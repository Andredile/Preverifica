package myricevimentodocenti;
/*
    quali sono di docenti che ricevono nel giorno scelto dall'utente
    quando riceve il docente inserito dall'utente
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author di_lella_andrea
 */
public class MyRicevimentoDocenti {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        int scelta = -1;
        Scanner tastiera = new Scanner(System.in);
        
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader input = new BufferedReader(reader);
        Parser dom = new Parser("ricevimento_docenti.xml");
        List<Docenti> lista = null;
        
        try {
            while (scelta!=0) {
            System.out.println("0)esci");
            System.out.println("1)Ricevimento professori");
            System.out.println("2)Inserisci nome docente");
            scelta = tastiera.nextInt();
            switch(scelta){
                case 1:
                    System.out.println("inserisci giorno");
                    String giorno = tastiera.next();
                    lista = dom.parseDocument(giorno);
                     for(Docenti d : lista)
                        System.out.println(d.getNome());
                    break;
                case 2:
                    System.out.println("inserisci il nome del prof");
                    String prof = input.readLine();
                    giorno = dom.ricerca(prof);
                    System.out.println(prof + " riceve il " + giorno);
                    break;
               
                case 0:
                    break;
                default:
                    System.out.println("Scelta effettuata inesistente");
            }
        }
        } catch (Exception e) {
            //(System.out.print(e.)
        }
    }

}
