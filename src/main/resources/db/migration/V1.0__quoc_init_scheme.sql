-- MySQL dump 10.13  Distrib 8.0.20, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: c04piggy
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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `deleted` tinyint NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `password` varchar(250) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cote`
--

DROP TABLE IF EXISTS `cote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cote` (
  `id` int NOT NULL AUTO_INCREMENT,
  `deleted` tinyint NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `export_date` date DEFAULT NULL,
  `import_date` date DEFAULT NULL,
  `quantity` int NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `employee_id` int DEFAULT NULL,
  `herd_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbo15t1hbxljhdnsp4o34aju76` (`employee_id`),
  KEY `FKskt2w3b9dervqchjxm3nuqmmn` (`herd_id`),
  CONSTRAINT `FKbo15t1hbxljhdnsp4o34aju76` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `FKskt2w3b9dervqchjxm3nuqmmn` FOREIGN KEY (`herd_id`) REFERENCES `herd` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `diseases`
--

DROP TABLE IF EXISTS `diseases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diseases` (
  `id` int NOT NULL AUTO_INCREMENT,
  `deleted` tinyint NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `deleted` tinyint NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `card_id` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` tinyint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `account_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcfg6ajo8oske94exynxpf7tf9` (`account_id`),
  CONSTRAINT `FKcfg6ajo8oske94exynxpf7tf9` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `feed`
--

