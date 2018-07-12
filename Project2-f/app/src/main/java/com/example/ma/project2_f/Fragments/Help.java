package com.example.ma.project2_f.Fragments;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ma.project2_f.Other_Classes.IsTxtLarg;
import com.example.ma.project2_f.R;

public class Help extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.help,container,false);

        LayoutInflater Localinflater;
        if(IsTxtLarg.isLarg()){
            Context context = new ContextThemeWrapper(getActivity(), R.style.LargText);
            Localinflater = inflater.cloneInContext(context);
            v = Localinflater.inflate(R.layout.help, container, false);
        }
        else {
            Context context = new ContextThemeWrapper(getActivity(), R.style.NormalText);
            Localinflater = inflater.cloneInContext(context);
            v = Localinflater.inflate(R.layout.help, container, false);
        }

        final Button btn=(Button)v.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_DIAL);
                i.setType("*/*");
                i.putExtra(Intent.ACTION_CALL, "");
                i.setData(Uri.parse("tel:"+btn.getText().toString()));
                startActivity(i);
            }
        });

        return v;
    }

}
