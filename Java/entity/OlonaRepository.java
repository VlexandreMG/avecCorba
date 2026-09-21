package entity;
import java.util.Array;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OlonaRepository {
    String cheminFichier;
    String separateur;

    List<Olona> readThem() {
        List<Olona> listOlona = new ArrayList<>();

        // Fonction pour lire le fichier 
        try () {
            FileReader fileReader = new FileReader(this.cheminFichier);
            BufferedReader reader = new BufferedReader(fileReader);
            // Debut de la boucle 
            
            // À chaque ligne , transforme en un objet et le met dans la liste 

            // Fin de la boucle 
        } catch (IOException e) {

        }

        // Liberer de la mémoire 
    }
}