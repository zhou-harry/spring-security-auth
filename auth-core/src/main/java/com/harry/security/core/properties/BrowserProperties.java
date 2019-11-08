package com.harry.security.core.properties;

import com.harry.security.core.constant.SecurityConstants;

/**
 * @author harry
 * @version 1.0
 * @title: BrowserProperties
 * @description: 表单属性配置
 * @date 2019/5/11 23:45
 */
public class BrowserProperties {

    //表单身份认证地址
    private String authRequire = SecurityConstants.DEFAULT_AUTH_REQUIRE;
    //用户名密码登录请求处理url
    private String signinProcessUrlForm = SecurityConstants.DEFAULT_SIGNIN_PROCESS_URL_FORM;
    //手机验证码登录请求处理url
    private String signinProcessUrlMobile = SecurityConstants.DEFAULT_SIGNIN_PROCESS_URL_MOBILE;
    //OpenID认证登录请求处理url
    private String signinProcessUrlOpenId = SecurityConstants.DEFAULT_SIGNIN_PROCESS_URL_OPENID;
    //social注册页面
    private String signUpUrl = SecurityConstants.DEFAULT_SIGNUP_PAGE_URL;
    //自定义需要放行认证的地址
    private String[] permitUrl = {};

    public String getSigninProcessUrlForm() {
        return signinProcessUrlForm;
    }

    public void setSigninProcessUrlForm(String signinProcessUrlForm) {
        this.signinProcessUrlForm = signinProcessUrlForm;
    }

    public String getSigninProcessUrlMobile() {
        return signinProcessUrlMobile;
    }

    public void setSigninProcessUrlMobile(String signinProcessUrlMobile) {
        this.signinProcessUrlMobile = signinProcessUrlMobile;
    }

    public String getAuthRequire() {
        return authRequire;
    }

    public void setAuthRequire(String authRequire) {
        this.authRequire = authRequire;
    }

    public String getSigninProcessUrlOpenId() {
        return signinProcessUrlOpenId;
    }

    public void setSigninProcessUrlOpenId(String signinProcessUrlOpenId) {
        this.signinProcessUrlOpenId = signinProcessUrlOpenId;
    }

    public String[] getPermitUrl() {
        return permitUrl;
    }

    public void setPermitUrl(String[] permitUrl) {
        this.permitUrl = permitUrl;
    }

    public String getSignUpUrl() {
        return signUpUrl;
    }

    public void setSignUpUrl(String signUpUrl) {
        this.signUpUrl = signUpUrl;
    }
}
