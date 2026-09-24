package entity;

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

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

    public boolean enregistrerDepot(Compte compte, double montantDepose) {
        if (compte == null) {
            System.err.println("[Java Log] Impossible d'écrire : le compte est nul.");
            return false;
        }

        // On ouvre le fichier en mode "append" (deuxième paramètre = true)
        try (FileWriter fw = new FileWriter(this.cheminFichier, true);
             BufferedWriter writer = new BufferedWriter(fw)) {

            // Construction de la ligne avec le séparateur (ex: ";")
            String logLine = compte.id + this.separateur + compte.nom + this.separateur + compte.solde + this.separateur + montantDepose;

            writer.write(logLine);
            writer.newLine(); // Passage à la ligne suivante

            System.out.println("[Java Log] Opération enregistrée dans " + this.cheminFichier + " : " + logLine);
            return true;

        } catch (IOException e) {
            System.err.println("[Java Log] Erreur lors de l'écriture dans le fichier log : " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateCompte(int id, double montant) {
        try (BufferedReader br = new BufferedReader(new FileReader(this.cheminFichier))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] champs = line.split(this.separateur);
                    int idLine = Integer.parseInt(champs[0]);     

                    if (idLine == id) {
                        // 1. Transformer la 3ème colonne (index 2) en double 
                    double soldeActuel = Double.parseDouble(champs[2].trim());

                    // 2. Sommer avec le montant du dépôt
                    double nouveauSolde = soldeActuel + montant;

                    // 3. Remettre sur champs[2] en le transformant en String 
                    champs[2] = String.valueOf(nouveauSolde);
                    }
                }       
            }

            return true 
        } catch (IOException e) {
            System.err.println("Il y a une erreur dans le update : " + e.getMessage());
            e.printStackTrace();
            return false;
        }     
    }
}