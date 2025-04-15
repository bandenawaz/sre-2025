package com.example.spm.property_service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "properties")
@Builder
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String ownerName;
    private Double price;
    private Double size;

    public Property() {
    }

    public Property(Long id, String address, String ownerName, Double price, Double size) {
        this.id = id;
        this.address = address;
        this.ownerName = ownerName;
        this.price = price;
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }
}
