package com.tka.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Laptop {

    @Id
    int id;

    String brand;
    String model;
    double price;

    public Laptop() {
        // TODO Auto-generated constructor stub
    }

    public Laptop(int id, String brand, String model, double price) {
        super();
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Laptop [id=" + id + ", brand=" + brand
                + ", model=" + model + ", price=" + price + "]";
    }
}