package com.bortni.dao.mysql;

import com.bortni.dao.DaoFactory;
import com.bortni.dao.GenericDao;
import com.bortni.dao.JdbcAbstractDao;
import com.bortni.dao.sql_queries.PersonalQuery;
import com.bortni.model.Personal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlPersonalDao extends JdbcAbstractDao<Personal> {

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
    public String getUpdateQuery() {
        return PersonalQuery.UPDATE.getQuery();
    }

    @Override
    public String getDeleteQuery() {
        return PersonalQuery.DELETE.getQuery();
    }

    @Override
    public void setStatementForUpdate(PreparedStatement preparedStatement, Personal object) {

    }

    @Override
    public void setStatementForDelete(PreparedStatement preparedStatement, Personal object) {

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
                personals.add(personal);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return personals;
    }

    @Override
    public Personal create() {
        return null;
    }

}
