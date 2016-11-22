-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: unisus
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
-- Table structure for table `agente_saude`
--

DROP TABLE IF EXISTS `agente_saude`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agente_saude` (
  `id` int(11) NOT NULL,
  `area_trabalho` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `agente_saude_ibfk_1` FOREIGN KEY (`id`) REFERENCES `profissional_sus` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `dados_medicos_auxiliares`
--

DROP TABLE IF EXISTS `dados_medicos_auxiliares`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dados_medicos_auxiliares` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_sanguineo` varchar(256) DEFAULT NULL,
  `peso` varchar(256) DEFAULT NULL,
  `altura` varchar(256) DEFAULT NULL,
  `alergia` varchar(256) DEFAULT NULL,
  `tratamentos_atuais` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `endereco` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pais` varchar(256) DEFAULT NULL,
  `uf` varchar(256) DEFAULT NULL,
  `cidade` varchar(256) DEFAULT NULL,
  `bairro` varchar(256) DEFAULT NULL,
  `rua` varchar(256) DEFAULT NULL,
  `ponto_referencia` varchar(256) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `enfermeira`
--

DROP TABLE IF EXISTS `enfermeira`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enfermeira` (
  `id` int(11) NOT NULL,
  `coren` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `enfermeira_ibfk_1` FOREIGN KEY (`id`) REFERENCES `profissional_sus` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `especialidade`
--

DROP TABLE IF EXISTS `especialidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `especialidade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(256) DEFAULT NULL,
  `descricao` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `especialidade_x_medico`
--

DROP TABLE IF EXISTS `especialidade_x_medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `especialidade_x_medico` (
  `medico` int(11) NOT NULL,
  `especialidade` int(11) NOT NULL,
  PRIMARY KEY (`medico`,`especialidade`),
  KEY `especialidade` (`especialidade`),
  CONSTRAINT `especialidade_x_medico_ibfk_1` FOREIGN KEY (`medico`) REFERENCES `medico` (`id`),
  CONSTRAINT `especialidade_x_medico_ibfk_2` FOREIGN KEY (`especialidade`) REFERENCES `especialidade` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `especialidade_x_tipo_registro`
--

DROP TABLE IF EXISTS `especialidade_x_tipo_registro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `especialidade_x_tipo_registro` (
  `especialidade` int(11) NOT NULL,
  `tipo_registro` int(11) NOT NULL,
  PRIMARY KEY (`especialidade`,`tipo_registro`),
  KEY `tipo_registro` (`tipo_registro`),
  CONSTRAINT `especialidade_x_tipo_registro_ibfk_1` FOREIGN KEY (`especialidade`) REFERENCES `especialidade` (`id`),
  CONSTRAINT `especialidade_x_tipo_registro_ibfk_2` FOREIGN KEY (`tipo_registro`) REFERENCES `tipo_registro` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome_usuario` varchar(256) DEFAULT NULL,
  `senha_usuario` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `medico`
--

DROP TABLE IF EXISTS `medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medico` (
  `id` int(11) NOT NULL,
  `crm` varchar(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `medico_ibfk_1` FOREIGN KEY (`id`) REFERENCES `profissional_sus` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `paramedico`
--

DROP TABLE IF EXISTS `paramedico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paramedico` (
  `id` int(11) NOT NULL,
  `area_trabalho` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `paramedico_ibfk_1` FOREIGN KEY (`id`) REFERENCES `profissional_sus` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `profissional_sus`
--

DROP TABLE IF EXISTS `profissional_sus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profissional_sus` (
  `id` int(11) NOT NULL,
  `crm` varchar(256) DEFAULT NULL,
  `unidade_atendimento` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `unidade_atendimento` (`unidade_atendimento`),
  CONSTRAINT `profissional_sus_ibfk_1` FOREIGN KEY (`id`) REFERENCES `usuario` (`id`),
  CONSTRAINT `profissional_sus_ibfk_2` FOREIGN KEY (`unidade_atendimento`) REFERENCES `unidade_atendimento` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `registro`
--

DROP TABLE IF EXISTS `registro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registro` (
  `id` int(11) NOT NULL,
  `local_ocorrencia` varchar(256) DEFAULT NULL,
  `responsaveis` varchar(256) DEFAULT NULL,
  `descricao` datetime DEFAULT NULL,
  `dt_inicio` datetime DEFAULT NULL,
  `dt_fim` datetime DEFAULT NULL,
  `uni_atendimento` int(11) NOT NULL,
  `paciente` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `uni_atendimento` (`uni_atendimento`),
  KEY `registro_ib_fk2` (`paciente`),
  CONSTRAINT `registro_ib_fk2` FOREIGN KEY (`paciente`) REFERENCES `usuario_comum` (`id`),
  CONSTRAINT `registro_ibfk_1` FOREIGN KEY (`uni_atendimento`) REFERENCES `unidade_atendimento` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tipo_registro`
--

DROP TABLE IF EXISTS `tipo_registro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_registro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(256) DEFAULT NULL,
  `descricao` varchar(256) DEFAULT NULL,
  `paciente` int(11) NOT NULL,
  `profissional_responsavel` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `paciente` (`paciente`),
  KEY `profissional_responsavel` (`profissional_responsavel`),
  CONSTRAINT `tipo_registro_ibfk_1` FOREIGN KEY (`paciente`) REFERENCES `usuario_comum` (`id`),
  CONSTRAINT `tipo_registro_ibfk_2` FOREIGN KEY (`profissional_responsavel`) REFERENCES `profissional_sus` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tipo_unidade_atendimento`
--

DROP TABLE IF EXISTS `tipo_unidade_atendimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_unidade_atendimento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pronto_socorro` varchar(256) DEFAULT NULL,
  `posto_atendimento` varchar(256) DEFAULT NULL,
  `unidade_saude` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `unidade_atendimento`
--

DROP TABLE IF EXISTS `unidade_atendimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unidade_atendimento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `endereco` int(11) NOT NULL,
  `nome` varchar(256) DEFAULT NULL,
  `tipo` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `endereco` (`endereco`),
  CONSTRAINT `unidade_atendimento_ibfk_1` FOREIGN KEY (`endereco`) REFERENCES `endereco` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(256) DEFAULT NULL,
  `telefone` varchar(256) DEFAULT NULL,
  `dt_nascimento` datetime DEFAULT NULL,
  `cpf` varchar(256) DEFAULT NULL,
  `endereco` int(11) NOT NULL,
  `login` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `endereco` (`endereco`),
  KEY `login` (`login`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`endereco`) REFERENCES `endereco` (`id`),
  CONSTRAINT `usuario_ibfk_2` FOREIGN KEY (`login`) REFERENCES `login` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuario_comum`
--

DROP TABLE IF EXISTS `usuario_comum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_comum` (
  `id` int(11) NOT NULL,
  `numero_cns` varchar(256) DEFAULT NULL,
  `estado_atual` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `estado_atual` (`estado_atual`),
  CONSTRAINT `usuario_comum_ibfk_1` FOREIGN KEY (`estado_atual`) REFERENCES `dados_medicos_auxiliares` (`id`),
  CONSTRAINT `usuario_comum_ibfk_2` FOREIGN KEY (`id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-21 18:06:26
