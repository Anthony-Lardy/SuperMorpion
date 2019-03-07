package com.example.fisso.morpiontest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;


public class Credits  extends AppCompatActivity {



    ImageButton retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credits);

        retour = (ImageButton) findViewById(R.id.boutonAccueil);


        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //on fait appel à la méthode ouvrirMainActivity
                ouvrirAccueilActivity();
            }
        });
    }


    public void ouvrirAccueilActivity(){
        Intent intent = new Intent(this, Accueil.class);
        startActivity(intent);
    }
}
