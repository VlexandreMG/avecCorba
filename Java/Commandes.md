# Generer des Stubs 
- idlj -fall ../C++/banque.idl

# Compilation des classes 
- javac Main.java BanqueModule/*.java

# Execution du client 
- java Main -ORBInitRef NameService=corbaloc::localhost:2809/NameService