package com.bortni.service;

import com.bortni.dao.DaoFactory;
import com.bortni.dao.GenericDao;
import com.bortni.dao.mysql.MySqlDaoFactory;
import com.bortni.dao.mysql.MySqlOrderDao;
import com.bortni.exceptions.ReadException;
import com.bortni.model.Order;
import com.bortni.model.Port;
import com.bortni.model.Tour;

import java.util.List;

public class OrderService {
    private GenericDao genericDao;

    public OrderService() {
        DaoFactory daoFactory = new MySqlDaoFactory();
        genericDao = daoFactory.getDao(Order.class);
    }

    public List getAllOrders() throws ReadException {
        return genericDao.getAll();
    }

    public List getOrdersByUserId(int id) throws ReadException {
        return ((MySqlOrderDao) genericDao).getOrdersByUserId(id);
    }

    public Order sumAllPrice(Order order, List tours) {
        int price = order.getCruise().getPrice();

        for (Object tour : tours) {
            price += ((Tour) tour).getPrice();
        }
        order.setSumPrice(price);
        return order;
    }

    public void createOrder(Order order) throws ReadException {
        ((MySqlOrderDao) genericDao).create(order);
    }

    public void changeStatus(Order order) throws ReadException {
        ((MySqlOrderDao) genericDao).updateStatus(order);
    }
}
