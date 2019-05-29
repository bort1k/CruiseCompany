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

    public PersonalService() {
        DaoFactory daoFactory = new MySqlDaoFactory();
        genericDao = daoFactory.getDao(Personal.class);
    }

    public Personal getPersonalById(int id) throws ReadException {
        return (Personal) genericDao.getByPK(id);
    }
}
