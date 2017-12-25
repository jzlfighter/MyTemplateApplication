package com.example.administrator.mytemplateapplication.tools.encryption;


import java.security.Key;
import java.security.PrivateKey;
import java.security.Signature;

/**
 * Author: fwd
 * E-mail: xth@erongdu.com
 * Date: 2017年06月26日11:30:54
 * <p>
 * Description: RSA 工具类
 */
@SuppressWarnings("unused")
public class RSAUtil {
    ///////////////////////////////////////////////////////////////////////////
    // RSA + Base64 加解密
    ///////////////////////////////////////////////////////////////////////////
    public static String Base64Encrypt(Key encryptKey, String data) {
        try {
            return Base64.encode(RSA.encrypt(encryptKey, data.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
            return data;
        }
    }

    public static String Base64Decrypt(Key decryptKey, String data) {
        try {
            byte[] base64Decrypt = RSA.decrypt(decryptKey, Base64.decode(data));
            if (null == base64Decrypt) {
                return data;
            } else {
                return new String(base64Decrypt);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return data;
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // RSA + BCD 加解密
    ///////////////////////////////////////////////////////////////////////////
    public static String BCDEncrypt(Key encryptKey, String data) {
        try {
            return BCD.encode(RSA.encrypt(encryptKey, data.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
            return data;
        }
    }

    public static String BCDDecrypt(Key decryptKey, String data) {
        try {
            byte[] bcdDecrypt = RSA.decrypt(decryptKey, BCD.decode(data));
            if (null == bcdDecrypt) {
                return data;
            } else {
                return new String(bcdDecrypt);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return data;
        }
    }


    /**
     * 数字签名方法
     * @param data 需要签名的数据
     * @return 返回签名后的数据
     */
    public static String Sign(String data) throws Exception {
        //设备信息采集签名密钥
         String priKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAMmfFQt1Seq792sX\n" +
                "TUCKE/X0gVqUD64S6Y/+zet+QJIp2sBMFCbqF8OfhtCvTI4ogdrsqkFNN6YhX4ld\n" +
                "fbGN7x5Fk+LfeUZ/4c6iibIYaOfLZwBU85BM7Z5jvczMsQovtWvCLX1khndPCwp3\n" +
                "1W2xPJosgIy/FqgwwZqJ6Dt5U3FfAgMBAAECgYAq1u9cyOYUxy2SBph2fyAwoWwe\n" +
                "t9kBDqmr2+MbB29m3xfIxiF+Bz1XZnz5uFWW2wqEXsbqKyMI3Ix1HnVHlbXZop2q\n" +
                "ypoOwrIpRYD2a8BCh7HdRgdK88F+GYN5xrDfud6tJIAMmRvnXvjhwWOu/H1wavjk\n" +
                "xHmywbaptSGWDAJJSQJBAP4nUP40CdcDtVVPKta60EuAXd/oDVnV6TZaXttqm25x\n" +
                "flzO9hM6yR6WSiFbTEtfHT9vMAMuVI3889DDw61qRpUCQQDLFhCPgBP/kaO49Kt1\n" +
                "14ZNUZguslSCnCG8Y3X93+7cWzOVZ1UzBqhFl97COAOTVwJekO9cD+dTsKQ6DAzr\n" +
                "EN8jAkALBHdNXcIjcQS2WwU3Y8fNzhXDtBKIF27RrV85UcjFI+Rfb5VZRg4b5lX2\n" +
                "VjfbeJcS/eXt7V86/IExRps/9EB1AkAKWZmGdrSONdHuPynt24oQrrPezV/ZODPP\n" +
                "8hG1WpBF0rASUS3aZ+Bzi4XiyBAGlkycnS5VtsnHTh1QiASwhi+ZAkEAw0U58X9W\n" +
                "RZdoGjKD9ASDLSGxaipcCR6CErOb/m2IaNndU+Q2oQ+GjI7I5+bUUHIyr7L+BCw7\n" +
                "ILrNBl+dZxD0lA==";
        PrivateKey privateKey = RSA.loadPrivateKey(priKey);
        Signature signature = Signature.getInstance("SHA1withRSA");
        signature.initSign(privateKey);
        signature.update(data.getBytes());
        byte[] bytes = signature.sign();
        return Base64.encode(bytes);
    }

    ///////////////////////////////////////////////////////////////////////////
    // 测试方法
    ///////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) throws Exception {
        /** 初始化 */
        /*
        // 模数
        final String MODULUS = "107313014787453253829513673985053918726593068988221496468690790790802075050722805681779868076020008707138640388406561" +
                "068474396154327072223704660330307918588647384313038984599338136855776599433735821877968427797411779108082005780044235264787430800389" +
                "781402472437269446693342945094190149098376175320612555505261";
        // 公钥指数
        final String EXPONENT_PUBLIC = "65537";
        // 私钥指数
        final String EXPONENT_PRIVATE = "825630839314123009077580369817719561474018603922075208652261631330976735005805164729344417371726029423279143" +
                "943762397148880174999386550446867629457373067125297824799565849115055482890092858954479969385576382410003319025033705676588412117911" +
                "87830923546955842844428915263387790024344591831863514724691718478017";
        */

        final String PEM_PUBLIC = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCY0Z0/0k8GbrD+SbRZHnsWyjoX3d0sf5Xm4593wasw0epVAkpndcuGQeWnZVIeV02AW3JTjNbi9t" +
                "YE1SOgOJLDsL1Q3YgaEr48sj0Gsmpd7iaN6ylyM3gsKHdTpu7qXAvC1+i5ePSFT0cH7vZbuK3vgsH3/osUNCduCJoYiky+bQIDAQAB";
        final String PEM_PRIVATE = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJjRnT/STwZusP5JtFkeexbKOhfd3Sx/lebjn3fBqzDR6lUCSmd1y4ZB5adlUh5XT" +
                "YBbclOM1uL21gTVI6A4ksOwvVDdiBoSvjyyPQayal3uJo3rKXIzeCwod1Om7upcC8LX6Ll49IVPRwfu9lu4re+Cwff+ixQ0J24ImhiKTL5tAgMBAAECgYB1kuA/GBmAw20dV" +
                "6uP3WmqURB9CE+ASvET4RDx3GlPeFGn8ck47GIX+18reULC4TxZgwHk0jkKCgsDUNDGFoCjJpG2KZOmEbtQmawMjoAjcRVJWpeDT+uydiDtt73QAmnGga9kqtnyX+eSBRLoc" +
                "zthCCcPJjLWD1IZyxBAqXyYwQJBAOegDBPq+rYmBKhAiA+Cmwhnr7a49H6E2t+5XtItTrzl4vHz1b/qait+8QoK260IO+TgxkFiHFCVbb1mzFY1ioUCQQCo5oiHzgHQ2rKJE" +
                "v7U4ZkTankwxPHf+BaNdZExltlzNh3nNMIe+bDBAtKActbNmGC6xKdziALgBpEbwl+ErczJAkBkGAzAGr5nMny2vNRPZ5BZjH0piDnX5s+y+KdaSkwJY4q0JjwLqGBjFYNSZ" +
                "KjT2IgRe3URUjWMOVboD2FkK9UFAkB8XUMqvAWaQ24ygEojdfnA0iVqQ5nV0FbK0kaWvPxgWPirxa0qIbCEbg+RhP2lZQ3Ud/jUmNGFI1C1n+m1SEQBAkBll/DAaDUXM+GMk" +
                "A6zUh7Uddw1wxBc3QxdVHWZsQn4GfmiQC9Z5ZXoAc6MrmYMBcxJuo9Sv/zCL4NlD7FPhn4H";
        // 加密密钥
        Key encryptKey;
        // 解密密钥
        Key decryptKey;
        /** 公钥加密，私钥解密 */
        // PEM
        encryptKey = RSA.getKey(RSA.MODE.PEM_STRING, RSA.TYPE_PUBLIC, PEM_PUBLIC);
        decryptKey = RSA.getKey(RSA.MODE.PEM_STRING, RSA.TYPE_PRIVATE, PEM_PRIVATE);
        // 模数指数
        // encryptKey = RSA.getKey(MODE.MODULUS_EXPONENT, RSA.TYPE_PUBLIC, MODULUS, EXPONENT_PUBLIC);
        // decryptKey = RSA.getKey(MODE.MODULUS_EXPONENT, RSA.TYPE_PRIVATE, MODULUS, EXPONENT_PRIVATE);

        /** 私钥加密，公钥解密 */
        // PEM
//         encryptKey = RSA.getKey(MODE.PEM_STRING, RSA.TYPE_PRIVATE, PEM_PRIVATE);
//         decryptKey = RSA.getKey(MODE.PEM_STRING, RSA.TYPE_PUBLIC, PEM_PUBLIC);
        // 模数指数
        // encryptKey = RSA.getKey(MODE.MODULUS_EXPONENT, RSA.TYPE_PRIVATE, MODULUS, EXPONENT_PRIVATE);
        // decryptKey = RSA.getKey(MODE.MODULUS_EXPONENT, RSA.TYPE_PUBLIC, MODULUS, EXPONENT_PUBLIC);

        System.out.println("\n-------------------- content --------------------");
        // 待加密字符串
        String data = "ABC";
        for (int i = 0; i < 1024; i++) {
            data += (int) (Math.random() * 10);
        }
        System.out.println("待加密内容: " + data);

        System.out.println("\n-------------------- encrypt --------------------");
        // "RSA加密"后再进行"Base64"加密
        String encrypt_base64 = Base64Encrypt(encryptKey, data);
        System.out.println("Base64加密后: " + encrypt_base64);
        // "RSA加密"后再进行"BCD"加密
        String encrypt_bcd = BCDEncrypt(encryptKey, data);
        System.out.println("BCD加密后: " + encrypt_bcd);

        System.out.println("\n-------------------- decrypt --------------------");
        // "Base64"解密后再进行"RSA解密"
        System.out.println("Base64解密后: " + Base64Decrypt(decryptKey, encrypt_base64));
        // "BCD"解密后再进行"RSA解密"
        System.out.println("BCD解密后: " + BCDDecrypt(decryptKey, encrypt_bcd));

        System.out.println("\n-------------------- test --------------------");
        // 待解密字符串
        String dec = "AAA";
        System.out.println("解密结果: " + BCDDecrypt(decryptKey, dec));
    }
}
