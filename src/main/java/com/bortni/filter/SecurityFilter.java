package com.bortni.filter;

import com.bortni.model.User;
import com.bortni.util.ForwardUserUtil;
import com.bortni.util.SecurityUtils;
import com.bortni.util.UrlPath;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String path = request.getPathInfo();
        User signedInUser = (User) request.getSession().getAttribute("userSession");

        if(UrlPath.SIGN_IN.getPath().equals(path) && signedInUser != null){
            ForwardUserUtil.forwardSignedInUser(signedInUser,UrlPath.USER_PROFILE.getPath(), request, response);
            return;
        }

        if(SecurityUtils.isSecurityPage(request)){
            if(signedInUser != null && SecurityUtils.hasPermission(request,signedInUser.getRole())){
                filterChain.doFilter(request, response);
            }
            else{
                request.getRequestDispatcher("/403").forward(request, response);
            }
        }
        else {
            filterChain.doFilter(request, response);
        }


    }

    @Override
    public void destroy() {

    }
}
