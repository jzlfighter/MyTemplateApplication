/*
 * RSA加密原理概述
 * RSA的安全性依赖于大数的分解，公钥和私钥都是两个大素数（大于100的十进制位）的函数。
 * 据猜测，从一个密钥和密文推断出明文的难度等同于分解两个大素数的积
 * ===================================================================
 * 密钥的产生：
 * 1.选择两个大素数 p,q ,计算 n=p*q;
 * 2.随机选择加密密钥 e ,要求 e 和 (p-1)*(q-1)互质
 * 3.利用 Euclid 算法计算解密密钥 d , 使其满足 e*d = 1(mod(p-1)*(q-1)) (其中 n,d 也要互质)
 * 4:至此得出公钥为 (n,e) 私钥为 (n,d)
 * ===================================================================
 * 加解密方法：
 * 1.首先将要加密的信息 m(二进制表示) 分成等长的数据块 m1,m2,...,mi 块长 s(尽可能大) ,其中 2^s<n
 * 2:对应的密文是： ci = mi^e(mod n)
 * 3:解密时作如下计算： mi = ci^d(mod n)
 * ===================================================================
 * RSA速度
 * 由于进行的都是大数计算，使得RSA最快的情况也比DES慢上100倍，无论是软件还是硬件实现。
 * 速度一直是RSA的缺陷。一般来说只用于少量数据加密。
 */
package com.example.administrator.mytemplateapplication.tools.encryption;


import com.example.administrator.mytemplateapplication.tools.utils.TextUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

public final class RSA {
    // RSA密钥文件路径
    private static final String KEY_PATH = "D:/RSAKey.txt";
    // 算法名称
    private static final String KEY_ALGORITHM = "RSA";
    // 算法名称/加密模式/填充方式
    // private static final String CIPHER_ALGORITHM    = "RSA/ECB/PKCS1Padding";
    private static final String CIPHER_ALGORITHM = "RSA/None/PKCS1Padding";
    // 秘钥长度
    private static final int DEFAULT_KEY_SIZE = 1024;
    // 当前秘钥、工作模式、填充方式所支持加密的最大字节数
    private static final int DEFAULT_BUFFER_SIZE = (DEFAULT_KEY_SIZE / 8) - 11;
    //与php服务端签名需要的key
    private static String phpSignKey = "";

    /**
     * 随机生成RSA密钥对(默认密钥长度为1024)
     */
    private static KeyPair generateRSAKeyPair() {
        return generateRSAKeyPair(DEFAULT_KEY_SIZE);
    }

    /**
     * 随机生成RSA密钥对
     *
     * @param keyLength 密钥长度，范围：512～2048
     *                  一般1024
     */
    private static KeyPair generateRSAKeyPair(int keyLength) {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance(KEY_ALGORITHM);
            kpg.initialize(keyLength);
            KeyPair kp = kpg.genKeyPair();
            printPublicKeyInfo(kp.getPublic());
            printPrivateKeyInfo(kp.getPrivate());
            return kp;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 通过公钥byte[]将公钥还原
     *
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    private static PublicKey getPublicKey(byte[] keyBytes) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        // X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        return keyFactory.generatePublic(keySpec);
    }

    /**
     * 通过私钥byte[]将私钥还原
     *
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    private static PrivateKey getPrivateKey(byte[] keyBytes) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        // X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        return keyFactory.generatePrivate(keySpec);
    }

    /**
     * 使用N、e值还原公钥
     * 通过模数 + 指数获得公钥
     *
     * @param modulus        模数
     * @param publicExponent 公钥指数
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    private static RSAPublicKey getPublicKey(String modulus, String publicExponent) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(new BigInteger(modulus), new BigInteger(publicExponent));
        return (RSAPublicKey) keyFactory.generatePublic(keySpec);
    }

    /**
     * 使用N、d值还原私钥
     * 通过模数 + 指数获得私钥
     *
     * @param modulus         模数
     * @param privateExponent 私钥指数
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    private static RSAPrivateKey getPrivateKey(String modulus, String privateExponent) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(new BigInteger(modulus), new BigInteger(privateExponent));
        return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
    }

    /**
     * 从字符串中加载公钥
     *
     * @param publicKeyStr 公钥数据字符串
     * @return 公钥
     * @throws Exception 加载公钥时产生的异常
     */
    private static PublicKey loadPublicKey(String publicKeyStr) throws Exception {
        try {
            byte[] buffer = Base64.decode(publicKeyStr);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
            return keyFactory.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException e) {
            throw new Exception("公钥非法");
        } catch (NullPointerException e) {
            throw new Exception("公钥数据为空");
        }
    }

