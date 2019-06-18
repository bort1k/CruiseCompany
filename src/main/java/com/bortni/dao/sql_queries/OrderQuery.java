package com.bortni.dao.sql_queries;

public enum OrderQuery {

    SELECT_ALL("SELECT * FROM user_order"),

    SELECT_ONE("SELECT * FROM user_order WHERE user_order.id = ?"),

    SELECT_ALL_BY_USER("SELECT * FROM user_order WHERE user_order.user_id = ?"),

    INSERT("INSERT INTO user_order" +
            "(user_id, cruise_id, status, sum_price)" +
            "VALUES (?, ?, ?, ?)"),

    UPDATE_STATUS("UPDATE user_order" +
            "SET status = ?" +
            "WHERE id = ?"),
    ;
    String query;
    OrderQuery(String query){
        this.query = query;
    }

    public String getQuery(){
        return this.query;
    }

}
