package com.bortni.model;

import java.util.Date;
import java.util.List;

public class Cruise {
    private int id;
    private String name;
    private int duration;
    private int numberOfPorts;
    private int price;
    private Date startDate;
    private int ship_id;
    private List<Port> ports;

    public Cruise(int id, String name, int duration, int numberOfPorts, int price, Date start_date, int ship_id, List<Port> ports) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.numberOfPorts = numberOfPorts;
        this.price = price;
        this.startDate = start_date;
        this.ship_id = ship_id;
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

    public int getShipId() {
        return ship_id;
    }

    public void setShipId(int ship_id) {
        this.ship_id = ship_id;
    }

    public List<Port> getPorts() {
        return ports;
    }

    public void setPorts(List<Port> ports) {
        this.ports = ports;
    }

    public int getNumberOfPorts() {
        return numberOfPorts;
    }

    public void setNumberOfPorts(int numberOfPorts) {
        this.numberOfPorts = numberOfPorts;
    }
}
