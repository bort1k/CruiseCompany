package com.bortni.dao.mysql;

import com.bortni.dao.DaoFactory;
import com.bortni.dao.GenericDao;
import com.bortni.dao.JdbcAbstractDao;
import com.bortni.dao.sql_queries.OrderQuery;
import com.bortni.exceptions.ReadException;
import com.bortni.model.Cruise;
import com.bortni.model.Order;
import com.bortni.model.User;
import com.bortni.model.enums.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlOrderDao extends JdbcAbstractDao<Order> {

    protected MySqlOrderDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectAllQuery() {
        return OrderQuery.SELECT_ALL.getQuery();
    }

    @Override
    public String getUpdateQuery() {
        return OrderQuery.UPDATE_STATUS.getQuery();
    }

    @Override
    public String getCreateQuery() {
        return OrderQuery.INSERT.getQuery();
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
    public void setStatementForInsert(PreparedStatement preparedStatement, Order object) {

    }

    @Override
    public void setStatementForUpdate(PreparedStatement preparedStatement, Order object) {

    }

    @Override
    public void setStatementForDelete(PreparedStatement preparedStatement, Order object) {

    }

    @Override
    public List<Order> getObjects(ResultSet resultSet) throws SQLException, ReadException {
        List<Order> orders = new ArrayList<>();

        while (resultSet.next()){
            Order order = new Order();
            order.setId(resultSet.getInt("id"));
            order.setSumPrice(resultSet.getInt("sum_price"));
            order.setStatus(Status.valueOf(resultSet.getString("status")));
            order.setCruise(getCruiseFromResultSet(resultSet));
            order.setUser(getUserFromResultSet(resultSet));
            orders.add(order);
        }
        return orders;
    }

    public int getIndexByUserId(int id) throws ReadException {
        String sql = OrderQuery.SELECT_CRUISE_ID_BY_ID.getQuery();
        final ResultSet resultSet;
        int cruiseId = 0;
        try(PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                cruiseId = resultSet.getInt("cruise_id");
            }
        } catch (SQLException e) {
            throw new ReadException(e);
        }
        return cruiseId;
    }

    @Override
    public void create(Order object) throws ReadException {
        String sql = getCreateQuery();

        try(PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql)){
            preparedStatement.setInt(1, object.getUser().getId());
            preparedStatement.setInt(2, object.getCruise().getId());
            preparedStatement.setString(3, object.getStatus().name());
            preparedStatement.setInt(4, object.getSumPrice());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new ReadException(e);
        }
    }

    public List getOrdersByUserId(int id) throws ReadException {
        List orders;

        String sql = OrderQuery.SELECT_ALL_BY_USER.getQuery();

        final ResultSet resultSet;
        try(PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            orders = getObjects(resultSet);
        } catch (SQLException e) {
            throw new ReadException(e);
        }

        return orders;
    }

    public void updateStatus(Order order) throws ReadException {
        String sql = OrderQuery.UPDATE_STATUS.getQuery();

        try(PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql)){
            preparedStatement.setString(1, order.getStatus().name());
            preparedStatement.setInt(2, order.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new ReadException(e);
        }
    }

    private Cruise getCruiseFromResultSet(ResultSet resultSet) throws SQLException {
        Cruise cruise = new Cruise();
        cruise.setName(resultSet.getString("cruise_name"));
        return cruise;
    }

    private User getUserFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setFirstName(resultSet.getString("firstname"));
        user.setLastName(resultSet.getString("lastname"));
        user.setEmail(resultSet.getString("email"));
        return user;
    }
}
