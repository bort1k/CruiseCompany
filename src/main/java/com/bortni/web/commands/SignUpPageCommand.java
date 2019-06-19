package com.bortni.web.commands;

import com.bortni.model.User;
import com.bortni.util.ForwardUserUtil;
import com.bortni.util.Routes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpPageCommand implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SignedUserRedirect.redirectSignedUser(Routes.SIGN_UP.getRoute(), request, response);
    }
}
