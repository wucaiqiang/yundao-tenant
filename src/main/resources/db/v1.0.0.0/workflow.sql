delimiter //

drop procedure if exists workflow_sql_update;

create procedure workflow_sql_update()
begin

   CREATE TABLE  If Not Exists  `pro_def_task_action` (
	  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
	  `task_def_key` varchar(255) DEFAULT NULL COMMENT '任务节点key',
	  `pro_def_id` varchar(64) DEFAULT NULL COMMENT '流程定义id',
	  `action_value` int(11) DEFAULT NULL COMMENT '操作值',
	  `sequence` int(11) DEFAULT '1' COMMENT '排序，越小越靠前',
	  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
	  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
	  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新者id',
	  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
	  `is_delete` tinyint(2) DEFAULT '0' COMMENT '是否删除，0：否，1：是',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流程定义节点操作';
   
end;

call workflow_sql_update();

DROP PROCEDURE if exists workflow_sql_update;
//