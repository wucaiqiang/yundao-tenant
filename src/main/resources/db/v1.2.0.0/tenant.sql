delimiter //

DROP PROCEDURE if exists tenant_sql_update_1_2;

create procedure tenant_sql_update_1_2()
begin

DECLARE _tenantId BIGINT;
DECLARE _msgReservationDiscard BIGINT;
DECLARE _msgDeclarationDiscard BIGINT;
DECLARE _objectFieldId BIGINT;

SELECT tenant_id INTO _tenantId FROM user_account LIMIT 1;

	IF EXISTS (SELECT 1 FROM resource WHERE code='customer.my') THEN
  UPDATE resource SET is_deplay=0 WHERE id IN (
    SELECT * FROM (
       SELECT r.id FROM resource r LEFT JOIN resource pr ON r.parent_id=pr.id WHERE pr.code='customer.my') t);

       UPDATE resource SET is_deplay=0 WHERE code='customer.my';
	END IF;


	IF EXISTS (SELECT 1 FROM resource WHERE code='customer.pool') THEN
  UPDATE resource SET is_deplay=0 WHERE id IN (
    SELECT * FROM (
       SELECT r.id FROM resource r LEFT JOIN resource pr ON r.parent_id=pr.id WHERE pr.code='customer.pool') t);

       UPDATE resource SET is_deplay=0 WHERE code='customer.pool';
	END IF;

	
	
IF NOT EXISTS (SELECT 1 FROM resource WHERE code='customer.index' AND id=91) THEN

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('91', _tenantId, 'customer.index', 'WM', '22', '客户', '/customer/index', '1', '1', '1', '客户（我的客户和全部客户合并）', '10', '-1', SYSDATE(), NULL, NULL, '0');

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) 
VALUES ('92', _tenantId, 'customer.v2.back.apply', 'WM', '91', '放弃', '/customer/v2/back/apply', '0', '1', '0', '客户管理 - 客户 放弃(回退)', '2', '-1', SYSDATE(), NULL, NULL, '0');

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) 
VALUES ('93', _tenantId, 'customer.v2.add', 'WM', '91', '新增客户', '/customer/v2/add', '0', '1', '0', '客户管理 - 客户 新增客户', '6', '-1', SYSDATE(), NULL, NULL, '0');

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) 
VALUES ('94', _tenantId, 'customer.v2.import.multi', 'WM', '91', '批量导入客户', '/customer/v2/import/multi', '0', '1', '0', '客户管理 - 客户 批量导入客户', '7', '-1', SYSDATE(), NULL, NULL, '0');


INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) 
VALUES ('95', _tenantId, 'customer.v2.distribution.allot_to_fp', 'WM', '91', '调配', '/customer/v2/distribution/allot_to_fp', '0', '1', '0', '客户管理 - 客户 调配', '3', '-1', SYSDATE(), NULL, NULL, '0');

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) 
VALUES ('96', _tenantId, 'customer.v2.distribution.recycle', 'WM', '91', '回收', '/customer/v2/distribution/recycle', '0', '1', '0', '客户管理 - 客户 回收', '4', '-1', SYSDATE(), NULL, NULL, '0');

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) 
VALUES ('97', _tenantId, 'customer.v2.distribution.allot_to_cs', 'WM', '91', '分配回访', '/customer/v2/distribution/allot_to_cs', '0', '1', '0', '客户管理 - 客户 分配回访', '5', '-1', SYSDATE(), NULL, NULL, '0');

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) 
VALUES ('98', _tenantId, 'user.customer.v2.focus', 'WM', '91', '关注', '/user/customer/v2/focus', '0', '1', '0', '客户管理 - 客户 关注', '1', '-1', SYSDATE(), NULL, NULL, '0');


INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) 
VALUES (_tenantId, '91', '1', '1', '-1', SYSDATE(), NULL, NULL, '0');
INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, '91', '2', '1', '-1', SYSDATE(), NULL, NULL, '0');
INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, '91', '7', '1', '-1', SYSDATE(), NULL, NULL, '0');

INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) 
VALUES (_tenantId, '92', '1', '1', '-1', SYSDATE(), NULL, NULL, '0');
INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, '92', '2', '1', '-1', SYSDATE(), NULL, NULL, '0');

INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) 
VALUES (_tenantId, '93', '1', '1', '-1', SYSDATE(), NULL, NULL, '0');
INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, '93', '2', '1', '-1', SYSDATE(), NULL, NULL, '0');

INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) 
VALUES (_tenantId, '94', '1', '1', '-1', SYSDATE(), NULL, NULL, '0');
INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, '94', '2', '1', '-1', SYSDATE(), NULL, NULL, '0');

INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) 
VALUES (_tenantId, '95', '1', '1', '-1', SYSDATE(), NULL, NULL, '0');
INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, '95', '7', '1', '-1', SYSDATE(), NULL, NULL, '0');

INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) 
VALUES (_tenantId, '96', '1', '1', '-1', SYSDATE(), NULL, NULL, '0');
INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, '96', '7', '1', '-1', SYSDATE(), NULL, NULL, '0');

INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) 
VALUES (_tenantId, '97', '1', '1', '-1', SYSDATE(), NULL, NULL, '0');
INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, '97', '7', '1', '-1', SYSDATE(), NULL, NULL, '0');

INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, '93', '7', '1', '-1', SYSDATE(), NULL, NULL, '0');

INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, '94', '7', '1', '-1', SYSDATE(), NULL, NULL, '0');

INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) 
VALUES (_tenantId, '98', '1', '1', '-1', SYSDATE(), NULL, NULL, '0');
INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, '98', '2', '1', '-1', SYSDATE(), NULL, NULL, '0');
INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, '98', '7', '1', '-1', SYSDATE(), NULL, NULL, '0');

	END IF;
	

IF NOT EXISTS (SELECT * FROM information_schema.statistics WHERE table_schema=DATABASE() AND table_name = 'declaration' AND index_name = 'customer_id_index') THEN
create index customer_id_index on declaration
(
   customer_id
);
END IF;

IF NOT EXISTS (select * from msg_template where code = 'c_view_product' and message_content = '客户$!{customerName}查看了$!{productType}类产品$!{productName}详情，渠道：$!{channel}，请及时跟进' and is_delete = 0) THEN
       update msg_template set message_content='客户$!{customerName}查看了$!{productType}类产品$!{productName}详情，渠道：$!{channel}，请及时跟进'
       ,app_content='客户$!{customerName}查看了$!{productType}类产品$!{productName}详情，渠道：$!{channel}，请及时跟进'
       ,params='{"productType":{"isBlank":false,"message":"产品类型不能为空"},"customerName":{"isBlank":false,"message":"客户名称不能为空"},"channel":{"isBlank":false,"message":"注册渠道不能为空"},"productName":{"isBlank":false,"message":"产品名称不能为空"},"customerId":{"isBlank":false,"message":"客户ID不能为空"}}' where code = 'c_view_product';
	END IF;

