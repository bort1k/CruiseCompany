package com.bortni.service;

import com.bortni.dao.GenericDao;
import com.bortni.dao.mysql.MySqlCruiseDao;
import com.bortni.dao.mysql.MySqlDaoFactory;
import com.bortni.exceptions.ReadException;
import com.bortni.model.Cruise;

import java.util.List;

public class CruiseService {
    private GenericDao genericDao;

    public CruiseService() {
        MySqlDaoFactory daoFactory = new MySqlDaoFactory();
        genericDao = daoFactory.getDao(Cruise.class);
    }

    public Cruise getCruiseById(int id) throws ReadException {
            return (Cruise) genericDao.getByPK(id);
    }

    public List getAllCruises() throws ReadException {
        return genericDao.getAll();
    }

    public List getCruisesByShipId(int id) throws ReadException {
        return ((MySqlCruiseDao) genericDao).getCruisesByShipId(id);
    }

    public List getCruisesWithShip() throws ReadException {
        return ((MySqlCruiseDao) genericDao).getCruisesWithShips();
    }
}
