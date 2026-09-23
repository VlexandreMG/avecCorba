package entity;

public class Compte {
    int id;
    String nom;

    public Compte() {}; 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // NOM
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}