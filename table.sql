-- MySQL dump 10.13  Distrib 5.6.37, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: loan_my_db
-- ------------------------------------------------------
-- Server version	5.6.37-log

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
-- Table structure for table `loan_offer`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loan_offer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bank_name` varchar(256) DEFAULT NULL,
  `offer_name` varchar(256) DEFAULT NULL,
  `max_amount` bigint(20) DEFAULT NULL,
  `max_duration` int(11) DEFAULT NULL,
  `interest_rate` int(11) DEFAULT NULL,
  `currency` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loan_offer`
--

/*!40000 ALTER TABLE `loan_offer` DISABLE KEYS */;
INSERT INTO `loan_offer` VALUES (2,'PrivatBank','Mortgage 1M 360/10',1000000,360,10,'UAH');
INSERT INTO `loan_offer` VALUES (3,'PrivatBank','Mortgage 1M 120/8',1000000,120,10,'UAH');
INSERT INTO `loan_offer` VALUES (4,'PrivatBank','Mortgage 1M 60/7 D',1000000,60,7,'USD');
INSERT INTO `loan_offer` VALUES (5,'PrivatBank','Mortgage 1M 12/5 D',1000000,12,5,'USD');
INSERT INTO `loan_offer` VALUES (6,'PrivatBank','Mortgage 100K 360/12',100000,360,12,'UAH');
INSERT INTO `loan_offer` VALUES (7,'PrivatBank','Mortgage 100K 120/15',100000,120,15,'UAH');
INSERT INTO `loan_offer` VALUES (8,'PrivatBank','Mortgage 100K 96/10 E',100000,96,10,'EUR');
INSERT INTO `loan_offer` VALUES (9,'PrivatBank','Mortgage 50K 240/12 E',50000,240,12,'EUR');
INSERT INTO `loan_offer` VALUES (10,'PrivatBank','Mortgage 50K 120/9 D',50000,120,9,'USD');
INSERT INTO `loan_offer` VALUES (11,'Ukrgasbank','Mortgage 1M 120/1 D',1000000,120,1,'USD');
INSERT INTO `loan_offer` VALUES (12,'Ukrgasbank','Mortgage 1M 60/2 D',1000000,60,2,'USD');
INSERT INTO `loan_offer` VALUES (13,'Ukrgasbank','Mortgage 1M 12/3 D',1000000,12,3,'USD');
INSERT INTO `loan_offer` VALUES (14,'Ukrgasbank','Mortgage 100K 360/4',100000,360,4,'UAH');
INSERT INTO `loan_offer` VALUES (15,'Ukrgasbank','Mortgage 100K 120/5',100000,120,5,'UAH');
INSERT INTO `loan_offer` VALUES (16,'Ukrgasbank','Mortgage 100K 96/6 E',100000,96,6,'EUR');
INSERT INTO `loan_offer` VALUES (17,'Ukrgasbank','Mortgage 50K 240/7 E',50000,240,7,'EUR');
INSERT INTO `loan_offer` VALUES (18,'Ukrgasbank','Mortgage 50K 120/8 D',50000,120,8,'USD');
INSERT INTO `loan_offer` VALUES (19,'Ukrgasbank','Car 100K 60/4',100000,60,4,'UAH');
INSERT INTO `loan_offer` VALUES (20,'Ukrgasbank','Car 100K 36/5',100000,36,5,'UAH');
INSERT INTO `loan_offer` VALUES (21,'Ukrgasbank','Car 100K 60/6 E',100000,60,6,'EUR');
INSERT INTO `loan_offer` VALUES (22,'Ukrgasbank','Car 50K 36/7 E',50000,36,7,'EUR');
INSERT INTO `loan_offer` VALUES (23,'Ukrgasbank','Car 50K 72/8 D',50000,72,8,'USD');
/*!40000 ALTER TABLE `loan_offer` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-16 22:44:07