    /**
     * 从字符串中加载私钥
     * 加载时使用的是PKCS8EncodedKeySpec（PKCS#8编码的Key指令）。
     *
     * @param privateKeyStr 私钥数据字符串
     * @return 私钥
     * @throws Exception 加载私钥时产生的异常
     */
    public static PrivateKey loadPrivateKey(String privateKeyStr) throws Exception {
        try {
            byte[] buffer = Base64.decode(privateKeyStr);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            // X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
            return keyFactory.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException e) {
            throw new Exception("私钥非法");
        } catch (NullPointerException e) {
            throw new Exception("私钥数据为空");
        }
    }

    /**
     * 从文件输入流中加载公钥
     *
     * @param in 公钥输入流
     * @return 公钥
     * @throws Exception 加载公钥时产生的异常
     */
    public static PublicKey loadPublicKey(InputStream in) throws Exception {
        try {
            return loadPublicKey(readKey(in));
        } catch (IOException e) {
            throw new Exception("公钥数据流读取错误");
        } catch (NullPointerException e) {
            throw new Exception("公钥输入流为空");
        }
    }

    /**
     * 从文件输入流中加载私钥
     *
     * @param in 私钥输入流
     * @return 私钥
     * @throws Exception 加载公钥时产生的异常
     */
    private static PrivateKey loadPrivateKey(InputStream in) throws Exception {
        try {
            return loadPrivateKey(readKey(in));
        } catch (IOException e) {
            throw new Exception("私钥数据读取错误");
        } catch (NullPointerException e) {
            throw new Exception("私钥输入流为空");
        }
    }

