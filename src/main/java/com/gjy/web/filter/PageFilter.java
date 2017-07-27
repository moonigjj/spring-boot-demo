package com.gjy.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * ClassName:PageFilter
 *
 * @author ty
 * @description 分页Filter，用于获取offSet和pageSize的值
 * @create 2017/7/11 14:12
 **/
public class PageFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
    }

    @Override
    public void destroy() {

    }


}
