import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import service.BanqueServiceImpl;

public class ServerMain {

    public static void main(String[] args) {
        try {
            // 1. Initialiser l'ORB
            System.out.println("[Java Server] Démarrage de l'ORB...");
            ORB orb = ORB.init(args, null);

            // 2. Obtenir et activer le RootPOA
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // 3. Instancier le service Java
            BanqueServiceImpl banqueService = new BanqueServiceImpl();

            // 4. Obtenir la référence CORBA (servant) associée à notre service
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(banqueService);
            Banque.banqueService href = Banque.banqueServiceHelper.narrow(ref);

            // 5. Enregistrer le service dans le NameService (omniNames / NamingService)
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            String name = "BanqueService";
            NameComponent[] path = ncRef.to_name(name);
            ncRef.rebind(path, href);

            System.out.println("[Java Server] Le service 'BanqueService' est prêt et à l'écoute des requêtes C++...");

            // 6. Mettre le serveur en attente d'appels distants
            orb.run();

        } catch (Exception e) {
            System.err.println("[Java Server] Erreur serveur : " + e.getMessage());
            e.printStackTrace();
        }
    }
}