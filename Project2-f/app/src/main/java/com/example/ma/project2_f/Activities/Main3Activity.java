package com.example.ma.project2_f.Activities;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ma.project2_f.Databases.Local_DB_Handiler;
import com.example.ma.project2_f.Other_Classes.IsTxtLarg;
import com.example.ma.project2_f.R;

import java.util.List;

public class Main3Activity extends AppCompatActivity {
    Local_DB_Handiler DB;

    @Override
    public void onBackPressed() {

        finish();
    }
    String msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        LargeText();
        msg=(String)getIntent().getExtras().getString("msg");
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ListView listview=(ListView)findViewById(R.id.list_lvl3);

        DB=new Local_DB_Handiler(this);
        List<String> list=DB.BringLVL3(msg);
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name=String.valueOf(parent.getItemAtPosition(position)) ;
                Intent i=new Intent(Main3Activity.this,Details.class);
                i.putExtra("msg",name);
                startActivity(i);
            }
        });
    }
    private void LargeText() {

        if(IsTxtLarg.isLarg())
            setTheme(R.style.LargText);
        else  setTheme(R.style.NormalText);
    }

}
