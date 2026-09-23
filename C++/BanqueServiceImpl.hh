#pragma once 

#include "banque.hh"

// C'est quoi le POA  
class BanqueServiceImpl : public POA_BanqueModule::banqueService {
public:
    BanqueServiceImpl();
    // Pourquoi il y a un constructeur en virtual 
    virtual ~BanqueServiceImpl();

    // Pourquoi il y a tous ces CORBA 
    ::CORBA::Boolean faireDepot(::CORBA::Long idCompte , ::CORBA::Double montant) override;
};