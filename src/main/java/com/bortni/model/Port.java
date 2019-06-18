package com.bortni.model;

import java.util.List;

public class Port {
    private int id;
    private String name;
    private List<Cruise> cruises;
    private List<Tour> tours;

    public Port() {
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

    public List<Cruise> getCruises() {
        return cruises;
    }

    public void setCruises(List<Cruise> cruises) {
        this.cruises = cruises;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    @Override
    public String toString() {
        return "Port{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cruises=" + cruises +
                ", tours=" + tours +
                '}';
    }
}
