package entity;

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Banque.Compte;
import Banque.banqueService;

public class CompteRepository {
    String cheminFichier;
    String separateur;

    public CompteRepository() {};

    public String getCheminFichier() {
        return cheminFichier;
    }

    public void setCheminFichier(String cheminFichier) {
        this.cheminFichier = cheminFichier;
    }

    // SÉPARATEUR
    public String getSeparateur() {
        return separateur;
    }

    public void setSeparateur(String separateur) {
        this.separateur = separateur;
    }

    // public List<Compte> readThem() {
    //     List<Compte> listCompte = new ArrayList<>();

    //     // Fonction pour lire le fichier 
    //     try (FileReader fileReader = new FileReader(this.cheminFichier);) {
    //         BufferedReader reader = new BufferedReader(fileReader);

    //         String line;
    //         // Debut de la boucle 
    //         while ((line = reader.readLine()) != null) {
    //         // À chaque ligne , transforme en un objet et le met dans la liste 
    //             if (!line.trim().isEmpty()) {
    //                 String[] champs =  line.split(this.separateur);

    //                 int id = Integer.parseInt(champs[0]);
    //                 String nom = champs[1];

    //                 Compte man = new Compte();
    //                 man.setId(id);
    //                 man.setNom(nom);

    //         // Ajout dans la liste 
    //         listCompte.add(man);
    //             }

    //         // Fin de la boucle 
    //         }
    //     } catch (IOException e) {
    //         // Liberer de la mémoire 
    //         e.printStackTrace();
    //     }

    //     return listCompte;
    // }

    public Compte getCompteFromCpp (banqueService serviceCorba, int id, double montant) {
        Compte compteMisAJour = null;

        try {
            // Appel distant de la méthode faireDepot de BanqueServiceImpl en C++
            compteMisAJour = serviceCorba.faireDepot(id, montant);
            
            System.out.println("[Java Client] Compte reçu du C++ :");
            System.out.println("  ID     : " + compteMisAJour.id);
            System.out.println("  Nom    : " + compteMisAJour.nom);
            System.out.println("  Solde  : " + compteMisAJour.solde);

        } catch (Exception e) {
            System.err.println("[Java Client] Erreur lors de l'appel CORBA : " + e.getMessage());
            e.printStackTrace();
        }

        return compteMisAJour;
    }   
}