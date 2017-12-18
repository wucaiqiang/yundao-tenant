delimiter //

DROP PROCEDURE if exists tenant_sql_update_1_2;

create procedure tenant_sql_update_1_2()
begin

DECLARE _tenantId BIGINT;

DECLARE _product_typeId BIGINT;

DECLARE _risk_ratingId BIGINT;

SELECT tenant_id INTO _tenantId FROM user_account LIMIT 1;







CREATE TABLE IF NOT EXISTS `am_company` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='公司信息';

-- ----------------------------
-- Table structure for am_decision
-- ----------------------------

CREATE TABLE IF NOT EXISTS `am_decision` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='立项投决';

-- ----------------------------
-- Table structure for am_decision_flow
-- ----------------------------

CREATE TABLE IF NOT EXISTS `am_decision_flow` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='立项投决流程';

-- ----------------------------
-- Table structure for am_decision_flow_file
-- ----------------------------

CREATE TABLE IF NOT EXISTS `am_decision_flow_file` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='立项投决流程文件';

-- ----------------------------
-- Table structure for am_decision_invest_info
-- ----------------------------

CREATE TABLE IF NOT EXISTS `am_decision_invest_info` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='立项投决投资信息';

-- ----------------------------
-- Table structure for am_decision_suggestion
-- ----------------------------

CREATE TABLE IF NOT EXISTS `am_decision_suggestion` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='立项投决意见';

-- ----------------------------
-- Table structure for am_financing
-- ----------------------------

CREATE TABLE IF NOT EXISTS `am_financing` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='融资信息';

-- ----------------------------
-- Table structure for am_financing_round
-- ----------------------------

CREATE TABLE IF NOT EXISTS `am_financing_round` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='融资轮次';

-- ----------------------------
-- Table structure for am_fund
-- ----------------------------

CREATE TABLE IF NOT EXISTS `am_fund` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='基金信息表';

-- ----------------------------
-- Table structure for am_fund_attach
-- ----------------------------

