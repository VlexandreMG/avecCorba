# --- COMPILATEUR ET FLAGS ---
CXX = g++
CXXFLAGS = -std=c++17 -Wall -Wextra -I./lib/mysql-connector/include/jdbc -I.

# --- PATHS ET LINKER MYSQL ---
# Ajustez lib64 en lib si votre dossier s'appelle lib
LDFLAGS = -L./lib/mysql-connector/lib64 -lmysqlcppconn -Wl,-rpath,./lib/mysql-connector/lib64

# --- FICHIERS SOURCE ET OBJET ---
SRC = Main.cpp \
      OlonaRepository.cpp 

OBJ = $(SRC:.cpp=.o)
EXEC = mon_programme

# --- RÈGLES DE COMPILATION ---
all: $(EXEC)

# Édition de liens
$(EXEC): $(OBJ)
	$(CXX) $(OBJ) -o $(EXEC) $(LDFLAGS)

# Règle générique de compilation des .cpp en .o
%.o: %.cpp
	$(CXX) $(CXXFLAGS) -c $< -o $@

clean:
	rm -f $(OBJ) $(EXEC)

.PHONY: all clean