-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : lun. 25 avr. 2022 à 08:26
-- Version du serveur : 8.0.27
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestionjeu`
--

-- --------------------------------------------------------

--
-- Structure de la table `action`
--

DROP TABLE IF EXISTS `action`;
CREATE TABLE IF NOT EXISTS `action` (
  `ID_Action` varchar(20) NOT NULL,
  `ID_Personnage` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Moment` datetime NOT NULL,
  `Type_action` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Commentaire` text NOT NULL,
  `ID_Cible` varchar(20) NOT NULL,
  PRIMARY KEY (`ID_Action`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `action`
--

INSERT INTO `action` (`ID_Action`, `ID_Personnage`, `Moment`, `Type_action`, `Commentaire`, `ID_Cible`) VALUES
('ACTI-KIHJXKR', 'PERS-AAAAAAA', '2022-02-24 14:38:37', 'Test', 'Hahaha', 'LIEU-AAAAAAA'),
('ACTI-IMKBCSZ', 'PERS-AAAAAAA', '2022-02-24 14:38:41', 'Test', 'Hahaha', 'LIEU-AAAAAAA'),
('ACTI-XOXJQNU', 'PERS-AAAAAAA', '2022-02-24 14:38:42', 'Test', 'Hahaha', 'LIEU-AAAAAAA'),
('ACTI-YVYDGFB', 'PERS-AAAAAAA', '2022-02-24 14:38:43', 'Test', 'Hahaha', 'LIEU-AAAAAAA'),
('ACTI-RHJWCLR', 'PERS-AAAAAAA', '2022-02-24 14:38:43', 'Test', 'Hahaha', 'LIEU-AAAAAAA'),
('ACTI-NEXIQVN', 'PERS-AAAAAAA', '2022-02-24 14:38:44', 'Test', 'Hahaha', 'LIEU-AAAAAAA'),
('ACTI-JGKPEHJ', 'PERS-AAAAAAA', '2022-02-24 14:38:44', 'Test', 'Hahaha', 'LIEU-AAAAAAA'),
('ON-BWtaRPgZETwefNMWq', 'PERS-AAAAAAA', '2022-03-29 10:39:40', 'Test', 'Hahaha', 'LIEU-BBBBBBB'),
('ACTI-BKLlUzzZWBDERPT', 'PERS-AAAAAAA', '2022-03-29 10:45:34', 'Test', 'Hahaha', 'LIEU-BBBBBBB'),
('ACTI-ZXgIheRXFQZOcCZ', 'PERS-AAAAAAA', '2022-03-29 12:33:14', 'Test', 'Hahaha', 'LIEU-AAAAAAA'),
('ACTI-eCYYBYUIp_y_Ryu', 'PERS-AAAAAAA', '2022-03-29 19:31:27', 'Test', 'Hahaha', 'LIEU-BBBBBBB');

-- --------------------------------------------------------

--
-- Structure de la table `app_user`
--

DROP TABLE IF EXISTS `app_user`;
CREATE TABLE IF NOT EXISTS `app_user` (
  `username` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `mail` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `app_user`
--

INSERT INTO `app_user` (`username`, `mail`, `password`) VALUES
('Naimde', 'naimde@orange.fr', '$2a$10$eKjqoPWibC2u8fpTz6z3k.lESqO2.SnQFNWppxwq86odlzxgqUo2O'),
('test', 'testfgf', '$2y$10$YQK8vV.8Ac3UBu/b174vIeXrLoQGi7NER2.JdviLB3rEUYgjCJmha');

-- --------------------------------------------------------

--
-- Structure de la table `app_user_roles`
--

DROP TABLE IF EXISTS `app_user_roles`;
CREATE TABLE IF NOT EXISTS `app_user_roles` (
  `username` varchar(40) NOT NULL,
  `roles_id` int NOT NULL,
  UNIQUE KEY `username` (`username`,`roles_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `app_user_roles`
--

INSERT INTO `app_user_roles` (`username`, `roles_id`) VALUES
('Naimde', 1),
('Naimde', 2),
('Naimde', 3),
('Naimde', 4),
('Naimde', 9),
('test', 2),
('test', 3),
('test', 4);

-- --------------------------------------------------------

--
-- Structure de la table `connu`
--

