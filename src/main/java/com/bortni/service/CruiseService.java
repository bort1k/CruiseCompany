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

    public Cruise getCruiseById(int id){
        try {
            return (Cruise) genericDao.getByPK(id);
        } catch (ReadException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List getAllCruises(){
        List cruises = null;
        try {
            cruises = genericDao.getAll();
        } catch (ReadException e) {
            e.printStackTrace();
        }
        return cruises;
    }

    public List getCruisesByShipId(int id){
        List cruises;
        try {
            cruises = ((MySqlCruiseDao) genericDao).getCruisesByShipId(id);
            return cruises;
        } catch (ReadException e){
            e.printStackTrace();
        }
        return null;
    }

    public List getCruisesWithShip(){
        List cruises;
        try{
            cruises = ((MySqlCruiseDao) genericDao).getCruisesWithShips();
            return cruises;
        }
        catch (ReadException e){
            e.printStackTrace();
        }
        return null;
    }

}
