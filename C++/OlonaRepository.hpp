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
};