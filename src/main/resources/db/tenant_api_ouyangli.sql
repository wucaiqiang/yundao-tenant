
delimiter //

DROP PROCEDURE if exists tenant_sql_update_1_1;

create procedure tenant_sql_update_1_1()
begin

DECLARE _tenantId BIGINT;
DECLARE _msgReservationDiscard BIGINT;
DECLARE _msgDeclarationDiscard BIGINT;
DECLARE _resource_id BIGINT;
DECLARE _api_id BIGINT;
DECLARE _resource_code VARCHAR(64);
DECLARE _api_code VARCHAR(64);
DECLARE _api_name VARCHAR(32);
DECLARE _api_url VARCHAR(256);

SELECT tenant_id INTO _tenantId FROM user_account LIMIT 1;

	-- 产品中心
	set  _api_code = 'product.center.gets';
	set  _api_name = '产品中心-->产品中心列表';
	set  _api_url = '/product/center/gets';
	IF NOT EXISTS (select * from api_resource where `code`=_api_code and url=_api_url and url_type = 1 and system_code = 'WM' and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, _api_code, _api_name, _api_url, 1, 1,'WM', 0);
	END IF;
	
	set  _api_code = 'declaration.pc_add';
	set  _api_name = '产品中心-->添加报单';
	set  _api_url = '/declaration/pc_add';
	IF NOT EXISTS (select * from api_resource where `code`=_api_code and url=_api_url and url_type = 1 and system_code = 'WM' and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, _api_code, _api_name, _api_url, 1, 1,'WM', 0);
	END IF;
	
    set  _api_code = 'product.center.reservation';
	set  _api_name = '产品中心-->添加预约';
	set  _api_url = '/product/center/reservation';
	IF NOT EXISTS (select * from api_resource where `code`=_api_code and url=_api_url and url_type = 1 and system_code = 'WM' and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, _api_code, _api_name, _api_url, 1, 1,'WM', 0);
	END IF;
	
	set  _api_code = 'product.focus';
	set  _api_name = '产品中心-->关注';
	set  _api_url = '/product/focus';
	IF NOT EXISTS (select * from api_resource where `code`=_api_code and url=_api_url and url_type = 1 and system_code = 'WM' and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, _api_code, _api_name, _api_url, 1, 1,'WM', 0);
	END IF;
	
	-- 产品中心 功能接口关系
	set  _api_code = 'product.center.gets';
	set  _resource_code = 'product.center';
	IF NOT EXISTS (SELECT * FROM api_resource_rel arr LEFT JOIN api_resource ar ON arr.api_id = ar.id LEFT JOIN resource r ON arr.resource_id = r.id
         where ar.`code` = _api_code and r.`code` = _resource_code and ar.url_type = 1) THEN
         SELECT id INTO _api_id FROM api_resource where `code` = _api_code and url_type = 1 and system_code = 'WM' and is_delete = 0  LIMIT 1;
         SELECT id INTO _resource_id FROM resource where `code` = _resource_code  LIMIT 1;
         INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `is_delete`) VALUES (_tenantId, _resource_id, _api_id, 0);
	END IF;
	
    set  _api_code = 'declaration.pc_add';
	set  _resource_code = 'product.center.declaration';
	IF NOT EXISTS (SELECT * FROM api_resource_rel arr LEFT JOIN api_resource ar ON arr.api_id = ar.id LEFT JOIN resource r ON arr.resource_id = r.id
         where ar.`code` = _api_code and r.`code` = _resource_code and ar.url_type = 1) THEN
         SELECT id INTO _api_id FROM api_resource where `code` = _api_code and url_type = 1 and system_code = 'WM' and is_delete = 0  LIMIT 1;
         SELECT id INTO _resource_id FROM resource where `code` = _resource_code  LIMIT 1;
         INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `is_delete`) VALUES (_tenantId, _resource_id, _api_id, 0);
	END IF;
	
	
	set  _api_code = 'product.center.reservation';
	set  _resource_code = 'product.center.reservation';
	IF NOT EXISTS (SELECT * FROM api_resource_rel arr LEFT JOIN api_resource ar ON arr.api_id = ar.id LEFT JOIN resource r ON arr.resource_id = r.id
         where ar.`code` = _api_code and r.`code` = _resource_code and ar.url_type = 1) THEN
         SELECT id INTO _api_id FROM api_resource where `code` = _api_code and url_type = 1 and system_code = 'WM' and is_delete = 0  LIMIT 1;
         SELECT id INTO _resource_id FROM resource where `code` = _resource_code  LIMIT 1;
         INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `is_delete`) VALUES (_tenantId, _resource_id, _api_id, 0);
	END IF;
	
		
	
	-- 产品管理
	IF NOT EXISTS (select * from api_resource where `code`='product.get_manager_List' and url='/product/get_manager_List' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'product.get_manager_List', '产品管理-->列表', '/product/get_manager_List', 1, 1,'WM', 0);
	END IF;
	
	set  _api_code = 'product.get_manager_List';
	set  _resource_code = 'product.control.index';
	IF NOT EXISTS (SELECT * FROM api_resource_rel arr LEFT JOIN api_resource ar ON arr.api_id = ar.id LEFT JOIN resource r ON arr.resource_id = r.id
         where ar.`code` = _api_code and r.`code` = _resource_code and ar.url_type = 1) THEN
         SELECT id INTO _api_id FROM api_resource where `code` = _api_code and url_type = 1 and system_code = 'WM' and is_delete = 0  LIMIT 1;
         SELECT id INTO _resource_id FROM resource where `code` = _resource_code  LIMIT 1;
         INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `is_delete`) VALUES (_tenantId, _resource_id, _api_id, 0);
	END IF;
	
	IF NOT EXISTS (select * from api_resource where `code`='product.delete' and url='/product/delete' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'product.delete', '产品管理-->删除', '/product/delete', 1, 1,'WM', 0);
	END IF;
	
	set  _api_code = 'product.delete';
	set  _resource_code = 'product.control.index';
	IF NOT EXISTS (SELECT * FROM api_resource_rel arr LEFT JOIN api_resource ar ON arr.api_id = ar.id LEFT JOIN resource r ON arr.resource_id = r.id
         where ar.`code` = _api_code and r.`code` = _resource_code and ar.url_type = 1) THEN
         SELECT id INTO _api_id FROM api_resource where `code` = _api_code and url_type = 1 and system_code = 'WM' and is_delete = 0  LIMIT 1;
         SELECT id INTO _resource_id FROM resource where `code` = _resource_code  LIMIT 1;
         INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `is_delete`) VALUES (_tenantId, _resource_id, _api_id, 0);
	END IF;
		
	
	IF NOT EXISTS (select * from api_resource where `code`='product.update_status' and url='/product/update_status' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'product.update_status', '产品管理-->修改产品状态', '/product/update_status', 1, 1,'WM', 0);
	END IF;
	
	IF NOT EXISTS (select * from api_resource where `code`='user.get_users_by_realName' and url='/user/get_users_by_realName' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'user.get_users_by_realName', '产品管理-->新增产品-->查询用户', '/user/get_users_by_realName', 1, 1,'WM', 0);
	END IF;
	
	IF NOT EXISTS (select * from api_resource where `code`='file.upload' and url='/file/upload' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'file.upload', '产品管理-->新增产品-->上传附件', '/file/upload', 1, 1,'WM', 0);
	END IF;
	
	set  _api_code = 'file.upload';
	set  _resource_code = 'product.control.new';
	IF NOT EXISTS (SELECT * FROM api_resource_rel arr LEFT JOIN api_resource ar ON arr.api_id = ar.id LEFT JOIN resource r ON arr.resource_id = r.id
         where ar.`code` = _api_code and r.`code` = _resource_code and ar.url_type = 1) THEN
         SELECT id INTO _api_id FROM api_resource where `code` = _api_code and url_type = 1 and system_code = 'WM' and is_delete = 0  LIMIT 1;
         SELECT id INTO _resource_id FROM resource where `code` = _resource_code  LIMIT 1;
         INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `is_delete`) VALUES (_tenantId, _resource_id, _api_id, 0);
	END IF;
		
	IF NOT EXISTS (select * from api_resource where `code`='product.add' and url='/product/add' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'product.add', '产品管理-->新增产品', '/product/add', 1, 1,'WM', 0);
	END IF;
	set  _api_code = 'product.add';
	set  _resource_code = 'product.control.new';
	IF NOT EXISTS (SELECT * FROM api_resource_rel arr LEFT JOIN api_resource ar ON arr.api_id = ar.id LEFT JOIN resource r ON arr.resource_id = r.id
         where ar.`code` = _api_code and r.`code` = _resource_code and ar.url_type = 1) THEN
         SELECT id INTO _api_id FROM api_resource where `code` = _api_code and url_type = 1 and system_code = 'WM' and is_delete = 0  LIMIT 1;
         SELECT id INTO _resource_id FROM resource where `code` = _resource_code  LIMIT 1;
         INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `is_delete`) VALUES (_tenantId, _resource_id, _api_id, 0);
	END IF;
		
	IF NOT EXISTS (select * from api_resource where `code`='product.base.update' and url='/product/base/update' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'product.base.update', '产品管理-->产品信息-->修改', '/product/base/update', 1, 1,'WM', 0);
	END IF;
	
	IF NOT EXISTS (select * from api_resource where `code`='product.attach.add' and url='/product/attach/add' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'product.attach.add', '产品管理-->产品信息-->添加附件', '/product/attach/add', 1, 1,'WM', 0);
	END IF;
 
	IF NOT EXISTS (select * from api_resource where `code`='product.attach.delete' and url='product/attach/delete' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'product.attach.delete', '产品管理-->产品信息-->删除附件', 'product/attach/delete', 1, 1,'WM', 0);
	END IF;
	
	
	IF NOT EXISTS (select * from api_resource where `code`='product.sale.update' and url='/product/sale/update' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'product.sale.update', '产品管理-->销售信息-->修改销售信息', '/product/sale/update', 1, 1,'WM', 0);
	END IF;
	
	IF NOT EXISTS (select * from api_resource where `code`='product.supplier_quotation.update' and url='/product/supplier_quotation/update' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'product.supplier_quotation.update', '产品管理-->销售信息-->修改供应商报价', '/product/supplier_quotation/update', 1, 1,'WM', 0);
	END IF;
	
	IF NOT EXISTS (select * from api_resource where `code`='product.commission.update' and url='/product/commission/update' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'product.commission.update', '产品管理-->销售信息-->修改佣金', '/product/commission/update', 1, 1,'WM', 0);
	END IF;
	
	IF NOT EXISTS (select * from api_resource where `code`='product.income.update' and url='/product/income/update' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'product.income.update', '产品管理-->收益模式-->修改收益模式', '/product/income/update', 1, 1,'WM', 0);
	END IF;
	
	
	IF NOT EXISTS (select * from api_resource where `code`='declaration.get_page_for_pro_detail' and url='/declaration/get_page_for_pro_detail' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'declaration.get_page_for_pro_detail', '产品管理-->交易信息', '/declaration/get_page_for_pro_detail', 1, 1,'WM', 0);
	END IF;
	
	IF NOT EXISTS (select * from api_resource where `code`='product.notice.get_productId' and url='/product/notice/get_productId' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'product.notice.get_productId', '产品管理-->信息披露', '/product/notice/get_productId', 1, 1,'WM', 0);
	END IF;
	
	IF NOT EXISTS (select * from api_resource where `code`='product.cancel_focus' and url='/product/cancel_focus' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'product.cancel_focus', '产品管理-->取消关注', '/product/cancel_focus', 1, 1,'WM', 0);
	END IF;
	
	
	
	
	-- 产品审批
	IF NOT EXISTS (select * from api_resource where `code`='product.control.audit.get_history_audit_detail' and url='/product/control/audit/get_history_audit_detail' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'product.control.audit.get_history_audit_detail', '产品审批-->产品审批记录', '/product/control/audit/get_history_audit_detail', 1, 1,'WM', 0);
	END IF;
	set  _api_code = 'product.control.audit.get_history_audit_detail';
	set  _resource_code = 'product.control.audit';
	IF NOT EXISTS (SELECT * FROM api_resource_rel arr LEFT JOIN api_resource ar ON arr.api_id = ar.id LEFT JOIN resource r ON arr.resource_id = r.id
         where ar.`code` = _api_code and r.`code` = _resource_code and ar.url_type = 1) THEN
         SELECT id INTO _api_id FROM api_resource where `code` = _api_code and url_type = 1 and system_code = 'WM' and is_delete = 0  LIMIT 1;
         SELECT id INTO _resource_id FROM resource where `code` = _resource_code  LIMIT 1;
         INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `is_delete`) VALUES (_tenantId, _resource_id, _api_id, 0);
	END IF;
		
	IF NOT EXISTS (select * from api_resource where `code`='product.control.audit.get_page' and url='/product/control/audit/get_page' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'product.control.audit.get_page', '产品审批-->审批列表', '/product/control/audit/get_page', 1, 1,'WM', 0);
	END IF;
	set  _api_code = 'product.control.audit.get_page';
	set  _resource_code = 'product.control.audit';
	IF NOT EXISTS (SELECT * FROM api_resource_rel arr LEFT JOIN api_resource ar ON arr.api_id = ar.id LEFT JOIN resource r ON arr.resource_id = r.id
         where ar.`code` = _api_code and r.`code` = _resource_code and ar.url_type = 1) THEN
         SELECT id INTO _api_id FROM api_resource where `code` = _api_code and url_type = 1 and system_code = 'WM' and is_delete = 0  LIMIT 1;
         SELECT id INTO _resource_id FROM resource where `code` = _resource_code  LIMIT 1;
         INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `is_delete`) VALUES (_tenantId, _resource_id, _api_id, 0);
	END IF;
	

	IF NOT EXISTS (select * from api_resource where `code`='product.control.audit.do' and url='/product/control/audit/do' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'product.control.audit.do', '产品审批-->审批(通过/驳回)', '/product/control/audit/do', 1, 1,'WM', 0);
	END IF;
	set  _api_code = 'product.control.audit.do';
	set  _resource_code = 'product.examine.audit';
	IF NOT EXISTS (SELECT * FROM api_resource_rel arr LEFT JOIN api_resource ar ON arr.api_id = ar.id LEFT JOIN resource r ON arr.resource_id = r.id
         where ar.`code` = _api_code and r.`code` = _resource_code and ar.url_type = 1) THEN
         SELECT id INTO _api_id FROM api_resource where `code` = _api_code and url_type = 1 and system_code = 'WM' and is_delete = 0  LIMIT 1;
         SELECT id INTO _resource_id FROM resource where `code` = _resource_code  LIMIT 1;
         INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `is_delete`) VALUES (_tenantId, _resource_id, _api_id, 0);
	END IF;
		
	-- 客户公海
	IF NOT EXISTS (select * from api_resource where `code`='customer.opensea.receive_customer' and url='/customer/opensea/receive_customer' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'customer.opensea.receive_customer', '客户公海-->领取', '/customer/opensea/receive_customer', 1, 1,'WM', 0);
	END IF;
	set  _api_code = 'customer.opensea.receive_customer';
	set  _resource_code = 'customer.opensea.receive_customer';
	IF NOT EXISTS (SELECT * FROM api_resource_rel arr LEFT JOIN api_resource ar ON arr.api_id = ar.id LEFT JOIN resource r ON arr.resource_id = r.id
         where ar.`code` = _api_code and r.`code` = _resource_code and ar.url_type = 1) THEN
         SELECT id INTO _api_id FROM api_resource where `code` = _api_code and url_type = 1 and system_code = 'WM' and is_delete = 0  LIMIT 1;
         SELECT id INTO _resource_id FROM resource where `code` = _resource_code  LIMIT 1;
         INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `is_delete`) VALUES (_tenantId, _resource_id, _api_id, 0);
	END IF;
	
	IF NOT EXISTS (select * from api_resource where `code`='customer.opensea.get_page' and url='/customer/opensea/get_page' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'customer.opensea.get_page', '客户公海-->公海列表', '/customer/opensea/get_page', 1, 1,'WM', 0);
	END IF;
	set  _api_code = 'customer.opensea.get_page';
	set  _resource_code = 'customer.highseas';
	IF NOT EXISTS (SELECT * FROM api_resource_rel arr LEFT JOIN api_resource ar ON arr.api_id = ar.id LEFT JOIN resource r ON arr.resource_id = r.id
         where ar.`code` = _api_code and r.`code` = _resource_code and ar.url_type = 1) THEN
         SELECT id INTO _api_id FROM api_resource where `code` = _api_code and url_type = 1 and system_code = 'WM' and is_delete = 0  LIMIT 1;
         SELECT id INTO _resource_id FROM resource where `code` = _resource_code  LIMIT 1;
         INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `is_delete`) VALUES (_tenantId, _resource_id, _api_id, 0);
	END IF;
	
	IF NOT EXISTS (select * from api_resource where `code`='customer.validate_mobile' and url='/customer/validate_mobile' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'customer.validate_mobile', '客户公海-->添加客户--> 校验客户手机号码', '/customer/validate_mobile', 1, 1,'WM', 0);
	END IF;
	
	IF NOT EXISTS (select * from api_resource where `code`='customer.tag.get_top' and url='/customer/tag/get_top' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'customer.tag.get_top', '客户公海-->添加客户-->查询标签', '/customer/tag/get_top', 1, 1,'WM', 0);
	END IF;
	
	IF NOT EXISTS (select * from api_resource where `code`='customer.add_opensea' and url='/customer/add_opensea' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'customer.add_opensea', '客户公海-->添加客户', '/customer/add_opensea', 1, 1,'WM', 0);
	END IF;
	set  _api_code = 'customer.add_opensea';
	set  _resource_code = 'customer.add_opensea';
	IF NOT EXISTS (SELECT * FROM api_resource_rel arr LEFT JOIN api_resource ar ON arr.api_id = ar.id LEFT JOIN resource r ON arr.resource_id = r.id
         where ar.`code` = _api_code and r.`code` = _resource_code and ar.url_type = 1) THEN
         SELECT id INTO _api_id FROM api_resource where `code` = _api_code and url_type = 1 and system_code = 'WM' and is_delete = 0  LIMIT 1;
         SELECT id INTO _resource_id FROM resource where `code` = _resource_code  LIMIT 1;
         INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `is_delete`) VALUES (_tenantId, _resource_id, _api_id, 0);
	END IF;
	
	IF NOT EXISTS (select * from api_resource where `code`='customer.import.multi_from_opensea' and url='/customer/import/multi_from_opensea' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'customer.import.multi_from_opensea', '客户公海-->导入客户', '/customer/import/multi_from_opensea', 1, 1,'WM', 0);
	END IF;
	set  _api_code = 'customer.import.multi_from_opensea';
	set  _resource_code = 'customer.import.multi_from_opensea';
	IF NOT EXISTS (SELECT * FROM api_resource_rel arr LEFT JOIN api_resource ar ON arr.api_id = ar.id LEFT JOIN resource r ON arr.resource_id = r.id
         where ar.`code` = _api_code and r.`code` = _resource_code and ar.url_type = 1) THEN
         SELECT id INTO _api_id FROM api_resource where `code` = _api_code and url_type = 1 and system_code = 'WM' and is_delete = 0  LIMIT 1;
         SELECT id INTO _resource_id FROM resource where `code` = _resource_code  LIMIT 1;
         INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `is_delete`) VALUES (_tenantId, _resource_id, _api_id, 0);
	END IF;
	
	-- 回访管理
	IF NOT EXISTS (select * from api_resource where `code`='user.visit.get_page' and url='/user/visit/get_page' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'user.visit.get_page', '回访管理-->列表', '/user/visit/get_page', 1, 1,'WM', 0);
	END IF;
	set  _api_code = 'user.visit.get_page';
	set  _resource_code = 'operation.allot';
	IF NOT EXISTS (SELECT * FROM api_resource_rel arr LEFT JOIN api_resource ar ON arr.api_id = ar.id LEFT JOIN resource r ON arr.resource_id = r.id
         where ar.`code` = _api_code and r.`code` = _resource_code and ar.url_type = 1) THEN
         SELECT id INTO _api_id FROM api_resource where `code` = _api_code and url_type = 1 and system_code = 'WM' and is_delete = 0  LIMIT 1;
         SELECT id INTO _resource_id FROM resource where `code` = _resource_code  LIMIT 1;
         INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `is_delete`) VALUES (_tenantId, _resource_id, _api_id, 0);
	END IF;
	
	IF NOT EXISTS (select * from api_resource where `code`='user.visit.do' and url='/user/visit/do' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'user.visit.do', '回访管理-->回访', '/user/visit/do', 1, 1,'WM', 0);
	END IF;
	set  _api_code = 'user.visit.do';
	set  _resource_code = 'operation.allot';
	IF NOT EXISTS (SELECT * FROM api_resource_rel arr LEFT JOIN api_resource ar ON arr.api_id = ar.id LEFT JOIN resource r ON arr.resource_id = r.id
         where ar.`code` = _api_code and r.`code` = _resource_code and ar.url_type = 1) THEN
         SELECT id INTO _api_id FROM api_resource where `code` = _api_code and url_type = 1 and system_code = 'WM' and is_delete = 0  LIMIT 1;
         SELECT id INTO _resource_id FROM resource where `code` = _resource_code  LIMIT 1;
         INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `is_delete`) VALUES (_tenantId, _resource_id, _api_id, 0);
	END IF;
	
	
	-- 我的退款
	IF NOT EXISTS (select * from api_resource where `code`='refund.get_my_refund_page' and url='/refund/get_my_refund_page' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'refund.get_my_refund_page', '我的退款-->列表', '/refund/get_my_refund_page', 1, 1,'WM', 0);
	END IF;
	set  _api_code = 'refund.get_my_refund_page';
	set  _resource_code = 'sale.refunds';
	IF NOT EXISTS (SELECT * FROM api_resource_rel arr LEFT JOIN api_resource ar ON arr.api_id = ar.id LEFT JOIN resource r ON arr.resource_id = r.id
         where ar.`code` = _api_code and r.`code` = _resource_code and ar.url_type = 1) THEN
         SELECT id INTO _api_id FROM api_resource where `code` = _api_code and url_type = 1 and system_code = 'WM' and is_delete = 0  LIMIT 1;
         SELECT id INTO _resource_id FROM resource where `code` = _resource_code  LIMIT 1;
         INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `is_delete`) VALUES (_tenantId, _resource_id, _api_id, 0);
	END IF;
	
	IF NOT EXISTS (select * from api_resource where `code`='refund.resubmit' and url='/refund/resubmit' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'refund.resubmit', '我的退款-->重新提交', '/refund/resubmit', 1, 1,'WM', 0);
	END IF;
	set  _api_code = 'refund.resubmit';
	set  _resource_code = 'sale.refunds';
	IF NOT EXISTS (SELECT * FROM api_resource_rel arr LEFT JOIN api_resource ar ON arr.api_id = ar.id LEFT JOIN resource r ON arr.resource_id = r.id
         where ar.`code` = _api_code and r.`code` = _resource_code and ar.url_type = 1) THEN
         SELECT id INTO _api_id FROM api_resource where `code` = _api_code and url_type = 1 and system_code = 'WM' and is_delete = 0  LIMIT 1;
         SELECT id INTO _resource_id FROM resource where `code` = _resource_code  LIMIT 1;
         INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `is_delete`) VALUES (_tenantId, _resource_id, _api_id, 0);
	END IF;
	
	IF NOT EXISTS (select * from api_resource where `code`='refund.cancel' and url='/refund/cancel' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'refund.cancel', '我的退款-->取消退款', '/refund/cancel', 1, 1,'WM', 0);
	END IF;
	set  _api_code = 'refund.cancel';
	set  _resource_code = 'sale.refunds';
	IF NOT EXISTS (SELECT * FROM api_resource_rel arr LEFT JOIN api_resource ar ON arr.api_id = ar.id LEFT JOIN resource r ON arr.resource_id = r.id
         where ar.`code` = _api_code and r.`code` = _resource_code and ar.url_type = 1) THEN
         SELECT id INTO _api_id FROM api_resource where `code` = _api_code and url_type = 1 and system_code = 'WM' and is_delete = 0  LIMIT 1;
         SELECT id INTO _resource_id FROM resource where `code` = _resource_code  LIMIT 1;
         INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `is_delete`) VALUES (_tenantId, _resource_id, _api_id, 0);
	END IF;
	
	
	-- 退款审批
	IF NOT EXISTS (select * from api_resource where `code`='refund.audit.get_audit_page' and url='/refund/audit/get_audit_page' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'refund.audit.get_audit_page', '退款审批-->列表', '/refund/audit/get_audit_page', 1, 1,'WM', 0);
	END IF;
	set  _api_code = 'refund.audit.get_audit_page';
	set  _resource_code = 'sale.refunds.audit';
	IF NOT EXISTS (SELECT * FROM api_resource_rel arr LEFT JOIN api_resource ar ON arr.api_id = ar.id LEFT JOIN resource r ON arr.resource_id = r.id
         where ar.`code` = _api_code and r.`code` = _resource_code and ar.url_type = 1) THEN
         SELECT id INTO _api_id FROM api_resource where `code` = _api_code and url_type = 1 and system_code = 'WM' and is_delete = 0  LIMIT 1;
         SELECT id INTO _resource_id FROM resource where `code` = _resource_code  LIMIT 1;
         INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `is_delete`) VALUES (_tenantId, _resource_id, _api_id, 0);
	END IF;
	
	
	IF NOT EXISTS (select * from api_resource where `code`='refund.audit.do' and url='/refund/audit/do' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'refund.audit.do', '退款审批-->审批', '/refund/audit/do', 1, 1,'WM', 0);
	END IF;
	set  _api_code = 'refund.audit.do';
	set  _resource_code = 'refund.audit.do';
	IF NOT EXISTS (SELECT * FROM api_resource_rel arr LEFT JOIN api_resource ar ON arr.api_id = ar.id LEFT JOIN resource r ON arr.resource_id = r.id
         where ar.`code` = _api_code and r.`code` = _resource_code and ar.url_type = 1) THEN
         SELECT id INTO _api_id FROM api_resource where `code` = _api_code and url_type = 1 and system_code = 'WM' and is_delete = 0  LIMIT 1;
         SELECT id INTO _resource_id FROM resource where `code` = _resource_code  LIMIT 1;
         INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `is_delete`) VALUES (_tenantId, _resource_id, _api_id, 0);
	END IF;
	
	
	-- 组织架构管理
	IF NOT EXISTS (select * from api_resource where `code`='department.add' and url='/department/add' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'department.add', '组织架构管理-->添加部门', '/department/add', 1, 1,'WM', 0);
	END IF;
	set  _api_code = 'department.add';
	set  _resource_code = 'system.config.organization';
	IF NOT EXISTS (SELECT * FROM api_resource_rel arr LEFT JOIN api_resource ar ON arr.api_id = ar.id LEFT JOIN resource r ON arr.resource_id = r.id
         where ar.`code` = _api_code and r.`code` = _resource_code and ar.url_type = 1) THEN
         SELECT id INTO _api_id FROM api_resource where `code` = _api_code and url_type = 1 and system_code = 'WM' and is_delete = 0  LIMIT 1;
         SELECT id INTO _resource_id FROM resource where `code` = _resource_code  LIMIT 1;
         INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `is_delete`) VALUES (_tenantId, _resource_id, _api_id, 0);
	END IF;
	
	
	IF NOT EXISTS (select * from api_resource where `code`='department.update' and url='/department/update' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'department.update', '组织架构管理-->修改部门', '/department/update', 1, 1,'WM', 0);
	END IF;
	set  _api_code = 'department.update';
	set  _resource_code = 'system.config.organization';
	IF NOT EXISTS (SELECT * FROM api_resource_rel arr LEFT JOIN api_resource ar ON arr.api_id = ar.id LEFT JOIN resource r ON arr.resource_id = r.id
         where ar.`code` = _api_code and r.`code` = _resource_code and ar.url_type = 1) THEN
         SELECT id INTO _api_id FROM api_resource where `code` = _api_code and url_type = 1 and system_code = 'WM' and is_delete = 0  LIMIT 1;
         SELECT id INTO _resource_id FROM resource where `code` = _resource_code  LIMIT 1;
         INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `is_delete`) VALUES (_tenantId, _resource_id, _api_id, 0);
	END IF;
	
	IF NOT EXISTS (select * from api_resource where `code`='department.delete' and url='/department/delete' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'department.delete', '组织架构管理-->删除部门', '/department/delete', 1, 1,'WM', 0);
	END IF;
	set  _api_code = 'department.delete';
	set  _resource_code = 'system.config.organization';
	IF NOT EXISTS (SELECT * FROM api_resource_rel arr LEFT JOIN api_resource ar ON arr.api_id = ar.id LEFT JOIN resource r ON arr.resource_id = r.id
         where ar.`code` = _api_code and r.`code` = _resource_code and ar.url_type = 1) THEN
         SELECT id INTO _api_id FROM api_resource where `code` = _api_code and url_type = 1 and system_code = 'WM' and is_delete = 0  LIMIT 1;
         SELECT id INTO _resource_id FROM resource where `code` = _resource_code  LIMIT 1;
         INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `is_delete`) VALUES (_tenantId, _resource_id, _api_id, 0);
	END IF;
	
	IF NOT EXISTS (select * from api_resource where `code`='department.gets' and url='/department/gets' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'department.gets', '组织架构管理-->部门列表', '/department/gets', 1, 1,'WM', 0);
	END IF;
	set  _api_code = 'department.gets';
	set  _resource_code = 'system.config.organization';
	IF NOT EXISTS (SELECT * FROM api_resource_rel arr LEFT JOIN api_resource ar ON arr.api_id = ar.id LEFT JOIN resource r ON arr.resource_id = r.id
         where ar.`code` = _api_code and r.`code` = _resource_code and ar.url_type = 1) THEN
         SELECT id INTO _api_id FROM api_resource where `code` = _api_code and url_type = 1 and system_code = 'WM' and is_delete = 0  LIMIT 1;
         SELECT id INTO _resource_id FROM resource where `code` = _resource_code  LIMIT 1;
         INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `is_delete`) VALUES (_tenantId, _resource_id, _api_id, 0);
	END IF;
	
	IF NOT EXISTS (select * from api_resource where `code`='user.get_enabled_users' and url='/user/get_enabled_users' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'user.get_enabled_users', '组织架构管理-->在职员工列表', '/user/get_enabled_users', 1, 1,'WM', 0);
	END IF;
	set  _api_code = 'user.get_enabled_users';
	set  _resource_code = 'system.config.organization';
	IF NOT EXISTS (SELECT * FROM api_resource_rel arr LEFT JOIN api_resource ar ON arr.api_id = ar.id LEFT JOIN resource r ON arr.resource_id = r.id
         where ar.`code` = _api_code and r.`code` = _resource_code and ar.url_type = 1) THEN
         SELECT id INTO _api_id FROM api_resource where `code` = _api_code and url_type = 1 and system_code = 'WM' and is_delete = 0  LIMIT 1;
         SELECT id INTO _resource_id FROM resource where `code` = _resource_code  LIMIT 1;
         INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `is_delete`) VALUES (_tenantId, _resource_id, _api_id, 0);
	END IF;
	
	IF NOT EXISTS (select * from api_resource where `code`='user.get_cease_users' and url='/user/get_cease_users' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'user.get_cease_users', '组织架构管理-->停用员工', '/user/get_cease_users', 1, 1,'WM', 0);
	END IF;
	set  _api_code = 'user.get_cease_users';
	set  _resource_code = 'system.config.organization';
	IF NOT EXISTS (SELECT * FROM api_resource_rel arr LEFT JOIN api_resource ar ON arr.api_id = ar.id LEFT JOIN resource r ON arr.resource_id = r.id
         where ar.`code` = _api_code and r.`code` = _resource_code and ar.url_type = 1) THEN
         SELECT id INTO _api_id FROM api_resource where `code` = _api_code and url_type = 1 and system_code = 'WM' and is_delete = 0  LIMIT 1;
         SELECT id INTO _resource_id FROM resource where `code` = _resource_code  LIMIT 1;
         INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `is_delete`) VALUES (_tenantId, _resource_id, _api_id, 0);
	END IF;
	
	
	IF NOT EXISTS (select * from api_resource where `code`='user.cease' and url='/user/cease' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'user.cease', '组织架构管理-->在职员工列表-->停用员工', '/user/cease', 1, 1,'WM', 0);
	END IF;
	set  _api_code = 'user.cease';
	set  _resource_code = 'system.config.organization';
	IF NOT EXISTS (SELECT * FROM api_resource_rel arr LEFT JOIN api_resource ar ON arr.api_id = ar.id LEFT JOIN resource r ON arr.resource_id = r.id
         where ar.`code` = _api_code and r.`code` = _resource_code and ar.url_type = 1) THEN
         SELECT id INTO _api_id FROM api_resource where `code` = _api_code and url_type = 1 and system_code = 'WM' and is_delete = 0  LIMIT 1;
         SELECT id INTO _resource_id FROM resource where `code` = _resource_code  LIMIT 1;
         INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `is_delete`) VALUES (_tenantId, _resource_id, _api_id, 0);
	END IF;
	
	IF NOT EXISTS (select * from api_resource where `code`='user.enabled' and url='/user/enabled' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'user.enabled', '组织架构管理-->停用员工-->启用员工', '/user/enabled', 1, 1,'WM', 0);
	END IF;
	set  _api_code = 'user.enabled';
	set  _resource_code = 'system.config.organization';
	IF NOT EXISTS (SELECT * FROM api_resource_rel arr LEFT JOIN api_resource ar ON arr.api_id = ar.id LEFT JOIN resource r ON arr.resource_id = r.id
         where ar.`code` = _api_code and r.`code` = _resource_code and ar.url_type = 1) THEN
         SELECT id INTO _api_id FROM api_resource where `code` = _api_code and url_type = 1 and system_code = 'WM' and is_delete = 0  LIMIT 1;
         SELECT id INTO _resource_id FROM resource where `code` = _resource_code  LIMIT 1;
         INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `is_delete`) VALUES (_tenantId, _resource_id, _api_id, 0);
	END IF;
	
	IF NOT EXISTS (select * from api_resource where `code`='user.check_mobile_exist' and url='/user/check_mobile_exist' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'user.check_mobile_exist', '组织架构管理-->添加用户-->检查手机号码是否存在', '/user/check_mobile_exist', 1, 1,'WM', 0);
	END IF;
	set  _api_code = 'user.check_mobile_exist';
	set  _resource_code = 'system.config.organization';
	IF NOT EXISTS (SELECT * FROM api_resource_rel arr LEFT JOIN api_resource ar ON arr.api_id = ar.id LEFT JOIN resource r ON arr.resource_id = r.id
         where ar.`code` = _api_code and r.`code` = _resource_code and ar.url_type = 1) THEN
         SELECT id INTO _api_id FROM api_resource where `code` = _api_code and url_type = 1 and system_code = 'WM' and is_delete = 0  LIMIT 1;
         SELECT id INTO _resource_id FROM resource where `code` = _resource_code  LIMIT 1;
         INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `is_delete`) VALUES (_tenantId, _resource_id, _api_id, 0);
	END IF;
	
	IF NOT EXISTS (select * from api_resource where `code`='user.check_job_number_exist' and url='/user/check_job_number_exist' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'user.check_job_number_exist', '组织架构管理-->添加用户-->检查工号是否存在', '/user/check_job_number_exist', 1, 1,'WM', 0);
	END IF;
	set  _api_code = 'user.check_job_number_exist';
	set  _resource_code = 'system.config.organization';
	IF NOT EXISTS (SELECT * FROM api_resource_rel arr LEFT JOIN api_resource ar ON arr.api_id = ar.id LEFT JOIN resource r ON arr.resource_id = r.id
         where ar.`code` = _api_code and r.`code` = _resource_code and ar.url_type = 1) THEN
         SELECT id INTO _api_id FROM api_resource where `code` = _api_code and url_type = 1 and system_code = 'WM' and is_delete = 0  LIMIT 1;
         SELECT id INTO _resource_id FROM resource where `code` = _resource_code  LIMIT 1;
         INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `is_delete`) VALUES (_tenantId, _resource_id, _api_id, 0);
	END IF;
	
	IF NOT EXISTS (select * from api_resource where `code`='user.get_key_public' and url='/user/get_key_public' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'user.get_key_public', '组织架构管理-->添加用户-->获取公钥', '/user/get_key_public', 1, 1,'WM', 0);
	END IF;
	
	
	IF NOT EXISTS (select * from api_resource where `code`='user.add' and url='/user/add' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'user.add', '组织架构管理-->添加用户', '/user/add', 1, 1,'WM', 0);
	END IF;
	set  _api_code = 'user.add';
	set  _resource_code = 'system.config.organization';
	IF NOT EXISTS (SELECT * FROM api_resource_rel arr LEFT JOIN api_resource ar ON arr.api_id = ar.id LEFT JOIN resource r ON arr.resource_id = r.id
         where ar.`code` = _api_code and r.`code` = _resource_code and ar.url_type = 1) THEN
         SELECT id INTO _api_id FROM api_resource where `code` = _api_code and url_type = 1 and system_code = 'WM' and is_delete = 0  LIMIT 1;
         SELECT id INTO _resource_id FROM resource where `code` = _resource_code  LIMIT 1;
         INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `is_delete`) VALUES (_tenantId, _resource_id, _api_id, 0);
	END IF;
	
	
	-- 产品推荐配置
	IF NOT EXISTS (select * from api_resource where `code`='cms.product.recommend.get_page' and url='/cms/product/recommend/get_page' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'cms.product.recommend.get_page', '产品推荐配置-->列表', '/cms/product/recommend/get_page', 1, 1,'WM', 0);
	END IF;
	set  _api_code = 'cms.product.recommend.get_page';
	set  _resource_code = 'cms.product.recommend';
	
	
	IF NOT EXISTS (select * from api_resource where `code`='cms.product.recommend.get' and url='/cms/product/recommend/get' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'cms.product.recommend.get', '产品推荐配置-->查询详情', '/cms/product/recommend/get', 1, 1,'WM', 0);
	END IF;
	set  _api_code = 'cms.product.recommend.get';
	set  _resource_code = 'cms.product.recommend';
	
	IF NOT EXISTS (select * from api_resource where `code`='cms.product.recommend.update' and url='/cms/product/recommend/update' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'cms.product.recommend.update', '产品推荐配置-->修改', '/cms/product/recommend/update', 1, 1,'WM', 0);
	END IF;
	set  _api_code = 'cms.product.recommend.update';
	set  _resource_code = 'cms.product.recommend';
	
	IF NOT EXISTS (select * from api_resource where `code`='cms.product.recommend.delete' and url='/cms/product/recommend/delete' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'cms.product.recommend.delete', '产品推荐配置-->删除', '/cms/product/recommend/delete', 1, 1,'WM', 0);
	END IF;
	set  _api_code = 'cms.product.recommend.delete';
	set  _resource_code = 'cms.product.recommend';
	
	IF NOT EXISTS (select * from api_resource where `code`='cms.product.recommend.add' and url='/cms/product/recommend/add' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`, `is_delete`) 
       VALUES (_tenantId, 'cms.product.recommend.add', '产品推荐配置-->添加', '/cms/product/recommend/add', 1, 1,'WM', 0);
	END IF;
	set  _api_code = 'cms.product.recommend.add';
	set  _resource_code = 'cms.product.recommend';
	
	
end;

call tenant_sql_update_1_1();

DROP PROCEDURE if exists tenant_sql_update_1_1;
//