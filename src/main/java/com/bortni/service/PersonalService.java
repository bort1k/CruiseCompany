package com.bortni.service;

import com.bortni.dao.DaoFactory;
import com.bortni.dao.GenericDao;
import com.bortni.dao.mysql.MySqlDaoFactory;
import com.bortni.dao.mysql.MySqlPersonalDao;
import com.bortni.exceptions.ReadException;
import com.bortni.model.Personal;

import java.sql.SQLException;

public class PersonalService {
    private GenericDao genericDao;
    private DaoFactory daoFactory;
    public PersonalService() {
        daoFactory = new MySqlDaoFactory();
        genericDao = daoFactory.getDao(Personal.class);
    }

    public Personal getPersonalById(int id) {
        try {
            return (Personal) genericDao.getByPK(id);
        } catch (ReadException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Personal getPersonalByShipId(int id){
        Personal personal;
        try {
            personal = ((MySqlPersonalDao) genericDao).getPersonalByShipId(id);
            return personal;
        } catch (ReadException e){
            e.printStackTrace();
        }
        return null;
    }


}
