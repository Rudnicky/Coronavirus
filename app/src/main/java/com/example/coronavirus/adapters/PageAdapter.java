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

    public PageAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.mNumberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new TotalFragment();
            case 1:
                return new CountryFragment();
            case 2:
                return new InfoFragment();
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
