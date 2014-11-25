/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.6.21 : Database - dormitory_management
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dormitory_management` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `dormitory_management`;

/*Table structure for table `managerlogin` */

DROP TABLE IF EXISTS `managerlogin`;

CREATE TABLE `managerlogin` (
  `name` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `managerlogin` */

insert  into `managerlogin`(`name`,`password`) values ('李双','lishuang');

/*Table structure for table `studentinfor` */

DROP TABLE IF EXISTS `studentinfor`;

CREATE TABLE `studentinfor` (
  `student_number` varchar(50) NOT NULL,
  `student_name` varchar(20) NOT NULL,
  `student_hostel` varchar(20) NOT NULL,
  `student_class` varchar(20) NOT NULL,
  `student_academy` varchar(20) NOT NULL,
  PRIMARY KEY (`student_number`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `studentinfor` */

insert  into `studentinfor`(`student_number`,`student_name`,`student_hostel`,`student_class`,`student_academy`) values ('2012210658','张继','609','0191203','通信学院'),('2012210625','李双','611','0191203','通信学院');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
