# Generer des Stubs 
- idlj -fall ../C++/banque.idl

# Compilation des classes 
- javac Main.java BanqueModule/*.java

# Execution du client 
- java -cp bin Main -ORBInitRef NameService=corbaloc::localhost:2809/NameService

# Compilation izy rehetra 
- javac -d bin -sourcepath src $(find src -name "*.java")