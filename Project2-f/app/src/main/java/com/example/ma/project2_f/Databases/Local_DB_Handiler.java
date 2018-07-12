package com.example.ma.project2_f.Databases;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.ma.project2_f.Other_Classes.Person;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Local_DB_Handiler extends SQLiteAssetHelper {
    public SQLiteDatabase DB;
    private static String DB_NAME="tourist.db";
    private static int DB_VERSION=1;
    Context context;
    public Local_DB_Handiler(Context context){
        super(context, DB_NAME, null,DB_VERSION);
        this.context=context;
    }

    public void open(){
        DB=this.getWritableDatabase();
    }

    public void close(){
        if(DB!=null)
        DB.close();
    }

    public List<String>tour(){
        List<String>list=new ArrayList<String>();
        open();
        Cursor cursor=DB.rawQuery("select * from tour_table",null);

        while(cursor.moveToNext())
            list.add(cursor.getString(0));

        close();
        return list;
    }

    public List<String>commercial(){
        List<String>list=new ArrayList<String>();
        open();
        Cursor cursor=DB.rawQuery("select * from commercial_table",null);

        while(cursor.moveToNext())
            list.add(cursor.getString(0));

        close();
        return list;
    }

    public List<String>stuff(String str){
        List<String>list=new ArrayList<String>();
        open();
        Cursor cursor=DB.rawQuery("select * from stuff_tabel where tour_or_comm='"+str+"'",null);

        while(cursor.moveToNext())
            list.add(cursor.getString(0));

        close();
        return list;
    }

    public String []BringItAll(){
        open();
        Cursor cursor= DB.rawQuery("select * from stuff_tabel",null);
        String [] list=new String[cursor.getCount()];
        int i=0;
        while(cursor.moveToNext()) {
            list[i]=cursor.getString(0);
            i++;
        }
        close();
        return list;
    }

    public List<String>BringLVL3(String type){
        List<String>list=new LinkedList<String>();
        open();
        Cursor cursor= DB.rawQuery("select * from allofit where type='"+type+"';",null);
        while(cursor.moveToNext())
            list.add(cursor.getString(0));
        close();
        return list;
    }

    public Person BringINFO(String name){
        Person Info=new Person();
        open();
        Cursor cursor= DB.rawQuery("select * from allofit where name='"+name+"';",null);
        while(cursor.moveToNext()) {
            Bitmap pic = BitmapFactory.decodeByteArray(cursor.getBlob(5), 0, cursor.getBlob(5).length);
            Info = new Person(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),pic);
        }
        close();
        return Info;
    }

    public List<Bitmap>Ads_Pics(){
        List<Bitmap>list=new LinkedList<Bitmap>();
        open();
        Cursor cursor=DB.rawQuery("select * from ads",null);

        while(cursor.moveToNext()) {
            Bitmap pic = BitmapFactory.decodeByteArray(cursor.getBlob(0), 0, cursor.getBlob(0).length);
            list.add(pic);
        }
        close();
        return list;
    }

}
