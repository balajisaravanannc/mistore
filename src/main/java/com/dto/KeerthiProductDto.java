package com.dto;

public class KeerthiProductDto {
    private int id;
    private String name;
    private String description;
    private String price;
    private String manufacture_date;
    private boolean available;
    private String manufacture_company;
    private double cost;
    private double usd;
    private double inr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacture_date() {
        return manufacture_date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setManufacture_date(String manufacture_date) {
        this.manufacture_date = manufacture_date;
    }

    public boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getManufacture_company() {
        return manufacture_company;
    }

    public void setManufacture_company(String manufacture_company) {
        this.manufacture_company = manufacture_company;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getUsd() {
        return usd;
    }

    public void setUsd(double usd) {
        this.usd = usd;
    }

    public double getInr() {
        return inr;
    }

    public void setInr(double inr) {
        this.inr = inr;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
                + ", manufacture_date=" + manufacture_date + ", available=" + available + ", manufacture_company="
                + manufacture_company + ", cost=" + cost + ", usd=" + usd + ", inr=" + inr + "]";
    }
}
