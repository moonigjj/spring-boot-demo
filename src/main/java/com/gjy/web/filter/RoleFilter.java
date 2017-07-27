package com.gjy.web.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * ClassName:RoleFilter
 *
 * @author ty
 * @description 角色过滤器,为了实现or的效果就使用这个过滤器,shiro默认是and的效果
 * @create 2017/7/19 11:47
 **/
public class RoleFilter extends RolesAuthorizationFilter {

    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {

        Subject subject = getSubject(request, response);
        String[] rolesArr = (String[]) mappedValue;
        if (null == rolesArr || rolesArr.length == 0){

            return true;
        }
        for (int i = 0, len = rolesArr.length; i < len; i++){

            if (subject.hasRole(rolesArr[i])){

                return true;
            }
        }
        return false;
    }
}
