package com.bortni.service;

import com.bortni.dao.GenericDao;
import com.bortni.dao.mysql.MySqlDaoFactory;
import com.bortni.dao.mysql.MySqlPortDao;
import com.bortni.dao.mysql.MySqlTourDao;
import com.bortni.exceptions.ReadException;
import com.bortni.model.Port;

import java.util.List;

public class PortService {
    private GenericDao genericDao;

    public PortService() {
        MySqlDaoFactory daoFactory = new MySqlDaoFactory();
        genericDao = daoFactory.getDao(Port.class);
    }

    public Port getPortById(int id) throws ReadException {

        return (Port) genericDao.getByPK(id);

    }

    public List getPortsByCruiseId(int id) throws ReadException {
        return ((MySqlPortDao) genericDao).getPortsByCruiseId(id);
    }
}
