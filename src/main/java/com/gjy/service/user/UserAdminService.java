package com.gjy.service.user;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gjy.mapper.UserAdminMapper;
import com.gjy.model.Role;
import com.gjy.model.UserAdmin;
import com.gjy.model.UserRole;
import com.gjy.service.role.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ClassName:UserService
 *
 * @author ty
 * @description User 表数据服务层接口实现类
 * @create 2017/7/7 15:33
 **/
@Service
public class UserAdminService extends ServiceImpl<UserAdminMapper, UserAdmin>{


    @Autowired
    private UserRoleService userRoleService;

    /**
     * 通过用户名查询
     * @param username 用户名
     * @return 用户对象
     */
    public UserAdmin findByName(@NotNull String username){

        return this.baseMapper.selectByName(username);
    }

    /**
     * 分页列表查询
     * @param page 分页对象
     * @param params 条件参数
     * @return
     */
    public Page<UserAdmin> findListPage(Page<UserAdmin> page, Map<String, Object> params){

        page.setRecords(this.baseMapper.selectListPage(page, params));
        return page;
    }

    /**
     *添加用户角色
     * @param roles 角色列表
     * @param user 用户对象
     * @return 是否添加成功
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean addRole(@NotNull List<Role> roles,@NotNull UserAdmin user){

        UserRole userRole;
        List<UserRole> userRoles = new ArrayList<>(roles.size());
        for (int i = 0, s = roles.size(); i < s; i++){

            userRole = new UserRole();
            userRole.setDeleted(0);
            userRole.setRoleId(roles.get(i).getId());
            userRole.setUserId(user.getId());
            userRoles.add(userRole);
        }

        return this.userRoleService.insertBatch(userRoles);
    }
}
