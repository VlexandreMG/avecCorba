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

bool OlonaRepository::update(long id, double montant) {
    try {
        sql::mysql::MySQL_Driver* driver = sql::mysql::get_mysql_driver_instance();
        std::unique_ptr<sql::Connection> con(driver->connect(host, user, password));
        con->setSchema(database);

        std::cout << "[C++ Repo] Connexion BDD réussie (" << database << ")" << std::endl;

        std::unique_ptr<sql::PreparedStatement> pstmt(
            con->prepareStatement("UPDATE compte SET solde = solde + ? WHERE id = ?")
        );

        pstmt->setDouble(1, montant);
        pstmt->setInt64(2, static_cast<int64_t>(id));

        int rowUpdated = pstmt->executeUpdate();
        std::cout << "[C++ Repo] Lignes affectées par l'UPDATE : " << rowUpdated << std::endl;

        return (rowUpdated > 0);

    } catch (sql::SQLException& e) {
        std::cerr << "[C++ Repo Error] SQL Exception: " << e.what() 
                  << " (MySQL error code: " << e.getErrorCode() << ")" << std::endl;
        return false;
    } catch (const std::exception& e) {
        std::cerr << "[C++ Repo Error] Standard Exception: " << e.what() << std::endl;
        return false;
    }
}

Banque::Compte OlonaRepository::readById(long id) {
    // Initialisation d'une structure Compte par défaut
    Banque::Compte compte;
    compte.id = 0;
    compte.nom = CORBA::string_dup("");
    compte.solde = 0.0;

    try {
        // 1. Activation du driver & Connexion
        sql::mysql::MySQL_Driver* driver = sql::mysql::get_mysql_driver_instance();
        std::unique_ptr<sql::Connection> con(driver->connect(host, user, password));
        con->setSchema(database);

        // 2. Préparation de la requête SELECT
        std::unique_ptr<sql::PreparedStatement> pstmt(
            con->prepareStatement("SELECT id, nom, solde FROM compte WHERE id = ?")
        );
        pstmt->setInt(1, id); // Remplacement du premier '?' par l'ID

        // 3. Exécution de la requête (executeQuery pour un SELECT)
        std::unique_ptr<sql::ResultSet> res(pstmt->executeQuery());

        // 4. Parcours du résultat
        if (res->next()) {
            compte.id = res->getInt("id");
            // CORBA::string_dup permet d'allouer proprement la mémoire pour les chaînes CORBA
            compte.nom = CORBA::string_dup(res->getString("nom").c_str());
            compte.solde = res->getDouble("solde");
        } else {
            std::cerr << "[OlonaRepository] Aucun compte trouvé avec l'ID : " << id << std::endl;
        }

    } catch (sql::SQLException& e) {
        std::cerr << "[OlonaRepository] Erreur SQL dans readById : " << e.what() << std::endl;
    }

    return compte;
}