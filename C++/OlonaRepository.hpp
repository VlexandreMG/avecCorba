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

    std::string getHost() const;
    void setHost(const std::string& host);

    std::string getUser() const;
    void setUser(const std::string& user);

    std::string getPassword() const;
    void setPassword(const std::string& password);

    std::string getDatabase() const;
    void setDatabase(const std::string& database);
};