package org.seminify.spring5fs.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession httpSession = request.getSession(false);
        if (httpSession != null && httpSession.getAttribute("authInfo") != null)
            return true;
        response.sendRedirect(request.getContextPath() + "/login");
        return false;
    }
}
