#include "BanqueServiceImpl.hh"

BanqueServiceImpl::BanqueServiceImpl() {

// Initialisation du repo MySQL 
    olonaRepo.setHost("tcp://127.0.0.1:3306");
    olonaRepo.setUser("root");
    olonaRepo.setPassword("root"); // Remplace par ton mdp MySQL
    olonaRepo.setDatabase("test_db");
}

Banque::Compte* BanqueServiceImpl::faireDepot(::CORBA::Long idCompte , ::CORBA::Double montant) {
    bool succes = olonaRepo.update(idCompte, montant);

    if (!succes) {
        std::cout << "Echec de l'update dans la base" << std::endl;
    }

    Banque::Compte* res = new Banque::Compte();
    *res = olonaRepo.readById(idCompte);

    return res;
}
