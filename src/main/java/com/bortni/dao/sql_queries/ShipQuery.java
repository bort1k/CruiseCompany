package com.bortni.dao.sql_queries;

public enum ShipQuery {
    SELECT_ALL("SELECT * FROM ship"),

    SELECT_ONE("SELECT * FROM ship WHERE id = ?;"),

    INSERT("INSERT INTO personal " +
            "(passenger_capacity, ship_name, personal_id, )" +
            "VALUES (?, ?, ?);"),

    UPDATE("UPDATE ship " +
            "SET passenger_capacity = ?, ship_name = ?," +
            "personal_id = ?" +
            "WHERE id = ?"),
    DELETE("");


    String query;
    ShipQuery(String query){
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
