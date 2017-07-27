package com.gjy.service.user;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gjy.mapper.UserAdminMapper;
import com.gjy.model.UserAdmin;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

/**
 * ClassName:UserService
 *
 * @author ty
 * @description User 表数据服务层接口实现类
 * @create 2017/7/7 15:33
 **/
@Service
public class UserAdminService extends ServiceImpl<UserAdminMapper, UserAdmin>{


}
