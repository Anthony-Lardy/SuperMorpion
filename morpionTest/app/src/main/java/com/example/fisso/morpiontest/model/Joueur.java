package com.example.fisso.morpiontest.model;


/**
 * Created by fisso on 28/01/2019.
 */

public class Joueur {

    private String pseudo;
    private int forme;
    private int formeTrans;

    public Joueur(String pseudo, int forme, int formeTrans){
        this.pseudo = pseudo;
        this.forme = forme;
        this.formeTrans = formeTrans;
    }

    public String getPseudo(){
        return this.pseudo;
    }

    public int getForme(){
        return this.forme;
    }

    public int getFormeTrans(){
        return this.formeTrans;
    }

}

