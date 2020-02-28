/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import javax.swing.JOptionPane;

/**
 *
 * @author jafet
 */
public class Analizador {

    private String cadena;
    private final Automata afd;
    private int simbolo_analizado;

    public Analizador(Automata afd) {
        simbolo_analizado = -1;
        this.afd = afd;
        afd.getMte();
    }

    char siguiente_simbolo() throws IndexOutOfBoundsException {//Para proteger memoria y saber que ya termino 
        simbolo_analizado++;
        return cadena.charAt(simbolo_analizado);

    }

    private void error(int i) {
        switch (i) {
            case 101:JOptionPane.showMessageDialog(null, "Simbolo o estado no declarado", "Error!!!", JOptionPane.ERROR_MESSAGE);
                break;
            case 102:   JOptionPane.showMessageDialog(null, "Simbolo no declarado", "Error!!!", JOptionPane.ERROR_MESSAGE);
                break;
        }

    }
    //String w recibe la cadena
    public boolean analizar(String w) {
        cadena = w;
        int q = afd.getQ0();//  estado inicial=0
        char s;//caracter, inicia -1
        int is; //Posicion 
        try {
            s = siguiente_simbolo();
            while (true) {
                is = afd.getAlpha().indexOf("" + s);//posicion del simbolo
                if (is == -1) {
                    error(102);
                }
                q = afd.getMte(q, is);// posicion en la matriz para hacer el cambio de E.

                System.out.println("" + q);
                if (q == -1) {
                    error(101);
                }
                s = siguiente_simbolo();
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Fin de cadena!");
        }
        // return afd.getF().contains("" + q);
        return afd.getF().contains(q);

    }
}
