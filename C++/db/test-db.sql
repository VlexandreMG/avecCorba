-- 1. Création de la base de données si elle n'existe pas
CREATE DATABASE IF NOT EXISTS `test_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- 2. Utilisation de la base
USE `test_db`;

-- 3. Suppression de la table si elle existe déjà (pour repartir à neuf)
DROP TABLE IF EXISTS `olona`;

-- 4. Création de la table olona
CREATE TABLE `olona` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `nom` VARCHAR(50) NOT NULL,
    `prenom` VARCHAR(50) NOT NULL,
    `email` VARCHAR(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 5. Insertion de quelques données de test
INSERT INTO `olona` (`nom`, `prenom`, `email`) VALUES
('Ranaivo', 'Aina', 'aina.ranaivo@email.com'),
('Rakoto', 'Koto', 'koto.rakoto@email.com'),
('Andria', 'Soa', 'soa.andria@email.com');