CREATE TABLE IF NOT EXISTS `am_fund_attach` (
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
-- Table structure for am_fund_field_value
-- ----------------------------

CREATE TABLE IF NOT EXISTS `am_fund_field_value` (
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
-- Table structure for am_fund_focus
-- ----------------------------

CREATE TABLE IF NOT EXISTS `am_fund_focus` (
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
-- Table structure for am_fund_income
-- ----------------------------

CREATE TABLE IF NOT EXISTS `am_fund_income` (
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
-- Table structure for am_fund_income_rule
-- ----------------------------

CREATE TABLE IF NOT EXISTS `am_fund_income_rule` (
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
-- Table structure for am_fund_product
-- ----------------------------

CREATE TABLE IF NOT EXISTS `am_fund_product` (
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
-- Table structure for am_fund_raise
-- ----------------------------

CREATE TABLE IF NOT EXISTS `am_fund_raise` (
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
-- Table structure for am_fund_team
-- ----------------------------

CREATE TABLE IF NOT EXISTS `am_fund_team` (
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
-- Table structure for am_industry
-- ----------------------------

CREATE TABLE IF NOT EXISTS `am_industry` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='行业领域';

-- ----------------------------
-- Table structure for am_investment
-- ----------------------------

CREATE TABLE IF NOT EXISTS `am_investment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `fund_id` bigint(20) DEFAULT NULL COMMENT '基金ID',
  `project_id` bigint(20) DEFAULT NULL COMMENT '项目ID',
  `round` int(11) DEFAULT NULL COMMENT '投资轮次',
  `invest_amount` double DEFAULT NULL COMMENT '投资金额',
  `share_ratio` decimal(10,2) DEFAULT NULL COMMENT '投资占股比例',
  `invest_level` tinyint(2) DEFAULT NULL COMMENT '投资等级 1、领投  2、跟投',
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
-- Table structure for am_project
-- ----------------------------

CREATE TABLE IF NOT EXISTS `am_project` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `name` varchar(64) DEFAULT NULL COMMENT '项目名称',
  `industry_id` bigint(20) DEFAULT NULL COMMENT '行业领域id',
  `leader_id` bigint(20) DEFAULT NULL COMMENT '项目负责人',
  `valuation` double DEFAULT NULL COMMENT '目前估值',
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='项目';

IF EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'am_project' AND column_name ='valuation') THEN
ALTER TABLE am_project DROP valuation;
	END IF;
-- ----------------------------
-- Table structure for am_project_crew
-- ----------------------------

CREATE TABLE IF NOT EXISTS `am_project_crew` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='项目组员';

-- ----------------------------
-- Table structure for am_project_file
-- ----------------------------

CREATE TABLE IF NOT EXISTS `am_project_file` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `project_id` bigint(20) DEFAULT NULL COMMENT '项目id',
  `source_name` varchar(256) DEFAULT NULL COMMENT '项目文件名',
  `url` varchar(256) DEFAULT NULL COMMENT '文件地址',
  `type` varchar(128) DEFAULT NULL COMMENT '类型',
  `ext_name` varchar(16) DEFAULT NULL COMMENT '扩展名',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='项目文件';

-- ----------------------------
-- Table structure for am_project_focus
-- ----------------------------

CREATE TABLE IF NOT EXISTS `am_project_focus` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='项目关注';

-- ----------------------------
-- Table structure for am_project_found_import
-- ----------------------------

CREATE TABLE IF NOT EXISTS `am_project_found_import` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `project_id` bigint(20) DEFAULT NULL COMMENT '项目ID',
  `decision_id` bigint(20) DEFAULT NULL COMMENT '轮次ID',
  `fund_id` bigint(20) DEFAULT NULL COMMENT '基金ID',
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='项目成立导入';

-- ----------------------------
-- Table structure for am_project_record
-- ----------------------------

CREATE TABLE IF NOT EXISTS `am_project_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `project_id` bigint(20) DEFAULT NULL COMMENT '项目id',
  `action` tinyint(4) DEFAULT NULL COMMENT '行为;1:上传,2:下载,3:删除',
  `action_info` varchar(300) DEFAULT NULL COMMENT '行为信息',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='项目记录';

-- ----------------------------
-- Table structure for am_withdrawal
-- ----------------------------

CREATE TABLE IF NOT EXISTS `am_withdrawal` (
   `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `fund_id` bigint(20) DEFAULT NULL COMMENT '基金ID',
  `project_id` bigint(20) DEFAULT NULL COMMENT '项目ID',
  `withdrawal_type` tinyint(2) DEFAULT '0' COMMENT '1、被并购  2、IPO上市  3、股权转让',
  `withdrawal_amount` double DEFAULT NULL COMMENT '投资金额',
  `withdrawal_share_ratio` decimal(10,2) DEFAULT NULL COMMENT '投资占股比例',
  `withdrawal_date` datetime DEFAULT NULL COMMENT '投资日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='退出管理';







	IF NOT EXISTS (select * from dictionary d where d.`value` = 'dic_project_history_audit_status') THEN
      insert INTO dictionary(tenant_id,parent_id,label,value)VALUES(_tenantId,0,'项目审批','dic_project_history_audit_status');
    END IF;

    IF NOT EXISTS (select * from dictionary d LEFT JOIN dictionary p on d.parent_id = p.id where d.`value` = 0 and p.`value` = 'dic_project_history_audit_status') THEN
      insert INTO dictionary(tenant_id,parent_id,label,value) select _tenantId,id,'已通过','2' FROM dictionary where value='dic_project_history_audit_status' limit 1;
    END IF;

    IF NOT EXISTS (select * from dictionary d LEFT JOIN dictionary p on d.parent_id = p.id where d.`value` = 0 and p.`value` = 'dic_project_history_audit_status') THEN
      insert INTO dictionary(tenant_id,parent_id,label,value) select _tenantId,id,'已驳回','3' FROM dictionary where value='dic_project_history_audit_status' limit 1;
    END IF;






IF NOT EXISTS (SELECT 1 FROM resource WHERE id=110) THEN

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('110', _tenantId, 'investment', 'WM', '0', '投资管理', '/investment', '1', '1', '1', '投资管理', '0', '-1', SYSDATE(), NULL, NULL, '0');

END IF;

  IF NOT EXISTS (SELECT 1 FROM resource WHERE id=111) THEN

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('111', _tenantId, 'assets.index', 'WM', '110', '首页', '/assets/index', '1', '1', '1', '首页', '10'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');

  END IF;

  IF NOT EXISTS (SELECT 1 FROM resource WHERE id=112) THEN

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('112', _tenantId, 'assets.project', 'WM', '110', '项目', '/assets/project', '1', '1', '1', '项目', '20'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');

  END IF;


  IF NOT EXISTS (SELECT 1 FROM resource WHERE id=113) THEN

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('113', _tenantId, 'assets.investment', 'WM', '110', '投资管理', '/assets/investment', '1', '1', '1', '投资管理', '30'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');

  END IF;

  IF NOT EXISTS (SELECT 1 FROM resource WHERE id=114) THEN

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('114', _tenantId, 'assets.withdrawal', 'WM', '110', '退出管理', '/assets/withdrawal', '1', '1', '1', '退出管理', '40'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');

  END IF;

  IF NOT EXISTS (SELECT 1 FROM resource WHERE id=115) THEN

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('115', _tenantId, 'assets.fund', 'WM', '110', '基金', '/assets/fund', '1', '1', '1', '基金', '50'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');

  END IF;


  IF NOT EXISTS (SELECT 1 FROM resource WHERE id=116) THEN

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('116', _tenantId, 'assets.project.audit_history', 'WM', '110', '审批历史', '/assets/project/audit_history', '1', '1', '0', '审批历史', '60'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');

  END IF;


   IF NOT EXISTS (SELECT 1 FROM resource WHERE id=117) THEN
INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('117', _tenantId, 'wealth', 'WM', '0', '财富管理', '/wealth', '1', '1', '1', '财富管理', '20'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');
  END IF;

  IF NOT EXISTS (SELECT 1 FROM resource WHERE id=118) THEN
INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('118', _tenantId, 'backstage', 'WM', '0', '后台管理', '/backstage', '1', '1', '1', '后台管理', '30'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');
  END IF;


    IF NOT EXISTS (SELECT 1 FROM resource WHERE id=119) THEN
INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('119', _tenantId, 'assets.index.audit.todo', 'WM', '111', '待我审批', '/assets/index/audit/todo', '0', '1', '1', '待我审批', '10'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');
  END IF;

      IF NOT EXISTS (SELECT 1 FROM resource WHERE id=120) THEN
INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('120', _tenantId, 'assets.index.audit_history.get_page', 'WM', '111', '审批历史', '/assets/index/audit_history/get_page', '0', '1', '1', '审批历史', '20'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');
  END IF;

     IF NOT EXISTS (SELECT 1 FROM resource WHERE id=121) THEN
INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('121', _tenantId, 'assets.index.report', 'WM', '111', '资产管理概况', '/assets/index/report', '0', '1', '1', '资产管理概况', '30'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');
  END IF;

       IF NOT EXISTS (SELECT 1 FROM resource WHERE id=122) THEN
INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('122', _tenantId, 'assets.project.add', 'WM', '112', '新增项目', '/assets/project/add', '0', '1', '1', '新增项目', '10'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');
  END IF;

  IF NOT EXISTS (SELECT 1 FROM resource WHERE id=123) THEN
INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('123', _tenantId, 'assets.project.decision.audit_decisioning', 'WM', '112', '立项会审批', '/assets/project/decision/audit_decisioning', '0', '1', '1', '立项会审批', '20'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');
  END IF;

    IF NOT EXISTS (SELECT 1 FROM resource WHERE id=124) THEN
INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('124', _tenantId, 'assets.project.decision.audit_due_diligence', 'WM', '112', '尽职调查审批', '/assets/project/decision/audit_due_diligence', '0', '1', '1', '尽职调查审批', '30'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');
  END IF;

    IF NOT EXISTS (SELECT 1 FROM resource WHERE id=125) THEN
INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('125', _tenantId, 'assets.project.decision.audit_first_trial', 'WM', '112', '初审审批', '/assets/project/decision/audit_first_trial', '0', '1', '1', '初审审批', '40'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');
  END IF;

      IF NOT EXISTS (SELECT 1 FROM resource WHERE id=126) THEN
INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('126', _tenantId, 'assets.project.decision.audit_investment_commission', 'WM', '112', '投委会审批', '/assets/project/decision/audit_investment_commission', '0', '1', '1', '投委会审批', '50'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');
  END IF;

        IF NOT EXISTS (SELECT 1 FROM resource WHERE id=127) THEN
INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('127', _tenantId, 'assets.project.decision.audit_invest', 'WM', '112', '出资审批', '/assets/project/decision/audit_invest', '0', '1', '1', '出资审批', '60'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');
  END IF;


   IF NOT EXISTS (SELECT 1 FROM resource WHERE id=128) THEN
INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('128', _tenantId, 'assets.fund.add', 'WM', '115', '新增基金', '/assets/fund/add', '0', '1', '1', '新增基金', '10'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');
  END IF;

   IF NOT EXISTS (SELECT 1 FROM resource WHERE id=129) THEN
INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('129', _tenantId, 'assets.investment.add', 'WM', '113', '新增出资', '/assets/investment/add', '0', '1', '1', '新增出资', '10'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');
  END IF;

     IF NOT EXISTS (SELECT 1 FROM resource WHERE id=130) THEN
INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('130', _tenantId, 'assets.withdrawal.add', 'WM', '114', '新增退出', '/assets/withdrawal/add', '0', '1', '1', '新增退出', '10'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');
  END IF;


   IF NOT EXISTS (SELECT 1 FROM resource WHERE parent_id=117 AND id=21) THEN
  UPDATE resource SET parent_id=117 WHERE  id IN(21,8,22,26,77);
  UPDATE resource SET parent_id=118 WHERE  id IN(1,4,87);
  END IF;


	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 110 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (110, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 111 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (111, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 112 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (112, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 113 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (113, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 114 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (114, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 115 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (115, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 116 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (116, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 117 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (117, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 118 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (118, 1);
	END IF;








 IF NOT EXISTS (select * from dictionary WHERE `value` = 'dic_project_source') THEN

INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`) VALUES
(_tenantId, '0', '项目来源', 'dic_project_source', '1', '1', SYSDATE(), 1, '0');
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'网络搜索','1','10'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_source';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'个人／机构推荐','2','20'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_source';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'路演','3','30'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_source';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'邮箱投递','4','40'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_source';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'其他','5','50'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_source';

END IF;


IF NOT EXISTS (select * from dictionary WHERE `value` = 'dic_project_priority') THEN

INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`) VALUES
(_tenantId, '0', '优先级', 'dic_project_priority', '1', '1', SYSDATE(), 1, '0');
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'A[最重要]','1','10'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_priority';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'B[重要]','2','20'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_priority';
  INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'C[普通]','3','30'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_priority';
  INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'D[沉默]','4','40'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_priority';
END IF;


 IF NOT EXISTS (select * from dictionary WHERE `value` = 'dic_project_status') THEN

INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`) VALUES
(_tenantId, '0', '项目状态', 'dic_project_status', '1', '1', SYSDATE(), 1, '0');
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'入库','0','10'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_status';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'立项会','10','20'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_status';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'尽职调查','20','30'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_status';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'初审','30','40'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_status';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'投委会','40','50'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_status';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'待出资','45','60'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_status';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'已出资','50','70'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_status';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'放弃出资','60','80'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_status';
END IF;


 IF NOT EXISTS (select * from dictionary WHERE `value` = 'dic_project_round') THEN

INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`) VALUES
(_tenantId, '0', '轮次', 'dic_project_round', '1', '1', SYSDATE(), 1, '0');
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)

SELECT _tenantId,id,'种子轮','20','20'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_round';
  INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'天使轮','30','30'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_round';
  INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'Pre-A轮','40','40'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_round';
  INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'A轮','50','50'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_round';
  INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'A+轮','60','60'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_round';
  INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'Pre-B轮','70','70'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_round';
  INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'B轮','80','80'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_round';
  INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'B+轮','90','90'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_round';
  INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'C轮','100','100'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_round';
    INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
    SELECT _tenantId,id,'C+轮','101','101'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_round';
    INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'D轮','110','110'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_round';
    INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
    SELECT _tenantId,id,'D+轮','111','111'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_round';
    INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'E轮','120','120'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_round';
    INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'F轮-上市前','130','130'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE
`value`='dic_project_round';
    INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'IPO上市','140','140'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_round';
    INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'新三板','150','150'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_round';
    INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'战略融资','160','160'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_round';
    INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'已被收购','170','170'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_round';
      INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'不明确','180','180'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_round';

END IF;



IF NOT EXISTS (select * from dictionary WHERE `value` = 'dic_currency') THEN

INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`) VALUES
(_tenantId, '0', '币种', 'dic_currency', '1', '1', SYSDATE(), 1, '0');
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'人民币','0','10'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_currency';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'美元','1','10'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_currency';

END IF;


IF NOT EXISTS (select * from dictionary WHERE `value` = 'dic_currency') THEN

INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`) VALUES
(_tenantId, '0', '币种', 'dic_currency', '1', '1', SYSDATE(), 1, '0');
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'人民币','0','10'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_currency';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'美元','1','10'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_currency';

END IF;


 IF NOT EXISTS (select * from dictionary WHERE `value` = 'dic_project_investment_level') THEN

INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`) VALUES
(_tenantId, '0', '投资等级', 'dic_project_investment_level', '1', '1', SYSDATE(), 1, '0');
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'领投','1','10'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_investment_level';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'跟投','2','20'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_investment_level';

END IF;

 IF NOT EXISTS (select * from dictionary WHERE `value` = 'dic_project_investment_type') THEN

INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`) VALUES
(_tenantId, '0', '投资方式', 'dic_project_investment_type', '1', '1', SYSDATE(), 1, '0');
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'增资','1','10'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_investment_type';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'股权转让','2','20'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_investment_type';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'增资&股权转让','3','30'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_investment_type';
END IF;

 IF NOT EXISTS (select * from dictionary WHERE `value` = 'dic_project_investment_source') THEN

INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`) VALUES
(_tenantId, '0', '投资方、投资来源', 'dic_project_investment_source', '1', '1', SYSDATE(), 1, '0');
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'内部基金产品','1','10'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_investment_source';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'其他','2','20'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_investment_source';

END IF;



 IF NOT EXISTS (select * from dictionary WHERE `value` = 'dic_withdrawal_type') THEN

INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`) VALUES
(_tenantId, '0', '退出方式', 'dic_withdrawal_type', '1', '1', SYSDATE(), 1, '0');

INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'被并购','1','10'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_withdrawal_type';

INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'IPO上市','2','20'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_withdrawal_type';

INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'股权转让','3','20'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_withdrawal_type';

END IF;


 IF NOT EXISTS (select * from dictionary WHERE `value` = 'dic_project_company_type') THEN

INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`) VALUES
(_tenantId, '0', '公司类型', 'dic_project_company_type', '1', '1', SYSDATE(), 1, '0');
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'(内资)有限公司','1','10'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_company_type';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'(内资)股份公司','2','20'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_company_type';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'(内资)个人独资企业','3','30'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_company_type';
  INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'(内资)有限合伙企业','4','40'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_company_type';
  INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'(内资)普通合伙企业','5','50'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_company_type';
  INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'(外资)中外合资企业','6','60'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_company_type';
  INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'(外资)外商独资企业','7','70'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_company_type';
  INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'外商投资有限合伙','8','80'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_company_type';
  INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'外商投资普通合伙','9','90'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_company_type';
END IF;

   IF NOT EXISTS (select * from dictionary WHERE `value` = 'dic_project_decision_suggestion') THEN

INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`) VALUES
(_tenantId, '0', '意见', 'dic_project_decision_suggestion', '1', '1', SYSDATE(), 1, '0');
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'通过','1','10'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_decision_suggestion';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'不通过','0','20'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_decision_suggestion';

END IF;

IF NOT EXISTS (select * from dictionary WHERE `value` = 'dic_decision_audit_status') THEN

INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`) VALUES
(_tenantId, '0', '立项审批状态', 'dic_decision_audit_status', '1', '1', SYSDATE(), 1, '0');
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'进行中','0','10'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_decision_audit_status';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'待审批','1','20'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_decision_audit_status';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'已通过','2','30'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_decision_audit_status';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'已驳回','3','40'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_decision_audit_status';

END IF;


  IF NOT EXISTS (select * from dictionary WHERE `value` = 'dic_project_invest_or_not') THEN

INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`) VALUES
(_tenantId, '0', '是否出资', 'dic_project_invest_or_not', '1', '1', SYSDATE(), 1, '0');
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'放弃出资','0','10'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_invest_or_not';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'决定出资','1','20'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_project_invest_or_not';

END IF;


   IF NOT EXISTS (select * from dictionary WHERE `value` = 'dic_fund_issued_status') THEN

INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`) VALUES
(_tenantId, '0', '基金发行状态', 'dic_fund_issued_status', '1', '1', SYSDATE(), 1, '0');
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'待募集','-1','10'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_fund_issued_status';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'募集中','3','20'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_fund_issued_status';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'募集结束','4','30'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_fund_issued_status';
     INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'存续／封闭中','5','40'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_fund_issued_status';
     INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'清算退出','6','50'/*排序*/, '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_fund_issued_status';
END IF;



IF NOT EXISTS (select * from data_object WHERE `code` = 'project') THEN

INSERT INTO `data_object` (`id`, `tenant_id`, `name`, `code`, `description`, `sequence`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`) VALUES
  ('15', _tenantId, '项目', 'project', NULL, '1', sysdate(), '1', NULL, NULL, '0');


  INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
SELECT id,0/*读取*/,0,1,1,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='project';
 INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
SELECT id,0/*读取*/,10,2,0,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='project';
   INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
SELECT id,0/*读取*/,30,3,0,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='project';
   INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
SELECT id,0/*读取*/,40,4,0,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='project';

INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
SELECT id,1/*编辑*/,0,1,1,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='project';
INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
SELECT id,1/*编辑*/,10,2,0,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='project';
INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
SELECT id,1/*编辑*/,30,4,0,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='project';
INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
SELECT id,1/*编辑*/,40,5,0,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='project';

INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
SELECT id,2/*删除*/,0,1,1,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='project';
INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
SELECT id,2/*删除*/,10,2,0,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='project';
INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
SELECT id,2/*删除*/,30,4,0,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='project';
INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
SELECT id,2/*删除*/,40,5,0,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='project';

END IF;



IF NOT EXISTS (select * from data_object WHERE `code` = 'fund') THEN

  INSERT INTO `data_object` (`id`, `tenant_id`, `name`, `code`, `description`, `sequence`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`) VALUES
  ('16', _tenantId, '基金', 'fund', NULL, '5', sysdate(), '1', NULL, NULL, '0');


   INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
SELECT id,0/*读取*/,0,1,1,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='fund';
 INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
SELECT id,0/*读取*/,10,2,0,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='fund';
   INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
SELECT id,0/*读取*/,30,3,0,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='fund';
   INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
SELECT id,0/*读取*/,40,4,0,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='fund';

INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
SELECT id,1/*编辑*/,0,1,1,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='fund';
INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
SELECT id,1/*编辑*/,10,2,0,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='fund';
INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
SELECT id,1/*编辑*/,30,4,0,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='fund';
INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
SELECT id,1/*编辑*/,40,5,0,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='fund';

INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
SELECT id,2/*删除*/,0,1,1,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='fund';
INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
SELECT id,2/*删除*/,10,2,0,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='fund';
INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
SELECT id,2/*删除*/,30,4,0,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='fund';
INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
SELECT id,2/*删除*/,40,5,0,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='fund';

END IF;

/*系统管理员*/
IF NOT EXISTS (select * from data_object_access WHERE role_id=1 AND data_object_id=15) THEN
  INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('15',/*role_id*/'1',/*read*/'0',/*delete*/'0',/*edit*/'0',_tenantId,SYSDATE(),'1',NULL ,NULL ,'0');
END IF;

/*系统管理员*/
IF NOT EXISTS (select * from data_object_access WHERE role_id=1 AND data_object_id=16) THEN
  INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('16',/*role_id*/'1',/*read*/'0',/*delete*/'0',/*edit*/'0',_tenantId,SYSDATE(),'1',NULL ,NULL ,'0');
END IF;

/*理财师*/
IF NOT EXISTS (select * from data_object_access WHERE role_id=2 AND data_object_id=15) THEN
  INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('15',/*role_id*/'2',/*read*/'0',/*delete*/'0',/*edit*/'0',_tenantId,SYSDATE(),'1',NULL ,NULL ,'0');
END IF;

/*理财师*/
IF NOT EXISTS (select * from data_object_access WHERE role_id=2 AND data_object_id=16) THEN
  INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('16',/*role_id*/'2',/*read*/'0',/*delete*/'0',/*edit*/'0',_tenantId,SYSDATE(),'1',NULL ,NULL ,'0');
END IF;


  /*产品助理*/
IF NOT EXISTS (select * from data_object_access WHERE role_id=3 AND data_object_id=15) THEN
  INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('15',/*role_id*/'3',/*read*/'0',/*delete*/'0',/*edit*/'0',_tenantId,SYSDATE(),'1',NULL ,NULL ,'0');
END IF;

/*产品助理*/
IF NOT EXISTS (select * from data_object_access WHERE role_id=3 AND data_object_id=16) THEN
  INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('16',/*role_id*/'3',/*read*/'0',/*delete*/'0',/*edit*/'0',_tenantId,SYSDATE(),'1',NULL ,NULL ,'0');
END IF;


    /*产品经理*/
IF NOT EXISTS (select * from data_object_access WHERE role_id=4 AND data_object_id=15) THEN
  INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('15',/*role_id*/'4',/*read*/'0',/*delete*/'0',/*edit*/'0',_tenantId,SYSDATE(),'1',NULL ,NULL ,'0');
END IF;

/*产品经理*/
IF NOT EXISTS (select * from data_object_access WHERE role_id=4 AND data_object_id=16) THEN
  INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('16',/*role_id*/'4',/*read*/'10',/*delete*/'10',/*edit*/'10',_tenantId,SYSDATE(),'1',NULL ,NULL ,'0');
END IF;


     /*产品总监*/
IF NOT EXISTS (select * from data_object_access WHERE role_id=5 AND data_object_id=15) THEN
  INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('15',/*role_id*/'5',/*read*/'0',/*delete*/'0',/*edit*/'0',_tenantId,SYSDATE(),'1',NULL ,NULL ,'0');
END IF;

/*产品总监*/
IF NOT EXISTS (select * from data_object_access WHERE role_id=5 AND data_object_id=16) THEN
  INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('16',/*role_id*/'5',/*read*/'40',/*delete*/'40',/*edit*/'40',_tenantId,SYSDATE(),'1',NULL ,NULL ,'0');
END IF;


    /*客服专员*/
IF NOT EXISTS (select * from data_object_access WHERE role_id=6 AND data_object_id=15) THEN
  INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('15',/*role_id*/'6',/*read*/'0',/*delete*/'0',/*edit*/'0',_tenantId,SYSDATE(),'1',NULL ,NULL ,'0');
END IF;

/*客服专员*/
IF NOT EXISTS (select * from data_object_access WHERE role_id=6 AND data_object_id=16) THEN
  INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('16',/*role_id*/'6',/*read*/'0',/*delete*/'0',/*edit*/'0',_tenantId,SYSDATE(),'1',NULL ,NULL ,'0');
END IF;


      /*运营经理*/
IF NOT EXISTS (select * from data_object_access WHERE role_id=7 AND data_object_id=15) THEN
  INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('15',/*role_id*/'7',/*read*/'0',/*delete*/'0',/*edit*/'0',_tenantId,SYSDATE(),'1',NULL ,NULL ,'0');
END IF;

/*运营经理*/
IF NOT EXISTS (select * from data_object_access WHERE role_id=7 AND data_object_id=16) THEN
  INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('16',/*role_id*/'7',/*read*/'0',/*delete*/'0',/*edit*/'0',_tenantId,SYSDATE(),'1',NULL ,NULL ,'0');
END IF;


  /*财务专员*/
IF NOT EXISTS (select * from data_object_access WHERE role_id=8 AND data_object_id=15) THEN
  INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('15',/*role_id*/'8',/*read*/'0',/*delete*/'0',/*edit*/'0',_tenantId,SYSDATE(),'1',NULL ,NULL ,'0');
END IF;

/*财务专员*/
IF NOT EXISTS (select * from data_object_access WHERE role_id=8 AND data_object_id=16) THEN
  INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('16',/*role_id*/'8',/*read*/'0',/*delete*/'0',/*edit*/'0',_tenantId,SYSDATE(),'1',NULL ,NULL ,'0');
END IF;


  /*财务总监*/
IF NOT EXISTS (select * from data_object_access WHERE role_id=9 AND data_object_id=15) THEN
  INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('15',/*role_id*/'9',/*read*/'0',/*delete*/'0',/*edit*/'0',_tenantId,SYSDATE(),'1',NULL ,NULL ,'0');
END IF;

/*财务总监*/
IF NOT EXISTS (select * from data_object_access WHERE role_id=9 AND data_object_id=16) THEN
  INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('16',/*role_id*/'9',/*read*/'0',/*delete*/'0',/*edit*/'0',_tenantId,SYSDATE(),'1',NULL ,NULL ,'0');
END IF;



  /*项目经理*/
IF NOT EXISTS (select * from data_object_access WHERE role_id=10 AND data_object_id=15) THEN
  INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('15',/*role_id*/'10',/*read*/'10',/*delete*/'10',/*edit*/'10',_tenantId,SYSDATE(),'1',NULL ,NULL ,'0');
END IF;

/*项目经理*/
IF NOT EXISTS (select * from data_object_access WHERE role_id=10 AND data_object_id=16) THEN
  INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('16',/*role_id*/'10',/*read*/'10',/*delete*/'10',/*edit*/'10',_tenantId,SYSDATE(),'1',NULL ,NULL ,'0');
END IF;



  /*项目总监*/
IF NOT EXISTS (select * from data_object_access WHERE role_id=11 AND data_object_id=15) THEN
  INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('15',/*role_id*/'11',/*read*/'40',/*delete*/'40',/*edit*/'40',_tenantId,SYSDATE(),'1',NULL ,NULL ,'0');
END IF;

/*项目总监*/
IF NOT EXISTS (select * from data_object_access WHERE role_id=11 AND data_object_id=16) THEN
  INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('16',/*role_id*/'11',/*read*/'40',/*delete*/'40',/*edit*/'40',_tenantId,SYSDATE(),'1',NULL ,NULL ,'0');
END IF;

/*将其他角色加上项目数据权限*/
INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
SELECT 15,r.id,'0','0','0',_tenantId,SYSDATE(),'1',NULL,NULL,0 FROM role r WHERE NOT exists(SELECT 1 FROM data_object_access doa WHERE doa.role_id=r.id AND doa.data_object_id=15);

/*将其他角色加上基金数据权限*/
INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
SELECT 16,r.id,'0','0','0',_tenantId,SYSDATE(),'1',NULL,NULL,0 FROM role r WHERE NOT exists(SELECT 1 FROM data_object_access doa WHERE doa.role_id=r.id AND doa.data_object_id=16);


 IF NOT EXISTS (select * from role WHERE id=10) THEN
INSERT INTO `role` (`id`, `tenant_id`, `parent_id`, `system_code`, `name`, `description`, `is_share`, `is_enabled`, `is_system`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('10', _tenantId, '0', NULL, '项目经理', '项目经理', '0', '1', '0', '10', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

 IF NOT EXISTS (select * from role WHERE id=11) THEN
INSERT INTO `role` (`id`, `tenant_id`, `parent_id`, `system_code`, `name`, `description`, `is_share`, `is_enabled`, `is_system`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('11', _tenantId, '0', NULL, '项目总监', '项目总监', '0', '1', '0', '11', '-1', SYSDATE(), NULL, NULL, '0');
END IF;


  /*项目经理 投资管理*/
IF NOT EXISTS (select * from role_resource WHERE resource_id=110 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 110, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目经理 首页*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=111 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 111, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

    /*项目经理 待我审批*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=119 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 119, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目经理 审批历史*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=120 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 120, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目经理 资产管理概况*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=121 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 121, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目经理 项目*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=112 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 112, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目经理 新增项目*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=122 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 122, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目经理 基金*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=115 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 115, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目经理 新增基金*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=128 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 128, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;


  /*项目经理 投资管理*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=113 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 113, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目经理 新增出资*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=129 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 129, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目经理 退出管理*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=114 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 114, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目经理 新增退出*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=130 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 130, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目经理 财富管理*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=117 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 117, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目经理 产品中心*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=21 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 21, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目经理 产品管理*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=8 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 8, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目经理 产品管理*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=9 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 9, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目经理 公告管理*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=13 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 13, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;






   /*项目总监 投资管理*/
IF NOT EXISTS (select * from role_resource WHERE resource_id=110 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 110, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目总监 首页*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=111 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 111, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

    /*项目总监 待我审批*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=119 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 119, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目总监 审批历史*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=120 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 120, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目总监 资产管理概况*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=121 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 121, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目总监 项目*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=112 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 112, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目总监 新增项目*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=122 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 122, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目总监 基金*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=115 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 115, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目总监 新增基金*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=128 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 128, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;


  /*项目总监 投资管理*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=113 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 113, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目总监 新增出资*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=129 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 129, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目总监 退出管理*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=114 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 114, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目总监 新增退出*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=130 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 130, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目总监 财富管理*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=117 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 117, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目总监 产品中心*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=21 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 21, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目总监 产品管理*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=8 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 8, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目总监 产品管理*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=9 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 9, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目总监 公告管理*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=13 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 13, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;


  /*项目总监 立项会审批*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=123 AND role_id=1) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 123, 1, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;
  /*项目总监 尽职调查审批*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=124 AND role_id=1) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 124, 1, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;
  /*项目总监 初审审批*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=125 AND role_id=1) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 125, 1, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;
  /*项目总监 投委会审批*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=126 AND role_id=1) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 126, 1, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;
  /*项目总监 出资审批*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=127 AND role_id=1) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 127, 1, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;


IF NOT EXISTS (SELECT * FROM resource WHERE code='proconf' and name='基金产品配置') THEN
  UPDATE resource SET name='基金产品配置' WHERE code='proconf';
END IF;

IF NOT EXISTS (SELECT * FROM resource WHERE code='proconf.product.config.elements' and name='要素配置') THEN
  UPDATE resource SET name='要素配置' WHERE code='proconf.product.config.elements';
END IF;

IF NOT EXISTS (SELECT * FROM resource WHERE code='proconf.product.config.type' and name='类别配置') THEN
  UPDATE resource SET name='类别配置' WHERE code='proconf.product.config.type';
END IF;



IF NOT EXISTS (SELECT * FROM field WHERE code='product_name' and name='名称') THEN
UPDATE field SET name='名称' WHERE code='product_name';
END IF;


IF NOT EXISTS (SELECT * FROM field WHERE code='product_level' and name='重要等级') THEN
UPDATE field SET name='重要等级' WHERE code='product_level';
END IF;


IF NOT EXISTS (SELECT * FROM field WHERE code='product_receiver_id' and name='负责人') THEN
UPDATE field SET name='负责人' WHERE code='product_receiver_id';
END IF;

IF NOT EXISTS (SELECT * FROM field WHERE code='product_assistant_id' and name='助理') THEN
UPDATE field SET name='助理' WHERE code='product_assistant_id';
END IF;

IF NOT EXISTS (SELECT * FROM field WHERE code='product_product_scale' and name='募集规模') THEN
UPDATE field SET name='募集规模' WHERE code='product_product_scale';
END IF;


IF NOT EXISTS (SELECT * FROM object_field WHERE is_mandatory=0 AND can_edit_mandatory=1 AND field_id=2) THEN
UPDATE object_field SET is_mandatory=0,can_edit_mandatory=1 WHERE field_id=2;
END IF;


IF NOT EXISTS (SELECT * FROM object_field WHERE is_mandatory=0 AND can_edit_mandatory=1 AND field_id=4) THEN
UPDATE object_field SET is_mandatory=0,can_edit_mandatory=1 WHERE field_id=4;
END IF;

IF NOT EXISTS (SELECT * FROM object_field WHERE is_mandatory=0 AND can_edit_mandatory=1 AND field_id=5) THEN
UPDATE object_field SET is_mandatory=0,can_edit_mandatory=1 WHERE field_id=5;
END IF;

IF NOT EXISTS (SELECT * FROM object_field WHERE is_mandatory=0 AND can_edit_mandatory=1 AND field_id=7) THEN
UPDATE object_field SET is_mandatory=0,can_edit_mandatory=1 WHERE field_id=7;
END IF;


    IF EXISTS (SELECT * FROM resource WHERE id=70) THEN
DELETE FROM resource WHERE id=70;
END IF;

IF EXISTS (SELECT * FROM resource WHERE id=71) THEN
DELETE FROM resource WHERE id=71;
END IF;


IF EXISTS (SELECT * FROM role_resource WHERE resource_id=70) THEN
DELETE FROM role_resource WHERE resource_id=70;
END IF;

IF EXISTS (SELECT * FROM role_resource WHERE resource_id=71) THEN
DELETE FROM role_resource WHERE resource_id=71;
END IF;


CREATE TABLE IF NOT EXISTS  `declaration_video` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
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


IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'video' AND column_name = 'category') THEN
	ALTER TABLE `video`
	ADD COLUMN `category`  tinyint(4) NULL COMMENT '视频分类 1:路演 2：合规双录' AFTER `tenant_id`;
END IF;
UPDATE video set category=1 ;






















/*  以下为鉴权相关脚本  */




/* 处理两个在resource表重复的url */
IF NOT EXISTS (select * from resource where `code`='system' AND url='/system') THEN
UPDATE resource SET url='/system' WHERE code='system';
END IF;

IF NOT EXISTS (select * from resource where `code`='customer.pool.add' AND url='/customer/pool/add') THEN
UPDATE resource SET url='/customer/pool/add' WHERE code='customer.pool.add';
END IF;




CREATE TABLE IF NOT EXISTS `api_resource` (
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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='api资源表';


CREATE TABLE IF NOT EXISTS `api_resource_rel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `resource_id` bigint(20) DEFAULT NULL COMMENT '资源id',
  `api_id` bigint(20) DEFAULT NULL COMMENT 'api资源id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='api资源关系表';


IF NOT EXISTS (SELECT * FROM information_schema.statistics WHERE table_schema=DATABASE() AND table_name = 'api_resource_rel' AND index_name = 'resource_id_index') THEN
 create index resource_id_index on api_resource_rel
(
   resource_id
);
END IF;


IF NOT EXISTS (SELECT * FROM information_schema.statistics WHERE table_schema=DATABASE() AND table_name = 'api_resource_rel' AND index_name = 'api_id_index') THEN
 create index api_id_index on api_resource_rel
(
   api_id
);
END IF;





IF NOT EXISTS (select * from api_resource where `code`='reservation.add') THEN

/*=============我的预约 BEGIN==============*/

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'reservation.add', 'WM', '我的预约-->从我的预约页面进行预约', '/reservation/add', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,55,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='reservation.add';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'reservation.submit_declaration', 'WM', '我的预约-->从我的预约页面提交报单', '/reservation/submit_declaration', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,27,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='reservation.submit_declaration';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'reservation.cancel', 'WM', '我的预约-->取消预约', '/reservation/cancel', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,27,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='reservation.cancel';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'reservation.again_commit', 'WM', '我的预约-->重新提交', '/reservation/again_commit', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,27,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='reservation.again_commit';


-- INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
-- VALUES (_tenantId, 'reservation.get', 'WM', '我的预约-->获取预约详情接口', '/reservation/get', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

/*=============我的预约 END==============*/


/*=============额度预约审批 BEGIN==============*/

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'reservation.audit.get_page', 'WM', '预约额度审批-->获取预约额度审批分页数据接口', '/reservation/audit/get_page', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,29,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='reservation.audit.get_page';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'reservation.audit.do', 'WM', '预约额度审批-->预约额度审批页面，审批操作接口', '/reservation/audit/do', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,57,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='reservation.audit.do';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'reservation.audit.discard', 'WM', '预约额度审批-->预约作废', '/reservation/audit/discard', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,65,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='reservation.audit.discard';


INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'reservation.audit.gets_audit_record', 'WM', '预约额度审批-->获取审批记录接口', '/reservation/audit/gets_audit_record', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,29,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='reservation.audit.gets_audit_record';

/*=============额度预约审批 END==============*/


/*=============销售线索 BEGIN==============*/

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'leads.get_page', 'WM', '销售线索管理-->销售线索管理分页接口', '/leads/get_page', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,67,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='leads.get_page';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'leads.customer.get_unallot', 'WM', '销售线索管理-->获取未被分配的销售线索接口', '/leads/customer/get_unallot', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,68,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='leads.customer.get_unallot';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'leads.allot', 'WM', '销售线索管理-->销售线索分配回访接口', '/leads/allot', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,68,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='leads.allot';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'leads.try_allot', 'WM', '销售线索管理-->销售线索尝试分配客服', '/leads/try_allot', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,68,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='leads.try_allot';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'leads.allot_to_fp', 'WM', '销售线索管理-->销售线索分配给理财师', '/leads/allot_to_fp', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,69,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='leads.allot_to_fp';

/*=============销售线索 END==============*/


/*=============回款计划管理 BEGIN==============*/

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'receipt.plan.get_page', 'WM', '回款计划管理-->回款计划分页数据接口', '/receipt/plan/get_page', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,78,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.get_page';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'receipt.plan.delete', 'WM', '回款计划管理-->删除回款计划接口', '/receipt/plan/delete', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,78,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.delete';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'receipt.record.add', 'WM', '回款计划管理-->录入回款接口', '/receipt/record/add', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,78,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.record.add';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'receipt.plan.check_name_exist', 'WM', '回款计划管理-->检查回款计划名称是否存在接口', '/receipt/plan/check_name_exist', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,86,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.check_name_exist';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'product.get_select_option_for_receipt', 'WM', '回款计划管理-->添加回款计划 产品自动补全下拉接口', '/product/get_select_option_for_receipt', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,86,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='product.get_select_option_for_receipt';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'receipt.plan.add', 'WM', '回款计划管理-->添加回款计划接口', '/receipt/plan/add', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,86,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.add';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'receipt.plan.get', 'WM', '回款计划管理-->获取回款计划详情接口', '/receipt/plan/get', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,78,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.get';

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,79,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.get';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'receipt.plan.detail.get_receipts', 'WM', '回款计划管理-->回款计划详情回款记录列表接口', '/receipt/plan/detail/get_receipts', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,78,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.detail.get_receipts';

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,79,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.detail.get_receipts';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'receipt.record.delete', 'WM', '回款计划管理-->回款计划详情 删除回款记录几口', '/receipt/record/delete', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,78,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.record.delete';

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,79,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.record.delete';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'receipt.plan.update', 'WM', '回款计划管理-->修改回款计划接口', '/receipt/plan/update', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,78,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.update';

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,79,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.update';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'receipt.plan.detail.get_declarations', 'WM', '回款计划管理-->回款计划详情 关联报单列表接口', '/receipt/plan/detail/get_declarations', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,78,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.detail.get_declarations';

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,79,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.detail.get_declarations';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'receipt.plan.delete_declaration_rel', 'WM', '回款计划管理-->回款计划详情 移除关联报单', '/receipt/plan/delete_declaration_rel', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,78,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.delete_declaration_rel';

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,79,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.delete_declaration_rel';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'receipt.record.get_can_receipt_declarations', 'WM', '回款计划管理-->回款计划详情 获取可新增的关联报单接口', '/receipt/record/get_can_receipt_declarations', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,78,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.record.get_can_receipt_declarations';

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,79,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.record.get_can_receipt_declarations';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'receipt.plan.add_declaration_rel', 'WM', '回款计划管理-->回款计划详情 新增关联报单', '/receipt/plan/add_declaration_rel', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,78,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.add_declaration_rel';

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,79,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.add_declaration_rel';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'receipt.plan.check_name_exist_for_update', 'WM', '回款计划管理-->检查回款计划名称是否存在（更新操作使用）', '/receipt/plan/check_name_exist_for_update', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,78,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.check_name_exist_for_update';

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,79,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.check_name_exist_for_update';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'receipt.plan.detail.get_supplier', 'WM', '回款计划管理-->获取产品供应商', '/receipt/plan/detail/get_supplier', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,78,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.detail.get_supplier';

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,79,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.detail.get_supplier';

/*=============额度预约审批 END==============*/


/*=============角色权限管理 BEGIN==============*/

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'role.gets', 'WM', '角色权限管理-->获取角色列表接口', '/role/gets', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,2,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='role.gets';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'resource.get_by_role_id', 'WM', '角色权限管理-->获取角色对应的资源列表接口', '/resource/get_by_role_id', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,2,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='resource.get_by_role_id';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'data.object.gets', 'WM', '角色权限管理-->获取角色对应的数据权限列表接口', '/data/object/gets', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,2,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='data.object.gets';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'user.get_by_role', 'WM', '角色权限管理-->获取角色关联员工列表接口', '/user/get_by_role', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,2,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='user.get_by_role';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'role.add', 'WM', '角色权限管理-->添加角色接口', '/role/add', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,2,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='role.add';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'role.update', 'WM', '角色权限管理-->修改角色接口', '/role/update', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,2,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='role.update';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'role.delete', 'WM', '角色权限管理-->删除角色接口', '/role/delete', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,2,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='role.delete';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'resource.update_by_role_id', 'WM', '角色权限管理-->修改角色的功能权限接口', '/resource/update_by_role_id', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,2,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='resource.update_by_role_id';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'user.get_for_org', 'WM', '角色权限管理-->查看员工详情', '/user/get_for_org', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,2,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='user.get_for_org';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'user.modify', 'WM', '角色权限管理&组织架构管理-->编辑用户', '/user/modify', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,2,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='user.modify';

/*=============角色权限管理 END==============*/


/*=============客户 BEGIN==============*/

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'customer.v2.get_page', 'WM', '客户-->获取分页数据', '/customer/v2/get_page', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,91,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='customer.v2.get_page';
/* 已存在
INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'user.get_users_by_realName', 'WM', '客户-->根据用户姓名自动补全，用于调配客户', '/user/get_users_by_realName', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');
*/
  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,95,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='user.get_users_by_realName';

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,97,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='user.get_users_by_realName';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'customer.v2.back.apply', 'WM', '客户-->放弃', '/customer/v2/back/apply', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,92,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='customer.v2.back.apply';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'customer.v2.add', 'WM', '客户-->新增客户', '/customer/v2/add', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,93,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='customer.v2.add';


INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'customer.v2.import.multi', 'WM', '客户-->批量导入客户', '/customer/v2/import/multi', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,94,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='customer.v2.import.multi';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'customer.v2.distribution.allot_to_fp', 'WM', '客户-->调配', '/customer/v2/distribution/allot_to_fp', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,95,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='customer.v2.distribution.allot_to_fp';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'customer.v2.distribution.recycle', 'WM', '客户-->回收', '/customer/v2/distribution/recycle', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,96,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='customer.v2.distribution.recycle';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'customer.v2.distribution.allot_to_cs', 'WM', '客户-->分配回访', '/customer/v2/distribution/allot_to_cs', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,97,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='customer.v2.distribution.allot_to_cs';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'user.customer.v2.focus', 'WM', '客户-->关注', '/user/customer/v2/focus', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,98,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='user.customer.v2.focus';

/*=============客户 END==============*/



/*=============组织架构管理 BEGIN==============*/



INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'department.gets', 'WM', '组织架构管理-->获取部门接口', '/department/gets', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,6,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='department.gets';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'user.get_enabled_users', 'WM', '组织架构管理-->获取在职员工接口', '/user/get_enabled_users', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,6,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='user.get_enabled_users';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'user.get_cease_users', 'WM', '组织架构管理-->获取停用员工接口', '/user/get_cease_users', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,6,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='user.get_cease_users';


INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'user.cease', 'WM', '组织架构管理-->停用员工接口', '/user/cease', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,6,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='user.cease';


INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'user.enabled', 'WM', '组织架构管理-->启用员工接口', '/user/enabled', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,6,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='user.enabled';


INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'department.add', 'WM', '组织架构管理-->新增部门接口', '/department/add', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,6,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='department.add';


INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'department.update', 'WM', '组织架构管理-->编辑部门接口', '/department/update', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,6,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='department.update';


INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'department.delete', 'WM', '组织架构管理-->删除部门接口', '/department/delete', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,6,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='department.delete';



  /*获取用户详情*/
  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,6,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='user.get_for_org';

  /*编辑用户详情*/
  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,6,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='user.modify';

  /*选择角色 下拉*/
  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT _tenantId,6,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='role.gets';



/*=============组织架构管理 END==============*/



/*=============白名单 BEGIN==============*/

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'customer.validate_mobile', 'WM', '白名单-->验证客户手机号是否可用', '/customer/validate_mobile', '1', '1',1,NULL , SYSDATE(), NULL, NULL, NULL, '0');

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'customer.update', 'WM', '白名单-->编辑客户基本资料', '/customer/update', '1', '1',1,NULL , SYSDATE(), NULL, NULL, NULL, '0');

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'customer.update_info', 'WM', '白名单-->编辑客户信息', '/customer/update_info', '1', '1',1,NULL , SYSDATE(), NULL, NULL, NULL, '0');

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'customer.update_contact', 'WM', '白名单-->编辑客户联系方式', '/customer/update_contact', '1', '1',1,NULL , SYSDATE(), NULL, NULL, NULL, '0');

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'customer.get_detail', 'WM', '白名单-->获取客户详情', '/customer/get_detail', '1', '1',1,NULL , SYSDATE(), NULL, NULL, NULL, '0');

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'customer.get_user_customer', 'WM', '白名单-->获取我的客户下拉选项', '/customer/get_user_customer', '1', '1',1,NULL , SYSDATE(), NULL, NULL, NULL, '0');

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'customer.follow.add', 'WM', '白名单-->添加跟进', '/customer/follow/add', '1', '1',1,NULL , SYSDATE(), NULL, NULL, NULL, '0');

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'leads.customer.detail.get_page', 'WM', '白名单-->获取客户详情页面销售线索列表', '/leads/customer/detail/get_page', '1', '1',1,NULL , SYSDATE(), NULL, NULL, NULL, '0');

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, 'leads.process', 'WM', '白名单-->处理销售线索', '/leads/process', '1', '1',1,NULL , SYSDATE(), NULL, NULL, NULL, '0');



	-- 白名单
	IF NOT EXISTS (select * from api_resource where `code`='resource.get_menu' and url='/resource/get_menu' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`,
       `is_delete`,is_whitelist,create_date)
       VALUES (_tenantId, 'resource.get_menu', '白名单-->获取菜单和功能权限', '/resource/get_menu', 1, 1,'WM', 0,1,SYSDATE());
	END IF;

	IF NOT EXISTS (select * from api_resource where `code`='dictionary.gets' and url='/dictionary/gets' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`,
       `is_delete`,is_whitelist,create_date)
       VALUES (_tenantId, 'dictionary.gets', '白名单-->获取数据字段', '/dictionary/gets', 1, 1,'WM', 0,1,SYSDATE());
	END IF;

	IF NOT EXISTS (select * from api_resource where `code`='msg.message.get_unread_count' and url='/msg/message/get_unread_count' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`,
       `is_delete`,is_whitelist,create_date)
       VALUES (_tenantId, 'msg.message.get_unread_count', '白名单-->获取消息的个数', '/msg/message/get_unread_count', 1, 1,
       'WM', 0,1,SYSDATE());
	END IF;

	IF NOT EXISTS (select * from api_resource where `code`='product.fieldgroup.get_all' and url='/product/fieldgroup/get_all' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`,
       `is_delete`,is_whitelist,create_date)
       VALUES (_tenantId, 'product.fieldgroup.get_all', '白名单-->获取所有产品类别', '/product/fieldgroup/get_all', 1, 1,'WM',
       0,1,SYSDATE());
	END IF;


	IF NOT EXISTS (select * from api_resource where `code`='msg.message.get_my_page' and url='/msg/message/get_my_page' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`,
       `is_delete`,is_whitelist,create_date)
       VALUES (_tenantId, 'msg.message.get_my_page', '白名单-->分页获取消息列表', '/msg/message/get_my_page', 1, 1,'WM', 0,1,SYSDATE());
	END IF;


/*=============白名单 END==============*/


/* 将没有 财富管理 的角色 勾上 */
INSERT INTO role_resource (tenant_id,resource_id,role_id,create_date)
SELECT _tenantId,117,r.id,SYSDATE() FROM role r WHERE EXISTS(SELECT 1 FROM role_resource rr2 WHERE rr2.role_id=r.id AND
rr2.resource_id IN(8,21,22,26,77) AND NOT EXISTS(SELECT 1 FROM role_resource rr3 WHERE  rr3.role_id=r.id and rr3.resource_id=117)
);


/* 将没有 数据报表(APP) 的角色 勾上 */
INSERT INTO role_resource (tenant_id,resource_id,role_id,create_date)
SELECT _tenantId,99,r.id,SYSDATE() FROM role r WHERE EXISTS(SELECT 1 FROM role_resource rr2 WHERE rr2.role_id=r.id AND
rr2.resource_id IN(100,101,102,105) AND NOT EXISTS(SELECT 1 FROM role_resource rr3 WHERE  rr3.role_id=r.id and rr3.resource_id=99)
);


/* 将没有 投资管理 的角色 勾上 */
INSERT INTO role_resource (tenant_id,resource_id,role_id,create_date)
SELECT _tenantId,110,r.id,SYSDATE() FROM role r WHERE EXISTS(SELECT 1 FROM role_resource rr2 WHERE rr2.role_id=r.id AND
rr2.resource_id IN(111,112,113,114,115,129) AND NOT EXISTS(SELECT 1 FROM role_resource rr3 WHERE  rr3.role_id=r.id and rr3.resource_id=110)
);


/* 将没有 后台管理 的角色 勾上 */
INSERT INTO role_resource (tenant_id,resource_id,role_id,create_date)
SELECT _tenantId,118,r.id,SYSDATE() FROM role r WHERE EXISTS(SELECT 1 FROM role_resource rr2 WHERE rr2.role_id=r.id AND
rr2.resource_id IN(1,4,87) AND NOT EXISTS(SELECT 1 FROM role_resource rr3 WHERE  rr3.role_id=r.id and rr3.resource_id=118)
);

	END IF;



	IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'product_attach' AND column_name = 'show_type') THEN
	ALTER TABLE `product_attach`
	ADD COLUMN `show_type`  tinyint(4) DEFAULT 0 COMMENT '可见性：1：内部可见 2：外部可见 0：全部可见' AFTER `sort`;
END IF;

UPDATE product_attach set show_type=0 where show_type is null;

IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'declaration_video' AND column_name = 'tenant_id') THEN
	ALTER TABLE `declaration_video`
	ADD COLUMN `tenant_id`  bigint(20) NULL DEFAULT NULL COMMENT '租户id' AFTER `id`;
END IF;



UPDATE resource SET sequence=25 WHERE code='assets.fund' AND sequence=50 LIMIT 1;



IF NOT EXISTS (SELECT 1 FROM resource WHERE id=131) THEN

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('131', _tenantId, 'report.customer', 'WM', '99', '客户新增', '/report/customer', '1', '1', '0', '数据报表(APP)-->客户新增', '40', '-1', SYSDATE(), NULL, NULL, '0');

END IF;


IF NOT EXISTS (SELECT 1 FROM resource WHERE id=132) THEN

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('132', _tenantId, 'report.customer.get_department', 'WM', '131', '部门新增', '/report/customer/get_department', '0', '1', '0', '数据报表(APP)-->客户新增-->部门新增', '10', '-1', SYSDATE(), NULL, NULL, '0');

END IF;


IF NOT EXISTS (SELECT 1 FROM resource WHERE id=133) THEN

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('133', _tenantId, 'report.customer.get_user_rank_page', 'WM', '131', '员工新增', '/report/customer/get_user_rank_page', '0', '1', '0', '数据报表(APP)-->客户新增-->员工新增', '20', '-1', SYSDATE(), NULL, NULL, '0');

END IF;



	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 131 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (131, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 132 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (132, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 133 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (133, 1);
	END IF;



  	IF EXISTS (select * from resource where id = 116 AND code='assets.project.audit_history') THEN
       DELETE FROM resource WHERE id=116 LIMIT 1;
       DELETE FROM role_resource WHERE resource_id=116;
	END IF;
	
   	UPDATE dictionary d,dictionary d2 set d.sequence=0 WHERE d.parent_id = d2.id AND d2.`value`='dic_roadshow_status' AND d.`value`=1;
 	UPDATE dictionary d,dictionary d2 set d.sequence=1 WHERE d.parent_id = d2.id AND d2.`value`='dic_roadshow_status' AND d.`value`=0;
 	UPDATE dictionary d,dictionary d2 set d.sequence=0 WHERE d.parent_id = d2.id AND d2.`value`='dic_roadshow_column_status' AND d.`value`=1;
 	UPDATE dictionary d,dictionary d2 set d.sequence=1 WHERE d.parent_id = d2.id AND d2.`value`='dic_roadshow_column_status' AND d.`value`=0;
 	UPDATE dictionary d,dictionary d2 set d.sequence=0 WHERE d.parent_id = d2.id AND d2.`value`='dic_article_status' AND d.`value`=1;
 	UPDATE dictionary d,dictionary d2 set d.sequence=1 WHERE d.parent_id = d2.id AND d2.`value`='dic_article_status' AND d.`value`=0;
 	UPDATE dictionary d,dictionary d2 set d.sequence=0 WHERE d.parent_id = d2.id AND d2.`value`='dic_article_column_status' AND d.`value`=1;
	UPDATE dictionary d,dictionary d2 set d.sequence=1 WHERE d.parent_id = d2.id AND d2.`value`='dic_article_column_status' AND d.`value`=0;



end;

call tenant_sql_update_1_2();

DROP PROCEDURE if exists tenant_sql_update_1_2;
//