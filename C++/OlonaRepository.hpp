#pragma once 

#include <mysql_driver.h>
#include <mysql_connection.h>
#include <cppconn/statement.h>
#include <cppconn/resultset.h>
#include <cppconn/exception.h>

class OlonaRepository {
public:
    std::string host:
    std::string user;
    std::string password;
    std::string database;

    std::string getHost(); 
    void setHost(std::string& host);

    std::string getUser(); 
    void setUser(std::string& user);

    std::string getPassword(); 
    void setPassword(std::string& password);

    std::string getDatabase(); 
    void setDatabase(std::string& database);

    std::vector<Olona> readThem();
};
