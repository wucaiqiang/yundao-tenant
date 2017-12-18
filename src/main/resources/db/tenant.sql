delimiter //

DROP PROCEDURE if exists tenant_sql_update_1_2;

create procedure tenant_sql_update_1_2()
begin

DECLARE _tenantId BIGINT;

DECLARE _product_typeId BIGINT;

DECLARE _risk_ratingId BIGINT;

DECLARE _industry_table_count int;

SELECT tenant_id INTO _tenantId FROM user_account LIMIT 1;

   IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'user_detail' AND column_name = 'address') THEN
	     ALTER TABLE `user_detail`
          ADD COLUMN `address`  VARCHAR(256) NULL COMMENT '地址' AFTER `card_uuid`;
          
   END IF; 
	
   IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'user_detail' AND column_name = 'avatar') THEN
	     ALTER TABLE `user_detail`
          ADD COLUMN `avatar`  VARCHAR(256) NULL COMMENT '头像' AFTER `address`;
   END IF; 


CREATE TABLE IF NOT EXISTS `sms_assistant_content` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `call_title` varchar(100) DEFAULT NULL COMMENT '称呼',
  `send_title` varchar(100) DEFAULT NULL COMMENT '签名',
  `content` varchar(200) DEFAULT NULL COMMENT '内容',
  `send_status` tinyint(4) DEFAULT '0' COMMENT '发送状态 ： 0:未发送 1：发送成功 2：发送失败',
  `send_time` datetime DEFAULT NULL COMMENT '发送时间',
  `execute_time` datetime DEFAULT NULL COMMENT '待执行时间',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='短信助手发送的短信内容';

CREATE TABLE IF NOT EXISTS `sms_assistant_content_ref` (
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


IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'product_attach' AND column_name = 'show_type') THEN
	ALTER TABLE `product_attach`
	ADD COLUMN `show_type`  tinyint(4) DEFAULT 0 COMMENT '可见性：1：内部可见 2：外部可见 0：全部可见' AFTER `sort`;
END IF;
UPDATE product_attach set show_type=0 where show_type is null;



CREATE TABLE IF NOT EXISTS `customer_follow_up_attach` (
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

IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'customer_follow_up' AND column_name = 'map_type') THEN
	ALTER TABLE `customer_follow_up`
	ADD COLUMN `map_type`  tinyint(4) DEFAULT null COMMENT '地图类型： 1:高德 2：百度' AFTER `content`;
END IF;
IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'customer_follow_up' AND column_name = 'itude_x') THEN
	ALTER TABLE `customer_follow_up`
	ADD COLUMN `itude_x`  double DEFAULT null COMMENT '经度' AFTER `map_type`;
END IF;
IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'customer_follow_up' AND column_name = 'itude_y') THEN
	ALTER TABLE `customer_follow_up`
	ADD COLUMN `itude_y`  double DEFAULT null COMMENT '纬度' AFTER `itude_x`;
END IF;
IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'customer_follow_up' AND column_name = 'address') THEN
	ALTER TABLE `customer_follow_up`
	ADD COLUMN `address`  varchar(256) DEFAULT null COMMENT '地址' AFTER `itude_y`;
END IF;

UPDATE msg_template set feed_content ='客户跟进：$!{content}
方式：$!{typeName} 状态：$!{statusName} ,操作人：$!{createUserName}' where code='customer_follow';

