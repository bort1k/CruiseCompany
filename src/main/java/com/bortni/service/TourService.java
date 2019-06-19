package com.bortni.service;

import com.bortni.dao.DaoFactory;
import com.bortni.dao.GenericDao;
import com.bortni.dao.mysql.MySqlDaoFactory;
import com.bortni.dao.mysql.MySqlTourDao;
import com.bortni.exceptions.ReadException;
import com.bortni.model.Port;
import com.bortni.model.Tour;

import java.util.List;

public class TourService {
    private GenericDao genericDao;

    public TourService() {
        DaoFactory daoFactory = new MySqlDaoFactory();
        genericDao = daoFactory.getDao(Tour.class);
    }

    public List getToursByCruiseId(int id) throws ReadException {

        return ((MySqlTourDao) genericDao).getToursByCruiseIdWithHarbor(id);
    }
}
