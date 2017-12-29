package com.example.administrator.mytemplateapplication;

import android.os.Environment;

import java.io.File;

/**
 * Author: TinhoXu
 * E-mail: xth@erongdu.com
 * Date: 2016/2/18 16:23
 * <p/>
 * Description: 常量类
 */
public class Constant {
    /** number */
    public static final int    NUMBER__2         = -2;
    public static final int    NUMBER__1         = -1;
    public static final int    NUMBER_0          = 0;
    public static final int    NUMBER_1          = 1;
    public static final int    NUMBER_2          = 2;
    public static final int    NUMBER_3          = 3;
    public static final int    NUMBER_4          = 4;
    public static final int    NUMBER_5          = 5;
    public static final int    NUMBER_6          = 6;
    public static final int    NUMBER_7          = 7;
    public static final int    NUMBER_8          = 8;
    public static final int    NUMBER_9          = 9;
    public static final int    NUMBER_10         = 10;
    public static final int    NUMBER_20         = 20;
    /** status */
    public static final String STATUS__2         = "-2";
    public static final String STATUS__1         = "-1";
    public static final String STATUS_0          = "0";
    public static final String STATUS_1          = "1";
    public static final String STATUS_2          = "2";
    public static final String STATUS_3          = "3";
    public static final String STATUS_4          = "4";
    public static final String STATUS_5          = "5";
    public static final String STATUS_6          = "6";
    public static final String STATUS_7          = "7";
    public static final String STATUS_8          = "8";
    public static final String STATUS_9          = "9";
    public static final String STATUS_10         = "10";
    public static final String STATUS_20         = "20";
    public static final String STATUS_21         = "21";
    public static final String STATUS_22         = "22";
    public static final String STATUS_23         = "23";
    public static final String STATUS_24         = "24";
    public static final String STATUS_25         = "25";
    public static final String STATUS_26         = "26";
    public static final String STATUS_27         = "27";
    public static final String STATUS_28         = "28";
    public static final String STATUS_29         = "29";
    public static final String STATUS_30         = "30";
    public static final String STATUS_40         = "40";
    public static final String STATUS_50         = "50";
    /** 符号 */
    public static final String SYMBOL_PLUS       = "+";
    public static final String SYMBOL_MINUS      = "-";
    /** true or false */
    public static final String TRUE              = "true";
    public static final String FALSE             = "false";
    /** network params */
    // 公共参数
//    public static final String APP_KEY           = "appkey";
    public static final String SIGNA             = "signMsg";
    public static final String TS                = "ts";
    public static final String MOBILE_TYPE       = "mobileType";
    public static final String VERSION_NUMBER    = "versionNumber";
    // SP 字段
    public static final String IS_LAND           = "isLand";
    public static final String IS_FIRST_IN       = "isFirstIn";
    public static final String IS_GESTURE_OPENED = "isGestureOpened";
    // 登录参数
    public static final String TOKEN             = "token";
    public static final String REFRESH_TOKEN     = "refreshToken";
    public static final String USER_ID           = "userId";


    public static final String URL_TEST="http://api.jiexinka.com/api/";

