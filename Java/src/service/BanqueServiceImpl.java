package service;

import Banque.banqueServicePOA;
import Banque.Compte;
import entity.CompteRepository;

public class BanqueServiceImpl extends banqueServicePOA {

    CompteRepository cpRep;

    @Override
    public Compte faireDepot(int idCompte, double montant) {
        System.out.println("[Java Server] Requête de dépôt reçue ! ID: " + idCompte + " | Montant: " + montant);

        cpRep.setCheminFichier("donnees.txt");
        cpRep.setSeparateur("\\;");

        if (!cpRep.updateCompte(idCompte, montant)) {
            System.out.println("Erreur dans l'update");
        } else {
            Compte compte = cpRep.selectCompte(idCompte);
            return compte;
        }

        // // Exemple de logique côté Java :
        // // Ici, vous pouvez traiter les données, interroger une BDD ou instancier le compte
        // Compte compte = new Compte();
        // compte.id = idCompte;
        // compte.nom = "Client Java Server";
        // compte.solde = 150000.0 + montant; // Exemple de solde mis à jour
        return null;
    }
}