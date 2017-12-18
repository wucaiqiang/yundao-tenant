package com.yundao.tenant.auto.all;

import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.util.CamelUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * myBatis模板代码生成工具dao生成类
 * @author 
 * 创建时间:2012-07-03
 */
public class CreateController {

	public List<String> colClassList;//类中字段名-类型
	public String className;//类名
	public String classPackageName;//类所在包名
	public String parentPackageName;//上层类名
	public String pk = "";//主键名
	public String dbpk = "";//数据库中主键名
	public String classNameMapper;
	public String classNameModel;
	public String classRsqDto;
	public String lowerClassName;
	public String classNameService;
	public String classNameController;
	public String tableComment;
	public String addPackage;

	public CreateController(List<String> colClassList,String className,String classPackageName,String parentPackageName,String pk,String dbpk,String addPackage) {
		this.colClassList = colClassList;
		this.className = className;
		this.classPackageName = classPackageName;
		this.parentPackageName = parentPackageName;
		this.pk = pk;
		this.dbpk = dbpk;
		this.classNameModel = "Base" + className;
		this.classNameService = className + "Service";
		this.classNameController = className + "Controller";
		this.classNameMapper = "Base" + className + "Mapper";
		this.classRsqDto = className + "ReqDto";
		this.lowerClassName = Util.toLowerFrist(this.className);
		this.addPackage = addPackage;
	}
	
	public void createControllerJava(Util util) throws Exception {
		List<String> fileStrList = new ArrayList<String>();
		tableComment = util.getTableComment();
		String pack = BooleanUtils.isNotEmpty(addPackage)?addPackage+".":"";
		String urlPack = BooleanUtils.isNotEmpty(addPackage)?addPackage+"/":"";
		fileStrList.add("package " + classPackageName+".controller."+ pack +util.toLower(className)+";");
		fileStrList.add("import " + classPackageName+".dto.BasePageDto;");
		fileStrList.add("");
		fileStrList.add("import "+util.getUserPackageName()+".service."+pack+util.toLower(className)+"."+classNameService+";");
		fileStrList.add("import "+util.getUserPackageName()+".model.base."+pack+classNameModel+";");
		fileStrList.add("import "+util.getUserPackageName()+".dto."+pack+util.toLower(className)+"."+classRsqDto+";");
		fileStrList.add("import com.yundao.core.code.Result;");
		fileStrList.add("import com.yundao.core.validator.group.Update;");
//		fileStrList.add("import com.yundao.core.utils.ObjectCopyUtil;");
		fileStrList.add("import com.yundao.core.pagination.PaginationSupport;");
		fileStrList.add("import com.yundao.core.validator.spring.BindingResultHandler;");
		fileStrList.add("");
		fileStrList.add("import org.springframework.beans.factory.annotation.Autowired;");
		fileStrList.add("import org.springframework.web.bind.annotation.*;");
		fileStrList.add("import org.springframework.validation.BindingResult;");
		fileStrList.add("import org.springframework.beans.BeanUtils;");
		fileStrList.add("import org.springframework.validation.annotation.Validated;");
		fileStrList.add("import org.springframework.web.bind.annotation.RestController;");
		fileStrList.add("import io.swagger.annotations.ApiOperation;");
		fileStrList.add("import io.swagger.annotations.Api;");
		fileStrList.add("");
		fileStrList.add("@RestController");
		fileStrList.add("@RequestMapping(value = \""+ CamelUtil.toSprit(className)+"/\")");
		fileStrList.add("@ResponseBody");
		fileStrList.add("@Api(\""+tableComment+"\")");
		fileStrList.add("public class "+classNameController+"{");
		fileStrList.add("");
		fileStrList.add("    @Autowired");
		fileStrList.add("    private "+classNameService+" "+util.toLowerFrist(classNameService)+";");
		fileStrList.add("");

		if(!pk.equals("")){
			fileStrList.add("    @RequestMapping(value = \"get_page\",method=RequestMethod.GET)");
			fileStrList.add("    @ApiOperation(value=\"分页查询"+tableComment+"\")");
			fileStrList.add("    public Result<PaginationSupport<"+classNameModel+">> getPage(@ModelAttribute "+classRsqDto+" dto, @ModelAttribute BasePageDto pageDto) throws Exception{");
//			fileStrList.add("        "+classNameModel+" model = new " + classNameModel + "();");
//			fileStrList.add("        BeanUtils.copyProperties(dto,model);");
			fileStrList.add("		return " + util.toLowerFrist(classNameService) + ".getPage(dto, pageDto);");
			fileStrList.add("    }");
			fileStrList.add("");

			fileStrList.add("    @RequestMapping(value=\"add\", method=RequestMethod.POST)");
			fileStrList.add("    @ApiOperation(value=\"新增"+tableComment+"\", notes=\"根据"+className+"对象创建"+tableComment+"\")");
			fileStrList.add("    public Result<Integer> add(@Validated @ModelAttribute "+classRsqDto+" reqDto, BindingResult bindingResult) throws Exception{");
			fileStrList.add("        BindingResultHandler.handleByException(bindingResult);");
//			fileStrList.add("        "+classNameModel+" model = ObjectCopyUtil.copyObject(dto,"+classNameModel+".class);");
			fileStrList.add("        return "+util.toLowerFrist(classNameService)+".add(reqDto);");
			fileStrList.add("    }");
			fileStrList.add("");
			
			fileStrList.add("    @RequestMapping(value = \"update\", method=RequestMethod.POST)");
			fileStrList.add("    @ApiOperation(value=\"编辑"+tableComment+"信息\")");
			fileStrList.add("    public Result<Integer> update(@Validated(value = {Update.class}) @ModelAttribute "+classRsqDto+" reqDto, BindingResult bindingResult) throws Exception{");
			fileStrList.add("        BindingResultHandler.handleByException(bindingResult);");
			fileStrList.add("        return "+util.toLowerFrist(classNameService)+".update(reqDto);");
			fileStrList.add("    }");
			fileStrList.add("");

			fileStrList.add("    @RequestMapping(value = \"get\", method=RequestMethod.GET)");
			fileStrList.add("    @ApiOperation(value=\"获取"+tableComment+"详细信息\")");
			fileStrList.add("    public Result<"+classNameModel+"> get(@RequestParam Long "+pk+") throws Exception{");
			fileStrList.add("       return "+util.toLowerFrist(classNameService)+".get(" + pk +");");
			fileStrList.add("    }");
			fileStrList.add("");
		}
		
		fileStrList.add("    @RequestMapping(value = \"delete\", method=RequestMethod.POST)");
		fileStrList.add("    @ApiOperation(value=\"删除"+tableComment+"信息\")");
		fileStrList.add("    public Result<Integer> delete(@RequestParam Long "+pk+") throws Exception{");
		fileStrList.add("        return "+util.toLowerFrist(classNameService)+".delete("+pk+");");
		fileStrList.add("    }");
		fileStrList.add("");
		

		fileStrList.add("}");
		util.writeFile(fileStrList, "controller/"+ urlPack+util.toLower(className)+"/", classNameController+".java");
	}
}
