#pragma once 

#include <string>

class Olona {
public:
    int id;
    std::string nom;
    std::string prenom;
    std::string email; 

    int getId() const; 
    void setId(int& id) const;

    std::string getNom() const; 
    void setNom(std::string& nom) const;

    std::string getPrenom() const; 
    void setPrenom(std::string& prenom) const;

    std::string getEmail() const; 
    void setEmail(std::string& email) const;
};