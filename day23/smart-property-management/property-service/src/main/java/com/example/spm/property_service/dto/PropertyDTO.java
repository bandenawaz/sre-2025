package com.example.spm.property_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class PropertyDTO {
    private Long id;
    private String address;
    private String ownerName;
    private Double price;
    private Double size;

    // Default constructor needed for deserialization
    public PropertyDTO() {}

    // Constructor for the builder to use
    PropertyDTO(Long id, String address, String ownerName, Double price, Double size) {
        this.id = id;
        this.address = address;
        this.ownerName = ownerName;
        this.price = price;
        this.size = size;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Double getSize() { return size; }
    public void setSize(Double size) { this.size = size; }

    public static PropertyDTOBuilder builder() {
        return new PropertyDTOBuilder();
    }
}