CREATE TABLE IF NOT EXISTS `share_info` (
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

DELETE from  dictionary WHERE parent_id IN(
SELECT * FROM(
SELECT id FROM dictionary WHERE `value`='dic_follow_up_status') t);

INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'有效','1','0', '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_follow_up_status';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'无效','2','1', '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_follow_up_status';


 SELECT COUNT(1) INTO _industry_table_count FROM information_schema.TABLES WHERE table_name ='am_industry';

    IF _industry_table_count=0 THEN

INSERT INTO `am_industry` (`tenant_id`, `name`, `sequence`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`) VALUES (_tenantId, '人工智能', '10', SYSDATE(), NULL, NULL, NULL, '0');

INSERT INTO `am_industry` (`tenant_id`, `name`, `sequence`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`) VALUES (_tenantId, '教育', '20', SYSDATE(), NULL, NULL, NULL, '0');

INSERT INTO `am_industry` (`tenant_id`, `name`, `sequence`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`) VALUES (_tenantId, '金融', '30', SYSDATE(), NULL, NULL, NULL, '0');

INSERT INTO `am_industry` (`tenant_id`, `name`, `sequence`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`) VALUES (_tenantId, '汽车交通', '40', SYSDATE(), NULL, NULL, NULL, '0');

INSERT INTO `am_industry` (`tenant_id`, `name`, `sequence`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`) VALUES (_tenantId, '房产服务', '50', SYSDATE(), NULL, NULL, NULL, '0');

INSERT INTO `am_industry` (`tenant_id`, `name`, `sequence`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`) VALUES (_tenantId, '医疗健康', '60', SYSDATE(), NULL, NULL, NULL, '0');

INSERT INTO `am_industry` (`tenant_id`, `name`, `sequence`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`) VALUES (_tenantId, '生活服务', '70', SYSDATE(), NULL, NULL, NULL, '0');

INSERT INTO `am_industry` (`tenant_id`, `name`, `sequence`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`) VALUES (_tenantId, '硬件', '80', SYSDATE(), NULL, NULL, NULL, '0');

INSERT INTO `am_industry` (`tenant_id`, `name`, `sequence`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`) VALUES (_tenantId, '企业服务', '90', SYSDATE(), NULL, NULL, NULL, '0');

END IF;

  
DELETE from user_department where department_id='0';

 alter table video MODIFY name varchar(128) DEFAULT NULL COMMENT '视频名称';
 alter table video MODIFY file_name varchar(128) DEFAULT NULL COMMENT '文件名';


 UPDATE resource SET name='组织结构管理' WHERE code='system.config.organization' AND name='组织架构管理' LIMIT 1;
  UPDATE data_object SET name='客户基本资料' WHERE code='customer' AND name='客户' LIMIT 1;


  /*系统管理员*/
IF EXISTS (select * from data_object_access WHERE role_id=1 AND data_object_id=15) THEN
UPDATE data_object_access SET read_permission=40,delete_permission=40,edit_permission=40 WHERE role_id=1 AND data_object_id=15;
END IF;

IF EXISTS (select * from data_object_access WHERE role_id=1 AND data_object_id=16) THEN
UPDATE data_object_access SET read_permission=40,delete_permission=40,edit_permission=40 WHERE role_id=1 AND data_object_id=16;
END IF;

IF EXISTS (select * from data_object_access WHERE role_id=1 AND data_object_id=12 ) THEN
UPDATE data_object_access SET edit_permission=40 WHERE role_id=1 AND data_object_id=12;
END IF;


INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `is_delete`)
SELECT 1,r.id,1,1,NULL,SYSDATE(),0 FROM resource r WHERE NOT EXISTS(SELECT 1 FROM role_resource rr WHERE rr
.resource_id=r.id AND rr.role_id=1);


UPDATE role SET name='超级管理员' WHERE id=1 AND name='系统管理员' LIMIT 1;

  UPDATE role SET sequence=sequence * 10 WHERE id<12 AND sequence<20;

 IF NOT EXISTS (select * from role WHERE id=12) THEN
INSERT INTO `role` (`id`, `tenant_id`, `parent_id`, `system_code`, `name`, `description`, `is_share`, `is_enabled`, `is_system`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('12', _tenantId, '0', NULL, '系统管理员', '系统管理员', '0', '1', '0', '11', '-1', SYSDATE(), NULL, NULL, '0');
END IF;


    /*系统管理员 后台管理*/
IF NOT EXISTS (select * from role_resource WHERE resource_id=118 AND role_id=12) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 118, 12, '1', NULL, SYSDATE(), NULL, NULL, '0');
END IF;


    /*系统管理员 系统管理*/
IF NOT EXISTS (select * from role_resource WHERE resource_id=1 AND role_id=12) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 1, 12, '1', NULL, SYSDATE(), NULL, NULL, '0');
END IF;


  /*系统管理员 角色权限管理*/
IF NOT EXISTS (select * from role_resource WHERE resource_id=2 AND role_id=12) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 2, 12, '1', NULL, SYSDATE(), NULL, NULL, '0');
END IF;


  /*系统管理员 组织结构管理*/
IF NOT EXISTS (select * from role_resource WHERE resource_id=6 AND role_id=12) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 6, 12, '1', NULL, SYSDATE(), NULL, NULL, '0');
END IF;

    /*系统管理员 销售管理配置*/
IF NOT EXISTS (select * from role_resource WHERE resource_id=106 AND role_id=12) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( _tenantId, 106, 12, '1', NULL, SYSDATE(), NULL, NULL, '0');
END IF;


UPDATE role SET sequence=9999 WHERE sequence=1;
UPDATE role SET sequence=2 WHERE id=1;
UPDATE user_role ur,user_account ua SET ur.role_id=12 WHERE  ur.user_account_id=ua.id AND ur.role_id=1 AND ua.is_system=0;

end;
call tenant_sql_update_1_2();

DROP PROCEDURE if exists tenant_sql_update_1_2;
//