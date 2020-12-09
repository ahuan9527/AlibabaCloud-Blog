package org.foon.blog.login.entity;

import lombok.Data;

/**
 * @Description <What does this class do>
 * @DATE 2020/9/27 11:53
 * @Author ahuan
 * @ProjectName AlibabaCloud-Blog
 * @Email a1875884755@gmail.com
 * @Version 1.0
 */
@Data
public class BUserProfile {
    private String id;
    private BUser bUser;
    private String avater;
}
