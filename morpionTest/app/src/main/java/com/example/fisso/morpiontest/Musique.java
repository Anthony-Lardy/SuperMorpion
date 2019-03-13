package com.example.fisso.morpiontest;

import android.content.Context;
import android.media.MediaPlayer;



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