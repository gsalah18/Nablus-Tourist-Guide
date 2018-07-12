package com.example.ma.project2_f.Adapters;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.ma.project2_f.Other_Classes.Fragment_Adapter_items;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

	List<Fragment_Adapter_items> fragments;

	public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment_Adapter_items> fragments) {
		super(fm);
		this.fragments = fragments;
	}

	@Override
	public Fragment getItem(int position) {
		return this.fragments.get(position).getFrag();
	}

	@Override
	public int getCount() {
		
		return fragments.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return fragments.get(position).getTitle();
	}
}
