/*
Navicat MySQL Data Transfer

Source Server         : family
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2016-10-28 17:20:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog_area
-- ----------------------------
DROP TABLE IF EXISTS `blog_area`;
CREATE TABLE `blog_area` (
  `ID` varchar(32) NOT NULL COMMENT '唯一标识',
  `BA_CODE` varchar(20) NOT NULL COMMENT '编号',
  `BA_NAME` varchar(150) NOT NULL COMMENT '名称',
  `BA_LEVEL` char(1) NOT NULL COMMENT '层级(0:国家 1：省 2:市 3:县 4:镇/乡)',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='地域表';

-- ----------------------------
-- Records of blog_area
-- ----------------------------

-- ----------------------------
-- Table structure for blog_article
-- ----------------------------
DROP TABLE IF EXISTS `blog_article`;
CREATE TABLE `blog_article` (
  `ID` varchar(32) NOT NULL COMMENT '唯一标识',
  `BA_LABEL_ID` varchar(32) DEFAULT NULL COMMENT '类别id',
  `BA_TITLE` varchar(255) NOT NULL COMMENT '标题',
  `BA_SUMMARY` varchar(255) DEFAULT NULL COMMENT '总结',
  `BA_CONTENT` varchar(255) NOT NULL COMMENT '内容',
  `BA_HOT` char(1) DEFAULT '1' COMMENT '热门文章（0：非热门文章 1：热门文章）',
  `BA_CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `BA_OPERATE_TIME` datetime NOT NULL COMMENT '操作时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章表';

-- ----------------------------
-- Records of blog_article
-- ----------------------------

-- ----------------------------
-- Table structure for blog_comment
-- ----------------------------
DROP TABLE IF EXISTS `blog_comment`;
CREATE TABLE `blog_comment` (
  `ID` varchar(32) NOT NULL COMMENT '唯一标识',
  `BC_USER_ID` varchar(32) NOT NULL COMMENT '用户id',
  `BC_ABEL_ID` varchar(32) NOT NULL COMMENT '文章id',
  `BC_CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `BC_OPERATE_TIME` datetime NOT NULL COMMENT '操作时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论表';

-- ----------------------------
-- Records of blog_comment
-- ----------------------------

-- ----------------------------
-- Table structure for blog_industry
-- ----------------------------
DROP TABLE IF EXISTS `blog_industry`;
CREATE TABLE `blog_industry` (
  `ID` varchar(32) NOT NULL COMMENT '唯一标识',
  `BI_NAME` varchar(32) NOT NULL COMMENT '名称',
  `BI_CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `BI_OPERATE_TIME` datetime NOT NULL COMMENT '操作时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='行业表';

-- ----------------------------
-- Records of blog_industry
-- ----------------------------

-- ----------------------------
-- Table structure for blog_label
-- ----------------------------
DROP TABLE IF EXISTS `blog_label`;
CREATE TABLE `blog_label` (
  `ID` varchar(32) NOT NULL COMMENT '唯一标识',
  `BL_NAME` varchar(32) NOT NULL COMMENT '名称',
  `BL_CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `BL_OPERATE_TIME` datetime NOT NULL COMMENT '操作时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='标签表';

-- ----------------------------
-- Records of blog_label
-- ----------------------------

-- ----------------------------
-- Table structure for blog_recommend
-- ----------------------------
DROP TABLE IF EXISTS `blog_recommend`;
CREATE TABLE `blog_recommend` (
  `ID` varchar(32) NOT NULL COMMENT '唯一标识',
  `BR_URL` varchar(32) NOT NULL COMMENT '连接',
  `BR_PICTURE` varchar(32) DEFAULT NULL COMMENT '图片',
  `BR_CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `BR_OPERATE_TIME` datetime NOT NULL COMMENT '操作时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='推荐表';

-- ----------------------------
-- Records of blog_recommend
-- ----------------------------

-- ----------------------------
-- Table structure for blog_sundry
-- ----------------------------
DROP TABLE IF EXISTS `blog_sundry`;
CREATE TABLE `blog_sundry` (
  `ID` varchar(32) NOT NULL COMMENT '唯一标识',
  `BS_CONTENT` varchar(255) NOT NULL COMMENT '内容',
  `BS_STATUS` char(1) NOT NULL COMMENT '状态 0：闲言碎语 1生活感悟 2 名言金句 3 人生体会 4时间轴',
  `BS_CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `BS_OPERATE_TIME` datetime NOT NULL COMMENT '操作时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='杂项表';

-- ----------------------------
-- Records of blog_sundry
-- ----------------------------

-- ----------------------------
-- Table structure for blog_user
-- ----------------------------
DROP TABLE IF EXISTS `blog_user`;
CREATE TABLE `blog_user` (
  `ID` varchar(32) NOT NULL COMMENT '唯一标识',
  `BU_USER_NAME` varchar(32) NOT NULL COMMENT '用户名',
  `BU_PASSWORD` varchar(32) NOT NULL COMMENT '密码',
  `BU_NAME` varchar(32) NOT NULL COMMENT '姓名',
  `BU_SEX` char(1) NOT NULL COMMENT '性别(0:女 1:男)',
  `BU_ADDRESS` varchar(32) NOT NULL COMMENT '地址',
  `BU_DIRTHDAY` datetime DEFAULT NULL COMMENT '生日',
  `BU_MOBILE` varchar(20) DEFAULT NULL COMMENT '手机号',
  `BU_MAIL` varchar(32) NOT NULL COMMENT '邮箱',
  `BU_WECHAT` varchar(32) DEFAULT NULL COMMENT '微信号',
  `BU_SKETCH` varchar(255) DEFAULT NULL COMMENT '描述',
  `BU_ENCRYPT_SALT` varchar(32) NOT NULL COMMENT '加盐值',
  `BU_CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `BU_OPERATE_TIME` datetime NOT NULL COMMENT '操作时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of blog_user
-- ----------------------------
