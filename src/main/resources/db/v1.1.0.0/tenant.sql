delimiter //

DROP PROCEDURE if exists tenant_sql_update_1_1;

create procedure tenant_sql_update_1_1()
begin

DECLARE _tenantId BIGINT;
DECLARE _msgReservationDiscard BIGINT;
DECLARE _msgDeclarationDiscard BIGINT;

SELECT tenant_id INTO _tenantId FROM user_account LIMIT 1;

IF NOT EXISTS (SELECT * FROM resource WHERE id=77)
THEN

INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (77,_tenantId, 'finance', 'WM', '0', '财务管理', '/finance/', '1', '1', NULL, '财务管理', '60', '-1', SYSDATE(), NULL, NULL, '0');

END IF;



IF NOT EXISTS (SELECT * FROM resource WHERE id=78)
THEN

INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
SELECT 78,_tenantId, 'finance.receiptplan', 'WM', id, '回款计划管理', '/finance/receiptplan', '1', '1', NULL, '回款计划管理', '10', '-1', SYSDATE(), NULL, NULL, '0' FROM resource WHERE code='finance' LIMIT 1;

END IF;


IF NOT EXISTS (SELECT * FROM resource WHERE id=79)
THEN

INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
SELECT 79,_tenantId, 'finance.knotcommission', 'WM', id, '结佣管理', '/finance/knotcommission', '1', '1', NULL, '结佣管理', '20', '-1', SYSDATE(), NULL, NULL, '0' FROM resource WHERE code='finance' LIMIT 1;

END IF;


IF NOT EXISTS (SELECT * FROM resource WHERE id=80)
THEN

INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
SELECT 80,_tenantId, 'finance.knotcommission.audit', 'WM', id, '结佣审批', '/finance/knotcommission/audit', '1', '1', NULL, '结佣审批', '20', '-1', SYSDATE(), NULL, NULL, '0' FROM resource WHERE code='finance' LIMIT 1;

END IF;




IF NOT EXISTS (SELECT * FROM resource WHERE id=81)
THEN

INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
SELECT 81,_tenantId, 'sale.refunds', 'WM', id, '我的退款', '/sale/refunds', '1', '1', NULL, '我的退款', '31', '-1', SYSDATE(), NULL, NULL, '0' FROM resource WHERE code='sale' LIMIT 1;

END IF;


IF NOT EXISTS (SELECT * FROM resource WHERE id=82)
THEN

INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
SELECT 82,_tenantId, 'sale.refunds.audit', 'WM', id, '退款审批', '/sale/refunds/audit', '1', '1', NULL, '退款审批', '51', '-1', SYSDATE(), NULL, NULL, '0' FROM resource WHERE code='sale' LIMIT 1;

END IF;


IF NOT EXISTS (SELECT * FROM resource WHERE id=83)
THEN

INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
SELECT 83,_tenantId, 'refund.audit.do', 'WM', id, '退款审批', '/refund/audit/do', '0', '1', NULL, '退款审批', '51', '-1', SYSDATE(), NULL, NULL, '0' FROM resource WHERE code='sale.refunds.audit' LIMIT 1;

END IF;


IF NOT EXISTS (SELECT * FROM resource WHERE id=84)
THEN

INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
SELECT 84,_tenantId, 'knot.commission.audit', 'WM', id, '结佣审批', '/knot/commission/audit', '0', '1', NULL, '结佣审批', '51', '-1', SYSDATE(), NULL, NULL, '0' FROM resource WHERE code='finance.knotcommission.audit' LIMIT 1;

END IF;

IF NOT EXISTS (SELECT * FROM resource WHERE id=85)
THEN

INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
SELECT 85,_tenantId, 'declaration.apply_refund', 'WM', id, '申请退款', '/declaration/apply_refund', '0', '1', NULL, '申请退款', '10', '-1', SYSDATE(), NULL, NULL, '0' FROM resource WHERE code='sale.refunds' LIMIT 1;

END IF;

IF NOT EXISTS (SELECT * FROM resource WHERE id=86)
THEN

INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
SELECT 86,_tenantId, 'receipt.plan.add', 'WM', id, '新增回款计划', '/receipt/plan/add', '0', '1', NULL, '新增回款计划', '10', '-1', SYSDATE(), NULL, NULL, '0' FROM resource WHERE code='finance.receiptplan' LIMIT 1;

