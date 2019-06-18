package com.bortni.service;

import com.bortni.dao.DaoFactory;
import com.bortni.dao.GenericDao;
import com.bortni.dao.mysql.MySqlDaoFactory;
import com.bortni.exceptions.ReadException;
import com.bortni.model.Ship;

import java.util.List;

public class ShipService {

    private GenericDao genericDao;

    public ShipService() {
        DaoFactory daoFactory = new MySqlDaoFactory();
        genericDao = daoFactory.getDao(Ship.class);
    }

    public Ship getById(int id) {
        try {
            return (Ship) genericDao.getByPK(id);
        } catch (ReadException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List getAllShips() {
        List ships = null;
        try {
            ships = genericDao.getAll();
        } catch (ReadException e) {
            e.printStackTrace();
        }
        return ships;
    }
}
