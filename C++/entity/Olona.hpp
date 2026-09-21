#pragma once 

class Olona {
public:
    int id;
    String nom;
    String prenom;
    String email; 

    std::int getId(); 
    void setId(std::int& id);

    std::string getNom(); 
    void setNom(std::string& nom);

    std::string getPrenom(); 
    void setPrenom(std::string& prenom);

    std::string getEmail(); 
    void setEmail(std::string& email);
};