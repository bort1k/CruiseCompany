package com.bortni.dao.mysql;

import com.bortni.dao.GenericDao;
import com.bortni.dao.JdbcAbstractDao;
import com.bortni.dao.sql_queries.ShipQuery;
import com.bortni.exceptions.ReadException;
import com.bortni.model.Cruise;
import com.bortni.model.Ship;
import com.bortni.service.PersonalService;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlShipDao extends JdbcAbstractDao<Ship> {

    private final Logger LOGGER = Logger.getLogger(MySqlShipDao.class);

    protected MySqlShipDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectAllQuery() {
        return ShipQuery.SELECT_ALL.getQuery();
    }

    @Override
    public String getUpdateQuery() {
        return ShipQuery.UPDATE.getQuery();
    }

    @Override
    public String getCreateQuery() {
        return ShipQuery.INSERT.getQuery();
    }

    @Override
    public String getDeleteQuery() {
        return ShipQuery.DELETE.getQuery();
    }

    @Override
    public String getSelectOneQuery() {
        return ShipQuery.SELECT_ONE.getQuery();
    }

    @Override
    public void setStatementForInsert(PreparedStatement preparedStatement, Ship object) {

    }

    @Override
    public void setStatementForUpdate(PreparedStatement preparedStatement, Ship object) {

    }

    @Override
    public void setStatementForDelete(PreparedStatement preparedStatement, Ship object) {

    }

    @Override
    public List<Ship> getObjects(ResultSet resultSet) throws ReadException {

        List<Ship> ships = new ArrayList<>();

        try {
            while (resultSet.next()){
                Ship ship = new Ship();
                PersonalService personalService = new PersonalService();
                List cruises = new MySqlCruiseDao(this.getConnection()).getAll();
                ship.setId(resultSet.getInt("id"));
                ship.setName(resultSet.getString("ship_name"));
                ship.setPassenger_capacity(resultSet.getInt("passenger_capacity"));
                ship.setPersonal(personalService.getPersonalById(resultSet.getInt("personal_id")));
                ship.setCruises(cruises);
                LOGGER.info("Ship was created " + resultSet.getInt("personal_id"));
                ships.add(ship);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return ships;
    }

    @Override
    public void create(Ship object) throws ReadException {

    }
}
