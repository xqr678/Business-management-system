package com.iweb.filter;

import com.iweb.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author JDP
 * @date 2022/8/12 16:14
 * @description 类的描述和介绍
 */
@WebFilter(urlPatterns = {"/*"})
public class C_AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //登陆验证
        //session校验
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
        //获取uri，只有根据uri才能判断用户访问什么
        //判断访问的请求是否是登录界面本身，或者是访问登录的提交路径
        //比如我们的登陆页面是login.html 表单提交路径是/login
        //这两个路径过滤器不可以拦截，否则永远无法访问任何路径
        String uri = req.getRequestURI();
        if (uri.endsWith("login.html")||uri.endsWith("login")) {
            chain.doFilter(req,resp);
            return;
        }

        User user = (User)req.getSession().getAttribute("user");
        if (user!=null){
            if (user.getUsername()==null){

                resp.sendRedirect("login.html");
                return;
            }
        }
        chain.doFilter(req,resp);
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}
