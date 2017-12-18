package com.yundao.tenant.service.cc.ccuseraccount.impl;

import java.security.KeyPair;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.dto.login.KeyPairModel;
import com.yundao.core.ed.Md5Utils;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.DesUtils;
import com.yundao.core.utils.Limit;
import com.yundao.core.utils.ObjectAndByteUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import com.yundao.tenant.constant.url.ScmUrlConstant;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.cc.cclogin.CcRegisterReqDto;
import com.yundao.tenant.dto.cc.ccuseraccount.CcUserAccountReqDto;
import com.yundao.tenant.dto.login.RetrievePasswordDto;
import com.yundao.tenant.dto.sale.leads.LeadsAddReqDto;
import com.yundao.tenant.dto.sms.SmsTemplateDto;
import com.yundao.tenant.enums.customer.CustomerBelongTypeEnum;
import com.yundao.tenant.enums.customer.CustomerSourceType;
import com.yundao.tenant.enums.keypair.KeyPairAreaEnum;
import com.yundao.tenant.enums.sale.leads.LeadsTypeEnum;
import com.yundao.tenant.enums.sms.template.CaptchaTempEnum;
import com.yundao.tenant.enums.sms.template.SmsTemplateCodeEnum;
import com.yundao.tenant.mapper.base.cc.BaseCcCustomerUserRelMapper;
import com.yundao.tenant.mapper.base.cc.BaseCcUserAccountMapper;
import com.yundao.tenant.mapper.base.cc.BaseCcUserDetailMapper;
import com.yundao.tenant.mapper.base.customer.BaseCustomerDetailMapper;
import com.yundao.tenant.mapper.base.customer.BaseCustomerMapper;
import com.yundao.tenant.model.base.BaseUserDetail;
import com.yundao.tenant.model.base.cc.BaseCcCustomerUserRel;
import com.yundao.tenant.model.base.cc.BaseCcUserAccount;
import com.yundao.tenant.model.base.cc.BaseCcUserAccountExample;
import com.yundao.tenant.model.base.cc.BaseCcUserDetail;
import com.yundao.tenant.model.base.customer.BaseCustomer;
import com.yundao.tenant.model.base.customer.BaseCustomerDetail;
import com.yundao.tenant.model.base.customer.BaseCustomerExample;
import com.yundao.tenant.model.base.customer.BaseUserCustomer;
import com.yundao.tenant.service.cc.cccustomeruserrel.CcCustomerUserRelService;
import com.yundao.tenant.service.cc.ccuseraccount.CcUserAccountService;
import com.yundao.tenant.service.sale.leads.LeadsService;
import com.yundao.tenant.service.sms.SmsCaptchaService;
import com.yundao.tenant.service.sms.SmsService;
import com.yundao.tenant.service.user.UserDetailService;
import com.yundao.tenant.service.user.customer.UserCustomerService;
import com.yundao.tenant.util.HttpUtils;
import com.yundao.tenant.util.RSAUtils;

@Service
public class CcUserAccountServiceImpl extends AbstractService implements CcUserAccountService {

	@Autowired
	private BaseCcUserAccountMapper baseCcUserAccountMapper;

	@Autowired
	private SmsCaptchaService smsCaptchaService;

	@Autowired
	private BaseCustomerMapper baseCustomerMapper;

	@Autowired
	private BaseCcCustomerUserRelMapper customerUserRelMapper;

	@Autowired
	private BaseCustomerDetailMapper baseCustomerDetailMapper;

	@Autowired
	private BaseCcUserDetailMapper baseCcUserDetailMapper;

	@Autowired
	private SmsService smsService;

	@Autowired
	private LeadsService leadsServjice;
	@Autowired
	private UserDetailService userDetailService;
	@Autowired
	private CcCustomerUserRelService ccCustomerUserRelService;
	@Autowired
	private UserCustomerService userCustomerService;

	public Result<Integer> add(CcUserAccountReqDto reqDto) throws Exception {
		BaseCcUserAccount model = new BaseCcUserAccount();
		BeanUtils.copyProperties(reqDto, model);
		model.setCreateDate(new Date());
		model.setCreateUserId(super.getHeaderUserId());
		model.setId(null);
		int count = baseCcUserAccountMapper.insertSelective(model);
		return Result.newSuccessResult(count);
	}

