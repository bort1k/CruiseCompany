package com.bortni.web.commands;

import com.bortni.model.User;
import com.bortni.util.ForwardUserUtil;
import com.bortni.util.Routes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class SignedUserRedirect {
    static void redirectSignedUser(String page, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = (User)request.getSession().getAttribute("userSession");
        if(user != null){
            ForwardUserUtil.forwardSignedInUser(user, request, response);
        }
        else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}
