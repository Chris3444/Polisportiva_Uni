package it.unife.ip.model;

import java.util.ArrayList;

public class Atleta {
    private String nome;
    private String cognome;
    private String dataNascita;
    private int numeroTelefono;
    private String email;
    private ArrayList<Attivita_Sp> attivita;

    public Atleta(String nome, String cognome, String dataNascita, int numeroTelefono, String email, ArrayList<Attivita_Sp> attivita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.numeroTelefono = numeroTelefono;
        this.email = email;
        this.attivita = attivita;
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
    
}
