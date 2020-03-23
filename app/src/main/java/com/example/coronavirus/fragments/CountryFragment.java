package com.example.coronavirus.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coronavirus.R;
import com.example.coronavirus.activites.CountryDetailActivity;
import com.example.coronavirus.adapters.CountryArrayAdapter;
import com.example.coronavirus.managers.GlobalManager;
import com.example.coronavirus.models.CountriesStat;
import com.example.coronavirus.models.CountryModel;
import com.example.coronavirus.network.COVID19DataService;
import com.example.coronavirus.network.RetrofitClientInstance;

import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.OnMenuItemClickListener;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryFragment extends Fragment {

    public CountryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private COVID19DataService mWebService;
    private Call<CountryModel> mWebServiceCall;
    private boolean mIsRefreshing = false;

    private ListView mListView;
    private CountryArrayAdapter adapter;
    private SearchView mSearchView;
    private ProgressBar mProgressBar;
    private View mHeaders;
    private TextView mEmptyTextView;
    private ImageButton mSortButton;
    private RelativeLayout mRelativeContainer;
    private PowerMenu mPowerMenu;
    private LinearLayout mRootContainer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View RootView = inflater.inflate(R.layout.fragment_country, container, false);

        mProgressBar = (ProgressBar) RootView.findViewById(R.id.progressBar);
        mHeaders = (View) RootView.findViewById(R.id.headers);
        mListView = (ListView) RootView.findViewById(R.id.list);
        mSearchView = (SearchView) RootView.findViewById(R.id.searchView);
        mEmptyTextView = (TextView) RootView.findViewById(R.id.emptyTextView);
        mSortButton = (ImageButton) RootView.findViewById(R.id.sortButton);
        mRelativeContainer = (RelativeLayout) RootView.findViewById(R.id.relativeContainer);
        mRootContainer = (LinearLayout) RootView.findViewById(R.id.rootContainer);

        mPowerMenu = new PowerMenu.Builder(getContext())
                .addItem(new PowerMenuItem("Sort by Cases", false)) // add an item.
                .addItem(new PowerMenuItem("Sort by Deaths", false)) // aad an item list.
                .setAnimation(MenuAnimation.SHOWUP_TOP_RIGHT) // Animation start point (TOP | LEFT).
                .setMenuRadius(10f) // sets the corner radius.
                .setMenuShadow(10f) // sets the shadow.
                .setTextColor(ContextCompat.getColor(getContext(), R.color.black))
                .setTextGravity(Gravity.CENTER)
                .setTextTypeface(Typeface.create("sans-serif-medium", Typeface.BOLD))
                .setSelectedTextColor(Color.WHITE)
                .setMenuColor(Color.WHITE)
                .setSelectedMenuColor(ContextCompat.getColor(getContext(), R.color.colorPrimary))
                .build();

        mPowerMenu.setOnMenuItemClickListener(new OnMenuItemClickListener<PowerMenuItem>() {
            @Override
            public void onItemClick(int position, PowerMenuItem item) {
                Toast.makeText(getContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
                mPowerMenu.setSelectedPosition(position); // change selected item
                mPowerMenu.dismiss();

                String x = item.getTitle();

                adapter.getFilter().filter(x);
            }
        });

        mListView.setEmptyView(mEmptyTextView);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                CountriesStat country = (CountriesStat) adapter.getItem(position);

                Intent intent = new Intent(getContext(), CountryDetailActivity.class);
                intent.putExtra("Country", country);

                startActivity(intent);
            }
        });

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        mSortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPowerMenu.showAsDropDown(v);
            }
        });

        mRelativeContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchView.onActionViewExpanded();
            }
        });

        mProgressBar.setVisibility(View.VISIBLE);
        mSearchView.setVisibility(View.GONE);
        mHeaders.setVisibility(View.GONE);
        mEmptyTextView.setVisibility(View.INVISIBLE);
        mRootContainer.setVisibility(View.GONE);

        mWebService = RetrofitClientInstance.getRetrofitInstance().create(COVID19DataService.class);
        mWebServiceCall = mWebService.getCountries();
        mWebServiceCall.enqueue(onWebServiceCallback);

        return RootView;
    }

    public void refreshData() {

        mIsRefreshing = true;

        mProgressBar.setVisibility(View.VISIBLE);
        mSearchView.setVisibility(View.GONE);
        mHeaders.setVisibility(View.GONE);
        mEmptyTextView.setVisibility(View.INVISIBLE);
        mRootContainer.setVisibility(View.GONE);

        mWebServiceCall = mWebService.getCountries();
        mWebServiceCall.enqueue(onWebServiceCallback);
    }

    private Callback<CountryModel> onWebServiceCallback = new Callback<CountryModel>() {
        @Override
        public void onResponse(Call<CountryModel> call, Response<CountryModel> response) {
            List<CountriesStat> list = response.body().getCountriesStat();

            adapter = new CountryArrayAdapter(getContext(), list);
            mListView.setAdapter(adapter);

            mProgressBar.setVisibility(View.GONE);
            mSearchView.setVisibility(View.VISIBLE);
            mHeaders.setVisibility(View.VISIBLE);
            mRootContainer.setVisibility(View.VISIBLE);

            GlobalManager instance = GlobalManager.GetInstance();

            if (mIsRefreshing && !instance.isTotalActive) {
                Toast.makeText(getContext(), "Countries Statistic Updated", Toast.LENGTH_SHORT).show();
                mIsRefreshing = false;
                mSearchView.setQuery("", false);
                mSearchView.clearFocus();
            } else if (instance.isTotalActive) {
                instance.isTotalActive = false;
            }
        }

        @Override
        public void onFailure(Call<CountryModel> call, Throwable t) {

        }
    };

    private OnMenuItemClickListener<PowerMenuItem> onMenuItemClickListener = new OnMenuItemClickListener<PowerMenuItem>() {
        @Override
        public void onItemClick(int position, PowerMenuItem item) {
            Toast.makeText(getContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
            mPowerMenu.setSelectedPosition(position); // change selected item
            mPowerMenu.dismiss();

            adapter.getFilter().filter(item.getTitle());
        }
    };
}
