package com.example.mybatisplustest.havetry.filter;

import org.springframework.context.annotation.ComponentScan;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*@WebFilter(urlPatterns = "*.do")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       *//* HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        System.out.println("进入LoginFilter过滤器");
        String path = httpRequest.getServletPath();
        System.out.println(path);
        if("/login.do".equals(path)){
            chain.doFilter(httpRequest,httpResponse);
        }else{
            String ENAME = (String) httpRequest.getSession().getAttribute("ENAME");
            if (ENAME != null) {
                chain.doFilter(httpRequest, httpResponse);
            } else {
                httpResponse.sendRedirect("/");
            }
        }*//*
    }
    @Override
    public void destroy() {
     }
}*/
