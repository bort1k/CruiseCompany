package com.bortni.util;

import com.bortni.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ForwardUserUtil {
    public static void forwardSignedInUser(User user, String page, HttpServletRequest request, HttpServletResponse response) throws IOException {
        switch (user.getRole()){
            case ADMIN:
                response.sendRedirect("/eden-cruises" + UrlPath.ADMIN.getPath());
                break;
            case USER:
                response.sendRedirect("/eden-cruises" + page);
                break;
        }
    }
}
