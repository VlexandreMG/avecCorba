import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import BanqueModule.banqueService;
import BanqueModule.banqueServiceHelper;

public class Main {
    public static void main(String[] args) {
        OlonaRepository olonaR = new OlonaRepository(); 
        olonaR.setCheminFichier("donnees.txt");
        olonaR.setSeparateur("\\|");

        List<Olona> result = olonaR.readThem();

        for (Olona o : result) {
            System.out.println("ID :" + o.getId());
            System.out.println("Nom:" + o.getNom());
            System.out.println("Prenom :" + o.getPrenom());
            System.out.println("Email :" + o.getEmail());
        }
    }
}

