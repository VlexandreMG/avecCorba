import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import BanqueModule.banqueService;
import BanqueModule.banqueServiceHelper;

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

            // 4. Appeler la fonction C++
            boolean resultat = service.faireDepot(1, 500.0);
            System.out.println("[CLIENT JAVA] Résultat du dépôt : " + resultat);

        } catch (Exception e) {
            System.err.println("[ERREUR CLIENT JAVA] : " + e.getMessage());
            e.printStackTrace();
        }
    }
}

