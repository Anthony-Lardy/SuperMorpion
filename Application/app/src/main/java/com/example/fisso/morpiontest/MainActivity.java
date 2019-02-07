package com.example.fisso.morpiontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout fenetre;
    private int width;
    private int height;
    private Matrice m1 = new Matrice();
    private Matrice m2 = new Matrice();
    private Matrice m3 = new Matrice();
    private Matrice m4 = new Matrice();
    private Matrice m5 = new Matrice();
    private Matrice m6 = new Matrice();
    private Matrice m7 = new Matrice();
    private Matrice m8 = new Matrice();
    private Matrice m9 = new Matrice();
    private Joueur j1, j2, joueurActuel;
    private Matrice [][] tableauMatrice = { {m1, m2, m3}, {m4, m5, m6},{ m7, m8, m9} };
    private List<Matrice> listeToutesMatrices = new ArrayList<Matrice>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fenetre = (RelativeLayout) findViewById(R.id.fenetre);





    }

    private void afficherGrille(Matrice[][] listeMatrice){
        int x = (width/22);
        int y = (width/22)+height/5;

        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                afficherMatrice(listeMatrice[i][j], x, y);
                x+= 7*(width/22);
            }
            x = (width/22);
            y+= 7*(width/22);
        }








    }

    private void afficherMatrice(Matrice m1, float x, float yDepart){


        ImageButton [][] tableau = m1.getMatrice();







        for (int i=0;i<3;i++) {

                //ecart vertical entre les imagesButton

            float xDepart = x;

                for (int j = 0; j < 3; j++) {
                    //taille des imageButtons
                    ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(width / 11, width / 11);
                    tableau[i][j] = new ImageButton(this);
                    tableau[i][j].setLayoutParams(params);
                    tableau[i][j].setBackgroundResource(R.drawable.carreau);


                    tableau[i][j].setX(xDepart);
                    tableau[i][j].setY(yDepart);
                    fenetre.addView(tableau[i][j]);
                    //ecart horizontal entre les imagesButton
                    xDepart = xDepart + (float) (width / 11);
                }
            yDepart = yDepart + (float) (width / 11);
            }
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus){
        super.onWindowFocusChanged(hasFocus);
        listeToutesMatrices.add(m1);
        listeToutesMatrices.add(m2);
        listeToutesMatrices.add(m3);
        listeToutesMatrices.add(m4);
        listeToutesMatrices.add(m5);
        listeToutesMatrices.add(m6);
        listeToutesMatrices.add(m7);
        listeToutesMatrices.add(m8);
        listeToutesMatrices.add(m9);
        width = fenetre.getWidth();
        height = fenetre.getHeight();
        afficherGrille(tableauMatrice);
        j1  = new Joueur("jrzqtes1", R.drawable.croix);
        j2 = new Joueur("jrdyhg2", R.drawable.cercle);
        jouerUnePartie();

    }

    private void changerJoueur(){
        if(joueurActuel == j1){
            joueurActuel = j2;
        }else{
            joueurActuel = j1;
        }
    }

    public void jouerUnePartie(){
        joueurActuel = j1;
        jouerUnCoupLibre(listeToutesMatrices);


    }


    public void jouerUnCoupLibre(List<Matrice> listeMatrice) {
        final List<Matrice> liste = listeMatrice;

        for (Matrice m : liste) {
            if(!m.getEstFinie()) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        m.getMatrice()[k][l].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ImageButton b = (ImageButton) v;
                                b.setBackgroundResource(joueurActuel.getForme());
                                b.setTag(joueurActuel.getPseudo());
                                for (Matrice m : listeToutesMatrices) {
                                        m.desactiverMatrice();
                                        if (m.verificationVictoire(joueurActuel) == 1) {
                                            m.getMatrice()[1][1].setBackgroundColor(joueurActuel.getForme());
                                        }
                                }
                                changerJoueur();
                                if (matriceSuivante(m1.coupSuivant(b)).getEstFinie()) {
                                    List<Matrice> l = new ArrayList<Matrice>();
                                    l.add(matriceSuivante(m1.coupSuivant(b)));
                                    jouerUnCoupLibre(l);
                                } else {
                                    jouerUnCoupLibre(listeToutesMatrices);
                                }

                            }

                        });
                    }
                }
            }

            }
    }





    private Matrice matriceSuivante(int i){

        switch (i) {
            case 0:
                return m1;
            case 1:
                return m2;
            case 2:
                return m3;
            case 3:
                return m4;
            case 4:
                return m5;
            case 5:
                return m6;
            case 6:
                return m7;
            case 7:
                return m8;
            case 8:
                return m9;

        }
        return null;
    }


}