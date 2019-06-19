package com.bortni.web.commands;

import com.bortni.model.Port;
import com.bortni.model.Tour;
import com.bortni.model.User;
import com.bortni.util.Routes;
import com.bortni.util.UrlPath;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class AddTourToOrderCommand implements Command{

    private final Logger LOGGER = Logger.getLogger(AddTourToOrderCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Tour> tours = new ArrayList<>();

        request.getSession().setAttribute("previousPageUrl",  UrlPath.CRUISE_ITEM.getPath());

        User user = (User)request.getSession().getAttribute("userSession");
        if(user != null) {
            Tour tour = new Tour();
            Port port = new Port();
            String sPrice = request.getParameter("tour.price");
            int price = parseInt(sPrice);
            tour.setPrice(price);
            String name = request.getParameter("tour.name");
            tour.setName(name);
            String portName = request.getParameter("tour.port.name");
            port.setName(portName);
            tour.setPort(port);
            tours.add(tour);

            request.getSession().removeAttribute("toursSession");
            request.getSession().setAttribute("toursSession", tours);

            response.sendRedirect("/eden-cruises" + UrlPath.CRUISE_ITEM.getPath());
        }
        else{
            request.getRequestDispatcher(Routes.SIGN_IN.getRoute()).forward(request, response);
        }

    }
}
