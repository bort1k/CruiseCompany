package com.bortni.dao;


import com.bortni.exceptions.ReadException;
import java.sql.Connection;
import java.sql.SQLException;

public interface DaoFactory {

    Connection getConnection() throws SQLException;

    interface DaoCreator{
        public GenericDao create(Connection connection) throws ReadException;
    }

    public GenericDao getDao(Class objectClass) throws SQLException, ReadException;


}
