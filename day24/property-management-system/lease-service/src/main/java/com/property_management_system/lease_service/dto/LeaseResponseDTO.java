package com.property_management_system.lease_service.dto;

import com.property_management_system.lease_service.model.Lease;

import java.time.LocalDate;

public class LeaseResponseDTO {
    private Long leaseId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double rentAmount;
    private TenantDTO tenant;
    private PropertyDTO property;

    //constructor
    public LeaseResponseDTO(){}

    public LeaseResponseDTO(Lease lease, TenantDTO tenant, PropertyDTO property) {
        this.leaseId = lease.getId();
        this.startDate = lease.getStartDate();
        this.endDate = lease.getEndDate();
        this.rentAmount = lease.getRentAmount();
        this.tenant = tenant;
        this.property = property;
    }

    //getter and setters

    public Long getLeaseId() {
        return leaseId;
    }

    public void setLeaseId(Long leaseId) {
        this.leaseId = leaseId;
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

    public TenantDTO getTenant() {
        return tenant;
    }

    public void setTenant(TenantDTO tenant) {
        this.tenant = tenant;
    }

    public PropertyDTO getProperty() {
        return property;
    }

    public void setProperty(PropertyDTO property) {
        this.property = property;
    }
}
