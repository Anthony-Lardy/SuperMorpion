package com.example.fisso.morpiontest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;


public class Credits  extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credits);

    }


    public void ouvrirAccueilActivity(){
        Intent intent = new Intent(this, Accueil.class);
        startActivity(intent);
    }
}
