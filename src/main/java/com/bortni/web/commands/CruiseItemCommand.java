package com.bortni.web.commands;

import com.bortni.exceptions.ReadException;
import com.bortni.model.Cruise;
import com.bortni.service.CruiseService;
import com.bortni.service.PortService;
import com.bortni.service.TourService;
import com.bortni.util.Routes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static java.lang.Integer.parseInt;

public class CruiseItemCommand implements Command {

    private CruiseService cruiseService;
    private PortService portService;
    private TourService tourService;

    private int price;

    public CruiseItemCommand(CruiseService cruiseService, PortService portService, TourService tourService) {
        this.cruiseService = cruiseService;
        this.portService = portService;
        this.tourService = tourService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sCruiseId = request.getParameter("cruise.id");
        if(sCruiseId != null) {
            request.getSession().setAttribute("cruiseIdSession", request.getParameter("cruise.id"));
        }
        else{
            sCruiseId = (String) request.getSession().getAttribute("cruiseIdSession");
        }
        int id =  parseInt(sCruiseId);
        try {
            Cruise cruise = cruiseService.getCruiseById(id);
            List ports = portService.getPortsByCruiseId(id);
            List tours = tourService.getToursByCruiseId(id);
            cruise.setPorts(ports);
            request.setAttribute("cruise", cruise);
            request.setAttribute("tours", tours);
        }
        catch (ReadException e){
            request.getRequestDispatcher("/jsp/404error.jsp").forward(request, response);
        }


        request.getRequestDispatcher(Routes.CRUISE_ITEM.getRoute()).forward(request, response);
    }
}
