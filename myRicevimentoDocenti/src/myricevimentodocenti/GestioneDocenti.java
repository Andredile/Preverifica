/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myricevimentodocenti;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author di_lella_andrea
 */
public class GestioneDocenti {
    
    public static void inserisciCsv(Docenti docenti){
         try {
            File file = new File("Docenti.csv");

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            String Stringa = docenti.getNome() + ";" + docenti.getGiorno_ricevimento()+ ";" + docenti.getOra() + ";" + docenti.getNote();

            bw.write(Stringa + "\n");
            bw.close();
            System.out.println("Docente aggiunto");
        } catch (IOException ioe) {
            System.out.println("Errore: " + ioe);
        }
    }
    
    
}
