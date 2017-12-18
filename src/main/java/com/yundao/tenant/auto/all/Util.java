package com.yundao.tenant.auto.all;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 * ibatis模板代码生成公用工具类
 * @author 王辉
 * 创建时间:2012-07-03
 */
public class Util {
	private String driver = null;
	private String url = null;
	private String user= null;
	private String passwd = null;
	private  String tableName = null;//表名,分隔符只能用"_"
	private  List<String> coltablelist;//表中字段名--类型,分隔符只能用"_"
	private  String userPackageName = null;//包名,以"."隔开
	private  String pk = "";
	
	public Util(String driver,String url,String user,String passwd,String tableName,String userPackageName) {
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.passwd = passwd;
		this.tableName = tableName;
		this.userPackageName = userPackageName;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 将列名中下划线去掉
	 */
	public List<String> getColumn() throws Exception {
		List<String> l = new ArrayList<String>();
		for (int i = 0; i < getColtablelist().size(); i++) {
			//对每个字段小写化,去下划线
			String temp =  getColtablelist().get(i);
//			l.add(temp.replace("_","").toLowerCase());
			l.add(convetColumn(temp));
		}
		return l;
	}
	
	public String convetColumn(String tempName) {
		tempName = tempName.toLowerCase();
		String[] temp = tempName.split("_");
		tempName = "";
		tempName = temp[0];
		for (int i = 1; i < temp.length; i++) {
			tempName += temp[i].substring(0, 1).toUpperCase()
					+ temp[i].substring(1);
		}
		return tempName;
	}
	
	/**
	 * 将表名转换成类名
	 */
	public String getClassName() {
		String tempName = tableName;
		//全转为小写
		//判断表名中是否有下划线
		//如果有,把每个下划线的首字母大写,去掉下划线
		tempName = tempName.toLowerCase();
		int index = tempName.indexOf('_');
		if(-1 == index){
			tempName = tempName.substring(0,1).toUpperCase()+tempName.substring(1);
		}else{
			String[] temp = tempName.split("_");
			tempName = "";
			for (int i = 0; i < temp.length; i++) {
				tempName += temp[i].substring(0,1).toUpperCase()+temp[i].substring(1);
			}
		}
		return tempName;
	}
	
	/**
	 * 获取列名
	 */
	public List<String> getTableColumn() throws Exception{
		List<String> list = new ArrayList<String>();
		Connection conn = DriverManager.getConnection(url, user, passwd);
		String sql = "select * from "+tableName+" where 1<>1";
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		ResultSetMetaData rsm = rs.getMetaData();
		int columnCount = rsm.getColumnCount();
		for (int i = 1; i <= columnCount; i++) {
			String className = rsm.getColumnClassName(i);
			String colName = rsm.getColumnName(i);
			if(null == className){
				list.add(colName.toLowerCase()+"--String");
			}else if(className.equalsIgnoreCase("java.lang.Long")
					||className.equalsIgnoreCase("java.math.BigInteger")
					||className.equalsIgnoreCase("java.math.BigDecimal")){
				list.add(colName.toLowerCase()+"--Long");
			}else if(className.equalsIgnoreCase("java.lang.Integer")){
				list.add(colName.toLowerCase()+"--Integer");
			}else if(className.equalsIgnoreCase("java.lang.Short")){
				list.add(colName.toLowerCase()+"--Short");
			}else if(className.equalsIgnoreCase("byte[]")){
				list.add(colName.toLowerCase()+"--byte[]");
			}else if(className.equalsIgnoreCase("byte")){
				list.add(colName.toLowerCase()+"--byte");
			}else if(className.equalsIgnoreCase("java.sql.Timestamp")){
				list.add(colName.toLowerCase()+"--Date");
			}else{
				list.add(colName.toLowerCase()+"--String");
			}
		}
		rs.close();
		stm.close();
		conn.close();
		return list;
	}

	public Map<String,String> getColumnComment() throws Exception{
		Map<String,String> result = new HashMap<String,String>();
		Connection conn = DriverManager.getConnection(url, user, passwd);
		String sql = "show full columns from "+tableName;
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		while (rs.next()){
			String name = rs.getString(1);
			name = convetColumn(name);
			String value = rs.getString(9);
			result.put(name,value);
		}
		rs.close();
		stm.close();
		conn.close();
		return result;
	}

	public String getTableComment() throws Exception{
		Map<String,String> result = new HashMap<String,String>();
		Connection conn = DriverManager.getConnection(url, user, passwd);
		String sql = "show table status WHERE NAME='"+tableName + "'";
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		String tableComment = "";
		while (rs.next()){
			tableComment = rs.getString(18);
		}
		rs.close();
		stm.close();
		conn.close();
		return tableComment;
	}
	
	/**
	 * 通过用户包名,获取文件夹路径
	 */
	public String getPathByPackage(){
		String result = "";
		String[] temps = userPackageName.split("\\.");
		for (int i = 0; i < temps.length; i++) {
			result += temps[i]+"/";
		}
		return result;
	}
	
	/**
	 * @param list 源代码数据
	 * @param filedir 文件夹路径 以/结束,如 model/sqlmap/
	 * @param fileName 源代码文件名
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException 
	 */
	public void writeFile(List<String> list,String filedir,String fileName) throws FileNotFoundException, UnsupportedEncodingException{
		String dir = Util.class.getResource("/").getPath() + "../../src/main/java/"+getPathByPackage();
		String filedir1 = filedir == null?"":filedir;
		new File(dir).mkdirs();
		new File(dir+filedir1).mkdirs();
		PrintWriter pw = new PrintWriter(new File(dir+filedir1+fileName),"utf8");
		for (int i = 0; i < list.size(); i++) {
			pw.println(list.get(i));
		}
		pw.flush();
		pw.close();
	}
	
	/**
	 * @param list 源代码数据
	 * @param filedir 文件夹路径 以/结束,如 model/sqlmap/
	 * @param fileName 源代码文件名
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException 
	 */
	public void writeXmlFile(List<String> list,String filedir,String fileName) throws FileNotFoundException, UnsupportedEncodingException{
		String dir = Util.class.getResource("/").getPath() + "../../src/main/resources/";
		String filedir1 = filedir == null?"":filedir;
		new File(dir).mkdirs();
		new File(dir+filedir1).mkdirs();
		PrintWriter pw = new PrintWriter(new File(dir+filedir1+fileName),"utf8");
		for (int i = 0; i < list.size(); i++) {
			pw.println(list.get(i));
		}
		pw.flush();
		pw.close();
	}
	/**
	 * 获取表中主键
	 */
	public String getPK() throws SQLException{
		if (pk == null || pk.equals("")) {
			Connection conn = DriverManager.getConnection(url, user, passwd);
			ResultSet rrs = conn.getMetaData().getPrimaryKeys(conn.getCatalog(),null,tableName.toUpperCase());
			List<String> list = new ArrayList<String>();
			while (rrs.next()) {
			    list.add(rrs.getString(4));
			}
			if(list.size()>1){
				Collections.sort(list,new MyListSort());
				pk = list.get(0);
			}else if(list.size()>0){
				pk = list.get(0);
			}
			rrs.close();
		    conn.close();
		}else{
			pk = "";
		}
		return pk;
	}
	
	class MyListSort implements Comparator{
		public int compare(Object o1, Object o2) {
			String s1 = (String)o1;
			String s2 = (String)o2;
		    Integer s11 = s1.length();
		    Integer s22 = s2.length();
			return s11.compareTo(s22);
		}
	}
	
	/**
	 * 将字符串的首字母大写
	 */
	public String formatStr(String str){
		return str.substring(0,1).toUpperCase()+str.substring(1);
	}
	
	/**
	 * 将字符串的首字母小写
	 */
	public String formatStrToLowCase(String str){
		return str.substring(0,1).toLowerCase()+str.substring(1);
	}
	
	/**
	 * 获取列名
	 */
	public List<String> getColtablelist() {
		if(coltablelist == null){
			try {
				coltablelist = getTableColumn();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return coltablelist;
	}
	
	public String getUserPackageName() {
		return userPackageName;
	}
	public String getTableName() {
		return tableName;
	}

	public String getDriver() {
		return driver;
	}
	
	public String getPackageName() {
		return userPackageName;
	}
	
	public String getParentPackageName(){
		return userPackageName.substring(0,userPackageName.lastIndexOf("."));
	}
	
	public static String toLowerFrist(String str){
		str = str.substring(0, 1).toLowerCase() + str.substring(1, str.length());
		return str;
	}
	public static String toLower(String str){
		return str.toLowerCase();
	}
	public String toUpperCaseFrist(String str){
		str = str.substring(0, 1).toUpperCase() + str.substring(1, str.length());
		return str;
	}
}
