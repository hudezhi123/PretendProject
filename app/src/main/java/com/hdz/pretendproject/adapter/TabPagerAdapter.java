package com.hdz.pretendproject.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class TabPagerAdapter extends FragmentPagerAdapter {

    private List<String> tabTitles;
    private List<Fragment> fragments;

    public TabPagerAdapter(FragmentManager fm, List<String> tabTitles, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
        this.tabTitles = tabTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles.get(position);
    }
}
