package com.yundao.tenant.auto.all;

import java.util.List;

/**
 * mybatis模板代码生成工具入口调用类
 * @author
 * 创建时间:2012-07-03
 */
public class Auto {
	
	public List<String> colClassList;//类中字段名--类型
	public String className;//类名
	public String classPackageName;//类所在包名
	public String parentPackageName;//上层类名
	public String pk = "";//主键名
	public String dbpk = "";//数据库中主键名
	public String addPackage = "";

	public void create(String driver,String url,String user,String passwd,String tableName,String userPackageName,String addPackage) throws Exception{
		Util util = new Util(driver,url,user,passwd,tableName,userPackageName);
		classPackageName = util.getPackageName();//包名,需要在写文件时完成.如 com.commsoft
		parentPackageName = util.getParentPackageName();
		className = util.getClassName();//类名
		colClassList = util.getColumn();//类中字段名
		dbpk = util.getPK().toLowerCase();
		pk = util.convetColumn(dbpk);//dbpk.replace("_","");//主键名
		this.addPackage = addPackage;
		
//		CreateModel model = new CreateModel(colClassList,className,classPackageName,parentPackageName,pk,dbpk,addPackage);
		CreateModelSQL model = new CreateModelSQL(colClassList,className,classPackageName,parentPackageName,pk,dbpk,addPackage);
		model.createModelJava(util);//创建model实体类
		
//		model.createMysqlSqlmapXML(util);//创建mysql sqlmap配置文件
//
//		CreateDao dao = new CreateDao(colClassList,className,classPackageName,parentPackageName,pk,dbpk,addPackage);
		/*CreateDaoSQL dao = new CreateDaoSQL(colClassList,className,classPackageName,parentPackageName,pk,dbpk,addPackage);
		dao.createIDAOJava(util);//创建DAO接口类
*/		
		CreateService service = new CreateService(colClassList, className, classPackageName, parentPackageName, pk, dbpk,addPackage);
		service.createServiceJava(util);//创建service接口类
		service.createServiceImplJava(util);//创建service实现类
//
//
		CreateController controller = new CreateController(colClassList, className, classPackageName, parentPackageName, pk, dbpk,addPackage);
		controller.createControllerJava(util);
	}
}
