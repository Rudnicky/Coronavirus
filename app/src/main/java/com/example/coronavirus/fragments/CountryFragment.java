package com.example.coronavirus.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;

import com.example.coronavirus.R;
import com.example.coronavirus.adapters.CountryArrayAdapter;
import com.example.coronavirus.models.CountriesStat;
import com.example.coronavirus.models.CountryModel;
import com.example.coronavirus.network.COVID19DataService;
import com.example.coronavirus.network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CountryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CountryFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CountryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Country.
     */
    // TODO: Rename and change types and number of parameters
    public static CountryFragment newInstance(String param1, String param2) {
        CountryFragment fragment = new CountryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private ListView mListView;
    private CountryArrayAdapter adapter;
    private SearchView mSearchView;
    private ProgressBar mProgressBar;
    private View mHeaders;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View RootView = inflater.inflate(R.layout.fragment_country, container, false);

        mProgressBar = (ProgressBar) RootView.findViewById(R.id.progressBar);
        mHeaders = (View) RootView.findViewById(R.id.headers);
        mListView = (ListView) RootView.findViewById(R.id.list);
        mSearchView = (SearchView) RootView.findViewById(R.id.searchView);

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

        mProgressBar.setVisibility(View.VISIBLE);
        mSearchView.setVisibility(View.GONE);
        mHeaders.setVisibility(View.GONE);

        COVID19DataService service = RetrofitClientInstance.getRetrofitInstance().create(COVID19DataService.class);
        Call<CountryModel> call = service.getCountries();

        call.enqueue(new Callback<CountryModel>() {
            @Override
            public void onResponse(Call<CountryModel> call, Response<CountryModel> response) {
                List<CountriesStat> list = response.body().getCountriesStat();

                adapter = new CountryArrayAdapter(getContext(), list);
                mListView.setAdapter(adapter);

                mProgressBar.setVisibility(View.GONE);
                mSearchView.setVisibility(View.VISIBLE);
                mHeaders.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<CountryModel> call, Throwable t) {

            }
        });

        return RootView;
    }
}
