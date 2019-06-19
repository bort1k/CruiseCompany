package com.bortni.dao.mysql;

import com.bortni.dao.*;
import com.bortni.dao.connection.ConnectionPoolHolder;
import com.bortni.exceptions.ReadException;
import com.bortni.model.*;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MySqlDaoFactory implements DaoFactory {

    private final Logger LOGGER = Logger.getLogger(MySqlDaoFactory.class);

    private Map<Class, DaoCreator> classCreators;

    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    @Override
    public Connection getConnection() throws ReadException {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            LOGGER.fatal(e);
            throw new ReadException(e);
        }
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
        classCreators.put(User.class, MySqlUserDao::new);
        classCreators.put(Order.class, MySqlOrderDao::new);
    }

}
