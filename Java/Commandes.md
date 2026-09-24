# Generer des Stubs 
- idlj -fall ../C++/banque.idl

# Compilation des classes 
- javac Main.java BanqueModule/*.java

# Execution du client 
- java Main -ORBInitRef NameService=corbaloc::localhost:2809/NameService

# Compilation rehefa mitest 
- javac -d bin -sourcepath src src/entity/CompteRepository.java 

# Compilation izy rehetra 
- javac -d bin -sourcepath src $(find src -name "*.java")