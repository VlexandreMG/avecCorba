# --- COMPILATEUR ET COMPILATEUR IDL ---
CXX = g++
IDL = omniidl

# -- DOSSIERS ---
SRC_DIR = src 
GEN_DIR = generated 

# --- FLAGS D'INCLUSION & OPTION DE COMPILATION ---
# On inclut omniORB, MySQL Connector et le dossier courant
CXXFLAGS = -std=c++17 -Wall -Wextra \
           -I. \
           -I$(SRC_DIR) \
           -I$(GEN_DIR) \
           -I./lib/mysql-connector/include/jdbc \
           -D__x86__ -D__linux__ -D__OSVERSION__=2

# --- PATHS ET EDITION DE LIENS (LDFLAGS) ---
# Ajout des bibliothèques omniORB4 et omniDynamic4
LDFLAGS = -L./lib/mysql-connector/lib64 -lmysqlcppconn \
          -lomniORB4 -lomniDynamic4 -lomnithread \
          -Wl,-rpath,./lib/mysql-connector/lib64

# --- FICHIERS IDL & SOURCES GÉNÉRÉS ---
IDL_SRC = banque.idl
# omniidl va générer BanqueSK.cc et Banque.hh
CORBA_GEN_SRC = $(GEN_DIR)/banqueSK.cc
CORBA_GEN_OBJ = $(GEN_DIR)/banqueSK.o

# --- VOS FICHIERS SOURCE ---
SRC = $(SRC_DIR)/Server.cpp \
      $(SRC_DIR)/BanqueServiceImpl.cpp \
      $(SRC_DIR)/OlonaRepository.cpp

OBJ = $(SRC:.cpp=.o) $(CORBA_GEN_OBJ)
EXEC = monServeurCorba

# --- RÈGLES DE COMPILATION ---
all: $(EXEC)

# 1. Compilation du fichier IDL
$(CORBA_GEN_SRC): $(IDL_SRC)
        @mkdir -p $(GEN_DIR)
	  $(IDL) -bcxx -C$(GEN_DIR) $(IDL_SRC)

# 2. Édition de liens finale
$(EXEC): $(CORBA_GEN_SRC) $(OBJ)
	$(CXX) $(OBJ) -o $(EXEC) $(LDFLAGS)

# 3. Règle pour compiler les fichiers .cpp et .cc en .o
$(SRC_DIR)/%.o: $(SRC_DIR)/%.cpp
	$(CXX) $(CXXFLAGS) -c $< -o $@

$(SRC_DIR)/%.o: $(SRC_DIR)/%.cc
	$(CXX) $(CXXFLAGS) -c $< -o $@

# Nettoyage
clean:
	rm -f $(OBJ) $(EXEC) $(GEN_DIR)

.PHONY: all cleancd 