package com.harry.security.app.controller;

import com.harry.security.core.constant.SecurityConstants;
import com.harry.security.core.domain.BaseSecurityResponse;
import com.harry.security.core.properties.SecurityProperties;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@AllArgsConstructor
public class BaseSecurityController {

    //当需要身份认证时，跳转到这里
    @RequestMapping(SecurityConstants.DEFAULT_AUTH_REQUIRE)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED) //不是html请求时，返回401状态码
    public BaseSecurityResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return new BaseSecurityResponse("访问的服务需要身份认证");
    }

}
