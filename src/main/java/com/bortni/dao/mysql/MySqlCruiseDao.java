package com.bortni.dao.mysql;

import com.bortni.dao.JdbcAbstractDao;
import com.bortni.dao.sql_queries.CruiseQuery;
import com.bortni.exceptions.ReadException;
import com.bortni.model.Cruise;
import com.bortni.model.Ship;
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
                Cruise cruise = getCruise(resultSet);
                LOGGER.info("Cruise was created" + resultSet.getInt("id"));
                cruises.add(cruise);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return cruises;
    }

    public List getCruisesByShipId(int id) throws ReadException {
        List cruises;

        String sql = CruiseQuery.SELECT_BY_SHIP_ID.getQuery();

        try (PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            LOGGER.info("Getting all objects");
            cruises = getObjects(resultSet);
        }
        catch (SQLException e){
            throw new ReadException(e);
        }
        return cruises;
    }

    public List getCruisesWithShips() throws ReadException {
        List<Cruise> cruises = new ArrayList<>();

        String sql = CruiseQuery.SELECT_ALL_WITH_SHIPS.getQuery();

        try(PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Cruise cruise = getCruise(resultSet);
                Ship ship = new Ship();
                ship.setName(resultSet.getString("ship_name"));
                ship.setId(resultSet.getInt("ship_id"));
                cruise.setShip(ship);
                LOGGER.info("Cruise was created" + resultSet.getInt("id"));
                cruises.add(cruise);
            }

        } catch (SQLException e) {
            throw new ReadException(e);
        }

        return cruises;
    }

    @Override
    public void create(Object object) throws ReadException {
    }


    public Cruise getCruise(ResultSet resultSet) throws SQLException {
        Cruise cruise = new Cruise();
        cruise.setId(resultSet.getInt("id"));
        cruise.setDuration(resultSet.getInt("duration"));
        cruise.setNumberOfPorts(resultSet.getInt("number_of_ports"));
        cruise.setPrice(resultSet.getInt("price"));
        cruise.setName(resultSet.getString("cruise_name"));
        cruise.setStartDate(resultSet.getDate("start_date"));
        return cruise;
    }
}
