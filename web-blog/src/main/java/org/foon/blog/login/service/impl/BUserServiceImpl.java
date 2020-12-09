package org.foon.blog.login.service.impl;

import org.foon.blog.login.entity.BUser;
import org.foon.blog.login.mapper.BUserMapper;
import org.foon.blog.login.service.IBUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ahuan
 * @since 2020-09-25
 */
@Service
public class BUserServiceImpl extends ServiceImpl<BUserMapper, BUser> implements IBUserService {

}
