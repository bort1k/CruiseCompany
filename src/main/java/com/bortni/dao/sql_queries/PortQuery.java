package com.bortni.dao.sql_queries;

public enum  PortQuery {
    SELECT_ALL("SELECT * FROM harbor"),

    SELECT_BY_CRUISE_ID("SELECT * FROM harbor, cruise_in_harbor WHERE cruise_in_harbor.harbor_id = harbor.id AND cruise_id = ?;"),

    SELECT_ONE("SELECT * FROM harbor WHERE id = ?;"),

    INSERT("INSERT INTO harbor " +
                   "" +
                   "VALUES (?, ?, ? ,?, ?, ?);"),

    UPDATE("UPDATE harbor " +
                   "" +
                   "WHERE id = ?"),
    DELETE("");


    private String query;
    PortQuery(String query){
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
