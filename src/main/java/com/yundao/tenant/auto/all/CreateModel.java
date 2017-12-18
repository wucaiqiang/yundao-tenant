package com.yundao.tenant.auto.all;

import com.yundao.core.utils.BooleanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * MyBatis模板代码生成工具model生成类
 * @author 
 * 创建时间:2012-07-03
 */
public class CreateModel {

	public List<String> colClassList;//类中字段名--类型
	public String className;//类名
	public String classNameModel;//类所在包名
	public String classPackageName;//类所在包名
	public String parentPackageName;//上层类名
	public String classNameMapper;//上层类名
	public String pk = "";//主键名
	public String dbpk = "";//数据库中主键名
	public String addPackage = "";//数据库中主键名

	static List<String> continiuStr = new ArrayList<String>();
	static {
		continiuStr.add("createUserId");
		continiuStr.add("createDate");
		continiuStr.add("updateUserId");
		continiuStr.add("updateDate");
		continiuStr.add("isEnabled");
		continiuStr.add("isDelete");
		continiuStr.add("tenantId");
	}
	
	public CreateModel(List<String> colClassList,String className,String classPackageName,String parentPackageName,String pk,String dbpk,String addPackage) {
		this.colClassList = colClassList;
		this.className = className;
		this.classPackageName = classPackageName;
		this.parentPackageName = parentPackageName;
		this.classNameModel = "Base" + className;
		this.classNameMapper = "Base" + className + "Mapper";
		this.addPackage = addPackage;
		this.pk = pk;
		this.dbpk = dbpk;
	}
	
