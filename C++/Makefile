# --- COMPILATEUR ET COMPILATEUR IDL ---
CXX = g++
IDL = omniidl

# --- FLAGS D'INCLUSION & OPTION DE COMPILATION ---
# On inclut omniORB, MySQL Connector et le dossier courant
CXXFLAGS = -std=c++17 -Wall -Wextra \
           -I. \
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
CORBA_GEN_SRC = banqueSK.cc
CORBA_GEN_OBJ = banqueSK.o

# --- VOS FICHIERS SOURCE ---
SRC = Server.cpp \
      BanqueServiceImpl.cpp \
      OlonaRepository.cpp

OBJ = $(SRC:.cpp=.o) $(CORBA_GEN_OBJ)
EXEC = mon_serveur_corba

# --- RÈGLES DE COMPILATION ---
all: $(EXEC)

# 1. Compilation du fichier IDL
$(CORBA_GEN_SRC): $(IDL_SRC)
	$(IDL) -bcxx $(IDL_SRC)

# 2. Édition de liens finale
$(EXEC): $(CORBA_GEN_SRC) $(OBJ)
	$(CXX) $(OBJ) -o $(EXEC) $(LDFLAGS)

# 3. Règle pour compiler les fichiers .cpp et .cc en .o
%.o: %.cpp
	$(CXX) $(CXXFLAGS) -c $< -o $@

%.o: %.cc
	$(CXX) $(CXXFLAGS) -c $< -o $@

# Nettoyage
clean:
	rm -f $(OBJ) $(EXEC) banqueSK.cc banque.hh

.PHONY: all cleancd 