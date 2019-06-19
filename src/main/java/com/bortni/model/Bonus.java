package com.bortni.model;

public class Bonus {
    private int id;
    private String name;

    public Bonus() {
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

    @Override
    public String toString() {
        return "Bonus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
