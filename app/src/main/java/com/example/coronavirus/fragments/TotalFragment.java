package com.example.coronavirus.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coronavirus.R;
import com.example.coronavirus.managers.GlobalManager;
import com.example.coronavirus.models.TotalModel;
import com.example.coronavirus.network.COVID19DataService;
import com.example.coronavirus.network.RetrofitClientInstance;
import com.example.coronavirus.services.DaggerNetworkComponent;
import com.example.coronavirus.services.NetworkComponent;
import com.example.coronavirus.services.NetworkConnectivity;
import com.example.coronavirus.views.TotalView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TotalFragment extends Fragment {

    public TotalFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private NetworkConnectivity mNetworkConnectivity;
    private COVID19DataService mWebService;
    private Call<TotalModel> mWebServiceCall;
    private boolean mIsRefreshing = false;

    private ProgressBar mProgressBar;
    private LinearLayout mTotalViewContainer;
    private TotalView mTotalConfirmedView;
    private TotalView mTotalDeceasedView;
    private TotalView mTotalRecoveredView;
    private TotalView mStatisticTakenAtView;
    private TextView mErrorMessageText;

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
        mErrorMessageText = (TextView) RootView.findViewById(R.id.errorMessageText);

        mProgressBar.setVisibility(View.VISIBLE);
        mTotalViewContainer.setVisibility(View.GONE);

        /** check if user has access to the internet **/
        NetworkComponent networkComponent = DaggerNetworkComponent.create();
        mNetworkConnectivity = networkComponent.getNetworkConnectivity();
        if (!mNetworkConnectivity.hasAccess(getContext())) {
            mProgressBar.setVisibility(View.GONE);
            mErrorMessageText.setVisibility(View.VISIBLE);
        } else {
            mWebService = RetrofitClientInstance.getRetrofitInstance().create(COVID19DataService.class);
            mWebServiceCall = mWebService.getTotal();
            mWebServiceCall.enqueue(onTotalWebServiceCall);
        }

        return RootView;
    }

    public void refreshData() {
        if (mNetworkConnectivity != null) {
            if (!mNetworkConnectivity.hasAccess(getContext())) {
                mProgressBar.setVisibility(View.GONE);
                mErrorMessageText.setVisibility(View.VISIBLE);
            } else {
                mProgressBar.setVisibility(View.VISIBLE);
                mTotalViewContainer.setVisibility(View.GONE);
                mErrorMessageText.setVisibility(View.GONE);

                if (mWebService == null) {
                    mWebService = RetrofitClientInstance.getRetrofitInstance().create(COVID19DataService.class);
                }

                mWebServiceCall = mWebService.getTotal();
                mWebServiceCall.enqueue(onTotalWebServiceCall);
                mIsRefreshing = true;
            }
        }
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
