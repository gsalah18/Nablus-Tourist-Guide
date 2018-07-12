package com.example.ma.project2_f.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ma.project2_f.Activities.Main2Activity;
import com.example.ma.project2_f.Databases.Local_DB_Handiler;
import com.example.ma.project2_f.Other_Classes.IsTxtLarg;
import com.example.ma.project2_f.R;

import java.util.List;


public class Fragment2 extends Fragment {
    View v2;
    ListView lv2;
    Local_DB_Handiler DB;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v2=inflater.inflate(R.layout.frag, container, false);
        LayoutInflater Localinflater;
        if(IsTxtLarg.isLarg()){
            Context context = new ContextThemeWrapper(getActivity(), R.style.LargText);
            Localinflater = inflater.cloneInContext(context);
            v2 = Localinflater.inflate(R.layout.frag, container, false);
        }
        else {
            Context context = new ContextThemeWrapper(getActivity(), R.style.NormalText);
            Localinflater = inflater.cloneInContext(context);
            v2 = Localinflater.inflate(R.layout.frag, container, false);
        }


        lv2=(ListView)v2.findViewById(R.id.list);
        DB=new Local_DB_Handiler(getActivity());
        List<String> list=DB.tour();
        final ArrayAdapter<String>adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,list);
        lv2.setAdapter(adapter);

        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(getActivity(), Main2Activity.class);
                i.putExtra("msg",String.valueOf(parent.getItemAtPosition(position)));
                startActivity(i);
            }
        });

        return v2;
    }


}
