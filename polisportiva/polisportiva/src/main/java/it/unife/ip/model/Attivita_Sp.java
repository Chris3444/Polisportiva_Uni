package it.unife.ip.model;

public class Attivita_Sp {
    private String nome;
    private String descrizione;
    private String orari;
    private String giorni;
    
    public Attivita_Sp(String nome, String descrizione, String orari, String giorni) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.orari = orari;
        this.giorni = giorni;
    }
    public Attivita_Sp() {
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public String getOrari() {
        return orari;
    }
    public void setOrari(String orari) {
        this.orari = orari;
    }
    public String getGiorni() {
        return giorni;
    }
    public void setGiorni(String giorni) {
        this.giorni = giorni;
    }
    @Override
    public String toString() {
        return "Attivita_Sp{" +
                "nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", orari='" + orari + '\'' +
                ", giorni='" + giorni + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attivita_Sp that = (Attivita_Sp) o;
        return nome.equals(that.nome) && descrizione.equals(that.descrizione) && orari.equals(that.orari) && giorni.equals(that.giorni);
    }
    
}
