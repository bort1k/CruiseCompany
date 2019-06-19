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

    public Port getPortById(int id){
        try {
            return (Port) genericDao.getByPK(id);
        } catch (ReadException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List getPortsByCruiseId(int id){
        List ports;

        try{
            ports = ((MySqlPortDao) genericDao).getPortsByCruiseId(id);
            return ports;
        } catch (ReadException e) {
            e.printStackTrace();
        }
        return null;
    }
}
