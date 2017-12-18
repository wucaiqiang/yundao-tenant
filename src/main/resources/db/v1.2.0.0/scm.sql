
delimiter //

drop procedure if exists scm_sql_update;

create procedure scm_sql_update()
begin




IF EXISTS (SELECT 1 FROM resource WHERE code='customer.my') THEN

 DELETE FROM role_resource WHERE resource_id IN (
    SELECT * FROM (
       SELECT r.id FROM resource r LEFT JOIN resource pr ON r.parent_id=pr.id WHERE pr.code='customer.my') t);

DELETE FROM role_resource WHERE resource_id=23;

  DELETE FROM resource WHERE id IN (
    SELECT * FROM (
       SELECT r.id FROM resource r LEFT JOIN resource pr ON r.parent_id=pr.id WHERE pr.code='customer.my') t);

       DELETE FROM resource WHERE code='customer.my';
	END IF;


	IF EXISTS (SELECT 1 FROM resource WHERE code='customer.pool') THEN

 DELETE FROM role_resource WHERE resource_id IN (
    SELECT * FROM (
       SELECT r.id FROM resource r LEFT JOIN resource pr ON r.parent_id=pr.id WHERE pr.code='customer.pool') t);

DELETE FROM role_resource WHERE resource_id=24;

  DELETE FROM resource WHERE id IN (
    SELECT * FROM (
       SELECT r.id FROM resource r LEFT JOIN resource pr ON r.parent_id=pr.id WHERE pr.code='customer.pool') t);

        DELETE FROM resource WHERE code='customer.pool';
	END IF;



IF NOT EXISTS (SELECT 1 FROM resource WHERE code='customer.index' AND id=91) THEN

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('91', NULL, 'customer.index', 'WM', '22', '客户', '/customer/index', '1', '1', '1', '客户（我的客户和全部客户合并）', '10', '-1', SYSDATE(), NULL, NULL, '0');

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) 
VALUES ('92', NULL, 'customer.v2.back.apply', 'WM', '91', '放弃', '/customer/v2/back/apply', '0', '1', '0', '客户管理 - 客户 放弃(回退)', '2', '-1', SYSDATE(), NULL, NULL, '0');

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) 
VALUES ('93', NULL, 'customer.v2.add', 'WM', '91', '新增客户', '/customer/v2/add', '0', '1', '0', '客户管理 - 客户 新增客户', '6', '-1', SYSDATE(), NULL, NULL, '0');

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) 
VALUES ('94', NULL, 'customer.v2.import.multi', 'WM', '91', '批量导入客户', '/customer/v2/import/multi', '0', '1', '0', '客户管理 - 客户 批量导入客户', '7', '-1', SYSDATE(), NULL, NULL, '0');


INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) 
VALUES ('95', NULL, 'customer.v2.distribution.allot_to_fp', 'WM', '91', '调配', '/customer/v2/distribution/allot_to_fp', '0', '1', '0', '客户管理 - 客户 调配', '3', '-1', SYSDATE(), NULL, NULL, '0');

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) 
VALUES ('96', NULL, 'customer.v2.distribution.recycle', 'WM', '91', '回收', '/customer/v2/distribution/recycle', '0', '1', '0', '客户管理 - 客户 回收', '4', '-1', SYSDATE(), NULL, NULL, '0');

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) 
VALUES ('97', NULL, 'customer.v2.distribution.allot_to_cs', 'WM', '91', '分配回访', '/customer/v2/distribution/allot_to_cs', '0', '1', '0', '客户管理 - 客户 分配回访', '5', '-1', SYSDATE(), NULL, NULL, '0');

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) 
VALUES ('98', NULL, 'user.customer.v2.focus', 'WM', '91', '关注', '/user/customer/v2/focus', '0', '1', '0', '客户管理 - 客户 关注', '1', '-1', SYSDATE(), NULL, NULL, '0');


INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) 
VALUES (NULL, '91', '1', '1', '-1', SYSDATE(), NULL, NULL, '0');
INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, '91', '2', '1', '-1', SYSDATE(), NULL, NULL, '0');
INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, '91', '7', '1', '-1', SYSDATE(), NULL, NULL, '0');

INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) 
VALUES (NULL, '92', '1', '1', '-1', SYSDATE(), NULL, NULL, '0');
INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, '92', '2', '1', '-1', SYSDATE(), NULL, NULL, '0');

INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) 
VALUES (NULL, '93', '1', '1', '-1', SYSDATE(), NULL, NULL, '0');
INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, '93', '2', '1', '-1', SYSDATE(), NULL, NULL, '0');

INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) 
VALUES (NULL, '94', '1', '1', '-1', SYSDATE(), NULL, NULL, '0');
INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, '94', '2', '1', '-1', SYSDATE(), NULL, NULL, '0');

INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) 
VALUES (NULL, '95', '1', '1', '-1', SYSDATE(), NULL, NULL, '0');
INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, '95', '7', '1', '-1', SYSDATE(), NULL, NULL, '0');

INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) 
VALUES (NULL, '96', '1', '1', '-1', SYSDATE(), NULL, NULL, '0');
INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, '96', '7', '1', '-1', SYSDATE(), NULL, NULL, '0');

INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) 
VALUES (NULL, '97', '1', '1', '-1', SYSDATE(), NULL, NULL, '0');
INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, '97', '7', '1', '-1', SYSDATE(), NULL, NULL, '0');

INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, '93', '7', '1', '-1', SYSDATE(), NULL, NULL, '0');

INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, '94', '7', '1', '-1', SYSDATE(), NULL, NULL, '0');

INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`) 
VALUES (NULL, '98', '1', '1', '-1', SYSDATE(), NULL, NULL, '0');
INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, '98', '2', '1', '-1', SYSDATE(), NULL, NULL, '0');
INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, '98', '7', '1', '-1', SYSDATE(), NULL, NULL, '0');

	END IF;


	IF NOT EXISTS (SELECT 1 FROM resource WHERE code='system.config.sale') THEN

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('106', NULL, 'system.config.sale', 'WM', '1', '销售管理配置', '/system/config/sale', '1', '1', '1', '销售管理配置', '30', '-1', SYSDATE(), NULL, NULL, '0');

INSERT INTO `role_resource` (`tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, '106', '1', '1', '-1', SYSDATE(), NULL, NULL, '0');

END IF;

