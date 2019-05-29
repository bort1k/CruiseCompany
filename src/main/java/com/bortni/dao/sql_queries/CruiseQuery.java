package com.bortni.dao.sql_queries;

import com.bortni.model.Cruise;

public enum CruiseQuery {
    SELECT_ALL("SELECT * FROM сruise"),

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
