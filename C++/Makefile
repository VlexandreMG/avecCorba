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

# --- FICHIERS SOURCE SERVEUR ---
SERVER_SRC = $(SRC_DIR)/Server.cpp \
             $(SRC_DIR)/BanqueServiceImpl.cpp \
             $(SRC_DIR)/OlonaRepository.cpp
SERVER_OBJ = $(SERVER_SRC:.cpp=.o) $(CORBA_GEN_OBJ)

# --- FICHIERS SOURCE CLIENT ---
CLIENT_SRC = $(SRC_DIR)/ClientMain.cpp
CLIENT_OBJ = $(CLIENT_SRC:.cpp=.o) $(CORBA_GEN_OBJ)

# --- EXÉCUTABLES ---
SERVER_EXEC = monServeurCorba
CLIENT_EXEC = client_cpp

# --- RÈGLES DE COMPILATION ---
all: $(CORBA_GEN_SRC) $(SERVER_EXEC) $(CLIENT_EXEC)

# 1. Compilation du fichier IDL
$(CORBA_GEN_SRC): $(IDL_SRC)
	@mkdir -p $(GEN_DIR)
	$(IDL) -bcxx -C$(GEN_DIR) $(IDL_SRC)

# 2. Édition de liens du SERVEUR
$(SERVER_EXEC): $(SERVER_OBJ)
	$(CXX) $(SERVER_OBJ) -o $(SERVER_EXEC) $(LDFLAGS)

# 3. Édition de liens du CLIENT
$(CLIENT_EXEC): $(CLIENT_OBJ)
	$(CXX) $(CLIENT_OBJ) -o $(CLIENT_EXEC) $(LDFLAGS)

# 4. Compilation des fichiers .cpp de src/
$(SRC_DIR)/%.o: $(SRC_DIR)/%.cpp
	$(CXX) $(CXXFLAGS) -c $< -o $@

# 5. Compilation du code CORBA généré dans generated/
$(GEN_DIR)/%.o: $(GEN_DIR)/%.cc
	$(CXX) $(CXXFLAGS) -c $< -o $@

# Nettoyage
clean:
	rm -rf $(SRC_DIR)/*.o $(SERVER_EXEC) $(CLIENT_EXEC) $(GEN_DIR)

.PHONY: all clean