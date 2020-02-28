/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import javax.swing.JOptionPane;

/**
 * Carrera: ISC
 * 6 semestre
 * Lenguajes y automatas
 * Docente: Rogelio Garcia Rodriguez
 * Integrantes:
 * Jesus Francisco Martinez
 * Gerard Facundo Del Angel
 * Francisca Jeronimo Del Angel
 *
 * @author jafet
 */
public class LyA {

    public static void main(String[] args) {
        try {
            Automata afd = new Automata();
            OpenFile on = new OpenFile(afd);
            on.analizarRuta();
            int result = 0;
            while (result == 0) {

                Analizador a = new Analizador(afd);
                String cadena;
                cadena = JOptionPane.showInputDialog(null, "Cadena a analizar", "Datos de entrada", JOptionPane.QUESTION_MESSAGE);
                if (a.analizar(cadena)) {
                    JOptionPane.showMessageDialog(null, "Cadena aceptada", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Cadena rechazada", "Resultado", JOptionPane.ERROR_MESSAGE);
                }
                result = JOptionPane.showConfirmDialog(null, "Deseas analizar otra cadena", "Oye", JOptionPane.OK_OPTION);

            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nEl automata no es correcto o ah ingresado datos nulos",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        }
    }
}
