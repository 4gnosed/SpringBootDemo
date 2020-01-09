package com.gnosed.demo.interceptor;

import com.gnosed.demo.pojo.User;
import com.gnosed.demo.util.LoginInterceptorUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String contextPath = session.getServletContext().getContextPath();
        //是否拦截该url
        if (LoginInterceptorUtil.check(url,contextPath)) {
            //用户未登录,重定向到登录页
            if (user == null) {
                response.sendRedirect("login");
                return false;
            }
        }
        return true;
    }
}
