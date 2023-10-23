-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.4.25-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para interdados
CREATE DATABASE IF NOT EXISTS `interdados` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `interdados`;

-- Copiando estrutura para tabela interdados.funcionarios
CREATE TABLE IF NOT EXISTS `funcionarios` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Usuario` varchar(255) NOT NULL,
  `Senha` varchar(30) NOT NULL,
  `isadmin` int(1) DEFAULT 0,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela interdados.funcionarios: ~2 rows (aproximadamente)
INSERT INTO `funcionarios` (`ID`, `Usuario`, `Senha`, `isadmin`) VALUES
	(1, 'admin', 'admin', 1),
	(2, 'user', 'user', 0);

-- Copiando estrutura para tabela interdados.produtos
CREATE TABLE IF NOT EXISTS `produtos` (
  `IDProduto` int(11) NOT NULL AUTO_INCREMENT,
  `NomeProduto` varchar(255) NOT NULL,
  `QuantidadeEstoque` int(11) NOT NULL,
  `Valor` int(11) NOT NULL,
  PRIMARY KEY (`IDProduto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela interdados.produtos: ~0 rows (aproximadamente)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
