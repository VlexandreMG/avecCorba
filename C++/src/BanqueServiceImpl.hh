#pragma once 

#include <iostream>
#include "banque.hh"

// C'est quoi le POA : Le portable indique la portabilité sur n'importe 
// quel ORB , cet héritage transforme la classe BanqueServiceImpl en skeleton
// pour qu'il puisse intéragir en réseau. 

class BanqueServiceImpl : public POA_BanqueModule::banqueService {
public:
    BanqueServiceImpl();

    // Pourquoi il y a un constructeur en virtual 
    // ~ signifie que c'est un destructeur , et le virtual ,
    // lorsque CORBA détruit l'objet , le destructeur de la classe fille est executé en premier.  
    virtual ~BanqueServiceImpl();

    // Pourquoi il y a tous ces CORBA 
    // Pour éviter les conflits avec les noms 
    ::CORBA::Boolean faireDepot(::CORBA::Long idCompte , ::CORBA::Double montant) override;
};