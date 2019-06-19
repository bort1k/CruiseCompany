package com.bortni.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Cruise {
    private int id;
    private String name;
    private int duration;
    private int numberOfPorts;
    private int price;
    private Date startDate;
    private Ship ship;
    private List ports;

    @Override
    public String toString() {
        return "Cruise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", numberOfPorts=" + numberOfPorts +
                ", price=" + price +
                ", startDate=" + startDate +
                ", ship=" + ship +
                ", ports=" + ports +
                '}';
    }

    public Cruise(int id, String name, int duration, int numberOfPorts, int price, Date start_date, Ship ship, List ports) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.numberOfPorts = numberOfPorts;
        this.price = price;
        this.startDate = start_date;
        this.ports = ports;
        this.ship = ship;
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

    public List getPorts() {
        return ports;
    }

    public void setPorts(List ports) {
        this.ports = ports;
    }

    public int getNumberOfPorts() {
        return numberOfPorts;
    }

    public void setNumberOfPorts(int numberOfPorts) {
        this.numberOfPorts = numberOfPorts;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

}
