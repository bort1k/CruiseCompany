package com.bortni.model;

import com.bortni.model.enums.Status;

import java.util.List;

public class Order {
    private int id;
    private Cruise cruise;
    private User user;
    private List<Bonus> bonuses;
    private Status status;
    private int sumPrice;

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cruise getCruise() {
        return cruise;
    }

    public void setCruise(Cruise cruise) {
        this.cruise = cruise;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Bonus> getBonuses() {
        return bonuses;
    }

    public void setBonuses(List<Bonus> bonuses) {
        this.bonuses = bonuses;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(int sumPrice) {
        this.sumPrice = sumPrice;
    }
}
