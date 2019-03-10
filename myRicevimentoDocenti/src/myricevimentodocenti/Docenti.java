package myricevimentodocenti;

/**
 *
 * @author di_lella_andrea
 */

public class Docenti {
     String nome,ora,giorno_ricevimento,note;
    int id;

    public Docenti(int id, String nome, String giorno_ricevimento, String ora, String note) {
        this.nome = nome;
        this.giorno_ricevimento = giorno_ricevimento;
        this.note = note;
        this.id = id;
        this.ora = ora;
    }

    public Docenti() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGiorno_ricevimento() {
        return giorno_ricevimento;
    }

    public void setGiorno_ricevimento(String giorno_ricevimento) {
        this.giorno_ricevimento = giorno_ricevimento;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

}
