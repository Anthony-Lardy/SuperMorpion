package com.example.fisso.morpiontest;

import android.content.Context;
import android.media.MediaPlayer;


/**
 * Created by fisso on 02/03/2019.
 */

public class Musique{

    private MediaPlayer mediaPlayer;


    public Musique(Context context){
        mediaPlayer = MediaPlayer.create(context, R.raw.musique);

    }

    public void jouerMusique(){
        mediaPlayer.start();

    }

    public void arreterMusique(){
        mediaPlayer.pause();

    }

}