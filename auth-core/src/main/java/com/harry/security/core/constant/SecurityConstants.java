package com.harry.security.core.constant;

/**
 * @author zhouhong
 * @version 1.0
 * @title: SecurityConstants
 * @description: TODO
 * @date 2019/11/6 15:29
 */
public class SecurityConstants {

    /**
     * 默认表单身份认证地址
     */
    public final static String DEFAULT_AUTH_REQUIRE = "/auth/require";

    /**
     * 默认注册页面url
     */
    public static final String DEFAULT_SIGNUP_PAGE_URL = "/signUp.html";
    /**
     * 默认的用户名密码登录请求处理url
     */
    public final static String DEFAULT_SIGNIN_PROCESS_URL_FORM = "/auth/form";
    /**
     * 默认的手机验证码登录请求处理url
     */
    public final static String DEFAULT_SIGNIN_PROCESS_URL_MOBILE = "/auth/mobile";
    /**
     * 默认的openid登陆请求处理url
     */
    public static final String DEFAULT_SIGNIN_PROCESS_URL_OPENID = "/auth/openId";
    /**
     * App端默认注册跳转路径
     */
    public static final String DEFAULT_APP_SOCIAL_INFO = "/social/signup";
    /**
     * Web端第三方注册绑定信息
     */
    public static final String DEFAULT_WEB_SOCIAL_INFO = "/info";
    /**
     * 默认的验证码请求的前缀
     */
    public static final String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/verifyCode";
    /**
     * 验证码存储键
     */
    public static final String SESSION_KEY_IMAGE = "SESSION_KEY_IMAGE_CODE";
    public static final String SESSION_KEY_SMS = "SESSION_KEY_SMS_CODE";
    /**
     * 验证图片验证码时，http请求中默认的携带图片验证码信息的参数的名称
     */
    public static final String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "imageCode";
    /**
     * 验证短信验证码时，http请求中默认的携带短信验证码信息的参数的名称
     */
    public static final String DEFAULT_PARAMETER_NAME_CODE_SMS = "smsCode";
    /**
     * 图片验证码处理器实例名
     */
    public static final String DEFAULT_IMAGE_CODE_PROCESSOR = "imageCodeProcessor";
    /**
     * 短信验证码处理器实例名
     */
    public static final String DEFAULT_SMS_CODE_PROCESSOR = "smsCodeProcessor";

    /**
     * 默认的Social UserConnection表名的前缀
     */
    public static final String DEFAULT_SOCIAL_USER_CONNECTION_PREFIX = "t_";
    /**
     * SocialAuthenticationFilter默认的处理路径
     */
    public static final String DEFAULT_FILTER_PROCESSES_URL = "/auth";
    /**
     * 社交登陆时， 传递的openId参数名
     */
    public static final String DEFAULT_REQUEST_PARAMETER_OPENID = "openId";
    /**
     * 社交登陆时，传递的providerId参数名
     */
    public static final String DEFAULT_REQUEST_PARAMETER_PROVIDERID = "providerId";

    /**
     * 默认OAuth2签名
     */
    public static final String DEFAULT_OAUTH2_SIGNING_KEY = "harry";
    /**
     * 默认OAuth2 Token存储方式(jwt/redis)
     */
    public static final String DEFAULT_OAUTH2_STORETYPE = "jwt";
    /**
     * 自定义实现SpringSocialConfigurer名称
     */
    public static final String BASE_SOCIAL_CONFIGURER = "baseSocialConfigurer";
    /**
     * SSO 授权认证请求地址
     */
    public static final String BASE_OAUTH2_AUTHORIZE = "/oauth/authorize";
    /**
     * SSO登录默认地址
     */
    public static final String BASE_SSO_LOGIN = "/login";

    //获取QQ 授权码地址
    public static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";
    //获取QQ Token地址
    public static final String URL_ACCESSTOKEN = "https://graph.qq.com/oauth2.0/token";
    //获取QQ OPENID地址
    public static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";
    //获取QQ 用户信息地址
    public static final String URL_GET_USERINFO = "https://graph.qq.com/user/get_user_info?&oauth_consumer_key=%s&openid=%s";

    public final static String[] MATCHERS = {
            BASE_SSO_LOGIN,
            DEFAULT_AUTH_REQUIRE,
            DEFAULT_SIGNIN_PROCESS_URL_MOBILE,
            DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
            BASE_OAUTH2_AUTHORIZE
    };

}
