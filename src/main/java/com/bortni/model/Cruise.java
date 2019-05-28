package com.bortni.model;

import java.util.Date;
import java.util.List;

public class Cruise {
    private int id;
    private String name;
    private int duration;
    private int price;
    private Date startDate;
    private Ship ship;
    private List<Port> ports;

    public Cruise(int id, String name, int duration, int price, Date start_date, Ship ship, List<Port> ports) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.price = price;
        this.startDate = start_date;
        this.ship = ship;
        this.ports = ports;
    }

    public Cruise() {

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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public List<Port> getPorts() {
        return ports;
    }

    public void setPorts(List<Port> ports) {
        this.ports = ports;
    }

}
