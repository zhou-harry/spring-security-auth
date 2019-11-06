package com.harry.security.app.config;

import com.harry.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import static com.harry.security.core.constant.SecurityConstants.BASE_OAUTH2_AUTHORIZE;
import static com.harry.security.core.constant.SecurityConstants.BASE_SSO_LOGIN;

@Configuration
@Order(1)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;
    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.requestMatchers()
                .antMatchers(BASE_SSO_LOGIN, BASE_OAUTH2_AUTHORIZE)
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll();

    }

    /**
     * 用户认证信息获取的三种方式
     * auth.jdbcAuthentication()
     * auth.inMemoryAuthentication()
     * auth.userDetailsService()
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    /**
     * 表单通用配置
     *
     * @param http
     * @throws Exception
     */
    protected void applyPasswordAuthConfig(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage(securityProperties.getBrowser().getLoginPage())
                .loginProcessingUrl(securityProperties.getBrowser().getSigninProcessUrlForm())
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler);
    }

    /**
     * 需要配置这个支持password模式
     * support password grant type
     * @return
     * @throws Exception
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
