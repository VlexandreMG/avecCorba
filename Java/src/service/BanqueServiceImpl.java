package service;

import Banque.banqueServicePOA;
import Banque.Compte;

public class BanqueServiceImpl extends banqueServicePOA {

    @Override
    public Compte faireDepot(int idCompte, double montant) {
        System.out.println("[Java Server] Requête de dépôt reçue ! ID: " + idCompte + " | Montant: " + montant);

        // Exemple de logique côté Java :
        // Ici, vous pouvez traiter les données, interroger une BDD ou instancier le compte
        Compte compte = new Compte();
        compte.id = idCompte;
        compte.nom = "Client Java Server";
        compte.solde = 150000.0 + montant; // Exemple de solde mis à jour

        System.out.println("[Java Server] Traitement effectué. Nouveau solde : " + compte.solde);
        
        return compte;
    }
}