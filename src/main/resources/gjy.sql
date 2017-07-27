/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : gjy

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-07-27 10:57:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `name` varchar(16) NOT NULL DEFAULT '' COMMENT '权限名称',
  `desc` varchar(64) NOT NULL DEFAULT '' COMMENT '权限描述',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', 'view', '查询', '2017-07-27 10:28:03', '2017-07-27 10:28:05');
INSERT INTO `sys_permission` VALUES ('2', 'create', '创建', '2017-07-27 10:28:21', '2017-07-27 10:28:24');
INSERT INTO `sys_permission` VALUES ('3', 'edit', '编辑', '2017-07-27 10:28:38', '2017-07-27 10:28:41');
INSERT INTO `sys_permission` VALUES ('4', 'del', '删除', '2017-07-27 10:28:55', '2017-07-27 10:28:57');

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `desc` varchar(128) NOT NULL,
  `url` varchar(255) NOT NULL,
  `icon` varchar(128) DEFAULT NULL,
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除,0否，1删除',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='路径资源表';

-- ----------------------------
-- Records of sys_resource
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(128) NOT NULL DEFAULT '' COMMENT '角色名称',
  `desc` varchar(255) NOT NULL DEFAULT '' COMMENT '角色描述',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除,0否，1删除',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色权限关联id',
  `role_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '角色id',
  `permission` varchar(32) NOT NULL DEFAULT '' COMMENT '权限user:create',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除,0否，1删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限关联表';

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_admin
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_admin`;
CREATE TABLE `sys_user_admin` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(32) NOT NULL DEFAULT '' COMMENT '用户登录名',
  `real_name` varchar(32) NOT NULL DEFAULT '' COMMENT '用户真实姓名',
  `password` varchar(128) NOT NULL COMMENT '登录密码',
  `salt` varchar(16) NOT NULL COMMENT '盐',
  `status` tinyint(1) unsigned NOT NULL COMMENT '状态。0正常，1冻结',
  `deleted` tinyint(1) unsigned NOT NULL COMMENT '是否删除,0否，1删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台用户表';

-- ----------------------------
-- Records of sys_user_admin
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户角色关联表id',
  `user_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '用户id',
  `role_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '角色id',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除,0否，1删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关联表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
