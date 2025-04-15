package com.property_management_system.property_service.model;

import jakarta.persistence.*;

@Entity
@Table(name = "properties")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String name;
    private String address;
    private String location;
    private Double price;
    private Double size;

    //Constructor
    public Property() {}

    public Property(String name, String address, String location, Double price, Double size) {
        this.name = name;
        this.address = address;
        this.location = location;
        this.price = price;
        this.size = size;
    }
    //getters and setters
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getLocation() {
        return location;
    }
    public Double getPrice() {
        return price;
    }
    public Double getSize() {
        return size;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public void setSize(Double size) {
        this.size = size;
    }
}
