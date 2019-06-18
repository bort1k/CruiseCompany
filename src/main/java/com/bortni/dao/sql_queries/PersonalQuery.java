package com.bortni.dao.sql_queries;

public enum PersonalQuery {
    SELECT_ALL("SELECT * FROM personal"),

    SELECT_ONE("SELECT * FROM personal WHERE id = ?;"),

    SELECT_ONE_BY_SHIP_ID("SELECT * FROM personal WHERE ship_id = ?;"),

    INSERT("INSERT INTO personal " +
            "(captain_firstname, captain_lastname, technical_workers, hotel_workers, shop_workers)" +
            "VALUES (?, ?, ? ,?, ?);"),

    UPDATE("UPDATE personal " +
            "SET captain_firstname = ?, captain_lastname = ?," +
            " technical_workers = ?, hotel_workers = ?, shop_workers = ?" +
            "WHERE id = ?"),
    DELETE("");


    String query;
    PersonalQuery(String query){
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
