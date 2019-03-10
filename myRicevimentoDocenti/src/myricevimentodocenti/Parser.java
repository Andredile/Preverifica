package myricevimentodocenti;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import myricevimentodocenti.Docenti;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
 *
 * @author di_lella_andrea
 */
public class Parser {

    private List<Docenti> docenti;
    String file;
    
    public Parser() {
        docenti = new ArrayList();
        file = "";
    }
    
    public Parser(String file){
        this.file = file;
        docenti = new ArrayList();
    }
    
     public List<Docenti> parseDocument(String giorno)
            throws ParserConfigurationException, SAXException, IOException {
        List<Docenti> lista = new ArrayList();
       
        valorizzaLista();
        for(Docenti d : docenti){
            if(d.giorno_ricevimento.equals(giorno))
            lista.add(d);
        }
        return lista;
    }
    
     
     public void valorizzaLista()
            throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document document;
        Element root, element;
        NodeList nodelist;
        
        // creazione dell’albero DOM dal documento XML
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(file);
        root = document.getDocumentElement();
        
        // generazione della lista degli elementi "docente"
        nodelist = root.getElementsByTagName("tr");
        String nome=null,giorno_ricevimento=null,ora=null,nota=null;
        int id=0;
        if(nodelist != null && nodelist.getLength() > 0){
            for (int i = 0; i < nodelist.getLength(); i++) {
                element = (Element) nodelist.item(i);
                NodeList nl = element.getElementsByTagName("td");
                if(nl != null && nl.getLength() > 0){
                    for(int o = 0; o < nl.getLength(); o++){
                        element = (Element)nl.item(o);
                        if(!element.getTextContent().equals(null)){
                            switch(o){
                                case 0:
                                    id = Integer.parseInt(element.getTextContent());
                                    break;
                                case 1:
                                    nome = element.getTextContent();
                                    break;
                                case 2:
                                    giorno_ricevimento = element.getTextContent();
                                    break;
                                case 3:
                                    ora = element.getTextContent();
                                    break;
                                default:
                                    nota = element.getTextContent();
                            }
                        }
                        
                    }
                    Docenti docente = new Docenti(id, nome, giorno_ricevimento, ora, nota);
                    GestioneDocenti.inserisciCsv(docente);
                    docenti.add(docente);
                }
            }
        }
    }
     
      public String ricerca(String nome)
            throws ParserConfigurationException, SAXException, IOException{
        valorizzaLista();
        for(Docenti d : docenti){
            if(d.nome.equals(nome))
                return d.giorno_ricevimento;
        }
        return "errore";
    }
    
    
}
