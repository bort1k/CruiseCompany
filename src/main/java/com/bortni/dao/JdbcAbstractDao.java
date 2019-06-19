package com.bortni.dao;

import com.bortni.exceptions.ReadException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class JdbcAbstractDao<T> implements GenericDao<T>{
    private Connection connection;

    private final Logger LOGGER = Logger.getLogger(JdbcAbstractDao.class);

    protected JdbcAbstractDao(Connection connection) {
        this.connection = connection;
    }

    public abstract String getSelectAllQuery();

    public abstract String getUpdateQuery();

    public abstract String getCreateQuery();

    public abstract String getDeleteQuery();

    public abstract String getSelectOneQuery();

    public abstract void setStatementForInsert(PreparedStatement preparedStatement, T object);

    public abstract void setStatementForUpdate(PreparedStatement preparedStatement, T object);

    public abstract void setStatementForDelete(PreparedStatement preparedStatement, T object);

    public abstract List<T> getObjects(ResultSet resultSet) throws SQLException, ReadException;


    @Override
    public T getByPK(int key) throws ReadException {

        List<T> objects;

        String sql = getSelectOneQuery();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            objects = getObjects(resultSet);
        }
        catch (SQLException e){
            throw new ReadException(e);
        }

        if(objects == null || objects.size() == 0){
            return null;
        }

        if (objects.size() > 1){
            throw new ReadException("Error! Received more than one object");
        }

        return objects.iterator().next();
    }

    @Override
    public void update(T object) throws ReadException {
        String sql = getUpdateQuery();
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            setStatementForUpdate(preparedStatement, object);
            int count = preparedStatement.executeUpdate();
            if(count != 1){
                throw new ReadException("Error! Not one object was updated!");
            }
        } catch (SQLException e) {
            throw new ReadException(e);
        }
    }

    @Override
    public void delete(T object) throws ReadException {
        String sql = getDeleteQuery();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            setStatementForDelete(preparedStatement, object);
            int count = preparedStatement.executeUpdate();
            if(count != 1){
                throw new ReadException("Error! Not one object was deleted!");
            }
        } catch (SQLException e) {
            throw new ReadException(e);
        }
    }

    @Override
    public List<T> getAll() throws ReadException {

        List<T> objects;

        String sql = getSelectAllQuery() + ";";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            LOGGER.info("Getting all objects");
            objects = getObjects(resultSet);
        }
        catch (SQLException e){
            throw new ReadException(e);
        }
        return objects;
    }


    public Connection getConnection() {
        return connection;
    }

    @Override
    public void close(){
        try{
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
