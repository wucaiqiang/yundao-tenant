delimiter //

drop procedure if exists tenant_sql_update;

create procedure tenant_sql_update()
begin

DECLARE _tenantId BIGINT;
DECLARE _msgReservationAuditId BIGINT;
DECLARE _msgDeclarationAuditId BIGINT;
DECLARE _msgReservationApprovedId BIGINT;
DECLARE _msgReservationRejectId BIGINT;
DECLARE _newFollowTypeCount BIGINT;

SELECT tenant_id INTO _tenantId FROM user_account LIMIT 1;


	IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'leads' AND column_name = 'object_id') THEN
	   ALTER TABLE `leads` ADD COLUMN `object_id`  bigint NULL COMMENT '对象id' AFTER `status`;
	END IF; 
	
	
	IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'user_customer' AND column_name = 'source_type') THEN
        ALTER TABLE `user_customer`
        ADD COLUMN `source_type`  tinyint(2) NULL COMMENT '来源类型（0：自建，1：分配， 2：领取）' AFTER `user_id`;
	END IF; 
	
	ALTER TABLE `user_customer`
    MODIFY COLUMN `source_type`  tinyint(2) NULL DEFAULT NULL COMMENT '来源类型（0：自建，1：分配， 2：领取）' AFTER `user_id`;
	
	create table If Not Exists cc_product_consult
			(
			   id                   bigint not null auto_increment comment '主键',
			   customer_id          bigint comment '客户id',
			   product_id           bigint comment '产品id',
			   consult_date         datetime comment '预约咨询时间',
			   create_date          datetime comment '创建日期',
			   create_user_id       bigint comment '创建者id',
			   update_user_id       bigint comment '更新者id',
			   update_date          datetime comment '更新日期',
			   is_delete            tinyint(2) default 0 comment '是否删除，0：否，1：是',
			   primary key (id)
			);
   alter table cc_product_consult comment '产品预约咨询表';

   
   UPDATE number_config SET decimal_length=0 WHERE  object_field_id IN(6,7,16);

   
   	IF  EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'declaration' AND column_name = 'has_pay_evidence') THEN
        ALTER TABLE `declaration`  DROP COLUMN `has_pay_evidence`;
	END IF; 


  IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'leads' AND column_name = 'follow_remark') THEN
        ALTER TABLE leads ADD follow_remark VARCHAR(128) NULL COMMENT '跟进备注';
        ALTER TABLE leads MODIFY COLUMN follow_remark VARCHAR(128) COMMENT '跟进备注' AFTER remark;
	END IF;
	
	
	
	IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'msg_feed' AND column_name = 'first_type') THEN
       alter table msg_feed add `first_type` tinyint(2) DEFAULT NULL COMMENT '一级类型  1客户行为  2服务轨迹';
	END IF; 
	
    update msg_feed set first_type=2 where first_type is null;
	
	delete from dictionary WHERE parent_id in (select * from (select id FROM dictionary where value='dic_msg_feed_type')as b)  AND value=3;
    insert INTO dictionary(tenant_id,parent_id,label,value) select _tenantId,id,'客户行为','3' FROM dictionary where value='dic_msg_feed_type' limit 1;


    delete from dictionary WHERE parent_id in (select * from (select id FROM dictionary where value='dic_msg_message_two_type')as b)  AND value=8;
    insert INTO dictionary(tenant_id,parent_id,label,value) select _tenantId,id,'客户行为','8' FROM dictionary where value='dic_msg_message_two_type' limit 1;
	
	
   IF  EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'product' AND column_name = 'audit_status') THEN
       	ALTER TABLE `product` DROP COLUMN `audit_status`;
	END IF; 
	
	
	
	
	
	
DELETE FROM field_group_rel WHERE object_field_id <45;

INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `is_delete`)SELECT _tenantId,1,of.id,20,1,SYSDATE(),0 FROM `field` f LEFT JOIN object_field of ON f.id=of.field_id WHERE f.code='product_private_fund_rm';
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `is_delete`)SELECT _tenantId,1,of.id,20,1,SYSDATE(),0 FROM `field` f LEFT JOIN object_field of ON f.id=of.field_id WHERE f.code='product_private_investment_strategy';
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `is_delete`)SELECT _tenantId,1,of.id,20,1,SYSDATE(),0 FROM `field` f LEFT JOIN object_field of ON f.id=of.field_id WHERE f.code='product_private_investment_sub_strategy';
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `is_delete`)SELECT _tenantId,1,of.id,20,1,SYSDATE(),0 FROM `field` f LEFT JOIN object_field of ON f.id=of.field_id WHERE f.code='product_private_closure_period';
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `is_delete`)SELECT _tenantId,1,of.id,20,1,SYSDATE(),0 FROM `field` f LEFT JOIN object_field of ON f.id=of.field_id WHERE f.code='product_private_fund_type';
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `is_delete`)SELECT _tenantId,1,of.id,20,1,SYSDATE(),0 FROM `field` f LEFT JOIN object_field of ON f.id=of.field_id WHERE f.code='product_pro_buy_fee';
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `is_delete`)SELECT _tenantId,1,of.id,20,1,SYSDATE(),0 FROM `field` f LEFT JOIN object_field of ON f.id=of.field_id WHERE f.code='product_private_redemption_fee';
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `is_delete`)SELECT _tenantId,1,of.id,20,1,SYSDATE(),0 FROM `field` f LEFT JOIN object_field of ON f.id=of.field_id WHERE f.code='product_pro_manage_fee';
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `is_delete`)SELECT _tenantId,1,of.id,20,1,SYSDATE(),0 FROM `field` f LEFT JOIN object_field of ON f.id=of.field_id WHERE f.code='product_private_date_open';


INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `is_delete`)SELECT _tenantId,2,of.id,20,1,SYSDATE(),0 FROM `field` f LEFT JOIN object_field of ON f.id=of.field_id WHERE f.code='product_pro_buy_fee';
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `is_delete`)SELECT _tenantId,2,of.id,20,1,SYSDATE(),0 FROM `field` f LEFT JOIN object_field of ON f.id=of.field_id WHERE f.code='product_pro_manage_fee';
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `is_delete`)SELECT _tenantId,2,of.id,20,1,SYSDATE(),0 FROM `field` f LEFT JOIN object_field of ON f.id=of.field_id WHERE f.code='product_stock_fund_type';
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `is_delete`)SELECT _tenantId,2,of.id,20,1,SYSDATE(),0 FROM `field` f LEFT JOIN object_field of ON f.id=of.field_id WHERE f.code='product_stock_fund_form';
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `is_delete`)SELECT _tenantId,2,of.id,20,1,SYSDATE(),0 FROM `field` f LEFT JOIN object_field of ON f.id=of.field_id WHERE f.code='product_stock_custodian';
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `is_delete`)SELECT _tenantId,2,of.id,20,1,SYSDATE(),0 FROM `field` f LEFT JOIN object_field of ON f.id=of.field_id WHERE f.code='product_stock_invest_way';
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `is_delete`)SELECT _tenantId,2,of.id,20,1,SYSDATE(),0 FROM `field` f LEFT JOIN object_field of ON f.id=of.field_id WHERE f.code='product_stock_revenue_share';

INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `is_delete`)SELECT _tenantId,3,of.id,20,1,SYSDATE(),0 FROM `field` f LEFT JOIN object_field of ON f.id=of.field_id WHERE f.code='product_fix_fund_type';
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `is_delete`)SELECT _tenantId,3,of.id,20,1,SYSDATE(),0 FROM `field` f LEFT JOIN object_field of ON f.id=of.field_id WHERE f.code='product_fix_invest_domain';
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `is_delete`)SELECT _tenantId,3,of.id,20,1,SYSDATE(),0 FROM `field` f LEFT JOIN object_field of ON f.id=of.field_id WHERE f.code='product_fix_major_financing';
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `is_delete`)SELECT _tenantId,3,of.id,20,1,SYSDATE(),0 FROM `field` f LEFT JOIN object_field of ON f.id=of.field_id WHERE f.code='product_fix_fund_use';
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `is_delete`)SELECT _tenantId,3,of.id,20,1,SYSDATE(),0 FROM `field` f LEFT JOIN object_field of ON f.id=of.field_id WHERE f.code='product_fix_risk_control';
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `is_delete`)SELECT _tenantId,3,of.id,20,1,SYSDATE(),0 FROM `field` f LEFT JOIN object_field of ON f.id=of.field_id WHERE f.code='product_fix_repayment';
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `is_delete`)SELECT _tenantId,3,of.id,20,1,SYSDATE(),0 FROM `field` f LEFT JOIN object_field of ON f.id=of.field_id WHERE f.code='product_fix_profit_info';
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `is_delete`)SELECT _tenantId,3,of.id,20,1,SYSDATE(),0 FROM `field` f LEFT JOIN object_field of ON f.id=of.field_id WHERE f.code='product_fix_pay_interest';


INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)SELECT _tenantId,id,1,0,-1,SYSDATE(),NULL,NULL,0 FROM field_group;
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)SELECT _tenantId,id,2,0,-1,SYSDATE(),NULL,NULL,0 FROM field_group;
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)SELECT _tenantId,id,3,0,-1,SYSDATE(),NULL,NULL,0 FROM field_group;
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)SELECT _tenantId,id,4,0,-1,SYSDATE(),NULL,NULL,0 FROM field_group;
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)SELECT _tenantId,id,5,0,-1,SYSDATE(),NULL,NULL,0 FROM field_group;
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)SELECT _tenantId,id,6,0,-1,SYSDATE(),NULL,NULL,0 FROM field_group;
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)SELECT _tenantId,id,7,0,-1,SYSDATE(),NULL,NULL,0 FROM field_group;
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)SELECT _tenantId,id,8,0,-1,SYSDATE(),NULL,NULL,0 FROM field_group;
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)SELECT _tenantId,id,9,0,-1,SYSDATE(),NULL,NULL,0 FROM field_group;
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)SELECT _tenantId,id,10,0,-1,SYSDATE(),NULL,NULL,0 FROM field_group;
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)SELECT _tenantId,id,11,0,-1,SYSDATE(),NULL,NULL,0 FROM field_group;
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)SELECT _tenantId,id,12,0,-1,SYSDATE(),NULL,NULL,0 FROM field_group;
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)SELECT _tenantId,id,13,0,-1,SYSDATE(),NULL,NULL,0 FROM field_group;
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)SELECT _tenantId,id,14,0,-1,SYSDATE(),NULL,NULL,0 FROM field_group;
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)SELECT _tenantId,id,15,0,-1,SYSDATE(),NULL,NULL,0 FROM field_group;
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)SELECT _tenantId,id,16,0,-1,SYSDATE(),NULL,NULL,0 FROM field_group;
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)SELECT _tenantId,id,17,0,-1,SYSDATE(),NULL,NULL,0 FROM field_group;
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)SELECT _tenantId,id,18,0,-1,SYSDATE(),NULL,NULL,0 FROM field_group;
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)SELECT _tenantId,id,41,0,-1,SYSDATE(),NULL,NULL,0 FROM field_group;
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)SELECT _tenantId,id,42,0,-1,SYSDATE(),NULL,NULL,0 FROM field_group;
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)SELECT _tenantId,id,43,0,-1,SYSDATE(),NULL,NULL,0 FROM field_group;
INSERT INTO `field_group_rel` (`tenant_id`, `field_group_id`, `object_field_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)SELECT _tenantId,id,44,0,-1,SYSDATE(),NULL,NULL,0 FROM field_group;



	/*恢复 销售线索*/
UPDATE data_object SET is_delete=0 WHERE id IN(12);
UPDATE data_object_access SET is_delete=0 WHERE data_object_id IN(12);
UPDATE data_object_init SET is_delete=0 WHERE data_object_id IN(12) AND permission!=20;


INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`) 
SELECT id,1/*编辑*/,0,1,1,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='leads';
INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`) 
SELECT id,1/*编辑*/,10,2,0,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='leads';
INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`) 
SELECT id,1/*编辑*/,20,3,0,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='leads';
INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`) 
SELECT id,1/*编辑*/,30,4,0,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='leads';
INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`) 
SELECT id,1/*编辑*/,40,5,0,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='leads';





	IF NOT EXISTS (SELECT * FROM resource WHERE id = 73) THEN
        INSERT INTO `resource` (`id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_deplay`, `description`, `sequence`) 
	    VALUES (73, 'customer.highseas', 'WM', 22, '客户公海', '/customer/highseas', 1, NULL, '客户管理 - 客户公海', 25);
	END IF;
	
	IF NOT EXISTS (SELECT * FROM resource WHERE id = 74) THEN
       INSERT INTO `resource` (`id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_deplay`, `description`, `sequence`) 
	   VALUES (74, 'customer.opensea.receive_customer', 'WM', 73, '领取', '/customer/opensea/receive_customer', 0, NULL, '客户管理 - 客户公海- 领取', 10);
	END IF;
	
	IF NOT EXISTS (SELECT * FROM resource WHERE id = 75) THEN
       INSERT INTO `resource` (`id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_deplay`, `description`, `sequence`) 
	   VALUES (75, 'customer.add_opensea', 'WM', 73, '新增客户', '/customer/add_opensea', 0, NULL, '客户管理 - 客户公海- 新增客户', 20);
	END IF;
	
	IF NOT EXISTS (SELECT * FROM resource WHERE id = 76) THEN
      INSERT INTO `resource` (`id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_deplay`, `description`, `sequence`) 
	   VALUES (76, 'customer.import.multi_from_opensea', 'WM', 73, '批量导入客户', '/customer/import/multi_from_opensea', 0, NULL, '客户管理 - 客户公海- 批量导入客户', 30);
	END IF;
	
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 73 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (73, 1);
	END IF;
	
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 74 and is_delete = 0) THEN
         INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (74, 1);
	END IF;
	
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 75 and is_delete = 0) THEN
          INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (75, 1);
	END IF;
	
   
    IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 76 and is_delete = 0) THEN
          INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (76, 1);
	END IF;



	  update resource r set r.tenant_id = _tenantId where r.tenant_id is null; 
		update role_resource r set r.tenant_id =_tenantId where r.tenant_id is null;
  
    /*gjl   理财师名片介绍*/
    IF  EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'product_notice_attach' AND column_name = 'type') THEN
       alter table product_notice_attach MODIFY type varchar(100) DEFAULT NULL COMMENT '附件类型';
	END IF; 


	/*恢复 跟进*/
	UPDATE data_object SET is_delete=0 WHERE id IN(13);
	UPDATE data_object_access SET is_delete=0 WHERE data_object_id IN(13);
	UPDATE data_object_init SET is_delete=0 WHERE data_object_id IN(13) AND permission!=20;

    /*吴才强   理财师名片介绍*/
	IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'user_detail' AND column_name = 'card_introduce') THEN
        alter table user_detail add `card_introduce` varchar(200) DEFAULT NULL COMMENT '理财师名片介绍' AFTER `register_source`;
	END IF; 





UPDATE product_notice_type
SET  name = '重大事项', description = NULL, code = 'major_issues ', is_permit_delete = 0, create_user_id = 1,
  create_date = '2017-08-22 14:47:06', update_user_id = NULL, update_date = NULL, is_delete = 1
WHERE id = 1;
UPDATE product_notice_type
SET name = '周报', description = NULL, code = 'weekly', is_permit_delete = 0, create_user_id = 1,
  create_date = '2017-08-22 14:47:06', update_user_id = NULL, update_date = NULL, is_delete = 0
WHERE id = 2;
UPDATE product_notice_type
SET name = '月报', description = NULL, code = 'monthly', is_permit_delete = 0, create_user_id = 1,
  create_date = '2017-08-22 14:47:06', update_user_id = NULL, update_date = NULL, is_delete = 0
WHERE id = 3;
UPDATE product_notice_type
SET name = '季报', description = NULL, code = 'quarterly', is_permit_delete = 0, create_user_id = 1,
  create_date = '2017-08-22 14:47:06', update_user_id = NULL, update_date = NULL, is_delete = 0
WHERE id = 4;
UPDATE product_notice_type
SET name = '半年报', description = NULL, code = 'semi_annual', is_permit_delete = 0, create_user_id = 1,
  create_date = '2017-08-22 14:47:06', update_user_id = NULL, update_date = NULL, is_delete = 0
WHERE id = 5;
UPDATE product_notice_type
SET name = '年报', description = NULL, code = 'annual', is_permit_delete = 0, create_user_id = 1,
  create_date = '2017-08-22 14:47:06', update_user_id = NULL, update_date = NULL, is_delete = 0
WHERE id = 6;
UPDATE product_notice_type
SET name = '私募备案', description = NULL, code = 'private_record', is_permit_delete = 0, create_user_id = 1,
  create_date = '2017-08-22 14:47:06', update_user_id = NULL, update_date = NULL, is_delete = 0
WHERE id = 7;
UPDATE product_notice_type
SET name = '通知赎回', description = NULL, code = 'notification_redemption', is_permit_delete = 0,
  create_user_id = 1, create_date = '2017-08-22 14:47:06', update_user_id = NULL, update_date = NULL, is_delete = 0
WHERE id = 8;
UPDATE product_notice_type
SET name = '产品成立', description = NULL, code = 'product_found', is_permit_delete = 0, create_user_id = 1,
  create_date = '2017-08-22 14:47:06', update_user_id = NULL, update_date = NULL, is_delete = 0
WHERE id = 9;
UPDATE product_notice_type
SET name = '付息通知', description = NULL, code = 'interest_notice', is_permit_delete = 0,
  create_user_id = 1, create_date = '2017-08-22 14:47:06', update_user_id = NULL, update_date = '2017-08-25 19:15:01',
  is_delete      = 1
