package com.bortni.web;

import com.bortni.service.*;
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
        commands.put(UrlPath.SIGN_UP.getPath(), new SignUpPageCommand());
        commands.put(UrlPath.SIGN_IN.getPath(), new SignInPageCommand());
        commands.put(UrlPath.SIGN_UP_USER.getPath(), new SignUpUserCommand(userService));
        commands.put(UrlPath.SIGN_IN_USER.getPath(), new SignInUserCommand(userService));
        commands.put(UrlPath.LOG_OUT.getPath(), new LogOutCommand());
        commands.put(UrlPath.USER_PROFILE.getPath(), new UserProfileCommand());
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
