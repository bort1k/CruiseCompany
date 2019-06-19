package com.bortni.web.commands;

import com.bortni.exceptions.ReadException;
import com.bortni.model.Cruise;
import com.bortni.model.Order;
import com.bortni.model.User;
import com.bortni.model.enums.Status;
import com.bortni.service.CruiseService;
import com.bortni.service.OrderService;
import com.bortni.util.Routes;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static java.lang.Integer.parseInt;

public class AddOrderCommand implements Command{

    private final Logger LOGGER = Logger.getLogger(AddOrderCommand.class);

    private OrderService orderService;
    private CruiseService cruiseService;

    public AddOrderCommand(OrderService orderService, CruiseService cruiseService) {
        this.orderService = orderService;
        this.cruiseService = cruiseService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


//        List orders = (List) request.getSession().getAttribute("ordersSession");
//        if(orders == null){
//            orders = new ArrayList<Order>();
//            request.getSession().setAttribute("ordersSession", orders);
//        }

        String sCruiseId = request.getParameter("cruise.id");
        int cruiseId = parseInt(sCruiseId);
        Cruise cruise = null;
        try {
            cruise = cruiseService.getCruiseById(cruiseId);
        } catch (ReadException e) {
            request.getRequestDispatcher("/jsp/404error.jsp").forward(request, response);
        }
        LOGGER.info("Cruise:" + cruise);

        request.getSession().removeAttribute(sCruiseId);

        User user = (User)request.getSession().getAttribute("userSession");
        if(user != null) {
            Order order = new Order();
            List tours = (List)request.getSession().getAttribute("toursSession");
            request.getSession().removeAttribute("toursSession");
            order.setCruise(cruise);
            order.setTours(tours);
            order.setUser(user);
            order.setStatus(Status.WAITING);
            order = orderService.sumAllPrice(order, tours);
            try {
                orderService.createOrder(order);
            } catch (ReadException e) {
                request.getRequestDispatcher("/jsp/404error.jsp").forward(request, response);
            }
//            orders.add(order);
//            request.getSession().removeAttribute("ordersSession");
//            request.getSession().setAttribute("ordersSession", orders);

            request.getRequestDispatcher(Routes.SUCCESSFUL.getRoute()).forward(request, response);
        }
        else{
            request.getRequestDispatcher(Routes.SIGN_IN.getRoute()).forward(request, response);
        }
    }
}
