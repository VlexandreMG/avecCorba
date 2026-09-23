# Demarrage du NameService 
- omniNames 

# Compilation de l'idl 
- omniidl -bcxx banque.idl

# Compilation du serveur 
- Via MakeList 

# Lancement du serveur 
- ./monServeurCorba -ORBInitRef NameService=corbaloc::localhost:2809/NameService