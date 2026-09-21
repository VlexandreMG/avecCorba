# --- COMPILATEUR ET FLAGS ---
CXX = g++
CXXFLAGS = -std=c++17 -Wall -Wextra -I./lib/mysql-connector/include -I.

# --- PATHS ET LINKER MYSQL ---
LDFLAGS = -L./lib/mysql-connector/lib64 -lmysqlcppconn -Wl,-rpath,./lib/mysql-connector/lib64

# --- FICHIERS SOURCE ET OBJET ---
SRC = main.cpp \
      OlonaRepository.cpp \
      entity/Olona.cpp

OBJ = $(SRC:.cpp=.o)
EXEC = mon_programme

# --- RÈGLES DE COMPILATION ---

# Règle par défaut
all: $(EXEC)

# Édition de liens pour créer l'exécutable
$(EXEC): $(OBJ)
	$(CXX) $(OBJ) -o $(EXEC) $(LDFLAGS)

# Compilation des fichiers .cpp en fichiers .o
%.o: %.cpp
	$(CXX) $(CXXFLAGS) -c $< -o $@

# Nettoyage des fichiers générés
clean:
	rm -f $(OBJ) $(EXEC)

# Pour éviter les conflits si un fichier s'appelle 'clean' ou 'all'
.PHONY: all clean