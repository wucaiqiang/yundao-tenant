
delimiter //

DROP PROCEDURE if exists tenant_sql_update_1_1;

create procedure tenant_sql_update_1_1()
begin

DECLARE _tenantId BIGINT;
DECLARE _msgReservationDiscard BIGINT;
DECLARE _msgDeclarationDiscard BIGINT;

SELECT tenant_id INTO _tenantId FROM user_account LIMIT 1;

	-- 白名单
	IF NOT EXISTS (select * from api_resource where `code`='resource.get_menu' and url='/resource/get_menu' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`,
       `is_delete`,is_whitelist)
       VALUES (_tenantId, 'resource.get_menu', '白名单-->获取菜单和功能权限', '/resource/get_menu', 1, 1,'WM', 0,1);
	END IF;
	
	IF NOT EXISTS (select * from api_resource where `code`='dictionary.gets' and url='/dictionary/gets' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`,
       `is_delete`,is_whitelist)
       VALUES (_tenantId, 'dictionary.gets', '白名单-->获取数据字段', '/dictionary/gets', 1, 1,'WM', 0,1);
	END IF;
	
	IF NOT EXISTS (select * from api_resource where `code`='msg.message.get_unread_count' and url='/msg/message/get_unread_count' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`,
       `is_delete`,is_whitelist)
       VALUES (_tenantId, 'msg.message.get_unread_count', '白名单-->获取消息的个数', '/msg/message/get_unread_count', 1, 1,
       'WM', 0,1);
	END IF;
	
	IF NOT EXISTS (select * from api_resource where `code`='product.fieldgroup.get_all' and url='/product/fieldgroup/get_all' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`,
       `is_delete`,is_whitelist)
       VALUES (_tenantId, 'product.fieldgroup.get_all', '白名单-->获取所有产品类别', '/product/fieldgroup/get_all', 1, 1,'WM',
       0,1);
	END IF;
	
	
	IF NOT EXISTS (select * from api_resource where `code`='msg.message.get_my_page' and url='/msg/message/get_my_page' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`,
       `is_delete`,is_whitelist)
       VALUES (_tenantId, 'msg.message.get_my_page', '白名单-->分页获取消息列表', '/msg/message/get_my_page', 1, 1,'WM', 0,1);
	END IF;

	
	
end;

call tenant_sql_update_1_1();

DROP PROCEDURE if exists tenant_sql_update_1_1;
//