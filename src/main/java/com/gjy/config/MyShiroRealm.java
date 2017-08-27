package com.gjy.config;

import com.gjy.model.Role;
import com.gjy.model.RolePermission;
import com.gjy.model.UserAdmin;
import com.gjy.service.role.RolePermissionService;
import com.gjy.service.user.PermissionService;
import com.gjy.service.user.RoleService;
import com.gjy.service.user.UserAdminService;
import com.gjy.web.util.EncryptUtils;
import com.gjy.web.util.GsonUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * ClassName:MyShiroRealm
 *
 * @author ty
 * @description
 * @create 2017/7/19 11:29
 **/
public class MyShiroRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

    @Autowired
    private UserAdminService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RolePermissionService rolePermissionService;

    /**
     * 此方法调用  hasRole,hasPermission的时候才会进行回调
     * 权限信息.(授权):
     * 1、如果用户正常退出，缓存自动清空；
     * 2、如果用户非正常退出，缓存自动清空；
     * 3、如果我们修改了用户的权限，而用户不退出系统，修改的权限无法立即生效。
     * （需要手动编程进行实现；放在service进行调用）
     * 在权限修改后调用realm中的方法，realm已经由spring管理，所以从spring中获取realm实例，
     * 调用clearCached方法；
     * :Authorization 是授权访问控制，用于对用户进行的操作授权，证明该用户是否允许进行当前操作，如访问某个链接，某个资源文件等。
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        /*
        * 当没有使用缓存的时候，不断刷新页面的话，这个代码会不断执行，
        * 当其实没有必要每次都重新设置权限信息，所以我们需要放到缓存中进行管理；
        * 当放到缓存中时，这样的话，doGetAuthorizationInfo就只会执行一次了，
        * 缓存过期之后会再次执行。
        */

        UserAdmin userAdmin = (UserAdmin) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<Role> roles = this.roleService.findByUserid(userAdmin.getId());
        if (!CollectionUtils.isEmpty(roles)) {
            //设置用户角色
            Set<String> roleSet = new HashSet<>();
            Integer size = roles.size();
            final Integer[] roleIds = new Integer[size];
            IntStream.range(0, size)
                    .forEach(idx -> {

                        Role role = roles.get(idx);
                        if (Objects.nonNull(role)) {
                            roleIds[idx] = role.getId();
                            roleSet.add(role.getName());
                        }
                    });
            info.setRoles(roleSet);
            logger.info("user has roles >>> {}", GsonUtils.toJson(roleSet));

            //设置用户角色权限
            Set<String> permissionSet = new HashSet<>();
            List<RolePermission> rolePermissions = this.rolePermissionService.findByRoleIds(roleIds);
            rolePermissions.stream().filter(Objects ::nonNull)
                    .forEach(r -> {

                        permissionSet.add(r.getPermission());
                    });
            info.setStringPermissions(permissionSet);
            logger.info("user has permission >>> {}", GsonUtils.toJson(permissionSet));
        }

        return info;
    }

    /**
     * 认证信息.(身份验证)
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        String password = String.valueOf(token.getPassword());

        UserAdmin userAdmin = this.userService.findByName(username);
        if (userAdmin == null){

            throw new AccountException("帐号或密码不正确");
        }
        String pwd = EncryptUtils.md5Hex(password, userAdmin.getSalt());
        if (!pwd.equals(userAdmin.getPassword())){

            throw new AccountException("帐号或密码不正确");
        }
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自
        // 定义实现
        /*SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo(
                userAdmin.getUserName(),
                userAdmin.getPassword(),
                userAdmin.getSalt(),
                getName()
        );*/

        logger.info("身份认证成功，登录用户：" + username);
        return new SimpleAuthenticationInfo(userAdmin, password, getName());
    }

    @Override
    protected void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }
}
