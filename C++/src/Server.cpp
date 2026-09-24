#include <iostream>
#include <omniORB4/CORBA.h>
#include <omniORB4/Naming.hh>
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
        Banque::banqueService_var serviceRef = serviceImpl->_this();

    // Trouver le nameservice 
        CORBA::Object_var objNS = orb->resolve_initial_references("NameService");
        CosNaming::NamingContext_var nc = CosNaming::NamingContext::_narrow(objNS);

    // Enregistrer l'objet sous "BanqueService"5
        CosNaming::Name name;
        name.length(1);
        name[0].id = CORBA::string_dup("BanqueService");
        name[0].kind = CORBA::string_dup("");

        nc->rebind(name, serviceRef);

        std::cout << "==================================================" << std::endl;
        std::cout << ">>> Serveur C++ en ecoute sur le NameService ! <<<" << std::endl;
        std::cout << "==================================================" << std::endl;

    // Bloquer sur orb->run()
        orb->run();
    }
    catch (CORBA::Exception& ex) {
        std::cerr << "Erreur CORBA C++ : " << ex._name() << std::endl;
    }
    return 0;
};