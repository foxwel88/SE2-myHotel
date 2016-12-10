/*
Navicat MySQL Data Transfer

Source Server         : NewBeeDataBase
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : hotelbookingsystemdatabase

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2016-12-10 14:18:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for 00001
-- ----------------------------
DROP TABLE IF EXISTS `00001`;
CREATE TABLE `00001` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00001
-- ----------------------------
INSERT INTO `00001` VALUES ('单人间', '28', '120');
INSERT INTO `00001` VALUES ('标间', '15', '220');
INSERT INTO `00001` VALUES ('套间', '4', '350');

-- ----------------------------
-- Table structure for 00002
-- ----------------------------
DROP TABLE IF EXISTS `00002`;
CREATE TABLE `00002` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00002
-- ----------------------------
INSERT INTO `00002` VALUES ('单人间', '33', '130');
INSERT INTO `00002` VALUES ('标间', '18', '250');
INSERT INTO `00002` VALUES ('套间', '6', '380');

-- ----------------------------
-- Table structure for 00003
-- ----------------------------
DROP TABLE IF EXISTS `00003`;
CREATE TABLE `00003` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00003
-- ----------------------------
INSERT INTO `00003` VALUES ('单人间', '19', '110');
INSERT INTO `00003` VALUES ('标间', '12', '200');
INSERT INTO `00003` VALUES ('套间', '3', '300');

-- ----------------------------
-- Table structure for 00004
-- ----------------------------
DROP TABLE IF EXISTS `00004`;
CREATE TABLE `00004` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00004
-- ----------------------------
INSERT INTO `00004` VALUES ('单人间', '36', '120');
INSERT INTO `00004` VALUES ('标间', '14', '220');
INSERT INTO `00004` VALUES ('套间', '6', '350');

-- ----------------------------
-- Table structure for 00005
-- ----------------------------
DROP TABLE IF EXISTS `00005`;
CREATE TABLE `00005` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00005
-- ----------------------------
INSERT INTO `00005` VALUES ('单人间', '25', '120');
INSERT INTO `00005` VALUES ('标间', '16', '220');
INSERT INTO `00005` VALUES ('套间', '7', '350');

-- ----------------------------
-- Table structure for 00006
-- ----------------------------
DROP TABLE IF EXISTS `00006`;
CREATE TABLE `00006` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00006
-- ----------------------------
INSERT INTO `00006` VALUES ('单人间', '18', '120');
INSERT INTO `00006` VALUES ('标间', '15', '220');
INSERT INTO `00006` VALUES ('套间', '5', '350');

-- ----------------------------
-- Table structure for 00007
-- ----------------------------
DROP TABLE IF EXISTS `00007`;
CREATE TABLE `00007` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00007
-- ----------------------------
INSERT INTO `00007` VALUES ('单人间', '21', '120');
INSERT INTO `00007` VALUES ('标间', '12', '220');
INSERT INTO `00007` VALUES ('套间', '7', '350');

-- ----------------------------
-- Table structure for 00008
-- ----------------------------
DROP TABLE IF EXISTS `00008`;
CREATE TABLE `00008` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00008
-- ----------------------------
INSERT INTO `00008` VALUES ('单人间', '20', '120');
INSERT INTO `00008` VALUES ('标间', '15', '220');
INSERT INTO `00008` VALUES ('套间', '7', '350');

-- ----------------------------
-- Table structure for 00009
-- ----------------------------
DROP TABLE IF EXISTS `00009`;
CREATE TABLE `00009` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00009
-- ----------------------------
INSERT INTO `00009` VALUES ('单人间', '21', '120');
INSERT INTO `00009` VALUES ('标间', '12', '220');
INSERT INTO `00009` VALUES ('套间', '5', '350');

-- ----------------------------
-- Table structure for 00010
-- ----------------------------
DROP TABLE IF EXISTS `00010`;
CREATE TABLE `00010` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00010
-- ----------------------------
INSERT INTO `00010` VALUES ('单人间', '39', '120');
INSERT INTO `00010` VALUES ('标间', '10', '220');
INSERT INTO `00010` VALUES ('套间', '6', '350');

-- ----------------------------
-- Table structure for 00011
-- ----------------------------
DROP TABLE IF EXISTS `00011`;
CREATE TABLE `00011` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00011
-- ----------------------------
INSERT INTO `00011` VALUES ('单人间', '16', '120');
INSERT INTO `00011` VALUES ('标间', '11', '220');
INSERT INTO `00011` VALUES ('套间', '5', '350');

-- ----------------------------
-- Table structure for 00012
-- ----------------------------
DROP TABLE IF EXISTS `00012`;
CREATE TABLE `00012` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00012
-- ----------------------------
INSERT INTO `00012` VALUES ('单人间', '25', '120');
INSERT INTO `00012` VALUES ('标间', '12', '220');
INSERT INTO `00012` VALUES ('套间', '4', '350');

-- ----------------------------
-- Table structure for 00013
-- ----------------------------
DROP TABLE IF EXISTS `00013`;
CREATE TABLE `00013` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00013
-- ----------------------------
INSERT INTO `00013` VALUES ('单人间', '30', '120');
INSERT INTO `00013` VALUES ('标间', '10', '220');
INSERT INTO `00013` VALUES ('套间', '5', '350');

-- ----------------------------
-- Table structure for 00014
-- ----------------------------
DROP TABLE IF EXISTS `00014`;
CREATE TABLE `00014` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00014
-- ----------------------------
INSERT INTO `00014` VALUES ('单人间', '24', '120');
INSERT INTO `00014` VALUES ('标间', '11', '220');
INSERT INTO `00014` VALUES ('套间', '7', '350');

-- ----------------------------
-- Table structure for 00015
-- ----------------------------
DROP TABLE IF EXISTS `00015`;
CREATE TABLE `00015` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00015
-- ----------------------------
INSERT INTO `00015` VALUES ('单人间', '37', '120');
INSERT INTO `00015` VALUES ('标间', '17', '220');
INSERT INTO `00015` VALUES ('套间', '3', '350');

-- ----------------------------
-- Table structure for 00016
-- ----------------------------
DROP TABLE IF EXISTS `00016`;
CREATE TABLE `00016` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00016
-- ----------------------------
INSERT INTO `00016` VALUES ('单人间', '37', '120');
INSERT INTO `00016` VALUES ('标间', '12', '220');
INSERT INTO `00016` VALUES ('套间', '6', '350');

-- ----------------------------
-- Table structure for 00017
-- ----------------------------
DROP TABLE IF EXISTS `00017`;
CREATE TABLE `00017` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00017
-- ----------------------------
INSERT INTO `00017` VALUES ('单人间', '34', '120');
INSERT INTO `00017` VALUES ('标间', '16', '220');
INSERT INTO `00017` VALUES ('套间', '7', '350');

-- ----------------------------
-- Table structure for 00018
-- ----------------------------
DROP TABLE IF EXISTS `00018`;
CREATE TABLE `00018` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00018
-- ----------------------------
INSERT INTO `00018` VALUES ('单人间', '36', '120');
INSERT INTO `00018` VALUES ('标间', '12', '220');
INSERT INTO `00018` VALUES ('套间', '7', '350');

-- ----------------------------
-- Table structure for 00019
-- ----------------------------
DROP TABLE IF EXISTS `00019`;
CREATE TABLE `00019` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00019
-- ----------------------------
INSERT INTO `00019` VALUES ('单人间', '30', '120');
INSERT INTO `00019` VALUES ('标间', '11', '220');
INSERT INTO `00019` VALUES ('套间', '4', '350');

-- ----------------------------
-- Table structure for 00020
-- ----------------------------
DROP TABLE IF EXISTS `00020`;
CREATE TABLE `00020` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00020
-- ----------------------------
INSERT INTO `00020` VALUES ('单人间', '39', '120');
INSERT INTO `00020` VALUES ('标间', '17', '220');
INSERT INTO `00020` VALUES ('套间', '7', '350');

-- ----------------------------
-- Table structure for 00021
-- ----------------------------
DROP TABLE IF EXISTS `00021`;
CREATE TABLE `00021` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00021
-- ----------------------------
INSERT INTO `00021` VALUES ('单人间', '38', '120');
INSERT INTO `00021` VALUES ('标间', '11', '220');
INSERT INTO `00021` VALUES ('套间', '7', '350');

-- ----------------------------
-- Table structure for 00022
-- ----------------------------
DROP TABLE IF EXISTS `00022`;
CREATE TABLE `00022` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00022
-- ----------------------------
INSERT INTO `00022` VALUES ('单人间', '35', '120');
INSERT INTO `00022` VALUES ('标间', '14', '220');
INSERT INTO `00022` VALUES ('套间', '3', '350');

-- ----------------------------
-- Table structure for 00023
-- ----------------------------
DROP TABLE IF EXISTS `00023`;
CREATE TABLE `00023` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00023
-- ----------------------------
INSERT INTO `00023` VALUES ('单人间', '34', '120');
INSERT INTO `00023` VALUES ('标间', '15', '220');
INSERT INTO `00023` VALUES ('套间', '6', '350');

-- ----------------------------
-- Table structure for 00024
-- ----------------------------
DROP TABLE IF EXISTS `00024`;
CREATE TABLE `00024` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00024
-- ----------------------------
INSERT INTO `00024` VALUES ('单人间', '24', '120');
INSERT INTO `00024` VALUES ('标间', '16', '220');
INSERT INTO `00024` VALUES ('套间', '4', '350');

-- ----------------------------
-- Table structure for 00025
-- ----------------------------
DROP TABLE IF EXISTS `00025`;
CREATE TABLE `00025` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00025
-- ----------------------------
INSERT INTO `00025` VALUES ('单人间', '25', '120');
INSERT INTO `00025` VALUES ('标间', '10', '220');
INSERT INTO `00025` VALUES ('套间', '3', '350');

-- ----------------------------
-- Table structure for 00026
-- ----------------------------
DROP TABLE IF EXISTS `00026`;
CREATE TABLE `00026` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00026
-- ----------------------------
INSERT INTO `00026` VALUES ('单人间', '30', '120');
INSERT INTO `00026` VALUES ('标间', '14', '220');
INSERT INTO `00026` VALUES ('套间', '5', '350');

-- ----------------------------
-- Table structure for 00027
-- ----------------------------
DROP TABLE IF EXISTS `00027`;
CREATE TABLE `00027` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00027
-- ----------------------------
INSERT INTO `00027` VALUES ('单人间', '36', '120');
INSERT INTO `00027` VALUES ('标间', '18', '220');
INSERT INTO `00027` VALUES ('套间', '6', '350');

-- ----------------------------
-- Table structure for 00028
-- ----------------------------
DROP TABLE IF EXISTS `00028`;
CREATE TABLE `00028` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00028
-- ----------------------------
INSERT INTO `00028` VALUES ('单人间', '37', '120');
INSERT INTO `00028` VALUES ('标间', '13', '220');
INSERT INTO `00028` VALUES ('套间', '3', '350');

-- ----------------------------
-- Table structure for 00029
-- ----------------------------
DROP TABLE IF EXISTS `00029`;
CREATE TABLE `00029` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00029
-- ----------------------------
INSERT INTO `00029` VALUES ('单人间', '33', '120');
INSERT INTO `00029` VALUES ('标间', '10', '220');
INSERT INTO `00029` VALUES ('套间', '4', '350');

-- ----------------------------
-- Table structure for 00030
-- ----------------------------
DROP TABLE IF EXISTS `00030`;
CREATE TABLE `00030` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00030
-- ----------------------------
INSERT INTO `00030` VALUES ('单人间', '19', '120');
INSERT INTO `00030` VALUES ('标间', '17', '220');
INSERT INTO `00030` VALUES ('套间', '6', '350');

-- ----------------------------
-- Table structure for 00031
-- ----------------------------
DROP TABLE IF EXISTS `00031`;
CREATE TABLE `00031` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00031
-- ----------------------------
INSERT INTO `00031` VALUES ('单人间', '34', '120');
INSERT INTO `00031` VALUES ('标间', '17', '220');
INSERT INTO `00031` VALUES ('套间', '6', '350');

-- ----------------------------
-- Table structure for 00032
-- ----------------------------
DROP TABLE IF EXISTS `00032`;
CREATE TABLE `00032` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00032
-- ----------------------------
INSERT INTO `00032` VALUES ('单人间', '23', '120');
INSERT INTO `00032` VALUES ('标间', '13', '220');
INSERT INTO `00032` VALUES ('套间', '6', '350');

-- ----------------------------
-- Table structure for 00033
-- ----------------------------
DROP TABLE IF EXISTS `00033`;
CREATE TABLE `00033` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00033
-- ----------------------------
INSERT INTO `00033` VALUES ('单人间', '21', '120');
INSERT INTO `00033` VALUES ('标间', '12', '220');
INSERT INTO `00033` VALUES ('套间', '5', '350');

-- ----------------------------
-- Table structure for 00034
-- ----------------------------
DROP TABLE IF EXISTS `00034`;
CREATE TABLE `00034` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00034
-- ----------------------------
INSERT INTO `00034` VALUES ('单人间', '39', '120');
INSERT INTO `00034` VALUES ('标间', '17', '220');
INSERT INTO `00034` VALUES ('套间', '3', '350');

-- ----------------------------
-- Table structure for 00035
-- ----------------------------
DROP TABLE IF EXISTS `00035`;
CREATE TABLE `00035` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00035
-- ----------------------------
INSERT INTO `00035` VALUES ('单人间', '21', '120');
INSERT INTO `00035` VALUES ('标间', '13', '220');
INSERT INTO `00035` VALUES ('套间', '7', '350');

-- ----------------------------
-- Table structure for 00036
-- ----------------------------
DROP TABLE IF EXISTS `00036`;
CREATE TABLE `00036` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00036
-- ----------------------------
INSERT INTO `00036` VALUES ('单人间', '18', '120');
INSERT INTO `00036` VALUES ('标间', '11', '220');
INSERT INTO `00036` VALUES ('套间', '5', '350');

-- ----------------------------
-- Table structure for 00037
-- ----------------------------
DROP TABLE IF EXISTS `00037`;
CREATE TABLE `00037` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00037
-- ----------------------------
INSERT INTO `00037` VALUES ('单人间', '37', '120');
INSERT INTO `00037` VALUES ('标间', '18', '220');
INSERT INTO `00037` VALUES ('套间', '7', '350');

-- ----------------------------
-- Table structure for 00038
-- ----------------------------
DROP TABLE IF EXISTS `00038`;
CREATE TABLE `00038` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00038
-- ----------------------------
INSERT INTO `00038` VALUES ('单人间', '27', '120');
INSERT INTO `00038` VALUES ('标间', '17', '220');
INSERT INTO `00038` VALUES ('套间', '5', '350');

-- ----------------------------
-- Table structure for 00039
-- ----------------------------
DROP TABLE IF EXISTS `00039`;
CREATE TABLE `00039` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00039
-- ----------------------------
INSERT INTO `00039` VALUES ('单人间', '29', '120');
INSERT INTO `00039` VALUES ('标间', '19', '220');
INSERT INTO `00039` VALUES ('套间', '3', '350');

-- ----------------------------
-- Table structure for 00040
-- ----------------------------
DROP TABLE IF EXISTS `00040`;
CREATE TABLE `00040` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00040
-- ----------------------------
INSERT INTO `00040` VALUES ('单人间', '16', '120');
INSERT INTO `00040` VALUES ('标间', '15', '220');
INSERT INTO `00040` VALUES ('套间', '6', '350');

-- ----------------------------
-- Table structure for 00041
-- ----------------------------
DROP TABLE IF EXISTS `00041`;
CREATE TABLE `00041` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00041
-- ----------------------------
INSERT INTO `00041` VALUES ('单人间', '30', '120');
INSERT INTO `00041` VALUES ('标间', '10', '220');
INSERT INTO `00041` VALUES ('套间', '4', '350');

-- ----------------------------
-- Table structure for 00042
-- ----------------------------
DROP TABLE IF EXISTS `00042`;
CREATE TABLE `00042` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00042
-- ----------------------------
INSERT INTO `00042` VALUES ('单人间', '27', '120');
INSERT INTO `00042` VALUES ('标间', '13', '220');
INSERT INTO `00042` VALUES ('套间', '5', '350');

-- ----------------------------
-- Table structure for 00043
-- ----------------------------
DROP TABLE IF EXISTS `00043`;
CREATE TABLE `00043` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00043
-- ----------------------------
INSERT INTO `00043` VALUES ('单人间', '34', '120');
INSERT INTO `00043` VALUES ('标间', '10', '220');
INSERT INTO `00043` VALUES ('套间', '6', '350');

-- ----------------------------
-- Table structure for 00044
-- ----------------------------
DROP TABLE IF EXISTS `00044`;
CREATE TABLE `00044` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00044
-- ----------------------------
INSERT INTO `00044` VALUES ('单人间', '35', '120');
INSERT INTO `00044` VALUES ('标间', '16', '220');
INSERT INTO `00044` VALUES ('套间', '7', '350');

-- ----------------------------
-- Table structure for 00045
-- ----------------------------
DROP TABLE IF EXISTS `00045`;
CREATE TABLE `00045` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00045
-- ----------------------------
INSERT INTO `00045` VALUES ('单人间', '35', '120');
INSERT INTO `00045` VALUES ('标间', '19', '220');
INSERT INTO `00045` VALUES ('套间', '5', '350');

-- ----------------------------
-- Table structure for 00046
-- ----------------------------
DROP TABLE IF EXISTS `00046`;
CREATE TABLE `00046` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00046
-- ----------------------------
INSERT INTO `00046` VALUES ('单人间', '31', '120');
INSERT INTO `00046` VALUES ('标间', '15', '220');
INSERT INTO `00046` VALUES ('套间', '7', '350');

-- ----------------------------
-- Table structure for 00047
-- ----------------------------
DROP TABLE IF EXISTS `00047`;
CREATE TABLE `00047` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00047
-- ----------------------------
INSERT INTO `00047` VALUES ('单人间', '30', '120');
INSERT INTO `00047` VALUES ('标间', '14', '220');
INSERT INTO `00047` VALUES ('套间', '5', '350');

-- ----------------------------
-- Table structure for 00048
-- ----------------------------
DROP TABLE IF EXISTS `00048`;
CREATE TABLE `00048` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00048
-- ----------------------------
INSERT INTO `00048` VALUES ('单人间', '34', '120');
INSERT INTO `00048` VALUES ('标间', '15', '220');
INSERT INTO `00048` VALUES ('套间', '5', '350');

-- ----------------------------
-- Table structure for 00049
-- ----------------------------
DROP TABLE IF EXISTS `00049`;
CREATE TABLE `00049` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00049
-- ----------------------------
INSERT INTO `00049` VALUES ('单人间', '35', '120');
INSERT INTO `00049` VALUES ('标间', '14', '220');
INSERT INTO `00049` VALUES ('套间', '3', '350');

-- ----------------------------
-- Table structure for 00050
-- ----------------------------
DROP TABLE IF EXISTS `00050`;
CREATE TABLE `00050` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00050
-- ----------------------------
INSERT INTO `00050` VALUES ('单人间', '32', '120');
INSERT INTO `00050` VALUES ('标间', '12', '220');
INSERT INTO `00050` VALUES ('套间', '5', '350');

-- ----------------------------
-- Table structure for 00051
-- ----------------------------
DROP TABLE IF EXISTS `00051`;
CREATE TABLE `00051` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00051
-- ----------------------------
INSERT INTO `00051` VALUES ('单人间', '21', '120');
INSERT INTO `00051` VALUES ('标间', '18', '220');
INSERT INTO `00051` VALUES ('套间', '6', '350');

-- ----------------------------
-- Table structure for 00052
-- ----------------------------
DROP TABLE IF EXISTS `00052`;
CREATE TABLE `00052` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00052
-- ----------------------------
INSERT INTO `00052` VALUES ('单人间', '40', '120');
INSERT INTO `00052` VALUES ('标间', '17', '220');
INSERT INTO `00052` VALUES ('套间', '6', '350');

-- ----------------------------
-- Table structure for 00053
-- ----------------------------
DROP TABLE IF EXISTS `00053`;
CREATE TABLE `00053` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00053
-- ----------------------------
INSERT INTO `00053` VALUES ('单人间', '24', '120');
INSERT INTO `00053` VALUES ('标间', '16', '220');
INSERT INTO `00053` VALUES ('套间', '3', '350');

-- ----------------------------
-- Table structure for 00054
-- ----------------------------
DROP TABLE IF EXISTS `00054`;
CREATE TABLE `00054` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00054
-- ----------------------------
INSERT INTO `00054` VALUES ('单人间', '30', '120');
INSERT INTO `00054` VALUES ('标间', '16', '220');
INSERT INTO `00054` VALUES ('套间', '4', '350');

-- ----------------------------
-- Table structure for 00055
-- ----------------------------
DROP TABLE IF EXISTS `00055`;
CREATE TABLE `00055` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00055
-- ----------------------------
INSERT INTO `00055` VALUES ('单人间', '31', '120');
INSERT INTO `00055` VALUES ('标间', '12', '220');
INSERT INTO `00055` VALUES ('套间', '4', '350');

-- ----------------------------
-- Table structure for 00056
-- ----------------------------
DROP TABLE IF EXISTS `00056`;
CREATE TABLE `00056` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00056
-- ----------------------------
INSERT INTO `00056` VALUES ('单人间', '28', '120');
INSERT INTO `00056` VALUES ('标间', '18', '220');
INSERT INTO `00056` VALUES ('套间', '7', '350');

-- ----------------------------
-- Table structure for 00057
-- ----------------------------
DROP TABLE IF EXISTS `00057`;
CREATE TABLE `00057` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00057
-- ----------------------------
INSERT INTO `00057` VALUES ('单人间', '34', '120');
INSERT INTO `00057` VALUES ('标间', '10', '220');
INSERT INTO `00057` VALUES ('套间', '3', '350');

-- ----------------------------
-- Table structure for 00058
-- ----------------------------
DROP TABLE IF EXISTS `00058`;
CREATE TABLE `00058` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00058
-- ----------------------------
INSERT INTO `00058` VALUES ('单人间', '27', '120');
INSERT INTO `00058` VALUES ('标间', '18', '220');
INSERT INTO `00058` VALUES ('套间', '6', '350');

-- ----------------------------
-- Table structure for 00059
-- ----------------------------
DROP TABLE IF EXISTS `00059`;
CREATE TABLE `00059` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00059
-- ----------------------------
INSERT INTO `00059` VALUES ('单人间', '22', '120');
INSERT INTO `00059` VALUES ('标间', '10', '220');
INSERT INTO `00059` VALUES ('套间', '6', '350');

-- ----------------------------
-- Table structure for 00060
-- ----------------------------
DROP TABLE IF EXISTS `00060`;
CREATE TABLE `00060` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00060
-- ----------------------------
INSERT INTO `00060` VALUES ('单人间', '16', '120');
INSERT INTO `00060` VALUES ('标间', '10', '220');
INSERT INTO `00060` VALUES ('套间', '4', '350');

-- ----------------------------
-- Table structure for 00061
-- ----------------------------
DROP TABLE IF EXISTS `00061`;
CREATE TABLE `00061` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00061
-- ----------------------------
INSERT INTO `00061` VALUES ('单人间', '16', '120');
INSERT INTO `00061` VALUES ('标间', '13', '220');
INSERT INTO `00061` VALUES ('套间', '6', '350');

-- ----------------------------
-- Table structure for 00062
-- ----------------------------
DROP TABLE IF EXISTS `00062`;
CREATE TABLE `00062` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00062
-- ----------------------------
INSERT INTO `00062` VALUES ('单人间', '25', '120');
INSERT INTO `00062` VALUES ('标间', '19', '220');
INSERT INTO `00062` VALUES ('套间', '4', '350');

-- ----------------------------
-- Table structure for 00063
-- ----------------------------
DROP TABLE IF EXISTS `00063`;
CREATE TABLE `00063` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00063
-- ----------------------------
INSERT INTO `00063` VALUES ('单人间', '40', '120');
INSERT INTO `00063` VALUES ('标间', '19', '220');
INSERT INTO `00063` VALUES ('套间', '7', '350');

-- ----------------------------
-- Table structure for 00064
-- ----------------------------
DROP TABLE IF EXISTS `00064`;
CREATE TABLE `00064` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00064
-- ----------------------------
INSERT INTO `00064` VALUES ('单人间', '20', '120');
INSERT INTO `00064` VALUES ('标间', '15', '220');
INSERT INTO `00064` VALUES ('套间', '3', '350');

-- ----------------------------
-- Table structure for 00065
-- ----------------------------
DROP TABLE IF EXISTS `00065`;
CREATE TABLE `00065` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00065
-- ----------------------------
INSERT INTO `00065` VALUES ('单人间', '34', '120');
INSERT INTO `00065` VALUES ('标间', '15', '220');
INSERT INTO `00065` VALUES ('套间', '5', '350');

-- ----------------------------
-- Table structure for 00066
-- ----------------------------
DROP TABLE IF EXISTS `00066`;
CREATE TABLE `00066` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00066
-- ----------------------------
INSERT INTO `00066` VALUES ('单人间', '36', '120');
INSERT INTO `00066` VALUES ('标间', '15', '220');
INSERT INTO `00066` VALUES ('套间', '4', '350');

-- ----------------------------
-- Table structure for 00067
-- ----------------------------
DROP TABLE IF EXISTS `00067`;
CREATE TABLE `00067` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00067
-- ----------------------------
INSERT INTO `00067` VALUES ('单人间', '36', '120');
INSERT INTO `00067` VALUES ('标间', '12', '220');
INSERT INTO `00067` VALUES ('套间', '7', '350');

-- ----------------------------
-- Table structure for 00068
-- ----------------------------
DROP TABLE IF EXISTS `00068`;
CREATE TABLE `00068` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00068
-- ----------------------------
INSERT INTO `00068` VALUES ('单人间', '28', '120');
INSERT INTO `00068` VALUES ('标间', '18', '220');
INSERT INTO `00068` VALUES ('套间', '7', '350');

-- ----------------------------
-- Table structure for 00069
-- ----------------------------
DROP TABLE IF EXISTS `00069`;
CREATE TABLE `00069` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00069
-- ----------------------------
INSERT INTO `00069` VALUES ('单人间', '22', '120');
INSERT INTO `00069` VALUES ('标间', '13', '220');
INSERT INTO `00069` VALUES ('套间', '7', '350');

-- ----------------------------
-- Table structure for 00070
-- ----------------------------
DROP TABLE IF EXISTS `00070`;
CREATE TABLE `00070` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00070
-- ----------------------------
INSERT INTO `00070` VALUES ('单人间', '28', '120');
INSERT INTO `00070` VALUES ('标间', '17', '220');
INSERT INTO `00070` VALUES ('套间', '4', '350');

-- ----------------------------
-- Table structure for 00071
-- ----------------------------
DROP TABLE IF EXISTS `00071`;
CREATE TABLE `00071` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00071
-- ----------------------------
INSERT INTO `00071` VALUES ('单人间', '31', '120');
INSERT INTO `00071` VALUES ('标间', '19', '220');
INSERT INTO `00071` VALUES ('套间', '6', '350');

-- ----------------------------
-- Table structure for 00072
-- ----------------------------
DROP TABLE IF EXISTS `00072`;
CREATE TABLE `00072` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00072
-- ----------------------------
INSERT INTO `00072` VALUES ('单人间', '36', '120');
INSERT INTO `00072` VALUES ('标间', '19', '220');
INSERT INTO `00072` VALUES ('套间', '5', '350');

-- ----------------------------
-- Table structure for 00073
-- ----------------------------
DROP TABLE IF EXISTS `00073`;
CREATE TABLE `00073` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00073
-- ----------------------------
INSERT INTO `00073` VALUES ('单人间', '27', '120');
INSERT INTO `00073` VALUES ('标间', '19', '220');
INSERT INTO `00073` VALUES ('套间', '3', '350');

-- ----------------------------
-- Table structure for 00074
-- ----------------------------
DROP TABLE IF EXISTS `00074`;
CREATE TABLE `00074` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00074
-- ----------------------------
INSERT INTO `00074` VALUES ('单人间', '34', '120');
INSERT INTO `00074` VALUES ('标间', '14', '220');
INSERT INTO `00074` VALUES ('套间', '3', '350');

-- ----------------------------
-- Table structure for 00075
-- ----------------------------
DROP TABLE IF EXISTS `00075`;
CREATE TABLE `00075` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00075
-- ----------------------------
INSERT INTO `00075` VALUES ('单人间', '26', '120');
INSERT INTO `00075` VALUES ('标间', '16', '220');
INSERT INTO `00075` VALUES ('套间', '7', '350');

-- ----------------------------
-- Table structure for 00076
-- ----------------------------
DROP TABLE IF EXISTS `00076`;
CREATE TABLE `00076` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00076
-- ----------------------------
INSERT INTO `00076` VALUES ('单人间', '28', '120');
INSERT INTO `00076` VALUES ('标间', '18', '220');
INSERT INTO `00076` VALUES ('套间', '6', '350');

-- ----------------------------
-- Table structure for 00077
-- ----------------------------
DROP TABLE IF EXISTS `00077`;
CREATE TABLE `00077` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00077
-- ----------------------------
INSERT INTO `00077` VALUES ('单人间', '18', '120');
INSERT INTO `00077` VALUES ('标间', '12', '220');
INSERT INTO `00077` VALUES ('套间', '4', '350');

-- ----------------------------
-- Table structure for 00078
-- ----------------------------
DROP TABLE IF EXISTS `00078`;
CREATE TABLE `00078` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00078
-- ----------------------------
INSERT INTO `00078` VALUES ('单人间', '20', '120');
INSERT INTO `00078` VALUES ('标间', '11', '220');
INSERT INTO `00078` VALUES ('套间', '5', '350');

-- ----------------------------
-- Table structure for 00079
-- ----------------------------
DROP TABLE IF EXISTS `00079`;
CREATE TABLE `00079` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00079
-- ----------------------------
INSERT INTO `00079` VALUES ('单人间', '35', '120');
INSERT INTO `00079` VALUES ('标间', '15', '220');
INSERT INTO `00079` VALUES ('套间', '4', '350');

-- ----------------------------
-- Table structure for 00080
-- ----------------------------
DROP TABLE IF EXISTS `00080`;
CREATE TABLE `00080` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00080
-- ----------------------------
INSERT INTO `00080` VALUES ('单人间', '35', '120');
INSERT INTO `00080` VALUES ('标间', '11', '220');
INSERT INTO `00080` VALUES ('套间', '4', '350');

-- ----------------------------
-- Table structure for 00081
-- ----------------------------
DROP TABLE IF EXISTS `00081`;
CREATE TABLE `00081` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00081
-- ----------------------------
INSERT INTO `00081` VALUES ('单人间', '19', '120');
INSERT INTO `00081` VALUES ('标间', '17', '220');
INSERT INTO `00081` VALUES ('套间', '5', '350');

-- ----------------------------
-- Table structure for 00082
-- ----------------------------
DROP TABLE IF EXISTS `00082`;
CREATE TABLE `00082` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00082
-- ----------------------------
INSERT INTO `00082` VALUES ('单人间', '18', '120');
INSERT INTO `00082` VALUES ('标间', '11', '220');
INSERT INTO `00082` VALUES ('套间', '3', '350');

-- ----------------------------
-- Table structure for 00083
-- ----------------------------
DROP TABLE IF EXISTS `00083`;
CREATE TABLE `00083` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00083
-- ----------------------------
INSERT INTO `00083` VALUES ('单人间', '31', '120');
INSERT INTO `00083` VALUES ('标间', '15', '220');
INSERT INTO `00083` VALUES ('套间', '3', '350');

-- ----------------------------
-- Table structure for 00084
-- ----------------------------
DROP TABLE IF EXISTS `00084`;
CREATE TABLE `00084` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00084
-- ----------------------------
INSERT INTO `00084` VALUES ('单人间', '30', '120');
INSERT INTO `00084` VALUES ('标间', '16', '220');
INSERT INTO `00084` VALUES ('套间', '4', '350');

-- ----------------------------
-- Table structure for 00085
-- ----------------------------
DROP TABLE IF EXISTS `00085`;
CREATE TABLE `00085` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00085
-- ----------------------------
INSERT INTO `00085` VALUES ('单人间', '35', '120');
INSERT INTO `00085` VALUES ('标间', '19', '220');
INSERT INTO `00085` VALUES ('套间', '5', '350');

-- ----------------------------
-- Table structure for 00086
-- ----------------------------
DROP TABLE IF EXISTS `00086`;
CREATE TABLE `00086` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00086
-- ----------------------------
INSERT INTO `00086` VALUES ('单人间', '35', '120');
INSERT INTO `00086` VALUES ('标间', '12', '220');
INSERT INTO `00086` VALUES ('套间', '7', '350');

-- ----------------------------
-- Table structure for 00087
-- ----------------------------
DROP TABLE IF EXISTS `00087`;
CREATE TABLE `00087` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00087
-- ----------------------------
INSERT INTO `00087` VALUES ('单人间', '16', '120');
INSERT INTO `00087` VALUES ('标间', '12', '220');
INSERT INTO `00087` VALUES ('套间', '4', '350');

-- ----------------------------
-- Table structure for 00088
-- ----------------------------
DROP TABLE IF EXISTS `00088`;
CREATE TABLE `00088` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00088
-- ----------------------------
INSERT INTO `00088` VALUES ('单人间', '31', '120');
INSERT INTO `00088` VALUES ('标间', '12', '220');
INSERT INTO `00088` VALUES ('套间', '4', '350');

-- ----------------------------
-- Table structure for 00089
-- ----------------------------
DROP TABLE IF EXISTS `00089`;
CREATE TABLE `00089` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00089
-- ----------------------------
INSERT INTO `00089` VALUES ('单人间', '38', '120');
INSERT INTO `00089` VALUES ('标间', '15', '220');
INSERT INTO `00089` VALUES ('套间', '3', '350');

-- ----------------------------
-- Table structure for 00090
-- ----------------------------
DROP TABLE IF EXISTS `00090`;
CREATE TABLE `00090` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00090
-- ----------------------------
INSERT INTO `00090` VALUES ('单人间', '32', '120');
INSERT INTO `00090` VALUES ('标间', '11', '220');
INSERT INTO `00090` VALUES ('套间', '6', '350');

-- ----------------------------
-- Table structure for 00091
-- ----------------------------
DROP TABLE IF EXISTS `00091`;
CREATE TABLE `00091` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00091
-- ----------------------------
INSERT INTO `00091` VALUES ('单人间', '35', '120');
INSERT INTO `00091` VALUES ('标间', '10', '220');
INSERT INTO `00091` VALUES ('套间', '7', '350');

-- ----------------------------
-- Table structure for 00092
-- ----------------------------
DROP TABLE IF EXISTS `00092`;
CREATE TABLE `00092` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00092
-- ----------------------------
INSERT INTO `00092` VALUES ('单人间', '23', '120');
INSERT INTO `00092` VALUES ('标间', '18', '220');
INSERT INTO `00092` VALUES ('套间', '4', '350');

-- ----------------------------
-- Table structure for 00093
-- ----------------------------
DROP TABLE IF EXISTS `00093`;
CREATE TABLE `00093` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00093
-- ----------------------------
INSERT INTO `00093` VALUES ('单人间', '34', '120');
INSERT INTO `00093` VALUES ('标间', '19', '220');
INSERT INTO `00093` VALUES ('套间', '6', '350');

-- ----------------------------
-- Table structure for 00094
-- ----------------------------
DROP TABLE IF EXISTS `00094`;
CREATE TABLE `00094` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00094
-- ----------------------------
INSERT INTO `00094` VALUES ('单人间', '33', '120');
INSERT INTO `00094` VALUES ('标间', '12', '220');
INSERT INTO `00094` VALUES ('套间', '3', '350');

-- ----------------------------
-- Table structure for 00095
-- ----------------------------
DROP TABLE IF EXISTS `00095`;
CREATE TABLE `00095` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00095
-- ----------------------------
INSERT INTO `00095` VALUES ('单人间', '25', '120');
INSERT INTO `00095` VALUES ('标间', '18', '220');
INSERT INTO `00095` VALUES ('套间', '4', '350');

-- ----------------------------
-- Table structure for 00096
-- ----------------------------
DROP TABLE IF EXISTS `00096`;
CREATE TABLE `00096` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00096
-- ----------------------------
INSERT INTO `00096` VALUES ('单人间', '26', '120');
INSERT INTO `00096` VALUES ('标间', '15', '220');
INSERT INTO `00096` VALUES ('套间', '4', '350');

-- ----------------------------
-- Table structure for 00097
-- ----------------------------
DROP TABLE IF EXISTS `00097`;
CREATE TABLE `00097` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00097
-- ----------------------------
INSERT INTO `00097` VALUES ('单人间', '35', '120');
INSERT INTO `00097` VALUES ('标间', '10', '220');
INSERT INTO `00097` VALUES ('套间', '3', '350');

-- ----------------------------
-- Table structure for 00098
-- ----------------------------
DROP TABLE IF EXISTS `00098`;
CREATE TABLE `00098` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00098
-- ----------------------------
INSERT INTO `00098` VALUES ('单人间', '17', '120');
INSERT INTO `00098` VALUES ('标间', '11', '220');
INSERT INTO `00098` VALUES ('套间', '6', '350');

-- ----------------------------
-- Table structure for 00099
-- ----------------------------
DROP TABLE IF EXISTS `00099`;
CREATE TABLE `00099` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00099
-- ----------------------------
INSERT INTO `00099` VALUES ('单人间', '36', '120');
INSERT INTO `00099` VALUES ('标间', '11', '220');
INSERT INTO `00099` VALUES ('套间', '4', '350');

-- ----------------------------
-- Table structure for 00100
-- ----------------------------
DROP TABLE IF EXISTS `00100`;
CREATE TABLE `00100` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00100
-- ----------------------------
INSERT INTO `00100` VALUES ('单人间', '22', '120');
INSERT INTO `00100` VALUES ('标间', '11', '220');
INSERT INTO `00100` VALUES ('套间', '3', '350');

-- ----------------------------
-- Table structure for 00101
-- ----------------------------
DROP TABLE IF EXISTS `00101`;
CREATE TABLE `00101` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00101
-- ----------------------------
INSERT INTO `00101` VALUES ('单人间', '31', '120');
INSERT INTO `00101` VALUES ('标间', '11', '220');
INSERT INTO `00101` VALUES ('套间', '6', '350');

-- ----------------------------
-- Table structure for 00102
-- ----------------------------
DROP TABLE IF EXISTS `00102`;
CREATE TABLE `00102` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00102
-- ----------------------------
INSERT INTO `00102` VALUES ('单人间', '36', '120');
INSERT INTO `00102` VALUES ('标间', '11', '220');
INSERT INTO `00102` VALUES ('套间', '5', '350');

-- ----------------------------
-- Table structure for 00103
-- ----------------------------
DROP TABLE IF EXISTS `00103`;
CREATE TABLE `00103` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00103
-- ----------------------------
INSERT INTO `00103` VALUES ('单人间', '18', '120');
INSERT INTO `00103` VALUES ('标间', '19', '220');
INSERT INTO `00103` VALUES ('套间', '4', '350');

-- ----------------------------
-- Table structure for 00104
-- ----------------------------
DROP TABLE IF EXISTS `00104`;
CREATE TABLE `00104` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00104
-- ----------------------------
INSERT INTO `00104` VALUES ('单人间', '31', '120');
INSERT INTO `00104` VALUES ('标间', '12', '220');
INSERT INTO `00104` VALUES ('套间', '4', '350');

-- ----------------------------
-- Table structure for 00105
-- ----------------------------
DROP TABLE IF EXISTS `00105`;
CREATE TABLE `00105` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00105
-- ----------------------------
INSERT INTO `00105` VALUES ('单人间', '31', '120');
INSERT INTO `00105` VALUES ('标间', '12', '220');
INSERT INTO `00105` VALUES ('套间', '6', '350');

-- ----------------------------
-- Table structure for 00106
-- ----------------------------
DROP TABLE IF EXISTS `00106`;
CREATE TABLE `00106` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00106
-- ----------------------------
INSERT INTO `00106` VALUES ('单人间', '20', '120');
INSERT INTO `00106` VALUES ('标间', '10', '220');
INSERT INTO `00106` VALUES ('套间', '5', '350');

-- ----------------------------
-- Table structure for 00107
-- ----------------------------
DROP TABLE IF EXISTS `00107`;
CREATE TABLE `00107` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00107
-- ----------------------------
INSERT INTO `00107` VALUES ('单人间', '33', '120');
INSERT INTO `00107` VALUES ('标间', '18', '220');
INSERT INTO `00107` VALUES ('套间', '4', '350');

-- ----------------------------
-- Table structure for 00108
-- ----------------------------
DROP TABLE IF EXISTS `00108`;
CREATE TABLE `00108` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00108
-- ----------------------------
INSERT INTO `00108` VALUES ('单人间', '38', '120');
INSERT INTO `00108` VALUES ('标间', '15', '220');
INSERT INTO `00108` VALUES ('套间', '4', '350');

-- ----------------------------
-- Table structure for 00109
-- ----------------------------
DROP TABLE IF EXISTS `00109`;
CREATE TABLE `00109` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00109
-- ----------------------------
INSERT INTO `00109` VALUES ('单人间', '27', '120');
INSERT INTO `00109` VALUES ('标间', '14', '220');
INSERT INTO `00109` VALUES ('套间', '3', '350');

-- ----------------------------
-- Table structure for 00110
-- ----------------------------
DROP TABLE IF EXISTS `00110`;
CREATE TABLE `00110` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00110
-- ----------------------------
INSERT INTO `00110` VALUES ('单人间', '40', '120');
INSERT INTO `00110` VALUES ('标间', '16', '220');
INSERT INTO `00110` VALUES ('套间', '5', '350');

-- ----------------------------
-- Table structure for 00111
-- ----------------------------
DROP TABLE IF EXISTS `00111`;
CREATE TABLE `00111` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00111
-- ----------------------------
INSERT INTO `00111` VALUES ('单人间', '26', '120');
INSERT INTO `00111` VALUES ('标间', '15', '220');
INSERT INTO `00111` VALUES ('套间', '5', '350');

-- ----------------------------
-- Table structure for 00112
-- ----------------------------
DROP TABLE IF EXISTS `00112`;
CREATE TABLE `00112` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00112
-- ----------------------------
INSERT INTO `00112` VALUES ('单人间', '17', '120');
INSERT INTO `00112` VALUES ('标间', '15', '220');
INSERT INTO `00112` VALUES ('套间', '6', '350');

-- ----------------------------
-- Table structure for 00113
-- ----------------------------
DROP TABLE IF EXISTS `00113`;
CREATE TABLE `00113` (
  `RoomType` text,
  `RoomNum` int(11) DEFAULT NULL,
  `RoomPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 00113
-- ----------------------------
INSERT INTO `00113` VALUES ('单人间', '19', '120');
INSERT INTO `00113` VALUES ('标间', '13', '220');
INSERT INTO `00113` VALUES ('套间', '5', '350');

-- ----------------------------
-- Table structure for cityandarea
-- ----------------------------
DROP TABLE IF EXISTS `cityandarea`;
CREATE TABLE `cityandarea` (
  `cityname` text,
  `tradearea` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cityandarea
-- ----------------------------
INSERT INTO `cityandarea` VALUES ('南京', '新街口');
INSERT INTO `cityandarea` VALUES ('南京', '夫子庙');
INSERT INTO `cityandarea` VALUES ('南京', '湖南路');
INSERT INTO `cityandarea` VALUES ('南京', '河西');
INSERT INTO `cityandarea` VALUES ('南京', '百家湖');
INSERT INTO `cityandarea` VALUES ('南京', '仙林');
INSERT INTO `cityandarea` VALUES ('南京', '桥北');
INSERT INTO `cityandarea` VALUES ('北京', '西单');
INSERT INTO `cityandarea` VALUES ('北京', '王府井');
INSERT INTO `cityandarea` VALUES ('北京', '崇文门');
INSERT INTO `cityandarea` VALUES ('北京', '国贸');
INSERT INTO `cityandarea` VALUES ('北京', '中关村');
INSERT INTO `cityandarea` VALUES ('北京', '三里屯');
INSERT INTO `cityandarea` VALUES ('上海', '徐家汇');
INSERT INTO `cityandarea` VALUES ('上海', '陆家嘴');
INSERT INTO `cityandarea` VALUES ('上海', '五角场');
INSERT INTO `cityandarea` VALUES ('上海', '曹安路');
INSERT INTO `cityandarea` VALUES ('上海', '中山公园');
INSERT INTO `cityandarea` VALUES ('上海', '淮海路');
INSERT INTO `cityandarea` VALUES ('上海', '南京南路');
INSERT INTO `cityandarea` VALUES ('上海', '南京东路');
INSERT INTO `cityandarea` VALUES ('广州', '天河');
INSERT INTO `cityandarea` VALUES ('广州', '珠江新城');
INSERT INTO `cityandarea` VALUES ('广州', '北京路');
INSERT INTO `cityandarea` VALUES ('广州', '岗顶数码');
INSERT INTO `cityandarea` VALUES ('广州', '西关');
INSERT INTO `cityandarea` VALUES ('广州', '江南西');
INSERT INTO `cityandarea` VALUES ('广州', '番禺大北路');
INSERT INTO `cityandarea` VALUES ('广州', '流花');
INSERT INTO `cityandarea` VALUES ('广州', '白鹅潭');
INSERT INTO `cityandarea` VALUES ('广州', '东山');
INSERT INTO `cityandarea` VALUES ('成都', '春熙路');
INSERT INTO `cityandarea` VALUES ('成都', '天府新城');
INSERT INTO `cityandarea` VALUES ('成都', '新双楠尚品广场');
INSERT INTO `cityandarea` VALUES ('成都', '金沙光华');
INSERT INTO `cityandarea` VALUES ('成都', '建设路');
INSERT INTO `cityandarea` VALUES ('成都', '盐市口');
INSERT INTO `cityandarea` VALUES ('成都', '骡马市');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `UserName` text,
  `HotelID` text,
  `CommentDate` datetime DEFAULT NULL,
  `Rank` double DEFAULT NULL,
  `Comment` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('张客户', '00001', '2008-07-12 00:00:00', '4.5', '酒店很好，服务到位，价格公道，环境优美，下次还会再来');

-- ----------------------------
-- Table structure for creditrecord
-- ----------------------------
DROP TABLE IF EXISTS `creditrecord`;
CREATE TABLE `creditrecord` (
  `orderid` text,
  `userid` text,
  `changeddate` datetime DEFAULT NULL,
  `changedvalue` double DEFAULT NULL,
  `result` double DEFAULT NULL,
  `op` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of creditrecord
-- ----------------------------
INSERT INTO `creditrecord` VALUES ('123456789020080606143055', '1234567890', '2008-07-10 00:00:00', '120', '120', '执行订单');
INSERT INTO `creditrecord` VALUES ('123456789020080808221016', '1234567890', '2008-09-10 00:00:00', '120', '240', '执行订单');
INSERT INTO `creditrecord` VALUES ('123456789020081010130101', '1234567890', '2008-10-12 00:00:00', '220', '460', '执行订单');
INSERT INTO `creditrecord` VALUES ('123456789020081212152751', '1234567890', '2008-12-12 00:00:00', '-60', '400', '撤销订单');
INSERT INTO `creditrecord` VALUES ('123456789020081212152311', '1234567890', '2008-12-16 00:00:00', '120', '520', '执行订单');
INSERT INTO `creditrecord` VALUES ('123456789020090202080303', '1234567890', '2009-03-04 00:00:00', '350', '870', '执行订单');
INSERT INTO `creditrecord` VALUES ('123456789020090404121212', '1234567890', '2009-05-06 00:00:00', '120', '990', '执行订单');
INSERT INTO `creditrecord` VALUES ('123456789020090606121212', '1234567890', '2009-07-07 00:00:00', '220', '1210', '执行订单');
INSERT INTO `creditrecord` VALUES ('123456789020101111121212', '1234567890', '2010-11-12 00:00:00', '72', '1282', '执行订单');
INSERT INTO `creditrecord` VALUES ('123456789020101111172222', '1234567890', '2010-11-11 00:00:00', '-36', '1246', '撤销订单');
INSERT INTO `creditrecord` VALUES ('123456789020120101000000', '1234567890', '2012-01-01 00:00:00', '-120', '1126', '异常订单');
INSERT INTO `creditrecord` VALUES ('123456789020120102000000', '1234567890', '2012-01-02 00:00:00', '-120', '1006', '异常订单');
INSERT INTO `creditrecord` VALUES ('123456789020120103000000', '1234567890', '2012-01-03 00:00:00', '-220', '786', '异常订单');
INSERT INTO `creditrecord` VALUES ('123456789020120104000000', '1234567890', '2012-01-04 00:00:00', '-120', '666', '异常订单');
INSERT INTO `creditrecord` VALUES ('123456789020120105000000', '1234567890', '2012-01-05 00:00:00', '-350', '316', '异常订单');
INSERT INTO `creditrecord` VALUES ('123456789020120106000000', '1234567890', '2012-01-06 00:00:00', '-120', '196', '异常订单');
INSERT INTO `creditrecord` VALUES ('123456789020120107000000', '1234567890', '2012-01-07 00:00:00', '-220', '-24', '异常订单');
INSERT INTO `creditrecord` VALUES ('无', '1234567890', '2012-01-07 00:00:00', '2906', '2882', '信用充值');
INSERT INTO `creditrecord` VALUES ('123456789020120108000000', '1234567890', '2012-01-08 00:00:00', '-72', '2810', '异常订单');
INSERT INTO `creditrecord` VALUES ('123456789020080606143055', '1234567890', '2008-07-10 00:00:00', '120', '120', '执行订单');

-- ----------------------------
-- Table structure for hotel
-- ----------------------------
DROP TABLE IF EXISTS `hotel`;
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

-- ----------------------------
-- Records of hotel
-- ----------------------------
INSERT INTO `hotel` VALUES ('00001', '南京1号大酒店', '南京市A区新街口大道163号', '新街口', '南京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.83434891326784', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00002', '南京2号大酒店', '南京市A区新街口大道54号', '新街口', '南京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.91661736608247', '5', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00003', '南京3号大酒店', '南京市A区新街口大道13号', '新街口', '南京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.83434891326784', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00004', '南京4号大酒店', '南京市A区新街口大道666号', '新街口', '南京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.49941642045032', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00005', '南京5号大酒店', '南京市B区夫子庙大道16号', '夫子庙', '南京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.99365474498644', '5', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00006', '南京6号大酒店', '南京市B区夫子庙大道99号', '夫子庙', '南京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.03307958784372', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00007', '南京7号大酒店', '南京市B区夫子庙大道145号', '夫子庙', '南京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.38724500196813', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00008', '南京8号大酒店', '南京市C区湖南路大道64号', '湖南路', '南京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.03583437168273', '2', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00009', '南京9号大酒店', '南京市C区湖南路大道80号', '湖南路', '南京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.4361193716202', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00010', '南京10号大酒店', '南京市C区湖南路大道277号', '湖南路', '南京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.64622103982715', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00011', '南京11号大酒店', '南京市C区湖南路大道1号', '湖南路', '南京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.68986008598912', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00012', '南京12号大酒店', '南京市D区河西大道33号', '河西', '南京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.06397235355856', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00013', '南京13号大酒店', '南京市D区河西大道82号', '河西', '南京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.8610489142618', '5', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00014', '南京14号大酒店', '南京市D区河西大道909号', '河西', '南京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.62049359674451', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00015', '南京15号大酒店', '南京市E区百家湖大道144号', '百家湖', '南京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.57118230858112', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00016', '南京16号大酒店', '南京市E区百家湖大道26号', '百家湖', '南京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.80800892815965', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00017', '南京17号大酒店', '南京市F区仙林大道20号', '仙林', '南京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.96335039983792', '5', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00018', '南京18号大酒店', '南京市F区仙林大道77号', '仙林', '南京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.56940947396616', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00019', '南京19号大酒店', '南京市F区仙林大道51号', '仙林', '南京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.81892362923538', '5', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00020', '南京20号大酒店', '南京市F区仙林大道3号', '仙林', '南京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.93580586044532', '5', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00021', '南京21号大酒店', '南京市F区仙林大道85号', '仙林', '南京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.5353470632701', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00022', '南京22号大酒店', '南京市G区桥北大道69号', '桥北', '南京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.66607547672896', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00023', '南京23号大酒店', '南京市G区桥北大道188号', '桥北', '南京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.11023738279245', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00024', '北京1号大酒店', '北京市A区西单路1号', '西单', '北京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.84685898284328', '5', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00025', '北京2号大酒店', '北京市A区西单路2号', '西单', '北京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.73548620361824', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00026', '北京3号大酒店', '北京市A区西单路4号', '西单', '北京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.65048627938285', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00027', '北京4号大酒店', '北京市F区王府井路8号', '王府井', '北京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.21689648950742', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00028', '北京5号大酒店', '北京市F区王府井路16号', '王府井', '北京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.28094517017787', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00029', '北京6号大酒店', '北京市F区王府井路32号', '王府井', '北京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.70842243307506', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00030', '北京7号大酒店', '北京市B区崇文门路64号', '崇文门', '北京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.4536886921416', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00031', '北京8号大酒店', '北京市B区崇文门路128号', '崇文门', '北京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.62283261751371', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00032', '北京9号大酒店', '北京市B区崇文门路256号', '崇文门', '北京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.84917064903758', '5', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00033', '北京10号大酒店', '北京市B区崇文门路84号', '崇文门', '北京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.88968047065472', '5', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00034', '北京11号大酒店', '北京市C区国贸路91号', '国贸', '北京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.85114346244302', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00035', '北京12号大酒店', '北京市C区国贸路44号', '国贸', '北京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.03878082543093', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00036', '北京13号大酒店', '北京市C区国贸路16号', '国贸', '北京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.08509699758083', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00037', '北京14号大酒店', '北京市C区国贸路101号', '国贸', '北京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.36015672665507', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00038', '北京15号大酒店', '北京市D区中关村路17号', '中关村', '北京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.05313096028933', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00039', '北京16号大酒店', '北京市D区中关村路31号', '中关村', '北京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.88352361296298', '5', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00040', '北京17号大酒店', '北京市D区中关村路48号', '中关村', '北京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.02985192226438', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00041', '北京18号大酒店', '北京市D区中关村路172号', '中关村', '北京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.8401303315292', '5', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00042', '北京19号大酒店', '北京市E区三里屯路336号', '三里屯', '北京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.45950875736421', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00043', '北京20号大酒店', '北京市E区三里屯路75号', '三里屯', '北京', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.04350103720126', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00044', '上海1号大酒店', '上海市A区徐路106号', '徐家汇', '上海', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.69915010241492', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00045', '上海2号大酒店', '上海市A区徐路888号', '徐家汇', '上海', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.05365285783721', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00046', '上海3号大酒店', '上海市A区徐路11号', '徐家汇', '上海', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.0117434214188', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00047', '上海4号大酒店', '上海市A区徐路941号', '徐家汇', '上海', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.88', '5', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00048', '上海5号大酒店', '上海市A区徐路771号', '徐家汇', '上海', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.6557839075034', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00049', '上海6号大酒店', '上海市B区陆路191号', '陆家嘴', '上海', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.46742962625477', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00050', '上海7号大酒店', '上海市B区陆路4号', '陆家嘴', '上海', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.31449087278475', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00051', '上海8号大酒店', '上海市B区陆路10号', '陆家嘴', '上海', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.95060209376754', '5', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00052', '上海9号大酒店', '上海市B区陆路77号', '陆家嘴', '上海', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.38532916163575', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00053', '上海10号大酒店', '上海市C区五角路66号', '五角场', '上海', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.29497467278387', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00054', '上海11号大酒店', '上海市C区五角路55号', '五角场', '上海', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.01144239409671', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00055', '上海12号大酒店', '上海市D区曹安路44号', '曹安路', '上海', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.43346654909636', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00056', '上海13号大酒店', '上海市D区曹安路33号', '曹安路', '上海', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.00672124158783', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00057', '上海14号大酒店', '上海市E区中山路22号', '中山公园', '上海', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.15023757893212', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00058', '上海15号大酒店', '上海市E区中山路11号', '中山公园', '上海', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.92294058513398', '5', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00059', '上海16号大酒店', '上海市E区中山路88号', '中山公园', '上海', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.43079728273312', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00060', '上海17号大酒店', '上海市F区淮海路97号', '淮海路', '上海', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.69400626686192', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00061', '上海18号大酒店', '上海市F区淮海路453号', '淮海路', '上海', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.78930141836191', '5', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00062', '上海19号大酒店', '上海市F区淮海路234号', '淮海路', '上海', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.29283690522504', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00063', '上海20号大酒店', '上海市G区南京南路161号', '南京南路', '上海', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.84290985835349', '5', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00064', '上海21号大酒店', '上海市G区南京南路26号', '南京南路', '上海', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.5430038425658', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00065', '上海22号大酒店', '上海市G区南京南路136号', '南京南路', '上海', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.17108836195408', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00066', '上海23号大酒店', '上海市G区南京南路56号', '南京南路', '上海', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.58201874891673', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00067', '上海24号大酒店', '上海市G区南京南路99号', '南京南路', '上海', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.96', '5', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00068', '上海25号大酒店', '上海市H区南京东路752号', '南京东路', '上海', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.58759169518001', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00069', '上海26号大酒店', '上海市H区南京东路281号', '南京东路', '上海', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.60892832742689', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00070', '上海27号大酒店', '上海市H区南京东路142号', '南京东路', '上海', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.37663314299524', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00071', '上海28号大酒店', '上海市H区南京东路139号', '南京东路', '上海', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.526025595746', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00072', '广州1号大酒店', '广州市A区天河街99号', '天河', '广州', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.63474834531588', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00073', '广州2号大酒店', '广州市A区天河街73号', '天河', '广州', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.43298253365338', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00074', '广州3号大酒店', '广州市B区珠江街71号', '珠江新城', '广州', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.66813114570117', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00075', '广州4号大酒店', '广州市B区珠江街11号', '珠江新城', '广州', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.71607127191102', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00076', '广州5号大酒店', '广州市C区北京街14号', '北京路', '广州', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.78038603055484', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00077', '广州6号大酒店', '广州市C区北京街25号', '北京路', '广州', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.59991512475902', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00078', '广州7号大酒店', '广州市C区北京街13号', '北京路', '广州', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.45826960621898', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00079', '广州8号大酒店', '广州市C区北京街7号', '北京路', '广州', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.53071055980102', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00080', '广州9号大酒店', '广州市C区北京街8号', '北京路', '广州', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.55849508894759', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00081', '广州10号大酒店', '广州市D区数码街18号', '岗顶数码', '广州', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.85951698516384', '5', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00082', '广州11号大酒店', '广州市E区西关街67号', '西关', '广州', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.21203662367741', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00083', '广州12号大酒店', '广州市E区西关街33号', '西关', '广州', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.39000338114148', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00084', '广州13号大酒店', '广州市F区江南西街75号', '江南西', '广州', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.89031353373485', '5', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00085', '广州14号大酒店', '广州市F区江南西街22号', '江南西', '广州', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.4548266452012', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00086', '广州15号大酒店', '广州市F区江南西街1号', '江南西', '广州', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.73472731503954', '5', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00087', '广州16号大酒店', '广州市F区江南西街4号', '江南西', '广州', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.71645222652215', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00088', '广州17号大酒店', '广州市G区大北路街43号', '番禺大北路', '广州', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.93076405542284', '5', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00089', '广州18号大酒店', '广州市G区大北路街77号', '番禺大北路', '广州', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.29178684058411', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00090', '广州19号大酒店', '广州市G区大北路街55号', '番禺大北路', '广州', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.70896460436746', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00091', '广州20号大酒店', '广州市H区小北路街86号', '流花', '广州', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.41247961607896', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00092', '广州21号大酒店', '广州市H区小北路街3号', '流花', '广州', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.23270032240335', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00093', '广州22号大酒店', '广州市H区小北路街14号', '流花', '广州', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.27129571824635', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00094', '广州23号大酒店', '广州市I区向天歌街31号', '白鹅潭', '广州', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.74644699188279', '5', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00095', '广州24号大酒店', '广州市J区东山街43号', '东山', '广州', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.74361641810116', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00096', '广州25号大酒店', '广州市A区东山街8号', '东山', '广州', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.4521011834817', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00097', '成都1号大酒店', '成都市A区春熙路516号', '春熙路', '成都', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.84629959958729', '5', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00098', '成都2号大酒店', '成都市A区春熙路76号', '春熙路', '成都', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.06727054089028', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00099', '成都3号大酒店', '成都市A区春熙路75号', '春熙路', '成都', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.78732339269045', '5', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00100', '成都4号大酒店', '成都市B区天府路14号', '天府新城', '成都', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.81204907004212', '5', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00101', '成都5号大酒店', '成都市C区双楠路34号', '新双楠尚品广场', '成都', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.2662770045607', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00102', '成都6号大酒店', '成都市C区双楠路78号', '新双楠尚品广场', '成都', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.66894634626622', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00103', '成都7号大酒店', '成都市D区金沙路69号', '金沙光华', '成都', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.61399500537894', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00104', '成都8号大酒店', '成都市D区金沙路6号', '金沙光华', '成都', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.34643010053578', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00105', '成都9号大酒店', '成都市D区金沙路7号', '金沙光华', '成都', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.89443396254802', '5', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00106', '成都10号大酒店', '成都市E区建设路58号', '建设路', '成都', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.88273296713075', '5', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00107', '成都11号大酒店', '成都市E区建设路31号', '建设路', '成都', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.75140741275148', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00108', '成都12号大酒店', '成都市E区建设路24号', '建设路', '成都', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.64530399663484', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00109', '成都13号大酒店', '成都市E区建设路267号', '建设路', '成都', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.66833648128419', '4', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00110', '成都14号大酒店', '成都市F区咸口路43号', '盐市口', '成都', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.89722659956579', '5', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00111', '成都15号大酒店', '成都市F区咸口路55号', '盐市口', '成都', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.89579654027145', '5', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00112', '成都16号大酒店', '成都市G区骡马路86号', '骡马市', '成都', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.40016679511933', '3', '游泳馆，健身房等等等等服务齐全', '');
INSERT INTO `hotel` VALUES ('00113', '成都17号大酒店', '成都市G区骡马路94号', '骡马市', '成都', '风景如画，等等等等', '302,20061001,20061002;303,20061101,20061103', '4.34962072565623', '3', '游泳馆，健身房等等等等服务齐全', '');

-- ----------------------------
-- Table structure for level
-- ----------------------------
DROP TABLE IF EXISTS `level`;
CREATE TABLE `level` (
  `LevelNum` int(11) DEFAULT NULL,
  `Credits` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of level
-- ----------------------------
INSERT INTO `level` VALUES ('1', '300');
INSERT INTO `level` VALUES ('2', '600');
INSERT INTO `level` VALUES ('3', '900');
INSERT INTO `level` VALUES ('4', '1200');
INSERT INTO `level` VALUES ('5', '1500');
INSERT INTO `level` VALUES ('6', '1800');
INSERT INTO `level` VALUES ('7', '2100');
INSERT INTO `level` VALUES ('8', '2400');
INSERT INTO `level` VALUES ('9', '2700');
INSERT INTO `level` VALUES ('10', '3000');
INSERT INTO `level` VALUES ('11', '3300');
INSERT INTO `level` VALUES ('12', '3600');
INSERT INTO `level` VALUES ('13', '3900');
INSERT INTO `level` VALUES ('14', '4200');
INSERT INTO `level` VALUES ('15', '4500');
INSERT INTO `level` VALUES ('16', '4800');
INSERT INTO `level` VALUES ('17', '5100');
INSERT INTO `level` VALUES ('18', '5400');
INSERT INTO `level` VALUES ('19', '5700');
INSERT INTO `level` VALUES ('20', '6000');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
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

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('已执行订单', '2008-06-06 00:00:00', '2008-07-07 00:00:00', '2008-07-10 00:00:00', '2008-07-07 13:22:33', '2008-07-10 13:22:33', '2008-07-07 23:59:59', '1000-01-01 00:00:00', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020080606143055', '00001', '单人间', '1', '1', '0', '1234567890', '张客户', '13301112944', '120');
INSERT INTO `order` VALUES ('已执行订单', '2008-08-08 00:00:00', '2008-09-09 00:00:00', '2008-09-10 00:00:00', '2008-09-09 13:22:33', '2008-09-10 13:22:33', '2008-08-08 23:59:59', '1000-01-01 00:00:00', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020080808221016', '00001', '单人间', '1', '1', '0', '1234567890', '张客户', '13301112944', '120');
INSERT INTO `order` VALUES ('已执行订单', '2008-10-10 00:00:00', '2008-10-11 00:00:00', '2008-10-12 00:00:00', '2008-10-11 13:22:33', '2008-10-12 13:22:33', '2008-10-10 23:59:59', '1000-01-01 00:00:00', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020081010130101', '00001', '标间', '1', '2', '1', '1234567890', '张客户', '13301112944', '220');
INSERT INTO `order` VALUES ('已执行订单', '2008-12-12 00:00:00', '2008-12-15 00:00:00', '2008-12-16 00:00:00', '2008-12-15 13:22:33', '2008-12-16 13:22:33', '2008-12-12 23:59:59', '1000-01-01 00:00:00', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020081212152311', '00001', '单人间', '1', '1', '0', '1234567890', '张客户', '13301112944', '120');
INSERT INTO `order` VALUES ('已执行订单', '2009-02-02 00:00:00', '2009-03-03 00:00:00', '2009-03-04 00:00:00', '2009-03-03 13:22:33', '2009-03-04 13:22:33', '2009-02-02 23:59:59', '1000-01-01 00:00:00', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020090202080303', '00001', '套间', '1', '1', '0', '1234567890', '张客户', '13301112944', '350');
INSERT INTO `order` VALUES ('已执行订单', '2009-04-04 00:00:00', '2009-05-05 00:00:00', '2009-05-06 00:00:00', '2009-05-05 13:22:33', '2009-05-06 13:22:33', '2009-04-04 23:59:59', '1000-01-01 00:00:00', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020090404121212', '00001', '单人间', '1', '1', '0', '1234567890', '张客户', '13301112944', '120');
INSERT INTO `order` VALUES ('已执行订单', '2009-06-06 00:00:00', '2009-07-07 00:00:00', '2009-07-07 00:00:00', '2009-07-07 13:22:33', '2009-07-07 13:22:33', '2009-06-06 23:59:59', '1000-01-01 00:00:00', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020090606121212', '00001', '标间', '1', '2', '0', '1234567890', '张客户', '13301112944', '220');
INSERT INTO `order` VALUES ('已执行订单', '2010-11-06 00:00:00', '2010-11-11 00:00:00', '2010-11-12 00:00:00', '2010-11-11 13:22:33', '2010-11-12 13:22:33', '2010-11-11 23:59:59', '1000-01-01 00:00:00', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020101111121212', '00001', '单人间', '1', '1', '0', '1234567890', '张客户', '13301112944', '72');
INSERT INTO `order` VALUES ('已撤销订单', '2008-06-06 00:00:00', '2008-07-07 00:00:00', '2008-07-10 00:00:00', '1000-01-01 00:00:00', '1000-01-01 00:00:00', '2008-07-07 23:59:59', '2008-06-07 23:59:59', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020080606173055', '00001', '单人间', '1', '1', '0', '1234567890', '张客户', '13301112944', '120');
INSERT INTO `order` VALUES ('已撤销订单', '2008-08-08 00:00:00', '2008-09-09 00:00:00', '2008-09-10 00:00:00', '1000-01-01 00:00:00', '1000-01-01 00:00:00', '2008-08-08 23:59:59', '2008-08-09 23:59:59', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020080808201016', '00001', '单人间', '1', '1', '0', '1234567890', '张客户', '13301112944', '120');
INSERT INTO `order` VALUES ('已撤销订单', '2008-10-10 00:00:00', '2008-10-11 00:00:00', '2008-10-12 00:00:00', '1000-01-01 00:00:00', '1000-01-01 00:00:00', '2008-10-10 23:59:59', '2008-10-11 23:59:59', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020081010220101', '00001', '标间', '1', '2', '1', '1234567890', '张客户', '13301112944', '220');
INSERT INTO `order` VALUES ('已撤销订单', '2008-12-12 00:00:00', '2008-12-15 00:00:00', '2008-12-16 00:00:00', '1000-01-01 00:00:00', '1000-01-01 00:00:00', '2008-12-12 23:59:59', '2008-12-15 18:59:59', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020081212152751', '00001', '单人间', '1', '1', '0', '1234567890', '张客户', '13301112944', '120');
INSERT INTO `order` VALUES ('已撤销订单', '2009-02-02 00:00:00', '2009-03-03 00:00:00', '2009-03-04 00:00:00', '1000-01-01 00:00:00', '1000-01-01 00:00:00', '2009-02-03 23:59:59', '2009-02-03 23:59:59', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020090202080000', '00001', '套间', '1', '1', '0', '1234567890', '张客户', '13301112944', '350');
INSERT INTO `order` VALUES ('已撤销订单', '2009-04-04 00:00:00', '2009-05-05 00:00:00', '2009-05-06 00:00:00', '1000-01-01 00:00:00', '1000-01-01 00:00:00', '2009-04-04 23:59:59', '2009-04-05 23:59:59', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020090404124411', '00001', '单人间', '1', '1', '0', '1234567890', '张客户', '13301112944', '120');
INSERT INTO `order` VALUES ('已撤销订单', '2009-06-06 00:00:00', '2009-07-07 00:00:00', '2009-07-07 00:00:00', '1000-01-01 00:00:00', '1000-01-01 00:00:00', '2009-06-06 23:59:59', '2009-06-07 23:59:59', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020090606130505', '00001', '标间', '1', '2', '0', '1234567890', '张客户', '13301112944', '220');
INSERT INTO `order` VALUES ('已撤销订单', '2010-11-06 00:00:00', '2010-11-11 00:00:00', '2010-11-12 00:00:00', '1000-01-01 00:00:00', '1000-01-01 00:00:00', '2010-11-11 23:59:59', '2010-11-11 19:59:59', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020101111172222', '00001', '单人间', '1', '1', '0', '1234567890', '张客户', '13301112944', '72');
INSERT INTO `order` VALUES ('异常订单', '2012-01-01 00:00:00', '2012-01-01 00:00:00', '2012-01-02 00:00:00', '1000-01-01 00:00:00', '1000-01-01 00:00:00', '2012-01-01 23:59:59', '1000-01-01 00:00:00', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020120101000000', '00001', '单人间', '1', '1', '0', '1234567890', '张客户', '13301112944', '120');
INSERT INTO `order` VALUES ('异常订单', '2012-01-02 00:00:00', '2012-01-02 00:00:00', '2012-01-03 00:00:00', '1000-01-01 00:00:00', '1000-01-01 00:00:00', '2012-01-02 23:59:59', '1000-01-01 00:00:00', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020120102000000', '00001', '单人间', '1', '1', '0', '1234567890', '张客户', '13301112944', '120');
INSERT INTO `order` VALUES ('异常订单', '2012-01-03 00:00:00', '2012-01-03 00:00:00', '2012-01-04 00:00:00', '1000-01-01 00:00:00', '1000-01-01 00:00:00', '2012-01-03 23:59:59', '1000-01-01 00:00:00', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020120103000000', '00001', '标间', '1', '2', '1', '1234567890', '张客户', '13301112944', '220');
INSERT INTO `order` VALUES ('异常订单', '2012-01-04 00:00:00', '2012-01-04 00:00:00', '2012-01-05 00:00:00', '1000-01-01 00:00:00', '1000-01-01 00:00:00', '2012-01-04 23:59:59', '1000-01-01 00:00:00', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020120104000000', '00001', '单人间', '1', '1', '0', '1234567890', '张客户', '13301112944', '120');
INSERT INTO `order` VALUES ('异常订单', '2012-01-05 00:00:00', '2012-01-05 00:00:00', '2012-01-06 00:00:00', '1000-01-01 00:00:00', '1000-01-01 00:00:00', '2012-01-05 23:59:59', '1000-01-01 00:00:00', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020120105000000', '00001', '套间', '1', '1', '0', '1234567890', '张客户', '13301112944', '350');
INSERT INTO `order` VALUES ('异常订单', '2012-01-06 00:00:00', '2012-01-06 00:00:00', '2012-01-07 00:00:00', '1000-01-01 00:00:00', '1000-01-01 00:00:00', '2012-01-06 23:59:59', '1000-01-01 00:00:00', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020120106000000', '00001', '单人间', '1', '1', '0', '1234567890', '张客户', '13301112944', '120');
INSERT INTO `order` VALUES ('异常订单', '2012-01-07 00:00:00', '2012-01-07 00:00:00', '2012-01-08 00:00:00', '1000-01-01 00:00:00', '1000-01-01 00:00:00', '2012-01-07 23:59:59', '1000-01-01 00:00:00', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020120107000000', '00001', '标间', '1', '2', '0', '1234567890', '张客户', '13301112944', '220');
INSERT INTO `order` VALUES ('异常订单', '2012-01-08 00:00:00', '2012-01-08 00:00:00', '2012-01-09 00:00:00', '1000-01-01 00:00:00', '1000-01-01 00:00:00', '2012-01-08 23:59:59', '1000-01-01 00:00:00', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020120108000000', '00001', '单人间', '1', '1', '0', '1234567890', '张客户', '13301112944', '72');
INSERT INTO `order` VALUES ('未执行订单', '2012-01-09 00:00:00', '2012-01-09 00:00:00', '2012-01-10 00:00:00', '1000-01-01 00:00:00', '1000-01-01 00:00:00', '2012-01-09 23:59:59', '1000-01-01 00:00:00', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020120109000000', '00001', '单人间', '1', '1', '0', '1234567890', '张客户', '13301112944', '120');
INSERT INTO `order` VALUES ('未执行订单', '2012-01-10 00:00:00', '2012-01-10 00:00:00', '2012-01-11 00:00:00', '1000-01-01 00:00:00', '1000-01-01 00:00:00', '2012-01-10 23:59:59', '1000-01-01 00:00:00', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020120110000000', '00001', '单人间', '1', '1', '0', '1234567890', '张客户', '13301112944', '120');
INSERT INTO `order` VALUES ('未执行订单', '2012-01-11 00:00:00', '2012-01-11 00:00:00', '2012-01-12 00:00:00', '1000-01-01 00:00:00', '1000-01-01 00:00:00', '2012-01-11 23:59:59', '1000-01-01 00:00:00', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020120111000000', '00001', '标间', '1', '2', '1', '1234567890', '张客户', '13301112944', '220');
INSERT INTO `order` VALUES ('未执行订单', '2012-01-12 00:00:00', '2012-01-12 00:00:00', '2012-01-13 00:00:00', '1000-01-01 00:00:00', '1000-01-01 00:00:00', '2012-01-12 23:59:59', '1000-01-01 00:00:00', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020120112000000', '00001', '单人间', '1', '1', '0', '1234567890', '张客户', '13301112944', '120');
INSERT INTO `order` VALUES ('未执行订单', '2012-01-13 00:00:00', '2012-01-13 00:00:00', '2012-01-14 00:00:00', '1000-01-01 00:00:00', '1000-01-01 00:00:00', '2012-01-13 23:59:59', '1000-01-01 00:00:00', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020120113000000', '00001', '套间', '1', '1', '0', '1234567890', '张客户', '13301112944', '350');
INSERT INTO `order` VALUES ('未执行订单', '2012-01-14 00:00:00', '2012-01-14 00:00:00', '2012-01-15 00:00:00', '1000-01-01 00:00:00', '1000-01-01 00:00:00', '2012-01-14 23:59:59', '1000-01-01 00:00:00', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020120114000000', '00001', '单人间', '1', '1', '0', '1234567890', '张客户', '13301112944', '120');
INSERT INTO `order` VALUES ('未执行订单', '2012-01-15 00:00:00', '2012-01-15 00:00:00', '2012-01-16 00:00:00', '1000-01-01 00:00:00', '1000-01-01 00:00:00', '2012-01-15 23:59:59', '1000-01-01 00:00:00', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020120115000000', '00001', '标间', '1', '2', '0', '1234567890', '张客户', '13301112944', '220');
INSERT INTO `order` VALUES ('未执行订单', '2012-01-16 00:00:00', '2012-01-16 00:00:00', '2012-01-17 00:00:00', '1000-01-01 00:00:00', '1000-01-01 00:00:00', '2012-01-16 23:59:59', '1000-01-01 00:00:00', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020120116000000', '00001', '单人间', '1', '1', '0', '1234567890', '张客户', '13301112944', '72');
INSERT INTO `order` VALUES ('未执行订单', '2012-01-17 00:00:00', '2012-01-17 00:00:00', '2012-01-18 00:00:00', '1000-01-01 00:00:00', '1000-01-01 00:00:00', '2012-01-17 23:59:59', '1000-01-01 00:00:00', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020120117000000', '00001', '单人间', '1', '1', '0', '1234567890', '张客户', '13301112944', '120');
INSERT INTO `order` VALUES ('未执行订单', '2012-01-18 00:00:00', '2012-01-18 00:00:00', '2012-01-19 00:00:00', '1000-01-01 00:00:00', '1000-01-01 00:00:00', '2012-01-18 23:59:59', '1000-01-01 00:00:00', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020120118000000', '00001', '单人间', '1', '1', '0', '1234567890', '张客户', '13301112944', '120');
INSERT INTO `order` VALUES ('未执行订单', '2012-01-19 00:00:00', '2012-01-19 00:00:00', '2012-01-20 00:00:00', '1000-01-01 00:00:00', '1000-01-01 00:00:00', '2012-01-19 23:59:59', '1000-01-01 00:00:00', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020120119000000', '00001', '标间', '1', '2', '1', '1234567890', '张客户', '13301112944', '220');
INSERT INTO `order` VALUES ('未执行订单', '2012-01-20 00:00:00', '2012-01-20 00:00:00', '2012-01-21 00:00:00', '1000-01-01 00:00:00', '1000-01-01 00:00:00', '2012-01-20 23:59:59', '1000-01-01 00:00:00', '南京1号大酒店', '南京市A区新街口大道163号', '123456789020120120000000', '00001', '单人间', '1', '1', '0', '1234567890', '张客户', '13301112944', '120');
INSERT INTO `order` VALUES ('', null, null, null, null, null, null, null, '', '', '', '', '', null, null, null, '', '', '', null);
INSERT INTO `order` VALUES ('', null, null, null, null, null, null, null, '', '', '', '', '', null, null, null, '', '', '', null);
INSERT INTO `order` VALUES ('', null, null, null, null, null, null, null, '', '', '', '', '', null, null, null, '', '', '', null);
INSERT INTO `order` VALUES ('', null, null, null, null, null, null, null, '', '', '', '', '', null, null, null, '', '', '', null);

-- ----------------------------
-- Table structure for promotion
-- ----------------------------
DROP TABLE IF EXISTS `promotion`;
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

-- ----------------------------
-- Records of promotion
-- ----------------------------
INSERT INTO `promotion` VALUES ('hotel', '特定日期促销', '0000000001', '2010-11-11 00:00:00', '2010-11-12 00:00:00', '南京1号大酒店', '00001', '3', '南京', '新街口', '6', '双十一促销');
INSERT INTO `promotion` VALUES ('hotel', '三间以上促销', '0000000002', '1990-01-01 00:00:00', '2017-12-12 00:00:00', '南京1号大酒店', '00001', '3', '南京', '新街口', '8', '三间以上折扣');
INSERT INTO `promotion` VALUES ('hotel', '商圈促销', '0000000003', '1990-01-01 00:00:00', '2017-12-12 00:00:00', '南京2号大酒店', '00002', '3', '南京', '新街口', '7', '新街口促销');
INSERT INTO `promotion` VALUES ('web', '特定日期促销', '0000000004', '1990-01-01 00:00:00', '2017-12-12 00:00:00', null, null, '3', '南京', '新街口', '5', '网站特殊促销');
INSERT INTO `promotion` VALUES ('hotel', '三间以上促销', '0000000005', '1990-01-01 00:00:00', '2017-12-12 00:00:00', '南京3号大酒店', '00003', '3', '南京', '新街口', '9', '三间以上折扣');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
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

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('企业客户', 'aUaGG0ruYCpgszDQvluBGw==', 'JDtdGgh8TkdCwqGwz3HcAg==', '4433196829', 'hHUMP+1jyaeB/sOCDYqFBg==', 'nHp1oaeBqj31aogiFJPqpA==', '7900', '1000-01-01 00:00:00', 'pineapple', 'null', '');
INSERT INTO `user` VALUES ('网站营销人员', 'Iw4MClm/F/L8qKL3WGGYrw==', 'mDjgO09WH6CdJWSqWp4C6g==', '3311203982', 'hHUMP+1jyaeB/sOCDYqFBg==', 'SGTXicgeWawK6Y1b6r1cYQ==', '0', '1000-01-01 00:00:00', 'null', 'null', '');
INSERT INTO `user` VALUES ('网站管理人员', '7A+inG3u36zcfu3UG+7o7g==', 'ZqwEdKpB0tuWSj5yTu7DKg==', '3431938943', 'hHUMP+1jyaeB/sOCDYqFBg==', 'ynonMyTd8ANPhUniST+7Jg==', '0', '1000-01-01 00:00:00', 'null', 'null', '');
INSERT INTO `user` VALUES ('个人客户', 'pOiVDqvEAwAapfEFAq7oMQ==', 'gRysBnGIpMibhrw/z32SQw==', '1234567890', 'hHUMP+1jyaeB/sOCDYqFBg==', 'qzt+Z8IRxQ5YOTrn5q+nfg==', '2820', '1995-03-05 00:00:00', 'null', 'null', '');
INSERT INTO `user` VALUES ('酒店工作人员', '/sKlsTzcyBKoerIYDEg4IQ==', 'ZEAw6b1tjWQuzne6f9ThdQ==', '1209329435', 'hHUMP+1jyaeB/sOCDYqFBg==', 'paAdQL5Ykx4ceC+RV9YzFQ==', '0', '1000-01-01 00:00:00', 'null', '南京市A区新街口大道163号', '00001');
