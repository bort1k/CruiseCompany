package com.bortni.web.commands;

import com.bortni.exceptions.ReadException;
import com.bortni.model.Personal;
import com.bortni.model.Ship;
import com.bortni.service.CruiseService;
import com.bortni.service.PersonalService;
import com.bortni.service.ShipService;
import com.bortni.util.Routes;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static java.lang.Integer.parseInt;

public class ShipItemCommand implements Command {
    private final Logger LOGGER = Logger.getLogger(ShipItemCommand.class);

    private ShipService shipService;
    private PersonalService personalService;
    private CruiseService cruiseService;

    public ShipItemCommand(ShipService shipService, PersonalService personalService, CruiseService cruiseService){
        this.shipService = shipService;
        this.personalService = personalService;
        this.cruiseService = cruiseService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String stringId = request.getParameter("id");
        int id = parseInt(stringId);
        try {
            Ship ship = shipService.getById(id);
            Personal personal = personalService.getPersonalByShipId(id);
            ship.setPersonal(personal);
            List cruises = cruiseService.getCruisesByShipId(id);
            ship.setCruises(cruises);
            LOGGER.info("Getting cruises by ship_id" + cruises.size());
            request.setAttribute("ship_item", ship);
        }
        catch (ReadException e){
            request.getRequestDispatcher("/jsp/404error.jsp").forward(request, response);
        }
        request.getRequestDispatcher(Routes.SHIP_ITEM.getRoute()).forward(request, response);
    }
}
