package com.example.fisso.morpiontest;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;


public class Regles extends AppCompatActivity {
    ImageView pointGauche;
    ImageView pointMilieu;
    ImageView pointDroit;
    ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.regles);



        pointGauche = (ImageView) findViewById(R.id.pointGauche);
        pointMilieu = (ImageView) findViewById(R.id.pointMilieu);
        pointDroit = (ImageView) findViewById(R.id.pointDroit);
        mViewPager = (ViewPager) findViewById(R.id.pager);

        pointGauche.setBackgroundResource(R.drawable.cercle_bleu);
        pointMilieu.setBackgroundResource(R.drawable.cercle_gris);
        pointDroit.setBackgroundResource(R.drawable.cercle_gris);


        PageListener pageListener = new PageListener();
        mViewPager.setOnPageChangeListener(pageListener);



        mViewPager.setAdapter(new SamplePagerAdapter(
                getSupportFragmentManager()));
    }





    private class PageListener extends ViewPager.SimpleOnPageChangeListener {


        public void onPageSelected(int position) {
            if (position == 0) {
                pointGauche.setBackgroundResource(R.drawable.cercle_bleu);
                pointMilieu.setBackgroundResource(R.drawable.cercle_gris);
                pointDroit.setBackgroundResource(R.drawable.cercle_gris);
            }
            if (position == 1) {
                pointGauche.setBackgroundResource(R.drawable.cercle_gris);
                pointMilieu.setBackgroundResource(R.drawable.cercle_bleu);
                pointDroit.setBackgroundResource(R.drawable.cercle_gris);
            }
            if (position == 2) {
                pointGauche.setBackgroundResource(R.drawable.cercle_gris);
                pointMilieu.setBackgroundResource(R.drawable.cercle_gris);
                pointDroit.setBackgroundResource(R.drawable.cercle_bleu);
            }
        }
    }
}




