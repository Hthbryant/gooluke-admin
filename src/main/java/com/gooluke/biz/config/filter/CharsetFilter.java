package com.gooluke.biz.config.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 咕噜科
 * ClassName: CharsetFilter
 * date: 2023-08-17 22:45
 * Description:
 * version 1.0
 */

public class CharsetFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
