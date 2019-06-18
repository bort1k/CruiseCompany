package com.bortni.web.commands;

import com.bortni.web.Routes;
import com.bortni.web.UrlPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogOutCommand implements Command{
    @Override
    public void getPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("userSession");
        request.getSession().invalidate();
        response.sendRedirect("/eden-cruises" + UrlPath.HOME.getPath());
    }
}
