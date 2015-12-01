
DROP DATABASE IF EXISTS 'mehrals';
CREATE DATABASE 'mehrals';
USE 'mehrals';

--
-- Table structure for table `integrity_records`
--

DROP TABLE IF EXISTS `integrity_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `integrity_records` (
  `curr_status` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `integrity_records`
--

LOCK TABLES `integrity_records` WRITE;
/*!40000 ALTER TABLE `integrity_records` DISABLE KEYS */;
INSERT INTO `integrity_records` VALUES (403);
/*!40000 ALTER TABLE `integrity_records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login_records`
--

DROP TABLE IF EXISTS `login_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login_records` (
  `U_Id` varchar(80) DEFAULT NULL,
  `U_Pass` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_records`
--

LOCK TABLES `login_records` WRITE;
/*!40000 ALTER TABLE `login_records` DISABLE KEYS */;
INSERT INTO `login_records` VALUES ('admin','21232f297a57a5a743894a0e4a801fc3');
/*!40000 ALTER TABLE `login_records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `main_records`
--

DROP TABLE IF EXISTS `main_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `main_records` (
  `Serial` int(6) DEFAULT NULL,
  `Dated` date DEFAULT NULL,
  `Bill_no` varchar(20) DEFAULT NULL,
  `Hosp_Name` varchar(80) DEFAULT NULL,
  `Vat` decimal(9,3) DEFAULT NULL,
  `Net_Amt` decimal(15,3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `main_records`
--

LOCK TABLES `main_records` WRITE;
/*!40000 ALTER TABLE `main_records` DISABLE KEYS */;
/*!40000 ALTER TABLE `main_records` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-01  7:34:41
