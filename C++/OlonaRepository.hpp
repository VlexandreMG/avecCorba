#pragma once 

#include <vector>
#include <string>
#include <memory>

#include <mysql_driver.h>
#include <mysql_connection.h>
#include <cppconn/statement.h>
#include <cppconn/resultset.h>
#include <cppconn/exception.h>

#include "entity/Olona.hpp"

class OlonaRepository {
public:
    std::string host;
    std::string user;
    std::string password;
    std::string database;

    OlonaRepository();

    std::string getHost() const; 
    void setHost(const std::string& host);

    std::string getUser() const; 
    void setUser(const std::string& user);

    std::string getPassword() const; 
    void setPassword(const std::string& password);

    std::string getDatabase() const; 
    void setDatabase(const std::string& database);

    std::vector<Olona> readThem();
};
