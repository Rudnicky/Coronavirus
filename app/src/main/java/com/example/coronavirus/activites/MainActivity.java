package com.example.coronavirus.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.coronavirus.R;
import com.example.coronavirus.adapters.PageAdapter;
import com.example.coronavirus.network.COVID19DataService;
import com.example.coronavirus.network.RetrofitClientInstance;
import com.example.coronavirus.receivers.NetworkStateReceiver;
import com.example.coronavirus.services.DaggerNetworkComponent;
import com.example.coronavirus.services.NetworkComponent;
import com.example.coronavirus.services.NetworkConnectivity;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity implements NetworkStateReceiver.NetworkStateReceiverListener {

    private TabLayout mTabLayout;
    private TabItem mTotalTab;
    private TabItem mCountryTab;
    private TabItem mInfoTab;
    private ViewPager mViewPager;
    private NetworkStateReceiver networkStateReceiver;
    private boolean mIsNetworkAvailable;
    public PageAdapter mPageAdapter;
    private NetworkConnectivity mNetworkConnectivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** start network broadcast **/
        startNetworkBroadcastReceiver(this);

        /** initialize custom toolbar **/
        Toolbar mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Corona VIRUS");
        mToolbar.setSubtitle("COVID19");

        /** initialize controls **/
        mTabLayout = findViewById(R.id.TabLayout);
        mTotalTab = findViewById(R.id.TotalTab);
        mCountryTab = findViewById(R.id.CountryTab);
        mInfoTab = findViewById(R.id.InfoTab);
        mViewPager = findViewById(R.id.ViewPager);

        mPageAdapter = new PageAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());
        mViewPager.setAdapter(mPageAdapter);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2) {
                    mPageAdapter.notifyDataSetChanged();
                    mPageAdapter.setCurrentPosition(tab.getPosition());
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        /** check if user has access to the internet **/
        NetworkComponent networkComponent = DaggerNetworkComponent.create();
        mNetworkConnectivity = networkComponent.getNetworkConnectivity();
        if (!mNetworkConnectivity.hasAccess(this)) {
            mIsNetworkAvailable = false;
        } else {
            mIsNetworkAvailable = true;
        }
    }

    @Override
    protected void onPause() {
        unregisterNetworkBroadcastReceiver(this);
        super.onPause();
    }

    @Override
    protected void onResume() {
        registerNetworkBroadcastReceiver(this);
        super.onResume();
    }

    @Override
    public void networkAvailable() {
        if (!mIsNetworkAvailable) {
            mPageAdapter.refreshData();
            mIsNetworkAvailable = true;
        }
    }

    @Override
    public void networkUnavailable() {
        mIsNetworkAvailable = false;
    }

    public void startNetworkBroadcastReceiver(Context currentContext) {
        networkStateReceiver = new NetworkStateReceiver();
        networkStateReceiver.addListener((NetworkStateReceiver.NetworkStateReceiverListener) currentContext);
        registerNetworkBroadcastReceiver(currentContext);
    }

    public void registerNetworkBroadcastReceiver(Context currentContext) {
        currentContext.registerReceiver(networkStateReceiver, new IntentFilter(android.net.ConnectivityManager.CONNECTIVITY_ACTION));
    }

    public void unregisterNetworkBroadcastReceiver(Context currentContext) {
        currentContext.unregisterReceiver(networkStateReceiver);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refresh:
                mPageAdapter.refreshData();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
