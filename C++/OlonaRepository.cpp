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