	/**
	 * 创建实体类
	 * @param util 
	 * @throws Exception
	 */
	public void createModelJava(Util util) throws Exception{
		String pack = BooleanUtils.isNotEmpty(addPackage)?addPackage+".":"";
		String urlPack = BooleanUtils.isNotEmpty(addPackage)?addPackage+"/":"";
		List<String> fileStrList = new ArrayList<String>();
		fileStrList.add("");
		fileStrList.add("package "+classPackageName+".dto."+ pack+className.toLowerCase()+";");
		fileStrList.add("");
		fileStrList.add("import java.util.Date;");
		fileStrList.add("import com.yundao.core.code.config.CommonCode;");
		fileStrList.add("import com.yundao.core.validator.group.Update;");
		fileStrList.add("import io.swagger.annotations.ApiModelProperty;");
		fileStrList.add("import com.yundao.core.validator.number.Number;");
		fileStrList.add("");
//		fileStrList.add( "public class "+className+"Model extends AbstractModel{");
		fileStrList.add( "public class "+className+"ReqDto{");
		fileStrList.add("    private static final long serialVersionUID = 1L;");
		Map<String,String> columnComment = util.getColumnComment();
		//获取字段说明
		for (String s:colClassList) {
			String[] ss = s.split("--");
			if(continiuStr.indexOf(ss[0]) > -1){
				continue;
			}
//			if(columnComment.containsKey(ss[0])){
//				fileStrList.add("    /**");
//				fileStrList.add("     * " + columnComment.get(ss[0]));
//				fileStrList.add("     */");
//			}
			if("id".equals(ss[0])){
				fileStrList.add("    @ApiModelProperty(value = \"新增不需要传\")");
				fileStrList.add("    @Number(isBlank = false, message = \"{\" + CommonCode.COMMON_1079+ \"}\", groups = {Update.class})");
			}else {
				fileStrList.add("    @ApiModelProperty(value = \""+columnComment.get(ss[0])+"\")");
			}
			if(ss[1].equalsIgnoreCase("long")){
				fileStrList.add("    private Long "+ss[0]+";");
			}else if(ss[1].equalsIgnoreCase("integer")){
				fileStrList.add("    private Integer "+ss[0]+";");
			}else if(ss[1].equalsIgnoreCase("short")){
				fileStrList.add("    private Short "+ss[0]+";");
			}else if(ss[1].equalsIgnoreCase("double")){
				fileStrList.add("    private Double "+ss[0]+";");
			}else if(ss[1].equalsIgnoreCase("byte")){
				fileStrList.add("    private Byte "+ss[0]+";");
			}else if(ss[1].equalsIgnoreCase("byte[]")){
				fileStrList.add("    private Byte[] "+ss[0]+";");
			}else if(ss[1].equalsIgnoreCase("Date")){
				fileStrList.add("    private Date "+ss[0]+";");
			}else{
//				fileStrList.add("    @Length(min = 1,max = 32,message = \"{\" +  + \"}\"))");
				fileStrList.add("    private String "+ss[0]+";");
			}
			fileStrList.add("");
		}
		fileStrList.add("");
		//get,set方法
		for (String s:colClassList) {
			String[] ss = s.split("--");
			if(continiuStr.indexOf(ss[0]) > -1){
				continue;
			}
			if(ss[1].equalsIgnoreCase("long")){
				fileStrList.add("    public Long get"+util.formatStr(ss[0])+" (){");
				fileStrList.add("        return "+ss[0]+";");
				fileStrList.add("    }");
				fileStrList.add("");
				fileStrList.add("    public void set"+util.formatStr(ss[0])+" (Long "+ss[0]+"){");
				fileStrList.add("        this."+ss[0]+" = "+ss[0]+";");
				fileStrList.add("    }");
				fileStrList.add("");
			}else if(ss[1].equalsIgnoreCase("integer")){
				fileStrList.add("    public Integer get"+util.formatStr(ss[0])+" (){");
				fileStrList.add("        return "+ss[0]+";");
				fileStrList.add("    }");
				fileStrList.add("");
				fileStrList.add("    public void set"+util.formatStr(ss[0])+" (Integer "+ss[0]+"){");
				fileStrList.add("        this."+ss[0]+" = "+ss[0]+";");
				fileStrList.add("    }");
				fileStrList.add("");
			}else if(ss[1].equalsIgnoreCase("short")){
				fileStrList.add("    public Short get"+util.formatStr(ss[0])+" (){");
				fileStrList.add("        return "+ss[0]+";");
				fileStrList.add("    }");
				fileStrList.add("");
				fileStrList.add("    public void set"+util.formatStr(ss[0])+" (Short "+ss[0]+"){");
				fileStrList.add("        this."+ss[0]+" = "+ss[0]+";");
				fileStrList.add("    }");
				fileStrList.add("");
			}else if(ss[1].equalsIgnoreCase("double")){
				fileStrList.add("    public Double get"+util.formatStr(ss[0])+" (){");
				fileStrList.add("        return "+ss[0]+";");
				fileStrList.add("    }");
				fileStrList.add("");
				fileStrList.add("    public void set"+util.formatStr(ss[0])+" (Double "+ss[0]+"){");
				fileStrList.add("        this."+ss[0]+" = "+ss[0]+";");
				fileStrList.add("    }");
				fileStrList.add("");
			}else if(ss[1].equalsIgnoreCase("byte")){
				fileStrList.add("    public Byte get"+util.formatStr(ss[0])+" (){");
				fileStrList.add("        return "+ss[0]+";");
				fileStrList.add("    }");
				fileStrList.add("");
				fileStrList.add("    public void set"+util.formatStr(ss[0])+" (Byte "+ss[0]+"){");
				fileStrList.add("        this."+ss[0]+" = "+ss[0]+";");
				fileStrList.add("    }");
				fileStrList.add("");
			}else if(ss[1].equalsIgnoreCase("Byte[]")){
				fileStrList.add("    public Byte[] get"+util.formatStr(ss[0])+" (){");
				fileStrList.add("        return "+ss[0]+";");
				fileStrList.add("    }");
				fileStrList.add("");
				fileStrList.add("    public void set"+util.formatStr(ss[0])+" (Byte[] "+ss[0]+"){");
				fileStrList.add("        this."+ss[0]+" = "+ss[0]+";");
				fileStrList.add("    }");
				fileStrList.add("");
			}else if(ss[1].equalsIgnoreCase("Date")){
				fileStrList.add("    public Date get"+util.formatStr(ss[0])+" (){");
				fileStrList.add("        return "+ss[0]+";");
				fileStrList.add("    }");
				fileStrList.add("");
				fileStrList.add("    public void set"+util.formatStr(ss[0])+" (Date "+ss[0]+"){");
				fileStrList.add("        this."+ss[0]+" = "+ss[0]+";");
				fileStrList.add("    }");
				fileStrList.add("");
			}else{
				fileStrList.add("    public String get"+util.formatStr(ss[0])+" (){");
				fileStrList.add("        return "+ss[0]+";");
				fileStrList.add("    }");
				fileStrList.add("");
				fileStrList.add("    public void set"+util.formatStr(ss[0])+" (String "+ss[0]+"){");
				fileStrList.add("        this."+ss[0]+" = "+ss[0]+";");
				fileStrList.add("    }");
				fileStrList.add("");
			}
		}
		fileStrList.add("}");
		util.writeFile(fileStrList, "dto/"+urlPack+util.toLower(className)+"/", className+"ReqDto.java");
	}
	
	
	public void createMysqlSqlmapXML(Util util) throws Exception {
		String insert = "add"+className;
		String updateByPK = "update"+className+"ByPK";
		String deleteByPK = "delete"+className+"ByPK";
		String getByPK = "get"+className+"ByPK";
		String getByCond = "get"+className+"ListByCond";
		String queryPage = "queryPageInfo";
		String queryCount = "queryPageCount";
		String pack = BooleanUtils.isNotEmpty(addPackage)?addPackage+".":"";
		String urlPack = BooleanUtils.isNotEmpty(addPackage)?addPackage+"/":"";

		
		String resultMap = className+"Result";
		
		String where = className+"_Where_Clause";
		
		String parameterType = classPackageName+".model.base." + pack +classNameModel;

		String extend = classPackageName+".mapper.base." + pack + classNameMapper + ".BaseResultMap";
		
		List<String> fileStrList = new ArrayList<String>();
		fileStrList.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		fileStrList.add("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\" >");
		fileStrList.add("");
		fileStrList.add("<mapper namespace=\""+classPackageName+".mapper."+pack+util.toLower(className)+"."+className+"Mapper\">");
		fileStrList.add("");
		fileStrList.add("    <resultMap id=\""+resultMap+"\" type=\""+parameterType+"\" extends=\""+extend+"\"> ");
		List<String> coltablelist = util.getColtablelist();
//		for (int i=0;i<colClassList.size();i++) {
//			String s1 = colClassList.get(i);
//			String[] ss1 = s1.split("--");
//			String s2 = coltablelist.get(i);
//			String[] ss2 = s2.split("--");
//			fileStrList.add("        <result column=\""+ss2[0]+"\" property=\""+ss1[0]+"\" />");
//		}
		fileStrList.add("    </resultMap>");
		fileStrList.add("");
		//where条件
		fileStrList.add("    <sql id=\""+where+"\">");
		fileStrList.add("        is_delete != 1");
		for (int i = 0; i < colClassList.size(); i++) {
			String s1 = colClassList.get(i);
			String[] ss1 = s1.split("--");
			String s2 = coltablelist.get(i);
			String[] ss2 = s2.split("--");
			if("is_delete".equals(ss2[0]))continue;
			if(ss1[1].equalsIgnoreCase("long") || ss1[1].equalsIgnoreCase("integer") || ss1[1].equalsIgnoreCase("Date")
					|| ss1[1].equalsIgnoreCase("double") || ss1[1].equalsIgnoreCase("byte") || ss1[1].equalsIgnoreCase("short")){
				fileStrList.add("        <if test=\""+ss1[0]+"!=null\">");
			}else{
				fileStrList.add("        <if test=\""+ss1[0]+"!=null and ''!="+ss1[0]+"\">");
			}
			fileStrList.add("            AND "+ss2[0]+" = #{"+ss1[0]+"}");
			fileStrList.add("        </if>");
		}
		fileStrList.add("    </sql>");
		fileStrList.add("");
//
//		//add
//		if(!pk.equals("")){
//			fileStrList.add("    <add id=\""+add+"\" parameterType=\""+parameterType+"\">");
//			fileStrList.add("        add into "+util.getTableName()+" ( "+dbpk+" ");
//			for (int i = 0; i < colClassList.size(); i++) {
//				String temp = colClassList.get(i);
//				String[] ss1 = temp.split("--");
//				String s2 = coltablelist.get(i);
//				String[] ss2 = s2.split("--");
//				if("is_delete".equals(ss2[0]))continue;
//				if(!pk.equals(ss1[0])){
//					if(ss1[1].equalsIgnoreCase("long") || ss1[1].equalsIgnoreCase("integer") || ss1[1].equalsIgnoreCase("Date")
//							|| ss1[1].equalsIgnoreCase("double") || ss1[1].equalsIgnoreCase("byte") || ss1[1].equalsIgnoreCase("short")){
//						fileStrList.add("            <if test=\""+ss1[0]+"!=null\">");
//					}else{
//						fileStrList.add("            <if test=\""+ss1[0]+"!=null and ''!="+ss1[0]+"\">");
//					}
//					fileStrList.add("                ,"+ss2[0]);
//					fileStrList.add("            </if>");
//				}
//			}
//			fileStrList.add("            ,is_delete");
//			fileStrList.add("        )values( #{"+pk+"}");
//			for (int i = 0; i < colClassList.size(); i++) {
//				String temp = colClassList.get(i);
//				String[] ss1 = temp.split("--");
//				if("isDelete".equals(ss1[0]))continue;
//				if(!pk.equals(ss1[0])){
//					if(ss1[1].equalsIgnoreCase("long") || ss1[1].equalsIgnoreCase("integer") || ss1[1].equalsIgnoreCase("Date")
//							|| ss1[1].equalsIgnoreCase("double") || ss1[1].equalsIgnoreCase("byte") || ss1[1].equalsIgnoreCase("short")){
//						fileStrList.add("            <if test=\""+ss1[0]+"!=null\">");
//					}else{
//						fileStrList.add("            <if test=\""+ss1[0]+"!=null and ''!="+ss1[0]+"\">");
//					}
//					fileStrList.add("                ,#{"+ss1[0]+"}");
//					fileStrList.add("            </if>");
//				}
//			}
//			fileStrList.add("            ,0");
//			fileStrList.add("        )");
//			fileStrList.add("    </add>");
//			fileStrList.add("");
//		}
//
//		//update By pk
//		if(!pk.equals("")){
//			fileStrList.add("    <update id=\""+updateByPK+"\" parameterType=\""+parameterType+"\">");
//			fileStrList.add("        update "+util.getTableName()+" set "+dbpk+" = #{"+pk+"}");
//			for (int i = 0; i < colClassList.size(); i++) {
//				String temp = colClassList.get(i);
//				String[] ss1 = temp.split("--");
//				String s2 = coltablelist.get(i);
//				String[] ss2 = s2.split("--");
//				if("is_delete".equals(ss2[0]))continue;
//				if(!pk.equals(ss1[0])){
//					if(ss1[1].equalsIgnoreCase("long") || ss1[1].equalsIgnoreCase("integer") || ss1[1].equalsIgnoreCase("Date")
//							|| ss1[1].equalsIgnoreCase("double") || ss1[1].equalsIgnoreCase("byte") || ss1[1].equalsIgnoreCase("short")){
//						fileStrList.add("            <if test=\""+ss1[0]+"!=null\">");
//					}else{
//						fileStrList.add("            <if test=\""+ss1[0]+"!=null and ''!="+ss1[0]+"\">");
//					}
//					fileStrList.add("                ,"+ss2[0]+" = #{"+ss1[0]+"}");
//					fileStrList.add("            </if>");
//				}
//			}
//			fileStrList.add("        where "+dbpk+" = #{"+pk+"}");
//			fileStrList.add("    </update>");
//			fileStrList.add("");
//		}
//
//		//delete by cond
//		fileStrList.add("    <update id=\""+deleteByPK+"\" parameterType=\""+parameterType+"\">");
//		fileStrList.add("        update "+util.getTableName()+" set is_delete = 1");
//		fileStrList.add("        where "+dbpk+" = #{"+pk+"}");
////		fileStrList.add("        <where><include refid=\""+where+"\" /></where>");
//		fileStrList.add("    </update>");
//		fileStrList.add("");
//
//		String temp1 = "";
//		for (int i = 0; i < util.getColtablelist().size(); i++) {
//			temp1 += coltablelist.get(i).split("--")[0]+",";
//		}
//		temp1 = temp1.substring(0,temp1.length()-1);
//
//		//getBy pk
//		if(!pk.equals("")){
//			fileStrList.add("    <select id=\""+getByPK+"\" parameterType=\""+parameterType+"\" resultMap=\""+resultMap+"\">");
//			fileStrList.add("        select "+temp1+" from "+util.getTableName()+" where "+dbpk+" = #{"+pk+"} and is_delete != 1");
//			fileStrList.add("    </select>");
//			fileStrList.add("");
//		}
//
//		//getBy cond
//		fileStrList.add("    <select id=\""+getByCond+"\" parameterType=\""+parameterType+"\" resultMap=\""+resultMap+"\">");
//		fileStrList.add("        select "+temp1+" from "+util.getTableName());
//		fileStrList.add("    	<where><include refid=\""+where+"\" /></where>");
////		fileStrList.add("		<dynamic prepend=\"order by\">");
////		fileStrList.add("       <if test=\"order!=null and ''!=order\">");
////		fileStrList.add("			order by $order$");
////		fileStrList.add("       </if>");
////		fileStrList.add("		</dynamic>");
//		fileStrList.add("    </select>");
//		fileStrList.add("");
//
//		//query page
//		fileStrList.add("    <select id=\""+queryPage+"\" parameterType=\""+parameterType+"\" resultMap=\""+resultMap+"\">");
//		fileStrList.add("        select "+temp1+" from "+util.getTableName());
//		fileStrList.add("    	<where><include refid=\""+where+"\" /></where>");
////		fileStrList.add("       <if test=\"order!=null and ''!=order\">");
////		fileStrList.add("			order by ${order}");
////		fileStrList.add("       </if>");
//		fileStrList.add("			limit #{offset},#{pageSize}");
//		fileStrList.add("    </select>");
//		fileStrList.add("");
//
//		//query count
//		fileStrList.add("    <select id=\""+queryCount+"\" parameterType=\""+parameterType+"\" resultType=\"java.lang.Integer\">");
//		fileStrList.add("        select count(*) from "+util.getTableName());
//		fileStrList.add("    	<where><include refid=\""+where+"\" /></where>");
//		fileStrList.add("    </select>");
//		fileStrList.add("");
		
		fileStrList.add("</mapper>");
		
		util.writeXmlFile(fileStrList, "config/mybatis/"+ urlPack+util.toLower(className)+"/", className+"Mapper.xml");
	}
}
