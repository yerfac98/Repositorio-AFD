/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.util.ArrayList;

/**
 *
 * @author jafet
 */
public class Automata {

    private int Q;
    private String alpha;
    private int q0;
    //Cambiar estados finales por arreglo o lista
    //private String F;//ArrayList <Integer> F;
    private ArrayList<Integer> F;
    private int mte[][];

    public int[][] getMte() {
        return mte;
    }

    public void setMte(int[][] mte) {
        this.mte = mte;
    }
   

    public int getMte(int q, int s) {
        if (q < Q && s < alpha.length()) {
            return mte[q][s];
        } else {
            return -1;
        }
    }

    public int getQ() {
        return Q;
    }

    public ArrayList<Integer> getF() {
        return F;
    }

    public String getAlpha() {
        return alpha;
    }

    public int getQ0() {
        return q0;
    }

    public void setQ(int Q) {
        this.Q = Q;
    }

    public void setAlpha(String alpha) {
        this.alpha = alpha;
    }

    public void setQ0(int q0) {
        this.q0 = q0;
    }

    public ArrayList<Integer> setF(String texto) {
        F = new ArrayList<>();
        for (int i = 0; i < texto.length(); i++) {
            char x = texto.charAt(i);
            if (x != ',') {
                int estadof = Integer.parseInt(String.valueOf(x));
                F.add(estadof);
            }
        }
        return F;
    }

    public void validamematriz() {

    }
//Metodo para cargar matriz

    public void llenaMatriz(String texto) {
        mte = new int[Q][alpha.length()];
        int cont = 0;
        for (int i = 0; i < Q; i++) {
            for (int j = 0; j < alpha.length(); j++) {
                mte[i][j] = Integer.parseInt(String.valueOf(texto.charAt(cont)));
                cont++;
            }
        }
        setMte(mte);
        imprimeMatriz();
    }

    private void imprimeMatriz() {
        for (int i = 0; i < Q; i++) {
            for (int j = 0; j < alpha.length(); j++) {
                System.out.print(mte[i][j]);
            }
            System.out.println("");
        }
    }

}
