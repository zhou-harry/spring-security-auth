package com.harry.security.core.config;

import com.harry.security.core.authorization.repository.AuthorizeUrlRepository;
import com.harry.security.core.authorization.server.AuthorizeServer;
import com.harry.security.core.authorization.server.BaseAuthorizeServer;
import com.harry.security.core.properties.SecurityProperties;
import com.harry.security.core.validate.code.sms.DefaultSmsCodeSender;
import com.harry.security.core.validate.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @author harry
 * @version 1.0
 * @title: SecurityCoreConfig
 * @description: 认证授权主配置
 * @date 2019/5/11 17:52
 */
@ComponentScan({"com.harry.security.core"})
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {

    private final SecurityProperties securityProperties;

    private final DataSource dataSource;

    public SecurityCoreConfig(SecurityProperties securityProperties, @Qualifier("dataSource") DataSource defaultDataSource) {
        this.securityProperties = securityProperties;
        this.dataSource = defaultDataSource;
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
//        jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }


    @Bean
    @ConditionalOnMissingBean(PasswordEncoder.class)
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @ConditionalOnMissingBean(SmsCodeSender.class)
    public SmsCodeSender smsCodeSender() {
        return new DefaultSmsCodeSender();
    }


    @Bean("authorizeServer")
    @ConditionalOnBean(AuthorizeUrlRepository.class)
    public AuthorizeServer authorizeServer() {
        return new BaseAuthorizeServer();
    }

    @Bean
    public OAuth2WebSecurityExpressionHandler oAuth2WebSecurityExpressionHandler(ApplicationContext applicationContext) {
        OAuth2WebSecurityExpressionHandler expressionHandler = new OAuth2WebSecurityExpressionHandler();
        expressionHandler.setApplicationContext(applicationContext);
        return expressionHandler;
    }
}
