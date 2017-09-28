/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : market

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2017-09-26 10:39:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for food
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `food_name` varchar(50) DEFAULT NULL,
  `food_store` varchar(50) DEFAULT NULL,
  `food_price` decimal(10,2) DEFAULT NULL,
  `food_picture` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of food
-- ----------------------------
INSERT INTO `food` VALUES ('1', '良品铺子手撕面包营养早餐食品蛋糕口袋面包糕点点心零食批发整箱', '良品铺子旗舰店', '32.90', 'images/pciture1.png');
INSERT INTO `food` VALUES ('2', '【三只松鼠_猪肉猪肉脯210g】休闲食品小吃零食靖江特产猪肉干', '三只松鼠旗舰店', '17.90', 'images/picture2.png');
INSERT INTO `food` VALUES ('3', '良品铺子靖江猪肉脯 特产零食小吃猪肉干肉脯猪肉铺原味休闲食品', '良品铺子旗舰店', '18.90', 'images/picture3.png');
INSERT INTO `food` VALUES ('4', '【天猫超市】卫龙小面筋辣条280g辣味豆干80后怀旧麻辣零食小吃', '天猫超市', '9.90', 'images/picture4.png');
INSERT INTO `food` VALUES ('5', '聚【百草味-夹心麻薯210gx3袋】零食小吃特产美食 早餐食品糕点', '百草味旗舰店', '25.90', 'images/picture5.png');
INSERT INTO `food` VALUES ('6', '【天猫超市】港荣蒸蛋糕1kg早餐糕点手撕小面包网红零食品整箱', '天猫超市', '38.90', 'images/picture6.png');
INSERT INTO `food` VALUES ('7', '【天猫超市】百草味熟食 白芝麻猪肉脯180g 靖江零食肉干休闲小吃', '天猫超市', '15.90', 'images/picture7.png');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` varchar(100) NOT NULL,
  `user_pwd` varchar(100) NOT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `is_admin` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'admin', 'admin', '1', '1');
INSERT INTO `users` VALUES ('2', 'user', 'user', '1', '0');

-- ----------------------------
-- Table structure for user_type
-- ----------------------------
DROP TABLE IF EXISTS `user_type`;
CREATE TABLE `user_type` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `item_name` varchar(40) DEFAULT NULL,
  `item_url` varchar(50) DEFAULT NULL,
  `is_admin` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_type
-- ----------------------------
INSERT INTO `user_type` VALUES ('1', '商品管理', 'dofood.jsp', '1');
INSERT INTO `user_type` VALUES ('2', '设置商品属性', null, '1');
INSERT INTO `user_type` VALUES ('3', '订单管理', null, '1');
INSERT INTO `user_type` VALUES ('4', '活动管理', null, '1');
INSERT INTO `user_type` VALUES ('5', '所有商品', 'dofood.jsp', '0');
INSERT INTO `user_type` VALUES ('6', '我的购物车', null, '0');
INSERT INTO `user_type` VALUES ('7', '每日活动', null, '0');
INSERT INTO `user_type` VALUES ('8', '意见建议', null, '0');
