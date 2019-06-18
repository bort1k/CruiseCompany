package com.bortni.model;

import java.util.List;

public class Ship {
    private int id;
    private String name;
    private int passengerCapacity;
    private int releaseYear;
    private String imageUrl;
    private Personal personal;
    private List cruises;


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

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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


    public Ship() {
    }

    public Ship(int id, String name, int passenger_capacity, int releaseYear, Personal personal, List cruises, String image_url) {
        this.id = id;
        this.name = name;
        this.passengerCapacity = passenger_capacity;
        this.releaseYear = releaseYear;
        this.personal = personal;
        this.cruises = cruises;
        this.imageUrl = image_url;
    }


    @Override
    public String toString() {
        return "Ship{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passengerCapacity=" + passengerCapacity +
                ", releaseYear=" + releaseYear +
                ", image_url=" + imageUrl +
                ", personal=" + personal +
                ", cruises=" + cruises +
                '}';
    }
}
