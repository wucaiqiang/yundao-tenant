delimiter //

drop procedure if exists scm_sql_update;

create procedure scm_sql_update()
begin


IF NOT EXISTS (SELECT * FROM resource WHERE id=77)
THEN

INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (77,NULL, 'finance', 'WM', '0', '财务管理', '/finance/', '1', '1', NULL, '财务管理', '60', '-1', SYSDATE(), NULL, NULL, '0');

END IF;



IF NOT EXISTS (SELECT * FROM resource WHERE id=78)
THEN

INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
SELECT 78,NULL, 'finance.receiptplan', 'WM', id, '回款计划管理', '/finance/receiptplan', '1', '1', NULL, '回款计划管理', '10', '-1', SYSDATE(), NULL, NULL, '0' FROM resource WHERE code='finance' LIMIT 1;

END IF;


IF NOT EXISTS (SELECT * FROM resource WHERE id=79)
THEN

INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
SELECT 79,NULL, 'finance.knotcommission', 'WM', id, '结佣管理', '/finance/knotcommission', '1', '1', NULL, '结佣管理', '20', '-1', SYSDATE(), NULL, NULL, '0' FROM resource WHERE code='finance' LIMIT 1;

END IF;


IF NOT EXISTS (SELECT * FROM resource WHERE id=80)
THEN

INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
SELECT 80,NULL, 'finance.knotcommission.audit', 'WM', id, '结佣审批', '/finance/knotcommission/audit', '1', '1', NULL, '结佣审批', '20', '-1', SYSDATE(), NULL, NULL, '0' FROM resource WHERE code='finance' LIMIT 1;

END IF;




IF NOT EXISTS (SELECT * FROM resource WHERE id=81)
THEN

INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
SELECT 81,NULL, 'sale.refunds', 'WM', id, '我的退款', '/sale/refunds', '1', '1', NULL, '我的退款', '31', '-1', SYSDATE(), NULL, NULL, '0' FROM resource WHERE code='sale' LIMIT 1;

END IF;


IF NOT EXISTS (SELECT * FROM resource WHERE id=82)
THEN

INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
SELECT 82,NULL, 'sale.refunds.audit', 'WM', id, '退款审批', '/sale/refunds/audit', '1', '1', NULL, '退款审批', '51', '-1', SYSDATE(), NULL, NULL, '0' FROM resource WHERE code='sale' LIMIT 1;

END IF;


IF NOT EXISTS (SELECT * FROM resource WHERE id=83)
THEN

INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
SELECT 83,NULL, 'refund.audit.do', 'WM', id, '退款审批', '/refund/audit/do', '0', '1', NULL, '退款审批', '51', '-1', SYSDATE(), NULL, NULL, '0' FROM resource WHERE code='sale.refunds.audit' LIMIT 1;

END IF;


IF NOT EXISTS (SELECT * FROM resource WHERE id=84)
THEN

INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
SELECT 84,NULL, 'knot.commission.audit', 'WM', id, '结佣审批', '/knot/commission/audit', '0', '1', NULL, '结佣审批', '51', '-1', SYSDATE(), NULL, NULL, '0' FROM resource WHERE code='finance.knotcommission.audit' LIMIT 1;

END IF;

IF NOT EXISTS (SELECT * FROM resource WHERE id=85)
THEN

INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
SELECT 85,NULL, 'declaration.apply_refund', 'WM', id, '申请退款', '/declaration/apply_refund', '0', '1', NULL, '申请退款', '10', '-1', SYSDATE(), NULL, NULL, '0' FROM resource WHERE code='sale.refunds' LIMIT 1;

END IF;

IF NOT EXISTS (SELECT * FROM resource WHERE id=86)
THEN

INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
SELECT 86,NULL, 'receipt.plan.add', 'WM', id, '新增回款计划', '/receipt/plan/add', '0', '1', NULL, '新增回款计划', '10', '-1', SYSDATE(), NULL, NULL, '0' FROM resource WHERE code='finance.receiptplan' LIMIT 1;

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

	update resource set name = '组织架构管理' , description ='组织架构管理' where id = 6;
	
	
	
	
	
	
IF NOT EXISTS (select * from role WHERE id=8) THEN
INSERT INTO `role` (`id`, `tenant_id`, `parent_id`, `name`, `description`, `is_share`, `is_delete`, `is_enabled`, `is_system`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`)
 VALUES ('8', NULL, '0', '财务专员', '财务专员', '0', '0', '1', '0', '8', NULL, NULL, NULL, NULL);
END IF;

IF NOT EXISTS (select * from role WHERE id=9) THEN
INSERT INTO `role` (`id`, `tenant_id`, `parent_id`, `name`, `description`, `is_share`, `is_delete`, `is_enabled`, `is_system`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`)
 VALUES ('9', NULL, '0', '财务总监', '财务总监', '0', '0', '1', '0', '9', NULL, NULL, NULL, NULL);
END IF;


IF NOT EXISTS (select * from role_system WHERE id=8) THEN
INSERT INTO `role_system` (`id`, `tenant_id`, `role_id`, `system_code`, `is_enabled`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) 
VALUES ('8', NULL, '8', 'WM', '1', NULL, NULL, NULL, NULL, '0');
END IF;

