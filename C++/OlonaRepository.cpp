#include "OlonaRepository.hpp"
#include <iostream>

OlonaRepository::OlonaRepository()
    : host("tcp://127.0.0.1:3306"),
      user("root"),
      password("root"),
      database("test_db") {}

// --- GETTERS ET SETTERS ---
std::string OlonaRepository::getHost() const { return host; }
void OlonaRepository::setHost(const std::string& h) { host = h; }

std::string OlonaRepository::getUser() const { return user; }
void OlonaRepository::setUser(const std::string& u) { user = u; }

std::string OlonaRepository::getPassword() const { return password; }
void OlonaRepository::setPassword(const std::string& p) { password = p; }

std::string OlonaRepository::getDatabase() const { return database; }
void OlonaRepository::setDatabase(const std::string& db) { database = db; }

std::vector<Olona> OlonaRepository::readThem() {
    std::vector<Olona> listOlona;

    try {
        // Activation du driver 
        sql::mysql::MySQL_Driver* driver = sql::mysql::get_mysql_driver_instance();

        // Connexion à la base de données 
        std::unique_ptr<sql::Connection> con(driver->connect(host, user, password));

        // Selectionner la base de données 
        con->setSchema(database);

        // Création du statement 
        std::unique_ptr<sql::Statement> stmt(con->createStatement());

        // Execution de la requête SQL 
        std::unique_ptr<sql::ResultSet> res(stmt->executeQuery("SELECT id, nom, prenom, email FROM olona"));

        // Parcours du ResultSet 
        while (res->next()) {
            int id = res->getInt("id");
            std::string nom = res->getString("nom");
            std::string prenom = res->getString("prenom");
            std::string email = res->getString("email");

            // Instanciation de l'objet et ajout dans le vecteur
            Olona olona{id , nom , prenom , email};
            listOlona.push_back(olona);
        }
    } catch (sql::SQLException& e) {
        std::cerr << "Erreur de connexion MySQL : " << e.what() << std::endl;
        std::cerr << "Code d'erreur MySQL : " << e.getErrorCode() << std::endl;
    }

    return listOlona;
}