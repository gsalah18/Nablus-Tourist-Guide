package com.example.ma.project2_f.Activities;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ma.project2_f.Databases.Local_DB_Handiler;
import com.example.ma.project2_f.Other_Classes.IsTxtLarg;
import com.example.ma.project2_f.Other_Classes.Person;
import com.example.ma.project2_f.R;

public class Details extends AppCompatActivity {
    Local_DB_Handiler DB;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        LargeText();
        name=(String)getIntent().getExtras().getString("msg");
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        DB=new Local_DB_Handiler(this);

        Person INFO=DB.BringINFO(name);

        ImageView image=(ImageView)findViewById(R.id.image);
        TextView Name=(TextView)findViewById(R.id.fullname);
        TextView Address=(TextView)findViewById(R.id.address);
        final Button Phone1=(Button)findViewById(R.id.phone1);
        final Button Phone2=(Button)findViewById(R.id.phone2);
        final Button Phone3=(Button)findViewById(R.id.phone3);

        image.setImageBitmap(INFO.getPicture());
        Name.setText(INFO.getName());
        Address.setText(INFO.getAddress());
        Phone1.setText(INFO.getPhone1());
        Phone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_DIAL);
                i.setType("*/*");
                i.putExtra(Intent.ACTION_CALL, "");
                i.setData(Uri.parse("tel:"+Phone1.getText()));
                startActivity(i);
                //Toast.makeText(getApplicationContext(),name,Toast.LENGTH_LONG).show();
            }
        });

        Phone2.setText(INFO.getPhone2());
        Phone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_DIAL);
                i.setType("*/*");
                i.putExtra(Intent.ACTION_CALL, "");
                i.setData(Uri.parse("tel:"+Phone2.getText()));
                startActivity(i);
            }
        });

        Phone3.setText(INFO.getPhone3());
        Phone3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_DIAL);
                i.setType("*/*");
                i.putExtra(Intent.ACTION_CALL, "");
                i.setData(Uri.parse("tel:"+Phone3.getText()));
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