UPDATE resource SET is_deplay=0 WHERE  id IN(23,43,44,71,24,46,47,48,50,70);

	IF NOT EXISTS (select * from role_resource where role_id = 7 and resource_id = 87 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( tenant_id,`resource_id`, `role_id`) VALUES (NULL,87, 7);
	END IF;

	IF NOT EXISTS (select * from role_resource where role_id = 7 and resource_id = 88 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( tenant_id,`resource_id`, `role_id`) VALUES (NULL,88, 7);
	END IF;

	IF NOT EXISTS (select * from role_resource where role_id = 7 and resource_id = 89 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( tenant_id,`resource_id`, `role_id`) VALUES (NULL,89, 7);
	END IF;

	IF NOT EXISTS (select * from role_resource where role_id = 7 and resource_id = 90 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( tenant_id,`resource_id`, `role_id`) VALUES (NULL,90, 7);
	END IF;

  
end;

call scm_sql_update();

DROP PROCEDURE if exists scm_sql_update;


















drop procedure if exists scm_sql_update;

create procedure scm_sql_update()
begin

	IF NOT EXISTS (SELECT * FROM resource WHERE id=99)
	THEN
	INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
	VALUES (99, NULL , 'report', 'WM', '0', '数据报表(APP)', '/report/', '1', '1', 0, '数据报表(APP)', '1060', '-1', SYSDATE(), NULL, NULL, '0');
	END IF;
	
	IF NOT EXISTS (SELECT * FROM resource WHERE id=100)
	THEN
	INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
	VALUES (100, NULL , 'report.declaration.company', 'WM', '99', '公司业绩走势', '/report/declaration/company/', '1', '1', 0, '数据报表(APP)-->公司业绩走势', '10', '-1', SYSDATE(), NULL, NULL, '0');
	END IF;
	
	IF NOT EXISTS (SELECT * FROM resource WHERE id=101)
	THEN
	INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
	VALUES (101, NULL , 'report.declaration.user.top', 'WM', '99', '员工业绩Top榜', '/report/declaration/user/top', '1', '1', 0, '数据报表(APP)-->员工业绩Top榜', '20', '-1', SYSDATE(), NULL, NULL, '0');
	END IF;
	
	IF NOT EXISTS (SELECT * FROM resource WHERE id=102)
	THEN
	INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
	VALUES (102, NULL , 'report.declaration', 'WM', '99', '业绩报表', '/report/declaration', '1', '1', 0, '数据报表(APP)-->业绩报表', '30', '-1', SYSDATE(), NULL, NULL, '0');
	END IF;
	
	
	IF NOT EXISTS (SELECT * FROM resource WHERE id=103)
	THEN
	INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
	VALUES (103, NULL , 'report.declaration.department', 'WM', '102', '部门业绩', '/report/declaration/department', '0', '1', 0, '数据报表(APP)-->业绩报表-->部门业绩', '10', '-1', SYSDATE(), NULL, NULL, '0');
	END IF;
	
	IF NOT EXISTS (SELECT * FROM resource WHERE id=104)
	THEN
	INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
	VALUES (104, NULL , 'report.declaration.user', 'WM', '102', '员工业绩', '/report/declaration/user', '0', '1', 0, '数据报表(APP)-->业绩报表-->员工业绩', '20', '-1', SYSDATE(), NULL, NULL, '0');
	END IF;
	
	IF NOT EXISTS (SELECT * FROM resource WHERE id=105)
	THEN
	INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
	VALUES (105, NULL , 'report.declaration.customer', 'WM', '99', '客户成交', '/report/declaration/customer', '1', '1', 0, '数据报表(APP)-->客户成交', '50', '-1', SYSDATE(), NULL, NULL, '0');
	END IF;
	
	
	
IF NOT EXISTS (SELECT * FROM resource WHERE id=107)
THEN
INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (107, NULL , 'cms.roadshow.list', 'WM', '87', '路演内容配置', '/cms/roadshow/list', '1', '1', 1, '内容配置-->路演内容配置', '60', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

IF NOT EXISTS (SELECT * FROM resource WHERE id=108)
THEN
INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (108, NULL , 'cms.roadshow.column', 'WM', '87', '路演栏目配置', '/cms/roadshow/column', '1', '1', 1, '内容配置-->路演栏目配置', '50', '-1', SYSDATE(), NULL, NULL, '0');
END IF;


IF NOT EXISTS (SELECT * FROM resource WHERE id=109)
THEN
INSERT INTO `resource` (id,`tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES (109, NULL , 'cms.video.list', 'WM', '87', '路演视频管理', '/cms/video/list', '1', '1', 1, '内容配置-->路演视频管理', '70', '-1', SYSDATE(), NULL, NULL, '0');
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
	
CREATE TABLE IF NOT EXISTS `video_tenant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ref_file_id` varchar(255) DEFAULT NULL COMMENT '腾讯所对应的视频ID',
  `tenant_id` tinyint(4) DEFAULT NULL COMMENT '租户ID',
  `type` tinyint(4) DEFAULT NULL COMMENT '视频类型，1：路演',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态 0:压缩中 1：压缩完成',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '是否删除',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='视频ID与租户的关联表';

end;

call scm_sql_update();

DROP PROCEDURE if exists scm_sql_update;



//