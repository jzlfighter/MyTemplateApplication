package com.example.administrator.mytemplateapplication;

import android.os.Environment;

import java.io.File;

public class Constant {
    public static final String SIGNA             = "signMsg";
    public static final String MOBILE_TYPE       = "mobileType";
    public static final String VERSION_NUMBER    = "versionNumber";
    // 登录参数
    public static final String TOKEN             = "token";
    public static final String USER_ID           = "userId";


    public static final String URL_TEST="";

    public static final String URI_AUTHORITY_BETA = "";//预发服务器
    /** 正式服务器地址 */
    public static final String  URI_AUTHORITY_RELEASE = "";
    /**
     * 是否使用RAP MOCK服务
     */
    private static final boolean IS_RAP = false;
    /**
     * RAP服务器地址
     */
    private static final String URI_AUTHORITY_RAP = "";
    /**
     * 服务器地址
     */
    public static final String URI_AUTHORITY = BuildConfig.DEBUG ? (IS_RAP ? URI_AUTHORITY_RAP : URI_AUTHORITY_BETA) : URI_AUTHORITY_RELEASE;
    /**
     * 模块名称("接口地址"会拼接在 URL 中最后的"/"之后，故URL必须以"/"结尾)
     */
    private static final String URI_PATH = "/api/";
    /**
     * 请求地址
     */
    public static final String URI = URI_AUTHORITY + (IS_RAP ? "80/api/" : URI_PATH);
    /**
     * 根路径
     */
    public static final String ROOT_PATH = getSDPath() + "/xjmd";
    /**
     * SP文件名
     */
    public static final String SP_NAME = "sp_file";

    /**
     * 获取SD卡的根目录
     */
    public static String getSDPath() {
        File sdDir = null;
        // 判断sd卡是否存在
        boolean sdCardExist = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        if (sdCardExist) {
            // 获取跟目录
            sdDir = Environment.getExternalStorageDirectory();
        }
        if (sdDir == null) {
            return "";
        } else {
            return sdDir.toString();
        }
    }


    /**
     * 是否是debug模式
     */
    public static final boolean IS_DEBUG = false;
    /**
     * 测试服务器地址
     */
    //public static final String  URI_AUTHORITY_BETA = "192.168.21.94";//测试服务器

    /**数据采集接口预发*/
    public static final String USER_INFO_COLLECT = "";
    /**
     * app_key
     */
    public static final String APP_KEY = "";
}
