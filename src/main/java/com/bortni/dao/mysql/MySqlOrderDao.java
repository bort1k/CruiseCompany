package com.bortni.dao.mysql;

import com.bortni.dao.JdbcAbstractDao;
import com.bortni.dao.sql_queries.OrderQuery;
import com.bortni.exceptions.ReadException;
import com.bortni.model.Order;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable;

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
            orders.add(order);
        }
        return orders;

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
}
