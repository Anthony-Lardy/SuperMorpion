package com.example.fisso.morpiontest;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by fisso on 28/01/2019.
 */

public class Joueur {

    private String pseudo;
    private int forme;

    public Joueur(String pseudo, int forme){
        this.pseudo = pseudo;
        this.forme = forme;
    }

    public String getPseudo(){
        return this.pseudo;
    }

    public int getForme(){
        return this.forme;
    }


}

