package com.example.ma.project2_f.Other_Classes;

import android.support.v4.app.Fragment;

/**
 * Created by GSCode on 9/30/2016.
 */

public class Fragment_Adapter_items {
    Fragment frag;
    String title;

    public Fragment_Adapter_items(Fragment frag, String title) {
        this.frag = frag;
        this.title = title;
    }

    public Fragment getFrag() {
        return frag;
    }

    public String getTitle() {
        return title;
    }
}
