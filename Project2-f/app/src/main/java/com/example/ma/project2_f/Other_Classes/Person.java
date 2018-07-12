package com.example.ma.project2_f.Other_Classes;

import android.graphics.Bitmap;

/**
 * Created by GS on 12/pic3/2016.
 */

public class Person {
    String Name,Address,Phone1,Phone2,Phone3;
    Bitmap Picture;

    public Person(String name, String address, String phone1, String phone2, String phone3,Bitmap picture) {
        Name = name;
        Address = address;
        Phone1 = phone1;
        Phone2 = phone2;
        Phone3 = phone3;
        Picture=picture;
    }
    public Person(){}
    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }

    public String getPhone1() {
        return Phone1;
    }

    public String getPhone2() {
        return Phone2;
    }

    public String getPhone3() {
        return Phone3;
    }

    public Bitmap getPicture() {
        return Picture;
    }

    @Override
    public String toString() {
        return Name;
    }
}
