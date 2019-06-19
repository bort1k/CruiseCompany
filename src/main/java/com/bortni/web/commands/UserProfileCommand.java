package com.bortni.web.commands;

import com.bortni.model.User;
import com.bortni.service.OrderService;
import com.bortni.util.Routes;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserProfileCommand implements Command {

    private final Logger LOGGER = Logger.getLogger(UserProfileCommand.class);

    private OrderService orderService;

    public UserProfileCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("userSession");
        List orders = orderService.getOrdersByUserId(user.getId());
        LOGGER.info("Orders" + orders);
        request.setAttribute("orders", orders);
        request.getRequestDispatcher(Routes.USER_PROFILE.getRoute()).forward(request, response);
    }
}
