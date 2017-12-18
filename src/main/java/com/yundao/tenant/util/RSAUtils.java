package com.yundao.tenant.util;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Date;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;

/**
 * RSA算法加密/解密工具类
 * 
 * @author wucaiqiang
 *
 */
public abstract class RSAUtils {
	private static Log LOGGER = LogFactory.getLog(RSAUtils.class);

	private static final String ALGORITHOM = "RSA";
	private static final int KEY_SIZE = 1024;
	private static final Provider DEFAULT_PROVIDER = new BouncyCastleProvider();

	private RSAUtils() {
	}

	/**
	 * 生成并返回RSA密钥对。 
	 * generateKeyPair:
	 * @author: wucq
	 * @return
	 * @description:
	 */
	public static synchronized KeyPair generateKeyPair() {
		try {
			KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(ALGORITHOM, DEFAULT_PROVIDER);
			keyPairGen.initialize(KEY_SIZE,
					new SecureRandom(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss").getBytes()));
			KeyPair oneKeyPair = keyPairGen.generateKeyPair();
			return oneKeyPair;
		} catch (Exception ex) {
			LOGGER.error("生成密钥对出现异常，异常信息为：", ex);
		}
		return null;
	}

	/**
	 * 使用公钥加密数据。 
	 * encrypt:
	 * @author: wucq
	 * @param publicKey
	 * @param data
	 * @return
	 * @throws Exception
	 * @description:
	 */
	public static byte[] encrypt(PublicKey publicKey, byte[] data) throws Exception {
		Cipher ci = Cipher.getInstance(ALGORITHOM, DEFAULT_PROVIDER);
		ci.init(Cipher.ENCRYPT_MODE, publicKey);
		return ci.doFinal(data);
	}

	/**
	 * 使用私钥解密数据 
	 * decrypt:
	 * @author: wucq
	 * @param privateKey
	 * @param data
	 * @return
	 * @throws Exception
	 * @description:
	 */
	public static byte[] decrypt(PrivateKey privateKey, byte[] data) throws Exception {
		Cipher ci = Cipher.getInstance(ALGORITHOM, DEFAULT_PROVIDER);
		ci.init(Cipher.DECRYPT_MODE, privateKey);
		return ci.doFinal(data);
	}

	/**
	 * 加密成16进度字符串 
	 * encryptToHex:
	 * @author: wucq
	 * @param publicKey
	 * @param content
	 * @return 十六进制字符串
	 * @description:
	 */
	public static String encryptToHex(PublicKey publicKey, String content) {
		if (StringUtils.isBlank(content)) {
			return null;
		}
		byte[] data = content.getBytes();
		try {
			byte[] en_data = encrypt(publicKey, data);
			return new String(Hex.encodeHex(en_data));
		} catch (Exception e) {
			LOGGER.error("加密出现异常，异常信息为：", e);
		}
		return null;
	}
	/**
	 * hex 16进制字符串解密
	 * decryptHex:
	 * 
	 * @author: wucq
	 * @param privateKey
	 * @param content
	 * @return
	 * @description:
	 */
	public static String decryptHex(PrivateKey privateKey, String content) {
		if (StringUtils.isBlank(content)) {
			return null;
		}
		try {
			byte[] en_data = Hex.decodeHex(content.toCharArray());
			byte[] data = decrypt(privateKey, en_data);
			return new String(data);
		} catch (Exception e) {
			LOGGER.error("解密出现异常，异常信息为：", e);
		}
		return null;
	}
}