package com.bortni.dao.sql_queries;

public enum CruiseQuery {
    SELECT_ALL("SELECT * FROM cruise"),

    SELECT_ALL_WITH_SHIPS("SELECT * FROM cruise, ship WHERE ship_id = ship.id;"),

    SELECT_BY_SHIP_ID("SELECT * FROM cruise WHERE ship_id = ?;"),

    SELECT_ONE("SELECT * FROM cruise WHERE id = ?;"),

    INSERT("INSERT INTO cruise " +
            "(duration, number_of_ports, price, start_date, ship_id, cruise_name)" +
            "VALUES (?, ?, ? ,?, ?, ?);"),

    UPDATE("UPDATE cruise " +
            "SET duration = ?, number_of_ports = ?," +
            " price = ?, start_date = ?, ship_id = ?, cruise_name = ?" +
            "WHERE id = ?"),
    DELETE("");


    String query;
    CruiseQuery(String query){
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
