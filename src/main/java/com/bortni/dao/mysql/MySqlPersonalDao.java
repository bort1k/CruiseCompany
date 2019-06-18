package com.bortni.dao.mysql;

import com.bortni.dao.DaoFactory;
import com.bortni.dao.GenericDao;
import com.bortni.dao.JdbcAbstractDao;
import com.bortni.dao.sql_queries.PersonalQuery;
import com.bortni.exceptions.ReadException;
import com.bortni.model.Personal;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlPersonalDao extends JdbcAbstractDao<Personal> {

    private final Logger LOGGER = Logger.getLogger(MySqlPersonalDao.class);

    public MySqlPersonalDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectAllQuery() {
        return PersonalQuery.SELECT_ALL.getQuery();
    }

    @Override
    public String getSelectOneQuery() {
        return PersonalQuery.SELECT_ONE.getQuery();
    }


    @Override
    public String getCreateQuery() {
        return PersonalQuery.INSERT.getQuery();
    }

    @Override
    public String getUpdateQuery() {
        return PersonalQuery.UPDATE.getQuery();
    }

    @Override
    public String getDeleteQuery() {
        return PersonalQuery.DELETE.getQuery();
    }

    @Override
    public void setStatementForInsert(PreparedStatement preparedStatement, Personal object) {
        try{
            preparedStatement.setString(1, object.getCaptainFirstName());
            preparedStatement.setString(2, object.getCaptainLastName());
            preparedStatement.setInt(3, object.getNumberOfTechnicalWorkers());
            preparedStatement.setInt(4, object.getNumberOfHotelWorkers());
            preparedStatement.setInt(5, object.getNumberOfShopWorkers());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setStatementForUpdate(PreparedStatement preparedStatement, Personal object) {

    }

    @Override
    public void setStatementForDelete(PreparedStatement preparedStatement, Personal object) {

    }

    @Override
    public void create(Personal object) throws ReadException {
        String sql = PersonalQuery.INSERT.getQuery();
        try (PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql)) {
            LOGGER.debug("Execute query: " + sql);
            setStatementForInsert(preparedStatement, object);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Personal> getObjects(ResultSet resultSet) {
        List<Personal> personals = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Personal personal = new Personal();
                personal.setId(resultSet.getInt("id"));
                personal.setCaptainFirstName(resultSet.getString("captain_firstname"));
                personal.setCaptainLastName(resultSet.getString("captain_lastname"));
                personal.setNumberOfTechnicalWorkers(resultSet.getInt("technical_workers"));
                personal.setNumberOfHotelWorkers(resultSet.getInt("hotel_workers"));
                personal.setNumberOfShopWorkers(resultSet.getInt("shop_workers"));
                LOGGER.info("Personal was created");
                personals.add(personal);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return personals;
    }

    public Personal getPersonalByShipId(int id) throws ReadException {
        List<Personal> personals;

        String sql = PersonalQuery.SELECT_ONE_BY_SHIP_ID.getQuery();

        try(PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            personals = this.getObjects(resultSet);

        } catch (SQLException e) {
            throw new ReadException(e);
        }

        return personals.iterator().next();
    }

}
