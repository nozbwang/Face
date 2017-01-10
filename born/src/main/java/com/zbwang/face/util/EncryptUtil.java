package com.zbwang.face.util;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class EncryptUtil {
	private final String DES = "DES";

	private String key = "bobomeilin@1234";

	public String encrypt(String data) throws Exception {
		byte[] bt = encrypt(data.getBytes(), key.getBytes());
		String strs = new BASE64Encoder().encode(bt);
		return strs;
	}

	private byte[] encrypt(byte[] data, byte[] key) throws Exception {
		// ���һ�������ε������Դ
		SecureRandom sr = new SecureRandom();

		// ��ԭʼ��Կ��ݴ���DESKeySpec����
		DESKeySpec dks = new DESKeySpec(key);

		// ����һ����Կ������Ȼ�������DESKeySpecת����SecretKey����
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);

		// Cipher����ʵ����ɼ��ܲ���
		Cipher cipher = Cipher.getInstance(DES);

		// ����Կ��ʼ��Cipher����
		cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

		return cipher.doFinal(data);
	}

	public String decrypt(String data) throws Exception {
		if (data == null)
			return null;
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] buf = decoder.decodeBuffer(data);
		byte[] bt = decrypt(buf, key.getBytes());
		return new String(bt);
	}

	private byte[] decrypt(byte[] data, byte[] key) throws Exception {
		// ���һ�������ε������Դ
		SecureRandom sr = new SecureRandom();

		// ��ԭʼ��Կ��ݴ���DESKeySpec����
		DESKeySpec dks = new DESKeySpec(key);

		// ����һ����Կ������Ȼ�������DESKeySpecת����SecretKey����
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);

		// Cipher����ʵ����ɽ��ܲ���
		Cipher cipher = Cipher.getInstance(DES);

		// ����Կ��ʼ��Cipher����
		cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

		return cipher.doFinal(data);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
