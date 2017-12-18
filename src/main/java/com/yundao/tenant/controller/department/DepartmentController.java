package com.yundao.tenant.controller.department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.controller.BaseController;
import com.yundao.tenant.dto.department.DepartmentAddReqDto;
import com.yundao.tenant.dto.department.DepartmentDetailResDto;
import com.yundao.tenant.dto.department.DepartmentListResDto;
import com.yundao.tenant.dto.department.DepartmentUpdateReqDto;
import com.yundao.tenant.dto.department.DepartmentUserListResDto;
import com.yundao.tenant.model.base.BaseDepartment;
import com.yundao.tenant.service.department.DepartmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author jan
 * @create 2017-06-19 PM8:14
 **/
@RestController
@RequestMapping("/department")
@ResponseBody
@Api("部门")
public class DepartmentController extends BaseController {

	@Autowired
	private DepartmentService departmentService;

	@ApiOperation(value = "添加部门", notes = "返回部门id")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Result<Long> add(@Validated @ModelAttribute DepartmentAddReqDto departmentAddReqDto,
			BindingResult bindingResult) throws BaseException {
		BindingResultHandler.handleByException(bindingResult);
		// 同一层级，部门名称不能重复
		Result<Boolean> result = departmentService.checkDepartmentNameExist(departmentAddReqDto.getParentId(),
				departmentAddReqDto.getName());
		if (result.getResult()) {
			return Result.newFailureResult(CodeConstant.CODE_1200031, "同一层级，部门名称不能重复", null);
		}

		// 检查上级部门是否存在
		Boolean isExist = departmentService.checkDepartmentExist(departmentAddReqDto.getParentId());
		if (!isExist) {
			return Result.newFailureResult(CodeConstant.CODE_1200033, "上级部门不存在！", null);
		}

		return departmentService.insert(departmentAddReqDto);
	}

	@ApiOperation(value = "获取部门")
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public Result<DepartmentDetailResDto> get(Long id) throws BaseException {
		if (id == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200006);
		}
		return Result.newSuccessResult(departmentService.get(id));
	}

	@ApiOperation(value = "部门列表查询")
	@RequestMapping(value = "/gets", method = RequestMethod.GET)
	public Result<List<DepartmentListResDto>> gets() throws BaseException {
		return Result.newSuccessResult(departmentService.gets());
	}

	@ApiOperation(value = "部门列表查询")
	@RequestMapping(value = "/get_department_and_users", method = RequestMethod.GET)
	public Result<DepartmentUserListResDto> getDepartmentAndUsers() throws BaseException {
		return Result.newSuccessResult(departmentService.getDepartmentAndUsers());
	}

	@ApiOperation(value = "修改部门")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Result<Long> update(@Validated @ModelAttribute DepartmentUpdateReqDto departmentUpdateReqDto,
			BindingResult bindingResult) throws BaseException {
		BindingResultHandler.handleByException(bindingResult);
		if (departmentUpdateReqDto.getId() == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200006);
		}

		// 检查上级部门是否存在
		Boolean isCurrentExist = departmentService.checkDepartmentExist(departmentUpdateReqDto.getId());
		if (!isCurrentExist) {
			return Result.newFailureResult(CodeConstant.CODE_1200033, "当前部门不存在！", null);
		}

		// 同一层级，部门名称不能重复
		Result<Boolean> result = departmentService.checkDepartmentNameExist(departmentUpdateReqDto.getParentId(),
				departmentUpdateReqDto.getName(), departmentUpdateReqDto.getId());
		if (result.getResult()) {
			return Result.newFailureResult(CodeConstant.CODE_1200031, "同一层级，部门名称不能重复", null);
		}

		// 检查上级部门是否存在
		Boolean isExist = departmentService.checkDepartmentExist(departmentUpdateReqDto.getParentId());
		if (!isExist) {
			return Result.newFailureResult(CodeConstant.CODE_1200033, "上级部门不存在！", null);
		}

		BindingResultHandler.handleByException(bindingResult);
		return departmentService.update(departmentUpdateReqDto);
	}

	@ApiOperation(value = "删除部门")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public Result<Long> delete(Long id) throws BaseException {
		if (id == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200006);
		}
		return departmentService.delete(id);
	}

	@ApiOperation(value = "查询当前用户所在的部门")
	@RequestMapping(value = "/get_current_user_department", method = RequestMethod.GET)
	public Result<BaseDepartment> getCurrentUserDepartment() throws BaseException {
		return departmentService.getCurrentUserDepartment();
	}

	@ApiOperation(value = "通过部门id查询部门信息")
	@RequestMapping(value = "/get_base_department_by_id", method = RequestMethod.GET)
	public Result<BaseDepartment> getBaseDepartment(Long id) throws BaseException {
		return departmentService.getBaseDepartment(id);
	}

}
