package com.aftabmaner.newsapp.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.aftabmaner.newsapp.Fragments.HealthFragment;
import com.aftabmaner.newsapp.Fragments.HomeFragment;
import com.aftabmaner.newsapp.Fragments.SportsFragment;

public class PagerAdapter extends FragmentPagerAdapter {

    int tabcount;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount = behavior;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new SportsFragment();
            case 2:
                return new HealthFragment();

            default:
                return null;


        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
