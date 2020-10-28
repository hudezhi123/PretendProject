package com.hdz.pretendproject.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.hdz.pretendproject.R;
import com.hdz.pretendproject.adapter.TabPagerAdapter;
import com.hdz.pretendproject.fragment.IpGetFragment;
import com.hdz.pretendproject.fragment.IpMineFragment;
import com.hdz.pretendproject.fragment.IpProduceFragment;

import java.util.ArrayList;
import java.util.List;

public class IPFSActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private TabPagerAdapter mAdapter;

    List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_p_f_s);
        init();
    }

    private void init() {
        fragments = new ArrayList<>();
        List<String> tabList = new ArrayList<>();
        tabList.add("矿机产出");
        tabList.add("提取明细");
        tabList.add("我的矿机");
        fragments.add(new IpProduceFragment());
        fragments.add(new IpGetFragment());
        fragments.add(new IpMineFragment());
        mViewPager = findViewById(R.id.viewpager_file_coin);
        mTabLayout = findViewById(R.id.tab_file_coin);
        mAdapter = new TabPagerAdapter(getSupportFragmentManager(), tabList, fragments);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }
}
