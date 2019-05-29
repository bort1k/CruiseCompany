package com.bortni.dao.mysql;

import com.bortni.dao.*;
import com.bortni.dao.connection.ConnectionHolder;
import com.bortni.exceptions.ReadException;
import com.bortni.model.*;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MySqlDaoFactory implements DaoFactory {

    private final Logger LOGGER = Logger.getLogger(MySqlDaoFactory.class);

    private Map<Class, DaoCreator> classCreators;

    @Override
    public Connection getConnection(){
        try {
            return ConnectionHolder.getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public GenericDao getDao(Class objectClass) {
        GenericDao genericDao = null;
        try {
            DaoCreator daoCreator = classCreators.get(objectClass);
            genericDao = daoCreator.create(getConnection());
        }
        catch (ReadException e){
            e.printStackTrace();
        }
        return genericDao;
    }

    public MySqlDaoFactory() {
        classCreators = new HashMap<>();
        classCreators.put(Personal.class, MySqlPersonalDao::new);
        classCreators.put(Cruise.class, MySqlCruiseDao::new);
        classCreators.put(Ship.class, MySqlShipDao::new);
        classCreators.put(Port.class, MySqlPortDao::new);
        classCreators.put(Tour.class, MySqlTourDao::new);
        classCreators.put(Ticket.class, MySqlTicketDao::new);
        classCreators.put(User.class, MySqlUserDao::new);
    }

}
