package com.bortni.web.commands;

import com.bortni.web.Routes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpPageCommand implements Command{

    @Override
    public void getPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(Routes.SIGN_UP.getRoute()).forward(request, response);
    }
}