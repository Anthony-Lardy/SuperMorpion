package com.example.fisso.morpiontest;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout fenetre;
    private TextView jouerTourTexte, pseudo1, pseudo2;
    private ImageView jouerTourImage, i1, i2, i3, i4, i5, i6 ,i7 ,i8, i9;
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
    private Musique musique;
    ImageView [][] tableauImage = { {i1, i2, i3}, {i4, i5, i6},{ i7, i8, i9} };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fenetre = (RelativeLayout) findViewById(R.id.fenetre);

    }

    private void afficherGrille(Matrice[][] listeMatrice){
        int x = (width/22);
        int y = (width/22)+height/3;

        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                afficherMatrice(listeMatrice[i][j], x, y);
                x+= 7*(width/22);
            }
            x = (width/22);
            y+= 7*(width/22);
        }








    }

    private void afficherGrandeGrille(){
        float xDepart = width/22;
        float yDepart = height/3;

        for (int i=0;i<3;i++) {

            //ecart vertical entre les imagesButton



            for (int j = 0; j < 3; j++) {
                //taille des imageButtons
                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(6*(width / 22), 8*(width / 22));
                tableauImage[i][j] = new ImageButton(this);
                tableauImage[i][j].setLayoutParams(params);
                tableauImage[i][j].setVisibility(View.GONE);

                tableauImage[i][j].setX(xDepart);
                tableauImage[i][j].setY(yDepart);
                fenetre.addView(tableauImage[i][j]);
                xDepart+= 7*(width/22);
            }
            xDepart = (width/22);
            yDepart+= 7*(width/22);
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tableauMatrice[i][j].setImage(tableauImage[i][j]);
            }
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
    public void onPause(){
        super.onPause();
        musique.arreterMusique();
    }

    @Override
    public void onResume(){
        super.onResume();
        musique = new Musique(getApplicationContext());

        musique.jouerMusique();
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus){
        super.onWindowFocusChanged(hasFocus);
        if(width == 0) {
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
            afficherGrandeGrille();
            j1 = new Joueur((String) getIntent().getSerializableExtra("pseudo1"), R.drawable.croix, R.drawable.croix_transp);
            j2 = new Joueur((String) getIntent().getSerializableExtra("pseudo2"), R.drawable.cercle, R.drawable.cercle_transp);
            joueurActuel = j1;


            jouerTourTexte = (TextView) findViewById(R.id.jouerTourTexte);
            pseudo1 = (TextView) findViewById(R.id.pseudo1);
            pseudo2 = (TextView) findViewById(R.id.pseudo2);
            jouerTourImage = (ImageView) findViewById(R.id.tourJouerImage);
            jouerTourImage.setBackgroundResource(joueurActuel.getFormeTrans());
            jouerTourTexte.setText("C'est au tour de "+ joueurActuel.getPseudo() + " de jouer");
            pseudo1.setText(j1.getPseudo());
            pseudo2.setText(j2.getPseudo());

            jouerUnePartie();
        }

    }

    private void changerJoueur(){
        if(joueurActuel == j1){
            joueurActuel = j2;

        }else{
            joueurActuel = j1;

        }
        jouerTourTexte.setText("C'est au tour de "+ joueurActuel.getPseudo() + " de jouer");
        jouerTourImage.setBackgroundResource(joueurActuel.getFormeTrans());
    }

    public void jouerUnePartie(){
        jouerUnCoup(listeToutesMatrices);


    }


    public void jouerUnCoup(final List<Matrice> liste) {
        for (Matrice m : liste) {
            m.activerMatrice();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        m.getMatrice()[k][l].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ImageButton b = (ImageButton) v;
                                afficherForme(b);
                                desactiverMatrice(liste);
                                Matrice a = getMatriceClique(b);
                                verificationVictoire(a);
                                if(verificationVictoirePartie() == 0) {
                                    changerJoueur();
                                    coupSuivant(b, a);
                                }
                            }
                        });
                    }
                }

            }
    }

    private Matrice verificationVictoire(Matrice a){

        if (a.verificationVictoire(joueurActuel) == 1) {
            a.getImage().setBackgroundResource(a.getForme());
            a.getImage().setVisibility(View.VISIBLE);
        }
        return a;
    }

    public int verificationVictoirePartie(){
        int compteuregalite = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tableauMatrice[i][0].getForme() == joueurActuel.getFormeTrans() &&
                        tableauMatrice[i][1].getForme() == joueurActuel.getFormeTrans() && tableauMatrice[i][2].getForme() == joueurActuel.getFormeTrans()){
                    finPartieVictoire(1);
                    return 1;
                }
                if(tableauMatrice[0][i].getForme() == joueurActuel.getFormeTrans() &&
                        tableauMatrice[1][i].getForme() == joueurActuel.getFormeTrans() && tableauMatrice[2][i].getForme() == joueurActuel.getFormeTrans()){
                    finPartieVictoire(1);
                    return 1;
                }

                if(tableauMatrice[0][0].getForme() == joueurActuel.getFormeTrans() &&
                        tableauMatrice[1][1].getForme() == joueurActuel.getFormeTrans() && tableauMatrice[2][2].getForme() == joueurActuel.getFormeTrans()) {
                    finPartieVictoire(1);
                    return 1;
                }
                if(tableauMatrice[2][0].getForme() == joueurActuel.getFormeTrans() &&
                        tableauMatrice[1][1].getForme() == joueurActuel.getFormeTrans() && tableauMatrice[0][2].getForme() == joueurActuel.getFormeTrans()){
                    finPartieVictoire(1);
                    return 1;
                }
                if(tableauMatrice[i][j].getForme() != 0){
                    compteuregalite++;
                }
            }
        }
        if(compteuregalite == 9){
            finPartieVictoire(0);
            return 1;
        }
        return 0;
    }

    private void finPartieVictoire(int typeFin) {
        if(typeFin == 1){
            android.app.AlertDialog finPartie = new android.app.AlertDialog.Builder(this).create();
            finPartie.setButton(DialogInterface.BUTTON_POSITIVE, "oui", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            finPartie.setTitle("Victoire !!");
            finPartie.setIcon(joueurActuel.getFormeTrans());
            finPartie.setMessage(joueurActuel.getPseudo() + " a gagné !!");
            finPartie.show();
        }else if(typeFin == 0){
            android.app.AlertDialog finPartie = new android.app.AlertDialog.Builder(this).create();
            finPartie.setButton(DialogInterface.BUTTON_POSITIVE, "oui", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            finPartie.setTitle("Égalité !!");
            finPartie.setIcon(R.drawable.egalite);
            finPartie.show();
        }

    }


    private void coupSuivant(ImageButton b, Matrice a){
        List<Matrice> l = new ArrayList();
        if (matriceSuivante(a.coupSuivant(b)).getEstFinie()==false) {
            l.add(matriceSuivante(a.coupSuivant(b)));
            jouerUnCoup(l);
        } else {
            jouerUnCoup(listeToutesMatrices);
        }
    }

    private void afficherForme(ImageButton b){
        b.setBackgroundResource(joueurActuel.getForme());
        b.setTag(joueurActuel.getPseudo());
    }

    private void desactiverMatrice(List<Matrice> liste){
        for (Matrice m : liste) {
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    m.desactiverMatrice();
                }
            }
        }
    }



    private Matrice getMatriceClique(ImageButton b){
        for (Matrice m : listeToutesMatrices) {
            if (m.coupSuivant(b)!=9){
                return m;
            }
        }
        return m8;
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