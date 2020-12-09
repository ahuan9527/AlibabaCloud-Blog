package org.foon.blog.login.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 
 * </p>
 *
 * @author ahuan
 * @since 2020-09-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("b_user")
public class BUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * uuid 
     */
    private String id;

    /**
     * 用户姓名
     */
    @NotBlank(message = "用户名不能为空")
    private String name;

    /**
     * 用户密码 加密
     */
    private String pwd;

    /**
     * 用户状态 1在线 2下线
     */
    private String status;

    /**
     * 该条数据是否有效
     */
    private String effect;

    /**
     * 用户手机
     */
    private String mobile;

    /**
     * 用户头像
     */
    private String img;

    /**
     * 用户ip
     */
    private String ip;

    /**
     * 用户登录时间
     */
    private String loginTime;

    /**
     * 用户登出时间
     */
    private String logoutTime;

    /**
     * 创建时间
     */
    private String maketime;

    /**
     * 更新时间
     */
    private String modifytime;


}
