#include <vector>
#include "OlonaRepository.hpp"
#include "entity/Olona.hpp"

int main() {
    OlonaRepository repo;

    std::vector<Olona> listeOlona = repo.readThem();
}