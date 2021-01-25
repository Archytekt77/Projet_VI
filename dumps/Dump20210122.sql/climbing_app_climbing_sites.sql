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
-- Table structure for table `climbing_sites`
--

DROP TABLE IF EXISTS `climbing_sites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `climbing_sites` (
  `id` int NOT NULL,
  `area` varchar(255) DEFAULT NULL,
  `climbing_height` int DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `max_grade` varchar(255) DEFAULT NULL,
  `min_grade` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `official` bit(1) DEFAULT NULL,
  `orientation` varchar(255) DEFAULT NULL,
  `route` int DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `topo_id` int DEFAULT NULL,
  `user_account_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK25o294m54y1l1e0pq1a8l6iss` (`topo_id`),
  KEY `FKnaiuabj91yylm223axkjtn0dh` (`user_account_id`),
  CONSTRAINT `FK25o294m54y1l1e0pq1a8l6iss` FOREIGN KEY (`topo_id`) REFERENCES `topos` (`id`),
  CONSTRAINT `FKnaiuabj91yylm223axkjtn0dh` FOREIGN KEY (`user_account_id`) REFERENCES `users_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `climbing_sites`
--

LOCK TABLES `climbing_sites` WRITE;
/*!40000 ALTER TABLE `climbing_sites` DISABLE KEYS */;
INSERT INTO `climbing_sites` VALUES (9,'Alpes',400,'2021-01-21 19:53:33','8a','3a','Ailefroide',_binary '','Toute direction',500,'Falaise','2021-01-22 13:01:22',6,1),(10,'Alpes',25,'2021-01-21 19:54:24','8c','4c','Annot',_binary '\0','Toute direction',400,'Bloc','2021-01-21 19:54:24',6,2),(11,'Pyrénées-Atlantiques',55,'2021-01-21 19:55:38','6b','3c','Arudy',_binary '\0','Sud-Ouest',230,'Falaise et Bloc','2021-01-21 19:55:38',NULL,2),(19,'Alpes',350,'2021-01-21 21:41:36','9c','3','Le Verdon',_binary '\0','Toute direction',1500,'Falaise','2021-01-21 21:41:36',8,3),(20,'Alpes',250,'2021-01-21 21:42:45','6b','5b','Les aiguilles rouges',_binary '\0','Nord',30,'Falaise','2021-01-21 21:42:45',8,3),(21,'Jura',30,'2021-01-21 21:45:12','7','3c','Venasque',_binary '\0','Nord-Est',47,'Bloc','2021-01-21 21:45:12',7,3),(22,'Pyrénées-Atlantiques',30,'2021-01-21 21:46:06','7b','5c','Vallouise - Falaise de la gorge',_binary '\0','Nord-Est',22,'Falaise','2021-01-21 21:46:06',NULL,3);
/*!40000 ALTER TABLE `climbing_sites` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-25 16:46:06
