package com.example.coronavirus.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.coronavirus.fragments.CountryFragment;
import com.example.coronavirus.fragments.InfoFragment;
import com.example.coronavirus.fragments.TotalFragment;

public class PageAdapter extends FragmentPagerAdapter {

    private int mNumberOfTabs;
    private int mCurrentPosition;
    private TotalFragment mTotalFragment;
    private CountryFragment mCountryFragment;
    private InfoFragment mInfoFragment;

    public PageAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.mNumberOfTabs = numberOfTabs;

        mTotalFragment = new TotalFragment();
        mCountryFragment = new CountryFragment();
        mInfoFragment = new InfoFragment();
    }


    public void refreshData() {
        switch (mCurrentPosition) {
            case 0:
                mTotalFragment.refreshData();
            case 1:
                mCountryFragment.refreshData();
        }
    }

    public void setCurrentPosition(int position) {
        mCurrentPosition = position;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return mTotalFragment;
            case 1:
                return mCountryFragment;
            case 2:
                return mInfoFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumberOfTabs;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
