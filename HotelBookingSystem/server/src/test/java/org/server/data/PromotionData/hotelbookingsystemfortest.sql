-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hotelbookingsystemfortest
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `00001`
--

DROP TABLE IF EXISTS `00001`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00001` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00001`
--

LOCK TABLES `00001` WRITE;
/*!40000 ALTER TABLE `00001` DISABLE KEYS */;
INSERT INTO `00001` VALUES ('单人间',28,120),('标间',15,220),('套间',4,350);
/*!40000 ALTER TABLE `00001` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00002`
--

DROP TABLE IF EXISTS `00002`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00002` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00002`
--

LOCK TABLES `00002` WRITE;
/*!40000 ALTER TABLE `00002` DISABLE KEYS */;
INSERT INTO `00002` VALUES ('单人间',33,130),('标间',18,250),('套间',6,380);
/*!40000 ALTER TABLE `00002` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00003`
--

DROP TABLE IF EXISTS `00003`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00003` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00003`
--

LOCK TABLES `00003` WRITE;
/*!40000 ALTER TABLE `00003` DISABLE KEYS */;
INSERT INTO `00003` VALUES ('单人间',19,110),('标间',12,200),('套间',3,300);
/*!40000 ALTER TABLE `00003` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00004`
--

DROP TABLE IF EXISTS `00004`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00004` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00004`
--

LOCK TABLES `00004` WRITE;
/*!40000 ALTER TABLE `00004` DISABLE KEYS */;
INSERT INTO `00004` VALUES ('单人间',36,120),('标间',14,220),('套间',6,350);
/*!40000 ALTER TABLE `00004` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00005`
--

DROP TABLE IF EXISTS `00005`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00005` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00005`
--

LOCK TABLES `00005` WRITE;
/*!40000 ALTER TABLE `00005` DISABLE KEYS */;
INSERT INTO `00005` VALUES ('单人间',25,120),('标间',16,220),('套间',7,350);
/*!40000 ALTER TABLE `00005` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00006`
--

DROP TABLE IF EXISTS `00006`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00006` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00006`
--

LOCK TABLES `00006` WRITE;
/*!40000 ALTER TABLE `00006` DISABLE KEYS */;
INSERT INTO `00006` VALUES ('单人间',18,120),('标间',15,220),('套间',5,350);
/*!40000 ALTER TABLE `00006` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00007`
--

DROP TABLE IF EXISTS `00007`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00007` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00007`
--

LOCK TABLES `00007` WRITE;
/*!40000 ALTER TABLE `00007` DISABLE KEYS */;
INSERT INTO `00007` VALUES ('单人间',21,120),('标间',12,220),('套间',7,350);
/*!40000 ALTER TABLE `00007` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00008`
--

DROP TABLE IF EXISTS `00008`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00008` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00008`
--

LOCK TABLES `00008` WRITE;
/*!40000 ALTER TABLE `00008` DISABLE KEYS */;
INSERT INTO `00008` VALUES ('单人间',20,120),('标间',15,220),('套间',7,350);
/*!40000 ALTER TABLE `00008` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00009`
--

DROP TABLE IF EXISTS `00009`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00009` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00009`
--

LOCK TABLES `00009` WRITE;
/*!40000 ALTER TABLE `00009` DISABLE KEYS */;
INSERT INTO `00009` VALUES ('单人间',21,120),('标间',12,220),('套间',5,350);
/*!40000 ALTER TABLE `00009` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00010`
--

DROP TABLE IF EXISTS `00010`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00010` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00010`
--

LOCK TABLES `00010` WRITE;
/*!40000 ALTER TABLE `00010` DISABLE KEYS */;
INSERT INTO `00010` VALUES ('单人间',39,120),('标间',10,220),('套间',6,350);
/*!40000 ALTER TABLE `00010` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00011`
--

DROP TABLE IF EXISTS `00011`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00011` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00011`
--

LOCK TABLES `00011` WRITE;
/*!40000 ALTER TABLE `00011` DISABLE KEYS */;
INSERT INTO `00011` VALUES ('单人间',16,120),('标间',11,220),('套间',5,350);
/*!40000 ALTER TABLE `00011` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00012`
--

DROP TABLE IF EXISTS `00012`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00012` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00012`
--

LOCK TABLES `00012` WRITE;
/*!40000 ALTER TABLE `00012` DISABLE KEYS */;
INSERT INTO `00012` VALUES ('单人间',25,120),('标间',12,220),('套间',4,350);
/*!40000 ALTER TABLE `00012` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00013`
--

DROP TABLE IF EXISTS `00013`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00013` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00013`
--

LOCK TABLES `00013` WRITE;
/*!40000 ALTER TABLE `00013` DISABLE KEYS */;
INSERT INTO `00013` VALUES ('单人间',30,120),('标间',10,220),('套间',5,350);
/*!40000 ALTER TABLE `00013` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00014`
--

DROP TABLE IF EXISTS `00014`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00014` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00014`
--

LOCK TABLES `00014` WRITE;
/*!40000 ALTER TABLE `00014` DISABLE KEYS */;
INSERT INTO `00014` VALUES ('单人间',24,120),('标间',11,220),('套间',7,350);
/*!40000 ALTER TABLE `00014` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00015`
--

DROP TABLE IF EXISTS `00015`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00015` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00015`
--

LOCK TABLES `00015` WRITE;
/*!40000 ALTER TABLE `00015` DISABLE KEYS */;
INSERT INTO `00015` VALUES ('单人间',37,120),('标间',17,220),('套间',3,350);
/*!40000 ALTER TABLE `00015` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00016`
--

DROP TABLE IF EXISTS `00016`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00016` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00016`
--

LOCK TABLES `00016` WRITE;
/*!40000 ALTER TABLE `00016` DISABLE KEYS */;
INSERT INTO `00016` VALUES ('单人间',37,120),('标间',12,220),('套间',6,350);
/*!40000 ALTER TABLE `00016` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00017`
--

DROP TABLE IF EXISTS `00017`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00017` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00017`
--

LOCK TABLES `00017` WRITE;
/*!40000 ALTER TABLE `00017` DISABLE KEYS */;
INSERT INTO `00017` VALUES ('单人间',34,120),('标间',16,220),('套间',7,350);
/*!40000 ALTER TABLE `00017` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00018`
--

DROP TABLE IF EXISTS `00018`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00018` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00018`
--

LOCK TABLES `00018` WRITE;
/*!40000 ALTER TABLE `00018` DISABLE KEYS */;
INSERT INTO `00018` VALUES ('单人间',36,120),('标间',12,220),('套间',7,350);
/*!40000 ALTER TABLE `00018` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00019`
--

DROP TABLE IF EXISTS `00019`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00019` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00019`
--

LOCK TABLES `00019` WRITE;
/*!40000 ALTER TABLE `00019` DISABLE KEYS */;
INSERT INTO `00019` VALUES ('单人间',30,120),('标间',11,220),('套间',4,350);
/*!40000 ALTER TABLE `00019` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00020`
--

DROP TABLE IF EXISTS `00020`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00020` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00020`
--

LOCK TABLES `00020` WRITE;
/*!40000 ALTER TABLE `00020` DISABLE KEYS */;
INSERT INTO `00020` VALUES ('单人间',39,120),('标间',17,220),('套间',7,350);
/*!40000 ALTER TABLE `00020` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00021`
--

DROP TABLE IF EXISTS `00021`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00021` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00021`
--

LOCK TABLES `00021` WRITE;
/*!40000 ALTER TABLE `00021` DISABLE KEYS */;
INSERT INTO `00021` VALUES ('单人间',38,120),('标间',11,220),('套间',7,350);
/*!40000 ALTER TABLE `00021` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00022`
--

DROP TABLE IF EXISTS `00022`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00022` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00022`
--

LOCK TABLES `00022` WRITE;
/*!40000 ALTER TABLE `00022` DISABLE KEYS */;
INSERT INTO `00022` VALUES ('单人间',35,120),('标间',14,220),('套间',3,350);
/*!40000 ALTER TABLE `00022` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00023`
--

DROP TABLE IF EXISTS `00023`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00023` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00023`
--

LOCK TABLES `00023` WRITE;
/*!40000 ALTER TABLE `00023` DISABLE KEYS */;
INSERT INTO `00023` VALUES ('单人间',34,120),('标间',15,220),('套间',6,350);
/*!40000 ALTER TABLE `00023` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00024`
--

DROP TABLE IF EXISTS `00024`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00024` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00024`
--

LOCK TABLES `00024` WRITE;
/*!40000 ALTER TABLE `00024` DISABLE KEYS */;
INSERT INTO `00024` VALUES ('单人间',24,120),('标间',16,220),('套间',4,350);
/*!40000 ALTER TABLE `00024` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00025`
--

DROP TABLE IF EXISTS `00025`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00025` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00025`
--

LOCK TABLES `00025` WRITE;
/*!40000 ALTER TABLE `00025` DISABLE KEYS */;
INSERT INTO `00025` VALUES ('单人间',25,120),('标间',10,220),('套间',3,350);
/*!40000 ALTER TABLE `00025` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00026`
--

DROP TABLE IF EXISTS `00026`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00026` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00026`
--

LOCK TABLES `00026` WRITE;
/*!40000 ALTER TABLE `00026` DISABLE KEYS */;
INSERT INTO `00026` VALUES ('单人间',30,120),('标间',14,220),('套间',5,350);
/*!40000 ALTER TABLE `00026` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00027`
--

DROP TABLE IF EXISTS `00027`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00027` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00027`
--

LOCK TABLES `00027` WRITE;
/*!40000 ALTER TABLE `00027` DISABLE KEYS */;
INSERT INTO `00027` VALUES ('单人间',36,120),('标间',18,220),('套间',6,350);
/*!40000 ALTER TABLE `00027` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00028`
--

DROP TABLE IF EXISTS `00028`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00028` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00028`
--

LOCK TABLES `00028` WRITE;
/*!40000 ALTER TABLE `00028` DISABLE KEYS */;
INSERT INTO `00028` VALUES ('单人间',37,120),('标间',13,220),('套间',3,350);
/*!40000 ALTER TABLE `00028` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00029`
--

DROP TABLE IF EXISTS `00029`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00029` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00029`
--

LOCK TABLES `00029` WRITE;
/*!40000 ALTER TABLE `00029` DISABLE KEYS */;
INSERT INTO `00029` VALUES ('单人间',33,120),('标间',10,220),('套间',4,350);
/*!40000 ALTER TABLE `00029` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00030`
--

DROP TABLE IF EXISTS `00030`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00030` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00030`
--

LOCK TABLES `00030` WRITE;
/*!40000 ALTER TABLE `00030` DISABLE KEYS */;
INSERT INTO `00030` VALUES ('单人间',19,120),('标间',17,220),('套间',6,350);
/*!40000 ALTER TABLE `00030` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00031`
--

DROP TABLE IF EXISTS `00031`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00031` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00031`
--

LOCK TABLES `00031` WRITE;
/*!40000 ALTER TABLE `00031` DISABLE KEYS */;
INSERT INTO `00031` VALUES ('单人间',34,120),('标间',17,220),('套间',6,350);
/*!40000 ALTER TABLE `00031` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00032`
--

DROP TABLE IF EXISTS `00032`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00032` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00032`
--

LOCK TABLES `00032` WRITE;
/*!40000 ALTER TABLE `00032` DISABLE KEYS */;
INSERT INTO `00032` VALUES ('单人间',23,120),('标间',13,220),('套间',6,350);
/*!40000 ALTER TABLE `00032` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00033`
--

DROP TABLE IF EXISTS `00033`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00033` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00033`
--

LOCK TABLES `00033` WRITE;
/*!40000 ALTER TABLE `00033` DISABLE KEYS */;
INSERT INTO `00033` VALUES ('单人间',21,120),('标间',12,220),('套间',5,350);
/*!40000 ALTER TABLE `00033` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00034`
--

DROP TABLE IF EXISTS `00034`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00034` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00034`
--

LOCK TABLES `00034` WRITE;
/*!40000 ALTER TABLE `00034` DISABLE KEYS */;
INSERT INTO `00034` VALUES ('单人间',39,120),('标间',17,220),('套间',3,350);
/*!40000 ALTER TABLE `00034` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00035`
--

DROP TABLE IF EXISTS `00035`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00035` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00035`
--

LOCK TABLES `00035` WRITE;
/*!40000 ALTER TABLE `00035` DISABLE KEYS */;
INSERT INTO `00035` VALUES ('单人间',21,120),('标间',13,220),('套间',7,350);
/*!40000 ALTER TABLE `00035` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00036`
--

DROP TABLE IF EXISTS `00036`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00036` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00036`
--

LOCK TABLES `00036` WRITE;
/*!40000 ALTER TABLE `00036` DISABLE KEYS */;
INSERT INTO `00036` VALUES ('单人间',18,120),('标间',11,220),('套间',5,350);
/*!40000 ALTER TABLE `00036` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00037`
--

DROP TABLE IF EXISTS `00037`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00037` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00037`
--

LOCK TABLES `00037` WRITE;
/*!40000 ALTER TABLE `00037` DISABLE KEYS */;
INSERT INTO `00037` VALUES ('单人间',37,120),('标间',18,220),('套间',7,350);
/*!40000 ALTER TABLE `00037` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00038`
--

DROP TABLE IF EXISTS `00038`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00038` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00038`
--

LOCK TABLES `00038` WRITE;
/*!40000 ALTER TABLE `00038` DISABLE KEYS */;
INSERT INTO `00038` VALUES ('单人间',27,120),('标间',17,220),('套间',5,350);
/*!40000 ALTER TABLE `00038` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00039`
--

DROP TABLE IF EXISTS `00039`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00039` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00039`
--

LOCK TABLES `00039` WRITE;
/*!40000 ALTER TABLE `00039` DISABLE KEYS */;
INSERT INTO `00039` VALUES ('单人间',29,120),('标间',19,220),('套间',3,350);
/*!40000 ALTER TABLE `00039` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00040`
--

DROP TABLE IF EXISTS `00040`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00040` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00040`
--

LOCK TABLES `00040` WRITE;
/*!40000 ALTER TABLE `00040` DISABLE KEYS */;
INSERT INTO `00040` VALUES ('单人间',16,120),('标间',15,220),('套间',6,350);
/*!40000 ALTER TABLE `00040` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00041`
--

DROP TABLE IF EXISTS `00041`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00041` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00041`
--

LOCK TABLES `00041` WRITE;
/*!40000 ALTER TABLE `00041` DISABLE KEYS */;
INSERT INTO `00041` VALUES ('单人间',30,120),('标间',10,220),('套间',4,350);
/*!40000 ALTER TABLE `00041` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00042`
--

DROP TABLE IF EXISTS `00042`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00042` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00042`
--

LOCK TABLES `00042` WRITE;
/*!40000 ALTER TABLE `00042` DISABLE KEYS */;
INSERT INTO `00042` VALUES ('单人间',27,120),('标间',13,220),('套间',5,350);
/*!40000 ALTER TABLE `00042` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00043`
--

DROP TABLE IF EXISTS `00043`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00043` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00043`
--

LOCK TABLES `00043` WRITE;
/*!40000 ALTER TABLE `00043` DISABLE KEYS */;
INSERT INTO `00043` VALUES ('单人间',34,120),('标间',10,220),('套间',6,350);
/*!40000 ALTER TABLE `00043` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00044`
--

DROP TABLE IF EXISTS `00044`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00044` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00044`
--

LOCK TABLES `00044` WRITE;
/*!40000 ALTER TABLE `00044` DISABLE KEYS */;
INSERT INTO `00044` VALUES ('单人间',35,120),('标间',16,220),('套间',7,350);
/*!40000 ALTER TABLE `00044` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00045`
--

DROP TABLE IF EXISTS `00045`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00045` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00045`
--

LOCK TABLES `00045` WRITE;
/*!40000 ALTER TABLE `00045` DISABLE KEYS */;
INSERT INTO `00045` VALUES ('单人间',35,120),('标间',19,220),('套间',5,350);
/*!40000 ALTER TABLE `00045` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00046`
--

DROP TABLE IF EXISTS `00046`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00046` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00046`
--

LOCK TABLES `00046` WRITE;
/*!40000 ALTER TABLE `00046` DISABLE KEYS */;
INSERT INTO `00046` VALUES ('单人间',31,120),('标间',15,220),('套间',7,350);
/*!40000 ALTER TABLE `00046` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00047`
--

DROP TABLE IF EXISTS `00047`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00047` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00047`
--

LOCK TABLES `00047` WRITE;
/*!40000 ALTER TABLE `00047` DISABLE KEYS */;
INSERT INTO `00047` VALUES ('单人间',30,120),('标间',14,220),('套间',5,350);
/*!40000 ALTER TABLE `00047` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00048`
--

DROP TABLE IF EXISTS `00048`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00048` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00048`
--

LOCK TABLES `00048` WRITE;
/*!40000 ALTER TABLE `00048` DISABLE KEYS */;
INSERT INTO `00048` VALUES ('单人间',34,120),('标间',15,220),('套间',5,350);
/*!40000 ALTER TABLE `00048` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00049`
--

DROP TABLE IF EXISTS `00049`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00049` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00049`
--

LOCK TABLES `00049` WRITE;
/*!40000 ALTER TABLE `00049` DISABLE KEYS */;
INSERT INTO `00049` VALUES ('单人间',35,120),('标间',14,220),('套间',3,350);
/*!40000 ALTER TABLE `00049` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00050`
--

DROP TABLE IF EXISTS `00050`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00050` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00050`
--

LOCK TABLES `00050` WRITE;
/*!40000 ALTER TABLE `00050` DISABLE KEYS */;
INSERT INTO `00050` VALUES ('单人间',32,120),('标间',12,220),('套间',5,350);
/*!40000 ALTER TABLE `00050` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00051`
--

DROP TABLE IF EXISTS `00051`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00051` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00051`
--

LOCK TABLES `00051` WRITE;
/*!40000 ALTER TABLE `00051` DISABLE KEYS */;
INSERT INTO `00051` VALUES ('单人间',21,120),('标间',18,220),('套间',6,350);
/*!40000 ALTER TABLE `00051` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00052`
--

DROP TABLE IF EXISTS `00052`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00052` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00052`
--

LOCK TABLES `00052` WRITE;
/*!40000 ALTER TABLE `00052` DISABLE KEYS */;
INSERT INTO `00052` VALUES ('单人间',40,120),('标间',17,220),('套间',6,350);
/*!40000 ALTER TABLE `00052` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00053`
--

DROP TABLE IF EXISTS `00053`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00053` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00053`
--

LOCK TABLES `00053` WRITE;
/*!40000 ALTER TABLE `00053` DISABLE KEYS */;
INSERT INTO `00053` VALUES ('单人间',24,120),('标间',16,220),('套间',3,350);
/*!40000 ALTER TABLE `00053` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00054`
--

DROP TABLE IF EXISTS `00054`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00054` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00054`
--

LOCK TABLES `00054` WRITE;
/*!40000 ALTER TABLE `00054` DISABLE KEYS */;
INSERT INTO `00054` VALUES ('单人间',30,120),('标间',16,220),('套间',4,350);
/*!40000 ALTER TABLE `00054` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00055`
--

DROP TABLE IF EXISTS `00055`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00055` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00055`
--

LOCK TABLES `00055` WRITE;
/*!40000 ALTER TABLE `00055` DISABLE KEYS */;
INSERT INTO `00055` VALUES ('单人间',31,120),('标间',12,220),('套间',4,350);
/*!40000 ALTER TABLE `00055` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00056`
--

DROP TABLE IF EXISTS `00056`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00056` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00056`
--

LOCK TABLES `00056` WRITE;
/*!40000 ALTER TABLE `00056` DISABLE KEYS */;
INSERT INTO `00056` VALUES ('单人间',28,120),('标间',18,220),('套间',7,350);
/*!40000 ALTER TABLE `00056` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00057`
--

DROP TABLE IF EXISTS `00057`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00057` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00057`
--

LOCK TABLES `00057` WRITE;
/*!40000 ALTER TABLE `00057` DISABLE KEYS */;
INSERT INTO `00057` VALUES ('单人间',34,120),('标间',10,220),('套间',3,350);
/*!40000 ALTER TABLE `00057` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00058`
--

DROP TABLE IF EXISTS `00058`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00058` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00058`
--

LOCK TABLES `00058` WRITE;
/*!40000 ALTER TABLE `00058` DISABLE KEYS */;
INSERT INTO `00058` VALUES ('单人间',27,120),('标间',18,220),('套间',6,350);
/*!40000 ALTER TABLE `00058` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00059`
--

DROP TABLE IF EXISTS `00059`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00059` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00059`
--

LOCK TABLES `00059` WRITE;
/*!40000 ALTER TABLE `00059` DISABLE KEYS */;
INSERT INTO `00059` VALUES ('单人间',22,120),('标间',10,220),('套间',6,350);
/*!40000 ALTER TABLE `00059` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00060`
--

DROP TABLE IF EXISTS `00060`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00060` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00060`
--

LOCK TABLES `00060` WRITE;
/*!40000 ALTER TABLE `00060` DISABLE KEYS */;
INSERT INTO `00060` VALUES ('单人间',16,120),('标间',10,220),('套间',4,350);
/*!40000 ALTER TABLE `00060` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00061`
--

DROP TABLE IF EXISTS `00061`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00061` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00061`
--

LOCK TABLES `00061` WRITE;
/*!40000 ALTER TABLE `00061` DISABLE KEYS */;
INSERT INTO `00061` VALUES ('单人间',16,120),('标间',13,220),('套间',6,350);
/*!40000 ALTER TABLE `00061` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00062`
--

DROP TABLE IF EXISTS `00062`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00062` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00062`
--

LOCK TABLES `00062` WRITE;
/*!40000 ALTER TABLE `00062` DISABLE KEYS */;
INSERT INTO `00062` VALUES ('单人间',25,120),('标间',19,220),('套间',4,350);
/*!40000 ALTER TABLE `00062` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00063`
--

DROP TABLE IF EXISTS `00063`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00063` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00063`
--

LOCK TABLES `00063` WRITE;
/*!40000 ALTER TABLE `00063` DISABLE KEYS */;
INSERT INTO `00063` VALUES ('单人间',40,120),('标间',19,220),('套间',7,350);
/*!40000 ALTER TABLE `00063` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00064`
--

DROP TABLE IF EXISTS `00064`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00064` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00064`
--

LOCK TABLES `00064` WRITE;
/*!40000 ALTER TABLE `00064` DISABLE KEYS */;
INSERT INTO `00064` VALUES ('单人间',20,120),('标间',15,220),('套间',3,350);
/*!40000 ALTER TABLE `00064` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00065`
--

DROP TABLE IF EXISTS `00065`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00065` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00065`
--

LOCK TABLES `00065` WRITE;
/*!40000 ALTER TABLE `00065` DISABLE KEYS */;
INSERT INTO `00065` VALUES ('单人间',34,120),('标间',15,220),('套间',5,350);
/*!40000 ALTER TABLE `00065` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00066`
--

DROP TABLE IF EXISTS `00066`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00066` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00066`
--

LOCK TABLES `00066` WRITE;
/*!40000 ALTER TABLE `00066` DISABLE KEYS */;
INSERT INTO `00066` VALUES ('单人间',36,120),('标间',15,220),('套间',4,350);
/*!40000 ALTER TABLE `00066` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00067`
--

DROP TABLE IF EXISTS `00067`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00067` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00067`
--

LOCK TABLES `00067` WRITE;
/*!40000 ALTER TABLE `00067` DISABLE KEYS */;
INSERT INTO `00067` VALUES ('单人间',36,120),('标间',12,220),('套间',7,350);
/*!40000 ALTER TABLE `00067` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00068`
--

DROP TABLE IF EXISTS `00068`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00068` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00068`
--

LOCK TABLES `00068` WRITE;
/*!40000 ALTER TABLE `00068` DISABLE KEYS */;
INSERT INTO `00068` VALUES ('单人间',28,120),('标间',18,220),('套间',7,350);
/*!40000 ALTER TABLE `00068` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00069`
--

DROP TABLE IF EXISTS `00069`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00069` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00069`
--

LOCK TABLES `00069` WRITE;
/*!40000 ALTER TABLE `00069` DISABLE KEYS */;
INSERT INTO `00069` VALUES ('单人间',22,120),('标间',13,220),('套间',7,350);
/*!40000 ALTER TABLE `00069` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00070`
--

DROP TABLE IF EXISTS `00070`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00070` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00070`
--

LOCK TABLES `00070` WRITE;
/*!40000 ALTER TABLE `00070` DISABLE KEYS */;
INSERT INTO `00070` VALUES ('单人间',28,120),('标间',17,220),('套间',4,350);
/*!40000 ALTER TABLE `00070` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00071`
--

DROP TABLE IF EXISTS `00071`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00071` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00071`
--

LOCK TABLES `00071` WRITE;
/*!40000 ALTER TABLE `00071` DISABLE KEYS */;
INSERT INTO `00071` VALUES ('单人间',31,120),('标间',19,220),('套间',6,350);
/*!40000 ALTER TABLE `00071` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00072`
--

DROP TABLE IF EXISTS `00072`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00072` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00072`
--

LOCK TABLES `00072` WRITE;
/*!40000 ALTER TABLE `00072` DISABLE KEYS */;
INSERT INTO `00072` VALUES ('单人间',36,120),('标间',19,220),('套间',5,350);
/*!40000 ALTER TABLE `00072` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00073`
--

DROP TABLE IF EXISTS `00073`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00073` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00073`
--

LOCK TABLES `00073` WRITE;
/*!40000 ALTER TABLE `00073` DISABLE KEYS */;
INSERT INTO `00073` VALUES ('单人间',27,120),('标间',19,220),('套间',3,350);
/*!40000 ALTER TABLE `00073` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00074`
--

DROP TABLE IF EXISTS `00074`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00074` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00074`
--

LOCK TABLES `00074` WRITE;
/*!40000 ALTER TABLE `00074` DISABLE KEYS */;
INSERT INTO `00074` VALUES ('单人间',34,120),('标间',14,220),('套间',3,350);
/*!40000 ALTER TABLE `00074` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00075`
--

DROP TABLE IF EXISTS `00075`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00075` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00075`
--

LOCK TABLES `00075` WRITE;
/*!40000 ALTER TABLE `00075` DISABLE KEYS */;
INSERT INTO `00075` VALUES ('单人间',26,120),('标间',16,220),('套间',7,350);
/*!40000 ALTER TABLE `00075` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00076`
--

DROP TABLE IF EXISTS `00076`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00076` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00076`
--

LOCK TABLES `00076` WRITE;
/*!40000 ALTER TABLE `00076` DISABLE KEYS */;
INSERT INTO `00076` VALUES ('单人间',28,120),('标间',18,220),('套间',6,350);
/*!40000 ALTER TABLE `00076` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00077`
--

DROP TABLE IF EXISTS `00077`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00077` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00077`
--

LOCK TABLES `00077` WRITE;
/*!40000 ALTER TABLE `00077` DISABLE KEYS */;
INSERT INTO `00077` VALUES ('单人间',18,120),('标间',12,220),('套间',4,350);
/*!40000 ALTER TABLE `00077` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00078`
--

DROP TABLE IF EXISTS `00078`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00078` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00078`
--

LOCK TABLES `00078` WRITE;
/*!40000 ALTER TABLE `00078` DISABLE KEYS */;
INSERT INTO `00078` VALUES ('单人间',20,120),('标间',11,220),('套间',5,350);
/*!40000 ALTER TABLE `00078` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00079`
--

DROP TABLE IF EXISTS `00079`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00079` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00079`
--

LOCK TABLES `00079` WRITE;
/*!40000 ALTER TABLE `00079` DISABLE KEYS */;
INSERT INTO `00079` VALUES ('单人间',35,120),('标间',15,220),('套间',4,350);
/*!40000 ALTER TABLE `00079` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00080`
--

DROP TABLE IF EXISTS `00080`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00080` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00080`
--

LOCK TABLES `00080` WRITE;
/*!40000 ALTER TABLE `00080` DISABLE KEYS */;
INSERT INTO `00080` VALUES ('单人间',35,120),('标间',11,220),('套间',4,350);
/*!40000 ALTER TABLE `00080` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00081`
--

DROP TABLE IF EXISTS `00081`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00081` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00081`
--

LOCK TABLES `00081` WRITE;
/*!40000 ALTER TABLE `00081` DISABLE KEYS */;
INSERT INTO `00081` VALUES ('单人间',19,120),('标间',17,220),('套间',5,350);
/*!40000 ALTER TABLE `00081` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00082`
--

DROP TABLE IF EXISTS `00082`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00082` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00082`
--

LOCK TABLES `00082` WRITE;
/*!40000 ALTER TABLE `00082` DISABLE KEYS */;
INSERT INTO `00082` VALUES ('单人间',18,120),('标间',11,220),('套间',3,350);
/*!40000 ALTER TABLE `00082` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00083`
--

DROP TABLE IF EXISTS `00083`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00083` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00083`
--

LOCK TABLES `00083` WRITE;
/*!40000 ALTER TABLE `00083` DISABLE KEYS */;
INSERT INTO `00083` VALUES ('单人间',31,120),('标间',15,220),('套间',3,350);
/*!40000 ALTER TABLE `00083` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00084`
--

DROP TABLE IF EXISTS `00084`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00084` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00084`
--

LOCK TABLES `00084` WRITE;
/*!40000 ALTER TABLE `00084` DISABLE KEYS */;
INSERT INTO `00084` VALUES ('单人间',30,120),('标间',16,220),('套间',4,350);
/*!40000 ALTER TABLE `00084` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00085`
--

DROP TABLE IF EXISTS `00085`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00085` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00085`
--

LOCK TABLES `00085` WRITE;
/*!40000 ALTER TABLE `00085` DISABLE KEYS */;
INSERT INTO `00085` VALUES ('单人间',35,120),('标间',19,220),('套间',5,350);
/*!40000 ALTER TABLE `00085` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00086`
--

DROP TABLE IF EXISTS `00086`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00086` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00086`
--

LOCK TABLES `00086` WRITE;
/*!40000 ALTER TABLE `00086` DISABLE KEYS */;
INSERT INTO `00086` VALUES ('单人间',35,120),('标间',12,220),('套间',7,350);
/*!40000 ALTER TABLE `00086` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00087`
--

DROP TABLE IF EXISTS `00087`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00087` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00087`
--

LOCK TABLES `00087` WRITE;
/*!40000 ALTER TABLE `00087` DISABLE KEYS */;
INSERT INTO `00087` VALUES ('单人间',16,120),('标间',12,220),('套间',4,350);
/*!40000 ALTER TABLE `00087` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00088`
--

DROP TABLE IF EXISTS `00088`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00088` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00088`
--

LOCK TABLES `00088` WRITE;
/*!40000 ALTER TABLE `00088` DISABLE KEYS */;
INSERT INTO `00088` VALUES ('单人间',31,120),('标间',12,220),('套间',4,350);
/*!40000 ALTER TABLE `00088` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00089`
--

DROP TABLE IF EXISTS `00089`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00089` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00089`
--

LOCK TABLES `00089` WRITE;
/*!40000 ALTER TABLE `00089` DISABLE KEYS */;
INSERT INTO `00089` VALUES ('单人间',38,120),('标间',15,220),('套间',3,350);
/*!40000 ALTER TABLE `00089` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00090`
--

DROP TABLE IF EXISTS `00090`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00090` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00090`
--

LOCK TABLES `00090` WRITE;
/*!40000 ALTER TABLE `00090` DISABLE KEYS */;
INSERT INTO `00090` VALUES ('单人间',32,120),('标间',11,220),('套间',6,350);
/*!40000 ALTER TABLE `00090` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00091`
--

DROP TABLE IF EXISTS `00091`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00091` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00091`
--

LOCK TABLES `00091` WRITE;
/*!40000 ALTER TABLE `00091` DISABLE KEYS */;
INSERT INTO `00091` VALUES ('单人间',35,120),('标间',10,220),('套间',7,350);
/*!40000 ALTER TABLE `00091` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00092`
--

DROP TABLE IF EXISTS `00092`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00092` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00092`
--

LOCK TABLES `00092` WRITE;
/*!40000 ALTER TABLE `00092` DISABLE KEYS */;
INSERT INTO `00092` VALUES ('单人间',23,120),('标间',18,220),('套间',4,350);
/*!40000 ALTER TABLE `00092` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00093`
--

DROP TABLE IF EXISTS `00093`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00093` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00093`
--

LOCK TABLES `00093` WRITE;
/*!40000 ALTER TABLE `00093` DISABLE KEYS */;
INSERT INTO `00093` VALUES ('单人间',34,120),('标间',19,220),('套间',6,350);
/*!40000 ALTER TABLE `00093` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00094`
--

DROP TABLE IF EXISTS `00094`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00094` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00094`
--

LOCK TABLES `00094` WRITE;
/*!40000 ALTER TABLE `00094` DISABLE KEYS */;
INSERT INTO `00094` VALUES ('单人间',33,120),('标间',12,220),('套间',3,350);
/*!40000 ALTER TABLE `00094` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00095`
--

DROP TABLE IF EXISTS `00095`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00095` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00095`
--

LOCK TABLES `00095` WRITE;
/*!40000 ALTER TABLE `00095` DISABLE KEYS */;
INSERT INTO `00095` VALUES ('单人间',25,120),('标间',18,220),('套间',4,350);
/*!40000 ALTER TABLE `00095` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00096`
--

DROP TABLE IF EXISTS `00096`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00096` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00096`
--

LOCK TABLES `00096` WRITE;
/*!40000 ALTER TABLE `00096` DISABLE KEYS */;
INSERT INTO `00096` VALUES ('单人间',26,120),('标间',15,220),('套间',4,350);
/*!40000 ALTER TABLE `00096` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00097`
--

DROP TABLE IF EXISTS `00097`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00097` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00097`
--

LOCK TABLES `00097` WRITE;
/*!40000 ALTER TABLE `00097` DISABLE KEYS */;
INSERT INTO `00097` VALUES ('单人间',35,120),('标间',10,220),('套间',3,350);
/*!40000 ALTER TABLE `00097` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00098`
--

DROP TABLE IF EXISTS `00098`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00098` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00098`
--

LOCK TABLES `00098` WRITE;
/*!40000 ALTER TABLE `00098` DISABLE KEYS */;
INSERT INTO `00098` VALUES ('单人间',17,120),('标间',11,220),('套间',6,350);
/*!40000 ALTER TABLE `00098` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00099`
--

DROP TABLE IF EXISTS `00099`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00099` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00099`
--

LOCK TABLES `00099` WRITE;
/*!40000 ALTER TABLE `00099` DISABLE KEYS */;
INSERT INTO `00099` VALUES ('单人间',36,120),('标间',11,220),('套间',4,350);
/*!40000 ALTER TABLE `00099` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00100`
--

DROP TABLE IF EXISTS `00100`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00100` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00100`
--

LOCK TABLES `00100` WRITE;
/*!40000 ALTER TABLE `00100` DISABLE KEYS */;
INSERT INTO `00100` VALUES ('单人间',22,120),('标间',11,220),('套间',3,350);
/*!40000 ALTER TABLE `00100` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00101`
--

DROP TABLE IF EXISTS `00101`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00101` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00101`
--

LOCK TABLES `00101` WRITE;
/*!40000 ALTER TABLE `00101` DISABLE KEYS */;
INSERT INTO `00101` VALUES ('单人间',31,120),('标间',11,220),('套间',6,350);
/*!40000 ALTER TABLE `00101` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00102`
--

DROP TABLE IF EXISTS `00102`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00102` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00102`
--

LOCK TABLES `00102` WRITE;
/*!40000 ALTER TABLE `00102` DISABLE KEYS */;
INSERT INTO `00102` VALUES ('单人间',36,120),('标间',11,220),('套间',5,350);
/*!40000 ALTER TABLE `00102` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00103`
--

DROP TABLE IF EXISTS `00103`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00103` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00103`
--

LOCK TABLES `00103` WRITE;
/*!40000 ALTER TABLE `00103` DISABLE KEYS */;
INSERT INTO `00103` VALUES ('单人间',18,120),('标间',19,220),('套间',4,350);
/*!40000 ALTER TABLE `00103` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00104`
--

DROP TABLE IF EXISTS `00104`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00104` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00104`
--

LOCK TABLES `00104` WRITE;
/*!40000 ALTER TABLE `00104` DISABLE KEYS */;
INSERT INTO `00104` VALUES ('单人间',31,120),('标间',12,220),('套间',4,350);
/*!40000 ALTER TABLE `00104` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00105`
--

DROP TABLE IF EXISTS `00105`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00105` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00105`
--

LOCK TABLES `00105` WRITE;
/*!40000 ALTER TABLE `00105` DISABLE KEYS */;
INSERT INTO `00105` VALUES ('单人间',31,120),('标间',12,220),('套间',6,350);
/*!40000 ALTER TABLE `00105` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00106`
--

DROP TABLE IF EXISTS `00106`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00106` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00106`
--

LOCK TABLES `00106` WRITE;
/*!40000 ALTER TABLE `00106` DISABLE KEYS */;
INSERT INTO `00106` VALUES ('单人间',20,120),('标间',10,220),('套间',5,350);
/*!40000 ALTER TABLE `00106` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00107`
--

DROP TABLE IF EXISTS `00107`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00107` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00107`
--

LOCK TABLES `00107` WRITE;
/*!40000 ALTER TABLE `00107` DISABLE KEYS */;
INSERT INTO `00107` VALUES ('单人间',33,120),('标间',18,220),('套间',4,350);
/*!40000 ALTER TABLE `00107` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00108`
--

DROP TABLE IF EXISTS `00108`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00108` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00108`
--

LOCK TABLES `00108` WRITE;
/*!40000 ALTER TABLE `00108` DISABLE KEYS */;
INSERT INTO `00108` VALUES ('单人间',38,120),('标间',15,220),('套间',4,350);
/*!40000 ALTER TABLE `00108` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00109`
--

DROP TABLE IF EXISTS `00109`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00109` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00109`
--

LOCK TABLES `00109` WRITE;
/*!40000 ALTER TABLE `00109` DISABLE KEYS */;
INSERT INTO `00109` VALUES ('单人间',27,120),('标间',14,220),('套间',3,350);
/*!40000 ALTER TABLE `00109` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00110`
--

DROP TABLE IF EXISTS `00110`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00110` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00110`
--

LOCK TABLES `00110` WRITE;
/*!40000 ALTER TABLE `00110` DISABLE KEYS */;
INSERT INTO `00110` VALUES ('单人间',40,120),('标间',16,220),('套间',5,350);
/*!40000 ALTER TABLE `00110` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00111`
--

DROP TABLE IF EXISTS `00111`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00111` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00111`
--

LOCK TABLES `00111` WRITE;
/*!40000 ALTER TABLE `00111` DISABLE KEYS */;
INSERT INTO `00111` VALUES ('单人间',26,120),('标间',15,220),('套间',5,350);
/*!40000 ALTER TABLE `00111` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00112`
--

DROP TABLE IF EXISTS `00112`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00112` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00112`
--

LOCK TABLES `00112` WRITE;
/*!40000 ALTER TABLE `00112` DISABLE KEYS */;
INSERT INTO `00112` VALUES ('单人间',17,120),('标间',15,220),('套间',6,350);
/*!40000 ALTER TABLE `00112` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `00113`
--

DROP TABLE IF EXISTS `00113`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `00113` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `00113`
--

LOCK TABLES `00113` WRITE;
/*!40000 ALTER TABLE `00113` DISABLE KEYS */;
INSERT INTO `00113` VALUES ('单人间',19,120),('标间',13,220),('套间',5,350);
/*!40000 ALTER TABLE `00113` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cityandarea`
--

DROP TABLE IF EXISTS `cityandarea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cityandarea` (
  `cityname` text,
  `tradearea` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cityandarea`
--

LOCK TABLES `cityandarea` WRITE;
/*!40000 ALTER TABLE `cityandarea` DISABLE KEYS */;
INSERT INTO `cityandarea` VALUES ('南京','新街口'),('南京','夫子庙'),('南京','湖南路'),('南京','河西'),('南京','百家湖'),('南京','仙林'),('南京','桥北'),('北京','西单'),('北京','王府井'),('北京','崇文门'),('北京','国贸'),('北京','中关村'),('北京','三里屯'),('上海','徐家汇'),('上海','陆家嘴'),('上海','五角场'),('上海','曹安路'),('上海','中山公园'),('上海','淮海路'),('上海','南京南路'),('上海','南京东路'),('广州','天河'),('广州','珠江新城'),('广州','北京路'),('广州','岗顶数码'),('广州','西关'),('广州','江南西'),('广州','番禺大北路'),('广州','流花'),('广州','白鹅潭'),('广州','东山'),('成都','春熙路'),('成都','天府新城'),('成都','新双楠尚品广场'),('成都','金沙光华'),('成都','建设路'),('成都','盐市口'),('成都','骡马市');
/*!40000 ALTER TABLE `cityandarea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `UserName` text,
  `HotelID` text,
  `CommentDate` datetime DEFAULT NULL,
  `Rank` double DEFAULT NULL,
  `Comment` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES ('张客户','00001','2008-07-12 00:00:00',4.5,'酒店很好，服务到位，价格公道，环境优美，下次还会再来');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `creditrecord`
--

DROP TABLE IF EXISTS `creditrecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `creditrecord` (
  `orderid` text,
  `userid` text,
  `changeddate` datetime DEFAULT NULL,
  `changedvalue` double DEFAULT NULL,
  `result` double DEFAULT NULL,
  `op` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creditrecord`
--

LOCK TABLES `creditrecord` WRITE;
/*!40000 ALTER TABLE `creditrecord` DISABLE KEYS */;
INSERT INTO `creditrecord` VALUES ('123456789020080606143055','1234567890','2008-07-10 00:00:00',120,120,'执行订单'),('123456789020080808221016','1234567890','2008-09-10 00:00:00',120,240,'执行订单'),('123456789020081010130101','1234567890','2008-10-12 00:00:00',220,460,'执行订单'),('123456789020081212152751','1234567890','2008-12-12 00:00:00',-60,400,'撤销订单'),('123456789020081212152311','1234567890','2008-12-16 00:00:00',120,520,'执行订单'),('123456789020090202080303','1234567890','2009-03-04 00:00:00',350,870,'执行订单'),('123456789020090404121212','1234567890','2009-05-06 00:00:00',120,990,'执行订单'),('123456789020090606121212','1234567890','2009-07-07 00:00:00',220,1210,'执行订单'),('123456789020101111121212','1234567890','2010-11-12 00:00:00',72,1282,'执行订单'),('123456789020101111172222','1234567890','2010-11-11 00:00:00',-36,1246,'撤销订单'),('123456789020120101000000','1234567890','2012-01-01 00:00:00',-120,1126,'异常订单'),('123456789020120102000000','1234567890','2012-01-02 00:00:00',-120,1006,'异常订单'),('123456789020120103000000','1234567890','2012-01-03 00:00:00',-220,786,'异常订单'),('123456789020120104000000','1234567890','2012-01-04 00:00:00',-120,666,'异常订单'),('123456789020120105000000','1234567890','2012-01-05 00:00:00',-350,316,'异常订单'),('123456789020120106000000','1234567890','2012-01-06 00:00:00',-120,196,'异常订单'),('123456789020120107000000','1234567890','2012-01-07 00:00:00',-220,-24,'异常订单'),('无','1234567890','2012-01-07 00:00:00',2906,2882,'信用充值'),('123456789020120108000000','1234567890','2012-01-08 00:00:00',-72,2810,'异常订单'),('123456789020080606143055','1234567890','2008-07-10 00:00:00',120,120,'执行订单');
/*!40000 ALTER TABLE `creditrecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hotel` (
  `HotelID` text,
  `HotelName` text,
  `Address` text,
  `Area` text,
  `City` text,
  `Introduction` text,
  `CheckInInfos` text,
  `Rank` double DEFAULT NULL,
  `Star` int(11) DEFAULT NULL,
  `Facility` text,
  `Cooperators` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES ('00001','南京1号大酒店','南京市A区新街口大道163号','新街口','南京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.83434891326784,4,'游泳馆，健身房等等等等服务齐全',''),('00002','南京2号大酒店','南京市A区新街口大道54号','新街口','南京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.91661736608247,5,'游泳馆，健身房等等等等服务齐全',''),('00003','南京3号大酒店','南京市A区新街口大道13号','新街口','南京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.83434891326784,3,'游泳馆，健身房等等等等服务齐全',''),('00004','南京4号大酒店','南京市A区新街口大道666号','新街口','南京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.49941642045032,3,'游泳馆，健身房等等等等服务齐全',''),('00005','南京5号大酒店','南京市B区夫子庙大道16号','夫子庙','南京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.99365474498644,5,'游泳馆，健身房等等等等服务齐全',''),('00006','南京6号大酒店','南京市B区夫子庙大道99号','夫子庙','南京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.03307958784372,3,'游泳馆，健身房等等等等服务齐全',''),('00007','南京7号大酒店','南京市B区夫子庙大道145号','夫子庙','南京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.38724500196813,3,'游泳馆，健身房等等等等服务齐全',''),('00008','南京8号大酒店','南京市C区湖南路大道64号','湖南路','南京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.03583437168273,2,'游泳馆，健身房等等等等服务齐全',''),('00009','南京9号大酒店','南京市C区湖南路大道80号','湖南路','南京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.4361193716202,3,'游泳馆，健身房等等等等服务齐全',''),('00010','南京10号大酒店','南京市C区湖南路大道277号','湖南路','南京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.64622103982715,4,'游泳馆，健身房等等等等服务齐全',''),('00011','南京11号大酒店','南京市C区湖南路大道1号','湖南路','南京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.68986008598912,4,'游泳馆，健身房等等等等服务齐全',''),('00012','南京12号大酒店','南京市D区河西大道33号','河西','南京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.06397235355856,3,'游泳馆，健身房等等等等服务齐全',''),('00013','南京13号大酒店','南京市D区河西大道82号','河西','南京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.8610489142618,5,'游泳馆，健身房等等等等服务齐全',''),('00014','南京14号大酒店','南京市D区河西大道909号','河西','南京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.62049359674451,4,'游泳馆，健身房等等等等服务齐全',''),('00015','南京15号大酒店','南京市E区百家湖大道144号','百家湖','南京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.57118230858112,3,'游泳馆，健身房等等等等服务齐全',''),('00016','南京16号大酒店','南京市E区百家湖大道26号','百家湖','南京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.80800892815965,4,'游泳馆，健身房等等等等服务齐全',''),('00017','南京17号大酒店','南京市F区仙林大道20号','仙林','南京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.96335039983792,5,'游泳馆，健身房等等等等服务齐全',''),('00018','南京18号大酒店','南京市F区仙林大道77号','仙林','南京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.56940947396616,3,'游泳馆，健身房等等等等服务齐全',''),('00019','南京19号大酒店','南京市F区仙林大道51号','仙林','南京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.81892362923538,5,'游泳馆，健身房等等等等服务齐全',''),('00020','南京20号大酒店','南京市F区仙林大道3号','仙林','南京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.93580586044532,5,'游泳馆，健身房等等等等服务齐全',''),('00021','南京21号大酒店','南京市F区仙林大道85号','仙林','南京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.5353470632701,4,'游泳馆，健身房等等等等服务齐全',''),('00022','南京22号大酒店','南京市G区桥北大道69号','桥北','南京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.66607547672896,4,'游泳馆，健身房等等等等服务齐全',''),('00023','南京23号大酒店','南京市G区桥北大道188号','桥北','南京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.11023738279245,3,'游泳馆，健身房等等等等服务齐全',''),('00024','北京1号大酒店','北京市A区西单路1号','西单','北京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.84685898284328,5,'游泳馆，健身房等等等等服务齐全',''),('00025','北京2号大酒店','北京市A区西单路2号','西单','北京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.73548620361824,4,'游泳馆，健身房等等等等服务齐全',''),('00026','北京3号大酒店','北京市A区西单路4号','西单','北京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.65048627938285,4,'游泳馆，健身房等等等等服务齐全',''),('00027','北京4号大酒店','北京市F区王府井路8号','王府井','北京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.21689648950742,3,'游泳馆，健身房等等等等服务齐全',''),('00028','北京5号大酒店','北京市F区王府井路16号','王府井','北京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.28094517017787,3,'游泳馆，健身房等等等等服务齐全',''),('00029','北京6号大酒店','北京市F区王府井路32号','王府井','北京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.70842243307506,4,'游泳馆，健身房等等等等服务齐全',''),('00030','北京7号大酒店','北京市B区崇文门路64号','崇文门','北京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.4536886921416,4,'游泳馆，健身房等等等等服务齐全',''),('00031','北京8号大酒店','北京市B区崇文门路128号','崇文门','北京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.62283261751371,4,'游泳馆，健身房等等等等服务齐全',''),('00032','北京9号大酒店','北京市B区崇文门路256号','崇文门','北京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.84917064903758,5,'游泳馆，健身房等等等等服务齐全',''),('00033','北京10号大酒店','北京市B区崇文门路84号','崇文门','北京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.88968047065472,5,'游泳馆，健身房等等等等服务齐全',''),('00034','北京11号大酒店','北京市C区国贸路91号','国贸','北京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.85114346244302,4,'游泳馆，健身房等等等等服务齐全',''),('00035','北京12号大酒店','北京市C区国贸路44号','国贸','北京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.03878082543093,3,'游泳馆，健身房等等等等服务齐全',''),('00036','北京13号大酒店','北京市C区国贸路16号','国贸','北京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.08509699758083,3,'游泳馆，健身房等等等等服务齐全',''),('00037','北京14号大酒店','北京市C区国贸路101号','国贸','北京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.36015672665507,3,'游泳馆，健身房等等等等服务齐全',''),('00038','北京15号大酒店','北京市D区中关村路17号','中关村','北京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.05313096028933,3,'游泳馆，健身房等等等等服务齐全',''),('00039','北京16号大酒店','北京市D区中关村路31号','中关村','北京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.88352361296298,5,'游泳馆，健身房等等等等服务齐全',''),('00040','北京17号大酒店','北京市D区中关村路48号','中关村','北京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.02985192226438,3,'游泳馆，健身房等等等等服务齐全',''),('00041','北京18号大酒店','北京市D区中关村路172号','中关村','北京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.8401303315292,5,'游泳馆，健身房等等等等服务齐全',''),('00042','北京19号大酒店','北京市E区三里屯路336号','三里屯','北京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.45950875736421,4,'游泳馆，健身房等等等等服务齐全',''),('00043','北京20号大酒店','北京市E区三里屯路75号','三里屯','北京','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.04350103720126,3,'游泳馆，健身房等等等等服务齐全',''),('00044','上海1号大酒店','上海市A区徐路106号','徐家汇','上海','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.69915010241492,4,'游泳馆，健身房等等等等服务齐全',''),('00045','上海2号大酒店','上海市A区徐路888号','徐家汇','上海','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.05365285783721,3,'游泳馆，健身房等等等等服务齐全',''),('00046','上海3号大酒店','上海市A区徐路11号','徐家汇','上海','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.0117434214188,3,'游泳馆，健身房等等等等服务齐全',''),('00047','上海4号大酒店','上海市A区徐路941号','徐家汇','上海','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.88,5,'游泳馆，健身房等等等等服务齐全',''),('00048','上海5号大酒店','上海市A区徐路771号','徐家汇','上海','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.6557839075034,4,'游泳馆，健身房等等等等服务齐全',''),('00049','上海6号大酒店','上海市B区陆路191号','陆家嘴','上海','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.46742962625477,4,'游泳馆，健身房等等等等服务齐全',''),('00050','上海7号大酒店','上海市B区陆路4号','陆家嘴','上海','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.31449087278475,3,'游泳馆，健身房等等等等服务齐全',''),('00051','上海8号大酒店','上海市B区陆路10号','陆家嘴','上海','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.95060209376754,5,'游泳馆，健身房等等等等服务齐全',''),('00052','上海9号大酒店','上海市B区陆路77号','陆家嘴','上海','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.38532916163575,3,'游泳馆，健身房等等等等服务齐全',''),('00053','上海10号大酒店','上海市C区五角路66号','五角场','上海','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.29497467278387,3,'游泳馆，健身房等等等等服务齐全',''),('00054','上海11号大酒店','上海市C区五角路55号','五角场','上海','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.01144239409671,3,'游泳馆，健身房等等等等服务齐全',''),('00055','上海12号大酒店','上海市D区曹安路44号','曹安路','上海','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.43346654909636,4,'游泳馆，健身房等等等等服务齐全',''),('00056','上海13号大酒店','上海市D区曹安路33号','曹安路','上海','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.00672124158783,3,'游泳馆，健身房等等等等服务齐全',''),('00057','上海14号大酒店','上海市E区中山路22号','中山公园','上海','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.15023757893212,3,'游泳馆，健身房等等等等服务齐全',''),('00058','上海15号大酒店','上海市E区中山路11号','中山公园','上海','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.92294058513398,5,'游泳馆，健身房等等等等服务齐全',''),('00059','上海16号大酒店','上海市E区中山路88号','中山公园','上海','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.43079728273312,4,'游泳馆，健身房等等等等服务齐全',''),('00060','上海17号大酒店','上海市F区淮海路97号','淮海路','上海','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.69400626686192,4,'游泳馆，健身房等等等等服务齐全',''),('00061','上海18号大酒店','上海市F区淮海路453号','淮海路','上海','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.78930141836191,5,'游泳馆，健身房等等等等服务齐全',''),('00062','上海19号大酒店','上海市F区淮海路234号','淮海路','上海','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.29283690522504,3,'游泳馆，健身房等等等等服务齐全',''),('00063','上海20号大酒店','上海市G区南京南路161号','南京南路','上海','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.84290985835349,5,'游泳馆，健身房等等等等服务齐全',''),('00064','上海21号大酒店','上海市G区南京南路26号','南京南路','上海','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.5430038425658,4,'游泳馆，健身房等等等等服务齐全',''),('00065','上海22号大酒店','上海市G区南京南路136号','南京南路','上海','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.17108836195408,3,'游泳馆，健身房等等等等服务齐全',''),('00066','上海23号大酒店','上海市G区南京南路56号','南京南路','上海','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.58201874891673,4,'游泳馆，健身房等等等等服务齐全',''),('00067','上海24号大酒店','上海市G区南京南路99号','南京南路','上海','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.96,5,'游泳馆，健身房等等等等服务齐全',''),('00068','上海25号大酒店','上海市H区南京东路752号','南京东路','上海','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.58759169518001,4,'游泳馆，健身房等等等等服务齐全',''),('00069','上海26号大酒店','上海市H区南京东路281号','南京东路','上海','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.60892832742689,4,'游泳馆，健身房等等等等服务齐全',''),('00070','上海27号大酒店','上海市H区南京东路142号','南京东路','上海','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.37663314299524,3,'游泳馆，健身房等等等等服务齐全',''),('00071','上海28号大酒店','上海市H区南京东路139号','南京东路','上海','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.526025595746,4,'游泳馆，健身房等等等等服务齐全',''),('00072','广州1号大酒店','广州市A区天河街99号','天河','广州','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.63474834531588,4,'游泳馆，健身房等等等等服务齐全',''),('00073','广州2号大酒店','广州市A区天河街73号','天河','广州','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.43298253365338,4,'游泳馆，健身房等等等等服务齐全',''),('00074','广州3号大酒店','广州市B区珠江街71号','珠江新城','广州','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.66813114570117,4,'游泳馆，健身房等等等等服务齐全',''),('00075','广州4号大酒店','广州市B区珠江街11号','珠江新城','广州','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.71607127191102,4,'游泳馆，健身房等等等等服务齐全',''),('00076','广州5号大酒店','广州市C区北京街14号','北京路','广州','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.78038603055484,4,'游泳馆，健身房等等等等服务齐全',''),('00077','广州6号大酒店','广州市C区北京街25号','北京路','广州','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.59991512475902,4,'游泳馆，健身房等等等等服务齐全',''),('00078','广州7号大酒店','广州市C区北京街13号','北京路','广州','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.45826960621898,3,'游泳馆，健身房等等等等服务齐全',''),('00079','广州8号大酒店','广州市C区北京街7号','北京路','广州','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.53071055980102,4,'游泳馆，健身房等等等等服务齐全',''),('00080','广州9号大酒店','广州市C区北京街8号','北京路','广州','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.55849508894759,4,'游泳馆，健身房等等等等服务齐全',''),('00081','广州10号大酒店','广州市D区数码街18号','岗顶数码','广州','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.85951698516384,5,'游泳馆，健身房等等等等服务齐全',''),('00082','广州11号大酒店','广州市E区西关街67号','西关','广州','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.21203662367741,3,'游泳馆，健身房等等等等服务齐全',''),('00083','广州12号大酒店','广州市E区西关街33号','西关','广州','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.39000338114148,3,'游泳馆，健身房等等等等服务齐全',''),('00084','广州13号大酒店','广州市F区江南西街75号','江南西','广州','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.89031353373485,5,'游泳馆，健身房等等等等服务齐全',''),('00085','广州14号大酒店','广州市F区江南西街22号','江南西','广州','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.4548266452012,4,'游泳馆，健身房等等等等服务齐全',''),('00086','广州15号大酒店','广州市F区江南西街1号','江南西','广州','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.73472731503954,5,'游泳馆，健身房等等等等服务齐全',''),('00087','广州16号大酒店','广州市F区江南西街4号','江南西','广州','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.71645222652215,4,'游泳馆，健身房等等等等服务齐全',''),('00088','广州17号大酒店','广州市G区大北路街43号','番禺大北路','广州','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.93076405542284,5,'游泳馆，健身房等等等等服务齐全',''),('00089','广州18号大酒店','广州市G区大北路街77号','番禺大北路','广州','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.29178684058411,3,'游泳馆，健身房等等等等服务齐全',''),('00090','广州19号大酒店','广州市G区大北路街55号','番禺大北路','广州','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.70896460436746,4,'游泳馆，健身房等等等等服务齐全',''),('00091','广州20号大酒店','广州市H区小北路街86号','流花','广州','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.41247961607896,3,'游泳馆，健身房等等等等服务齐全',''),('00092','广州21号大酒店','广州市H区小北路街3号','流花','广州','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.23270032240335,3,'游泳馆，健身房等等等等服务齐全',''),('00093','广州22号大酒店','广州市H区小北路街14号','流花','广州','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.27129571824635,3,'游泳馆，健身房等等等等服务齐全',''),('00094','广州23号大酒店','广州市I区向天歌街31号','白鹅潭','广州','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.74644699188279,5,'游泳馆，健身房等等等等服务齐全',''),('00095','广州24号大酒店','广州市J区东山街43号','东山','广州','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.74361641810116,4,'游泳馆，健身房等等等等服务齐全',''),('00096','广州25号大酒店','广州市A区东山街8号','东山','广州','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.4521011834817,3,'游泳馆，健身房等等等等服务齐全',''),('00097','成都1号大酒店','成都市A区春熙路516号','春熙路','成都','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.84629959958729,5,'游泳馆，健身房等等等等服务齐全',''),('00098','成都2号大酒店','成都市A区春熙路76号','春熙路','成都','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.06727054089028,3,'游泳馆，健身房等等等等服务齐全',''),('00099','成都3号大酒店','成都市A区春熙路75号','春熙路','成都','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.78732339269045,5,'游泳馆，健身房等等等等服务齐全',''),('00100','成都4号大酒店','成都市B区天府路14号','天府新城','成都','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.81204907004212,5,'游泳馆，健身房等等等等服务齐全',''),('00101','成都5号大酒店','成都市C区双楠路34号','新双楠尚品广场','成都','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.2662770045607,3,'游泳馆，健身房等等等等服务齐全',''),('00102','成都6号大酒店','成都市C区双楠路78号','新双楠尚品广场','成都','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.66894634626622,4,'游泳馆，健身房等等等等服务齐全',''),('00103','成都7号大酒店','成都市D区金沙路69号','金沙光华','成都','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.61399500537894,4,'游泳馆，健身房等等等等服务齐全',''),('00104','成都8号大酒店','成都市D区金沙路6号','金沙光华','成都','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.34643010053578,3,'游泳馆，健身房等等等等服务齐全',''),('00105','成都9号大酒店','成都市D区金沙路7号','金沙光华','成都','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.89443396254802,5,'游泳馆，健身房等等等等服务齐全',''),('00106','成都10号大酒店','成都市E区建设路58号','建设路','成都','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.88273296713075,5,'游泳馆，健身房等等等等服务齐全',''),('00107','成都11号大酒店','成都市E区建设路31号','建设路','成都','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.75140741275148,4,'游泳馆，健身房等等等等服务齐全',''),('00108','成都12号大酒店','成都市E区建设路24号','建设路','成都','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.64530399663484,4,'游泳馆，健身房等等等等服务齐全',''),('00109','成都13号大酒店','成都市E区建设路267号','建设路','成都','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.66833648128419,4,'游泳馆，健身房等等等等服务齐全',''),('00110','成都14号大酒店','成都市F区咸口路43号','盐市口','成都','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.89722659956579,5,'游泳馆，健身房等等等等服务齐全',''),('00111','成都15号大酒店','成都市F区咸口路55号','盐市口','成都','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.89579654027145,5,'游泳馆，健身房等等等等服务齐全',''),('00112','成都16号大酒店','成都市G区骡马路86号','骡马市','成都','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.40016679511933,3,'游泳馆，健身房等等等等服务齐全',''),('00113','成都17号大酒店','成都市G区骡马路94号','骡马市','成都','风景如画，等等等等','302,20061001,20061002;303,20061101,20061103',4.34962072565623,3,'游泳馆，健身房等等等等服务齐全','');
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `level`
--

DROP TABLE IF EXISTS `level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `level` (
  `LevelNum` int(11) DEFAULT NULL,
  `Credits` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `level`
--

LOCK TABLES `level` WRITE;
/*!40000 ALTER TABLE `level` DISABLE KEYS */;
INSERT INTO `level` VALUES (1,300),(2,600),(3,900),(4,1200),(5,1500),(6,1800),(7,2100),(8,2400),(9,2700),(10,3000),(11,3300),(12,3600),(13,3900),(14,4200),(15,4500),(16,4800),(17,5100),(18,5400),(19,5700),(20,6000);
/*!40000 ALTER TABLE `level` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `Type` text,
  `GeneratedDate` datetime DEFAULT NULL,
  `SchFrom` datetime DEFAULT NULL,
  `SchTo` datetime DEFAULT NULL,
  `ActFrom` datetime DEFAULT NULL,
  `ActTo` datetime DEFAULT NULL,
  `LatestTime` datetime DEFAULT NULL,
  `CancelTime` datetime DEFAULT NULL,
  `HotelName` text,
  `HotelAddress` text,
  `OrderID` text,
  `HotelID` text,
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `NumOfPeople` int(11) DEFAULT NULL,
  `ExistsChildren` tinyint(4) DEFAULT NULL,
  `UserID` text,
  `CustomerName` text,
  `PhoneNumber` text,
  `TotalPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES ('已执行订单','2008-06-06 00:00:00','2008-07-07 00:00:00','2008-07-10 00:00:00','2008-07-07 13:22:33','2008-07-10 13:22:33','2008-07-07 23:59:59','1000-01-01 00:00:00','南京1号大酒店','南京市A区新街口大道163号','123456789020080606143055','00001','单人间',1,1,0,'1234567890','张客户','13301112944',120),('已执行订单','2008-08-08 00:00:00','2008-09-09 00:00:00','2008-09-10 00:00:00','2008-09-09 13:22:33','2008-09-10 13:22:33','2008-08-08 23:59:59','1000-01-01 00:00:00','南京1号大酒店','南京市A区新街口大道163号','123456789020080808221016','00001','单人间',1,1,0,'1234567890','张客户','13301112944',120),('已执行订单','2008-10-10 00:00:00','2008-10-11 00:00:00','2008-10-12 00:00:00','2008-10-11 13:22:33','2008-10-12 13:22:33','2008-10-10 23:59:59','1000-01-01 00:00:00','南京1号大酒店','南京市A区新街口大道163号','123456789020081010130101','00001','标间',1,2,1,'1234567890','张客户','13301112944',220),('已执行订单','2008-12-12 00:00:00','2008-12-15 00:00:00','2008-12-16 00:00:00','2008-12-15 13:22:33','2008-12-16 13:22:33','2008-12-12 23:59:59','1000-01-01 00:00:00','南京1号大酒店','南京市A区新街口大道163号','123456789020081212152311','00001','单人间',1,1,0,'1234567890','张客户','13301112944',120),('已执行订单','2009-02-02 00:00:00','2009-03-03 00:00:00','2009-03-04 00:00:00','2009-03-03 13:22:33','2009-03-04 13:22:33','2009-02-02 23:59:59','1000-01-01 00:00:00','南京1号大酒店','南京市A区新街口大道163号','123456789020090202080303','00001','套间',1,1,0,'1234567890','张客户','13301112944',350),('已执行订单','2009-04-04 00:00:00','2009-05-05 00:00:00','2009-05-06 00:00:00','2009-05-05 13:22:33','2009-05-06 13:22:33','2009-04-04 23:59:59','1000-01-01 00:00:00','南京1号大酒店','南京市A区新街口大道163号','123456789020090404121212','00001','单人间',1,1,0,'1234567890','张客户','13301112944',120),('已执行订单','2009-06-06 00:00:00','2009-07-07 00:00:00','2009-07-07 00:00:00','2009-07-07 13:22:33','2009-07-07 13:22:33','2009-06-06 23:59:59','1000-01-01 00:00:00','南京1号大酒店','南京市A区新街口大道163号','123456789020090606121212','00001','标间',1,2,0,'1234567890','张客户','13301112944',220),('已执行订单','2010-11-06 00:00:00','2010-11-11 00:00:00','2010-11-12 00:00:00','2010-11-11 13:22:33','2010-11-12 13:22:33','2010-11-11 23:59:59','1000-01-01 00:00:00','南京1号大酒店','南京市A区新街口大道163号','123456789020101111121212','00001','单人间',1,1,0,'1234567890','张客户','13301112944',72),('已撤销订单','2008-06-06 00:00:00','2008-07-07 00:00:00','2008-07-10 00:00:00','1000-01-01 00:00:00','1000-01-01 00:00:00','2008-07-07 23:59:59','2008-06-07 23:59:59','南京1号大酒店','南京市A区新街口大道163号','123456789020080606173055','00001','单人间',1,1,0,'1234567890','张客户','13301112944',120),('已撤销订单','2008-08-08 00:00:00','2008-09-09 00:00:00','2008-09-10 00:00:00','1000-01-01 00:00:00','1000-01-01 00:00:00','2008-08-08 23:59:59','2008-08-09 23:59:59','南京1号大酒店','南京市A区新街口大道163号','123456789020080808201016','00001','单人间',1,1,0,'1234567890','张客户','13301112944',120),('已撤销订单','2008-10-10 00:00:00','2008-10-11 00:00:00','2008-10-12 00:00:00','1000-01-01 00:00:00','1000-01-01 00:00:00','2008-10-10 23:59:59','2008-10-11 23:59:59','南京1号大酒店','南京市A区新街口大道163号','123456789020081010220101','00001','标间',1,2,1,'1234567890','张客户','13301112944',220),('已撤销订单','2008-12-12 00:00:00','2008-12-15 00:00:00','2008-12-16 00:00:00','1000-01-01 00:00:00','1000-01-01 00:00:00','2008-12-12 23:59:59','2008-12-15 18:59:59','南京1号大酒店','南京市A区新街口大道163号','123456789020081212152751','00001','单人间',1,1,0,'1234567890','张客户','13301112944',120),('已撤销订单','2009-02-02 00:00:00','2009-03-03 00:00:00','2009-03-04 00:00:00','1000-01-01 00:00:00','1000-01-01 00:00:00','2009-02-03 23:59:59','2009-02-03 23:59:59','南京1号大酒店','南京市A区新街口大道163号','123456789020090202080000','00001','套间',1,1,0,'1234567890','张客户','13301112944',350),('已撤销订单','2009-04-04 00:00:00','2009-05-05 00:00:00','2009-05-06 00:00:00','1000-01-01 00:00:00','1000-01-01 00:00:00','2009-04-04 23:59:59','2009-04-05 23:59:59','南京1号大酒店','南京市A区新街口大道163号','123456789020090404124411','00001','单人间',1,1,0,'1234567890','张客户','13301112944',120),('已撤销订单','2009-06-06 00:00:00','2009-07-07 00:00:00','2009-07-07 00:00:00','1000-01-01 00:00:00','1000-01-01 00:00:00','2009-06-06 23:59:59','2009-06-07 23:59:59','南京1号大酒店','南京市A区新街口大道163号','123456789020090606130505','00001','标间',1,2,0,'1234567890','张客户','13301112944',220),('已撤销订单','2010-11-06 00:00:00','2010-11-11 00:00:00','2010-11-12 00:00:00','1000-01-01 00:00:00','1000-01-01 00:00:00','2010-11-11 23:59:59','2010-11-11 19:59:59','南京1号大酒店','南京市A区新街口大道163号','123456789020101111172222','00001','单人间',1,1,0,'1234567890','张客户','13301112944',72),('异常订单','2012-01-01 00:00:00','2012-01-01 00:00:00','2012-01-02 00:00:00','1000-01-01 00:00:00','1000-01-01 00:00:00','2012-01-01 23:59:59','1000-01-01 00:00:00','南京1号大酒店','南京市A区新街口大道163号','123456789020120101000000','00001','单人间',1,1,0,'1234567890','张客户','13301112944',120),('异常订单','2012-01-02 00:00:00','2012-01-02 00:00:00','2012-01-03 00:00:00','1000-01-01 00:00:00','1000-01-01 00:00:00','2012-01-02 23:59:59','1000-01-01 00:00:00','南京1号大酒店','南京市A区新街口大道163号','123456789020120102000000','00001','单人间',1,1,0,'1234567890','张客户','13301112944',120),('异常订单','2012-01-03 00:00:00','2012-01-03 00:00:00','2012-01-04 00:00:00','1000-01-01 00:00:00','1000-01-01 00:00:00','2012-01-03 23:59:59','1000-01-01 00:00:00','南京1号大酒店','南京市A区新街口大道163号','123456789020120103000000','00001','标间',1,2,1,'1234567890','张客户','13301112944',220),('异常订单','2012-01-04 00:00:00','2012-01-04 00:00:00','2012-01-05 00:00:00','1000-01-01 00:00:00','1000-01-01 00:00:00','2012-01-04 23:59:59','1000-01-01 00:00:00','南京1号大酒店','南京市A区新街口大道163号','123456789020120104000000','00001','单人间',1,1,0,'1234567890','张客户','13301112944',120),('异常订单','2012-01-05 00:00:00','2012-01-05 00:00:00','2012-01-06 00:00:00','1000-01-01 00:00:00','1000-01-01 00:00:00','2012-01-05 23:59:59','1000-01-01 00:00:00','南京1号大酒店','南京市A区新街口大道163号','123456789020120105000000','00001','套间',1,1,0,'1234567890','张客户','13301112944',350),('异常订单','2012-01-06 00:00:00','2012-01-06 00:00:00','2012-01-07 00:00:00','1000-01-01 00:00:00','1000-01-01 00:00:00','2012-01-06 23:59:59','1000-01-01 00:00:00','南京1号大酒店','南京市A区新街口大道163号','123456789020120106000000','00001','单人间',1,1,0,'1234567890','张客户','13301112944',120),('异常订单','2012-01-07 00:00:00','2012-01-07 00:00:00','2012-01-08 00:00:00','1000-01-01 00:00:00','1000-01-01 00:00:00','2012-01-07 23:59:59','1000-01-01 00:00:00','南京1号大酒店','南京市A区新街口大道163号','123456789020120107000000','00001','标间',1,2,0,'1234567890','张客户','13301112944',220),('异常订单','2012-01-08 00:00:00','2012-01-08 00:00:00','2012-01-09 00:00:00','1000-01-01 00:00:00','1000-01-01 00:00:00','2012-01-08 23:59:59','1000-01-01 00:00:00','南京1号大酒店','南京市A区新街口大道163号','123456789020120108000000','00001','单人间',1,1,0,'1234567890','张客户','13301112944',72),('未执行订单','2012-01-09 00:00:00','2012-01-09 00:00:00','2012-01-10 00:00:00','1000-01-01 00:00:00','1000-01-01 00:00:00','2012-01-09 23:59:59','1000-01-01 00:00:00','南京1号大酒店','南京市A区新街口大道163号','123456789020120109000000','00001','单人间',1,1,0,'1234567890','张客户','13301112944',120),('未执行订单','2012-01-10 00:00:00','2012-01-10 00:00:00','2012-01-11 00:00:00','1000-01-01 00:00:00','1000-01-01 00:00:00','2012-01-10 23:59:59','1000-01-01 00:00:00','南京1号大酒店','南京市A区新街口大道163号','123456789020120110000000','00001','单人间',1,1,0,'1234567890','张客户','13301112944',120),('未执行订单','2012-01-11 00:00:00','2012-01-11 00:00:00','2012-01-12 00:00:00','1000-01-01 00:00:00','1000-01-01 00:00:00','2012-01-11 23:59:59','1000-01-01 00:00:00','南京1号大酒店','南京市A区新街口大道163号','123456789020120111000000','00001','标间',1,2,1,'1234567890','张客户','13301112944',220),('未执行订单','2012-01-12 00:00:00','2012-01-12 00:00:00','2012-01-13 00:00:00','1000-01-01 00:00:00','1000-01-01 00:00:00','2012-01-12 23:59:59','1000-01-01 00:00:00','南京1号大酒店','南京市A区新街口大道163号','123456789020120112000000','00001','单人间',1,1,0,'1234567890','张客户','13301112944',120),('未执行订单','2012-01-13 00:00:00','2012-01-13 00:00:00','2012-01-14 00:00:00','1000-01-01 00:00:00','1000-01-01 00:00:00','2012-01-13 23:59:59','1000-01-01 00:00:00','南京1号大酒店','南京市A区新街口大道163号','123456789020120113000000','00001','套间',1,1,0,'1234567890','张客户','13301112944',350),('未执行订单','2012-01-14 00:00:00','2012-01-14 00:00:00','2012-01-15 00:00:00','1000-01-01 00:00:00','1000-01-01 00:00:00','2012-01-14 23:59:59','1000-01-01 00:00:00','南京1号大酒店','南京市A区新街口大道163号','123456789020120114000000','00001','单人间',1,1,0,'1234567890','张客户','13301112944',120),('未执行订单','2012-01-15 00:00:00','2012-01-15 00:00:00','2012-01-16 00:00:00','1000-01-01 00:00:00','1000-01-01 00:00:00','2012-01-15 23:59:59','1000-01-01 00:00:00','南京1号大酒店','南京市A区新街口大道163号','123456789020120115000000','00001','标间',1,2,0,'1234567890','张客户','13301112944',220),('未执行订单','2012-01-16 00:00:00','2012-01-16 00:00:00','2012-01-17 00:00:00','1000-01-01 00:00:00','1000-01-01 00:00:00','2012-01-16 23:59:59','1000-01-01 00:00:00','南京1号大酒店','南京市A区新街口大道163号','123456789020120116000000','00001','单人间',1,1,0,'1234567890','张客户','13301112944',72),('未执行订单','2012-01-17 00:00:00','2012-01-17 00:00:00','2012-01-18 00:00:00','1000-01-01 00:00:00','1000-01-01 00:00:00','2012-01-17 23:59:59','1000-01-01 00:00:00','南京1号大酒店','南京市A区新街口大道163号','123456789020120117000000','00001','单人间',1,1,0,'1234567890','张客户','13301112944',120),('未执行订单','2012-01-18 00:00:00','2012-01-18 00:00:00','2012-01-19 00:00:00','1000-01-01 00:00:00','1000-01-01 00:00:00','2012-01-18 23:59:59','1000-01-01 00:00:00','南京1号大酒店','南京市A区新街口大道163号','123456789020120118000000','00001','单人间',1,1,0,'1234567890','张客户','13301112944',120),('未执行订单','2012-01-19 00:00:00','2012-01-19 00:00:00','2012-01-20 00:00:00','1000-01-01 00:00:00','1000-01-01 00:00:00','2012-01-19 23:59:59','1000-01-01 00:00:00','南京1号大酒店','南京市A区新街口大道163号','123456789020120119000000','00001','标间',1,2,1,'1234567890','张客户','13301112944',220),('未执行订单','2012-01-20 00:00:00','2012-01-20 00:00:00','2012-01-21 00:00:00','1000-01-01 00:00:00','1000-01-01 00:00:00','2012-01-20 23:59:59','1000-01-01 00:00:00','南京1号大酒店','南京市A区新街口大道163号','123456789020120120000000','00001','单人间',1,1,0,'1234567890','张客户','13301112944',120),('',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','','','','',NULL,NULL,NULL,'','','',NULL),('',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','','','','',NULL,NULL,NULL,'','','',NULL),('',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','','','','',NULL,NULL,NULL,'','','',NULL),('',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','','','','',NULL,NULL,NULL,'','','',NULL);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `promotion` (
  `Provider` text,
  `Type` text,
  `PromotionID` text,
  `StartTime` datetime DEFAULT NULL,
  `EndTime` datetime DEFAULT NULL,
  `HotelName` text,
  `HotelID` text,
  `Level` int(11) DEFAULT NULL,
  `City` text,
  `Area` text,
  `Discount` double DEFAULT NULL,
  `Name` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promotion`
--

LOCK TABLES `promotion` WRITE;
/*!40000 ALTER TABLE `promotion` DISABLE KEYS */;
INSERT INTO `promotion` VALUES ('hotel','特定日期促销','0000000001','2010-11-11 00:00:00','2010-11-12 00:00:00','南京1号大酒店','00001',3,'南京','新街口',6,'双十一促销'),('hotel','三间以上促销','0000000002','1990-01-01 00:00:00','2017-12-12 00:00:00','南京1号大酒店','00001',3,'南京','新街口',8,'三间以上折扣'),('hotel','商圈促销','0000000003','1990-01-01 00:00:00','2017-12-12 00:00:00','南京2号大酒店','00002',3,'南京','新街口',7,'新街口促销'),('web','特定日期促销','0000000004','1990-01-01 00:00:00','2017-12-12 00:00:00',NULL,NULL,3,'南京','新街口',5,'网站特殊促销'),('hotel','三间以上促销','0000000005','1990-01-01 00:00:00','2017-12-12 00:00:00','南京3号大酒店','00003',3,'南京','新街口',9,'三间以上折扣');
/*!40000 ALTER TABLE `promotion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `Type` text,
  `UserName` text,
  `Name` text,
  `ID` text,
  `PassWord` text,
  `PhoneNumber` text,
  `Credit` double DEFAULT NULL,
  `Birthday` datetime DEFAULT NULL,
  `CompanyName` text,
  `HotelAddress` text,
  `HotelID` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('企业客户','aUaGG0ruYCpgszDQvluBGw==','JDtdGgh8TkdCwqGwz3HcAg==','4433196829','hHUMP+1jyaeB/sOCDYqFBg==','nHp1oaeBqj31aogiFJPqpA==',7900,'1000-01-01 00:00:00','pineapple','null',''),('个人客户', 'QEEzUUwMgrt2npmA1pnp7w==', 'gRysBnGIpMibhrw/z32SQw==', '1234567890', '1ufTmfQ5zCLqk9nzRifFkg==', 'qzt+Z8IRxQ5YOTrn5q+nfg==', '2810', '1995-03-05 00:00:00', 'null', 'null', ''),('企业客户', 'nUB+e8u1FQ9LxnUBw8ATWQ==', 'JDtdGgh8TkdCwqGwz3HcAg==', '4433196829', 'QD0IwYVz6k+NP2yNNhSk8Q==', 'nHp1oaeBqj31aogiFJPqpA==', '7900', '1000-01-01 00:00:00', 'pineapple', 'null', ''),('酒店管理人员', 'kcltPlIFmIkKQ4P2za4QEw==', 'Tl2N6yx9Kvuuhbyw6HZ/Uw==', '1209329435', '5UT6K5T0XgqUKsDMGXKRMA==', 'paAdQL5Ykx4ceC+RV9YzFQ==', '0', '1000-01-01 00:00:00', 'null', '南京市A区新街口大道163号', '00001'),('网站营销人员', 'ypUMcdErxJHhO2AKlJJ+lg==', 'mDjgO09WH6CdJWSqWp4C6g==', '3311203982', 'TJrUtxdYUviOBwkedXAu+A==', 'SGTXicgeWawK6Y1b6r1cYQ==', '0', '1000-01-01 00:00:00', 'null', 'null', ''),('网站管理人员', 'gRZrLhzqr70cnyFmfMy91w==', 'ZqwEdKpB0tuWSj5yTu7DKg==', '3431938943', 'oFP4Aq7ECrUr05VUbywFwg==', 'ynonMyTd8ANPhUniST+7Jg==', '0', '1000-01-01 00:00:00', 'null', 'null', ''),('网站营销人员','Iw4MClm/F/L8qKL3WGGYrw==','mDjgO09WH6CdJWSqWp4C6g==','3311203982','hHUMP+1jyaeB/sOCDYqFBg==','SGTXicgeWawK6Y1b6r1cYQ==',0,'1000-01-01 00:00:00','null','null',''),('网站管理人员','7A+inG3u36zcfu3UG+7o7g==','ZqwEdKpB0tuWSj5yTu7DKg==','3431938943','hHUMP+1jyaeB/sOCDYqFBg==','ynonMyTd8ANPhUniST+7Jg==',0,'1000-01-01 00:00:00','null','null',''),('个人客户','pOiVDqvEAwAapfEFAq7oMQ==','gRysBnGIpMibhrw/z32SQw==','1234567890','hHUMP+1jyaeB/sOCDYqFBg==','qzt+Z8IRxQ5YOTrn5q+nfg==',2820,'1995-03-05 00:00:00','null','null',''),('酒店工作人员','/sKlsTzcyBKoerIYDEg4IQ==','ZEAw6b1tjWQuzne6f9ThdQ==','1209329435','hHUMP+1jyaeB/sOCDYqFBg==','paAdQL5Ykx4ceC+RV9YzFQ==',0,'1000-01-01 00:00:00','null','南京市A区新街口大道163号','00001');

/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-11  0:40:35
