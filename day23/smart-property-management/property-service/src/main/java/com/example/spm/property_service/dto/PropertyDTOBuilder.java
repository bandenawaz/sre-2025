package com.example.spm.property_service.dto;


public class PropertyDTOBuilder {
    private Long id;
    private String address;
    private String ownerName;
    private Double price;
    private Double size;

    public PropertyDTOBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public PropertyDTOBuilder address(String address) {
        this.address = address;
        return this;
    }

    public PropertyDTOBuilder ownerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    public PropertyDTOBuilder price(Double price) {
        this.price = price;
        return this;
    }

    public PropertyDTOBuilder size(Double size) {
        this.size = size;
        return this;
    }

    public PropertyDTO build() {
        return new PropertyDTO(id, address, ownerName, price, size);
    }
}