package com.bortni.dao.mysql;

import com.bortni.dao.JdbcAbstractDao;
import com.bortni.dao.sql_queries.PortQuery;
import com.bortni.exceptions.ReadException;
import com.bortni.model.Port;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlPortDao extends JdbcAbstractDao<Port> {

    private final Logger LOGGER = Logger.getLogger(MySqlPortDao.class);

    protected MySqlPortDao(Connection connection) {
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
    public void setStatementForInsert(PreparedStatement preparedStatement, Port object) {

    }

    @Override
    public void setStatementForUpdate(PreparedStatement preparedStatement, Port object) {

    }

    @Override
    public void setStatementForDelete(PreparedStatement preparedStatement, Port object) {

    }


    @Override
    public List<Port> getObjects(ResultSet resultSet) throws ReadException {
        List<Port> ports = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Port port = new Port();
                port.setId(resultSet.getInt("id"));
                port.setName(resultSet.getString("harbor_name"));
                LOGGER.info("Port was created " + resultSet.getInt("id"));
                ports.add(port);
            }
        } catch (SQLException e) {
            throw new ReadException(e);
        }
        return ports;
    }

    public List getPortsByCruiseId(int id) throws ReadException {
        List ports;

        String sql = PortQuery.SELECT_BY_CRUISE_ID.getQuery();

        try (PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            ports = getObjects(resultSet);
            LOGGER.info("Ports by cruise_id were created");

        }
        catch (SQLException e){
            throw new ReadException(e);
        }
        return ports;
    }


    @Override
    public void create(Port object) throws ReadException {

    }
}
