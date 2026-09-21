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

            String line;
            // Debut de la boucle 
            while ((line = reader.readLine()) != null) {
            // À chaque ligne , transforme en un objet et le met dans la liste 
                if (!line.trim().isEmpty()) {
                    String[] champs =  line.split(this.separateur);

                    int id = Integer.parseInt(champs[0]);
                    String nom = champs[1];
                    String prenom = champs[2];
                    String email = champs[3];

                    Olona man = new Olona();
                }

            }


            // Fin de la boucle 
        } catch (IOException e) {

        }

        // Liberer de la mémoire 
    }
}