package com.example.ma.project2_f.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.ma.project2_f.R;

import java.util.List;


public class Photo_Adapter extends PagerAdapter {
    private Context context;
    private List<Bitmap> images;
    private ImageView image;

    public Photo_Adapter(Context context, List<Bitmap>images) {
        super();
        this.context=context;
        this.images=images;

    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.img_swipe,container,false);
        image=(ImageView)view.findViewById(R.id.img_swipe);
        image.setImageBitmap(images.get(position));
        container.addView(view);


        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
