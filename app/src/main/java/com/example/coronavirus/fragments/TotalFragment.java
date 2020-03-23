package com.example.coronavirus.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.coronavirus.R;
import com.example.coronavirus.managers.GlobalManager;
import com.example.coronavirus.models.TotalModel;
import com.example.coronavirus.network.COVID19DataService;
import com.example.coronavirus.network.RetrofitClientInstance;
import com.example.coronavirus.views.TotalView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TotalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TotalFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TotalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Total.
     */
    // TODO: Rename and change types and number of parameters
    public static TotalFragment newInstance(String param1, String param2) {
        TotalFragment fragment = new TotalFragment();
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

    private COVID19DataService mWebService;
    private Call<TotalModel> mWebServiceCall;
    private boolean mIsRefreshing = false;

    private ProgressBar mProgressBar;
    private LinearLayout mTotalViewContainer;
    private TotalView mTotalConfirmedView;
    private TotalView mTotalDeceasedView;
    private TotalView mTotalRecoveredView;
    private TotalView mStatisticTakenAtView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View RootView = inflater.inflate(R.layout.fragment_total, container, false);

        mProgressBar = (ProgressBar) RootView.findViewById(R.id.progressBar);
        mTotalViewContainer = (LinearLayout) RootView.findViewById(R.id.totalViewContainer);
        mTotalConfirmedView = (TotalView) RootView.findViewById(R.id.totalConfirmedView);
        mTotalDeceasedView = (TotalView) RootView.findViewById(R.id.totalDeceasedView);
        mTotalRecoveredView = (TotalView) RootView.findViewById(R.id.totalRecoveredView);
        mStatisticTakenAtView = (TotalView) RootView.findViewById(R.id.statisticTakenAtView);

        mProgressBar.setVisibility(View.VISIBLE);
        mTotalViewContainer.setVisibility(View.GONE);

        mWebService = RetrofitClientInstance.getRetrofitInstance().create(COVID19DataService.class);
        mWebServiceCall = mWebService.getTotal();
        mWebServiceCall.enqueue(onTotalWebServiceCall);

        return RootView;
    }

    public void refreshData() {
        mProgressBar.setVisibility(View.VISIBLE);
        mTotalViewContainer.setVisibility(View.GONE);

        mWebServiceCall = mWebService.getTotal();
        mWebServiceCall.enqueue(onTotalWebServiceCall);
        mIsRefreshing = true;
    }

    private Callback<TotalModel> onTotalWebServiceCall = new Callback<TotalModel>() {
        @Override
        public void onResponse(Call<TotalModel> call, Response<TotalModel> response) {
            mTotalConfirmedView.setPrimaryText(response.body().getTotalCases());
            mTotalDeceasedView.setPrimaryText(response.body().getTotalDeaths());
            mTotalRecoveredView.setPrimaryText(response.body().getTotalRecovered());
            mStatisticTakenAtView.setPrimaryText(parseLastUpdated(response.body().getStatisticTakenAt()));

            mProgressBar.setVisibility(View.GONE);
            mTotalViewContainer.setVisibility(View.VISIBLE);

            GlobalManager instance = GlobalManager.GetInstance();
            instance.isTotalActive = true;

            if (mIsRefreshing) {
                Toast.makeText(getContext(), "World Statistic Updated", Toast.LENGTH_SHORT).show();
                mIsRefreshing = false;
            }
        }

        @Override
        public void onFailure(Call<TotalModel> call, Throwable t) {

        }
    };

    private String parseLastUpdated(String str) {
        try  {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = format.parse(str);

            DateFormat outputFormatter = new SimpleDateFormat("MM/dd/yyyy");
            String output = outputFormatter.format(date); // Output : 01/20/2012

            return output;

        } catch(ParseException ex) {

        }

        return str;
    }
}
