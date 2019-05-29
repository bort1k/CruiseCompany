package com.bortni.dao;


import com.bortni.exceptions.ReadException;
import java.sql.Connection;
import java.sql.SQLException;

public interface DaoFactory {

    Connection getConnection() throws SQLException;

    interface DaoCreator{
        GenericDao create(Connection connection) throws ReadException;
    }

    GenericDao getDao(Class objectClass);


}
