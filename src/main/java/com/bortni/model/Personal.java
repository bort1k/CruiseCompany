package com.bortni.model;

public class Personal {
    private int id;
    private String captainFirstName;
    private String captainLastName;
    private int numberOfTechnicalWorkers;
    private int numberOfHotelWorkers;
    private int numberOfShopWorkers;

    public Personal(int id, String captainFirstName, String captainLastName, int numberOfTechnicalWorkers, int numberOfHotelWorkers, int numberOfShopWorkers) {
        this.id = id;
        this.captainFirstName = captainFirstName;
        this.captainLastName = captainLastName;
        this.numberOfTechnicalWorkers = numberOfTechnicalWorkers;
        this.numberOfHotelWorkers = numberOfHotelWorkers;
        this.numberOfShopWorkers = numberOfShopWorkers;
    }

    public Personal() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaptainFirstName() {
        return captainFirstName;
    }

    public void setCaptainFirstName(String captainFirstName) {
        this.captainFirstName = captainFirstName;
    }

    public String getCaptainLastName() {
        return captainLastName;
    }

    public void setCaptainLastName(String captainLastName) {
        this.captainLastName = captainLastName;
    }

    public int getNumberOfTechnicalWorkers() {
        return numberOfTechnicalWorkers;
    }

    public void setNumberOfTechnicalWorkers(int numberOfTechnicalWorkers) {
        this.numberOfTechnicalWorkers = numberOfTechnicalWorkers;
    }

    public int getNumberOfHotelWorkers() {
        return numberOfHotelWorkers;
    }

    public void setNumberOfHotelWorkers(int numberOfHotelWorkers) {
        this.numberOfHotelWorkers = numberOfHotelWorkers;
    }

    public int getNumberOfShopWorkers() {
        return numberOfShopWorkers;
    }

    public void setNumberOfShopWorkers(int numberOfShopWorkers) {
        this.numberOfShopWorkers = numberOfShopWorkers;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "id=" + id +
                ", captainFirstName='" + captainFirstName + '\'' +
                ", captainLastName='" + captainLastName + '\'' +
                ", numberOfTechnicalWorkers=" + numberOfTechnicalWorkers +
                ", numberOfHotelWorkers=" + numberOfHotelWorkers +
                ", numberOfShopWorkers=" + numberOfShopWorkers +
                '}';
    }
}
