package com.example.fisso.morpiontest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.plattysoft.leonids.ParticleSystem;

public class Accueil extends AppCompatActivity {

    //creation du logo
   ImageView morpion;
    //creation des boutons
    Button jouer;
    Button regles;
    Button credits;
    Activity a = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil);

        //on affecte les caractéristiques écrite dans le XML aux boutons
        morpion = (ImageView) findViewById(R.id.morpion);
        jouer = (Button) findViewById(R.id.jouer);
        regles = (Button) findViewById(R.id.regles);
        credits = (Button) findViewById(R.id.credits);


        //on affecte les images
        morpion.setBackgroundResource(R.drawable.supermorpion);


        //on affecte une action au clic sur le bouton jouer
        jouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //on fait appel à la méthode ouvrirMainActivity
                new ParticleSystem(a, 1000, getDrawable(R.drawable.confetti), 1000)
                        .setSpeedRange(0.2f, 0.5f)
                        .oneShot(view, 100);
                ouvrirParametresActivity();
            }
        });
        //on affecte une action au clic sur le bouton regles
        regles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //on fait appel à la méthode ouvrirReglesActivity
                ouvrirReglesActivity();
            }
        });;


        //on affecte une action au clic sur le bouton credits
        credits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //on fait appel à la méthode ouvrirCreditsActivity
                ouvrirCreditsActivity();
            }
        });;



    }

    /*
    * Cette méthode permet d'ouvrir la page d'accueil
    */

    public void ouvrirParametresActivity(){
        Intent intent = new Intent(this, ParametrePartie.class);
        startActivity(intent);
    }

    /*
    * Cette méthode permet d'ouvrir la page règle
    */
    public void ouvrirReglesActivity(){
       Intent intent = new Intent(this, Regles.class);
        startActivity(intent);
    }

    /*
    * Cette méthode permet d'ouvrir la page crédits
    */
    public void ouvrirCreditsActivity(){
        Intent intent = new Intent(this, Credits.class);
        startActivity(intent);
    }









}