	public Result<Integer> update(CcUserAccountReqDto reqDto) throws Exception {
		BaseCcUserAccount model = new BaseCcUserAccount();
		BeanUtils.copyProperties(reqDto, model);
		model.setUpdateDate(new Date());
		model.setUpdateUserId(super.getHeaderUserId());
		int count = baseCcUserAccountMapper.updateByPrimaryKeySelective(model);
		return Result.newSuccessResult(count);
	}

	public Result<Integer> delete(Long id) throws Exception {
		BaseCcUserAccount ccUserAccount = new BaseCcUserAccount();
		ccUserAccount.setId(id);
		ccUserAccount.setUpdateDate(new Date());
		ccUserAccount.setUpdateUserId(super.getHeaderUserId());
		int count = baseCcUserAccountMapper.updateByPrimaryKeySelective(ccUserAccount);
		return Result.newSuccessResult(count);
	}

	public Result<BaseCcUserAccount> get(Long id) throws Exception {
		BaseCcUserAccount model = baseCcUserAccountMapper.selectByPrimaryKey(id);
		return Result.newSuccessResult(model);
	}

	public Result<PaginationSupport<BaseCcUserAccount>> getPage(CcUserAccountReqDto ccUserAccountReqDto,
			AbstractBasePageDto pageDto) throws Exception {
		BaseCcUserAccountExample baseCcUserAccountExample = new BaseCcUserAccountExample()
				.setLimit(Limit.buildLimit(pageDto.getCurrentPage(), pageDto.getPageSize()));
		BaseCcUserAccountExample.Criteria criteria = baseCcUserAccountExample.createCriteria();
		String orderByClause = "create_date desc";
		if (StringUtils.isNotBlank(pageDto.getOrderColumn())) {
			StringBuilder orderBuider = new StringBuilder();
			orderBuider.append(pageDto.getOrderColumn()).append(" ");
			if (StringUtils.isNotBlank(pageDto.getSort())) {
				orderBuider.append(pageDto.getSort());
			} else {
				orderBuider.append("desc");
			}
			orderByClause = orderBuider.toString();
		}
		baseCcUserAccountExample.setOrderByClause(orderByClause);
		List<BaseCcUserAccount> list = baseCcUserAccountMapper.selectByExample(baseCcUserAccountExample);
		int totalCount = baseCcUserAccountMapper.countByExample(baseCcUserAccountExample);
		PaginationSupport<BaseCcUserAccount> result = pageDto.getPaginationSupport();
		result.setDatas(list);
		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
	}

	@Override
	public Result<Integer> sendRetrieveCaptcha(String mobile, CaptchaTempEnum retrieve2cCaptcha) throws Exception {
		BaseCcUserAccount userAccount = checkMobileExist(mobile);
		// 验证手机号是否存在
		if (retrieve2cCaptcha.equals(CaptchaTempEnum.REGISTER_2C_CAPTCHA) && userAccount != null) {
			throw new BaseException(GJLCodeConstant.CODE_1210087);
		} else if (!retrieve2cCaptcha.equals(CaptchaTempEnum.REGISTER_2C_CAPTCHA)) {
			if (userAccount == null) {
				throw new BaseException(GJLCodeConstant.CODE_1210079);
			}
		}
		SmsTemplateDto smsTemplateDto = new SmsTemplateDto();
		smsTemplateDto.setCode(retrieve2cCaptcha.getCode());
		smsService.sendCaptchaToC(mobile, smsTemplateDto);
		return Result.newSuccessResult();
	}

	private BaseCcUserAccount checkMobileExist(String mobile) throws Exception {
		BaseCcUserAccountExample example = new BaseCcUserAccountExample();
		example.createCriteria().andMobileEqualTo(DesUtils.encrypt(mobile));
		return baseCcUserAccountMapper.selectOne(example);
	}

	@Override
	public Result<Integer> processRetrievePassword(RetrievePasswordDto model) throws Exception {
		BaseCcUserAccount userAccount = checkMobileExist(model.getMobile());
		if (userAccount == null) {
			throw new BaseException(GJLCodeConstant.CODE_1210079);
		}

		Result<Boolean> verifyResult = smsCaptchaService.doVerifyAndSetInvalidIfPass(model.getMobile(),
				SmsTemplateCodeEnum.CAPTCHA_2C_RETRIEVE.getValue(), model.getCaptcha());
		if (!verifyResult.getSuccess())
			return Result.newFailureResult(verifyResult.getCode());

		String orginPassword = processDecryptTranPassword(model.getPassword());
		String md5Password = processEncryptDBPassword(orginPassword);
		userAccount.setPassword(md5Password);
		int count = baseCcUserAccountMapper.updateByPrimaryKeySelective(userAccount);
		return Result.newSuccessResult(count);
	}

