/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author jafet
 */
public class OpenFile {

    Automata afd;

    /**
     *
     * @param afd
     */
    public OpenFile(Automata afd) {
        this.afd = afd;
    }

    /**
     *
     * @return
     */
    public File obtenerArchivo() {
        JFileChooser input = new JFileChooser();
        input.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int res;
        res = input.showOpenDialog(input);
        //Si el usuario hace clic en cancelar regresa
        if (res == JFileChooser.CANCEL_OPTION) {
            input.cancelSelection();
        }
        File nameFile = input.getSelectedFile();//Se obtiene el archivo
        if ((nameFile == null) || (nameFile.getName().equals(""))) {
            JOptionPane.showMessageDialog(null, "Nombre de archivo invalido", "Nombre de archivo invalido", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        return nameFile;
    }

    //Mostrar inforacion acerca del archivo

    /**
     *
     */
    public void analizarRuta() {
        //Crea un objeto File acerca del archivo que especifica usuario
        File name = obtenerArchivo();
        if (name.exists()) {//si el nombre existe muestra informacion sobre el
            leerArchivo(name);
        } else {
            JOptionPane.showMessageDialog(null, name + "No existe", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     *
     * @param name
     */
    public void leerArchivo(File name) {
        String texto = "";
        try {
            String aux = "";
            int numLinea = 1;
            FileReader archivos = new FileReader(name);
            BufferedReader lee = new BufferedReader(archivos);
            while ((aux = lee.readLine()) != null) {
                if (numLinea == 1) {
                    afd.setQ(Integer.parseInt(aux));//Cantidad de estados
                } else if (numLinea == 2) {
                    afd.setAlpha(aux);//Alfabeto
                } else if (numLinea == 3) {
                    afd.setQ0(Integer.parseInt(aux));//Estado inicial
                } else if (numLinea == 4) {
                    afd.setF(aux);//estados final
                } else {
                    texto += aux;//matriz
                }  // Imprime línea leída
                System.out.println("Línea " + numLinea + ": " + aux);

                numLinea++;

            }
            lee.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        } catch (IOException err) {
            JOptionPane.showMessageDialog(null, err + ""
                    + "\nErroren la lectura del archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        } catch (NumberFormatException nb) {
            JOptionPane.showMessageDialog(null, nb + ""
                    + "\nError en la entrada de datos",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        } finally {
            //System.err.println("Ah ocurrido un error");
        }
        //  Validacion validar = new Validacion(texto);

        afd.llenaMatriz(texto);
        Analizador a = new Analizador(afd);

    }
}
