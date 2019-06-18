package com.bortni.web;

import com.bortni.model.enums.Role;
import com.bortni.service.*;
import com.bortni.util.UrlPath;
import com.bortni.web.commands.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Servlet extends HttpServlet {

    private Map<String, Command> commands;

    @Override
    public void init() {
        commands = new HashMap<>();
        ShipService shipService = new ShipService();
        PersonalService personalService = new PersonalService();
        CruiseService cruiseService = new CruiseService();
        PortService portService = new PortService();
        TourService tourService = new TourService();
        UserService userService = new UserService();

        commands.put("/", new HomeCommand());
        commands.put(UrlPath.HOME.getPath(), new HomeCommand());
        commands.put(UrlPath.OUR_SHIPS.getPath(), new OurShipsCommand(shipService));
        commands.put(UrlPath.OUR_CRUISES.getPath(), new OurCruisesCommand(cruiseService));
        commands.put(UrlPath.ABOUT_US.getPath(), new AboutUsCommand());
        commands.put(UrlPath.SHIP_ITEM.getPath(), new ShipItemCommand(shipService, personalService, cruiseService));
        commands.put(UrlPath.CRUISE_ITEM.getPath(), new CruiseItemCommand(cruiseService, portService, tourService));
        commands.put(UrlPath.SIGN_UP_PAGE.getPath(), new SignUpPageCommand());
        commands.put(UrlPath.SIGN_IN_PAGE.getPath(), new SignInPageCommand());
        commands.put(UrlPath.SIGN_UP.getPath(), new SignUpUserCommand(userService));
        commands.put(UrlPath.SIGN_IN.getPath(), new SignInUserCommand(userService));
        commands.put(UrlPath.LOG_OUT.getPath(), new LogOutCommand());
        commands.put(UrlPath.USER_PROFILE.getPath(), new UserProfileCommand());
        commands.put(UrlPath.ADMIN.getPath(), new AdminCommand());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { ;
        doProcess(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().setAttribute("role.admin", Role.ADMIN);
        request.getServletContext().setAttribute("role.user", Role.USER);

        String uriPath = request.getPathInfo();
        Command command = commands.get(uriPath);
        if(command == null){
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        else {
            command.getPage(request, response);
        }
    }
}
