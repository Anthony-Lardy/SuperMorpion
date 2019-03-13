package com.example.fisso.morpiontest;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class ParametrePartie  extends AppCompatActivity {


    private EditText pseudo1;
    private EditText pseudo2;
    private Button valider;
    public SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parametres);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);



        pseudo1 = (EditText) findViewById(R.id.joueur1Pseudo);
        pseudo2 = (EditText) findViewById(R.id.joueur2Pseudo);
        valider = (Button) findViewById(R.id.Valider);

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ouvrirMainActivity();
            }
        });

    }



    public void ouvrirMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("pseudo1", pseudo1.getText().toString());
        intent.putExtra("pseudo2", pseudo2.getText().toString());
        startActivity(intent);
    }


}
