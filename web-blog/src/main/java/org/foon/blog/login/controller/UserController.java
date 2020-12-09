package org.foon.blog.login.controller;

import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.foon.blog.login.entity.BUser;
import org.foon.blog.login.filter.JwtUtils;
import org.foon.blog.login.service.impl.BUserServiceImpl;
import org.foon.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @Description <What does this class do>
 * @DATE 2020/9/28 15:19
 * @Author ahuan
 * @ProjectName AlibabaCloud-Blog
 * @Email a1875884755@gmail.com
 * @Version 1.0
 */
@RestController
public class UserController {

    @Autowired
    private BUserServiceImpl bUserService;

    @Autowired
    JwtUtils jwtUtils;

    @GetMapping("/user/test")
    public Object test(){
        return Result.success("asdad");
    }

    @PostMapping("/user/save")
    public Result save(@RequestBody BUser user){
        String s = SecureUtil.md5(user.getPwd());
        System.out.println(s);
        user.setPwd(s);
        bUserService.save(user);
        return Result.success(user);
    }


    @PostMapping("/user/login")
    public Result login(@RequestBody BUser bUser, HttpServletResponse response){
        BUser user = bUserService.getOne(new QueryWrapper<BUser>().eq("name", bUser.getName()));
        Assert.notNull(user,"用户不存在");
        if(!user.getPwd().equals(SecureUtil.md5(bUser.getPwd()))) {
            return Result.fail("密码错误！");
        }

        String jwt = jwtUtils.generateToken(bUser.getId());
        response.setHeader("Authorization", jwt);
        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        // 用户可以另一个接口
        return Result.success(MapUtil.builder()
                .put("id", user.getId())
                .put("username", user.getName())
                .put("mobile",user.getMobile())
                .map()
        );
    }
    // 退出
    @GetMapping("/user/logout")
//    @RequiresAuthentication
    public Result logout() {
        SecurityUtils.getSubject().logout();
        return Result.success(null);
    }
}
