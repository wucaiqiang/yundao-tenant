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
public class CreateModelSQL {

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

	public CreateModelSQL(List<String> colClassList, String className, String classPackageName, String parentPackageName, String pk, String dbpk, String addPackage) {
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
			String resultMap = className+"Result";
			
			String parameterType = classPackageName+".model.base." +className + "Model";

			String extend = classPackageName+".mapper.base." + className + "ModelMapper.BaseResultMap";
			List<String> fileStrList = new ArrayList<String>();
			fileStrList.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			fileStrList.add("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\" >");
			fileStrList.add("");
			fileStrList.add("<mapper namespace=\""+classPackageName+".mapper."+util.toLower(className)+"."+className+"Mapper\">");
			fileStrList.add("");
			fileStrList.add("    <resultMap id=\""+resultMap+"\" type=\""+parameterType+"\" extends=\""+extend+"\"> ");
			fileStrList.add("    </resultMap>");
			fileStrList.add("</mapper>");
			util.writeXmlFile(fileStrList, "config/mybatis/"+util.toLower(className)+"/", className+"Mapper.xml");
	}
}
