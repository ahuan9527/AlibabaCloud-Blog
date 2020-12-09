package org.foon.blog.login.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.foon.blog.login.entity.BUser;
import org.foon.blog.login.entity.BUserProfile;
import org.foon.blog.login.filter.JwtToken;
import org.foon.blog.login.filter.JwtUtils;
import org.foon.blog.login.service.IBUserService;
import org.foon.blog.login.service.impl.BUserServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description <AccountRealm是shiro进行登录或者权限校验的逻辑所在>
 * @DATE 2020/9/25 18:44
 * @Author ahuan
 * @ProjectName AlibabaCloud-Blog
 * @Email a1875884755@gmail.com
 * @Version 1.0
 */
@Component
@Slf4j
public class AccountRealm extends AuthorizingRealm {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    IBUserService bUserService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        JwtToken jwtToken = (JwtToken) token;
        log.info("jwt===========>{}",jwtToken);
        String userID = jwtUtils.getClaimByToken((String) jwtToken.getPrincipal()).getSubject();
        BUser user = bUserService.getById(Long.parseLong(userID));
        if(user == null) {
            throw new UnknownAccountException("账户不存在！");
        }
        if(user.getStatus() == "-1") {
            throw new LockedAccountException("账户已被锁定！");
        }
        BUserProfile bUserProfile =new BUserProfile();
        BeanUtils.copyProperties(user,bUserProfile);
        log.info("buserProfile==========={}",bUserProfile);
        return new SimpleAuthenticationInfo(bUserProfile,jwtToken.getCredentials(),getName());
    }
}
