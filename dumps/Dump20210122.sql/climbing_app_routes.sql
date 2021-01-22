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
-- Table structure for table `routes`
--

DROP TABLE IF EXISTS `routes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `routes` (
  `id` int NOT NULL,
  `create_date` datetime NOT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `pitch` int DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `climbing_site_id` int DEFAULT NULL,
  `user_account_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6en50vcvdnka5ubwi5f11dgtr` (`climbing_site_id`),
  KEY `FKgij6ue7mt5mpqs0h4foc705lq` (`user_account_id`),
  CONSTRAINT `FK6en50vcvdnka5ubwi5f11dgtr` FOREIGN KEY (`climbing_site_id`) REFERENCES `climbing_sites` (`id`),
  CONSTRAINT `FKgij6ue7mt5mpqs0h4foc705lq` FOREIGN KEY (`user_account_id`) REFERENCES `users_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `routes`
--

LOCK TABLES `routes` WRITE;
/*!40000 ALTER TABLE `routes` DISABLE KEYS */;
INSERT INTO `routes` VALUES (12,'2021-01-21 19:57:44','4b','1',5,'2021-01-21 19:57:44',11,2),(13,'2021-01-21 19:58:36','5b','2',2,'2021-01-21 19:58:36',11,2),(14,'2021-01-21 19:59:05','6','3',12,'2021-01-21 19:59:05',11,2),(23,'2021-01-21 21:47:13','6c','22',10,'2021-01-21 21:47:13',22,3),(24,'2021-01-21 21:48:32','6b','22',20,'2021-01-21 21:51:36',20,3);
/*!40000 ALTER TABLE `routes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-22 15:39:39
