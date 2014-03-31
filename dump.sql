-- MySQL dump 10.13  Distrib 5.1.73, for redhat-linux-gnu (x86_64)
--
-- Host: localhost    Database: quality
-- ------------------------------------------------------
-- Server version	5.1.73

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
-- Table structure for table `ankets`
--

DROP TABLE IF EXISTS `ankets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ankets` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `shname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ankets`
--

LOCK TABLES `ankets` WRITE;
/*!40000 ALTER TABLE `ankets` DISABLE KEYS */;
INSERT INTO `ankets` VALUES (1,'Анкета по анализу удовлетворенности качеством предоставления медицинских услуг в амбулаторных условиях учреждения здравоохранения','поликлиника');
/*!40000 ALTER TABLE `ankets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ankets_result`
--

DROP TABLE IF EXISTS `ankets_result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ankets_result` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `events_id` int(11) NOT NULL,
  `anketNum` int(11) NOT NULL,
  `ins_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ipaddr` char(15) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `events_id` (`events_id`),
  CONSTRAINT `ankets_result_fk` FOREIGN KEY (`events_id`) REFERENCES `events` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ankets_result`
--

LOCK TABLES `ankets_result` WRITE;
/*!40000 ALTER TABLE `ankets_result` DISABLE KEYS */;
/*!40000 ALTER TABLE `ankets_result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quest_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `discr` char(1) DEFAULT NULL,
  `subq_id` int(11) DEFAULT NULL,
  `answ_num` int(11) NOT NULL,
  `answerList_ORDER` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `quest_id` (`quest_id`),
  KEY `subq_id` (`subq_id`),
  CONSTRAINT `answer_fk` FOREIGN KEY (`quest_id`) REFERENCES `quest` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `answer_fk1` FOREIGN KEY (`subq_id`) REFERENCES `subq` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` VALUES (1,1,'0-18 лет','A',NULL,1,NULL),(2,1,'19-45 лет','A',NULL,2,NULL),(3,1,'свыше 45 лет','A',NULL,3,NULL),(4,2,'мужской','A',NULL,1,NULL),(5,2,'женский','A',NULL,2,NULL),(6,3,'обращался (напишите месяц, год)','B',NULL,1,NULL),(7,3,'не обращался в данное учреждение здравоохранения за получением медицинской помощи','A',NULL,2,NULL),(8,4,'да','A',NULL,1,NULL),(9,4,'нет','A',NULL,2,NULL),(10,5,'прошло около (дней) ','B',NULL,1,NULL),(11,5,'не обращался','A',NULL,2,NULL),(12,6,'очень легко','A',1,1,NULL),(13,6,'легко','A',1,2,NULL),(14,6,'сложно','A',1,3,NULL),(15,6,'очень сложно','A',1,4,NULL),(16,6,'не удалось записаться','A',1,5,NULL),(17,6,'не пользовался','A',1,6,NULL),(18,6,'очень легко','A',2,1,NULL),(19,6,'легко','A',2,2,NULL),(20,6,'сложно','A',2,3,NULL),(21,6,'очень сложно','A',2,4,NULL),(22,6,'не удалось записаться','A',2,5,NULL),(23,6,'не пользовался','A',2,6,NULL),(24,6,'сложно','A',3,1,NULL),(25,6,'очень сложно','A',3,2,NULL),(26,6,'не удалось записаться','A',3,3,NULL),(27,6,'очень легко','A',3,4,NULL),(28,6,'легко','A',3,5,NULL),(29,6,'сложно','A',3,6,NULL),(30,6,'не пользовался','A',3,7,NULL),(31,6,'очень легко','A',4,1,NULL),(32,6,'легко','A',4,2,NULL),(33,6,'сложно','A',4,3,NULL),(34,6,'очень сложно','A',4,4,NULL),(35,6,'не удалось записаться','A',4,5,NULL),(36,6,'не пользовался','A',4,6,NULL),(37,7,'практически не пришлось ожидать в очереди','A',NULL,1,NULL),(38,7,'да, пришлось ждать приема в очереди около (минут)','B',NULL,2,NULL),(39,8,'полностью удовлетворен','A',NULL,1,NULL),(40,8,'частично удовлетворен','A',NULL,2,NULL),(41,8,'скорее не удовлетворен','A',NULL,3,NULL),(42,8,'полностью не удовлетворен','A',NULL,4,NULL),(43,9,'да, помощь была оказана на дому вовремя','A',NULL,1,NULL),(44,9,'да, помощь была оказана позже, чем это требовалось','A',NULL,2,NULL),(45,9,'нет, пришлось самостоятельно обращаться в учреждение здравоохранения','A',NULL,3,NULL),(46,9,'не возникало необходимости вызывать врача на дом','A',NULL,4,NULL),(47,10,'количество дней ожидания','B',NULL,1,NULL),(48,16,'количество дней','B',9,1,NULL),(49,16,'количество дней','B',10,2,NULL),(50,11,'крайне плохо','A',5,1,NULL),(51,11,'плохо','A',5,2,NULL),(52,11,'удовлетворительно','A',5,3,NULL),(53,11,'хорошо','A',5,4,NULL),(54,11,'отлично','A',5,5,NULL),(55,11,'крайне плохо','A',6,1,NULL),(56,11,'плохо','A',6,2,NULL),(57,11,'удовлетворительно','A',6,3,NULL),(58,11,'хорошо','A',6,4,NULL),(59,11,'отлично','A',6,5,NULL),(60,11,'крайне плохо','A',7,1,NULL),(61,11,'плохо','A',7,2,NULL),(62,11,'удовлетворительно','A',7,3,NULL),(63,11,'хорошо','A',7,4,NULL),(64,11,'отлично','A',7,5,NULL),(65,11,'крайне плохо','A',8,1,NULL),(66,11,'плохо','A',8,2,NULL),(67,11,'удовлетворительно','A',8,3,NULL),(68,11,'хорошо','A',8,4,NULL),(69,11,'отлично','A',8,5,NULL),(70,12,'да, полностью','A',NULL,1,NULL),(71,12,'больше да, чем нет','A',NULL,2,NULL),(72,12,'больше нет, чем да','A',NULL,3,NULL),(73,12,'не удовлетворен','A',NULL,4,NULL),(74,13,'да','A',NULL,1,NULL),(75,13,'нет','A',NULL,2,NULL),(76,13,'пока не знаю','A',NULL,3,NULL),(77,14,'да, полностью','A',NULL,1,NULL),(78,14,'больше да, чем нет','A',NULL,2,NULL),(79,14,'боьше нет, чем да','A',NULL,3,NULL),(80,14,'не удовлетворен','A',NULL,4,NULL),(81,15,'да, достаточным','A',NULL,1,NULL),(82,15,'скорее да, чем нет','A',NULL,2,NULL),(83,15,'скорее нет, чем да','A',NULL,3,NULL),(84,15,'не знаю','A',NULL,4,NULL),(85,7,'не помню','A',NULL,3,NULL);
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `events`
--

DROP TABLE IF EXISTS `events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `events` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lpu_id` char(26) NOT NULL,
  `date_b` date DEFAULT NULL,
  `date_e` date DEFAULT NULL,
  `anket_id` int(11) NOT NULL,
  `opened` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `lpu_id` (`lpu_id`),
  KEY `anket_id` (`anket_id`),
  CONSTRAINT `events_fk` FOREIGN KEY (`lpu_id`) REFERENCES `lpu` (`oid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `events_fk1` FOREIGN KEY (`anket_id`) REFERENCES `ankets` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events`
--

LOCK TABLES `events` WRITE;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
INSERT INTO `events` VALUES (1,'1.2.643.5.1.13.3.25.45.4','2014-03-01',NULL,1,1),(2,'1.2.643.5.1.13.3.25.45.56','2014-04-01',NULL,1,1);
/*!40000 ALTER TABLE `events` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lpu`
--

DROP TABLE IF EXISTS `lpu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lpu` (
  `oid` char(26) NOT NULL,
  `fullname` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`oid`),
  UNIQUE KEY `oid` (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lpu`
--

LOCK TABLES `lpu` WRITE;
/*!40000 ALTER TABLE `lpu` DISABLE KEYS */;
INSERT INTO `lpu` VALUES ('1.2.643.5.1.13.3.25.45.23','Государственное бюджетное учреждение \"Курганская детская поликлиника\"','ГБУ \"Курганская детская поликлиника\"'),('1.2.643.5.1.13.3.25.45.35','Государственное бюджетное учреждение  \"Курганская больница №2\"','ГБУ \"Курганская больница №2\"'),('1.2.643.5.1.13.3.25.45.4','Государственное бюджетное учреждение \"Курганская больница №5\"','ГБУ \"Курганская больница №5\"'),('1.2.643.5.1.13.3.25.45.56','Государственное бюджетное учреждение \"Курганская поликлиника №4\"','ГБУ \"Курганская поликлиника № 4\"'),('1.2.643.5.1.13.3.25.45.64','Государственное бюджетное учреждение \"Курганская поликлиника №3\"','ГБУ \"Курганская поликлиника №3\"'),('1.2.643.5.1.13.3.25.45.9','Государственное бюджетное учреждение \"Курганская больница №1\"','ГБУ \"Курганская больница №1\"');
/*!40000 ALTER TABLE `lpu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quest`
--

DROP TABLE IF EXISTS `quest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quest` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `anket_id` int(11) NOT NULL,
  `quest_num` smallint(6) NOT NULL,
  `value` varchar(255) NOT NULL,
  `discr` char(1) DEFAULT NULL,
  `layout` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `anket_id` (`anket_id`),
  CONSTRAINT `quest_fk` FOREIGN KEY (`anket_id`) REFERENCES `ankets` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quest`
--

LOCK TABLES `quest` WRITE;
/*!40000 ALTER TABLE `quest` DISABLE KEYS */;
INSERT INTO `quest` VALUES (1,1,1,'Укажите ваш возраст:','A','H'),(2,1,2,'Ваш пол:','A','H'),(3,1,3,'Когда Вам приходилось последний раз обращаться в учрежедние здравоохранения для получения медицинской помощи: ','B','V'),(4,1,4,'Когда Вам потребовалось посещение врача, удалось ли Вам записаться на прием при первом обращении в учрежедние здравоохранения:','A','H'),(5,1,5,'Сколько дней прошло с момента обращения в учрежедние здравоохранения за получением медицинской помощи у нужного Вам врача до назначенного времени приема у врача?','B','H'),(6,1,6,'Насколько легко Вам удалось записаться на прием к врачу одним из указанных способов?','A','H'),(7,1,7,'Сколько времени Вы ожидали приема в очереди?','B','H'),(8,1,8,'Удовлетворены ли Вы условиями ожидания приема (наличие свободных мест ожидания, туалета, питьевой воды, чистота и свежесть помещения)?','A','H'),(9,1,9,'Если Вам приходилось вызывать участкового врача на дом, то получили ли Вы необходимую помощь и консультацию?','A','V'),(10,1,10,'В случае, если после обращения в учрежедние здравоохранения Вы получили направление на плановую госпитализацию, то сколько времени Вам пришлось ожидать плановую госпитализацию?','B','H'),(11,1,12,'Удовлетворены ли Вы приемом у Врача? Оцените по 5-балльной шкале, где 1-крайне плохо, а 5-отлично','A','H'),(12,1,13,'Удовлетворены ли Вы условиями оказания медицинской помощи?','A','H'),(13,1,14,'Рекомендовали бы Вы данное учреждение здравоохранения Вашим друзьям и родственникам?','A','H'),(14,1,15,'Удовлетворены ли Вы качеством и полнотой информации, доступной на официалньом сайте, информационных стендах учреждения здравоохранения?','A','H'),(15,1,16,'Считаете ли Вы информирование о работе учреждений здравоохранения и о порядке предоставления услуг в сфере здравоохранения достаточным:','A','H'),(16,1,11,'В случае, если после обращения в учрежедние здравоохранения Вам были назначены диагностические исследования, то сколько времени прошло от назначения до прохождения Вами исследований и от прохождения исследований до получения результатов исследования?','B','H'),(17,1,17,'Ваши предложения, пожелания по улучшению качества предоставляемых медицинских услуг:','C','H');
/*!40000 ALTER TABLE `quest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quest_result`
--

DROP TABLE IF EXISTS `quest_result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quest_result` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `anketsresult_id` int(11) NOT NULL,
  `quest_id` int(11) NOT NULL,
  `subq_id` int(11) DEFAULT NULL,
  `answNum` int(11) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `anketsresult_id` (`anketsresult_id`),
  KEY `quest_id` (`quest_id`),
  KEY `subq_id` (`subq_id`),
  CONSTRAINT `quest_result_fk2` FOREIGN KEY (`subq_id`) REFERENCES `subq` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `quest_result_fk` FOREIGN KEY (`anketsresult_id`) REFERENCES `ankets_result` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `quest_result_fk1` FOREIGN KEY (`quest_id`) REFERENCES `quest` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1012 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quest_result`
--

LOCK TABLES `quest_result` WRITE;
/*!40000 ALTER TABLE `quest_result` DISABLE KEYS */;
/*!40000 ALTER TABLE `quest_result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subq`
--

DROP TABLE IF EXISTS `subq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subq` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quest_id` int(11) NOT NULL,
  `subq_num` int(11) NOT NULL,
  `name` varchar(128) NOT NULL,
  `subqList_ORDER` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `quest_id` (`quest_id`),
  CONSTRAINT `subq_fk` FOREIGN KEY (`quest_id`) REFERENCES `quest` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subq`
--

LOCK TABLES `subq` WRITE;
/*!40000 ALTER TABLE `subq` DISABLE KEYS */;
INSERT INTO `subq` VALUES (1,6,1,'по телефону:',NULL),(2,6,2,'личное обращение в регистратуру:',NULL),(3,6,3,'через интернет:',NULL),(4,6,4,'на прием к нужному врачу меня записал лечащий врач:',NULL),(5,11,1,'Вежливость и внимательность врача',NULL),(6,11,2,'Вежливость и внимательность медицинской сестры',NULL),(7,11,3,'Объяснение врачом назначенных исследований, проведенных исследований и назначенного лечения',NULL),(8,11,4,'Выявление врачом изменения состояния здоровья с учетом жалоб пациента на боли, недомогание и прочие ощущения',NULL),(9,16,1,'от назначения до прохождения исследований',NULL),(10,16,2,'до получения результатов исследования',NULL);
/*!40000 ALTER TABLE `subq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-04-01  2:00:20
