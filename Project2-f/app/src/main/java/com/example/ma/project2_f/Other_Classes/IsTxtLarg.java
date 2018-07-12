package com.example.ma.project2_f.Other_Classes;


public class IsTxtLarg {
    static boolean isLarg=false;
    static String Txt="تكبير الخط";
    public IsTxtLarg(boolean isLarg,String Txt) {
        this.isLarg=isLarg;
        this.Txt=Txt;
    }

    public static boolean isLarg() {
        return isLarg;
    }
    public static String Txt(){
        return Txt;
    }
}
