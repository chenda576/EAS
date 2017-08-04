package org.action;
import java.security.MessageDigest;
import sun.misc.BASE64Encoder;

public class MessageDigestUtil {
	public static String digestByMD5(String str) throws Exception{
	//采用MD5加密算法，将任意长度字符串加密
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] bts = md.digest(str.getBytes());
		//采用Base64算法，将加密后的字节变成字符串
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(bts);
	}
}
