# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.11)
# Database: voice_mail
# Generation Time: 2016-05-30 03:54:47 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table Contact
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Contact`;

CREATE TABLE `Contact` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL DEFAULT '',
  `last_name` varchar(50) NOT NULL DEFAULT '',
  `phone_number` varchar(50) NOT NULL DEFAULT '',
  `mailbox_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `mailbox_contact_fk` (`mailbox_id`),
  CONSTRAINT `mailbox_contact_fk` FOREIGN KEY (`mailbox_id`) REFERENCES `Mailbox` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table Mailbox
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Mailbox`;

CREATE TABLE `Mailbox` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `number` varchar(20) NOT NULL,
  `password` text NOT NULL,
  `greeting_message` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `Mailbox` WRITE;
/*!40000 ALTER TABLE `Mailbox` DISABLE KEYS */;

INSERT INTO `Mailbox` (`id`, `number`, `password`, `greeting_message`)
VALUES
	(44,'1','567','Hola'),
	(45,'2','2','You have reached mailbox 2. \nPlease leave a message now.');

/*!40000 ALTER TABLE `Mailbox` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Message
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Message`;

CREATE TABLE `Message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `text` text NOT NULL,
  `status` varchar(10) NOT NULL DEFAULT '',
  `mailbox_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `mailbox_message_fk` (`mailbox_id`),
  CONSTRAINT `mailbox_message_fk` FOREIGN KEY (`mailbox_id`) REFERENCES `Mailbox` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
