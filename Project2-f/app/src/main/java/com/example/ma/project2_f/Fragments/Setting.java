package com.example.ma.project2_f.Fragments;


import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.ma.project2_f.Other_Classes.IsTxtLarg;
import com.example.ma.project2_f.R;

public class Setting extends Fragment {


    Button button;
    LayoutInflater Localinflater;
    View view;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.setting, container, false);

        if(IsTxtLarg.isLarg()){
            Context context = new ContextThemeWrapper(getActivity(), R.style.LargText);
            Localinflater = inflater.cloneInContext(context);
            view = Localinflater.inflate(R.layout.setting, container, false);

        }
        else {
            Context context = new ContextThemeWrapper(getActivity(), R.style.NormalText);
            Localinflater = inflater.cloneInContext(context);
            view = Localinflater.inflate(R.layout.setting, container, false);

        }

        button=(Button) view.findViewById(R.id.Larg_btn);
        button.setText(IsTxtLarg.Txt());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!IsTxtLarg.isLarg()){
                    new IsTxtLarg(true,"الخط العادي");
                }else{
                    new IsTxtLarg(false,"تكبير الخط");
                }
                getActivity().finish();
                startActivity(getActivity().getIntent());
            }
        });


        return view;
    }

}
