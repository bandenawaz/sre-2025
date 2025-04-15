package com.property_management_system.lease_service.controller;

import com.property_management_system.lease_service.dto.TenantDTO;
import com.property_management_system.lease_service.model.Lease;
import com.property_management_system.lease_service.service.LeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/leases")
public class LeaseController {

    //Reference to LeaseService
    private final LeaseService leaseService;

    //Dependency Injection
    @Autowired
    public LeaseController(LeaseService leaseService) {
        this.leaseService = leaseService;
    }

    //lets create a lease
    @PostMapping
    public Lease createLease(Lease lease) {
        return leaseService.createLease(lease);
    }

    //get all leases
    @GetMapping
    public List<Lease> getAllLeases() {
        return leaseService.getAllLeases();
    }

    //get lease by id
    @GetMapping("/{id}")
    public Lease getLeaseById(@PathVariable Long id) {
        return leaseService.getLeaseById(id);
    }

    //get lease by tenant id
    @GetMapping("/tenant/{tenantId}")
    public List<Lease> getLeasesByTenantId(@PathVariable Long tenantId){
        return leaseService.getLeasesByTenantId(tenantId);
    }

    //get leases by property id
    @GetMapping("/property/{propertyId}")
    public ResponseEntity<List<Lease>> getLeasesByPropertyId(@PathVariable("propertyId") Long propertyId) {
        List<Lease> leases = leaseService.getLeasesByPropertyId(propertyId);
        return ResponseEntity.ok(leases);
    }

    //update leases
    @PutMapping("/{id}")
    public Lease updateLease(@PathVariable Long id, @RequestBody Lease lease){
        return leaseService.updateLease(id, lease);
    }

    @DeleteMapping("/{id}")
    public void deleteLease(@PathVariable Long id){
        leaseService.deleteLease(id);
    }

    // Endpoint to get tenant details by lease ID
    @GetMapping("/{leaseId}/tenant")
    public ResponseEntity<TenantDTO> getTenantByLeaseId(@PathVariable Long leaseId) {
        TenantDTO tenant = leaseService.getTenantByLeaseId(leaseId);
        return ResponseEntity.ok(tenant);
    }
}