DROP TABLE IF EXISTS `connu`;
CREATE TABLE IF NOT EXISTS `connu` (
  `IdPersonnage` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `IdCible` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Description` text,
  `Note` text,
  `Date_Ajout` datetime NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
CREATE TABLE IF NOT EXISTS `groupe` (
  `ID_Groupe` varchar(20) NOT NULL,
  `Genre` varchar(40) NOT NULL,
  `Nom` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Description` text,
  `visionautre` tinyint(1) NOT NULL DEFAULT '1',
  `Leader` varchar(20) DEFAULT NULL,
  `Jeu` varchar(60) NOT NULL,
  UNIQUE KEY `ID_Groupe` (`ID_Groupe`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `groupe`
--

INSERT INTO `groupe` (`ID_Groupe`, `Genre`, `Nom`, `Description`, `visionautre`, `Leader`, `Jeu`) VALUES
('GRGE-mwRaPXRdyVqPVkV', 'Genre', 'nom', 'Hera', 1, NULL, 'Heraclyon'),
('GRGE-NGddgVxbybXzBRi', 'Genre', 'Prout', 'haha', 1, NULL, 'Test'),
('GRHO-YUjrKXdkSfMeEHY', 'Hohoho', 'héhéhé', 'non', 0, NULL, 'Test');

-- --------------------------------------------------------

--
-- Structure de la table `jeux`
--

DROP TABLE IF EXISTS `jeux`;
CREATE TABLE IF NOT EXISTS `jeux` (
  `Jeu` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ID_Personnage` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `User` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `lieu`
--

DROP TABLE IF EXISTS `lieu`;
CREATE TABLE IF NOT EXISTS `lieu` (
  `ID_Lieu` varchar(20) NOT NULL,
  `Genre` varchar(20) NOT NULL,
  `Nom` varchar(100) DEFAULT NULL,
  `Description` text,
  `Jeu` varchar(60) NOT NULL,
  UNIQUE KEY `ID_Lieu` (`ID_Lieu`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `membre`
--

DROP TABLE IF EXISTS `membre`;
CREATE TABLE IF NOT EXISTS `membre` (
  `Id_groupe` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Id_personnage` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Description` text NOT NULL,
  UNIQUE KEY `Id_groupe` (`Id_groupe`,`Id_personnage`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `membre`
--

INSERT INTO `membre` (`Id_groupe`, `Id_personnage`, `Description`) VALUES
('GRGE-NGddgVxbybXzBRi', 'PERS-kri_wNnIdNUuXzs', 'Test Bordel'),
('GRGE-NGddgVxbybXzBRi', 'PERS-QCQSeZIThdQpLqD', 'Vraie personnalité'),
('GRHO-YUjrKXdkSfMeEHY', 'bidon', ''),
('GRGE-NGddgVxbybXzBRi', 'commun', 'Groupe 1'),
('GRHO-YUjrKXdkSfMeEHY', 'commun', 'Groupe 2');

-- --------------------------------------------------------

--
-- Structure de la table `objet`
--

DROP TABLE IF EXISTS `objet`;
CREATE TABLE IF NOT EXISTS `objet` (
  `ID_Objet` varchar(20) NOT NULL,
  `nom` varchar(200) NOT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `possesseur` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Jeu` varchar(60) NOT NULL,
  PRIMARY KEY (`ID_Objet`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `personnage`
--

DROP TABLE IF EXISTS `personnage`;
CREATE TABLE IF NOT EXISTS `personnage` (
  `ID_Personnage` varchar(20) NOT NULL,
  `ID_Reelle` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `nom` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `prenom` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `surnom` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Image` varchar(200) DEFAULT NULL COMMENT 'Lien vers l''image redimensionnée',
  `Genre` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'Type de personnage',
  `Naissance` date DEFAULT NULL,
  `Localisation` varchar(20) DEFAULT NULL,
  `Background` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `Info_public` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `Jeu` varchar(60) NOT NULL,
  UNIQUE KEY `ID_Personnage` (`ID_Personnage`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `personnage`
--

INSERT INTO `personnage` (`ID_Personnage`, `ID_Reelle`, `nom`, `prenom`, `surnom`, `Image`, `Genre`, `Naissance`, `Localisation`, `Background`, `Info_public`, `Jeu`) VALUES
('PERS-QCQSeZIThdQpLqD', NULL, 'Delaunay', 'Damien', NULL, NULL, 'humain', '1987-06-16', 'Maison', 'Trop long', 'Dev du site', 'Test'),
('PERS-kri_wNnIdNUuXzs', 'PERS-QCQSeZIThdQpLqD', NULL, NULL, 'Naimde', NULL, 'Interface', NULL, NULL, NULL, 'Cache son identité', 'Test'),
('bidon', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, ''),
('commun', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '');

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'Test-pj'),
(3, 'Test-orga'),
(4, 'Heraclyon-orga'),
(5, 'Heraclyon-pj'),
(6, 'Hahaha hohoho-pj'),
(7, 'Hahaha hohoho-orga'),
(8, 'Test2-pj'),
(9, 'Test2-orga');

-- --------------------------------------------------------

--
-- Structure de la table `secret`
--

DROP TABLE IF EXISTS `secret`;
CREATE TABLE IF NOT EXISTS `secret` (
  `ID_Secret` varchar(20) NOT NULL,
  `ID_Cible` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Description` text,
  UNIQUE KEY `ID_Secret` (`ID_Secret`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
