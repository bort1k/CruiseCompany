package com.bortni.dao.sql_queries;

public enum TourQuery {
    SELECT_ALL("SELECT * FROM tour"),

    SELECT_ALL_BY_CRUISE_ID_WITH_HARBOR("SELECT tour.id, tour.tour_name, tour.price, harbor_name FROM tour, harbor, cruise_in_harbor " +
            "WHERE tour.harbor_id = harbor.id AND harbor.id = cruise_in_harbor.harbor_id AND cruise_id = ?"),

    SELECT_ONE("SELECT * FROM tour WHERE id = ?;"),

    INSERT("INSERT INTO harbor " +
            "" +
            "VALUES (?, ?, ? ,?, ?, ?);"),

    UPDATE("UPDATE harbor " +
            "" +
            "WHERE id = ?"),
    DELETE("");

    private String query;
    TourQuery(String query){
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