    /**
     * 读取密钥信息
     *
     * @throws IOException
     */
    private static String readKey(InputStream in) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        String readLine;
        while ((readLine = br.readLine()) != null) {
            if (readLine.charAt(0) != '-') {
                sb.append(readLine);
                sb.append('\r');
            }
        }
        return sb.toString();
    }

    /**
     * 保存密钥文件
     *
     * @throws Exception
     */
    private static void saveKeyPair(KeyPair kp) throws Exception {
        FileOutputStream fos = new FileOutputStream(KEY_PATH);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(kp);
        oos.close();
        fos.close();
    }

    /**
     * 读取密钥文件
     *
     * @throws Exception
     */
    private static KeyPair readKeyPair(String path) throws Exception {
        if (TextUtil.isEmpty(path)) {
            path = KEY_PATH;
        }
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream oos = new ObjectInputStream(fis);
        KeyPair kp = (KeyPair) oos.readObject();
        oos.close();
        fis.close();
        return kp;
    }

    /**
     * 读取源文件内容
     *
     * @param path 文件路径
     * @return byte[] 文件内容
     * @throws IOException
     */
    private static String readFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String s = br.readLine();
        String str = "";
        while (s.charAt(0) != '-') {
            str += s;
            s = br.readLine();
        }
        br.close();
        return str;
    }

    /**
     * 打印公钥信息
     */
    private static void printPublicKeyInfo(PublicKey publicKey) {
        RSAPublicKey rsaPublicKey = (RSAPublicKey) publicKey;
        System.out.println("\n---------- RSAPublicKey ----------");
        System.out.println("Modulus.length=" + rsaPublicKey.getModulus().bitLength());
        System.out.println("Modulus=" + rsaPublicKey.getModulus().toString());
        System.out.println("PublicExponent.length=" + rsaPublicKey.getPublicExponent().bitLength());
        System.out.println("PublicExponent=" + rsaPublicKey.getPublicExponent().toString());
        System.out.println("PublicEncoded=" + Base64.encode(rsaPublicKey.getEncoded()));
    }

    /**
     * 打印私钥信息
     */
    private static void printPrivateKeyInfo(PrivateKey privateKey) {
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) privateKey;
        System.out.println("\n---------- RSAPrivateKey ----------");
        System.out.println("Modulus.length=" + rsaPrivateKey.getModulus().bitLength());
        System.out.println("Modulus=" + rsaPrivateKey.getModulus().toString());
        System.out.println("PrivateExponent.length=" + rsaPrivateKey.getPrivateExponent().bitLength());
        System.out.println("PrivateExponent=" + rsaPrivateKey.getPrivateExponent().toString());
        System.out.println("PrivateEncoded=" + Base64.encode(rsaPrivateKey.getEncoded()));
    }

    /**
     * 加密
     *
     * @param key  加密的密钥
     * @param data 待加密的数据
     * @return 加密后的数据
     * @throws Exception
     */
    public static byte[] encrypt(Key key, byte[] data) throws Exception {
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        // 编码前设定编码方式及密钥
        cipher.init(Cipher.ENCRYPT_MODE, key);
        // 待加密的字节数不能超过密钥的长度值除以 8 再减去 11
        // int blockSize = cipher.getBlockSize();
        int blockSize = DEFAULT_BUFFER_SIZE;
        // 获得加密块加密后块大小
        int outputSize = cipher.getOutputSize(data.length);
        int leavedSize = data.length % blockSize;
        int blocksSize = leavedSize != 0 ? data.length / blockSize + 1 : data.length / blockSize;
        byte[] raw = new byte[outputSize * blocksSize];
        int i = 0;
        while (data.length - i * blockSize > 0) {
            if (data.length - i * blockSize > blockSize) {
                cipher.doFinal(data, i * blockSize, blockSize, raw, i * outputSize);
            } else {
                cipher.doFinal(data, i * blockSize, data.length - i * blockSize, raw, i * outputSize);
            }
            i++;
        }
        return raw;
    }

    /**
     * 解密
     *
     * @param key  解密的密钥
     * @param data 待解密的数据
     * @return 解密后的数据
     * @throws Exception
     */
    public static byte[] decrypt(Key key, byte[] data) throws Exception {
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        // 编码前设定编码方式及密钥
        cipher.init(Cipher.DECRYPT_MODE, key);
        // int                   blockSize = cipher.getBlockSize();
        int blockSize = DEFAULT_BUFFER_SIZE + 11;
        ByteArrayOutputStream bout = new ByteArrayOutputStream(64);
        int i = 0;
        while (data.length - i * blockSize > 0) {
            bout.write(cipher.doFinal(data, i * blockSize, blockSize));
            i++;
        }
        return bout.toByteArray();
    }
    ///////////////////////////////////////////////////////////////////////////
    // 获取密钥
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 密钥加载模式
     */
    public enum MODE {
        // PEM证书字符串
        PEM_STRING,
        // 十进制 - 模数、指数
        MODULUS_EXPONENT,
        // PEM证书文件
        PEM_FILE,
        // 密钥文件
        KEY_FILE
    }

    /**
     * 私钥类型
     */
    public static final String TYPE_PRIVATE = "0";
    /**
     * 公钥类型
     */
    public static final String TYPE_PUBLIC = "1";

    /**
     * @param mode   密钥加载模式
     * @param params 密钥信息
     *               第一位：密钥类型: 0 - 私钥, 1 - 公钥
     *               第二位：密钥字符串、密钥文件路径、模数
     *               第三位：指数
     */
    public static Key getKey(MODE mode, String... params) throws Exception {
        if (null == params || params.length <= 1) {
            return null;
        }
        String type = "";
        String arg1 = "";
        String arg2 = "";
        if (params.length == 2) {
            type = params[0];
            arg1 = params[1];
        } else if (params.length == 3) {
            type = params[0];
            arg1 = params[1];
            arg2 = params[2];
        }

        switch (mode) {
            /* PEM证书字符串 */
            case PEM_STRING:
                if (TYPE_PRIVATE.equals(type)) {
                    return loadPrivateKey(arg1);
                } else {
                    return loadPublicKey(arg1);
                }

            /* 十进制 - 模数、指数 */
            case MODULUS_EXPONENT:
                if (TYPE_PRIVATE.equals(type)) {
                    return getPrivateKey(arg1, arg2);
                } else {
                    return getPublicKey(arg1, arg2);
                }

            /* PEM证书文件 */
            case PEM_FILE:
                if (TYPE_PRIVATE.equals(type)) {
                    return loadPrivateKey(readFile(arg1));
                } else {
                    return loadPublicKey(readFile(arg1));
                }

             /* 密钥文件 */
            case KEY_FILE:
                if (TYPE_PRIVATE.equals(type)) {
                    return readKeyPair(arg1).getPrivate();
                } else {
                    return readKeyPair(arg1).getPublic();
                }

            default:
                return null;
        }
    }


    /**
     * 与php端数据交互签名方法\
     * @param data
     * @return
     * @throws Exception
     */
    public static String phpEncrypt(String data) throws Exception {
        PrivateKey privateKey = loadPrivateKey(phpSignKey);
        Signature signature = Signature.getInstance("SHA1withRSA");
        signature.initSign(privateKey);
        signature.update(data.getBytes());
        byte[] bytes = signature.sign();
        return Base64.encode(bytes);
    }


    public static void main(String[] args) throws Exception {

    }


}
