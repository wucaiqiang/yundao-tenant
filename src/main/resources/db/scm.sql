delimiter //

drop procedure if exists scm_sql_update;

create procedure scm_sql_update()
begin

	UPDATE resource SET name='组织结构管理' WHERE code='system.config.organization' AND name='组织架构管理' LIMIT 1;

  UPDATE role SET name='超级管理员' WHERE id=1 AND name='系统管理员' LIMIT 1;

   UPDATE role SET sequence=sequence * 10 WHERE id<12 AND sequence<20;

 IF NOT EXISTS (select * from role WHERE id=12) THEN
INSERT INTO `role` (`id`, `tenant_id`, `parent_id`, `name`, `description`, `is_share`, `is_enabled`, `is_system`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('12', NULL, '0', '系统管理员', '系统管理员', '0', '1', '0', '11', '-1', SYSDATE(), NULL, NULL, '0');
END IF;


    /*系统管理员 后台管理*/
IF NOT EXISTS (select * from role_resource WHERE resource_id=118 AND role_id=12) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 118, 12, '1', NULL, SYSDATE(), NULL, NULL, '0');
END IF;


    /*系统管理员 系统管理*/
IF NOT EXISTS (select * from role_resource WHERE resource_id=1 AND role_id=12) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 1, 12, '1', NULL, SYSDATE(), NULL, NULL, '0');
END IF;


  /*系统管理员 角色权限管理*/
IF NOT EXISTS (select * from role_resource WHERE resource_id=2 AND role_id=12) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 2, 12, '1', NULL, SYSDATE(), NULL, NULL, '0');
END IF;


  /*系统管理员 组织结构管理*/
IF NOT EXISTS (select * from role_resource WHERE resource_id=6 AND role_id=12) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 6, 12, '1', NULL, SYSDATE(), NULL, NULL, '0');
END IF;

    /*系统管理员 销售管理配置*/
IF NOT EXISTS (select * from role_resource WHERE resource_id=106 AND role_id=12) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 106, 12, '1', NULL, SYSDATE(), NULL, NULL, '0');
END IF;

end;

call scm_sql_update();

DROP PROCEDURE if exists scm_sql_update;
//