package com.bortni.dao.mysql;

import com.bortni.dao.JdbcAbstractDao;
import com.bortni.dao.sql_queries.UserQuery;
import com.bortni.exceptions.ReadException;
import com.bortni.model.User;
import com.bortni.model.enums.Role;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlUserDao extends JdbcAbstractDao {

    private final Logger LOGGER = Logger.getLogger(MySqlUserDao.class);

    protected MySqlUserDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectAllQuery() {
        return UserQuery.SELECT_ALL.getQuery();
    }

    @Override
    public String getUpdateQuery() {
        return null;
    }

    @Override
    public String getCreateQuery() {
        return UserQuery.INSERT.getQuery();
    }

    @Override
    public String getDeleteQuery() {
        return null;
    }

    @Override
    public String getSelectOneQuery() {
        return UserQuery.SELECT_ONE.getQuery();
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
    public List<User> getObjects(ResultSet resultSet) throws ReadException {
        List<User> users = new ArrayList<>();
        try {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("firstname"));
                user.setLastName(resultSet.getString("lastname"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                Role role = Role.valueOf(resultSet.getString("role"));
                user.setRole(role);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new ReadException(e);
        }
        return users;
    }

    public boolean isExist(String email, String password) throws ReadException {
        String sql = UserQuery.SELECT_USER_BY_EMAIL_AND_PASSWORD.getQuery();
        boolean exist = false;
        try (PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql)){
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            exist = resultSet.next();
        }catch (SQLException e){
            throw new ReadException(e);
        }
        return exist;
    }

    public boolean isEmailExist(String email) throws ReadException {
        String sql = UserQuery.SELECT_USER_BY_EMAIL.getQuery();
        final ResultSet resultSet;
        boolean exist = false;
        try(PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql)){
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            exist = resultSet.next();
        } catch (SQLException e) {
            throw new ReadException(e);
        }
        return exist;
    }

    public User getUserByEmailAndPassword(String email, String password) throws ReadException {
        List users;
        String sql = UserQuery.SELECT_USER_BY_EMAIL_AND_PASSWORD.getQuery();
        final ResultSet resultSet;
        try(PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql)){
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            users = getObjects(resultSet);
        } catch (SQLException e) {
            throw new ReadException(e);
        }

        return (User)users.iterator().next();

    }


    @Override
    public void create(Object object) throws ReadException {
        String sql = getCreateQuery();

        try (PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, ((User) object).getEmail());
            preparedStatement.setString(2, ((User) object).getFirstName());
            preparedStatement.setString(3, ((User) object).getLastName());
            preparedStatement.setString(4, ((User) object).getPassword());
            preparedStatement.setString(5, Role.USER.name());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new ReadException(e);
        }
    }
}
