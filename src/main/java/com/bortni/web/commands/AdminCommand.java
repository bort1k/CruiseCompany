package com.bortni.web.commands;

import com.bortni.model.User;
import com.bortni.service.OrderService;
import com.bortni.util.Routes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminCommand implements Command{
    private OrderService orderService;

    public AdminCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List orders = orderService.getAllOrders();
        request.setAttribute("orders", orders);
        request.getRequestDispatcher(Routes.ADMIN.getRoute()).forward(request, response);
    }
}
