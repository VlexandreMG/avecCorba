#include <vector>
#include <iostream>
#include "OlonaRepository.hpp"
#include "entity/Olona.hpp"

int main() {
    OlonaRepository repo;

    std::vector<Olona> listeOlona = repo.readThem();

    if (listeOlona.empty()) {
        std::cout << "Aucun olona trouvé dans la base" << std::endl;
    } else {
        for (const auto& olona : listeOlona) {
            std::cout << "Id : " << olona.getId()
                      << "Nom : " << olona.getNom()
                      << "Prenom : " << olona.getPrenom()        
                      << "Email : " << olona.getEmail() << std::endl;
        }
    }
}