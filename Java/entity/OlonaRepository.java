package entity;

import java.util.List;
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
        try (FileReader fileReader = new FileReader(this.cheminFichier);) {
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
                    man.setId(id);
                    man.setNom(nom);
                    man.setPrenom(prenom);
                    man.setEmail(email);

            // Ajout dans la liste 
            listOlona.add(man);
                }

            // Fin de la boucle 
            }
        } catch (IOException e) {
            // Liberer de la mémoire 
            e.printStackTrace();
        }

        return listOlona;
    }
}