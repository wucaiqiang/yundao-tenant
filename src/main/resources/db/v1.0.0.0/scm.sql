delimiter //

drop procedure if exists scm_sql_update;

create procedure scm_sql_update()
begin

  IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'user_account' AND column_name = 'pwd_err_count') THEN
    ALTER TABLE user_account ADD pwd_err_count TINYINT(2) DEFAULT 0 COMMENT '输入密码错误次数，默认：0' AFTER password;
	END IF;

  IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'user_account' AND column_name = 'once_edit_pwd') THEN
    ALTER TABLE user_account ADD once_edit_pwd TINYINT(2) DEFAULT 0 COMMENT '是否修改过密码，1：是，0：否，默认：0' AFTER password;
	END IF;


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
    
	update resource set name = '全部客户',description = '全部客户' where id = 24;

	UPDATE resource SET name=REPLACE(name,'审核','审批');
	
	delete from role_resource where resource_id in (25,51);
	delete from resource where id in(25,51);
	
	
	IF NOT EXISTS (select * from role_resource where role_id = 6 and resource_id = 26 and is_delete = 0) THEN
          INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (26, 6);
	END IF;
	
	IF NOT EXISTS (select * from role_resource where role_id = 6 and resource_id = 67 and is_delete = 0) THEN
          INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (67, 6);
	END IF;
	
	IF NOT EXISTS (select * from role_resource where role_id = 6 and resource_id = 69 and is_delete = 0) THEN
          INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (69, 6);
	END IF;
	
	
	
	IF NOT EXISTS (select * from role_resource where role_id = 7 and resource_id = 26 and is_delete = 0) THEN
          INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (26, 7);
	END IF;
	
	IF NOT EXISTS (select * from role_resource where role_id = 7 and resource_id = 67 and is_delete = 0) THEN
          INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (67, 7);
	END IF;
	
	IF NOT EXISTS (select * from role_resource where role_id = 7 and resource_id = 69 and is_delete = 0) THEN
          INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (69, 7);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 7 and resource_id = 68 and is_delete = 0) THEN
          INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (68, 7);
	END IF;
	
	
	    update resource set name = '预约额度审批'  where id= 29;
    
     update resource set name = '预约额度审批'  where id= 57;
     
	
     
    IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'domain_name' AND column_name = 'type') THEN
        alter table domain_name add `type` varchar(64) DEFAULT NULL COMMENT '域名类型' AFTER `register_date`;
	END IF; 
	
     update domain_name set type = 'to_c'  where url in('h5.yundaojishu.com','h5zr.yundaojishu.com');
end;

call scm_sql_update();

DROP PROCEDURE if exists scm_sql_update;
//