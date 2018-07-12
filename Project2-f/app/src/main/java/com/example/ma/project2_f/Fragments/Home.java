package com.example.ma.project2_f.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ma.project2_f.Adapters.MyFragmentPagerAdapter;
import com.example.ma.project2_f.Other_Classes.Fragment_Adapter_items;
import com.example.ma.project2_f.Other_Classes.IsTxtLarg;
import com.example.ma.project2_f.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment_Adapter_items> Fragment_list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_home, container, false);
        LayoutInflater Localinflater;
        if(IsTxtLarg.isLarg()){
            Context context = new ContextThemeWrapper(getActivity(), R.style.LargText);
            Localinflater = inflater.cloneInContext(context);
            v = Localinflater.inflate(R.layout.fragment_home, container, false);
        }
        else {
            Context context = new ContextThemeWrapper(getActivity(), R.style.NormalText);
            Localinflater = inflater.cloneInContext(context);
            v = Localinflater.inflate(R.layout.fragment_home, container, false);
        }



        Fragment_list=new ArrayList<Fragment_Adapter_items>();
        Fragment_list.add(new Fragment_Adapter_items(new Fragment1(),"رئيسي"));
        Fragment_list.add(new Fragment_Adapter_items(new Fragment2(),"سياحي"));
        Fragment_list.add(new Fragment_Adapter_items(new Fragment3(),"تجاري"));
        Fragment_list.add(new Fragment_Adapter_items(new Fragment4(),"اعلانات"));
        viewPager= (ViewPager) v.findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyFragmentPagerAdapter(getActivity().getSupportFragmentManager(), Fragment_list));

        tabLayout= (TabLayout) v.findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
        });


        return v;
    }

}
