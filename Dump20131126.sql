CREATE DATABASE  IF NOT EXISTS `Escola` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `Escola`;
-- MySQL dump 10.13  Distrib 5.5.32, for debian-linux-gnu (i686)
--
-- Host: 127.0.0.1    Database: Escola
-- ------------------------------------------------------
-- Server version	5.5.32-0ubuntu0.12.04.1

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
-- Table structure for table `Categoria`
--

DROP TABLE IF EXISTS `Categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Categoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cat_nome` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Categoria`
--

LOCK TABLES `Categoria` WRITE;
/*!40000 ALTER TABLE `Categoria` DISABLE KEYS */;
INSERT INTO `Categoria` VALUES (2,'Telefonia'),(5,'Video'),(9,'Outros');
/*!40000 ALTER TABLE `Categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Layout`
--

DROP TABLE IF EXISTS `Layout`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Layout` (
  `idLayout` int(11) NOT NULL AUTO_INCREMENT,
  `anuncioBG` varchar(255) DEFAULT NULL,
  `anuncioLink` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idLayout`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Layout`
--

LOCK TABLES `Layout` WRITE;
/*!40000 ALTER TABLE `Layout` DISABLE KEYS */;
INSERT INTO `Layout` VALUES (6,'background: #fafafa url(resources/img/b1.jpg) no-repeat','http://localhost:8080/escola/detalhe.jsf?produto=7'),(9,'background: #fff','http://localhost:8080/escola/admin/pages/layout.jsf');
/*!40000 ALTER TABLE `Layout` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuario` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(25) NOT NULL,
  `login` varchar(10) NOT NULL,
  `email` varchar(45) NOT NULL,
  `senha` varchar(32) NOT NULL,
  `situacao` varchar(1) NOT NULL,
  `razaoSocial` varchar(50) DEFAULT NULL,
  `cep` varchar(9) NOT NULL,
  `sexo` char(1) NOT NULL,
  `cpf_cnpj` char(20) NOT NULL,
  `admin` varchar(1) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES (1,'Administrador','admin','admin@admin.com.br','1d0258c2440a8d19e716292b231e3190','A','','07171-145','M','999999','S'),(2,'Fulano','fulano','fulano@fulano.com.br','3342949e2e99fc2f304de6fdd626a188','A','','07272-140','M','99998','N'),(9,'Ernande','ernande','ernandeinf@yahoo.com.br','9a46adbbd0731122c3fe9236c2066aed','A',NULL,'071744','M','999999','N'),(15,'Pessoa Juridica','social','test@tesc.com.br','social','A','social','cep','J','cnpj','N'),(16,'ernande','ernandeinf','er@te.com.br','ernande@','A',NULL,'07171-129','M','999999999','N'),(18,'Teste','teste','teste@teste.com.br','teste','A',NULL,'1234','F','2222','N'),(19,'Nome fantasia','razao','e@test.com.br','razao','A','Rz Social','cep','J','cnpj','N'),(22,'md5','md5','md5@md5.com','1bc29b36f623ba82aaf6724fd3b16718','A',NULL,'md5','F','md5','N'),(23,'logar','logar','logar@logar.com','c6ab1b470860e4c231e9d33e98ddf035','A',NULL,'logar','M','logar','N');
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Aluno`
--

DROP TABLE IF EXISTS `Aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Aluno` (
  `idAluno` int(11) NOT NULL AUTO_INCREMENT,
  `ra` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `dataNascimento` date NOT NULL,
  `rg` varchar(15) DEFAULT NULL,
  `cpf` varchar(15) DEFAULT NULL,
  `sexo` varchar(1) NOT NULL,
  PRIMARY KEY (`idAluno`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Aluno`
--

LOCK TABLES `Aluno` WRITE;
/*!40000 ALTER TABLE `Aluno` DISABLE KEYS */;
INSERT INTO `Aluno` VALUES (2,2,'Antonia','1978-04-02','3','3','F'),(3,1243455678,'Ernande','1990-10-09','99.999.999-9','999.999.999-99','M');
/*!40000 ALTER TABLE `Aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Professor`
--

DROP TABLE IF EXISTS `Professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Professor` (
  `idProfessor` int(11) NOT NULL AUTO_INCREMENT,
  `matricula` varchar(20) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `dataNascimento` date NOT NULL,
  `rg` varchar(15) DEFAULT NULL,
  `cpf` varchar(15) DEFAULT NULL,
  `sexo` varchar(1) NOT NULL,
  `dataContratacao` datetime NOT NULL,
  `pis` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idProfessor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Professor`
--

LOCK TABLES `Professor` WRITE;
/*!40000 ALTER TABLE `Professor` DISABLE KEYS */;
/*!40000 ALTER TABLE `Professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Produto`
--

DROP TABLE IF EXISTS `Produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Produto` (
  `idProduto` int(11) NOT NULL AUTO_INCREMENT,
  `prod_nome` varchar(40) DEFAULT NULL,
  `cat_id` int(11) DEFAULT NULL,
  `preco` decimal(10,2) DEFAULT NULL,
  `desconto` decimal(10,2) DEFAULT NULL,
  `desc_keys` varchar(400) DEFAULT NULL,
  `desc_pq` varchar(500) DEFAULT NULL,
  `desc_gd` text,
  `imagem` varchar(250) DEFAULT NULL,
  `destaque` char(1) DEFAULT NULL,
  `rank` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProduto`),
  KEY `fk_categorias` (`cat_id`),
  CONSTRAINT `fk_categorias` FOREIGN KEY (`cat_id`) REFERENCES `Categoria` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Produto`
--

LOCK TABLES `Produto` WRITE;
/*!40000 ALTER TABLE `Produto` DISABLE KEYS */;
INSERT INTO `Produto` VALUES (1,'Bicicleta',9,200.00,10.00,'bicicleta,livro, prata','É um teste de pontuação É um teste de pontuação  É um teste de pontuação É um teste de pontuação É um teste de pontuação','tv','bike.jpg','S',84),(3,'Iphone',2,1390.00,90.00,'iphone, preto, branco, telefonia, celular','iphone  pequena descrição','<font face=\"Arial, Verdana\" size=\"2\" style=\"font-weight: normal;\">Iphone 2012</font><div style=\"font-weight: normal; font-family: Arial, Verdana; font-size: 10pt; font-style: normal; font-variant: normal; line-height: normal;\"><br/></div><div style=\"font-weight: normal; font-family: Arial, Verdana; font-size: 10pt; font-style: normal; font-variant: normal; line-height: normal;\">conteúdo:</div><div><ul><li style=\"font-weight: normal;\"><font face=\"Arial, Verdana\" size=\"2\">cabo usb;</font></li><li style=\"font-weight: normal;\"><font face=\"Arial, Verdana\" size=\"2\">carregador;</font></li><li><font face=\"Arial, Verdana\" size=\"2\"><strong>1 ano de garantia</strong></font></li></ul></div>','iphone.jpg','N',100),(4,'Monitor',5,1000.00,35.00,'tv, video, led','Monitor descrição pequena','tv descrição grande','monitor.jpg','S',86),(5,'Pendrive',9,40.00,2.00,'pendrive, armazenamento, preto, usb','Pequena descrição pendrive','Grande descrição pendrive','pendrive.jpg','N',81),(6,'TV ',5,900.00,30.00,'tv, led, plasma,video','tv pequena descrição','tv grande descrição','tv.jpg','S',75),(7,'Protex Men Power',9,20.00,2.00,'protex men power, promoção, sabonete, colgate','pequena descrição para protex Men','Grande descrição para Protex Men','protex.jpg','S',100);
/*!40000 ALTER TABLE `Produto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-11-26 13:36:14
