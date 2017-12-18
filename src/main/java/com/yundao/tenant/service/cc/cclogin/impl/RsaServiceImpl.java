package com.yundao.tenant.service.cc.cclogin.impl;

import com.yundao.core.code.Result;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.dto.HeaderUser;
import com.yundao.core.dto.login.KeyPairModel;
import com.yundao.core.ed.Md5Utils;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.service.AbstractService;
import com.yundao.core.service.login.RsaService;
import com.yundao.core.utils.ObjectAndByteUtils;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import com.yundao.tenant.constant.url.ScmUrlConstant;
import com.yundao.tenant.enums.keypair.KeyPairAreaEnum;
import com.yundao.tenant.util.HttpUtils;
import com.yundao.tenant.util.RSAUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gjl on 2017/9/8.
 */
@Service
public class RsaServiceImpl extends AbstractService implements RsaService {
    @Override
    public String processEncryptDBPassword(String password) throws Exception {
        if (StringUtils.isBlank(password)) {
            return "";
        }
        StringBuilder builder = new StringBuilder(password);
        Map<String, Object> methodParams = new HashMap<String, Object>();
        methodParams.put("tenantId", "-1");
        methodParams.put("area", KeyPairAreaEnum.DB.getValue());
        Result<KeyPairModel> keyResult = HttpUtils.get(ScmUrlConstant.KEY_PAIR_GET_BY_TENANT_ID, methodParams, new BaseTypeReference<Result<KeyPairModel>>() {});
        if (keyResult != null && keyResult.getResult() != null) {
            KeyPairModel keyPairModel = keyResult.getResult();
            KeyPair keyPair = (KeyPair) ObjectAndByteUtils.toObject(keyPairModel.getKeyPair());
            String encryptPassword= RSAUtils.encryptToHex(keyPair.getPublic(), builder.reverse().toString());
            return Md5Utils.md5(encryptPassword);
        }
        return "";
    }

    @Override
    public String processDecryptTranPassword(String password) throws Exception {
        HeaderUser user = this.getHeaderUser();

        Map<String, Object> methodParams = new HashMap<String, Object>();
        methodParams.put("tenantId", "-1");
        methodParams.put("area", KeyPairAreaEnum.TRAN.getValue());
        Result<KeyPairModel> keyResult = HttpUtils.get(ScmUrlConstant.KEY_PAIR_GET_BY_TENANT_ID, methodParams, new BaseTypeReference<Result<KeyPairModel>>() {});
        if (keyResult != null && keyResult.getResult() != null) {
            KeyPairModel keyPairModel = keyResult.getResult();
            KeyPair keyPair = (KeyPair) ObjectAndByteUtils.toObject(keyPairModel.getKeyPair());
            String decPassword = RSAUtils.decryptHex(keyPair.getPrivate(), password);
            if(StringUtils.isBlank(decPassword)){
                throw new BaseException(GJLCodeConstant.CODE_1210081);
            }
            StringBuffer sb = new StringBuffer(decPassword);
            decPassword=sb.reverse().toString();
            String realPassword = decPassword.split(CommonConstant.COMMA_SEMICOLON)[0];
            return realPassword;
        }
        return "";
    }
}
