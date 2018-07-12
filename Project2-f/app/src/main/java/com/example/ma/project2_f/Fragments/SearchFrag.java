package com.example.ma.project2_f.Fragments;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ma.project2_f.Activities.Main2Activity;
import com.example.ma.project2_f.Activities.Main3Activity;
import com.example.ma.project2_f.Databases.Local_DB_Handiler;
import com.example.ma.project2_f.Other_Classes.IsTxtLarg;
import com.example.ma.project2_f.R;

import java.util.Arrays;

/**
 * Created by GS on 12/12/2016.
 */

public class SearchFrag extends Fragment {
    Local_DB_Handiler DB;
    ListView list;
    EditText txt;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.search_frag,container,false);

        LayoutInflater Localinflater;
        if(IsTxtLarg.isLarg()){
            Context context = new ContextThemeWrapper(getActivity(), R.style.LargText);
            Localinflater = inflater.cloneInContext(context);
            v = Localinflater.inflate(R.layout.search_frag, container, false);
        }
        else {
            Context context = new ContextThemeWrapper(getActivity(), R.style.NormalText);
            Localinflater = inflater.cloneInContext(context);
            v = Localinflater.inflate(R.layout.search_frag, container, false);
        }



        DB=new Local_DB_Handiler(getActivity());
        list=(ListView)v.findViewById(R.id.search_list);
        txt=(EditText)v.findViewById(R.id.search_txt);

        final String []Data=DB.BringItAll();

        final ArrayAdapter<String>adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,Data);
        list.setAdapter(adapter);
        list.setVisibility(View.INVISIBLE);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(getActivity(), Main3Activity.class);
                i.putExtra("msg",String.valueOf(parent.getItemAtPosition(position)));
                startActivity(i);
            }
        });
        txt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                list.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
                list.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()==0)
                    list.setVisibility(View.INVISIBLE);
                else
                    list.setVisibility(View.VISIBLE);


            }
        });

        return v;
    }
}
