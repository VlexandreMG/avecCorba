# --- COMPILATEUR ET COMPILATEUR IDL ---
CXX = g++
IDL = omniidl

# --- DOSSIERS ---
SRC_DIR = src
GEN_DIR = generated

# --- FLAGS D'INCLUSION & OPTIONS DE COMPILATION ---
CXXFLAGS = -std=c++17 -Wall -Wextra \
           -I. \
           -I$(SRC_DIR) \
           -I$(GEN_DIR) \
           -I./lib/mysql-connector/include/jdbc \
           -D__x86__ -D__linux__ -D__OSVERSION__=2

# --- PATHS ET ÉDITION DE LIENS (LDFLAGS) ---
LDFLAGS = -L./lib/mysql-connector/lib64 -lmysqlcppconn \
          -lomniORB4 -lomniDynamic4 -lomnithread \
          -Wl,-rpath,./lib/mysql-connector/lib64

# --- FICHIERS IDL & SOURCES GÉNÉRÉS ---
IDL_SRC = banque.idl
CORBA_GEN_SRC = $(GEN_DIR)/banqueSK.cc
CORBA_GEN_OBJ = $(GEN_DIR)/banqueSK.o

# --- FICHIERS SOURCE (dans src/) ---
SRC = $(SRC_DIR)/Server.cpp \
      $(SRC_DIR)/BanqueServiceImpl.cpp \
      $(SRC_DIR)/OlonaRepository.cpp

# Transformation des .cpp et .cc en .o
OBJ = $(SRC:.cpp=.o) $(CORBA_GEN_OBJ)
EXEC = monServeurCorba

# --- RÈGLES DE COMPILATION ---
all: $(EXEC)

# 1. Compilation du fichier IDL dans le dossier generated/
$(CORBA_GEN_SRC): $(IDL_SRC)
	@mkdir -p $(GEN_DIR)
	$(IDL) -bcxx -C$(GEN_DIR) $(IDL_SRC)

# 2. Édition de liens finale
$(EXEC): $(CORBA_GEN_SRC) $(OBJ)
	$(CXX) $(OBJ) -o $(EXEC) $(LDFLAGS)

# 3. Règle pour compiler les fichiers .cpp de src/
$(SRC_DIR)/%.o: $(SRC_DIR)/%.cpp
	$(CXX) $(CXXFLAGS) -c $< -o $@

# 4. Règle pour compiler le code CORBA généré dans generated/
$(GEN_DIR)/%.o: $(GEN_DIR)/%.cc
	$(CXX) $(CXXFLAGS) -c $< -o $@

# Nettoyage
clean:
	rm -rf $(OBJ) $(EXEC) $(GEN_DIR)

.PHONY: all clean