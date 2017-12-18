delimiter //

drop procedure if exists scm_sql_update;

create procedure scm_sql_update()
begin

	


IF NOT EXISTS (SELECT 1 FROM resource WHERE id=110) THEN

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('110', NULL, 'investment', 'WM', '0', '投资管理', '/investment', '1', '1', '1', '投资管理', '0', '-1', SYSDATE(), NULL, NULL, '0');

END IF;

  IF NOT EXISTS (SELECT 1 FROM resource WHERE id=111) THEN

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('111', NULL, 'assets.index', 'WM', '110', '首页', '/assets/index', '1', '1', '1', '首页', '10'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');

  END IF;

  IF NOT EXISTS (SELECT 1 FROM resource WHERE id=112) THEN

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('112', NULL, 'assets.project', 'WM', '110', '项目', '/assets/project', '1', '1', '1', '项目', '20'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');

  END IF;


  IF NOT EXISTS (SELECT 1 FROM resource WHERE id=113) THEN

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('113', NULL, 'assets.investment', 'WM', '110', '投资管理', '/assets/investment', '1', '1', '1', '投资管理', '30'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');

  END IF;

  IF NOT EXISTS (SELECT 1 FROM resource WHERE id=114) THEN

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('114', NULL, 'assets.withdrawal', 'WM', '110', '退出管理', '/assets/withdrawal', '1', '1', '1', '退出管理', '40'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');

  END IF;

  IF NOT EXISTS (SELECT 1 FROM resource WHERE id=115) THEN

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('115', NULL, 'assets.fund', 'WM', '110', '基金', '/assets/fund', '1', '1', '1', '基金', '50'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');

  END IF;


  IF NOT EXISTS (SELECT 1 FROM resource WHERE id=116) THEN

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('116', NULL, 'assets.project.audit_history', 'WM', '110', '审批历史', '/assets/project/audit_history', '1', '1', '0', '审批历史', '60'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');

  END IF;


   IF NOT EXISTS (SELECT 1 FROM resource WHERE id=117) THEN
INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('117', NULL, 'wealth', 'WM', '0', '财富管理', '/wealth', '1', '1', '1', '财富管理', '20'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');
  END IF;

  IF NOT EXISTS (SELECT 1 FROM resource WHERE id=118) THEN
INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('118', NULL, 'backstage', 'WM', '0', '后台管理', '/backstage', '1', '1', '1', '后台管理', '30'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');
  END IF;


    IF NOT EXISTS (SELECT 1 FROM resource WHERE id=119) THEN
INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('119', NULL, 'assets.index.audit.todo', 'WM', '111', '待我审批', '/assets/index/audit/todo', '0', '1', '1', '待我审批', '10'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');
  END IF;

      IF NOT EXISTS (SELECT 1 FROM resource WHERE id=120) THEN
INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('120', NULL, 'assets.index.audit_history.get_page', 'WM', '111', '审批历史', '/assets/index/audit_history/get_page', '0', '1', '1', '审批历史', '20'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');
  END IF;

     IF NOT EXISTS (SELECT 1 FROM resource WHERE id=121) THEN
INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('121', NULL, 'assets.index.report', 'WM', '111', '资产管理概况', '/assets/index/report', '0', '1', '1', '资产管理概况', '30'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');
  END IF;

       IF NOT EXISTS (SELECT 1 FROM resource WHERE id=122) THEN
INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('122', NULL, 'assets.project.add', 'WM', '112', '新增项目', '/assets/project/add', '0', '1', '1', '新增项目', '10'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');
  END IF;

  IF NOT EXISTS (SELECT 1 FROM resource WHERE id=123) THEN
INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('123', NULL, 'assets.project.decision.audit_decisioning', 'WM', '112', '立项会审批', '/assets/project/decision/audit_decisioning', '0', '1', '1', '立项会审批', '20'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');
  END IF;

    IF NOT EXISTS (SELECT 1 FROM resource WHERE id=124) THEN
INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('124', NULL, 'assets.project.decision.audit_due_diligence', 'WM', '112', '尽职调查审批', '/assets/project/decision/audit_due_diligence', '0', '1', '1', '尽职调查审批', '30'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');
  END IF;

    IF NOT EXISTS (SELECT 1 FROM resource WHERE id=125) THEN
INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('125', NULL, 'assets.project.decision.audit_first_trial', 'WM', '112', '初审审批', '/assets/project/decision/audit_first_trial', '0', '1', '1', '初审审批', '40'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');
  END IF;

      IF NOT EXISTS (SELECT 1 FROM resource WHERE id=126) THEN
INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('126', NULL, 'assets.project.decision.audit_investment_commission', 'WM', '112', '投委会审批', '/assets/project/decision/audit_investment_commission', '0', '1', '1', '投委会审批', '50'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');
  END IF;

        IF NOT EXISTS (SELECT 1 FROM resource WHERE id=127) THEN
INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('127', NULL, 'assets.project.decision.audit_invest', 'WM', '112', '出资审批', '/assets/project/decision/audit_invest', '0', '1', '1', '出资审批', '60'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');
  END IF;


   IF NOT EXISTS (SELECT 1 FROM resource WHERE id=128) THEN
INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('128', NULL, 'assets.fund.add', 'WM', '115', '新增基金', '/assets/fund/add', '0', '1', '1', '新增基金', '10'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');
  END IF;

   IF NOT EXISTS (SELECT 1 FROM resource WHERE id=129) THEN
INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('129', NULL, 'assets.investment.add', 'WM', '113', '新增出资', '/assets/investment/add', '0', '1', '1', '新增出资', '10'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');
  END IF;

     IF NOT EXISTS (SELECT 1 FROM resource WHERE id=130) THEN
INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('130', NULL, 'assets.withdrawal.add', 'WM', '114', '新增退出', '/assets/withdrawal/add', '0', '1', '1', '新增退出', '10'/*排序*/, '-1', SYSDATE(), NULL, NULL, '0');
  END IF;


   IF NOT EXISTS (SELECT 1 FROM resource WHERE parent_id=117 AND id=21) THEN
  UPDATE resource SET parent_id=117 WHERE  id IN(21,8,22,26,77);
  UPDATE resource SET parent_id=118 WHERE  id IN(1,4,87);
  END IF;


	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 110 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (110, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 111 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (111, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 112 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (112, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 113 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (113, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 114 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (114, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 115 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (115, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 116 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (116, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 117 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (117, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 118 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (118, 1);
	END IF;







 IF NOT EXISTS (select * from role WHERE id=10) THEN
INSERT INTO `role` (`id`, `tenant_id`, `parent_id`, `name`, `description`, `is_share`, `is_enabled`, `is_system`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('10', NULL, '0','项目经理', '项目经理', '0', '1', '0', '10', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

 IF NOT EXISTS (select * from role WHERE id=11) THEN
INSERT INTO `role` (`id`, `tenant_id`, `parent_id`,`name`, `description`, `is_share`, `is_enabled`, `is_system`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('11', NULL, '0', '项目总监', '项目总监', '0', '1', '0', '11', '-1', SYSDATE(), NULL, NULL, '0');
END IF;


  /*项目经理 投资管理*/
IF NOT EXISTS (select * from role_resource WHERE resource_id=110 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 110, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目经理 首页*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=111 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 111, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

    /*项目经理 待我审批*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=119 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 119, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目经理 审批历史*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=120 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 120, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目经理 资产管理概况*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=121 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 121, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目经理 项目*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=112 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 112, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目经理 新增项目*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=122 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 122, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目经理 基金*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=115 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 115, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目经理 新增基金*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=128 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 128, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;


  /*项目经理 投资管理*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=113 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 113, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目经理 新增出资*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=129 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 129, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目经理 退出管理*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=114 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 114, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目经理 新增退出*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=130 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 130, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目经理 财富管理*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=117 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 117, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目经理 产品中心*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=21 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 21, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目经理 产品管理*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=8 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 8, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目经理 产品管理*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=9 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 9, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目经理 公告管理*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=13 AND role_id=10) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 13, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;






   /*项目总监 投资管理*/
IF NOT EXISTS (select * from role_resource WHERE resource_id=110 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 110, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目总监 首页*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=111 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 111, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

    /*项目总监 待我审批*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=119 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 119, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目总监 审批历史*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=120 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 120, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目总监 资产管理概况*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=121 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 121, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目总监 项目*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=112 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 112, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目总监 新增项目*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=122 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 122, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目总监 基金*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=115 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 115, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目总监 新增基金*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=128 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 128, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;


  /*项目总监 投资管理*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=113 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 113, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目总监 新增出资*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=129 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 129, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目总监 退出管理*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=114 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 114, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目总监 新增退出*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=130 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 130, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目总监 财富管理*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=117 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 117, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目总监 产品中心*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=21 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 21, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目总监 产品管理*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=8 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 8, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目总监 产品管理*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=9 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 9, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;

  /*项目总监 公告管理*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=13 AND role_id=11) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 13, 10, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;


  /*项目总监 立项会审批*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=123 AND role_id=1) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 123, 1, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;
  /*项目总监 尽职调查审批*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=124 AND role_id=1) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 124, 1, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;
  /*项目总监 初审审批*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=125 AND role_id=1) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 125, 1, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;
  /*项目总监 投委会审批*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=126 AND role_id=1) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 126, 1, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;
  /*项目总监 出资审批*/
  IF NOT EXISTS (select * from role_resource WHERE resource_id=127 AND role_id=1) THEN
INSERT INTO `role_resource` ( `tenant_id`, `resource_id`, `role_id`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
VALUES ( NULL, 127, 1, '1', '-1', SYSDATE(), NULL, NULL, '0');
END IF;


IF NOT EXISTS (SELECT * FROM resource WHERE code='proconf' and name='基金产品配置') THEN
  UPDATE resource SET name='基金产品配置' WHERE code='proconf';
END IF;

IF NOT EXISTS (SELECT * FROM resource WHERE code='proconf.product.config.elements' and name='要素配置') THEN
  UPDATE resource SET name='要素配置' WHERE code='proconf.product.config.elements';
END IF;

IF NOT EXISTS (SELECT * FROM resource WHERE code='proconf.product.config.type' and name='产品类别管理') THEN
  UPDATE resource SET name='类别配置' WHERE code='proconf.product.config.type';
END IF;


	IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE table_schema = DATABASE()  AND table_name = 'tenant' AND column_name = 'limit_employee_count') THEN
	ALTER TABLE tenant ADD limit_employee_count INT NULL COMMENT '限制员工数';
ALTER TABLE tenant
  MODIFY COLUMN limit_employee_count INT COMMENT '限制员工数' AFTER sequence;
  END IF;

	UPDATE tenant SET limit_employee_count=20 WHERE limit_employee_count IS NULL;

  IF EXISTS (SELECT * FROM resource WHERE id=70) THEN
DELETE FROM resource WHERE id=70;
END IF;

IF EXISTS (SELECT * FROM resource WHERE id=71) THEN
DELETE FROM resource WHERE id=71;
END IF;


IF EXISTS (SELECT * FROM role_resource WHERE resource_id=70) THEN
DELETE FROM role_resource WHERE resource_id=70;
END IF;

IF EXISTS (SELECT * FROM role_resource WHERE resource_id=71) THEN
DELETE FROM role_resource WHERE resource_id=71;
END IF;










/*  以下为鉴权相关脚本  */




CREATE TABLE IF NOT EXISTS `api_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `code` varchar(64) DEFAULT NULL COMMENT '编码',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编码',
  `name` varchar(32) DEFAULT NULL COMMENT '名字',
  `url` varchar(256) DEFAULT NULL COMMENT '链接',
  `url_type` tinyint(2) DEFAULT '1' COMMENT '链接类型；1：PC，2：APP',
  `is_enabled` tinyint(2) DEFAULT '1' COMMENT '是否启用，0：否，1：是',
  `is_whitelist` tinyint(2) DEFAULT NULL COMMENT '是否白名单',
  `description` varchar(512) DEFAULT NULL COMMENT '描述',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique` (`code`,`url_type`) USING BTREE,
  UNIQUE KEY `code_uq` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='api资源表';


CREATE TABLE IF NOT EXISTS `api_resource_rel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `resource_id` bigint(20) DEFAULT NULL COMMENT '资源id',
  `api_id` bigint(20) DEFAULT NULL COMMENT 'api资源id',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='api资源关系表';


IF NOT EXISTS (SELECT * FROM information_schema.statistics WHERE table_schema=DATABASE() AND table_name = 'api_resource_rel' AND index_name = 'resource_id_index') THEN
 create index resource_id_index on api_resource_rel
(
   resource_id
);
END IF;


IF NOT EXISTS (SELECT * FROM information_schema.statistics WHERE table_schema=DATABASE() AND table_name = 'api_resource_rel' AND index_name = 'api_id_index') THEN
 create index api_id_index on api_resource_rel
(
   api_id
);
END IF;





/* 处理两个在resource表重复的url */
IF NOT EXISTS (select * from resource where `code`='system' AND url='/system') THEN
UPDATE resource SET url='/system' WHERE code='system';
END IF;

IF NOT EXISTS (select * from resource where `code`='customer.pool.add' AND url='/customer/pool/add') THEN
UPDATE resource SET url='/customer/pool/add' WHERE code='customer.pool.add';
END IF;


IF NOT EXISTS (select * from api_resource where `code`='reservation.add') THEN

/*=============我的预约 BEGIN==============*/

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'reservation.add', 'WM', '我的预约-->从我的预约页面进行预约', '/reservation/add', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,55,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='reservation.add';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'reservation.submit_declaration', 'WM', '我的预约-->从我的预约页面提交报单', '/reservation/submit_declaration', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,27,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='reservation.submit_declaration';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'reservation.cancel', 'WM', '我的预约-->取消预约', '/reservation/cancel', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,27,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='reservation.cancel';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'reservation.again_commit', 'WM', '我的预约-->重新提交', '/reservation/again_commit', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,27,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='reservation.again_commit';


-- INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
-- VALUES (NULL, 'reservation.get', 'WM', '我的预约-->获取预约详情接口', '/reservation/get', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

/*=============我的预约 END==============*/


/*=============额度预约审批 BEGIN==============*/

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'reservation.audit.get_page', 'WM', '预约额度审批-->获取预约额度审批分页数据接口', '/reservation/audit/get_page', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,29,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='reservation.audit.get_page';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'reservation.audit.do', 'WM', '预约额度审批-->预约额度审批页面，审批操作接口', '/reservation/audit/do', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,57,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='reservation.audit.do';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'reservation.audit.discard', 'WM', '预约额度审批-->预约作废', '/reservation/audit/discard', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,65,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='reservation.audit.discard';


INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'reservation.audit.gets_audit_record', 'WM', '预约额度审批-->获取审批记录接口', '/reservation/audit/gets_audit_record', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,29,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='reservation.audit.gets_audit_record';

/*=============额度预约审批 END==============*/


/*=============销售线索 BEGIN==============*/

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'leads.get_page', 'WM', '销售线索管理-->销售线索管理分页接口', '/leads/get_page', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,67,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='leads.get_page';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'leads.customer.get_unallot', 'WM', '销售线索管理-->获取未被分配的销售线索接口', '/leads/customer/get_unallot', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,68,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='leads.customer.get_unallot';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'leads.allot', 'WM', '销售线索管理-->销售线索分配回访接口', '/leads/allot', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,68,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='leads.allot';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'leads.try_allot', 'WM', '销售线索管理-->销售线索尝试分配客服', '/leads/try_allot', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,68,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='leads.try_allot';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'leads.allot_to_fp', 'WM', '销售线索管理-->销售线索分配给理财师', '/leads/allot_to_fp', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,69,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='leads.allot_to_fp';

/*=============销售线索 END==============*/


/*=============回款计划管理 BEGIN==============*/

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'receipt.plan.get_page', 'WM', '回款计划管理-->回款计划分页数据接口', '/receipt/plan/get_page', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,78,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.get_page';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'receipt.plan.delete', 'WM', '回款计划管理-->删除回款计划接口', '/receipt/plan/delete', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,78,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.delete';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'receipt.record.add', 'WM', '回款计划管理-->录入回款接口', '/receipt/record/add', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,78,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.record.add';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'receipt.plan.check_name_exist', 'WM', '回款计划管理-->检查回款计划名称是否存在接口', '/receipt/plan/check_name_exist', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,86,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.check_name_exist';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'product.get_select_option_for_receipt', 'WM', '回款计划管理-->添加回款计划 产品自动补全下拉接口', '/product/get_select_option_for_receipt', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,86,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='product.get_select_option_for_receipt';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'receipt.plan.add', 'WM', '回款计划管理-->添加回款计划接口', '/receipt/plan/add', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,86,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.add';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'receipt.plan.get', 'WM', '回款计划管理-->获取回款计划详情接口', '/receipt/plan/get', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,78,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.get';

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,79,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.get';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'receipt.plan.detail.get_receipts', 'WM', '回款计划管理-->回款计划详情回款记录列表接口', '/receipt/plan/detail/get_receipts', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,78,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.detail.get_receipts';

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,79,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.detail.get_receipts';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'receipt.record.delete', 'WM', '回款计划管理-->回款计划详情 删除回款记录几口', '/receipt/record/delete', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,78,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.record.delete';

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,79,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.record.delete';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'receipt.plan.update', 'WM', '回款计划管理-->修改回款计划接口', '/receipt/plan/update', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,78,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.update';

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,79,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.update';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'receipt.plan.detail.get_declarations', 'WM', '回款计划管理-->回款计划详情 关联报单列表接口', '/receipt/plan/detail/get_declarations', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,78,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.detail.get_declarations';

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,79,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.detail.get_declarations';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'receipt.plan.delete_declaration_rel', 'WM', '回款计划管理-->回款计划详情 移除关联报单', '/receipt/plan/delete_declaration_rel', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,78,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.delete_declaration_rel';

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,79,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.delete_declaration_rel';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'receipt.record.get_can_receipt_declarations', 'WM', '回款计划管理-->回款计划详情 获取可新增的关联报单接口', '/receipt/record/get_can_receipt_declarations', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,78,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.record.get_can_receipt_declarations';

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,79,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.record.get_can_receipt_declarations';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'receipt.plan.add_declaration_rel', 'WM', '回款计划管理-->回款计划详情 新增关联报单', '/receipt/plan/add_declaration_rel', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,78,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.add_declaration_rel';

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,79,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.add_declaration_rel';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'receipt.plan.check_name_exist_for_update', 'WM', '回款计划管理-->检查回款计划名称是否存在（更新操作使用）', '/receipt/plan/check_name_exist_for_update', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,78,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.check_name_exist_for_update';

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,79,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.check_name_exist_for_update';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'receipt.plan.detail.get_supplier', 'WM', '回款计划管理-->获取产品供应商', '/receipt/plan/detail/get_supplier', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,78,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.detail.get_supplier';

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,79,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='receipt.plan.detail.get_supplier';

/*=============额度预约审批 END==============*/


/*=============角色权限管理 BEGIN==============*/

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'role.gets', 'WM', '角色权限管理-->获取角色列表接口', '/role/gets', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,2,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='role.gets';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'resource.get_by_role_id', 'WM', '角色权限管理-->获取角色对应的资源列表接口', '/resource/get_by_role_id', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,2,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='resource.get_by_role_id';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'data.object.gets', 'WM', '角色权限管理-->获取角色对应的数据权限列表接口', '/data/object/gets', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,2,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='data.object.gets';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'user.get_by_role', 'WM', '角色权限管理-->获取角色关联员工列表接口', '/user/get_by_role', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,2,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='user.get_by_role';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'role.add', 'WM', '角色权限管理-->添加角色接口', '/role/add', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,2,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='role.add';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'role.update', 'WM', '角色权限管理-->修改角色接口', '/role/update', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,2,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='role.update';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'role.delete', 'WM', '角色权限管理-->删除角色接口', '/role/delete', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,2,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='role.delete';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'resource.update_by_role_id', 'WM', '角色权限管理-->修改角色的功能权限接口', '/resource/update_by_role_id', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,2,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='resource.update_by_role_id';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'user.get_for_org', 'WM', '角色权限管理-->查看员工详情', '/user/get_for_org', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,2,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='user.get_for_org';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'user.modify', 'WM', '角色权限管理&组织架构管理-->编辑用户', '/user/modify', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,2,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='user.modify';

/*=============角色权限管理 END==============*/


/*=============客户 BEGIN==============*/

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'customer.v2.get_page', 'WM', '客户-->获取分页数据', '/customer/v2/get_page', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,91,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='customer.v2.get_page';
/* 已存在
INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'user.get_users_by_realName', 'WM', '客户-->根据用户姓名自动补全，用于调配客户', '/user/get_users_by_realName', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');
*/
  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,95,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='user.get_users_by_realName';

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,97,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='user.get_users_by_realName';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'customer.v2.back.apply', 'WM', '客户-->放弃', '/customer/v2/back/apply', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,92,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='customer.v2.back.apply';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'customer.v2.add', 'WM', '客户-->新增客户', '/customer/v2/add', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,93,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='customer.v2.add';


INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'customer.v2.import.multi', 'WM', '客户-->批量导入客户', '/customer/v2/import/multi', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,94,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='customer.v2.import.multi';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'customer.v2.distribution.allot_to_fp', 'WM', '客户-->调配', '/customer/v2/distribution/allot_to_fp', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,95,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='customer.v2.distribution.allot_to_fp';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'customer.v2.distribution.recycle', 'WM', '客户-->回收', '/customer/v2/distribution/recycle', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,96,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='customer.v2.distribution.recycle';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'customer.v2.distribution.allot_to_cs', 'WM', '客户-->分配回访', '/customer/v2/distribution/allot_to_cs', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,97,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='customer.v2.distribution.allot_to_cs';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'user.customer.v2.focus', 'WM', '客户-->关注', '/user/customer/v2/focus', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,98,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='user.customer.v2.focus';

/*=============客户 END==============*/



/*=============组织架构管理 BEGIN==============*/



INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'department.gets', 'WM', '组织架构管理-->获取部门接口', '/department/gets', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,6,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='department.gets';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'user.get_enabled_users', 'WM', '组织架构管理-->获取在职员工接口', '/user/get_enabled_users', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,6,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='user.get_enabled_users';

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'user.get_cease_users', 'WM', '组织架构管理-->获取停用员工接口', '/user/get_cease_users', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,6,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='user.get_cease_users';


INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'user.cease', 'WM', '组织架构管理-->停用员工接口', '/user/cease', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,6,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='user.cease';


INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'user.enabled', 'WM', '组织架构管理-->启用员工接口', '/user/enabled', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,6,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='user.enabled';


INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'department.add', 'WM', '组织架构管理-->新增部门接口', '/department/add', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,6,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='department.add';


INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'department.update', 'WM', '组织架构管理-->编辑部门接口', '/department/update', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,6,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='department.update';


INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'department.delete', 'WM', '组织架构管理-->删除部门接口', '/department/delete', '1', '1',0,NULL , SYSDATE(), NULL, NULL, NULL, '0');

  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,6,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='department.delete';



  /*获取用户详情*/
  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,6,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='user.get_for_org';

  /*编辑用户详情*/
  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,6,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='user.modify';

  /*选择角色 下拉*/
  INSERT INTO `api_resource_rel` (`tenant_id`, `resource_id`, `api_id`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
  SELECT NULL,6,id,SYSDATE(),NULL,NULL,NULL,0 FROM api_resource WHERE  code='role.gets';



/*=============组织架构管理 END==============*/



/*=============白名单 BEGIN==============*/

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'customer.validate_mobile', 'WM', '白名单-->验证客户手机号是否可用', '/customer/validate_mobile', '1', '1',1,NULL , SYSDATE(), NULL, NULL, NULL, '0');

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'customer.update', 'WM', '白名单-->编辑客户基本资料', '/customer/update', '1', '1',1,NULL , SYSDATE(), NULL, NULL, NULL, '0');

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'customer.update_info', 'WM', '白名单-->编辑客户信息', '/customer/update_info', '1', '1',1,NULL , SYSDATE(), NULL, NULL, NULL, '0');

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'customer.update_contact', 'WM', '白名单-->编辑客户联系方式', '/customer/update_contact', '1', '1',1,NULL , SYSDATE(), NULL, NULL, NULL, '0');

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'customer.get_detail', 'WM', '白名单-->获取客户详情', '/customer/get_detail', '1', '1',1,NULL , SYSDATE(), NULL, NULL, NULL, '0');

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'customer.get_user_customer', 'WM', '白名单-->获取我的客户下拉选项', '/customer/get_user_customer', '1', '1',1,NULL , SYSDATE(), NULL, NULL, NULL, '0');

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'customer.follow.add', 'WM', '白名单-->添加跟进', '/customer/follow/add', '1', '1',1,NULL , SYSDATE(), NULL, NULL, NULL, '0');

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'leads.customer.detail.get_page', 'WM', '白名单-->获取客户详情页面销售线索列表', '/leads/customer/detail/get_page', '1', '1',1,NULL , SYSDATE(), NULL, NULL, NULL, '0');

INSERT INTO `api_resource` ( `tenant_id`, `code`, `system_code`, `name`, `url`, `url_type`, `is_enabled`,is_whitelist, `description`, `create_date`, `create_user_id`, `update_user_id`, `update_date`, `is_delete`)
VALUES (NULL, 'leads.process', 'WM', '白名单-->处理销售线索', '/leads/process', '1', '1',1,NULL , SYSDATE(), NULL, NULL, NULL, '0');



	-- 白名单
	IF NOT EXISTS (select * from api_resource where `code`='resource.get_menu' and url='/resource/get_menu' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`,
       `is_delete`,is_whitelist,create_date)
       VALUES (NULL, 'resource.get_menu', '白名单-->获取菜单和功能权限', '/resource/get_menu', 1, 1,'WM', 0,1,SYSDATE());
	END IF;

	IF NOT EXISTS (select * from api_resource where `code`='dictionary.gets' and url='/dictionary/gets' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`,
       `is_delete`,is_whitelist,create_date)
       VALUES (NULL, 'dictionary.gets', '白名单-->获取数据字段', '/dictionary/gets', 1, 1,'WM', 0,1,SYSDATE());
	END IF;

	IF NOT EXISTS (select * from api_resource where `code`='msg.message.get_unread_count' and url='/msg/message/get_unread_count' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`,
       `is_delete`,is_whitelist,create_date)
       VALUES (NULL, 'msg.message.get_unread_count', '白名单-->获取消息的个数', '/msg/message/get_unread_count', 1, 1,
       'WM', 0,1,SYSDATE());
	END IF;

	IF NOT EXISTS (select * from api_resource where `code`='product.fieldgroup.get_all' and url='/product/fieldgroup/get_all' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`,
       `is_delete`,is_whitelist,create_date)
       VALUES (NULL, 'product.fieldgroup.get_all', '白名单-->获取所有产品类别', '/product/fieldgroup/get_all', 1, 1,'WM',
       0,1,SYSDATE());
	END IF;


	IF NOT EXISTS (select * from api_resource where `code`='msg.message.get_my_page' and url='/msg/message/get_my_page' and url_type = 1 and system_code = 'WM'   and is_delete = 0) THEN
       INSERT INTO `api_resource` (`tenant_id`, `code`, `name`, `url`, `url_type`, `is_enabled`,`system_code`,
       `is_delete`,is_whitelist,create_date)
       VALUES (NULL, 'msg.message.get_my_page', '白名单-->分页获取消息列表', '/msg/message/get_my_page', 1, 1,'WM', 0,1,SYSDATE());
	END IF;

	/*=============白名单 END==============*/




/* 将没有 财富管理 的角色 勾上 */
INSERT INTO role_resource (tenant_id,resource_id,role_id,create_date)
SELECT NULL,117,r.id,SYSDATE() FROM role r WHERE EXISTS(SELECT 1 FROM role_resource rr2 WHERE rr2.role_id=r.id AND
rr2.resource_id IN(8,21,22,26,77) AND NOT EXISTS(SELECT 1 FROM role_resource rr3 WHERE  rr3.role_id=r.id and rr3.resource_id=117)
);


/* 将没有 数据报表(APP) 的角色 勾上 */
INSERT INTO role_resource (tenant_id,resource_id,role_id,create_date)
SELECT NULL,99,r.id,SYSDATE() FROM role r WHERE EXISTS(SELECT 1 FROM role_resource rr2 WHERE rr2.role_id=r.id AND
rr2.resource_id IN(100,101,102,105) AND NOT EXISTS(SELECT 1 FROM role_resource rr3 WHERE  rr3.role_id=r.id and rr3.resource_id=99)
);


/* 将没有 投资管理 的角色 勾上 */
INSERT INTO role_resource (tenant_id,resource_id,role_id,create_date)
SELECT NULL,110,r.id,SYSDATE() FROM role r WHERE EXISTS(SELECT 1 FROM role_resource rr2 WHERE rr2.role_id=r.id AND
rr2.resource_id IN(111,112,113,114,115,129) AND NOT EXISTS(SELECT 1 FROM role_resource rr3 WHERE  rr3.role_id=r.id and rr3.resource_id=110)
);


/* 将没有 后台管理 的角色 勾上 */
INSERT INTO role_resource (tenant_id,resource_id,role_id,create_date)
SELECT NULL,118,r.id,SYSDATE() FROM role r WHERE EXISTS(SELECT 1 FROM role_resource rr2 WHERE rr2.role_id=r.id AND
rr2.resource_id IN(1,4,87) AND NOT EXISTS(SELECT 1 FROM role_resource rr3 WHERE  rr3.role_id=r.id and rr3.resource_id=118)
);

	END IF;


UPDATE resource SET sequence=25 WHERE code='assets.fund' AND sequence=50 LIMIT 1;






IF NOT EXISTS (SELECT 1 FROM resource WHERE id=131) THEN

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('131', NULL, 'report.customer', 'WM', '99', '客户新增', '/report/customer', '1', '1', '0', '数据报表(APP)-->客户新增', '40', '-1', SYSDATE(), NULL, NULL, '0');

END IF;


IF NOT EXISTS (SELECT 1 FROM resource WHERE id=132) THEN

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('132', NULL, 'report.customer.get_department', 'WM', '131', '部门新增', '/report/customer/get_department', '0', '1', '0', '数据报表(APP)-->客户新增-->部门新增', '10', '-1', SYSDATE(), NULL, NULL, '0');

END IF;


IF NOT EXISTS (SELECT 1 FROM resource WHERE id=133) THEN

INSERT INTO `resource` (`id`, `tenant_id`, `code`, `system_code`, `parent_id`, `name`, `url`, `is_menu`, `is_enabled`, `is_deplay`, `description`, `sequence`, `create_user_id`, `create_date`, `update_user_id`, `update_date`, `is_delete`)
 VALUES ('133', NULL, 'report.customer.get_user_rank_page', 'WM', '131', '员工新增', '/report/customer/get_user_rank_page', '0', '1', '0', '数据报表(APP)-->客户新增-->员工新增', '20', '-1', SYSDATE(), NULL, NULL, '0');

END IF;



	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 131 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (131, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 132 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (132, 1);
	END IF;
	IF NOT EXISTS (select * from role_resource where role_id = 1 and resource_id = 133 and is_delete = 0) THEN
        INSERT INTO `role_resource` ( `resource_id`, `role_id`) VALUES (133, 1);
	END IF;



  	IF EXISTS (select * from resource where id = 116 AND code='assets.project.audit_history') THEN
       DELETE FROM resource WHERE id=116 LIMIT 1;
       DELETE FROM role_resource WHERE resource_id=116;
	END IF;


end;

call scm_sql_update();

DROP PROCEDURE if exists scm_sql_update;
//