/*
Navicat MySQL Data Transfer
Source Host     : localhost:3306
Source Database : wm_tenant_test
Target Host     : localhost:3306
Target Database : wm_tenant_test
Date: 2017-12-19 19:29:21
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for aa_product_ref
-- ----------------------------
DROP TABLE IF EXISTS `aa_product_ref`;
CREATE TABLE `aa_product_ref` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `score_id` bigint(20) DEFAULT NULL COMMENT '成绩id',
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='理财师测评关联产品';

-- ----------------------------
-- Records of aa_product_ref
-- ----------------------------

-- ----------------------------
-- Table structure for aa_product_type
-- ----------------------------
DROP TABLE IF EXISTS `aa_product_type`;
CREATE TABLE `aa_product_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(128) DEFAULT NULL COMMENT '编号',
  `name` varchar(128) DEFAULT NULL COMMENT '名称',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8 COMMENT='资产配置 产品类型';

-- ----------------------------
-- Records of aa_product_type
-- ----------------------------
INSERT INTO `aa_product_type` VALUES ('1', 'product_type_cash', '现金管理类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('2', 'product_type_fix', '类固定收益类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('3', 'product_type_private', '阳光私募类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('4', 'product_type_stock', '权益/另类投资类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('5', 'product_type_sea', '海外投资类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('6', 'product_type_cash', '现金管理类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('7', 'product_type_fix', '类固定收益类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('8', 'product_type_private', '阳光私募类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('9', 'product_type_stock', '权益/另类投资类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('10', 'product_type_sea', '海外投资类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('11', 'product_type_cash', '现金管理类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('12', 'product_type_fix', '类固定收益类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('13', 'product_type_private', '阳光私募类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('14', 'product_type_stock', '权益/另类投资类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('15', 'product_type_sea', '海外投资类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('16', 'product_type_cash', '现金管理类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('17', 'product_type_fix', '类固定收益类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('18', 'product_type_private', '阳光私募类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('19', 'product_type_stock', '权益/另类投资类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('20', 'product_type_sea', '海外投资类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('21', 'product_type_cash', '现金管理类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('22', 'product_type_fix', '类固定收益类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('23', 'product_type_private', '阳光私募类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('24', 'product_type_stock', '权益/另类投资类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('25', 'product_type_sea', '海外投资类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('26', 'product_type_cash', '现金管理类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('27', 'product_type_fix', '类固定收益类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('28', 'product_type_private', '阳光私募类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('29', 'product_type_stock', '权益/另类投资类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('30', 'product_type_sea', '海外投资类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('31', 'product_type_cash', '现金管理类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('32', 'product_type_fix', '类固定收益类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('33', 'product_type_private', '阳光私募类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('34', 'product_type_stock', '权益/另类投资类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('35', 'product_type_sea', '海外投资类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('36', 'product_type_cash', '现金管理类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('37', 'product_type_fix', '类固定收益类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('38', 'product_type_private', '阳光私募类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('39', 'product_type_stock', '权益/另类投资类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('40', 'product_type_sea', '海外投资类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('41', 'product_type_cash', '现金管理类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('42', 'product_type_fix', '类固定收益类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('43', 'product_type_private', '阳光私募类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('44', 'product_type_stock', '权益/另类投资类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('45', 'product_type_sea', '海外投资类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('46', 'product_type_cash', '现金管理类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('47', 'product_type_fix', '类固定收益类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('48', 'product_type_private', '阳光私募类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('49', 'product_type_stock', '权益/另类投资类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('50', 'product_type_sea', '海外投资类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('51', 'product_type_cash', '现金管理类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('52', 'product_type_fix', '类固定收益类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('53', 'product_type_private', '阳光私募类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('54', 'product_type_stock', '权益/另类投资类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('55', 'product_type_sea', '海外投资类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('56', 'product_type_cash', '现金管理类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('57', 'product_type_fix', '类固定收益类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('58', 'product_type_private', '阳光私募类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('59', 'product_type_stock', '权益/另类投资类', '3', null, null, null, null, '0');
INSERT INTO `aa_product_type` VALUES ('60', 'product_type_sea', '海外投资类', '3', null, null, null, null, '0');

-- ----------------------------
-- Table structure for aa_product_type_risk_rating
-- ----------------------------
DROP TABLE IF EXISTS `aa_product_type_risk_rating`;
CREATE TABLE `aa_product_type_risk_rating` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `product_type_id` bigint(20) DEFAULT NULL COMMENT '产品类型id',
  `risk_rating_id` bigint(20) DEFAULT NULL COMMENT '风险评测类型id',
  `rate` double DEFAULT NULL COMMENT '性质',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aa_product_type_risk_rating
-- ----------------------------
INSERT INTO `aa_product_type_risk_rating` VALUES ('1', '3', '1', '1', '60', null, null, null, null, '0');
INSERT INTO `aa_product_type_risk_rating` VALUES ('2', '3', '2', '1', '30', null, null, null, null, '0');
INSERT INTO `aa_product_type_risk_rating` VALUES ('3', '3', '3', '1', '10', null, null, null, null, '0');
INSERT INTO `aa_product_type_risk_rating` VALUES ('4', '3', '4', '1', '0', null, null, null, null, '0');
INSERT INTO `aa_product_type_risk_rating` VALUES ('5', '3', '5', '1', '0', null, null, null, null, '0');
INSERT INTO `aa_product_type_risk_rating` VALUES ('6', '3', '1', '2', '30', null, null, null, null, '0');
INSERT INTO `aa_product_type_risk_rating` VALUES ('7', '3', '2', '2', '40', null, null, null, null, '0');
INSERT INTO `aa_product_type_risk_rating` VALUES ('8', '3', '3', '2', '10', null, null, null, null, '0');
INSERT INTO `aa_product_type_risk_rating` VALUES ('9', '3', '4', '2', '10', null, null, null, null, '0');
INSERT INTO `aa_product_type_risk_rating` VALUES ('10', '3', '5', '2', '10', null, null, null, null, '0');
INSERT INTO `aa_product_type_risk_rating` VALUES ('11', '3', '1', '3', '25', null, null, null, null, '0');
INSERT INTO `aa_product_type_risk_rating` VALUES ('12', '3', '2', '3', '30', null, null, null, null, '0');
INSERT INTO `aa_product_type_risk_rating` VALUES ('13', '3', '3', '3', '20', null, null, null, null, '0');
INSERT INTO `aa_product_type_risk_rating` VALUES ('14', '3', '4', '3', '15', null, null, null, null, '0');
INSERT INTO `aa_product_type_risk_rating` VALUES ('15', '3', '5', '3', '10', null, null, null, null, '0');
INSERT INTO `aa_product_type_risk_rating` VALUES ('16', '3', '1', '4', '15', null, null, null, null, '0');
INSERT INTO `aa_product_type_risk_rating` VALUES ('17', '3', '2', '4', '25', null, null, null, null, '0');
INSERT INTO `aa_product_type_risk_rating` VALUES ('18', '3', '3', '4', '20', null, null, null, null, '0');
INSERT INTO `aa_product_type_risk_rating` VALUES ('19', '3', '4', '4', '30', null, null, null, null, '0');
INSERT INTO `aa_product_type_risk_rating` VALUES ('20', '3', '5', '4', '10', null, null, null, null, '0');
INSERT INTO `aa_product_type_risk_rating` VALUES ('21', '3', '1', '5', '10', null, null, null, null, '0');
INSERT INTO `aa_product_type_risk_rating` VALUES ('22', '3', '2', '5', '20', null, null, null, null, '0');
INSERT INTO `aa_product_type_risk_rating` VALUES ('23', '3', '3', '5', '20', null, null, null, null, '0');
INSERT INTO `aa_product_type_risk_rating` VALUES ('24', '3', '4', '5', '50', null, null, null, null, '0');
INSERT INTO `aa_product_type_risk_rating` VALUES ('25', '3', '5', '5', '0', null, null, null, null, '0');

-- ----------------------------
-- Table structure for aa_question_answer
-- ----------------------------
DROP TABLE IF EXISTS `aa_question_answer`;
CREATE TABLE `aa_question_answer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `question_id` bigint(20) DEFAULT NULL COMMENT '问答id',
  `option_id` bigint(20) DEFAULT NULL COMMENT '选项id',
  `score_id` bigint(20) DEFAULT NULL COMMENT '答题成绩id',
  `question_type_id` bigint(20) DEFAULT NULL COMMENT '题目类型',
  `content` varchar(512) DEFAULT NULL COMMENT '答题文本，当问题类型为“文本”时填写',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='理财师帮客户测评';

-- ----------------------------
-- Records of aa_question_answer
-- ----------------------------

-- ----------------------------
-- Table structure for aa_question_score
-- ----------------------------
DROP TABLE IF EXISTS `aa_question_score`;
CREATE TABLE `aa_question_score` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户id',
  `grade` int(11) DEFAULT NULL COMMENT '得分',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `question_type_id` bigint(20) DEFAULT NULL COMMENT '题目类型',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aa_question_score
-- ----------------------------

-- ----------------------------
-- Table structure for am_company
-- ----------------------------
DROP TABLE IF EXISTS `am_company`;
CREATE TABLE `am_company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `project_id` bigint(20) DEFAULT NULL COMMENT '项目id',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `registration_authority` varchar(32) DEFAULT NULL COMMENT '登记机关',
  `registration_number` varchar(32) DEFAULT NULL COMMENT '注册号',
  `registration_date` date DEFAULT NULL COMMENT '注册时间',
  `type` tinyint(4) DEFAULT NULL COMMENT '类型',
  `business_term_begin` date DEFAULT NULL COMMENT '营业期限开始时间',
  `business_term_end` date DEFAULT NULL COMMENT '营业期限结束时间',
  `legal_representative` varchar(32) DEFAULT NULL COMMENT '法定代表',
  `registration_capital` double DEFAULT NULL COMMENT '注册资本',
  `approval_date` date DEFAULT NULL COMMENT '发照日期',
  `address` varchar(128) DEFAULT NULL COMMENT '公司地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公司信息';

-- ----------------------------
-- Records of am_company
-- ----------------------------

-- ----------------------------
-- Table structure for am_decision
-- ----------------------------
DROP TABLE IF EXISTS `am_decision`;
CREATE TABLE `am_decision` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `project_id` bigint(20) DEFAULT NULL COMMENT '项目id',
  `round` int(11) DEFAULT NULL COMMENT '轮次',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `is_over` tinyint(4) DEFAULT NULL COMMENT '是否已结束，1：是，0：否',
  `audit_remark` varchar(256) DEFAULT NULL COMMENT '最后审批原因',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='立项投决';

-- ----------------------------
-- Records of am_decision
-- ----------------------------

-- ----------------------------
-- Table structure for am_decision_flow
-- ----------------------------
DROP TABLE IF EXISTS `am_decision_flow`;
CREATE TABLE `am_decision_flow` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `decision_id` bigint(20) DEFAULT NULL COMMENT '立项投决id ',
  `name` varchar(32) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `audit_status` tinyint(4) DEFAULT NULL COMMENT '审批状态， 0：进行中 1：审核中  2：审核通过  3：驳回修改 ',
  `audit_date` datetime DEFAULT NULL COMMENT '审批时间',
  `apply_user_id` bigint(20) DEFAULT NULL COMMENT '提交人',
  `apply_date` datetime DEFAULT NULL COMMENT '申请时间',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='立项投决流程';

-- ----------------------------
-- Records of am_decision_flow
-- ----------------------------

-- ----------------------------
-- Table structure for am_decision_flow_file
-- ----------------------------
DROP TABLE IF EXISTS `am_decision_flow_file`;
CREATE TABLE `am_decision_flow_file` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `decision_flow_id` bigint(20) DEFAULT NULL COMMENT '项目流程id',
  `name` varchar(64) DEFAULT NULL,
  `url` varchar(256) DEFAULT NULL COMMENT '文件地址',
  `type` tinyint(4) DEFAULT NULL COMMENT '类型(暂未使用)',
  `ext_name` varchar(16) DEFAULT NULL COMMENT '扩展名',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='立项投决流程文件';

-- ----------------------------
-- Records of am_decision_flow_file
-- ----------------------------

-- ----------------------------
-- Table structure for am_decision_invest_info
-- ----------------------------
DROP TABLE IF EXISTS `am_decision_invest_info`;
CREATE TABLE `am_decision_invest_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `decision_id` bigint(20) DEFAULT NULL COMMENT '立项投决id',
  `invest_or_not` tinyint(4) DEFAULT NULL COMMENT '是否出资，1：是，0：否',
  `fund_id` bigint(20) DEFAULT NULL COMMENT '投资主体（基金）',
  `investment_amount` double DEFAULT NULL COMMENT '出资金额',
  `share_ratio` double DEFAULT NULL COMMENT '占股比例',
  `valuation_before` double DEFAULT NULL COMMENT '投前估值',
  `valuation_after` double DEFAULT NULL COMMENT '投后估值',
  `invest_level` tinyint(4) DEFAULT NULL COMMENT '投资等级 1、领投  2、跟投',
  `invest_type` tinyint(4) DEFAULT NULL COMMENT '投资方式  1、增资  2、股权转让  3、增资&股权转让',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='立项投决投资信息';

-- ----------------------------
-- Records of am_decision_invest_info
-- ----------------------------

-- ----------------------------
-- Table structure for am_decision_suggestion
-- ----------------------------
DROP TABLE IF EXISTS `am_decision_suggestion`;
CREATE TABLE `am_decision_suggestion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `decision_id` bigint(20) DEFAULT NULL COMMENT '立项投决id',
  `user_account_id` bigint(20) DEFAULT NULL COMMENT '意见人id',
  `suggest` tinyint(4) DEFAULT NULL COMMENT '意见',
  `remark` varchar(200) DEFAULT NULL COMMENT '详情',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='立项投决意见';

-- ----------------------------
-- Records of am_decision_suggestion
-- ----------------------------

-- ----------------------------
-- Table structure for am_financing
-- ----------------------------
DROP TABLE IF EXISTS `am_financing`;
CREATE TABLE `am_financing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `finacing_round_id` bigint(20) DEFAULT NULL COMMENT '项目id',
  `investment_source` tinyint(4) DEFAULT NULL COMMENT '投资方，来源；1：内部基金产品，2：其他',
  `fund_id` bigint(20) DEFAULT NULL COMMENT '基金id',
  `fund_name` varchar(128) DEFAULT NULL COMMENT '基金名称',
  `investment_amount` double DEFAULT NULL COMMENT '出资金额',
  `share_ratio` double DEFAULT NULL COMMENT '占股比例',
  `insert_type` tinyint(4) DEFAULT NULL COMMENT '添加方式，1：手动添加，2：立项通过自动添加',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='融资信息';

-- ----------------------------
-- Records of am_financing
-- ----------------------------

-- ----------------------------
-- Table structure for am_financing_round
-- ----------------------------
DROP TABLE IF EXISTS `am_financing_round`;
CREATE TABLE `am_financing_round` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `project_id` bigint(20) DEFAULT NULL COMMENT '项目id',
  `round` int(11) DEFAULT NULL COMMENT '轮次',
  `time` datetime DEFAULT NULL COMMENT '融资时间',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='融资轮次';

-- ----------------------------
-- Records of am_financing_round
-- ----------------------------

-- ----------------------------
-- Table structure for am_fund
-- ----------------------------
DROP TABLE IF EXISTS `am_fund`;
CREATE TABLE `am_fund` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `type_id` bigint(20) DEFAULT NULL COMMENT '类型ID',
  `name` varchar(200) DEFAULT NULL COMMENT '名称',
  `issued_channel` varchar(32) DEFAULT NULL COMMENT '发行通道',
  `invest_domain` varchar(32) DEFAULT NULL COMMENT '投资标的',
  `time_limit` varchar(200) DEFAULT NULL COMMENT '投资期限',
  `mechanism` varchar(200) DEFAULT '0' COMMENT '管理机构',
  `buy_start_point` double DEFAULT NULL COMMENT '认购起点',
  `incremental_amount` double DEFAULT NULL COMMENT '递增金额',
  `buy_person_limit` int(11) DEFAULT NULL COMMENT '投资方式投资人数上限',
  `level` varchar(32) DEFAULT NULL COMMENT '基金等级',
  `risk_level` varchar(32) DEFAULT NULL COMMENT '风险等级',
  `receiver_id` bigint(20) DEFAULT NULL COMMENT '基金负责人',
  `highlight` varchar(1000) DEFAULT NULL COMMENT '简要亮点',
  `maturity_date` datetime DEFAULT NULL COMMENT '到期日期',
  `issued_status` int(11) DEFAULT NULL COMMENT '发行状态；待募集：-1，募集中：3，募集结束：4，存续／封闭中：5，清算退出：6',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='基金信息表';

-- ----------------------------
-- Records of am_fund
-- ----------------------------

-- ----------------------------
-- Table structure for am_fund_attach
-- ----------------------------
DROP TABLE IF EXISTS `am_fund_attach`;
CREATE TABLE `am_fund_attach` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `source_name` varchar(250) DEFAULT NULL COMMENT '文件名称',
  `url` varchar(250) DEFAULT NULL COMMENT 'url',
  `fund_id` bigint(20) DEFAULT NULL COMMENT '基金id',
  `sort` double DEFAULT NULL COMMENT '排序',
  `type` varchar(100) DEFAULT '0' COMMENT '附件类型',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='基金附件';

-- ----------------------------
-- Records of am_fund_attach
-- ----------------------------

-- ----------------------------
-- Table structure for am_fund_field_value
-- ----------------------------
DROP TABLE IF EXISTS `am_fund_field_value`;
CREATE TABLE `am_fund_field_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `object_field_id` bigint(20) DEFAULT NULL COMMENT '业务对象字段id',
  `reference_table_id` bigint(20) DEFAULT NULL COMMENT '引用表id',
  `value` longtext COMMENT '字段值',
  `slot` int(11) DEFAULT NULL COMMENT '位置，一个字段有多个值时使用，按数字从小到大排列，例如日期区间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='基金扩展字段表';

-- ----------------------------
-- Records of am_fund_field_value
-- ----------------------------

-- ----------------------------
-- Table structure for am_fund_focus
-- ----------------------------
DROP TABLE IF EXISTS `am_fund_focus`;
CREATE TABLE `am_fund_focus` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `fund_id` bigint(20) DEFAULT NULL COMMENT '基金ID',
  `user_account_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='基金关注表';

-- ----------------------------
-- Records of am_fund_focus
-- ----------------------------

-- ----------------------------
-- Table structure for am_fund_income
-- ----------------------------
DROP TABLE IF EXISTS `am_fund_income`;
CREATE TABLE `am_fund_income` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `income_rule_id` bigint(20) DEFAULT NULL COMMENT '收益规则ID',
  `buy_max` double DEFAULT NULL COMMENT '认购最大值',
  `buy_min` double DEFAULT NULL COMMENT '认购最小值',
  `buy_time_limit` bigint(20) DEFAULT NULL COMMENT '认购期限',
  `income_type` varchar(32) DEFAULT NULL COMMENT '收益类型',
  `fix_income_rate` double DEFAULT '0' COMMENT '收益率',
  `float_income_rate` double DEFAULT NULL COMMENT '浮动收益',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='基金收益';

-- ----------------------------
-- Records of am_fund_income
-- ----------------------------

-- ----------------------------
-- Table structure for am_fund_income_rule
-- ----------------------------
DROP TABLE IF EXISTS `am_fund_income_rule`;
CREATE TABLE `am_fund_income_rule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `fund_id` bigint(20) DEFAULT NULL COMMENT '基金ID',
  `rule_name` varchar(32) DEFAULT NULL COMMENT '规则名称',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='基金收益规则';

-- ----------------------------
-- Records of am_fund_income_rule
-- ----------------------------

-- ----------------------------
-- Table structure for am_fund_product
-- ----------------------------
DROP TABLE IF EXISTS `am_fund_product`;
CREATE TABLE `am_fund_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品ID',
  `fund_id` bigint(20) DEFAULT NULL COMMENT '基金ID',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='基金产品关联表';

-- ----------------------------
-- Records of am_fund_product
-- ----------------------------

-- ----------------------------
-- Table structure for am_fund_raise
-- ----------------------------
DROP TABLE IF EXISTS `am_fund_raise`;
CREATE TABLE `am_fund_raise` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `fund_id` bigint(20) DEFAULT NULL COMMENT '基金ID',
  `sale_start_date` datetime DEFAULT NULL COMMENT '拟销售开始日期',
  `sale_end_date` datetime DEFAULT NULL COMMENT '拟销售结束日期',
  `is_scale` tinyint(2) DEFAULT NULL COMMENT '是否有规模',
  `product_scale` double DEFAULT NULL COMMENT '规模',
  `currency_code` varchar(32) DEFAULT '0' COMMENT '投资币种',
  `pay_account` varchar(200) DEFAULT NULL COMMENT '打款账号',
  `account_name` varchar(200) DEFAULT NULL COMMENT '开户名',
  `raise_bank` varchar(200) DEFAULT NULL COMMENT '募集银行',
  `pay_remark` varchar(1000) DEFAULT NULL COMMENT '打款备注',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='基金募集信息表';

-- ----------------------------
-- Records of am_fund_raise
-- ----------------------------

-- ----------------------------
-- Table structure for am_fund_team
-- ----------------------------
DROP TABLE IF EXISTS `am_fund_team`;
CREATE TABLE `am_fund_team` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `fund_id` bigint(20) DEFAULT NULL COMMENT '基金ID',
  `name` varchar(32) DEFAULT NULL COMMENT '管理人',
  `position` varchar(128) DEFAULT NULL,
  `remark` varchar(512) DEFAULT NULL,
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='基金管理团队表';

-- ----------------------------
-- Records of am_fund_team
-- ----------------------------

-- ----------------------------
-- Table structure for am_industry
-- ----------------------------
DROP TABLE IF EXISTS `am_industry`;
CREATE TABLE `am_industry` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `name` varchar(32) DEFAULT NULL COMMENT '项目名称',
  `sequence` int(11) DEFAULT '1' COMMENT '排序，越小越靠前',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='行业领域';

-- ----------------------------
-- Records of am_industry
-- ----------------------------
INSERT INTO `am_industry` VALUES ('1', '3', '人工智能', '1000', '2017-12-13 11:09:00', null, null, null, '0');
INSERT INTO `am_industry` VALUES ('2', '3', '教育', '1000', '2017-12-13 11:09:00', null, null, null, '0');
INSERT INTO `am_industry` VALUES ('3', '3', '金融', '1000', '2017-12-13 11:09:00', null, null, null, '0');
INSERT INTO `am_industry` VALUES ('4', '3', '汽车交通', '1000', '2017-12-13 11:09:00', null, null, null, '0');
INSERT INTO `am_industry` VALUES ('5', '3', '房产服务', '1000', '2017-12-13 11:09:00', null, null, null, '0');
INSERT INTO `am_industry` VALUES ('6', '3', '医疗健康', '1000', '2017-12-13 11:09:00', null, null, null, '0');
INSERT INTO `am_industry` VALUES ('7', '3', '生活服务', '1000', '2017-12-13 11:09:00', null, null, null, '0');
INSERT INTO `am_industry` VALUES ('8', '3', '硬件', '1000', '2017-12-13 11:09:00', null, null, null, '0');
INSERT INTO `am_industry` VALUES ('9', '3', '企业服务', '1000', '2017-12-13 11:09:00', null, null, null, '0');

-- ----------------------------
-- Table structure for am_investment
-- ----------------------------
DROP TABLE IF EXISTS `am_investment`;
CREATE TABLE `am_investment` (
  `id` bigint(20) NOT NULL,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `fund_id` bigint(20) DEFAULT NULL COMMENT '基金ID',
  `project_id` bigint(20) DEFAULT NULL COMMENT '项目ID',
  `round` tinyint(2) DEFAULT NULL COMMENT '投资轮次',
  `invest_amount` double DEFAULT NULL COMMENT '投资金额',
  `share_ratio` double DEFAULT NULL COMMENT '投资占股比例',
  `invest_level` tinyint(2) DEFAULT '0' COMMENT '投资等级 1、领投  2、跟投',
  `valuation_before` double DEFAULT NULL COMMENT '投前估值',
  `valuation_after` double DEFAULT NULL,
  `invest_type` tinyint(2) DEFAULT NULL COMMENT '1、增资  2、股权转让  3、增资&股权转让',
  `invest_date` datetime DEFAULT NULL COMMENT '投资日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `AK_only_one` (`fund_id`,`project_id`,`round`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投资管理';

-- ----------------------------
-- Records of am_investment
-- ----------------------------

-- ----------------------------
-- Table structure for am_project
-- ----------------------------
DROP TABLE IF EXISTS `am_project`;
CREATE TABLE `am_project` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `name` varchar(32) DEFAULT NULL COMMENT '项目名称',
  `industry_id` bigint(20) DEFAULT NULL COMMENT '行业领域id',
  `leader_id` bigint(20) DEFAULT NULL COMMENT '项目负责人',
  `currency` tinyint(4) DEFAULT NULL COMMENT '币种',
  `source` tinyint(4) DEFAULT NULL COMMENT '来源',
  `priority` tinyint(4) DEFAULT NULL COMMENT '优先级',
  `province_code` varchar(32) DEFAULT NULL COMMENT '省份',
  `city_code` varchar(32) DEFAULT NULL COMMENT '市',
  `url` varchar(256) DEFAULT NULL COMMENT '主页链接',
  `description` varchar(200) DEFAULT NULL COMMENT '项目介绍',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目';

-- ----------------------------
-- Records of am_project
-- ----------------------------

-- ----------------------------
-- Table structure for am_project_crew
-- ----------------------------
DROP TABLE IF EXISTS `am_project_crew`;
CREATE TABLE `am_project_crew` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `project_id` bigint(20) DEFAULT NULL COMMENT '项目id',
  `user_account_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目组员';

-- ----------------------------
-- Records of am_project_crew
-- ----------------------------

-- ----------------------------
-- Table structure for am_project_file
-- ----------------------------
DROP TABLE IF EXISTS `am_project_file`;
CREATE TABLE `am_project_file` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `project_id` bigint(20) DEFAULT NULL COMMENT '项目id',
  `source_name` varchar(256) DEFAULT NULL COMMENT '项目文件名',
  `url` varchar(256) DEFAULT NULL COMMENT '文件地址',
  `type` varchar(32) DEFAULT NULL COMMENT '类型',
  `ext_name` varchar(16) DEFAULT NULL COMMENT '扩展名',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目文件';

-- ----------------------------
-- Records of am_project_file
-- ----------------------------

-- ----------------------------
-- Table structure for am_project_focus
-- ----------------------------
DROP TABLE IF EXISTS `am_project_focus`;
CREATE TABLE `am_project_focus` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `project_id` bigint(20) DEFAULT NULL COMMENT '项目id',
  `user_account_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目关注';

-- ----------------------------
-- Records of am_project_focus
-- ----------------------------

-- ----------------------------
-- Table structure for am_project_found_import
-- ----------------------------
DROP TABLE IF EXISTS `am_project_found_import`;
CREATE TABLE `am_project_found_import` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `project_id` bigint(20) DEFAULT NULL COMMENT '项目ID',
  `decision_id` bigint(20) DEFAULT NULL COMMENT '轮次ID',
  `investment_amount` double DEFAULT NULL COMMENT '投资金额',
  `share_ratio` double DEFAULT NULL COMMENT '投资占比',
  `type` varchar(16) DEFAULT NULL COMMENT '导入类型；项目：project，基金：fund',
  `is_import` tinyint(2) DEFAULT '0' COMMENT '是否已经导入',
  `is_clear` tinyint(2) DEFAULT '0' COMMENT '是否取消导入',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目成立导入';

-- ----------------------------
-- Records of am_project_found_import
-- ----------------------------

-- ----------------------------
-- Table structure for am_project_record
-- ----------------------------
DROP TABLE IF EXISTS `am_project_record`;
CREATE TABLE `am_project_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `project_id` bigint(20) DEFAULT NULL COMMENT '项目id',
  `action` tinyint(4) DEFAULT NULL COMMENT '行为;1:上传,2:下载,3:删除',
  `action_info` varchar(64) DEFAULT NULL COMMENT '行为信息',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目记录';

-- ----------------------------
-- Records of am_project_record
-- ----------------------------

-- ----------------------------
-- Table structure for am_withdrawal
-- ----------------------------
DROP TABLE IF EXISTS `am_withdrawal`;
CREATE TABLE `am_withdrawal` (
  `id` bigint(20) NOT NULL,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `fund_id` bigint(20) DEFAULT NULL COMMENT '基金ID',
  `project_id` bigint(20) DEFAULT NULL COMMENT '项目ID',
  `withdrawal_type` tinyint(2) DEFAULT '0' COMMENT '1、被并购  2、IPO上市  3、股权转让',
  `withdrawal_amount` double DEFAULT NULL COMMENT '投资金额',
  `withdrawal_share_ratio` double DEFAULT NULL COMMENT '投资占股比例',
  `withdrawal_date` datetime DEFAULT NULL COMMENT '投资日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='退出管理';

-- ----------------------------
-- Records of am_withdrawal
-- ----------------------------

-- ----------------------------
-- Table structure for api_resource
-- ----------------------------
DROP TABLE IF EXISTS `api_resource`;
CREATE TABLE `api_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `code` varchar(64) DEFAULT NULL COMMENT '编码',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编码',
  `name` varchar(32) DEFAULT NULL COMMENT '名字',
  `url` varchar(256) DEFAULT NULL COMMENT '链接',
  `url_type` tinyint(2) DEFAULT '1' COMMENT '链接类型；1：PC，2：APP',
  `is_enabled` tinyint(2) DEFAULT '1' COMMENT '是否启用，0：否，1：是',
  `is_whitelist` tinyint(2) DEFAULT NULL COMMENT '是否白名单',
  `description` varchar(512) DEFAULT NULL COMMENT '描述',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique` (`code`,`url_type`) USING BTREE,
  UNIQUE KEY `code_uq` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8 COMMENT='api资源表';

-- ----------------------------
-- Records of api_resource
-- ----------------------------
INSERT INTO `api_resource` VALUES ('1', '3', 'reservation.add', 'WM', '我的预约-->从我的预约页面进行预约', '/reservation/add', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('2', '3', 'reservation.submit_declaration', 'WM', '我的预约-->从我的预约页面提交报单', '/reservation/submit_declaration', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('3', '3', 'reservation.cancel', 'WM', '我的预约-->取消预约', '/reservation/cancel', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('4', '3', 'reservation.again_commit', 'WM', '我的预约-->重新提交', '/reservation/again_commit', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('5', '3', 'reservation.audit.get_page', 'WM', '预约额度审批-->获取预约额度审批分页数据接口', '/reservation/audit/get_page', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('6', '3', 'reservation.audit.do', 'WM', '预约额度审批-->预约额度审批页面，审批操作接口', '/reservation/audit/do', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('7', '3', 'reservation.audit.discard', 'WM', '预约额度审批-->预约作废', '/reservation/audit/discard', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('8', '3', 'reservation.audit.gets_audit_record', 'WM', '预约额度审批-->获取审批记录接口', '/reservation/audit/gets_audit_record', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('9', '3', 'leads.get_page', 'WM', '销售线索管理-->销售线索管理分页接口', '/leads/get_page', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('10', '3', 'leads.customer.get_unallot', 'WM', '销售线索管理-->获取未被分配的销售线索接口', '/leads/customer/get_unallot', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('11', '3', 'leads.allot', 'WM', '销售线索管理-->销售线索分配回访接口', '/leads/allot', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('12', '3', 'leads.try_allot', 'WM', '销售线索管理-->销售线索尝试分配客服', '/leads/try_allot', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('13', '3', 'leads.allot_to_fp', 'WM', '销售线索管理-->销售线索分配给理财师', '/leads/allot_to_fp', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('14', '3', 'receipt.plan.get_page', 'WM', '回款计划管理-->回款计划分页数据接口', '/receipt/plan/get_page', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('15', '3', 'receipt.plan.delete', 'WM', '回款计划管理-->删除回款计划接口', '/receipt/plan/delete', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('16', '3', 'receipt.record.add', 'WM', '回款计划管理-->录入回款接口', '/receipt/record/add', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('17', '3', 'receipt.plan.check_name_exist', 'WM', '回款计划管理-->检查回款计划名称是否存在接口', '/receipt/plan/check_name_exist', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('18', '3', 'product.get_select_option_for_receipt', 'WM', '回款计划管理-->添加回款计划 产品自动补全下拉接口', '/product/get_select_option_for_receipt', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('19', '3', 'receipt.plan.add', 'WM', '回款计划管理-->添加回款计划接口', '/receipt/plan/add', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('20', '3', 'receipt.plan.get', 'WM', '回款计划管理-->获取回款计划详情接口', '/receipt/plan/get', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('21', '3', 'receipt.plan.detail.get_receipts', 'WM', '回款计划管理-->回款计划详情回款记录列表接口', '/receipt/plan/detail/get_receipts', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('22', '3', 'receipt.record.delete', 'WM', '回款计划管理-->回款计划详情 删除回款记录几口', '/receipt/record/delete', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('23', '3', 'receipt.plan.update', 'WM', '回款计划管理-->修改回款计划接口', '/receipt/plan/update', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('24', '3', 'receipt.plan.detail.get_declarations', 'WM', '回款计划管理-->回款计划详情 关联报单列表接口', '/receipt/plan/detail/get_declarations', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('25', '3', 'receipt.plan.delete_declaration_rel', 'WM', '回款计划管理-->回款计划详情 移除关联报单', '/receipt/plan/delete_declaration_rel', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('26', '3', 'receipt.record.get_can_receipt_declarations', 'WM', '回款计划管理-->回款计划详情 获取可新增的关联报单接口', '/receipt/record/get_can_receipt_declarations', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('27', '3', 'receipt.plan.add_declaration_rel', 'WM', '回款计划管理-->回款计划详情 新增关联报单', '/receipt/plan/add_declaration_rel', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('28', '3', 'receipt.plan.check_name_exist_for_update', 'WM', '回款计划管理-->检查回款计划名称是否存在（更新操作使用）', '/receipt/plan/check_name_exist_for_update', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('29', '3', 'receipt.plan.detail.get_supplier', 'WM', '回款计划管理-->获取产品供应商', '/receipt/plan/detail/get_supplier', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('30', '3', 'role.gets', 'WM', '角色权限管理-->获取角色列表接口', '/role/gets', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('31', '3', 'resource.get_by_role_id', 'WM', '角色权限管理-->获取角色对应的资源列表接口', '/resource/get_by_role_id', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('32', '3', 'data.object.gets', 'WM', '角色权限管理-->获取角色对应的数据权限列表接口', '/data/object/gets', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('33', '3', 'user.get_by_role', 'WM', '角色权限管理-->获取角色关联员工列表接口', '/user/get_by_role', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('34', '3', 'role.add', 'WM', '角色权限管理-->添加角色接口', '/role/add', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('35', '3', 'role.update', 'WM', '角色权限管理-->修改角色接口', '/role/update', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('36', '3', 'role.delete', 'WM', '角色权限管理-->删除角色接口', '/role/delete', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('37', '3', 'resource.update_by_role_id', 'WM', '角色权限管理-->修改角色的功能权限接口', '/resource/update_by_role_id', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('38', '3', 'user.get_for_org', 'WM', '角色权限管理-->查看员工详情', '/user/get_for_org', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('39', '3', 'user.modify', 'WM', '角色权限管理&组织架构管理-->编辑用户', '/user/modify', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('40', '3', 'customer.v2.get_page', 'WM', '客户-->获取分页数据', '/customer/v2/get_page', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('41', '3', 'customer.v2.back.apply', 'WM', '客户-->放弃', '/customer/v2/back/apply', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('42', '3', 'customer.v2.add', 'WM', '客户-->新增客户', '/customer/v2/add', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('43', '3', 'customer.v2.import.multi', 'WM', '客户-->批量导入客户', '/customer/v2/import/multi', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('44', '3', 'customer.v2.distribution.allot_to_fp', 'WM', '客户-->调配', '/customer/v2/distribution/allot_to_fp', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('45', '3', 'customer.v2.distribution.recycle', 'WM', '客户-->回收', '/customer/v2/distribution/recycle', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('46', '3', 'customer.v2.distribution.allot_to_cs', 'WM', '客户-->分配回访', '/customer/v2/distribution/allot_to_cs', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('47', '3', 'user.customer.v2.focus', 'WM', '客户-->关注', '/user/customer/v2/focus', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('48', '3', 'department.gets', 'WM', '组织架构管理-->获取部门接口', '/department/gets', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('49', '3', 'user.get_enabled_users', 'WM', '组织架构管理-->获取在职员工接口', '/user/get_enabled_users', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('50', '3', 'user.get_cease_users', 'WM', '组织架构管理-->获取停用员工接口', '/user/get_cease_users', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('51', '3', 'user.cease', 'WM', '组织架构管理-->停用员工接口', '/user/cease', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('52', '3', 'user.enabled', 'WM', '组织架构管理-->启用员工接口', '/user/enabled', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('53', '3', 'department.add', 'WM', '组织架构管理-->新增部门接口', '/department/add', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('54', '3', 'department.update', 'WM', '组织架构管理-->编辑部门接口', '/department/update', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('55', '3', 'department.delete', 'WM', '组织架构管理-->删除部门接口', '/department/delete', '1', '1', '0', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('56', '3', 'customer.validate_mobile', 'WM', '白名单-->验证客户手机号是否可用', '/customer/validate_mobile', '1', '1', '1', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('57', '3', 'customer.update', 'WM', '白名单-->编辑客户基本资料', '/customer/update', '1', '1', '1', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('58', '3', 'customer.update_info', 'WM', '白名单-->编辑客户信息', '/customer/update_info', '1', '1', '1', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('59', '3', 'customer.update_contact', 'WM', '白名单-->编辑客户联系方式', '/customer/update_contact', '1', '1', '1', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('60', '3', 'customer.get_detail', 'WM', '白名单-->获取客户详情', '/customer/get_detail', '1', '1', '1', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('61', '3', 'customer.get_user_customer', 'WM', '白名单-->获取我的客户下拉选项', '/customer/get_user_customer', '1', '1', '1', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('62', '3', 'customer.follow.add', 'WM', '白名单-->添加跟进', '/customer/follow/add', '1', '1', '1', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('63', '3', 'leads.customer.detail.get_page', 'WM', '白名单-->获取客户详情页面销售线索列表', '/leads/customer/detail/get_page', '1', '1', '1', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('64', '3', 'leads.process', 'WM', '白名单-->处理销售线索', '/leads/process', '1', '1', '1', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('65', '3', 'resource.get_menu', 'WM', '白名单-->获取菜单和功能权限', '/resource/get_menu', '1', '1', '1', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('66', '3', 'dictionary.gets', 'WM', '白名单-->获取数据字段', '/dictionary/gets', '1', '1', '1', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('67', '3', 'msg.message.get_unread_count', 'WM', '白名单-->获取消息的个数', '/msg/message/get_unread_count', '1', '1', '1', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('68', '3', 'product.fieldgroup.get_all', 'WM', '白名单-->获取所有产品类别', '/product/fieldgroup/get_all', '1', '1', '1', null, '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource` VALUES ('69', '3', 'msg.message.get_my_page', 'WM', '白名单-->分页获取消息列表', '/msg/message/get_my_page', '1', '1', '1', null, '2017-12-02 09:39:02', null, null, null, '0');

-- ----------------------------
-- Table structure for api_resource_rel
-- ----------------------------
DROP TABLE IF EXISTS `api_resource_rel`;
CREATE TABLE `api_resource_rel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `resource_id` bigint(20) DEFAULT NULL COMMENT '资源id',
  `api_id` bigint(20) DEFAULT NULL COMMENT 'api资源id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`),
  KEY `resource_id_index` (`resource_id`),
  KEY `api_id_index` (`api_id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 COMMENT='api资源关系表';

-- ----------------------------
-- Records of api_resource_rel
-- ----------------------------
INSERT INTO `api_resource_rel` VALUES ('1', '3', '55', '1', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('2', '3', '27', '2', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('3', '3', '27', '3', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('4', '3', '27', '4', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('5', '3', '29', '5', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('6', '3', '57', '6', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('7', '3', '65', '7', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('8', '3', '29', '8', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('9', '3', '67', '9', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('10', '3', '68', '10', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('11', '3', '68', '11', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('12', '3', '68', '12', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('13', '3', '69', '13', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('14', '3', '78', '14', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('15', '3', '78', '15', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('16', '3', '78', '16', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('17', '3', '86', '17', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('18', '3', '86', '18', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('19', '3', '86', '19', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('20', '3', '78', '20', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('21', '3', '79', '20', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('22', '3', '78', '21', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('23', '3', '79', '21', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('24', '3', '78', '22', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('25', '3', '79', '22', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('26', '3', '78', '23', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('27', '3', '79', '23', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('28', '3', '78', '24', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('29', '3', '79', '24', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('30', '3', '78', '25', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('31', '3', '79', '25', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('32', '3', '78', '26', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('33', '3', '79', '26', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('34', '3', '78', '27', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('35', '3', '79', '27', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('36', '3', '78', '28', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('37', '3', '79', '28', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('38', '3', '78', '29', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('39', '3', '79', '29', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('40', '3', '2', '30', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('41', '3', '2', '31', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('42', '3', '2', '32', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('43', '3', '2', '33', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('44', '3', '2', '34', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('45', '3', '2', '35', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('46', '3', '2', '36', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('47', '3', '2', '37', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('48', '3', '2', '38', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('49', '3', '2', '39', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('50', '3', '91', '40', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('51', '3', '92', '41', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('52', '3', '93', '42', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('53', '3', '94', '43', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('54', '3', '95', '44', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('55', '3', '96', '45', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('56', '3', '97', '46', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('57', '3', '98', '47', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('58', '3', '6', '48', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('59', '3', '6', '49', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('60', '3', '6', '50', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('61', '3', '6', '51', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('62', '3', '6', '52', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('63', '3', '6', '53', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('64', '3', '6', '54', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('65', '3', '6', '55', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('66', '3', '6', '38', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('67', '3', '6', '39', '2017-12-02 09:39:02', null, null, null, '0');
INSERT INTO `api_resource_rel` VALUES ('68', '3', '6', '30', '2017-12-02 09:39:02', null, null, null, '0');

-- ----------------------------
-- Table structure for app_login
-- ----------------------------
DROP TABLE IF EXISTS `app_login`;
CREATE TABLE `app_login` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `login_id` bigint(20) DEFAULT NULL COMMENT '登录id',
  `network_type` varchar(32) DEFAULT NULL COMMENT '网络类型（WIFI）',
  `device_id` varchar(64) DEFAULT NULL COMMENT '设备id',
  `device_name` varchar(64) DEFAULT NULL COMMENT '设备名称（iPhone 6s）',
  `device_model` varchar(64) DEFAULT NULL COMMENT '设备型号（iPhone）',
  `vendor` varchar(64) DEFAULT NULL COMMENT '厂商（iPhone）',
  `operating_system` varchar(64) DEFAULT NULL COMMENT '操作系统（iPhone OS）',
  `app_version` varchar(64) DEFAULT NULL COMMENT 'app版本号',
  `device_resolution` varchar(32) DEFAULT NULL COMMENT '设备分辨率',
  `imei` varchar(32) DEFAULT NULL COMMENT '国际移动设备身份',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编码',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `i_tenant_id` (`tenant_id`),
  KEY `i_login_id` (`login_id`),
  KEY `i_create_user_id` (`create_user_id`),
  KEY `i_update_user_id` (`update_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='APP登录表';

-- ----------------------------
-- Records of app_login
-- ----------------------------

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `platform_id` bigint(20) DEFAULT NULL COMMENT '平台id',
  `title` varchar(128) DEFAULT NULL COMMENT '标题',
  `code` varchar(64) DEFAULT NULL COMMENT '编码，可用于URL地址',
  `cover_url` varchar(128) DEFAULT NULL COMMENT '封面图片',
  `pageview` int(11) DEFAULT NULL COMMENT '浏览量',
  `actual_pageview` int(11) DEFAULT '0' COMMENT '真实浏览量',
  `publish_date` datetime DEFAULT NULL COMMENT '发布时间',
  `sequence` int(11) DEFAULT '1' COMMENT '排序，越小越靠前',
  `status` tinyint(2) DEFAULT '1' COMMENT '状态，0：停用，1：启用',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  `seo_title` varchar(64) DEFAULT NULL COMMENT 'seo标题',
  `seo_keywords` varchar(128) DEFAULT NULL COMMENT 'seo关键字',
  `seo_description` varchar(256) DEFAULT NULL COMMENT 'seo描述',
  PRIMARY KEY (`id`),
  KEY `platform_id_index` (`platform_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='文章表';

-- ----------------------------
-- Records of article
-- ----------------------------

-- ----------------------------
-- Table structure for article_column
-- ----------------------------
DROP TABLE IF EXISTS `article_column`;
CREATE TABLE `article_column` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `platform_id` bigint(20) DEFAULT NULL COMMENT '平台id',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `code` varchar(64) DEFAULT NULL COMMENT '编码，可用于URL地址',
  `cover_url` varchar(128) DEFAULT NULL COMMENT '封面图片',
  `seo_title` varchar(64) DEFAULT NULL COMMENT 'seo title',
  `seo_keywords` varchar(128) DEFAULT NULL COMMENT 'seo keywords',
  `seo_description` varchar(256) DEFAULT NULL COMMENT 'seo description',
  `sequence` int(11) DEFAULT '1' COMMENT '排序，越小越靠前',
  `status` tinyint(2) DEFAULT '1' COMMENT '状态，0：停用，1：启用',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`),
  KEY `platform_id_index` (`platform_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_column
-- ----------------------------

-- ----------------------------
-- Table structure for article_column_rel
-- ----------------------------
DROP TABLE IF EXISTS `article_column_rel`;
CREATE TABLE `article_column_rel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `article_id` bigint(20) DEFAULT NULL COMMENT '文章id',
  `column_id` bigint(20) DEFAULT NULL COMMENT '栏目id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`),
  KEY `article_id_index` (`article_id`),
  KEY `column_id_index` (`column_id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8 COMMENT='文章与栏目关系表';

-- ----------------------------
-- Records of article_column_rel
-- ----------------------------

-- ----------------------------
-- Table structure for article_detail
-- ----------------------------
DROP TABLE IF EXISTS `article_detail`;
CREATE TABLE `article_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `article_id` bigint(20) DEFAULT NULL COMMENT '文章id',
  `feature` varchar(640) DEFAULT NULL COMMENT '导读',
  `author` varchar(32) DEFAULT NULL COMMENT '作者',
  `source` varchar(32) DEFAULT NULL COMMENT '文章来源',
  `content` text COMMENT '文章内容',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`),
  KEY `article_id_index` (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='文章详情表';

-- ----------------------------
-- Records of article_detail
-- ----------------------------

-- ----------------------------
-- Table structure for browser_login
-- ----------------------------
DROP TABLE IF EXISTS `browser_login`;
CREATE TABLE `browser_login` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `login_id` bigint(20) DEFAULT NULL COMMENT '登录id',
  `user_agent` varchar(1024) DEFAULT NULL COMMENT '浏览器头部代理信息',
  `browser_type` varchar(64) DEFAULT NULL COMMENT '浏览器类型（Internet Explorer 6）',
  `device_type` varchar(64) DEFAULT NULL COMMENT '设备类型（Computer）',
  `operating_system` varchar(64) DEFAULT NULL COMMENT '操作系统（Windows XP）',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编码',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `i_tenant_id` (`tenant_id`),
  KEY `i_login_id` (`login_id`),
  KEY `i_create_user_id` (`create_user_id`),
  KEY `i_update_user_id` (`update_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='浏览器登录表';

-- ----------------------------
-- Records of browser_login
-- ----------------------------

-- ----------------------------
-- Table structure for business_object
-- ----------------------------
DROP TABLE IF EXISTS `business_object`;
CREATE TABLE `business_object` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编码',
  `name` varchar(32) DEFAULT NULL COMMENT '名字',
  `code` varchar(64) DEFAULT NULL COMMENT '编码',
  `description` varchar(512) DEFAULT NULL COMMENT '描述',
  `is_share` tinyint(4) DEFAULT '0' COMMENT '是否共用，0：否，1：是',
  `is_data_access` tinyint(4) DEFAULT '0' COMMENT '是否开启数据访问，0：否，1：是',
  `is_enabled` tinyint(4) DEFAULT '1' COMMENT '是否启用，0：否，1：是',
  `sequence` int(11) DEFAULT '1' COMMENT '排序，越小越靠前',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，1：是；0：否',
  PRIMARY KEY (`id`),
  KEY `i_tenant_id` (`tenant_id`),
  KEY `i_name` (`name`),
  KEY `i_create_user_id` (`create_user_id`),
  KEY `i_update_user_id` (`update_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='业务对象';

-- ----------------------------
-- Records of business_object
-- ----------------------------
INSERT INTO `business_object` VALUES ('1', '3', 'WM', '产品', 'product', null, '0', '0', '1', '1', null, null, null, null, '0');

-- ----------------------------
-- Table structure for cc_customer_user_rel
-- ----------------------------
DROP TABLE IF EXISTS `cc_customer_user_rel`;
CREATE TABLE `cc_customer_user_rel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_account_id` bigint(20) NOT NULL COMMENT '用户账号id',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `customer_id` bigint(20) NOT NULL COMMENT '客户id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户用户关系';

-- ----------------------------
-- Records of cc_customer_user_rel
-- ----------------------------

-- ----------------------------
-- Table structure for cc_login
-- ----------------------------
DROP TABLE IF EXISTS `cc_login`;
CREATE TABLE `cc_login` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编码',
  `user_account_id` bigint(20) DEFAULT NULL COMMENT '用户账号id',
  `ip` varchar(32) DEFAULT NULL COMMENT 'ip地址',
  `status` tinyint(4) DEFAULT NULL COMMENT '登录状态，对应账号状态，1：正常使用；2：禁止登陆',
  `ticket` varchar(512) DEFAULT NULL COMMENT '登录凭证码',
  `type` varchar(32) DEFAULT NULL COMMENT '登录类型',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投资用户登录';

-- ----------------------------
-- Records of cc_login
-- ----------------------------

-- ----------------------------
-- Table structure for cc_login_detail
-- ----------------------------
DROP TABLE IF EXISTS `cc_login_detail`;
CREATE TABLE `cc_login_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `login_id` bigint(20) DEFAULT NULL COMMENT '登录id',
  `os_name` varchar(32) DEFAULT NULL COMMENT '操作系统名称',
  `device_type` varchar(32) DEFAULT NULL COMMENT '设备类型',
  `device_name` varchar(32) DEFAULT NULL COMMENT '设备名称',
  `resolution` varchar(16) DEFAULT NULL COMMENT '分辨率',
  `user_agent` varchar(512) DEFAULT NULL COMMENT '终端信息',
  `browser` varchar(64) DEFAULT NULL COMMENT '浏览器',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='登录详情';

-- ----------------------------
-- Records of cc_login_detail
-- ----------------------------

-- ----------------------------
-- Table structure for cc_product_consult
-- ----------------------------
DROP TABLE IF EXISTS `cc_product_consult`;
CREATE TABLE `cc_product_consult` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户id',
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品id',
  `consult_date` datetime DEFAULT NULL COMMENT '预约咨询时间',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品预约咨询表';

-- ----------------------------
-- Records of cc_product_consult
-- ----------------------------

-- ----------------------------
-- Table structure for cc_question
-- ----------------------------
DROP TABLE IF EXISTS `cc_question`;
CREATE TABLE `cc_question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `type_id` bigint(20) DEFAULT NULL COMMENT '类型id',
  `title` varchar(128) DEFAULT NULL COMMENT '标题',
  `type` tinyint(4) DEFAULT NULL COMMENT '类型，0：单选，1：多选，2：文本',
  `sequence` int(11) DEFAULT NULL COMMENT '排序',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='问答问题';

-- ----------------------------
-- Records of cc_question
-- ----------------------------
INSERT INTO `cc_question` VALUES ('1', '3', '1', '您现在的年龄是？', '0', '1', null, null, null, null, '0');
INSERT INTO `cc_question` VALUES ('2', '3', '1', '您目前的家庭净资产是？（折合人民币）', '0', '2', null, null, null, null, '0');
INSERT INTO `cc_question` VALUES ('3', '3', '1', '您的家庭年收入的状况是？（折合人民币）', '0', '3', null, null, null, null, '0');
INSERT INTO `cc_question` VALUES ('4', '3', '1', '以下哪项最能描述您的过去的投资分布？', '0', '4', null, null, null, null, '0');
INSERT INTO `cc_question` VALUES ('5', '3', '1', '以下哪项最能描述您对投资期限的偏好？', '0', '5', null, null, null, null, '0');
INSERT INTO `cc_question` VALUES ('6', '3', '1', '以下哪项最能描述您对投资历史经验？', '0', '6', null, null, null, null, '0');
INSERT INTO `cc_question` VALUES ('7', '3', '1', '以下情况，您会选择哪一种？', '0', '7', null, null, null, null, '0');
INSERT INTO `cc_question` VALUES ('8', '3', '1', '对投资以下哪项最能描述您投资的目的？', '0', '8', null, null, null, null, '0');
INSERT INTO `cc_question` VALUES ('9', '3', '1', '您最倾向于选择以下哪一种产品组合？', '0', '9', null, null, null, null, '0');

-- ----------------------------
-- Table structure for cc_question_answer
-- ----------------------------
DROP TABLE IF EXISTS `cc_question_answer`;
CREATE TABLE `cc_question_answer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `question_id` bigint(20) DEFAULT NULL COMMENT '问答id',
  `option_id` bigint(20) DEFAULT NULL COMMENT '选项id',
  `score_id` bigint(20) DEFAULT NULL COMMENT '答题成绩id',
  `content` varchar(512) DEFAULT NULL COMMENT '答题文本，当问题类型为“文本”时填写',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户答题';

-- ----------------------------
-- Records of cc_question_answer
-- ----------------------------

-- ----------------------------
-- Table structure for cc_question_option
-- ----------------------------
DROP TABLE IF EXISTS `cc_question_option`;
CREATE TABLE `cc_question_option` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `question_id` bigint(20) DEFAULT NULL COMMENT '问题id',
  `content` varchar(128) DEFAULT NULL COMMENT '选项内容',
  `grade` int(11) DEFAULT NULL COMMENT '分数',
  `sequence` int(11) DEFAULT NULL COMMENT '排序',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='问答选项';

-- ----------------------------
-- Records of cc_question_option
-- ----------------------------
INSERT INTO `cc_question_option` VALUES ('1', '3', '1', 'A.18-30', '3', '1', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('2', '3', '1', 'B.31-50', '5', '2', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('3', '3', '1', 'C.51-65', '4', '3', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('4', '3', '1', 'D.高于65岁', '2', '4', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('5', '3', '2', 'A.低于600万', '2', '1', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('6', '3', '2', 'B.600万-2000万', '3', '2', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('7', '3', '2', 'C.2000万-1亿', '4', '3', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('8', '3', '2', 'D.大于1亿', '5', '4', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('9', '3', '3', 'A.收入来源稳定，平均年收入在50万以下', '2', '1', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('10', '3', '3', 'B.收入来源稳定，平均年收入在50万-200万', '4', '2', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('11', '3', '3', 'C.收入来源稳定，平均年收入在200万以上', '5', '3', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('12', '3', '3', 'D.收入来源不稳定，过去五年中平均年收入100万以下', '1', '4', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('13', '3', '3', 'E.收入来源不稳定，过去五年的平均年收入在100万以上', '3', '5', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('14', '3', '4', 'A.大部分投资于银行的存款和理财产品，少部分投资于其他金融产品，比如基金和股票', '2', '1', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('15', '3', '4', 'B.资产均衡地分布于存款和银行理财产品、信托或资管产品、基金和股票等', '3', '2', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('16', '3', '4', 'C.大部分投资于股票、基金、外汇等高风险产品，少部分投资于信托等类固定收益产品', '4', '3', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('17', '3', '4', 'D.投资多元化，以股权投资和资本市场投资为主，包括股票，期货等', '5', '4', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('18', '3', '5', 'A.以6个月以内的短期产品或方便赎回的流动性强的产品为主', '2', '1', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('19', '3', '5', 'B.在资产配置的基础上，以1-5年的中等期限的投资为主', '3', '2', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('20', '3', '5', 'C.在资产配置的基础上，以大于5年的长期投资为主', '5', '3', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('21', '3', '5', 'D.通过资产配置，均衡分布于短期（小于1年），中期（1-5年）和长期（大于5年）的期限分布', '4', '4', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('22', '3', '6', 'A.初涉投资，经验尚浅。具有1年以内的经验，主要接触的是基金和股票等公募产品或信托类型的类固定收益产品', '2', '1', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('23', '3', '6', 'B.略懂一二，经验尚可。具有1-3年的经验，主要接触的资本市场产品，包括股票和基金；或者信托和资管类的类固定收益产品；接触过海外市场背景的产品', '3', '2', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('24', '3', '6', 'C.比较熟悉，较有经验。具有3－10年的经验，熟悉资本市场产品，包括股票和基金；或者信托和资管类的类固定收益产品；或者私募类的投资产品以及房产，贵金属等投资；接触过海外市场背景的产品', '4', '3', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('25', '3', '6', 'D.深谙此道，经验丰富。拥有10年以上的经验，熟悉通过股权和债权等方式进行的实业相关的投资或房产投资，或者或者熟悉资本市场产品，包括股票和基金；或者信托和资管类的类固定收益产品。对海外市场的投资有一定了解', '5', '4', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('26', '3', '7', 'A.有100%的机会赢取5000元现金', '2', '1', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('27', '3', '7', 'B.有50%的机会赢取5万元现金', '3', '2', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('28', '3', '7', 'C.有25%的机会赢取10万元现金', '4', '3', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('29', '3', '7', 'D.有10%的机会赢取50万元现金', '5', '4', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('30', '3', '8', 'A.保全现有资产，抵御通货膨胀', '2', '1', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('31', '3', '8', 'B.多元化配置分散风险，稳健增值，考虑资产传承', '3', '2', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('32', '3', '8', 'C.增加财产性收入，达到或巩固财务自由状态', '4', '3', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('33', '3', '8', 'D.实现资本增值和继续的积累', '5', '4', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('34', '3', '9', 'A.预期收益60％，最好150%，最差损失100%本金', '5', '1', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('35', '3', '9', 'B.预期收益20%，最好50%，最差损失30%本金', '4', '2', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('36', '3', '9', 'C.预期收益15%，最好20%，最差损失10%本金', '3', '3', null, null, null, null, '0');
INSERT INTO `cc_question_option` VALUES ('37', '3', '9', 'D.预期收益4%，最好8%，最差收益0%', '2', '4', null, null, null, null, '0');

-- ----------------------------
-- Table structure for cc_question_score
-- ----------------------------
DROP TABLE IF EXISTS `cc_question_score`;
CREATE TABLE `cc_question_score` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `user_account_id` bigint(20) DEFAULT NULL COMMENT '用户账号id',
  `grade` int(11) DEFAULT NULL COMMENT '得分',
  `question_type_id` bigint(20) DEFAULT NULL COMMENT '问答类型id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户答题成绩';

-- ----------------------------
-- Records of cc_question_score
-- ----------------------------

-- ----------------------------
-- Table structure for cc_question_type
-- ----------------------------
DROP TABLE IF EXISTS `cc_question_type`;
CREATE TABLE `cc_question_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `code` varchar(32) DEFAULT NULL COMMENT '编码',
  `name` varchar(64) DEFAULT NULL COMMENT '类型名称',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='问答类型';

-- ----------------------------
-- Records of cc_question_type
-- ----------------------------
INSERT INTO `cc_question_type` VALUES ('1', '3', 'risk', '分析评估', null, null, null, null, '0');

-- ----------------------------
-- Table structure for cc_risk_rating
-- ----------------------------
DROP TABLE IF EXISTS `cc_risk_rating`;
CREATE TABLE `cc_risk_rating` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `label` varchar(16) DEFAULT NULL COMMENT '文本',
  `value` int(11) DEFAULT NULL COMMENT '值，1：保守型，2：适度保守型，3：平衡型，4：适度进取型，5：进取型',
  `grade_min` int(11) DEFAULT NULL COMMENT '分数最小区间',
  `grade_max` int(11) DEFAULT NULL COMMENT '分数最大区间',
  `comment` varchar(256) DEFAULT NULL COMMENT '评语',
  `img_description` varchar(250) DEFAULT NULL COMMENT '图片描述信息',
  `img_url` varchar(250) DEFAULT NULL COMMENT '图片url',
  `portfolio_income` double DEFAULT NULL COMMENT '组合收益',
  `portfolio_risk` double DEFAULT NULL COMMENT '组合风险',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用户风险评估';

-- ----------------------------
-- Records of cc_risk_rating
-- ----------------------------
INSERT INTO `cc_risk_rating` VALUES ('1', '3', '保守型', '1', '0', '60', '建议您的资产配置中以保障类，现金管理类为主，类固定收益类资产配置不益超过25%，对股权类产品需要非常谨慎，不益超过整个资产组合的5%。', '如图在95%的置信区间下获取预期收益时左右波动（风险）较低', 'https://file.yundaojishu.com/335e12500764449f96b50ed0805c3428.png', '5.7', '1.7', null, null, null, null, '0');
INSERT INTO `cc_risk_rating` VALUES ('2', '3', '适度保守型', '2', '60', '70', '建议您的资产配置中以保障类，现金管理类为主，类固定收益类资产配置不益超过40%，股权类产品资产配置不益超15%。', '如图在95%的置信区间下获取预期收益时左右波动（风险）较低到中等', 'https://file.yundaojishu.com/242285d9adfe461ba85d5af182dcf70d.png', '9.4', '2.5', null, null, null, null, '0');
INSERT INTO `cc_risk_rating` VALUES ('3', '3', '平衡型', '3', '70', '80', '建议您的资产配置在各大资产种类里比较平衡分配，保障类，现金管理类资产配置在30%，类固定收益类资产配置在40%，股权等其他类资产配置在30%。', '如图在95%的置信区间下获取预期收益时左右波动（风险）中等', 'https://file.yundaojishu.com/cb69420de5d642a98178ad58d92cf285.png', '13.7', '3.5', null, null, null, null, '0');
INSERT INTO `cc_risk_rating` VALUES ('4', '3', '适度进取型', '4', '80', '90', '建议您的资产配置中以股权和夹层投资等为主，保障类，现金管理类资产配置在15%，类固定收益类资产配置在35%，股权等其他类资产配置在50%。', '如图在95%的置信区间下获取预期收益时左右波动（风险）较高', 'https://file.yundaojishu.com/5f52632e4dcd44b6b0eea46e08a37378.png', '20.5', '4.1', null, null, null, null, '0');
INSERT INTO `cc_risk_rating` VALUES ('5', '3', '进取型', '5', '90', '100', '建议在您的资产配置中以股权投资为主，保障类，现金管理类资产配置在10%以内，类固定收益类资产配置在25%，股权类和另类投资类资产配置在65%以上。', '如图在95%的置信区间下获取预期收益时左右波动（风险）高', 'https://file.yundaojishu.com/52eecdd4a274484c91c9647db668db12.png', '30.4', '4.7', null, null, null, null, '0');

-- ----------------------------
-- Table structure for cc_ticket
-- ----------------------------
DROP TABLE IF EXISTS `cc_ticket`;
CREATE TABLE `cc_ticket` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `user_account_id` bigint(20) DEFAULT NULL COMMENT '用户账号id',
  `ticket` varchar(512) DEFAULT NULL COMMENT '登录凭证码',
  `active_time` int(11) DEFAULT NULL COMMENT '存活时间，单位秒，-1代表永不过期',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `type` varchar(32) DEFAULT NULL COMMENT '类型，C_PC，C_APP',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投资用户登录凭证';

-- ----------------------------
-- Records of cc_ticket
-- ----------------------------

-- ----------------------------
-- Table structure for cc_user_account
-- ----------------------------
DROP TABLE IF EXISTS `cc_user_account`;
CREATE TABLE `cc_user_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `mobile` varchar(256) DEFAULT NULL COMMENT '手机号',
  `user_name` varchar(256) DEFAULT NULL COMMENT '账号',
  `password` varchar(128) DEFAULT NULL COMMENT '密码',
  `status` tinyint(4) DEFAULT '1' COMMENT '账号状态，1：正常使用；2：禁止登陆',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投资用户账号表';

-- ----------------------------
-- Records of cc_user_account
-- ----------------------------

-- ----------------------------
-- Table structure for cc_user_detail
-- ----------------------------
DROP TABLE IF EXISTS `cc_user_detail`;
CREATE TABLE `cc_user_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `user_account_id` bigint(20) DEFAULT NULL COMMENT '用户账号id',
  `avatar` varchar(64) DEFAULT NULL COMMENT '头像',
  `nick_name` varchar(16) DEFAULT NULL COMMENT '昵称',
  `real_name` varchar(32) DEFAULT NULL COMMENT '姓名',
  `sex` tinyint(4) DEFAULT NULL COMMENT '1：男；2：女',
  `birth` datetime DEFAULT NULL COMMENT '生日',
  `wechat` varchar(256) DEFAULT NULL COMMENT '微信',
  `qq` varchar(256) DEFAULT NULL COMMENT 'qq',
  `email` varchar(256) DEFAULT NULL COMMENT '邮箱',
  `province_code` varchar(32) DEFAULT NULL COMMENT '省份',
  `city_code` varchar(32) DEFAULT NULL COMMENT '市',
  `address` varchar(256) DEFAULT NULL COMMENT '地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投资用户详情';

-- ----------------------------
-- Records of cc_user_detail
-- ----------------------------

-- ----------------------------
-- Table structure for cloud_file
-- ----------------------------
DROP TABLE IF EXISTS `cloud_file`;
CREATE TABLE `cloud_file` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `type` tinyint(2) DEFAULT '0' COMMENT '云类型，0：阿里云；1：腾讯云；2：ucloud云',
  `url` varchar(512) DEFAULT NULL COMMENT '链接',
  `create_user_id` int(11) DEFAULT NULL COMMENT '创建者id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间 ',
  `update_user_id` int(11) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，1：是；0：否',
  `original_name` varchar(128) DEFAULT NULL COMMENT '原文件名',
  `nsc_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='云文件表';

-- ----------------------------
-- Records of cloud_file
-- ----------------------------
INSERT INTO `cloud_file` VALUES ('1', null, '0', 'http://file.yundaojishu.com/65600025015845d9bebecd3d65a1051f.jpg', null, '2017-11-02 15:50:47', null, null, '0', 'a_20151211040010250.jpg', null);
INSERT INTO `cloud_file` VALUES ('2', null, '0', 'http://file.yundaojishu.com/48b12772492d4d5bbbd07e2eeade0860.jpeg', null, '2017-11-02 15:50:49', null, null, '0', 'mp46107783_1449117860569_3.jpeg', null);
INSERT INTO `cloud_file` VALUES ('3', null, '0', 'http://file.yundaojishu.com/a0fb34f521d94b42bd1423acfbed19f0.jpg', null, '2017-11-02 15:50:53', null, null, '0', 'a_20151211023749517.jpg', null);
INSERT INTO `cloud_file` VALUES ('4', null, '0', 'http://file.yundaojishu.com/7f6ac2aab87b4a9584c473e0d36cfef4.jpg', null, '2017-11-02 15:51:23', null, null, '0', 'a_20151211040010250.jpg', null);
INSERT INTO `cloud_file` VALUES ('5', null, '0', 'http://file.yundaojishu.com/62a99f909daa4165972d00d5f6bd30c7.jpg', null, '2017-11-02 15:51:31', null, null, '0', 'serror.jpg', null);
INSERT INTO `cloud_file` VALUES ('6', null, '0', 'http://file.yundaojishu.com/5c5d010747ee464ca36f1ae1a8063d4d.jpg', null, '2017-11-02 15:51:39', null, null, '0', 'a_20151024104108412.jpg', null);
INSERT INTO `cloud_file` VALUES ('7', null, '0', 'http://file.yundaojishu.com/72327018e6534b4a8779807c31b36d7a.jpg', null, '2017-11-02 15:51:41', null, null, '0', 'a_20151211023749517.jpg', null);

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `name` varchar(32) DEFAULT NULL COMMENT '姓名',
  `sex` tinyint(2) DEFAULT NULL COMMENT '性别(1：男，2：女)',
  `number` varchar(32) DEFAULT NULL COMMENT '客户编号',
  `mobile` varchar(256) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(256) DEFAULT NULL COMMENT '邮箱',
  `level` tinyint(2) DEFAULT NULL COMMENT '客户级别(1：A[最重要]，2：[重要]，3：[普通]，4[沉默])',
  `risk_rating` tinyint(2) DEFAULT NULL COMMENT '风险特征（1：保守型，2：适度保守型，3：平衡型，4：适度进取型，5：进取型）',
  `type` tinyint(2) DEFAULT NULL COMMENT '投资人类型（1：普通投资人，2：专业投资人）',
  `source` tinyint(2) DEFAULT NULL COMMENT '客户来源（1：自我开发，2：客户转介绍，3：市场活动，4：其他）',
  `status` tinyint(2) DEFAULT '0' COMMENT '客户状态（0：未确认，1：有效，2：无效）',
  `belong_type` tinyint(4) DEFAULT NULL COMMENT '属于类型（0： 私人，1：公海,2：销售线索）',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8 COMMENT='客户表';

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('10000', '3', '客户001', '0', '00010000', 'DB8ACC6CE32EC4D0252112B301BF816B', null, '2', null, null, null, '1', '0', null, '46', '2017-11-02 15:49:45', null, null, '0');

-- ----------------------------
-- Table structure for customer_anniversaries
-- ----------------------------
DROP TABLE IF EXISTS `customer_anniversaries`;
CREATE TABLE `customer_anniversaries` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户id',
  `name` varchar(32) DEFAULT NULL COMMENT '名称',
  `anvr_time` datetime DEFAULT NULL COMMENT '日期',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `tenant_id_index` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户纪念日表';

-- ----------------------------
-- Records of customer_anniversaries
-- ----------------------------

-- ----------------------------
-- Table structure for customer_attach
-- ----------------------------
DROP TABLE IF EXISTS `customer_attach`;
CREATE TABLE `customer_attach` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户id',
  `name` varchar(128) DEFAULT NULL COMMENT '附件名称',
  `url` varchar(256) DEFAULT NULL COMMENT 'url',
  `type` int(6) DEFAULT NULL COMMENT '附件类型（1：资产证明）',
  `type_name` char(10) DEFAULT NULL COMMENT '类型名称',
  `seqencing` int(6) DEFAULT NULL COMMENT '排序',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `tenant_id_index` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='客户附件表';

-- ----------------------------
-- Records of customer_attach
-- ----------------------------
INSERT INTO `customer_attach` VALUES ('1', '3', '10000', 'a_20151211023749517.jpg', 'http://file.yundaojishu.com/a0fb34f521d94b42bd1423acfbed19f0.jpg', '1', '资产证明', '1', '46', '2017-11-02 15:51:08', null, null, '0');

-- ----------------------------
-- Table structure for customer_back_examine
-- ----------------------------
DROP TABLE IF EXISTS `customer_back_examine`;
CREATE TABLE `customer_back_examine` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '申请发起人',
  `reason` varchar(128) DEFAULT NULL COMMENT '回退原因',
  `application_date` datetime DEFAULT NULL COMMENT '申请时间',
  `examine_date` datetime DEFAULT NULL COMMENT '审核时间',
  `examine_user_id` bigint(20) DEFAULT NULL COMMENT '审核人',
  `status` tinyint(2) DEFAULT NULL COMMENT '状态  1:审核中  2:通过  3驳回',
  `reject_reason` varchar(128) DEFAULT NULL COMMENT '驳回原因',
  `is_delete` tinyint(2) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `tenant_id_index` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户回退审核';

-- ----------------------------
-- Records of customer_back_examine
-- ----------------------------

-- ----------------------------
-- Table structure for customer_bank
-- ----------------------------
DROP TABLE IF EXISTS `customer_bank`;
CREATE TABLE `customer_bank` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `account` varchar(32) DEFAULT NULL COMMENT '银行卡账号',
  `bank_name` varchar(128) DEFAULT NULL COMMENT '开户行',
  `front` varchar(128) DEFAULT NULL COMMENT '银行卡正面',
  `back` varchar(128) DEFAULT NULL COMMENT '银行卡反面',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='客户银行卡表';

-- ----------------------------
-- Records of customer_bank
-- ----------------------------
INSERT INTO `customer_bank` VALUES ('1', '3', '45300021233211', '中国银行', 'http://file.yundaojishu.com/7f6ac2aab87b4a9584c473e0d36cfef4.jpg', 'http://file.yundaojishu.com/62a99f909daa4165972d00d5f6bd30c7.jpg', '46', '2017-11-02 15:51:35', null, null, '0');
INSERT INTO `customer_bank` VALUES ('2', '3', '45300021233211', '中国银行', 'http://file.yundaojishu.com/7f6ac2aab87b4a9584c473e0d36cfef4.jpg', 'http://file.yundaojishu.com/62a99f909daa4165972d00d5f6bd30c7.jpg', '46', '2017-11-02 15:51:35', null, null, '0');

-- ----------------------------
-- Table structure for customer_bank_rel
-- ----------------------------
DROP TABLE IF EXISTS `customer_bank_rel`;
CREATE TABLE `customer_bank_rel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户id',
  `bank_id` bigint(20) DEFAULT NULL COMMENT '银行卡id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tenant_id_index` (`customer_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='客户银行卡关系';

-- ----------------------------
-- Records of customer_bank_rel
-- ----------------------------
INSERT INTO `customer_bank_rel` VALUES ('1', '3', '10000', '2', '46', '2017-11-02 15:51:35', null, null, '0');

-- ----------------------------
-- Table structure for customer_credentials
-- ----------------------------
DROP TABLE IF EXISTS `customer_credentials`;
CREATE TABLE `customer_credentials` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `type` bigint(2) DEFAULT NULL COMMENT '证件类型（1：身份证，2：护照）',
  `number` varchar(32) DEFAULT NULL COMMENT '证件号码',
  `front` varchar(128) DEFAULT NULL COMMENT '证件正面',
  `back` varchar(128) DEFAULT NULL COMMENT '证件反面',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='客户证件表';

-- ----------------------------
-- Records of customer_credentials
-- ----------------------------
INSERT INTO `customer_credentials` VALUES ('1', null, '1', '432012015621656545', 'http://file.yundaojishu.com/65600025015845d9bebecd3d65a1051f.jpg', 'http://file.yundaojishu.com/48b12772492d4d5bbbd07e2eeade0860.jpeg', '46', '2017-11-02 15:51:08', null, null, '0');
INSERT INTO `customer_credentials` VALUES ('2', null, '1', '432012015621656545', 'http://file.yundaojishu.com/65600025015845d9bebecd3d65a1051f.jpg', 'http://file.yundaojishu.com/48b12772492d4d5bbbd07e2eeade0860.jpeg', '46', '2017-11-02 15:51:08', null, null, '0');

-- ----------------------------
-- Table structure for customer_credentials_rel
-- ----------------------------
DROP TABLE IF EXISTS `customer_credentials_rel`;
CREATE TABLE `customer_credentials_rel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户id',
  `credentials_id` bigint(20) DEFAULT NULL COMMENT '证件id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `tenant_id_index` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='客户证件关系表';

-- ----------------------------
-- Records of customer_credentials_rel
-- ----------------------------
INSERT INTO `customer_credentials_rel` VALUES ('1', '3', '10000', '2', '46', '2017-11-02 15:51:08', null, null, '0');

-- ----------------------------
-- Table structure for customer_detail
-- ----------------------------
DROP TABLE IF EXISTS `customer_detail`;
CREATE TABLE `customer_detail` (
  `id` bigint(20) NOT NULL COMMENT '客户id',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `wechat` varchar(256) DEFAULT NULL COMMENT '微信',
  `qq` varchar(256) DEFAULT NULL COMMENT 'qq',
  `province_code` varchar(32) DEFAULT NULL COMMENT '省份',
  `city_code` varchar(32) DEFAULT NULL COMMENT '市',
  `address` varchar(256) DEFAULT NULL COMMENT '地址',
  `trade` varchar(64) DEFAULT NULL COMMENT '行业',
  `organization` varchar(128) DEFAULT NULL COMMENT '机构',
  `position` varchar(64) DEFAULT NULL COMMENT '职位',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户详情表';

-- ----------------------------
-- Records of customer_detail
-- ----------------------------
INSERT INTO `customer_detail` VALUES ('10000', '3', null, null, null, null, null, null, null, null, null, '0');

-- ----------------------------
-- Table structure for customer_follow_up
-- ----------------------------
DROP TABLE IF EXISTS `customer_follow_up`;
CREATE TABLE `customer_follow_up` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户id',
  `type` tinyint(2) DEFAULT NULL COMMENT '跟进方式',
  `status` tinyint(2) DEFAULT NULL COMMENT '跟进状态',
  `content` varchar(512) DEFAULT NULL COMMENT '跟进内容',
  `map_type` tinyint(4) DEFAULT NULL COMMENT '地图类型： 1:高德 2：百度',
  `itude_x` double DEFAULT NULL COMMENT '经度',
  `itude_y` double DEFAULT NULL COMMENT '纬度',
  `address` varchar(256) DEFAULT NULL COMMENT '地址',
  `next_follow_date` datetime DEFAULT NULL COMMENT '下次跟进时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  `next_message_send` tinyint(2) DEFAULT '1' COMMENT '下次跟进是否生成消息，1未生成，2生成。',
  PRIMARY KEY (`id`),
  KEY `tenant_id_index` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户跟进';

-- ----------------------------
-- Records of customer_follow_up
-- ----------------------------

-- ----------------------------
-- Table structure for customer_follow_up_attach
-- ----------------------------
DROP TABLE IF EXISTS `customer_follow_up_attach`;
CREATE TABLE `customer_follow_up_attach` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `custoemr_follow_up_id` bigint(20) DEFAULT NULL COMMENT '客户跟进记录Id',
  `name` varchar(256) DEFAULT NULL COMMENT '文件名称',
  `url` varchar(256) DEFAULT NULL,
  `format` varchar(255) DEFAULT NULL COMMENT '文件格式',
  `sort` float DEFAULT NULL COMMENT '排序',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '是否删除 0:否 1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户跟进附件表';

-- ----------------------------
-- Records of customer_follow_up_attach
-- ----------------------------

-- ----------------------------
-- Table structure for customer_invest_type
-- ----------------------------
DROP TABLE IF EXISTS `customer_invest_type`;
CREATE TABLE `customer_invest_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户id',
  `product_type_id` bigint(20) DEFAULT NULL COMMENT '投资偏好',
  `seqencing` int(6) DEFAULT NULL COMMENT '排序',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `tenant_id_index` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户投资偏好';

-- ----------------------------
-- Records of customer_invest_type
-- ----------------------------

-- ----------------------------
-- Table structure for customer_tag
-- ----------------------------
DROP TABLE IF EXISTS `customer_tag`;
CREATE TABLE `customer_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tag_id` bigint(20) DEFAULT NULL COMMENT '标签表_id',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户ID',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  `seqencing` bigint(6) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`),
  KEY `customer_tag_index` (`tag_id`,`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户标签关联表';

-- ----------------------------
-- Records of customer_tag
-- ----------------------------

-- ----------------------------
-- Table structure for customer_transfer
-- ----------------------------
DROP TABLE IF EXISTS `customer_transfer`;
CREATE TABLE `customer_transfer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户ID',
  `after_user` varchar(64) DEFAULT NULL COMMENT '移交后归属人名称',
  `after_user_id` bigint(20) DEFAULT NULL COMMENT '移交后归属id',
  `before_user` varchar(64) DEFAULT NULL COMMENT '移交前归属人名称',
  `before_user_id` bigint(20) DEFAULT NULL COMMENT '移交前归属id',
  `transfer_date` datetime DEFAULT NULL COMMENT '移交时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '操作人',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  `is_delete` tinyint(2) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `tenant_id_index` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户移交记录';

-- ----------------------------
-- Records of customer_transfer
-- ----------------------------

-- ----------------------------
-- Table structure for data_access
-- ----------------------------
DROP TABLE IF EXISTS `data_access`;
CREATE TABLE `data_access` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  `business_object_id` bigint(20) DEFAULT NULL COMMENT '业务对象id',
  `delete_permission` tinyint(4) DEFAULT '0' COMMENT '删除权限，0：无权限，1：本人，2：本人及下属，3：本级，4：本级及下属，5：全部',
  `edit_permission` tinyint(4) DEFAULT '0' COMMENT '编辑权限，0：无权限，1：本人，2：本人及下属，3：本级，4：本级及下属，5：全部',
  `read_permission` tinyint(4) DEFAULT '0' COMMENT '读取权限，0：无权限，1：本人，2：本人及下属，3：本级，4：本级及下属，5：全部',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，1：是；0：否',
  PRIMARY KEY (`id`),
  KEY `i_tenant_id` (`tenant_id`),
  KEY `i_role_id` (`role_id`),
  KEY `i_create_user_id` (`create_user_id`),
  KEY `i_update_user_id` (`update_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务对象数据访问控制(删除)';

-- ----------------------------
-- Records of data_access
-- ----------------------------

-- ----------------------------
-- Table structure for data_object
-- ----------------------------
DROP TABLE IF EXISTS `data_object`;
CREATE TABLE `data_object` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `name` varchar(32) DEFAULT NULL COMMENT '名称',
  `code` varchar(32) DEFAULT NULL COMMENT '编码',
  `description` varchar(512) DEFAULT NULL COMMENT '描述',
  `sequence` int(11) DEFAULT '1' COMMENT '排序，越小越靠前',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data_object
-- ----------------------------
INSERT INTO `data_object` VALUES ('1', '3', '产品', 'product', null, '30', '2017-07-13 10:17:29', '1', null, null, '0');
INSERT INTO `data_object` VALUES ('2', '3', '产品供应商报价', 'supplier', null, '40', '2017-07-13 10:17:58', '1', null, null, '0');
INSERT INTO `data_object` VALUES ('3', '3', '产品销售佣金', 'commission', null, '50', '2017-07-13 10:18:40', '1', null, null, '0');
INSERT INTO `data_object` VALUES ('4', '3', '产品公告', 'notice', null, '60', '2017-07-13 10:19:01', '1', null, null, '0');
INSERT INTO `data_object` VALUES ('5', '3', '客户基本资料', 'customer', null, '70', '2017-07-13 10:19:13', '1', null, null, '0');
INSERT INTO `data_object` VALUES ('6', '3', '客户联系信息', 'contact', null, '80', '2017-07-13 10:19:39', '1', null, null, '0');
INSERT INTO `data_object` VALUES ('7', '3', '产品要素', 'product_element', null, '10', '2017-07-24 17:14:59', '1', null, null, '1');
INSERT INTO `data_object` VALUES ('8', '3', '产品类别', 'product_type', null, '20', '2017-07-24 17:15:20', '1', null, null, '1');
INSERT INTO `data_object` VALUES ('9', '3', '预约', 'reservation', null, '110', '2017-07-25 11:26:24', '1', null, null, '0');
INSERT INTO `data_object` VALUES ('10', '3', '报单', 'declaration', null, '120', '2017-07-25 11:34:16', '1', null, null, '0');
INSERT INTO `data_object` VALUES ('11', '3', '回访', 'visit', null, '130', '2017-07-25 11:49:40', '1', null, null, '0');
INSERT INTO `data_object` VALUES ('12', '3', '销售线索', 'leads', null, '90', '2017-07-25 11:49:40', '1', null, null, '0');
INSERT INTO `data_object` VALUES ('13', '3', '跟进', 'follow', null, '100', '2017-07-25 11:49:40', '1', null, null, '1');
INSERT INTO `data_object` VALUES ('14', '3', '业绩报表(APP)', 'report', null, '140', '2017-11-03 11:49:40', '1', null, null, '0');
INSERT INTO `data_object` VALUES ('15', '3', '项目', 'project', null, '1', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object` VALUES ('16', '3', '基金', 'fund', null, '5', '2017-11-26 14:11:15', '1', null, null, '0');

-- ----------------------------
-- Table structure for data_object_access
-- ----------------------------
DROP TABLE IF EXISTS `data_object_access`;
CREATE TABLE `data_object_access` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `data_object_id` bigint(20) DEFAULT NULL COMMENT '数据对象id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  `read_permission` tinyint(4) DEFAULT '0' COMMENT '读取权限，0：无权限，10：我的，20：团队，30：部门，40：全部',
  `delete_permission` tinyint(4) DEFAULT '0' COMMENT '删除权限，0：无权限，10：我的，20：团队，30：部门，40：全部',
  `edit_permission` tinyint(4) DEFAULT '0' COMMENT '编辑权限，0：无权限，10：我的，20：团队，30：部门，40：全部',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=137 DEFAULT CHARSET=utf8 COMMENT='数据对象的访问权限';

-- ----------------------------
-- Records of data_object_access
-- ----------------------------
INSERT INTO `data_object_access` VALUES ('1', '3', '7', '1', '40', '40', '40', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '1');
INSERT INTO `data_object_access` VALUES ('2', '3', '8', '1', '40', '40', '40', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '1');
INSERT INTO `data_object_access` VALUES ('3', '3', '1', '1', '40', '40', '40', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('4', '3', '2', '1', '40', '0', '40', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('5', '3', '3', '1', '40', '0', '40', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('6', '3', '4', '1', '40', '40', '40', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('7', '3', '5', '1', '40', '0', '40', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('8', '3', '6', '1', '40', '0', '40', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('9', '3', '12', '1', '10', '0', '40', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('10', '3', '13', '1', '40', '40', '40', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '1');
INSERT INTO `data_object_access` VALUES ('11', '3', '9', '1', '40', '0', '40', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('12', '3', '10', '1', '40', '0', '40', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('13', '3', '11', '1', '40', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('14', '3', '7', '2', '40', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '1');
INSERT INTO `data_object_access` VALUES ('15', '3', '8', '2', '40', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '1');
INSERT INTO `data_object_access` VALUES ('16', '3', '1', '2', '40', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('17', '3', '2', '2', '0', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('18', '3', '3', '2', '40', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('19', '3', '4', '2', '40', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('20', '3', '5', '2', '10', '0', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('21', '3', '6', '2', '10', '0', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('22', '3', '12', '2', '10', '0', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('23', '3', '13', '2', '40', '0', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '1');
INSERT INTO `data_object_access` VALUES ('24', '3', '9', '2', '40', '0', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('25', '3', '10', '2', '40', '0', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('26', '3', '11', '2', '0', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('27', '3', '7', '3', '40', '40', '40', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '1');
INSERT INTO `data_object_access` VALUES ('28', '3', '8', '3', '40', '40', '40', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '1');
INSERT INTO `data_object_access` VALUES ('29', '3', '1', '3', '40', '10', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('30', '3', '2', '3', '40', '0', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('31', '3', '3', '3', '40', '0', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('32', '3', '4', '3', '40', '10', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('33', '3', '5', '3', '40', '0', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('34', '3', '6', '3', '10', '0', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('35', '3', '12', '3', '10', '0', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('36', '3', '13', '3', '40', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '1');
INSERT INTO `data_object_access` VALUES ('37', '3', '9', '3', '40', '0', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('38', '3', '10', '3', '40', '0', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('39', '3', '11', '3', '0', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('40', '3', '7', '4', '40', '40', '40', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '1');
INSERT INTO `data_object_access` VALUES ('41', '3', '8', '4', '40', '40', '40', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '1');
INSERT INTO `data_object_access` VALUES ('42', '3', '1', '4', '40', '10', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('43', '3', '2', '4', '40', '0', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('44', '3', '3', '4', '40', '0', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('45', '3', '4', '4', '40', '10', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('46', '3', '5', '4', '40', '0', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('47', '3', '6', '4', '10', '0', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('48', '3', '12', '4', '10', '0', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('49', '3', '13', '4', '40', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '1');
INSERT INTO `data_object_access` VALUES ('50', '3', '9', '4', '40', '0', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('51', '3', '10', '4', '40', '0', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('52', '3', '11', '4', '0', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('53', '3', '7', '5', '40', '40', '40', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '1');
INSERT INTO `data_object_access` VALUES ('54', '3', '8', '5', '40', '40', '40', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '1');
INSERT INTO `data_object_access` VALUES ('55', '3', '1', '5', '40', '40', '40', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('56', '3', '2', '5', '40', '0', '40', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('57', '3', '3', '5', '40', '0', '40', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('58', '3', '4', '5', '40', '40', '40', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('59', '3', '5', '5', '40', '0', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('60', '3', '6', '5', '10', '0', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('61', '3', '12', '5', '10', '0', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('62', '3', '13', '5', '40', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '1');
INSERT INTO `data_object_access` VALUES ('63', '3', '9', '5', '40', '0', '40', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('64', '3', '10', '5', '40', '0', '40', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('65', '3', '11', '5', '0', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('66', '3', '7', '6', '40', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '1');
INSERT INTO `data_object_access` VALUES ('67', '3', '8', '6', '40', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '1');
INSERT INTO `data_object_access` VALUES ('68', '3', '1', '6', '40', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('69', '3', '2', '6', '0', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('70', '3', '3', '6', '0', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('71', '3', '4', '6', '40', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('72', '3', '5', '6', '40', '0', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('73', '3', '6', '6', '10', '0', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('74', '3', '12', '6', '40', '0', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('75', '3', '13', '6', '40', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '1');
INSERT INTO `data_object_access` VALUES ('76', '3', '9', '6', '40', '0', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('77', '3', '10', '6', '40', '0', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('78', '3', '11', '6', '10', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('79', '3', '7', '7', '40', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '1');
INSERT INTO `data_object_access` VALUES ('80', '3', '8', '7', '40', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '1');
INSERT INTO `data_object_access` VALUES ('81', '3', '1', '7', '40', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('82', '3', '2', '7', '0', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('83', '3', '3', '7', '40', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('84', '3', '4', '7', '40', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('85', '3', '5', '7', '40', '0', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('86', '3', '6', '7', '10', '0', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('87', '3', '12', '7', '40', '0', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('88', '3', '13', '7', '40', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '1');
INSERT INTO `data_object_access` VALUES ('89', '3', '9', '7', '40', '0', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('90', '3', '10', '7', '40', '0', '10', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('91', '3', '11', '7', '40', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('92', null, '1', '8', '40', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('93', null, '2', '8', '40', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('94', null, '3', '8', '40', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('95', null, '4', '8', '40', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('96', null, '5', '8', '0', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('97', null, '6', '8', '0', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('98', null, '12', '8', '0', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('99', null, '13', '8', '0', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '1');
INSERT INTO `data_object_access` VALUES ('100', null, '9', '8', '40', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('101', null, '10', '8', '40', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('102', null, '11', '8', '0', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('103', null, '1', '9', '40', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('104', null, '2', '9', '40', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('105', null, '3', '9', '40', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('106', null, '4', '9', '40', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('107', null, '5', '9', '0', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('108', null, '6', '9', '0', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('109', null, '12', '9', '0', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('110', null, '13', '9', '0', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '1');
INSERT INTO `data_object_access` VALUES ('111', null, '9', '9', '40', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('112', null, '10', '9', '40', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('113', null, '11', '9', '0', '0', '0', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('114', '3', '14', '1', '40', '40', '40', '2017-07-25 14:35:16', '1', '1', '2017-07-25 14:35:16', '0');
INSERT INTO `data_object_access` VALUES ('115', '3', '15', '1', '40', '40', '40', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_access` VALUES ('116', '3', '16', '1', '40', '40', '40', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_access` VALUES ('117', '3', '15', '2', '0', '0', '0', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_access` VALUES ('118', '3', '16', '2', '0', '0', '0', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_access` VALUES ('119', '3', '15', '3', '0', '0', '0', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_access` VALUES ('120', '3', '16', '3', '0', '0', '0', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_access` VALUES ('121', '3', '15', '4', '0', '0', '0', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_access` VALUES ('122', '3', '16', '4', '10', '10', '10', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_access` VALUES ('123', '3', '15', '5', '0', '0', '0', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_access` VALUES ('124', '3', '16', '5', '40', '40', '40', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_access` VALUES ('125', '3', '15', '6', '0', '0', '0', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_access` VALUES ('126', '3', '16', '6', '0', '0', '0', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_access` VALUES ('127', '3', '15', '7', '0', '0', '0', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_access` VALUES ('128', '3', '16', '7', '0', '0', '0', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_access` VALUES ('129', '3', '15', '8', '0', '0', '0', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_access` VALUES ('130', '3', '16', '8', '0', '0', '0', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_access` VALUES ('131', '3', '15', '9', '0', '0', '0', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_access` VALUES ('132', '3', '16', '9', '0', '0', '0', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_access` VALUES ('133', '3', '15', '10', '10', '10', '10', '2017-11-29 18:28:02', '1', null, null, '0');
INSERT INTO `data_object_access` VALUES ('134', '3', '16', '10', '10', '10', '10', '2017-11-29 18:28:02', '1', null, null, '0');
INSERT INTO `data_object_access` VALUES ('135', '3', '15', '11', '40', '40', '40', '2017-11-29 18:28:02', '1', null, null, '0');
INSERT INTO `data_object_access` VALUES ('136', '3', '16', '11', '40', '40', '40', '2017-11-29 18:28:02', '1', null, null, '0');

-- ----------------------------
-- Table structure for data_object_field
-- ----------------------------
DROP TABLE IF EXISTS `data_object_field`;
CREATE TABLE `data_object_field` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `field_id` bigint(20) DEFAULT NULL COMMENT '字段id',
  `data_object_id` bigint(20) DEFAULT NULL COMMENT '数据对象id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=155 DEFAULT CHARSET=utf8 COMMENT='数据对象关联字段表';

-- ----------------------------
-- Records of data_object_field
-- ----------------------------
INSERT INTO `data_object_field` VALUES ('1', '3', '1', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('2', '3', '2', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('3', '3', '3', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('4', '3', '4', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('5', '3', '5', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('6', '3', '6', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('7', '3', '7', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('8', '3', '8', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('9', '3', '9', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('10', '3', '10', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('11', '3', '11', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('12', '3', '12', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('13', '3', '13', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('14', '3', '14', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('15', '3', '15', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('16', '3', '16', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('17', '3', '17', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('18', '3', '18', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('19', '3', '19', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('20', '3', '20', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('21', '3', '21', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('22', '3', '22', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('23', '3', '23', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('24', '3', '24', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('25', '3', '25', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('26', '3', '26', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('27', '3', '27', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('28', '3', '28', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('29', '3', '29', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('30', '3', '30', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('31', '3', '31', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('32', '3', '32', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('33', '3', '33', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('34', '3', '34', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('35', '3', '35', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('36', '3', '36', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('37', '3', '37', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('38', '3', '38', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('39', '3', '39', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('40', '3', '40', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('41', '3', '41', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('42', '3', '42', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('43', '3', '43', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('44', '3', '44', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('64', '3', '46', '6', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('65', '3', '47', '6', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('66', '3', '48', '6', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('67', '3', '49', '6', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('71', '3', '45', '5', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('72', '3', '50', '5', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('73', '3', '51', '5', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('74', '3', '52', '5', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('75', '3', '53', '5', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('76', '3', '54', '5', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('77', '3', '55', '5', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('78', '3', '56', '5', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('79', '3', '57', '5', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('80', '3', '58', '5', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('81', '3', '59', '5', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('82', '3', '60', '5', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('83', '3', '61', '5', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('84', '3', '62', '5', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('85', '3', '63', '5', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('86', '3', '64', '5', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('87', '3', '65', '5', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('88', '3', '66', '5', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('89', '3', '67', '5', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('90', '3', '68', '5', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('91', '3', '69', '5', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('92', '3', '70', '5', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('93', '3', '71', '5', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('94', '3', '72', '5', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('95', '3', '73', '5', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('96', '3', '74', '5', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('102', '3', '75', '11', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('103', '3', '76', '11', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('104', '3', '77', '11', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('105', '3', '78', '11', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('106', '3', '79', '11', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('107', '3', '80', '11', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('108', '3', '81', '11', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('109', '3', '82', '9', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('110', '3', '83', '9', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('111', '3', '84', '9', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('112', '3', '85', '9', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('113', '3', '86', '9', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('114', '3', '87', '9', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('115', '3', '88', '9', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('116', '3', '89', '9', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('117', '3', '90', '9', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('124', '3', '91', '10', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('125', '3', '92', '10', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('126', '3', '93', '10', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('127', '3', '94', '10', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('128', '3', '95', '10', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('129', '3', '96', '10', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('130', '3', '97', '10', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('131', '3', '98', '10', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('132', '3', '99', '10', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('133', '3', '100', '10', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('134', '3', '101', '10', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('135', '3', '102', '10', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('136', '3', '103', '10', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('137', '3', '104', '10', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('138', '3', '105', '10', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('139', '3', '106', '10', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('140', '3', '107', '10', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('141', '3', '108', '10', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('142', '3', '109', '10', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('143', '3', '110', '10', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('144', '3', '111', '10', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('145', '3', '112', '10', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('146', '3', '113', '10', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('147', '3', '114', '10', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `data_object_field` VALUES ('148', '3', '115', '10', '1', '2017-11-02 14:55:38', null, null, '0');

-- ----------------------------
-- Table structure for data_object_init
-- ----------------------------
DROP TABLE IF EXISTS `data_object_init`;
CREATE TABLE `data_object_init` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL,
  `data_object_id` bigint(20) DEFAULT NULL COMMENT '数据对象id',
  `operation` tinyint(2) DEFAULT NULL COMMENT '操作，0：读取，1：修改，2：删除',
  `permission` tinyint(4) DEFAULT NULL COMMENT '权限值，0：无权限，10：我的，20：团队，30：部门，40：全部',
  `sequence` int(11) DEFAULT '1' COMMENT '排序，越小越靠前',
  `is_check` tinyint(2) DEFAULT NULL COMMENT '是否选中，0：否，1：是',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=151 DEFAULT CHARSET=utf8 COMMENT='数据对象初始化信息表';

-- ----------------------------
-- Records of data_object_init
-- ----------------------------
INSERT INTO `data_object_init` VALUES ('1', '3', '7', '0', '40', '1', '1', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('2', '3', '7', '1', '0', '1', '1', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('3', '3', '7', '1', '10', '2', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('4', '3', '7', '1', '20', '3', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('5', '3', '7', '1', '30', '4', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('6', '3', '7', '1', '40', '5', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('7', '3', '7', '2', '0', '1', '1', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('8', '3', '7', '2', '10', '2', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('9', '3', '7', '2', '20', '3', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('10', '3', '7', '2', '30', '4', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('11', '3', '7', '2', '40', '5', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('12', '3', '8', '0', '40', '1', '1', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('13', '3', '8', '1', '0', '1', '1', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('14', '3', '8', '1', '10', '2', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('15', '3', '8', '1', '20', '3', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('16', '3', '8', '1', '30', '4', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('17', '3', '8', '1', '40', '5', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('18', '3', '8', '2', '0', '1', '1', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('19', '3', '8', '2', '10', '2', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('20', '3', '8', '2', '20', '3', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('21', '3', '8', '2', '30', '4', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('22', '3', '8', '2', '40', '5', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('23', '3', '1', '0', '40', '1', '1', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('24', '3', '1', '1', '0', '1', '1', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('25', '3', '1', '1', '10', '2', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('26', '3', '1', '1', '20', '3', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('27', '3', '1', '1', '30', '4', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('28', '3', '1', '1', '40', '5', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('29', '3', '1', '2', '0', '1', '1', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('30', '3', '1', '2', '10', '2', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('31', '3', '1', '2', '20', '3', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('32', '3', '1', '2', '30', '4', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('33', '3', '1', '2', '40', '5', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('34', '3', '2', '0', '0', '1', '1', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('35', '3', '2', '0', '10', '2', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('36', '3', '2', '0', '20', '3', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('37', '3', '2', '0', '30', '4', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('38', '3', '2', '0', '40', '5', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('39', '3', '2', '1', '0', '1', '1', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('40', '3', '2', '1', '10', '2', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('41', '3', '2', '1', '20', '3', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('42', '3', '2', '1', '30', '4', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('43', '3', '2', '1', '40', '5', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('44', '3', '3', '0', '0', '1', '1', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('45', '3', '3', '0', '10', '2', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('46', '3', '3', '0', '20', '3', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('47', '3', '3', '0', '30', '4', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('48', '3', '3', '0', '40', '5', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('49', '3', '3', '1', '0', '1', '1', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('50', '3', '3', '1', '10', '2', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('51', '3', '3', '1', '20', '3', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('52', '3', '3', '1', '30', '4', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('53', '3', '3', '1', '40', '5', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('54', '3', '4', '0', '40', '1', '1', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('55', '3', '4', '1', '0', '1', '1', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('56', '3', '4', '1', '10', '2', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('57', '3', '4', '1', '20', '3', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('58', '3', '4', '1', '30', '4', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('59', '3', '4', '1', '40', '5', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('60', '3', '4', '2', '0', '1', '1', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('61', '3', '4', '2', '10', '2', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('62', '3', '4', '2', '20', '3', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('63', '3', '4', '2', '30', '4', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('64', '3', '4', '2', '40', '5', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('65', '3', '5', '0', '0', '1', '1', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('66', '3', '5', '0', '10', '2', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('67', '3', '5', '0', '20', '3', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('68', '3', '5', '0', '30', '4', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('69', '3', '5', '0', '40', '5', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('70', '3', '5', '1', '0', '1', '1', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('71', '3', '5', '1', '10', '2', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('72', '3', '5', '1', '20', '3', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('73', '3', '5', '1', '30', '4', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('74', '3', '5', '1', '40', '5', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('75', '3', '6', '0', '0', '1', '1', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('76', '3', '6', '0', '10', '2', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('77', '3', '6', '0', '20', '3', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('78', '3', '6', '0', '30', '4', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('79', '3', '6', '0', '40', '5', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('80', '3', '6', '1', '0', '1', '1', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('81', '3', '6', '1', '10', '2', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('82', '3', '6', '1', '20', '3', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('83', '3', '6', '1', '30', '4', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('84', '3', '6', '1', '40', '5', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('85', '3', '9', '0', '40', '5', '1', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('86', '3', '9', '1', '0', '1', '1', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('87', '3', '9', '1', '10', '2', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('88', '3', '9', '1', '20', '3', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('89', '3', '9', '1', '30', '4', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('90', '3', '9', '1', '40', '5', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('91', '3', '10', '0', '40', '5', '1', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('92', '3', '10', '1', '0', '1', '1', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('93', '3', '10', '1', '10', '2', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('94', '3', '10', '1', '20', '3', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('95', '3', '10', '1', '30', '4', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('96', '3', '10', '1', '40', '5', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('97', '3', '11', '0', '0', '1', '1', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('98', '3', '11', '0', '10', '2', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('99', '3', '11', '0', '20', '3', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('100', '3', '11', '0', '30', '4', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('101', '3', '11', '0', '40', '5', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('102', '3', '13', '0', '40', '5', '1', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('103', '3', '13', '1', '0', '1', '1', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('104', '3', '13', '1', '10', '2', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('105', '3', '13', '1', '20', '3', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('106', '3', '13', '1', '30', '4', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('107', '3', '13', '1', '40', '5', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('108', '3', '12', '0', '0', '1', '1', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('109', '3', '12', '0', '10', '2', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('110', '3', '12', '0', '20', '3', '0', '2017-11-02 14:55:38', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('111', '3', '12', '0', '30', '4', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('112', '3', '12', '0', '40', '5', '0', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('113', '3', '12', '1', '0', '1', '1', '2017-11-02 14:55:39', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('114', '3', '12', '1', '10', '2', '0', '2017-11-02 14:55:39', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('115', '3', '12', '1', '20', '3', '0', '2017-11-02 14:55:39', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('116', '3', '12', '1', '30', '4', '0', '2017-11-02 14:55:39', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('117', '3', '12', '1', '40', '5', '0', '2017-11-02 14:55:39', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('118', '3', '13', '0', '0', '1', '1', '2017-11-02 14:55:39', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('119', '3', '13', '0', '10', '2', '0', '2017-11-02 14:55:39', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('120', '3', '13', '0', '20', '3', '0', '2017-11-02 14:55:39', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('121', '3', '13', '0', '30', '4', '0', '2017-11-02 14:55:39', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('122', '3', '13', '0', '40', '5', '0', '2017-11-02 14:55:39', '1', null, null, '1');
INSERT INTO `data_object_init` VALUES ('123', '3', '14', '0', '0', '1', '1', '2017-11-15 16:22:21', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('124', '3', '14', '0', '10', '2', '0', '2017-11-15 16:22:21', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('125', '3', '14', '0', '30', '3', '0', '2017-11-15 16:22:21', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('126', '3', '14', '0', '40', '4', '0', '2017-11-15 16:22:21', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('127', '3', '15', '0', '0', '1', '1', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('128', '3', '15', '0', '10', '2', '0', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('129', '3', '15', '0', '30', '3', '0', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('130', '3', '15', '0', '40', '4', '0', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('131', '3', '15', '1', '0', '1', '1', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('132', '3', '15', '1', '10', '2', '0', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('133', '3', '15', '1', '30', '4', '0', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('134', '3', '15', '1', '40', '5', '0', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('135', '3', '15', '2', '0', '1', '1', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('136', '3', '15', '2', '10', '2', '0', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('137', '3', '15', '2', '30', '4', '0', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('138', '3', '15', '2', '40', '5', '0', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('139', '3', '16', '0', '0', '1', '1', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('140', '3', '16', '0', '10', '2', '0', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('141', '3', '16', '0', '30', '3', '0', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('142', '3', '16', '0', '40', '4', '0', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('143', '3', '16', '1', '0', '1', '1', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('144', '3', '16', '1', '10', '2', '0', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('145', '3', '16', '1', '30', '4', '0', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('146', '3', '16', '1', '40', '5', '0', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('147', '3', '16', '2', '0', '1', '1', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('148', '3', '16', '2', '10', '2', '0', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('149', '3', '16', '2', '30', '4', '0', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `data_object_init` VALUES ('150', '3', '16', '2', '40', '5', '0', '2017-11-26 14:11:15', '1', null, null, '0');

-- ----------------------------
-- Table structure for declaration
-- ----------------------------
DROP TABLE IF EXISTS `declaration`;
CREATE TABLE `declaration` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `reservation_id` bigint(20) DEFAULT NULL COMMENT '预约id',
  `number` varchar(128) DEFAULT NULL COMMENT '报单编号',
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品id',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户id',
  `pay_date` datetime DEFAULT NULL COMMENT '打款日期',
  `deal_amount` double DEFAULT NULL COMMENT '认购金额',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  `reason` varchar(256) DEFAULT NULL COMMENT '原因；驳回、取消时填写',
  `audit_status` tinyint(4) DEFAULT NULL COMMENT '审批状态，  1：审核中  2：审核通过  3：驳回修改  4： 已取消 ',
  `status` tinyint(4) DEFAULT NULL COMMENT '报单状态，  1：审核中  2：审核通过  3：驳回修改  4： 已取消  5: 已作废  6:已退款',
  `user_id` bigint(20) DEFAULT NULL COMMENT '报单者id',
  `commit_date` datetime DEFAULT NULL COMMENT '最后提交时间',
  `apply_date` datetime DEFAULT NULL COMMENT '申请时间',
  `operation_date` datetime DEFAULT NULL COMMENT '最后审核操作时间',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`),
  KEY `customer_id_index` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='报单';

-- ----------------------------
-- Records of declaration
-- ----------------------------
INSERT INTO `declaration` VALUES ('1', '3', '1', '00000001', '1', '10000', '2017-11-02 00:00:00', '300', '客户已打款！', null, '2', '2', '46', '2017-11-02 15:50:29', null, '2017-11-02 15:51:54', '2017-11-02 15:50:29', '46', '46', '2017-11-02 15:51:54', '0');

-- ----------------------------
-- Table structure for declaration_attach
-- ----------------------------
DROP TABLE IF EXISTS `declaration_attach`;
CREATE TABLE `declaration_attach` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `declaration_id` bigint(20) DEFAULT NULL COMMENT '报单id',
  `name` varchar(128) DEFAULT NULL COMMENT '附件名称',
  `url` varchar(256) DEFAULT NULL COMMENT 'url',
  `type` tinyint(4) DEFAULT NULL COMMENT '附件类型',
  `sequence` int(11) DEFAULT NULL COMMENT '排序',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `tenant_id_index` (`declaration_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='报单附件';

-- ----------------------------
-- Records of declaration_attach
-- ----------------------------
INSERT INTO `declaration_attach` VALUES ('1', '3', '1', 'a_20151211023749517.jpg', 'http://file.yundaojishu.com/a0fb34f521d94b42bd1423acfbed19f0.jpg', '3', '1', '46', '2017-11-02 15:51:08', null, null, '0');
INSERT INTO `declaration_attach` VALUES ('2', '3', '1', 'a_20151024104108412.jpg', 'http://file.yundaojishu.com/5c5d010747ee464ca36f1ae1a8063d4d.jpg', '2', '1', '46', '2017-11-02 15:51:42', null, null, '0');
INSERT INTO `declaration_attach` VALUES ('3', '3', '1', 'a_20151211023749517.jpg', 'http://file.yundaojishu.com/72327018e6534b4a8779807c31b36d7a.jpg', '1', '1', '46', '2017-11-02 15:51:42', null, null, '0');

-- ----------------------------
-- Table structure for declaration_bank_rel
-- ----------------------------
DROP TABLE IF EXISTS `declaration_bank_rel`;
CREATE TABLE `declaration_bank_rel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `declaration_id` bigint(20) DEFAULT NULL COMMENT '报单id',
  `bank_id` bigint(20) DEFAULT NULL COMMENT '银行卡id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `tenant_id_index` (`declaration_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='报单客户银行卡关系';

-- ----------------------------
-- Records of declaration_bank_rel
-- ----------------------------
INSERT INTO `declaration_bank_rel` VALUES ('1', '3', '1', '1', '46', '2017-11-02 15:51:35', null, null, '0');

-- ----------------------------
-- Table structure for declaration_compliance
-- ----------------------------
DROP TABLE IF EXISTS `declaration_compliance`;
CREATE TABLE `declaration_compliance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `declaration_id` bigint(20) DEFAULT NULL COMMENT '报单id',
  `url` varchar(256) DEFAULT NULL COMMENT 'url',
  `name` varchar(128) DEFAULT NULL COMMENT '文件名',
  `type` tinyint(2) DEFAULT NULL COMMENT '类型',
  `format_type` tinyint(4) DEFAULT NULL COMMENT '格式；1：图片，2：视频',
  `sequence` int(11) DEFAULT NULL,
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `tenant_id_index` (`declaration_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='报单合规文件';

-- ----------------------------
-- Records of declaration_compliance
-- ----------------------------

-- ----------------------------
-- Table structure for declaration_credentials_rel
-- ----------------------------
DROP TABLE IF EXISTS `declaration_credentials_rel`;
CREATE TABLE `declaration_credentials_rel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `declaration_id` bigint(20) DEFAULT NULL COMMENT '报单id',
  `credentials_id` bigint(20) DEFAULT NULL COMMENT '证件id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `tenant_id_index` (`declaration_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='报单客户证件关系表';

-- ----------------------------
-- Records of declaration_credentials_rel
-- ----------------------------
INSERT INTO `declaration_credentials_rel` VALUES ('1', '3', '1', '1', '46', '2017-11-02 15:51:08', null, null, '0');

-- ----------------------------
-- Table structure for declaration_discard
-- ----------------------------
DROP TABLE IF EXISTS `declaration_discard`;
CREATE TABLE `declaration_discard` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `declaration_id` bigint(20) NOT NULL COMMENT '报单id',
  `reason` varchar(256) DEFAULT NULL COMMENT '废弃原因',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`),
  KEY `tenant_id_index` (`declaration_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='报单废弃表';

-- ----------------------------
-- Records of declaration_discard
-- ----------------------------

-- ----------------------------
-- Table structure for declaration_refund
-- ----------------------------
DROP TABLE IF EXISTS `declaration_refund`;
CREATE TABLE `declaration_refund` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `declaration_id` bigint(20) DEFAULT NULL COMMENT '报单ID',
  `reason` varchar(256) DEFAULT NULL COMMENT '退款原因',
  `status` tinyint(2) DEFAULT NULL COMMENT '1、待审批 2、已通过 3、已驳回',
  `operation_date` datetime DEFAULT NULL COMMENT '操作时间',
  `user_id` bigint(20) DEFAULT NULL COMMENT '流程发起人',
  `audit_date` datetime DEFAULT NULL COMMENT '审批时间',
  `apply_date` datetime DEFAULT NULL COMMENT '申请时间',
  `audit_reason` varchar(256) DEFAULT NULL COMMENT '审批原因',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `declaration_id_index` (`declaration_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='报单退款表';

-- ----------------------------
-- Records of declaration_refund
-- ----------------------------

-- ----------------------------
-- Table structure for declaration_video
-- ----------------------------
DROP TABLE IF EXISTS `declaration_video`;
CREATE TABLE `declaration_video` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `declaration_id` bigint(20) DEFAULT NULL COMMENT '报单id',
  `video_id` bigint(20) DEFAULT NULL COMMENT '视频id',
  `type` tinyint(3) DEFAULT NULL COMMENT '视频类型(1:合规双录)',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='报单视频';

-- ----------------------------
-- Records of declaration_video
-- ----------------------------

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编码',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父id',
  `name` varchar(32) DEFAULT NULL COMMENT '名字',
  `code` varchar(64) DEFAULT NULL COMMENT '编码（最小八位数，最大支持八层，从00000001开始）',
  `description` varchar(512) DEFAULT NULL COMMENT '描述',
  `is_enabled` tinyint(2) DEFAULT '1' COMMENT '是否启用，0：否，1：是',
  `sequence` int(11) DEFAULT '1' COMMENT '排序，越小越靠前',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `i_tenant_id` (`tenant_id`),
  KEY `i_parent_id` (`parent_id`),
  KEY `i_name` (`name`),
  KEY `i_create_user_id` (`create_user_id`),
  KEY `i_update_user_id` (`update_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '3', null, '0', '销售部', '10000000', null, '1', '1', '46', '2017-11-02 15:45:59', null, null, '0');
INSERT INTO `department` VALUES ('2', '3', null, '0', '产品部', '10000001', null, '1', '1', '46', '2017-11-02 15:46:05', null, null, '0');

-- ----------------------------
-- Table structure for dictionary
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父id',
  `label` varchar(32) DEFAULT NULL COMMENT '文本',
  `value` varchar(32) DEFAULT NULL COMMENT '值',
  `sequence` int(11) DEFAULT '1' COMMENT '排序，越小越靠前',
  `is_enabled` tinyint(2) DEFAULT '1' COMMENT '是否启用，0：否，1：是',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100449 DEFAULT CHARSET=utf8 COMMENT='数据字典';

-- ----------------------------
-- Records of dictionary
-- ----------------------------
INSERT INTO `dictionary` VALUES ('54317', '3', '0', '中国', 'dic_area', '54317', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54318', '3', '57616', '北京市', '110100', '54318', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54319', '3', '54318', '东城区', '110101', '54319', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54320', '3', '54318', '西城区', '110102', '54320', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54321', '3', '54318', '崇文区', '110103', '54321', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54322', '3', '54318', '宣武区', '110104', '54322', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54323', '3', '54318', '朝阳区', '110105', '54323', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54324', '3', '54318', '丰台区', '110106', '54324', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54325', '3', '54318', '石景山区', '110107', '54325', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54326', '3', '54318', '海淀区', '110108', '54326', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54327', '3', '54318', '门头沟区', '110109', '54327', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54328', '3', '54318', '房山区', '110111', '54328', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54329', '3', '54318', '通州区', '110112', '54329', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54330', '3', '54318', '顺义区', '110113', '54330', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54331', '3', '54318', '昌平区', '110114', '54331', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54332', '3', '54318', '大兴区', '110115', '54332', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54333', '3', '54318', '怀柔区', '110116', '54333', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54334', '3', '54318', '平谷区', '110117', '54334', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54335', '3', '54318', '密云县', '110228', '54335', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54336', '3', '54318', '延庆县', '110229', '54336', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54337', '3', '57617', '天津市', '120100', '54337', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54338', '3', '54337', '和平区', '120101', '54338', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54339', '3', '54337', '河东区', '120102', '54339', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54340', '3', '54337', '河西区', '120103', '54340', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54341', '3', '54337', '南开区', '120104', '54341', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54342', '3', '54337', '河北区', '120105', '54342', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54343', '3', '54337', '红桥区', '120106', '54343', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54344', '3', '54337', '塘沽区', '120107', '54344', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54345', '3', '54337', '汉沽区', '120108', '54345', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54346', '3', '54337', '大港区', '120109', '54346', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54347', '3', '54337', '东丽区', '120110', '54347', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54348', '3', '54337', '西青区', '120111', '54348', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54349', '3', '54337', '津南区', '120112', '54349', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54350', '3', '54337', '北辰区', '120113', '54350', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54351', '3', '54337', '武清区', '120114', '54351', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54352', '3', '54337', '宝坻区', '120115', '54352', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54353', '3', '54337', '宁河县', '120221', '54353', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54354', '3', '54337', '静海县', '120223', '54354', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54355', '3', '54337', '蓟县', '120225', '54355', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54356', '3', '54317', '河北省', '130000', '54356', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54357', '3', '54356', '石家庄市', '130100', '54357', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54358', '3', '54357', '长安区', '130102', '54358', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54359', '3', '54357', '桥东区', '130103', '54359', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54360', '3', '54357', '桥西区', '130104', '54360', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54361', '3', '54357', '新华区', '130105', '54361', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54362', '3', '54357', '井陉矿区', '130107', '54362', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54363', '3', '54357', '裕华区', '130108', '54363', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54364', '3', '54357', '井陉县', '130121', '54364', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54365', '3', '54357', '正定县', '130123', '54365', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54366', '3', '54357', '栾城县', '130124', '54366', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54367', '3', '54357', '行唐县', '130125', '54367', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54368', '3', '54357', '灵寿县', '130126', '54368', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54369', '3', '54357', '高邑县', '130127', '54369', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54370', '3', '54357', '深泽县', '130128', '54370', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54371', '3', '54357', '赞皇县', '130129', '54371', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54372', '3', '54357', '无极县', '130130', '54372', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54373', '3', '54357', '平山县', '130131', '54373', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54374', '3', '54357', '元氏县', '130132', '54374', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54375', '3', '54357', '赵县', '130133', '54375', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54376', '3', '54357', '辛集市', '130181', '54376', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54377', '3', '54357', '藁城市', '130182', '54377', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54378', '3', '54357', '晋州市', '130183', '54378', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54379', '3', '54357', '新乐市', '130184', '54379', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54380', '3', '54357', '鹿泉市', '130185', '54380', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54381', '3', '54356', '唐山市', '130200', '54381', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54382', '3', '54381', '路南区', '130202', '54382', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54383', '3', '54381', '路北区', '130203', '54383', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54384', '3', '54381', '古冶区', '130204', '54384', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54385', '3', '54381', '开平区', '130205', '54385', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54386', '3', '54381', '丰南区', '130207', '54386', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54387', '3', '54381', '丰润区', '130208', '54387', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54388', '3', '54381', '滦县', '130223', '54388', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54389', '3', '54381', '滦南县', '130224', '54389', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54390', '3', '54381', '乐亭县', '130225', '54390', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54391', '3', '54381', '迁西县', '130227', '54391', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54392', '3', '54381', '玉田县', '130229', '54392', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54393', '3', '54381', '唐海县', '130230', '54393', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54394', '3', '54381', '遵化市', '130281', '54394', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54395', '3', '54381', '迁安市', '130283', '54395', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54396', '3', '54356', '秦皇岛市', '130300', '54396', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54397', '3', '54396', '海港区', '130302', '54397', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54398', '3', '54396', '山海关区', '130303', '54398', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54399', '3', '54396', '北戴河区', '130304', '54399', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54400', '3', '54396', '青龙满族自治县', '130321', '54400', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54401', '3', '54396', '昌黎县', '130322', '54401', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54402', '3', '54396', '抚宁县', '130323', '54402', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54403', '3', '54396', '卢龙县', '130324', '54403', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54404', '3', '54356', '邯郸市', '130400', '54404', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54405', '3', '54404', '邯山区', '130402', '54405', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54406', '3', '54404', '丛台区', '130403', '54406', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54407', '3', '54404', '复兴区', '130404', '54407', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54408', '3', '54404', '峰峰矿区', '130406', '54408', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54409', '3', '54404', '邯郸县', '130421', '54409', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54410', '3', '54404', '临漳县', '130423', '54410', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54411', '3', '54404', '成安县', '130424', '54411', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54412', '3', '54404', '大名县', '130425', '54412', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54413', '3', '54404', '涉县', '130426', '54413', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54414', '3', '54404', '磁县', '130427', '54414', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54415', '3', '54404', '肥乡县', '130428', '54415', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54416', '3', '54404', '永年县', '130429', '54416', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54417', '3', '54404', '邱县', '130430', '54417', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54418', '3', '54404', '鸡泽县', '130431', '54418', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54419', '3', '54404', '广平县', '130432', '54419', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54420', '3', '54404', '馆陶县', '130433', '54420', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54421', '3', '54404', '魏县', '130434', '54421', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54422', '3', '54404', '曲周县', '130435', '54422', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54423', '3', '54404', '武安市', '130481', '54423', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54424', '3', '54356', '邢台市', '130500', '54424', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54425', '3', '54424', '桥东区', '130502', '54425', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54426', '3', '54424', '桥西区', '130503', '54426', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54427', '3', '54424', '邢台县', '130521', '54427', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54428', '3', '54424', '临城县', '130522', '54428', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54429', '3', '54424', '内丘县', '130523', '54429', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54430', '3', '54424', '柏乡县', '130524', '54430', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54431', '3', '54424', '隆尧县', '130525', '54431', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54432', '3', '54424', '任县', '130526', '54432', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54433', '3', '54424', '南和县', '130527', '54433', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54434', '3', '54424', '宁晋县', '130528', '54434', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54435', '3', '54424', '巨鹿县', '130529', '54435', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54436', '3', '54424', '新河县', '130530', '54436', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54437', '3', '54424', '广宗县', '130531', '54437', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54438', '3', '54424', '平乡县', '130532', '54438', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54439', '3', '54424', '威县', '130533', '54439', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54440', '3', '54424', '清河县', '130534', '54440', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54441', '3', '54424', '临西县', '130535', '54441', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54442', '3', '54424', '南宫市', '130581', '54442', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54443', '3', '54424', '沙河市', '130582', '54443', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54444', '3', '54356', '保定市', '130600', '54444', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54445', '3', '54444', '新市区', '130602', '54445', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54446', '3', '54444', '北市区', '130603', '54446', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54447', '3', '54444', '南市区', '130604', '54447', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54448', '3', '54444', '满城县', '130621', '54448', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54449', '3', '54444', '清苑县', '130622', '54449', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54450', '3', '54444', '涞水县', '130623', '54450', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54451', '3', '54444', '阜平县', '130624', '54451', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54452', '3', '54444', '徐水县', '130625', '54452', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54453', '3', '54444', '定兴县', '130626', '54453', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54454', '3', '54444', '唐县', '130627', '54454', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54455', '3', '54444', '高阳县', '130628', '54455', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54456', '3', '54444', '容城县', '130629', '54456', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54457', '3', '54444', '涞源县', '130630', '54457', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54458', '3', '54444', '望都县', '130631', '54458', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54459', '3', '54444', '安新县', '130632', '54459', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54460', '3', '54444', '易县', '130633', '54460', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54461', '3', '54444', '曲阳县', '130634', '54461', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54462', '3', '54444', '蠡县', '130635', '54462', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54463', '3', '54444', '顺平县', '130636', '54463', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54464', '3', '54444', '博野县', '130637', '54464', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54465', '3', '54444', '雄县', '130638', '54465', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54466', '3', '54444', '涿州市', '130681', '54466', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54467', '3', '54444', '定州市', '130682', '54467', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54468', '3', '54444', '安国市', '130683', '54468', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54469', '3', '54444', '高碑店市', '130684', '54469', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54470', '3', '54356', '张家口市', '130700', '54470', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54471', '3', '54470', '桥东区', '130702', '54471', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54472', '3', '54470', '桥西区', '130703', '54472', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54473', '3', '54470', '宣化区', '130705', '54473', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54474', '3', '54470', '下花园区', '130706', '54474', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54475', '3', '54470', '宣化县', '130721', '54475', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54476', '3', '54470', '张北县', '130722', '54476', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54477', '3', '54470', '康保县', '130723', '54477', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54478', '3', '54470', '沽源县', '130724', '54478', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54479', '3', '54470', '尚义县', '130725', '54479', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54480', '3', '54470', '蔚县', '130726', '54480', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54481', '3', '54470', '阳原县', '130727', '54481', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54482', '3', '54470', '怀安县', '130728', '54482', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54483', '3', '54470', '万全县', '130729', '54483', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54484', '3', '54470', '怀来县', '130730', '54484', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54485', '3', '54470', '涿鹿县', '130731', '54485', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54486', '3', '54470', '赤城县', '130732', '54486', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54487', '3', '54470', '崇礼县', '130733', '54487', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54488', '3', '54356', '承德市', '130800', '54488', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54489', '3', '54488', '双桥区', '130802', '54489', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54490', '3', '54488', '双滦区', '130803', '54490', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54491', '3', '54488', '鹰手营子矿区', '130804', '54491', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54492', '3', '54488', '承德县', '130821', '54492', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54493', '3', '54488', '兴隆县', '130822', '54493', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54494', '3', '54488', '平泉县', '130823', '54494', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54495', '3', '54488', '滦平县', '130824', '54495', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54496', '3', '54488', '隆化县', '130825', '54496', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54497', '3', '54488', '丰宁满族自治县', '130826', '54497', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54498', '3', '54488', '宽城满族自治县', '130827', '54498', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54499', '3', '54488', '围场满族蒙古族自治县', '130828', '54499', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54500', '3', '54356', '沧州市', '130900', '54500', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54501', '3', '54500', '新华区', '130902', '54501', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54502', '3', '54500', '运河区', '130903', '54502', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54503', '3', '54500', '沧县', '130921', '54503', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54504', '3', '54500', '青县', '130922', '54504', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54505', '3', '54500', '东光县', '130923', '54505', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54506', '3', '54500', '海兴县', '130924', '54506', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54507', '3', '54500', '盐山县', '130925', '54507', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54508', '3', '54500', '肃宁县', '130926', '54508', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54509', '3', '54500', '南皮县', '130927', '54509', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54510', '3', '54500', '吴桥县', '130928', '54510', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54511', '3', '54500', '献县', '130929', '54511', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54512', '3', '54500', '孟村回族自治县', '130930', '54512', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54513', '3', '54500', '泊头市', '130981', '54513', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54514', '3', '54500', '任丘市', '130982', '54514', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54515', '3', '54500', '黄骅市', '130983', '54515', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54516', '3', '54500', '河间市', '130984', '54516', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54517', '3', '54356', '廊坊市', '131000', '54517', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54518', '3', '54517', '安次区', '131002', '54518', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54519', '3', '54517', '广阳区', '131003', '54519', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54520', '3', '54517', '固安县', '131022', '54520', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54521', '3', '54517', '永清县', '131023', '54521', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54522', '3', '54517', '香河县', '131024', '54522', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54523', '3', '54517', '大城县', '131025', '54523', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54524', '3', '54517', '文安县', '131026', '54524', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54525', '3', '54517', '大厂回族自治县', '131028', '54525', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54526', '3', '54517', '霸州市', '131081', '54526', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54527', '3', '54517', '三河市', '131082', '54527', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54528', '3', '54356', '衡水市', '131100', '54528', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54529', '3', '54528', '桃城区', '131102', '54529', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54530', '3', '54528', '枣强县', '131121', '54530', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54531', '3', '54528', '武邑县', '131122', '54531', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54532', '3', '54528', '武强县', '131123', '54532', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54533', '3', '54528', '饶阳县', '131124', '54533', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54534', '3', '54528', '安平县', '131125', '54534', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54535', '3', '54528', '故城县', '131126', '54535', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54536', '3', '54528', '景县', '131127', '54536', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54537', '3', '54528', '阜城县', '131128', '54537', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54538', '3', '54528', '冀州市', '131181', '54538', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54539', '3', '54528', '深州市', '131182', '54539', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54540', '3', '54317', '山西省', '140000', '54540', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54541', '3', '54540', '太原市', '140100', '54541', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54542', '3', '54541', '小店区', '140105', '54542', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54543', '3', '54541', '迎泽区', '140106', '54543', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54544', '3', '54541', '杏花岭区', '140107', '54544', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54545', '3', '54541', '尖草坪区', '140108', '54545', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54546', '3', '54541', '万柏林区', '140109', '54546', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54547', '3', '54541', '晋源区', '140110', '54547', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54548', '3', '54541', '清徐县', '140121', '54548', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54549', '3', '54541', '阳曲县', '140122', '54549', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54550', '3', '54541', '娄烦县', '140123', '54550', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54551', '3', '54541', '古交市', '140181', '54551', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54552', '3', '54540', '大同市', '140200', '54552', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54553', '3', '54552', '城区', '140202', '54553', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54554', '3', '54552', '矿区', '140203', '54554', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54555', '3', '54552', '南郊区', '140211', '54555', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54556', '3', '54552', '新荣区', '140212', '54556', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54557', '3', '54552', '阳高县', '140221', '54557', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54558', '3', '54552', '天镇县', '140222', '54558', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54559', '3', '54552', '广灵县', '140223', '54559', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54560', '3', '54552', '灵丘县', '140224', '54560', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54561', '3', '54552', '浑源县', '140225', '54561', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54562', '3', '54552', '左云县', '140226', '54562', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54563', '3', '54552', '大同县', '140227', '54563', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54564', '3', '54540', '阳泉市', '140300', '54564', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54565', '3', '54564', '城区', '140302', '54565', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54566', '3', '54564', '矿区', '140303', '54566', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54567', '3', '54564', '郊区', '140311', '54567', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54568', '3', '54564', '平定县', '140321', '54568', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54569', '3', '54564', '盂县', '140322', '54569', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54570', '3', '54540', '长治市', '140400', '54570', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54571', '3', '54570', '城区', '140402', '54571', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54572', '3', '54570', '郊区', '140411', '54572', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54573', '3', '54570', '长治县', '140421', '54573', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54574', '3', '54570', '襄垣县', '140423', '54574', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54575', '3', '54570', '屯留县', '140424', '54575', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54576', '3', '54570', '平顺县', '140425', '54576', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54577', '3', '54570', '黎城县', '140426', '54577', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54578', '3', '54570', '壶关县', '140427', '54578', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54579', '3', '54570', '长子县', '140428', '54579', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54580', '3', '54570', '武乡县', '140429', '54580', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54581', '3', '54570', '沁县', '140430', '54581', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54582', '3', '54570', '沁源县', '140431', '54582', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54583', '3', '54570', '潞城市', '140481', '54583', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54584', '3', '54540', '晋城市', '140500', '54584', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54585', '3', '54584', '城区', '140502', '54585', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54586', '3', '54584', '沁水县', '140521', '54586', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54587', '3', '54584', '阳城县', '140522', '54587', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54588', '3', '54584', '陵川县', '140524', '54588', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54589', '3', '54584', '泽州县', '140525', '54589', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54590', '3', '54584', '高平市', '140581', '54590', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54591', '3', '54540', '朔州市', '140600', '54591', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54592', '3', '54591', '朔城区', '140602', '54592', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54593', '3', '54591', '平鲁区', '140603', '54593', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54594', '3', '54591', '山阴县', '140621', '54594', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54595', '3', '54591', '应县', '140622', '54595', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54596', '3', '54591', '右玉县', '140623', '54596', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54597', '3', '54591', '怀仁县', '140624', '54597', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54598', '3', '54540', '晋中市', '140700', '54598', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54599', '3', '54598', '榆次区', '140702', '54599', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54600', '3', '54598', '榆社县', '140721', '54600', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54601', '3', '54598', '左权县', '140722', '54601', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54602', '3', '54598', '和顺县', '140723', '54602', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54603', '3', '54598', '昔阳县', '140724', '54603', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54604', '3', '54598', '寿阳县', '140725', '54604', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54605', '3', '54598', '太谷县', '140726', '54605', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54606', '3', '54598', '祁县', '140727', '54606', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54607', '3', '54598', '平遥县', '140728', '54607', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54608', '3', '54598', '灵石县', '140729', '54608', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54609', '3', '54598', '介休市', '140781', '54609', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54610', '3', '54540', '运城市', '140800', '54610', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54611', '3', '54610', '盐湖区', '140802', '54611', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54612', '3', '54610', '临猗县', '140821', '54612', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54613', '3', '54610', '万荣县', '140822', '54613', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54614', '3', '54610', '闻喜县', '140823', '54614', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54615', '3', '54610', '稷山县', '140824', '54615', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54616', '3', '54610', '新绛县', '140825', '54616', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54617', '3', '54610', '绛县', '140826', '54617', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54618', '3', '54610', '垣曲县', '140827', '54618', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54619', '3', '54610', '夏县', '140828', '54619', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54620', '3', '54610', '平陆县', '140829', '54620', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54621', '3', '54610', '芮城县', '140830', '54621', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54622', '3', '54610', '永济市', '140881', '54622', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54623', '3', '54610', '河津市', '140882', '54623', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54624', '3', '54540', '忻州市', '140900', '54624', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54625', '3', '54624', '忻府区', '140902', '54625', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54626', '3', '54624', '定襄县', '140921', '54626', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54627', '3', '54624', '五台县', '140922', '54627', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54628', '3', '54624', '代县', '140923', '54628', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54629', '3', '54624', '繁峙县', '140924', '54629', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54630', '3', '54624', '宁武县', '140925', '54630', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54631', '3', '54624', '静乐县', '140926', '54631', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54632', '3', '54624', '神池县', '140927', '54632', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54633', '3', '54624', '五寨县', '140928', '54633', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54634', '3', '54624', '岢岚县', '140929', '54634', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54635', '3', '54624', '河曲县', '140930', '54635', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54636', '3', '54624', '保德县', '140931', '54636', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54637', '3', '54624', '偏关县', '140932', '54637', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54638', '3', '54624', '原平市', '140981', '54638', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54639', '3', '54540', '临汾市', '141000', '54639', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54640', '3', '54639', '尧都区', '141002', '54640', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54641', '3', '54639', '曲沃县', '141021', '54641', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54642', '3', '54639', '翼城县', '141022', '54642', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54643', '3', '54639', '襄汾县', '141023', '54643', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54644', '3', '54639', '洪洞县', '141024', '54644', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54645', '3', '54639', '古县', '141025', '54645', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54646', '3', '54639', '安泽县', '141026', '54646', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54647', '3', '54639', '浮山县', '141027', '54647', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54648', '3', '54639', '吉县', '141028', '54648', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54649', '3', '54639', '乡宁县', '141029', '54649', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54650', '3', '54639', '大宁县', '141030', '54650', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54651', '3', '54639', '隰县', '141031', '54651', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54652', '3', '54639', '永和县', '141032', '54652', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54653', '3', '54639', '蒲县', '141033', '54653', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54654', '3', '54639', '汾西县', '141034', '54654', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54655', '3', '54639', '侯马市', '141081', '54655', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54656', '3', '54639', '霍州市', '141082', '54656', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54657', '3', '54540', '吕梁市', '141100', '54657', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54658', '3', '54657', '离石区', '141102', '54658', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54659', '3', '54657', '文水县', '141121', '54659', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54660', '3', '54657', '交城县', '141122', '54660', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54661', '3', '54657', '兴县', '141123', '54661', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54662', '3', '54657', '临县', '141124', '54662', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54663', '3', '54657', '柳林县', '141125', '54663', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54664', '3', '54657', '石楼县', '141126', '54664', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54665', '3', '54657', '岚县', '141127', '54665', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54666', '3', '54657', '方山县', '141128', '54666', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54667', '3', '54657', '中阳县', '141129', '54667', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54668', '3', '54657', '交口县', '141130', '54668', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54669', '3', '54657', '孝义市', '141181', '54669', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54670', '3', '54657', '汾阳市', '141182', '54670', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54671', '3', '54317', '内蒙古自治区', '150000', '54671', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54672', '3', '54671', '呼和浩特市', '150100', '54672', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54673', '3', '54672', '新城区', '150102', '54673', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54674', '3', '54672', '回民区', '150103', '54674', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54675', '3', '54672', '玉泉区', '150104', '54675', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54676', '3', '54672', '赛罕区', '150105', '54676', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54677', '3', '54672', '土默特左旗', '150121', '54677', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54678', '3', '54672', '托克托县', '150122', '54678', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54679', '3', '54672', '和林格尔县', '150123', '54679', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54680', '3', '54672', '清水河县', '150124', '54680', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54681', '3', '54672', '武川县', '150125', '54681', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54682', '3', '54671', '包头市', '150200', '54682', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54683', '3', '54682', '东河区', '150202', '54683', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54684', '3', '54682', '昆都仑区', '150203', '54684', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54685', '3', '54682', '青山区', '150204', '54685', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54686', '3', '54682', '石拐区', '150205', '54686', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54687', '3', '54682', '白云鄂博矿区', '150206', '54687', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54688', '3', '54682', '九原区', '150207', '54688', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54689', '3', '54682', '土默特右旗', '150221', '54689', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54690', '3', '54682', '固阳县', '150222', '54690', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54691', '3', '54682', '达尔罕茂明安联合旗', '150223', '54691', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54692', '3', '54671', '乌海市', '150300', '54692', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54693', '3', '54692', '海勃湾区', '150302', '54693', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54694', '3', '54692', '海南区', '150303', '54694', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54695', '3', '54692', '乌达区', '150304', '54695', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54696', '3', '54671', '赤峰市', '150400', '54696', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54697', '3', '54696', '红山区', '150402', '54697', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54698', '3', '54696', '元宝山区', '150403', '54698', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54699', '3', '54696', '松山区', '150404', '54699', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54700', '3', '54696', '阿鲁科尔沁旗', '150421', '54700', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54701', '3', '54696', '巴林左旗', '150422', '54701', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54702', '3', '54696', '巴林右旗', '150423', '54702', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54703', '3', '54696', '林西县', '150424', '54703', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54704', '3', '54696', '克什克腾旗', '150425', '54704', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54705', '3', '54696', '翁牛特旗', '150426', '54705', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54706', '3', '54696', '喀喇沁旗', '150428', '54706', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54707', '3', '54696', '宁城县', '150429', '54707', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54708', '3', '54696', '敖汉旗', '150430', '54708', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54709', '3', '54671', '通辽市', '150500', '54709', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54710', '3', '54709', '科尔沁区', '150502', '54710', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54711', '3', '54709', '科尔沁左翼中旗', '150521', '54711', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54712', '3', '54709', '科尔沁左翼后旗', '150522', '54712', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54713', '3', '54709', '开鲁县', '150523', '54713', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54714', '3', '54709', '库伦旗', '150524', '54714', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54715', '3', '54709', '奈曼旗', '150525', '54715', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54716', '3', '54709', '扎鲁特旗', '150526', '54716', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54717', '3', '54709', '霍林郭勒市', '150581', '54717', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54718', '3', '54671', '鄂尔多斯市', '150600', '54718', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54719', '3', '54718', '东胜区', '150602', '54719', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54720', '3', '54718', '达拉特旗', '150621', '54720', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54721', '3', '54718', '准格尔旗', '150622', '54721', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54722', '3', '54718', '鄂托克前旗', '150623', '54722', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54723', '3', '54718', '鄂托克旗', '150624', '54723', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54724', '3', '54718', '杭锦旗', '150625', '54724', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54725', '3', '54718', '乌审旗', '150626', '54725', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54726', '3', '54718', '伊金霍洛旗', '150627', '54726', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54727', '3', '54671', '呼伦贝尔市', '150700', '54727', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54728', '3', '54727', '海拉尔区', '150702', '54728', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54729', '3', '54727', '阿荣旗', '150721', '54729', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54730', '3', '54727', '莫力达瓦达斡尔族自治旗', '150722', '54730', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54731', '3', '54727', '鄂伦春自治旗', '150723', '54731', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54732', '3', '54727', '鄂温克族自治旗', '150724', '54732', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54733', '3', '54727', '陈巴尔虎旗', '150725', '54733', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54734', '3', '54727', '新巴尔虎左旗', '150726', '54734', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54735', '3', '54727', '新巴尔虎右旗', '150727', '54735', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54736', '3', '54727', '满洲里市', '150781', '54736', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54737', '3', '54727', '牙克石市', '150782', '54737', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54738', '3', '54727', '扎兰屯市', '150783', '54738', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54739', '3', '54727', '额尔古纳市', '150784', '54739', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54740', '3', '54727', '根河市', '150785', '54740', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54741', '3', '54671', '巴彦淖尔市', '150800', '54741', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54742', '3', '54741', '临河区', '150802', '54742', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54743', '3', '54741', '五原县', '150821', '54743', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54744', '3', '54741', '磴口县', '150822', '54744', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54745', '3', '54741', '乌拉特前旗', '150823', '54745', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54746', '3', '54741', '乌拉特中旗', '150824', '54746', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54747', '3', '54741', '乌拉特后旗', '150825', '54747', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54748', '3', '54741', '杭锦后旗', '150826', '54748', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54749', '3', '54671', '乌兰察布市', '150900', '54749', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54750', '3', '54749', '集宁区', '150902', '54750', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54751', '3', '54749', '卓资县', '150921', '54751', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54752', '3', '54749', '化德县', '150922', '54752', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54753', '3', '54749', '商都县', '150923', '54753', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54754', '3', '54749', '兴和县', '150924', '54754', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54755', '3', '54749', '凉城县', '150925', '54755', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54756', '3', '54749', '察哈尔右翼前旗', '150926', '54756', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54757', '3', '54749', '察哈尔右翼中旗', '150927', '54757', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54758', '3', '54749', '察哈尔右翼后旗', '150928', '54758', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54759', '3', '54749', '四子王旗', '150929', '54759', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54760', '3', '54749', '丰镇市', '150981', '54760', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54761', '3', '54671', '兴安盟', '152200', '54761', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54762', '3', '54761', '乌兰浩特市', '152201', '54762', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54763', '3', '54761', '阿尔山市', '152202', '54763', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54764', '3', '54761', '科尔沁右翼前旗', '152221', '54764', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54765', '3', '54761', '科尔沁右翼中旗', '152222', '54765', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54766', '3', '54761', '扎赉特旗', '152223', '54766', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54767', '3', '54761', '突泉县', '152224', '54767', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54768', '3', '54671', '锡林郭勒盟', '152500', '54768', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54769', '3', '54768', '二连浩特市', '152501', '54769', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54770', '3', '54768', '锡林浩特市', '152502', '54770', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54771', '3', '54768', '阿巴嘎旗', '152522', '54771', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54772', '3', '54768', '苏尼特左旗', '152523', '54772', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54773', '3', '54768', '苏尼特右旗', '152524', '54773', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54774', '3', '54768', '东乌珠穆沁旗', '152525', '54774', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54775', '3', '54768', '西乌珠穆沁旗', '152526', '54775', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54776', '3', '54768', '太仆寺旗', '152527', '54776', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54777', '3', '54768', '镶黄旗', '152528', '54777', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54778', '3', '54768', '正镶白旗', '152529', '54778', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54779', '3', '54768', '正蓝旗', '152530', '54779', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54780', '3', '54768', '多伦县', '152531', '54780', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54781', '3', '54671', '阿拉善盟', '152900', '54781', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54782', '3', '54781', '阿拉善左旗', '152921', '54782', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54783', '3', '54781', '阿拉善右旗', '152922', '54783', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54784', '3', '54781', '额济纳旗', '152923', '54784', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54785', '3', '54317', '辽宁省', '210000', '54785', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54786', '3', '54785', '沈阳市', '210100', '54786', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54787', '3', '54786', '和平区', '210102', '54787', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54788', '3', '54786', '沈河区', '210103', '54788', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54789', '3', '54786', '大东区', '210104', '54789', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54790', '3', '54786', '皇姑区', '210105', '54790', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54791', '3', '54786', '铁西区', '210106', '54791', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54792', '3', '54786', '苏家屯区', '210111', '54792', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54793', '3', '54786', '东陵区', '210112', '54793', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54794', '3', '54786', '沈北新区', '210113', '54794', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54795', '3', '54786', '于洪区', '210114', '54795', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54796', '3', '54786', '辽中县', '210122', '54796', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54797', '3', '54786', '康平县', '210123', '54797', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54798', '3', '54786', '法库县', '210124', '54798', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54799', '3', '54786', '新民市', '210181', '54799', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54800', '3', '54785', '大连市', '210200', '54800', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54801', '3', '54800', '中山区', '210202', '54801', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54802', '3', '54800', '西岗区', '210203', '54802', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54803', '3', '54800', '沙河口区', '210204', '54803', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54804', '3', '54800', '甘井子区', '210211', '54804', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54805', '3', '54800', '旅顺口区', '210212', '54805', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54806', '3', '54800', '金州区', '210213', '54806', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54807', '3', '54800', '长海县', '210224', '54807', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54808', '3', '54800', '瓦房店市', '210281', '54808', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54809', '3', '54800', '普兰店市', '210282', '54809', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54810', '3', '54800', '庄河市', '210283', '54810', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54811', '3', '54785', '鞍山市', '210300', '54811', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54812', '3', '54811', '铁东区', '210302', '54812', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54813', '3', '54811', '铁西区', '210303', '54813', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54814', '3', '54811', '立山区', '210304', '54814', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54815', '3', '54811', '千山区', '210311', '54815', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54816', '3', '54811', '台安县', '210321', '54816', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54817', '3', '54811', '岫岩满族自治县', '210323', '54817', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54818', '3', '54811', '海城市', '210381', '54818', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54819', '3', '54785', '抚顺市', '210400', '54819', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54820', '3', '54819', '新抚区', '210402', '54820', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54821', '3', '54819', '东洲区', '210403', '54821', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54822', '3', '54819', '望花区', '210404', '54822', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54823', '3', '54819', '顺城区', '210411', '54823', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54824', '3', '54819', '抚顺县', '210421', '54824', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54825', '3', '54819', '新宾满族自治县', '210422', '54825', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54826', '3', '54819', '清原满族自治县', '210423', '54826', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54827', '3', '54785', '本溪市', '210500', '54827', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54828', '3', '54827', '平山区', '210502', '54828', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54829', '3', '54827', '溪湖区', '210503', '54829', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54830', '3', '54827', '明山区', '210504', '54830', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54831', '3', '54827', '南芬区', '210505', '54831', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54832', '3', '54827', '本溪满族自治县', '210521', '54832', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54833', '3', '54827', '桓仁满族自治县', '210522', '54833', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54834', '3', '54785', '丹东市', '210600', '54834', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54835', '3', '54834', '元宝区', '210602', '54835', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54836', '3', '54834', '振兴区', '210603', '54836', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54837', '3', '54834', '振安区', '210604', '54837', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54838', '3', '54834', '宽甸满族自治县', '210624', '54838', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54839', '3', '54834', '东港市', '210681', '54839', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54840', '3', '54834', '凤城市', '210682', '54840', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54841', '3', '54785', '锦州市', '210700', '54841', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54842', '3', '54841', '古塔区', '210702', '54842', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54843', '3', '54841', '凌河区', '210703', '54843', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54844', '3', '54841', '太和区', '210711', '54844', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54845', '3', '54841', '黑山县', '210726', '54845', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54846', '3', '54841', '义县', '210727', '54846', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54847', '3', '54841', '凌海市', '210781', '54847', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54848', '3', '54841', '北镇市', '210782', '54848', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54849', '3', '54785', '营口市', '210800', '54849', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54850', '3', '54849', '站前区', '210802', '54850', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54851', '3', '54849', '西市区', '210803', '54851', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54852', '3', '54849', '鲅鱼圈区', '210804', '54852', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54853', '3', '54849', '老边区', '210811', '54853', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54854', '3', '54849', '盖州市', '210881', '54854', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54855', '3', '54849', '大石桥市', '210882', '54855', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54856', '3', '54785', '阜新市', '210900', '54856', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54857', '3', '54856', '海州区', '210902', '54857', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54858', '3', '54856', '新邱区', '210903', '54858', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54859', '3', '54856', '太平区', '210904', '54859', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54860', '3', '54856', '清河门区', '210905', '54860', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54861', '3', '54856', '细河区', '210911', '54861', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54862', '3', '54856', '阜新蒙古族自治县', '210921', '54862', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54863', '3', '54856', '彰武县', '210922', '54863', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54864', '3', '54785', '辽阳市', '211000', '54864', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54865', '3', '54864', '白塔区', '211002', '54865', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54866', '3', '54864', '文圣区', '211003', '54866', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54867', '3', '54864', '宏伟区', '211004', '54867', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54868', '3', '54864', '弓长岭区', '211005', '54868', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54869', '3', '54864', '太子河区', '211011', '54869', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54870', '3', '54864', '辽阳县', '211021', '54870', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54871', '3', '54864', '灯塔市', '211081', '54871', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54872', '3', '54785', '盘锦市', '211100', '54872', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54873', '3', '54872', '双台子区', '211102', '54873', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54874', '3', '54872', '兴隆台区', '211103', '54874', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54875', '3', '54872', '大洼县', '211121', '54875', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54876', '3', '54872', '盘山县', '211122', '54876', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54877', '3', '54785', '铁岭市', '211200', '54877', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54878', '3', '54877', '银州区', '211202', '54878', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54879', '3', '54877', '清河区', '211204', '54879', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54880', '3', '54877', '铁岭县', '211221', '54880', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54881', '3', '54877', '西丰县', '211223', '54881', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54882', '3', '54877', '昌图县', '211224', '54882', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54883', '3', '54877', '调兵山市', '211281', '54883', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54884', '3', '54877', '开原市', '211282', '54884', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54885', '3', '54785', '朝阳市', '211300', '54885', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54886', '3', '54885', '双塔区', '211302', '54886', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54887', '3', '54885', '龙城区', '211303', '54887', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54888', '3', '54885', '朝阳县', '211321', '54888', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54889', '3', '54885', '建平县', '211322', '54889', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54890', '3', '54885', '喀喇沁左翼蒙古族自治县', '211324', '54890', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54891', '3', '54885', '北票市', '211381', '54891', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54892', '3', '54885', '凌源市', '211382', '54892', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54893', '3', '54785', '葫芦岛市', '211400', '54893', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54894', '3', '54893', '连山区', '211402', '54894', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54895', '3', '54893', '龙港区', '211403', '54895', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54896', '3', '54893', '南票区', '211404', '54896', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54897', '3', '54893', '绥中县', '211421', '54897', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54898', '3', '54893', '建昌县', '211422', '54898', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54899', '3', '54893', '兴城市', '211481', '54899', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54900', '3', '54317', '吉林省', '220000', '54900', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54901', '3', '54900', '长春市', '220100', '54901', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54902', '3', '54901', '南关区', '220102', '54902', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54903', '3', '54901', '宽城区', '220103', '54903', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54904', '3', '54901', '朝阳区', '220104', '54904', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54905', '3', '54901', '二道区', '220105', '54905', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54906', '3', '54901', '绿园区', '220106', '54906', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54907', '3', '54901', '双阳区', '220112', '54907', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54908', '3', '54901', '农安县', '220122', '54908', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54909', '3', '54901', '九台市', '220181', '54909', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54910', '3', '54901', '榆树市', '220182', '54910', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54911', '3', '54901', '德惠市', '220183', '54911', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54912', '3', '54900', '吉林市', '220200', '54912', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54913', '3', '54912', '昌邑区', '220202', '54913', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54914', '3', '54912', '龙潭区', '220203', '54914', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54915', '3', '54912', '船营区', '220204', '54915', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54916', '3', '54912', '丰满区', '220211', '54916', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54917', '3', '54912', '永吉县', '220221', '54917', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54918', '3', '54912', '蛟河市', '220281', '54918', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54919', '3', '54912', '桦甸市', '220282', '54919', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54920', '3', '54912', '舒兰市', '220283', '54920', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54921', '3', '54912', '磐石市', '220284', '54921', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54922', '3', '54900', '四平市', '220300', '54922', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54923', '3', '54922', '铁西区', '220302', '54923', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54924', '3', '54922', '铁东区', '220303', '54924', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54925', '3', '54922', '梨树县', '220322', '54925', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54926', '3', '54922', '伊通满族自治县', '220323', '54926', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54927', '3', '54922', '公主岭市', '220381', '54927', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54928', '3', '54922', '双辽市', '220382', '54928', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54929', '3', '54900', '辽源市', '220400', '54929', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54930', '3', '54929', '龙山区', '220402', '54930', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54931', '3', '54929', '西安区', '220403', '54931', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54932', '3', '54929', '东丰县', '220421', '54932', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54933', '3', '54929', '东辽县', '220422', '54933', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54934', '3', '54900', '通化市', '220500', '54934', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54935', '3', '54934', '东昌区', '220502', '54935', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54936', '3', '54934', '二道江区', '220503', '54936', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54937', '3', '54934', '通化县', '220521', '54937', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54938', '3', '54934', '辉南县', '220523', '54938', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54939', '3', '54934', '柳河县', '220524', '54939', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54940', '3', '54934', '梅河口市', '220581', '54940', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54941', '3', '54934', '集安市', '220582', '54941', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54942', '3', '54900', '白山市', '220600', '54942', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54943', '3', '54942', '八道江区', '220602', '54943', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54944', '3', '54942', '江源区', '220605', '54944', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54945', '3', '54942', '抚松县', '220621', '54945', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54946', '3', '54942', '靖宇县', '220622', '54946', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54947', '3', '54942', '长白朝鲜族自治县', '220623', '54947', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54948', '3', '54942', '临江市', '220681', '54948', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54949', '3', '54900', '松原市', '220700', '54949', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54950', '3', '54949', '宁江区', '220702', '54950', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54951', '3', '54949', '前郭尔罗斯蒙古族自治县', '220721', '54951', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54952', '3', '54949', '长岭县', '220722', '54952', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54953', '3', '54949', '乾安县', '220723', '54953', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54954', '3', '54949', '扶余县', '220724', '54954', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54955', '3', '54900', '白城市', '220800', '54955', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54956', '3', '54955', '洮北区', '220802', '54956', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54957', '3', '54955', '镇赉县', '220821', '54957', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54958', '3', '54955', '通榆县', '220822', '54958', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54959', '3', '54955', '洮南市', '220881', '54959', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54960', '3', '54955', '大安市', '220882', '54960', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54961', '3', '54900', '延边朝鲜族自治州', '222400', '54961', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54962', '3', '54961', '延吉市', '222401', '54962', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54963', '3', '54961', '图们市', '222402', '54963', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54964', '3', '54961', '敦化市', '222403', '54964', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54965', '3', '54961', '珲春市', '222404', '54965', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54966', '3', '54961', '龙井市', '222405', '54966', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54967', '3', '54961', '和龙市', '222406', '54967', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54968', '3', '54961', '汪清县', '222424', '54968', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54969', '3', '54961', '安图县', '222426', '54969', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54970', '3', '54317', '黑龙江省', '230000', '54970', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54971', '3', '54970', '哈尔滨市', '230100', '54971', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54972', '3', '54971', '道里区', '230102', '54972', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54973', '3', '54971', '南岗区', '230103', '54973', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54974', '3', '54971', '道外区', '230104', '54974', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54975', '3', '54971', '平房区', '230108', '54975', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54976', '3', '54971', '松北区', '230109', '54976', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54977', '3', '54971', '香坊区', '230110', '54977', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54978', '3', '54971', '呼兰区', '230111', '54978', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54979', '3', '54971', '阿城区', '230112', '54979', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54980', '3', '54971', '依兰县', '230123', '54980', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54981', '3', '54971', '方正县', '230124', '54981', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54982', '3', '54971', '宾县', '230125', '54982', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54983', '3', '54971', '巴彦县', '230126', '54983', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54984', '3', '54971', '木兰县', '230127', '54984', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54985', '3', '54971', '通河县', '230128', '54985', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54986', '3', '54971', '延寿县', '230129', '54986', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54987', '3', '54971', '双城市', '230182', '54987', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54988', '3', '54971', '尚志市', '230183', '54988', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54989', '3', '54971', '五常市', '230184', '54989', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54990', '3', '54970', '齐齐哈尔市', '230200', '54990', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54991', '3', '54990', '龙沙区', '230202', '54991', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54992', '3', '54990', '建华区', '230203', '54992', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54993', '3', '54990', '铁锋区', '230204', '54993', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54994', '3', '54990', '昂昂溪区', '230205', '54994', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54995', '3', '54990', '富拉尔基区', '230206', '54995', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54996', '3', '54990', '碾子山区', '230207', '54996', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54997', '3', '54990', '梅里斯达斡尔族区', '230208', '54997', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54998', '3', '54990', '龙江县', '230221', '54998', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('54999', '3', '54990', '依安县', '230223', '54999', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55000', '3', '54990', '泰来县', '230224', '55000', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55001', '3', '54990', '甘南县', '230225', '55001', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55002', '3', '54990', '富裕县', '230227', '55002', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55003', '3', '54990', '克山县', '230229', '55003', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55004', '3', '54990', '克东县', '230230', '55004', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55005', '3', '54990', '拜泉县', '230231', '55005', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55006', '3', '54990', '讷河市', '230281', '55006', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55007', '3', '54970', '鸡西市', '230300', '55007', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55008', '3', '55007', '鸡冠区', '230302', '55008', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55009', '3', '55007', '恒山区', '230303', '55009', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55010', '3', '55007', '滴道区', '230304', '55010', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55011', '3', '55007', '梨树区', '230305', '55011', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55012', '3', '55007', '城子河区', '230306', '55012', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55013', '3', '55007', '麻山区', '230307', '55013', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55014', '3', '55007', '鸡东县', '230321', '55014', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55015', '3', '55007', '虎林市', '230381', '55015', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55016', '3', '55007', '密山市', '230382', '55016', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55017', '3', '54970', '鹤岗市', '230400', '55017', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55018', '3', '55017', '向阳区', '230402', '55018', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55019', '3', '55017', '工农区', '230403', '55019', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55020', '3', '55017', '南山区', '230404', '55020', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55021', '3', '55017', '兴安区', '230405', '55021', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55022', '3', '55017', '东山区', '230406', '55022', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55023', '3', '55017', '兴山区', '230407', '55023', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55024', '3', '55017', '萝北县', '230421', '55024', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55025', '3', '55017', '绥滨县', '230422', '55025', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55026', '3', '54970', '双鸭山市', '230500', '55026', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55027', '3', '55026', '尖山区', '230502', '55027', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55028', '3', '55026', '岭东区', '230503', '55028', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55029', '3', '55026', '四方台区', '230505', '55029', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55030', '3', '55026', '宝山区', '230506', '55030', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55031', '3', '55026', '集贤县', '230521', '55031', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55032', '3', '55026', '友谊县', '230522', '55032', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55033', '3', '55026', '宝清县', '230523', '55033', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55034', '3', '55026', '饶河县', '230524', '55034', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55035', '3', '54970', '大庆市', '230600', '55035', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55036', '3', '55035', '萨尔图区', '230602', '55036', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55037', '3', '55035', '龙凤区', '230603', '55037', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55038', '3', '55035', '让胡路区', '230604', '55038', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55039', '3', '55035', '红岗区', '230605', '55039', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55040', '3', '55035', '大同区', '230606', '55040', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55041', '3', '55035', '肇州县', '230621', '55041', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55042', '3', '55035', '肇源县', '230622', '55042', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55043', '3', '55035', '林甸县', '230623', '55043', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55044', '3', '55035', '杜尔伯特蒙古族自治县', '230624', '55044', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55045', '3', '54970', '伊春市', '230700', '55045', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55046', '3', '55045', '伊春区', '230702', '55046', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55047', '3', '55045', '南岔区', '230703', '55047', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55048', '3', '55045', '友好区', '230704', '55048', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55049', '3', '55045', '西林区', '230705', '55049', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55050', '3', '55045', '翠峦区', '230706', '55050', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55051', '3', '55045', '新青区', '230707', '55051', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55052', '3', '55045', '美溪区', '230708', '55052', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55053', '3', '55045', '金山屯区', '230709', '55053', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55054', '3', '55045', '五营区', '230710', '55054', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55055', '3', '55045', '乌马河区', '230711', '55055', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55056', '3', '55045', '汤旺河区', '230712', '55056', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55057', '3', '55045', '带岭区', '230713', '55057', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55058', '3', '55045', '乌伊岭区', '230714', '55058', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55059', '3', '55045', '红星区', '230715', '55059', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55060', '3', '55045', '上甘岭区', '230716', '55060', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55061', '3', '55045', '嘉荫县', '230722', '55061', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55062', '3', '55045', '铁力市', '230781', '55062', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55063', '3', '54970', '佳木斯市', '230800', '55063', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55064', '3', '55063', '向阳区', '230803', '55064', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55065', '3', '55063', '前进区', '230804', '55065', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55066', '3', '55063', '东风区', '230805', '55066', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55067', '3', '55063', '郊区', '230811', '55067', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55068', '3', '55063', '桦南县', '230822', '55068', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55069', '3', '55063', '桦川县', '230826', '55069', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55070', '3', '55063', '汤原县', '230828', '55070', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55071', '3', '55063', '抚远县', '230833', '55071', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55072', '3', '55063', '同江市', '230881', '55072', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55073', '3', '55063', '富锦市', '230882', '55073', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55074', '3', '54970', '七台河市', '230900', '55074', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55075', '3', '55074', '新兴区', '230902', '55075', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55076', '3', '55074', '桃山区', '230903', '55076', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55077', '3', '55074', '茄子河区', '230904', '55077', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55078', '3', '55074', '勃利县', '230921', '55078', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55079', '3', '54970', '牡丹江市', '231000', '55079', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55080', '3', '55079', '东安区', '231002', '55080', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55081', '3', '55079', '阳明区', '231003', '55081', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55082', '3', '55079', '爱民区', '231004', '55082', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55083', '3', '55079', '西安区', '231005', '55083', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55084', '3', '55079', '东宁县', '231024', '55084', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55085', '3', '55079', '林口县', '231025', '55085', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55086', '3', '55079', '绥芬河市', '231081', '55086', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55087', '3', '55079', '海林市', '231083', '55087', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55088', '3', '55079', '宁安市', '231084', '55088', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55089', '3', '55079', '穆棱市', '231085', '55089', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55090', '3', '54970', '黑河市', '231100', '55090', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55091', '3', '55090', '爱辉区', '231102', '55091', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55092', '3', '55090', '嫩江县', '231121', '55092', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55093', '3', '55090', '逊克县', '231123', '55093', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55094', '3', '55090', '孙吴县', '231124', '55094', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55095', '3', '55090', '北安市', '231181', '55095', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55096', '3', '55090', '五大连池市', '231182', '55096', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55097', '3', '54970', '绥化市', '231200', '55097', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55098', '3', '55097', '北林区', '231202', '55098', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55099', '3', '55097', '望奎县', '231221', '55099', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55100', '3', '55097', '兰西县', '231222', '55100', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55101', '3', '55097', '青冈县', '231223', '55101', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55102', '3', '55097', '庆安县', '231224', '55102', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55103', '3', '55097', '明水县', '231225', '55103', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55104', '3', '55097', '绥棱县', '231226', '55104', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55105', '3', '55097', '安达市', '231281', '55105', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55106', '3', '55097', '肇东市', '231282', '55106', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55107', '3', '55097', '海伦市', '231283', '55107', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55108', '3', '54970', '大兴安岭地区', '232700', '55108', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55109', '3', '55108', '加格达奇区', '232701', '55109', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55110', '3', '55108', '松岭区', '232702', '55110', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55111', '3', '55108', '新林区', '232703', '55111', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55112', '3', '55108', '呼中区', '232704', '55112', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55113', '3', '55108', '呼玛县', '232721', '55113', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55114', '3', '55108', '塔河县', '232722', '55114', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55115', '3', '55108', '漠河县', '232723', '55115', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55116', '3', '57619', '上海市', '310100', '55116', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55117', '3', '55116', '黄浦区', '310101', '55117', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55118', '3', '55116', '卢湾区', '310103', '55118', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55119', '3', '55116', '徐汇区', '310104', '55119', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55120', '3', '55116', '长宁区', '310105', '55120', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55121', '3', '55116', '静安区', '310106', '55121', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55122', '3', '55116', '普陀区', '310107', '55122', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55123', '3', '55116', '闸北区', '310108', '55123', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55124', '3', '55116', '虹口区', '310109', '55124', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55125', '3', '55116', '杨浦区', '310110', '55125', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55126', '3', '55116', '闵行区', '310112', '55126', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55127', '3', '55116', '宝山区', '310113', '55127', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55128', '3', '55116', '嘉定区', '310114', '55128', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55129', '3', '55116', '浦东新区', '310115', '55129', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55130', '3', '55116', '金山区', '310116', '55130', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55131', '3', '55116', '松江区', '310117', '55131', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55132', '3', '55116', '青浦区', '310118', '55132', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55133', '3', '55116', '南汇区', '310119', '55133', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55134', '3', '55116', '奉贤区', '310120', '55134', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55135', '3', '55116', '崇明县', '310230', '55135', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55136', '3', '54317', '江苏省', '320000', '55136', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55137', '3', '55136', '南京市', '320100', '55137', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55138', '3', '55137', '玄武区', '320102', '55138', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55139', '3', '55137', '白下区', '320103', '55139', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55140', '3', '55137', '秦淮区', '320104', '55140', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55141', '3', '55137', '建邺区', '320105', '55141', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55142', '3', '55137', '鼓楼区', '320106', '55142', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55143', '3', '55137', '下关区', '320107', '55143', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55144', '3', '55137', '浦口区', '320111', '55144', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55145', '3', '55137', '栖霞区', '320113', '55145', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55146', '3', '55137', '雨花台区', '320114', '55146', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55147', '3', '55137', '江宁区', '320115', '55147', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55148', '3', '55137', '六合区', '320116', '55148', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55149', '3', '55137', '溧水县', '320124', '55149', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55150', '3', '55137', '高淳县', '320125', '55150', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55151', '3', '55136', '无锡市', '320200', '55151', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55152', '3', '55151', '崇安区', '320202', '55152', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55153', '3', '55151', '南长区', '320203', '55153', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55154', '3', '55151', '北塘区', '320204', '55154', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55155', '3', '55151', '锡山区', '320205', '55155', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55156', '3', '55151', '惠山区', '320206', '55156', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55157', '3', '55151', '滨湖区', '320211', '55157', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55158', '3', '55151', '江阴市', '320281', '55158', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55159', '3', '55151', '宜兴市', '320282', '55159', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55160', '3', '55136', '徐州市', '320300', '55160', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55161', '3', '55160', '鼓楼区', '320302', '55161', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55162', '3', '55160', '云龙区', '320303', '55162', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55163', '3', '55160', '九里区', '320304', '55163', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55164', '3', '55160', '贾汪区', '320305', '55164', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55165', '3', '55160', '泉山区', '320311', '55165', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55166', '3', '55160', '丰县', '320321', '55166', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55167', '3', '55160', '沛县', '320322', '55167', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55168', '3', '55160', '铜山县', '320323', '55168', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55169', '3', '55160', '睢宁县', '320324', '55169', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55170', '3', '55160', '新沂市', '320381', '55170', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55171', '3', '55160', '邳州市', '320382', '55171', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55172', '3', '55136', '常州市', '320400', '55172', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55173', '3', '55172', '天宁区', '320402', '55173', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55174', '3', '55172', '钟楼区', '320404', '55174', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55175', '3', '55172', '戚墅堰区', '320405', '55175', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55176', '3', '55172', '新北区', '320411', '55176', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55177', '3', '55172', '武进区', '320412', '55177', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55178', '3', '55172', '溧阳市', '320481', '55178', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55179', '3', '55172', '金坛市', '320482', '55179', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55180', '3', '55136', '苏州市', '320500', '55180', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55181', '3', '55180', '沧浪区', '320502', '55181', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55182', '3', '55180', '平江区', '320503', '55182', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55183', '3', '55180', '金阊区', '320504', '55183', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55184', '3', '55180', '虎丘区', '320505', '55184', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55185', '3', '55180', '吴中区', '320506', '55185', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55186', '3', '55180', '相城区', '320507', '55186', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55187', '3', '55180', '常熟市', '320581', '55187', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55188', '3', '55180', '张家港市', '320582', '55188', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55189', '3', '55180', '昆山市', '320583', '55189', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55190', '3', '55180', '吴江市', '320584', '55190', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55191', '3', '55180', '太仓市', '320585', '55191', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55192', '3', '55136', '南通市', '320600', '55192', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55193', '3', '55192', '崇川区', '320602', '55193', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55194', '3', '55192', '港闸区', '320611', '55194', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55195', '3', '55192', '海安县', '320621', '55195', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55196', '3', '55192', '如东县', '320623', '55196', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55197', '3', '55192', '启东市', '320681', '55197', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55198', '3', '55192', '如皋市', '320682', '55198', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55199', '3', '55192', '通州市', '320683', '55199', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55200', '3', '55192', '海门市', '320684', '55200', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55201', '3', '55136', '连云港市', '320700', '55201', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55202', '3', '55201', '连云区', '320703', '55202', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55203', '3', '55201', '新浦区', '320705', '55203', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55204', '3', '55201', '海州区', '320706', '55204', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55205', '3', '55201', '赣榆县', '320721', '55205', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55206', '3', '55201', '东海县', '320722', '55206', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55207', '3', '55201', '灌云县', '320723', '55207', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55208', '3', '55201', '灌南县', '320724', '55208', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55209', '3', '55136', '淮安市', '320800', '55209', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55210', '3', '55209', '清河区', '320802', '55210', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55211', '3', '55209', '楚州区', '320803', '55211', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55212', '3', '55209', '淮阴区', '320804', '55212', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55213', '3', '55209', '清浦区', '320811', '55213', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55214', '3', '55209', '涟水县', '320826', '55214', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55215', '3', '55209', '洪泽县', '320829', '55215', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55216', '3', '55209', '盱眙县', '320830', '55216', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55217', '3', '55209', '金湖县', '320831', '55217', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55218', '3', '55136', '盐城市', '320900', '55218', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55219', '3', '55218', '亭湖区', '320902', '55219', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55220', '3', '55218', '盐都区', '320903', '55220', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55221', '3', '55218', '响水县', '320921', '55221', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55222', '3', '55218', '滨海县', '320922', '55222', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55223', '3', '55218', '阜宁县', '320923', '55223', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55224', '3', '55218', '射阳县', '320924', '55224', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55225', '3', '55218', '建湖县', '320925', '55225', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55226', '3', '55218', '东台市', '320981', '55226', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55227', '3', '55218', '大丰市', '320982', '55227', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55228', '3', '55136', '扬州市', '321000', '55228', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55229', '3', '55228', '广陵区', '321002', '55229', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55230', '3', '55228', '邗江区', '321003', '55230', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55231', '3', '55228', '维扬区', '321011', '55231', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55232', '3', '55228', '宝应县', '321023', '55232', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55233', '3', '55228', '仪征市', '321081', '55233', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55234', '3', '55228', '高邮市', '321084', '55234', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55235', '3', '55228', '江都市', '321088', '55235', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55236', '3', '55136', '镇江市', '321100', '55236', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55237', '3', '55236', '京口区', '321102', '55237', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55238', '3', '55236', '润州区', '321111', '55238', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55239', '3', '55236', '丹徒区', '321112', '55239', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55240', '3', '55236', '丹阳市', '321181', '55240', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55241', '3', '55236', '扬中市', '321182', '55241', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55242', '3', '55236', '句容市', '321183', '55242', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55243', '3', '55136', '泰州市', '321200', '55243', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55244', '3', '55243', '海陵区', '321202', '55244', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55245', '3', '55243', '高港区', '321203', '55245', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55246', '3', '55243', '兴化市', '321281', '55246', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55247', '3', '55243', '靖江市', '321282', '55247', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55248', '3', '55243', '泰兴市', '321283', '55248', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55249', '3', '55243', '姜堰市', '321284', '55249', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55250', '3', '55136', '宿迁市', '321300', '55250', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55251', '3', '55250', '宿城区', '321302', '55251', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55252', '3', '55250', '宿豫区', '321311', '55252', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55253', '3', '55250', '沭阳县', '321322', '55253', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55254', '3', '55250', '泗阳县', '321323', '55254', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55255', '3', '55250', '泗洪县', '321324', '55255', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55256', '3', '54317', '浙江省', '330000', '55256', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55257', '3', '55256', '杭州市', '330100', '55257', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55258', '3', '55257', '上城区', '330102', '55258', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55259', '3', '55257', '下城区', '330103', '55259', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55260', '3', '55257', '江干区', '330104', '55260', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55261', '3', '55257', '拱墅区', '330105', '55261', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55262', '3', '55257', '西湖区', '330106', '55262', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55263', '3', '55257', '滨江区', '330108', '55263', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55264', '3', '55257', '萧山区', '330109', '55264', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55265', '3', '55257', '余杭区', '330110', '55265', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55266', '3', '55257', '桐庐县', '330122', '55266', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55267', '3', '55257', '淳安县', '330127', '55267', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55268', '3', '55257', '建德市', '330182', '55268', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55269', '3', '55257', '富阳市', '330183', '55269', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55270', '3', '55257', '临安市', '330185', '55270', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55271', '3', '55256', '宁波市', '330200', '55271', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55272', '3', '55271', '海曙区', '330203', '55272', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55273', '3', '55271', '江东区', '330204', '55273', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55274', '3', '55271', '江北区', '330205', '55274', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55275', '3', '55271', '北仑区', '330206', '55275', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55276', '3', '55271', '镇海区', '330211', '55276', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55277', '3', '55271', '鄞州区', '330212', '55277', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55278', '3', '55271', '象山县', '330225', '55278', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55279', '3', '55271', '宁海县', '330226', '55279', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55280', '3', '55271', '余姚市', '330281', '55280', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55281', '3', '55271', '慈溪市', '330282', '55281', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55282', '3', '55271', '奉化市', '330283', '55282', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55283', '3', '55256', '温州市', '330300', '55283', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55284', '3', '55283', '鹿城区', '330302', '55284', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55285', '3', '55283', '龙湾区', '330303', '55285', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55286', '3', '55283', '瓯海区', '330304', '55286', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55287', '3', '55283', '洞头县', '330322', '55287', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55288', '3', '55283', '永嘉县', '330324', '55288', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55289', '3', '55283', '平阳县', '330326', '55289', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55290', '3', '55283', '苍南县', '330327', '55290', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55291', '3', '55283', '文成县', '330328', '55291', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55292', '3', '55283', '泰顺县', '330329', '55292', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55293', '3', '55283', '瑞安市', '330381', '55293', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55294', '3', '55283', '乐清市', '330382', '55294', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55295', '3', '55256', '嘉兴市', '330400', '55295', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55296', '3', '55295', '南湖区', '330402', '55296', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55297', '3', '55295', '秀洲区', '330411', '55297', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55298', '3', '55295', '嘉善县', '330421', '55298', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55299', '3', '55295', '海盐县', '330424', '55299', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55300', '3', '55295', '海宁市', '330481', '55300', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55301', '3', '55295', '平湖市', '330482', '55301', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55302', '3', '55295', '桐乡市', '330483', '55302', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55303', '3', '55256', '湖州市', '330500', '55303', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55304', '3', '55303', '吴兴区', '330502', '55304', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55305', '3', '55303', '南浔区', '330503', '55305', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55306', '3', '55303', '德清县', '330521', '55306', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55307', '3', '55303', '长兴县', '330522', '55307', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55308', '3', '55303', '安吉县', '330523', '55308', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55309', '3', '55256', '绍兴市', '330600', '55309', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55310', '3', '55309', '越城区', '330602', '55310', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55311', '3', '55309', '绍兴县', '330621', '55311', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55312', '3', '55309', '新昌县', '330624', '55312', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55313', '3', '55309', '诸暨市', '330681', '55313', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55314', '3', '55309', '上虞市', '330682', '55314', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55315', '3', '55309', '嵊州市', '330683', '55315', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55316', '3', '55256', '金华市', '330700', '55316', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55317', '3', '55316', '婺城区', '330702', '55317', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55318', '3', '55316', '金东区', '330703', '55318', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55319', '3', '55316', '武义县', '330723', '55319', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55320', '3', '55316', '浦江县', '330726', '55320', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55321', '3', '55316', '磐安县', '330727', '55321', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55322', '3', '55316', '兰溪市', '330781', '55322', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55323', '3', '55316', '义乌市', '330782', '55323', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55324', '3', '55316', '东阳市', '330783', '55324', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55325', '3', '55316', '永康市', '330784', '55325', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55326', '3', '55256', '衢州市', '330800', '55326', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55327', '3', '55326', '柯城区', '330802', '55327', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55328', '3', '55326', '衢江区', '330803', '55328', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55329', '3', '55326', '常山县', '330822', '55329', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55330', '3', '55326', '开化县', '330824', '55330', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55331', '3', '55326', '龙游县', '330825', '55331', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55332', '3', '55326', '江山市', '330881', '55332', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55333', '3', '55256', '舟山市', '330900', '55333', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55334', '3', '55333', '定海区', '330902', '55334', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55335', '3', '55333', '普陀区', '330903', '55335', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55336', '3', '55333', '岱山县', '330921', '55336', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55337', '3', '55333', '嵊泗县', '330922', '55337', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55338', '3', '55256', '台州市', '331000', '55338', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55339', '3', '55338', '椒江区', '331002', '55339', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55340', '3', '55338', '黄岩区', '331003', '55340', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55341', '3', '55338', '路桥区', '331004', '55341', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55342', '3', '55338', '玉环县', '331021', '55342', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55343', '3', '55338', '三门县', '331022', '55343', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55344', '3', '55338', '天台县', '331023', '55344', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55345', '3', '55338', '仙居县', '331024', '55345', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55346', '3', '55338', '温岭市', '331081', '55346', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55347', '3', '55338', '临海市', '331082', '55347', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55348', '3', '55256', '丽水市', '331100', '55348', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55349', '3', '55348', '莲都区', '331102', '55349', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55350', '3', '55348', '青田县', '331121', '55350', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55351', '3', '55348', '缙云县', '331122', '55351', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55352', '3', '55348', '遂昌县', '331123', '55352', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55353', '3', '55348', '松阳县', '331124', '55353', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55354', '3', '55348', '云和县', '331125', '55354', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55355', '3', '55348', '庆元县', '331126', '55355', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55356', '3', '55348', '景宁畲族自治县', '331127', '55356', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55357', '3', '55348', '龙泉市', '331181', '55357', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55358', '3', '54317', '安徽省', '340000', '55358', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55359', '3', '55358', '合肥市', '340100', '55359', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55360', '3', '55359', '瑶海区', '340102', '55360', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55361', '3', '55359', '庐阳区', '340103', '55361', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55362', '3', '55359', '蜀山区', '340104', '55362', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55363', '3', '55359', '包河区', '340111', '55363', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55364', '3', '55359', '长丰县', '340121', '55364', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55365', '3', '55359', '肥东县', '340122', '55365', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55366', '3', '55359', '肥西县', '340123', '55366', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55367', '3', '55358', '芜湖市', '340200', '55367', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55368', '3', '55367', '镜湖区', '340202', '55368', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55369', '3', '55367', '弋江区', '340203', '55369', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55370', '3', '55367', '鸠江区', '340207', '55370', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55371', '3', '55367', '三山区', '340208', '55371', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55372', '3', '55367', '芜湖县', '340221', '55372', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55373', '3', '55367', '繁昌县', '340222', '55373', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55374', '3', '55367', '南陵县', '340223', '55374', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55375', '3', '55358', '蚌埠市', '340300', '55375', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55376', '3', '55375', '龙子湖区', '340302', '55376', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55377', '3', '55375', '蚌山区', '340303', '55377', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55378', '3', '55375', '禹会区', '340304', '55378', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55379', '3', '55375', '淮上区', '340311', '55379', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55380', '3', '55375', '怀远县', '340321', '55380', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55381', '3', '55375', '五河县', '340322', '55381', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55382', '3', '55375', '固镇县', '340323', '55382', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55383', '3', '55358', '淮南市', '340400', '55383', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55384', '3', '55383', '大通区', '340402', '55384', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55385', '3', '55383', '田家庵区', '340403', '55385', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55386', '3', '55383', '谢家集区', '340404', '55386', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55387', '3', '55383', '八公山区', '340405', '55387', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55388', '3', '55383', '潘集区', '340406', '55388', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55389', '3', '55383', '凤台县', '340421', '55389', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55390', '3', '55358', '马鞍山市', '340500', '55390', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55391', '3', '55390', '金家庄区', '340502', '55391', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55392', '3', '55390', '花山区', '340503', '55392', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55393', '3', '55390', '雨山区', '340504', '55393', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55394', '3', '55390', '当涂县', '340521', '55394', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55395', '3', '55358', '淮北市', '340600', '55395', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55396', '3', '55395', '杜集区', '340602', '55396', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55397', '3', '55395', '相山区', '340603', '55397', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55398', '3', '55395', '烈山区', '340604', '55398', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55399', '3', '55395', '濉溪县', '340621', '55399', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55400', '3', '55358', '铜陵市', '340700', '55400', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55401', '3', '55400', '铜官山区', '340702', '55401', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55402', '3', '55400', '狮子山区', '340703', '55402', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55403', '3', '55400', '郊区', '340711', '55403', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55404', '3', '55400', '铜陵县', '340721', '55404', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55405', '3', '55358', '安庆市', '340800', '55405', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55406', '3', '55405', '迎江区', '340802', '55406', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55407', '3', '55405', '大观区', '340803', '55407', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55408', '3', '55405', '宜秀区', '340811', '55408', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55409', '3', '55405', '怀宁县', '340822', '55409', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55410', '3', '55405', '枞阳县', '340823', '55410', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55411', '3', '55405', '潜山县', '340824', '55411', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55412', '3', '55405', '太湖县', '340825', '55412', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55413', '3', '55405', '宿松县', '340826', '55413', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55414', '3', '55405', '望江县', '340827', '55414', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55415', '3', '55405', '岳西县', '340828', '55415', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55416', '3', '55405', '桐城市', '340881', '55416', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55417', '3', '55358', '黄山市', '341000', '55417', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55418', '3', '55417', '屯溪区', '341002', '55418', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55419', '3', '55417', '黄山区', '341003', '55419', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55420', '3', '55417', '徽州区', '341004', '55420', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55421', '3', '55417', '歙县', '341021', '55421', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55422', '3', '55417', '休宁县', '341022', '55422', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55423', '3', '55417', '黟县', '341023', '55423', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55424', '3', '55417', '祁门县', '341024', '55424', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55425', '3', '55358', '滁州市', '341100', '55425', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55426', '3', '55425', '琅琊区', '341102', '55426', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55427', '3', '55425', '南谯区', '341103', '55427', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55428', '3', '55425', '来安县', '341122', '55428', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55429', '3', '55425', '全椒县', '341124', '55429', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55430', '3', '55425', '定远县', '341125', '55430', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55431', '3', '55425', '凤阳县', '341126', '55431', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55432', '3', '55425', '天长市', '341181', '55432', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55433', '3', '55425', '明光市', '341182', '55433', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55434', '3', '55358', '阜阳市', '341200', '55434', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55435', '3', '55434', '颍州区', '341202', '55435', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55436', '3', '55434', '颍东区', '341203', '55436', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55437', '3', '55434', '颍泉区', '341204', '55437', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55438', '3', '55434', '临泉县', '341221', '55438', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55439', '3', '55434', '太和县', '341222', '55439', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55440', '3', '55434', '阜南县', '341225', '55440', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55441', '3', '55434', '颍上县', '341226', '55441', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55442', '3', '55434', '界首市', '341282', '55442', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55443', '3', '55358', '宿州市', '341300', '55443', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55444', '3', '55443', '埇桥区', '341302', '55444', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55445', '3', '55443', '砀山县', '341321', '55445', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55446', '3', '55443', '萧县', '341322', '55446', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55447', '3', '55443', '灵璧县', '341323', '55447', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55448', '3', '55443', '泗县', '341324', '55448', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55449', '3', '55358', '巢湖市', '341400', '55449', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55450', '3', '55449', '居巢区', '341402', '55450', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55451', '3', '55449', '庐江县', '341421', '55451', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55452', '3', '55449', '无为县', '341422', '55452', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55453', '3', '55449', '含山县', '341423', '55453', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55454', '3', '55449', '和县', '341424', '55454', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55455', '3', '55358', '六安市', '341500', '55455', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55456', '3', '55455', '金安区', '341502', '55456', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55457', '3', '55455', '裕安区', '341503', '55457', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55458', '3', '55455', '寿县', '341521', '55458', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55459', '3', '55455', '霍邱县', '341522', '55459', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55460', '3', '55455', '舒城县', '341523', '55460', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55461', '3', '55455', '金寨县', '341524', '55461', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55462', '3', '55455', '霍山县', '341525', '55462', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55463', '3', '55358', '亳州市', '341600', '55463', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55464', '3', '55463', '谯城区', '341602', '55464', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55465', '3', '55463', '涡阳县', '341621', '55465', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55466', '3', '55463', '蒙城县', '341622', '55466', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55467', '3', '55463', '利辛县', '341623', '55467', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55468', '3', '55358', '池州市', '341700', '55468', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55469', '3', '55468', '贵池区', '341702', '55469', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55470', '3', '55468', '东至县', '341721', '55470', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55471', '3', '55468', '石台县', '341722', '55471', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55472', '3', '55468', '青阳县', '341723', '55472', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55473', '3', '55358', '宣城市', '341800', '55473', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55474', '3', '55473', '宣州区', '341802', '55474', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55475', '3', '55473', '郎溪县', '341821', '55475', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55476', '3', '55473', '广德县', '341822', '55476', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55477', '3', '55473', '泾县', '341823', '55477', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55478', '3', '55473', '绩溪县', '341824', '55478', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55479', '3', '55473', '旌德县', '341825', '55479', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55480', '3', '55473', '宁国市', '341881', '55480', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55481', '3', '54317', '福建省', '350000', '55481', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55482', '3', '55481', '福州市', '350100', '55482', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55483', '3', '55482', '鼓楼区', '350102', '55483', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55484', '3', '55482', '台江区', '350103', '55484', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55485', '3', '55482', '仓山区', '350104', '55485', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55486', '3', '55482', '马尾区', '350105', '55486', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55487', '3', '55482', '晋安区', '350111', '55487', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55488', '3', '55482', '闽侯县', '350121', '55488', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55489', '3', '55482', '连江县', '350122', '55489', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55490', '3', '55482', '罗源县', '350123', '55490', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55491', '3', '55482', '闽清县', '350124', '55491', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55492', '3', '55482', '永泰县', '350125', '55492', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55493', '3', '55482', '平潭县', '350128', '55493', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55494', '3', '55482', '福清市', '350181', '55494', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55495', '3', '55482', '长乐市', '350182', '55495', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55496', '3', '55481', '厦门市', '350200', '55496', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55497', '3', '55496', '思明区', '350203', '55497', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55498', '3', '55496', '海沧区', '350205', '55498', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55499', '3', '55496', '湖里区', '350206', '55499', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55500', '3', '55496', '集美区', '350211', '55500', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55501', '3', '55496', '同安区', '350212', '55501', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55502', '3', '55496', '翔安区', '350213', '55502', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55503', '3', '55481', '莆田市', '350300', '55503', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55504', '3', '55503', '城厢区', '350302', '55504', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55505', '3', '55503', '涵江区', '350303', '55505', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55506', '3', '55503', '荔城区', '350304', '55506', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55507', '3', '55503', '秀屿区', '350305', '55507', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55508', '3', '55503', '仙游县', '350322', '55508', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55509', '3', '55481', '三明市', '350400', '55509', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55510', '3', '55509', '梅列区', '350402', '55510', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55511', '3', '55509', '三元区', '350403', '55511', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55512', '3', '55509', '明溪县', '350421', '55512', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55513', '3', '55509', '清流县', '350423', '55513', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55514', '3', '55509', '宁化县', '350424', '55514', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55515', '3', '55509', '大田县', '350425', '55515', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55516', '3', '55509', '尤溪县', '350426', '55516', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55517', '3', '55509', '沙县', '350427', '55517', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55518', '3', '55509', '将乐县', '350428', '55518', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55519', '3', '55509', '泰宁县', '350429', '55519', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55520', '3', '55509', '建宁县', '350430', '55520', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55521', '3', '55509', '永安市', '350481', '55521', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55522', '3', '55481', '泉州市', '350500', '55522', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55523', '3', '55522', '鲤城区', '350502', '55523', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55524', '3', '55522', '丰泽区', '350503', '55524', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55525', '3', '55522', '洛江区', '350504', '55525', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55526', '3', '55522', '泉港区', '350505', '55526', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55527', '3', '55522', '惠安县', '350521', '55527', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55528', '3', '55522', '安溪县', '350524', '55528', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55529', '3', '55522', '永春县', '350525', '55529', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55530', '3', '55522', '德化县', '350526', '55530', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55531', '3', '55522', '金门县', '350527', '55531', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55532', '3', '55522', '石狮市', '350581', '55532', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55533', '3', '55522', '晋江市', '350582', '55533', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55534', '3', '55522', '南安市', '350583', '55534', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55535', '3', '55481', '漳州市', '350600', '55535', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55536', '3', '55535', '芗城区', '350602', '55536', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55537', '3', '55535', '龙文区', '350603', '55537', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55538', '3', '55535', '云霄县', '350622', '55538', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55539', '3', '55535', '漳浦县', '350623', '55539', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55540', '3', '55535', '诏安县', '350624', '55540', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55541', '3', '55535', '长泰县', '350625', '55541', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55542', '3', '55535', '东山县', '350626', '55542', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55543', '3', '55535', '南靖县', '350627', '55543', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55544', '3', '55535', '平和县', '350628', '55544', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55545', '3', '55535', '华安县', '350629', '55545', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55546', '3', '55535', '龙海市', '350681', '55546', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55547', '3', '55481', '南平市', '350700', '55547', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55548', '3', '55547', '延平区', '350702', '55548', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55549', '3', '55547', '顺昌县', '350721', '55549', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55550', '3', '55547', '浦城县', '350722', '55550', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55551', '3', '55547', '光泽县', '350723', '55551', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55552', '3', '55547', '松溪县', '350724', '55552', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55553', '3', '55547', '政和县', '350725', '55553', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55554', '3', '55547', '邵武市', '350781', '55554', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55555', '3', '55547', '武夷山市', '350782', '55555', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55556', '3', '55547', '建瓯市', '350783', '55556', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55557', '3', '55547', '建阳市', '350784', '55557', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55558', '3', '55481', '龙岩市', '350800', '55558', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55559', '3', '55558', '新罗区', '350802', '55559', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55560', '3', '55558', '长汀县', '350821', '55560', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55561', '3', '55558', '永定县', '350822', '55561', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55562', '3', '55558', '上杭县', '350823', '55562', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55563', '3', '55558', '武平县', '350824', '55563', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55564', '3', '55558', '连城县', '350825', '55564', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55565', '3', '55558', '漳平市', '350881', '55565', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55566', '3', '55481', '宁德市', '350900', '55566', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55567', '3', '55566', '蕉城区', '350902', '55567', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55568', '3', '55566', '霞浦县', '350921', '55568', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55569', '3', '55566', '古田县', '350922', '55569', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55570', '3', '55566', '屏南县', '350923', '55570', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55571', '3', '55566', '寿宁县', '350924', '55571', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55572', '3', '55566', '周宁县', '350925', '55572', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55573', '3', '55566', '柘荣县', '350926', '55573', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55574', '3', '55566', '福安市', '350981', '55574', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55575', '3', '55566', '福鼎市', '350982', '55575', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55576', '3', '54317', '江西省', '360000', '55576', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55577', '3', '55576', '南昌市', '360100', '55577', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55578', '3', '55577', '东湖区', '360102', '55578', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55579', '3', '55577', '西湖区', '360103', '55579', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55580', '3', '55577', '青云谱区', '360104', '55580', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55581', '3', '55577', '湾里区', '360105', '55581', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55582', '3', '55577', '青山湖区', '360111', '55582', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55583', '3', '55577', '南昌县', '360121', '55583', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55584', '3', '55577', '新建县', '360122', '55584', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55585', '3', '55577', '安义县', '360123', '55585', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55586', '3', '55577', '进贤县', '360124', '55586', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55587', '3', '55576', '景德镇市', '360200', '55587', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55588', '3', '55587', '昌江区', '360202', '55588', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55589', '3', '55587', '珠山区', '360203', '55589', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55590', '3', '55587', '浮梁县', '360222', '55590', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55591', '3', '55587', '乐平市', '360281', '55591', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55592', '3', '55576', '萍乡市', '360300', '55592', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55593', '3', '55592', '安源区', '360302', '55593', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55594', '3', '55592', '湘东区', '360313', '55594', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55595', '3', '55592', '莲花县', '360321', '55595', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55596', '3', '55592', '上栗县', '360322', '55596', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55597', '3', '55592', '芦溪县', '360323', '55597', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55598', '3', '55576', '九江市', '360400', '55598', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55599', '3', '55598', '庐山区', '360402', '55599', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55600', '3', '55598', '浔阳区', '360403', '55600', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55601', '3', '55598', '九江县', '360421', '55601', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55602', '3', '55598', '武宁县', '360423', '55602', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55603', '3', '55598', '修水县', '360424', '55603', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55604', '3', '55598', '永修县', '360425', '55604', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55605', '3', '55598', '德安县', '360426', '55605', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55606', '3', '55598', '星子县', '360427', '55606', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55607', '3', '55598', '都昌县', '360428', '55607', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55608', '3', '55598', '湖口县', '360429', '55608', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55609', '3', '55598', '彭泽县', '360430', '55609', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55610', '3', '55598', '瑞昌市', '360481', '55610', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55611', '3', '55576', '新余市', '360500', '55611', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55612', '3', '55611', '渝水区', '360502', '55612', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55613', '3', '55611', '分宜县', '360521', '55613', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55614', '3', '55576', '鹰潭市', '360600', '55614', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55615', '3', '55614', '月湖区', '360602', '55615', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55616', '3', '55614', '余江县', '360622', '55616', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55617', '3', '55614', '贵溪市', '360681', '55617', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55618', '3', '55576', '赣州市', '360700', '55618', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55619', '3', '55618', '章贡区', '360702', '55619', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55620', '3', '55618', '赣县', '360721', '55620', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55621', '3', '55618', '信丰县', '360722', '55621', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55622', '3', '55618', '大余县', '360723', '55622', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55623', '3', '55618', '上犹县', '360724', '55623', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55624', '3', '55618', '崇义县', '360725', '55624', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55625', '3', '55618', '安远县', '360726', '55625', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55626', '3', '55618', '龙南县', '360727', '55626', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55627', '3', '55618', '定南县', '360728', '55627', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55628', '3', '55618', '全南县', '360729', '55628', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55629', '3', '55618', '宁都县', '360730', '55629', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55630', '3', '55618', '于都县', '360731', '55630', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55631', '3', '55618', '兴国县', '360732', '55631', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55632', '3', '55618', '会昌县', '360733', '55632', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55633', '3', '55618', '寻乌县', '360734', '55633', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55634', '3', '55618', '石城县', '360735', '55634', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55635', '3', '55618', '瑞金市', '360781', '55635', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55636', '3', '55618', '南康市', '360782', '55636', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55637', '3', '55576', '吉安市', '360800', '55637', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55638', '3', '55637', '吉州区', '360802', '55638', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55639', '3', '55637', '青原区', '360803', '55639', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55640', '3', '55637', '吉安县', '360821', '55640', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55641', '3', '55637', '吉水县', '360822', '55641', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55642', '3', '55637', '峡江县', '360823', '55642', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55643', '3', '55637', '新干县', '360824', '55643', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55644', '3', '55637', '永丰县', '360825', '55644', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55645', '3', '55637', '泰和县', '360826', '55645', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55646', '3', '55637', '遂川县', '360827', '55646', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55647', '3', '55637', '万安县', '360828', '55647', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55648', '3', '55637', '安福县', '360829', '55648', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55649', '3', '55637', '永新县', '360830', '55649', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55650', '3', '55637', '井冈山市', '360881', '55650', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55651', '3', '55576', '宜春市', '360900', '55651', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55652', '3', '55651', '袁州区', '360902', '55652', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55653', '3', '55651', '奉新县', '360921', '55653', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55654', '3', '55651', '万载县', '360922', '55654', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55655', '3', '55651', '上高县', '360923', '55655', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55656', '3', '55651', '宜丰县', '360924', '55656', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55657', '3', '55651', '靖安县', '360925', '55657', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55658', '3', '55651', '铜鼓县', '360926', '55658', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55659', '3', '55651', '丰城市', '360981', '55659', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55660', '3', '55651', '樟树市', '360982', '55660', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55661', '3', '55651', '高安市', '360983', '55661', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55662', '3', '55576', '抚州市', '361000', '55662', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55663', '3', '55662', '临川区', '361002', '55663', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55664', '3', '55662', '南城县', '361021', '55664', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55665', '3', '55662', '黎川县', '361022', '55665', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55666', '3', '55662', '南丰县', '361023', '55666', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55667', '3', '55662', '崇仁县', '361024', '55667', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55668', '3', '55662', '乐安县', '361025', '55668', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55669', '3', '55662', '宜黄县', '361026', '55669', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55670', '3', '55662', '金溪县', '361027', '55670', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55671', '3', '55662', '资溪县', '361028', '55671', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55672', '3', '55662', '东乡县', '361029', '55672', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55673', '3', '55662', '广昌县', '361030', '55673', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55674', '3', '55576', '上饶市', '361100', '55674', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55675', '3', '55674', '信州区', '361102', '55675', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55676', '3', '55674', '上饶县', '361121', '55676', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55677', '3', '55674', '广丰县', '361122', '55677', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55678', '3', '55674', '玉山县', '361123', '55678', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55679', '3', '55674', '铅山县', '361124', '55679', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55680', '3', '55674', '横峰县', '361125', '55680', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55681', '3', '55674', '弋阳县', '361126', '55681', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55682', '3', '55674', '余干县', '361127', '55682', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55683', '3', '55674', '鄱阳县', '361128', '55683', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55684', '3', '55674', '万年县', '361129', '55684', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55685', '3', '55674', '婺源县', '361130', '55685', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55686', '3', '55674', '德兴市', '361181', '55686', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55687', '3', '54317', '山东省', '370000', '55687', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55688', '3', '55687', '济南市', '370100', '55688', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55689', '3', '55688', '历下区', '370102', '55689', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55690', '3', '55688', '市中区', '370103', '55690', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55691', '3', '55688', '槐荫区', '370104', '55691', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55692', '3', '55688', '天桥区', '370105', '55692', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55693', '3', '55688', '历城区', '370112', '55693', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55694', '3', '55688', '长清区', '370113', '55694', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55695', '3', '55688', '平阴县', '370124', '55695', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55696', '3', '55688', '济阳县', '370125', '55696', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55697', '3', '55688', '商河县', '370126', '55697', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55698', '3', '55688', '章丘市', '370181', '55698', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55699', '3', '55687', '青岛市', '370200', '55699', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55700', '3', '55699', '市南区', '370202', '55700', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55701', '3', '55699', '市北区', '370203', '55701', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55702', '3', '55699', '四方区', '370205', '55702', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55703', '3', '55699', '黄岛区', '370211', '55703', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55704', '3', '55699', '崂山区', '370212', '55704', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55705', '3', '55699', '李沧区', '370213', '55705', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55706', '3', '55699', '城阳区', '370214', '55706', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55707', '3', '55699', '胶州市', '370281', '55707', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55708', '3', '55699', '即墨市', '370282', '55708', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55709', '3', '55699', '平度市', '370283', '55709', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55710', '3', '55699', '胶南市', '370284', '55710', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55711', '3', '55699', '莱西市', '370285', '55711', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55712', '3', '55687', '淄博市', '370300', '55712', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55713', '3', '55712', '淄川区', '370302', '55713', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55714', '3', '55712', '张店区', '370303', '55714', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55715', '3', '55712', '博山区', '370304', '55715', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55716', '3', '55712', '临淄区', '370305', '55716', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55717', '3', '55712', '周村区', '370306', '55717', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55718', '3', '55712', '桓台县', '370321', '55718', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55719', '3', '55712', '高青县', '370322', '55719', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55720', '3', '55712', '沂源县', '370323', '55720', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55721', '3', '55687', '枣庄市', '370400', '55721', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55722', '3', '55721', '市中区', '370402', '55722', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55723', '3', '55721', '薛城区', '370403', '55723', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55724', '3', '55721', '峄城区', '370404', '55724', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55725', '3', '55721', '台儿庄区', '370405', '55725', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55726', '3', '55721', '山亭区', '370406', '55726', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55727', '3', '55721', '滕州市', '370481', '55727', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55728', '3', '55687', '东营市', '370500', '55728', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55729', '3', '55728', '东营区', '370502', '55729', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55730', '3', '55728', '河口区', '370503', '55730', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55731', '3', '55728', '垦利县', '370521', '55731', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55732', '3', '55728', '利津县', '370522', '55732', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55733', '3', '55728', '广饶县', '370523', '55733', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55734', '3', '55687', '烟台市', '370600', '55734', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55735', '3', '55734', '芝罘区', '370602', '55735', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55736', '3', '55734', '福山区', '370611', '55736', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55737', '3', '55734', '牟平区', '370612', '55737', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55738', '3', '55734', '莱山区', '370613', '55738', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55739', '3', '55734', '长岛县', '370634', '55739', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55740', '3', '55734', '龙口市', '370681', '55740', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55741', '3', '55734', '莱阳市', '370682', '55741', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55742', '3', '55734', '莱州市', '370683', '55742', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55743', '3', '55734', '蓬莱市', '370684', '55743', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55744', '3', '55734', '招远市', '370685', '55744', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55745', '3', '55734', '栖霞市', '370686', '55745', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55746', '3', '55734', '海阳市', '370687', '55746', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55747', '3', '55687', '潍坊市', '370700', '55747', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55748', '3', '55747', '潍城区', '370702', '55748', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55749', '3', '55747', '寒亭区', '370703', '55749', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55750', '3', '55747', '坊子区', '370704', '55750', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55751', '3', '55747', '奎文区', '370705', '55751', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55752', '3', '55747', '临朐县', '370724', '55752', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55753', '3', '55747', '昌乐县', '370725', '55753', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55754', '3', '55747', '青州市', '370781', '55754', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55755', '3', '55747', '诸城市', '370782', '55755', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55756', '3', '55747', '寿光市', '370783', '55756', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55757', '3', '55747', '安丘市', '370784', '55757', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55758', '3', '55747', '高密市', '370785', '55758', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55759', '3', '55747', '昌邑市', '370786', '55759', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55760', '3', '55687', '济宁市', '370800', '55760', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55761', '3', '55760', '市中区', '370802', '55761', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55762', '3', '55760', '任城区', '370811', '55762', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55763', '3', '55760', '微山县', '370826', '55763', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55764', '3', '55760', '鱼台县', '370827', '55764', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55765', '3', '55760', '金乡县', '370828', '55765', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55766', '3', '55760', '嘉祥县', '370829', '55766', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55767', '3', '55760', '汶上县', '370830', '55767', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55768', '3', '55760', '泗水县', '370831', '55768', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55769', '3', '55760', '梁山县', '370832', '55769', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55770', '3', '55760', '曲阜市', '370881', '55770', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55771', '3', '55760', '兖州市', '370882', '55771', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55772', '3', '55760', '邹城市', '370883', '55772', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55773', '3', '55687', '泰安市', '370900', '55773', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55774', '3', '55773', '泰山区', '370902', '55774', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55775', '3', '55773', '岱岳区', '370911', '55775', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55776', '3', '55773', '宁阳县', '370921', '55776', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55777', '3', '55773', '东平县', '370923', '55777', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55778', '3', '55773', '新泰市', '370982', '55778', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55779', '3', '55773', '肥城市', '370983', '55779', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55780', '3', '55687', '威海市', '371000', '55780', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55781', '3', '55780', '环翠区', '371002', '55781', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55782', '3', '55780', '文登市', '371081', '55782', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55783', '3', '55780', '荣成市', '371082', '55783', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55784', '3', '55780', '乳山市', '371083', '55784', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55785', '3', '55687', '日照市', '371100', '55785', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55786', '3', '55785', '东港区', '371102', '55786', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55787', '3', '55785', '岚山区', '371103', '55787', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55788', '3', '55785', '五莲县', '371121', '55788', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55789', '3', '55785', '莒县', '371122', '55789', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55790', '3', '55687', '莱芜市', '371200', '55790', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55791', '3', '55790', '莱城区', '371202', '55791', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55792', '3', '55790', '钢城区', '371203', '55792', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55793', '3', '55687', '临沂市', '371300', '55793', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55794', '3', '55793', '兰山区', '371302', '55794', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55795', '3', '55793', '罗庄区', '371311', '55795', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55796', '3', '55793', '河东区', '371312', '55796', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55797', '3', '55793', '沂南县', '371321', '55797', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55798', '3', '55793', '郯城县', '371322', '55798', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55799', '3', '55793', '沂水县', '371323', '55799', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55800', '3', '55793', '苍山县', '371324', '55800', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55801', '3', '55793', '费县', '371325', '55801', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55802', '3', '55793', '平邑县', '371326', '55802', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55803', '3', '55793', '莒南县', '371327', '55803', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55804', '3', '55793', '蒙阴县', '371328', '55804', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55805', '3', '55793', '临沭县', '371329', '55805', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55806', '3', '55687', '德州市', '371400', '55806', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55807', '3', '55806', '德城区', '371402', '55807', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55808', '3', '55806', '陵县', '371421', '55808', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55809', '3', '55806', '宁津县', '371422', '55809', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55810', '3', '55806', '庆云县', '371423', '55810', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55811', '3', '55806', '临邑县', '371424', '55811', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55812', '3', '55806', '齐河县', '371425', '55812', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55813', '3', '55806', '平原县', '371426', '55813', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55814', '3', '55806', '夏津县', '371427', '55814', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55815', '3', '55806', '武城县', '371428', '55815', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55816', '3', '55806', '乐陵市', '371481', '55816', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55817', '3', '55806', '禹城市', '371482', '55817', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55818', '3', '55687', '聊城市', '371500', '55818', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55819', '3', '55818', '东昌府区', '371502', '55819', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55820', '3', '55818', '阳谷县', '371521', '55820', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55821', '3', '55818', '莘县', '371522', '55821', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55822', '3', '55818', '茌平县', '371523', '55822', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55823', '3', '55818', '东阿县', '371524', '55823', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55824', '3', '55818', '冠县', '371525', '55824', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55825', '3', '55818', '高唐县', '371526', '55825', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55826', '3', '55818', '临清市', '371581', '55826', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55827', '3', '55687', '滨州市', '371600', '55827', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55828', '3', '55827', '滨城区', '371602', '55828', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55829', '3', '55827', '惠民县', '371621', '55829', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55830', '3', '55827', '阳信县', '371622', '55830', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55831', '3', '55827', '无棣县', '371623', '55831', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55832', '3', '55827', '沾化县', '371624', '55832', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55833', '3', '55827', '博兴县', '371625', '55833', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55834', '3', '55827', '邹平县', '371626', '55834', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55835', '3', '55687', '菏泽市', '371700', '55835', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55836', '3', '55835', '牡丹区', '371702', '55836', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55837', '3', '55835', '曹县', '371721', '55837', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55838', '3', '55835', '单县', '371722', '55838', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55839', '3', '55835', '成武县', '371723', '55839', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55840', '3', '55835', '巨野县', '371724', '55840', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55841', '3', '55835', '郓城县', '371725', '55841', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55842', '3', '55835', '鄄城县', '371726', '55842', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55843', '3', '55835', '定陶县', '371727', '55843', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55844', '3', '55835', '东明县', '371728', '55844', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55845', '3', '54317', '河南省', '410000', '55845', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55846', '3', '55845', '郑州市', '410100', '55846', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55847', '3', '55846', '中原区', '410102', '55847', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55848', '3', '55846', '二七区', '410103', '55848', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55849', '3', '55846', '管城回族区', '410104', '55849', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55850', '3', '55846', '金水区', '410105', '55850', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55851', '3', '55846', '上街区', '410106', '55851', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55852', '3', '55846', '惠济区', '410108', '55852', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55853', '3', '55846', '中牟县', '410122', '55853', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55854', '3', '55846', '巩义市', '410181', '55854', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55855', '3', '55846', '荥阳市', '410182', '55855', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55856', '3', '55846', '新密市', '410183', '55856', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55857', '3', '55846', '新郑市', '410184', '55857', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55858', '3', '55846', '登封市', '410185', '55858', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55859', '3', '55845', '开封市', '410200', '55859', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55860', '3', '55859', '龙亭区', '410202', '55860', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55861', '3', '55859', '顺河回族区', '410203', '55861', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55862', '3', '55859', '鼓楼区', '410204', '55862', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55863', '3', '55859', '禹王台区', '410205', '55863', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55864', '3', '55859', '金明区', '410211', '55864', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55865', '3', '55859', '杞县', '410221', '55865', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55866', '3', '55859', '通许县', '410222', '55866', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55867', '3', '55859', '尉氏县', '410223', '55867', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55868', '3', '55859', '开封县', '410224', '55868', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55869', '3', '55859', '兰考县', '410225', '55869', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55870', '3', '55845', '洛阳市', '410300', '55870', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55871', '3', '55870', '老城区', '410302', '55871', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55872', '3', '55870', '西工区', '410303', '55872', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55873', '3', '55870', '瀍河回族区', '410304', '55873', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55874', '3', '55870', '涧西区', '410305', '55874', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55875', '3', '55870', '吉利区', '410306', '55875', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55876', '3', '55870', '洛龙区', '410311', '55876', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55877', '3', '55870', '孟津县', '410322', '55877', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55878', '3', '55870', '新安县', '410323', '55878', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55879', '3', '55870', '栾川县', '410324', '55879', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55880', '3', '55870', '嵩县', '410325', '55880', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55881', '3', '55870', '汝阳县', '410326', '55881', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55882', '3', '55870', '宜阳县', '410327', '55882', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55883', '3', '55870', '洛宁县', '410328', '55883', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55884', '3', '55870', '伊川县', '410329', '55884', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55885', '3', '55870', '偃师市', '410381', '55885', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55886', '3', '55845', '平顶山市', '410400', '55886', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55887', '3', '55886', '新华区', '410402', '55887', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55888', '3', '55886', '卫东区', '410403', '55888', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55889', '3', '55886', '石龙区', '410404', '55889', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55890', '3', '55886', '湛河区', '410411', '55890', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55891', '3', '55886', '宝丰县', '410421', '55891', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55892', '3', '55886', '叶县', '410422', '55892', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55893', '3', '55886', '鲁山县', '410423', '55893', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55894', '3', '55886', '郏县', '410425', '55894', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55895', '3', '55886', '舞钢市', '410481', '55895', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55896', '3', '55886', '汝州市', '410482', '55896', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55897', '3', '55845', '安阳市', '410500', '55897', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55898', '3', '55897', '文峰区', '410502', '55898', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55899', '3', '55897', '北关区', '410503', '55899', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55900', '3', '55897', '殷都区', '410505', '55900', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55901', '3', '55897', '龙安区', '410506', '55901', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55902', '3', '55897', '安阳县', '410522', '55902', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55903', '3', '55897', '汤阴县', '410523', '55903', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55904', '3', '55897', '滑县', '410526', '55904', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55905', '3', '55897', '内黄县', '410527', '55905', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55906', '3', '55897', '林州市', '410581', '55906', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55907', '3', '55845', '鹤壁市', '410600', '55907', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55908', '3', '55907', '鹤山区', '410602', '55908', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55909', '3', '55907', '山城区', '410603', '55909', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55910', '3', '55907', '淇滨区', '410611', '55910', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55911', '3', '55907', '浚县', '410621', '55911', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55912', '3', '55907', '淇县', '410622', '55912', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55913', '3', '55845', '新乡市', '410700', '55913', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55914', '3', '55913', '红旗区', '410702', '55914', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55915', '3', '55913', '卫滨区', '410703', '55915', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55916', '3', '55913', '凤泉区', '410704', '55916', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55917', '3', '55913', '牧野区', '410711', '55917', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55918', '3', '55913', '新乡县', '410721', '55918', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55919', '3', '55913', '获嘉县', '410724', '55919', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55920', '3', '55913', '原阳县', '410725', '55920', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55921', '3', '55913', '延津县', '410726', '55921', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55922', '3', '55913', '封丘县', '410727', '55922', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55923', '3', '55913', '长垣县', '410728', '55923', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55924', '3', '55913', '卫辉市', '410781', '55924', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55925', '3', '55913', '辉县市', '410782', '55925', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55926', '3', '55845', '焦作市', '410800', '55926', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55927', '3', '55926', '解放区', '410802', '55927', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55928', '3', '55926', '中站区', '410803', '55928', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55929', '3', '55926', '马村区', '410804', '55929', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55930', '3', '55926', '山阳区', '410811', '55930', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55931', '3', '55926', '修武县', '410821', '55931', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55932', '3', '55926', '博爱县', '410822', '55932', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55933', '3', '55926', '武陟县', '410823', '55933', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55934', '3', '55926', '温县', '410825', '55934', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55935', '3', '55926', '沁阳市', '410882', '55935', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55936', '3', '55926', '孟州市', '410883', '55936', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55937', '3', '55845', '濮阳市', '410900', '55937', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55938', '3', '55937', '华龙区', '410902', '55938', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55939', '3', '55937', '清丰县', '410922', '55939', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55940', '3', '55937', '南乐县', '410923', '55940', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55941', '3', '55937', '范县', '410926', '55941', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55942', '3', '55937', '台前县', '410927', '55942', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55943', '3', '55937', '濮阳县', '410928', '55943', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55944', '3', '55845', '许昌市', '411000', '55944', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55945', '3', '55944', '魏都区', '411002', '55945', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55946', '3', '55944', '许昌县', '411023', '55946', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55947', '3', '55944', '鄢陵县', '411024', '55947', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55948', '3', '55944', '襄城县', '411025', '55948', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55949', '3', '55944', '禹州市', '411081', '55949', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55950', '3', '55944', '长葛市', '411082', '55950', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55951', '3', '55845', '漯河市', '411100', '55951', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55952', '3', '55951', '源汇区', '411102', '55952', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55953', '3', '55951', '郾城区', '411103', '55953', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55954', '3', '55951', '召陵区', '411104', '55954', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55955', '3', '55951', '舞阳县', '411121', '55955', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55956', '3', '55951', '临颍县', '411122', '55956', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55957', '3', '55845', '三门峡市', '411200', '55957', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55958', '3', '55957', '湖滨区', '411202', '55958', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55959', '3', '55957', '渑池县', '411221', '55959', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55960', '3', '55957', '陕县', '411222', '55960', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55961', '3', '55957', '卢氏县', '411224', '55961', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55962', '3', '55957', '义马市', '411281', '55962', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55963', '3', '55957', '灵宝市', '411282', '55963', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55964', '3', '55845', '南阳市', '411300', '55964', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55965', '3', '55964', '宛城区', '411302', '55965', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55966', '3', '55964', '卧龙区', '411303', '55966', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55967', '3', '55964', '南召县', '411321', '55967', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55968', '3', '55964', '方城县', '411322', '55968', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55969', '3', '55964', '西峡县', '411323', '55969', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55970', '3', '55964', '镇平县', '411324', '55970', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55971', '3', '55964', '内乡县', '411325', '55971', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55972', '3', '55964', '淅川县', '411326', '55972', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55973', '3', '55964', '社旗县', '411327', '55973', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55974', '3', '55964', '唐河县', '411328', '55974', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55975', '3', '55964', '新野县', '411329', '55975', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55976', '3', '55964', '桐柏县', '411330', '55976', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55977', '3', '55964', '邓州市', '411381', '55977', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55978', '3', '55845', '商丘市', '411400', '55978', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55979', '3', '55978', '梁园区', '411402', '55979', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55980', '3', '55978', '睢阳区', '411403', '55980', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55981', '3', '55978', '民权县', '411421', '55981', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55982', '3', '55978', '睢县', '411422', '55982', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55983', '3', '55978', '宁陵县', '411423', '55983', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55984', '3', '55978', '柘城县', '411424', '55984', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55985', '3', '55978', '虞城县', '411425', '55985', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55986', '3', '55978', '夏邑县', '411426', '55986', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55987', '3', '55978', '永城市', '411481', '55987', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55988', '3', '55845', '信阳市', '411500', '55988', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55989', '3', '55988', '浉河区', '411502', '55989', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55990', '3', '55988', '平桥区', '411503', '55990', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55991', '3', '55988', '罗山县', '411521', '55991', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55992', '3', '55988', '光山县', '411522', '55992', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55993', '3', '55988', '新县', '411523', '55993', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55994', '3', '55988', '商城县', '411524', '55994', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55995', '3', '55988', '固始县', '411525', '55995', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55996', '3', '55988', '潢川县', '411526', '55996', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55997', '3', '55988', '淮滨县', '411527', '55997', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55998', '3', '55988', '息县', '411528', '55998', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('55999', '3', '55845', '周口市', '411600', '55999', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56000', '3', '55999', '川汇区', '411602', '56000', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56001', '3', '55999', '扶沟县', '411621', '56001', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56002', '3', '55999', '西华县', '411622', '56002', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56003', '3', '55999', '商水县', '411623', '56003', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56004', '3', '55999', '沈丘县', '411624', '56004', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56005', '3', '55999', '郸城县', '411625', '56005', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56006', '3', '55999', '淮阳县', '411626', '56006', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56007', '3', '55999', '太康县', '411627', '56007', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56008', '3', '55999', '鹿邑县', '411628', '56008', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56009', '3', '55999', '项城市', '411681', '56009', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56010', '3', '55845', '驻马店市', '411700', '56010', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56011', '3', '56010', '驿城区', '411702', '56011', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56012', '3', '56010', '西平县', '411721', '56012', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56013', '3', '56010', '上蔡县', '411722', '56013', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56014', '3', '56010', '平舆县', '411723', '56014', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56015', '3', '56010', '正阳县', '411724', '56015', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56016', '3', '56010', '确山县', '411725', '56016', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56017', '3', '56010', '泌阳县', '411726', '56017', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56018', '3', '56010', '汝南县', '411727', '56018', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56019', '3', '56010', '遂平县', '411728', '56019', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56020', '3', '56010', '新蔡县', '411729', '56020', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56021', '3', '55845', '（省直辖县级行政区划）', '419000', '56021', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56022', '3', '56021', '济源市', '419001', '56022', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56023', '3', '54317', '湖北省', '420000', '56023', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56024', '3', '56023', '武汉市', '420100', '56024', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56025', '3', '56024', '江岸区', '420102', '56025', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56026', '3', '56024', '江汉区', '420103', '56026', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56027', '3', '56024', '硚口区', '420104', '56027', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56028', '3', '56024', '汉阳区', '420105', '56028', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56029', '3', '56024', '武昌区', '420106', '56029', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56030', '3', '56024', '青山区', '420107', '56030', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56031', '3', '56024', '洪山区', '420111', '56031', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56032', '3', '56024', '东西湖区', '420112', '56032', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56033', '3', '56024', '汉南区', '420113', '56033', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56034', '3', '56024', '蔡甸区', '420114', '56034', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56035', '3', '56024', '江夏区', '420115', '56035', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56036', '3', '56024', '黄陂区', '420116', '56036', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56037', '3', '56024', '新洲区', '420117', '56037', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56038', '3', '56023', '黄石市', '420200', '56038', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56039', '3', '56038', '黄石港区', '420202', '56039', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56040', '3', '56038', '西塞山区', '420203', '56040', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56041', '3', '56038', '下陆区', '420204', '56041', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56042', '3', '56038', '铁山区', '420205', '56042', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56043', '3', '56038', '阳新县', '420222', '56043', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56044', '3', '56038', '大冶市', '420281', '56044', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56045', '3', '56023', '十堰市', '420300', '56045', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56046', '3', '56045', '茅箭区', '420302', '56046', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56047', '3', '56045', '张湾区', '420303', '56047', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56048', '3', '56045', '郧县', '420321', '56048', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56049', '3', '56045', '郧西县', '420322', '56049', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56050', '3', '56045', '竹山县', '420323', '56050', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56051', '3', '56045', '竹溪县', '420324', '56051', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56052', '3', '56045', '房县', '420325', '56052', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56053', '3', '56045', '丹江口市', '420381', '56053', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56054', '3', '56023', '宜昌市', '420500', '56054', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56055', '3', '56054', '西陵区', '420502', '56055', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56056', '3', '56054', '伍家岗区', '420503', '56056', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56057', '3', '56054', '点军区', '420504', '56057', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56058', '3', '56054', '猇亭区', '420505', '56058', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56059', '3', '56054', '夷陵区', '420506', '56059', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56060', '3', '56054', '远安县', '420525', '56060', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56061', '3', '56054', '兴山县', '420526', '56061', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56062', '3', '56054', '秭归县', '420527', '56062', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56063', '3', '56054', '长阳土家族自治县', '420528', '56063', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56064', '3', '56054', '五峰土家族自治县', '420529', '56064', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56065', '3', '56054', '宜都市', '420581', '56065', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56066', '3', '56054', '当阳市', '420582', '56066', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56067', '3', '56054', '枝江市', '420583', '56067', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56068', '3', '56023', '襄樊市', '420600', '56068', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56069', '3', '56068', '襄城区', '420602', '56069', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56070', '3', '56068', '樊城区', '420606', '56070', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56071', '3', '56068', '襄阳区', '420607', '56071', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56072', '3', '56068', '南漳县', '420624', '56072', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56073', '3', '56068', '谷城县', '420625', '56073', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56074', '3', '56068', '保康县', '420626', '56074', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56075', '3', '56068', '老河口市', '420682', '56075', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56076', '3', '56068', '枣阳市', '420683', '56076', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56077', '3', '56068', '宜城市', '420684', '56077', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56078', '3', '56023', '鄂州市', '420700', '56078', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56079', '3', '56078', '梁子湖区', '420702', '56079', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56080', '3', '56078', '华容区', '420703', '56080', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56081', '3', '56078', '鄂城区', '420704', '56081', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56082', '3', '56023', '荆门市', '420800', '56082', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56083', '3', '56082', '东宝区', '420802', '56083', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56084', '3', '56082', '掇刀区', '420804', '56084', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56085', '3', '56082', '京山县', '420821', '56085', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56086', '3', '56082', '沙洋县', '420822', '56086', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56087', '3', '56082', '钟祥市', '420881', '56087', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56088', '3', '56023', '孝感市', '420900', '56088', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56089', '3', '56088', '孝南区', '420902', '56089', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56090', '3', '56088', '孝昌县', '420921', '56090', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56091', '3', '56088', '大悟县', '420922', '56091', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56092', '3', '56088', '云梦县', '420923', '56092', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56093', '3', '56088', '应城市', '420981', '56093', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56094', '3', '56088', '安陆市', '420982', '56094', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56095', '3', '56088', '汉川市', '420984', '56095', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56096', '3', '56023', '荆州市', '421000', '56096', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56097', '3', '56096', '沙市区', '421002', '56097', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56098', '3', '56096', '荆州区', '421003', '56098', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56099', '3', '56096', '公安县', '421022', '56099', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56100', '3', '56096', '监利县', '421023', '56100', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56101', '3', '56096', '江陵县', '421024', '56101', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56102', '3', '56096', '石首市', '421081', '56102', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56103', '3', '56096', '洪湖市', '421083', '56103', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56104', '3', '56096', '松滋市', '421087', '56104', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56105', '3', '56023', '黄冈市', '421100', '56105', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56106', '3', '56105', '黄州区', '421102', '56106', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56107', '3', '56105', '团风县', '421121', '56107', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56108', '3', '56105', '红安县', '421122', '56108', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56109', '3', '56105', '罗田县', '421123', '56109', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56110', '3', '56105', '英山县', '421124', '56110', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56111', '3', '56105', '浠水县', '421125', '56111', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56112', '3', '56105', '蕲春县', '421126', '56112', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56113', '3', '56105', '黄梅县', '421127', '56113', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56114', '3', '56105', '麻城市', '421181', '56114', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56115', '3', '56105', '武穴市', '421182', '56115', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56116', '3', '56023', '咸宁市', '421200', '56116', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56117', '3', '56116', '咸安区', '421202', '56117', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56118', '3', '56116', '嘉鱼县', '421221', '56118', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56119', '3', '56116', '通城县', '421222', '56119', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56120', '3', '56116', '崇阳县', '421223', '56120', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56121', '3', '56116', '通山县', '421224', '56121', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56122', '3', '56116', '赤壁市', '421281', '56122', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56123', '3', '56023', '随州市', '421300', '56123', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56124', '3', '56123', '曾都区', '421302', '56124', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56125', '3', '56123', '广水市', '421381', '56125', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56126', '3', '56023', '恩施土家族苗族自治州', '422800', '56126', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56127', '3', '56126', '恩施市', '422801', '56127', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56128', '3', '56126', '利川市', '422802', '56128', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56129', '3', '56126', '建始县', '422822', '56129', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56130', '3', '56126', '巴东县', '422823', '56130', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56131', '3', '56126', '宣恩县', '422825', '56131', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56132', '3', '56126', '咸丰县', '422826', '56132', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56133', '3', '56126', '来凤县', '422827', '56133', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56134', '3', '56126', '鹤峰县', '422828', '56134', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56135', '3', '56023', '（省直辖县级行政区划）', '429000', '56135', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56136', '3', '56135', '仙桃市', '429004', '56136', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56137', '3', '56135', '潜江市', '429005', '56137', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56138', '3', '56135', '天门市', '429006', '56138', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56139', '3', '56135', '神农架林区', '429021', '56139', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56140', '3', '54317', '湖南省', '430000', '56140', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56141', '3', '56140', '长沙市', '430100', '56141', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56142', '3', '56141', '芙蓉区', '430102', '56142', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56143', '3', '56141', '天心区', '430103', '56143', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56144', '3', '56141', '岳麓区', '430104', '56144', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56145', '3', '56141', '开福区', '430105', '56145', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56146', '3', '56141', '雨花区', '430111', '56146', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56147', '3', '56141', '长沙县', '430121', '56147', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56148', '3', '56141', '望城县', '430122', '56148', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56149', '3', '56141', '宁乡县', '430124', '56149', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56150', '3', '56141', '浏阳市', '430181', '56150', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56151', '3', '56140', '株洲市', '430200', '56151', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56152', '3', '56151', '荷塘区', '430202', '56152', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56153', '3', '56151', '芦淞区', '430203', '56153', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56154', '3', '56151', '石峰区', '430204', '56154', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56155', '3', '56151', '天元区', '430211', '56155', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56156', '3', '56151', '株洲县', '430221', '56156', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56157', '3', '56151', '攸县', '430223', '56157', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56158', '3', '56151', '茶陵县', '430224', '56158', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56159', '3', '56151', '炎陵县', '430225', '56159', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56160', '3', '56151', '醴陵市', '430281', '56160', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56161', '3', '56140', '湘潭市', '430300', '56161', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56162', '3', '56161', '雨湖区', '430302', '56162', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56163', '3', '56161', '岳塘区', '430304', '56163', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56164', '3', '56161', '湘潭县', '430321', '56164', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56165', '3', '56161', '湘乡市', '430381', '56165', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56166', '3', '56161', '韶山市', '430382', '56166', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56167', '3', '56140', '衡阳市', '430400', '56167', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56168', '3', '56167', '珠晖区', '430405', '56168', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56169', '3', '56167', '雁峰区', '430406', '56169', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56170', '3', '56167', '石鼓区', '430407', '56170', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56171', '3', '56167', '蒸湘区', '430408', '56171', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56172', '3', '56167', '南岳区', '430412', '56172', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56173', '3', '56167', '衡阳县', '430421', '56173', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56174', '3', '56167', '衡南县', '430422', '56174', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56175', '3', '56167', '衡山县', '430423', '56175', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56176', '3', '56167', '衡东县', '430424', '56176', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56177', '3', '56167', '祁东县', '430426', '56177', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56178', '3', '56167', '耒阳市', '430481', '56178', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56179', '3', '56167', '常宁市', '430482', '56179', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56180', '3', '56140', '邵阳市', '430500', '56180', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56181', '3', '56180', '双清区', '430502', '56181', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56182', '3', '56180', '大祥区', '430503', '56182', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56183', '3', '56180', '北塔区', '430511', '56183', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56184', '3', '56180', '邵东县', '430521', '56184', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56185', '3', '56180', '新邵县', '430522', '56185', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56186', '3', '56180', '邵阳县', '430523', '56186', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56187', '3', '56180', '隆回县', '430524', '56187', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56188', '3', '56180', '洞口县', '430525', '56188', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56189', '3', '56180', '绥宁县', '430527', '56189', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56190', '3', '56180', '新宁县', '430528', '56190', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56191', '3', '56180', '城步苗族自治县', '430529', '56191', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56192', '3', '56180', '武冈市', '430581', '56192', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56193', '3', '56140', '岳阳市', '430600', '56193', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56194', '3', '56193', '岳阳楼区', '430602', '56194', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56195', '3', '56193', '云溪区', '430603', '56195', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56196', '3', '56193', '君山区', '430611', '56196', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56197', '3', '56193', '岳阳县', '430621', '56197', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56198', '3', '56193', '华容县', '430623', '56198', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56199', '3', '56193', '湘阴县', '430624', '56199', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56200', '3', '56193', '平江县', '430626', '56200', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56201', '3', '56193', '汨罗市', '430681', '56201', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56202', '3', '56193', '临湘市', '430682', '56202', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56203', '3', '56140', '常德市', '430700', '56203', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56204', '3', '56203', '武陵区', '430702', '56204', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56205', '3', '56203', '鼎城区', '430703', '56205', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56206', '3', '56203', '安乡县', '430721', '56206', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56207', '3', '56203', '汉寿县', '430722', '56207', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56208', '3', '56203', '澧县', '430723', '56208', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56209', '3', '56203', '临澧县', '430724', '56209', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56210', '3', '56203', '桃源县', '430725', '56210', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56211', '3', '56203', '石门县', '430726', '56211', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56212', '3', '56203', '津市市', '430781', '56212', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56213', '3', '56140', '张家界市', '430800', '56213', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56214', '3', '56213', '永定区', '430802', '56214', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56215', '3', '56213', '武陵源区', '430811', '56215', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56216', '3', '56213', '慈利县', '430821', '56216', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56217', '3', '56213', '桑植县', '430822', '56217', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56218', '3', '56140', '益阳市', '430900', '56218', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56219', '3', '56218', '资阳区', '430902', '56219', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56220', '3', '56218', '赫山区', '430903', '56220', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56221', '3', '56218', '南县', '430921', '56221', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56222', '3', '56218', '桃江县', '430922', '56222', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56223', '3', '56218', '安化县', '430923', '56223', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56224', '3', '56218', '沅江市', '430981', '56224', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56225', '3', '56140', '郴州市', '431000', '56225', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56226', '3', '56225', '北湖区', '431002', '56226', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56227', '3', '56225', '苏仙区', '431003', '56227', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56228', '3', '56225', '桂阳县', '431021', '56228', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56229', '3', '56225', '宜章县', '431022', '56229', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56230', '3', '56225', '永兴县', '431023', '56230', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56231', '3', '56225', '嘉禾县', '431024', '56231', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56232', '3', '56225', '临武县', '431025', '56232', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56233', '3', '56225', '汝城县', '431026', '56233', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56234', '3', '56225', '桂东县', '431027', '56234', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56235', '3', '56225', '安仁县', '431028', '56235', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56236', '3', '56225', '资兴市', '431081', '56236', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56237', '3', '56140', '永州市', '431100', '56237', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56238', '3', '56237', '零陵区', '431102', '56238', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56239', '3', '56237', '冷水滩区', '431103', '56239', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56240', '3', '56237', '祁阳县', '431121', '56240', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56241', '3', '56237', '东安县', '431122', '56241', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56242', '3', '56237', '双牌县', '431123', '56242', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56243', '3', '56237', '道县', '431124', '56243', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56244', '3', '56237', '江永县', '431125', '56244', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56245', '3', '56237', '宁远县', '431126', '56245', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56246', '3', '56237', '蓝山县', '431127', '56246', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56247', '3', '56237', '新田县', '431128', '56247', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56248', '3', '56237', '江华瑶族自治县', '431129', '56248', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56249', '3', '56140', '怀化市', '431200', '56249', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56250', '3', '56249', '鹤城区', '431202', '56250', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56251', '3', '56249', '中方县', '431221', '56251', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56252', '3', '56249', '沅陵县', '431222', '56252', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56253', '3', '56249', '辰溪县', '431223', '56253', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56254', '3', '56249', '溆浦县', '431224', '56254', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56255', '3', '56249', '会同县', '431225', '56255', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56256', '3', '56249', '麻阳苗族自治县', '431226', '56256', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56257', '3', '56249', '新晃侗族自治县', '431227', '56257', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56258', '3', '56249', '芷江侗族自治县', '431228', '56258', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56259', '3', '56249', '靖州苗族侗族自治县', '431229', '56259', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56260', '3', '56249', '通道侗族自治县', '431230', '56260', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56261', '3', '56249', '洪江市', '431281', '56261', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56262', '3', '56140', '娄底市', '431300', '56262', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56263', '3', '56262', '娄星区', '431302', '56263', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56264', '3', '56262', '双峰县', '431321', '56264', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56265', '3', '56262', '新化县', '431322', '56265', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56266', '3', '56262', '冷水江市', '431381', '56266', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56267', '3', '56262', '涟源市', '431382', '56267', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56268', '3', '56140', '湘西土家族苗族自治州', '433100', '56268', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56269', '3', '56268', '吉首市', '433101', '56269', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56270', '3', '56268', '泸溪县', '433122', '56270', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56271', '3', '56268', '凤凰县', '433123', '56271', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56272', '3', '56268', '花垣县', '433124', '56272', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56273', '3', '56268', '保靖县', '433125', '56273', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56274', '3', '56268', '古丈县', '433126', '56274', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56275', '3', '56268', '永顺县', '433127', '56275', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56276', '3', '56268', '龙山县', '433130', '56276', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56277', '3', '54317', '广东省', '440000', '56277', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56278', '3', '56277', '广州市', '440100', '56278', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56279', '3', '56278', '荔湾区', '440103', '56279', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56280', '3', '56278', '越秀区', '440104', '56280', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56281', '3', '56278', '海珠区', '440105', '56281', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56282', '3', '56278', '天河区', '440106', '56282', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56283', '3', '56278', '白云区', '440111', '56283', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56284', '3', '56278', '黄埔区', '440112', '56284', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56285', '3', '56278', '番禺区', '440113', '56285', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56286', '3', '56278', '花都区', '440114', '56286', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56287', '3', '56278', '南沙区', '440115', '56287', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56288', '3', '56278', '萝岗区', '440116', '56288', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56289', '3', '56278', '增城市', '440183', '56289', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56290', '3', '56278', '从化市', '440184', '56290', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56291', '3', '56277', '韶关市', '440200', '56291', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56292', '3', '56291', '武江区', '440203', '56292', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56293', '3', '56291', '浈江区', '440204', '56293', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56294', '3', '56291', '曲江区', '440205', '56294', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56295', '3', '56291', '始兴县', '440222', '56295', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56296', '3', '56291', '仁化县', '440224', '56296', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56297', '3', '56291', '翁源县', '440229', '56297', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56298', '3', '56291', '乳源瑶族自治县', '440232', '56298', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56299', '3', '56291', '新丰县', '440233', '56299', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56300', '3', '56291', '乐昌市', '440281', '56300', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56301', '3', '56291', '南雄市', '440282', '56301', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56302', '3', '56277', '深圳市', '440300', '56302', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56303', '3', '56302', '罗湖区', '440303', '56303', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56304', '3', '56302', '福田区', '440304', '56304', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56305', '3', '56302', '南山区', '440305', '56305', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56306', '3', '56302', '宝安区', '440306', '56306', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56307', '3', '56302', '龙岗区', '440307', '56307', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56308', '3', '56302', '盐田区', '440308', '56308', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56309', '3', '56277', '珠海市', '440400', '56309', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56310', '3', '56309', '香洲区', '440402', '56310', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56311', '3', '56309', '斗门区', '440403', '56311', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56312', '3', '56309', '金湾区', '440404', '56312', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56313', '3', '56277', '汕头市', '440500', '56313', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56314', '3', '56313', '龙湖区', '440507', '56314', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56315', '3', '56313', '金平区', '440511', '56315', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56316', '3', '56313', '濠江区', '440512', '56316', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56317', '3', '56313', '潮阳区', '440513', '56317', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56318', '3', '56313', '潮南区', '440514', '56318', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56319', '3', '56313', '澄海区', '440515', '56319', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56320', '3', '56313', '南澳县', '440523', '56320', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56321', '3', '56277', '佛山市', '440600', '56321', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56322', '3', '56321', '禅城区', '440604', '56322', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56323', '3', '56321', '南海区', '440605', '56323', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56324', '3', '56321', '顺德区', '440606', '56324', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56325', '3', '56321', '三水区', '440607', '56325', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56326', '3', '56321', '高明区', '440608', '56326', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56327', '3', '56277', '江门市', '440700', '56327', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56328', '3', '56327', '蓬江区', '440703', '56328', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56329', '3', '56327', '江海区', '440704', '56329', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56330', '3', '56327', '新会区', '440705', '56330', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56331', '3', '56327', '台山市', '440781', '56331', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56332', '3', '56327', '开平市', '440783', '56332', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56333', '3', '56327', '鹤山市', '440784', '56333', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56334', '3', '56327', '恩平市', '440785', '56334', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56335', '3', '56277', '湛江市', '440800', '56335', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56336', '3', '56335', '赤坎区', '440802', '56336', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56337', '3', '56335', '霞山区', '440803', '56337', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56338', '3', '56335', '坡头区', '440804', '56338', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56339', '3', '56335', '麻章区', '440811', '56339', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56340', '3', '56335', '遂溪县', '440823', '56340', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56341', '3', '56335', '徐闻县', '440825', '56341', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56342', '3', '56335', '廉江市', '440881', '56342', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56343', '3', '56335', '雷州市', '440882', '56343', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56344', '3', '56335', '吴川市', '440883', '56344', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56345', '3', '56277', '茂名市', '440900', '56345', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56346', '3', '56345', '茂南区', '440902', '56346', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56347', '3', '56345', '茂港区', '440903', '56347', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56348', '3', '56345', '电白县', '440923', '56348', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56349', '3', '56345', '高州市', '440981', '56349', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56350', '3', '56345', '化州市', '440982', '56350', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56351', '3', '56345', '信宜市', '440983', '56351', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56352', '3', '56277', '肇庆市', '441200', '56352', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56353', '3', '56352', '端州区', '441202', '56353', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56354', '3', '56352', '鼎湖区', '441203', '56354', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56355', '3', '56352', '广宁县', '441223', '56355', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56356', '3', '56352', '怀集县', '441224', '56356', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56357', '3', '56352', '封开县', '441225', '56357', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56358', '3', '56352', '德庆县', '441226', '56358', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56359', '3', '56352', '高要市', '441283', '56359', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56360', '3', '56352', '四会市', '441284', '56360', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56361', '3', '56277', '惠州市', '441300', '56361', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56362', '3', '56361', '惠城区', '441302', '56362', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56363', '3', '56361', '惠阳区', '441303', '56363', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56364', '3', '56361', '博罗县', '441322', '56364', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56365', '3', '56361', '惠东县', '441323', '56365', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56366', '3', '56361', '龙门县', '441324', '56366', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56367', '3', '56277', '梅州市', '441400', '56367', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56368', '3', '56367', '梅江区', '441402', '56368', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56369', '3', '56367', '梅县', '441421', '56369', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56370', '3', '56367', '大埔县', '441422', '56370', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56371', '3', '56367', '丰顺县', '441423', '56371', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56372', '3', '56367', '五华县', '441424', '56372', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56373', '3', '56367', '平远县', '441426', '56373', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56374', '3', '56367', '蕉岭县', '441427', '56374', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56375', '3', '56367', '兴宁市', '441481', '56375', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56376', '3', '56277', '汕尾市', '441500', '56376', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56377', '3', '56376', '城区', '441502', '56377', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56378', '3', '56376', '海丰县', '441521', '56378', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56379', '3', '56376', '陆河县', '441523', '56379', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56380', '3', '56376', '陆丰市', '441581', '56380', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56381', '3', '56277', '河源市', '441600', '56381', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56382', '3', '56381', '源城区', '441602', '56382', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56383', '3', '56381', '紫金县', '441621', '56383', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56384', '3', '56381', '龙川县', '441622', '56384', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56385', '3', '56381', '连平县', '441623', '56385', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56386', '3', '56381', '和平县', '441624', '56386', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56387', '3', '56381', '东源县', '441625', '56387', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56388', '3', '56277', '阳江市', '441700', '56388', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56389', '3', '56388', '江城区', '441702', '56389', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56390', '3', '56388', '阳西县', '441721', '56390', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56391', '3', '56388', '阳东县', '441723', '56391', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56392', '3', '56388', '阳春市', '441781', '56392', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56393', '3', '56277', '清远市', '441800', '56393', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56394', '3', '56393', '清城区', '441802', '56394', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56395', '3', '56393', '佛冈县', '441821', '56395', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56396', '3', '56393', '阳山县', '441823', '56396', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56397', '3', '56393', '连山壮族瑶族自治县', '441825', '56397', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56398', '3', '56393', '连南瑶族自治县', '441826', '56398', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56399', '3', '56393', '清新县', '441827', '56399', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56400', '3', '56393', '英德市', '441881', '56400', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56401', '3', '56393', '连州市', '441882', '56401', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56402', '3', '56277', '东莞市', '441900', '56402', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56403', '3', '56277', '中山市', '442000', '56403', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56404', '3', '56277', '潮州市', '445100', '56404', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56405', '3', '56404', '湘桥区', '445102', '56405', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56406', '3', '56404', '潮安县', '445121', '56406', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56407', '3', '56404', '饶平县', '445122', '56407', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56408', '3', '56277', '揭阳市', '445200', '56408', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56409', '3', '56408', '榕城区', '445202', '56409', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56410', '3', '56408', '揭东县', '445221', '56410', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56411', '3', '56408', '揭西县', '445222', '56411', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56412', '3', '56408', '惠来县', '445224', '56412', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56413', '3', '56408', '普宁市', '445281', '56413', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56414', '3', '56277', '云浮市', '445300', '56414', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56415', '3', '56414', '云城区', '445302', '56415', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56416', '3', '56414', '新兴县', '445321', '56416', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56417', '3', '56414', '郁南县', '445322', '56417', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56418', '3', '56414', '云安县', '445323', '56418', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56419', '3', '56414', '罗定市', '445381', '56419', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56420', '3', '54317', '广西壮族自治区', '450000', '56420', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56421', '3', '56420', '南宁市', '450100', '56421', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56422', '3', '56421', '兴宁区', '450102', '56422', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56423', '3', '56421', '青秀区', '450103', '56423', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56424', '3', '56421', '江南区', '450105', '56424', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56425', '3', '56421', '西乡塘区', '450107', '56425', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56426', '3', '56421', '良庆区', '450108', '56426', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56427', '3', '56421', '邕宁区', '450109', '56427', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56428', '3', '56421', '武鸣县', '450122', '56428', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56429', '3', '56421', '隆安县', '450123', '56429', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56430', '3', '56421', '马山县', '450124', '56430', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56431', '3', '56421', '上林县', '450125', '56431', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56432', '3', '56421', '宾阳县', '450126', '56432', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56433', '3', '56421', '横县', '450127', '56433', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56434', '3', '56420', '柳州市', '450200', '56434', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56435', '3', '56434', '城中区', '450202', '56435', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56436', '3', '56434', '鱼峰区', '450203', '56436', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56437', '3', '56434', '柳南区', '450204', '56437', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56438', '3', '56434', '柳北区', '450205', '56438', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56439', '3', '56434', '柳江县', '450221', '56439', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56440', '3', '56434', '柳城县', '450222', '56440', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56441', '3', '56434', '鹿寨县', '450223', '56441', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56442', '3', '56434', '融安县', '450224', '56442', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56443', '3', '56434', '融水苗族自治县', '450225', '56443', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56444', '3', '56434', '三江侗族自治县', '450226', '56444', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56445', '3', '56420', '桂林市', '450300', '56445', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56446', '3', '56445', '秀峰区', '450302', '56446', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56447', '3', '56445', '叠彩区', '450303', '56447', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56448', '3', '56445', '象山区', '450304', '56448', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56449', '3', '56445', '七星区', '450305', '56449', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56450', '3', '56445', '雁山区', '450311', '56450', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56451', '3', '56445', '阳朔县', '450321', '56451', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56452', '3', '56445', '临桂县', '450322', '56452', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56453', '3', '56445', '灵川县', '450323', '56453', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56454', '3', '56445', '全州县', '450324', '56454', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56455', '3', '56445', '兴安县', '450325', '56455', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56456', '3', '56445', '永福县', '450326', '56456', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56457', '3', '56445', '灌阳县', '450327', '56457', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56458', '3', '56445', '龙胜各族自治县', '450328', '56458', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56459', '3', '56445', '资源县', '450329', '56459', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56460', '3', '56445', '平乐县', '450330', '56460', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56461', '3', '56445', '荔浦县', '450331', '56461', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56462', '3', '56445', '恭城瑶族自治县', '450332', '56462', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56463', '3', '56420', '梧州市', '450400', '56463', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56464', '3', '56463', '万秀区', '450403', '56464', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56465', '3', '56463', '蝶山区', '450404', '56465', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56466', '3', '56463', '长洲区', '450405', '56466', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56467', '3', '56463', '苍梧县', '450421', '56467', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56468', '3', '56463', '藤县', '450422', '56468', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56469', '3', '56463', '蒙山县', '450423', '56469', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56470', '3', '56463', '岑溪市', '450481', '56470', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56471', '3', '56420', '北海市', '450500', '56471', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56472', '3', '56471', '海城区', '450502', '56472', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56473', '3', '56471', '银海区', '450503', '56473', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56474', '3', '56471', '铁山港区', '450512', '56474', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56475', '3', '56471', '合浦县', '450521', '56475', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56476', '3', '56420', '防城港市', '450600', '56476', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56477', '3', '56476', '港口区', '450602', '56477', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56478', '3', '56476', '防城区', '450603', '56478', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56479', '3', '56476', '上思县', '450621', '56479', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56480', '3', '56476', '东兴市', '450681', '56480', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56481', '3', '56420', '钦州市', '450700', '56481', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56482', '3', '56481', '钦南区', '450702', '56482', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56483', '3', '56481', '钦北区', '450703', '56483', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56484', '3', '56481', '灵山县', '450721', '56484', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56485', '3', '56481', '浦北县', '450722', '56485', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56486', '3', '56420', '贵港市', '450800', '56486', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56487', '3', '56486', '港北区', '450802', '56487', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56488', '3', '56486', '港南区', '450803', '56488', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56489', '3', '56486', '覃塘区', '450804', '56489', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56490', '3', '56486', '平南县', '450821', '56490', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56491', '3', '56486', '桂平市', '450881', '56491', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56492', '3', '56420', '玉林市', '450900', '56492', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56493', '3', '56492', '玉州区', '450902', '56493', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56494', '3', '56492', '容县', '450921', '56494', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56495', '3', '56492', '陆川县', '450922', '56495', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56496', '3', '56492', '博白县', '450923', '56496', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56497', '3', '56492', '兴业县', '450924', '56497', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56498', '3', '56492', '北流市', '450981', '56498', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56499', '3', '56420', '百色市', '451000', '56499', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56500', '3', '56499', '右江区', '451002', '56500', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56501', '3', '56499', '田阳县', '451021', '56501', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56502', '3', '56499', '田东县', '451022', '56502', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56503', '3', '56499', '平果县', '451023', '56503', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56504', '3', '56499', '德保县', '451024', '56504', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56505', '3', '56499', '靖西县', '451025', '56505', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56506', '3', '56499', '那坡县', '451026', '56506', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56507', '3', '56499', '凌云县', '451027', '56507', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56508', '3', '56499', '乐业县', '451028', '56508', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56509', '3', '56499', '田林县', '451029', '56509', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56510', '3', '56499', '西林县', '451030', '56510', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56511', '3', '56499', '隆林各族自治县', '451031', '56511', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56512', '3', '56420', '贺州市', '451100', '56512', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56513', '3', '56512', '八步区', '451102', '56513', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56514', '3', '56512', '昭平县', '451121', '56514', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56515', '3', '56512', '钟山县', '451122', '56515', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56516', '3', '56512', '富川瑶族自治县', '451123', '56516', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56517', '3', '56420', '河池市', '451200', '56517', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56518', '3', '56517', '金城江区', '451202', '56518', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56519', '3', '56517', '南丹县', '451221', '56519', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56520', '3', '56517', '天峨县', '451222', '56520', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56521', '3', '56517', '凤山县', '451223', '56521', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56522', '3', '56517', '东兰县', '451224', '56522', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56523', '3', '56517', '罗城仫佬族自治县', '451225', '56523', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56524', '3', '56517', '环江毛南族自治县', '451226', '56524', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56525', '3', '56517', '巴马瑶族自治县', '451227', '56525', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56526', '3', '56517', '都安瑶族自治县', '451228', '56526', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56527', '3', '56517', '大化瑶族自治县', '451229', '56527', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56528', '3', '56517', '宜州市', '451281', '56528', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56529', '3', '56420', '来宾市', '451300', '56529', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56530', '3', '56529', '兴宾区', '451302', '56530', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56531', '3', '56529', '忻城县', '451321', '56531', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56532', '3', '56529', '象州县', '451322', '56532', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56533', '3', '56529', '武宣县', '451323', '56533', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56534', '3', '56529', '金秀瑶族自治县', '451324', '56534', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56535', '3', '56529', '合山市', '451381', '56535', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56536', '3', '56420', '崇左市', '451400', '56536', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56537', '3', '56536', '江洲区', '451402', '56537', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56538', '3', '56536', '扶绥县', '451421', '56538', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56539', '3', '56536', '宁明县', '451422', '56539', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56540', '3', '56536', '龙州县', '451423', '56540', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56541', '3', '56536', '大新县', '451424', '56541', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56542', '3', '56536', '天等县', '451425', '56542', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56543', '3', '56536', '凭祥市', '451481', '56543', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56544', '3', '54317', '海南省', '460000', '56544', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56545', '3', '56544', '海口市', '460100', '56545', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56546', '3', '56545', '秀英区', '460105', '56546', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56547', '3', '56545', '龙华区', '460106', '56547', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56548', '3', '56545', '琼山区', '460107', '56548', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56549', '3', '56545', '美兰区', '460108', '56549', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56550', '3', '56544', '三亚市', '460200', '56550', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56551', '3', '56544', '三沙市\n', '460300', '56551', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56552', '3', '56551', '西沙群岛', '460321', '56552', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56553', '3', '56551', '南沙群岛', '460322', '56553', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56554', '3', '56551', '中沙群岛的岛礁及其海域', '460323', '56554', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56555', '3', '56544', '（省直辖县级行政区划）', '469000', '56555', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56556', '3', '56555', '五指山市', '469001', '56556', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56557', '3', '56555', '琼海市', '469002', '56557', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56558', '3', '56555', '儋州市', '469003', '56558', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56559', '3', '56555', '文昌市', '469005', '56559', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56560', '3', '56555', '万宁市', '469006', '56560', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56561', '3', '56555', '东方市', '469007', '56561', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56562', '3', '56555', '定安县', '469021', '56562', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56563', '3', '56555', '屯昌县', '469022', '56563', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56564', '3', '56555', '澄迈县', '469023', '56564', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56565', '3', '56555', '临高县', '469024', '56565', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56566', '3', '56555', '白沙黎族自治县', '469025', '56566', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56567', '3', '56555', '昌江黎族自治县', '469026', '56567', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56568', '3', '56555', '乐东黎族自治县', '469027', '56568', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56569', '3', '56555', '陵水黎族自治县', '469028', '56569', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56570', '3', '56555', '保亭黎族苗族自治县', '469029', '56570', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56571', '3', '56555', '琼中黎族苗族自治县', '469030', '56571', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56572', '3', '57618', '重庆市', '500100', '56572', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56573', '3', '56572', '万州区', '500101', '56573', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56574', '3', '56572', '涪陵区', '500102', '56574', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56575', '3', '56572', '渝中区', '500103', '56575', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56576', '3', '56572', '大渡口区', '500104', '56576', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56577', '3', '56572', '江北区', '500105', '56577', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56578', '3', '56572', '沙坪坝区', '500106', '56578', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56579', '3', '56572', '九龙坡区', '500107', '56579', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56580', '3', '56572', '南岸区', '500108', '56580', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56581', '3', '56572', '北碚区', '500109', '56581', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56582', '3', '56572', '万盛区', '500110', '56582', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56583', '3', '56572', '双桥区', '500111', '56583', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56584', '3', '56572', '渝北区', '500112', '56584', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56585', '3', '56572', '巴南区', '500113', '56585', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56586', '3', '56572', '黔江区', '500114', '56586', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56587', '3', '56572', '长寿区', '500115', '56587', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56588', '3', '56572', '江津区', '500116', '56588', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56589', '3', '56572', '合川区', '500117', '56589', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56590', '3', '56572', '永川区', '500118', '56590', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56591', '3', '56572', '南川区', '500119', '56591', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56592', '3', '56572', '綦江县', '500222', '56592', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56593', '3', '56572', '潼南县', '500223', '56593', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56594', '3', '56572', '铜梁县', '500224', '56594', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56595', '3', '56572', '大足县', '500225', '56595', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56596', '3', '56572', '荣昌县', '500226', '56596', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56597', '3', '56572', '璧山县', '500227', '56597', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56598', '3', '56572', '梁平县', '500228', '56598', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56599', '3', '56572', '城口县', '500229', '56599', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56600', '3', '56572', '丰都县', '500230', '56600', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56601', '3', '56572', '垫江县', '500231', '56601', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56602', '3', '56572', '武隆县', '500232', '56602', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56603', '3', '56572', '忠县', '500233', '56603', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56604', '3', '56572', '开县', '500234', '56604', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56605', '3', '56572', '云阳县', '500235', '56605', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56606', '3', '56572', '奉节县', '500236', '56606', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56607', '3', '56572', '巫山县', '500237', '56607', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56608', '3', '56572', '巫溪县', '500238', '56608', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56609', '3', '56572', '石柱土家族自治县', '500240', '56609', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56610', '3', '56572', '秀山土家族苗族自治县', '500241', '56610', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56611', '3', '56572', '酉阳土家族苗族自治县', '500242', '56611', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56612', '3', '56572', '彭水苗族土家族自治县', '500243', '56612', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56613', '3', '54317', '四川省', '510000', '56613', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56614', '3', '56613', '成都市', '510100', '56614', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56615', '3', '56614', '锦江区', '510104', '56615', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56616', '3', '56614', '青羊区', '510105', '56616', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56617', '3', '56614', '金牛区', '510106', '56617', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56618', '3', '56614', '武侯区', '510107', '56618', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56619', '3', '56614', '成华区', '510108', '56619', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56620', '3', '56614', '高新区', '510109', '56620', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56621', '3', '56614', '龙泉驿区', '510112', '56621', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56622', '3', '56614', '青白江区', '510113', '56622', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56623', '3', '56614', '新都区', '510114', '56623', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56624', '3', '56614', '温江区', '510115', '56624', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56625', '3', '56614', '金堂县', '510121', '56625', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56626', '3', '56614', '双流县', '510122', '56626', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56627', '3', '56614', '郫县', '510124', '56627', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56628', '3', '56614', '大邑县', '510129', '56628', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56629', '3', '56614', '蒲江县', '510131', '56629', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56630', '3', '56614', '新津县', '510132', '56630', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56631', '3', '56614', '都江堰市', '510181', '56631', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56632', '3', '56614', '彭州市', '510182', '56632', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56633', '3', '56614', '邛崃市', '510183', '56633', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56634', '3', '56614', '崇州市', '510184', '56634', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56635', '3', '56613', '自贡市', '510300', '56635', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56636', '3', '56635', '自流井区', '510302', '56636', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56637', '3', '56635', '贡井区', '510303', '56637', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56638', '3', '56635', '大安区', '510304', '56638', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56639', '3', '56635', '沿滩区', '510311', '56639', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56640', '3', '56635', '荣县', '510321', '56640', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56641', '3', '56635', '富顺县', '510322', '56641', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56642', '3', '56613', '攀枝花市', '510400', '56642', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56643', '3', '56642', '东区', '510402', '56643', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56644', '3', '56642', '西区', '510403', '56644', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56645', '3', '56642', '仁和区', '510411', '56645', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56646', '3', '56642', '米易县', '510421', '56646', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56647', '3', '56642', '盐边县', '510422', '56647', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56648', '3', '56613', '泸州市', '510500', '56648', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56649', '3', '56648', '江阳区', '510502', '56649', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56650', '3', '56648', '纳溪区', '510503', '56650', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56651', '3', '56648', '龙马潭区', '510504', '56651', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56652', '3', '56648', '泸县', '510521', '56652', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56653', '3', '56648', '合江县', '510522', '56653', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56654', '3', '56648', '叙永县', '510524', '56654', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56655', '3', '56648', '古蔺县', '510525', '56655', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56656', '3', '56613', '德阳市', '510600', '56656', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56657', '3', '56656', '旌阳区', '510603', '56657', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56658', '3', '56656', '中江县', '510623', '56658', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56659', '3', '56656', '罗江县', '510626', '56659', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56660', '3', '56656', '广汉市', '510681', '56660', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56661', '3', '56656', '什邡市', '510682', '56661', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56662', '3', '56656', '绵竹市', '510683', '56662', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56663', '3', '56613', '绵阳市', '510700', '56663', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56664', '3', '56663', '涪城区', '510703', '56664', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56665', '3', '56663', '游仙区', '510704', '56665', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56666', '3', '56663', '高新区', '510705', '56666', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56667', '3', '56663', '科学城', '510706', '56667', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56668', '3', '56663', '三台县', '510722', '56668', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56669', '3', '56663', '盐亭县', '510723', '56669', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56670', '3', '56663', '安县', '510724', '56670', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56671', '3', '56663', '梓潼县', '510725', '56671', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56672', '3', '56663', '北川羌族自治县', '510726', '56672', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56673', '3', '56663', '平武县', '510727', '56673', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56674', '3', '56663', '江油市', '510781', '56674', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56675', '3', '56613', '广元市', '510800', '56675', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56676', '3', '56675', '利州区', '510802', '56676', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56677', '3', '56675', '元坝区', '510811', '56677', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56678', '3', '56675', '朝天区', '510812', '56678', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56679', '3', '56675', '旺苍县', '510821', '56679', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56680', '3', '56675', '青川县', '510822', '56680', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56681', '3', '56675', '剑阁县', '510823', '56681', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56682', '3', '56675', '苍溪县', '510824', '56682', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56683', '3', '56613', '遂宁市', '510900', '56683', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56684', '3', '56683', '船山区', '510903', '56684', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56685', '3', '56683', '安居区', '510904', '56685', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56686', '3', '56683', '蓬溪县', '510921', '56686', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56687', '3', '56683', '射洪县', '510922', '56687', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56688', '3', '56683', '大英县', '510923', '56688', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56689', '3', '56613', '内江市', '511000', '56689', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56690', '3', '56689', '市中区', '511002', '56690', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56691', '3', '56689', '东兴区', '511011', '56691', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56692', '3', '56689', '威远县', '511024', '56692', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56693', '3', '56689', '资中县', '511025', '56693', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56694', '3', '56689', '隆昌县', '511028', '56694', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56695', '3', '56613', '乐山市', '511100', '56695', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56696', '3', '56695', '市中区', '511102', '56696', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56697', '3', '56695', '沙湾区', '511111', '56697', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56698', '3', '56695', '五通桥区', '511112', '56698', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56699', '3', '56695', '金口河区', '511113', '56699', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56700', '3', '56695', '犍为县', '511123', '56700', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56701', '3', '56695', '井研县', '511124', '56701', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56702', '3', '56695', '夹江县', '511126', '56702', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56703', '3', '56695', '沐川县', '511129', '56703', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56704', '3', '56695', '峨边彝族自治县', '511132', '56704', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56705', '3', '56695', '马边彝族自治县', '511133', '56705', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56706', '3', '56695', '峨眉山市', '511181', '56706', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56707', '3', '56613', '南充市', '511300', '56707', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56708', '3', '56707', '顺庆区', '511302', '56708', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56709', '3', '56707', '高坪区', '511303', '56709', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56710', '3', '56707', '嘉陵区', '511304', '56710', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56711', '3', '56707', '南部县', '511321', '56711', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56712', '3', '56707', '营山县', '511322', '56712', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56713', '3', '56707', '蓬安县', '511323', '56713', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56714', '3', '56707', '仪陇县', '511324', '56714', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56715', '3', '56707', '西充县', '511325', '56715', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56716', '3', '56707', '阆中市', '511381', '56716', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56717', '3', '56613', '眉山市', '511400', '56717', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56718', '3', '56717', '东坡区', '511402', '56718', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56719', '3', '56717', '仁寿县', '511421', '56719', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56720', '3', '56717', '彭山县', '511422', '56720', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56721', '3', '56717', '洪雅县', '511423', '56721', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56722', '3', '56717', '丹棱县', '511424', '56722', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56723', '3', '56717', '青神县', '511425', '56723', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56724', '3', '56613', '宜宾市', '511500', '56724', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56725', '3', '56724', '翠屏区', '511502', '56725', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56726', '3', '56724', '宜宾县', '511521', '56726', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56727', '3', '56724', '南溪县', '511522', '56727', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56728', '3', '56724', '江安县', '511523', '56728', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56729', '3', '56724', '长宁县', '511524', '56729', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56730', '3', '56724', '高县', '511525', '56730', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56731', '3', '56724', '珙县', '511526', '56731', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56732', '3', '56724', '筠连县', '511527', '56732', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56733', '3', '56724', '兴文县', '511528', '56733', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56734', '3', '56724', '屏山县', '511529', '56734', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56735', '3', '56613', '广安市', '511600', '56735', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56736', '3', '56735', '广安区', '511602', '56736', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56737', '3', '56735', '岳池县', '511621', '56737', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56738', '3', '56735', '武胜县', '511622', '56738', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56739', '3', '56735', '邻水县', '511623', '56739', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56740', '3', '56735', '华蓥市', '511681', '56740', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56741', '3', '56613', '达州市', '511700', '56741', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56742', '3', '56741', '通川区', '511702', '56742', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56743', '3', '56741', '达县', '511721', '56743', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56744', '3', '56741', '宣汉县', '511722', '56744', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56745', '3', '56741', '开江县', '511723', '56745', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56746', '3', '56741', '大竹县', '511724', '56746', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56747', '3', '56741', '渠县', '511725', '56747', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56748', '3', '56741', '万源市', '511781', '56748', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56749', '3', '56613', '雅安市', '511800', '56749', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56750', '3', '56749', '雨城区', '511802', '56750', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56751', '3', '56749', '名山县', '511821', '56751', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56752', '3', '56749', '荥经县', '511822', '56752', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56753', '3', '56749', '汉源县', '511823', '56753', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56754', '3', '56749', '石棉县', '511824', '56754', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56755', '3', '56749', '天全县', '511825', '56755', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56756', '3', '56749', '芦山县', '511826', '56756', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56757', '3', '56749', '宝兴县', '511827', '56757', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56758', '3', '56613', '巴中市', '511900', '56758', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56759', '3', '56758', '巴州区', '511902', '56759', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56760', '3', '56758', '通江县', '511921', '56760', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56761', '3', '56758', '南江县', '511922', '56761', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56762', '3', '56758', '平昌县', '511923', '56762', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56763', '3', '56613', '资阳市', '512000', '56763', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56764', '3', '56763', '雁江区', '512002', '56764', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56765', '3', '56763', '安岳县', '512021', '56765', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56766', '3', '56763', '乐至县', '512022', '56766', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56767', '3', '56763', '简阳市', '512081', '56767', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56768', '3', '56613', '阿坝藏族羌族自治州', '513200', '56768', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56769', '3', '56768', '汶川县', '513221', '56769', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56770', '3', '56768', '理县', '513222', '56770', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56771', '3', '56768', '茂县', '513223', '56771', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56772', '3', '56768', '松潘县', '513224', '56772', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56773', '3', '56768', '九寨沟县', '513225', '56773', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56774', '3', '56768', '金川县', '513226', '56774', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56775', '3', '56768', '小金县', '513227', '56775', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56776', '3', '56768', '黑水县', '513228', '56776', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56777', '3', '56768', '马尔康县', '513229', '56777', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56778', '3', '56768', '壤塘县', '513230', '56778', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56779', '3', '56768', '阿坝县', '513231', '56779', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56780', '3', '56768', '若尔盖县', '513232', '56780', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56781', '3', '56768', '红原县', '513233', '56781', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56782', '3', '56613', '甘孜藏族自治州', '513300', '56782', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56783', '3', '56782', '康定县', '513321', '56783', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56784', '3', '56782', '泸定县', '513322', '56784', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56785', '3', '56782', '丹巴县', '513323', '56785', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56786', '3', '56782', '九龙县', '513324', '56786', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56787', '3', '56782', '雅江县', '513325', '56787', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56788', '3', '56782', '道孚县', '513326', '56788', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56789', '3', '56782', '炉霍县', '513327', '56789', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56790', '3', '56782', '甘孜县', '513328', '56790', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56791', '3', '56782', '新龙县', '513329', '56791', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56792', '3', '56782', '德格县', '513330', '56792', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56793', '3', '56782', '白玉县', '513331', '56793', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56794', '3', '56782', '石渠县', '513332', '56794', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56795', '3', '56782', '色达县', '513333', '56795', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56796', '3', '56782', '理塘县', '513334', '56796', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56797', '3', '56782', '巴塘县', '513335', '56797', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56798', '3', '56782', '乡城县', '513336', '56798', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56799', '3', '56782', '稻城县', '513337', '56799', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56800', '3', '56782', '得荣县', '513338', '56800', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56801', '3', '56613', '凉山彝族自治州', '513400', '56801', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56802', '3', '56801', '西昌市', '513401', '56802', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56803', '3', '56801', '木里藏族自治县', '513422', '56803', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56804', '3', '56801', '盐源县', '513423', '56804', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56805', '3', '56801', '德昌县', '513424', '56805', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56806', '3', '56801', '会理县', '513425', '56806', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56807', '3', '56801', '会东县', '513426', '56807', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56808', '3', '56801', '宁南县', '513427', '56808', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56809', '3', '56801', '普格县', '513428', '56809', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56810', '3', '56801', '布拖县', '513429', '56810', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56811', '3', '56801', '金阳县', '513430', '56811', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56812', '3', '56801', '昭觉县', '513431', '56812', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56813', '3', '56801', '喜德县', '513432', '56813', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56814', '3', '56801', '冕宁县', '513433', '56814', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56815', '3', '56801', '越西县', '513434', '56815', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56816', '3', '56801', '甘洛县', '513435', '56816', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56817', '3', '56801', '美姑县', '513436', '56817', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56818', '3', '56801', '雷波县', '513437', '56818', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56819', '3', '54317', '贵州省', '520000', '56819', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56820', '3', '56819', '贵阳市', '520100', '56820', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56821', '3', '56820', '南明区', '520102', '56821', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56822', '3', '56820', '云岩区', '520103', '56822', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56823', '3', '56820', '花溪区', '520111', '56823', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56824', '3', '56820', '乌当区', '520112', '56824', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56825', '3', '56820', '白云区', '520113', '56825', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56826', '3', '56820', '小河区', '520114', '56826', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56827', '3', '56820', '开阳县', '520121', '56827', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56828', '3', '56820', '息烽县', '520122', '56828', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56829', '3', '56820', '修文县', '520123', '56829', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56830', '3', '56820', '清镇市', '520181', '56830', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56831', '3', '56819', '六盘水市', '520200', '56831', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56832', '3', '56831', '钟山区', '520201', '56832', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56833', '3', '56831', '六枝特区', '520203', '56833', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56834', '3', '56831', '水城县', '520221', '56834', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56835', '3', '56831', '盘县', '520222', '56835', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56836', '3', '56819', '遵义市', '520300', '56836', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56837', '3', '56836', '红花岗区', '520302', '56837', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56838', '3', '56836', '汇川区', '520303', '56838', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56839', '3', '56836', '遵义县', '520321', '56839', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56840', '3', '56836', '桐梓县', '520322', '56840', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56841', '3', '56836', '绥阳县', '520323', '56841', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56842', '3', '56836', '正安县', '520324', '56842', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56843', '3', '56836', '道真仡佬族苗族自治县', '520325', '56843', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56844', '3', '56836', '务川仡佬族苗族自治县', '520326', '56844', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56845', '3', '56836', '凤冈县', '520327', '56845', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56846', '3', '56836', '湄潭县', '520328', '56846', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56847', '3', '56836', '余庆县', '520329', '56847', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56848', '3', '56836', '习水县', '520330', '56848', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56849', '3', '56836', '赤水市', '520381', '56849', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56850', '3', '56836', '仁怀市', '520382', '56850', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56851', '3', '56819', '安顺市', '520400', '56851', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56852', '3', '56851', '西秀区', '520402', '56852', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56853', '3', '56851', '平坝县', '520421', '56853', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56854', '3', '56851', '普定县', '520422', '56854', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56855', '3', '56851', '镇宁布依族苗族自治县', '520423', '56855', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56856', '3', '56851', '关岭布依族苗族自治县', '520424', '56856', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56857', '3', '56851', '紫云苗族布依族自治县', '520425', '56857', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56858', '3', '56819', '铜仁地区', '522200', '56858', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56859', '3', '56858', '铜仁市', '522201', '56859', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56860', '3', '56858', '江口县', '522222', '56860', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56861', '3', '56858', '玉屏侗族自治县', '522223', '56861', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56862', '3', '56858', '石阡县', '522224', '56862', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56863', '3', '56858', '思南县', '522225', '56863', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56864', '3', '56858', '印江土家族苗族自治县', '522226', '56864', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56865', '3', '56858', '德江县', '522227', '56865', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56866', '3', '56858', '沿河土家族自治县', '522228', '56866', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56867', '3', '56858', '松桃苗族自治县', '522229', '56867', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56868', '3', '56858', '万山特区', '522230', '56868', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56869', '3', '56819', '黔西南布依族苗族自治州', '522300', '56869', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56870', '3', '56869', '兴义市', '522301', '56870', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56871', '3', '56869', '兴仁县', '522322', '56871', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56872', '3', '56869', '普安县', '522323', '56872', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56873', '3', '56869', '晴隆县', '522324', '56873', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56874', '3', '56869', '贞丰县', '522325', '56874', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56875', '3', '56869', '望谟县', '522326', '56875', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56876', '3', '56869', '册亨县', '522327', '56876', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56877', '3', '56869', '安龙县', '522328', '56877', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56878', '3', '56819', '毕节地区', '522400', '56878', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56879', '3', '56878', '毕节市', '522401', '56879', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56880', '3', '56878', '大方县', '522422', '56880', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56881', '3', '56878', '黔西县', '522423', '56881', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56882', '3', '56878', '金沙县', '522424', '56882', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56883', '3', '56878', '织金县', '522425', '56883', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56884', '3', '56878', '纳雍县', '522426', '56884', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56885', '3', '56878', '威宁彝族回族苗族自治县', '522427', '56885', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56886', '3', '56878', '赫章县', '522428', '56886', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56887', '3', '56819', '黔东南苗族侗族自治州', '522600', '56887', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56888', '3', '56887', '凯里市', '522601', '56888', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56889', '3', '56887', '黄平县', '522622', '56889', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56890', '3', '56887', '施秉县', '522623', '56890', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56891', '3', '56887', '三穗县', '522624', '56891', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56892', '3', '56887', '镇远县', '522625', '56892', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56893', '3', '56887', '岑巩县', '522626', '56893', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56894', '3', '56887', '天柱县', '522627', '56894', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56895', '3', '56887', '锦屏县', '522628', '56895', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56896', '3', '56887', '剑河县', '522629', '56896', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56897', '3', '56887', '台江县', '522630', '56897', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56898', '3', '56887', '黎平县', '522631', '56898', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56899', '3', '56887', '榕江县', '522632', '56899', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56900', '3', '56887', '从江县', '522633', '56900', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56901', '3', '56887', '雷山县', '522634', '56901', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56902', '3', '56887', '麻江县', '522635', '56902', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56903', '3', '56887', '丹寨县', '522636', '56903', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56904', '3', '56819', '黔南布依族苗族自治州', '522700', '56904', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56905', '3', '56904', '都匀市', '522701', '56905', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56906', '3', '56904', '福泉市', '522702', '56906', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56907', '3', '56904', '荔波县', '522722', '56907', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56908', '3', '56904', '贵定县', '522723', '56908', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56909', '3', '56904', '瓮安县', '522725', '56909', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56910', '3', '56904', '独山县', '522726', '56910', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56911', '3', '56904', '平塘县', '522727', '56911', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56912', '3', '56904', '罗甸县', '522728', '56912', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56913', '3', '56904', '长顺县', '522729', '56913', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56914', '3', '56904', '龙里县', '522730', '56914', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56915', '3', '56904', '惠水县', '522731', '56915', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56916', '3', '56904', '三都水族自治县', '522732', '56916', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56917', '3', '54317', '云南省', '530000', '56917', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56918', '3', '56917', '昆明市', '530100', '56918', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56919', '3', '56918', '五华区', '530102', '56919', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56920', '3', '56918', '盘龙区', '530103', '56920', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56921', '3', '56918', '官渡区', '530111', '56921', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56922', '3', '56918', '西山区', '530112', '56922', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56923', '3', '56918', '东川区', '530113', '56923', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56924', '3', '56918', '呈贡县', '530121', '56924', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56925', '3', '56918', '晋宁县', '530122', '56925', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56926', '3', '56918', '富民县', '530124', '56926', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56927', '3', '56918', '宜良县', '530125', '56927', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56928', '3', '56918', '石林彝族自治县', '530126', '56928', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56929', '3', '56918', '嵩明县', '530127', '56929', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56930', '3', '56918', '禄劝彝族苗族自治县', '530128', '56930', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56931', '3', '56918', '寻甸回族彝族自治县', '530129', '56931', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56932', '3', '56918', '安宁市', '530181', '56932', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56933', '3', '56917', '曲靖市', '530300', '56933', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56934', '3', '56933', '麒麟区', '530302', '56934', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56935', '3', '56933', '马龙县', '530321', '56935', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56936', '3', '56933', '陆良县', '530322', '56936', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56937', '3', '56933', '师宗县', '530323', '56937', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56938', '3', '56933', '罗平县', '530324', '56938', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56939', '3', '56933', '富源县', '530325', '56939', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56940', '3', '56933', '会泽县', '530326', '56940', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56941', '3', '56933', '沾益县', '530328', '56941', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56942', '3', '56933', '宣威市', '530381', '56942', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56943', '3', '56917', '玉溪市', '530400', '56943', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56944', '3', '56943', '红塔区', '530402', '56944', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56945', '3', '56943', '江川县', '530421', '56945', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56946', '3', '56943', '澄江县', '530422', '56946', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56947', '3', '56943', '通海县', '530423', '56947', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56948', '3', '56943', '华宁县', '530424', '56948', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56949', '3', '56943', '易门县', '530425', '56949', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56950', '3', '56943', '峨山彝族自治县', '530426', '56950', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56951', '3', '56943', '新平彝族傣族自治县', '530427', '56951', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56952', '3', '56943', '元江哈尼族彝族傣族自治县', '530428', '56952', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56953', '3', '56917', '保山市', '530500', '56953', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56954', '3', '56953', '隆阳区', '530502', '56954', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56955', '3', '56953', '施甸县', '530521', '56955', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56956', '3', '56953', '腾冲县', '530522', '56956', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56957', '3', '56953', '龙陵县', '530523', '56957', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56958', '3', '56953', '昌宁县', '530524', '56958', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56959', '3', '56917', '昭通市', '530600', '56959', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56960', '3', '56959', '昭阳区', '530602', '56960', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56961', '3', '56959', '鲁甸县', '530621', '56961', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56962', '3', '56959', '巧家县', '530622', '56962', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56963', '3', '56959', '盐津县', '530623', '56963', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56964', '3', '56959', '大关县', '530624', '56964', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56965', '3', '56959', '永善县', '530625', '56965', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56966', '3', '56959', '绥江县', '530626', '56966', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56967', '3', '56959', '镇雄县', '530627', '56967', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56968', '3', '56959', '彝良县', '530628', '56968', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56969', '3', '56959', '威信县', '530629', '56969', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56970', '3', '56959', '水富县', '530630', '56970', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56971', '3', '56917', '丽江市', '530700', '56971', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56972', '3', '56971', '古城区', '530702', '56972', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56973', '3', '56971', '玉龙纳西族自治县', '530721', '56973', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56974', '3', '56971', '永胜县', '530722', '56974', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56975', '3', '56971', '华坪县', '530723', '56975', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56976', '3', '56971', '宁蒗彝族自治县', '530724', '56976', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56977', '3', '56917', '普洱市', '530800', '56977', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56978', '3', '56977', '思茅区', '530802', '56978', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56979', '3', '56977', '宁洱哈尼族彝族自治县', '530821', '56979', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56980', '3', '56977', '墨江哈尼族自治县', '530822', '56980', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56981', '3', '56977', '景东彝族自治县', '530823', '56981', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56982', '3', '56977', '景谷傣族彝族自治县', '530824', '56982', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56983', '3', '56977', '镇沅彝族哈尼族拉祜族自治县', '530825', '56983', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56984', '3', '56977', '江城哈尼族彝族自治县', '530826', '56984', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56985', '3', '56977', '孟连傣族拉祜族佤族自治县', '530827', '56985', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56986', '3', '56977', '澜沧拉祜族自治县', '530828', '56986', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56987', '3', '56977', '西盟佤族自治县', '530829', '56987', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56988', '3', '56917', '临沧市', '530900', '56988', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56989', '3', '56988', '临翔区', '530902', '56989', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56990', '3', '56988', '凤庆县', '530921', '56990', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56991', '3', '56988', '云县', '530922', '56991', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56992', '3', '56988', '永德县', '530923', '56992', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56993', '3', '56988', '镇康县', '530924', '56993', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56994', '3', '56988', '双江拉祜族佤族布朗族傣族自治县', '530925', '56994', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56995', '3', '56988', '耿马傣族佤族自治县', '530926', '56995', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56996', '3', '56988', '沧源佤族自治县', '530927', '56996', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56997', '3', '56917', '楚雄彝族自治州', '532300', '56997', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56998', '3', '56997', '楚雄市', '532301', '56998', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('56999', '3', '56997', '双柏县', '532322', '56999', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57000', '3', '56997', '牟定县', '532323', '57000', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57001', '3', '56997', '南华县', '532324', '57001', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57002', '3', '56997', '姚安县', '532325', '57002', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57003', '3', '56997', '大姚县', '532326', '57003', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57004', '3', '56997', '永仁县', '532327', '57004', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57005', '3', '56997', '元谋县', '532328', '57005', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57006', '3', '56997', '武定县', '532329', '57006', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57007', '3', '56997', '禄丰县', '532331', '57007', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57008', '3', '56917', '红河哈尼族彝族自治州', '532500', '57008', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57009', '3', '57008', '个旧市', '532501', '57009', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57010', '3', '57008', '开远市', '532502', '57010', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57011', '3', '57008', '蒙自县', '532522', '57011', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57012', '3', '57008', '屏边苗族自治县', '532523', '57012', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57013', '3', '57008', '建水县', '532524', '57013', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57014', '3', '57008', '石屏县', '532525', '57014', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57015', '3', '57008', '弥勒县', '532526', '57015', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57016', '3', '57008', '泸西县', '532527', '57016', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57017', '3', '57008', '元阳县', '532528', '57017', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57018', '3', '57008', '红河县', '532529', '57018', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57019', '3', '57008', '金平苗族瑶族傣族自治县', '532530', '57019', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57020', '3', '57008', '绿春县', '532531', '57020', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57021', '3', '57008', '河口瑶族自治县', '532532', '57021', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57022', '3', '56917', '文山壮族苗族自治州', '532600', '57022', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57023', '3', '57022', '文山县', '532621', '57023', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57024', '3', '57022', '砚山县', '532622', '57024', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57025', '3', '57022', '西畴县', '532623', '57025', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57026', '3', '57022', '麻栗坡县', '532624', '57026', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57027', '3', '57022', '马关县', '532625', '57027', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57028', '3', '57022', '丘北县', '532626', '57028', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57029', '3', '57022', '广南县', '532627', '57029', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57030', '3', '57022', '富宁县', '532628', '57030', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57031', '3', '56917', '西双版纳傣族自治州', '532800', '57031', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57032', '3', '57031', '景洪市', '532801', '57032', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57033', '3', '57031', '勐海县', '532822', '57033', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57034', '3', '57031', '勐腊县', '532823', '57034', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57035', '3', '56917', '大理白族自治州', '532900', '57035', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57036', '3', '57035', '大理市', '532901', '57036', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57037', '3', '57035', '漾濞彝族自治县', '532922', '57037', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57038', '3', '57035', '祥云县', '532923', '57038', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57039', '3', '57035', '宾川县', '532924', '57039', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57040', '3', '57035', '弥渡县', '532925', '57040', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57041', '3', '57035', '南涧彝族自治县', '532926', '57041', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57042', '3', '57035', '巍山彝族回族自治县', '532927', '57042', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57043', '3', '57035', '永平县', '532928', '57043', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57044', '3', '57035', '云龙县', '532929', '57044', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57045', '3', '57035', '洱源县', '532930', '57045', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57046', '3', '57035', '剑川县', '532931', '57046', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57047', '3', '57035', '鹤庆县', '532932', '57047', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57048', '3', '56917', '德宏傣族景颇族自治州', '533100', '57048', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57049', '3', '57048', '瑞丽市', '533102', '57049', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57050', '3', '57048', '潞西市', '533103', '57050', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57051', '3', '57048', '梁河县', '533122', '57051', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57052', '3', '57048', '盈江县', '533123', '57052', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57053', '3', '57048', '陇川县', '533124', '57053', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57054', '3', '56917', '怒江傈僳族自治州', '533300', '57054', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57055', '3', '57054', '泸水县', '533321', '57055', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57056', '3', '57054', '福贡县', '533323', '57056', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57057', '3', '57054', '贡山独龙族怒族自治县', '533324', '57057', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57058', '3', '57054', '兰坪白族普米族自治县', '533325', '57058', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57059', '3', '56917', '迪庆藏族自治州', '533400', '57059', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57060', '3', '57059', '香格里拉县', '533421', '57060', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57061', '3', '57059', '德钦县', '533422', '57061', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57062', '3', '57059', '维西傈僳族自治县', '533423', '57062', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57063', '3', '54317', '西藏自治区', '540000', '57063', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57064', '3', '57063', '拉萨市', '540100', '57064', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57065', '3', '57064', '城关区', '540102', '57065', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57066', '3', '57064', '林周县', '540121', '57066', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57067', '3', '57064', '当雄县', '540122', '57067', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57068', '3', '57064', '尼木县', '540123', '57068', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57069', '3', '57064', '曲水县', '540124', '57069', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57070', '3', '57064', '堆龙德庆县', '540125', '57070', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57071', '3', '57064', '达孜县', '540126', '57071', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57072', '3', '57064', '墨竹工卡县', '540127', '57072', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57073', '3', '57063', '昌都地区', '542100', '57073', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57074', '3', '57073', '昌都县', '542121', '57074', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57075', '3', '57073', '江达县', '542122', '57075', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57076', '3', '57073', '贡觉县', '542123', '57076', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57077', '3', '57073', '类乌齐县', '542124', '57077', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57078', '3', '57073', '丁青县', '542125', '57078', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57079', '3', '57073', '察雅县', '542126', '57079', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57080', '3', '57073', '八宿县', '542127', '57080', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57081', '3', '57073', '左贡县', '542128', '57081', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57082', '3', '57073', '芒康县', '542129', '57082', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57083', '3', '57073', '洛隆县', '542132', '57083', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57084', '3', '57073', '边坝县', '542133', '57084', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57085', '3', '57063', '山南地区', '542200', '57085', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57086', '3', '57085', '乃东县', '542221', '57086', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57087', '3', '57085', '扎囊县', '542222', '57087', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57088', '3', '57085', '贡嘎县', '542223', '57088', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57089', '3', '57085', '桑日县', '542224', '57089', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57090', '3', '57085', '琼结县', '542225', '57090', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57091', '3', '57085', '曲松县', '542226', '57091', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57092', '3', '57085', '措美县', '542227', '57092', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57093', '3', '57085', '洛扎县', '542228', '57093', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57094', '3', '57085', '加查县', '542229', '57094', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57095', '3', '57085', '隆子县', '542231', '57095', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57096', '3', '57085', '错那县', '542232', '57096', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57097', '3', '57085', '浪卡子县', '542233', '57097', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57098', '3', '57063', '日喀则地区', '542300', '57098', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57099', '3', '57098', '日喀则市', '542301', '57099', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57100', '3', '57098', '南木林县', '542322', '57100', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57101', '3', '57098', '江孜县', '542323', '57101', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57102', '3', '57098', '定日县', '542324', '57102', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57103', '3', '57098', '萨迦县', '542325', '57103', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57104', '3', '57098', '拉孜县', '542326', '57104', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57105', '3', '57098', '昂仁县', '542327', '57105', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57106', '3', '57098', '谢通门县', '542328', '57106', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57107', '3', '57098', '白朗县', '542329', '57107', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57108', '3', '57098', '仁布县', '542330', '57108', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57109', '3', '57098', '康马县', '542331', '57109', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57110', '3', '57098', '定结县', '542332', '57110', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57111', '3', '57098', '仲巴县', '542333', '57111', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57112', '3', '57098', '亚东县', '542334', '57112', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57113', '3', '57098', '吉隆县', '542335', '57113', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57114', '3', '57098', '聂拉木县', '542336', '57114', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57115', '3', '57098', '萨嘎县', '542337', '57115', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57116', '3', '57098', '岗巴县', '542338', '57116', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57117', '3', '57063', '那曲地区', '542400', '57117', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57118', '3', '57117', '那曲县', '542421', '57118', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57119', '3', '57117', '嘉黎县', '542422', '57119', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57120', '3', '57117', '比如县', '542423', '57120', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57121', '3', '57117', '聂荣县', '542424', '57121', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57122', '3', '57117', '安多县', '542425', '57122', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57123', '3', '57117', '申扎县', '542426', '57123', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57124', '3', '57117', '索县', '542427', '57124', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57125', '3', '57117', '班戈县', '542428', '57125', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57126', '3', '57117', '巴青县', '542429', '57126', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57127', '3', '57117', '尼玛县', '542430', '57127', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57128', '3', '57063', '阿里地区', '542500', '57128', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57129', '3', '57128', '普兰县', '542521', '57129', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57130', '3', '57128', '札达县', '542522', '57130', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57131', '3', '57128', '噶尔县', '542523', '57131', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57132', '3', '57128', '日土县', '542524', '57132', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57133', '3', '57128', '革吉县', '542525', '57133', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57134', '3', '57128', '改则县', '542526', '57134', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57135', '3', '57128', '措勤县', '542527', '57135', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57136', '3', '57063', '林芝地区', '542600', '57136', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57137', '3', '57136', '林芝县', '542621', '57137', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57138', '3', '57136', '工布江达县', '542622', '57138', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57139', '3', '57136', '米林县', '542623', '57139', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57140', '3', '57136', '墨脱县', '542624', '57140', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57141', '3', '57136', '波密县', '542625', '57141', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57142', '3', '57136', '察隅县', '542626', '57142', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57143', '3', '57136', '朗县', '542627', '57143', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57144', '3', '54317', '陕西省', '610000', '57144', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57145', '3', '57144', '西安市', '610100', '57145', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57146', '3', '57145', '新城区', '610102', '57146', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57147', '3', '57145', '碑林区', '610103', '57147', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57148', '3', '57145', '莲湖区', '610104', '57148', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57149', '3', '57145', '灞桥区', '610111', '57149', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57150', '3', '57145', '未央区', '610112', '57150', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57151', '3', '57145', '雁塔区', '610113', '57151', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57152', '3', '57145', '阎良区', '610114', '57152', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57153', '3', '57145', '临潼区', '610115', '57153', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57154', '3', '57145', '长安区', '610116', '57154', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57155', '3', '57145', '蓝田县', '610122', '57155', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57156', '3', '57145', '周至县', '610124', '57156', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57157', '3', '57145', '户县', '610125', '57157', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57158', '3', '57145', '高陵县', '610126', '57158', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57159', '3', '57144', '铜川市', '610200', '57159', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57160', '3', '57159', '王益区', '610202', '57160', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57161', '3', '57159', '印台区', '610203', '57161', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57162', '3', '57159', '耀州区', '610204', '57162', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57163', '3', '57159', '宜君县', '610222', '57163', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57164', '3', '57144', '宝鸡市', '610300', '57164', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57165', '3', '57164', '渭滨区', '610302', '57165', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57166', '3', '57164', '金台区', '610303', '57166', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57167', '3', '57164', '陈仓区', '610304', '57167', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57168', '3', '57164', '凤翔县', '610322', '57168', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57169', '3', '57164', '岐山县', '610323', '57169', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57170', '3', '57164', '扶风县', '610324', '57170', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57171', '3', '57164', '眉县', '610326', '57171', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57172', '3', '57164', '陇县', '610327', '57172', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57173', '3', '57164', '千阳县', '610328', '57173', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57174', '3', '57164', '麟游县', '610329', '57174', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57175', '3', '57164', '凤县', '610330', '57175', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57176', '3', '57164', '太白县', '610331', '57176', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57177', '3', '57144', '咸阳市', '610400', '57177', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57178', '3', '57177', '秦都区', '610402', '57178', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57179', '3', '57177', '杨凌区', '610403', '57179', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57180', '3', '57177', '渭城区', '610404', '57180', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57181', '3', '57177', '三原县', '610422', '57181', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57182', '3', '57177', '泾阳县', '610423', '57182', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57183', '3', '57177', '乾县', '610424', '57183', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57184', '3', '57177', '礼泉县', '610425', '57184', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57185', '3', '57177', '永寿县', '610426', '57185', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57186', '3', '57177', '彬县', '610427', '57186', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57187', '3', '57177', '长武县', '610428', '57187', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57188', '3', '57177', '旬邑县', '610429', '57188', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57189', '3', '57177', '淳化县', '610430', '57189', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57190', '3', '57177', '武功县', '610431', '57190', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57191', '3', '57177', '兴平市', '610481', '57191', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57192', '3', '57144', '渭南市', '610500', '57192', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57193', '3', '57192', '临渭区', '610502', '57193', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57194', '3', '57192', '华县', '610521', '57194', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57195', '3', '57192', '潼关县', '610522', '57195', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57196', '3', '57192', '大荔县', '610523', '57196', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57197', '3', '57192', '合阳县', '610524', '57197', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57198', '3', '57192', '澄城县', '610525', '57198', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57199', '3', '57192', '蒲城县', '610526', '57199', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57200', '3', '57192', '白水县', '610527', '57200', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57201', '3', '57192', '富平县', '610528', '57201', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57202', '3', '57192', '韩城市', '610581', '57202', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57203', '3', '57192', '华阴市', '610582', '57203', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57204', '3', '57144', '延安市', '610600', '57204', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57205', '3', '57204', '宝塔区', '610602', '57205', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57206', '3', '57204', '延长县', '610621', '57206', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57207', '3', '57204', '延川县', '610622', '57207', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57208', '3', '57204', '子长县', '610623', '57208', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57209', '3', '57204', '安塞县', '610624', '57209', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57210', '3', '57204', '志丹县', '610625', '57210', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57211', '3', '57204', '吴起县', '610626', '57211', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57212', '3', '57204', '甘泉县', '610627', '57212', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57213', '3', '57204', '富县', '610628', '57213', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57214', '3', '57204', '洛川县', '610629', '57214', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57215', '3', '57204', '宜川县', '610630', '57215', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57216', '3', '57204', '黄龙县', '610631', '57216', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57217', '3', '57204', '黄陵县', '610632', '57217', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57218', '3', '57144', '汉中市', '610700', '57218', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57219', '3', '57218', '汉台区', '610702', '57219', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57220', '3', '57218', '南郑县', '610721', '57220', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57221', '3', '57218', '城固县', '610722', '57221', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57222', '3', '57218', '洋县', '610723', '57222', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57223', '3', '57218', '西乡县', '610724', '57223', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57224', '3', '57218', '勉县', '610725', '57224', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57225', '3', '57218', '宁强县', '610726', '57225', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57226', '3', '57218', '略阳县', '610727', '57226', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57227', '3', '57218', '镇巴县', '610728', '57227', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57228', '3', '57218', '留坝县', '610729', '57228', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57229', '3', '57218', '佛坪县', '610730', '57229', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57230', '3', '57144', '榆林市', '610800', '57230', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57231', '3', '57230', '榆阳区', '610802', '57231', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57232', '3', '57230', '神木县', '610821', '57232', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57233', '3', '57230', '府谷县', '610822', '57233', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57234', '3', '57230', '横山县', '610823', '57234', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57235', '3', '57230', '靖边县', '610824', '57235', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57236', '3', '57230', '定边县', '610825', '57236', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57237', '3', '57230', '绥德县', '610826', '57237', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57238', '3', '57230', '米脂县', '610827', '57238', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57239', '3', '57230', '佳县', '610828', '57239', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57240', '3', '57230', '吴堡县', '610829', '57240', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57241', '3', '57230', '清涧县', '610830', '57241', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57242', '3', '57230', '子洲县', '610831', '57242', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57243', '3', '57144', '安康市', '610900', '57243', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57244', '3', '57243', '汉滨区', '610902', '57244', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57245', '3', '57243', '汉阴县', '610921', '57245', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57246', '3', '57243', '石泉县', '610922', '57246', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57247', '3', '57243', '宁陕县', '610923', '57247', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57248', '3', '57243', '紫阳县', '610924', '57248', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57249', '3', '57243', '岚皋县', '610925', '57249', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57250', '3', '57243', '平利县', '610926', '57250', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57251', '3', '57243', '镇坪县', '610927', '57251', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57252', '3', '57243', '旬阳县', '610928', '57252', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57253', '3', '57243', '白河县', '610929', '57253', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57254', '3', '57144', '商洛市', '611000', '57254', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57255', '3', '57254', '商州区', '611002', '57255', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57256', '3', '57254', '洛南县', '611021', '57256', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57257', '3', '57254', '丹凤县', '611022', '57257', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57258', '3', '57254', '商南县', '611023', '57258', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57259', '3', '57254', '山阳县', '611024', '57259', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57260', '3', '57254', '镇安县', '611025', '57260', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57261', '3', '57254', '柞水县', '611026', '57261', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57262', '3', '54317', '甘肃省', '620000', '57262', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57263', '3', '57262', '兰州市', '620100', '57263', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57264', '3', '57263', '城关区', '620102', '57264', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57265', '3', '57263', '七里河区', '620103', '57265', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57266', '3', '57263', '西固区', '620104', '57266', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57267', '3', '57263', '安宁区', '620105', '57267', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57268', '3', '57263', '红古区', '620111', '57268', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57269', '3', '57263', '永登县', '620121', '57269', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57270', '3', '57263', '皋兰县', '620122', '57270', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57271', '3', '57263', '榆中县', '620123', '57271', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57272', '3', '57262', '嘉峪关市', '620200', '57272', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57273', '3', '57262', '金昌市', '620300', '57273', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57274', '3', '57273', '金川区', '620302', '57274', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57275', '3', '57273', '永昌县', '620321', '57275', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57276', '3', '57262', '白银市', '620400', '57276', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57277', '3', '57276', '白银区', '620402', '57277', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57278', '3', '57276', '平川区', '620403', '57278', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57279', '3', '57276', '靖远县', '620421', '57279', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57280', '3', '57276', '会宁县', '620422', '57280', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57281', '3', '57276', '景泰县', '620423', '57281', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57282', '3', '57262', '天水市', '620500', '57282', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57283', '3', '57282', '秦州区', '620502', '57283', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57284', '3', '57282', '麦积区', '620503', '57284', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57285', '3', '57282', '清水县', '620521', '57285', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57286', '3', '57282', '秦安县', '620522', '57286', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57287', '3', '57282', '甘谷县', '620523', '57287', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57288', '3', '57282', '武山县', '620524', '57288', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57289', '3', '57282', '张家川回族自治县', '620525', '57289', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57290', '3', '57262', '武威市', '620600', '57290', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57291', '3', '57290', '凉州区', '620602', '57291', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57292', '3', '57290', '民勤县', '620621', '57292', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57293', '3', '57290', '古浪县', '620622', '57293', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57294', '3', '57290', '天祝藏族自治县', '620623', '57294', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57295', '3', '57262', '张掖市', '620700', '57295', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57296', '3', '57295', '甘州区', '620702', '57296', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57297', '3', '57295', '肃南裕固族自治县', '620721', '57297', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57298', '3', '57295', '民乐县', '620722', '57298', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57299', '3', '57295', '临泽县', '620723', '57299', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57300', '3', '57295', '高台县', '620724', '57300', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57301', '3', '57295', '山丹县', '620725', '57301', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57302', '3', '57262', '平凉市', '620800', '57302', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57303', '3', '57302', '崆峒区', '620802', '57303', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57304', '3', '57302', '泾川县', '620821', '57304', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57305', '3', '57302', '灵台县', '620822', '57305', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57306', '3', '57302', '崇信县', '620823', '57306', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57307', '3', '57302', '华亭县', '620824', '57307', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57308', '3', '57302', '庄浪县', '620825', '57308', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57309', '3', '57302', '静宁县', '620826', '57309', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57310', '3', '57262', '酒泉市', '620900', '57310', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57311', '3', '57310', '肃州区', '620902', '57311', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57312', '3', '57310', '金塔县', '620921', '57312', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57313', '3', '57310', '瓜州县', '620922', '57313', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57314', '3', '57310', '肃北蒙古族自治县', '620923', '57314', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57315', '3', '57310', '阿克塞哈萨克族自治县', '620924', '57315', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57316', '3', '57310', '玉门市', '620981', '57316', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57317', '3', '57310', '敦煌市', '620982', '57317', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57318', '3', '57262', '庆阳市', '621000', '57318', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57319', '3', '57318', '西峰区', '621002', '57319', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57320', '3', '57318', '庆城县', '621021', '57320', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57321', '3', '57318', '环县', '621022', '57321', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57322', '3', '57318', '华池县', '621023', '57322', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57323', '3', '57318', '合水县', '621024', '57323', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57324', '3', '57318', '正宁县', '621025', '57324', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57325', '3', '57318', '宁县', '621026', '57325', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57326', '3', '57318', '镇原县', '621027', '57326', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57327', '3', '57262', '定西市', '621100', '57327', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57328', '3', '57327', '安定区', '621102', '57328', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57329', '3', '57327', '通渭县', '621121', '57329', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57330', '3', '57327', '陇西县', '621122', '57330', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57331', '3', '57327', '渭源县', '621123', '57331', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57332', '3', '57327', '临洮县', '621124', '57332', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57333', '3', '57327', '漳县', '621125', '57333', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57334', '3', '57327', '岷县', '621126', '57334', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57335', '3', '57262', '陇南市', '621200', '57335', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57336', '3', '57335', '武都区', '621202', '57336', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57337', '3', '57335', '成县', '621221', '57337', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57338', '3', '57335', '文县', '621222', '57338', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57339', '3', '57335', '宕昌县', '621223', '57339', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57340', '3', '57335', '康县', '621224', '57340', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57341', '3', '57335', '西和县', '621225', '57341', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57342', '3', '57335', '礼县', '621226', '57342', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57343', '3', '57335', '徽县', '621227', '57343', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57344', '3', '57335', '两当县', '621228', '57344', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57345', '3', '57262', '临夏回族自治州', '622900', '57345', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57346', '3', '57345', '临夏市', '622901', '57346', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57347', '3', '57345', '临夏县', '622921', '57347', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57348', '3', '57345', '康乐县', '622922', '57348', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57349', '3', '57345', '永靖县', '622923', '57349', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57350', '3', '57345', '广河县', '622924', '57350', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57351', '3', '57345', '和政县', '622925', '57351', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57352', '3', '57345', '东乡族自治县', '622926', '57352', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57353', '3', '57345', '积石山保安族东乡族撒拉族自治县', '622927', '57353', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57354', '3', '57262', '甘南藏族自治州', '623000', '57354', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57355', '3', '57354', '合作市', '623001', '57355', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57356', '3', '57354', '临潭县', '623021', '57356', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57357', '3', '57354', '卓尼县', '623022', '57357', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57358', '3', '57354', '舟曲县', '623023', '57358', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57359', '3', '57354', '迭部县', '623024', '57359', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57360', '3', '57354', '玛曲县', '623025', '57360', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57361', '3', '57354', '碌曲县', '623026', '57361', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57362', '3', '57354', '夏河县', '623027', '57362', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57363', '3', '54317', '青海省', '630000', '57363', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57364', '3', '57363', '西宁市', '630100', '57364', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57365', '3', '57364', '城东区', '630102', '57365', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57366', '3', '57364', '城中区', '630103', '57366', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57367', '3', '57364', '城西区', '630104', '57367', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57368', '3', '57364', '城北区', '630105', '57368', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57369', '3', '57364', '大通回族土族自治县', '630121', '57369', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57370', '3', '57364', '湟中县', '630122', '57370', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57371', '3', '57364', '湟源县', '630123', '57371', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57372', '3', '57363', '海东地区', '632100', '57372', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57373', '3', '57372', '平安县', '632121', '57373', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57374', '3', '57372', '民和回族土族自治县', '632122', '57374', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57375', '3', '57372', '乐都县', '632123', '57375', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57376', '3', '57372', '互助土族自治县', '632126', '57376', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57377', '3', '57372', '化隆回族自治县', '632127', '57377', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57378', '3', '57372', '循化撒拉族自治县', '632128', '57378', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57379', '3', '57363', '海北藏族自治州', '632200', '57379', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57380', '3', '57379', '门源回族自治县', '632221', '57380', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57381', '3', '57379', '祁连县', '632222', '57381', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57382', '3', '57379', '海晏县', '632223', '57382', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57383', '3', '57379', '刚察县', '632224', '57383', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57384', '3', '57363', '黄南藏族自治州', '632300', '57384', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57385', '3', '57384', '同仁县', '632321', '57385', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57386', '3', '57384', '尖扎县', '632322', '57386', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57387', '3', '57384', '泽库县', '632323', '57387', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57388', '3', '57384', '河南蒙古族自治县', '632324', '57388', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57389', '3', '57363', '海南藏族自治州', '632500', '57389', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57390', '3', '57389', '共和县', '632521', '57390', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57391', '3', '57389', '同德县', '632522', '57391', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57392', '3', '57389', '贵德县', '632523', '57392', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57393', '3', '57389', '兴海县', '632524', '57393', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57394', '3', '57389', '贵南县', '632525', '57394', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57395', '3', '57363', '果洛藏族自治州', '632600', '57395', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57396', '3', '57395', '玛沁县', '632621', '57396', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57397', '3', '57395', '班玛县', '632622', '57397', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57398', '3', '57395', '甘德县', '632623', '57398', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57399', '3', '57395', '达日县', '632624', '57399', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57400', '3', '57395', '久治县', '632625', '57400', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57401', '3', '57395', '玛多县', '632626', '57401', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57402', '3', '57363', '玉树藏族自治州', '632700', '57402', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57403', '3', '57402', '玉树县', '632721', '57403', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57404', '3', '57402', '杂多县', '632722', '57404', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57405', '3', '57402', '称多县', '632723', '57405', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57406', '3', '57402', '治多县', '632724', '57406', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57407', '3', '57402', '囊谦县', '632725', '57407', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57408', '3', '57402', '曲麻莱县', '632726', '57408', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57409', '3', '57363', '海西蒙古族藏族自治州', '632800', '57409', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57410', '3', '57409', '格尔木市', '632801', '57410', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57411', '3', '57409', '德令哈市', '632802', '57411', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57412', '3', '57409', '乌兰县', '632821', '57412', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57413', '3', '57409', '都兰县', '632822', '57413', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57414', '3', '57409', '天峻县', '632823', '57414', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57415', '3', '54317', '宁夏回族自治区', '640000', '57415', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57416', '3', '57415', '银川市', '640100', '57416', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57417', '3', '57416', '兴庆区', '640104', '57417', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57418', '3', '57416', '西夏区', '640105', '57418', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57419', '3', '57416', '金凤区', '640106', '57419', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57420', '3', '57416', '永宁县', '640121', '57420', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57421', '3', '57416', '贺兰县', '640122', '57421', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57422', '3', '57416', '灵武市', '640181', '57422', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57423', '3', '57415', '石嘴山市', '640200', '57423', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57424', '3', '57423', '大武口区', '640202', '57424', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57425', '3', '57423', '惠农区', '640205', '57425', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57426', '3', '57423', '平罗县', '640221', '57426', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57427', '3', '57415', '吴忠市', '640300', '57427', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57428', '3', '57427', '利通区', '640302', '57428', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57429', '3', '57427', '盐池县', '640323', '57429', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57430', '3', '57427', '同心县', '640324', '57430', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57431', '3', '57427', '青铜峡市', '640381', '57431', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57432', '3', '57415', '固原市', '640400', '57432', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57433', '3', '57432', '原州区', '640402', '57433', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57434', '3', '57432', '西吉县', '640422', '57434', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57435', '3', '57432', '隆德县', '640423', '57435', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57436', '3', '57432', '泾源县', '640424', '57436', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57437', '3', '57432', '彭阳县', '640425', '57437', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57438', '3', '57415', '中卫市', '640500', '57438', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57439', '3', '57438', '沙坡头区', '640502', '57439', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57440', '3', '57438', '中宁县', '640521', '57440', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57441', '3', '57438', '海原县', '640522', '57441', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57442', '3', '54317', '新疆维吾尔自治区', '650000', '57442', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57443', '3', '57442', '乌鲁木齐市', '650100', '57443', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57444', '3', '57443', '天山区', '650102', '57444', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57445', '3', '57443', '沙依巴克区', '650103', '57445', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57446', '3', '57443', '新市区', '650104', '57446', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57447', '3', '57443', '水磨沟区', '650105', '57447', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57448', '3', '57443', '头屯河区', '650106', '57448', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57449', '3', '57443', '达坂城区', '650107', '57449', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57450', '3', '57443', '米东区', '650109', '57450', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57451', '3', '57443', '乌鲁木齐县', '650121', '57451', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57452', '3', '57442', '克拉玛依市', '650200', '57452', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57453', '3', '57452', '独山子区', '650202', '57453', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57454', '3', '57452', '克拉玛依区', '650203', '57454', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57455', '3', '57452', '白碱滩区', '650204', '57455', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57456', '3', '57452', '乌尔禾区', '650205', '57456', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57457', '3', '57442', '吐鲁番地区', '652100', '57457', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57458', '3', '57457', '吐鲁番市', '652101', '57458', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57459', '3', '57457', '鄯善县', '652122', '57459', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57460', '3', '57457', '托克逊县', '652123', '57460', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57461', '3', '57442', '哈密地区', '652200', '57461', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57462', '3', '57461', '哈密市', '652201', '57462', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57463', '3', '57461', '巴里坤哈萨克自治县', '652222', '57463', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57464', '3', '57461', '伊吾县', '652223', '57464', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57465', '3', '57442', '昌吉回族自治州', '652300', '57465', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57466', '3', '57465', '昌吉市', '652301', '57466', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57467', '3', '57465', '阜康市', '652302', '57467', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57468', '3', '57465', '呼图壁县', '652323', '57468', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57469', '3', '57465', '玛纳斯县', '652324', '57469', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57470', '3', '57465', '奇台县', '652325', '57470', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57471', '3', '57465', '吉木萨尔县', '652327', '57471', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57472', '3', '57465', '木垒哈萨克自治县', '652328', '57472', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57473', '3', '57442', '博尔塔拉蒙古自治州', '652700', '57473', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57474', '3', '57473', '博乐市', '652701', '57474', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57475', '3', '57473', '精河县', '652722', '57475', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57476', '3', '57473', '温泉县', '652723', '57476', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57477', '3', '57442', '巴音郭楞蒙古自治州', '652800', '57477', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57478', '3', '57477', '库尔勒市', '652801', '57478', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57479', '3', '57477', '轮台县', '652822', '57479', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57480', '3', '57477', '尉犁县', '652823', '57480', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57481', '3', '57477', '若羌县', '652824', '57481', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57482', '3', '57477', '且末县', '652825', '57482', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57483', '3', '57477', '焉耆回族自治县', '652826', '57483', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57484', '3', '57477', '和静县', '652827', '57484', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57485', '3', '57477', '和硕县', '652828', '57485', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57486', '3', '57477', '博湖县', '652829', '57486', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57487', '3', '57442', '阿克苏地区', '652900', '57487', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57488', '3', '57487', '阿克苏市', '652901', '57488', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57489', '3', '57487', '温宿县', '652922', '57489', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57490', '3', '57487', '库车县', '652923', '57490', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57491', '3', '57487', '沙雅县', '652924', '57491', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57492', '3', '57487', '新和县', '652925', '57492', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57493', '3', '57487', '拜城县', '652926', '57493', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57494', '3', '57487', '乌什县', '652927', '57494', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57495', '3', '57487', '阿瓦提县', '652928', '57495', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57496', '3', '57487', '柯坪县', '652929', '57496', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57497', '3', '57442', '克孜勒苏柯尔克孜自治州', '653000', '57497', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57498', '3', '57497', '阿图什市', '653001', '57498', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57499', '3', '57497', '阿克陶县', '653022', '57499', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57500', '3', '57497', '阿合奇县', '653023', '57500', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57501', '3', '57497', '乌恰县', '653024', '57501', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57502', '3', '57442', '喀什地区', '653100', '57502', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57503', '3', '57502', '喀什市', '653101', '57503', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57504', '3', '57502', '疏附县', '653121', '57504', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57505', '3', '57502', '疏勒县', '653122', '57505', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57506', '3', '57502', '英吉沙县', '653123', '57506', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57507', '3', '57502', '泽普县', '653124', '57507', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57508', '3', '57502', '莎车县', '653125', '57508', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57509', '3', '57502', '叶城县', '653126', '57509', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57510', '3', '57502', '麦盖提县', '653127', '57510', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57511', '3', '57502', '岳普湖县', '653128', '57511', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57512', '3', '57502', '伽师县', '653129', '57512', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57513', '3', '57502', '巴楚县', '653130', '57513', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57514', '3', '57502', '塔什库尔干塔吉克自治县', '653131', '57514', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57515', '3', '57442', '和田地区', '653200', '57515', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57516', '3', '57515', '和田市', '653201', '57516', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57517', '3', '57515', '和田县', '653221', '57517', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57518', '3', '57515', '墨玉县', '653222', '57518', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57519', '3', '57515', '皮山县', '653223', '57519', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57520', '3', '57515', '洛浦县', '653224', '57520', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57521', '3', '57515', '策勒县', '653225', '57521', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57522', '3', '57515', '于田县', '653226', '57522', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57523', '3', '57515', '民丰县', '653227', '57523', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57524', '3', '57442', '伊犁哈萨克自治州', '654000', '57524', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57525', '3', '57524', '伊宁市', '654002', '57525', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57526', '3', '57524', '奎屯市', '654003', '57526', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57527', '3', '57524', '伊宁县', '654021', '57527', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57528', '3', '57524', '察布查尔锡伯自治县', '654022', '57528', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57529', '3', '57524', '霍城县', '654023', '57529', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57530', '3', '57524', '巩留县', '654024', '57530', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57531', '3', '57524', '新源县', '654025', '57531', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57532', '3', '57524', '昭苏县', '654026', '57532', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57533', '3', '57524', '特克斯县', '654027', '57533', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57534', '3', '57524', '尼勒克县', '654028', '57534', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57535', '3', '57442', '塔城地区', '654200', '57535', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57536', '3', '57535', '塔城市', '654201', '57536', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57537', '3', '57535', '乌苏市', '654202', '57537', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57538', '3', '57535', '额敏县', '654221', '57538', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57539', '3', '57535', '沙湾县', '654223', '57539', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57540', '3', '57535', '托里县', '654224', '57540', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57541', '3', '57535', '裕民县', '654225', '57541', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57542', '3', '57535', '和布克赛尔蒙古自治县', '654226', '57542', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57543', '3', '57442', '阿勒泰地区', '654300', '57543', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57544', '3', '57543', '阿勒泰市', '654301', '57544', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57545', '3', '57543', '布尔津县', '654321', '57545', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57546', '3', '57543', '富蕴县', '654322', '57546', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57547', '3', '57543', '福海县', '654323', '57547', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57548', '3', '57543', '哈巴河县', '654324', '57548', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57549', '3', '57543', '青河县', '654325', '57549', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57550', '3', '57543', '吉木乃县', '654326', '57550', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57551', '3', '57442', '（自治区直辖县级行政区）', '659000', '57551', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57552', '3', '57551', '石河子市', '659001', '57552', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57553', '3', '57551', '阿拉尔市', '659002', '57553', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57554', '3', '57551', '图木舒克市', '659003', '57554', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57555', '3', '57551', '五家渠市', '659004', '57555', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57556', '3', '54317', '台湾省', '710000', '57556', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57557', '3', '57556', '台北市', '710001', '57557', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57558', '3', '57556', '高雄市', '710002', '57558', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57559', '3', '57556', '基隆市', '710003', '57559', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57560', '3', '57556', '新竹市', '710004', '57560', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57561', '3', '57556', '台中市', '710005', '57561', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57562', '3', '57556', '嘉义市', '710006', '57562', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57563', '3', '57556', '台南市', '710007', '57563', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57564', '3', '57556', '台北县', '710008', '57564', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57565', '3', '57556', '宜兰县', '710009', '57565', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57566', '3', '57556', '桃园县', '710010', '57566', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57567', '3', '57556', '新竹县', '710011', '57567', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57568', '3', '57556', '苗栗县', '710012', '57568', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57569', '3', '57556', '台中县', '710013', '57569', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57570', '3', '57556', '彰化县', '710014', '57570', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57571', '3', '57556', '南投县', '710015', '57571', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57572', '3', '57556', '云林县', '710016', '57572', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57573', '3', '57556', '嘉义县', '710017', '57573', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57574', '3', '57556', '台南县', '710018', '57574', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57575', '3', '57556', '高雄县', '710019', '57575', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57576', '3', '57556', '屏东县', '710020', '57576', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57577', '3', '57556', '台东县', '710021', '57577', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57578', '3', '57556', '花莲县', '710022', '57578', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57579', '3', '57556', '澎湖县', '710023', '57579', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57580', '3', '57620', '香港特别行政区', '810100', '57580', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57581', '3', '57621', '澳门特别行政区', '820100', '57581', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57616', '3', '54317', '北京市', '110000', '57616', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57617', '3', '54317', '天津市', '120000', '57617', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57618', '3', '54317', '重庆市', '500000', '57618', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57619', '3', '54317', '上海市', '310000', '57619', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57620', '3', '54317', '香港特别行政区', '810000', '57620', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('57621', '3', '54317', '澳门特别行政区', '820000', '57621', '1', '2017-08-01 18:22:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100000', '3', '0', '佣金类型', 'dic_commission_type', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100001', '3', '100000', '前端佣金', 'dic_commission_type_front', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100002', '3', '100000', '前端+后端佣金', 'dic_commission_type_front_back', '2', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100003', '3', '0', '佣金类型', 'dic_quo_commission_type', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100004', '3', '100003', '前端佣金', 'dic_quo_commission_type_front', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100005', '3', '100003', '前端+后端佣金', 'dic_quo_commission_type_front_bk', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100006', '3', '0', '收益类型', 'dic_income_type', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100007', '3', '100006', '固定收益', 'dic_income_type_fix', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100008', '3', '100006', '浮动收益', 'dic_income_type_float', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100009', '3', '100006', '固定+浮动收益', 'dic_income_type_fix_float', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100010', '3', '0', '发行状态', 'dic_product_issued_status', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100011', '3', '100010', '未上线', '0', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100012', '3', '100010', '上线准备中', '1', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100013', '3', '100010', '预售', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100014', '3', '100010', '募集中', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100015', '3', '100010', '募集结束', '4', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100016', '3', '100010', '存续/封闭中', '5', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100017', '3', '100010', '清算退出', '6', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100018', '3', '0', '产品审批状态', 'dic_product_examine_status', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100019', '3', '100018', '未提交', '0', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100020', '3', '100018', '审批中', '1', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100021', '3', '100018', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100022', '3', '100018', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100023', '3', '100018', '已撤销', '4', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100024', '3', '0', '跟进方式', 'dic_follow_up_type', '1', '1', '2017-08-08 20:00:20', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100025', '3', '100024', '电话', '1', '1', '1', '2017-08-08 20:00:20', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100026', '3', '100024', '短信', '2', '2', '1', '2017-08-08 20:00:20', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100027', '3', '100024', '微信/QQ', '3', '3', '1', '2017-08-08 20:00:20', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100028', '3', '100024', '上门拜访', '4', '4', '1', '2017-08-08 20:00:20', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100029', '3', '100024', '其他', '5', '5', '1', '2017-08-08 20:00:21', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100030', '3', '0', '跟进状态', 'dic_follow_up_status', '1', '1', '2017-08-08 20:08:31', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100041', '3', '0', '性别', 'dic_sex', '1', '1', '2017-08-08 20:08:31', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100042', '3', '100041', '男', '1', '1', '1', '2017-08-08 20:08:32', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100043', '3', '100041', '女', '2', '2', '1', '2017-08-08 20:08:32', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100044', '3', '0', '客户级别', 'dic_customer_level', '1', '1', '2017-08-08 20:08:32', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100045', '3', '100044', 'A[最重要]', '1', '1', '1', '2017-08-08 20:08:32', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100046', '3', '100044', 'B[重要]', '2', '2', '1', '2017-08-08 20:08:32', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100047', '3', '100044', 'C[普通]', '3', '3', '1', '2017-08-08 20:08:32', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100048', '3', '100044', 'D[沉默]', '4', '4', '1', '2017-08-08 20:08:32', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100049', '3', '0', '来源', 'dic_customer_source', '1', '1', '2017-08-08 20:08:32', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100050', '3', '100049', '自我开发', '1', '1', '1', '2017-08-08 20:08:32', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100051', '3', '100049', '客户转介绍', '2', '2', '1', '2017-08-08 20:08:32', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100052', '3', '100049', '市场活动', '3', '3', '1', '2017-08-08 20:08:32', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100053', '3', '100049', '其他', '4', '4', '1', '2017-08-08 20:08:32', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100054', '3', '0', '证件类型', 'dic_customer_credentials', '1', '1', '2017-08-08 20:08:32', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100055', '3', '100054', '身份证', '1', '1', '1', '2017-08-08 20:08:32', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100056', '3', '100054', '护照', '2', '2', '1', '2017-08-08 20:08:32', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100057', '3', '0', '投资人类型', 'dic_customer_type', '1', '1', '2017-08-08 20:08:32', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100058', '3', '100057', '普通投资人', '1', '1', '1', '2017-08-08 20:08:32', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100059', '3', '100057', '专业投资人', '2', '2', '1', '2017-08-08 20:08:32', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100060', '3', '0', '风险特征', 'dic_customer_risk_rating', '1', '1', '2017-08-08 20:08:33', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100061', '3', '100060', '保守型', '1', '1', '1', '2017-08-08 20:08:33', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100062', '3', '100060', '适度保守型', '2', '2', '1', '2017-08-08 20:08:33', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100063', '3', '100060', '平衡型', '3', '3', '1', '2017-08-08 20:08:33', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100064', '3', '100060', '适度进取型', '4', '2', '1', '2017-08-08 20:08:33', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100065', '3', '100060', '进取型', '5', '5', '1', '2017-08-08 20:08:33', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100076', '3', '0', '回访方式', 'dic_user_visit_type', '1', '1', '2017-08-08 20:08:34', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100077', '3', '100076', '电话', '1', '1', '1', '2017-08-08 20:08:34', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100078', '3', '100076', '短信', '2', '2', '1', '2017-08-08 20:08:34', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100079', '3', '100076', '微信/QQ', '3', '3', '1', '2017-08-08 20:08:34', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100080', '3', '100076', '上门拜访', '4', '4', '1', '2017-08-08 20:08:34', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100081', '3', '100076', '其他', '5', '5', '1', '2017-08-08 20:08:34', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100082', '3', '0', '回访状态', 'dic_user_visit_status', '1', '1', '2017-08-08 20:08:34', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100083', '3', '100082', '成功', '1', '1', '1', '2017-08-08 20:08:34', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100084', '3', '100082', '失败', '0', '2', '2', '2017-08-08 20:08:34', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100085', '3', '0', '是否', 'dic_yes_or_no', '1', '1', '2017-08-08 20:08:34', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100086', '3', '100085', '是', '1', '1', '1', '2017-08-08 20:08:34', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100087', '3', '100085', '否', '0', '2', '2', '2017-08-08 20:08:34', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100088', '3', '0', '客户回退审批状态', 'dic_customer_back_status', '1', '1', '2017-08-10 15:07:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100089', '3', '100088', '审批中', '1', '1', '1', '2017-08-10 15:07:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100090', '3', '100088', '已通过', '2', '2', '1', '2017-08-10 15:07:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100091', '3', '100088', '已驳回', '3', '3', '1', '2017-08-10 15:07:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100092', '3', '0', '消息二级类型', 'dic_msg_message_two_type', '1', '1', '2017-08-17 16:41:55', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100093', '3', '100092', '客户', '1', '1', '1', '2017-08-17 16:42:32', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100094', '3', '100092', '产品', '2', '2', '1', '2017-08-17 16:42:53', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100095', '3', '100092', '待回访', '3', '3', '1', '2017-08-17 16:43:21', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100096', '3', '100092', '待跟进', '4', '4', '1', '2017-08-17 16:43:23', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100097', '3', '100092', '待审批', '5', '5', '1', '2017-08-17 16:43:36', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100098', '3', '100092', '待确认', '6', '6', '1', '2017-08-17 16:43:48', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100099', '3', '100092', '交易', '7', '7', '1', '2017-08-17 16:44:03', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100100', '3', '0', '消息一级类型', 'dic_msg_message_frist_type', '1', '1', '2017-08-17 16:45:06', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100101', '3', '100100', '代办', '1', '1', '1', '2017-08-17 16:45:24', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100102', '3', '100100', '通知', '2', '1', '1', '2017-08-17 16:45:56', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100103', '3', '0', '动态类型', 'dic_msg_feed_type', '1', '1', '2017-08-17 16:46:46', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100104', '3', '100103', '客户', '1', '1', '1', '2017-08-17 16:49:59', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100105', '3', '100103', '交易', '2', '1', '1', '2017-08-17 16:50:16', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100119', '3', '0', '是否已上传打款凭证', 'dic_has_pay_evidence', '1', '1', '2017-08-28 13:48:38', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100120', '3', '100119', '已上传', '1', '1', '1', '2017-08-28 13:48:38', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100121', '3', '100119', '未上传', '0', '2', '2', '2017-08-28 13:48:38', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100136', '3', '0', '报单审批状态', 'dic_declaration_status', '1', '1', '2017-08-29 13:44:17', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100137', '3', '100136', '待审批', '1', '1', '1', '2017-08-29 13:44:17', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100138', '3', '100136', '已通过', '2', '2', '1', '2017-08-29 13:44:17', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100139', '3', '100136', '已驳回', '3', '3', '1', '2017-08-29 13:44:17', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100140', '3', '100136', '已取消', '4', '4', '1', '2017-08-29 13:44:17', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100142', '3', '0', '预约审批状态', 'dic_reservation_status', '1', '1', '2017-09-02 11:57:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100143', '3', '100142', '待审批', '1', '1', '1', '2017-09-02 11:57:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100144', '3', '100142', '已通过', '2', '2', '1', '2017-09-02 11:57:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100145', '3', '100142', '已驳回', '3', '3', '1', '2017-09-02 11:57:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100146', '3', '100142', '已取消', '4', '4', '1', '2017-09-02 11:57:08', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100147', '3', '0', '销售线索类型', 'dic_leads_type', '1', '1', '2017-09-06 19:42:34', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100148', '3', '100147', '预约产品', '1', '1', '1', '2017-09-06 19:42:34', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100149', '3', '100147', '注册', '2', '2', '1', '2017-09-06 19:42:34', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100150', '3', '0', '销售线索渠道', 'dic_leads_channel', '1', '1', '2017-09-06 19:42:34', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100151', '3', '100150', '网站', '1', '1', '1', '2017-09-06 19:42:34', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100152', '3', '100150', '服务号', '2', '2', '1', '2017-09-06 19:42:34', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100153', '3', '0', '销售线索状态', 'dic_leads_status', '1', '1', '2017-09-06 19:42:34', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100154', '3', '100153', '未处理', '0', '1', '1', '2017-09-06 19:42:34', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100155', '3', '100153', '已联系', '1', '2', '1', '2017-09-06 19:42:34', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100156', '3', '100153', '关闭', '2', '2', '1', '2017-09-06 19:42:34', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100157', '3', '0', '客户状态', 'dic_customer_status', '1', '1', '2017-09-06 19:42:34', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100158', '3', '100157', '未确认', '0', '1', '1', '2017-09-06 19:42:34', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100159', '3', '100157', '有效', '1', '2', '1', '2017-09-06 19:42:34', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100160', '3', '100157', '无效', '2', '2', '1', '2017-09-06 19:42:34', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100161', '3', '0', '销售线索回访状态', 'dic_leads_visit_status', '1', '1', '2017-09-06 19:42:34', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100162', '3', '100161', '未分配', '0', '1', '1', '2017-09-06 19:42:34', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100163', '3', '100161', '已分配', '1', '2', '1', '2017-09-06 19:42:34', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100164', '3', '100161', '已回访', '2', '2', '1', '2017-09-06 19:42:34', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100165', null, '100103', '客户行为', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100166', null, '100092', '客户行为', '8', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100167', null, '100136', '已作废', '5', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100168', null, '0', '报单审批状态', 'dic_declaration_audit_status', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100169', null, '100168', '待审批', '1', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100170', null, '100168', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100171', null, '100168', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100172', null, '100168', '已取消', '4', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100173', null, '100142', '已作废', '5', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100174', null, '0', '预约审批状态', 'dic_reservation_audit_status', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100175', null, '100174', '待审批', '1', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100176', null, '100174', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100177', null, '100174', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100178', null, '100174', '已取消', '4', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100179', null, '0', '是否开具发票', 'dic_receipt_record_is_invoiced', '1', '1', '2017-11-02 14:55:39', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100180', null, '100179', '已开票', '1', '1', '1', '2017-11-02 14:55:39', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100181', null, '100179', '未开票', '0', '2', '2', '2017-11-02 14:55:39', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100182', null, '0', '结佣审批状态', 'dic_knotcommission_status', '1', '1', '2017-11-02 14:55:39', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100183', null, '100182', '待审批', '1', '1', '1', '2017-11-02 14:55:39', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100184', null, '100182', '已通过', '2', '2', '1', '2017-11-02 14:55:39', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100185', null, '100182', '已否决', '5', '3', '1', '2017-11-02 14:55:39', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100186', null, '0', '结佣佣金类型', 'dic_knotcommission_type', '1', '1', '2017-11-02 14:55:39', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100187', null, '100186', '前端佣金', 'dic_knotcommission_type_front', '1', '1', '2017-11-02 14:55:39', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100188', null, '100186', '后端佣金', 'dic_knotcommission_type_back', '2', '1', '2017-11-02 14:55:39', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100189', null, '0', '预约审批状态', 'dic_refund_status', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100190', null, '100189', '待审批', '1', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100191', null, '100189', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100192', null, '100189', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100193', null, '100189', '已取消', '4', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100194', null, '100136', '已退款', '6', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100195', null, '0', '文章状态', 'dic_article_status', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100196', null, '100195', '停用', '0', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100197', null, '100195', '启用', '1', '0', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100198', null, '0', '文章栏目状态', 'dic_article_column_status', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100199', null, '100198', '停用', '0', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100200', null, '100198', '启用', '1', '0', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100201', null, '100147', '预约理财师', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100202', '3', '0', '是否限制公海客户领取上限', 'dic_conf_sale_opensea_limit', '1', '1', '2017-11-07 10:21:56', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100203', '3', '100202', '限制上限', '1', '1', '1', '2017-11-07 10:21:56', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100204', '3', '100202', '不限制', '0', '2', '1', '2017-11-07 10:21:56', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100205', '3', '100136', '未提交', '0', '0', '1', '2017-11-07 10:21:56', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100206', '3', '0', '视频压缩状态', 'dic_video_status', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100207', '3', '100206', '压缩中', '0', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100208', '3', '100206', '压缩完成', '1', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100209', '3', '0', '路演栏目状态', 'dic_roadshow_column_status', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100210', '3', '100209', '停用', '0', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100211', '3', '100209', '启用', '1', '0', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100212', '3', '0', '路演状态', 'dic_roadshow_status', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100213', '3', '100212', '停用', '0', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100214', '3', '100212', '启用', '1', '0', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100215', '3', '0', '项目审批', 'dic_project_history_audit_status', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100216', '3', '100215', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100217', '3', '100215', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100218', '3', '0', '项目来源', 'dic_project_source', '1', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100219', '3', '100218', '网络搜索', '1', '10', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100220', '3', '100218', '个人／机构推荐', '2', '20', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100221', '3', '100218', '路演', '3', '30', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100222', '3', '100218', '邮箱投递', '4', '40', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100223', '3', '100218', '其他', '5', '50', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100224', '3', '0', '优先级', 'dic_project_priority', '1', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100225', '3', '100224', 'A[最重要]', '1', '10', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100226', '3', '100224', 'B[重要]', '2', '20', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100227', '3', '100224', 'C[普通]', '3', '30', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100228', '3', '100224', 'D[沉默]', '4', '40', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100229', '3', '0', '项目状态', 'dic_project_status', '1', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100230', '3', '100229', '入库', '0', '10', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100231', '3', '100229', '立项会', '10', '20', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100232', '3', '100229', '尽职调查', '20', '30', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100233', '3', '100229', '初审', '30', '40', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100234', '3', '100229', '投委会', '40', '50', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100235', '3', '100229', '待出资', '45', '60', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100236', '3', '100229', '已出资', '50', '70', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100237', '3', '100229', '放弃出资', '60', '80', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100238', '3', '0', '轮次', 'dic_project_round', '1', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100239', '3', '100238', '尚未获投', '1', '10', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100240', '3', '100238', '种子轮', '2', '20', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100241', '3', '100238', '天使轮', '3', '30', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100242', '3', '100238', 'Pre-A轮', '4', '40', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100243', '3', '100238', 'A轮', '5', '50', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100244', '3', '100238', 'A+轮', '6', '60', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100245', '3', '100238', 'Pre-B轮', '7', '70', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100246', '3', '100238', 'B轮', '8', '80', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100247', '3', '100238', 'B+轮', '9', '90', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100248', '3', '100238', 'C轮', '10', '100', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100249', '3', '100238', 'D轮', '11', '110', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100250', '3', '100238', 'E轮', '12', '120', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100251', '3', '100238', 'F轮-上市前', '13', '130', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100252', '3', '100238', 'IPO上市', '14', '140', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100253', '3', '100238', '新三板', '15', '150', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100254', '3', '100238', '战略融资', '16', '160', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100255', '3', '100238', '已被收购', '17', '170', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100256', '3', '100238', '不明确', '18', '180', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100257', '3', '0', '币种', 'dic_currency', '1', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100258', '3', '100257', '人民币', '0', '10', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100259', '3', '100257', '美元', '1', '10', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100260', '3', '0', '投资等级', 'dic_project_investment_level', '1', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100261', '3', '100260', '领投', '1', '10', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100262', '3', '100260', '跟投', '2', '20', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100263', '3', '0', '投资方式', 'dic_project_investment_type', '1', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100264', '3', '100263', '增资', '1', '10', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100265', '3', '100263', '股权转让', '2', '20', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100266', '3', '100263', '增资&股权转让', '3', '30', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100267', '3', '0', '投资方、投资来源', 'dic_project_investment_source', '1', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100268', '3', '100267', '内部基金产品', '1', '10', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100269', '3', '100267', '其他', '2', '20', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100270', '3', '0', '公司类型', 'dic_project_company_type', '1', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100271', '3', '100270', '(内资)有限公司', '1', '10', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100272', '3', '100270', '(内资)股份公司', '2', '20', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100273', '3', '100270', '(内资)个人独资企业', '3', '30', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100274', '3', '100270', '(内资)有限合伙企业', '4', '40', '1', '2017-11-26 14:11:14', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100275', '3', '100270', '(内资)普通合伙企业', '5', '50', '1', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100276', '3', '100270', '(外资)中外合资企业', '6', '60', '1', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100277', '3', '100270', '(外资)外商独资企业', '7', '70', '1', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100278', '3', '100270', '外商投资有限合伙', '8', '80', '1', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100279', '3', '100270', '外商投资普通合伙', '9', '90', '1', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100280', '3', '0', '意见', 'dic_project_decision_suggestion', '1', '1', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100281', '3', '100280', '通过', '1', '10', '1', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100282', '3', '100280', '不通过', '0', '20', '1', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100283', '3', '0', '立项审批状态', 'dic_decision_audit_status', '1', '1', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100284', '3', '100283', '进行中', '0', '10', '1', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100285', '3', '100283', '待审批', '1', '20', '1', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100286', '3', '100283', '已通过', '2', '30', '1', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100287', '3', '100283', '已驳回', '3', '40', '1', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100288', '3', '0', '是否出资', 'dic_project_invest_or_not', '1', '1', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100289', '3', '100288', '放弃出资', '0', '10', '1', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100290', '3', '100288', '决定出资', '1', '20', '1', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100291', '3', '0', '基金发行状态', 'dic_fund_issued_status', '1', '1', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100292', '3', '100291', '待募集', '-1', '10', '1', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100293', '3', '100291', '募集中', '3', '20', '1', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100294', '3', '100291', '募集结束', '4', '30', '1', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100295', '3', '100291', '存续／封闭中', '5', '40', '1', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100296', '3', '100291', '清算退出', '6', '50', '1', '2017-11-26 14:11:15', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100297', '3', '100215', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100298', '3', '100215', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100299', '3', '100215', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100300', '3', '100215', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100301', '3', '100215', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100302', '3', '100215', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100303', '3', '0', '退出方式', 'dic_withdrawal_type', '1', '1', '2017-11-29 18:28:02', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100304', '3', '100303', '被并购', '1', '10', '1', '2017-11-29 18:28:02', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100305', '3', '100303', 'IPO上市', '2', '20', '1', '2017-11-29 18:28:02', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100306', '3', '100303', '股权转让', '3', '20', '1', '2017-11-29 18:28:02', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100307', '3', '100215', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100308', '3', '100215', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100309', '3', '100215', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100310', '3', '100215', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100311', '3', '100215', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100312', '3', '100215', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100313', '3', '100215', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100314', '3', '100215', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100315', '3', '100215', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100316', '3', '100215', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100317', '3', '100215', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100318', '3', '100215', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100319', '3', '100215', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100320', '3', '100215', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100321', '3', '100215', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100322', '3', '100215', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100323', '3', '100215', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100324', '3', '100215', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100325', '3', '100215', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100326', '3', '100215', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100327', '3', '100215', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100328', '3', '100215', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100329', '3', '100215', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100330', '3', '100215', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100331', '3', '100215', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100332', '3', '100215', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100333', '3', '100215', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100334', '3', '100215', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100335', '3', '100215', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100336', '3', '100215', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100337', '3', '100215', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100338', '3', '100215', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100339', '3', '100215', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100340', '3', '100215', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100341', '3', '100215', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100342', '3', '100215', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100343', '3', '100215', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100344', '3', '100215', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100345', '3', '100215', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100346', '3', '100215', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100347', '3', '100215', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100348', '3', '100215', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100349', '3', '100215', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100350', '3', '100215', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100351', '3', '100215', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100352', '3', '100215', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100353', '3', '100215', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100354', '3', '100215', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100355', '3', '100215', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100356', '3', '100215', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100357', '3', '100215', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100358', '3', '100215', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100359', '3', '100215', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100360', '3', '100215', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100361', '3', '100215', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100362', '3', '100215', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100363', '3', '100215', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100364', '3', '100215', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100365', '3', '100215', '已通过', '2', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100366', '3', '100215', '已驳回', '3', '1', '1', null, null, null, null, '0');
INSERT INTO `dictionary` VALUES ('100447', '3', '100030', '有效', '1', '0', '1', '2017-12-16 18:25:59', '1', null, null, '0');
INSERT INTO `dictionary` VALUES ('100448', '3', '100030', '无效', '2', '1', '1', '2017-12-16 18:25:59', '1', null, null, '0');

-- ----------------------------
-- Table structure for field
-- ----------------------------
DROP TABLE IF EXISTS `field`;
CREATE TABLE `field` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `name` varchar(32) DEFAULT NULL COMMENT '名字',
  `code` varchar(64) DEFAULT NULL COMMENT '编码',
  `description` varchar(512) DEFAULT NULL COMMENT '描述',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8 COMMENT='业务字段';

-- ----------------------------
-- Records of field
-- ----------------------------
INSERT INTO `field` VALUES ('1', '3', '名称', 'product_name', null, '1', '2017-07-16 23:59:00', null, null, '0');
INSERT INTO `field` VALUES ('2', '3', '发行通道', 'product_issued_channel', null, '1', '2017-07-16 23:58:00', null, null, '0');
INSERT INTO `field` VALUES ('3', '3', '投资标的', 'product_invest_domain', null, '1', '2017-07-16 23:57:00', null, null, '0');
INSERT INTO `field` VALUES ('4', '3', '投资期限', 'product_time_limit', null, '1', '2017-07-16 23:56:00', null, null, '0');
INSERT INTO `field` VALUES ('5', '3', '管理机构', 'product_mechanism', null, '1', '2017-07-16 23:55:00', null, null, '0');
INSERT INTO `field` VALUES ('6', '3', '认购起点', 'product_buy_start_point', null, '1', '2017-07-16 23:54:00', null, null, '0');
INSERT INTO `field` VALUES ('7', '3', '递增金额', 'product_Incremental_amount', null, '1', '2017-07-16 23:53:00', null, null, '0');
INSERT INTO `field` VALUES ('8', '3', '投资人数上限', 'product_buy_person_count_limit', null, '1', '2017-07-16 23:52:00', null, null, '0');
INSERT INTO `field` VALUES ('9', '3', '重要等级', 'product_level', null, '1', '2017-07-16 23:51:00', null, null, '0');
INSERT INTO `field` VALUES ('10', '3', '风险等级', 'product_risk_level', null, '1', '2017-07-16 23:50:00', null, null, '0');
INSERT INTO `field` VALUES ('11', '3', '负责人', 'product_receiver_id', null, '1', '2017-07-16 22:49:00', null, null, '0');
INSERT INTO `field` VALUES ('12', '3', '助理', 'product_assistant_id', null, '1', '2017-07-16 22:48:00', null, null, '0');
INSERT INTO `field` VALUES ('13', '3', '简要亮点', 'product_highlight', null, '1', '2017-07-16 22:47:00', null, null, '0');
INSERT INTO `field` VALUES ('14', '3', '拟销售日期', 'product_sale_start_date', null, '1', '2017-07-16 22:46:00', null, null, '0');
INSERT INTO `field` VALUES ('15', '3', '是否有规模', 'product_is_scale', null, '1', '2017-07-16 22:45:00', null, null, '0');
INSERT INTO `field` VALUES ('16', '3', '募集规模', 'product_product_scale', null, '1', '2017-07-16 22:44:00', null, null, '0');
INSERT INTO `field` VALUES ('17', '3', '投资币种', 'product_currency_code', null, '1', '2017-07-16 22:43:00', null, null, '0');
INSERT INTO `field` VALUES ('18', '3', '打款账号', 'product_pay_account', null, '1', '2017-07-16 22:42:00', null, null, '0');
INSERT INTO `field` VALUES ('19', '3', '基金经理', 'product_private_fund_rm', null, '1', '2017-07-16 22:41:00', null, null, '0');
INSERT INTO `field` VALUES ('20', '3', '投资策略', 'product_private_investment_strategy', null, '1', '2017-07-16 22:40:00', null, null, '0');
INSERT INTO `field` VALUES ('21', '3', '投资子策略', 'product_private_investment_sub_strategy', null, '1', '2017-07-16 22:39:00', null, null, '0');
INSERT INTO `field` VALUES ('22', '3', '封闭期', 'product_private_closure_period', null, '1', '2017-07-16 22:38:00', null, null, '0');
INSERT INTO `field` VALUES ('23', '3', 'SP基金类型', 'product_private_fund_type', null, '1', '2017-07-16 22:37:00', null, null, '0');
INSERT INTO `field` VALUES ('24', '3', '认购费', 'product_pro_buy_fee', null, '1', '2017-07-16 22:36:00', null, null, '0');
INSERT INTO `field` VALUES ('25', '3', '赎回费', 'product_private_redemption_fee', null, '1', '2017-07-16 22:35:00', null, null, '0');
INSERT INTO `field` VALUES ('26', '3', '管理费', 'product_pro_manage_fee', null, '1', '2017-07-16 22:34:00', null, null, '0');
INSERT INTO `field` VALUES ('27', '3', '开放日', 'product_private_date_open', null, '1', '2017-07-16 22:33:00', null, null, '0');
INSERT INTO `field` VALUES ('28', '3', '股权基金类型', 'product_stock_fund_type', null, '1', '2017-07-16 22:32:00', null, null, '0');
INSERT INTO `field` VALUES ('29', '3', '基金形式', 'product_stock_fund_form', null, '1', '2017-07-16 22:31:00', null, null, '0');
INSERT INTO `field` VALUES ('30', '3', '托管方', 'product_stock_custodian', null, '1', '2017-07-16 22:30:00', null, null, '0');
INSERT INTO `field` VALUES ('31', '3', '投资方向', 'product_stock_invest_way', null, '1', '2017-07-16 22:29:00', null, null, '0');
INSERT INTO `field` VALUES ('32', '3', '收益分成', 'product_stock_revenue_share', null, '1', '2017-07-16 22:28:00', null, null, '0');
INSERT INTO `field` VALUES ('33', '3', '固收基金类型', 'product_fix_fund_type', null, '1', '2017-07-16 22:27:00', null, null, '0');
INSERT INTO `field` VALUES ('34', '3', '投资领域', 'product_fix_invest_domain', null, '1', '2017-07-16 22:26:00', null, null, '0');
INSERT INTO `field` VALUES ('35', '3', '融资主体', 'product_fix_major_financing', null, '1', '2017-07-16 22:25:00', null, null, '0');
INSERT INTO `field` VALUES ('36', '3', '资金用途', 'product_fix_fund_use', null, '1', '2017-07-16 22:24:00', null, null, '0');
INSERT INTO `field` VALUES ('37', '3', '风控措施', 'product_fix_risk_control', null, '1', '2017-07-16 22:23:00', null, null, '0');
INSERT INTO `field` VALUES ('38', '3', '还款来源', 'product_fix_repayment', null, '1', '2017-07-16 22:22:00', null, null, '0');
INSERT INTO `field` VALUES ('39', '3', '收益信息', 'product_fix_profit_info', null, '1', '2017-07-16 22:21:00', null, null, '0');
INSERT INTO `field` VALUES ('40', '3', '付息方式', 'product_fix_pay_interest', null, '1', '2017-07-16 22:20:00', null, null, '0');
INSERT INTO `field` VALUES ('41', '3', '微信简版', 'product_wx_content', null, '1', '2017-07-16 22:19:00', null, null, '0');
INSERT INTO `field` VALUES ('42', '3', '开户名', 'product_account_name', null, '1', '2017-07-16 22:18:00', null, null, '0');
INSERT INTO `field` VALUES ('43', '3', '募集银行', 'product_raise_bank', null, '1', '2017-07-16 22:17:00', null, null, '0');
INSERT INTO `field` VALUES ('44', '3', '打款备注', 'product_pay_remark', null, '1', '2017-07-16 22:16:00', null, null, '0');
INSERT INTO `field` VALUES ('45', '3', '姓名', 'customer_name', null, '1', '2017-07-16 22:15:00', null, null, '0');
INSERT INTO `field` VALUES ('46', '3', '邮箱', 'contact_email', null, '1', '2017-07-16 22:14:00', null, null, '0');
INSERT INTO `field` VALUES ('47', '3', '手机号码', 'contact_mobile', null, '1', '2017-07-16 22:13:00', null, null, '0');
INSERT INTO `field` VALUES ('48', '3', '微信', 'contact_wechat', null, '1', '2017-07-16 22:12:00', null, null, '0');
INSERT INTO `field` VALUES ('49', '3', 'qq', 'contact_qq', null, '1', '2017-07-16 22:11:00', null, null, '0');
INSERT INTO `field` VALUES ('50', '3', '省份', 'customer_province_code', null, '1', '2017-07-16 22:10:00', null, null, '0');
INSERT INTO `field` VALUES ('51', '3', '市', 'customer_city_code', null, '1', '2017-07-16 22:09:00', null, null, '0');
INSERT INTO `field` VALUES ('52', '3', '地址', 'customer_address', null, '1', '2017-07-16 22:08:00', null, null, '0');
INSERT INTO `field` VALUES ('53', '3', '行业', 'customer_trade', null, '1', '2017-07-16 22:07:00', null, null, '0');
INSERT INTO `field` VALUES ('54', '3', '机构', 'customer_organization', null, '1', '2017-07-16 22:06:00', null, null, '0');
INSERT INTO `field` VALUES ('55', '3', '职位', 'customer_position', null, '1', '2017-07-16 22:05:00', null, null, '0');
INSERT INTO `field` VALUES ('56', '3', '性别', 'customer_sex', null, '1', '2017-07-16 22:04:00', null, null, '0');
INSERT INTO `field` VALUES ('57', '3', '客户编号', 'customer_number', null, '1', '2017-07-16 22:03:00', null, null, '0');
INSERT INTO `field` VALUES ('58', '3', '客户级别', 'customer_level', null, '1', '2017-07-16 22:02:00', null, null, '0');
INSERT INTO `field` VALUES ('59', '3', '标签', 'customer_tag', null, '1', '2017-07-16 22:01:00', null, null, '0');
INSERT INTO `field` VALUES ('60', '3', '生日', 'customer_birthday', null, '1', '2017-07-16 22:00:00', null, null, '0');
INSERT INTO `field` VALUES ('61', '3', '客户来源', 'customer_source', null, '1', '2017-07-16 21:59:00', null, null, '0');
INSERT INTO `field` VALUES ('62', '3', '证件类型', 'customer_credentials_type', null, '1', '2017-07-16 21:58:00', null, null, '0');
INSERT INTO `field` VALUES ('63', '3', '证件号码', 'customer_credentials_number', null, '1', '2017-07-16 21:57:00', null, null, '0');
INSERT INTO `field` VALUES ('64', '3', '证件正面', 'customer_credentials_front', null, '1', '2017-07-16 21:56:00', null, null, '0');
INSERT INTO `field` VALUES ('65', '3', '证件反面', 'customer_credentials_back', null, '1', '2017-07-16 21:55:00', null, null, '0');
INSERT INTO `field` VALUES ('66', '3', '资产证明', 'customer_assets_certify', null, '1', '2017-07-16 21:54:00', null, null, '0');
INSERT INTO `field` VALUES ('67', '3', '备注', 'customer_remark', null, '1', '2017-07-16 21:53:00', null, null, '0');
INSERT INTO `field` VALUES ('68', '3', '银行卡账号', 'customer_bank_account', null, '1', '2017-07-16 21:52:00', null, null, '0');
INSERT INTO `field` VALUES ('69', '3', '开户行', 'customer_bank_name', null, '1', '2017-07-16 21:51:00', null, null, '0');
INSERT INTO `field` VALUES ('70', '3', '银行卡正面', 'customer_bank_front', null, '1', '2017-07-16 21:50:00', null, null, '0');
INSERT INTO `field` VALUES ('71', '3', '银行卡反面', 'customer_bank_back', null, '1', '2017-07-16 21:49:00', null, null, '0');
INSERT INTO `field` VALUES ('72', '3', '投资偏好', 'customer_customer_invest_type', null, '1', '2017-07-16 21:48:00', null, null, '0');
INSERT INTO `field` VALUES ('73', '3', '风险特征', 'customer_risk_rating', null, '1', '2017-07-16 21:47:00', null, null, '0');
INSERT INTO `field` VALUES ('74', '3', '投资人类型', 'customer_type', null, '1', '2017-07-16 21:46:00', null, null, '0');
INSERT INTO `field` VALUES ('75', '3', '提交回访时间', 'visit_sub_date', null, '1', '2017-07-16 21:45:00', null, null, '0');
INSERT INTO `field` VALUES ('76', '3', '回访事由', 'visit_matter', null, '1', '2017-07-16 21:44:00', null, null, '0');
INSERT INTO `field` VALUES ('77', '3', '回访时间', 'visit_visit_date', null, '1', '2017-07-16 21:43:00', null, null, '0');
INSERT INTO `field` VALUES ('78', '3', '回访方式', 'visit_type', null, '1', '2017-07-16 21:42:00', null, null, '0');
INSERT INTO `field` VALUES ('79', '3', '回访状态', 'visit_status', null, '1', '2017-07-16 21:41:00', null, null, '0');
INSERT INTO `field` VALUES ('80', '3', '回访内容', 'visit_content', null, '1', '2017-07-16 21:40:00', null, null, '0');
INSERT INTO `field` VALUES ('81', '3', '下次回访时间', 'visit_next_time', null, '1', '2017-07-16 21:39:00', null, null, '0');
INSERT INTO `field` VALUES ('82', '3', '预约编号', 'reservation_number', null, '1', '2017-07-16 21:38:00', null, null, '0');
INSERT INTO `field` VALUES ('83', '3', '预计打款日期', 'reservation_estimate_pay_date', null, '1', '2017-07-16 21:37:00', null, null, '0');
INSERT INTO `field` VALUES ('84', '3', '预约金额', 'reservation_reservation_amount', null, '1', '2017-07-16 21:36:00', null, null, '0');
INSERT INTO `field` VALUES ('85', '3', '备注', 'reservation_remark', null, '1', '2017-07-16 21:35:00', null, null, '0');
INSERT INTO `field` VALUES ('86', '3', '预约状态', 'reservation_status', null, '1', '2017-07-16 21:34:00', null, null, '0');
INSERT INTO `field` VALUES ('87', '3', '预约者id', 'reservation_user_id', null, '1', '2017-07-16 21:33:00', null, null, '0');
INSERT INTO `field` VALUES ('88', '3', '最后提交时间', 'reservation_commit_date', null, '1', '2017-07-16 21:32:00', null, null, '0');
INSERT INTO `field` VALUES ('89', '3', '最后审核操作时间', 'reservation_operation_date', null, '1', '2017-07-16 21:31:00', null, null, '0');
INSERT INTO `field` VALUES ('90', '3', '废弃原因', 'reservation_discard_reason', null, '1', '2017-07-16 21:30:00', null, null, '0');
INSERT INTO `field` VALUES ('91', '3', '报单编号', 'declaration_number', null, '1', '2017-07-16 21:29:00', null, null, '0');
INSERT INTO `field` VALUES ('92', '3', '打款日期', 'declaration_pay_date', null, '1', '2017-07-16 21:28:00', null, null, '0');
INSERT INTO `field` VALUES ('93', '3', '认购金额', 'declaration_deal_amount', null, '1', '2017-07-16 21:27:00', null, null, '0');
INSERT INTO `field` VALUES ('94', '3', '是否已上传打款凭证', 'declaration_has_pay_evidence', null, '1', '2017-07-16 21:26:00', null, null, '0');
INSERT INTO `field` VALUES ('95', '3', '备注', 'declaration_remark', null, '1', '2017-07-16 21:25:00', null, null, '0');
INSERT INTO `field` VALUES ('96', '3', '报单状态', 'declaration_status', null, '1', '2017-07-16 21:24:00', null, null, '0');
INSERT INTO `field` VALUES ('97', '3', '报单者id', 'declaration_user_id', null, '1', '2017-07-16 21:23:00', null, null, '0');
INSERT INTO `field` VALUES ('98', '3', '最后提交时间', 'declaration_commit_date', null, '1', '2017-07-16 21:22:00', null, null, '0');
INSERT INTO `field` VALUES ('99', '3', '最后审核操作时间', 'declaration_operation_date', null, '1', '2017-07-16 21:21:00', null, null, '0');
INSERT INTO `field` VALUES ('100', '3', '废弃原因', 'declaration_discard_reason', null, '1', '2017-07-16 21:20:00', null, null, '0');
INSERT INTO `field` VALUES ('101', '3', '附件名称', 'declaration_attach_name', null, '1', '2017-07-16 21:19:00', null, null, '0');
INSERT INTO `field` VALUES ('102', '3', '附件url', 'declaration_attach_url', null, '1', '2017-07-16 21:18:00', null, null, '0');
INSERT INTO `field` VALUES ('103', '3', '附件类型', 'declaration_attach_type', null, '1', '2017-07-16 21:17:00', null, null, '0');
INSERT INTO `field` VALUES ('104', '3', '合规文件url', 'declaration_compliance_url', null, '1', '2017-07-16 21:16:00', null, null, '0');
INSERT INTO `field` VALUES ('105', '3', '文件名', 'declaration_compliance_name', null, '1', '2017-07-16 21:15:00', null, null, '0');
INSERT INTO `field` VALUES ('106', '3', '类型', 'declaration_compliance_type', null, '1', '2017-07-16 21:14:00', null, null, '0');
INSERT INTO `field` VALUES ('107', '3', '格式', 'declaration_compliance_format_type', null, '1', '2017-07-16 21:13:00', null, null, '0');
INSERT INTO `field` VALUES ('108', '3', '银行卡账号', 'declaration_bank_account', null, '1', '2017-07-16 21:12:00', null, null, '0');
INSERT INTO `field` VALUES ('109', '3', '开户行', 'declaration_bank_name', null, '1', '2017-07-16 21:11:00', null, null, '0');
INSERT INTO `field` VALUES ('110', '3', '银行卡正面', 'declaration_bank_front', null, '1', '2017-07-16 21:10:00', null, null, '0');
INSERT INTO `field` VALUES ('111', '3', '银行卡反面', 'declaration_bank_back', null, '1', '2017-07-16 21:09:00', null, null, '0');
INSERT INTO `field` VALUES ('112', '3', '证件类型', 'declaration_credentials_type', null, '1', '2017-07-16 21:08:00', null, null, '0');
INSERT INTO `field` VALUES ('113', '3', '证件号码', 'declaration_credentials_number', null, '1', '2017-07-16 21:07:00', null, null, '0');
INSERT INTO `field` VALUES ('114', '3', '证件正面', 'declaration_credentials_front', null, '1', '2017-07-16 21:06:00', null, null, '0');
INSERT INTO `field` VALUES ('115', '3', '证件反面', 'declaration_credentials_back', null, '1', '2017-07-16 21:05:00', null, null, '0');
INSERT INTO `field` VALUES ('116', '3', '到期日期', 'product_maturity_date', null, null, '2017-07-16 23:56:10', null, null, '0');
INSERT INTO `field` VALUES ('10000', '3', '测试文本', 'product_field_10000', null, '46', '2017-11-02 15:43:56', null, null, '0');

-- ----------------------------
-- Table structure for field_config
-- ----------------------------
DROP TABLE IF EXISTS `field_config`;
CREATE TABLE `field_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `object_field_id` bigint(20) DEFAULT NULL COMMENT '业务对象字段id',
  `default_value` varchar(256) DEFAULT NULL COMMENT '默认值；如果是区间值，用逗号分隔如 数值：0,10000   日期：2017-10-10,,2099-10-10',
  `max_length` int(11) DEFAULT NULL COMMENT '最大长度；一般文本类型使用',
  `min_length` int(11) DEFAULT '0' COMMENT '最小长度；一般文本类型使用',
  `max_value` varchar(32) DEFAULT NULL COMMENT '最大值；一般数值和日期类型使用',
  `min_value` varchar(32) DEFAULT NULL COMMENT '最小值；一般数值和日期类型使用',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，1：是；0：否',
  PRIMARY KEY (`id`),
  KEY `i_tenant_id` (`tenant_id`),
  KEY `i_create_user_id` (`create_user_id`),
  KEY `i_update_user_id` (`update_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='业务对象字段配置';

-- ----------------------------
-- Records of field_config
-- ----------------------------
INSERT INTO `field_config` VALUES ('1', '3', '1', null, '100', '1', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('2', '3', '2', null, '200', '1', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('3', '3', '3', null, '200', '1', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('4', '3', '4', null, '200', '1', '2147483647', '0', '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('5', '3', '5', null, '64', '1', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('6', '3', '6', null, '200', '1', '2147483647', '0', '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('7', '3', '7', null, '200', '1', '2147483647', '0', '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('8', '3', '8', null, '200', '1', '2147483647', '0', '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('9', '3', '9', null, '200', '1', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('10', '3', '10', null, '200', '1', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('11', '3', '11', null, '200', '1', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('12', '3', '12', null, '200', '1', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('13', '3', '13', null, '1000', '0', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('14', '3', '14', null, '200', '0', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('15', '3', '15', '1', '200', '0', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('16', '3', '16', null, '200', '0', '2147483647', '0', '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('17', '3', '17', '0', '200', '1', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('18', '3', '18', null, '250', '0', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('19', '3', '19', null, '200', '1', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('20', '3', '20', null, '200', '1', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('21', '3', '21', null, '200', '1', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('22', '3', '22', null, '200', '1', '2147483647', '0', '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('23', '3', '23', null, '200', '1', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('24', '3', '24', null, '200', '1', '2147483647', '0', '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('25', '3', '25', null, '200', '1', '2147483647', '0', '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('26', '3', '26', null, '200', '1', '2147483647', '0', '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('27', '3', '27', null, '200', '1', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('28', '3', '28', null, '200', '1', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('29', '3', '29', null, '200', '1', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('30', '3', '30', null, '200', '1', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('31', '3', '31', null, '200', '1', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('32', '3', '32', null, '200', '1', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('33', '3', '33', null, '200', '1', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('34', '3', '34', null, '200', '1', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('35', '3', '35', null, '200', '1', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('36', '3', '36', null, '200', '1', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('37', '3', '37', null, '200', '1', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('38', '3', '38', null, '200', '1', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('39', '3', '39', null, '200', '1', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('40', '3', '40', null, '200', '1', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('41', '3', '41', null, '512', '0', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('42', '3', '42', null, '64', '0', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('43', '3', '43', null, '64', '0', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('44', '3', '44', null, '64', '0', null, null, '1', '2017-07-07 08:30:21', null, null, '0');
INSERT INTO `field_config` VALUES ('45', '3', '45', null, '200', '0', null, null, '46', '2017-11-02 15:43:56', null, null, '0');
INSERT INTO `field_config` VALUES ('46', '3', '46', null, '200', '0', null, null, '1', '2017-11-04 18:45:57', null, null, '0');

-- ----------------------------
-- Table structure for field_group
-- ----------------------------
DROP TABLE IF EXISTS `field_group`;
CREATE TABLE `field_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `business_object_id` bigint(20) DEFAULT NULL COMMENT '业务对象id',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父id',
  `name` varchar(32) DEFAULT NULL COMMENT '名字',
  `code` varchar(32) DEFAULT NULL COMMENT '编码(已经废弃，用id去区分唯一)',
  `description` varchar(512) DEFAULT NULL COMMENT '描述',
  `is_share` tinyint(4) DEFAULT '0' COMMENT '是否共用，0：否，1：是',
  `is_enabled` tinyint(4) DEFAULT '1' COMMENT '是否启用，0：否，1：是',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否删除，1：是；0：否',
  PRIMARY KEY (`id`),
  KEY `i_tenant_id` (`tenant_id`),
  KEY `i_parent_id` (`parent_id`),
  KEY `i_name` (`name`),
  KEY `i_create_user_id` (`create_user_id`),
  KEY `i_update_user_id` (`update_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='业务对象字段分组';

-- ----------------------------
-- Records of field_group
-- ----------------------------
INSERT INTO `field_group` VALUES ('1', '3', '1', '0', '阳光私募', 'private', null, '0', '1', null, null, null, null, '0');
INSERT INTO `field_group` VALUES ('2', '3', '1', '0', '私募股权', 'stock', null, '0', '1', null, null, null, null, '0');
INSERT INTO `field_group` VALUES ('3', '3', '1', '0', '固定收益', 'fix', null, '0', '1', null, null, null, null, '0');
INSERT INTO `field_group` VALUES ('4', '3', '1', '0', '私募基金', 'common', null, '1', '1', null, null, null, null, '0');
INSERT INTO `field_group` VALUES ('5', null, '1', '0', '保险产品', null, null, '0', '1', '46', '2017-11-02 15:44:18', null, null, '0');

-- ----------------------------
-- Table structure for field_group_rel
-- ----------------------------
DROP TABLE IF EXISTS `field_group_rel`;
CREATE TABLE `field_group_rel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `field_group_id` bigint(20) DEFAULT NULL COMMENT '业务对象字段分组id',
  `object_field_id` bigint(20) DEFAULT NULL COMMENT '业务对象字段id',
  `sequence` int(11) DEFAULT '1' COMMENT '排序，越小越靠前',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，1：是；0：否',
  PRIMARY KEY (`id`),
  KEY `i_tenant_id` (`tenant_id`),
  KEY `i_create_user_id` (`create_user_id`),
  KEY `i_update_user_id` (`update_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=367 DEFAULT CHARSET=utf8 COMMENT='业务对象字段分组关联';

-- ----------------------------
-- Records of field_group_rel
-- ----------------------------
INSERT INTO `field_group_rel` VALUES ('155', null, '1', '19', '20', '1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('156', null, '1', '20', '20', '1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('157', null, '1', '21', '20', '1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('158', null, '1', '22', '20', '1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('159', null, '1', '23', '20', '1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('160', null, '1', '24', '20', '1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('161', null, '1', '25', '20', '1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('162', null, '1', '26', '20', '1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('163', null, '1', '27', '20', '1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('164', null, '2', '24', '20', '1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('165', null, '2', '26', '20', '1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('166', null, '2', '28', '20', '1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('167', null, '2', '29', '20', '1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('168', null, '2', '30', '20', '1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('169', null, '2', '31', '20', '1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('170', null, '2', '32', '20', '1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('171', null, '3', '33', '20', '1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('172', null, '3', '34', '20', '1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('173', null, '3', '35', '20', '1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('174', null, '3', '36', '20', '1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('175', null, '3', '37', '20', '1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('176', null, '3', '38', '20', '1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('177', null, '3', '39', '20', '1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('178', null, '3', '40', '20', '1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('179', null, '1', '1', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('180', null, '2', '1', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('181', null, '3', '1', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('182', null, '4', '1', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('186', null, '1', '2', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('187', null, '2', '2', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('188', null, '3', '2', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('189', null, '4', '2', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('193', null, '1', '3', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('194', null, '2', '3', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('195', null, '3', '3', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('196', null, '4', '3', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('200', null, '1', '4', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('201', null, '2', '4', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('202', null, '3', '4', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('203', null, '4', '4', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('207', null, '1', '5', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('208', null, '2', '5', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('209', null, '3', '5', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('210', null, '4', '5', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('214', null, '1', '6', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('215', null, '2', '6', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('216', null, '3', '6', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('217', null, '4', '6', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('221', null, '1', '7', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('222', null, '2', '7', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('223', null, '3', '7', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('224', null, '4', '7', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('228', null, '1', '8', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('229', null, '2', '8', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('230', null, '3', '8', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('231', null, '4', '8', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('235', null, '1', '9', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('236', null, '2', '9', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('237', null, '3', '9', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('238', null, '4', '9', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('242', null, '1', '10', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('243', null, '2', '10', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('244', null, '3', '10', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('245', null, '4', '10', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('249', null, '1', '11', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('250', null, '2', '11', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('251', null, '3', '11', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('252', null, '4', '11', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('256', null, '1', '12', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('257', null, '2', '12', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('258', null, '3', '12', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('259', null, '4', '12', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('263', null, '1', '13', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('264', null, '2', '13', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('265', null, '3', '13', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('266', null, '4', '13', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('270', null, '1', '14', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('271', null, '2', '14', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('272', null, '3', '14', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('273', null, '4', '14', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('277', null, '1', '15', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('278', null, '2', '15', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('279', null, '3', '15', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('280', null, '4', '15', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('284', null, '1', '16', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('285', null, '2', '16', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('286', null, '3', '16', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('287', null, '4', '16', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('291', null, '1', '17', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('292', null, '2', '17', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('293', null, '3', '17', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('294', null, '4', '17', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('298', null, '1', '18', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('299', null, '2', '18', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('300', null, '3', '18', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('301', null, '4', '18', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('305', null, '1', '41', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('306', null, '2', '41', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('307', null, '3', '41', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('308', null, '4', '41', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('312', null, '1', '42', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('313', null, '2', '42', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('314', null, '3', '42', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('315', null, '4', '42', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('319', null, '1', '43', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('320', null, '2', '43', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('321', null, '3', '43', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('322', null, '4', '43', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('326', null, '1', '44', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('327', null, '2', '44', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('328', null, '3', '44', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('329', null, '4', '44', '0', '-1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('333', '3', '1', '45', '1', '46', '2017-11-02 15:43:56', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('334', '3', '2', '45', '1', '46', '2017-11-02 15:43:56', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('335', '3', '3', '45', '1', '46', '2017-11-02 15:43:56', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('336', '3', '4', '45', '1', '46', '2017-11-02 15:43:56', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('337', '3', '5', '1', '1', null, '2017-11-02 15:44:18', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('338', '3', '5', '2', '2', null, '2017-11-02 15:44:18', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('339', '3', '5', '3', '3', null, '2017-11-02 15:44:18', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('340', '3', '5', '4', '4', null, '2017-11-02 15:44:18', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('341', '3', '5', '5', '5', null, '2017-11-02 15:44:18', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('342', '3', '5', '6', '6', null, '2017-11-02 15:44:18', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('343', '3', '5', '7', '7', null, '2017-11-02 15:44:18', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('344', '3', '5', '8', '8', null, '2017-11-02 15:44:18', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('345', '3', '5', '9', '9', null, '2017-11-02 15:44:18', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('346', '3', '5', '10', '10', null, '2017-11-02 15:44:18', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('347', '3', '5', '11', '11', null, '2017-11-02 15:44:18', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('348', '3', '5', '12', '12', null, '2017-11-02 15:44:18', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('349', '3', '5', '13', '13', null, '2017-11-02 15:44:18', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('350', '3', '5', '14', '14', null, '2017-11-02 15:44:18', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('351', '3', '5', '15', '15', null, '2017-11-02 15:44:18', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('352', '3', '5', '16', '16', null, '2017-11-02 15:44:18', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('353', '3', '5', '17', '17', null, '2017-11-02 15:44:18', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('354', '3', '5', '18', '18', null, '2017-11-02 15:44:18', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('355', '3', '5', '41', '19', null, '2017-11-02 15:44:18', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('356', '3', '5', '42', '20', null, '2017-11-02 15:44:18', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('357', '3', '5', '43', '21', null, '2017-11-02 15:44:18', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('358', '3', '5', '44', '22', null, '2017-11-02 15:44:18', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('359', '3', '5', '45', '23', null, '2017-11-02 15:44:18', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('360', '3', '5', '46', '0', '-1', '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('361', '3', '1', '46', '0', '-1', '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('362', '3', '2', '46', '0', '-1', '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('363', '3', '3', '46', '0', '-1', '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `field_group_rel` VALUES ('364', '3', '4', '46', '0', '-1', '2017-11-04 18:45:57', null, null, '0');

-- ----------------------------
-- Table structure for field_role
-- ----------------------------
DROP TABLE IF EXISTS `field_role`;
CREATE TABLE `field_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `object_field_id` bigint(20) DEFAULT NULL COMMENT '业务对象字段id',
  `role_id` bigint(20) DEFAULT '0' COMMENT '角色id（0：针对所有角色）',
  `is_role_readonly` tinyint(4) DEFAULT '1' COMMENT '是否角色只读，0：否，1：是',
  `is_role_access` tinyint(4) DEFAULT '1' COMMENT '是否角色访问，0：否，1：是',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，1：是；0：否',
  PRIMARY KEY (`id`),
  KEY `i_tenant_id` (`tenant_id`),
  KEY `i_create_user_id` (`create_user_id`),
  KEY `i_update_user_id` (`update_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务对象字段角色访问';

-- ----------------------------
-- Records of field_role
-- ----------------------------

-- ----------------------------
-- Table structure for field_type
-- ----------------------------
DROP TABLE IF EXISTS `field_type`;
CREATE TABLE `field_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `name` varchar(32) DEFAULT NULL COMMENT '名字',
  `code` varchar(64) DEFAULT NULL COMMENT '编码',
  `description` varchar(512) DEFAULT NULL COMMENT '描述',
  `demo_picture` varchar(256) DEFAULT NULL COMMENT '演示图片',
  `type` tinyint(4) DEFAULT NULL COMMENT '类型，1：文本，2：文本域，3：图片，4：日期，5：日期区间，6：下拉选项，7：单选，8：多选，9：数值，10：数值区间，11：地址',
  `is_search` tinyint(4) DEFAULT '0' COMMENT '是否可搜索，0：否，1：是',
  `is_share` tinyint(4) DEFAULT '0' COMMENT '是否共用，0：否，1：是',
  `is_enabled` tinyint(4) DEFAULT '1' COMMENT '是否启用，0：否，1：是',
  `sequence` int(11) DEFAULT '1' COMMENT '排序，越小越靠前',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，1：是；0：否',
  PRIMARY KEY (`id`),
  KEY `i_tenant_id` (`tenant_id`),
  KEY `i_name` (`name`),
  KEY `i_create_user_id` (`create_user_id`),
  KEY `i_update_user_id` (`update_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='业务对象字段类型';

-- ----------------------------
-- Records of field_type
-- ----------------------------
INSERT INTO `field_type` VALUES ('1', '3', '文本', 'text', '文本', null, '1', '0', '0', '1', '1', '-1', '2017-07-04 09:10:45', null, null, '0');
INSERT INTO `field_type` VALUES ('2', '3', '文本域', 'textarea', '文本域', null, '2', '0', '0', '1', '1', '-1', '2017-07-04 09:11:29', null, null, '0');
INSERT INTO `field_type` VALUES ('3', '3', '图片', 'image', '图片', null, '3', '0', '0', '1', '1', '-1', '2017-07-04 09:12:48', null, null, '0');
INSERT INTO `field_type` VALUES ('4', '3', '日期', 'date', '日期', null, '4', '0', '0', '1', '1', '-1', '2017-07-04 09:13:20', null, null, '0');
INSERT INTO `field_type` VALUES ('5', '3', '日期区间', 'date_range', '日期区间', null, '5', '0', '0', '1', '1', '-1', '2017-07-04 09:13:43', null, null, '0');
INSERT INTO `field_type` VALUES ('6', '3', '下拉选项', 'select', '下拉选项', null, '6', '0', '0', '1', '1', '-1', '2017-07-04 09:15:17', null, null, '0');
INSERT INTO `field_type` VALUES ('7', '3', '单选', 'radio', '单选', null, '7', '0', '0', '1', '1', '-1', '2017-07-04 09:15:45', null, null, '0');
INSERT INTO `field_type` VALUES ('8', '3', '多选', 'checkbox', '多选', null, '8', '0', '0', '1', '1', '-1', '2017-07-04 09:16:12', null, null, '0');
INSERT INTO `field_type` VALUES ('9', '3', '数值', 'number', '数值', null, '9', '0', '0', '1', '1', '-1', '2017-07-04 09:16:45', null, null, '0');
INSERT INTO `field_type` VALUES ('10', '3', '数值区间', 'number_range', '数值区间', null, '10', '0', '0', '1', '1', '-1', '2017-07-04 09:17:08', null, null, '0');
INSERT INTO `field_type` VALUES ('11', '3', '地址', 'address', '地址', null, '11', '0', '0', '1', '1', '-1', '2017-07-04 09:17:31', null, null, '0');

-- ----------------------------
-- Table structure for knot_commission
-- ----------------------------
DROP TABLE IF EXISTS `knot_commission`;
CREATE TABLE `knot_commission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `declaration_id` bigint(20) DEFAULT NULL COMMENT '报单ID',
  `type` varchar(32) DEFAULT NULL COMMENT '佣金类型',
  `rate` double DEFAULT NULL COMMENT '佣金费率',
  `amount` double DEFAULT NULL COMMENT '佣金金额',
  `provide_date` datetime DEFAULT NULL COMMENT '发放时间',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注',
  `status` tinyint(2) DEFAULT NULL COMMENT '1、待审批 2、已通过 3、已驳回',
  `operation_date` datetime DEFAULT NULL COMMENT '操作时间',
  `user_id` bigint(20) DEFAULT NULL COMMENT '流程发起人',
  `audit_date` datetime DEFAULT NULL COMMENT '审批时间',
  `apply_date` datetime DEFAULT NULL COMMENT '申请时间',
  `audit_reason` varchar(256) DEFAULT NULL COMMENT '审批原因',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `declaration_id_index` (`declaration_id`),
  KEY `tenant_id_index` (`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='结佣记录表';

-- ----------------------------
-- Records of knot_commission
-- ----------------------------

-- ----------------------------
-- Table structure for leads
-- ----------------------------
DROP TABLE IF EXISTS `leads`;
CREATE TABLE `leads` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户id',
  `type` tinyint(4) DEFAULT NULL COMMENT '线索类型，1：预约产品；2：注册；',
  `channel` tinyint(4) DEFAULT NULL COMMENT '渠道，1：网站；2：服务号',
  `content` varchar(128) DEFAULT NULL COMMENT '内容',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  `follow_remark` varchar(128) DEFAULT NULL COMMENT '跟进备注',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态，0：未处理；1：已联系；2：关闭',
  `object_id` bigint(20) DEFAULT NULL COMMENT '对象id',
  `process_user_id` bigint(20) DEFAULT NULL COMMENT '处理人id',
  `process_date` datetime DEFAULT NULL COMMENT '处理时间',
  `is_once_invalid` tinyint(4) DEFAULT '0' COMMENT '线索所属客户的状态，是否曾经被设置过无效，0：否，1：是，默认0',
  `is_alloted_cs` tinyint(4) DEFAULT NULL COMMENT '是否已被分配给客服，0：否，1：是',
  `is_alloted_fp` tinyint(4) DEFAULT NULL COMMENT '是否已被分配给理财师，0：否，1：是',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='销售线索';

-- ----------------------------
-- Records of leads
-- ----------------------------

-- ----------------------------
-- Table structure for leads_visit_rel
-- ----------------------------
DROP TABLE IF EXISTS `leads_visit_rel`;
CREATE TABLE `leads_visit_rel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `leads_id` bigint(20) DEFAULT NULL COMMENT '线索id',
  `user_visit_id` bigint(20) DEFAULT NULL COMMENT '回访id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='线索回访关系表';

-- ----------------------------
-- Records of leads_visit_rel
-- ----------------------------

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `user_account_id` bigint(20) DEFAULT NULL COMMENT '用户账号id',
  `login_date` datetime DEFAULT NULL COMMENT '登录日期',
  `login_ip` varchar(32) DEFAULT NULL COMMENT '登录ip',
  `login_address` varchar(128) DEFAULT NULL COMMENT '登录地址',
  `result_code` int(11) DEFAULT NULL COMMENT '结果码',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编码',
  `login_type` tinyint(2) DEFAULT '0' COMMENT '登录类型，0：浏览器，1：APP',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `i_user_account_id` (`user_account_id`),
  KEY `i_tenant_id` (`tenant_id`),
  KEY `i_create_user_id` (`create_user_id`),
  KEY `i_update_user_id` (`update_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='登录日志表';

-- ----------------------------
-- Records of login_log
-- ----------------------------

-- ----------------------------
-- Table structure for msg_feed
-- ----------------------------
DROP TABLE IF EXISTS `msg_feed`;
CREATE TABLE `msg_feed` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `template_id` bigint(20) DEFAULT NULL COMMENT '模板ID',
  `seq_no` varchar(64) DEFAULT NULL COMMENT '唯一码',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户id',
  `template_code` varchar(64) DEFAULT NULL COMMENT '模板code',
  `params` varchar(1024) DEFAULT NULL COMMENT '参数',
  `type` tinyint(2) DEFAULT NULL COMMENT ' 1、客户  2、交易 ',
  `opt_time` datetime DEFAULT NULL COMMENT '真实时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  `first_type` tinyint(2) DEFAULT NULL COMMENT '一级类型  1客户行为  2服务轨迹',
  PRIMARY KEY (`id`),
  KEY `tenant_id_index` (`template_id`),
  KEY `user_id_index` (`user_id`),
  KEY `customer_index` (`customer_id`),
  KEY `template_id_index` (`template_id`),
  KEY `opt_time_index` (`opt_time`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='动态';

-- ----------------------------
-- Records of msg_feed
-- ----------------------------
INSERT INTO `msg_feed` VALUES ('1', '3', '46', '1', '59d6f744d9194c548d3a3fc9d432bfc8', '10000', 'add_customer', '{\"createUserId\":46,\"level\":2,\"isDelete\":0,\"sex\":0,\"mobile\":\"DB8ACC6CE32EC4D0252112B301BF816B\",\"createUserName\":\"测试\",\"number\":\"00010000\",\"name\":\"客户001\",\"tenantId\":3,\"customerId\":10000,\"id\":10000,\"createDate\":\"2017-11-02 15:49:45:372\",\"status\":1}', '1', null, '46', '2017-11-02 15:49:45', null, null, '0', '2');
INSERT INTO `msg_feed` VALUES ('2', '3', '46', '30', '6bf4d23cdd704585bf311d7ef7364c5e', '10000', 'reservation_approved', '{\"reason\":null,\"estimatePayDate\":\"2017-11-02\",\"reservationId\":1,\"customerId\":10000,\"reservationAmount\":\"300\",\"createUserName\":\"测试\",\"userId\":46,\"customerName\":\"客户001\",\"productName\":\"保险产品001\"}', '7', null, '46', '2017-11-02 15:50:14', null, null, '0', '2');
INSERT INTO `msg_feed` VALUES ('3', '3', '46', '20', '31fcfcf1b5b349bd82259fa4107c4301', '10000', 'declaration_audio_pass', '{\"dealTime\":\"2017-11-02\",\"audioName\":\"测试\",\"dealAmount\":\"300.0万\",\"customerId\":10000,\"id\":1,\"userId\":46,\"productName\":\"保险产品001\",\"customerName\":\"客户001\"}', '2', null, '46', '2017-11-02 15:51:54', null, null, '0', '2');

-- ----------------------------
-- Table structure for msg_message
-- ----------------------------
DROP TABLE IF EXISTS `msg_message`;
CREATE TABLE `msg_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `feed_user_id` bigint(20) DEFAULT NULL COMMENT '查看消息的用户',
  `template_id` bigint(20) DEFAULT NULL COMMENT '模板id',
  `title` varchar(64) DEFAULT NULL COMMENT '标题',
  `seq_no` varchar(64) DEFAULT NULL COMMENT '唯一码',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户id',
  `read_status` tinyint(2) DEFAULT '1' COMMENT '1未读 2已读',
  `template_code` varchar(64) DEFAULT NULL COMMENT '模板code',
  `params` varchar(1024) DEFAULT NULL COMMENT '参数',
  `first_type` tinyint(2) DEFAULT NULL COMMENT '一级消息 1、代办 ，2、消息',
  `two_type` tinyint(2) DEFAULT NULL COMMENT '二级类型  1、客户 ，2、产品 ，3、待回访，4、待跟进，5、待审核，6、待确认，7、交易',
  `opt_time` datetime DEFAULT NULL COMMENT '真实发生时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `tenant_id_index` (`template_id`),
  KEY `user_id_index` (`feed_user_id`),
  KEY `template_id_index` (`template_id`),
  KEY `opt_time_index` (`opt_time`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='消息表';

-- ----------------------------
-- Records of msg_message
-- ----------------------------
INSERT INTO `msg_message` VALUES ('1', '3', '46', '6', '有待上线审批的产品', '2873fcab1b0346ae9eb50ebe42074c57', null, '1', 'product_on_line_audit', '{\"productId\":1,\"userIds\":\"46,48\",\"productTypeName\":\"保险产品\",\"productName\":\"保险产品001\",\"submitUserRealName\":\"测试\"}', '1', '4', null, '46', '2017-11-02 15:48:56', null, null, '0');
INSERT INTO `msg_message` VALUES ('2', '3', '48', '6', '有待上线审批的产品', '33f3e991522d47a6a54971fcae9ba091', null, '1', 'product_on_line_audit', '{\"productId\":1,\"userIds\":\"46,48\",\"productTypeName\":\"保险产品\",\"productName\":\"保险产品001\",\"submitUserRealName\":\"测试\"}', '1', '4', null, '46', '2017-11-02 15:48:56', null, null, '0');
INSERT INTO `msg_message` VALUES ('3', '3', '46', '4', '新产品上线', '03e084d8d99e4d9991683dc9b4cacff1', null, '1', 'product_on_line', '{\"productId\":1,\"userIds\":\"46,47,48\",\"productTypeName\":\"保险产品\",\"productName\":\"保险产品001\"}', '2', '2', null, '46', '2017-11-02 15:49:18', null, null, '0');
INSERT INTO `msg_message` VALUES ('4', '3', '47', '4', '新产品上线', 'dffcd15b39ec4bd388f19cd2b42ce6fd', null, '1', 'product_on_line', '{\"productId\":1,\"userIds\":\"46,47,48\",\"productTypeName\":\"保险产品\",\"productName\":\"保险产品001\"}', '2', '2', null, '46', '2017-11-02 15:49:18', null, null, '0');
INSERT INTO `msg_message` VALUES ('5', '3', '48', '4', '新产品上线', '748d2e7df4694e92ae7d343a116752e0', null, '1', 'product_on_line', '{\"productId\":1,\"userIds\":\"46,47,48\",\"productTypeName\":\"保险产品\",\"productName\":\"保险产品001\"}', '2', '2', null, '46', '2017-11-02 15:49:18', null, null, '0');
INSERT INTO `msg_message` VALUES ('6', '3', '46', '28', '额度预约待确认', '15d3ff5c63524b0397fefe9159fd6b1f', null, '1', 'reservation_audit_todo', '{\"userIds\":\"46,48\",\"reservationAmount\":\"300\",\"userName\":\"测试\",\"productName\":\"保险产品001\"}', '1', '6', null, '46', '2017-11-02 15:50:05', null, null, '0');
INSERT INTO `msg_message` VALUES ('7', '3', '48', '28', '额度预约待确认', '53603ce9f05c42de87b7b1513be31c71', null, '1', 'reservation_audit_todo', '{\"userIds\":\"46,48\",\"reservationAmount\":\"300\",\"userName\":\"测试\",\"productName\":\"保险产品001\"}', '1', '6', null, '46', '2017-11-02 15:50:05', null, null, '0');
INSERT INTO `msg_message` VALUES ('8', '3', '46', '30', '额度预约已确认', 'cec16c30053b4e508d5cc1fd61a1ee63', '10000', '1', 'reservation_approved', '{\"reason\":null,\"estimatePayDate\":\"2017-11-02\",\"reservationId\":1,\"customerId\":10000,\"reservationAmount\":\"300\",\"createUserName\":\"测试\",\"userId\":46,\"customerName\":\"客户001\",\"productName\":\"保险产品001\"}', '2', '7', null, '46', '2017-11-02 15:50:14', null, null, '0');
INSERT INTO `msg_message` VALUES ('9', '3', '46', '29', '报单待审批', 'a9bc321490684bd980e8abe13e7a2db5', null, '1', 'declaration_audit_todo', '{\"dealAmount\":\"300\",\"userIds\":\"46,48\",\"userName\":\"测试\",\"productName\":\"保险产品001\",\"payDate\":\"2017-11-02\"}', '1', '5', null, '46', '2017-11-02 15:50:29', null, null, '0');
INSERT INTO `msg_message` VALUES ('10', '3', '48', '29', '报单待审批', '1318961aa29742659fadad6d1611e53c', null, '1', 'declaration_audit_todo', '{\"dealAmount\":\"300\",\"userIds\":\"46,48\",\"userName\":\"测试\",\"productName\":\"保险产品001\",\"payDate\":\"2017-11-02\"}', '1', '5', null, '46', '2017-11-02 15:50:29', null, null, '0');
INSERT INTO `msg_message` VALUES ('11', '3', '46', '20', '报单审批通过', 'a697c96d25bf46a3ab8e35152955df39', '10000', '1', 'declaration_audio_pass', '{\"dealTime\":\"2017-11-02\",\"audioName\":\"测试\",\"dealAmount\":\"300.0万\",\"customerId\":10000,\"id\":1,\"userId\":46,\"productName\":\"保险产品001\",\"customerName\":\"客户001\"}', '2', '7', null, '46', '2017-11-02 15:51:54', null, null, '0');

-- ----------------------------
-- Table structure for msg_template
-- ----------------------------
DROP TABLE IF EXISTS `msg_template`;
CREATE TABLE `msg_template` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `title` varchar(128) DEFAULT NULL COMMENT '标题',
  `feed_content` varchar(512) DEFAULT NULL COMMENT '动态内容',
  `message_content` varchar(512) DEFAULT NULL COMMENT '消息的内容',
  `app_content` varchar(512) DEFAULT NULL COMMENT 'app内容',
  `need_push` tinyint(2) DEFAULT NULL COMMENT '1 不需要 2需要',
  `push_content` varchar(128) DEFAULT NULL COMMENT 'push内容',
  `index_content` varchar(128) DEFAULT NULL COMMENT '首页内容',
  `app_action` varchar(128) DEFAULT NULL COMMENT 'app动作',
  `pc_action` varchar(128) DEFAULT NULL COMMENT 'pc跳转动作',
  `code` varchar(32) DEFAULT NULL COMMENT '唯一编码',
  `params` varchar(1024) DEFAULT NULL COMMENT '验证参数',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `code_index` (`code`),
  KEY `tenant_id_index` (`feed_content`(255))
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='动态模板';

-- ----------------------------
-- Records of msg_template
-- ----------------------------
INSERT INTO `msg_template` VALUES ('1', null, '新增客户', '新增客户\r\n操作人：$!{createUserName}', null, null, '0', null, null, null, null, 'add_customer', '', '新增客户', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('2', null, '客户待跟进', '', '您计划于$!{nextFollowDate} 跟进客户（$!{name}$!{mobile}），请及时跟进', '您计划于$!{nextFollowDate} 跟进客户（$!{name}$!{mobile}），请及时跟进', '0', null, '跟进客户（$!{name}，$!{mobile}）', 'yundaojinfub://www.yundaocustomer.com/customer_detail?customerId=$!{customerId}', null, 'next_follow', '{\"customerId\":{\"isBlank\":false,\"message\":\"客户ID不能为空\"},\"userId\":{\"isBlank\":false,\"message\":\"理财师ID不能为空\"},\"name\":{\"isBlank\":false,\"message\":\"客户名称不能为空\"},\"mobile\":{\"isBlank\":false,\"message\":\"客户手机号不能为空\"},\"nextFollowDate\":{\"isBlank\":false,\"message\":\"下次跟进时间不能为空\"}}', '下次跟进', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('3', null, '客户跟进', '客户跟进：$!{content}\n方式：$!{typeName} 状态：$!{statusName} ,操作人：$!{createUserName}', null, null, '0', null, null, null, null, 'customer_follow', '{\"customerId\":{\"isBlank\":false,\"message\":\"客户ID不能为空\"},\"content\":{\"isBlank\":false,\"message\":\"跟进内容不允许为空\"},\"typeName\":{\"isBlank\":false,\"message\":\"跟进类型不允许为空\"},\"createUserName\":{\"isBlank\":false,\"message\":\"跟进状态\"}}', '客户跟进', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('4', null, '新产品上线', '', '$!{productTypeName}类产品$!{productName}上线了，敬请关注', '$!{productTypeName}类产品$!{productName}上线了，敬请关注', '0', null, null, 'yundaojinfub://www.yundaoproduct.com/product_detail?productId=$!{productId}&productName=$!{productName}', '/product/detail/$!{productId}', 'product_on_line', '{\"productId\":{\"isBlank\":false,\"message\":\"产品ID不能为空\"},\"productName\":{\"isBlank\":false,\"message\":\"产品名称不能为空\"},\"productTypeName\":{\"isBlank\":false,\"message\":\"产品类型名称不能为空\"}}', '新产品上线', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('5', null, '项目附件更新', null, '$!{productName}产品的附件$!{attachSourceName}有更新，敬请关注', '$!{productName}产品的附件$!{attachSourceName}有更新，敬请关注', '0', null, null, 'yundaojinfub://www.yundaoproduct.com/product_detail?productId=$!{productId}&productName=$!{productName}', '/product/detail/$!{productId}?tab=info', 'product_add_attach', '{\"productId\":{\"isBlank\":false,\"message\":\"产品ID不能为空\"},\"productName\":{\"isBlank\":false,\"message\":\"产品名称不能为空\"},\"attachSourceName\":{\"isBlank\":false,\"message\":\"产品附件名称不能为空\"}}', '项目附件更新', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('6', null, '有待上线审批的产品', null, '用户$!{submitUserRealName}提交产品上线审批（$!{productTypeName}，$!{productName}），请及时处理', '用户$!{submitUserRealName}提交产品上线审批（$!{productTypeName}，$!{productName}），请及时处理', '0', null, null, null, '/product/control/audit', 'product_on_line_audit', '{\"productId\":{\"isBlank\":false,\"message\":\"产品ID不能为空\"},\"productName\":{\"isBlank\":false,\"message\":\"产品名称不能为空\"},\"productTypeName\":{\"isBlank\":false,\"message\":\"产品类型名称不能为空\"}}', '有待上线审批的产品', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('7', null, '客户回退申请已通过', '客户回退到客户池\r\n申请人：$!{applyUserName}，操作人：$!{auditUserName}', '您的客户（$!{customerName}，$!{customerMobile}）回退申请被$!{auditUserName} 审批通过，已回退到客户池', '您的客户（$!{customerName}，$!{customerMobile}）回退申请被$!{auditUserName} 审批通过，已回退到客户池', '0', null, null, null, null, 'customer_back_examine_pass', '{\"customerName\":{\"isBlank\":false,\"message\":\"客户名称不能为空\"},\"customerMobile\":{\"isBlank\":false,\"message\":\"客户手机号不能为空\"},\"auditUserName\":{\"isBlank\":false,\"message\":\"审批人名称不能为空\"},\"applyUserName\":{\"isBlank\":false,\"message\":\"申请人名称不能为空\"}}', '客户回退-审批通过', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('8', null, '客户回退申请被驳回', '客户回退被驳回，原因：$!{rejectReason}\r\n操作人：$!{auditUserName}', '您的客户（$!{customerName}，$!{customerMobile}）回退申请被$!{auditUserName} 驳回，原因$!{rejectReason}', '您的客户（$!{customerName}，$!{customerMobile}）回退申请被$!{auditUserName} 驳回，原因$!{rejectReason}', '0', null, null, null, null, 'customer_back_examine_reject', '{\"customerName\":{\"isBlank\":false,\"message\":\"客户名称不能为空\"},\"customerMobile\":{\"isBlank\":false,\"message\":\"客户手机号不能为空\"},\"auditUserName\":{\"isBlank\":false,\"message\":\"审批人名称不能为空\"}}', '客户回退-驳回', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('9', null, '产品公告发布', null, '$!{productName}产品发布新公告（$!{typeName}，$!{title}），请及时关注', '$!{productName}产品发布新公告（$!{typeName}，$!{title}），请及时关注', '0', null, null, 'yundaojinfub://www.yundaoproduct.com/product_notice_detail?noticeId=$!{id}', '/product/detail/$!{productId}?tab=announce', 'send_notice', '{\"id\":{\"isBlank\":false,\"message\":\"公告ID不能为空\"},\"userIds\":{\"isBlank\":false,\"message\":\"发送人IDS不能为空\"},\"productName\":{\"isBlank\":false,\"message\":\"产品名称不能为空\"},\"typeName\":{\"isBlank\":false,\"message\":\"公告类型不能为空\"},\"title\":{\"isBlank\":false,\"message\":\"公告标题不能为空\"},\"productId\":{\"isBlank\":false,\"message\":\"产品ID不能为空\"}}', '产品公告发布', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('10', null, '有待发布审批的公告', null, '用户$!{realName}提交公告发布审批（$!{productName}），$!{typeName}，$!{title}）请及时处理', '用户$!{realName}提交公告发布审批（$!{productName}），$!{typeName}，$!{title}）请及时处理', '0', null, null, null, '/product/notice/audit', 'product_notice_audit', '{\"userIds\":{\"isBlank\":false,\"message\":\"发送人IDS不能为空\"},\"productName\":{\"isBlank\":false,\"message\":\"产品名称不能为空\"},\"typeName\":{\"isBlank\":false,\"message\":\"公告类型不能为空\"},\"title\":{\"isBlank\":false,\"message\":\"公告标题不能为空\"},\"realName\":{\"isBlank\":false,\"message\":\"用户名不能为空\"}}', '有待发布审批的公告', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('11', null, '回访了您的客户', '客户回访：$!{content}\r\n方式：$!{type}，状态：$!{status}，操作人：$!{visitOperationUserName}', '$!{visitOperationUserName} 对您的客户$!{customerName}进行了回访：$!{content}', '$!{visitOperationUserName} 对您的客户$!{customerName}进行了回访：$!{content}', '0', null, null, 'yundaojinfub://www.yundaocustomer.com/customer_detail/callback?customerId=$!{customerId}', '/customer/detail/$!{customerId}?tab=visit', 'customer_visit', '{\"userId\":{\"isBlank\":false,\"message\":\"发送人不能为空\"},\"customerId\":{\"isBlank\":false,\"message\":\"客户ID不能为空\"},\"customerName\":{\"isBlank\":false,\"message\":\"客户名称不能为空\"},\"type\":{\"isBlank\":false,\"message\":\"回访方式不能为空\"},\"status\":{\"isBlank\":false,\"message\":\"回访状态不能为空\"}}', '回访了您的客户', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('12', null, '客户待回访', null, '您计划于$!{nextTime} 回访客户（$!{customerName}，$!{customerMobile}），请及时处理', '您计划于$!{nextTime} 回访客户（$!{customerName}，$!{customerMobile}），请及时处理', '0', null, '回访客户（$!{customerName}，$!{customerMobile}）', null, '/operation/allot', 'customer_next_visit', null, '客户待回访', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('17', null, '给您调配了新客户', '客户调配：客户调配到$!{fpName}名下\n操作人：$!{createUserName}', '$!{createUserName} 给你调配了新客户（$!{name}，$!{mobile}），请及时跟进', '$!{createUserName} 给你调配了新客户（$!{name}，$!{mobile}），请及时跟进', '0', null, '', 'yundaojinfub://www.yundaocustomer.com/customer_list', '/customer/my', 'customer_allot', '', '单个客户调配', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('18', null, '给您调配了新客户', '客户调配：客户调配到$!{fpName}名下\n操作人：$!{createUserName}', '$!{createUserName} 给你调配了$!{customerNum}位新客户，请及时跟进', '$!{createUserName} 给你调配了$!{customerNum}位新客户，请及时跟进', '0', null, '', 'yundaojinfub://www.yundaocustomer.com/customer_list', '/customer/my', 'customer_allot_multi', '', '批量客户调配', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('19', null, '客户回收到客户池', '客户回收到客户池\n操作人：$!{createUserName}', '您的客户（$!{customerName}，$!{mobile}）已被$!{createUserName} 回收到客户池', '您的客户（$!{customerName}，$!{mobile}）已被$!{createUserName} 回收到客户池', '0', null, '', null, '', 'customer_recycle', null, '批量客户回收', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('20', null, '报单审批通过', '您为客户$!{customerName}认购（$!{productName}，$!{dealAmount}，$!{dealTime}）的报单已确认', '报单确认：$!{productName}，打款金额$!{dealAmount}，打款日期$!{dealTime}\r\n操作人：$!{audioName}', '您为客户$!{customerName}认购（$!{productName}，$!{dealAmount}，$!{dealTime}）的报单已确认', '0', null, null, 'yundaojinfub://www.yundaoorder.com/order_detail?orderId=$!{id}', '/declaration/detail/$!{id}', 'declaration_audio_pass', '{\"userId\":{\"isBlank\":false,\"message\":\"发送人ID不能为空\"},\"id\":{\"isBlank\":false,\"message\":\"报单ID不能为空\"},\"productName\":{\"isBlank\":false,\"message\":\"产品名称不能为空\"},\"dealAmount\":{\"isBlank\":false,\"message\":\"打款金额不能为空\"},\"audioName\":{\"isBlank\":false,\"message\":\"报单审批人不能为空\"},\"dealTime\":{\"isBlank\":false,\"message\":\"打款时间不能为空\"}}', '报单审批通过', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('21', null, '报单被驳回', '您为客户$!{customerName}认购（$!{productName}，$!{dealAmount}，$!{dealTime}）的报单被$!{audioName} 驳回，原因$!{reason}', '您为客户$!{customerName}认购（$!{productName}，$!{dealAmount}，$!{dealTime}）的报单被$!{audioName} 驳回，原因$!{reason}', '您为客户$!{customerName}认购（$!{productName}，$!{dealAmount}，$!{dealTime}）的报单被$!{audioName} 驳回，原因$!{reason}', '0', null, null, 'yundaojinfub://www.yundaoorder.com/order_detail?orderId=$!{id}', '/declaration/detail/$!{id}', 'declaration_audio_reject', '{\"userId\":{\"isBlank\":false,\"message\":\"发送人ID不能为空\"},\"productName\":{\"isBlank\":false,\"message\":\"产品名称不能为空\"},\"dealAmount\":{\"isBlank\":false,\"message\":\"打款金额不能为空\"},\"audioName\":{\"isBlank\":false,\"message\":\"报单审批人不能为空\"},\"dealTime\":{\"isBlank\":false,\"message\":\"打款时间不能为空\"},\"reason\":{\"isBlank\":false,\"message\":\"驳回原因不能为空\"},\"id\":{\"isBlank\":false,\"message\":\"报单不能为空\"}}', '报单被驳回', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('22', null, 'C端客户注册', '客户完成注册\r\n渠道：$!{channel}', '客户$!{customerName}在$!{channel}完成注册，请及时跟进', '客户$!{customerName}在$!{channel}完成注册，请及时跟进', '0', null, null, 'yundaojinfub://www.yundaocustomer.com/customer_detail/callback?customerId=$!{customerId}', '/customer/detail/$!{customerId}', 'c_add_customer', '{\"customerName\":{\"isBlank\":false,\"message\":\"客户名称不能为空\"},\"channel\":{\"isBlank\":false,\"message\":\"注册渠道不能为空\"},\"customerId\":{\"isBlank\":false,\"message\":\"客户ID不能为空\"}}', 'C端客户注册', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('23', null, '客户登录', '客户登录\r\n渠道：$!{channel}', '客户$!{customerName}在$!{channel}登录，请及时跟进\r\n', '客户$!{customerName}在$!{channel}登录，请及时跟进\r\n', '0', null, null, 'yundaojinfub://www.yundaocustomer.com/customer_detail/callback?customerId=$!{customerId}', '/customer/detail/$!{customerId}', 'c_login_customer', '{\"customerName\":{\"isBlank\":false,\"message\":\"客户名称不能为空\"},\"channel\":{\"isBlank\":false,\"message\":\"登陆渠道不能为空\"},\"customerId\":{\"isBlank\":false,\"message\":\"客户ID不能为空\"}}', 'C端客户登陆', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('24', null, '客户提交测评结果', '客户完成测评\r\n测评结果：$!{evaluating}，渠道：$!{channel}', '客户$!{customerName}完成风险测评，测评结果：$!{evaluating}，渠道：$!{channel}，请及时跟进', '客户$!{customerName}完成风险测评，测评结果：$!{evaluating}，渠道：$!{channel}，请及时跟进', '0', null, null, 'yundaojinfub://www.yundaocustomer.com/customer_detail/callback?customerId=$!{customerId}', '/customer/detail/$!{customerId}', 'c_evaluating_customer', '{\"customerName\":{\"isBlank\":false,\"message\":\"客户名称不能为空\"},\"channel\":{\"isBlank\":false,\"message\":\"注册渠道不能为空\"},\"evaluating\":{\"isBlank\":false,\"message\":\"评测结果不能为空\"},\"customerId\":{\"isBlank\":false,\"message\":\"客户ID不能为空\"}}', 'C端客户评测', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('25', null, '客户查看产品详情\r\n', '客户查看产品详情\r\n产品名称：$!{productName}，渠道：$!{channel}', '客户$!{customerName}查看了$!{productType}类产品$!{productName}详情，渠道：$!{channel}，请及时跟进', '客户$!{customerName}查看了$!{productType}类产品$!{productName}详情，渠道：$!{channel}，请及时跟进', '0', null, null, 'yundaojinfub://www.yundaocustomer.com/customer_detail/callback?customerId=$!{customerId}', '/customer/detail/$!{customerId}', 'c_view_product', '{\"productType\":{\"isBlank\":false,\"message\":\"产品类型不能为空\"},\"customerName\":{\"isBlank\":false,\"message\":\"客户名称不能为空\"},\"channel\":{\"isBlank\":false,\"message\":\"注册渠道不能为空\"},\"productName\":{\"isBlank\":false,\"message\":\"产品名称不能为空\"},\"customerId\":{\"isBlank\":false,\"message\":\"客户ID不能为空\"}}', '客户查看产品详情', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('26', null, '客户预约咨询产品', '客户预约咨询产品\r\n产品名称：$!{productName}，渠道：$!{channel}', '客户$!{customerName}预约咨询了$!{productType}类产品$!{productName}，渠道：$!{channel}，请及时跟进', '客户$!{customerName}预约咨询了$!{productType}类产品$!{productName}，渠道：$!{channel}，请及时跟进', '0', null, null, 'yundaojinfub://www.yundaocustomer.com/customer_detail/callback?customerId=$!{customerId}', '/customer/detail/$!{customerId}', 'c_reservation', '{\"productType\":{\"isBlank\":false,\"message\":\"产品类型不能为空\"},\"customerName\":{\"isBlank\":false,\"message\":\"客户名称不能为空\"},\"channel\":{\"isBlank\":false,\"message\":\"注册渠道不能为空\"},\"productName\":{\"isBlank\":false,\"message\":\"产品名称不能为空\"},\"customerId\":{\"isBlank\":false,\"message\":\"客户ID不能为空\"}}', '客户预约咨询产品', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('27', null, '客户查看公告详情', '客户查看公告详情\r\n公告标题：$!{title}，公告类型：$!{typeText}，产品名称：$!{productName}，渠道：$!{channel}', '客户$!{customerName}查看了$!{productName}的$!{typeText}公告：$!{title}，渠道：$!{channel}，请及时跟进', '客户$!{customerName}查看了$!{productName}的$!{typeText}公告：$!{title}，渠道：$!{channel}，请及时跟进', '0', null, null, 'yundaojinfub://www.yundaocustomer.com/customer_detail/callback?customerId=$!{customerId}', '/customer/detail/$!{customerId}', 'c_view_notice', '{\"typeText\":{\"isBlank\":false,\"message\":\"公告类型不能为空\"},\"title\":{\"isBlank\":false,\"message\":\"公告标题不能为空\"},\"customerName\":{\"isBlank\":false,\"message\":\"客户名称不能为空\"},\"channel\":{\"isBlank\":false,\"message\":\"注册渠道不能为空\"},\"productName\":{\"isBlank\":false,\"message\":\"产品名称不能为空\"},\"customerId\":{\"isBlank\":false,\"message\":\"客户ID不能为空\"}}', '客户查看公告详情', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('28', null, '额度预约待确认', null, '用户$!{userName}发起额度预约（$!{productName}，$!{reservationAmount}万），请及时处理', '确认额度预约（$!{productName}，$!{reservationAmount}万）', '0', null, null, '', '/sale/appointment/audit', 'reservation_audit_todo', '{\"userName\":{\"isBlank\":false,\"message\":\"消息动态：用户名称不能为空\"},\"productName\":{\"isBlank\":false,\"message\":\"消息动态：产品名称不能为空\"},\"reservationAmount\":{\"isBlank\":false,\"message\":\"消息动态：预约金额不能为空\"}}', '有待确认的额度预约', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('29', null, '报单待审批', null, '用户$!{userName}新增报单（$!{productName}，$!{dealAmount}万，打款日期$!{payDate}），请及时处理', '审批报单（$!{productName}，$!{dealAmount}万）', '0', null, null, '', '/sale/declaration/audit', 'declaration_audit_todo', '{\"userName\":{\"isBlank\":false,\"message\":\"消息动态：用户名称不能为空\"},\"productName\":{\"isBlank\":false,\"message\":\"消息动态：产品名称不能为空\"},\"dealAmount\":{\"isBlank\":false,\"message\":\"消息动态：打款金额不能为空\"}},\"payDate\":{\"isBlank\":false,\"message\":\"消息动态：打款日期不能为空\"}}', '有待审批的报单', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('30', null, '额度预约已确认', '额度预约确认：$!{productName}，预约额度$!{reservationAmount}万，预计打款日期$!{estimatePayDate}\n操作人：$!{createUserName}', '您为客户$!{customerName}预约（$!{productName}，$!{reservationAmount}万）额度已确认', '', '0', null, null, '', '/sale/appointment', 'reservation_approved', '', '额度预约已确认', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('31', null, '额度预约被驳回', '额度预约被驳回：$!{productName}，预约额度$!{reservationAmount}万，预计打款日期$!{estimatePayDate}，原因：$!{reason}\n操作人：$!{createUserName}', '您为客户$!{customerName}预约（$!{productName}，$!{reservationAmount}万）被$!{createUserName} 驳回，原因$!{reason}', '', '0', null, null, '', '/sale/appointment', 'reservation_reject', '', '额度预约被驳回', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('32', null, '额度预约被作废', '额度预约被作废：$!{productName}，预约额度$!{dealAmount}，预计打款日期$!{dealTime}，原因：$!{reason}\n操作人：$!{audioName}', '您为客户$!{customerName}预约（$!{productName}，$!{dealAmount}）被$!{audioName} 作废，原因：$!{reason}', '您为客户$!{customerName}预约（$!{productName}，$!{dealAmount}）被$!{audioName} 作废，原因：$!{reason}', '0', null, null, 'yundaojinfub://www.yundaoorder.com/appoint_detail?reservationId=$!{reservationId}', '/sale/appointment', 'reservation_discard', '', '额度预约被作废', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('33', null, '报单被作废', '报单被作废：$!{productName}，打款金额$!{dealAmount}，打款日期$!{dealTime}，原因：$!{reason}\n操作人：$!{audioName}', '您为客户$!{customerName}认购（$!{productName}，$!{dealAmount}，$!{dealTime}）的报单被$!{audioName} 作废，原因：$!{reason}', '您为客户$!{customerName}认购（$!{productName}，$!{dealAmount}，$!{dealTime}）的报单被$!{audioName} 作废，原因：$!{reason}', '0', null, null, 'yundaojinfub://www.yundaoorder.com/order_detail?orderId=$!{id}', '/declaration/detail/$!{id}', 'declaration_discard', '', '报单被作废', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('34', '3', '客户预约咨询资产配置', '客户预约咨询资产配置\n测评结果：$!{testResult}，渠道：$!{channel}', '客户$!{customerName}查看了资产配置方案并预约咨询产品配置，渠道：$!{channel}，请及时跟进', '客户$!{customerName}查看了资产配置方案并预约咨询产品配置，渠道：$!{channel}，请及时跟进', '0', null, null, 'yundaojinfub://www.yundaocustomer.com/customer_detail?customerId=$!{customerId}', '/customer/detail/$!{customerId}', 'reservation_asset_allocation', '', '客户预约咨询资产配置', null, null, null, null, '0');

-- ----------------------------
-- Table structure for msg_template_type
-- ----------------------------
DROP TABLE IF EXISTS `msg_template_type`;
CREATE TABLE `msg_template_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `name` varchar(32) DEFAULT NULL COMMENT '动态类型名称',
  `type` tinyint(2) DEFAULT NULL COMMENT '1、动态 2、消息',
  `first_type` tinyint(2) DEFAULT NULL COMMENT '对应消息：1、代办   2、消息\r\n  对应动态\r\n:1、客户行为   2、服务轨迹',
  `two_type` tinyint(2) DEFAULT NULL COMMENT '消息二级是：1、客户 ，2、产品 ，3、待回访，4、待跟进，5、待审核，6、待确认，7、交易，8、客户行为    动态的二级类型    1、客户  2、交易 3、客户行为',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `tenant_id_index` (`tenant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COMMENT='模板类型表';

-- ----------------------------
-- Records of msg_template_type
-- ----------------------------
INSERT INTO `msg_template_type` VALUES ('1', null, '新增客户', '1', '2', '1', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('2', null, '下次跟进客户', '2', '1', '4', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('3', null, '客户跟进', '1', '2', '1', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('4', null, '产品上线', '2', '2', '2', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('5', null, '项目附件更新', '2', '2', '2', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('6', null, '有待上线审核的产品', '2', '1', '4', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('7', null, '客户回退-审核通过', '1', '2', '2', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('8', null, '客户回退-审核通过', '2', '2', '1', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('9', null, '客户回退-驳回', '1', '2', '2', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('10', null, '客户回退-驳回', '2', '2', '1', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('11', null, '产品公告发布', '2', '2', '2', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('12', null, '有待发布审核的公告', '2', '1', '5', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('13', null, '客户回访', '1', '2', '2', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('14', null, '客户回访', '2', '2', '1', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('15', null, '下次回访', '2', '1', '3', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('16', null, '给您调配了新客户', '2', '2', '1', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('17', null, '给您调配了新客户', '1', '2', '1', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('18', null, '客户回收到客户池', '2', '2', '1', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('19', null, '客户回收到客户池', '1', '2', '1', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('20', null, '报单审核通过', '1', '2', '2', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('21', null, '报单审核通过', '2', '2', '7', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('22', null, '报单被驳回', '1', '2', '2', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('23', null, '报单被驳回', '2', '2', '7', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('24', null, 'C端客户注册', '1', '1', '3', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('25', null, 'C端客户注册', '2', '2', '8', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('26', null, '客户登录', '1', '1', '3', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('27', null, '客户登录', '2', '2', '8', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('28', null, '客户提交测评结果', '1', '1', '3', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('29', null, '客户提交测评结果', '2', '2', '8', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('30', null, '客户查看产品详情', '1', '1', '3', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('31', null, '客户查看产品详情', '2', '2', '8', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('32', null, '客户预约咨询产品', '1', '1', '3', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('33', null, '客户预约咨询产品', '2', '2', '8', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('34', null, '客户查看公告详情', '1', '1', '3', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('35', null, '客户查看公告详情', '2', '2', '8', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('36', null, '有待确认的额度预约', '2', '1', '6', null, '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `msg_template_type` VALUES ('37', null, '有待审批的报单', '2', '1', '5', null, '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `msg_template_type` VALUES ('38', null, '预约额度确认', '1', '2', '7', null, '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `msg_template_type` VALUES ('39', null, '预约额度确认', '2', '2', '7', null, '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `msg_template_type` VALUES ('40', null, '预约额度被驳回', '1', '2', '7', null, '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `msg_template_type` VALUES ('41', null, '预约额度被驳回', '2', '2', '7', null, '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `msg_template_type` VALUES ('42', null, '额度预约被作废', '2', '2', '7', null, '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `msg_template_type` VALUES ('43', null, '额度预约被作废', '1', '2', '2', null, '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `msg_template_type` VALUES ('44', null, '报单被作废', '2', '2', '7', null, '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `msg_template_type` VALUES ('45', null, '报单被作废', '1', '2', '2', null, '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `msg_template_type` VALUES ('46', '3', '客户预约咨询资产配置', '2', '2', '8', null, '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `msg_template_type` VALUES ('47', '3', '客户预约咨询资产配置', '1', '1', '3', null, '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `msg_template_type` VALUES ('48', '3', '客户预约咨询资产配置', '2', '1', '8', null, '2017-11-04 18:45:57', null, null, '0');

-- ----------------------------
-- Table structure for msg_template_type_ref
-- ----------------------------
DROP TABLE IF EXISTS `msg_template_type_ref`;
CREATE TABLE `msg_template_type_ref` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `template_id` bigint(20) DEFAULT NULL COMMENT '模板id',
  `type_id` bigint(20) DEFAULT NULL COMMENT '类型id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `tenant_id_index` (`tenant_id`),
  KEY `template_id_index` (`template_id`),
  KEY `type_id_index` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8 COMMENT='模板类型关联关系表';

-- ----------------------------
-- Records of msg_template_type_ref
-- ----------------------------
INSERT INTO `msg_template_type_ref` VALUES ('1', null, '1', '1', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('2', null, '2', '2', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('3', null, '3', '3', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('4', null, '4', '4', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('5', null, '5', '5', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('6', null, '6', '6', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('7', null, '7', '7', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('8', null, '7', '8', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('9', null, '8', '9', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('10', null, '8', '10', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('11', null, '9', '11', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('12', null, '10', '12', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('13', null, '11', '13', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('14', null, '11', '14', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('15', null, '12', '15', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('17', null, '17', '17', '-1', '2017-08-27 20:52:54', null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('18', null, '17', '16', '-1', '2017-08-27 20:53:38', null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('19', null, '18', '17', '-1', '2017-08-27 20:54:00', null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('20', null, '18', '16', '-1', '2017-08-27 20:54:00', null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('21', null, '19', '19', '-1', '2017-08-29 08:47:03', null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('22', null, '19', '18', '-1', '2017-08-29 08:49:06', null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('23', null, '20', '20', '-1', null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('24', null, '20', '21', '-1', null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('25', null, '21', '22', '-1', null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('26', null, '21', '23', '-1', null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('27', null, '22', '24', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('28', null, '22', '25', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('29', null, '23', '26', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('30', null, '23', '27', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('31', null, '24', '28', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('32', null, '24', '29', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('33', null, '25', '30', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('34', null, '25', '31', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('35', null, '26', '32', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('36', null, '26', '33', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('37', null, '27', '34', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('38', null, '27', '35', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('39', null, '28', '36', null, '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('40', null, '29', '37', null, '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('41', null, '30', '38', null, '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('42', null, '30', '39', null, '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('44', null, '31', '40', null, '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('45', null, '31', '41', null, '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('47', null, '32', '42', null, '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('48', null, '32', '43', null, '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('49', null, '33', '44', null, '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('50', null, '33', '45', null, '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('51', '3', '34', '46', null, '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('52', '3', '34', '47', null, '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('53', '3', '34', '48', null, '2017-11-04 18:45:57', null, null, '0');

-- ----------------------------
-- Table structure for number_config
-- ----------------------------
DROP TABLE IF EXISTS `number_config`;
CREATE TABLE `number_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `object_field_id` bigint(20) DEFAULT NULL COMMENT '业务对象字段id',
  `decimal_length` int(11) DEFAULT NULL COMMENT '小数点位数',
  `unit` varchar(32) DEFAULT NULL COMMENT '单位',
  `max_value` bigint(20) DEFAULT NULL COMMENT '最大值',
  `min_value` bigint(20) DEFAULT NULL COMMENT '最小值',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，1：是；0：否',
  PRIMARY KEY (`id`),
  KEY `i_tenant_id` (`tenant_id`),
  KEY `i_create_user_id` (`create_user_id`),
  KEY `i_update_user_id` (`update_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='业务对象字段数字类配置';

-- ----------------------------
-- Records of number_config
-- ----------------------------
INSERT INTO `number_config` VALUES ('1', '3', '4', '0', '月', '-1', null, '0', '2017-07-18 14:19:29', null, null, '0');
INSERT INTO `number_config` VALUES ('2', '3', '6', '0', '万', '-1', null, '0', '2017-07-18 14:19:29', null, null, '0');
INSERT INTO `number_config` VALUES ('3', '3', '7', '0', '万', '-1', null, '0', '2017-07-18 14:19:29', null, null, '0');
INSERT INTO `number_config` VALUES ('4', '3', '8', '0', '人', '-1', null, '0', '2017-07-18 14:19:29', null, null, '0');
INSERT INTO `number_config` VALUES ('5', '3', '16', '4', '万', '-1', null, '0', '2017-07-18 14:19:29', null, null, '0');
INSERT INTO `number_config` VALUES ('6', '3', '22', '0', '月', '-1', null, '0', '2017-07-18 14:19:29', null, null, '0');
INSERT INTO `number_config` VALUES ('7', '3', '24', '4', '%', '100', null, '0', '2017-07-18 14:19:29', null, null, '0');
INSERT INTO `number_config` VALUES ('8', '3', '25', '4', '%', '100', null, '0', '2017-07-18 14:19:29', null, null, '0');
INSERT INTO `number_config` VALUES ('9', '3', '26', '4', '%', '100', null, '0', '2017-07-18 14:19:29', null, null, '0');

-- ----------------------------
-- Table structure for object_field
-- ----------------------------
DROP TABLE IF EXISTS `object_field`;
CREATE TABLE `object_field` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `field_id` bigint(20) DEFAULT NULL COMMENT '字段id',
  `business_object_id` bigint(20) DEFAULT NULL COMMENT '业务对象id',
  `description` varchar(512) DEFAULT NULL COMMENT '描述',
  `field_type_id` bigint(20) DEFAULT NULL COMMENT '字段类型id',
  `is_fix` tinyint(4) DEFAULT NULL COMMENT '是否固定显示位置，0：否，1：是',
  `display_type` tinyint(4) DEFAULT NULL COMMENT '显示方式，0：隐藏，1：显示，2：强制显示',
  `is_mandatory` tinyint(4) DEFAULT '0' COMMENT '是否必选，0：否，1： 是',
  `is_basic` tinyint(4) DEFAULT '0' COMMENT '是否基本属性，0：否，1： 是',
  `is_share` tinyint(4) DEFAULT '0' COMMENT '是否共用，0：否，1：是',
  `is_system` tinyint(4) DEFAULT '1' COMMENT '是否系统标准字段，0：否，1：是',
  `is_search` tinyint(4) DEFAULT '0' COMMENT '是否可搜索，0：否，1：是',
  `is_readonly` tinyint(4) DEFAULT '0' COMMENT '是否只读，0：否，1：是',
  `is_init` tinyint(4) DEFAULT '0' COMMENT '是否初始化，0：否，1：是',
  `is_enabled` tinyint(4) DEFAULT '1' COMMENT '是否启用，0：否，1：是',
  `can_edit_mandatory` tinyint(4) DEFAULT NULL COMMENT '是否能够修改 必填项',
  `can_edit_enabled` tinyint(4) DEFAULT NULL COMMENT '是否可修改 启用 项',
  `access` tinyint(4) DEFAULT NULL COMMENT '权限，0：全部可见，1：部分可见',
  `sequence` int(11) DEFAULT '1' COMMENT '排序，越小越靠前',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，1：是；0：否',
  PRIMARY KEY (`id`),
  KEY `i_tenant_id` (`tenant_id`),
  KEY `i_create_user_id` (`create_user_id`),
  KEY `i_update_user_id` (`update_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='业务对象字段';

-- ----------------------------
-- Records of object_field
-- ----------------------------
INSERT INTO `object_field` VALUES ('1', '3', '1', '1', null, '1', '0', '1', '1', '1', '1', '1', '1', '0', '1', '1', '0', '0', '1', '10', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('2', '3', '2', '1', null, '6', '0', '1', '0', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '20', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('3', '3', '3', '1', null, '6', '0', '1', '0', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '30', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('4', '3', '4', '1', null, '9', '0', '1', '0', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '40', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('5', '3', '5', '1', null, '1', '0', '1', '0', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '50', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('6', '3', '6', '1', null, '9', '0', '1', '1', '1', '1', '1', '1', '0', '1', '1', '0', '0', '1', '60', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('7', '3', '7', '1', null, '9', '0', '1', '0', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '70', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('8', '3', '8', '1', null, '9', '0', '1', '0', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '80', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('9', '3', '9', '1', null, '6', '0', '1', '0', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '90', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('10', '3', '10', '1', null, '6', '0', '1', '1', '1', '1', '1', '1', '0', '1', '1', '0', '0', '1', '100', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('11', '3', '11', '1', null, '1', '0', '1', '1', '1', '1', '1', '1', '0', '1', '1', '0', '0', '1', '110', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('12', '3', '12', '1', null, '1', '0', '1', '0', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '120', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('13', '3', '13', '1', null, '1', '0', '1', '0', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '130', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('14', '3', '14', '1', null, '5', '0', '1', '0', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '140', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('15', '3', '15', '1', null, '7', '0', '1', '1', '1', '1', '1', '1', '0', '1', '1', '0', '0', '1', '150', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('16', '3', '16', '1', null, '9', '0', '1', '0', '1', '1', '1', '1', '0', '1', '1', '0', '0', '1', '160', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('17', '3', '17', '1', null, '6', '0', '1', '1', '1', '1', '1', '1', '0', '1', '1', '0', '0', '1', '170', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('18', '3', '18', '1', null, '1', '0', '1', '0', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '180', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('19', '3', '19', '1', null, '1', '0', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('20', '3', '20', '1', null, '6', '0', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('21', '3', '21', '1', null, '6', '0', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('22', '3', '22', '1', null, '9', '0', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('23', '3', '23', '1', null, '6', '0', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('24', '3', '24', '1', null, '9', '0', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('25', '3', '25', '1', null, '9', '0', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('26', '3', '26', '1', null, '9', '0', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('27', '3', '27', '1', null, '1', '0', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('28', '3', '28', '1', null, '6', '0', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('29', '3', '29', '1', null, '6', '0', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('30', '3', '30', '1', null, '1', '0', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('31', '3', '31', '1', null, '1', '0', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('32', '3', '32', '1', null, '1', '0', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('33', '3', '33', '1', null, '6', '0', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('34', '3', '34', '1', null, '6', '0', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('35', '3', '35', '1', null, '1', '0', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('36', '3', '36', '1', null, '1', '0', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('37', '3', '37', '1', null, '1', '0', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('38', '3', '38', '1', null, '1', '0', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('39', '3', '39', '1', null, '1', '0', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('40', '3', '40', '1', null, '6', '0', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('41', '3', '41', '1', null, '2', '0', '1', '0', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '180', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('42', '3', '42', '1', null, '1', '0', '1', '0', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '180', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('43', '3', '43', '1', null, '1', '0', '1', '0', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '180', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('44', '3', '44', '1', null, '1', '0', '1', '0', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '180', '1', '2017-07-04 19:50:47', null, null, null, null, '0');
INSERT INTO `object_field` VALUES ('45', '3', '10000', '1', null, '1', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', null, null, '0', '1', '46', '2017-11-02 15:43:56', null, null, '测试文本', null, '0');
INSERT INTO `object_field` VALUES ('46', '3', '116', '1', '到期日期', '4', '0', '1', '0', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '10', '1', '2017-11-04 18:45:57', null, null, null, null, '0');

-- ----------------------------
-- Table structure for operation_log
-- ----------------------------
DROP TABLE IF EXISTS `operation_log`;
CREATE TABLE `operation_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `user_account_id` bigint(20) DEFAULT NULL COMMENT '操作者用户账号id',
  `operate_type` tinyint(2) DEFAULT NULL COMMENT '操作类型（0：新建，1：编辑，2：删除，3：锁定，4：解锁）',
  `object_type` tinyint(2) DEFAULT NULL COMMENT '对象类型',
  `object_name` varchar(256) DEFAULT NULL COMMENT '对象名字',
  `object_id` bigint(20) DEFAULT NULL COMMENT '对象主键',
  `ip` varchar(32) DEFAULT NULL COMMENT 'ip',
  `description` varchar(512) DEFAULT NULL COMMENT '操作描述',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编码',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `i_user_account_id` (`user_account_id`),
  KEY `i_tenant_id` (`tenant_id`),
  KEY `i_object_type` (`object_type`),
  KEY `i_create_user_id` (`create_user_id`),
  KEY `i_update_user_id` (`update_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作日志表';

-- ----------------------------
-- Records of operation_log
-- ----------------------------

-- ----------------------------
-- Table structure for platform
-- ----------------------------
DROP TABLE IF EXISTS `platform`;
CREATE TABLE `platform` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `name` varchar(32) DEFAULT NULL COMMENT '名称',
  `code` varchar(32) DEFAULT NULL COMMENT '编码',
  `sequence` int(11) DEFAULT '1' COMMENT '排序，越小越靠前',
  `is_enabled` tinyint(2) DEFAULT '1' COMMENT '是否启用，0：否，1：是',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='平台表';

-- ----------------------------
-- Records of platform
-- ----------------------------
INSERT INTO `platform` VALUES ('1', null, '服务号', 'service_number', '1', '1', null, null, null, null, '0');
INSERT INTO `platform` VALUES ('2', null, '官方网站', 'website', '1', '1', null, null, null, null, '0');
INSERT INTO `platform` VALUES ('3', null, '员工版APP', 'app_to_b', '1', '1', null, null, null, null, '0');

-- ----------------------------
-- Table structure for platform_position_ref
-- ----------------------------
DROP TABLE IF EXISTS `platform_position_ref`;
CREATE TABLE `platform_position_ref` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `platform_id` bigint(20) DEFAULT NULL COMMENT '平台id',
  `position_id` bigint(20) DEFAULT NULL COMMENT '位置id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(3) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='平台与位置关系';

-- ----------------------------
-- Records of platform_position_ref
-- ----------------------------
INSERT INTO `platform_position_ref` VALUES ('1', null, '1', '3', null, null, null, null, '0');
INSERT INTO `platform_position_ref` VALUES ('2', null, '2', '1', null, null, null, null, '0');
INSERT INTO `platform_position_ref` VALUES ('3', null, '2', '2', null, null, null, null, '0');
INSERT INTO `platform_position_ref` VALUES ('4', null, '3', '4', null, null, null, null, '0');

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `name` varchar(128) NOT NULL COMMENT '位置名称',
  `code` varchar(128) DEFAULT NULL COMMENT '编码',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建人',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='位置';

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES ('1', null, '首页热门产品', 'index_hot_product', null, null, null, null, '0');
INSERT INTO `position` VALUES ('2', null, '产品列表', 'list_product', null, null, null, null, '0');
INSERT INTO `position` VALUES ('3', null, '首页推荐产品', 'index_recommend_product', null, null, null, null, '0');
INSERT INTO `position` VALUES ('4', null, '首页推荐产品', 'index_recommend_product_app', null, null, null, null, '0');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '产品id',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `type_id` bigint(32) DEFAULT NULL COMMENT '产品类型编码',
  `name` varchar(200) DEFAULT NULL COMMENT '产品名称',
  `issued_channel` varchar(32) DEFAULT NULL COMMENT '发行通道',
  `invest_domain` varchar(32) DEFAULT NULL COMMENT '投资标的',
  `time_limit` varchar(200) DEFAULT NULL COMMENT '投资期限',
  `mechanism` varchar(200) DEFAULT NULL COMMENT '管理机构',
  `buy_start_point` double DEFAULT NULL COMMENT '认购起点',
  `incremental_amount` double DEFAULT NULL COMMENT '递增金额',
  `buy_person_limit` int(11) DEFAULT NULL COMMENT '投资人数上限',
  `level` varchar(32) DEFAULT NULL COMMENT '产品等级',
  `risk_level` varchar(32) DEFAULT NULL COMMENT '风险等级',
  `receiver_id` bigint(20) DEFAULT NULL COMMENT '产品对接人',
  `assistant_id` bigint(20) DEFAULT NULL COMMENT '产品助理',
  `highlight` varchar(1000) DEFAULT NULL COMMENT '简要亮点',
  `on_line_time` datetime DEFAULT NULL COMMENT '上线时间',
  `issued_status` int(11) DEFAULT NULL COMMENT '产品发行状态 0:未上线  1:上线准备中  2:预售  3:募集中  4:募集结束  5:存续封闭中 6:清算退出',
  `declaration_model` tinyint(4) DEFAULT '2' COMMENT '报单模式： 1：直接报单: 2：先预约在报单',
  `wx_content` varchar(1000) DEFAULT NULL COMMENT '微信版内容',
  `maturity_date` datetime DEFAULT NULL COMMENT '到期日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(3) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `i_name` (`name`),
  KEY `i_receiver_id` (`receiver_id`),
  KEY `i_assistant_id` (`assistant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='产品基本信息';

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '3', '5', '保险产品001', '6', '1', '3', '中国保险', '50', '5', null, null, '2', '46', null, '', '2017-11-02 15:49:18', '2', null, '', null, '46', '2017-11-02 15:45:20', '46', '2017-11-02 15:49:18', '0');

-- ----------------------------
-- Table structure for product_attach
-- ----------------------------
DROP TABLE IF EXISTS `product_attach`;
CREATE TABLE `product_attach` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `source_name` varchar(250) DEFAULT NULL COMMENT '文件名称',
  `url` varchar(250) DEFAULT NULL COMMENT 'url',
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品id',
  `sort` double DEFAULT NULL COMMENT '排序',
  `show_type` tinyint(4) DEFAULT '0' COMMENT '可见性：1：内部可见 2：外部可见 0：全部可见',
  `type` varchar(100) DEFAULT NULL COMMENT '附件类型',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(3) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `i_product_id` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='附件';

-- ----------------------------
-- Records of product_attach
-- ----------------------------

-- ----------------------------
-- Table structure for product_commission
-- ----------------------------
DROP TABLE IF EXISTS `product_commission`;
CREATE TABLE `product_commission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `commission_rule_id` bigint(20) DEFAULT NULL COMMENT '佣金规则id',
  `sale_max` double DEFAULT NULL COMMENT '销售最大值',
  `sale_min` double DEFAULT NULL COMMENT '销售最小值',
  `commission_type` varchar(32) DEFAULT NULL COMMENT '佣金类型',
  `front_commission` double DEFAULT NULL COMMENT '前端佣金',
  `back_commission` double DEFAULT NULL COMMENT '后端佣金',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(3) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `commission_rule_id` (`commission_rule_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_commission
-- ----------------------------

-- ----------------------------
-- Table structure for product_commission_rule
-- ----------------------------
DROP TABLE IF EXISTS `product_commission_rule`;
CREATE TABLE `product_commission_rule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '规则id',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品id',
  `rule_name` varchar(100) DEFAULT NULL COMMENT '规则名称',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(3) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `i_product_id` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_commission_rule
-- ----------------------------

-- ----------------------------
-- Table structure for product_data_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `product_data_dictionary`;
CREATE TABLE `product_data_dictionary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL,
  `code` varchar(32) DEFAULT NULL,
  `value` varchar(32) DEFAULT NULL,
  `type` varchar(32) DEFAULT NULL,
  `description` varchar(512) DEFAULT NULL,
  `sort` double DEFAULT NULL,
  `create_user_id` bigint(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_user_id` bigint(20) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `is_delete` tinyint(3) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据字典';

-- ----------------------------
-- Records of product_data_dictionary
-- ----------------------------

-- ----------------------------
-- Table structure for product_examine
-- ----------------------------
DROP TABLE IF EXISTS `product_examine`;
CREATE TABLE `product_examine` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品id',
  `apply_user_id` bigint(20) DEFAULT NULL COMMENT '流程发起人id',
  `issued_status` int(11) DEFAULT NULL COMMENT '发行状态',
  `req_issued_status` int(11) DEFAULT NULL COMMENT '请求审核的 状态',
  `approve_id` bigint(20) DEFAULT NULL COMMENT '审核人',
  `approve_date` datetime DEFAULT NULL COMMENT '审核时间',
  `reason` varchar(512) DEFAULT NULL COMMENT '原因',
  `status` int(11) DEFAULT NULL COMMENT '审核状态， 0：未提交  1：审核中  2：已通过  3：已驳回  4： 已撤销',
  `business_type` varchar(64) DEFAULT NULL COMMENT '业务类型',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='产品审核';

-- ----------------------------
-- Records of product_examine
-- ----------------------------
INSERT INTO `product_examine` VALUES ('1', '3', '1', '46', '1', '1', '46', '2017-11-02 15:49:04', null, '2', 'product_audit', '46', '2017-11-02 15:48:56', '46', '2017-11-02 15:49:04', '0');

-- ----------------------------
-- Table structure for product_field_value
-- ----------------------------
DROP TABLE IF EXISTS `product_field_value`;
CREATE TABLE `product_field_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `object_field_id` bigint(20) DEFAULT NULL COMMENT '业务对象字段id',
  `reference_table_id` bigint(20) DEFAULT NULL COMMENT '引用表id',
  `value` longtext COMMENT '字段值',
  `slot` int(11) DEFAULT '0' COMMENT '位置，一个字段有多个值时使用，按数字从小到大排列，例如日期区间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `i_tenant_id` (`tenant_id`),
  KEY `i_create_user_id` (`create_user_id`),
  KEY `i_update_user_id` (`update_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务对象字段值';

-- ----------------------------
-- Records of product_field_value
-- ----------------------------

-- ----------------------------
-- Table structure for product_income
-- ----------------------------
DROP TABLE IF EXISTS `product_income`;
CREATE TABLE `product_income` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `income_rule_id` bigint(20) DEFAULT NULL COMMENT '收益规则id',
  `buy_max` double DEFAULT NULL COMMENT '认购最大值',
  `buy_min` double DEFAULT NULL COMMENT '认购最小值',
  `buy_time_limit` bigint(20) DEFAULT NULL COMMENT '认购期限',
  `income_type` varchar(32) DEFAULT NULL COMMENT '收益类型',
  `fix_income_rate` double DEFAULT NULL COMMENT '收益率',
  `float_income_rate` double DEFAULT NULL COMMENT '浮动收益',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(3) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `i_product_income_id` (`income_rule_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_income
-- ----------------------------

-- ----------------------------
-- Table structure for product_income_rule
-- ----------------------------
DROP TABLE IF EXISTS `product_income_rule`;
CREATE TABLE `product_income_rule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品id',
  `rule_name` varchar(32) DEFAULT NULL COMMENT '规则名称',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(3) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `i_product_id` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_income_rule
-- ----------------------------

-- ----------------------------
-- Table structure for product_nav
-- ----------------------------
DROP TABLE IF EXISTS `product_nav`;
CREATE TABLE `product_nav` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品id',
  `unit_nav` double DEFAULT NULL COMMENT '单位净值',
  `total_nav` double DEFAULT NULL COMMENT '累计净值',
  `up_down_rate` double DEFAULT NULL COMMENT '涨跌幅',
  `nav_date` date DEFAULT NULL COMMENT '净值日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(3) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `i_product_id` (`product_id`),
  KEY `i_nav_date` (`nav_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品净值';

-- ----------------------------
-- Records of product_nav
-- ----------------------------

-- ----------------------------
-- Table structure for product_notice
-- ----------------------------
DROP TABLE IF EXISTS `product_notice`;
CREATE TABLE `product_notice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品id',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `content` varchar(1000) DEFAULT NULL COMMENT '内容',
  `notice_type_id` bigint(20) DEFAULT NULL COMMENT '公告类型',
  `status` int(11) DEFAULT NULL COMMENT '审核状态 1未提交  2审核中  3已通过  4已驳回  5 已撤销',
  `send_time` datetime DEFAULT NULL COMMENT '定时发送时间',
  `is_send` tinyint(3) DEFAULT '0' COMMENT '是否发送  1发送 0未发送',
  `is_timing_send` tinyint(3) DEFAULT NULL COMMENT '是否定时发送（0：不是，1：是）',
  `audit_user_id` bigint(20) DEFAULT NULL COMMENT '审核人id',
  `audit_date` datetime DEFAULT NULL COMMENT '审核时间',
  `reason` varchar(1000) DEFAULT NULL COMMENT '原因',
  `apply_user_id` bigint(20) DEFAULT NULL COMMENT '申请人id',
  `apply_date` datetime DEFAULT NULL COMMENT '申请时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(3) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `i_product_id` (`product_id`),
  KEY `i_notice_type_id` (`notice_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品公告';

-- ----------------------------
-- Records of product_notice
-- ----------------------------

-- ----------------------------
-- Table structure for product_notice_attach
-- ----------------------------
DROP TABLE IF EXISTS `product_notice_attach`;
CREATE TABLE `product_notice_attach` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `notice_id` bigint(20) DEFAULT NULL COMMENT '公告id',
  `source_name` varchar(250) DEFAULT NULL COMMENT '文件名称',
  `url` varchar(250) DEFAULT NULL COMMENT 'url',
  `sort` double DEFAULT NULL COMMENT '排序',
  `type` varchar(100) DEFAULT NULL COMMENT '附件类型',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(3) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `i_notice_id` (`notice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品公告附件';

-- ----------------------------
-- Records of product_notice_attach
-- ----------------------------

-- ----------------------------
-- Table structure for product_notice_examine
-- ----------------------------
DROP TABLE IF EXISTS `product_notice_examine`;
CREATE TABLE `product_notice_examine` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `notice_id` bigint(20) DEFAULT NULL COMMENT '公告id',
  `product_name` varchar(100) DEFAULT NULL COMMENT '产品名称',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `content` varchar(1000) DEFAULT NULL COMMENT '内容',
  `notice_type` varchar(32) DEFAULT NULL COMMENT '公告类型',
  `status` int(11) DEFAULT NULL COMMENT '审核状态 1未提交  2审核中  3已通过  4已驳回  5 已撤销',
  `reason` varchar(1000) DEFAULT NULL COMMENT '原因',
  `create_user` varchar(32) DEFAULT NULL COMMENT '申请人',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '申请人Id',
  `create_date` datetime DEFAULT NULL COMMENT '申请时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '审核人id',
  `update_user` varchar(32) DEFAULT NULL COMMENT '审核人',
  `update_date` datetime DEFAULT NULL COMMENT '审核时间',
  `is_delete` tinyint(3) DEFAULT '0' COMMENT '是否删除',
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品ID',
  `notice_type_id` bigint(20) DEFAULT NULL COMMENT '公告类型ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品公告审核表';

-- ----------------------------
-- Records of product_notice_examine
-- ----------------------------

-- ----------------------------
-- Table structure for product_notice_type
-- ----------------------------
DROP TABLE IF EXISTS `product_notice_type`;
CREATE TABLE `product_notice_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `name` varchar(64) DEFAULT NULL COMMENT '类型名称',
  `description` varchar(512) DEFAULT NULL COMMENT '描述',
  `code` varchar(32) DEFAULT NULL COMMENT '产品公告CODE',
  `is_permit_delete` tinyint(2) DEFAULT '1' COMMENT '1 允许删除，0不允许删除',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(3) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='产品公告类型';

-- ----------------------------
-- Records of product_notice_type
-- ----------------------------
INSERT INTO `product_notice_type` VALUES ('1', '3', '重大事项', null, 'major_issues ', '0', '1', '2017-08-22 14:47:06', null, null, '1');
INSERT INTO `product_notice_type` VALUES ('2', '3', '周报', null, 'weekly', '0', '1', '2017-08-22 14:47:06', null, null, '0');
INSERT INTO `product_notice_type` VALUES ('3', '3', '月报', null, 'monthly', '0', '1', '2017-08-22 14:47:06', null, null, '0');
INSERT INTO `product_notice_type` VALUES ('4', '3', '季报', null, 'quarterly', '0', '1', '2017-08-22 14:47:06', null, null, '0');
INSERT INTO `product_notice_type` VALUES ('5', '3', '半年报', null, 'semi_annual', '0', '1', '2017-08-22 14:47:06', null, null, '0');
INSERT INTO `product_notice_type` VALUES ('6', '3', '年报', null, 'annual', '0', '1', '2017-08-22 14:47:06', null, null, '0');
INSERT INTO `product_notice_type` VALUES ('7', '3', '私募备案', null, 'private_record', '0', '1', '2017-08-22 14:47:06', null, null, '0');
INSERT INTO `product_notice_type` VALUES ('8', '3', '通知赎回', null, 'notification_redemption', '0', '1', '2017-08-22 14:47:06', null, null, '0');
INSERT INTO `product_notice_type` VALUES ('9', '3', '产品成立', null, 'product_found', '0', '1', '2017-08-22 14:47:06', null, null, '0');
INSERT INTO `product_notice_type` VALUES ('10', '3', '付息通知', null, 'interest_notice', '0', '1', '2017-08-22 14:47:06', null, '2017-08-25 19:15:01', '1');
INSERT INTO `product_notice_type` VALUES ('11', '3', '其他', null, 'other', '0', '1', '2017-08-22 14:47:06', null, null, '1');

-- ----------------------------
-- Table structure for product_recommend
-- ----------------------------
DROP TABLE IF EXISTS `product_recommend`;
CREATE TABLE `product_recommend` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品id',
  `platform_id` bigint(20) DEFAULT NULL COMMENT '平台id',
  `position_id` bigint(20) DEFAULT NULL COMMENT '位置id',
  `status` tinyint(3) DEFAULT NULL COMMENT '状态(0:停用， 1：启用)',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(3) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品推荐配置';

-- ----------------------------
-- Records of product_recommend
-- ----------------------------

-- ----------------------------
-- Table structure for product_sale
-- ----------------------------
DROP TABLE IF EXISTS `product_sale`;
CREATE TABLE `product_sale` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品id',
  `sale_start_date` date DEFAULT NULL COMMENT '拟销售日期开始日期',
  `sale_end_date` date DEFAULT NULL COMMENT '拟销售日期结束日期',
  `is_scale` tinyint(2) DEFAULT NULL COMMENT '是否有规模',
  `product_scale` double DEFAULT NULL COMMENT '产品规模',
  `currency_code` varchar(32) DEFAULT NULL COMMENT '投资币种',
  `pay_account` varchar(200) DEFAULT NULL COMMENT '打款账号',
  `account_name` varchar(200) DEFAULT NULL COMMENT '开户名',
  `raise_bank` varchar(200) DEFAULT NULL COMMENT '募集银行',
  `pay_remark` varchar(1000) DEFAULT NULL COMMENT '打款备注',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `i_product_id` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='产品销售信息';

-- ----------------------------
-- Records of product_sale
-- ----------------------------
INSERT INTO `product_sale` VALUES ('1', '3', '1', null, null, '1', '3000', '0', '', '', '', '', '46', '2017-11-02 15:45:20', null, null, '0');

-- ----------------------------
-- Table structure for product_supplier
-- ----------------------------
DROP TABLE IF EXISTS `product_supplier`;
CREATE TABLE `product_supplier` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `supplier_id` bigint(20) DEFAULT NULL COMMENT '供应商id',
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品id',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(3) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `i_supplier_id` (`supplier_id`),
  KEY `i_product_id` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_supplier
-- ----------------------------

-- ----------------------------
-- Table structure for product_supplier_quotation
-- ----------------------------
DROP TABLE IF EXISTS `product_supplier_quotation`;
CREATE TABLE `product_supplier_quotation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `product_supplier_id` bigint(20) DEFAULT NULL COMMENT '供应商报价id',
  `sale_max` double DEFAULT NULL COMMENT '销售金额最大',
  `sale_min` double DEFAULT NULL COMMENT '销售金额最小',
  `commission_type` varchar(32) DEFAULT NULL COMMENT '佣金类型',
  `front_commission` double DEFAULT NULL COMMENT '前端佣金',
  `back_commission` double DEFAULT NULL COMMENT '后端佣金',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(3) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `i_product_supplier_id` (`product_supplier_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品供应商报价';

-- ----------------------------
-- Records of product_supplier_quotation
-- ----------------------------

-- ----------------------------
-- Table structure for proudct_focus
-- ----------------------------
DROP TABLE IF EXISTS `proudct_focus`;
CREATE TABLE `proudct_focus` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `product_id` bigint(20) NOT NULL COMMENT '产品id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `focus_date` datetime DEFAULT NULL COMMENT '关注时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_tenant_product_user` (`tenant_id`,`product_id`,`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品用户关注表';

-- ----------------------------
-- Records of proudct_focus
-- ----------------------------

-- ----------------------------
-- Table structure for receipt_declaration
-- ----------------------------
DROP TABLE IF EXISTS `receipt_declaration`;
CREATE TABLE `receipt_declaration` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `receipt_plan_id` bigint(20) DEFAULT NULL COMMENT '回款计划ID',
  `declaration_id` bigint(20) DEFAULT NULL COMMENT '报单ID',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `receipt_plan_id_index` (`receipt_plan_id`),
  KEY `tenant_id_index` (`tenant_id`),
  KEY `declaration_id_index` (`declaration_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='回款报单关系表';

-- ----------------------------
-- Records of receipt_declaration
-- ----------------------------

-- ----------------------------
-- Table structure for receipt_plan
-- ----------------------------
DROP TABLE IF EXISTS `receipt_plan`;
CREATE TABLE `receipt_plan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `name` varchar(64) DEFAULT NULL COMMENT '回款计划名称',
  `product_id` bigint(20) DEFAULT NULL COMMENT '回款产品',
  `product_supplier_id` bigint(20) DEFAULT NULL COMMENT '供应商',
  `amount` double DEFAULT NULL COMMENT '计划回款金额',
  `pay_unit` varchar(128) DEFAULT NULL COMMENT '付款单位',
  `index_content` varchar(128) DEFAULT NULL COMMENT '首页内容',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `product_id_index` (`product_id`),
  KEY `tenant_id_index` (`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='回款计划表';

-- ----------------------------
-- Records of receipt_plan
-- ----------------------------

-- ----------------------------
-- Table structure for receipt_record
-- ----------------------------
DROP TABLE IF EXISTS `receipt_record`;
CREATE TABLE `receipt_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `receipt_plan_id` bigint(20) DEFAULT NULL COMMENT '回款记录ID',
  `amount` double DEFAULT NULL COMMENT '回款金额',
  `pay_date` datetime DEFAULT NULL COMMENT '回款日期',
  `pay_unit` varchar(64) DEFAULT NULL COMMENT '回款单位',
  `bank_name` varchar(64) DEFAULT NULL COMMENT '回款银行',
  `pay_account` varchar(32) DEFAULT NULL COMMENT '回款账号',
  `is_invoiced` tinyint(2) DEFAULT NULL COMMENT '是否开具发票',
  `invoiced_date` datetime DEFAULT NULL COMMENT '开票时间',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `receipt_plan_id_index` (`receipt_plan_id`),
  KEY `tenant_id_index` (`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='回款记录表';

-- ----------------------------
-- Records of receipt_record
-- ----------------------------

-- ----------------------------
-- Table structure for reservation
-- ----------------------------
DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `number` varchar(32) DEFAULT NULL COMMENT '预约编号',
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品id',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户id',
  `estimate_pay_date` datetime DEFAULT NULL COMMENT '预计打款日期',
  `reservation_amount` double DEFAULT NULL COMMENT '预约金额',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  `reason` varchar(256) DEFAULT NULL COMMENT '原因；驳回、取消时填写',
  `status` tinyint(4) DEFAULT NULL COMMENT '预约状态， 0：未提交  1：审核中  2：已通过  3：已驳回  4： 已取消 5: 已作废',
  `audit_status` tinyint(4) DEFAULT NULL COMMENT '预约审批状态， 0：未提交  1：审核中  2：已通过  3：已驳回  4： 已取消',
  `user_id` bigint(20) DEFAULT NULL COMMENT '预约者id',
  `commit_date` datetime DEFAULT NULL COMMENT '最后提交时间',
  `operation_date` datetime DEFAULT NULL COMMENT '最后审核操作时间',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='工作流业务关联表';

-- ----------------------------
-- Records of reservation
-- ----------------------------
INSERT INTO `reservation` VALUES ('1', '3', '00000001', '1', '10000', '2017-11-02 00:00:00', '300', '客户预约！！', null, '2', '2', '46', '2017-11-02 15:50:05', '2017-11-02 15:50:14', '2017-11-02 15:50:05', '46', '46', '2017-11-02 15:50:14', '0');

-- ----------------------------
-- Table structure for reservation_discard
-- ----------------------------
DROP TABLE IF EXISTS `reservation_discard`;
CREATE TABLE `reservation_discard` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `reservation_id` bigint(20) NOT NULL COMMENT '预约id',
  `reason` varchar(256) DEFAULT NULL COMMENT '废弃原因',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`),
  KEY `tenant_id_index` (`reservation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='预约废弃表';

-- ----------------------------
-- Records of reservation_discard
-- ----------------------------

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `code` varchar(64) DEFAULT NULL COMMENT '编码',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编码',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父id',
  `name` varchar(32) DEFAULT NULL COMMENT '名字',
  `url` varchar(256) DEFAULT NULL COMMENT '链接',
  `is_menu` tinyint(2) DEFAULT '1' COMMENT '是否菜单，0：否，1：是',
  `is_enabled` tinyint(2) DEFAULT '1' COMMENT '是否启用，0：否，1：是',
  `is_deplay` tinyint(2) DEFAULT NULL COMMENT '是否显示',
  `description` varchar(512) DEFAULT NULL COMMENT '描述',
  `sequence` int(11) DEFAULT '1' COMMENT '排序，越小越靠前',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`),
  KEY `i_tenant_id` (`tenant_id`),
  KEY `i_name` (`name`),
  KEY `i_parent_id` (`parent_id`),
  KEY `i_create_user_id` (`create_user_id`),
  KEY `i_update_user_id` (`update_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=134 DEFAULT CHARSET=utf8 COMMENT='资源表';

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('1', '3', 'system', 'WM', '118', '系统管理', '/system', '1', '1', null, '系统管理', '1000', '-1', '2017-11-02 14:55:40', null, null, '0');
INSERT INTO `resource` VALUES ('2', '3', 'system.role.role_page', 'WM', '1', '角色权限管理', '/system/config/role', '1', '1', null, '角色权限管理', '10', '-1', '2017-11-02 14:55:40', null, null, '0');
INSERT INTO `resource` VALUES ('4', '3', 'proconf', 'WM', '118', '基金产品配置', '/proconf/', '1', '1', null, '产品配置', '20', '-1', '2017-11-02 14:55:40', null, null, '0');
INSERT INTO `resource` VALUES ('5', '3', 'proconf.product.config.elements', 'WM', '4', '要素配置', '/product/config/elements', '1', '1', null, '产品要素配置', '10', '-1', '2017-11-02 14:55:40', null, null, '0');
INSERT INTO `resource` VALUES ('6', '3', 'system.config.organization', 'WM', '1', '组织结构管理', '/system/config/organization', '1', '1', null, '组织架构管理', '20', '-1', '2017-11-02 14:55:40', null, null, '0');
INSERT INTO `resource` VALUES ('7', '3', 'proconf.product.config.type', 'WM', '4', '类别配置', '/product/config/category', '1', '1', null, '产品类别管理', '20', '-1', '2017-11-02 14:55:40', null, null, '0');
INSERT INTO `resource` VALUES ('8', '3', 'product.control', 'WM', '117', '产品管理', '/product/control/', '1', '1', null, '产品管理', '30', '-1', '2017-11-02 14:55:40', null, null, '0');
INSERT INTO `resource` VALUES ('9', '3', 'product.control.index', 'WM', '8', '产品管理', '/product/control/index', '1', '1', null, '产品管理', '10', '-1', '2017-11-02 14:55:40', null, null, '0');
INSERT INTO `resource` VALUES ('10', '3', 'product.control.audit', 'WM', '8', '产品审批', '/product/control/audit', '1', '1', null, '产品审核', '20', '-1', '2017-11-02 14:55:40', null, null, '0');
INSERT INTO `resource` VALUES ('11', '3', 'product.control.new', 'WM', '9', '新增产品', '/product/add', '0', '1', null, '新增产品', '30', '-1', '2017-11-02 14:55:40', null, null, '0');
INSERT INTO `resource` VALUES ('13', '3', 'product.notice.index', 'WM', '8', '公告管理', '/product/notice/index', '1', '1', null, '公告管理', '40', '-1', '2017-11-02 14:55:40', null, null, '0');
INSERT INTO `resource` VALUES ('14', '3', 'product.notice.audit', 'WM', '8', '公告审批', '/product/notice/audit', '1', '1', null, '公告审核', '50', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('15', '3', 'product.element.add', 'WM', '5', '新增要素', '/product/element/add', '0', '1', null, '新增产品要素', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('16', '3', 'product.fieldgroup.add', 'WM', '7', '新增类别', '/product/fieldgroup/add', '0', '1', null, '新增产品类别', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('17', '3', 'product.examine.audit', 'WM', '10', '产品上线审批', '/product/control/audit/do', '0', '1', null, '产品上线审核', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('19', '3', 'product.notice.add', 'WM', '13', '新增产品公告', '/product/notice/add', '0', '1', null, '新增产品公告', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('20', '3', 'product.notice.flow', 'WM', '14', '产品公告审批', '/product/notice/flow', '0', '1', null, '产品公告审核', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('21', '3', 'product.center', 'WM', '117', '产品中心', '/product/center', '1', '1', null, '产品中心', '0', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('22', '3', 'customer', 'WM', '117', '客户管理', '/customer', '1', '1', null, '客户管理', '40', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('23', '3', 'customer.my', 'WM', '22', '我的客户', '/customer/my', '1', '1', '0', '我的客户', '10', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('24', '3', 'customer.pool', 'WM', '22', '全部客户', '/customer/pool', '1', '1', '0', '全部客户', '20', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('26', '3', 'sale', 'WM', '117', '销售管理', '/sale', '1', '1', null, '销售管理', '50', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('27', '3', 'sale.appointment', 'WM', '26', '我的预约', '/sale/appointment', '1', '1', null, '我的预约', '20', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('28', '3', 'sale.declaration', 'WM', '26', '我的报单', '/sale/declaration', '1', '1', null, '我的报单', '30', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('29', '3', 'sale.appointment.audit', 'WM', '26', '预约额度审批', '/sale/appointment/audit', '1', '1', null, '预约额度确认', '40', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('30', '3', 'sale.declaration.audit', 'WM', '26', '报单审批', '/sale/declaration/audit', '1', '1', null, '报单审核', '50', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('34', '3', 'operation.allot', 'WM', '22', '回访管理', '/operation/allot', '1', '1', null, '回访管理', '40', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('36', '3', 'product.center.reservation', 'WM', '21', '预约', '/product/center/reservation', '0', '1', null, '产品中心 预约', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('37', '3', 'product.center.declaration', 'WM', '21', '报单', '/declaration/pc_add', '0', '1', null, '产品中心 报单', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('43', '3', 'customer.back.apply', 'WM', '23', '回退', '/customer/back/apply', '0', '1', '0', '客户管理 - 我的客户 回退', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('44', '3', 'customer.add', 'WM', '23', '新增客户', '/customer/add', '0', '1', '0', '客户管理 - 我的客户 新增客户', '2', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('46', '3', 'customer.distribution.allot_to_fp', 'WM', '24', '调配', '/customer/distribution/allot_to_fp', '0', '1', '0', '客户管理 - 客户池 调配', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('47', '3', 'customer.distribution.recycle', 'WM', '24', '回收', '/customer/distribution/recycle', '0', '1', '0', '客户管理 - 客户池 回收', '2', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('48', '3', 'customer.distribution.allot_to_cs', 'WM', '24', '分配回访', '/customer/distribution/allot_to_cs', '0', '1', '0', '客户管理 - 客户池 分配回访', '3', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('50', '3', 'customer.pool.add', 'WM', '24', '新增客户', '/customer/pool/add', '0', '1', '0', '客户管理 - 客户池 新增客户', '5', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('55', '3', 'sale.appointment.add', 'WM', '27', '新增预约', '/reservation/add', '0', '1', null, '销售管理 - 我的预约 新增预约', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('56', '3', 'sale.declaration.add', 'WM', '28', '新增报单', '/declaration/add', '0', '1', null, '销售管理 - 我的报单 新增报单', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('57', '3', 'reservation.audit.do', 'WM', '29', '预约额度审批', '/reservation/audit/do', '0', '1', null, '销售管理 - 预约额度确认 预约额度审核', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('59', '3', 'declaration.audit.do', 'WM', '30', '报单审批', '/declaration/audit/do', '0', '1', null, '销售管理 - 报单审核 预约额度审核', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('65', '3', 'reservation.audit.discard', 'WM', '29', '预约作废', '/reservation/audit/discard', '0', '1', null, '销售管理 - 预约额度确认 作废', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('66', '3', 'declaration.audit.discard', 'WM', '30', '报单作废', '/declaration/audit/discard', '0', '1', null, '销售管理 - 报单审核 作废', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('67', '3', 'leads.get_page', 'WM', '26', '销售线索管理', '/operation/clue', '1', '1', null, '销售线索管理', '10', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('68', '3', 'leads.try_allot', 'WM', '67', '分配客服回访', '/leads/try_allot', '0', '1', null, '分配客服回访', '0', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('69', '3', 'leads.allot_to_fp', 'WM', '67', '分配理财师', '/leads/allot_to_fp', '0', '1', null, '销售线索管理-分配理财师', '2', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('72', '3', 'customer.update.status', 'WM', '22', '修改客户有效性', '/customer/update_status', '0', '1', null, '客户管理 - 修改客户有效性', '100', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('73', '3', 'customer.highseas', 'WM', '22', '客户公海', '/customer/highseas', '1', '1', null, '客户管理 - 客户公海', '25', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('74', '3', 'customer.opensea.receive_customer', 'WM', '73', '领取', '/customer/opensea/receive_customer', '0', '1', null, '客户管理 - 客户公海- 领取', '10', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('75', '3', 'customer.add_opensea', 'WM', '73', '新增客户', '/customer/add_opensea', '0', '1', null, '客户管理 - 客户公海- 新增客户', '20', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('76', '3', 'customer.import.multi_from_opensea', 'WM', '73', '批量导入客户', '/customer/import/multi_from_opensea', '0', '1', null, '客户管理 - 客户公海- 批量导入客户', '30', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('77', '3', 'finance', 'WM', '117', '财务管理', '/finance/', '1', '1', null, '财务管理', '60', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('78', '3', 'finance.paymentplan', 'WM', '77', '回款计划管理', '/finance/receiptplan', '1', '1', null, '回款计划管理', '10', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('79', '3', 'finance.knotcommission', 'WM', '77', '结佣管理', '/finance/knotcommission', '1', '1', null, '结佣管理', '20', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('80', '3', 'finance.knotcommission.audit', 'WM', '77', '结佣审批', '/finance/knotcommission/audit', '1', '1', null, '结佣审批', '20', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('81', '3', 'sale.refunds', 'WM', '26', '我的退款', '/sale/refunds', '1', '1', null, '我的退款', '31', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('82', '3', 'sale.refunds.audit', 'WM', '26', '退款审批', '/sale/refunds/audit', '1', '1', null, '退款审批', '51', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('83', '3', 'refund.audit.do', 'WM', '82', '退款审批', '/refund/audit/do', '0', '1', null, '退款审批', '51', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('85', '3', 'declaration.apply_refund', 'WM', '81', '申请退款', '/declaration/apply_refund', '0', '1', null, '申请退款', '51', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('87', '3', 'content.manager.menu', 'WM', '118', '内容配置', '', '1', '1', null, '内容配置', '1050', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('88', '3', 'cms.product.recommend', 'WM', '87', '产品推荐配置', '/cms/product/recommend', '1', '1', null, '产品推荐配置', '10', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('89', '3', 'cms.news.column', 'WM', '87', '文章栏目配置', '/cms/news/column', '1', '1', null, '文章栏目配置', '30', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('90', '3', 'cms.news.list', 'WM', '87', '文章内容配置', '/cms/news/list', '1', '1', null, '文章内容配置', '40', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `resource` VALUES ('91', '3', 'customer.index', 'WM', '22', '客户', '/customer/index', '1', '1', '1', '客户（我的客户和全部客户合并）', '10', '-1', '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `resource` VALUES ('92', '3', 'customer.v2.back.apply', 'WM', '91', '放弃', '/customer/v2/back/apply', '0', '1', '0', '客户管理 - 客户 放弃(回退)', '2', '-1', '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `resource` VALUES ('93', '3', 'customer.v2.add', 'WM', '91', '新增客户', '/customer/v2/add', '0', '1', '0', '客户管理 - 客户 新增客户', '6', '-1', '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `resource` VALUES ('94', '3', 'customer.v2.import.multi', 'WM', '91', '批量导入客户', '/customer/v2/import/multi', '0', '1', '0', '客户管理 - 客户 批量导入客户', '7', '-1', '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `resource` VALUES ('95', '3', 'customer.v2.distribution.allot_to_fp', 'WM', '91', '调配', '/customer/v2/distribution/allot_to_fp', '0', '1', '0', '客户管理 - 客户 调配', '3', '-1', '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `resource` VALUES ('96', '3', 'customer.v2.distribution.recycle', 'WM', '91', '回收', '/customer/v2/distribution/recycle', '0', '1', '0', '客户管理 - 客户 回收', '4', '-1', '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `resource` VALUES ('97', '3', 'customer.v2.distribution.allot_to_cs', 'WM', '91', '分配回访', '/customer/v2/distribution/allot_to_cs', '0', '1', '0', '客户管理 - 客户 分配回访', '5', '-1', '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `resource` VALUES ('98', '3', 'user.customer.v2.focus', 'WM', '91', '关注', '/user/customer/v2/focus', '0', '1', '0', '客户管理 - 客户 关注', '1', '-1', '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `resource` VALUES ('99', '3', 'report', 'WM', '0', '数据报表(APP)', '/report/', '1', '1', '0', '数据报表(APP)', '1060', '-1', '2017-11-15 16:22:21', null, null, '0');
INSERT INTO `resource` VALUES ('100', '3', 'report.declaration.company', 'WM', '99', '公司业绩走势', '/report/declaration/company/', '1', '1', '0', '数据报表(APP)-->公司业绩走势', '10', '-1', '2017-11-15 16:22:21', null, null, '0');
INSERT INTO `resource` VALUES ('101', '3', 'report.declaration.user.top', 'WM', '99', '员工业绩Top榜', '/report/declaration/user/top', '1', '1', '0', '数据报表(APP)-->员工业绩Top榜', '20', '-1', '2017-11-15 16:22:21', null, null, '0');
INSERT INTO `resource` VALUES ('102', '3', 'report.declaration', 'WM', '99', '业绩报表', '/report/declaration', '1', '1', '0', '数据报表(APP)-->业绩报表', '30', '-1', '2017-11-15 16:22:21', null, null, '0');
INSERT INTO `resource` VALUES ('103', '3', 'report.declaration.department', 'WM', '102', '部门业绩', '/report/declaration/department', '0', '1', '0', '数据报表(APP)-->业绩报表-->部门业绩', '10', '-1', '2017-11-15 16:22:21', null, null, '0');
INSERT INTO `resource` VALUES ('104', '3', 'report.declaration.user', 'WM', '102', '员工业绩', '/report/declaration/user', '0', '1', '0', '数据报表(APP)-->业绩报表-->员工业绩', '20', '-1', '2017-11-15 16:22:21', null, null, '0');
INSERT INTO `resource` VALUES ('105', '3', 'report.declaration.customer', 'WM', '99', '客户成交', '/report/declaration/customer', '1', '1', '0', '数据报表(APP)-->客户成交', '50', '-1', '2017-11-15 16:22:21', null, null, '0');
INSERT INTO `resource` VALUES ('106', '3', 'system.config.sale', 'WM', '1', '销售管理配置', '/system/config/sale', '1', '1', '1', '销售管理配置', '30', '-1', '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `resource` VALUES ('107', '3', 'cms.roadshow.list', 'WM', '87', '路演内容配置', '/cms/roadshow/list', '1', '1', '1', '内容配置-->路演内容配置', '60', '-1', '2017-11-15 16:22:21', null, null, '0');
INSERT INTO `resource` VALUES ('108', '3', 'cms.roadshow.column', 'WM', '87', '路演栏目配置', '/cms/roadshow/column', '1', '1', '1', '内容配置-->路演栏目配置', '50', '-1', '2017-11-15 16:22:21', null, null, '0');
INSERT INTO `resource` VALUES ('109', '3', 'cms.video.list', 'WM', '87', '路演视频管理', '/cms/video/list', '1', '1', '1', '内容配置-->路演视频管理', '70', '-1', '2017-11-15 16:22:21', null, null, '0');
INSERT INTO `resource` VALUES ('110', '3', 'investment', 'WM', '0', '投资管理', '/investment', '1', '1', '1', '投资管理', '0', '-1', '2017-11-26 14:11:14', null, null, '0');
INSERT INTO `resource` VALUES ('111', '3', 'assets.index', 'WM', '110', '首页', '/assets/index', '1', '1', '1', '首页', '10', '-1', '2017-11-26 14:11:14', null, null, '0');
INSERT INTO `resource` VALUES ('112', '3', 'assets.project', 'WM', '110', '项目', '/assets/project', '1', '1', '1', '项目', '20', '-1', '2017-11-26 14:11:14', null, null, '0');
INSERT INTO `resource` VALUES ('113', '3', 'assets.investment', 'WM', '110', '投资管理', '/assets/investment', '1', '1', '1', '投资管理', '30', '-1', '2017-11-26 14:11:14', null, null, '0');
INSERT INTO `resource` VALUES ('114', '3', 'assets.withdrawal', 'WM', '110', '退出管理', '/assets/withdrawal', '1', '1', '1', '退出管理', '40', '-1', '2017-11-26 14:11:14', null, null, '0');
INSERT INTO `resource` VALUES ('115', '3', 'assets.fund', 'WM', '110', '基金', '/assets/fund', '1', '1', '1', '基金', '25', '-1', '2017-11-26 14:11:14', null, null, '0');
INSERT INTO `resource` VALUES ('117', '3', 'wealth', 'WM', '0', '财富管理', '/wealth', '1', '1', '1', '财富管理', '20', '-1', '2017-11-26 14:11:14', null, null, '0');
INSERT INTO `resource` VALUES ('118', '3', 'backstage', 'WM', '0', '后台管理', '/backstage', '1', '1', '1', '后台管理', '30', '-1', '2017-11-26 14:11:14', null, null, '0');
INSERT INTO `resource` VALUES ('119', '3', 'assets.index.audit.todo', 'WM', '111', '待我审批', '/assets/index/audit/todo', '0', '1', '1', '待我审批', '10', '-1', '2017-11-26 14:11:14', null, null, '0');
INSERT INTO `resource` VALUES ('120', '3', 'assets.index.audit_history.get_page', 'WM', '111', '审批历史', '/assets/index/audit_history/get_page', '0', '1', '1', '审批历史', '20', '-1', '2017-11-26 14:11:14', null, null, '0');
INSERT INTO `resource` VALUES ('121', '3', 'assets.index.report', 'WM', '111', '资产管理概况', '/assets/index/report', '0', '1', '1', '资产管理概况', '30', '-1', '2017-11-26 14:11:14', null, null, '0');
INSERT INTO `resource` VALUES ('122', '3', 'assets.project.add', 'WM', '112', '新增项目', '/assets/project/add', '0', '1', '1', '新增项目', '10', '-1', '2017-11-26 14:11:14', null, null, '0');
INSERT INTO `resource` VALUES ('123', '3', 'assets.project.decision.audit_decisioning', 'WM', '112', '立项会审批', '/assets/project/decision/audit_decisioning', '0', '1', '1', '立项会审批', '20', '-1', '2017-11-26 14:11:14', null, null, '0');
INSERT INTO `resource` VALUES ('124', '3', 'assets.project.decision.audit_due_diligence', 'WM', '112', '尽职调查审批', '/assets/project/decision/audit_due_diligence', '0', '1', '1', '尽职调查审批', '30', '-1', '2017-11-26 14:11:14', null, null, '0');
INSERT INTO `resource` VALUES ('125', '3', 'assets.project.decision.audit_first_trial', 'WM', '112', '初审审批', '/assets/project/decision/audit_first_trial', '0', '1', '1', '初审审批', '40', '-1', '2017-11-26 14:11:14', null, null, '0');
INSERT INTO `resource` VALUES ('126', '3', 'assets.project.decision.audit_investment_commission', 'WM', '112', '投委会审批', '/assets/project/decision/audit_investment_commission', '0', '1', '1', '投委会审批', '50', '-1', '2017-11-26 14:11:14', null, null, '0');
INSERT INTO `resource` VALUES ('127', '3', 'assets.project.decision.audit_invest', 'WM', '112', '出资审批', '/assets/project/decision/audit_invest', '0', '1', '1', '出资审批', '60', '-1', '2017-11-26 14:11:14', null, null, '0');
INSERT INTO `resource` VALUES ('128', '3', 'assets.fund.add', 'WM', '115', '新增基金', '/assets/fund/add', '0', '1', '1', '新增基金', '10', '-1', '2017-11-26 14:11:14', null, null, '0');
INSERT INTO `resource` VALUES ('129', '3', 'assets.investment.add', 'WM', '110', '新增出资', '/assets/investment/add', '0', '1', '1', '新增出资', '10', '-1', '2017-11-26 14:11:14', null, null, '0');
INSERT INTO `resource` VALUES ('130', '3', 'assets.withdrawal.add', 'WM', '114', '新增退出', '/assets/withdrawal/add', '0', '1', '1', '新增退出', '10', '-1', '2017-11-26 14:11:14', null, null, '0');
INSERT INTO `resource` VALUES ('131', '3', 'report.customer', 'WM', '99', '客户新增', '/report/customer', '1', '1', '0', '数据报表(APP)-->客户新增', '40', '-1', '2017-12-07 19:04:54', null, null, '0');
INSERT INTO `resource` VALUES ('132', '3', 'report.customer.get_department', 'WM', '131', '部门新增', '/report/customer/get_department', '0', '1', '0', '数据报表(APP)-->客户新增-->部门新增', '10', '-1', '2017-12-07 19:04:54', null, null, '0');
INSERT INTO `resource` VALUES ('133', '3', 'report.customer.get_user_rank_page', 'WM', '131', '员工新增', '/report/customer/get_user_rank_page', '0', '1', '0', '数据报表(APP)-->客户新增-->员工新增', '20', '-1', '2017-12-07 19:04:54', null, null, '0');

-- ----------------------------
-- Table structure for roadshow
-- ----------------------------
DROP TABLE IF EXISTS `roadshow`;
CREATE TABLE `roadshow` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `platform_id` bigint(20) DEFAULT NULL COMMENT '平台ID',
  `title` varchar(64) DEFAULT NULL COMMENT '标题',
  `video_id` bigint(20) DEFAULT NULL COMMENT '视频关联ID',
  `cover_url` varchar(200) DEFAULT NULL COMMENT '封面地址',
  `speaker` varchar(32) DEFAULT NULL COMMENT '主讲人',
  `sponsor` varchar(32) DEFAULT NULL COMMENT '主办方',
  `introduction` varchar(200) DEFAULT NULL COMMENT '简介',
  `sequence` int(11) DEFAULT NULL COMMENT '排序',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `release_time` datetime DEFAULT NULL COMMENT '发布时间',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人ID',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='路演表';

-- ----------------------------
-- Records of roadshow
-- ----------------------------

-- ----------------------------
-- Table structure for roadshow_column
-- ----------------------------
DROP TABLE IF EXISTS `roadshow_column`;
CREATE TABLE `roadshow_column` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `platform_id` bigint(20) DEFAULT NULL COMMENT '平台ID',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `code` varchar(64) DEFAULT NULL COMMENT '编码',
  `sequence` int(4) DEFAULT NULL COMMENT '排序',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态，0：停用，1：启用',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者ID',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '是否删除 0:否 1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='路演栏目表';

-- ----------------------------
-- Records of roadshow_column
-- ----------------------------

-- ----------------------------
-- Table structure for roadshow_column_rel
-- ----------------------------
DROP TABLE IF EXISTS `roadshow_column_rel`;
CREATE TABLE `roadshow_column_rel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `roadshow_id` bigint(20) DEFAULT NULL COMMENT '路演ID',
  `column_id` bigint(20) DEFAULT NULL COMMENT '栏目ID',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者ID',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='路演与栏目关联表';

-- ----------------------------
-- Records of roadshow_column_rel
-- ----------------------------

-- ----------------------------
-- Table structure for roadshow_product_rel
-- ----------------------------
DROP TABLE IF EXISTS `roadshow_product_rel`;
CREATE TABLE `roadshow_product_rel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `roadshow_id` bigint(20) DEFAULT NULL COMMENT '路演ID',
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品ID',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者ID',
  `update_date` datetime DEFAULT NULL COMMENT '更新人ID',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='路演与产品关联表';

-- ----------------------------
-- Records of roadshow_product_rel
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父id',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编码',
  `name` varchar(32) DEFAULT NULL COMMENT '名字',
  `description` varchar(512) DEFAULT NULL COMMENT '描述',
  `is_share` tinyint(2) DEFAULT '0' COMMENT '是否共用，0：否，1：是',
  `is_enabled` tinyint(2) DEFAULT '1' COMMENT '是否启用，0：否，1：是',
  `is_system` tinyint(2) DEFAULT '0' COMMENT '是否系统预置，0：否，1：是',
  `sequence` int(11) DEFAULT '1' COMMENT '排序，越小越靠前',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `i_tenant_id` (`tenant_id`),
  KEY `i_parent_id` (`parent_id`),
  KEY `i_name` (`name`),
  KEY `i_create_user_id` (`create_user_id`),
  KEY `i_update_user_id` (`update_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '3', '0', null, '超级管理员', '系统管理员', '0', '1', '1', '2', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role` VALUES ('2', '3', '0', null, '理财师', '理财师', '0', '1', '0', '20', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role` VALUES ('3', '3', '0', null, '产品助理', '产品助理', '0', '1', '0', '30', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role` VALUES ('4', '3', '0', null, '产品经理', '产品经理', '0', '1', '0', '40', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role` VALUES ('5', '3', '0', null, '产品总监', '产品总监', '0', '1', '0', '50', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role` VALUES ('6', '3', '0', null, '客服专员', '客服专员', '0', '1', '0', '60', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role` VALUES ('7', '3', '0', null, '运营经理', '运营经理', '0', '1', '0', '70', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role` VALUES ('8', '3', '0', null, '财务专员', '财务专员', '0', '1', '0', '80', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role` VALUES ('9', '3', '0', null, '财务总监', '财务总监', '0', '1', '0', '90', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role` VALUES ('10', '3', '0', null, '项目经理', '项目经理', '0', '1', '0', '100', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role` VALUES ('11', '3', '0', null, '项目总监', '项目总监', '0', '1', '0', '110', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role` VALUES ('12', '3', '0', null, '系统管理员', '系统管理员', '0', '1', '0', '11', '-1', '2017-12-15 09:57:39', null, null, '0');

-- ----------------------------
-- Table structure for role_resource
-- ----------------------------
DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `resource_id` bigint(20) DEFAULT NULL COMMENT '资源id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  `sequence` int(11) DEFAULT '1' COMMENT '排序，越小越靠前',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `i_tenant_id` (`tenant_id`),
  KEY `i_resource_id` (`resource_id`),
  KEY `i_role_id` (`role_id`),
  KEY `i_create_user_id` (`create_user_id`),
  KEY `i_update_user_id` (`update_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1194 DEFAULT CHARSET=utf8 COMMENT='角色资源表';

-- ----------------------------
-- Records of role_resource
-- ----------------------------
INSERT INTO `role_resource` VALUES ('135', '3', '1', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('136', '3', '2', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('137', '3', '4', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('138', '3', '5', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('139', '3', '6', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('140', '3', '7', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('141', '3', '8', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('142', '3', '9', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('143', '3', '10', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('144', '3', '11', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('145', '3', '13', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('146', '3', '14', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('147', '3', '15', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('148', '3', '16', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('149', '3', '17', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('150', '3', '19', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('151', '3', '20', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('152', '3', '21', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('153', '3', '22', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('154', '3', '23', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('155', '3', '24', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('157', '3', '26', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('158', '3', '27', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('159', '3', '28', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('160', '3', '29', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('161', '3', '30', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('162', '3', '34', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('163', '3', '36', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('164', '3', '37', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('165', '3', '43', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('166', '3', '44', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('167', '3', '46', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('168', '3', '47', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('169', '3', '48', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('170', '3', '50', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('172', '3', '55', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('173', '3', '56', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('174', '3', '57', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('175', '3', '59', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('176', '3', '65', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('177', '3', '66', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('178', '3', '67', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('179', '3', '68', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('180', '3', '69', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('183', '3', '72', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('184', '3', '21', '2', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('185', '3', '36', '2', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('186', '3', '37', '2', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('187', '3', '22', '2', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('188', '3', '23', '2', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('189', '3', '43', '2', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('190', '3', '44', '2', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('191', '3', '26', '2', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('192', '3', '27', '2', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('193', '3', '55', '2', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('194', '3', '28', '2', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('195', '3', '56', '2', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('197', '3', '21', '3', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('198', '3', '4', '3', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('199', '3', '5', '3', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('200', '3', '15', '3', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('201', '3', '7', '3', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('202', '3', '16', '3', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('203', '3', '8', '3', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('204', '3', '9', '3', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('205', '3', '11', '3', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('206', '3', '13', '3', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('207', '3', '19', '3', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('208', '3', '26', '3', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('209', '3', '29', '3', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('210', '3', '57', '3', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('211', '3', '30', '3', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('212', '3', '59', '3', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('213', '3', '21', '4', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('214', '3', '4', '4', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('215', '3', '5', '4', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('216', '3', '15', '4', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('217', '3', '7', '4', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('218', '3', '16', '4', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('219', '3', '8', '4', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('220', '3', '9', '4', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('221', '3', '11', '4', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('222', '3', '13', '4', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('223', '3', '19', '4', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('224', '3', '26', '4', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('225', '3', '29', '4', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('226', '3', '57', '4', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('227', '3', '30', '4', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('228', '3', '59', '4', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('229', '3', '21', '5', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('230', '3', '4', '5', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('231', '3', '5', '5', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('232', '3', '15', '5', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('233', '3', '7', '5', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('234', '3', '16', '5', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('235', '3', '8', '5', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('236', '3', '9', '5', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('237', '3', '11', '5', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('238', '3', '13', '5', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('239', '3', '14', '5', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('240', '3', '19', '5', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('241', '3', '10', '5', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('242', '3', '17', '5', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('243', '3', '14', '5', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('244', '3', '20', '5', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('245', '3', '26', '5', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('246', '3', '29', '5', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('247', '3', '57', '5', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('248', '3', '30', '5', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('249', '3', '59', '5', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('250', '3', '21', '6', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('251', '3', '8', '6', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('252', '3', '13', '6', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('253', '3', '22', '6', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('254', '3', '24', '6', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('255', '3', '34', '6', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('256', '3', '21', '7', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('257', '3', '8', '7', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('258', '3', '13', '7', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('259', '3', '22', '7', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('260', '3', '24', '7', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('261', '3', '46', '7', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('262', '3', '47', '7', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('263', '3', '48', '7', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('264', '3', '50', '7', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('267', '3', '34', '7', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('268', '3', '72', '7', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('270', '3', '73', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('271', '3', '74', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('272', '3', '75', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('273', '3', '76', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('274', '3', '26', '6', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('275', '3', '67', '6', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('276', '3', '69', '6', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('277', '3', '26', '7', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('278', '3', '67', '7', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('279', '3', '69', '7', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('280', '3', '68', '7', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('281', '3', '77', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('282', '3', '78', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('283', '3', '79', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('284', '3', '80', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('285', '3', '81', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('286', '3', '82', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('287', '3', '83', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('288', '3', '84', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('289', '3', '85', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('290', '3', '86', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('291', '3', '77', '8', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('292', '3', '78', '8', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('293', '3', '79', '8', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('294', '3', '86', '8', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('295', '3', '77', '9', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('296', '3', '78', '9', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('297', '3', '79', '9', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('298', '3', '80', '9', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('299', '3', '84', '9', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('300', '3', '86', '9', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('301', '3', '87', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('302', '3', '88', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('303', '3', '89', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('304', '3', '90', '1', '1', '-1', '2017-11-02 14:55:41', null, null, '0');
INSERT INTO `role_resource` VALUES ('305', '3', '91', '1', '1', '-1', '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('306', '3', '91', '2', '1', '-1', '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('307', '3', '91', '7', '1', '-1', '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('308', '3', '92', '1', '1', '-1', '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('309', '3', '92', '2', '1', '-1', '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('310', '3', '93', '1', '1', '-1', '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('311', '3', '93', '2', '1', '-1', '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('312', '3', '94', '1', '1', '-1', '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('313', '3', '94', '2', '1', '-1', '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('314', '3', '95', '1', '1', '-1', '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('315', '3', '95', '7', '1', '-1', '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('316', '3', '96', '1', '1', '-1', '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('317', '3', '96', '7', '1', '-1', '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('318', '3', '97', '1', '1', '-1', '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('319', '3', '97', '7', '1', '-1', '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('320', '3', '93', '7', '1', '-1', '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('321', '3', '94', '7', '1', '-1', '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('322', '3', '98', '1', '1', '-1', '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('323', '3', '98', '2', '1', '-1', '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('324', '3', '98', '7', '1', '-1', '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('325', '3', '106', '1', '1', '-1', '2017-11-04 18:45:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('326', '3', '87', '7', '1', null, null, null, null, '0');
INSERT INTO `role_resource` VALUES ('327', '3', '88', '7', '1', null, null, null, null, '0');
INSERT INTO `role_resource` VALUES ('328', '3', '89', '7', '1', null, null, null, null, '0');
INSERT INTO `role_resource` VALUES ('329', '3', '90', '7', '1', null, null, null, null, '0');
INSERT INTO `role_resource` VALUES ('330', null, '99', '1', '1', null, null, null, null, '0');
INSERT INTO `role_resource` VALUES ('331', null, '100', '1', '1', null, null, null, null, '0');
INSERT INTO `role_resource` VALUES ('332', null, '101', '1', '1', null, null, null, null, '0');
INSERT INTO `role_resource` VALUES ('333', null, '102', '1', '1', null, null, null, null, '0');
INSERT INTO `role_resource` VALUES ('334', null, '103', '1', '1', null, null, null, null, '0');
INSERT INTO `role_resource` VALUES ('335', null, '104', '1', '1', null, null, null, null, '0');
INSERT INTO `role_resource` VALUES ('336', null, '105', '1', '1', null, null, null, null, '0');
INSERT INTO `role_resource` VALUES ('337', null, '107', '1', '1', null, null, null, null, '0');
INSERT INTO `role_resource` VALUES ('338', null, '108', '1', '1', null, null, null, null, '0');
INSERT INTO `role_resource` VALUES ('339', null, '109', '1', '1', null, null, null, null, '0');
INSERT INTO `role_resource` VALUES ('340', null, '110', '1', '1', null, null, null, null, '0');
INSERT INTO `role_resource` VALUES ('341', null, '111', '1', '1', null, null, null, null, '0');
INSERT INTO `role_resource` VALUES ('342', null, '112', '1', '1', null, null, null, null, '0');
INSERT INTO `role_resource` VALUES ('343', null, '113', '1', '1', null, null, null, null, '0');
INSERT INTO `role_resource` VALUES ('344', null, '114', '1', '1', null, null, null, null, '0');
INSERT INTO `role_resource` VALUES ('345', null, '115', '1', '1', null, null, null, null, '0');
INSERT INTO `role_resource` VALUES ('347', null, '117', '1', '1', null, null, null, null, '0');
INSERT INTO `role_resource` VALUES ('348', null, '118', '1', '1', null, null, null, null, '0');
INSERT INTO `role_resource` VALUES ('349', '3', '110', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('350', '3', '111', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('351', '3', '119', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('352', '3', '120', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('353', '3', '121', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('354', '3', '112', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('355', '3', '122', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('356', '3', '115', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('357', '3', '128', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('358', '3', '113', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('359', '3', '129', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('360', '3', '114', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('361', '3', '130', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('362', '3', '117', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('363', '3', '21', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('364', '3', '8', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('365', '3', '9', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('366', '3', '13', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('367', '3', '110', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('368', '3', '111', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('369', '3', '119', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('370', '3', '120', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('371', '3', '121', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('372', '3', '112', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('373', '3', '122', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('374', '3', '115', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('375', '3', '128', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('376', '3', '113', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('377', '3', '129', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('378', '3', '114', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('379', '3', '130', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('380', '3', '117', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('381', '3', '21', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('382', '3', '8', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('383', '3', '9', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('384', '3', '13', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('385', '3', '123', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('386', '3', '124', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('387', '3', '125', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('388', '3', '126', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('389', '3', '127', '10', '1', '-1', '2017-11-26 14:11:15', null, null, '0');
INSERT INTO `role_resource` VALUES ('390', '3', '110', '10', '1', '-1', '2017-11-27 09:52:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('391', '3', '111', '10', '1', '-1', '2017-11-27 09:52:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('392', '3', '119', '10', '1', '-1', '2017-11-27 09:52:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('393', '3', '120', '10', '1', '-1', '2017-11-27 09:52:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('394', '3', '121', '10', '1', '-1', '2017-11-27 09:52:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('395', '3', '112', '10', '1', '-1', '2017-11-27 09:52:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('396', '3', '122', '10', '1', '-1', '2017-11-27 09:52:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('397', '3', '115', '10', '1', '-1', '2017-11-27 09:52:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('398', '3', '128', '10', '1', '-1', '2017-11-27 09:52:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('399', '3', '113', '10', '1', '-1', '2017-11-27 09:52:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('400', '3', '129', '10', '1', '-1', '2017-11-27 09:52:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('401', '3', '114', '10', '1', '-1', '2017-11-27 09:52:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('402', '3', '130', '10', '1', '-1', '2017-11-27 09:52:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('403', '3', '117', '10', '1', '-1', '2017-11-27 09:52:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('404', '3', '21', '10', '1', '-1', '2017-11-27 09:52:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('405', '3', '8', '10', '1', '-1', '2017-11-27 09:52:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('406', '3', '9', '10', '1', '-1', '2017-11-27 09:52:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('407', '3', '13', '10', '1', '-1', '2017-11-27 09:52:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('408', '3', '123', '10', '1', '-1', '2017-11-27 09:52:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('409', '3', '124', '10', '1', '-1', '2017-11-27 09:52:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('410', '3', '125', '10', '1', '-1', '2017-11-27 09:52:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('411', '3', '126', '10', '1', '-1', '2017-11-27 09:52:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('412', '3', '127', '10', '1', '-1', '2017-11-27 09:52:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('413', '3', '110', '10', '1', '-1', '2017-11-29 10:10:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('414', '3', '111', '10', '1', '-1', '2017-11-29 10:10:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('415', '3', '119', '10', '1', '-1', '2017-11-29 10:10:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('416', '3', '120', '10', '1', '-1', '2017-11-29 10:10:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('417', '3', '121', '10', '1', '-1', '2017-11-29 10:10:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('418', '3', '112', '10', '1', '-1', '2017-11-29 10:10:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('419', '3', '122', '10', '1', '-1', '2017-11-29 10:10:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('420', '3', '115', '10', '1', '-1', '2017-11-29 10:10:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('421', '3', '128', '10', '1', '-1', '2017-11-29 10:10:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('422', '3', '113', '10', '1', '-1', '2017-11-29 10:10:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('423', '3', '129', '10', '1', '-1', '2017-11-29 10:10:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('424', '3', '114', '10', '1', '-1', '2017-11-29 10:10:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('425', '3', '130', '10', '1', '-1', '2017-11-29 10:10:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('426', '3', '117', '10', '1', '-1', '2017-11-29 10:10:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('427', '3', '21', '10', '1', '-1', '2017-11-29 10:10:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('428', '3', '8', '10', '1', '-1', '2017-11-29 10:10:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('429', '3', '9', '10', '1', '-1', '2017-11-29 10:10:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('430', '3', '13', '10', '1', '-1', '2017-11-29 10:10:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('431', '3', '123', '10', '1', '-1', '2017-11-29 10:10:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('432', '3', '124', '10', '1', '-1', '2017-11-29 10:10:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('433', '3', '125', '10', '1', '-1', '2017-11-29 10:10:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('434', '3', '126', '10', '1', '-1', '2017-11-29 10:10:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('435', '3', '127', '10', '1', '-1', '2017-11-29 10:10:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('436', '3', '110', '10', '1', '-1', '2017-11-29 18:28:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('437', '3', '111', '10', '1', '-1', '2017-11-29 18:28:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('438', '3', '119', '10', '1', '-1', '2017-11-29 18:28:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('439', '3', '120', '10', '1', '-1', '2017-11-29 18:28:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('440', '3', '121', '10', '1', '-1', '2017-11-29 18:28:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('441', '3', '112', '10', '1', '-1', '2017-11-29 18:28:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('442', '3', '122', '10', '1', '-1', '2017-11-29 18:28:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('443', '3', '115', '10', '1', '-1', '2017-11-29 18:28:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('444', '3', '128', '10', '1', '-1', '2017-11-29 18:28:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('445', '3', '113', '10', '1', '-1', '2017-11-29 18:28:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('446', '3', '129', '10', '1', '-1', '2017-11-29 18:28:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('447', '3', '114', '10', '1', '-1', '2017-11-29 18:28:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('448', '3', '130', '10', '1', '-1', '2017-11-29 18:28:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('449', '3', '117', '10', '1', '-1', '2017-11-29 18:28:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('450', '3', '21', '10', '1', '-1', '2017-11-29 18:28:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('451', '3', '8', '10', '1', '-1', '2017-11-29 18:28:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('452', '3', '9', '10', '1', '-1', '2017-11-29 18:28:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('453', '3', '13', '10', '1', '-1', '2017-11-29 18:28:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('454', '3', '123', '10', '1', '-1', '2017-11-29 18:28:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('455', '3', '124', '10', '1', '-1', '2017-11-29 18:28:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('456', '3', '125', '10', '1', '-1', '2017-11-29 18:28:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('457', '3', '126', '10', '1', '-1', '2017-11-29 18:28:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('458', '3', '127', '10', '1', '-1', '2017-11-29 18:28:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('459', '3', '110', '10', '1', '-1', '2017-12-01 09:56:38', null, null, '0');
INSERT INTO `role_resource` VALUES ('460', '3', '111', '10', '1', '-1', '2017-12-01 09:56:38', null, null, '0');
INSERT INTO `role_resource` VALUES ('461', '3', '119', '10', '1', '-1', '2017-12-01 09:56:38', null, null, '0');
INSERT INTO `role_resource` VALUES ('462', '3', '120', '10', '1', '-1', '2017-12-01 09:56:38', null, null, '0');
INSERT INTO `role_resource` VALUES ('463', '3', '121', '10', '1', '-1', '2017-12-01 09:56:38', null, null, '0');
INSERT INTO `role_resource` VALUES ('464', '3', '112', '10', '1', '-1', '2017-12-01 09:56:38', null, null, '0');
INSERT INTO `role_resource` VALUES ('465', '3', '122', '10', '1', '-1', '2017-12-01 09:56:38', null, null, '0');
INSERT INTO `role_resource` VALUES ('466', '3', '115', '10', '1', '-1', '2017-12-01 09:56:38', null, null, '0');
INSERT INTO `role_resource` VALUES ('467', '3', '128', '10', '1', '-1', '2017-12-01 09:56:38', null, null, '0');
INSERT INTO `role_resource` VALUES ('468', '3', '113', '10', '1', '-1', '2017-12-01 09:56:38', null, null, '0');
INSERT INTO `role_resource` VALUES ('469', '3', '129', '10', '1', '-1', '2017-12-01 09:56:38', null, null, '0');
INSERT INTO `role_resource` VALUES ('470', '3', '114', '10', '1', '-1', '2017-12-01 09:56:38', null, null, '0');
INSERT INTO `role_resource` VALUES ('471', '3', '130', '10', '1', '-1', '2017-12-01 09:56:38', null, null, '0');
INSERT INTO `role_resource` VALUES ('472', '3', '117', '10', '1', '-1', '2017-12-01 09:56:38', null, null, '0');
INSERT INTO `role_resource` VALUES ('473', '3', '21', '10', '1', '-1', '2017-12-01 09:56:38', null, null, '0');
INSERT INTO `role_resource` VALUES ('474', '3', '8', '10', '1', '-1', '2017-12-01 09:56:38', null, null, '0');
INSERT INTO `role_resource` VALUES ('475', '3', '9', '10', '1', '-1', '2017-12-01 09:56:38', null, null, '0');
INSERT INTO `role_resource` VALUES ('476', '3', '13', '10', '1', '-1', '2017-12-01 09:56:38', null, null, '0');
INSERT INTO `role_resource` VALUES ('477', '3', '123', '10', '1', '-1', '2017-12-01 09:56:38', null, null, '0');
INSERT INTO `role_resource` VALUES ('478', '3', '124', '10', '1', '-1', '2017-12-01 09:56:38', null, null, '0');
INSERT INTO `role_resource` VALUES ('479', '3', '125', '10', '1', '-1', '2017-12-01 09:56:38', null, null, '0');
INSERT INTO `role_resource` VALUES ('480', '3', '126', '10', '1', '-1', '2017-12-01 09:56:38', null, null, '0');
INSERT INTO `role_resource` VALUES ('481', '3', '127', '10', '1', '-1', '2017-12-01 09:56:38', null, null, '0');
INSERT INTO `role_resource` VALUES ('482', '3', '110', '10', '1', '-1', '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('483', '3', '111', '10', '1', '-1', '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('484', '3', '119', '10', '1', '-1', '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('485', '3', '120', '10', '1', '-1', '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('486', '3', '121', '10', '1', '-1', '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('487', '3', '112', '10', '1', '-1', '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('488', '3', '122', '10', '1', '-1', '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('489', '3', '115', '10', '1', '-1', '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('490', '3', '128', '10', '1', '-1', '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('491', '3', '113', '10', '1', '-1', '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('492', '3', '129', '10', '1', '-1', '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('493', '3', '114', '10', '1', '-1', '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('494', '3', '130', '10', '1', '-1', '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('495', '3', '117', '10', '1', '-1', '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('496', '3', '21', '10', '1', '-1', '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('497', '3', '8', '10', '1', '-1', '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('498', '3', '9', '10', '1', '-1', '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('499', '3', '13', '10', '1', '-1', '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('500', '3', '123', '10', '1', '-1', '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('501', '3', '124', '10', '1', '-1', '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('502', '3', '125', '10', '1', '-1', '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('503', '3', '126', '10', '1', '-1', '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('504', '3', '127', '10', '1', '-1', '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('505', '3', '117', '2', '1', null, '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('506', '3', '117', '3', '1', null, '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('507', '3', '117', '4', '1', null, '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('508', '3', '117', '5', '1', null, '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('509', '3', '117', '6', '1', null, '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('510', '3', '117', '7', '1', null, '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('511', '3', '117', '8', '1', null, '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('512', '3', '117', '9', '1', null, '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('520', '3', '118', '3', '1', null, '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('521', '3', '118', '4', '1', null, '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('522', '3', '118', '5', '1', null, '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('523', '3', '118', '7', '1', null, '2017-12-02 09:39:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('527', '3', '110', '10', '1', '-1', '2017-12-02 10:37:14', null, null, '0');
INSERT INTO `role_resource` VALUES ('528', '3', '111', '10', '1', '-1', '2017-12-02 10:37:14', null, null, '0');
INSERT INTO `role_resource` VALUES ('529', '3', '119', '10', '1', '-1', '2017-12-02 10:37:14', null, null, '0');
INSERT INTO `role_resource` VALUES ('530', '3', '120', '10', '1', '-1', '2017-12-02 10:37:14', null, null, '0');
INSERT INTO `role_resource` VALUES ('531', '3', '121', '10', '1', '-1', '2017-12-02 10:37:14', null, null, '0');
INSERT INTO `role_resource` VALUES ('532', '3', '112', '10', '1', '-1', '2017-12-02 10:37:14', null, null, '0');
INSERT INTO `role_resource` VALUES ('533', '3', '122', '10', '1', '-1', '2017-12-02 10:37:14', null, null, '0');
INSERT INTO `role_resource` VALUES ('534', '3', '115', '10', '1', '-1', '2017-12-02 10:37:14', null, null, '0');
INSERT INTO `role_resource` VALUES ('535', '3', '128', '10', '1', '-1', '2017-12-02 10:37:14', null, null, '0');
INSERT INTO `role_resource` VALUES ('536', '3', '113', '10', '1', '-1', '2017-12-02 10:37:14', null, null, '0');
INSERT INTO `role_resource` VALUES ('537', '3', '129', '10', '1', '-1', '2017-12-02 10:37:14', null, null, '0');
INSERT INTO `role_resource` VALUES ('538', '3', '114', '10', '1', '-1', '2017-12-02 10:37:14', null, null, '0');
INSERT INTO `role_resource` VALUES ('539', '3', '130', '10', '1', '-1', '2017-12-02 10:37:14', null, null, '0');
INSERT INTO `role_resource` VALUES ('540', '3', '117', '10', '1', '-1', '2017-12-02 10:37:14', null, null, '0');
INSERT INTO `role_resource` VALUES ('541', '3', '21', '10', '1', '-1', '2017-12-02 10:37:14', null, null, '0');
INSERT INTO `role_resource` VALUES ('542', '3', '8', '10', '1', '-1', '2017-12-02 10:37:14', null, null, '0');
INSERT INTO `role_resource` VALUES ('543', '3', '9', '10', '1', '-1', '2017-12-02 10:37:14', null, null, '0');
INSERT INTO `role_resource` VALUES ('544', '3', '13', '10', '1', '-1', '2017-12-02 10:37:14', null, null, '0');
INSERT INTO `role_resource` VALUES ('545', '3', '123', '10', '1', '-1', '2017-12-02 10:37:14', null, null, '0');
INSERT INTO `role_resource` VALUES ('546', '3', '124', '10', '1', '-1', '2017-12-02 10:37:14', null, null, '0');
INSERT INTO `role_resource` VALUES ('547', '3', '125', '10', '1', '-1', '2017-12-02 10:37:14', null, null, '0');
INSERT INTO `role_resource` VALUES ('548', '3', '126', '10', '1', '-1', '2017-12-02 10:37:14', null, null, '0');
INSERT INTO `role_resource` VALUES ('549', '3', '127', '10', '1', '-1', '2017-12-02 10:37:14', null, null, '0');
INSERT INTO `role_resource` VALUES ('550', '3', '110', '10', '1', '-1', '2017-12-02 11:47:21', null, null, '0');
INSERT INTO `role_resource` VALUES ('551', '3', '111', '10', '1', '-1', '2017-12-02 11:47:21', null, null, '0');
INSERT INTO `role_resource` VALUES ('552', '3', '119', '10', '1', '-1', '2017-12-02 11:47:21', null, null, '0');
INSERT INTO `role_resource` VALUES ('553', '3', '120', '10', '1', '-1', '2017-12-02 11:47:21', null, null, '0');
INSERT INTO `role_resource` VALUES ('554', '3', '121', '10', '1', '-1', '2017-12-02 11:47:21', null, null, '0');
INSERT INTO `role_resource` VALUES ('555', '3', '112', '10', '1', '-1', '2017-12-02 11:47:21', null, null, '0');
INSERT INTO `role_resource` VALUES ('556', '3', '122', '10', '1', '-1', '2017-12-02 11:47:21', null, null, '0');
INSERT INTO `role_resource` VALUES ('557', '3', '115', '10', '1', '-1', '2017-12-02 11:47:21', null, null, '0');
INSERT INTO `role_resource` VALUES ('558', '3', '128', '10', '1', '-1', '2017-12-02 11:47:21', null, null, '0');
INSERT INTO `role_resource` VALUES ('559', '3', '113', '10', '1', '-1', '2017-12-02 11:47:21', null, null, '0');
INSERT INTO `role_resource` VALUES ('560', '3', '129', '10', '1', '-1', '2017-12-02 11:47:21', null, null, '0');
INSERT INTO `role_resource` VALUES ('561', '3', '114', '10', '1', '-1', '2017-12-02 11:47:21', null, null, '0');
INSERT INTO `role_resource` VALUES ('562', '3', '130', '10', '1', '-1', '2017-12-02 11:47:21', null, null, '0');
INSERT INTO `role_resource` VALUES ('563', '3', '117', '10', '1', '-1', '2017-12-02 11:47:21', null, null, '0');
INSERT INTO `role_resource` VALUES ('564', '3', '21', '10', '1', '-1', '2017-12-02 11:47:21', null, null, '0');
INSERT INTO `role_resource` VALUES ('565', '3', '8', '10', '1', '-1', '2017-12-02 11:47:21', null, null, '0');
INSERT INTO `role_resource` VALUES ('566', '3', '9', '10', '1', '-1', '2017-12-02 11:47:21', null, null, '0');
INSERT INTO `role_resource` VALUES ('567', '3', '13', '10', '1', '-1', '2017-12-02 11:47:21', null, null, '0');
INSERT INTO `role_resource` VALUES ('568', '3', '123', '10', '1', '-1', '2017-12-02 11:47:21', null, null, '0');
INSERT INTO `role_resource` VALUES ('569', '3', '124', '10', '1', '-1', '2017-12-02 11:47:21', null, null, '0');
INSERT INTO `role_resource` VALUES ('570', '3', '125', '10', '1', '-1', '2017-12-02 11:47:21', null, null, '0');
INSERT INTO `role_resource` VALUES ('571', '3', '126', '10', '1', '-1', '2017-12-02 11:47:21', null, null, '0');
INSERT INTO `role_resource` VALUES ('572', '3', '127', '10', '1', '-1', '2017-12-02 11:47:21', null, null, '0');
INSERT INTO `role_resource` VALUES ('573', '3', '110', '10', '1', '-1', '2017-12-04 10:16:13', null, null, '0');
INSERT INTO `role_resource` VALUES ('574', '3', '111', '10', '1', '-1', '2017-12-04 10:16:13', null, null, '0');
INSERT INTO `role_resource` VALUES ('575', '3', '119', '10', '1', '-1', '2017-12-04 10:16:13', null, null, '0');
INSERT INTO `role_resource` VALUES ('576', '3', '120', '10', '1', '-1', '2017-12-04 10:16:13', null, null, '0');
INSERT INTO `role_resource` VALUES ('577', '3', '121', '10', '1', '-1', '2017-12-04 10:16:13', null, null, '0');
INSERT INTO `role_resource` VALUES ('578', '3', '112', '10', '1', '-1', '2017-12-04 10:16:13', null, null, '0');
INSERT INTO `role_resource` VALUES ('579', '3', '122', '10', '1', '-1', '2017-12-04 10:16:13', null, null, '0');
INSERT INTO `role_resource` VALUES ('580', '3', '115', '10', '1', '-1', '2017-12-04 10:16:13', null, null, '0');
INSERT INTO `role_resource` VALUES ('581', '3', '128', '10', '1', '-1', '2017-12-04 10:16:13', null, null, '0');
INSERT INTO `role_resource` VALUES ('582', '3', '113', '10', '1', '-1', '2017-12-04 10:16:13', null, null, '0');
INSERT INTO `role_resource` VALUES ('583', '3', '129', '10', '1', '-1', '2017-12-04 10:16:13', null, null, '0');
INSERT INTO `role_resource` VALUES ('584', '3', '114', '10', '1', '-1', '2017-12-04 10:16:13', null, null, '0');
INSERT INTO `role_resource` VALUES ('585', '3', '130', '10', '1', '-1', '2017-12-04 10:16:13', null, null, '0');
INSERT INTO `role_resource` VALUES ('586', '3', '117', '10', '1', '-1', '2017-12-04 10:16:13', null, null, '0');
INSERT INTO `role_resource` VALUES ('587', '3', '21', '10', '1', '-1', '2017-12-04 10:16:13', null, null, '0');
INSERT INTO `role_resource` VALUES ('588', '3', '8', '10', '1', '-1', '2017-12-04 10:16:13', null, null, '0');
INSERT INTO `role_resource` VALUES ('589', '3', '9', '10', '1', '-1', '2017-12-04 10:16:13', null, null, '0');
INSERT INTO `role_resource` VALUES ('590', '3', '13', '10', '1', '-1', '2017-12-04 10:16:13', null, null, '0');
INSERT INTO `role_resource` VALUES ('591', '3', '123', '10', '1', '-1', '2017-12-04 10:16:13', null, null, '0');
INSERT INTO `role_resource` VALUES ('592', '3', '124', '10', '1', '-1', '2017-12-04 10:16:13', null, null, '0');
INSERT INTO `role_resource` VALUES ('593', '3', '125', '10', '1', '-1', '2017-12-04 10:16:13', null, null, '0');
INSERT INTO `role_resource` VALUES ('594', '3', '126', '10', '1', '-1', '2017-12-04 10:16:13', null, null, '0');
INSERT INTO `role_resource` VALUES ('595', '3', '127', '10', '1', '-1', '2017-12-04 10:16:13', null, null, '0');
INSERT INTO `role_resource` VALUES ('596', '3', '110', '10', '1', '-1', '2017-12-04 22:06:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('597', '3', '111', '10', '1', '-1', '2017-12-04 22:06:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('598', '3', '119', '10', '1', '-1', '2017-12-04 22:06:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('599', '3', '120', '10', '1', '-1', '2017-12-04 22:06:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('600', '3', '121', '10', '1', '-1', '2017-12-04 22:06:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('601', '3', '112', '10', '1', '-1', '2017-12-04 22:06:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('602', '3', '122', '10', '1', '-1', '2017-12-04 22:06:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('603', '3', '115', '10', '1', '-1', '2017-12-04 22:06:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('604', '3', '128', '10', '1', '-1', '2017-12-04 22:06:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('605', '3', '113', '10', '1', '-1', '2017-12-04 22:06:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('606', '3', '129', '10', '1', '-1', '2017-12-04 22:06:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('607', '3', '114', '10', '1', '-1', '2017-12-04 22:06:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('608', '3', '130', '10', '1', '-1', '2017-12-04 22:06:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('609', '3', '117', '10', '1', '-1', '2017-12-04 22:06:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('610', '3', '21', '10', '1', '-1', '2017-12-04 22:06:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('611', '3', '8', '10', '1', '-1', '2017-12-04 22:06:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('612', '3', '9', '10', '1', '-1', '2017-12-04 22:06:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('613', '3', '13', '10', '1', '-1', '2017-12-04 22:06:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('614', '3', '123', '10', '1', '-1', '2017-12-04 22:06:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('615', '3', '124', '10', '1', '-1', '2017-12-04 22:06:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('616', '3', '125', '10', '1', '-1', '2017-12-04 22:06:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('617', '3', '126', '10', '1', '-1', '2017-12-04 22:06:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('618', '3', '127', '10', '1', '-1', '2017-12-04 22:06:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('619', '3', '110', '10', '1', '-1', '2017-12-05 09:29:52', null, null, '0');
INSERT INTO `role_resource` VALUES ('620', '3', '111', '10', '1', '-1', '2017-12-05 09:29:52', null, null, '0');
INSERT INTO `role_resource` VALUES ('621', '3', '119', '10', '1', '-1', '2017-12-05 09:29:52', null, null, '0');
INSERT INTO `role_resource` VALUES ('622', '3', '120', '10', '1', '-1', '2017-12-05 09:29:52', null, null, '0');
INSERT INTO `role_resource` VALUES ('623', '3', '121', '10', '1', '-1', '2017-12-05 09:29:52', null, null, '0');
INSERT INTO `role_resource` VALUES ('624', '3', '112', '10', '1', '-1', '2017-12-05 09:29:52', null, null, '0');
INSERT INTO `role_resource` VALUES ('625', '3', '122', '10', '1', '-1', '2017-12-05 09:29:52', null, null, '0');
INSERT INTO `role_resource` VALUES ('626', '3', '115', '10', '1', '-1', '2017-12-05 09:29:52', null, null, '0');
INSERT INTO `role_resource` VALUES ('627', '3', '128', '10', '1', '-1', '2017-12-05 09:29:52', null, null, '0');
INSERT INTO `role_resource` VALUES ('628', '3', '113', '10', '1', '-1', '2017-12-05 09:29:52', null, null, '0');
INSERT INTO `role_resource` VALUES ('629', '3', '129', '10', '1', '-1', '2017-12-05 09:29:52', null, null, '0');
INSERT INTO `role_resource` VALUES ('630', '3', '114', '10', '1', '-1', '2017-12-05 09:29:52', null, null, '0');
INSERT INTO `role_resource` VALUES ('631', '3', '130', '10', '1', '-1', '2017-12-05 09:29:52', null, null, '0');
INSERT INTO `role_resource` VALUES ('632', '3', '117', '10', '1', '-1', '2017-12-05 09:29:52', null, null, '0');
INSERT INTO `role_resource` VALUES ('633', '3', '21', '10', '1', '-1', '2017-12-05 09:29:52', null, null, '0');
INSERT INTO `role_resource` VALUES ('634', '3', '8', '10', '1', '-1', '2017-12-05 09:29:52', null, null, '0');
INSERT INTO `role_resource` VALUES ('635', '3', '9', '10', '1', '-1', '2017-12-05 09:29:52', null, null, '0');
INSERT INTO `role_resource` VALUES ('636', '3', '13', '10', '1', '-1', '2017-12-05 09:29:52', null, null, '0');
INSERT INTO `role_resource` VALUES ('637', '3', '123', '10', '1', '-1', '2017-12-05 09:29:52', null, null, '0');
INSERT INTO `role_resource` VALUES ('638', '3', '124', '10', '1', '-1', '2017-12-05 09:29:52', null, null, '0');
INSERT INTO `role_resource` VALUES ('639', '3', '125', '10', '1', '-1', '2017-12-05 09:29:52', null, null, '0');
INSERT INTO `role_resource` VALUES ('640', '3', '126', '10', '1', '-1', '2017-12-05 09:29:52', null, null, '0');
INSERT INTO `role_resource` VALUES ('641', '3', '127', '10', '1', '-1', '2017-12-05 09:29:52', null, null, '0');
INSERT INTO `role_resource` VALUES ('642', '3', '110', '10', '1', '-1', '2017-12-07 08:30:01', null, null, '0');
INSERT INTO `role_resource` VALUES ('643', '3', '111', '10', '1', '-1', '2017-12-07 08:30:01', null, null, '0');
INSERT INTO `role_resource` VALUES ('644', '3', '119', '10', '1', '-1', '2017-12-07 08:30:01', null, null, '0');
INSERT INTO `role_resource` VALUES ('645', '3', '120', '10', '1', '-1', '2017-12-07 08:30:01', null, null, '0');
INSERT INTO `role_resource` VALUES ('646', '3', '121', '10', '1', '-1', '2017-12-07 08:30:01', null, null, '0');
INSERT INTO `role_resource` VALUES ('647', '3', '112', '10', '1', '-1', '2017-12-07 08:30:01', null, null, '0');
INSERT INTO `role_resource` VALUES ('648', '3', '122', '10', '1', '-1', '2017-12-07 08:30:01', null, null, '0');
INSERT INTO `role_resource` VALUES ('649', '3', '115', '10', '1', '-1', '2017-12-07 08:30:01', null, null, '0');
INSERT INTO `role_resource` VALUES ('650', '3', '128', '10', '1', '-1', '2017-12-07 08:30:01', null, null, '0');
INSERT INTO `role_resource` VALUES ('651', '3', '113', '10', '1', '-1', '2017-12-07 08:30:01', null, null, '0');
INSERT INTO `role_resource` VALUES ('652', '3', '129', '10', '1', '-1', '2017-12-07 08:30:01', null, null, '0');
INSERT INTO `role_resource` VALUES ('653', '3', '114', '10', '1', '-1', '2017-12-07 08:30:01', null, null, '0');
INSERT INTO `role_resource` VALUES ('654', '3', '130', '10', '1', '-1', '2017-12-07 08:30:01', null, null, '0');
INSERT INTO `role_resource` VALUES ('655', '3', '117', '10', '1', '-1', '2017-12-07 08:30:01', null, null, '0');
INSERT INTO `role_resource` VALUES ('656', '3', '21', '10', '1', '-1', '2017-12-07 08:30:01', null, null, '0');
INSERT INTO `role_resource` VALUES ('657', '3', '8', '10', '1', '-1', '2017-12-07 08:30:01', null, null, '0');
INSERT INTO `role_resource` VALUES ('658', '3', '9', '10', '1', '-1', '2017-12-07 08:30:01', null, null, '0');
INSERT INTO `role_resource` VALUES ('659', '3', '13', '10', '1', '-1', '2017-12-07 08:30:01', null, null, '0');
INSERT INTO `role_resource` VALUES ('660', '3', '123', '10', '1', '-1', '2017-12-07 08:30:01', null, null, '0');
INSERT INTO `role_resource` VALUES ('661', '3', '124', '10', '1', '-1', '2017-12-07 08:30:01', null, null, '0');
INSERT INTO `role_resource` VALUES ('662', '3', '125', '10', '1', '-1', '2017-12-07 08:30:01', null, null, '0');
INSERT INTO `role_resource` VALUES ('663', '3', '126', '10', '1', '-1', '2017-12-07 08:30:01', null, null, '0');
INSERT INTO `role_resource` VALUES ('664', '3', '127', '10', '1', '-1', '2017-12-07 08:30:01', null, null, '0');
INSERT INTO `role_resource` VALUES ('665', '3', '110', '10', '1', '-1', '2017-12-07 17:34:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('666', '3', '111', '10', '1', '-1', '2017-12-07 17:34:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('667', '3', '119', '10', '1', '-1', '2017-12-07 17:34:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('668', '3', '120', '10', '1', '-1', '2017-12-07 17:34:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('669', '3', '121', '10', '1', '-1', '2017-12-07 17:34:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('670', '3', '112', '10', '1', '-1', '2017-12-07 17:34:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('671', '3', '122', '10', '1', '-1', '2017-12-07 17:34:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('672', '3', '115', '10', '1', '-1', '2017-12-07 17:34:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('673', '3', '128', '10', '1', '-1', '2017-12-07 17:34:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('674', '3', '113', '10', '1', '-1', '2017-12-07 17:34:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('675', '3', '129', '10', '1', '-1', '2017-12-07 17:34:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('676', '3', '114', '10', '1', '-1', '2017-12-07 17:34:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('677', '3', '130', '10', '1', '-1', '2017-12-07 17:34:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('678', '3', '117', '10', '1', '-1', '2017-12-07 17:34:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('679', '3', '21', '10', '1', '-1', '2017-12-07 17:34:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('680', '3', '8', '10', '1', '-1', '2017-12-07 17:34:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('681', '3', '9', '10', '1', '-1', '2017-12-07 17:34:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('682', '3', '13', '10', '1', '-1', '2017-12-07 17:34:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('683', '3', '123', '10', '1', '-1', '2017-12-07 17:34:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('684', '3', '124', '10', '1', '-1', '2017-12-07 17:34:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('685', '3', '125', '10', '1', '-1', '2017-12-07 17:34:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('686', '3', '126', '10', '1', '-1', '2017-12-07 17:34:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('687', '3', '127', '10', '1', '-1', '2017-12-07 17:34:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('688', '3', '110', '10', '1', '-1', '2017-12-07 19:04:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('689', '3', '111', '10', '1', '-1', '2017-12-07 19:04:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('690', '3', '119', '10', '1', '-1', '2017-12-07 19:04:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('691', '3', '120', '10', '1', '-1', '2017-12-07 19:04:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('692', '3', '121', '10', '1', '-1', '2017-12-07 19:04:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('693', '3', '112', '10', '1', '-1', '2017-12-07 19:04:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('694', '3', '122', '10', '1', '-1', '2017-12-07 19:04:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('695', '3', '115', '10', '1', '-1', '2017-12-07 19:04:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('696', '3', '128', '10', '1', '-1', '2017-12-07 19:04:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('697', '3', '113', '10', '1', '-1', '2017-12-07 19:04:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('698', '3', '129', '10', '1', '-1', '2017-12-07 19:04:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('699', '3', '114', '10', '1', '-1', '2017-12-07 19:04:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('700', '3', '130', '10', '1', '-1', '2017-12-07 19:04:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('701', '3', '117', '10', '1', '-1', '2017-12-07 19:04:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('702', '3', '21', '10', '1', '-1', '2017-12-07 19:04:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('703', '3', '8', '10', '1', '-1', '2017-12-07 19:04:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('704', '3', '9', '10', '1', '-1', '2017-12-07 19:04:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('705', '3', '13', '10', '1', '-1', '2017-12-07 19:04:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('706', '3', '123', '10', '1', '-1', '2017-12-07 19:04:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('707', '3', '124', '10', '1', '-1', '2017-12-07 19:04:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('708', '3', '125', '10', '1', '-1', '2017-12-07 19:04:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('709', '3', '126', '10', '1', '-1', '2017-12-07 19:04:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('710', '3', '127', '10', '1', '-1', '2017-12-07 19:04:54', null, null, '0');
INSERT INTO `role_resource` VALUES ('711', null, '131', '1', '1', null, null, null, null, '0');
INSERT INTO `role_resource` VALUES ('712', null, '132', '1', '1', null, null, null, null, '0');
INSERT INTO `role_resource` VALUES ('713', null, '133', '1', '1', null, null, null, null, '0');
INSERT INTO `role_resource` VALUES ('714', '3', '110', '10', '1', '-1', '2017-12-07 19:16:17', null, null, '0');
INSERT INTO `role_resource` VALUES ('715', '3', '111', '10', '1', '-1', '2017-12-07 19:16:17', null, null, '0');
INSERT INTO `role_resource` VALUES ('716', '3', '119', '10', '1', '-1', '2017-12-07 19:16:17', null, null, '0');
INSERT INTO `role_resource` VALUES ('717', '3', '120', '10', '1', '-1', '2017-12-07 19:16:17', null, null, '0');
INSERT INTO `role_resource` VALUES ('718', '3', '121', '10', '1', '-1', '2017-12-07 19:16:17', null, null, '0');
INSERT INTO `role_resource` VALUES ('719', '3', '112', '10', '1', '-1', '2017-12-07 19:16:17', null, null, '0');
INSERT INTO `role_resource` VALUES ('720', '3', '122', '10', '1', '-1', '2017-12-07 19:16:17', null, null, '0');
INSERT INTO `role_resource` VALUES ('721', '3', '115', '10', '1', '-1', '2017-12-07 19:16:17', null, null, '0');
INSERT INTO `role_resource` VALUES ('722', '3', '128', '10', '1', '-1', '2017-12-07 19:16:17', null, null, '0');
INSERT INTO `role_resource` VALUES ('723', '3', '113', '10', '1', '-1', '2017-12-07 19:16:17', null, null, '0');
INSERT INTO `role_resource` VALUES ('724', '3', '129', '10', '1', '-1', '2017-12-07 19:16:17', null, null, '0');
INSERT INTO `role_resource` VALUES ('725', '3', '114', '10', '1', '-1', '2017-12-07 19:16:17', null, null, '0');
INSERT INTO `role_resource` VALUES ('726', '3', '130', '10', '1', '-1', '2017-12-07 19:16:17', null, null, '0');
INSERT INTO `role_resource` VALUES ('727', '3', '117', '10', '1', '-1', '2017-12-07 19:16:17', null, null, '0');
INSERT INTO `role_resource` VALUES ('728', '3', '21', '10', '1', '-1', '2017-12-07 19:16:17', null, null, '0');
INSERT INTO `role_resource` VALUES ('729', '3', '8', '10', '1', '-1', '2017-12-07 19:16:17', null, null, '0');
INSERT INTO `role_resource` VALUES ('730', '3', '9', '10', '1', '-1', '2017-12-07 19:16:17', null, null, '0');
INSERT INTO `role_resource` VALUES ('731', '3', '13', '10', '1', '-1', '2017-12-07 19:16:17', null, null, '0');
INSERT INTO `role_resource` VALUES ('732', '3', '123', '10', '1', '-1', '2017-12-07 19:16:17', null, null, '0');
INSERT INTO `role_resource` VALUES ('733', '3', '124', '10', '1', '-1', '2017-12-07 19:16:17', null, null, '0');
INSERT INTO `role_resource` VALUES ('734', '3', '125', '10', '1', '-1', '2017-12-07 19:16:17', null, null, '0');
INSERT INTO `role_resource` VALUES ('735', '3', '126', '10', '1', '-1', '2017-12-07 19:16:17', null, null, '0');
INSERT INTO `role_resource` VALUES ('736', '3', '127', '10', '1', '-1', '2017-12-07 19:16:17', null, null, '0');
INSERT INTO `role_resource` VALUES ('737', '3', '110', '10', '1', '-1', '2017-12-08 09:24:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('738', '3', '111', '10', '1', '-1', '2017-12-08 09:24:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('739', '3', '119', '10', '1', '-1', '2017-12-08 09:24:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('740', '3', '120', '10', '1', '-1', '2017-12-08 09:24:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('741', '3', '121', '10', '1', '-1', '2017-12-08 09:24:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('742', '3', '112', '10', '1', '-1', '2017-12-08 09:24:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('743', '3', '122', '10', '1', '-1', '2017-12-08 09:24:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('744', '3', '115', '10', '1', '-1', '2017-12-08 09:24:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('745', '3', '128', '10', '1', '-1', '2017-12-08 09:24:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('746', '3', '113', '10', '1', '-1', '2017-12-08 09:24:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('747', '3', '129', '10', '1', '-1', '2017-12-08 09:24:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('748', '3', '114', '10', '1', '-1', '2017-12-08 09:24:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('749', '3', '130', '10', '1', '-1', '2017-12-08 09:24:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('750', '3', '117', '10', '1', '-1', '2017-12-08 09:24:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('751', '3', '21', '10', '1', '-1', '2017-12-08 09:24:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('752', '3', '8', '10', '1', '-1', '2017-12-08 09:24:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('753', '3', '9', '10', '1', '-1', '2017-12-08 09:24:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('754', '3', '13', '10', '1', '-1', '2017-12-08 09:24:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('755', '3', '123', '10', '1', '-1', '2017-12-08 09:24:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('756', '3', '124', '10', '1', '-1', '2017-12-08 09:24:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('757', '3', '125', '10', '1', '-1', '2017-12-08 09:24:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('758', '3', '126', '10', '1', '-1', '2017-12-08 09:24:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('759', '3', '127', '10', '1', '-1', '2017-12-08 09:24:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('760', '3', '110', '10', '1', '-1', '2017-12-08 11:15:07', null, null, '0');
INSERT INTO `role_resource` VALUES ('761', '3', '111', '10', '1', '-1', '2017-12-08 11:15:07', null, null, '0');
INSERT INTO `role_resource` VALUES ('762', '3', '119', '10', '1', '-1', '2017-12-08 11:15:07', null, null, '0');
INSERT INTO `role_resource` VALUES ('763', '3', '120', '10', '1', '-1', '2017-12-08 11:15:07', null, null, '0');
INSERT INTO `role_resource` VALUES ('764', '3', '121', '10', '1', '-1', '2017-12-08 11:15:07', null, null, '0');
INSERT INTO `role_resource` VALUES ('765', '3', '112', '10', '1', '-1', '2017-12-08 11:15:07', null, null, '0');
INSERT INTO `role_resource` VALUES ('766', '3', '122', '10', '1', '-1', '2017-12-08 11:15:07', null, null, '0');
INSERT INTO `role_resource` VALUES ('767', '3', '115', '10', '1', '-1', '2017-12-08 11:15:07', null, null, '0');
INSERT INTO `role_resource` VALUES ('768', '3', '128', '10', '1', '-1', '2017-12-08 11:15:07', null, null, '0');
INSERT INTO `role_resource` VALUES ('769', '3', '113', '10', '1', '-1', '2017-12-08 11:15:07', null, null, '0');
INSERT INTO `role_resource` VALUES ('770', '3', '129', '10', '1', '-1', '2017-12-08 11:15:07', null, null, '0');
INSERT INTO `role_resource` VALUES ('771', '3', '114', '10', '1', '-1', '2017-12-08 11:15:07', null, null, '0');
INSERT INTO `role_resource` VALUES ('772', '3', '130', '10', '1', '-1', '2017-12-08 11:15:07', null, null, '0');
INSERT INTO `role_resource` VALUES ('773', '3', '117', '10', '1', '-1', '2017-12-08 11:15:07', null, null, '0');
INSERT INTO `role_resource` VALUES ('774', '3', '21', '10', '1', '-1', '2017-12-08 11:15:07', null, null, '0');
INSERT INTO `role_resource` VALUES ('775', '3', '8', '10', '1', '-1', '2017-12-08 11:15:07', null, null, '0');
INSERT INTO `role_resource` VALUES ('776', '3', '9', '10', '1', '-1', '2017-12-08 11:15:07', null, null, '0');
INSERT INTO `role_resource` VALUES ('777', '3', '13', '10', '1', '-1', '2017-12-08 11:15:07', null, null, '0');
INSERT INTO `role_resource` VALUES ('778', '3', '123', '10', '1', '-1', '2017-12-08 11:15:07', null, null, '0');
INSERT INTO `role_resource` VALUES ('779', '3', '124', '10', '1', '-1', '2017-12-08 11:15:07', null, null, '0');
INSERT INTO `role_resource` VALUES ('780', '3', '125', '10', '1', '-1', '2017-12-08 11:15:07', null, null, '0');
INSERT INTO `role_resource` VALUES ('781', '3', '126', '10', '1', '-1', '2017-12-08 11:15:07', null, null, '0');
INSERT INTO `role_resource` VALUES ('782', '3', '127', '10', '1', '-1', '2017-12-08 11:15:07', null, null, '0');
INSERT INTO `role_resource` VALUES ('783', '3', '110', '10', '1', '-1', '2017-12-08 11:35:19', null, null, '0');
INSERT INTO `role_resource` VALUES ('784', '3', '111', '10', '1', '-1', '2017-12-08 11:35:19', null, null, '0');
INSERT INTO `role_resource` VALUES ('785', '3', '119', '10', '1', '-1', '2017-12-08 11:35:19', null, null, '0');
INSERT INTO `role_resource` VALUES ('786', '3', '120', '10', '1', '-1', '2017-12-08 11:35:19', null, null, '0');
INSERT INTO `role_resource` VALUES ('787', '3', '121', '10', '1', '-1', '2017-12-08 11:35:19', null, null, '0');
INSERT INTO `role_resource` VALUES ('788', '3', '112', '10', '1', '-1', '2017-12-08 11:35:19', null, null, '0');
INSERT INTO `role_resource` VALUES ('789', '3', '122', '10', '1', '-1', '2017-12-08 11:35:19', null, null, '0');
INSERT INTO `role_resource` VALUES ('790', '3', '115', '10', '1', '-1', '2017-12-08 11:35:19', null, null, '0');
INSERT INTO `role_resource` VALUES ('791', '3', '128', '10', '1', '-1', '2017-12-08 11:35:19', null, null, '0');
INSERT INTO `role_resource` VALUES ('792', '3', '113', '10', '1', '-1', '2017-12-08 11:35:19', null, null, '0');
INSERT INTO `role_resource` VALUES ('793', '3', '129', '10', '1', '-1', '2017-12-08 11:35:19', null, null, '0');
INSERT INTO `role_resource` VALUES ('794', '3', '114', '10', '1', '-1', '2017-12-08 11:35:19', null, null, '0');
INSERT INTO `role_resource` VALUES ('795', '3', '130', '10', '1', '-1', '2017-12-08 11:35:19', null, null, '0');
INSERT INTO `role_resource` VALUES ('796', '3', '117', '10', '1', '-1', '2017-12-08 11:35:19', null, null, '0');
INSERT INTO `role_resource` VALUES ('797', '3', '21', '10', '1', '-1', '2017-12-08 11:35:19', null, null, '0');
INSERT INTO `role_resource` VALUES ('798', '3', '8', '10', '1', '-1', '2017-12-08 11:35:19', null, null, '0');
INSERT INTO `role_resource` VALUES ('799', '3', '9', '10', '1', '-1', '2017-12-08 11:35:19', null, null, '0');
INSERT INTO `role_resource` VALUES ('800', '3', '13', '10', '1', '-1', '2017-12-08 11:35:19', null, null, '0');
INSERT INTO `role_resource` VALUES ('801', '3', '123', '10', '1', '-1', '2017-12-08 11:35:19', null, null, '0');
INSERT INTO `role_resource` VALUES ('802', '3', '124', '10', '1', '-1', '2017-12-08 11:35:19', null, null, '0');
INSERT INTO `role_resource` VALUES ('803', '3', '125', '10', '1', '-1', '2017-12-08 11:35:19', null, null, '0');
INSERT INTO `role_resource` VALUES ('804', '3', '126', '10', '1', '-1', '2017-12-08 11:35:19', null, null, '0');
INSERT INTO `role_resource` VALUES ('805', '3', '127', '10', '1', '-1', '2017-12-08 11:35:19', null, null, '0');
INSERT INTO `role_resource` VALUES ('806', '3', '110', '10', '1', '-1', '2017-12-08 17:05:25', null, null, '0');
INSERT INTO `role_resource` VALUES ('807', '3', '111', '10', '1', '-1', '2017-12-08 17:05:25', null, null, '0');
INSERT INTO `role_resource` VALUES ('808', '3', '119', '10', '1', '-1', '2017-12-08 17:05:25', null, null, '0');
INSERT INTO `role_resource` VALUES ('809', '3', '120', '10', '1', '-1', '2017-12-08 17:05:25', null, null, '0');
INSERT INTO `role_resource` VALUES ('810', '3', '121', '10', '1', '-1', '2017-12-08 17:05:25', null, null, '0');
INSERT INTO `role_resource` VALUES ('811', '3', '112', '10', '1', '-1', '2017-12-08 17:05:25', null, null, '0');
INSERT INTO `role_resource` VALUES ('812', '3', '122', '10', '1', '-1', '2017-12-08 17:05:25', null, null, '0');
INSERT INTO `role_resource` VALUES ('813', '3', '115', '10', '1', '-1', '2017-12-08 17:05:25', null, null, '0');
INSERT INTO `role_resource` VALUES ('814', '3', '128', '10', '1', '-1', '2017-12-08 17:05:25', null, null, '0');
INSERT INTO `role_resource` VALUES ('815', '3', '113', '10', '1', '-1', '2017-12-08 17:05:25', null, null, '0');
INSERT INTO `role_resource` VALUES ('816', '3', '129', '10', '1', '-1', '2017-12-08 17:05:25', null, null, '0');
INSERT INTO `role_resource` VALUES ('817', '3', '114', '10', '1', '-1', '2017-12-08 17:05:25', null, null, '0');
INSERT INTO `role_resource` VALUES ('818', '3', '130', '10', '1', '-1', '2017-12-08 17:05:25', null, null, '0');
INSERT INTO `role_resource` VALUES ('819', '3', '117', '10', '1', '-1', '2017-12-08 17:05:25', null, null, '0');
INSERT INTO `role_resource` VALUES ('820', '3', '21', '10', '1', '-1', '2017-12-08 17:05:25', null, null, '0');
INSERT INTO `role_resource` VALUES ('821', '3', '8', '10', '1', '-1', '2017-12-08 17:05:25', null, null, '0');
INSERT INTO `role_resource` VALUES ('822', '3', '9', '10', '1', '-1', '2017-12-08 17:05:25', null, null, '0');
INSERT INTO `role_resource` VALUES ('823', '3', '13', '10', '1', '-1', '2017-12-08 17:05:25', null, null, '0');
INSERT INTO `role_resource` VALUES ('824', '3', '123', '10', '1', '-1', '2017-12-08 17:05:25', null, null, '0');
INSERT INTO `role_resource` VALUES ('825', '3', '124', '10', '1', '-1', '2017-12-08 17:05:25', null, null, '0');
INSERT INTO `role_resource` VALUES ('826', '3', '125', '10', '1', '-1', '2017-12-08 17:05:25', null, null, '0');
INSERT INTO `role_resource` VALUES ('827', '3', '126', '10', '1', '-1', '2017-12-08 17:05:25', null, null, '0');
INSERT INTO `role_resource` VALUES ('828', '3', '127', '10', '1', '-1', '2017-12-08 17:05:25', null, null, '0');
INSERT INTO `role_resource` VALUES ('829', '3', '110', '10', '1', '-1', '2017-12-08 19:05:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('830', '3', '111', '10', '1', '-1', '2017-12-08 19:05:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('831', '3', '119', '10', '1', '-1', '2017-12-08 19:05:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('832', '3', '120', '10', '1', '-1', '2017-12-08 19:05:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('833', '3', '121', '10', '1', '-1', '2017-12-08 19:05:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('834', '3', '112', '10', '1', '-1', '2017-12-08 19:05:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('835', '3', '122', '10', '1', '-1', '2017-12-08 19:05:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('836', '3', '115', '10', '1', '-1', '2017-12-08 19:05:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('837', '3', '128', '10', '1', '-1', '2017-12-08 19:05:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('838', '3', '113', '10', '1', '-1', '2017-12-08 19:05:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('839', '3', '129', '10', '1', '-1', '2017-12-08 19:05:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('840', '3', '114', '10', '1', '-1', '2017-12-08 19:05:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('841', '3', '130', '10', '1', '-1', '2017-12-08 19:05:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('842', '3', '117', '10', '1', '-1', '2017-12-08 19:05:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('843', '3', '21', '10', '1', '-1', '2017-12-08 19:05:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('844', '3', '8', '10', '1', '-1', '2017-12-08 19:05:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('845', '3', '9', '10', '1', '-1', '2017-12-08 19:05:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('846', '3', '13', '10', '1', '-1', '2017-12-08 19:05:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('847', '3', '123', '10', '1', '-1', '2017-12-08 19:05:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('848', '3', '124', '10', '1', '-1', '2017-12-08 19:05:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('849', '3', '125', '10', '1', '-1', '2017-12-08 19:05:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('850', '3', '126', '10', '1', '-1', '2017-12-08 19:05:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('851', '3', '127', '10', '1', '-1', '2017-12-08 19:05:58', null, null, '0');
INSERT INTO `role_resource` VALUES ('852', '3', '110', '10', '1', '-1', '2017-12-08 19:47:20', null, null, '0');
INSERT INTO `role_resource` VALUES ('853', '3', '111', '10', '1', '-1', '2017-12-08 19:47:20', null, null, '0');
INSERT INTO `role_resource` VALUES ('854', '3', '119', '10', '1', '-1', '2017-12-08 19:47:20', null, null, '0');
INSERT INTO `role_resource` VALUES ('855', '3', '120', '10', '1', '-1', '2017-12-08 19:47:20', null, null, '0');
INSERT INTO `role_resource` VALUES ('856', '3', '121', '10', '1', '-1', '2017-12-08 19:47:20', null, null, '0');
INSERT INTO `role_resource` VALUES ('857', '3', '112', '10', '1', '-1', '2017-12-08 19:47:20', null, null, '0');
INSERT INTO `role_resource` VALUES ('858', '3', '122', '10', '1', '-1', '2017-12-08 19:47:20', null, null, '0');
INSERT INTO `role_resource` VALUES ('859', '3', '115', '10', '1', '-1', '2017-12-08 19:47:20', null, null, '0');
INSERT INTO `role_resource` VALUES ('860', '3', '128', '10', '1', '-1', '2017-12-08 19:47:20', null, null, '0');
INSERT INTO `role_resource` VALUES ('861', '3', '113', '10', '1', '-1', '2017-12-08 19:47:20', null, null, '0');
INSERT INTO `role_resource` VALUES ('862', '3', '129', '10', '1', '-1', '2017-12-08 19:47:20', null, null, '0');
INSERT INTO `role_resource` VALUES ('863', '3', '114', '10', '1', '-1', '2017-12-08 19:47:20', null, null, '0');
INSERT INTO `role_resource` VALUES ('864', '3', '130', '10', '1', '-1', '2017-12-08 19:47:20', null, null, '0');
INSERT INTO `role_resource` VALUES ('865', '3', '117', '10', '1', '-1', '2017-12-08 19:47:20', null, null, '0');
INSERT INTO `role_resource` VALUES ('866', '3', '21', '10', '1', '-1', '2017-12-08 19:47:20', null, null, '0');
INSERT INTO `role_resource` VALUES ('867', '3', '8', '10', '1', '-1', '2017-12-08 19:47:20', null, null, '0');
INSERT INTO `role_resource` VALUES ('868', '3', '9', '10', '1', '-1', '2017-12-08 19:47:20', null, null, '0');
INSERT INTO `role_resource` VALUES ('869', '3', '13', '10', '1', '-1', '2017-12-08 19:47:20', null, null, '0');
INSERT INTO `role_resource` VALUES ('870', '3', '123', '10', '1', '-1', '2017-12-08 19:47:20', null, null, '0');
INSERT INTO `role_resource` VALUES ('871', '3', '124', '10', '1', '-1', '2017-12-08 19:47:20', null, null, '0');
INSERT INTO `role_resource` VALUES ('872', '3', '125', '10', '1', '-1', '2017-12-08 19:47:20', null, null, '0');
INSERT INTO `role_resource` VALUES ('873', '3', '126', '10', '1', '-1', '2017-12-08 19:47:20', null, null, '0');
INSERT INTO `role_resource` VALUES ('874', '3', '127', '10', '1', '-1', '2017-12-08 19:47:20', null, null, '0');
INSERT INTO `role_resource` VALUES ('875', '3', '110', '10', '1', '-1', '2017-12-08 19:51:46', null, null, '0');
INSERT INTO `role_resource` VALUES ('876', '3', '111', '10', '1', '-1', '2017-12-08 19:51:46', null, null, '0');
INSERT INTO `role_resource` VALUES ('877', '3', '119', '10', '1', '-1', '2017-12-08 19:51:46', null, null, '0');
INSERT INTO `role_resource` VALUES ('878', '3', '120', '10', '1', '-1', '2017-12-08 19:51:46', null, null, '0');
INSERT INTO `role_resource` VALUES ('879', '3', '121', '10', '1', '-1', '2017-12-08 19:51:46', null, null, '0');
INSERT INTO `role_resource` VALUES ('880', '3', '112', '10', '1', '-1', '2017-12-08 19:51:46', null, null, '0');
INSERT INTO `role_resource` VALUES ('881', '3', '122', '10', '1', '-1', '2017-12-08 19:51:46', null, null, '0');
INSERT INTO `role_resource` VALUES ('882', '3', '115', '10', '1', '-1', '2017-12-08 19:51:46', null, null, '0');
INSERT INTO `role_resource` VALUES ('883', '3', '128', '10', '1', '-1', '2017-12-08 19:51:46', null, null, '0');
INSERT INTO `role_resource` VALUES ('884', '3', '113', '10', '1', '-1', '2017-12-08 19:51:46', null, null, '0');
INSERT INTO `role_resource` VALUES ('885', '3', '129', '10', '1', '-1', '2017-12-08 19:51:46', null, null, '0');
INSERT INTO `role_resource` VALUES ('886', '3', '114', '10', '1', '-1', '2017-12-08 19:51:46', null, null, '0');
INSERT INTO `role_resource` VALUES ('887', '3', '130', '10', '1', '-1', '2017-12-08 19:51:46', null, null, '0');
INSERT INTO `role_resource` VALUES ('888', '3', '117', '10', '1', '-1', '2017-12-08 19:51:46', null, null, '0');
INSERT INTO `role_resource` VALUES ('889', '3', '21', '10', '1', '-1', '2017-12-08 19:51:46', null, null, '0');
INSERT INTO `role_resource` VALUES ('890', '3', '8', '10', '1', '-1', '2017-12-08 19:51:46', null, null, '0');
INSERT INTO `role_resource` VALUES ('891', '3', '9', '10', '1', '-1', '2017-12-08 19:51:46', null, null, '0');
INSERT INTO `role_resource` VALUES ('892', '3', '13', '10', '1', '-1', '2017-12-08 19:51:46', null, null, '0');
INSERT INTO `role_resource` VALUES ('893', '3', '123', '10', '1', '-1', '2017-12-08 19:51:46', null, null, '0');
INSERT INTO `role_resource` VALUES ('894', '3', '124', '10', '1', '-1', '2017-12-08 19:51:46', null, null, '0');
INSERT INTO `role_resource` VALUES ('895', '3', '125', '10', '1', '-1', '2017-12-08 19:51:46', null, null, '0');
INSERT INTO `role_resource` VALUES ('896', '3', '126', '10', '1', '-1', '2017-12-08 19:51:46', null, null, '0');
INSERT INTO `role_resource` VALUES ('897', '3', '127', '10', '1', '-1', '2017-12-08 19:51:46', null, null, '0');
INSERT INTO `role_resource` VALUES ('898', '3', '110', '10', '1', '-1', '2017-12-08 19:57:29', null, null, '0');
INSERT INTO `role_resource` VALUES ('899', '3', '111', '10', '1', '-1', '2017-12-08 19:57:29', null, null, '0');
INSERT INTO `role_resource` VALUES ('900', '3', '119', '10', '1', '-1', '2017-12-08 19:57:29', null, null, '0');
INSERT INTO `role_resource` VALUES ('901', '3', '120', '10', '1', '-1', '2017-12-08 19:57:29', null, null, '0');
INSERT INTO `role_resource` VALUES ('902', '3', '121', '10', '1', '-1', '2017-12-08 19:57:29', null, null, '0');
INSERT INTO `role_resource` VALUES ('903', '3', '112', '10', '1', '-1', '2017-12-08 19:57:29', null, null, '0');
INSERT INTO `role_resource` VALUES ('904', '3', '122', '10', '1', '-1', '2017-12-08 19:57:29', null, null, '0');
INSERT INTO `role_resource` VALUES ('905', '3', '115', '10', '1', '-1', '2017-12-08 19:57:29', null, null, '0');
INSERT INTO `role_resource` VALUES ('906', '3', '128', '10', '1', '-1', '2017-12-08 19:57:29', null, null, '0');
INSERT INTO `role_resource` VALUES ('907', '3', '113', '10', '1', '-1', '2017-12-08 19:57:29', null, null, '0');
INSERT INTO `role_resource` VALUES ('908', '3', '129', '10', '1', '-1', '2017-12-08 19:57:29', null, null, '0');
INSERT INTO `role_resource` VALUES ('909', '3', '114', '10', '1', '-1', '2017-12-08 19:57:29', null, null, '0');
INSERT INTO `role_resource` VALUES ('910', '3', '130', '10', '1', '-1', '2017-12-08 19:57:29', null, null, '0');
INSERT INTO `role_resource` VALUES ('911', '3', '117', '10', '1', '-1', '2017-12-08 19:57:29', null, null, '0');
INSERT INTO `role_resource` VALUES ('912', '3', '21', '10', '1', '-1', '2017-12-08 19:57:29', null, null, '0');
INSERT INTO `role_resource` VALUES ('913', '3', '8', '10', '1', '-1', '2017-12-08 19:57:29', null, null, '0');
INSERT INTO `role_resource` VALUES ('914', '3', '9', '10', '1', '-1', '2017-12-08 19:57:29', null, null, '0');
INSERT INTO `role_resource` VALUES ('915', '3', '13', '10', '1', '-1', '2017-12-08 19:57:29', null, null, '0');
INSERT INTO `role_resource` VALUES ('916', '3', '123', '10', '1', '-1', '2017-12-08 19:57:29', null, null, '0');
INSERT INTO `role_resource` VALUES ('917', '3', '124', '10', '1', '-1', '2017-12-08 19:57:29', null, null, '0');
INSERT INTO `role_resource` VALUES ('918', '3', '125', '10', '1', '-1', '2017-12-08 19:57:29', null, null, '0');
INSERT INTO `role_resource` VALUES ('919', '3', '126', '10', '1', '-1', '2017-12-08 19:57:29', null, null, '0');
INSERT INTO `role_resource` VALUES ('920', '3', '127', '10', '1', '-1', '2017-12-08 19:57:29', null, null, '0');
INSERT INTO `role_resource` VALUES ('921', '3', '110', '10', '1', '-1', '2017-12-08 19:59:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('922', '3', '111', '10', '1', '-1', '2017-12-08 19:59:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('923', '3', '119', '10', '1', '-1', '2017-12-08 19:59:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('924', '3', '120', '10', '1', '-1', '2017-12-08 19:59:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('925', '3', '121', '10', '1', '-1', '2017-12-08 19:59:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('926', '3', '112', '10', '1', '-1', '2017-12-08 19:59:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('927', '3', '122', '10', '1', '-1', '2017-12-08 19:59:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('928', '3', '115', '10', '1', '-1', '2017-12-08 19:59:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('929', '3', '128', '10', '1', '-1', '2017-12-08 19:59:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('930', '3', '113', '10', '1', '-1', '2017-12-08 19:59:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('931', '3', '129', '10', '1', '-1', '2017-12-08 19:59:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('932', '3', '114', '10', '1', '-1', '2017-12-08 19:59:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('933', '3', '130', '10', '1', '-1', '2017-12-08 19:59:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('934', '3', '117', '10', '1', '-1', '2017-12-08 19:59:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('935', '3', '21', '10', '1', '-1', '2017-12-08 19:59:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('936', '3', '8', '10', '1', '-1', '2017-12-08 19:59:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('937', '3', '9', '10', '1', '-1', '2017-12-08 19:59:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('938', '3', '13', '10', '1', '-1', '2017-12-08 19:59:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('939', '3', '123', '10', '1', '-1', '2017-12-08 19:59:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('940', '3', '124', '10', '1', '-1', '2017-12-08 19:59:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('941', '3', '125', '10', '1', '-1', '2017-12-08 19:59:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('942', '3', '126', '10', '1', '-1', '2017-12-08 19:59:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('943', '3', '127', '10', '1', '-1', '2017-12-08 19:59:24', null, null, '0');
INSERT INTO `role_resource` VALUES ('944', '3', '110', '10', '1', '-1', '2017-12-08 20:13:10', null, null, '0');
INSERT INTO `role_resource` VALUES ('945', '3', '111', '10', '1', '-1', '2017-12-08 20:13:10', null, null, '0');
INSERT INTO `role_resource` VALUES ('946', '3', '119', '10', '1', '-1', '2017-12-08 20:13:10', null, null, '0');
INSERT INTO `role_resource` VALUES ('947', '3', '120', '10', '1', '-1', '2017-12-08 20:13:10', null, null, '0');
INSERT INTO `role_resource` VALUES ('948', '3', '121', '10', '1', '-1', '2017-12-08 20:13:10', null, null, '0');
INSERT INTO `role_resource` VALUES ('949', '3', '112', '10', '1', '-1', '2017-12-08 20:13:10', null, null, '0');
INSERT INTO `role_resource` VALUES ('950', '3', '122', '10', '1', '-1', '2017-12-08 20:13:10', null, null, '0');
INSERT INTO `role_resource` VALUES ('951', '3', '115', '10', '1', '-1', '2017-12-08 20:13:10', null, null, '0');
INSERT INTO `role_resource` VALUES ('952', '3', '128', '10', '1', '-1', '2017-12-08 20:13:10', null, null, '0');
INSERT INTO `role_resource` VALUES ('953', '3', '113', '10', '1', '-1', '2017-12-08 20:13:10', null, null, '0');
INSERT INTO `role_resource` VALUES ('954', '3', '129', '10', '1', '-1', '2017-12-08 20:13:10', null, null, '0');
INSERT INTO `role_resource` VALUES ('955', '3', '114', '10', '1', '-1', '2017-12-08 20:13:10', null, null, '0');
INSERT INTO `role_resource` VALUES ('956', '3', '130', '10', '1', '-1', '2017-12-08 20:13:10', null, null, '0');
INSERT INTO `role_resource` VALUES ('957', '3', '117', '10', '1', '-1', '2017-12-08 20:13:10', null, null, '0');
INSERT INTO `role_resource` VALUES ('958', '3', '21', '10', '1', '-1', '2017-12-08 20:13:10', null, null, '0');
INSERT INTO `role_resource` VALUES ('959', '3', '8', '10', '1', '-1', '2017-12-08 20:13:10', null, null, '0');
INSERT INTO `role_resource` VALUES ('960', '3', '9', '10', '1', '-1', '2017-12-08 20:13:10', null, null, '0');
INSERT INTO `role_resource` VALUES ('961', '3', '13', '10', '1', '-1', '2017-12-08 20:13:10', null, null, '0');
INSERT INTO `role_resource` VALUES ('962', '3', '123', '10', '1', '-1', '2017-12-08 20:13:10', null, null, '0');
INSERT INTO `role_resource` VALUES ('963', '3', '124', '10', '1', '-1', '2017-12-08 20:13:10', null, null, '0');
INSERT INTO `role_resource` VALUES ('964', '3', '125', '10', '1', '-1', '2017-12-08 20:13:10', null, null, '0');
INSERT INTO `role_resource` VALUES ('965', '3', '126', '10', '1', '-1', '2017-12-08 20:13:10', null, null, '0');
INSERT INTO `role_resource` VALUES ('966', '3', '127', '10', '1', '-1', '2017-12-08 20:13:10', null, null, '0');
INSERT INTO `role_resource` VALUES ('967', '3', '110', '10', '1', '-1', '2017-12-09 14:47:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('968', '3', '111', '10', '1', '-1', '2017-12-09 14:47:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('969', '3', '119', '10', '1', '-1', '2017-12-09 14:47:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('970', '3', '120', '10', '1', '-1', '2017-12-09 14:47:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('971', '3', '121', '10', '1', '-1', '2017-12-09 14:47:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('972', '3', '112', '10', '1', '-1', '2017-12-09 14:47:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('973', '3', '122', '10', '1', '-1', '2017-12-09 14:47:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('974', '3', '115', '10', '1', '-1', '2017-12-09 14:47:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('975', '3', '128', '10', '1', '-1', '2017-12-09 14:47:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('976', '3', '113', '10', '1', '-1', '2017-12-09 14:47:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('977', '3', '129', '10', '1', '-1', '2017-12-09 14:47:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('978', '3', '114', '10', '1', '-1', '2017-12-09 14:47:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('979', '3', '130', '10', '1', '-1', '2017-12-09 14:47:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('980', '3', '117', '10', '1', '-1', '2017-12-09 14:47:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('981', '3', '21', '10', '1', '-1', '2017-12-09 14:47:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('982', '3', '8', '10', '1', '-1', '2017-12-09 14:47:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('983', '3', '9', '10', '1', '-1', '2017-12-09 14:47:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('984', '3', '13', '10', '1', '-1', '2017-12-09 14:47:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('985', '3', '123', '10', '1', '-1', '2017-12-09 14:47:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('986', '3', '124', '10', '1', '-1', '2017-12-09 14:47:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('987', '3', '125', '10', '1', '-1', '2017-12-09 14:47:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('988', '3', '126', '10', '1', '-1', '2017-12-09 14:47:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('989', '3', '127', '10', '1', '-1', '2017-12-09 14:47:03', null, null, '0');
INSERT INTO `role_resource` VALUES ('991', '3', '110', '10', '1', '-1', '2017-12-09 16:53:43', null, null, '0');
INSERT INTO `role_resource` VALUES ('992', '3', '111', '10', '1', '-1', '2017-12-09 16:53:43', null, null, '0');
INSERT INTO `role_resource` VALUES ('993', '3', '119', '10', '1', '-1', '2017-12-09 16:53:43', null, null, '0');
INSERT INTO `role_resource` VALUES ('994', '3', '120', '10', '1', '-1', '2017-12-09 16:53:43', null, null, '0');
INSERT INTO `role_resource` VALUES ('995', '3', '121', '10', '1', '-1', '2017-12-09 16:53:43', null, null, '0');
INSERT INTO `role_resource` VALUES ('996', '3', '112', '10', '1', '-1', '2017-12-09 16:53:43', null, null, '0');
INSERT INTO `role_resource` VALUES ('997', '3', '122', '10', '1', '-1', '2017-12-09 16:53:43', null, null, '0');
INSERT INTO `role_resource` VALUES ('998', '3', '115', '10', '1', '-1', '2017-12-09 16:53:43', null, null, '0');
INSERT INTO `role_resource` VALUES ('999', '3', '128', '10', '1', '-1', '2017-12-09 16:53:43', null, null, '0');
INSERT INTO `role_resource` VALUES ('1000', '3', '113', '10', '1', '-1', '2017-12-09 16:53:43', null, null, '0');
INSERT INTO `role_resource` VALUES ('1001', '3', '129', '10', '1', '-1', '2017-12-09 16:53:43', null, null, '0');
INSERT INTO `role_resource` VALUES ('1002', '3', '114', '10', '1', '-1', '2017-12-09 16:53:43', null, null, '0');
INSERT INTO `role_resource` VALUES ('1003', '3', '130', '10', '1', '-1', '2017-12-09 16:53:43', null, null, '0');
INSERT INTO `role_resource` VALUES ('1004', '3', '117', '10', '1', '-1', '2017-12-09 16:53:43', null, null, '0');
INSERT INTO `role_resource` VALUES ('1005', '3', '21', '10', '1', '-1', '2017-12-09 16:53:43', null, null, '0');
INSERT INTO `role_resource` VALUES ('1006', '3', '8', '10', '1', '-1', '2017-12-09 16:53:43', null, null, '0');
INSERT INTO `role_resource` VALUES ('1007', '3', '9', '10', '1', '-1', '2017-12-09 16:53:43', null, null, '0');
INSERT INTO `role_resource` VALUES ('1008', '3', '13', '10', '1', '-1', '2017-12-09 16:53:43', null, null, '0');
INSERT INTO `role_resource` VALUES ('1009', '3', '123', '10', '1', '-1', '2017-12-09 16:53:43', null, null, '0');
INSERT INTO `role_resource` VALUES ('1010', '3', '124', '10', '1', '-1', '2017-12-09 16:53:43', null, null, '0');
INSERT INTO `role_resource` VALUES ('1011', '3', '125', '10', '1', '-1', '2017-12-09 16:53:43', null, null, '0');
INSERT INTO `role_resource` VALUES ('1012', '3', '126', '10', '1', '-1', '2017-12-09 16:53:43', null, null, '0');
INSERT INTO `role_resource` VALUES ('1013', '3', '127', '10', '1', '-1', '2017-12-09 16:53:43', null, null, '0');
INSERT INTO `role_resource` VALUES ('1015', '3', '110', '10', '1', '-1', '2017-12-09 18:28:45', null, null, '0');
INSERT INTO `role_resource` VALUES ('1016', '3', '111', '10', '1', '-1', '2017-12-09 18:28:45', null, null, '0');
INSERT INTO `role_resource` VALUES ('1017', '3', '119', '10', '1', '-1', '2017-12-09 18:28:45', null, null, '0');
INSERT INTO `role_resource` VALUES ('1018', '3', '120', '10', '1', '-1', '2017-12-09 18:28:45', null, null, '0');
INSERT INTO `role_resource` VALUES ('1019', '3', '121', '10', '1', '-1', '2017-12-09 18:28:45', null, null, '0');
INSERT INTO `role_resource` VALUES ('1020', '3', '112', '10', '1', '-1', '2017-12-09 18:28:45', null, null, '0');
INSERT INTO `role_resource` VALUES ('1021', '3', '122', '10', '1', '-1', '2017-12-09 18:28:45', null, null, '0');
INSERT INTO `role_resource` VALUES ('1022', '3', '115', '10', '1', '-1', '2017-12-09 18:28:45', null, null, '0');
INSERT INTO `role_resource` VALUES ('1023', '3', '128', '10', '1', '-1', '2017-12-09 18:28:45', null, null, '0');
INSERT INTO `role_resource` VALUES ('1024', '3', '113', '10', '1', '-1', '2017-12-09 18:28:45', null, null, '0');
INSERT INTO `role_resource` VALUES ('1025', '3', '129', '10', '1', '-1', '2017-12-09 18:28:45', null, null, '0');
INSERT INTO `role_resource` VALUES ('1026', '3', '114', '10', '1', '-1', '2017-12-09 18:28:45', null, null, '0');
INSERT INTO `role_resource` VALUES ('1027', '3', '130', '10', '1', '-1', '2017-12-09 18:28:45', null, null, '0');
INSERT INTO `role_resource` VALUES ('1028', '3', '117', '10', '1', '-1', '2017-12-09 18:28:45', null, null, '0');
INSERT INTO `role_resource` VALUES ('1029', '3', '21', '10', '1', '-1', '2017-12-09 18:28:45', null, null, '0');
INSERT INTO `role_resource` VALUES ('1030', '3', '8', '10', '1', '-1', '2017-12-09 18:28:45', null, null, '0');
INSERT INTO `role_resource` VALUES ('1031', '3', '9', '10', '1', '-1', '2017-12-09 18:28:45', null, null, '0');
INSERT INTO `role_resource` VALUES ('1032', '3', '13', '10', '1', '-1', '2017-12-09 18:28:45', null, null, '0');
INSERT INTO `role_resource` VALUES ('1033', '3', '123', '10', '1', '-1', '2017-12-09 18:28:45', null, null, '0');
INSERT INTO `role_resource` VALUES ('1034', '3', '124', '10', '1', '-1', '2017-12-09 18:28:45', null, null, '0');
INSERT INTO `role_resource` VALUES ('1035', '3', '125', '10', '1', '-1', '2017-12-09 18:28:45', null, null, '0');
INSERT INTO `role_resource` VALUES ('1036', '3', '126', '10', '1', '-1', '2017-12-09 18:28:45', null, null, '0');
INSERT INTO `role_resource` VALUES ('1037', '3', '127', '10', '1', '-1', '2017-12-09 18:28:45', null, null, '0');
INSERT INTO `role_resource` VALUES ('1039', '3', '110', '10', '1', '-1', '2017-12-09 21:49:31', null, null, '0');
INSERT INTO `role_resource` VALUES ('1040', '3', '111', '10', '1', '-1', '2017-12-09 21:49:31', null, null, '0');
INSERT INTO `role_resource` VALUES ('1041', '3', '119', '10', '1', '-1', '2017-12-09 21:49:31', null, null, '0');
INSERT INTO `role_resource` VALUES ('1042', '3', '120', '10', '1', '-1', '2017-12-09 21:49:31', null, null, '0');
INSERT INTO `role_resource` VALUES ('1043', '3', '121', '10', '1', '-1', '2017-12-09 21:49:31', null, null, '0');
INSERT INTO `role_resource` VALUES ('1044', '3', '112', '10', '1', '-1', '2017-12-09 21:49:31', null, null, '0');
INSERT INTO `role_resource` VALUES ('1045', '3', '122', '10', '1', '-1', '2017-12-09 21:49:31', null, null, '0');
INSERT INTO `role_resource` VALUES ('1046', '3', '115', '10', '1', '-1', '2017-12-09 21:49:31', null, null, '0');
INSERT INTO `role_resource` VALUES ('1047', '3', '128', '10', '1', '-1', '2017-12-09 21:49:31', null, null, '0');
INSERT INTO `role_resource` VALUES ('1048', '3', '113', '10', '1', '-1', '2017-12-09 21:49:31', null, null, '0');
INSERT INTO `role_resource` VALUES ('1049', '3', '129', '10', '1', '-1', '2017-12-09 21:49:31', null, null, '0');
INSERT INTO `role_resource` VALUES ('1050', '3', '114', '10', '1', '-1', '2017-12-09 21:49:31', null, null, '0');
INSERT INTO `role_resource` VALUES ('1051', '3', '130', '10', '1', '-1', '2017-12-09 21:49:31', null, null, '0');
INSERT INTO `role_resource` VALUES ('1052', '3', '117', '10', '1', '-1', '2017-12-09 21:49:31', null, null, '0');
INSERT INTO `role_resource` VALUES ('1053', '3', '21', '10', '1', '-1', '2017-12-09 21:49:31', null, null, '0');
INSERT INTO `role_resource` VALUES ('1054', '3', '8', '10', '1', '-1', '2017-12-09 21:49:31', null, null, '0');
INSERT INTO `role_resource` VALUES ('1055', '3', '9', '10', '1', '-1', '2017-12-09 21:49:31', null, null, '0');
INSERT INTO `role_resource` VALUES ('1056', '3', '13', '10', '1', '-1', '2017-12-09 21:49:31', null, null, '0');
INSERT INTO `role_resource` VALUES ('1057', '3', '123', '10', '1', '-1', '2017-12-09 21:49:31', null, null, '0');
INSERT INTO `role_resource` VALUES ('1058', '3', '124', '10', '1', '-1', '2017-12-09 21:49:31', null, null, '0');
INSERT INTO `role_resource` VALUES ('1059', '3', '125', '10', '1', '-1', '2017-12-09 21:49:31', null, null, '0');
INSERT INTO `role_resource` VALUES ('1060', '3', '126', '10', '1', '-1', '2017-12-09 21:49:31', null, null, '0');
INSERT INTO `role_resource` VALUES ('1061', '3', '127', '10', '1', '-1', '2017-12-09 21:49:31', null, null, '0');
INSERT INTO `role_resource` VALUES ('1063', '3', '110', '10', '1', '-1', '2017-12-11 17:07:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('1064', '3', '111', '10', '1', '-1', '2017-12-11 17:07:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('1065', '3', '119', '10', '1', '-1', '2017-12-11 17:07:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('1066', '3', '120', '10', '1', '-1', '2017-12-11 17:07:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('1067', '3', '121', '10', '1', '-1', '2017-12-11 17:07:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('1068', '3', '112', '10', '1', '-1', '2017-12-11 17:07:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('1069', '3', '122', '10', '1', '-1', '2017-12-11 17:07:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('1070', '3', '115', '10', '1', '-1', '2017-12-11 17:07:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('1071', '3', '128', '10', '1', '-1', '2017-12-11 17:07:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('1072', '3', '113', '10', '1', '-1', '2017-12-11 17:07:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('1073', '3', '129', '10', '1', '-1', '2017-12-11 17:07:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('1074', '3', '114', '10', '1', '-1', '2017-12-11 17:07:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('1075', '3', '130', '10', '1', '-1', '2017-12-11 17:07:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('1076', '3', '117', '10', '1', '-1', '2017-12-11 17:07:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('1077', '3', '21', '10', '1', '-1', '2017-12-11 17:07:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('1078', '3', '8', '10', '1', '-1', '2017-12-11 17:07:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('1079', '3', '9', '10', '1', '-1', '2017-12-11 17:07:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('1080', '3', '13', '10', '1', '-1', '2017-12-11 17:07:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('1081', '3', '123', '10', '1', '-1', '2017-12-11 17:07:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('1082', '3', '124', '10', '1', '-1', '2017-12-11 17:07:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('1083', '3', '125', '10', '1', '-1', '2017-12-11 17:07:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('1084', '3', '126', '10', '1', '-1', '2017-12-11 17:07:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('1085', '3', '127', '10', '1', '-1', '2017-12-11 17:07:57', null, null, '0');
INSERT INTO `role_resource` VALUES ('1087', '3', '110', '10', '1', '-1', '2017-12-11 18:59:27', null, null, '0');
INSERT INTO `role_resource` VALUES ('1088', '3', '111', '10', '1', '-1', '2017-12-11 18:59:27', null, null, '0');
INSERT INTO `role_resource` VALUES ('1089', '3', '119', '10', '1', '-1', '2017-12-11 18:59:27', null, null, '0');
INSERT INTO `role_resource` VALUES ('1090', '3', '120', '10', '1', '-1', '2017-12-11 18:59:27', null, null, '0');
INSERT INTO `role_resource` VALUES ('1091', '3', '121', '10', '1', '-1', '2017-12-11 18:59:27', null, null, '0');
INSERT INTO `role_resource` VALUES ('1092', '3', '112', '10', '1', '-1', '2017-12-11 18:59:27', null, null, '0');
INSERT INTO `role_resource` VALUES ('1093', '3', '122', '10', '1', '-1', '2017-12-11 18:59:27', null, null, '0');
INSERT INTO `role_resource` VALUES ('1094', '3', '115', '10', '1', '-1', '2017-12-11 18:59:27', null, null, '0');
INSERT INTO `role_resource` VALUES ('1095', '3', '128', '10', '1', '-1', '2017-12-11 18:59:27', null, null, '0');
INSERT INTO `role_resource` VALUES ('1096', '3', '113', '10', '1', '-1', '2017-12-11 18:59:27', null, null, '0');
INSERT INTO `role_resource` VALUES ('1097', '3', '129', '10', '1', '-1', '2017-12-11 18:59:27', null, null, '0');
INSERT INTO `role_resource` VALUES ('1098', '3', '114', '10', '1', '-1', '2017-12-11 18:59:27', null, null, '0');
INSERT INTO `role_resource` VALUES ('1099', '3', '130', '10', '1', '-1', '2017-12-11 18:59:27', null, null, '0');
INSERT INTO `role_resource` VALUES ('1100', '3', '117', '10', '1', '-1', '2017-12-11 18:59:27', null, null, '0');
INSERT INTO `role_resource` VALUES ('1101', '3', '21', '10', '1', '-1', '2017-12-11 18:59:27', null, null, '0');
INSERT INTO `role_resource` VALUES ('1102', '3', '8', '10', '1', '-1', '2017-12-11 18:59:27', null, null, '0');
INSERT INTO `role_resource` VALUES ('1103', '3', '9', '10', '1', '-1', '2017-12-11 18:59:27', null, null, '0');
INSERT INTO `role_resource` VALUES ('1104', '3', '13', '10', '1', '-1', '2017-12-11 18:59:27', null, null, '0');
INSERT INTO `role_resource` VALUES ('1105', '3', '123', '10', '1', '-1', '2017-12-11 18:59:27', null, null, '0');
INSERT INTO `role_resource` VALUES ('1106', '3', '124', '10', '1', '-1', '2017-12-11 18:59:27', null, null, '0');
INSERT INTO `role_resource` VALUES ('1107', '3', '125', '10', '1', '-1', '2017-12-11 18:59:27', null, null, '0');
INSERT INTO `role_resource` VALUES ('1108', '3', '126', '10', '1', '-1', '2017-12-11 18:59:27', null, null, '0');
INSERT INTO `role_resource` VALUES ('1109', '3', '127', '10', '1', '-1', '2017-12-11 18:59:27', null, null, '0');
INSERT INTO `role_resource` VALUES ('1111', '3', '110', '10', '1', '-1', '2017-12-11 20:31:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('1112', '3', '111', '10', '1', '-1', '2017-12-11 20:31:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('1113', '3', '119', '10', '1', '-1', '2017-12-11 20:31:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('1114', '3', '120', '10', '1', '-1', '2017-12-11 20:31:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('1115', '3', '121', '10', '1', '-1', '2017-12-11 20:31:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('1116', '3', '112', '10', '1', '-1', '2017-12-11 20:31:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('1117', '3', '122', '10', '1', '-1', '2017-12-11 20:31:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('1118', '3', '115', '10', '1', '-1', '2017-12-11 20:31:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('1119', '3', '128', '10', '1', '-1', '2017-12-11 20:31:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('1120', '3', '113', '10', '1', '-1', '2017-12-11 20:31:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('1121', '3', '129', '10', '1', '-1', '2017-12-11 20:31:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('1122', '3', '114', '10', '1', '-1', '2017-12-11 20:31:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('1123', '3', '130', '10', '1', '-1', '2017-12-11 20:31:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('1124', '3', '117', '10', '1', '-1', '2017-12-11 20:31:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('1125', '3', '21', '10', '1', '-1', '2017-12-11 20:31:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('1126', '3', '8', '10', '1', '-1', '2017-12-11 20:31:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('1127', '3', '9', '10', '1', '-1', '2017-12-11 20:31:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('1128', '3', '13', '10', '1', '-1', '2017-12-11 20:31:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('1129', '3', '123', '10', '1', '-1', '2017-12-11 20:31:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('1130', '3', '124', '10', '1', '-1', '2017-12-11 20:31:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('1131', '3', '125', '10', '1', '-1', '2017-12-11 20:31:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('1132', '3', '126', '10', '1', '-1', '2017-12-11 20:31:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('1133', '3', '127', '10', '1', '-1', '2017-12-11 20:31:02', null, null, '0');
INSERT INTO `role_resource` VALUES ('1135', '3', '110', '10', '1', '-1', '2017-12-12 00:39:09', null, null, '0');
INSERT INTO `role_resource` VALUES ('1136', '3', '111', '10', '1', '-1', '2017-12-12 00:39:09', null, null, '0');
INSERT INTO `role_resource` VALUES ('1137', '3', '119', '10', '1', '-1', '2017-12-12 00:39:09', null, null, '0');
INSERT INTO `role_resource` VALUES ('1138', '3', '120', '10', '1', '-1', '2017-12-12 00:39:09', null, null, '0');
INSERT INTO `role_resource` VALUES ('1139', '3', '121', '10', '1', '-1', '2017-12-12 00:39:09', null, null, '0');
INSERT INTO `role_resource` VALUES ('1140', '3', '112', '10', '1', '-1', '2017-12-12 00:39:09', null, null, '0');
INSERT INTO `role_resource` VALUES ('1141', '3', '122', '10', '1', '-1', '2017-12-12 00:39:09', null, null, '0');
INSERT INTO `role_resource` VALUES ('1142', '3', '115', '10', '1', '-1', '2017-12-12 00:39:09', null, null, '0');
INSERT INTO `role_resource` VALUES ('1143', '3', '128', '10', '1', '-1', '2017-12-12 00:39:09', null, null, '0');
INSERT INTO `role_resource` VALUES ('1144', '3', '113', '10', '1', '-1', '2017-12-12 00:39:09', null, null, '0');
INSERT INTO `role_resource` VALUES ('1145', '3', '129', '10', '1', '-1', '2017-12-12 00:39:09', null, null, '0');
INSERT INTO `role_resource` VALUES ('1146', '3', '114', '10', '1', '-1', '2017-12-12 00:39:09', null, null, '0');
INSERT INTO `role_resource` VALUES ('1147', '3', '130', '10', '1', '-1', '2017-12-12 00:39:09', null, null, '0');
INSERT INTO `role_resource` VALUES ('1148', '3', '117', '10', '1', '-1', '2017-12-12 00:39:09', null, null, '0');
INSERT INTO `role_resource` VALUES ('1149', '3', '21', '10', '1', '-1', '2017-12-12 00:39:09', null, null, '0');
INSERT INTO `role_resource` VALUES ('1150', '3', '8', '10', '1', '-1', '2017-12-12 00:39:09', null, null, '0');
INSERT INTO `role_resource` VALUES ('1151', '3', '9', '10', '1', '-1', '2017-12-12 00:39:09', null, null, '0');
INSERT INTO `role_resource` VALUES ('1152', '3', '13', '10', '1', '-1', '2017-12-12 00:39:09', null, null, '0');
INSERT INTO `role_resource` VALUES ('1153', '3', '123', '10', '1', '-1', '2017-12-12 00:39:09', null, null, '0');
INSERT INTO `role_resource` VALUES ('1154', '3', '124', '10', '1', '-1', '2017-12-12 00:39:09', null, null, '0');
INSERT INTO `role_resource` VALUES ('1155', '3', '125', '10', '1', '-1', '2017-12-12 00:39:09', null, null, '0');
INSERT INTO `role_resource` VALUES ('1156', '3', '126', '10', '1', '-1', '2017-12-12 00:39:09', null, null, '0');
INSERT INTO `role_resource` VALUES ('1157', '3', '127', '10', '1', '-1', '2017-12-12 00:39:09', null, null, '0');
INSERT INTO `role_resource` VALUES ('1159', '3', '110', '10', '1', '-1', '2017-12-12 01:14:00', null, null, '0');
INSERT INTO `role_resource` VALUES ('1160', '3', '111', '10', '1', '-1', '2017-12-12 01:14:00', null, null, '0');
INSERT INTO `role_resource` VALUES ('1161', '3', '119', '10', '1', '-1', '2017-12-12 01:14:00', null, null, '0');
INSERT INTO `role_resource` VALUES ('1162', '3', '120', '10', '1', '-1', '2017-12-12 01:14:00', null, null, '0');
INSERT INTO `role_resource` VALUES ('1163', '3', '121', '10', '1', '-1', '2017-12-12 01:14:00', null, null, '0');
INSERT INTO `role_resource` VALUES ('1164', '3', '112', '10', '1', '-1', '2017-12-12 01:14:00', null, null, '0');
INSERT INTO `role_resource` VALUES ('1165', '3', '122', '10', '1', '-1', '2017-12-12 01:14:00', null, null, '0');
INSERT INTO `role_resource` VALUES ('1166', '3', '115', '10', '1', '-1', '2017-12-12 01:14:00', null, null, '0');
INSERT INTO `role_resource` VALUES ('1167', '3', '128', '10', '1', '-1', '2017-12-12 01:14:00', null, null, '0');
INSERT INTO `role_resource` VALUES ('1168', '3', '113', '10', '1', '-1', '2017-12-12 01:14:00', null, null, '0');
INSERT INTO `role_resource` VALUES ('1169', '3', '129', '10', '1', '-1', '2017-12-12 01:14:00', null, null, '0');
INSERT INTO `role_resource` VALUES ('1170', '3', '114', '10', '1', '-1', '2017-12-12 01:14:00', null, null, '0');
INSERT INTO `role_resource` VALUES ('1171', '3', '130', '10', '1', '-1', '2017-12-12 01:14:00', null, null, '0');
INSERT INTO `role_resource` VALUES ('1172', '3', '117', '10', '1', '-1', '2017-12-12 01:14:00', null, null, '0');
INSERT INTO `role_resource` VALUES ('1173', '3', '21', '10', '1', '-1', '2017-12-12 01:14:00', null, null, '0');
INSERT INTO `role_resource` VALUES ('1174', '3', '8', '10', '1', '-1', '2017-12-12 01:14:00', null, null, '0');
INSERT INTO `role_resource` VALUES ('1175', '3', '9', '10', '1', '-1', '2017-12-12 01:14:00', null, null, '0');
INSERT INTO `role_resource` VALUES ('1176', '3', '13', '10', '1', '-1', '2017-12-12 01:14:00', null, null, '0');
INSERT INTO `role_resource` VALUES ('1177', '3', '123', '1', '1', '-1', '2017-12-12 01:14:00', null, null, '0');
INSERT INTO `role_resource` VALUES ('1178', '3', '124', '1', '1', '-1', '2017-12-12 01:14:00', null, null, '0');
INSERT INTO `role_resource` VALUES ('1179', '3', '125', '1', '1', '-1', '2017-12-12 01:14:00', null, null, '0');
INSERT INTO `role_resource` VALUES ('1180', '3', '126', '1', '1', '-1', '2017-12-12 01:14:00', null, null, '0');
INSERT INTO `role_resource` VALUES ('1181', '3', '127', '1', '1', '-1', '2017-12-12 01:14:00', null, null, '0');
INSERT INTO `role_resource` VALUES ('1182', '1', '119', '1', '1', null, '2017-12-15 09:57:39', null, null, '0');
INSERT INTO `role_resource` VALUES ('1183', '1', '120', '1', '1', null, '2017-12-15 09:57:39', null, null, '0');
INSERT INTO `role_resource` VALUES ('1184', '1', '121', '1', '1', null, '2017-12-15 09:57:39', null, null, '0');
INSERT INTO `role_resource` VALUES ('1185', '1', '122', '1', '1', null, '2017-12-15 09:57:39', null, null, '0');
INSERT INTO `role_resource` VALUES ('1186', '1', '128', '1', '1', null, '2017-12-15 09:57:39', null, null, '0');
INSERT INTO `role_resource` VALUES ('1187', '1', '129', '1', '1', null, '2017-12-15 09:57:39', null, null, '0');
INSERT INTO `role_resource` VALUES ('1188', '1', '130', '1', '1', null, '2017-12-15 09:57:39', null, null, '0');
INSERT INTO `role_resource` VALUES ('1189', '3', '118', '12', '1', null, '2017-12-15 09:57:39', null, null, '0');
INSERT INTO `role_resource` VALUES ('1190', '3', '1', '12', '1', null, '2017-12-15 09:57:39', null, null, '0');
INSERT INTO `role_resource` VALUES ('1191', '3', '2', '12', '1', null, '2017-12-15 09:57:39', null, null, '0');
INSERT INTO `role_resource` VALUES ('1192', '3', '6', '12', '1', null, '2017-12-15 09:57:39', null, null, '0');
INSERT INTO `role_resource` VALUES ('1193', '3', '106', '12', '1', null, '2017-12-15 09:57:39', null, null, '0');

-- ----------------------------
-- Table structure for role_resource_init
-- ----------------------------
DROP TABLE IF EXISTS `role_resource_init`;
CREATE TABLE `role_resource_init` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL,
  `resource_id` bigint(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_user_id` bigint(20) DEFAULT NULL,
  `update_user_id` bigint(20) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `is_delete` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='角色资源初始化';

-- ----------------------------
-- Records of role_resource_init
-- ----------------------------
INSERT INTO `role_resource_init` VALUES ('1', '3', '21', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `role_resource_init` VALUES ('2', '3', '36', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `role_resource_init` VALUES ('3', '3', '37', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `role_resource_init` VALUES ('4', '3', '22', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `role_resource_init` VALUES ('5', '3', '23', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `role_resource_init` VALUES ('6', '3', '43', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `role_resource_init` VALUES ('7', '3', '44', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `role_resource_init` VALUES ('8', '3', '26', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `role_resource_init` VALUES ('9', '3', '27', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `role_resource_init` VALUES ('10', '3', '55', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `role_resource_init` VALUES ('11', '3', '28', '2017-11-02 14:55:38', '1', null, null, '0');
INSERT INTO `role_resource_init` VALUES ('12', '3', '56', '2017-11-02 14:55:38', '1', null, null, '0');

-- ----------------------------
-- Table structure for role_system
-- ----------------------------
DROP TABLE IF EXISTS `role_system`;
CREATE TABLE `role_system` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编码',
  `is_enabled` tinyint(2) DEFAULT '1' COMMENT '是否启用，0：否，1：是',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `i_tenant_id` (`tenant_id`),
  KEY `i_role_id` (`role_id`),
  KEY `i_create_user_id` (`create_user_id`),
  KEY `i_update_user_id` (`update_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色系统表';

-- ----------------------------
-- Records of role_system
-- ----------------------------

-- ----------------------------
-- Table structure for select_config
-- ----------------------------
DROP TABLE IF EXISTS `select_config`;
CREATE TABLE `select_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `object_field_id` bigint(20) DEFAULT NULL COMMENT '业务对象字段id',
  `value` int(11) DEFAULT NULL COMMENT '选项值',
  `label` varchar(256) DEFAULT NULL COMMENT '选项文本',
  `sequence` int(11) DEFAULT '1' COMMENT '排序，越小越靠前',
  `is_system` tinyint(2) DEFAULT NULL COMMENT '是否系统预置',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，1：是；0：否',
  PRIMARY KEY (`id`),
  KEY `i_tenant_id` (`tenant_id`),
  KEY `i_create_user_id` (`create_user_id`),
  KEY `i_update_user_id` (`update_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8 COMMENT='业务对象字段选项类配置';

-- ----------------------------
-- Records of select_config
-- ----------------------------
INSERT INTO `select_config` VALUES ('1', null, '2', '0', '信托', '0', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('2', null, '2', '1', '资管', '1', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('3', null, '2', '2', '有限合伙', '2', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('4', null, '2', '3', '契约型基金', '3', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('5', null, '2', '4', '收益权质押', '4', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('6', null, '2', '5', '债权转让', '5', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('7', null, '2', '6', '其他', '6', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('8', null, '3', '0', '一级市场', '0', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('9', null, '3', '1', '一级半市场', '1', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('10', null, '3', '2', '二级市场', '2', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('11', null, '3', '3', '其他', '3', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('12', null, '9', '0', 'A', '0', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('13', null, '9', '1', 'B', '1', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('14', null, '9', '2', 'C', '2', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('15', null, '10', '0', '中', '0', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('16', null, '10', '1', '低', '1', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('17', null, '10', '2', '高', '2', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('18', null, '10', '3', '很高', '3', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('19', null, '20', '0', '相对价值策略', '0', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('20', null, '20', '1', '管理期货', '1', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('21', null, '20', '2', '宏观策略', '2', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('22', null, '20', '3', '股票策略', '3', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('23', null, '20', '4', '事件驱动', '4', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('24', null, '20', '5', '债券策略', '5', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('25', null, '20', '6', '组合基金', '6', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('26', null, '20', '7', '其他策略', '7', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('27', null, '20', '8', '复合策略', '8', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('28', null, '21', '0', '固定收益套利', '0', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('29', null, '21', '1', '可转换套利', '1', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('30', null, '21', '2', '股票市场中性', '2', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('31', null, '21', '3', '事件驱动复合策略', '3', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('32', null, '21', '4', '大宗交易', '4', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('33', null, '21', '5', '定向增发', '5', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('34', null, '21', '6', '并购重组', '6', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('35', null, '21', '7', '管理期货复合策略', '7', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('36', null, '21', '8', '系统化高频', '8', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('37', null, '21', '9', '主观日向', '9', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('38', null, '21', '10', 'ETF套利', '10', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('39', null, '21', '11', '相对价值复合策略', '11', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('40', null, '21', '12', '债券策略', '12', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('41', null, '21', '13', '其他策略', '13', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('42', null, '21', '14', 'FOF', '14', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('43', null, '21', '15', 'MOM', '15', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('44', null, '21', '16', '系统化套利', '16', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('45', null, '21', '17', '系统化趋势', '17', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('46', null, '21', '18', '复合策略', '18', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('47', null, '21', '19', '组合基金', '19', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('48', null, '21', '20', '主观套利', '20', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('49', null, '21', '21', '主观趋势', '21', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('50', null, '21', '22', '股票复合策略', '22', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('51', null, '21', '23', '股票行业策略', '23', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('52', null, '21', '24', '股票量化', '24', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('53', null, '21', '25', '股票多空', '25', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('54', null, '21', '26', '股票多头', '26', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('55', null, '21', '27', '宏观策略', '27', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('56', null, '28', '0', '单体项目', '0', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('57', null, '28', '1', '组合项目', '1', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('58', null, '28', '2', '并购基金', '2', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('59', null, '28', '3', '定向增发', '3', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('60', null, '28', '4', '其他', '4', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('61', null, '29', '0', '有限合伙', '0', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('62', null, '29', '1', '契约型', '1', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('63', null, '29', '2', '其他', '2', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('64', null, '33', '0', '信托计划', '0', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('65', null, '33', '1', '资管计划', '1', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('66', null, '33', '2', '契约式债权基金', '2', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('67', null, '33', '3', '债券／债权基金', '3', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('68', null, '33', '4', '中长期理财产品', '4', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('69', null, '33', '5', '其他', '5', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('70', null, '34', '0', '房地产', '0', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('71', null, '34', '1', '政信类', '1', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('72', null, '34', '2', '资金池', '2', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('73', null, '34', '3', '股权质押', '3', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('74', null, '34', '4', '公共投资', '4', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('75', null, '34', '5', '上市公司流贷', '5', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('76', null, '34', '6', '资产证券化', '6', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('77', null, '34', '7', '其他', '7', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('78', null, '40', '0', '按月付息', '0', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('79', null, '40', '1', '到期付息', '1', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('80', null, '40', '2', '按年付息', '2', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('81', null, '40', '3', '半年付息', '3', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('82', null, '40', '4', '按季付息', '4', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('83', null, '15', '1', '是', '1', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('84', null, '15', '0', '否', '2', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('85', null, '17', '0', '人民币', '1', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('86', null, '17', '1', '美元', '2', '1', '1', '2017-11-02 14:55:38', null, null, '0');
INSERT INTO `select_config` VALUES ('87', null, '23', '0', '量化对冲基金', '0', null, '1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `select_config` VALUES ('88', null, '23', '1', '私募证券基金', '1', null, '1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `select_config` VALUES ('89', null, '23', '2', '定增基金', '2', null, '1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `select_config` VALUES ('90', null, '23', '3', '股票／股票型基金', '3', null, '1', '2017-11-02 14:55:39', null, null, '0');
INSERT INTO `select_config` VALUES ('91', null, '23', '4', '其他', '4', null, '1', '2017-11-02 14:55:39', null, null, '0');

-- ----------------------------
-- Table structure for select_config_reference
-- ----------------------------
DROP TABLE IF EXISTS `select_config_reference`;
CREATE TABLE `select_config_reference` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `reference_table` varchar(32) DEFAULT NULL COMMENT '引用表',
  `reference_table_id` bigint(20) DEFAULT NULL COMMENT '引用表id',
  `select_config_id` bigint(20) DEFAULT NULL COMMENT '业务对象字段选项类配置id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，1：是；0：否',
  PRIMARY KEY (`id`),
  KEY `i_tenant_id` (`tenant_id`),
  KEY `i_create_user_id` (`create_user_id`),
  KEY `i_update_user_id` (`update_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务对象字段选项类配置引用表';

-- ----------------------------
-- Records of select_config_reference
-- ----------------------------

-- ----------------------------
-- Table structure for share_info
-- ----------------------------
DROP TABLE IF EXISTS `share_info`;
CREATE TABLE `share_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` varchar(255) DEFAULT NULL COMMENT '类型：product:产品 product_notice:产品公告 product_attach:产品附件',
  `object_id` bigint(20) DEFAULT NULL COMMENT '对象ID',
  `desc` varchar(255) DEFAULT NULL COMMENT '描述',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `share_url` varchar(256) DEFAULT NULL COMMENT '分享地址',
  `create_user_id` bigint(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_user_id` bigint(20) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `is_delete` tinyint(4) DEFAULT NULL COMMENT '是否删除 0：未删除 1：已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分享信息';

-- ----------------------------
-- Records of share_info
-- ----------------------------

-- ----------------------------
-- Table structure for sms_account
-- ----------------------------
DROP TABLE IF EXISTS `sms_account`;
CREATE TABLE `sms_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL,
  `access_key_id` varchar(128) NOT NULL,
  `access_key_secret` varchar(128) NOT NULL,
  `sign` varchar(16) NOT NULL COMMENT '短信签名',
  `is_enable` tinyint(2) DEFAULT '1' COMMENT '是否可用，1：是，0：否',
  `create_date` datetime DEFAULT NULL,
  `create_user_id` bigint(20) DEFAULT NULL,
  `update_user_id` bigint(20) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，1：是；0：否',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sms_account_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='短信账号';

-- ----------------------------
-- Records of sms_account
-- ----------------------------

-- ----------------------------
-- Table structure for sms_assistant_content
-- ----------------------------
DROP TABLE IF EXISTS `sms_assistant_content`;
CREATE TABLE `sms_assistant_content` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `call_title` varchar(100) DEFAULT NULL COMMENT '称呼',
  `send_title` varchar(100) DEFAULT NULL COMMENT '签名',
  `content` varchar(200) DEFAULT NULL COMMENT '内容',
  `send_status` tinyint(4) DEFAULT NULL COMMENT '发送状态 ： 0:未发送 1：发送成功 2：发送失败',
  `user_id` bigint(20) DEFAULT NULL,
  `send_time` datetime DEFAULT NULL COMMENT '发送时间',
  `execute_time` datetime DEFAULT NULL COMMENT '待执行时间',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='短信助手发送的短信内容';

-- ----------------------------
-- Records of sms_assistant_content
-- ----------------------------

-- ----------------------------
-- Table structure for sms_assistant_content_ref
-- ----------------------------
DROP TABLE IF EXISTS `sms_assistant_content_ref`;
CREATE TABLE `sms_assistant_content_ref` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sms_assistant_content_id` bigint(20) DEFAULT NULL COMMENT '短信助手内容ID',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户ID',
  `customer_mobile` varchar(32) DEFAULT NULL COMMENT '客户手机号',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sms_assistant_content_ref
-- ----------------------------

-- ----------------------------
-- Table structure for sms_captcha
-- ----------------------------
DROP TABLE IF EXISTS `sms_captcha`;
CREATE TABLE `sms_captcha` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `template_code` varchar(32) DEFAULT '0' COMMENT '模版CODE',
  `code` varchar(16) DEFAULT NULL COMMENT '验证码',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `is_valid` tinyint(2) DEFAULT '1' COMMENT '是否有效',
  `mobile` blob COMMENT '手机号码',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='短信验证码';

-- ----------------------------
-- Records of sms_captcha
-- ----------------------------

-- ----------------------------
-- Table structure for sms_conf
-- ----------------------------
DROP TABLE IF EXISTS `sms_conf`;
CREATE TABLE `sms_conf` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `use_defalut_channel` tinyint(4) DEFAULT NULL COMMENT '如果未设置短信账号(sms_account无数据)，是否使用默认通道；1：是，0：否',
  `is_filter_dimission` tinyint(4) DEFAULT NULL COMMENT '是否过滤离职员工，只针对内部员工；1：是，0：否',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='短信配置';

-- ----------------------------
-- Records of sms_conf
-- ----------------------------
INSERT INTO `sms_conf` VALUES ('1', '3', '1', '1', '2017-10-25 17:37:17', null, null, null, '0');

-- ----------------------------
-- Table structure for sms_extend
-- ----------------------------
DROP TABLE IF EXISTS `sms_extend`;
CREATE TABLE `sms_extend` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `template_code` varchar(32) DEFAULT '0' COMMENT '模版CODE',
  `roles` varchar(32) DEFAULT NULL COMMENT '角色id，多个逗号分隔',
  `users` varchar(64) DEFAULT NULL COMMENT '用户id，多个逗号分隔',
  `mobile` varchar(256) DEFAULT NULL COMMENT '需要扩展的手机号码，多个逗号分隔',
  `type` tinyint(2) DEFAULT NULL COMMENT '扩展类型，1：追加；2：过滤',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='短信扩展';

-- ----------------------------
-- Records of sms_extend
-- ----------------------------

-- ----------------------------
-- Table structure for sms_history
-- ----------------------------
DROP TABLE IF EXISTS `sms_history`;
CREATE TABLE `sms_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `response_id` bigint(20) DEFAULT '0' COMMENT '短信响应id',
  `mobile` blob COMMENT '手机号码',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='短信发送历史';

-- ----------------------------
-- Records of sms_history
-- ----------------------------

-- ----------------------------
-- Table structure for sms_response
-- ----------------------------
DROP TABLE IF EXISTS `sms_response`;
CREATE TABLE `sms_response` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `template_code` varchar(32) DEFAULT '0' COMMENT '模版CODE',
  `template_param` varchar(64) DEFAULT NULL COMMENT '模版参数',
  `seq_id` varchar(32) DEFAULT NULL COMMENT '流水号',
  `biz_id` varchar(32) DEFAULT NULL COMMENT '业务id，发送回执id',
  `code` varchar(32) DEFAULT NULL COMMENT '状态码',
  `message` varchar(64) DEFAULT NULL COMMENT '状态码描述',
  `smsType` tinyint(4) DEFAULT NULL COMMENT '短信类型；1：验证码，2：通知，3：群发推广',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='短信发送返回结果';

-- ----------------------------
-- Records of sms_response
-- ----------------------------

-- ----------------------------
-- Table structure for sms_template
-- ----------------------------
DROP TABLE IF EXISTS `sms_template`;
CREATE TABLE `sms_template` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL,
  `code` varchar(32) DEFAULT NULL COMMENT '模版编码',
  `third_party_code` varchar(16) DEFAULT NULL COMMENT '对应三方平台编码',
  `name` varchar(32) DEFAULT NULL COMMENT '模版名称',
  `message` varchar(256) DEFAULT NULL COMMENT '模版内容',
  `description` varchar(256) DEFAULT NULL COMMENT '描述',
  `is_enable` tinyint(2) DEFAULT NULL COMMENT '是否启用',
  `create_user_id` bigint(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_user_id` bigint(20) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `is_delete` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sms_template
-- ----------------------------
INSERT INTO `sms_template` VALUES ('1', '3', 'captcha_2c_retrieve_pwd', 'SMS_99890016', '找回密码', null, null, '1', null, null, null, null, '0');
INSERT INTO `sms_template` VALUES ('2', '3', 'captcha_2c_register', 'SMS_100015016', '注册', null, null, '1', null, null, null, null, '0');

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编码',
  `user_account_id` bigint(20) DEFAULT NULL COMMENT '用户账号id',
  `nick_name` varchar(32) DEFAULT NULL COMMENT '昵称',
  `real_name` varchar(64) DEFAULT NULL COMMENT '真实姓名',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `birth` date DEFAULT NULL COMMENT '生日',
  `sex` tinyint(2) DEFAULT '0' COMMENT '性别，0：未知；1：男；2：女',
  `is_dimission` tinyint(2) DEFAULT '0' COMMENT '是否离职，0：否；1：是',
  `job_number` varchar(32) DEFAULT NULL COMMENT '工号',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`id`),
  KEY `i_tenant_id` (`tenant_id`),
  KEY `i_email` (`email`),
  KEY `i_job_number` (`job_number`),
  KEY `i_real_name` (`real_name`),
  KEY `i_create_user_id` (`create_user_id`),
  KEY `i_update_user_id` (`update_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='职员表';

-- ----------------------------
-- Records of staff
-- ----------------------------

-- ----------------------------
-- Table structure for staff_department
-- ----------------------------
DROP TABLE IF EXISTS `staff_department`;
CREATE TABLE `staff_department` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `staff_id` bigint(20) DEFAULT NULL COMMENT '职员id',
  `department_id` bigint(20) DEFAULT NULL COMMENT '部门id',
  `is_enabled` tinyint(2) DEFAULT '1' COMMENT '是否启用，0：否，1：是',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`id`),
  KEY `i_tenant_id` (`tenant_id`),
  KEY `i_create_user_id` (`create_user_id`),
  KEY `i_update_user_id` (`update_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='职员部门表';

-- ----------------------------
-- Records of staff_department
-- ----------------------------

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `name` varchar(100) DEFAULT NULL COMMENT '供应商名称',
  `remark` varchar(250) DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人id',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(3) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supplier
-- ----------------------------

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `code` varchar(32) DEFAULT '0' COMMENT '编码',
  `name` varchar(32) DEFAULT NULL COMMENT '配置名称',
  `params` varchar(1024) DEFAULT NULL COMMENT '参数',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统配置';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES ('1', '3', 'sale', '销售管理', '{\"opensea\":{\"takeLimitCount\":10,\"taktLimitEnable\":0}}', '2017-11-04 18:45:57', null, null, null, '0');

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `name` varchar(32) DEFAULT NULL COMMENT '名称',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='标签表';

-- ----------------------------
-- Records of tag
-- ----------------------------

-- ----------------------------
-- Table structure for tenant_channel
-- ----------------------------
DROP TABLE IF EXISTS `tenant_channel`;
CREATE TABLE `tenant_channel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `channel_id` bigint(20) DEFAULT NULL COMMENT '短信通道id',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，1：是；0：否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='如果租户在这个表有数据，则使用此记录指定的通道，否则使用默认通道';

-- ----------------------------
-- Records of tenant_channel
-- ----------------------------

-- ----------------------------
-- Table structure for tenant_temp_table
-- ----------------------------
DROP TABLE IF EXISTS `tenant_temp_table`;
CREATE TABLE `tenant_temp_table` (
  `tenant_id` bigint(20) DEFAULT NULL,
  `sms_access_key_id` varchar(250) DEFAULT NULL,
  `sms_access_key_secret` varchar(250) DEFAULT NULL,
  `sms_sign` varchar(250) DEFAULT NULL,
  `sms_is_default` bigint(20) DEFAULT NULL COMMENT '是否使默认sms'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tenant_temp_table
-- ----------------------------
INSERT INTO `tenant_temp_table` VALUES ('3', 'null', 'null', 'null', '1');

-- ----------------------------
-- Table structure for type_property
-- ----------------------------
DROP TABLE IF EXISTS `type_property`;
CREATE TABLE `type_property` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `field_type_id` bigint(20) DEFAULT NULL COMMENT '字段类型id',
  `clazz` varchar(512) DEFAULT NULL COMMENT '属性值class\r\n            \r\n            文本类：[{"type":"text","key":"maxLength","value":"256","name":"最大长度","description":"最大长度不能超过256个字符","sequence":"1","isEnabled":"1"},{"type":"text","key":"minLength","value":"1","name":"最小长度","description":"最小长度不能小于1个字符","sequence":"2","isEnabled":"1"},{"type":"text","key":"description","value":"","name":"帮助文本","description":"最大长度不能超过256个字符","sequence":"3","isEnabled":"1"},{"type":"text","key":"defaultValue","value":"256","name":"默认值","description":"最大长度不能超过256个字符","sequence":"4","isEnabled":"1"}]\r\n            \r\n            文本域类：[{"type":"text","key":"maxLength","value":"65535","name":"最大长度","description":"最大长度不能超过65535个字符","sequence":"1","isEnabled":"1"},{"type":"text","key":"minLength","value":"1","name":"最小长度","description":"最小长度不能小于1个字符","sequence":"2","isEnabled":"1"},{"type":"text","key":"description","value":"","name":"帮助文本","description":"最大长度不能超过256个字符","sequence":"3","isEnabled":"1"}]\r\n            \r\n            单选类：[{"type":"text","key":"maxLength","value":"256","name',
  `is_enabled` tinyint(4) DEFAULT '1' COMMENT '是否启用，0：否，1：是',
  `sequence` int(11) DEFAULT '1' COMMENT '排序，越小越靠前',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，1：是；0：否',
  PRIMARY KEY (`id`),
  KEY `i_tenant_id` (`tenant_id`),
  KEY `i_create_user_id` (`create_user_id`),
  KEY `i_update_user_id` (`update_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务对象字段类型属性';

-- ----------------------------
-- Records of type_property
-- ----------------------------

-- ----------------------------
-- Table structure for ubsresource
-- ----------------------------
DROP TABLE IF EXISTS `ubsresource`;
CREATE TABLE `ubsresource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `system_code` varchar(32) NOT NULL COMMENT '系统编码',
  `parent_id` bigint(20) DEFAULT '-1' COMMENT '父id，-1：表示无父类',
  `code` varchar(32) DEFAULT NULL COMMENT '编码',
  `name` varchar(32) DEFAULT NULL COMMENT '名字',
  `url` varchar(256) DEFAULT NULL COMMENT '链接',
  `status` tinyint(2) DEFAULT '1' COMMENT '状态，0：无效；1：有效',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间 ',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `resource_type` varchar(32) DEFAULT NULL COMMENT '资源类型，1：外部资源；2：内部资源',
  `menue` tinyint(2) DEFAULT '1' COMMENT '1：菜单 2：功能',
  `is_delete` tinyint(2) DEFAULT '0',
  `description` varchar(256) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`),
  UNIQUE KEY `u_i_code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源表';

-- ----------------------------
-- Records of ubsresource
-- ----------------------------

-- ----------------------------
-- Table structure for update_log
-- ----------------------------
DROP TABLE IF EXISTS `update_log`;
CREATE TABLE `update_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `model` varchar(32) DEFAULT NULL COMMENT '修改模块',
  `object_id` bigint(20) DEFAULT NULL COMMENT '修改对象id',
  `update_item` varchar(64) DEFAULT NULL COMMENT '修改项',
  `update_before_content` varchar(512) DEFAULT NULL COMMENT '修改前内容',
  `update_after_content` varchar(512) DEFAULT NULL COMMENT '修改后内容',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '操作人',
  `create_date` datetime DEFAULT NULL COMMENT '操作时间',
  `update_id` bigint(20) DEFAULT NULL COMMENT '修改id',
  `client` varchar(32) DEFAULT NULL COMMENT '修改客户端',
  `clolumn_name` varchar(32) DEFAULT NULL COMMENT '字段名',
  `is_delete` tinyint(2) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `type_object_id_index` (`model`,`object_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='修改日志表';

-- ----------------------------
-- Records of update_log
-- ----------------------------

-- ----------------------------
-- Table structure for user_account
-- ----------------------------
DROP TABLE IF EXISTS `user_account`;
CREATE TABLE `user_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `username` varchar(32) DEFAULT NULL COMMENT '用户名',
  `mobile` varchar(16) DEFAULT NULL COMMENT '手机号',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(1000) DEFAULT NULL COMMENT '密码',
  `is_lock` tinyint(2) DEFAULT NULL COMMENT '是否锁定，0：否，1：是',
  `is_enabled` tinyint(2) DEFAULT '1' COMMENT '是否启用，0：否，1：是',
  `is_system` tinyint(2) DEFAULT '0' COMMENT '是否系统(0:否，1:是)',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(4) DEFAULT '0',
  `enabled_date` datetime DEFAULT NULL COMMENT '最后一次停用时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ui_email` (`email`),
  UNIQUE KEY `ui_mobile` (`mobile`),
  UNIQUE KEY `ui_username` (`username`),
  KEY `i_tenant_id` (`tenant_id`),
  KEY `i_create_user_id` (`create_user_id`),
  KEY `i_update_user_id` (`update_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COMMENT='用户账号表';

-- ----------------------------
-- Records of user_account
-- ----------------------------
INSERT INTO `user_account` VALUES ('46', '3', null, '15611111111', null, null, '0', '1', '1', '2017-11-02 14:55:43', '1', null, null, '0', null);
INSERT INTO `user_account` VALUES ('47', '3', null, '17911111112', null, null, '0', '1', '0', '2017-11-02 15:48:08', '46', null, null, '0', null);
INSERT INTO `user_account` VALUES ('48', '3', null, '17911111113', null, null, '0', '1', '0', '2017-11-02 15:48:42', '46', null, null, '0', null);

-- ----------------------------
-- Table structure for user_custom_field
-- ----------------------------
DROP TABLE IF EXISTS `user_custom_field`;
CREATE TABLE `user_custom_field` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `object_field_id` bigint(20) DEFAULT NULL COMMENT '业务对象字段id',
  `business_object_id` bigint(20) DEFAULT NULL COMMENT '业务对象id',
  `sequence` int(11) DEFAULT '1' COMMENT '排序，越小越靠前',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，1：是；0：否',
  PRIMARY KEY (`id`),
  KEY `i_tenant_id` (`tenant_id`),
  KEY `i_user_id` (`user_id`),
  KEY `i_create_user_id` (`create_user_id`),
  KEY `i_update_user_id` (`update_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户自定义显示字段';

-- ----------------------------
-- Records of user_custom_field
-- ----------------------------

-- ----------------------------
-- Table structure for user_customer
-- ----------------------------
DROP TABLE IF EXISTS `user_customer`;
CREATE TABLE `user_customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `source_type` tinyint(2) DEFAULT NULL COMMENT '来源类型（0：自建，1：分配， 2：领取）',
  `distribution_date` datetime DEFAULT NULL COMMENT '分配日期',
  `distribution_user_id` bigint(20) DEFAULT NULL COMMENT '分配人',
  `is_delete` tinyint(2) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `AK_customer_key` (`customer_id`),
  KEY `user_customer_index` (`customer_id`,`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='客户归属表';

-- ----------------------------
-- Records of user_customer
-- ----------------------------
INSERT INTO `user_customer` VALUES ('1', null, '10000', '46', '0', '2017-11-02 15:49:45', '46', '0');

-- ----------------------------
-- Table structure for user_customer_focus
-- ----------------------------
DROP TABLE IF EXISTS `user_customer_focus`;
CREATE TABLE `user_customer_focus` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `focus_date` datetime DEFAULT NULL COMMENT '关注时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `user_customer_index` (`customer_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户客户关注表';

-- ----------------------------
-- Records of user_customer_focus
-- ----------------------------

-- ----------------------------
-- Table structure for user_department
-- ----------------------------
DROP TABLE IF EXISTS `user_department`;
CREATE TABLE `user_department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `user_account_id` bigint(20) DEFAULT NULL COMMENT '用户账号id',
  `department_id` bigint(20) DEFAULT NULL COMMENT '部门id',
  `is_enabled` tinyint(2) DEFAULT '1' COMMENT '是否启用，0：否，1：是',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `i_tenant_id` (`tenant_id`),
  KEY `i_department_id` (`department_id`),
  KEY `i_create_user_id` (`create_user_id`),
  KEY `i_update_user_id` (`update_user_id`),
  KEY `FK_user_account_id` (`user_account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户部门表';

-- ----------------------------
-- Records of user_department
-- ----------------------------
INSERT INTO `user_department` VALUES ('2', '3', '47', '1', '1', '2017-11-02 15:48:08', '46', null, null, '0');
INSERT INTO `user_department` VALUES ('3', '3', '48', '2', '1', '2017-11-02 15:48:42', '46', null, null, '0');

-- ----------------------------
-- Table structure for user_detail
-- ----------------------------
DROP TABLE IF EXISTS `user_detail`;
CREATE TABLE `user_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `user_account_id` bigint(20) DEFAULT NULL COMMENT '用户账号id',
  `nick_name` varchar(32) DEFAULT NULL COMMENT '昵称',
  `real_name` varchar(64) DEFAULT NULL COMMENT '真实姓名',
  `birth` date DEFAULT NULL COMMENT '生日',
  `sex` tinyint(2) DEFAULT '0' COMMENT '性别，0：未知；1：男；2：女',
  `register_source` varchar(32) DEFAULT NULL COMMENT '注册来源',
  `card_introduce` varchar(200) DEFAULT NULL COMMENT '理财师名片介绍',
  `card_header_bit` varchar(200) DEFAULT NULL COMMENT '理财师名片头衔',
  `card_uuid` varchar(64) DEFAULT NULL COMMENT '理财师UUID',
  `address` varchar(256) DEFAULT NULL COMMENT '地址',
  `avatar` varchar(256) DEFAULT NULL COMMENT '头像',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `i_user_account_id` (`user_account_id`) USING BTREE,
  KEY `i_tenant_id` (`tenant_id`),
  KEY `i_real_name` (`real_name`),
  KEY `i_create_user_id` (`create_user_id`),
  KEY `i_update_user_id` (`update_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户详情表';

-- ----------------------------
-- Records of user_detail
-- ----------------------------
INSERT INTO `user_detail` VALUES ('1', '3', '46', null, '测试', null, null, null, null, null, null, null, null, '2017-11-02 14:55:43', '1', null, null, '0');
INSERT INTO `user_detail` VALUES ('2', '3', '47', null, '理财师一', null, null, null, null, null, null, null, null, '2017-11-02 15:48:08', '46', null, null, '0');
INSERT INTO `user_detail` VALUES ('3', '3', '48', null, '产品总监-可可', null, null, null, null, null, null, null, null, '2017-11-02 15:48:42', '46', null, null, '0');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `user_account_id` bigint(20) DEFAULT NULL COMMENT '用户账号id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  `is_enabled` tinyint(2) DEFAULT '1' COMMENT '是否启用，0：否，1：是',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `i_tenant_id` (`tenant_id`),
  KEY `i_create_user_id` (`create_user_id`),
  KEY `i_update_user_id` (`update_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '3', '46', '1', '1', '2017-11-02 14:55:43', '1', null, null, '0');
INSERT INTO `user_role` VALUES ('2', '3', '47', '2', '1', '2017-11-02 15:48:08', '46', null, null, '0');
INSERT INTO `user_role` VALUES ('3', '3', '48', '4', '1', '2017-11-02 15:48:42', '46', null, null, '0');
INSERT INTO `user_role` VALUES ('4', '3', '48', '5', '1', '2017-11-02 15:48:42', '46', null, null, '0');

-- ----------------------------
-- Table structure for user_staff
-- ----------------------------
DROP TABLE IF EXISTS `user_staff`;
CREATE TABLE `user_staff` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `user_account_id` bigint(20) DEFAULT NULL COMMENT '用户账号id',
  `is_dimission` tinyint(2) DEFAULT '0' COMMENT '是否离职，0：否；1：是',
  `job_number` varchar(32) DEFAULT NULL COMMENT '工号',
  `leader_id` bigint(20) DEFAULT NULL COMMENT '汇报上级id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `i_tenant_id` (`tenant_id`),
  KEY `i_job_number` (`job_number`),
  KEY `i_create_user_id` (`create_user_id`),
  KEY `i_update_user_id` (`update_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户职员表';

-- ----------------------------
-- Records of user_staff
-- ----------------------------
INSERT INTO `user_staff` VALUES ('1', '3', '46', '0', null, null, '2017-11-02 14:55:43', '1', null, null, '0');
INSERT INTO `user_staff` VALUES ('2', '3', '47', '0', null, null, '2017-11-02 15:48:08', '46', null, null, '0');
INSERT INTO `user_staff` VALUES ('3', '3', '48', '0', null, null, '2017-11-02 15:48:42', '46', null, null, '0');

-- ----------------------------
-- Table structure for user_system
-- ----------------------------
DROP TABLE IF EXISTS `user_system`;
CREATE TABLE `user_system` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编码',
  `user_account_id` bigint(20) DEFAULT NULL COMMENT '用户账号id',
  `is_enabled` tinyint(2) DEFAULT '1' COMMENT '是否启用，0：否，1：是',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `i_tenant_id` (`tenant_id`),
  KEY `i_create_user_id` (`create_user_id`),
  KEY `i_update_user_id` (`update_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户系统表';

-- ----------------------------
-- Records of user_system
-- ----------------------------

-- ----------------------------
-- Table structure for user_visit
-- ----------------------------
DROP TABLE IF EXISTS `user_visit`;
CREATE TABLE `user_visit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '回访人id',
  `sub_date` datetime DEFAULT NULL COMMENT '提交回访时间',
  `matter` varchar(128) DEFAULT NULL COMMENT '回访事由',
  `visit_date` datetime DEFAULT NULL COMMENT '回访时间',
  `type` tinyint(2) DEFAULT NULL COMMENT '回访方式(1：电话，2：短信，3：微信/QQ，4：上门拜访，5：其他)',
  `status` tinyint(2) DEFAULT NULL COMMENT '回访状态（1：成功，0：失败）',
  `content` varchar(256) DEFAULT NULL COMMENT '回访内容',
  `next_time` datetime DEFAULT NULL COMMENT '下次回访时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  `next_visit_id` bigint(20) DEFAULT NULL COMMENT '下次回访id',
  `send_status` tinyint(2) DEFAULT '0' COMMENT ' 发送消息的状态（0：没有发送，1：已经发送，2 ：不需要发送）',
  PRIMARY KEY (`id`),
  KEY `tenant_id_index` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户回访';

-- ----------------------------
-- Records of user_visit
-- ----------------------------

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `category` tinyint(4) DEFAULT NULL COMMENT '视频分类 1:路演 2：合规双录',
  `name` varchar(128) DEFAULT NULL COMMENT '视频名称',
  `file_name` varchar(128) DEFAULT NULL COMMENT '文件名',
  `duration` int(11) DEFAULT NULL COMMENT '时长',
  `type` varchar(8) DEFAULT NULL COMMENT '格式',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态 0:压缩中 1：压缩完成',
  `size` bigint(20) DEFAULT NULL COMMENT '大小',
  `cover_url` varchar(255) DEFAULT NULL COMMENT '封面',
  `ref_id` varchar(32) DEFAULT NULL COMMENT '腾讯云文件ID',
  `source_url` varchar(200) DEFAULT NULL COMMENT '原始文件地址',
  `description` varchar(200) DEFAULT NULL COMMENT '描述',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8 COMMENT='视频表';

-- ----------------------------
-- Records of video
-- ----------------------------

-- ----------------------------
-- Table structure for video_category
-- ----------------------------
DROP TABLE IF EXISTS `video_category`;
CREATE TABLE `video_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `ref_parent_id` varchar(64) DEFAULT NULL COMMENT '腾讯云关联目录父节点ID',
  `ref_id` varchar(64) DEFAULT NULL COMMENT '腾讯云关联的目录ID',
  `name` varchar(100) DEFAULT NULL COMMENT '腾讯云中的目录名',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `is_delete` int(11) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='视频分类表';

-- ----------------------------
-- Records of video_category
-- ----------------------------

-- ----------------------------
-- Table structure for video_transcode
-- ----------------------------
DROP TABLE IF EXISTS `video_transcode`;
CREATE TABLE `video_transcode` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `video_id` bigint(20) DEFAULT NULL COMMENT '原始视频关联ID',
  `size` bigint(20) DEFAULT NULL COMMENT '大小',
  `definition` int(11) DEFAULT NULL COMMENT '转码类型 标清：20 高清：30',
  `type` varchar(8) DEFAULT NULL COMMENT '文件格式',
  `md5` varchar(64) DEFAULT NULL COMMENT '视频md5值',
  `url` varchar(200) DEFAULT NULL COMMENT '文件地址（转码后）',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8 COMMENT='视频转码表';

-- ----------------------------
-- Records of video_transcode
-- ----------------------------

-- ----------------------------
-- Table structure for workflow_business_rel
-- ----------------------------
DROP TABLE IF EXISTS `workflow_business_rel`;
CREATE TABLE `workflow_business_rel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `object_id` bigint(20) DEFAULT NULL COMMENT '对象id',
  `business_no` varchar(64) DEFAULT NULL COMMENT '业务流水号',
  `type` varchar(32) DEFAULT NULL COMMENT '类型，1：预约，2：报单',
  `is_complete` tinyint(4) DEFAULT NULL COMMENT '是否已完成，1：是，0：否',
  `init_param` varchar(256) DEFAULT NULL COMMENT '初始参数',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='工作流业务关联表';

-- ----------------------------
-- Records of workflow_business_rel
-- ----------------------------
INSERT INTO `workflow_business_rel` VALUES ('1', '1', '1-1509608936104-product_audit', 'product_audit', '1', null, '2017-11-02 15:48:56', '46', '0');
INSERT INTO `workflow_business_rel` VALUES ('2', '1', '2-1509609004990-product_reservation', 'product_reservation', '1', null, '2017-11-02 15:50:05', '46', '0');
INSERT INTO `workflow_business_rel` VALUES ('3', '1', '3-1509609028954-declaration', 'declaration', '1', null, '2017-11-02 15:50:29', '46', '0');