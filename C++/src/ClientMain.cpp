#include <iostream>
#include <exception>
#include "banque.hh" // En-tête généré par omniidl

int main(int argc, char* argv[]) {
    try {
        // 1. Initialiser l'ORB C++ (omniORB)
        std::cout << "[C++ Client] Initialisation de l'ORB..." << std::endl;
        CORBA::ORB_var orb = CORBA::ORB_init(argc, argv);

        // 2. Obtenir la référence vers le NameService
        CORBA::Object_var objRef = orb->resolve_initial_references("NameService");
        
        // On importe le NameService CosNaming
        CosNaming::NamingContext_var ncRef = CosNaming::NamingContext::_narrow(objRef);

        if (CORBA::is_nil(ncRef)) {
            std::cerr << "[C++ Client] Impossible de contacter le NameService !" << std::endl;
            return 1;
        }

        // 3. Rechercher le service 'BanqueService' publié par Java
        CosNaming::Name name;
        name.length(1);
        name[0].id   = CORBA::string_dup("BanqueService");
        name[0].kind = CORBA::string_dup("");

        std::cout << "[C++ Client] Recherche de BanqueService dans le NameService..." << std::endl;
        CORBA::Object_var serviceObj = ncRef->resolve(name);

        // 4. Utiliser _narrow pour caster l'objet générique en interface BanqueService
        Banque::banqueService_var banqueService = Banque::banqueService::_narrow(serviceObj);

        if (CORBA::is_nil(banqueService)) {
            std::cerr << "[C++ Client] La référence distante n'est pas un BanqueService valide." << std::endl;
            return 1;
        }

        std::cout << "[C++ Client] Connecté avec succès au Serveur Java !" << std::endl;

        // 5. Invoquer la méthode distante faireDepot
        CORBA::Long idCompte = 1;
        CORBA::Double montant = 75000.0;

        std::cout << "[C++ Client] Envoi de la requête de dépôt -> ID: " << idCompte 
                  << " | Montant: " << montant << std::endl;

        // Appel distant (RPC) vers Java
        // Remarque : faireDepot renvoie un pointeur Banque::Compte* sous C++
        Banque::Compte* compteResultat = banqueService->faireDepot(idCompte, montant);

        if (compteResultat != nullptr) {
            std::cout << "\n================ RESULTAT REÇU DE JAVA ================" << std::endl;
            std::cout << "ID Compte : " << compteResultat->id << std::endl;
            std::cout << "Nom       : " << compteResultat->nom << std::endl;
            std::cout << "Nouveau Solde : " << compteResultat->solde << std::endl;
            std::cout << "========================================================\n" << std::endl;

            // Libération de la mémoire allouée dynamiquement pour la réponse
            delete compteResultat;
        } else {
            std::cerr << "[C++ Client] Aucun résultat retourné par le serveur Java." << std::endl;
        }

        // 6. Nettoyage de l'ORB
        orb->destroy();

    } catch (const CORBA::Exception& ex) {
        std::cerr << "[C++ Client] Exception CORBA : " << ex._name() << std::endl;
        return 1;
    } catch (const std::exception& e) {
        std::cerr << "[C++ Client] Erreur standard : " << e.what() << std::endl;
        return 1;
    }

    return 0;
}