package com.yundao.tenant.auto.all;

import com.yundao.core.utils.BooleanUtils;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * ibatis模板代码生成工具dao生成类
 * @author
 * 创建时间:2012-07-03
 */
public class CreateService {

	public List<String> colClassList;//类中字段名-类型
	public String className;//类名
	public String classPackageName;//类所在包名
	public String parentPackageName;//上层类名
	public String pk = "";//主键名
	public String dbpk = "";//数据库中主键名
	public String classNameMapper;
	public String classMapper;
	public String classNameModel;
	public String classNameModelExmaple;
	public String lowerClassName;
	public String classRsqDto;
	public String classNameService;
	public String classNameServiceImpl;
	public String addPackage;

	public CreateService(List<String> colClassList,String className,String classPackageName,String parentPackageName,String pk,String dbpk,String addPackage) {
		this.colClassList = colClassList;
		this.className = className;
		this.classPackageName = classPackageName;
		this.parentPackageName = parentPackageName;
		this.pk = pk;
		this.dbpk = dbpk;
		this.classNameModel = "Base" + className;
		this.classNameService = className + "Service";
		this.classNameServiceImpl = className + "ServiceImpl";
		this.classNameMapper = "Base" + className + "Mapper";
		this.classMapper = className + "Mapper";
		this.lowerClassName = Util.toLowerFrist(this.className);
		this.classNameModelExmaple = classNameModel + "Example";
		this.classRsqDto = className + "ReqDto";
		this.addPackage = addPackage;
	}
	
	public void createServiceJava(Util util) throws FileNotFoundException, UnsupportedEncodingException {
		String pack = BooleanUtils.isNotEmpty(addPackage)?addPackage+".":"";
		String urlPack = BooleanUtils.isNotEmpty(addPackage)?addPackage+"/":"";
		List<String> fileStrList = new ArrayList<String>();
		fileStrList.add("package " + classPackageName+".service."+pack+util.toLower(className)+";");
		fileStrList.add("");
		fileStrList.add("import " + classPackageName+".dto.AbstractBasePageDto;");
		fileStrList.add("import "+util.getUserPackageName()+".model.base." + addPackage +"."+classNameModel+";");
		fileStrList.add("import "+util.getUserPackageName()+".dto."+pack+util.toLower(className)+"."+classRsqDto+";");
		fileStrList.add("import com.yundao.core.code.Result;");
		fileStrList.add("import com.yundao.core.pagination.PaginationSupport;");
		fileStrList.add("");
		fileStrList.add("");
		fileStrList.add("public interface "+classNameService+"{");
		fileStrList.add("");
		fileStrList.add("");
		
		if(!pk.equals("")){
			fileStrList.add("    public Result<Integer> add("+classRsqDto+" reqDto) throws Exception;");
			fileStrList.add("");
			
//			fileStrList.add("    public Result<Integer> add"+className+"List(List<"+classNameModel+"> list) throws Exception;");
			fileStrList.add("");
			
			fileStrList.add("    public Result<Integer> update("+classRsqDto+" reqDto) throws Exception;");
			fileStrList.add("");
			
//			fileStrList.add("    public Result<Integer> update"+className+"List(List<"+classNameModel+"> list) throws Exception;");
			fileStrList.add("");
		}
		
		fileStrList.add("    public Result<Integer> delete(Long id) throws Exception;");
		fileStrList.add("");
		
//		fileStrList.add("    public Result<Integer> delete"+className+"ListByCond(List<"+classNameModel+"> list) throws Exception;");
		fileStrList.add("");
		
		if(!pk.equals("")){
			fileStrList.add("    public Result<"+classNameModel+"> get(Long id) throws Exception;");
			fileStrList.add("");
		}

		fileStrList.add("    public Result<PaginationSupport<"+classNameModel+">> getPage("+classRsqDto+" " + util.toLowerFrist(classRsqDto) + ", AbstractBasePageDto pageDto) throws Exception;");
		fileStrList.add("");
		
		fileStrList.add("}");
		util.writeFile(fileStrList, "service/"+ urlPack+util.toLower(className)+"/", classNameService+".java");
	}
	
