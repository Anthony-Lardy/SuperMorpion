package com.example.fisso.morpiontest.model;

import android.content.Context;
import android.media.MediaPlayer;

import com.example.fisso.morpiontest.R;


public class Musique{

    private MediaPlayer mediaPlayer;


    public Musique(Context context){
        mediaPlayer = MediaPlayer.create(context, R.raw.musique);
        mediaPlayer.setLooping(true);
    }

    public void jouerMusique(){
        mediaPlayer.start();

    }

    public void arreterMusique(){
        mediaPlayer.pause();

    }

}