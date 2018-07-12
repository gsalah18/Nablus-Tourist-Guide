package com.example.ma.project2_f.Fragments;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ma.project2_f.Other_Classes.IsTxtLarg;
import com.example.ma.project2_f.R;

/**
 * Created by MA3 on 5/10/2016.
 */
public class Fragment4 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.frag4,container,false);


        LayoutInflater Localinflater;
        if(IsTxtLarg.isLarg()){
            Context context = new ContextThemeWrapper(getActivity(), R.style.LargText);
            Localinflater = inflater.cloneInContext(context);
            v = Localinflater.inflate(R.layout.frag4, container, false);
        }
        else {
            Context context = new ContextThemeWrapper(getActivity(), R.style.NormalText);
            Localinflater = inflater.cloneInContext(context);
            v = Localinflater.inflate(R.layout.frag4, container, false);
        }
        return v;
    }
}
