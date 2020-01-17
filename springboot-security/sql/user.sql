/*
Navicat MySQL Data Transfer

Source Server         : 本机mysql
Source Server Version : 50646
Source Host           : localhost:3306
Source Database       : security02

Target Server Type    : MYSQL
Target Server Version : 50646
File Encoding         : 65001

Date: 2020-01-17 11:18:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
