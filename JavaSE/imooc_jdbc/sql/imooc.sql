-- MySQL dump 10.13  Distrib 5.6.25, for osx10.8 (x86_64)
--
-- Host: localhost    Database: imooc_db
-- ------------------------------------------------------
-- Server version	5.6.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account_info`
--

DROP TABLE IF EXISTS `account_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) NOT NULL,
  `amount` double(18,2) NOT NULL DEFAULT '0.00',
  `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_info`
--

LOCK TABLES `account_info` WRITE;
/*!40000 ALTER TABLE `account_info` DISABLE KEYS */;
INSERT INTO `account_info` VALUES (1,'a',230.00,'2015-08-24 08:28:36'),(2,'maket',20.00,'2015-08-24 08:28:37');
/*!40000 ALTER TABLE `account_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trans_info`
--

DROP TABLE IF EXISTS `trans_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trans_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `source_id` int(11) NOT NULL,
  `source_account` varchar(20) NOT NULL,
  `destination_id` int(11) NOT NULL,
  `destination_account` varchar(20) NOT NULL,
  `amount` double(18,2) NOT NULL DEFAULT '0.00',
  `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trans_info`
--

LOCK TABLES `trans_info` WRITE;
/*!40000 ALTER TABLE `trans_info` DISABLE KEYS */;
INSERT INTO `trans_info` VALUES (16,1,'a',2,'maket',20.00,'2015-11-12 09:24:09');
/*!40000 ALTER TABLE `trans_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-01-29 15:35:40
