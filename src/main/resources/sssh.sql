/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : sssh

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-05-18 22:59:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_basedata
-- ----------------------------
DROP TABLE IF EXISTS `t_basedata`;
CREATE TABLE `t_basedata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `parent` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_basedata
-- ----------------------------

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createtime` datetime DEFAULT NULL,
  `delivertime` datetime DEFAULT NULL,
  `orderno` varchar(255) DEFAULT NULL,
  `createUser` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_4v0o7vwcuo41m1ilpmfmqas7a` (`createUser`),
  KEY `FK_600h8onwv12f336wj6ov4ra5u` (`status`),
  CONSTRAINT `FK_4v0o7vwcuo41m1ilpmfmqas7a` FOREIGN KEY (`createUser`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FK_600h8onwv12f336wj6ov4ra5u` FOREIGN KEY (`status`) REFERENCES `t_basedata` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_product
-- ----------------------------
DROP TABLE IF EXISTS `t_order_product`;
CREATE TABLE `t_order_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` double NOT NULL,
  `order_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_1sg939jxjmxxgg5htbnodrjgc` (`order_id`),
  KEY `FK_8jk77c74fo7usb55302do1oeh` (`product_id`),
  CONSTRAINT `FK_1sg939jxjmxxgg5htbnodrjgc` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`id`),
  CONSTRAINT `FK_8jk77c74fo7usb55302do1oeh` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_product
-- ----------------------------

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_product
-- ----------------------------

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', null, 'ROLE_USER');
INSERT INTO `t_role` VALUES ('2', null, 'ROLE_ADMIN');
INSERT INTO `t_role` VALUES ('3', null, 'ROLE_CUSTOMER');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `weixinid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('5', '253498229@qq.com', null, null, '111', 'admin', null);
INSERT INTO `t_user` VALUES ('6', '253498229@qq.com', null, null, '111', 'user', null);

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `userid` int(11) NOT NULL,
  `roleid` int(11) NOT NULL,
  PRIMARY KEY (`userid`,`roleid`),
  KEY `FK_ctr9iiktd8na85op2w996e08p` (`roleid`),
  CONSTRAINT `FK_33njv6qae26quls3a6vtwexl3` FOREIGN KEY (`userid`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FK_ctr9iiktd8na85op2w996e08p` FOREIGN KEY (`roleid`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('5', '1');
INSERT INTO `t_user_role` VALUES ('6', '1');
INSERT INTO `t_user_role` VALUES ('5', '2');
INSERT INTO `t_user_role` VALUES ('6', '3');