DROP TABLE IF EXISTS `feed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feed` (
  `id` int NOT NULL AUTO_INCREMENT,
  `deleted` tinyint NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `amount` int NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `feed_type_id` int DEFAULT NULL,
  `herd_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn5qw8fi17p394j87es18umx8s` (`feed_type_id`),
  KEY `FKa0cll8pbl7ldoubd1yletd3nj` (`herd_id`),
  CONSTRAINT `FKa0cll8pbl7ldoubd1yletd3nj` FOREIGN KEY (`herd_id`) REFERENCES `herd` (`id`),
  CONSTRAINT `FKn5qw8fi17p394j87es18umx8s` FOREIGN KEY (`feed_type_id`) REFERENCES `feed_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `feed_type`
--

DROP TABLE IF EXISTS `feed_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feed_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `deleted` tinyint NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `herd`
--

DROP TABLE IF EXISTS `herd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `herd` (
  `id` int NOT NULL AUTO_INCREMENT,
  `deleted` tinyint NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `history_export`
--

DROP TABLE IF EXISTS `history_export`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `history_export` (
  `id` int NOT NULL AUTO_INCREMENT,
  `deleted` tinyint NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `export_date` date DEFAULT NULL,
  `quantity` int NOT NULL,
  `received_employee_id` int NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `cote_id` int DEFAULT NULL,
  `employee_id` int DEFAULT NULL,
  `stock_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2sw9wtop5ovr1qun1pawuydym` (`cote_id`),
  KEY `FKpqhqfbojm2xi8uertvpq8iy94` (`employee_id`),
  KEY `FKt75co5dlw6n32qj9r3ur36bdr` (`stock_id`),
  CONSTRAINT `FK2sw9wtop5ovr1qun1pawuydym` FOREIGN KEY (`cote_id`) REFERENCES `cote` (`id`),
  CONSTRAINT `FKpqhqfbojm2xi8uertvpq8iy94` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `FKt75co5dlw6n32qj9r3ur36bdr` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notification` (
  `id` int NOT NULL AUTO_INCREMENT,
  `deleted` tinyint NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `employee_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK858apfribgisso7wslgvebtxy` (`employee_id`),
  CONSTRAINT `FK858apfribgisso7wslgvebtxy` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `other`
--

DROP TABLE IF EXISTS `other`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `other` (
  `id` int NOT NULL AUTO_INCREMENT,
  `deleted` tinyint NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `is_other` tinyint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `ref_id` int NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `deleted` tinyint NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pig`
--

DROP TABLE IF EXISTS `pig`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pig` (
  `id` int NOT NULL AUTO_INCREMENT,
  `deleted` tinyint NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `export_date` date DEFAULT NULL,
  `father_id` int NOT NULL,
  `gender` tinyint NOT NULL,
  `import_date` date DEFAULT NULL,
  `mother_id` int NOT NULL,
  `spec` varchar(255) DEFAULT NULL,
  `weight` double NOT NULL,
  `cote_id` int DEFAULT NULL,
  `feed_id` int DEFAULT NULL,
  `herd_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgyh363gwge4wc4hk29xq4ywal` (`cote_id`),
  KEY `FK4xf9hfu7bycr8vqe5rdu5hext` (`feed_id`),
  KEY `FK5o39ffkph9gyd7e9d5r5xll8q` (`herd_id`),
  CONSTRAINT `FK4xf9hfu7bycr8vqe5rdu5hext` FOREIGN KEY (`feed_id`) REFERENCES `feed` (`id`),
  CONSTRAINT `FK5o39ffkph9gyd7e9d5r5xll8q` FOREIGN KEY (`herd_id`) REFERENCES `herd` (`id`),
  CONSTRAINT `FKgyh363gwge4wc4hk29xq4ywal` FOREIGN KEY (`cote_id`) REFERENCES `cote` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pig_associate_status`
--

DROP TABLE IF EXISTS `pig_associate_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pig_associate_status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `deleted` tinyint NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `pig_id` int DEFAULT NULL,
  `pig_status_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqfx09cco6npn7qiav9pa91u0` (`pig_id`),
  KEY `FK861qioj2pf44usg4ranyp6spj` (`pig_status_id`),
  CONSTRAINT `FK861qioj2pf44usg4ranyp6spj` FOREIGN KEY (`pig_status_id`) REFERENCES `pig_status` (`id`),
  CONSTRAINT `FKqfx09cco6npn7qiav9pa91u0` FOREIGN KEY (`pig_id`) REFERENCES `pig` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pig_status`
--

DROP TABLE IF EXISTS `pig_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pig_status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `deleted` tinyint NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `deleted` tinyint NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `role_account`
--

DROP TABLE IF EXISTS `role_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `deleted` tinyint NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `account_id` int DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbw44l0j93wl6fcbnukbfigrdq` (`account_id`),
  KEY `FK7n3rlpv8lyj1ut19752o57q4i` (`role_id`),
  CONSTRAINT `FK7n3rlpv8lyj1ut19752o57q4i` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKbw44l0j93wl6fcbnukbfigrdq` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `role_permission`
--

DROP TABLE IF EXISTS `role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `deleted` tinyint NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `permission_id` int DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKf8yllw1ecvwqy3ehyxawqa1qp` (`permission_id`),
  KEY `FKa6jx8n8xkesmjmv6jqug6bg68` (`role_id`),
  CONSTRAINT `FKa6jx8n8xkesmjmv6jqug6bg68` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKf8yllw1ecvwqy3ehyxawqa1qp` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock` (
  `id` int NOT NULL AUTO_INCREMENT,
  `deleted` tinyint NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `exp_date` date DEFAULT NULL,
  `import_date` date DEFAULT NULL,
  `mfg_date` date DEFAULT NULL,
  `quantity` int NOT NULL,
  `shipment_code` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `feed_type_id` int DEFAULT NULL,
  `vendor_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo0blk7rtd1jvyest5y8rchpr3` (`feed_type_id`),
  KEY `FKnca0v6cb87ypaqfj7ufh4ec23` (`vendor_id`),
  CONSTRAINT `FKnca0v6cb87ypaqfj7ufh4ec23` FOREIGN KEY (`vendor_id`) REFERENCES `vendor` (`id`),
  CONSTRAINT `FKo0blk7rtd1jvyest5y8rchpr3` FOREIGN KEY (`feed_type_id`) REFERENCES `feed_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `treatment_vacxin`
--

DROP TABLE IF EXISTS `treatment_vacxin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `treatment_vacxin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `deleted` tinyint NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `treat_date` date DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `veterinary` varchar(255) DEFAULT NULL,
  `cote_id` int DEFAULT NULL,
  `diseases_id` int DEFAULT NULL,
  `pig_id` int DEFAULT NULL,
  `vacxin_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7jqfv1mdd5a3yd9vm38x0e3u2` (`cote_id`),
  KEY `FKj2os4jtsxutgxgtxrkfxjdktm` (`diseases_id`),
  KEY `FKa017cp152sjwniguvf8y3tnme` (`pig_id`),
  KEY `FK6itbfdkef49tsjlblme79c4mw` (`vacxin_id`),
  CONSTRAINT `FK6itbfdkef49tsjlblme79c4mw` FOREIGN KEY (`vacxin_id`) REFERENCES `vacxin` (`id`),
  CONSTRAINT `FK7jqfv1mdd5a3yd9vm38x0e3u2` FOREIGN KEY (`cote_id`) REFERENCES `cote` (`id`),
  CONSTRAINT `FKa017cp152sjwniguvf8y3tnme` FOREIGN KEY (`pig_id`) REFERENCES `pig` (`id`),
  CONSTRAINT `FKj2os4jtsxutgxgtxrkfxjdktm` FOREIGN KEY (`diseases_id`) REFERENCES `diseases` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `vacxin`
--

DROP TABLE IF EXISTS `vacxin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vacxin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `deleted` tinyint NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `vendor`
--

DROP TABLE IF EXISTS `vendor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `deleted` tinyint NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-06 16:46:17
