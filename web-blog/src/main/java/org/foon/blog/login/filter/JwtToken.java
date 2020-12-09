package org.foon.blog.login.filter;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Description <What does this class do>
 * @DATE 2020/9/27 11:20
 * @Author ahuan
 * @ProjectName AlibabaCloud-Blog
 * @Email a1875884755@gmail.com
 * @Version 1.0
 */
public class JwtToken implements AuthenticationToken {
    private String token;

    public JwtToken(String token){
        this.token = token;
    }
    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
