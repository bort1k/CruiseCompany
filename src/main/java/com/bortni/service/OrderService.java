package com.bortni.service;

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
        MySqlDaoFactory daoFactory = new MySqlDaoFactory();
        genericDao = daoFactory.getDao(Order.class);
    }

    public List getAllOrders(){
        List orders;
        try{
            orders = genericDao.getAll();
            return orders;
        } catch (ReadException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List getOrdersByUserId(int id){
        List orders;
        try {
            orders = ((MySqlOrderDao)genericDao).getOrdersByUserId(id);
            return orders;
        } catch (ReadException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int sumAllPrice(Order order){
        int price = order.getCruise().getPrice();
        List ports = order.getCruise().getPorts();
        for(Object objectPort : ports){
            for(Object objectTour: ((Port)objectPort).getTours()){
                price += ((Tour)objectTour).getPrice();
            }
        }
        return price;
    }

    public void createOrder(Order order){
        try {
            ((MySqlOrderDao)genericDao).create(order);
        } catch (ReadException e) {
            e.printStackTrace();
        }
    }

    public void changeStatus(Order order){
        try {
            ((MySqlOrderDao)genericDao).updateStatus(order);
        } catch (ReadException e) {
            e.printStackTrace();
        }
    }
}
