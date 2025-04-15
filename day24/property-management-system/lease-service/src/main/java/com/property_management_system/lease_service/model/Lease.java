package com.property_management_system.lease_service.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "leases")
public class Lease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double rentAmount;


    @Column(name = "tenant_id")
    private Long tenantId;

    @Column(name = "property_id")
    private Long propertyId;
    //Constructor
    public Lease(){}

    public Lease(Long id, LocalDate startDate, LocalDate endDate, Double rentAmount, Long tenantId, Long property) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentAmount = rentAmount;
        this.tenantId = tenantId;
        this.propertyId = property;
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public Double getRentAmount() {
        return rentAmount;
    }
    public void setRentAmount(Double rentAmount) {
        this.rentAmount = rentAmount;
    }
    public Long getTenantId() {
        return tenantId;
    }
    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }
    public Long getPropertyId() {
        return propertyId;
    }
    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }
}
