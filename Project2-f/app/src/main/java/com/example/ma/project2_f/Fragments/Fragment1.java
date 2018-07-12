package com.example.ma.project2_f.Fragments;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.ma.project2_f.Adapters.Photo_Adapter;
import com.example.ma.project2_f.Databases.Local_DB_Handiler;
import com.example.ma.project2_f.Other_Classes.IsTxtLarg;
import com.example.ma.project2_f.R;

import java.util.LinkedList;
import java.util.List;



public class Fragment1 extends Fragment {
    Button b1, b2, b3, b4;
    View v;
    ViewPager ads_img;
    Local_DB_Handiler DB;
    List<Bitmap> Photos;
    int Index=0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        v = inflater.inflate(R.layout.frag1, container, false);
        DB=new Local_DB_Handiler(getActivity());
        //Font Code
        LayoutInflater Localinflater;
        if(IsTxtLarg.isLarg()){
            Context context = new ContextThemeWrapper(getActivity(), R.style.LargText);
            Localinflater = inflater.cloneInContext(context);
            v = Localinflater.inflate(R.layout.frag1, container, false);
        }
        else {
            Context context = new ContextThemeWrapper(getActivity(), R.style.NormalText);
            Localinflater = inflater.cloneInContext(context);
            v = Localinflater.inflate(R.layout.frag1, container, false);
        }
        //End of Font Code


        btnlis();
        Photos=DB.Ads_Pics();
        ads_img=(ViewPager)v.findViewById(R.id.ads_img);
        Photo_Adapter adapter=new Photo_Adapter(getActivity(),Photos);
        ads_img.setAdapter(adapter);
        SlideShow();
        ads_img.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Index--;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return v;
    }

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            setImg();
            Index++;
            if(Index>=Photos.size())
                Index=0;
        }
    };

    void SlideShow(){
        Runnable r=new Runnable() {
            @Override
            public void run() {

                while(true) {
                    long future=System.currentTimeMillis()+5000;
                    if (System.currentTimeMillis()<future) {
                        synchronized (this) {
                            try {
                                wait(future-System.currentTimeMillis());
                            } catch (InterruptedException e) {}
                        }
                    }
                    handler.sendEmptyMessage(0);
                }

            }
        };
        Thread thread=new Thread(r);
        thread.start();

    }
    void setImg(){
        ads_img.setCurrentItem(Index);
    }

    public void btnlis(){
        b1 = (Button) v.findViewById(R.id.btn1);
        b2 = (Button) v.findViewById(R.id.btn2);
        b3 = (Button) v.findViewById(R.id.btn3);
        b4 = (Button) v.findViewById(R.id.btn4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_DIAL);
                i.setType("*/*");
                i.putExtra(Intent.ACTION_DIAL, "");
                i.setData(Uri.parse("tel:100"));
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_DIAL);
                i.setType("*/*");
                i.putExtra(Intent.ACTION_DIAL, "");
                i.setData(Uri.parse("tel:101"));
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_DIAL);
                i.setType("*/*");
                i.putExtra(Intent.ACTION_CALL, "");
                i.setData(Uri.parse("tel:102"));
                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_DIAL);
                i.setType("*/*");
                i.putExtra(Intent.ACTION_CALL, "");
                i.setData(Uri.parse("tel:115"));
                startActivity(i);
            }
        });
    }


}