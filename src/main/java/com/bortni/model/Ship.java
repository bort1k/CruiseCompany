package com.bortni.model;

import java.util.List;

public class Ship {
    private int id;
    private String name;
    private int passenger_capacity;
    private Personal personal;
    private List cruises;

    public Ship(int id, String name, int passenger_capacity, Personal personal, List cruises) {
        this.id = id;
        this.name = name;
        this.passenger_capacity = passenger_capacity;
        this.personal = personal;
        this.cruises = cruises;
    }

    public Ship() {

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

    public int getPassenger_capacity() {
        return passenger_capacity;
    }

    public void setPassenger_capacity(int passenger_capacity) {
        this.passenger_capacity = passenger_capacity;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public List getCruises() {
        return cruises;
    }

    public void setCruises(List cruises) {
        this.cruises = cruises;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passenger_capacity=" + passenger_capacity +
                ", personal=" + personal +
                ", cruises=" + cruises +
                '}';
    }
}
