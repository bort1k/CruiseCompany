package com.bortni.dao.mysql;

import com.bortni.dao.*;
import com.bortni.dao.connection.ConnectionHolder;
import com.bortni.exceptions.ReadException;
import com.bortni.model.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MySqlDaoFactory implements DaoFactory {
    private Map<Class, DaoCreator> classCreators;

    @Override
    public Connection getConnection() throws SQLException {
        return ConnectionHolder.getDataSource().getConnection();
    }

    @Override
    public GenericDao getDao(Class objectClass) throws SQLException, ReadException {
        DaoCreator daoCreator = classCreators.get(objectClass);

        return daoCreator.create(getConnection());
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
