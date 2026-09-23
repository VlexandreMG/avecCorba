#include <iostream>
#include <omniORB4/CORBA.h>
#include <naming/Naming.hh>
#include "BanqueServiceImpl.hh"

int main(int argc , char**argv) {
    try {

    // Allumer l'ORB 
        CORBA::ORB_var orb = CORBA::ORB_init(argc, argv);

    // Activer le POA
        CORBA::Object_var objPOA = orb->resolve_initial_references("RootPOA");
        PortableServer::POA_var poa = PortableServer::POA::_narrow(objPOA);
        poa->the_POAManager()->activate();

    // Instancier le service C++ 
        BanqueServiceImpl* serviceImpl = new BanqueServiceImpl();
        BanqueModule::banqueService_var serviceRef = serviceImpl->_this();
        
    // Trouver le nameservice 

    // Enregistrer l'objet sous "BanqueService"5

    // Bloquer sur orb->run()
    }
    catch () {

    }
}