END IF;


	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 77 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (77, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 78 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (78, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 79 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (79, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 80 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (80, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 81 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (81, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 82 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (82, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 83 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (83, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 84 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (84, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 85 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (85, 1);
	END IF;
		IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 86 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (86, 1);
	END IF;
	
	
	IF  EXISTS (select * from resource where  id= 11 and is_delete = 0) THEN
       update resource set parent_id = 9 ,url = '/product/add' ,is_menu = 0 where id = 11;
	END IF;


	IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'declaration' AND column_name = 'audit_status') THEN
	   	ALTER TABLE `declaration`
             CHANGE COLUMN `status` `audit_status`  tinyint(4) NULL DEFAULT NULL COMMENT '审批状态，  1：审核中  2：审核通过  3：驳回修改  4： 已取消 ' AFTER `reason`;
	END IF; 
	

    IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'declaration' AND column_name = 'status') THEN
	     ALTER TABLE `declaration`
          ADD COLUMN `status`  tinyint(4) NULL COMMENT '报单状态，  1：审核中  2：审核通过  3：驳回修改  4： 已取消  5: 已作废' AFTER `audit_status`;
          
         update declaration set status = audit_status;
	END IF; 


	
		
	IF  EXISTS (select * from declaration_discard dd LEFT JOIN declaration d on dd.declaration_id = d.id where d.`status` = 2) THEN
	    update declaration set `status` = 5 where id in (
			select a.id from (
			   select d.id from declaration_discard dd LEFT JOIN declaration d on dd.declaration_id = d.id where d.`status` = 2
			)as a
		)and `status` = 2;
	END IF;
	

/*==============================================================*/
/* Table: declaration_refund                                    */
/*==============================================================*/
create table IF NOT EXISTS declaration_refund
(
   id                   bigint(20) not null auto_increment,
   tenant_id            bigint(20) comment '租户ID',
   declaration_id       bigint(20) comment '报单ID',
   reason               varchar(256) comment '退款原因',
   status               tinyint(2) comment '1、待审批 2、已通过 3、已驳回',
   operation_date       datetime comment '操作时间',
   user_id              bigint(20) comment '流程发起人',
   audit_date           datetime comment '审批时间',
   apply_date           datetime comment '申请时间',
   audit_reason         varchar(256) comment '审批原因',
   create_user_id       bigint(20) comment '创建人',
   create_date          datetime comment '创建时间',
   update_user_id       bigint(20) comment '修改人',
   update_date          datetime comment '修改时间',
   is_delete            tinyint(2) default 0 comment '是否删除',
   primary key (id)
);

alter table declaration_refund comment '报单退款表';

IF NOT EXISTS (SELECT * FROM information_schema.statistics WHERE table_schema=DATABASE() AND table_name = 'declaration_refund' AND index_name = 'declaration_id_index') THEN
 create index declaration_id_index on declaration_refund
(
   declaration_id
);
END IF;


/*==============================================================*/
/* Table: knot_commission                                       */
/*==============================================================*/
create table IF NOT EXISTS knot_commission
(
   id                   bigint(20) not null auto_increment,
   tenant_id            bigint(20) comment '租户ID',
   declaration_id       bigint(20) comment '报单ID',
   type                 varchar(32) comment '佣金类型',
   rate                 double comment '佣金费率',
   amount               double comment '佣金金额',
   provide_date         datetime comment '发放时间',
   remark               varchar(512) comment '备注',
   status               tinyint(2) comment '1、待审批 2、已通过 3、已驳回',
   operation_date       datetime comment '操作时间',
   user_id              bigint(20) comment '流程发起人',
   audit_date           datetime comment '审批时间',
   apply_date           datetime comment '申请时间',
   audit_reason         varchar(256) comment '审批原因',
   create_user_id       bigint(20) comment '创建人',
   create_date          datetime comment '创建时间',
   update_user_id       bigint(20) comment '修改人',
   update_date          datetime comment '修改时间',
   is_delete            tinyint(2) default 0 comment '是否删除',
   primary key (id)
);

alter table knot_commission comment '结佣记录表';

/*==============================================================*/
/* Index: declaration_id_index                                  */
/*==============================================================*/

IF NOT EXISTS (SELECT * FROM information_schema.statistics WHERE table_schema=DATABASE() AND table_name = 'knot_commission' AND index_name = 'declaration_id_index') THEN
 create index declaration_id_index on knot_commission
(
   declaration_id
);
END IF;

/*==============================================================*/
/* Index: tenant_id_index                                       */
/*==============================================================*/

IF NOT EXISTS (SELECT * FROM information_schema.statistics WHERE table_schema=DATABASE() AND table_name = 'knot_commission' AND index_name = 'tenant_id_index') THEN
create index tenant_id_index on knot_commission
(
   tenant_id
);
END IF;



/*==============================================================*/
/* Table: receipt_declaration                                   */
/*==============================================================*/
create table IF NOT EXISTS receipt_declaration
(
   id                   bigint(20) not null auto_increment,
   tenant_id            bigint(20) comment '租户ID',
   receipt_plan_id      bigint(20) comment '回款计划ID',
   declaration_id       bigint(20) comment '报单ID',
   create_user_id       bigint(20) comment '创建人',
   create_date          datetime comment '创建时间',
   update_user_id       bigint(20) comment '修改人',
   update_date          datetime comment '修改时间',
   is_delete            tinyint(2) default 0 comment '是否删除',
   primary key (id)
);

alter table receipt_declaration comment '回款报单关系表';

/*==============================================================*/
/* Index: receipt_plan_id_index                                 */
/*==============================================================*/
IF NOT EXISTS (SELECT * FROM information_schema.statistics WHERE table_schema=DATABASE() AND table_name = 'receipt_declaration' AND index_name = 'receipt_plan_id_index') THEN
create index receipt_plan_id_index on receipt_declaration
(
   receipt_plan_id
);
END IF;

/*==============================================================*/
/* Index: tenant_id_index                                       */
/*==============================================================*/


IF NOT EXISTS (SELECT * FROM information_schema.statistics WHERE table_schema=DATABASE() AND table_name = 'receipt_declaration' AND index_name = 'tenant_id_index') THEN
create index tenant_id_index on receipt_declaration
(
   tenant_id
);
END IF;

/*==============================================================*/
/* Index: declaration_id_index                                  */
/*==============================================================*/

IF NOT EXISTS (SELECT * FROM information_schema.statistics WHERE table_schema=DATABASE() AND table_name = 'receipt_declaration' AND index_name = 'declaration_id_index') THEN
create index declaration_id_index on receipt_declaration
(
   declaration_id
);
END IF;


/*==============================================================*/
/* Table: receipt_plan                                          */
/*==============================================================*/
create table IF NOT EXISTS receipt_plan
(
   id                   bigint(20) not null auto_increment,
   tenant_id            bigint(20) comment '租户ID',
   name                 varchar(64) comment '回款计划名称',
   product_id           bigint(20) comment '回款产品',
   product_supplier_id  bigint(20) comment '供应商',
   amount               double comment '计划回款金额',
   pay_unit             varchar(128) comment '付款单位',
   index_content        varchar(128) comment '首页内容',
   remark               varchar(512) comment '备注',
   create_user_id       bigint(20) comment '创建人',
   create_date          datetime comment '创建时间',
   update_user_id       bigint(20) comment '修改人',
   update_date          datetime comment '修改时间',
   is_delete            tinyint(2) default 0 comment '是否删除',
   primary key (id)
);

alter table receipt_plan comment '回款计划表';

/*==============================================================*/
/* Index: code_index                                            */
/*==============================================================*/

IF NOT EXISTS (SELECT * FROM information_schema.statistics WHERE table_schema=DATABASE() AND table_name = 'receipt_plan' AND index_name = 'product_id_index') THEN
create index product_id_index on receipt_plan
(
   product_id
);
END IF;

/*==============================================================*/
/* Index: tenant_id_index                                       */
/*==============================================================*/

IF NOT EXISTS (SELECT * FROM information_schema.statistics WHERE table_schema=DATABASE() AND table_name = 'receipt_plan' AND index_name = 'tenant_id_index') THEN
create index tenant_id_index on receipt_plan
(
   tenant_id
);
END IF;

/*==============================================================*/
/* Table: receipt_record                                        */
/*==============================================================*/
create table IF NOT EXISTS receipt_record
(
   id                   bigint(20) not null auto_increment,
   tenant_id            bigint(20) comment '租户ID',
   receipt_plan_id      bigint(20) comment '回款记录ID',
   amount               double comment '回款金额',
   pay_date             datetime comment '回款日期',
   pay_unit             varchar(64) comment '回款单位',
   bank_name            varchar(64) comment '回款银行',
   pay_account          varchar(32) comment '回款账号',
   is_invoiced          tinyint(2) comment '是否开具发票',
   invoiced_date        datetime comment '开票时间',
   remark               varchar(512) comment '备注',
   create_user_id       bigint(20) comment '创建人',
   create_date          datetime comment '创建时间',
   update_user_id       bigint(20) comment '修改人',
   update_date          datetime comment '修改时间',
   is_delete            tinyint(2) default 0 comment '是否删除',
   primary key (id)
);

alter table receipt_record comment '回款记录表';

/*==============================================================*/
/* Index: receipt_plan_id                                       */
/*==============================================================*/

IF NOT EXISTS (SELECT * FROM information_schema.statistics WHERE table_schema=DATABASE() AND table_name = 'receipt_record' AND index_name = 'receipt_plan_id_index') THEN
create index receipt_plan_id_index on receipt_record
(
   receipt_plan_id
);
END IF;

/*==============================================================*/
/* Index: tenant_id_index                                       */
/*==============================================================*/

IF NOT EXISTS (SELECT * FROM information_schema.statistics WHERE table_schema=DATABASE() AND table_name = 'receipt_record' AND index_name = 'tenant_id_index') THEN
create index tenant_id_index on receipt_record
(
   tenant_id
);
END IF;



    IF NOT EXISTS (select * from dictionary d LEFT JOIN dictionary p on d.parent_id = p.id where d.`value` = 5 and p.`value` = 'dic_declaration_status') THEN
	     insert INTO dictionary(tenant_id,parent_id,label,value) select _tenantId,id,'已作废','5' FROM dictionary where value='dic_declaration_status' limit 1;
	END IF; 



	IF NOT EXISTS (select * from dictionary d where d.`value` = 'dic_declaration_audit_status') THEN
	     insert INTO dictionary(tenant_id,parent_id,label,value)VALUES(_tenantId,0,'报单审批状态','dic_declaration_audit_status');
	END IF; 
	
	
    IF NOT EXISTS (select * from dictionary d LEFT JOIN dictionary p on d.parent_id = p.id where d.`value` = 1 and p.`value` = 'dic_declaration_audit_status') THEN
	     insert INTO dictionary(tenant_id,parent_id,label,value) select _tenantId,id,'待审批','1' FROM dictionary where value='dic_declaration_audit_status' limit 1;
	END IF; 
	
    IF NOT EXISTS (select * from dictionary d LEFT JOIN dictionary p on d.parent_id = p.id where d.`value` = 2 and p.`value` = 'dic_declaration_audit_status') THEN
	     insert INTO dictionary(tenant_id,parent_id,label,value) select _tenantId,id,'已通过','2' FROM dictionary where value='dic_declaration_audit_status' limit 1;
	END IF; 
	
    IF NOT EXISTS (select * from dictionary d LEFT JOIN dictionary p on d.parent_id = p.id where d.`value` = 3 and p.`value` = 'dic_declaration_audit_status') THEN
	     insert INTO dictionary(tenant_id,parent_id,label,value) select _tenantId,id,'已驳回','3' FROM dictionary where value='dic_declaration_audit_status' limit 1;
	END IF; 
	
    IF NOT EXISTS (select * from dictionary d LEFT JOIN dictionary p on d.parent_id = p.id where d.`value` = 4 and p.`value` = 'dic_declaration_audit_status') THEN
	     insert INTO dictionary(tenant_id,parent_id,label,value) select _tenantId,id,'已取消','4' FROM dictionary where value='dic_declaration_audit_status' limit 1;
	END IF; 
	
    IF NOT EXISTS (select * from dictionary d LEFT JOIN dictionary p on d.parent_id = p.id where d.`value` = 5 and p.`value` = 'dic_reservation_status') THEN
	     insert INTO dictionary(tenant_id,parent_id,label,value) select _tenantId,id,'已作废','5' FROM dictionary where value='dic_reservation_status' limit 1;
	END IF; 
	
	
		
	ALTER TABLE `declaration`
MODIFY COLUMN `status`  tinyint(4) NULL DEFAULT NULL COMMENT '报单状态，  1：审核中  2：审核通过  3：驳回修改  4： 已取消  5: 已作废  6:已退款' AFTER `audit_status`;
	

	
	IF NOT EXISTS (select * from dictionary d where d.`value` = 'dic_reservation_audit_status') THEN
	     insert INTO dictionary(tenant_id,parent_id,label,value)VALUES(_tenantId,0,'预约审批状态','dic_reservation_audit_status');
	END IF; 
	
	
    IF NOT EXISTS (select * from dictionary d LEFT JOIN dictionary p on d.parent_id = p.id where d.`value` = 1 and p.`value` = 'dic_reservation_audit_status') THEN
	     insert INTO dictionary(tenant_id,parent_id,label,value) select _tenantId,id,'待审批','1' FROM dictionary where value='dic_reservation_audit_status' limit 1;
	END IF; 
	
    IF NOT EXISTS (select * from dictionary d LEFT JOIN dictionary p on d.parent_id = p.id where d.`value` = 2 and p.`value` = 'dic_reservation_audit_status') THEN
	     insert INTO dictionary(tenant_id,parent_id,label,value) select _tenantId,id,'已通过','2' FROM dictionary where value='dic_reservation_audit_status' limit 1;
	END IF; 
	
    IF NOT EXISTS (select * from dictionary d LEFT JOIN dictionary p on d.parent_id = p.id where d.`value` = 3 and p.`value` = 'dic_reservation_audit_status') THEN
	     insert INTO dictionary(tenant_id,parent_id,label,value) select _tenantId,id,'已驳回','3' FROM dictionary where value='dic_reservation_audit_status' limit 1;
	END IF; 
	
    IF NOT EXISTS (select * from dictionary d LEFT JOIN dictionary p on d.parent_id = p.id where d.`value` = 4 and p.`value` = 'dic_reservation_audit_status') THEN
	     insert INTO dictionary(tenant_id,parent_id,label,value) select _tenantId,id,'已取消','4' FROM dictionary where value='dic_reservation_audit_status' limit 1;
	END IF; 
	
	
	IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'reservation' AND column_name = 'audit_status') THEN
	    ALTER TABLE `reservation`
          MODIFY COLUMN `status`  tinyint(4) NULL DEFAULT NULL COMMENT '预约状态， 0：未提交  1：审核中  2：已通过  3：已驳回  4： 已取消 5: 已作废' AFTER `reason`;
	
	    ALTER TABLE `reservation`
          ADD COLUMN `audit_status`  tinyint(4) NULL COMMENT '预约审批状态， 0：未提交  1：审核中  2：已通过  3：已驳回  4： 已取消' AFTER `status`;
          
        update reservation set audit_status = status;
	    IF  EXISTS (select * from reservation_discard rd LEFT JOIN reservation r on rd.reservation_id = r.id where r.`status` = 2) THEN
		    update reservation set `status` = 5 where id in (
				select a.id from (
				   select r.id from reservation_discard rd LEFT JOIN reservation r on rd.reservation_id = r.id where r.`status` = 2
				)as a
			)and `status` = 2;
		END IF;
	END IF; 
	

	IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'product' AND column_name = 'declaration_model') THEN
	   ALTER TABLE `product`
            ADD COLUMN `declaration_model`  tinyint(4) NULL DEFAULT 2 COMMENT '报单模式： 1：直接报单: 2：先预约在报单' AFTER `issued_status`;
	END IF; 


IF NOT EXISTS (SELECT * FROM dictionary WHERE value='dic_receipt_record_is_invoiced')
THEN
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`) VALUES
(_tenantId, '0', '是否开具发票', 'dic_receipt_record_is_invoiced', '1', '1', SYSDATE(), 1, '0');
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'已开票','1','1', '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_receipt_record_is_invoiced';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'未开票','0','2', '2', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_receipt_record_is_invoiced';
	END IF;

	IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'customer' AND column_name = 'belong_type') THEN
			ALTER TABLE `customer`
		ADD COLUMN `belong_type`  tinyint(4) NULL COMMENT '属于类型（0： 私人，1：公海,2：销售线索）' AFTER `status`;   
		 update customer set belong_type = 0  where id in (select customer_id from user_customer );
		 update customer set belong_type = 1  where  belong_type is null;
	END IF; 

IF NOT EXISTS (SELECT * FROM dictionary WHERE value='dic_knotcommission_status')
THEN
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`) VALUES
(_tenantId, '0', '结佣审批状态', 'dic_knotcommission_status', '1', '1', SYSDATE(), 1, '0');
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'待审批','1','1', '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_knotcommission_status';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'已通过','2','2', '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_knotcommission_status';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'已否决','5','3', '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_knotcommission_status';
	END IF;


IF NOT EXISTS (SELECT * FROM dictionary WHERE value='dic_knotcommission_type')
THEN
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`) VALUES
(_tenantId, '0', '结佣佣金类型', 'dic_knotcommission_type', '1', '1', SYSDATE(), 1, '0');
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'前端佣金','dic_knotcommission_type_front','1', '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_knotcommission_type';
INSERT INTO `dictionary` (`tenant_id`, `parent_id`, `label`, `value`, `sequence`, `is_enabled`, `create_date`, `create_user_id`, `is_delete`)
SELECT _tenantId,id,'后端佣金','dic_knotcommission_type_back','2', '1', SYSDATE(), 1, '0' FROM dictionary WHERE `value`='dic_knotcommission_type';

	END IF;

/* 消息模板*/
SELECT id INTO _msgReservationDiscard FROM msg_template WHERE code='reservation_discard';
IF _msgReservationDiscard IS NULL
THEN

INSERT INTO msg_template (tenant_id, title, feed_content, message_content, app_content, need_push, push_content, index_content, app_action, pc_action, code, params, remark, create_user_id, create_date, update_user_id, update_date, is_delete)
VALUES (_tenantId, '额度预约被作废', '额度预约被作废：$!{productName}，预约额度$!{dealAmount}，预计打款日期$!{dealTime}，原因：$!{reason}
操作人：$!{audioName}','您为客户$!{customerName}预约（$!{productName}，$!{dealAmount}）被$!{audioName} 作废，原因：$!{reason}','您为客户$!{customerName}预约（$!{productName}，$!{dealAmount}）被$!{audioName} 作废，原因：$!{reason}', 0, null, null, 'yundaojinfub://www.yundaoorder.com/appoint_detail?reservationId=$!{reservationId}', '/sale/appointment', 'reservation_discard', '', '额度预约被作废', null, null, null, null, 0);
SET _msgReservationDiscard=LAST_INSERT_ID();

INSERT INTO msg_template_type (tenant_id, name, type, first_type, two_type, create_user_id, create_date, update_user_id, update_date, is_delete)
VALUES (_tenantId, '额度预约被作废', 2, 2, 7, null, sysdate(), null, null, 0);

INSERT INTO msg_template_type_ref (tenant_id, template_id, type_id, create_user_id, create_date, update_user_id, update_date, is_delete)
SELECT _tenantId,_msgReservationDiscard,id,null,sysdate(),null,null,0 FROM msg_template_type WHERE name='额度预约被作废' order by id desc limit 1;

INSERT INTO msg_template_type (tenant_id, name, type, first_type, two_type, create_user_id, create_date, update_user_id, update_date, is_delete)
VALUES (_tenantId, '额度预约被作废', 1, 2, 2, null, sysdate(), null, null, 0);

INSERT INTO msg_template_type_ref (tenant_id, template_id, type_id, create_user_id, create_date, update_user_id, update_date, is_delete)
SELECT _tenantId,_msgReservationDiscard,id,null,sysdate(),null,null,0 FROM msg_template_type WHERE name='额度预约被作废' order by id desc limit 1;
END IF;


SELECT id INTO _msgDeclarationDiscard FROM msg_template WHERE code='declaration_discard';
IF _msgDeclarationDiscard IS NULL
THEN

INSERT INTO msg_template (tenant_id, title, feed_content, message_content, app_content, need_push, push_content, index_content, app_action, pc_action, code, params, remark, create_user_id, create_date, update_user_id, update_date, is_delete)
VALUES (_tenantId, '报单被作废', '报单被作废：$!{productName}，打款金额$!{dealAmount}，打款日期$!{dealTime}，原因：$!{reason}
操作人：$!{audioName}','您为客户$!{customerName}认购（$!{productName}，$!{dealAmount}，$!{dealTime}）的报单被$!{audioName} 作废，原因：$!{reason}','您为客户$!{customerName}认购（$!{productName}，$!{dealAmount}，$!{dealTime}）的报单被$!{audioName} 作废，原因：$!{reason}', 0, null, null, 'yundaojinfub://www.yundaoorder.com/order_detail?orderId=$!{id}', '/declaration/detail/$!{id}', 'declaration_discard', '', '报单被作废', null, null, null, null, 0);
SET _msgDeclarationDiscard=LAST_INSERT_ID();

INSERT INTO msg_template_type (tenant_id, name, type, first_type, two_type, create_user_id, create_date, update_user_id, update_date, is_delete)
VALUES (_tenantId, '报单被作废', 2, 2, 7, null, sysdate(), null, null, 0);

INSERT INTO msg_template_type_ref (tenant_id, template_id, type_id, create_user_id, create_date, update_user_id, update_date, is_delete)
SELECT _tenantId,_msgDeclarationDiscard,id,null,sysdate(),null,null,0 FROM msg_template_type WHERE name='报单被作废' order by id desc limit 1;

INSERT INTO msg_template_type (tenant_id, name, type, first_type, two_type, create_user_id, create_date, update_user_id, update_date, is_delete)
VALUES (_tenantId, '报单被作废', 1, 2, 2, null, sysdate(), null, null, 0);

INSERT INTO msg_template_type_ref (tenant_id, template_id, type_id, create_user_id, create_date, update_user_id, update_date, is_delete)
SELECT _tenantId,_msgDeclarationDiscard,id,null,sysdate(),null,null,0 FROM msg_template_type WHERE name='报单被作废' order by id desc limit 1;
END IF;



	IF NOT EXISTS (select * from dictionary d where d.`value` = 'dic_refund_status') THEN
	     insert INTO dictionary(tenant_id,parent_id,label,value)VALUES(_tenantId,0,'预约审批状态','dic_refund_status');
	END IF; 
    IF NOT EXISTS (select * from dictionary d LEFT JOIN dictionary p on d.parent_id = p.id where d.`value` = 1 and p.`value` = 'dic_refund_status') THEN
	     insert INTO dictionary(tenant_id,parent_id,label,value) select _tenantId,id,'待审批','1' FROM dictionary where value='dic_refund_status' limit 1;
	END IF; 
	
    IF NOT EXISTS (select * from dictionary d LEFT JOIN dictionary p on d.parent_id = p.id where d.`value` = 2 and p.`value` = 'dic_refund_status') THEN
	     insert INTO dictionary(tenant_id,parent_id,label,value) select _tenantId,id,'已通过','2' FROM dictionary where value='dic_refund_status' limit 1;
	END IF; 
	
    IF NOT EXISTS (select * from dictionary d LEFT JOIN dictionary p on d.parent_id = p.id where d.`value` = 3 and p.`value` = 'dic_refund_status') THEN
	     insert INTO dictionary(tenant_id,parent_id,label,value) select _tenantId,id,'已驳回','3' FROM dictionary where value='dic_refund_status' limit 1;
	END IF; 
	
    IF NOT EXISTS (select * from dictionary d LEFT JOIN dictionary p on d.parent_id = p.id where d.`value` = 4 and p.`value` = 'dic_refund_status') THEN
	     insert INTO dictionary(tenant_id,parent_id,label,value) select _tenantId,id,'已取消','4' FROM dictionary where value='dic_refund_status' limit 1;

	END IF;
	
	update resource set name = '组织架构管理' , description ='组织架构管理' where id = 6;

	
	
	IF NOT EXISTS (select * from dictionary d LEFT JOIN dictionary p on d.parent_id = p.id where d.`value` = 6 and p.`value` = 'dic_declaration_status') THEN
	     insert INTO dictionary(tenant_id,parent_id,label,value) select _tenantId,id,'已退款','6' FROM dictionary where value='dic_declaration_status' limit 1;
	END IF; 

	
	delete from dictionary where VALUE = 6 and label ='已退款' and parent_id IN (select a.id from (select id FROM dictionary where VALUE = 'dic_reservation_status')a );


IF NOT EXISTS (select * from role WHERE id=8) THEN
INSERT INTO `role` (`id`, `tenant_id`, `parent_id`, `system_code`, `name`, `description`, `is_share`, `is_enabled`, `is_system`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('8', _tenantId, '0', NULL, '财务专员', '财务专员', '0', '1', '0', '8', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

IF NOT EXISTS (select * from role WHERE id=9) THEN
INSERT INTO `role` (`id`, `tenant_id`, `parent_id`, `system_code`, `name`, `description`, `is_share`, `is_enabled`, `is_system`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('9', _tenantId, '0', NULL, '财务总监', '财务总监', '0', '1', '0', '9', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'user_account' AND column_name = 'enabled_date') THEN
	     alter table user_account add COLUMN enabled_date datetime COMMENT '最后一次停用时间';
	END IF;

/*财务专员 财务管理*/
IF NOT EXISTS (select * from role_resource WHERE resource_id=77 AND role_id=8) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) VALUES ( _tenantId, 77, 8, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

/*财务专员 回款计划管理*/
IF NOT EXISTS (select * from role_resource WHERE resource_id=78 AND role_id=8) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) VALUES ( _tenantId, 78, 8, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

/*财务专员 结佣管理*/
IF NOT EXISTS (select * from role_resource WHERE resource_id=79 AND role_id=8) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) VALUES ( _tenantId, 79, 8, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

/*财务专员 添加回款计划*/
IF NOT EXISTS (select * from role_resource WHERE resource_id=86 AND role_id=8) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) VALUES ( _tenantId, 86, 8, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

/*财务总监 财务管理*/
IF NOT EXISTS (select * from role_resource WHERE resource_id=77 AND role_id=9) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) VALUES ( _tenantId, 77, 9, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

/*财务总监 回款计划管理*/
IF NOT EXISTS (select * from role_resource WHERE resource_id=78 AND role_id=9) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) VALUES ( _tenantId, 78, 9, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

/*财务总监 结佣管理*/
IF NOT EXISTS (select * from role_resource WHERE resource_id=79 AND role_id=9) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) VALUES ( _tenantId, 79, 9, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

/*财务总监 结佣审批 菜单*/
IF NOT EXISTS (select * from role_resource WHERE resource_id=80 AND role_id=9) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) VALUES ( _tenantId, 80, 9, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

/*财务总监 结佣审批 接口*/
IF NOT EXISTS (select * from role_resource WHERE resource_id=84 AND role_id=9) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) VALUES ( _tenantId, 84, 9, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

/*财务总监 添加回款计划*/
IF NOT EXISTS (select * from role_resource WHERE resource_id=86 AND role_id=9) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) VALUES ( _tenantId, 86, 9, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;


IF NOT EXISTS (select * from data_object_access WHERE role_id=8) THEN
/*=============财务专员==============*/

/*产品*/
INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('1',/*role_id*/'8',/*read*/'40',/*delete*/'0',/*edit*/'0',_tenantId,'2017-07-25 14:35:16','1','1','2017-07-25 14:35:16','0');

/*产品供应商报价*/
INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('2',/*role_id*/'8',/*read*/'40',/*delete*/'0',/*edit*/'0',_tenantId,'2017-07-25 14:35:16','1','1','2017-07-25 14:35:16','0');

/*产品销售佣金*/
INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('3',/*role_id*/'8',/*read*/'40',/*delete*/'0',/*edit*/'0',_tenantId,'2017-07-25 14:35:16','1','1','2017-07-25 14:35:16','0');

/*产品公告*/
INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('4',/*role_id*/'8',/*read*/'40',/*delete*/'0',/*edit*/'0',_tenantId,'2017-07-25 14:35:16','1','1','2017-07-25 14:35:16','0');

/*客户*/
INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('5',/*role_id*/'8',/*read*/'0',/*delete*/'0',/*edit*/'0',_tenantId,'2017-07-25 14:35:16','1','1','2017-07-25 14:35:16','0');

/*客户联系信息*/
INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('6',/*role_id*/'8',/*read*/'0',/*delete*/'0',/*edit*/'0',_tenantId,'2017-07-25 14:35:16','1','1','2017-07-25 14:35:16','0');

/*销售线索*/
INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('12',/*role_id*/'8',/*read*/'0',/*delete*/'0',/*edit*/'0',_tenantId,'2017-07-25 14:35:16','1','1','2017-07-25 14:35:16','0');

/*跟进*/
INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('13',/*role_id*/'8',/*read*/'0',/*delete*/'0',/*edit*/'0',_tenantId,'2017-07-25 14:35:16','1','1','2017-07-25 14:35:16','0');

/*预约*/
INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('9',/*role_id*/'8',/*read*/'40',/*delete*/'0',/*edit*/'0',_tenantId,'2017-07-25 14:35:16','1','1','2017-07-25 14:35:16','0');

/*报单*/
INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('10',/*role_id*/'8',/*read*/'40',/*delete*/'0',/*edit*/'0',_tenantId,'2017-07-25 14:35:16','1','1','2017-07-25 14:35:16','0');

/*回访*/
INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('11',/*role_id*/'8',/*read*/'0',/*delete*/'0',/*edit*/'0',_tenantId,'2017-07-25 14:35:16','1','1','2017-07-25 14:35:16','0');

END IF;


IF NOT EXISTS (select * from data_object_access WHERE role_id=9) THEN
/*=============财务总监==============*/
/*产品*/
INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('1',/*role_id*/'9',/*read*/'40',/*delete*/'0',/*edit*/'0',_tenantId,'2017-07-25 14:35:16','1','1','2017-07-25 14:35:16','0');

/*产品供应商报价*/
INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('2',/*role_id*/'9',/*read*/'40',/*delete*/'0',/*edit*/'0',_tenantId,'2017-07-25 14:35:16','1','1','2017-07-25 14:35:16','0');

/*产品销售佣金*/
INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('3',/*role_id*/'9',/*read*/'40',/*delete*/'0',/*edit*/'0',_tenantId,'2017-07-25 14:35:16','1','1','2017-07-25 14:35:16','0');

/*产品公告*/
INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('4',/*role_id*/'9',/*read*/'40',/*delete*/'0',/*edit*/'0',_tenantId,'2017-07-25 14:35:16','1','1','2017-07-25 14:35:16','0');

/*客户*/
INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('5',/*role_id*/'9',/*read*/'0',/*delete*/'0',/*edit*/'0',_tenantId,'2017-07-25 14:35:16','1','1','2017-07-25 14:35:16','0');

/*客户联系信息*/
INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('6',/*role_id*/'9',/*read*/'0',/*delete*/'0',/*edit*/'0',_tenantId,'2017-07-25 14:35:16','1','1','2017-07-25 14:35:16','0');

/*销售线索*/
INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('12',/*role_id*/'9',/*read*/'0',/*delete*/'0',/*edit*/'0',_tenantId,'2017-07-25 14:35:16','1','1','2017-07-25 14:35:16','0');

/*跟进*/
INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('13',/*role_id*/'9',/*read*/'0',/*delete*/'0',/*edit*/'0',_tenantId,'2017-07-25 14:35:16','1','1','2017-07-25 14:35:16','0');

/*预约*/
INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('9',/*role_id*/'9',/*read*/'40',/*delete*/'0',/*edit*/'0',_tenantId,'2017-07-25 14:35:16','1','1','2017-07-25 14:35:16','0');

/*报单*/
INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('10',/*role_id*/'9',/*read*/'40',/*delete*/'0',/*edit*/'0',_tenantId,'2017-07-25 14:35:16','1','1','2017-07-25 14:35:16','0');

/*回访*/
INSERT INTO `data_object_access` (`data_object_id`,`role_id`,`read_permission`,`delete_permission`,`edit_permission`,`tenant_id`,`create_date`,`create_user_id`,`update_user_id`,`update_date`,`is_delete`)
VALUES('11',/*role_id*/'9',/*read*/'0',/*delete*/'0',/*edit*/'0',_tenantId,'2017-07-25 14:35:16','1','1','2017-07-25 14:35:16','0');

END IF;


/* 以下为v1.1.1 版本脚本 */




	IF NOT EXISTS (select * from dictionary d where d.`value` = 'dic_article_status') THEN
	     insert INTO dictionary(tenant_id,parent_id,label,value)VALUES(_tenantId,0,'文章状态','dic_article_status');
	END IF;

    IF NOT EXISTS (select * from dictionary d LEFT JOIN dictionary p on d.parent_id = p.id where d.`value` = 0 and p.`value` = 'dic_article_status') THEN
	     insert INTO dictionary(tenant_id,parent_id,label,value) select _tenantId,id,'停用','0' FROM dictionary where value='dic_article_status' limit 1;
	END IF;

    IF NOT EXISTS (select * from dictionary d LEFT JOIN dictionary p on d.parent_id = p.id where d.`value` = 1 and p.`value` = 'dic_article_status') THEN
	     insert INTO dictionary(tenant_id,parent_id,label,value) select _tenantId,id,'启用','1' FROM dictionary where value='dic_article_status' limit 1;
	END IF;


  	IF NOT EXISTS (select * from dictionary d where d.`value` = 'dic_article_column_status') THEN
	     insert INTO dictionary(tenant_id,parent_id,label,value)VALUES(_tenantId,0,'文章栏目状态','dic_article_column_status');
	END IF;

    IF NOT EXISTS (select * from dictionary d LEFT JOIN dictionary p on d.parent_id = p.id where d.`value` = 0 and p.`value` = 'dic_article_column_status') THEN
	     insert INTO dictionary(tenant_id,parent_id,label,value) select _tenantId,id,'停用','0' FROM dictionary where value='dic_article_column_status' limit 1;
	END IF;

    IF NOT EXISTS (select * from dictionary d LEFT JOIN dictionary p on d.parent_id = p.id where d.`value` = 1 and p.`value` = 'dic_article_column_status') THEN
	     insert INTO dictionary(tenant_id,parent_id,label,value) select _tenantId,id,'启用','1' FROM dictionary where value='dic_article_column_status' limit 1;
	END IF;



	IF NOT EXISTS (SELECT * FROM resource WHERE id=87)
	THEN

	INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
	VALUES (87,_tenantId, 'content.manager.menu', 'WM', 0, '内容配置', '', '1', '1', NULL, '内容配置', '1050', '-1', SYSDATE(), NULL, NULL, '0' ) ;

	END IF;


	IF NOT EXISTS (SELECT * FROM resource WHERE id=88)
	THEN

	INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
	SELECT 88,_tenantId, 'cms.product.recommend', 'WM', id, '产品推荐配置', '/cms/product/recommend', '1', '1', NULL, '产品推荐配置', '10', '-1', SYSDATE(), NULL, NULL, '0' FROM resource WHERE code='content.manager.menu' LIMIT 1;

	END IF;


		IF NOT EXISTS (SELECT * FROM resource WHERE id=89)
	THEN

	INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
	SELECT 89,_tenantId, 'cms.news.column', 'WM', id, '文章栏目配置', '/cms/news/column', '1', '1', NULL, '文章栏目配置', '30', '-1', SYSDATE(), NULL, NULL, '0' FROM resource WHERE code='content.manager.menu' LIMIT 1;

	END IF;


			IF NOT EXISTS (SELECT * FROM resource WHERE id=90)
	THEN

	INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
	SELECT 90,_tenantId, 'cms.news.list', 'WM', id, '文章内容配置', '/cms/news/list', '1', '1', NULL, '文章内容配置', '40', '-1', SYSDATE(), NULL, NULL, '0' FROM resource WHERE code='content.manager.menu' LIMIT 1;

	END IF;

	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 87 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (87, 1);
	END IF;
		IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 88 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (88, 1);
	END IF;

			IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 89 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (89, 1);
	END IF;

				IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 90 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (90, 1);
	END IF;


CREATE TABLE IF NOT EXISTS `product_recommend` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='产品推荐配置';
	
	
CREATE TABLE IF NOT EXISTS `platform` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='平台表';
	
	

CREATE TABLE IF NOT EXISTS `platform_position_ref` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='平台与位置关系';


CREATE TABLE IF NOT EXISTS `position` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='位置';




CREATE TABLE IF NOT EXISTS `article` (
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='文章表';

IF NOT EXISTS (SELECT * FROM information_schema.statistics WHERE table_schema=DATABASE() AND table_name = 'article' AND index_name = 'platform_id_index') THEN
create index platform_id_index on article
(
   platform_id
);
END IF;

-- ----------------------------
-- Table structure for article_column
-- ----------------------------
CREATE TABLE IF NOT EXISTS  `article_column` (
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

IF NOT EXISTS (SELECT * FROM information_schema.statistics WHERE table_schema=DATABASE() AND table_name = 'article_column' AND index_name = 'platform_id_index') THEN
create index platform_id_index on article_column
(
   platform_id
);
END IF;

-- ----------------------------
-- Table structure for article_column_rel
-- ----------------------------
CREATE TABLE IF NOT EXISTS  `article_column_rel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `article_id` bigint(20) DEFAULT NULL COMMENT '文章id',
  `column_id` bigint(20) DEFAULT NULL COMMENT '栏目id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8 COMMENT='文章与栏目关系表';

IF NOT EXISTS (SELECT * FROM information_schema.statistics WHERE table_schema=DATABASE() AND table_name = 'article_column_rel' AND index_name = 'article_id_index') THEN
create index article_id_index on article_column_rel
(
   article_id
);
END IF;


IF NOT EXISTS (SELECT * FROM information_schema.statistics WHERE table_schema=DATABASE() AND table_name = 'article_column_rel' AND index_name = 'column_id_index') THEN
create index column_id_index on article_column_rel
(
   column_id
);
END IF;

-- ----------------------------
-- Table structure for article_detail
-- ----------------------------
CREATE TABLE IF NOT EXISTS  `article_detail` (
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='文章详情表';

IF NOT EXISTS (SELECT * FROM information_schema.statistics WHERE table_schema=DATABASE() AND table_name = 'article_detail' AND index_name = 'article_id_index') THEN
create index article_id_index on article_detail
(
   article_id
);
END IF;



	IF NOT EXISTS (select * from platform where code = 'service_number' and is_enabled = 1 and is_delete = 0) THEN
       INSERT INTO `platform` (`tenant_id`, `name`, `code`, `sequence`, `is_enabled`, `create_date`, `is_delete`) 
       VALUES (_tenantId, '服务号', 'service_number', 1, 1, NULL, 0);
	END IF;

   IF NOT EXISTS (select * from platform where code = 'website' and is_enabled = 1 and is_delete = 0) THEN
        INSERT INTO `platform` (`tenant_id`, `name`, `code`, `sequence`, `is_enabled`, `create_date`, `is_delete`) 
        VALUES (_tenantId, '官方网站', 'website', 1, 1, NULL, 0);
	END IF;
   IF NOT EXISTS (select * from platform where code = 'app_to_b' and is_enabled = 1 and is_delete = 0) THEN
       INSERT INTO `platform` (`tenant_id`, `name`, `code`, `sequence`, `is_enabled`, `create_date`, `is_delete`) 
       VALUES (_tenantId, '员工版APP', 'app_to_b', 1, 1, NULL, 0);
	END IF;
	
	IF NOT EXISTS (select * from position where code = 'index_hot_product' and is_delete = 0) THEN
        INSERT INTO `position` (`tenant_id`, `name`, `code`, `is_delete`) VALUES (_tenantId, '首页热门产品', 'index_hot_product', 0);
	END IF;
	
	IF NOT EXISTS (select * from position where code = 'list_product' and is_delete = 0) THEN
        INSERT INTO `position` (`tenant_id`, `name`, `code`, `is_delete`) VALUES (_tenantId, '产品列表', 'list_product', 0);
	END IF;
	IF  EXISTS (select * from position where code = 'list_product' and is_delete = 0) THEN
	   update position set name = '产品列表' where code = 'list_product' and is_delete = 0;
	END IF;
	
	
	IF NOT EXISTS (select * from position where code = 'index_recommend_product' and is_delete = 0) THEN
        INSERT INTO `position` (`tenant_id`, `name`, `code`, `is_delete`) VALUES (_tenantId, '首页推荐产品', 'index_recommend_product', 0);
	END IF;
	
	IF NOT EXISTS (select * from position where code = 'index_recommend_product_app' and is_delete = 0) THEN
        INSERT INTO `position` (`tenant_id`, `name`, `code`, `is_delete`) VALUES (_tenantId, '首页推荐产品', 'index_recommend_product_app', 0);
	END IF;
	
	
    IF NOT EXISTS (select * from platform_position_ref where platform_id = 1 and position_id=3 and is_delete = 0) THEN
        INSERT INTO `platform_position_ref` (`tenant_id`, `platform_id`, `position_id`, `is_delete`) VALUES (NULL, 1, 3, 0);
	END IF;
	IF NOT EXISTS (select * from platform_position_ref where platform_id = 2 and position_id=1 and is_delete = 0) THEN
         INSERT INTO `platform_position_ref` (`tenant_id`, `platform_id`, `position_id`, `is_delete`) VALUES (NULL, 2, 1, 0);
	END IF;
	IF NOT EXISTS (select * from platform_position_ref where platform_id = 2 and position_id=2 and is_delete = 0) THEN
        INSERT INTO `platform_position_ref` (`tenant_id`, `platform_id`, `position_id`, `is_delete`) VALUES (NULL, 2, 2, 0);
	END IF;
	IF NOT EXISTS (select * from platform_position_ref where platform_id = 3 and position_id=4 and is_delete = 0) THEN
        INSERT INTO `platform_position_ref` (`tenant_id`, `platform_id`, `position_id`, `is_delete`) VALUES (NULL, 3, 4, 0);
	END IF;
	
	IF NOT EXISTS (select * from dictionary d LEFT JOIN dictionary p on d.parent_id = p.id where d.`value` = 3 and p.`value` = 'dic_leads_type') THEN
	     insert INTO dictionary(tenant_id,parent_id,label,value) select _tenantId,id,'预约理财师','3' FROM dictionary where value='dic_leads_type' limit 1;
	END IF;
	
	

end;

call tenant_sql_update_1_1();

DROP PROCEDURE if exists tenant_sql_update_1_1;
//