IF NOT EXISTS (select * from role_system WHERE id=9) THEN
INSERT INTO `role_system` (`id`, `tenant_id`, `role_id`, `system_code`, `is_enabled`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) 
VALUES ('9', NULL, '9', 'WM', '1', NULL, NULL, NULL, NULL, '0');
END IF;

/*财务专员 财务管理*/
IF NOT EXISTS (select * from role_resource WHERE resource_id=77 AND role_id=8) THEN
INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ( NULL, '77', '8', '1', NULL, NULL, NULL, NULL, '0');
END IF;

/*财务专员 回款计划管理*/
IF NOT EXISTS (select * from role_resource WHERE resource_id=78 AND role_id=8) THEN
INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ( NULL, '78', '8', '1', NULL, NULL, NULL, NULL, '0');
END IF;

/*财务专员 结佣管理*/
IF NOT EXISTS (select * from role_resource WHERE resource_id=79 AND role_id=8) THEN
INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ( NULL, '79', '8', '1', NULL, NULL, NULL, NULL, '0');
END IF;

/*财务专员 添加回款计划*/
IF NOT EXISTS (select * from role_resource WHERE resource_id=86 AND role_id=8) THEN
INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ( NULL, '86', '8', '1', NULL, NULL, NULL, NULL, '0');
END IF;


/*财务总监 财务管理*/
IF NOT EXISTS (select * from role_resource WHERE resource_id=77 AND role_id=9) THEN
INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ( NULL, '77', '9', '1', NULL, NULL, NULL, NULL, '0');
END IF;


/*财务总监 回款计划管理*/
IF NOT EXISTS (select * from role_resource WHERE resource_id=78 AND role_id=9) THEN
INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ( NULL, '78', '9', '1', NULL, NULL, NULL, NULL, '0');
END IF;


/*财务总监 结佣管理*/
IF NOT EXISTS (select * from role_resource WHERE resource_id=79 AND role_id=9) THEN
INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ( NULL, '79', '9', '1', NULL, NULL, NULL, NULL, '0');
END IF;


/*财务总监 结佣审批 菜单*/
IF NOT EXISTS (select * from role_resource WHERE resource_id=80 AND role_id=9) THEN
INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ( NULL, '80', '9', '1', NULL, NULL, NULL, NULL, '0');
END IF;


/*财务总监 结佣审批 接口*/
IF NOT EXISTS (select * from role_resource WHERE resource_id=84 AND role_id=9) THEN
INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ( NULL, '84', '9', '1', NULL, NULL, NULL, NULL, '0');
END IF;


/*财务总监 添加回款计划*/
IF NOT EXISTS (select * from role_resource WHERE resource_id=86 AND role_id=9) THEN
INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ( NULL, '86', '9', '1', NULL, NULL, NULL, NULL, '0');
END IF;



/* 以下为v1.1.1 版本脚本 */




	IF NOT EXISTS (SELECT * FROM resource WHERE id=87)
	THEN

	INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
	VALUES (87,NULL, 'content.manager.menu', 'WM', 0, '内容配置', '', '1', '1', NULL, '内容配置', '1050', '-1', SYSDATE(), NULL, NULL, '0' ) ;

	END IF;


	IF NOT EXISTS (SELECT * FROM resource WHERE id=88)
	THEN

	INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
	SELECT 88,NULL, 'cms.product.recommend', 'WM', id, '产品推荐配置', '/cms/product/recommend', '1', '1', NULL, '产品推荐配置', '10', '-1', SYSDATE(), NULL, NULL, '0' FROM resource WHERE code='content.manager.menu' LIMIT 1;

	END IF;



		IF NOT EXISTS (SELECT * FROM resource WHERE id=89)
	THEN

	INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
	SELECT 89,NULL, 'cms.news.column', 'WM', id, '文章栏目配置', '/cms/news/column', '1', '1', NULL, '文章栏目配置', '30', '-1', SYSDATE(), NULL, NULL, '0' FROM resource WHERE code='content.manager.menu' LIMIT 1;

	END IF;


			IF NOT EXISTS (SELECT * FROM resource WHERE id=90)
	THEN

	INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
	SELECT 90,NULL, 'cms.news.list', 'WM', id, '文章内容配置', '/cms/news/list', '1', '1', NULL, '文章内容配置', '40', '-1', SYSDATE(), NULL, NULL, '0' FROM resource WHERE code='content.manager.menu' LIMIT 1;

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



  IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'domain_name' AND column_name = 'platform_code') THEN
	     ALTER TABLE `domain_name`
          ADD COLUMN `platform_code` varchar(64) DEFAULT NULL COMMENT '域名类型';
         update domain_name set platform_code = 'service_number' where type='to_c';
				ALTER TABLE domain_name DROP COLUMN type;
				update domain_name set platform_code = 'website' where platform_code is null;
	END IF;
	
  
end;

call scm_sql_update();

DROP PROCEDURE if exists scm_sql_update;
//