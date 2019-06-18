package com.bortni.dao.mysql;

import com.bortni.dao.JdbcAbstractDao;
import com.bortni.dao.sql_queries.TourQuery;
import com.bortni.exceptions.ReadException;
import com.bortni.model.Port;
import com.bortni.model.Tour;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlTourDao extends JdbcAbstractDao {

    private final Logger LOGGER = Logger.getLogger(MySqlTourDao.class);

    protected MySqlTourDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectAllQuery() {
        return null;
    }

    @Override
    public String getUpdateQuery() {
        return null;
    }

    @Override
    public String getCreateQuery() {
        return null;
    }

    @Override
    public String getDeleteQuery() {
        return null;
    }

    @Override
    public String getSelectOneQuery() {
        return null;
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
    public List getObjects(ResultSet resultSet) throws ReadException {
        List<Tour> tours = new ArrayList<>();
        try{
            while (resultSet.next()){
                Tour tour = getTour(resultSet);
                tours.add(tour);
            }
        }catch (SQLException e){
            throw new ReadException(e);
        }
        return tours;
    }

    public List<Tour> getToursByCruiseIdWithHarbor(int id) throws ReadException {
        List<Tour> tours = new ArrayList<>();

        String sql = TourQuery.SELECT_ALL_BY_CRUISE_ID_WITH_HARBOR.getQuery();

        try (PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Tour tour = getTour(resultSet);
                Port port = new Port();
                port.setName(resultSet.getString("harbor_name"));
                tour.setPort(port);
                tours.add(tour);
            }
            LOGGER.info("Tours were created");
        }catch (SQLException e){
            throw new ReadException(e);
        }

        return tours;
    }

    @Override
    public void create(Object object) throws ReadException {

    }

    public Tour getTour(ResultSet resultSet) throws SQLException {
        Tour tour = new Tour();
        tour.setId(resultSet.getInt("id"));
        tour.setName(resultSet.getString("tour_name"));
        tour.setPrice(resultSet.getInt("price"));
        LOGGER.info("Tour was created");
        return tour;
    }
}
