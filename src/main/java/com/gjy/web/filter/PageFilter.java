package com.gjy.web.filter;

import com.gjy.web.util.StrUtils;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * ClassName:PageFilter
 *
 * @author ty
 * @description 分页Filter，用于获取offSet和pageSize的值
 * @create 2017/7/11 14:12
 **/
@Order(5)
@WebFilter(filterName = "pageFilter", urlPatterns = "/*")
public class PageFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        PageContext.setOffSet(getOffset(request));
        PageContext.setPageSize(getPageSize(request));

        try {

            filterChain.doFilter(servletRequest, servletResponse);
        } finally {

            //清空ThreadLocal中的值
            PageContext.removeOffSet();
            PageContext.removePageSize();
        }
    }

    @Override
    public void destroy() {

    }

    protected int getOffset(HttpServletRequest request){

        String offset = request.getParameter("offset");
        if (StrUtils.isDigit(offset)){

            return Integer.parseInt(offset);
        } else {

            return 0;
        }
    }

    protected int getPageSize(HttpServletRequest request){

        String pageSize = request.getParameter("pageSize");
        if (StrUtils.isDigit(pageSize)){

            return Integer.parseInt(pageSize);
        } else {

            return 10;
        }
    }


}