	@Override
	public String processDecryptTranPassword(String password) throws Exception {
		if (StringUtils.isBlank(password)) {
			return null;
		}
		Map<String, Object> methodParams = new HashMap<String, Object>();
		methodParams.put("tenantId", "-1");
		methodParams.put("area", KeyPairAreaEnum.TRAN.getValue());
		Result<KeyPairModel> keyResult = HttpUtils.get(ScmUrlConstant.KEY_PAIR_GET_BY_TENANT_ID, methodParams,
				new BaseTypeReference<Result<KeyPairModel>>() {
				});
		String realPassword = null;
		if (keyResult != null && keyResult.getResult() != null) {
			KeyPairModel keyPairModel = keyResult.getResult();
			KeyPair keyPair = (KeyPair) ObjectAndByteUtils.toObject(keyPairModel.getKeyPair());
			String decPassword = RSAUtils.decryptHex(keyPair.getPrivate(), password);
			if (StringUtils.isBlank(decPassword)) {
				throw new BaseException(GJLCodeConstant.CODE_1210081);
			}
			StringBuffer sb = new StringBuffer(decPassword);
			decPassword = sb.reverse().toString();
			realPassword = decPassword.split(CommonConstant.COMMA_SEMICOLON)[0];
		}
		return realPassword;
	}

	@Override
	public String processEncryptDBPassword(String password) throws Exception {
		if (StringUtils.isBlank(password)) {
			return null;
		}
		StringBuilder builder = new StringBuilder(password);
		Map<String, Object> methodParams = new HashMap<String, Object>();
		methodParams.put("tenantId", "-1");
		methodParams.put("area", KeyPairAreaEnum.DB.getValue());
		Result<KeyPairModel> keyResult = HttpUtils.get(ScmUrlConstant.KEY_PAIR_GET_BY_TENANT_ID, methodParams,
				new BaseTypeReference<Result<KeyPairModel>>() {
				});
		String result = null;
		if (keyResult != null && keyResult.getResult() != null) {
			KeyPairModel keyPairModel = keyResult.getResult();
			KeyPair keyPair = (KeyPair) ObjectAndByteUtils.toObject(keyPairModel.getKeyPair());
			String encryptPassword = RSAUtils.encryptToHex(keyPair.getPublic(), builder.reverse().toString());
			result = Md5Utils.md5(encryptPassword);
		}
		return result;
	}

