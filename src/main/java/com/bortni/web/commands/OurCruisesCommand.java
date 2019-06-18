package com.bortni.web.commands;

import com.bortni.service.CruiseService;
import com.bortni.util.Routes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OurCruisesCommand implements Command {
    private CruiseService cruiseService;

    public OurCruisesCommand(CruiseService cruiseService) {
        this.cruiseService = cruiseService;
    }

    @Override
    public void getPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List cruises = cruiseService.getCruisesWithShip();
        request.setAttribute("cruises", cruises);
        request.getRequestDispatcher(Routes.OUR_CRUISES.getRoute()).forward(request, response);
    }
}
