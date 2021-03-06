package com.bortni.web.commands;

import com.bortni.dao.mysql.MySqlCruiseDao;
import com.bortni.exceptions.ReadException;
import com.bortni.exceptions.UserDoesNotExist;
import com.bortni.model.User;
import com.bortni.service.UserService;
import com.bortni.util.ForwardUserUtil;
import com.bortni.util.Routes;
import com.bortni.util.UrlPath;
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
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user;
        if(request.getSession().getAttribute("userSession") != null){
            user = (User)request.getSession().getAttribute("userSession");
            ForwardUserUtil.forwardSignedInUser(user, UrlPath.USER_PROFILE.getPath(), request, response);
        }
        else {
            try {
                userService.isUserExist(email, password);
            } catch (UserDoesNotExist e) {
                request.getRequestDispatcher(Routes.SIGN_UP.getRoute() + "?userExist=false").forward(request, response);
                return;
            }
        }
        try {
            user = userService.getUserByEmailAndPassword(email, password);
            request.getSession().setAttribute("userSession", user);
            String pageUrl = (String) request.getSession().getAttribute("previousPageUrl");
            if (pageUrl == null) {
                pageUrl = UrlPath.USER_PROFILE.getPath();
            }
            ForwardUserUtil.forwardSignedInUser(user, pageUrl, request, response);
        }catch (ReadException e){
            request.getRequestDispatcher("/jsp/404error.jsp").forward(request, response);
        }

    }
}
