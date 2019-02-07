package com.example.fisso.morpiontest;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by fisso on 24/01/2019.
 */

public class Matrice {

    private ImageButton a1,a2,a3,b1,b2,b3,c1,c2,c3;
    private boolean estFinie;
    private ImageButton[][] tableau= { {a1, a2, a3}, {b1, b2, b3},{ c1, c2, c3} };



    public Matrice () {
        estFinie = false;
    }


    public ImageButton[][] getMatrice(){
        return this.tableau;
    }

    public int verificationVictoire(Joueur joueur){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tableau[i][0].getTag() == joueur.getPseudo() &&
                       tableau[i][1].getTag() == joueur.getPseudo() && tableau[i][2].getTag() == joueur.getPseudo()){
                    estFinie = true;
                    return 1;
                }
                    if(tableau[0][i].getTag() == joueur.getPseudo() &&
                            tableau[1][i].getTag() == joueur.getPseudo() && tableau[2][i].getTag() == joueur.getPseudo())
                {
                    estFinie = true;
                    return 1;
                }

                if(tableau[0][0].getTag() == joueur.getPseudo() &&
                        tableau[1][1].getTag() == joueur.getPseudo() && tableau[2][2].getTag() == joueur.getPseudo()) {
                    estFinie = true;
                    return 1;
                }
                    if(tableau[2][0].getTag() == joueur.getPseudo() &&
                            tableau[1][1].getTag() == joueur.getPseudo() && tableau[0][2].getTag() == joueur.getPseudo()){
                        estFinie = true;
                        return 1;
                }

                }


        }
        return 0;
    }


    public int coupSuivant(ImageButton b){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(b == tableau[i][j]){
                    return 3*i+j;
                }
            }
        }
        return 0;
    }


    public void desactiverMatrice(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tableau[i][j].setClickable(false);
            }
        }
    }

    public boolean getEstFinie(){
        return this.estFinie;
    }
}


