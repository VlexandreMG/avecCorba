import java.util.List;
import java.util.ArrayList;
import entity.Olona;
import entity.OlonaRepository;

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