	@Override
	public Result<Map<String, Object>> processRegister(CcRegisterReqDto reqDto) throws Exception {
		validateRegister(reqDto);
		String mobile = DesUtils.encrypt(reqDto.getMobile());
		// 新增用户到数据库
		BaseCcUserAccount userAccount = new BaseCcUserAccount();
		userAccount.setMobile(mobile);
		String orginPassword = processDecryptTranPassword(reqDto.getPassword());
		String md5Password = processEncryptDBPassword(orginPassword);
		userAccount.setPassword(md5Password);
		userAccount.setCreateDate(new Date());
		userAccount.setTenantId(super.getHeaderTenantId());
		baseCcUserAccountMapper.insertSelective(userAccount);
		// 添加user详情
		addUserDetail(userAccount, reqDto);
		// 判断是否有存在的客户
		BaseCustomerExample customerExample = new BaseCustomerExample();
		customerExample.createCriteria().andMobileEqualTo(mobile);
		BaseCustomer customer = baseCustomerMapper.selectOne(customerExample);
		// 如果没有有当前客户，新增客户基本信息
		if (customer == null) {
			BaseCustomer baseCustomer = new BaseCustomer();
			baseCustomer.setCreateDate(new Date());
			baseCustomer.setName(reqDto.getRealName());
			baseCustomer.setMobile(mobile);
			baseCustomer.setTenantId(super.getHeaderTenantId());
			baseCustomer.setBelongType(CustomerBelongTypeEnum.SALE_CLUE.getValue());
			baseCustomerMapper.insertSelective(baseCustomer);
			// 修改用户编码
			baseCustomer.setNumber(String.format("%08d", baseCustomer.getId()));
			baseCustomerMapper.updateByPrimaryKeySelective(baseCustomer);
			// 新增客户详情
			BaseCustomerDetail customerDetail = new BaseCustomerDetail();
			customerDetail.setId(baseCustomer.getId());
			customerDetail.setTenantId(baseCustomer.getTenantId());
			baseCustomerDetailMapper.insertSelective(customerDetail);
			customer = baseCustomer;
		}
		// 建立关联关系
		BaseCcCustomerUserRel customerUserRel = new BaseCcCustomerUserRel();
		customerUserRel.setCustomerId(customer.getId());
		customerUserRel.setUserAccountId(userAccount.getId());
		customerUserRel.setCreateDate(new Date());
		customerUserRel.setTenantId(userAccount.getTenantId());
		customerUserRelMapper.insertSelective(customerUserRel);

		if (StringUtils.isNotBlank(reqDto.getAfpUUID())) {
			// 如果存在，挂到理财师名下
			BaseUserDetail userDetail = userDetailService.getByUUID(reqDto.getAfpUUID());// 查询理财师信息
			if (userDetail != null) {
				BaseUserCustomer userCustomer = userCustomerService.getByCustomerId(customer.getId());
				if (userCustomer == null) {
					// 当前客户没有归属理财师才进行自动分配
					BaseUserCustomer baseUserCustomer = new BaseUserCustomer();
					baseUserCustomer.setCustomerId(customer.getId());
					baseUserCustomer.setUserId(userDetail.getUserAccountId());
					baseUserCustomer.setSourceType(CustomerSourceType.DISTRIBUTION.getValue());
					userCustomerService.insert(baseUserCustomer);
				}

			}

		}

		// 新增销售线索
		LeadsAddReqDto leadsAddReqDto = new LeadsAddReqDto();
		leadsAddReqDto.setChannel(reqDto.getChannel());
		leadsAddReqDto.setType(LeadsTypeEnum.REGISTER.getValue());
		leadsAddReqDto.setContent("注册");
		leadsServjice.add(customer.getId(), leadsAddReqDto);

		Map<String, Object> result = new HashMap<>();
		result.put("userId", userAccount.getId());
		result.put("customerId", customer.getId());
		return Result.newSuccessResult(result);
	}

	private void addUserDetail(BaseCcUserAccount userAccount, CcRegisterReqDto reqDto) {
		BaseCcUserDetail ccUserDetail = new BaseCcUserDetail();
		ccUserDetail.setTenantId(userAccount.getTenantId());
		ccUserDetail.setUserAccountId(userAccount.getId());
		ccUserDetail.setRealName(reqDto.getRealName());
		ccUserDetail.setCreateDate(new Date());
		baseCcUserDetailMapper.insertSelective(ccUserDetail);
	}

	@Override
	public Result<Boolean> validateMobile(String mobile) throws Exception {
		BaseCcUserAccountExample userAccountExample = new BaseCcUserAccountExample();
		userAccountExample.createCriteria().andMobileEqualTo(DesUtils.encrypt(mobile));
		BaseCcUserAccount baseCcUserAccount = baseCcUserAccountMapper.selectOne(userAccountExample);
		if (baseCcUserAccount != null) {
			return Result.newSuccessResult(true);
		}
		return Result.newSuccessResult(false);
	}

	private void validateRegister(CcRegisterReqDto reqDto) throws Exception {
		if(StringUtils.isNotBlank(reqDto.getMobile())){
			reqDto.setMobile(reqDto.getMobile().replaceAll("[^0-9]", ""));
		}
		BaseCcUserAccountExample userAccountExample = new BaseCcUserAccountExample();
		userAccountExample.createCriteria().andMobileEqualTo(DesUtils.encrypt(reqDto.getMobile()));
		BaseCcUserAccount baseCcUserAccount = baseCcUserAccountMapper.selectOne(userAccountExample);
		if (baseCcUserAccount != null) {
			throw new BaseException(GJLCodeConstant.CODE_1210085);
		}
		Result<Boolean> result = smsCaptchaService.doVerifyAndSetInvalidIfPass(reqDto.getMobile(),
				SmsTemplateCodeEnum.CAPTCHA_2C_REGISTER.getValue(), reqDto.getCaptcha());
		if (!result.getSuccess())
			throw new BaseException(result.getCode());
	}
}
