package com.bortni.dao.sql_queries;

public enum UserQuery {
    SELECT_ALL("SELECT * FROM user"),

    SELECT_ONE("SELECT * FROM user WHERE id = ?;"),

    SELECT_USER_BY_EMAIL_AND_PASSWORD("SELECT * FROM user WHERE email = ? AND password = ?"),

    SELECT_USER_BY_EMAIL("SELECT * FROM user WHERE email = ?"),

    INSERT("INSERT INTO user " +
            "(email, firstname, lastname, password, role)" +
            "VALUES (?, ?, ? ,?, ?);"),

    UPDATE("UPDATE user " +
            "SET " +
            "WHERE "),
    DELETE("");

    private String query;
    UserQuery(String query){
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
