CREATE DATABASE  IF NOT EXISTS `climbing_app` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `climbing_app`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: climbing_app
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `topos`
--

DROP TABLE IF EXISTS `topos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topos` (
  `id` int NOT NULL,
  `available` bit(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `place` varchar(255) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `user_account_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6xecelcy0asja00svka502a5v` (`user_account_id`),
  CONSTRAINT `FK6xecelcy0asja00svka502a5v` FOREIGN KEY (`user_account_id`) REFERENCES `users_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topos`
--

LOCK TABLES `topos` WRITE;
/*!40000 ALTER TABLE `topos` DISABLE KEYS */;
INSERT INTO `topos` VALUES (4,_binary '','2021-01-21 19:36:27','Sortez des sentiers battus! Le topo TOP SECRET de Fontainebleau recense 60 sites d\'escalade de blocs très variés mais plus difficiles d\'accès. Un incontournable pour tous les Bleausards avertis, en quête de problèmes sur un grès d\'une superbe qualité qu\'il faudra nettoyer soigneusement avant d\'entamer sa journée.','Fontainebleau top secret','Fontainebleau','2021-01-21 19:36:27',1),(5,_binary '','2021-01-21 19:39:40','Découvrez ce terrain de jeux grâce au topo FUN BLOC, incontournable pour tous les grimpeurs débutants et initiés. Les blocs sont photographiés et le guide comprend des vues aériennes qui facilitent le repérage des blocs dans chaque secteur. À l\'intérieur, vous trouverez 24 sites majeurs, 7000 blocs illustrés, 17 circuits enfants et des circuits jaunes pour les débutants. Pour les plus experts d\'entre vous, n\'ayez crainte... Les cotations vont jusqu\'au 7b+ !','Fontainebleau fun bloc','Fontainebleau','2021-01-21 19:39:40',1),(6,_binary '','2021-01-21 19:43:52','La troisième édition de cet ouvrage, à sa parution, un franc succès pour son originalité, a été augmentée de manière drastique, afin d’offrir aux grimpeurs le meilleur des sites d’escalade de la région concernée. Les 206 «grandes voies» présentées ici – contre 190 dans la précédente édition – exclusivement rocheuses et faciles d’accès, offrent toutes au grimpeur l’opportunité de s’engager dans des terrains bien adaptés à son propre niveau et, du coup, de progresser en sécurité.','Escalade plaisir Alpes du nord','Alpes','2021-01-21 19:43:52',1),(7,_binary '\0','2021-01-21 19:49:37','Voici la nouvelle édition du topo Jura !  27 sites ainsi que deux via ferrata pour quasiment 1000 voies sont répertoriées au long de ces 300 pages de façon précise :\r\n\r\n– carte de tous les sites au sommaire\r\n– présentation de la faune, flore et géologie jurassienne\r\n– Itinéraire sur photo\r\n– temps de marche d\'approche et dénivelé\r\n– Hauteur des secteurs\r\n– Période favorable pour pratiquer','Topo du Jura','Jura','2021-01-21 19:49:37',2),(8,_binary '','2021-01-21 19:51:54','Ce topoguide rédigé par Rémy Karle, guide de haute montagne, présente les voies du secret massif du Valgaudemar sous forme de croquis réalisés à partir de photos. Tous les points caractéristiques ont été relevés minutieusement : refuges, accès, équipement, recommandations, matériel à emporter, horaires recommandés, description de la descente. Bref, un condensé d\'informations cruciales pour préparer vos grandes voies alpines ! ','Escalades en Valgaudemar','Alpes','2021-01-21 19:52:22',2);
/*!40000 ALTER TABLE `topos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-25 16:46:07
