package com.bortni.web.commands;

import com.bortni.dao.mysql.MySqlCruiseDao;
import com.bortni.exceptions.UserDoesNotExist;
import com.bortni.model.User;
import com.bortni.service.UserService;
import com.bortni.web.Routes;
import com.bortni.web.UrlPath;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInUserCommand implements Command {
    private final Logger LOGGER = Logger.getLogger(MySqlCruiseDao.class);
    private UserService userService;

    public SignInUserCommand(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void getPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user;
        if(request.getSession().getAttribute("userSession") != null){
            user = (User)request.getSession().getAttribute("userSession");
            forwardSignedInUser(user, request, response);
        }
        else {
            try {
                userService.isUserExist(email, password);
            } catch (UserDoesNotExist e) {
                request.getRequestDispatcher(Routes.SIGN_UP.getRoute() + "?userExist=false").forward(request, response);
                return;
            }
        }

        user = userService.getUserByEmailAndPassword(email, password);
        request.getSession().setAttribute("userSession", user);
        forwardSignedInUser(user, request, response);
    }

    private void forwardSignedInUser(User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        switch (user.getRole()){
            case ADMIN:;
            case USER:
                response.sendRedirect("/eden-cruises" + UrlPath.HOME.getPath());
                break;
        }
    }
}