WHERE id = 10;
UPDATE product_notice_type
SET name = '其他', description = NULL, code = 'other', is_permit_delete = 0, create_user_id = 1,
  create_date = '2017-08-22 14:47:06', update_user_id = NULL, update_date = NULL, is_delete = 1
WHERE id = 11;



INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
SELECT id,0/*读取*/,0,1,1,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='follow';
INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
SELECT id,0/*读取*/,10,2,0,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='follow';
INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
SELECT id,0/*读取*/,20,3,0,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='follow';
INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
SELECT id,0/*读取*/,30,4,0,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='follow';
INSERT INTO `data_object_init` (`data_object_id`, `operation`, `permission`, `sequence`, `is_check`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
SELECT id,0/*读取*/,40,5,0,SYSDATE(),1,NULL,NULL,0 FROM data_object WHERE `code`='follow';



UPDATE data_object_init SET is_delete=1 WHERE permission=20;
UPDATE data_object_init SET tenant_id=_tenantId WHERE tenant_id IS NULL;

/*
Navicat MySQL Data Transfer

Source Server         : yundao_qa
Source Server Version : 50634
Source Host           : rds02l48nbv5zi77qvxjo.mysql.rds.aliyuncs.com:3306
Source Database       : wm_tenant_zcm

Target Server Type    : MYSQL
Target Server Version : 50634
File Encoding         : 65001

Date: 2017-09-27 15:32:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `msg_template`
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
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='动态模板';

-- ----------------------------
-- Records of msg_template
-- ----------------------------
INSERT INTO `msg_template` VALUES ('1', '1', '新增客户', '新增客户\r\n操作人：$!{createUserName}', null, null, '0', null, null, null, '/customer/detail/$!{customerId}', 'add_customer', '', '新增客户', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('2', '1', '客户待跟进', '', '您计划于$!{nextFollowDate} 跟进客户（$!{name}$!{mobile}），请及时跟进', '您计划于$!{nextFollowDate} 跟进客户（$!{name}$!{mobile}），请及时跟进', '0', null, '跟进客户（$!{name}，$!{mobile}）', 'yundaojinfub://www.yundaocustomer.com/customer_detail?customerId=$!{customerId}', '/customer/detail/$!{customerId}', 'next_follow', '{\"customerId\":{\"isBlank\":false,\"message\":\"客户ID不能为空\"},\"userId\":{\"isBlank\":false,\"message\":\"理财师ID不能为空\"},\"name\":{\"isBlank\":false,\"message\":\"客户名称不能为空\"},\"mobile\":{\"isBlank\":false,\"message\":\"客户手机号不能为空\"},\"nextFollowDate\":{\"isBlank\":false,\"message\":\"下次跟进时间不能为空\"}}', '下次跟进', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('3', '1', '客户跟进', '客户跟进：$!{content}\r\n方式：$!{typeName} , 操作人：$!{createUserName}', null, null, '0', null, null, null, '/customer/detail/$!{customerId}', 'customer_follow', '{\"customerId\":{\"isBlank\":false,\"message\":\"客户ID不能为空\"},\"content\":{\"isBlank\":false,\"message\":\"跟进内容不允许为空\"},\"typeName\":{\"isBlank\":false,\"message\":\"跟进类型不允许为空\"},\"createUserName\":{\"isBlank\":false,\"message\":\"跟进状态\"}}', '客户跟进', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('4', '1', '新产品上线', '', '$!{productTypeName}类产品$!{productName}上线了，敬请关注', '$!{productTypeName}类产品$!{productName}上线了，敬请关注', '0', null, null, 'yundaojinfub://www.yundaoproduct.com/product_detail?productId=$!{productId}&productName=$!{productName}', '/product/detail/$!{productId}', 'product_on_line', '{\"productId\":{\"isBlank\":false,\"message\":\"产品ID不能为空\"},\"productName\":{\"isBlank\":false,\"message\":\"产品名称不能为空\"},\"productTypeName\":{\"isBlank\":false,\"message\":\"产品类型名称不能为空\"}}', '新产品上线', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('5', '1', '产品附件更新', null, '$!{productName}产品的附件$!{attachSourceName}有更新，敬请关注', '$!{productName}产品的附件$!{attachSourceName}有更新，敬请关注', '0', null, null, 'yundaojinfub://www.yundaoproduct.com/product_detail?productId=$!{productId}&productName=$!{productName}', '/product/detail/$!{productId}?tab=info', 'product_add_attach', '{\"productId\":{\"isBlank\":false,\"message\":\"产品ID不能为空\"},\"productName\":{\"isBlank\":false,\"message\":\"产品名称不能为空\"},\"attachSourceName\":{\"isBlank\":false,\"message\":\"产品附件名称不能为空\"}}', '项目附件更新', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('6', '1', '产品上线待审批', null, '用户$!{submitUserRealName}提交产品上线审批（$!{productTypeName}，$!{productName}），请及时处理', '用户$!{submitUserRealName}提交产品上线审批（$!{productTypeName}，$!{productName}），请及时处理', '0', null, '产品上线审批（$!{productName}）', 'yundaojinfub://www.yundaomine.com/task_list', '/product/control/audit', 'product_on_line_audit', '{\"productId\":{\"isBlank\":false,\"message\":\"产品ID不能为空\"},\"productName\":{\"isBlank\":false,\"message\":\"产品名称不能为空\"},\"productTypeName\":{\"isBlank\":false,\"message\":\"产品类型名称不能为空\"}}', '产品上线待审批', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('7', '1', '客户回退申请已通过', '客户回退到客户公海\r\n申请人：$!{applyUserName}，操作人：$!{auditUserName}', '您的客户（$!{customerName}，$!{customerMobile}）回退申请被$!{auditUserName} 审批通过，已回退到客户公海', '您的客户（$!{customerName}，$!{customerMobile}）回退申请被$!{auditUserName} 审批通过，已回退到客户公海', '0', null, null, null, null, 'customer_back_examine_pass', '{\"customerName\":{\"isBlank\":false,\"message\":\"客户名称不能为空\"},\"customerMobile\":{\"isBlank\":false,\"message\":\"客户手机号不能为空\"},\"auditUserName\":{\"isBlank\":false,\"message\":\"审批人名称不能为空\"},\"applyUserName\":{\"isBlank\":false,\"message\":\"申请人名称不能为空\"}}', '客户回退-审批通过', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('8', '1', '客户回退申请被驳回', '客户回退被驳回，原因：$!{rejectReason}\r\n操作人：$!{auditUserName}', '您的客户（$!{customerName}，$!{customerMobile}）回退申请被$!{auditUserName} 驳回，原因：$!{rejectReason}', '您的客户（$!{customerName}，$!{customerMobile}）回退申请被$!{auditUserName} 驳回，原因：$!{rejectReason}', '0', null, null, null, null, 'customer_back_examine_reject', '{\"customerName\":{\"isBlank\":false,\"message\":\"客户名称不能为空\"},\"customerMobile\":{\"isBlank\":false,\"message\":\"客户手机号不能为空\"},\"auditUserName\":{\"isBlank\":false,\"message\":\"审批人名称不能为空\"}}', '客户回退-驳回', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('9', '1', '产品发布新公告', null, '$!{productName}产品发布新公告（$!{typeName}，$!{title}），请及时关注', '$!{productName}产品发布新公告（$!{typeName}，$!{title}），请及时关注', '0', null, null, 'yundaojinfub://www.yundaoproduct.com/product_notice_detail?noticeId=$!{id}', '/product/detail/$!{productId}?tab=announce', 'send_notice', '{\"id\":{\"isBlank\":false,\"message\":\"公告ID不能为空\"},\"userIds\":{\"isBlank\":false,\"message\":\"发送人IDS不能为空\"},\"productName\":{\"isBlank\":false,\"message\":\"产品名称不能为空\"},\"typeName\":{\"isBlank\":false,\"message\":\"公告类型不能为空\"},\"title\":{\"isBlank\":false,\"message\":\"公告标题不能为空\"},\"productId\":{\"isBlank\":false,\"message\":\"产品ID不能为空\"}}', '产品发布新公告', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('10', '1', '产品公告待审批', null, '用户$!{realName}提交公告发布审批（$!{productName}，$!{typeName}，$!{title}）请及时处理', '用户$!{realName}提交公告发布审批（$!{productName}，$!{typeName}，$!{title}）请及时处理', '0', null, '公告发布审批（$!{productName}，$!{title}）', 'yundaojinfub://www.yundaomine.com/task_list', '/product/notice/audit', 'product_notice_audit', '{\"userIds\":{\"isBlank\":false,\"message\":\"发送人IDS不能为空\"},\"productName\":{\"isBlank\":false,\"message\":\"产品名称不能为空\"},\"typeName\":{\"isBlank\":false,\"message\":\"公告类型不能为空\"},\"title\":{\"isBlank\":false,\"message\":\"公告标题不能为空\"},\"realName\":{\"isBlank\":false,\"message\":\"用户名不能为空\"}}', '产品公告待审批', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('11', '1', '回访了您的客户', '客户回访：$!{content}\r\n方式：$!{type}，状态：$!{status}，操作人：$!{visitOperationUserName}', '$!{visitOperationUserName} 对您的客户$!{customerName}进行了回访：$!{content}', '$!{visitOperationUserName} 对您的客户$!{customerName}进行了回访：$!{content}', '0', null, null, 'yundaojinfub://www.yundaocustomer.com/customer_detail/callback?customerId=$!{customerId}', '/customer/detail/$!{customerId}?tab=visit', 'customer_visit', '{\"userId\":{\"isBlank\":false,\"message\":\"发送人不能为空\"},\"customerId\":{\"isBlank\":false,\"message\":\"客户ID不能为空\"},\"customerName\":{\"isBlank\":false,\"message\":\"客户名称不能为空\"},\"type\":{\"isBlank\":false,\"message\":\"回访方式不能为空\"},\"status\":{\"isBlank\":false,\"message\":\"回访状态不能为空\"}}', '回访了您的客户', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('12', '1', '客户待回访', null, '您计划于$!{nextTime} 回访客户（$!{customerName}，$!{customerMobile}），请及时处理', '您计划于$!{nextTime} 回访客户（$!{customerName}，$!{customerMobile}），请及时处理', '0', null, '回访客户（$!{customerName}，$!{customerMobile}）', null, '/operation/allot', 'customer_next_visit', null, '客户待回访', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('17', '1', '给您调配了新客户', '客户调配：客户调配到$!{fpName}名下\n操作人：$!{createUserName}', '$!{createUserName} 给你调配了新客户（$!{name}，$!{mobile}），请及时跟进', '$!{createUserName} 给你调配了新客户（$!{name}，$!{mobile}），请及时跟进', '0', null, '', 'yundaojinfub://www.yundaocustomer.com/customer_list', '/customer/my', 'customer_allot', '', '单个客户调配', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('18', '1', '给您调配了新客户', '客户调配：客户调配到$!{fpName}名下\n操作人：$!{createUserName}', '$!{createUserName} 给你调配了$!{customerNum}位新客户，请及时跟进', '$!{createUserName} 给你调配了$!{customerNum}位新客户，请及时跟进', '0', null, '', 'yundaojinfub://www.yundaocustomer.com/customer_list', '/customer/my', 'customer_allot_multi', '', '批量客户调配', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('19', '1', '客户回收到客户公海', '客户回收到客户公海\n操作人：$!{createUserName}', '您的客户（$!{customerName}，$!{mobile}）已被$!{createUserName} 回收到客户公海', '您的客户（$!{customerName}，$!{mobile}）已被$!{createUserName} 回收到客户公海', '0', null, '', null, '', 'customer_recycle', null, '批量客户回收', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('20', '1', '报单审批通过', '报单确认：$!{productName}，打款金额$!{dealAmount}，打款日期$!{dealTime}\r\n操作人：$!{audioName}', '您为客户$!{customerName}认购（$!{productName}，$!{dealAmount}，$!{dealTime}）的报单已确认', '您为客户$!{customerName}认购（$!{productName}，$!{dealAmount}，$!{dealTime}）的报单已确认', '0', null, null, 'yundaojinfub://www.yundaoorder.com/order_detail?orderId=$!{id}', '/declaration/detail/$!{id}', 'declaration_audio_pass', '{\"userId\":{\"isBlank\":false,\"message\":\"发送人ID不能为空\"},\"id\":{\"isBlank\":false,\"message\":\"报单ID不能为空\"},\"productName\":{\"isBlank\":false,\"message\":\"产品名称不能为空\"},\"dealAmount\":{\"isBlank\":false,\"message\":\"打款金额不能为空\"},\"audioName\":{\"isBlank\":false,\"message\":\"报单审批人不能为空\"},\"dealTime\":{\"isBlank\":false,\"message\":\"打款时间不能为空\"}}', '报单审批通过', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('21', '1', '报单被驳回', '报单被驳回：$!{productName}，打款金额$!{dealAmount}，打款日期$!{dealTime}，原因：$!{reason}\r\n操作人：$!{audioName}', '您为客户$!{customerName}认购（$!{productName}，$!{dealAmount}，$!{dealTime}）的报单被$!{audioName} 驳回，原因：$!{reason}', '您为客户$!{customerName}认购（$!{productName}，$!{dealAmount}，$!{dealTime}）的报单被$!{audioName} 驳回，原因：$!{reason}', '0', null, null, 'yundaojinfub://www.yundaoorder.com/order_list', '/sale/declaration', 'declaration_audio_reject', '{\"userId\":{\"isBlank\":false,\"message\":\"发送人ID不能为空\"},\"productName\":{\"isBlank\":false,\"message\":\"产品名称不能为空\"},\"dealAmount\":{\"isBlank\":false,\"message\":\"打款金额不能为空\"},\"audioName\":{\"isBlank\":false,\"message\":\"报单审批人不能为空\"},\"dealTime\":{\"isBlank\":false,\"message\":\"打款时间不能为空\"},\"reason\":{\"isBlank\":false,\"message\":\"驳回原因不能为空\"},\"id\":{\"isBlank\":false,\"message\":\"报单不能为空\"}}', '报单被驳回', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('22', '1', '客户完成注册', '客户完成注册\r\n渠道：$!{channel}', '客户$!{customerName}在$!{channel}完成注册，请及时跟进', '客户$!{customerName}在$!{channel}完成注册，请及时跟进', '0', null, null, 'yundaojinfub://www.yundaocustomer.com/customer_detail?customerId=$!{customerId}', '/customer/detail/$!{customerId}', 'c_add_customer', '{\"customerName\":{\"isBlank\":false,\"message\":\"客户名称不能为空\"},\"channel\":{\"isBlank\":false,\"message\":\"注册渠道不能为空\"},\"customerId\":{\"isBlank\":false,\"message\":\"客户ID不能为空\"}}', '客户完成注册', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('23', '1', '客户登录', '客户登录\r\n渠道：$!{channel}', '客户$!{customerName}在$!{channel}登录，请及时跟进\r\n', '客户$!{customerName}在$!{channel}登录，请及时跟进\r\n', '0', null, null, 'yundaojinfub://www.yundaocustomer.com/customer_detail?customerId=$!{customerId}', '/customer/detail/$!{customerId}', 'c_login_customer', '{\"customerName\":{\"isBlank\":false,\"message\":\"客户名称不能为空\"},\"channel\":{\"isBlank\":false,\"message\":\"登陆渠道不能为空\"},\"customerId\":{\"isBlank\":false,\"message\":\"客户ID不能为空\"}}', '客户登录', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('24', '1', '客户提交测评结果', '客户完成测评\r\n测评结果：$!{evaluating}，渠道：$!{channel}', '客户$!{customerName}完成风险测评，测评结果：$!{evaluating}，渠道：$!{channel}，请及时跟进', '客户$!{customerName}完成风险测评，测评结果：$!{evaluating}，渠道：$!{channel}，请及时跟进', '0', null, null, 'yundaojinfub://www.yundaocustomer.com/customer_detail?customerId=$!{customerId}', '/customer/detail/$!{customerId}', 'c_evaluating_customer', '{\"customerName\":{\"isBlank\":false,\"message\":\"客户名称不能为空\"},\"channel\":{\"isBlank\":false,\"message\":\"注册渠道不能为空\"},\"evaluating\":{\"isBlank\":false,\"message\":\"评测结果不能为空\"},\"customerId\":{\"isBlank\":false,\"message\":\"客户ID不能为空\"}}', 'C端客户评测', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('25', '1', '客户查看产品详情\r\n', '客户查看产品详情\r\n产品名称：$!{productName}，渠道：$!{channel}', '客户$!{customerName}查看了$!{productName}详情，渠道：$!{channel}，请及时跟进', '客户$!{customerName}查看了$!{productName}详情，渠道：$!{channel}，请及时跟进', '0', null, null, 'yundaojinfub://www.yundaocustomer.com/customer_detail?customerId=$!{customerId}', '/customer/detail/$!{customerId}', 'c_view_product', '{\"customerName\":{\"isBlank\":false,\"message\":\"客户名称不能为空\"},\"channel\":{\"isBlank\":false,\"message\":\"注册渠道不能为空\"},\"productName\":{\"isBlank\":false,\"message\":\"产品名称不能为空\"},\"customerId\":{\"isBlank\":false,\"message\":\"客户ID不能为空\"}}', '客户查看产品详情', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('26', '1', '客户预约咨询产品', '客户预约咨询产品\r\n产品名称：$!{productName}，渠道：$!{channel}', '客户$!{customerName}预约咨询$!{productName}，渠道：$!{channel}，请及时跟进', '客户$!{customerName}预约咨询$!{productName}，渠道：$!{channel}，请及时跟进', '0', null, null, 'yundaojinfub://www.yundaocustomer.com/customer_detail?customerId=$!{customerId}', '/customer/detail/$!{customerId}', 'c_reservation', '{\"customerName\":{\"isBlank\":false,\"message\":\"客户名称不能为空\"},\"channel\":{\"isBlank\":false,\"message\":\"注册渠道不能为空\"},\"productName\":{\"isBlank\":false,\"message\":\"产品名称不能为空\"},\"customerId\":{\"isBlank\":false,\"message\":\"客户ID不能为空\"}}', '客户预约咨询产品', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('27', '1', '客户查看公告详情', '客户查看公告详情\r\n公告标题：$!{title}，公告类型：$!{typeText}，产品名称：$!{productName}，渠道：$!{channel}', '客户$!{customerName}查看了$!{productName}的$!{typeText}公告：$!{title}，渠道：$!{channel}，请及时跟进', '客户$!{customerName}查看了$!{productName}的$!{typeText}公告：$!{title}，渠道：$!{channel}，请及时跟进', '0', null, null, 'yundaojinfub://www.yundaocustomer.com/customer_detail?customerId=$!{customerId}', '/customer/detail/$!{customerId}', 'c_view_notice', '{\"typeText\":{\"isBlank\":false,\"message\":\"公告类型不能为空\"},\"title\":{\"isBlank\":false,\"message\":\"公告标题不能为空\"},\"customerName\":{\"isBlank\":false,\"message\":\"客户名称不能为空\"},\"channel\":{\"isBlank\":false,\"message\":\"注册渠道不能为空\"},\"productName\":{\"isBlank\":false,\"message\":\"产品名称不能为空\"},\"customerId\":{\"isBlank\":false,\"message\":\"客户ID不能为空\"}}', '客户查看公告详情', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('28', '1', '额度预约待审批', null, '用户$!{userName}发起额度预约（$!{productName}，$!{reservationAmount}万），请及时处理', '用户$!{userName}发起额度预约（$!{productName}，$!{reservationAmount}万），请及时处理', '0', null, '额度预约审批（$!{productName}，$!{reservationAmount}万）', 'yundaojinfub://www.yundaomine.com/task_list', '/sale/appointment/audit', 'reservation_audit_todo', '{\"userName\":{\"isBlank\":false,\"message\":\"消息动态：用户名称不能为空\"},\"productName\":{\"isBlank\":false,\"message\":\"消息动态：产品名称不能为空\"},\"reservationAmount\":{\"isBlank\":false,\"message\":\"消息动态：预约金额不能为空\"}}', '额度预约待审批', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('29', '1', '报单待审批', null, '用户$!{userName}新增报单（$!{productName}，$!{dealAmount}万，打款日期$!{payDate}），请及时处理', '用户$!{userName}新增报单（$!{productName}，$!{dealAmount}万，打款日期$!{payDate}），请及时处理', '0', null, '审批报单（$!{productName}，$!{dealAmount}万）', 'yundaojinfub://www.yundaomine.com/task_list', '/sale/declaration/audit', 'declaration_audit_todo', '{\"userName\":{\"isBlank\":false,\"message\":\"消息动态：用户名称不能为空\"},\"productName\":{\"isBlank\":false,\"message\":\"消息动态：产品名称不能为空\"},\"dealAmount\":{\"isBlank\":false,\"message\":\"消息动态：打款金额不能为空\"}},\"payDate\":{\"isBlank\":false,\"message\":\"消息动态：打款日期不能为空\"}}', '有待审批的报单', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('30', '1', '额度预约已确认', '额度预约确认：$!{productName}，预约额度$!{reservationAmount}万，预计打款日期$!{estimatePayDate}\r\n操作人：$!{createUserName}', '您为客户$!{customerName}预约（$!{productName}，$!{reservationAmount}万）额度已确认', '您为客户$!{customerName}预约（$!{productName}，$!{reservationAmount}万）额度已确认', '0', null, null, 'yundaojinfub://www.yundaoorder.com/appoint_detail?reservationId=$!{reservationId}', '/sale/appointment', 'reservation_approved', '', '额度预约已确认', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('31', '1', '额度预约被驳回', '额度预约被驳回：$!{productName}，预约额度$!{reservationAmount}万，预计打款日期$!{estimatePayDate}，原因：$!{reason}\r\n操作人：$!{createUserName}', '您为客户$!{customerName}预约（$!{productName}，$!{reservationAmount}万）被$!{createUserName} 驳回，原因：$!{reason}', '您为客户$!{customerName}预约（$!{productName}，$!{reservationAmount}万）被$!{createUserName} 驳回，原因：$!{reason}', '0', null, null, 'yundaojinfub://www.yundaoorder.com/appoint_detail?reservationId=$!{reservationId}', '/sale/appointment', 'reservation_reject', '', '额度预约被驳回', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('32', '1', '放弃客户', '放弃客户，原因：$!{reason}\r\n操作人:$!{createUserName}', null, '', '0', null, null, '', '', 'renounce_customer', '', '放弃客户', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('33', '1', '产品上线待审批', '', '用户$!{submitUserRealName}重新提交产品上线审批（$!{productTypeName}，$!{productName}），请及时处理', '用户$!{submitUserRealName}重新提交产品上线审批（$!{productTypeName}，$!{productName}），请及时处理', '0', null, '产品上线审批（$!{productName}）', 'yundaojinfub://www.yundaomine.com/task_list', '/product/control/audit', 'product_again_audit', '', '有待上线审批的产品（驳回后重新提交）', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('34', '1', '产品公告待审批', '', '用户$!{realName}重新提交公告发布审批（$!{productName}，$!{typeName}，$!{title}）请及时处理', '用户$!{realName}重新提交公告发布审批（$!{productName}，$!{typeName}，$!{title}）请及时处理', '0', null, '公告发布审批（$!{productName}，$!{title}）', 'yundaojinfub://www.yundaomine.com/task_list', '/product/notice/audit', 'product_notice_again_audit', '', '有待发布审批的公告（驳回后重新提交）', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('35', '1', '额度预约待审批', '', '用户$!{userName}重新发起额度预约（$!{productName}，$!{reservationAmount}万），请及时处理', '用户$!{userName}重新发起额度预约（$!{productName}，$!{reservationAmount}万），请及时处理', '0', null, '额度预约审批（$!{productName}，$!{reservationAmount}万）', 'yundaojinfub://www.yundaomine.com/task_list', '/sale/appointment/audit', 'reservation_again_audit', '', '有待审批的额度预约（驳回后重新提交）', null, null, null, null, '0');
INSERT INTO `msg_template` VALUES ('36', '1', '报单待审批', '', '用户$!{userName}重新提交报单（$!{productName}，$!{dealAmount}万，打款日期$!{payDate}），请及时处理', '用户$!{userName}重新提交报单（$!{productName}，$!{dealAmount}万，打款日期$!{payDate}），请及时处理', '0', null, '审批报单（$!{productName}，$!{dealAmount}万）', 'yundaojinfub://www.yundaomine.com/task_list', '/sale/declaration/audit', 'declaration_again_audit', '', '有待审批的额度预约（驳回后重新提交）', null, null, null, null, '0');
UPDATE msg_template SET tenant_id=_tenantId;

/*
Navicat MySQL Data Transfer

Source Server         : yundao_qa
Source Server Version : 50634
Source Host           : rds02l48nbv5zi77qvxjo.mysql.rds.aliyuncs.com:3306
Source Database       : wm_tenant_zcm

Target Server Type    : MYSQL
Target Server Version : 50634
File Encoding         : 65001

Date: 2017-09-27 15:22:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `msg_template_type`
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
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='模板类型表';

-- ----------------------------
-- Records of msg_template_type
-- ----------------------------
INSERT INTO `msg_template_type` VALUES ('1', '1', '新增客户', '1', '2', '1', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('2', '1', '下次跟进客户', '2', '1', '4', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('3', '1', '客户跟进', '1', '2', '1', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('4', '1', '产品上线', '2', '2', '2', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('5', '1', '项目附件更新', '2', '2', '2', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('6', '1', '有待上线审核的产品', '2', '1', '5', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('7', '1', '客户回退-审核通过', '1', '2', '2', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('8', '1', '客户回退-审核通过', '2', '2', '1', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('9', '1', '客户回退-驳回', '1', '2', '2', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('10', '1', '客户回退-驳回', '2', '2', '1', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('11', '1', '产品公告发布', '2', '2', '2', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('12', '1', '有待发布审核的公告', '2', '1', '5', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('13', '1', '客户回访', '1', '2', '2', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('14', '1', '客户回访', '2', '2', '1', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('15', '1', '下次回访', '2', '1', '3', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('16', '1', '给您调配了新客户', '2', '2', '1', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('17', '1', '给您调配了新客户', '1', '2', '1', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('18', '1', '客户回收到客户池', '2', '2', '1', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('19', '1', '客户回收到客户池', '1', '2', '1', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('20', '1', '报单审核通过', '1', '2', '2', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('21', '1', '报单审核通过', '2', '2', '7', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('22', '1', '报单被驳回', '1', '2', '2', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('23', '1', '报单被驳回', '2', '2', '7', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('24', '1', 'C端客户注册', '1', '1', '3', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('25', '1', 'C端客户注册', '2', '2', '8', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('26', '1', '客户登录', '1', '1', '3', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('27', '1', '客户登录', '2', '2', '8', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('28', '1', '客户提交测评结果', '1', '1', '3', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('29', '1', '客户提交测评结果', '2', '2', '8', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('30', '1', '客户查看产品详情', '1', '1', '3', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('31', '1', '客户查看产品详情', '2', '2', '8', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('32', '1', '客户预约咨询产品', '1', '1', '3', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('33', '1', '客户预约咨询产品', '2', '2', '8', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('34', '1', '客户查看公告详情', '1', '1', '3', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('35', '1', '客户查看公告详情', '2', '2', '8', null, null, null, null, '0');
INSERT INTO `msg_template_type` VALUES ('36', '1', '有待确认的额度预约', '2', '1', '6', null, '2017-09-26 16:12:01', null, null, '0');
INSERT INTO `msg_template_type` VALUES ('37', '1', '有待审批的报单', '2', '1', '5', null, '2017-09-26 16:12:01', null, null, '0');
INSERT INTO `msg_template_type` VALUES ('38', '1', '预约额度确认', '1', '2', '7', null, '2017-09-26 16:12:01', null, null, '0');
INSERT INTO `msg_template_type` VALUES ('39', '1', '预约额度确认', '2', '2', '7', null, '2017-09-26 16:12:01', null, null, '0');
INSERT INTO `msg_template_type` VALUES ('40', '1', '预约额度被驳回', '1', '2', '7', null, '2017-09-26 16:12:01', null, null, '0');
INSERT INTO `msg_template_type` VALUES ('41', '1', '预约额度被驳回', '2', '2', '7', null, '2017-09-26 16:12:01', null, null, '0');
INSERT INTO `msg_template_type` VALUES ('42', '1', '放弃客户', '1', '2', '1', null, '2017-09-26 19:10:38', null, null, '0');
INSERT INTO `msg_template_type` VALUES ('43', '1', '产品上线待审批', '2', '1', '5', null, '2017-09-26 19:13:14', null, null, '0');
INSERT INTO `msg_template_type` VALUES ('44', '1', '产品公告待审批', '2', '1', '5', null, '2017-09-26 19:14:59', null, null, '0');
INSERT INTO `msg_template_type` VALUES ('45', '1', '额度预约待审批', '2', '1', '5', null, '2017-09-26 19:14:59', null, null, '0');
INSERT INTO `msg_template_type` VALUES ('46', '1', '报单待审批', '2', '1', '5', null, '2017-09-26 19:14:59', null, null, '0');

UPDATE msg_template_type SET name=REPLACE(name,'审核','审批');
UPDATE msg_template_type SET tenant_id=_tenantId;
/*
Navicat MySQL Data Transfer

Source Server         : scm
Source Server Version : 50634
Source Host           : rds996n72786ft1i3ee4o.mysql.rds.aliyuncs.com:3306
Source Database       : wm_tenant_zcm

Target Server Type    : MYSQL
Target Server Version : 50634
File Encoding         : 65001

Date: 2017-09-26 19:50:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `msg_template_type_ref`
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
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 COMMENT='模板类型关联关系表';

-- ----------------------------
-- Records of msg_template_type_ref
-- ----------------------------
INSERT INTO `msg_template_type_ref` VALUES ('1', '1', '1', '1', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('2', '1', '2', '2', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('3', '1', '3', '3', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('4', '1', '4', '4', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('5', '1', '5', '5', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('6', '1', '6', '6', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('7', '1', '7', '7', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('8', '1', '7', '8', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('9', '1', '8', '9', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('10', '1', '8', '10', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('11', '1', '9', '11', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('12', '1', '10', '12', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('13', '1', '11', '13', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('14', '1', '11', '14', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('15', '1', '12', '15', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('17', '1', '17', '17', '-1', '2017-08-27 20:52:54', null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('18', '1', '17', '16', '-1', '2017-08-27 20:53:38', null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('19', '1', '18', '17', '-1', '2017-08-27 20:54:00', null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('20', '1', '18', '16', '-1', '2017-08-27 20:54:00', null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('21', '1', '19', '19', '-1', '2017-08-29 08:47:03', null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('22', '1', '19', '18', '-1', '2017-08-29 08:49:06', null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('23', '1', '20', '20', '-1', null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('24', '1', '20', '21', '-1', null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('25', '1', '21', '22', '-1', null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('26', '1', '21', '23', '-1', null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('27', '1', '22', '24', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('28', '1', '22', '25', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('29', '1', '23', '26', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('30', '1', '23', '27', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('31', '1', '24', '28', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('32', '1', '24', '29', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('33', '1', '25', '30', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('34', '1', '25', '31', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('35', '1', '26', '32', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('36', '1', '26', '33', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('37', '1', '27', '34', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('38', '1', '27', '35', null, null, null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('39', '1', '28', '36', null, '2017-09-26 16:12:01', null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('40', '1', '29', '37', null, '2017-09-26 16:12:01', null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('41', '1', '30', '38', null, '2017-09-26 16:12:01', null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('42', '1', '30', '39', null, '2017-09-26 16:12:01', null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('44', '1', '31', '40', null, '2017-09-26 16:12:01', null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('45', '1', '31', '41', null, '2017-09-26 16:12:01', null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('47', '1', '32', '42', null, '2017-09-26 19:10:38', null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('48', '1', '33', '43', null, '2017-09-26 19:13:14', null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('49', '1', '34', '44', null, '2017-09-26 19:14:59', null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('50', '1', '35', '45', null, '2017-09-26 19:14:59', null, null, '0');
INSERT INTO `msg_template_type_ref` VALUES ('51', '1', '36', '46', null, '2017-09-26 19:14:59', null, null, '0');


UPDATE msg_template_type_ref SET tenant_id=_tenantId;

update resource set name = '全部客户',description = '全部客户' where id = 24;

UPDATE resource SET name=REPLACE(name,'审核','审批');



  IF NOT  EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'user_detail' AND column_name = 'card_uuid') THEN
        alter table user_detail add `card_uuid` varchar(64) DEFAULT NULL COMMENT '理财师UUID' AFTER `card_introduce`;
	END IF; 




/* 额度预约待确认 - 消息动态 开始 */
SELECT id INTO _msgReservationAuditId FROM msg_template WHERE code='reservation_audit_todo';
IF _msgReservationAuditId IS NULL
THEN

INSERT INTO msg_template (tenant_id, title, feed_content, message_content, app_content, need_push, push_content, index_content, app_action, pc_action, code, params, remark, create_user_id, create_date, update_user_id, update_date, is_delete)
VALUES (_tenantId, '额度预约待确认', null,'用户$!{userName}发起额度预约（$!{productName}，$!{reservationAmount}万），请及时处理','确认额度预约（$!{productName}，$!{reservationAmount}万）', 0, null, null, '', '/sale/appointment/audit', 'reservation_audit_todo', '{"userName":{"isBlank":false,"message":"消息动态：用户名称不能为空"},"productName":{"isBlank":false,"message":"消息动态：产品名称不能为空"},"reservationAmount":{"isBlank":false,"message":"消息动态：预约金额不能为空"}}', '有待确认的额度预约', null, null, null, null, 0);
SET _msgReservationAuditId=LAST_INSERT_ID();

INSERT INTO msg_template_type (tenant_id, name, type, first_type, two_type, create_user_id, create_date, update_user_id, update_date, is_delete)
VALUES (_tenantId, '有待确认的额度预约', 2, 1, 6, null, sysdate(), null, null, 0);

INSERT INTO msg_template_type_ref (tenant_id, template_id, type_id, create_user_id, create_date, update_user_id, update_date, is_delete)
SELECT _tenantId,_msgReservationAuditId,id,null,sysdate(),null,null,0 FROM msg_template_type WHERE name='有待确认的额度预约';

END IF;
/* 额度预约待确认 - 消息动态 结束 */


/* 报单待审批 - 消息动态 开始 */
SELECT id INTO _msgDeclarationAuditId FROM msg_template WHERE code='declaration_audit_todo';
IF _msgDeclarationAuditId IS NULL
THEN

INSERT INTO msg_template (tenant_id, title, feed_content, message_content, app_content, need_push, push_content, index_content, app_action, pc_action, code, params, remark, create_user_id, create_date, update_user_id, update_date, is_delete)
VALUES (_tenantId, '报单待审批', null,'用户$!{userName}新增报单（$!{productName}，$!{dealAmount}万，打款日期$!{payDate}），请及时处理','审批报单（$!{productName}，$!{dealAmount}万）', 0, null, null, '', '/sale/declaration/audit', 'declaration_audit_todo', '{"userName":{"isBlank":false,"message":"消息动态：用户名称不能为空"},"productName":{"isBlank":false,"message":"消息动态：产品名称不能为空"},"dealAmount":{"isBlank":false,"message":"消息动态：打款金额不能为空"}},"payDate":{"isBlank":false,"message":"消息动态：打款日期不能为空"}}', '有待审批的报单', null, null, null, null, 0);
SET _msgDeclarationAuditId=LAST_INSERT_ID();

INSERT INTO msg_template_type (tenant_id, name, type, first_type, two_type, create_user_id, create_date, update_user_id, update_date, is_delete)
VALUES (_tenantId, '有待审批的报单', 2, 1, 5, null, sysdate(), null, null, 0);

INSERT INTO msg_template_type_ref (tenant_id, template_id, type_id, create_user_id, create_date, update_user_id, update_date, is_delete)
SELECT _tenantId,_msgDeclarationAuditId,id,null,sysdate(),null,null,0 FROM msg_template_type WHERE name='有待审批的报单';

END IF;
/* 报单待审批 - 消息动态 结束 */


/* 额度预约已确认 - 消息动态 开始 */
SELECT id INTO _msgReservationApprovedId FROM msg_template WHERE code='reservation_approved';
IF _msgReservationApprovedId IS NULL
THEN

INSERT INTO msg_template (tenant_id, title, feed_content, message_content, app_content, need_push, push_content, index_content, app_action, pc_action, code, params, remark, create_user_id, create_date, update_user_id, update_date, is_delete)
VALUES (_tenantId, '额度预约已确认', '额度预约确认：$!{productName}，预约额度$!{reservationAmount}万，预计打款日期$!{estimatePayDate}
操作人：$!{createUserName}','您为客户$!{customerName}预约（$!{productName}，$!{reservationAmount}万）额度已确认','', 0, null, null, '', '/sale/appointment', 'reservation_approved', '', '额度预约已确认', null, null, null, null, 0);
SET _msgReservationApprovedId=LAST_INSERT_ID();

INSERT INTO msg_template_type (tenant_id, name, type, first_type, two_type, create_user_id, create_date, update_user_id, update_date, is_delete)
VALUES (_tenantId, '预约额度确认', 1, 2, 7, null, sysdate(), null, null, 0);

INSERT INTO msg_template_type (tenant_id, name, type, first_type, two_type, create_user_id, create_date, update_user_id, update_date, is_delete)
VALUES (_tenantId, '预约额度确认', 2, 2, 7, null, sysdate(), null, null, 0);

INSERT INTO msg_template_type_ref (tenant_id, template_id, type_id, create_user_id, create_date, update_user_id, update_date, is_delete)
SELECT _tenantId,_msgReservationApprovedId,id,null,sysdate(),null,null,0 FROM msg_template_type WHERE name='预约额度确认';

END IF;
/* 额度预约已确认 - 消息动态 结束 */


/* 额度预约被驳回 - 消息动态 开始 */
SELECT id INTO _msgReservationRejectId FROM msg_template WHERE code='reservation_reject';
IF _msgReservationRejectId IS NULL
THEN

INSERT INTO msg_template (tenant_id, title, feed_content, message_content, app_content, need_push, push_content, index_content, app_action, pc_action, code, params, remark, create_user_id, create_date, update_user_id, update_date, is_delete)
VALUES (_tenantId, '额度预约被驳回', '额度预约被驳回：$!{productName}，预约额度$!{reservationAmount}万，预计打款日期$!{estimatePayDate}，原因：$!{reason}
操作人：$!{createUserName}','您为客户$!{customerName}预约（$!{productName}，$!{reservationAmount}万）被$!{createUserName} 驳回，原因$!{reason}','', 0, null, null, '', '/sale/appointment', 'reservation_reject', '', '额度预约被驳回', null, null, null, null, 0);
SET _msgReservationRejectId=LAST_INSERT_ID();

INSERT INTO msg_template_type (tenant_id, name, type, first_type, two_type, create_user_id, create_date, update_user_id, update_date, is_delete)
VALUES (_tenantId, '预约额度被驳回', 1, 2, 7, null, sysdate(), null, null, 0);

INSERT INTO msg_template_type (tenant_id, name, type, first_type, two_type, create_user_id, create_date, update_user_id, update_date, is_delete)
VALUES (_tenantId, '预约额度被驳回', 2, 2, 7, null, sysdate(), null, null, 0);

INSERT INTO msg_template_type_ref (tenant_id, template_id, type_id, create_user_id, create_date, update_user_id, update_date, is_delete)
SELECT _tenantId,_msgReservationRejectId,id,null,sysdate(),null,null,0 FROM msg_template_type WHERE name='预约额度被驳回';

END IF;
/* 额度预约被驳回 - 消息动态 结束 */


	delete from role_resource where resource_id in (25,51);
	delete from resource where id in(25,51);

	
	
	IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'product_notice' AND column_name = 'apply_user_id') THEN
	   ALTER TABLE `product_notice`
         ADD COLUMN `apply_user_id`  bigint(20) NULL COMMENT '申请人id' AFTER `reason`;
	END IF; 
	
	
	IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'product_notice' AND column_name = 'apply_date') THEN
	  ALTER TABLE `product_notice`
         ADD COLUMN `apply_date`  datetime NULL COMMENT '申请时间' AFTER `apply_user_id`;
	END IF; 
	
	
	/* 销售线索对应角色 初始化数据 */
UPDATE data_object_access SET read_permission=40, edit_permission=10,delete_permission=0  WHERE data_object_id=12 AND
 role_id=1;
UPDATE data_object_access SET read_permission=10, edit_permission=10,delete_permission=0  WHERE data_object_id=12 AND role_id=2;
UPDATE data_object_access SET read_permission=10, edit_permission=10,delete_permission=0  WHERE data_object_id=12 AND role_id=3;
UPDATE data_object_access SET read_permission=10, edit_permission=10,delete_permission=0  WHERE data_object_id=12 AND role_id=4;
UPDATE data_object_access SET read_permission=10, edit_permission=10,delete_permission=0  WHERE data_object_id=12 AND role_id=5;
UPDATE data_object_access SET read_permission=40, edit_permission=10,delete_permission=0  WHERE data_object_id=12 AND role_id=6;
UPDATE data_object_access SET read_permission=40, edit_permission=10,delete_permission=0  WHERE data_object_id=12 AND role_id=7;


/*暂时删除 销售线索 和 跟进*/
UPDATE data_object SET is_delete=1 WHERE id IN(7,8);
UPDATE data_object_access SET is_delete=1 WHERE data_object_id IN(7,8);
UPDATE data_object_init SET is_delete=1 WHERE data_object_id IN(7,8);

UPDATE dictionary SET label=REPLACE(label,'审核','审批') WHERE label LIKE '%审核%';



UPDATE field SET name='SP基金类型' WHERE code='product_private_fund_type';

INSERT INTO `select_config`
 (`object_field_id`, `value`, `label`, `sequence`, `create_user_id`, `create_date`, `is_delete`)
SELECT of.id,0/*values*/,'量化对冲基金',0/*排序*/,1,SYSDATE(),0 FROM object_field of INNER JOIN field f ON of.field_id=f.id WHERE f.`name`='SP基金类型';

INSERT INTO `select_config`
 (`object_field_id`, `value`, `label`, `sequence`, `create_user_id`, `create_date`, `is_delete`)
SELECT of.id,1/*values*/,'私募证券基金',1/*排序*/,1,SYSDATE(),0 FROM object_field of INNER JOIN field f ON of.field_id=f.id WHERE f.`name`='SP基金类型';

INSERT INTO `select_config`
 (`object_field_id`, `value`, `label`, `sequence`, `create_user_id`, `create_date`, `is_delete`)
SELECT of.id,2/*values*/,'定增基金',2/*排序*/,1,SYSDATE(),0 FROM object_field of INNER JOIN field f ON of.field_id=f.id WHERE f.`name`='SP基金类型';

INSERT INTO `select_config`
 (`object_field_id`, `value`, `label`, `sequence`, `create_user_id`, `create_date`, `is_delete`)
SELECT of.id,3/*values*/,'股票／股票型基金',3/*排序*/,1,SYSDATE(),0 FROM object_field of INNER JOIN field f ON of.field_id=f.id WHERE f.`name`='SP基金类型';

INSERT INTO `select_config`
 (`object_field_id`, `value`, `label`, `sequence`, `create_user_id`, `create_date`, `is_delete`)
SELECT of.id,4/*values*/,'其他',4/*排序*/,1,SYSDATE(),0 FROM object_field of INNER JOIN field f ON of.field_id=f.id WHERE f.`name`='SP基金类型';

UPDATE select_config SET tenant_id=_tenantId;


    DELETE from user_customer where is_delete = 1;

    update resource set name = '预约额度审批'  where id= 29;

     update resource set name = '预约额度审批'  where id= 57;


     ALTER TABLE `product`
MODIFY COLUMN `time_limit`  varchar(200) NULL DEFAULT NULL COMMENT '投资期限' AFTER `invest_domain`;


UPDATE object_field SET field_type_id=1 WHERE field_id=4;
DELETE FROM number_config WHERE object_field_id=4 LIMIT 1;
UPDATE field_config SET max_length=200,min_length=1,max_value=NULL,min_value=1 WHERE object_field_id=4;

UPDATE field SET name='账户名称' WHERE code='product_account_name' LIMIT 1;


SELECT child.id INTO _newFollowTypeCount FROM dictionary child LEFT JOIN dictionary parent ON child.parent_id=parent.id WHERE child.label='来访参观' AND parent.value='dic_follow_up_type';

IF _newFollowTypeCount IS NULL
THEN

DELETE FROM dictionary WHERE parent_id IN(
SELECT * FROM(
SELECT id FROM dictionary WHERE `value`='dic_follow_up_type') t);


INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'电话联系','1','1', '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_follow_up_type';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'微信沟通','2','2', '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_follow_up_type';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'上门拜访','3','3', '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_follow_up_type';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'发短信','4','4', '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_follow_up_type';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'发邮件','5','5', '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_follow_up_type';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'产品路演','6','6', '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_follow_up_type';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'市场活动','7','7', '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_follow_up_type';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'来访参观','8','8', '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_follow_up_type';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'其他','9','9', '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_follow_up_type';

END IF;

UPDATE field SET create_date='2017-07-16 22:42:59' WHERE  code='product_pay_account';
UPDATE field SET create_date='2017-07-16 22:42:58' WHERE  code='product_account_name';
UPDATE field SET create_date='2017-07-16 22:42:57' WHERE  code='product_raise_bank';
UPDATE field SET create_date='2017-07-16 22:42:56' WHERE  code='product_pay_remark';


UPDATE resource SET name='放弃' WHERE  code ='customer.back.apply';

UPDATE dictionary
SET label = '已跟进'
WHERE parent_id = 100153 AND value = 1;
UPDATE dictionary
SET label = '作废'
WHERE parent_id = 100153 AND value = 2;

end;

call tenant_sql_update();

DROP PROCEDURE if exists tenant_sql_update;






drop procedure if exists tenant_sql_update;

create procedure tenant_sql_update()
begin
        declare i int default 1;
         loop_name:loop -- 循环开始
             if i>4 then 
                 leave loop_name;  -- 判断条件成立则结束循环  好比java中的 boeak
             end if;
             		IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 1 and is_delete = 0) THEN
								 update field_group_rel set sequence = 10 where field_group_id = i and object_field_id = 1 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 2 and is_delete = 0) THEN
								 update field_group_rel set sequence = 20 where field_group_id = i and object_field_id = 2 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 3 and is_delete = 0) THEN
								 update field_group_rel set sequence = 30 where field_group_id = i and object_field_id = 3 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 4 and is_delete = 0) THEN
								 update field_group_rel set sequence = 40 where field_group_id = i and object_field_id = 4 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 5 and is_delete = 0) THEN
								 update field_group_rel set sequence = 50 where field_group_id = i and object_field_id = 5 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 6 and is_delete = 0) THEN
								 update field_group_rel set sequence = 60 where field_group_id = i and object_field_id = 6 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 7 and is_delete = 0) THEN
								 update field_group_rel set sequence = 70 where field_group_id = i and object_field_id = 7 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 8 and is_delete = 0) THEN
								 update field_group_rel set sequence = 80 where field_group_id = i and object_field_id = 8 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 9 and is_delete = 0) THEN
								 update field_group_rel set sequence = 90 where field_group_id = i and object_field_id = 9 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 10 and is_delete = 0) THEN
								 update field_group_rel set sequence = 100 where field_group_id = i and object_field_id = 10 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 11 and is_delete = 0) THEN
								 update field_group_rel set sequence = 110 where field_group_id = i and object_field_id = 11 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 12 and is_delete = 0) THEN
								 update field_group_rel set sequence = 120 where field_group_id = i and object_field_id = 12 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 13 and is_delete = 0) THEN
								 update field_group_rel set sequence = 130 where field_group_id = i and object_field_id = 13 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 14 and is_delete = 0) THEN
								 update field_group_rel set sequence = 140 where field_group_id = i and object_field_id = 14 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 17 and is_delete = 0) THEN
								 update field_group_rel set sequence = 145 where field_group_id = i and object_field_id = 17 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 15 and is_delete = 0) THEN
								 update field_group_rel set sequence = 150 where field_group_id = i and object_field_id = 15 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 16 and is_delete = 0) THEN
								 update field_group_rel set sequence = 160 where field_group_id = i and object_field_id = 16 and is_delete = 0 ;
					END IF;	
					
					
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 19 and is_delete = 0) THEN
								 update field_group_rel set sequence = 190 where field_group_id = i and object_field_id = 19 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 20 and is_delete = 0) THEN
								 update field_group_rel set sequence = 200 where field_group_id = i and object_field_id = 20 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 21 and is_delete = 0) THEN
								 update field_group_rel set sequence = 210 where field_group_id = i and object_field_id = 21 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 22 and is_delete = 0) THEN
								 update field_group_rel set sequence = 220 where field_group_id = i and object_field_id = 22 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 23 and is_delete = 0) THEN
								 update field_group_rel set sequence = 230 where field_group_id = i and object_field_id = 23 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 24 and is_delete = 0) THEN
								 update field_group_rel set sequence = 240 where field_group_id = i and object_field_id = 24 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 25 and is_delete = 0) THEN
								 update field_group_rel set sequence = 250 where field_group_id = i and object_field_id = 25 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 26 and is_delete = 0) THEN
								 update field_group_rel set sequence = 260 where field_group_id = i and object_field_id = 26 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 27 and is_delete = 0) THEN
								 update field_group_rel set sequence = 270 where field_group_id = i and object_field_id = 27 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 28 and is_delete = 0) THEN
								 update field_group_rel set sequence = 280 where field_group_id = i and object_field_id = 28 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 29 and is_delete = 0) THEN
								 update field_group_rel set sequence = 290 where field_group_id = i and object_field_id = 29 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 30 and is_delete = 0) THEN
								 update field_group_rel set sequence = 300 where field_group_id = i and object_field_id = 30 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 31 and is_delete = 0) THEN
								 update field_group_rel set sequence = 310 where field_group_id = i and object_field_id = 31 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 32 and is_delete = 0) THEN
								 update field_group_rel set sequence = 320 where field_group_id = i and object_field_id = 32 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 33 and is_delete = 0) THEN
								 update field_group_rel set sequence = 330 where field_group_id = i and object_field_id = 33 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 34 and is_delete = 0) THEN
								 update field_group_rel set sequence = 340 where field_group_id = i and object_field_id = 34 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 35 and is_delete = 0) THEN
								 update field_group_rel set sequence = 350 where field_group_id = i and object_field_id = 35 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 36 and is_delete = 0) THEN
								 update field_group_rel set sequence = 360 where field_group_id = i and object_field_id = 36 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 37 and is_delete = 0) THEN
								 update field_group_rel set sequence = 370 where field_group_id = i and object_field_id = 37 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 38 and is_delete = 0) THEN
								 update field_group_rel set sequence = 380 where field_group_id = i and object_field_id = 38 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 39 and is_delete = 0) THEN
								 update field_group_rel set sequence = 390 where field_group_id = i and object_field_id = 39 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 40 and is_delete = 0) THEN
								 update field_group_rel set sequence = 400 where field_group_id = i and object_field_id = 40 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 41 and is_delete = 0) THEN
								 update field_group_rel set sequence = 410 where field_group_id = i and object_field_id = 41 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 42 and is_delete = 0) THEN
								 update field_group_rel set sequence = 420 where field_group_id = i and object_field_id = 42 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 43 and is_delete = 0) THEN
								 update field_group_rel set sequence = 430 where field_group_id = i and object_field_id = 43 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 18 and is_delete = 0) THEN
								 update field_group_rel set sequence = 440 where field_group_id = i and object_field_id = 18 and is_delete = 0 ;
					END IF;	
					IF  EXISTS (select * from field_group_rel where field_group_id = i and object_field_id = 44 and is_delete = 0) THEN
								 update field_group_rel set sequence = 450 where field_group_id = i and object_field_id = 44 and is_delete = 0 ;
					END IF;	
					
					

             set i=i+1;
         end loop;  -- 循环结束　　


UPDATE select_config SET sequence=0 WHERE  object_field_id=10 AND value=1;
UPDATE select_config SET sequence=1 WHERE  object_field_id=10 AND value=0;

end; -- 整个函数的结果标记

call tenant_sql_update();

DROP PROCEDURE if exists tenant_sql_update;


//