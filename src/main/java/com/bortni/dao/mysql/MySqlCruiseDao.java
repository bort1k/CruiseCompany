package com.bortni.dao.mysql;

import com.bortni.dao.JdbcAbstractDao;
import com.bortni.dao.sql_queries.CruiseQuery;
import com.bortni.exceptions.ReadException;
import com.bortni.model.Cruise;
import com.bortni.service.ShipService;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlCruiseDao extends JdbcAbstractDao {

    private final Logger LOGGER = Logger.getLogger(MySqlCruiseDao.class);

    public MySqlCruiseDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectAllQuery() {
        return CruiseQuery.SELECT_ALL.getQuery();
    }

    @Override
    public String getUpdateQuery() {
        return CruiseQuery.UPDATE.getQuery();
    }

    @Override
    public String getCreateQuery() {
        return CruiseQuery.INSERT.getQuery();
    }

    @Override
    public String getDeleteQuery() {
        return CruiseQuery.DELETE.getQuery();
    }

    @Override
    public String getSelectOneQuery() {
        return CruiseQuery.SELECT_ONE.getQuery();
    }

    @Override
    public void setStatementForInsert(PreparedStatement preparedStatement, Object object) {

    }

    @Override
    public void setStatementForUpdate(PreparedStatement preparedStatement, Object object) {

    }

    @Override
    public void setStatementForDelete(PreparedStatement preparedStatement, Object object) {

    }

    @Override
    public List getObjects(ResultSet resultSet) throws ReadException{
        List<Cruise> cruises = new ArrayList<>();
        try{
            while (resultSet.next()){
                Cruise cruise = new Cruise();
                ShipService shipService = new ShipService();
                cruise.setId(resultSet.getInt("id"));
                cruise.setDuration(resultSet.getInt("duration"));
                cruise.setNumberOfPorts(resultSet.getInt("number_of_ports"));
                cruise.setPrice(resultSet.getInt("price"));
                cruise.setName(resultSet.getString("cruise_name"));
                cruise.setStartDate(resultSet.getDate("start_date"));
                cruise.setShipId(resultSet.getInt("ship_id"));

                cruises.add(cruise);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return cruises;
    }

    @Override
    public void create(Object object) throws ReadException {

    }
}
