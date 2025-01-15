package it.unife.ip.model;

import java.util.ArrayList;

public class Atleta {
    private String nome;
    private String cognome;
    private String dataNascita;
    private String indirizzo;
    private int numeroTelefono;
    private String email;
    private ArrayList<Attivita_Sp> attivita;
    

    public Atleta(String nome, String cognome, String dataNascita, String indirizzo, int numeroTelefono, String email, ArrayList<Attivita_Sp> attivita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.indirizzo = indirizzo;
        this.numeroTelefono = numeroTelefono;
        this.email = email;
        this.attivita = attivita;
    }
    public Atleta() {
        this.nome = "";
        this.cognome = "";
        this.dataNascita = "";
        this.indirizzo = "";
        this.numeroTelefono = 0;
        this.email = "";
        this.attivita = new ArrayList<>();
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getDataNascita() {
        return dataNascita;
    }
    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }
    public String getIndirizzo() {
        return indirizzo;
    }
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
    public int getNumeroTelefono() {
        return numeroTelefono;
    }
    public void setNumeroTelefono(int numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public ArrayList<Attivita_Sp> getAttivita() {
        return attivita;
    }
    public void setAttivita(ArrayList<Attivita_Sp> attivita) {
        this.attivita = attivita;
    }

    @Override
    public String toString() {
        return "Atleta{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita='" + dataNascita + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", numeroTelefono=" + numeroTelefono +
                ", email='" + email + '\'' +
                ", attivita=" + attivita +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atleta atleta = (Atleta) o;
        return numeroTelefono == atleta.numeroTelefono && nome.equals(atleta.nome) && cognome.equals(atleta.cognome) && dataNascita.equals(atleta.dataNascita) && indirizzo.equals(atleta.indirizzo) && email.equals(atleta.email) && attivita.equals(atleta.attivita);
    }
    
}