	public void createServiceImplJava(Util util) throws FileNotFoundException, UnsupportedEncodingException {
		String pack = BooleanUtils.isNotEmpty(addPackage)?addPackage+".":"";
		String urlPack = BooleanUtils.isNotEmpty(addPackage)?addPackage+"/":"";
		List<String> fileStrList = new ArrayList<String>();
		fileStrList.add("package " + classPackageName+".service."+pack+util.toLower(className)+".impl;");
		fileStrList.add("");
		fileStrList.add("import java.util.List;");
		fileStrList.add("import java.util.Date;");
		fileStrList.add("import " + classPackageName+".mapper.base." + addPackage + ".Base"  +className + "Mapper;");
		fileStrList.add("import " + classPackageName+".mapper."+ addPackage + "."+util.toLower(className)+"." +className + "Mapper;");
		fileStrList.add("import " + classPackageName+".dto.AbstractBasePageDto;");
		fileStrList.add("import "+util.getUserPackageName()+".model.base."+ addPackage + "."+classNameModel+";");
		fileStrList.add("import "+util.getUserPackageName()+".service."+ addPackage + "."+util.toLower(className)+"."+classNameService+";");
        fileStrList.add("import "+util.getUserPackageName()+".dto."+pack+util.toLower(className)+"."+classRsqDto+";");
		fileStrList.add("import com.yundao.core.code.Result;");
		fileStrList.add("import com.yundao.core.pagination.PaginationSupport;");
		fileStrList.add("import com.yundao.core.constant.CommonConstant;");
		fileStrList.add("import " + classPackageName+".model.base."+ addPackage + "." +classNameModelExmaple + ";");
		fileStrList.add("import com.yundao.core.utils.Limit;");
		fileStrList.add("import com.yundao.core.service.AbstractService;");
		fileStrList.add("import org.apache.commons.lang3.StringUtils;");
		fileStrList.add("import org.springframework.stereotype.Service;");
        fileStrList.add("import org.springframework.beans.BeanUtils;");
		fileStrList.add("");
		fileStrList.add("import org.springframework.beans.factory.annotation.Autowired;");
		fileStrList.add("");
		fileStrList.add("@Service");
		fileStrList.add("public class "+classNameServiceImpl+" extends AbstractService implements "+classNameService+"{");
		fileStrList.add("");
		fileStrList.add("    @Autowired");
		fileStrList.add("    private "+classNameMapper+" "+util.toLowerFrist(classNameMapper)+";");
		fileStrList.add("");
		fileStrList.add("    @Autowired");
		fileStrList.add("    private "+classMapper+" "+util.toLowerFrist(classMapper)+";");
		fileStrList.add("");

		if(!pk.equals("")){
			fileStrList.add("    public Result<Integer> add("+classRsqDto+" reqDto) throws Exception{");
			fileStrList.add("        "+classNameModel+" model = new " + classNameModel + "();");
			fileStrList.add("        BeanUtils.copyProperties(reqDto,model);");
			fileStrList.add("        model.setCreateDate(new Date());");
			fileStrList.add("        model.setCreateUserId(super.getHeaderUserId());");
			fileStrList.add("        model.setId(null);");
			fileStrList.add("        int count = "+util.toLowerFrist(classNameMapper)+".insertSelective(model);");
			fileStrList.add("        return Result.newSuccessResult(count);");
			fileStrList.add("    }");
			fileStrList.add("");
			
//			fileStrList.add("    public Result<Integer> add"+className+"List(List<"+classNameModel+"> list) throws Exception{");
//			fileStrList.add("        log.begin(model);");
//			fileStrList.add("        int count = 0;");
//			fileStrList.add("        if (null != list) {");
//			fileStrList.add("            for (int i = 0; i < list.size(); i++) {");
//			fileStrList.add("                count += "+util.toLowerFrist(classNameMapper)+".add"+className+"(list.get(i));");
//			fileStrList.add("            }");
//			fileStrList.add("        log.info(\"执行影响行数:\" + count);");
//			fileStrList.add("        log.end();");
//			fileStrList.add("        return Result.newSuccessResult(count);");
//			fileStrList.add("        }");
//			fileStrList.add("    }");
//			fileStrList.add("");

			fileStrList.add("    public Result<Integer> update("+classRsqDto+" reqDto) throws Exception{");
			fileStrList.add("        "+classNameModel+" model = new " + classNameModel + "();");
			fileStrList.add("        BeanUtils.copyProperties(reqDto,model);");
			fileStrList.add("        model.setUpdateDate(new Date());");
			fileStrList.add("        model.setUpdateUserId(super.getHeaderUserId());");
			fileStrList.add("        int count = "+util.toLowerFrist(classNameMapper)+".updateByPrimaryKeySelective(model);");
			fileStrList.add("        return Result.newSuccessResult(count);");
			fileStrList.add("    }");
			fileStrList.add("");
			
//			fileStrList.add("    public Result<Integer> update"+className+"List(List<"+classNameModel+"> list) throws Exception{");
//			fileStrList.add("        log.begin(model);");
//			fileStrList.add("        int count = 0;");
//			fileStrList.add("        if (null != list) {");
//			fileStrList.add("           for (int i = 0; i < list.size(); i++) {");
//			fileStrList.add("                count += update"+className+"ByPK(list.get(i));");
//			fileStrList.add("            }");
//			fileStrList.add("        log.info(\"执行影响行数:\" + count);");
//			fileStrList.add("        log.end();");
//			fileStrList.add("        return Result.newSuccessResult(count);");
//			fileStrList.add("        }");
//			fileStrList.add("    }");
//			fileStrList.add("");
		}
		
		fileStrList.add("    public Result<Integer> delete(Long id) throws Exception{");
		fileStrList.add("        " + classNameModel + " " + lowerClassName + " = new " + classNameModel + "();");
		fileStrList.add("        " + lowerClassName + ".setId(id);");
		fileStrList.add("        "+lowerClassName+".setUpdateDate(new Date());");
		fileStrList.add("        "+lowerClassName+".setUpdateUserId(super.getHeaderUserId());");
		fileStrList.add("        int count = "+util.toLowerFrist(classNameMapper)+".updateByPrimaryKeySelective(" + lowerClassName + ");");
		fileStrList.add("        return Result.newSuccessResult(count);");
		fileStrList.add("    }");
		fileStrList.add("");
		
//		fileStrList.add("    public Result<Integer> delete"+className+"ListByCond(List<"+classNameModel+"> list) throws Exception{");
//		fileStrList.add("        log.begin(model);");
//		fileStrList.add("        int count = 0;");
//		fileStrList.add("        if (null != list) {");
//		fileStrList.add("           for (int i = 0; i < list.size(); i++) {");
//		fileStrList.add("                count += delete"+className+"ByCond(list.get(i));");
//		fileStrList.add("            }");
//		fileStrList.add("        log.info(\"执行影响行数:\" + count);");
//		fileStrList.add("        log.end();");
//		fileStrList.add("        return Result.newSuccessResult(count);");
//		fileStrList.add("        }");
//		fileStrList.add("    }");
//		fileStrList.add("");
		
		if(!pk.equals("")){
			fileStrList.add("    public Result<"+classNameModel+"> get(Long id) throws Exception{");
			fileStrList.add("       " + classNameModel + " model = " + util.toLowerFrist(classNameMapper)+".selectByPrimaryKey(id);");
			fileStrList.add("       return Result.newSuccessResult(model);");
			fileStrList.add("    }");
			fileStrList.add("");
		}
		
//		fileStrList.add("    public List<" + classNameModel + "> get"+className+"ListByCond("+classNameModel+" " + lowerClassName + ") throws Exception{");
//		fileStrList.add("        List<"+classNameModel+"> list="+util.toLowerFrist(classNameMapper)+".get"+className+"ListByCond(" + lowerClassName + ");");
//		fileStrList.add("        return list;");
//		fileStrList.add("    }");
//		fileStrList.add("");
		
		fileStrList.add("    public Result<PaginationSupport<"+classNameModel+">> getPage("+classRsqDto+" " + util.toLowerFrist(classRsqDto) + ", AbstractBasePageDto pageDto) throws Exception{");
		fileStrList.add("		"+classNameModelExmaple+" "+util.toLowerFrist(classNameModelExmaple)+" = new "+classNameModelExmaple+"().setLimit(Limit.buildLimit(pageDto.getCurrentPage(), pageDto.getPageSize()));");

		fileStrList.add("		"+classNameModelExmaple+".Criteria criteria = "+util.toLowerFrist(classNameModelExmaple)+".createCriteria();");
		
		fileStrList.add("		String orderByClause=\"create_date desc\";");
		fileStrList.add("		if(StringUtils.isNotBlank(pageDto.getOrderColumn())){");
		fileStrList.add("		  StringBuilder orderBuider=new StringBuilder();");
		fileStrList.add("		  orderBuider.append(pageDto.getOrderColumn()).append(\" \");");
		fileStrList.add("		  if(StringUtils.isNotBlank(pageDto.getSort())){");
		fileStrList.add("			orderBuider.append(pageDto.getSort());");
		fileStrList.add("		  }else{");
		fileStrList.add("			orderBuider.append(\"desc\");");
		fileStrList.add("		  }");
		fileStrList.add("		  orderByClause=orderBuider.toString();");
		fileStrList.add("		}");
		
		fileStrList.add("		"+util.toLowerFrist(classNameModelExmaple)+".setOrderByClause(orderByClause);");
		fileStrList.add("		List<"+classNameModel+"> list = "+util.toLowerFrist(classNameMapper)+".selectByExample("+util.toLowerFrist(classNameModelExmaple)+");");
		fileStrList.add("		int totalCount = "+util.toLowerFrist(classNameMapper)+".countByExample("+util.toLowerFrist(classNameModelExmaple)+");");
		fileStrList.add("		PaginationSupport<"+classNameModel+"> result = pageDto.getPaginationSupport();");
		fileStrList.add("		result.setDatas(list);");
		fileStrList.add("		result.setTotalCount(totalCount);");
		fileStrList.add("		return Result.newSuccessResult(result);");
		fileStrList.add("    }");
		fileStrList.add("");
		
		fileStrList.add("}");
		util.writeFile(fileStrList, "service/"+urlPack+util.toLower(className)+"/impl/", classNameServiceImpl+".java");
	}
}
