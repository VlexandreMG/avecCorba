package entity;

public class Olona {
    int id;
    String nom;
    String prenom;
    String email;

    public Olona() {}; 

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

    // PRENOM
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    // EMAIL
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}