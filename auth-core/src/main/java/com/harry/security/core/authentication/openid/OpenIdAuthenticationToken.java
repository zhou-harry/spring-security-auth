package com.harry.security.core.authentication.openid;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author harry
 * @version 1.0
 * @title: OpenIdAuthenticationToken
 * @description: OpenId认证Token
 * @date 2019/5/20 11:02
 */
public class OpenIdAuthenticationToken extends AbstractAuthenticationToken {

    private static final long serialVersionUID = 1L;

    // ~ Instance fields
    // ================================================================================================
    private final Object principal;//OpenId
    private String providerId;//服务提供商

    // ~ Constructors
    // ===================================================================================================

    /**
     * This constructor can be safely used by any code that wishes to create a
     * <code>UsernamePasswordAuthenticationToken</code>, as the {@link #isAuthenticated()}
     * will return <code>false</code>.
     */
    public OpenIdAuthenticationToken(Object openId, String providerId) {
        super(null);
        this.principal = openId;
        this.providerId = providerId;
        setAuthenticated(false);
    }

    /**
     * This constructor should only be used by <code>AuthenticationManager</code> or
     * <code>AuthenticationProvider</code> implementations that are satisfied with
     * producing a trusted (i.e. {@link #isAuthenticated()} = <code>true</code>)
     * authentication token.
     *
     * @param openId
     * @param authorities
     */
    public OpenIdAuthenticationToken(Object openId, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = openId;
        super.setAuthenticated(true); // must use super, as we override
    }

    // ~ Methods
    // ========================================================================================================
    public Object getPrincipal() {
        return this.principal;
    }

    public String getProviderId() {
        return this.providerId;
    }

    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if (isAuthenticated) {
            throw new IllegalArgumentException(
                    "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        }

        super.setAuthenticated(false);
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
    }

    @Override
    public Object getCredentials() {
        return null;
    }

}