    public static final String URI_AUTHORITY_BETA = "http://api.jiexinka.com/";//预发服务器
    //public static final String URI_AUTHORITY_RELEASE = "http://192.168.21.94:8080/";
    /** 正式服务器地址 */
    public static final String  URI_AUTHORITY_RELEASE = "http://api.jiexinka.com/";
    /**
     * 是否使用RAP MOCK服务
     */
    private static final boolean IS_RAP = false;
    /**
     * RAP服务器地址
     */
    private static final String URI_AUTHORITY_RAP = "http://rap.erongdu.erongyun.net/mockjsdata/";
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
    //public static final  PaymentType paymentType           = PaymentType.PNR;
    /**
     * 转让专区uuid
     */
    public static final String TRANSFER_ZONE = "a31bd335e12ac0dced8849a16fd4a894";
    /**
     * 变现uuid
     */
    public static final String REALIZATION = "090d5d939784fe33aceff143ba1c198c";
    /**
     * 加密是需要使用的密钥
     * DES加解密时KEY必须是16进制字符串,不可小于8位
     * E.G.    6C4E60E55552386C
     * <p/>
     * 3DES加解密时KEY必须是6进制字符串,不可小于24位
     * E.G.    6C4E60E55552386C759569836DC0F83869836DC0F838C0F7
     */
    public static final String SECRET_KEY = "6C4E60E55552386C759569836DC0F83869836DC0F838C0F7";
    /**
     * 根路径
     */
    public static final String ROOT_PATH = getSDPath() + "/xjmd";
    /**
     * 照片文件文件保存路径
     */
    public static final String PHOTO_PATH = ROOT_PATH + "/photo";
    /**
     * 照片-活体识别
     */
    public static String PHOTO_ALIVE = "alive";
    /**
     * 照片-正面
     */
    public static String PHOTO_FRONT = "front";
    /**
     * 照片-反面
     */
    public static String PHOTO_BACK = "back";
    /**
     * 照片-头像
     */
    public static String PHOTO_AVATAR = "avatar";
    /**
     * SP文件名
     */
    public static final String SP_NAME = "sp_file";
    /**
     * 数据库名称
     */
    public static final String DATABASE_NAME = "stanley_db";
    /**
     * 发送验证码的短信平台号
     */
    public static final String SMS_SENDER = "";
    /**
     * 活体识别
     */
    public static final String ALIVE_APPID = "cc2dd02b62f142a6b44a690661de06b4";
    public static final String ALIVE_SECRET = "dc0eb0c5d0ad47648e347ca782d182cb";
    /**
     * 人证列表展示类别 下标 0个人信息 1工作信息 2紧急联系人 3银行卡 4芝麻授信 5 手机运营商 6支付宝人证 7更多信息
     */
    /**
     * 认证列表展示是否必填类别 下标 0个人信息 1工作信息 2紧急联系人 3银行卡 4芝麻授信 5 手机运营商 6支付宝人证 7更多信息
     */
    public static final boolean[] CREDIT_MUST =
            new boolean[]{CreditTypeFlag.PERSON_MUST_FLAG, CreditTypeFlag.BANK_MUST_FLAG, CreditTypeFlag.LINKER_MUST_FLAG,
                    CreditTypeFlag.PHONE_MUST_FLAG, CreditTypeFlag.ZMXY_MUST_FLAG, CreditTypeFlag.WORK_MUST_FLAG, CreditTypeFlag.ZFB_MUST_FLAG,
                    CreditTypeFlag.MORE_MUST_FLAG};
    //是否为运营商人证
    public static boolean isPhoneState = false;
    public static String phoneStateUrl = "";
    //连连签约接口
    public static String authSign = "act/mine/bankCard/authSign.htm";

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


//    public static final String  URI_AUTHORITY_RELEASE = "http://api-simu.hzmayidai.com/";
    /**数据采集接口测试*/
    //public static final String USER_INFO_COLLECT = "";
    /**数据采集接口预发*/
    public static final String USER_INFO_COLLECT = "";
    /**
     * app_key
     */
    public static final String APP_KEY = "fzZN2nBYgpjGfHGxwY6GA8UAaHNjR3qKK1dbhVxPAcHlIa0kalAfBJ82OS58";
    /**
     * app_secret
     */
    public static final String APP_SECRET = "";
    /**
     * 微信分享Key
     **/
    public final static String WX_APP_ID = "wxa04dd3100599e647";
    public final static String WX_APP_SECRET = "723e88df9cfb1cc131aecd28a8aa356c";
    /**
     * 小视账号密码
     **/
    public static final String REGARD_ACCOUNT = "";
    public static final String REGARD_PASSWORD = "";
    /**
     * QQKey
     **/
    public static final String QQ_ID = "1106296187";
    public static final String QQ_APP_KEY = "NP9GstpsSgNkd1Df";
    /**
     * 新浪分享Key
     **/
    public static final String SINA_APP_ID = "";
    public static final String SINA_APP_SECRET = "";
    /**
     * 引导页数量
     */
    public static final int GUIDE_COUNT = 4;
    /**
     * 首页下标
     */
    public static final int HOME_INDEX_NUM = 2;
    /**
     * 认证中心下标
     */
    public static final int CREDIT_CENTER_INDEX_NUM = 1;
    /**
     * 人像识别方案
     */
    public static final int IDENTIFICATION_TYPE = 1;

    /**
     * 盾人脸识别的key
     */
    public static final String AUTH_KEY = "859e7efb-ef0d-40c9-8540-a1b60a560196";
}
