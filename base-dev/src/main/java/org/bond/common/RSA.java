/**   
* @Title: RSA.java 
* @Package com.bond.dev 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2017年2月23日 下午2:48:05 
* @company 版权所有 深圳市天行云供应链有限公司
* @version V1.0   
*/
package org.bond.common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import javax.crypto.Cipher;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @ClassName: RSA
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author bond
 * @date 2017年2月23日 下午2:48:05
 * 
 */
public class RSA {
//
//	/** 指定加密算法为RSA */  
//    private static final String ALGORITHM = "RSA";  
//    /** 指定公钥存放文件 */  
//    private static String PUBLIC_KEY_FILE = "PublicKey";  
//    /** 指定私钥存放文件 */  
//    private static String PRIVATE_KEY_FILE = "PrivateKey";  
//
//    private static int KEYSIZE = 1024;
//	/**
//	 * @throws IOException 
//	 * @throws NoSuchAlgorithmException @Title: main @Description:
//	 * TODO(这里用一句话描述这个方法的作用) @param @param args 参数说明 @return void 返回类型 @author
//	 * bond @throws
//	 */
//	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
//		generatePairKey();
//		genKeyPair();
//	}
//	
//	public static void generatePairKey() throws NoSuchAlgorithmException, IOException{
//		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(ALGORITHM);
//		// 密钥位数
//		keyPairGen.initialize(1024);
//		// 密钥对
//		KeyPair keyPair = keyPairGen.generateKeyPair();
//		// 公钥
//		Key publicKey = (RSAPublicKey) keyPair.getPublic();
//		// 私钥
//		Key privateKey = (RSAPrivateKey) keyPair.getPrivate();
//
//		ObjectOutputStream oos1 = null;
//		ObjectOutputStream oos2 = null;
//		try {
//			/** 用对象流将生成的密钥写入文件 */
//			oos1 = new ObjectOutputStream(new FileOutputStream(PUBLIC_KEY_FILE));
//			oos2 = new ObjectOutputStream(new FileOutputStream(PRIVATE_KEY_FILE));
//			oos1.writeObject(publicKey);
//			oos2.writeObject(privateKey);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			/** 清空缓存，关闭文件输出流 */
//			oos1.close();
//			oos2.close();
//		}
//
//        System.out.println("生成的公钥:"+new BASE64Encoder().encode(publicKey.getEncoded()));
//        System.out.println("生成的私钥:"+new BASE64Encoder().encode(privateKey.getEncoded()));
//	}
//	
//	
//	 private static void genKeyPair() throws NoSuchAlgorithmException {  
//         
//	        /** RSA算法要求有一个可信任的随机数源 */  
//	        SecureRandom secureRandom = new SecureRandom();  
//	          
//	        /** 为RSA算法创建一个KeyPairGenerator对象 */  
//	        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);  
//	  
//	        /** 利用上面的随机数据源初始化这个KeyPairGenerator对象 */  
//	        keyPairGenerator.initialize(KEYSIZE, secureRandom);  
//	        //keyPairGenerator.initialize(KEYSIZE);  
//	  
//	        /** 生成密匙对 */  
//	        KeyPair keyPair = keyPairGenerator.generateKeyPair();  
//	  
//	        /** 得到公钥 */  
//	        Key publicKey = keyPair.getPublic();  
//	  
//	        /** 得到私钥 */  
//	        Key privateKey = keyPair.getPrivate();  
//	  
//	        byte[] publicKeyBytes = publicKey.getEncoded();  
//	        byte[] privateKeyBytes = privateKey.getEncoded();  
//	  
//	        String publicKeyBase64 = new BASE64Encoder().encode(publicKeyBytes);  
//	        String privateKeyBase64 = new BASE64Encoder().encode(privateKeyBytes);  
//	  
//	        System.out.println("publicKeyBase64.length():" + publicKeyBase64.length());  
//	        System.out.println("publicKeyBase64:" + publicKeyBase64);  
//	  
//	        System.out.println("privateKeyBase64.length():" + privateKeyBase64.length());  
//	        System.out.println("privateKeyBase64:" + privateKeyBase64);  
//	    }  
//	 
//	 
//    /** 
//     * 加密方法 
//     * @param source 源数据 
//     * @return 
//     * @throws Exception 
//     */  
//    public static String encrypt(String source) throws Exception {  
//          
//        Key publicKey = getKey(PUBLIC_KEY_FILE);  
//  
//        /** 得到Cipher对象来实现对源数据的RSA加密 */  
//        Cipher cipher = Cipher.getInstance(ALGORITHM);  
//        cipher.init(Cipher.ENCRYPT_MODE, publicKey);  
//        byte[] b = source.getBytes();  
//        /** 执行加密操作 */  
//        byte[] b1 = cipher.doFinal(b);  
//        BASE64Encoder encoder = new BASE64Encoder();  
//        return encoder.encode(b1);  
//    }
//    /** 
//     * 解密算法 
//     * @param cryptograph    密文 
//     * @return 
//     * @throws Exception 
//     */  
//    public static String decrypt(String cryptograph) throws Exception {  
//          
//        Key privateKey = getKey(PRIVATE_KEY_FILE);  
//  
//        /** 得到Cipher对象对已用公钥加密的数据进行RSA解密 */  
//        Cipher cipher = Cipher.getInstance(ALGORITHM);  
//        cipher.init(Cipher.DECRYPT_MODE, privateKey);  
//        BASE64Decoder decoder = new BASE64Decoder();  
//        byte[] b1 = decoder.decodeBuffer(cryptograph);  
//  
//        /** 执行解密操作 */  
//        byte[] b = cipher.doFinal(b1);  
//        return new String(b);  
//    }  
//      
//    private static Key getKey(String fileName) throws Exception, IOException {  
//        Key key;  
//        ObjectInputStream ois = null;  
//        try {  
//            /** 将文件中的私钥对象读出 */  
//            ois = new ObjectInputStream(new FileInputStream(fileName));  
//            key = (Key) ois.readObject();  
//        } catch (Exception e) {  
//            throw e;  
//        } finally {  
//            ois.close();  
//        }  
//        return key;  
//    }  

}
