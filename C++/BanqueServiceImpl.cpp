#include "BanqueServiceImpl.hh"

BanqueServiceImpl::BanqueServiceImpl() {}
BanqueServiceImpl::~BanqueServiceImpl() {}

::CORBA::Boolean BanqueServiceImpl::faireDepot(::CORBA::Long idCompte , ::CORBA::Double montant) {
    std::cout << "[SERVEUR C++] Id Compte : "<< idCompte << std::endl;
    std::cout << "[SERVEUR C++] Montant : "<< montant << std::endl;
    
    
    std::cout << "[SERVEUR C++] Depot effectue avec succes !" << std::endl;
    return true;
}
