#pragma once 

#include <string>

class Olona {
public:
    int id;
    std::string nom;
    std::string prenom;
    std::string email; 

    int getId() const {
        return id;
    } 
    void setId(int& id) {
        this->id = id;
    }

    std::string getNom() const {
        return nom;
    } 
    void setNom(std::string& nom) {
        this->nom = nom;
    }

    std::string getPrenom() const {
        return prenom;
    } 
    void setPrenom(std::string& prenom) {
        this->prenom = prenom;
    }

    std::string getEmail() const {
        return email;
    } 
    void setEmail(std::string& email) {
        this->email = email;
    }
};