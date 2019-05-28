package com.bortni.model;

public class Tour {
    private int id;
    private String name;
    private int price;
    private Port port;

    public Tour(int id, String name, int price, Port port) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.port = port;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Port getPort() {
        return port;
    }

    public void setPort(Port port) {
        this.port = port;
    }
}
