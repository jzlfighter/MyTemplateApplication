package com.example.administrator.mytemplateapplication.network.utils;

import android.text.TextUtils;

import com.example.administrator.mytemplateapplication.network.annotation.SerializedEncryption;
import com.example.administrator.mytemplateapplication.network.annotation.SerializedIgnore;
import com.example.administrator.mytemplateapplication.network.annotation.SerializedTrim;
import com.example.administrator.mytemplateapplication.tools.encryption.Base64;
import com.example.administrator.mytemplateapplication.tools.encryption.MDUtil;
import com.example.administrator.mytemplateapplication.tools.encryption.RSAUtil;
import com.google.gson.annotations.SerializedName;

import java.io.File;
import java.lang.reflect.Field;
import java.security.Key;

import static com.example.administrator.mytemplateapplication.tools.encryption.RSAUtil.BCDEncrypt;


@SuppressWarnings("unused")
public class SerializedUtil {
    // RSA 加密密钥
    private static Key RSA_KEY = null;

    /**
     * 密钥初始化
     */
    public static void init(Key key) {
        RSA_KEY = key;
    }

    /**
     * 转换成服务器可解析的请求
     *
     * @param args
     *         请求内容
     */
    public static Object[] convertToRequestContent(Object args, Field field) throws Exception {
        SerializedIgnore serializedIgnore = field.getAnnotation(SerializedIgnore.class);
        if (null != serializedIgnore) {
            return null;
        }

        SerializedName serializedName = field.getAnnotation(SerializedName.class);
        String         key;
        if (null != serializedName) {
            key = serializedName.value();
        } else {
            key = field.getName();
        }

        Object obj = field.get(args);
        if (TextUtils.isEmpty(key) || null == obj) {
            return null;
        }

        if (obj instanceof File) {
            return new Object[]{key, obj};
        } else {
            String         value          = obj.toString();
            SerializedTrim serializedTrim = field.getAnnotation(SerializedTrim.class);
            if (null != serializedTrim) {
                value = value.replaceAll("\\s*", "");
            }

            SerializedEncryption serializedEncryption = field.getAnnotation(SerializedEncryption.class);
            if (null != serializedEncryption) {
                if (null != RSA_KEY && serializedEncryption.type().equals("RSA-Base64")) {
                    value = RSAUtil.Base64Encrypt(RSA_KEY, value);
                } else if (null != RSA_KEY && serializedEncryption.type().equals("RSA-BCD")) {
                    value = BCDEncrypt(RSA_KEY, value);
                } else if (serializedEncryption.type().equals("MD5")) {
                    value = MDUtil.encode(MDUtil.TYPE.MD5, value).toUpperCase();
                } else {
                    value = Base64.encode(value.getBytes());
                }
            }
            return new Object[]{key, value};
        }
    }
}
