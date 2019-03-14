package com.example.fisso.morpiontest.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.ImageView;



public class SamplePagerAdapter extends FragmentPagerAdapter {

    ImageView p;


    public SamplePagerAdapter(FragmentManager fm) {
        super(fm);


    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new Regles_page_un();
        } if (position == 1) {
            return new Regles_page_deux();
        }else if(position == 2) {
            return new Regles_page_trois();
        }
return null;
    }

    @Override
    public int getCount() {

        return 3;
    }
}

