package com.bortni.web.commands;

import com.bortni.dao.mysql.MySqlCruiseDao;
import com.bortni.exceptions.EmailAlreadyExistException;
import com.bortni.exceptions.UserDoesNotExist;
import com.bortni.model.User;
import com.bortni.service.UserService;
import com.bortni.web.Routes;
import com.bortni.web.Servlet;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpUserCommand implements Command{
    private final Logger LOGGER = Logger.getLogger(MySqlCruiseDao.class);
    private UserService userService;

    public SignUpUserCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void getPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String password = request.getParameter("password");

        try {
            userService.isEmailExist(email);
            User user = new User();
            user.setEmail(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPassword(password);
            userService.createUser(user);
            request.getRequestDispatcher(Routes.SIGN_IN.getRoute() + "?emailExist=false").forward(request,response);
        }
        catch (EmailAlreadyExistException e){
            request.getRequestDispatcher(Routes.SIGN_UP.getRoute() + "?emailExist=true").forward(request, response);
        }

    }
}
