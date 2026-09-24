import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import Banque.banqueService;
import Banque.banqueServiceHelper;
import Banque.Compte;
import entity.CompteRepository;

public class Main {
    public static void main(String[] args) {
        try {
            // 1. Initialiser l'ORB Client
            ORB orb = ORB.init(args, null);

            // 2. Obtenir le NameService
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // 3. Chercher le service "BanqueService"
            banqueService service = banqueServiceHelper.narrow(ncRef.resolve_str("BanqueService"));

            System.out.println("[CLIENT JAVA] Connecté au serveur C++ !");

            // CompteRepository 
            CompteRepository cp = new CompteRepository();
            cp.setCheminFichier("donnees.txt");
            cp.setSeparateur(";");

            // Données 
            int idCompte = 1;
            double montant = 500.0;

            // 4. Appeler la fonction C++
            Compte compteMaj = cp.getCompteFromCpp(service,idCompte,montant);

            if (compteMaj != NULL) {
                cp.enregistrerDepot(compteMaj,montant);
                System.out.println("[Java Client] Traitement terminé avec succès.");
            } else {
                System.err.println("[Java Client] Échec du dépôt.");
            }

        } catch (Exception e) {
            System.err.println("[ERREUR CLIENT JAVA] : " + e.getMessage());
            e.printStackTrace();
        }
    }
}