IF NOT EXISTS (select * from msg_template where code = 'c_reservation' and message_content = '客户$!{customerName}预约咨询$!{productType}类产品$!{productName}，渠道：$!{channel}，请及时跟进' and is_delete = 0) THEN
       update msg_template set message_content='客户$!{customerName}预约咨询了$!{productType}类产品$!{productName}，渠道：$!{channel}，请及时跟进'
			,app_content='客户$!{customerName}预约咨询了$!{productType}类产品$!{productName}，渠道：$!{channel}，请及时跟进'
			,params='{"productType":{"isBlank":false,"message":"产品类型不能为空"},"customerName":{"isBlank":false,"message":"客户名称不能为空"},"channel":{"isBlank":false,"message":"注册渠道不能为空"},"productName":{"isBlank":false,"message":"产品名称不能为空"},"customerId":{"isBlank":false,"message":"客户ID不能为空"}}'
			where code = 'c_reservation';
	END IF;

-- 消息模板
SELECT id INTO _msgReservationDiscard FROM msg_template WHERE code='reservation_asset_allocation';
IF _msgReservationDiscard IS NULL
THEN

INSERT INTO msg_template (tenant_id, title, feed_content, message_content, app_content, need_push, push_content, index_content, app_action, pc_action, code, params, remark, create_user_id, create_date, update_user_id, update_date, is_delete)
VALUES (_tenantId, '客户预约咨询资产配置', '客户预约咨询资产配置
测评结果：$!{testResult}，渠道：$!{channel}','客户$!{customerName}查看了资产配置方案并预约咨询产品配置，渠道：$!{channel}，请及时跟进','客户$!{customerName}查看了资产配置方案并预约咨询产品配置，渠道：$!{channel}，请及时跟进', 0, null, null, 'yundaojinfub://www.yundaocustomer.com/customer_detail?customerId=$!{customerId}', '/customer/detail/$!{customerId}', 'reservation_asset_allocation', '', '客户预约咨询资产配置', null, null, null, null, 0);
SET _msgReservationDiscard=LAST_INSERT_ID();

INSERT INTO msg_template_type (tenant_id, name, type, first_type, two_type, create_user_id, create_date, update_user_id, update_date, is_delete)
VALUES (_tenantId, '客户预约咨询资产配置', 2, 2, 8, null, sysdate(), null, null, 0);

INSERT INTO msg_template_type_ref (tenant_id, template_id, type_id, create_user_id, create_date, update_user_id, update_date, is_delete)
SELECT _tenantId,_msgReservationDiscard,id,null,sysdate(),null,null,0 FROM msg_template_type WHERE name='客户预约咨询资产配置' order by id desc limit 1;

INSERT INTO msg_template_type (tenant_id, name, type, first_type, two_type, create_user_id, create_date, update_user_id, update_date, is_delete)
VALUES (_tenantId, '客户预约咨询资产配置', 1, 1, 3, null, sysdate(), null, null, 0);

INSERT INTO msg_template_type_ref (tenant_id, template_id, type_id, create_user_id, create_date, update_user_id, update_date, is_delete)
SELECT _tenantId,_msgReservationDiscard,id,null,sysdate(),null,null,0 FROM msg_template_type WHERE name='客户预约咨询资产配置' order by id desc limit 1;

INSERT INTO msg_template_type (tenant_id, name, type, first_type, two_type, create_user_id, create_date, update_user_id, update_date, is_delete)
VALUES (_tenantId, '客户预约咨询资产配置', 2, 1, 8, null, sysdate(), null, null, 0);

INSERT INTO msg_template_type_ref (tenant_id, template_id, type_id, create_user_id, create_date, update_user_id, update_date, is_delete)
SELECT _tenantId,_msgReservationDiscard,id,null,sysdate(),null,null,0 FROM msg_template_type WHERE name='客户预约咨询资产配置' order by id desc limit 1;
END IF;


SELECT id INTO _msgReservationDiscard FROM msg_template WHERE code='view_asset_allocation';
IF _msgReservationDiscard IS NULL
THEN

INSERT INTO msg_template (tenant_id, title, feed_content, message_content, app_content, need_push, push_content, index_content, app_action, pc_action, code, params, remark, create_user_id, create_date, update_user_id, update_date, is_delete)
VALUES (_tenantId, '客户查看了资产配置方案', '客户查看了资产配置方案
测评结果：$!{testResult}，渠道：$!{channel}','客户$!{customerName}通过分享的资产配置工具页面查看了配置方案，结果：$!{testResult}，渠道：$!{channel}，请及时跟进','客户$!{customerName}通过分享的资产配置工具页面查看了配置方案，结果：$!{testResult}，渠道：$!{channel}，请及时跟进', 0, null, null, 'yundaojinfub://www.yundaocustomer.com/customer_detail?customerId=$!{customerId}', '/customer/detail/$!{customerId}', 'view_asset_allocation', '', '客户查看了资产配置方案', null, null, null, null, 0);
SET _msgReservationDiscard=LAST_INSERT_ID();

INSERT INTO msg_template_type (tenant_id, name, type, first_type, two_type, create_user_id, create_date, update_user_id, update_date, is_delete)
VALUES (_tenantId, '客户查看了资产配置方案', 2, 2, 8, null, sysdate(), null, null, 0);

INSERT INTO msg_template_type_ref (tenant_id, template_id, type_id, create_user_id, create_date, update_user_id, update_date, is_delete)
SELECT _tenantId,_msgReservationDiscard,id,null,sysdate(),null,null,0 FROM msg_template_type WHERE name='客户查看了资产配置方案' order by id desc limit 1;

INSERT INTO msg_template_type (tenant_id, name, type, first_type, two_type, create_user_id, create_date, update_user_id, update_date, is_delete)
VALUES (_tenantId, '客户查看了资产配置方案', 1, 1, 3, null, sysdate(), null, null, 0);

INSERT INTO msg_template_type_ref (tenant_id, template_id, type_id, create_user_id, create_date, update_user_id, update_date, is_delete)
SELECT _tenantId,_msgReservationDiscard,id,null,sysdate(),null,null,0 FROM msg_template_type WHERE name='客户查看了资产配置方案' order by id desc limit 1;
END IF;


/*产品要素 到期日期*/

IF NOT EXISTS (SELECT 1 FROM field WHERE code='product_maturity_date') THEN

INSERT INTO `field` (id,tenant_id,name,code,create_date) VALUES(116,_tenantId, '到期日期', 'product_maturity_date','2017-07-16 23:56:10');

INSERT INTO `object_field` 
(`tenant_id`, `business_object_id`, `field_id`, `description`, `field_type_id`, `is_fix`, `display_type`, `is_mandatory`, `is_basic`, `is_share`, `is_system`, `is_search`, `is_readonly`, `is_init`, `is_enabled`,can_edit_mandatory,can_edit_enabled,access, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) VALUES 
(_tenantId, '1',116, '到期日期', '4'/*类型*/, '0', '1', '0'/*是否必填*/, '1'/*是否基本属性*/, '1'/*是否通用*/, '1'/*是否系统*/, '1'/*is_search*/, '0'/*is_readonly*/, '1'/*is_init*/, '1'/*is_enabled*/,1/*是否能修改 必填 项*/,0/*是否能修改 启用 项*/,1/*access*/, '10'/*排序*/, '1', SYSDATE(), NULL, NULL, '0');

SELECT id INTO _objectFieldId FROM object_field WHERE field_id=116;

INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
SELECT _tenantId,id,_objectFieldId,0,-1,SYSDATE(),NULL,NULL,0 FROM field_group;

INSERT INTO `field_config` (`tenant_id`, `object_field_id`, `default_value`, `max_length`, `min_length`,max_value,min_value, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) 
VALUES (_tenantId, _objectFieldId/*到期日期 字段id*/, NULL, '200'/*最大长度*/, '0'/*最小长度*/, NULL/*最大值*/,NULL/*最小值*/,'1', SYSDATE(), NULL, NULL, '0');

END IF;

/*产品要素 到期日期*/



create table IF NOT EXISTS sys_config
(
   id                   bigint not null auto_increment comment '主键',
   tenant_id            bigint comment '租户id',
   code                 varchar(32) default '0' comment '编码',
   name                 varchar(32) comment '配置名称',
   params               varchar(1024) comment '参数',
   create_date          datetime comment '创建日期',
   create_user_id       bigint comment '创建者id',
   update_user_id       bigint comment '更新者id',
   update_date          datetime comment '更新日期',
   is_delete            tinyint(2) default 0 comment '是否删除，0：否，1：是',
   primary key (id)
);

alter table sys_config comment '系统配置';



IF NOT EXISTS (SELECT 1 FROM resource WHERE code='system.config.sale') THEN

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('106', _tenantId, 'system.config.sale', 'WM', '1', '销售管理配置', '/system/config/sale', '1', '1', '1', '销售管理配置', '30', '-1', SYSDATE(), NULL, NULL, '0');

INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (_tenantId, '106', '1', '1', '-1', SYSDATE(), NULL, NULL, '0');

END IF;





IF NOT EXISTS (SELECT 1 FROM sys_config WHERE code='sale') THEN
INSERT INTO `sys_config` (`tenant_id`, `code`, `name`, `params`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`) 
VALUES ( _tenantId, 'sale', '销售管理', '{\"opensea\":{\"takeLimitCount\":10,\"taktLimitEnable\":0}}',  SYSDATE(), NULL, NULL, NULL, '0');
END IF;

	IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'product' AND column_name = 'maturity_date') THEN
ALTER TABLE `product`
ADD COLUMN `maturity_date`  datetime NULL COMMENT '到期日期' AFTER `wx_content`;
END IF; 


IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'declaration' AND column_name = 'apply_date') THEN
ALTER TABLE `declaration`
ADD COLUMN `apply_date`  datetime NULL COMMENT '申请时间' AFTER `commit_date`;
UPDATE `declaration` set apply_date = create_date;
END IF;



UPDATE resource SET is_deplay=0 WHERE  id IN(23,43,44,71,24,46,47,48,50,70);




IF NOT EXISTS (select * from dictionary WHERE `value` = 'dic_conf_sale_opensea_limit') THEN

INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`) VALUES 
(_tenantId, '0', '是否限制公海客户领取上限', 'dic_conf_sale_opensea_limit', '1', '1', SYSDATE(), 1, '0');
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'限制上限','1','1', '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_conf_sale_opensea_limit';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'不限制','0','2', '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_conf_sale_opensea_limit';
END IF; 


IF NOT EXISTS (select * from dictionary where parent_id in (select id from dictionary WHERE `value` = 'dic_declaration_status') and value=0) THEN
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'未提交','0','0', '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_declaration_status';
END IF;


IF  EXISTS (select * from customer c where c.belong_type is null) THEN
   update customer set belong_type = 0  where id in (select customer_id from user_customer ) and belong_type is null;
   update customer set belong_type = 1  where  belong_type is null;
END IF;


/* 去掉跟进的数据权限 */
UPDATE data_object SET is_delete=1 WHERE code='follow';

UPDATE data_object_init doi,data_object do SET doi.is_delete=1 WHERE doi.data_object_id=do.id AND do.code='follow';

UPDATE data_object_access doa,data_object do SET doa.is_delete=1 WHERE doa.data_object_id=do.id AND do.code='follow';


	IF NOT EXISTS (select * from role_resource where role_id = 7 and resource_id = 87 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( tenant_id,`resource_id`, `role_id`) VALUES (_tenantId,87, 7);
	END IF;

	IF NOT EXISTS (select * from role_resource where role_id = 7 and resource_id = 88 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( tenant_id,`resource_id`, `role_id`) VALUES (_tenantId,88, 7);
	END IF;

	IF NOT EXISTS (select * from role_resource where role_id = 7 and resource_id = 89 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( tenant_id,`resource_id`, `role_id`) VALUES (_tenantId,89, 7);
	END IF;

	IF NOT EXISTS (select * from role_resource where role_id = 7 and resource_id = 90 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( tenant_id,`resource_id`, `role_id`) VALUES (_tenantId,90, 7);
	END IF;
	
	
	
	
IF  EXISTS (select * from dictionary d LEFT JOIN dictionary p on d.parent_id = p.id where d.`value` = 5 and p.`value` = 'dic_product_issued_status') THEN
     update dictionary set label = '存续/封闭中' where `value` = 5 and parent_id in (
		    select id from (
		   select id from dictionary p where p.`value` = 'dic_product_issued_status'
		   )a
		);
 END IF; 

end;

call tenant_sql_update_1_2();

DROP PROCEDURE if exists tenant_sql_update_1_2;
























DROP PROCEDURE if exists tenant_sql_update_1_2;

create procedure tenant_sql_update_1_2()
begin

DECLARE _tenantId BIGINT;

DECLARE _product_typeId BIGINT;

DECLARE _risk_ratingId BIGINT;

SELECT tenant_id INTO _tenantId FROM user_account LIMIT 1;

IF NOT EXISTS (SELECT * FROM resource WHERE id=99)
THEN
INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (99, _tenantId , 'report', 'WM', '0', '数据报表(APP)', '/report/', '1', '1', 0, '数据报表(APP)', '1060', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

IF NOT EXISTS (SELECT * FROM resource WHERE id=100)
THEN
INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (100, _tenantId , 'report.declaration.company', 'WM', '99', '公司业绩走势', '/report/declaration/company/', '1', '1', 0, '数据报表(APP)-->公司业绩走势', '10', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

IF NOT EXISTS (SELECT * FROM resource WHERE id=101)
THEN
INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (101, _tenantId , 'report.declaration.user.top', 'WM', '99', '员工业绩Top榜', '/report/declaration/user/top', '1', '1', 0, '数据报表(APP)-->员工业绩Top榜', '20', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

IF NOT EXISTS (SELECT * FROM resource WHERE id=102)
THEN
INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (102, _tenantId , 'report.declaration', 'WM', '99', '业绩报表', '/report/declaration', '1', '1', 0, '数据报表(APP)-->业绩报表', '30', '-1', SYSDATE(), NULL, NULL, '0');
END IF;


IF NOT EXISTS (SELECT * FROM resource WHERE id=103)
THEN
INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (103, _tenantId , 'report.declaration.department', 'WM', '102', '部门业绩', '/report/declaration/department', '0', '1', 0, '数据报表(APP)-->业绩报表-->部门业绩', '10', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

IF NOT EXISTS (SELECT * FROM resource WHERE id=104)
THEN
INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (104, _tenantId , 'report.declaration.user', 'WM', '102', '员工业绩', '/report/declaration/user', '0', '1', 0, '数据报表(APP)-->业绩报表-->员工业绩', '20', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

IF NOT EXISTS (SELECT * FROM resource WHERE id=105)
THEN
INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (105, _tenantId , 'report.declaration.customer', 'WM', '99', '客户成交', '/report/declaration/customer', '1', '1', 0, '数据报表(APP)-->客户成交', '50', '-1', SYSDATE(), NULL, NULL, '0');
END IF;


IF NOT EXISTS (SELECT * FROM resource WHERE id=107)
THEN
INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (107, _tenantId , 'cms.roadshow.list', 'WM', '87', '路演内容配置', '/cms/roadshow/list', '1', '1', 1, '内容配置-->路演内容配置', '60', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

IF NOT EXISTS (SELECT * FROM resource WHERE id=108)
THEN
INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (108, _tenantId , 'cms.roadshow.column', 'WM', '87', '路演栏目配置', '/cms/roadshow/column', '1', '1', 1, '内容配置-->路演栏目配置', '50', '-1', SYSDATE(), NULL, NULL, '0');
END IF;


IF NOT EXISTS (SELECT * FROM resource WHERE id=109)
THEN
INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (109, _tenantId , 'cms.video.list', 'WM', '87', '路演视频管理', '/cms/video/list', '1', '1', 1, '内容配置-->路演视频管理', '70', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 99 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (99, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 100 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (100, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 101 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (101, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 102 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (102, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 103 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (103, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 104 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (104, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 105 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (105, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 107 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (107, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 108 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (108, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 109 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (109, 1);
	END IF;
	
	
	
	
	/*新增数据对象（以下脚本为新增 跟进）*/
	IF NOT EXISTS (select * from data_object where id = 14 and is_delete=0) THEN
        INSERT INTO `data_object` (`id`, `tenant_id`, `name`, `code`, `description`, `sequence`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`) 
	        VALUES ('14', _tenantId, '业绩报表(APP)', 'report', NULL, '140', '2017-11-03 11:49:40', '1', NULL, NULL, '0');
	END IF;
	
	
	/*设置数据权限的 初始数据 （以下脚本示例为 数据报表）*/
	IF NOT EXISTS (select * from data_object_init where data_object_id = 14 and operation = 0 and permission=0  and is_delete=0) THEN
	   	INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`) 
	       SELECT id,0/*读取*/,0,1,1,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='report';
	END IF;

	IF NOT EXISTS (select * from data_object_init where data_object_id = 14 and operation = 0 and permission=10 and is_delete=0) THEN
	INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`) 
	SELECT id,0/*读取*/,10,2,0,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='report';
	END IF;
	
	IF NOT EXISTS (select * from data_object_init where data_object_id = 14 and operation = 0 and permission=30 and is_delete=0) THEN
	INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`) 
	SELECT id,0/*读取*/,30,3,0,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='report';
	END IF;
	
	IF NOT EXISTS (select * from data_object_init where data_object_id = 14 and operation = 0 and permission=40 and is_delete=0) THEN
	INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`) 
	SELECT id,0/*读取*/,40,4,0,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='report';
	END IF;
	
	
	update data_object_init set tenant_id = _tenantId where tenant_id is null;
	
	/*设置每个角色对应的数据权限 数据报表 角色*/
	IF NOT EXISTS (select * from data_object_access where data_object_id = 14 and role_id = 1 and is_delete=0) THEN
	INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
	VALUES('14',/*role_id*/'1',/*read*/'40',/*delete*/'40',/*edit*/'40',_tenantId,'2017-07-25 14:35:16','1','1','2017-07-25 14:35:16','0');
	END IF;
	
	/*添加视频相关数据字典*/
	IF NOT EXISTS (select * from dictionary d where d.`value` = 'dic_video_status') THEN
      insert INTO dictionary(tenant_id,parent_id,label,value)VALUES(_tenantId,0,'视频压缩状态','dic_video_status');
    END IF; 
 
    IF NOT EXISTS (select * from dictionary d LEFT JOIN dictionary p on d.parent_id = p.id where d.`value` = 0 and p.`value` = 'dic_video_status') THEN
      insert INTO dictionary(tenant_id,parent_id,label,value) select _tenantId,id,'压缩中','0' FROM dictionary where value='dic_video_status' limit 1;
    END IF; 
 
    IF NOT EXISTS (select * from dictionary d LEFT JOIN dictionary p on d.parent_id = p.id where d.`value` = 1 and p.`value` = 'dic_video_status') THEN
      insert INTO dictionary(tenant_id,parent_id,label,value) select _tenantId,id,'压缩完成','1' FROM dictionary where value='dic_video_status' limit 1;
    END IF; 
    
    /*添加路演栏目状态数据字典*/
	IF NOT EXISTS (select * from dictionary d where d.`value` = 'dic_roadshow_column_status') THEN
      insert INTO dictionary(tenant_id,parent_id,label,value)VALUES(_tenantId,0,'路演栏目状态','dic_roadshow_column_status');
    END IF; 
 
    IF NOT EXISTS (select * from dictionary d LEFT JOIN dictionary p on d.parent_id = p.id where d.`value` = 0 and p.`value` = 'dic_roadshow_column_status') THEN
      insert INTO dictionary(tenant_id,parent_id,label,value) select _tenantId,id,'停用','0' FROM dictionary where value='dic_roadshow_column_status' limit 1;
    END IF; 
 
    IF NOT EXISTS (select * from dictionary d LEFT JOIN dictionary p on d.parent_id = p.id where d.`value` = 1 and p.`value` = 'dic_roadshow_column_status') THEN
      insert INTO dictionary(tenant_id,parent_id,label,value) select _tenantId,id,'启用','1' FROM dictionary where value='dic_roadshow_column_status' limit 1;
    END IF; 
    

    
create table IF NOT EXISTS aa_product_type
(
   id                    bigint not null auto_increment comment '主键',
   code                 varchar(128) comment '编号',
   name                 varchar(128) comment '名称',
   tenant_id            bigint comment '租户id',
   create_date          datetime comment '创建日期',
   create_user_id       bigint comment '创建者id',
   update_user_id       bigint comment '更新者id',
   update_date          datetime comment '更新日期',
   is_delete            tinyint(2) default 0 comment '是否删除，0：否，1：是',
   primary key (id)
);

alter table aa_product_type comment '资产配置 产品类型';



create table IF NOT EXISTS aa_product_type_risk_rating
(
   id                    bigint not null auto_increment comment '主键',
   tenant_id            bigint comment '租户id',
   product_type_id      bigint comment '产品类型id',
   risk_rating_id       bigint comment '风险评测类型id',
   rate                 double comment '性质',
   create_date          datetime comment '创建日期',
   create_user_id       bigint comment '创建者id',
   update_user_id       bigint comment '更新者id',
   update_date          datetime comment '更新日期',
   is_delete            tinyint(2) default 0 comment '是否删除，0：否，1：是',
   primary key (id)
);

create table IF NOT EXISTS aa_question_answer
(
   id                    bigint not null auto_increment comment '主键',
   tenant_id            bigint comment '租户id',
   question_id          bigint comment '问答id',
   option_id            bigint comment '选项id',
   score_id             bigint comment '答题成绩id',
   question_type_id     bigint(20)  COMMENT '题目类型',
   content              varchar(512) comment '答题文本，当问题类型为“文本”时填写',
   create_date          datetime comment '创建日期',
   create_user_id       bigint comment '创建者id',
   update_user_id       bigint comment '更新者id',
   update_date          datetime comment '更新日期',
   is_delete            tinyint(2) default 0 comment '是否删除，0：否，1：是',
   primary key (id)
);

alter table aa_question_answer comment '理财师帮客户测评';


create table IF NOT EXISTS aa_question_score
(
   id                   bigint not null auto_increment,
   user_id              bigint comment '用户id',
   customer_id          bigint comment '客户id',
   grade                int comment '得分',
   create_date          datetime comment '创建日期',
   create_user_id       bigint comment '创建者id',
   update_user_id       bigint comment '更新者id',
   update_date          datetime comment '更新日期',
   is_delete            tinyint(2) default 0 comment '是否删除，0：否，1：是',
   primary key (id)
);

    IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'aa_question_score' AND column_name = 'question_type_id') THEN
		ALTER TABLE `aa_question_score`
		ADD COLUMN `question_type_id`  bigint(20) NULL COMMENT '题目类型' AFTER `create_date`;
	END IF; 


create table IF NOT EXISTS aa_product_ref
(
   id                   bigint not null auto_increment,
   tenant_id            bigint comment '租户id',
   score_id             bigint comment '成绩id',
   product_id           bigint comment '产品id',
   create_date          datetime comment '创建日期',
   create_user_id       bigint comment '创建者id',
   update_user_id       bigint comment '更新者id',
   update_date          datetime comment '更新日期',
   is_delete            tinyint(2) default 0 comment '是否删除，0：否，1：是',
   primary key (id)
);

alter table aa_product_ref comment '理财师测评关联产品';
    
    
update cc_risk_rating set `comment` = '建议您的资产配置中以保障类，现金管理类为主，类固定收益类资产配置不益超过25%，对股权类产品需要非常谨慎，不益超过整个资产组合的5%。' where `value` = 1;
update cc_risk_rating set `comment` = '建议您的资产配置中以保障类，现金管理类为主，类固定收益类资产配置不益超过40%，股权类产品资产配置不益超15%。' where `value` = 2;
update cc_risk_rating set `comment` = '建议您的资产配置在各大资产种类里比较平衡分配，保障类，现金管理类资产配置在30%，类固定收益类资产配置在40%，股权等其他类资产配置在30%。' where `value` = 3;
update cc_risk_rating set `comment` = '建议您的资产配置中以股权和夹层投资等为主，保障类，现金管理类资产配置在15%，类固定收益类资产配置在35%，股权等其他类资产配置在50%。' where `value` = 4;
update cc_risk_rating set `comment` = '建议在您的资产配置中以股权投资为主，保障类，现金管理类资产配置在10%以内，类固定收益类资产配置在25%，股权类和另类投资类资产配置在65%以上。' where `value` = 5;

    IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'cc_risk_rating' AND column_name = 'img_description') THEN
	    ALTER TABLE `cc_risk_rating`
        ADD COLUMN `img_description`  varchar(250) NULL COMMENT '图片描述信息' AFTER `comment`;
	END IF; 
	
	
	IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'cc_risk_rating' AND column_name = 'portfolio_income') THEN
	    ALTER TABLE `cc_risk_rating`
            ADD COLUMN `portfolio_income`  double NULL COMMENT '组合收益' AFTER `img_description`;
	END IF; 
	
	IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'cc_risk_rating' AND column_name = 'portfolio_risk') THEN
	   ALTER TABLE `cc_risk_rating`
           ADD COLUMN `portfolio_risk`  double NULL COMMENT '组合风险' AFTER `portfolio_income`;
	END IF; 
	
	

update cc_risk_rating set img_description = '如图在95%的置信区间下获取预期收益时左右波动（风险）较低' where `value` = 1;
update cc_risk_rating set img_description = '如图在95%的置信区间下获取预期收益时左右波动（风险）较低到中等' where `value` = 2;
update cc_risk_rating set img_description = '如图在95%的置信区间下获取预期收益时左右波动（风险）中等' where `value` = 3;
update cc_risk_rating set img_description = '如图在95%的置信区间下获取预期收益时左右波动（风险）较高' where `value` = 4;
update cc_risk_rating set img_description = '如图在95%的置信区间下获取预期收益时左右波动（风险）高' where `value` = 5;





update cc_risk_rating set portfolio_income = 5.7 , portfolio_risk = 1.7 where `value` = 1;
update cc_risk_rating set portfolio_income = 9.4 , portfolio_risk = 2.5 where `value` = 2;
update cc_risk_rating set portfolio_income = 13.7 , portfolio_risk = 3.5 where `value` = 3;
update cc_risk_rating set portfolio_income = 20.5 , portfolio_risk = 4.1 where `value` = 4;
update cc_risk_rating set portfolio_income = 30.4 , portfolio_risk = 4.7 where `value` = 5;

IF NOT EXISTS (select * from aa_product_type p where p.`code` = 'product_type_cash') THEN
	  INSERT INTO `aa_product_type` (`code`, `name`, `tenant_id`, `is_delete`) VALUES ('product_type_cash', '现金管理类', _tenantId, 0);
END IF; 
IF NOT EXISTS (select * from aa_product_type p where p.`code` = 'product_type_fix') THEN
	  INSERT INTO `aa_product_type` (`code`, `name`, `tenant_id`, `is_delete`) VALUES ('product_type_fix', '类固定收益类', _tenantId, 0);
END IF; 
IF NOT EXISTS (select * from aa_product_type p where p.`code` = 'product_type_private') THEN
	  INSERT INTO `aa_product_type` (`code`, `name`, `tenant_id`, `is_delete`) VALUES ('product_type_private', '阳光私募类', _tenantId, 0);
END IF;
IF NOT EXISTS (select * from aa_product_type p where p.`code` = 'product_type_stock') THEN
	 INSERT INTO `aa_product_type` (`code`, `name`, `tenant_id`, `is_delete`) VALUES ('product_type_stock', '权益/另类投资类', _tenantId, 0);
END IF;
IF NOT EXISTS (select * from aa_product_type p where p.`code` = 'product_type_sea') THEN
	 INSERT INTO `aa_product_type` (`code`, `name`, `tenant_id`, `is_delete`) VALUES ('product_type_sea', '海外投资类', _tenantId, 0);
END IF;

update aa_product_type set name = '阳光私募类' where code = 'product_type_private';
	
	IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'cc_risk_rating' AND column_name = 'img_url') THEN
	   ALTER TABLE `cc_risk_rating`
           ADD COLUMN `img_url`  varchar(250) NULL COMMENT '图片url' AFTER `img_description`;
	END IF; 


	
update cc_risk_rating set img_url = 'https://file.yundaojishu.com/335e12500764449f96b50ed0805c3428.png' where `value` = 1;
update cc_risk_rating set img_url = 'https://file.yundaojishu.com/242285d9adfe461ba85d5af182dcf70d.png' where `value` = 2;
update cc_risk_rating set img_url = 'https://file.yundaojishu.com/cb69420de5d642a98178ad58d92cf285.png' where `value` = 3;
update cc_risk_rating set img_url = 'https://file.yundaojishu.com/5f52632e4dcd44b6b0eea46e08a37378.png' where `value` = 4;
update cc_risk_rating set img_url = 'https://file.yundaojishu.com/52eecdd4a274484c91c9647db668db12.png' where `value` = 5;
	

-- 保守型
SELECT id  INTO _product_typeId FROM aa_product_type where `code` = 'product_type_cash' and is_delete = 0  LIMIT 1;
select id  INTO _risk_ratingId from cc_risk_rating where `value` = 1 and is_delete = 0 LIMIT 1;
IF NOT EXISTS (select * from aa_product_type_risk_rating aa where aa.product_type_id=_product_typeId and aa.risk_rating_id=_risk_ratingId and aa.is_delete = 0) THEN
	INSERT INTO `aa_product_type_risk_rating` (`tenant_id`, `product_type_id`, `risk_rating_id`, `rate`, `is_delete`) 
	VALUES (_tenantId, _product_typeId, _risk_ratingId, 60, 0);
END IF; 


SELECT id  INTO _product_typeId FROM aa_product_type where `code` = 'product_type_fix' and is_delete = 0  LIMIT 1;
select id  INTO _risk_ratingId from cc_risk_rating where `value` = 1 and is_delete = 0 LIMIT 1;
IF NOT EXISTS (select * from aa_product_type_risk_rating aa where aa.product_type_id=_product_typeId and aa.risk_rating_id=_risk_ratingId and aa.is_delete = 0) THEN
	INSERT INTO `aa_product_type_risk_rating` (`tenant_id`, `product_type_id`, `risk_rating_id`, `rate`, `is_delete`) 
	VALUES (_tenantId, _product_typeId, _risk_ratingId, 30, 0);
END IF;


SELECT id  INTO _product_typeId FROM aa_product_type where `code` = 'product_type_private'  and is_delete = 0 LIMIT 1;
select id  INTO _risk_ratingId from cc_risk_rating where `value` = 1 and is_delete = 0 LIMIT 1;
IF NOT EXISTS (select * from aa_product_type_risk_rating aa where aa.product_type_id=_product_typeId and aa.risk_rating_id=_risk_ratingId and aa.is_delete = 0) THEN
	INSERT INTO `aa_product_type_risk_rating` (`tenant_id`, `product_type_id`, `risk_rating_id`, `rate`, `is_delete`) 
	VALUES (_tenantId, _product_typeId, _risk_ratingId, 10, 0);
END IF;

SELECT id  INTO _product_typeId FROM aa_product_type where `code` = 'product_type_stock' and is_delete = 0  LIMIT 1;
select id  INTO _risk_ratingId from cc_risk_rating where `value` = 1 and is_delete = 0 LIMIT 1;
IF NOT EXISTS (select * from aa_product_type_risk_rating aa where aa.product_type_id=_product_typeId and aa.risk_rating_id=_risk_ratingId and aa.is_delete = 0) THEN
	INSERT INTO `aa_product_type_risk_rating` (`tenant_id`, `product_type_id`, `risk_rating_id`, `rate`, `is_delete`) 
	VALUES (_tenantId, _product_typeId, _risk_ratingId, 0, 0);
END IF;

SELECT id  INTO _product_typeId FROM aa_product_type where `code` = 'product_type_sea' and is_delete = 0 LIMIT 1;
select id  INTO _risk_ratingId from cc_risk_rating where `value` = 1 and is_delete = 0 LIMIT 1;
IF NOT EXISTS (select * from aa_product_type_risk_rating aa where aa.product_type_id=_product_typeId and aa.risk_rating_id=_risk_ratingId and aa.is_delete = 0) THEN
	INSERT INTO `aa_product_type_risk_rating` (`tenant_id`, `product_type_id`, `risk_rating_id`, `rate`, `is_delete`) 
	VALUES (_tenantId, _product_typeId, _risk_ratingId, 0, 0);
END IF;




-- 适度保守型
SELECT id  INTO _product_typeId FROM aa_product_type where `code` = 'product_type_cash' and is_delete = 0 LIMIT 1;
select id  INTO _risk_ratingId from cc_risk_rating where `value` = 2  and is_delete = 0 LIMIT 1;
IF NOT EXISTS (select * from aa_product_type_risk_rating aa where aa.product_type_id=_product_typeId and aa.risk_rating_id=_risk_ratingId and aa.is_delete = 0) THEN
	INSERT INTO `aa_product_type_risk_rating` (`tenant_id`, `product_type_id`, `risk_rating_id`, `rate`, `is_delete`) 
	VALUES (_tenantId, _product_typeId, _risk_ratingId, 30, 0);
END IF; 


SELECT id  INTO _product_typeId FROM aa_product_type where `code` = 'product_type_fix' and is_delete = 0 LIMIT 1;
IF NOT EXISTS (select * from aa_product_type_risk_rating aa where aa.product_type_id=_product_typeId and aa.risk_rating_id=_risk_ratingId and aa.is_delete = 0) THEN
	INSERT INTO `aa_product_type_risk_rating` (`tenant_id`, `product_type_id`, `risk_rating_id`, `rate`, `is_delete`) 
	VALUES (_tenantId, _product_typeId, _risk_ratingId, 40, 0);
END IF;


SELECT id  INTO _product_typeId FROM aa_product_type where `code` = 'product_type_private' and is_delete = 0 LIMIT 1;
IF NOT EXISTS (select * from aa_product_type_risk_rating aa where aa.product_type_id=_product_typeId and aa.risk_rating_id=_risk_ratingId and aa.is_delete = 0) THEN
	INSERT INTO `aa_product_type_risk_rating` (`tenant_id`, `product_type_id`, `risk_rating_id`, `rate`, `is_delete`) 
	VALUES (_tenantId, _product_typeId, _risk_ratingId, 10, 0);
END IF;

SELECT id  INTO _product_typeId FROM aa_product_type where `code` = 'product_type_stock' and is_delete = 0 LIMIT 1;
IF NOT EXISTS (select * from aa_product_type_risk_rating aa where aa.product_type_id=_product_typeId and aa.risk_rating_id=_risk_ratingId and aa.is_delete = 0) THEN
	INSERT INTO `aa_product_type_risk_rating` (`tenant_id`, `product_type_id`, `risk_rating_id`, `rate`, `is_delete`) 
	VALUES (_tenantId, _product_typeId, _risk_ratingId, 10, 0);
END IF;

SELECT id  INTO _product_typeId FROM aa_product_type where `code` = 'product_type_sea' and is_delete = 0 LIMIT 1;
IF NOT EXISTS (select * from aa_product_type_risk_rating aa where aa.product_type_id=_product_typeId and aa.risk_rating_id=_risk_ratingId and aa.is_delete = 0) THEN
	INSERT INTO `aa_product_type_risk_rating` (`tenant_id`, `product_type_id`, `risk_rating_id`, `rate`, `is_delete`) 
	VALUES (_tenantId, _product_typeId, _risk_ratingId, 10, 0);
END IF;

-- 平衡型
SELECT id  INTO _product_typeId FROM aa_product_type where `code` = 'product_type_cash' and is_delete = 0 LIMIT 1;
select id  INTO _risk_ratingId from cc_risk_rating where `value` = 3  and is_delete = 0 LIMIT 1;
IF NOT EXISTS (select * from aa_product_type_risk_rating aa where aa.product_type_id=_product_typeId and aa.risk_rating_id=_risk_ratingId and aa.is_delete = 0) THEN
	INSERT INTO `aa_product_type_risk_rating` (`tenant_id`, `product_type_id`, `risk_rating_id`, `rate`, `is_delete`) 
	VALUES (_tenantId, _product_typeId, _risk_ratingId, 25, 0);
END IF; 


SELECT id  INTO _product_typeId FROM aa_product_type where `code` = 'product_type_fix' and is_delete = 0 LIMIT 1;
IF NOT EXISTS (select * from aa_product_type_risk_rating aa where aa.product_type_id=_product_typeId and aa.risk_rating_id=_risk_ratingId and aa.is_delete = 0) THEN
	INSERT INTO `aa_product_type_risk_rating` (`tenant_id`, `product_type_id`, `risk_rating_id`, `rate`, `is_delete`) 
	VALUES (_tenantId, _product_typeId, _risk_ratingId, 30, 0);
END IF;


SELECT id  INTO _product_typeId FROM aa_product_type where `code` = 'product_type_private' and is_delete = 0 LIMIT 1;
IF NOT EXISTS (select * from aa_product_type_risk_rating aa where aa.product_type_id=_product_typeId and aa.risk_rating_id=_risk_ratingId and aa.is_delete = 0) THEN
	INSERT INTO `aa_product_type_risk_rating` (`tenant_id`, `product_type_id`, `risk_rating_id`, `rate`, `is_delete`) 
	VALUES (_tenantId, _product_typeId, _risk_ratingId, 20, 0);
END IF;

SELECT id  INTO _product_typeId FROM aa_product_type where `code` = 'product_type_stock' and is_delete = 0 LIMIT 1;
IF NOT EXISTS (select * from aa_product_type_risk_rating aa where aa.product_type_id=_product_typeId and aa.risk_rating_id=_risk_ratingId and aa.is_delete = 0) THEN
	INSERT INTO `aa_product_type_risk_rating` (`tenant_id`, `product_type_id`, `risk_rating_id`, `rate`, `is_delete`) 
	VALUES (_tenantId, _product_typeId, _risk_ratingId, 15, 0);
END IF;

SELECT id  INTO _product_typeId FROM aa_product_type where `code` = 'product_type_sea' and is_delete = 0 LIMIT 1;
IF NOT EXISTS (select * from aa_product_type_risk_rating aa where aa.product_type_id=_product_typeId and aa.risk_rating_id=_risk_ratingId and aa.is_delete = 0) THEN
	INSERT INTO `aa_product_type_risk_rating` (`tenant_id`, `product_type_id`, `risk_rating_id`, `rate`, `is_delete`) 
	VALUES (_tenantId, _product_typeId, _risk_ratingId, 10, 0);
END IF;




--  适度进取型
SELECT id  INTO _product_typeId FROM aa_product_type where `code` = 'product_type_cash' and is_delete = 0 LIMIT 1;
select id  INTO _risk_ratingId from cc_risk_rating where `value` = 4  and is_delete = 0 LIMIT 1;
IF NOT EXISTS (select * from aa_product_type_risk_rating aa where aa.product_type_id=_product_typeId and aa.risk_rating_id=_risk_ratingId and aa.is_delete = 0) THEN
	INSERT INTO `aa_product_type_risk_rating` (`tenant_id`, `product_type_id`, `risk_rating_id`, `rate`, `is_delete`) 
	VALUES (_tenantId, _product_typeId, _risk_ratingId, 15, 0);
END IF; 


SELECT id  INTO _product_typeId FROM aa_product_type where `code` = 'product_type_fix' and is_delete = 0 LIMIT 1;
IF NOT EXISTS (select * from aa_product_type_risk_rating aa where aa.product_type_id=_product_typeId and aa.risk_rating_id=_risk_ratingId and aa.is_delete = 0) THEN
	INSERT INTO `aa_product_type_risk_rating` (`tenant_id`, `product_type_id`, `risk_rating_id`, `rate`, `is_delete`) 
	VALUES (_tenantId, _product_typeId, _risk_ratingId, 25, 0);
END IF;


SELECT id  INTO _product_typeId FROM aa_product_type where `code` = 'product_type_private' and is_delete = 0 LIMIT 1;
IF NOT EXISTS (select * from aa_product_type_risk_rating aa where aa.product_type_id=_product_typeId and aa.risk_rating_id=_risk_ratingId and aa.is_delete = 0) THEN
	INSERT INTO `aa_product_type_risk_rating` (`tenant_id`, `product_type_id`, `risk_rating_id`, `rate`, `is_delete`) 
	VALUES (_tenantId, _product_typeId, _risk_ratingId, 20, 0);
END IF;

SELECT id  INTO _product_typeId FROM aa_product_type where `code` = 'product_type_stock' and is_delete = 0 LIMIT 1;
IF NOT EXISTS (select * from aa_product_type_risk_rating aa where aa.product_type_id=_product_typeId and aa.risk_rating_id=_risk_ratingId and aa.is_delete = 0) THEN
	INSERT INTO `aa_product_type_risk_rating` (`tenant_id`, `product_type_id`, `risk_rating_id`, `rate`, `is_delete`) 
	VALUES (_tenantId, _product_typeId, _risk_ratingId, 30, 0);
END IF;

SELECT id  INTO _product_typeId FROM aa_product_type where `code` = 'product_type_sea' and is_delete = 0 LIMIT 1;
IF NOT EXISTS (select * from aa_product_type_risk_rating aa where aa.product_type_id=_product_typeId and aa.risk_rating_id=_risk_ratingId and aa.is_delete = 0) THEN
	INSERT INTO `aa_product_type_risk_rating` (`tenant_id`, `product_type_id`, `risk_rating_id`, `rate`, `is_delete`) 
	VALUES (_tenantId, _product_typeId, _risk_ratingId, 10, 0);
END IF;


-- 进取型
SELECT id  INTO _product_typeId FROM aa_product_type where `code` = 'product_type_cash' and is_delete = 0 LIMIT 1;
select id  INTO _risk_ratingId from cc_risk_rating where `value` = 5  and is_delete = 0 LIMIT 1;
IF NOT EXISTS (select * from aa_product_type_risk_rating aa where aa.product_type_id=_product_typeId and aa.risk_rating_id=_risk_ratingId and aa.is_delete = 0) THEN
	INSERT INTO `aa_product_type_risk_rating` (`tenant_id`, `product_type_id`, `risk_rating_id`, `rate`, `is_delete`) 
	VALUES (_tenantId, _product_typeId, _risk_ratingId, 10, 0);
END IF; 


SELECT id  INTO _product_typeId FROM aa_product_type where `code` = 'product_type_fix' and is_delete = 0 LIMIT 1;
IF NOT EXISTS (select * from aa_product_type_risk_rating aa where aa.product_type_id=_product_typeId and aa.risk_rating_id=_risk_ratingId and aa.is_delete = 0) THEN
	INSERT INTO `aa_product_type_risk_rating` (`tenant_id`, `product_type_id`, `risk_rating_id`, `rate`, `is_delete`) 
	VALUES (_tenantId, _product_typeId, _risk_ratingId, 20, 0);
END IF;


SELECT id  INTO _product_typeId FROM aa_product_type where `code` = 'product_type_private' and is_delete = 0 LIMIT 1;
IF NOT EXISTS (select * from aa_product_type_risk_rating aa where aa.product_type_id=_product_typeId and aa.risk_rating_id=_risk_ratingId and aa.is_delete = 0) THEN
	INSERT INTO `aa_product_type_risk_rating` (`tenant_id`, `product_type_id`, `risk_rating_id`, `rate`, `is_delete`) 
	VALUES (_tenantId, _product_typeId, _risk_ratingId, 20, 0);
END IF;

SELECT id  INTO _product_typeId FROM aa_product_type where `code` = 'product_type_stock' and is_delete = 0 LIMIT 1;
IF NOT EXISTS (select * from aa_product_type_risk_rating aa where aa.product_type_id=_product_typeId and aa.risk_rating_id=_risk_ratingId and aa.is_delete = 0) THEN
	INSERT INTO `aa_product_type_risk_rating` (`tenant_id`, `product_type_id`, `risk_rating_id`, `rate`, `is_delete`) 
	VALUES (_tenantId, _product_typeId, _risk_ratingId, 50, 0);
END IF;

SELECT id  INTO _product_typeId FROM aa_product_type where `code` = 'product_type_sea' and is_delete = 0 LIMIT 1;
IF NOT EXISTS (select * from aa_product_type_risk_rating aa where aa.product_type_id=_product_typeId and aa.risk_rating_id=_risk_ratingId and aa.is_delete = 0) THEN
	INSERT INTO `aa_product_type_risk_rating` (`tenant_id`, `product_type_id`, `risk_rating_id`, `rate`, `is_delete`) 
	VALUES (_tenantId, _product_typeId, _risk_ratingId, 0, 0);
END IF;


CREATE TABLE IF NOT EXISTS video(
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `name` varchar(32) DEFAULT NULL COMMENT '视频名称',
  `file_name` varchar(32) DEFAULT NULL COMMENT '文件名',
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

CREATE TABLE IF NOT EXISTS `video_category` (
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

CREATE TABLE IF NOT EXISTS `video_transcode` (
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

CREATE TABLE IF NOT EXISTS `roadshow` (
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

CREATE TABLE IF NOT EXISTS `roadshow_column` (
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

CREATE TABLE IF NOT EXISTS `roadshow_column_rel` (
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

CREATE TABLE IF NOT EXISTS `roadshow_product_rel` (
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

 IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'user_detail' AND column_name = 'card_header_bit') THEN
	     ALTER TABLE `user_detail`
          ADD COLUMN `card_header_bit`  VARCHAR(200) NULL COMMENT '理财师名片头衔' AFTER `card_introduce`;
          
	END IF; 
	
	--  修改文件域名
	UPDATE article set cover_url=REPLACE(cover_url,'file.yundaojinfu.com','file.yundaojishu.com');
	UPDATE article_column set cover_url=REPLACE(cover_url,'file.yundaojinfu.com','file.yundaojishu.com');
	UPDATE cc_risk_rating set img_url=REPLACE(img_url,'file.yundaojinfu.com','file.yundaojishu.com') ; 
	UPDATE cloud_file set url=REPLACE(url,'file.yundaojinfu.com','file.yundaojishu.com') ; 
	UPDATE customer_attach set url=REPLACE(url,'file.yundaojinfu.com','file.yundaojishu.com') ; 
	UPDATE customer_bank set front=REPLACE(front,'file.yundaojinfu.com','file.yundaojishu.com'),back=REPLACE(back,'file.yundaojinfu.com','file.yundaojishu.com') ; 
    UPDATE customer_credentials set front=REPLACE(front,'file.yundaojinfu.com','file.yundaojishu.com'),back=REPLACE(back,'file.yundaojinfu.com','file.yundaojishu.com') ;
	UPDATE declaration_attach set url=REPLACE(url,'file.yundaojinfu.com','file.yundaojishu.com'); 
    UPDATE declaration_compliance set url=REPLACE(url,'file.yundaojinfu.com','file.yundaojishu.com'); 
    UPDATE product_attach set url=REPLACE(url,'file.yundaojinfu.com','file.yundaojishu.com'); 
    UPDATE product_notice_attach set url=REPLACE(url,'file.yundaojinfu.com','file.yundaojishu.com'); 
    UPDATE roadshow set cover_url=REPLACE(cover_url,'file.yundaojinfu.com','file.yundaojishu.com'); 
    UPDATE video set cover_url=REPLACE(cover_url,'file.yundaojinfu.com','file.yundaojishu.com'); 
    UPDATE video_transcode set url=REPLACE(url,'file.yundaojinfu.com','file.yundaojishu.com'); 



     alter table video MODIFY name varchar(100) DEFAULT NULL COMMENT '视频名称';
     alter table video MODIFY file_name varchar(100) DEFAULT NULL COMMENT '文件名';
     UPDATE dictionary d,dictionary d2 set d.sequence=0 WHERE d.parent_id = d2.id AND d2.`value`='dic_roadshow_column_status' AND d.`value`=1;

	--  路演状态添加
     IF NOT EXISTS (select * from dictionary d where d.`value` = 'dic_roadshow_status') THEN
      insert INTO dictionary(tenant_id,parent_id,label,value)VALUES(_tenantId,0,'路演状态','dic_roadshow_status');
    END IF;

    IF NOT EXISTS (select * from dictionary d LEFT JOIN dictionary p on d.parent_id = p.id where d.`value` = 0 and p.`value` = 'dic_roadshow_status') THEN
      insert INTO dictionary(tenant_id,parent_id,label,value) select _tenantId,id,'停用','0' FROM dictionary where value='dic_roadshow_status' limit 1;
    END IF;

    IF NOT EXISTS (select * from dictionary d LEFT JOIN dictionary p on d.parent_id = p.id where d.`value` = 1 and p.`value` = 'dic_roadshow_status') THEN
      insert INTO dictionary(tenant_id,parent_id,label,value) select _tenantId,id,'启用','1' FROM dictionary where value='dic_roadshow_status' limit 1;
    END IF;

     UPDATE dictionary d,dictionary d2 set d.sequence=0 WHERE d.parent_id = d2.id AND d2.`value`='dic_roadshow_status' AND d.`value`=1;

end;

call tenant_sql_update_1_2();

DROP PROCEDURE if exists tenant_sql_update_1_2;






//