package com.property_management_system.lease_service.service;

import com.property_management_system.lease_service.dto.LeaseResponseDTO;
import com.property_management_system.lease_service.dto.PropertyDTO;
import com.property_management_system.lease_service.dto.TenantDTO;
import com.property_management_system.lease_service.model.Lease;
import com.property_management_system.lease_service.repository.LeaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class LeaseService {

    //Reference to the LeaseRepository
    private final LeaseRepository leaseRepository;
    private RestTemplate restTemplate;

    //Dependency injection
    @Autowired
    public LeaseService(LeaseRepository leaseRepository, RestTemplate restTemplate) {
        this.leaseRepository = leaseRepository;
        this.restTemplate = restTemplate;
    }

    public LeaseResponseDTO getLeaseWithDetails(Long leaseId){
        Lease lease = leaseRepository.findById(leaseId)
                .orElseThrow(() ->
                        new RuntimeException("No detail found for the given leaseID"));

        //Fetch Tenant
        TenantDTO tenant = restTemplate.getForObject(
                "http://TENANT-SERVICE/api/v1/tenants/"+lease.getTenantId(),
                TenantDTO.class
        );

        //Fetch the Property
        PropertyDTO property = restTemplate.getForObject(
                "http://PROPERTY-SERVICE/api/v1/properties/"+lease.getPropertyId(),
                PropertyDTO.class
        );
        return new LeaseResponseDTO(lease,tenant,property);
    }
    public TenantDTO getTenantByLeaseId(Long leaseId) {
        Lease lease = leaseRepository.findById(leaseId)
                .orElseThrow(() -> new RuntimeException("Lease not found with ID: " + leaseId));

        Long tenantId = lease.getTenantId();

        // Call Tenant Service via REST
        return restTemplate.getForObject(
                "http://TENANT-SERVICE/api/v1/tenants/" + tenantId,
                TenantDTO.class
        );
    }


    //get all leases
    public List<Lease> getAllLeases() {
        return leaseRepository.findAll();
    }

    //get lease by id
    public Lease getLeaseById(Long id) {
        return leaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lease not found"));
    }

    //get lease by tenant id
    public List<Lease> getLeasesByTenantId(Long tenantId) {
        return leaseRepository.findByTenantId(tenantId);
    }

    //get lease by property id
    public List<Lease> getLeasesByPropertyId(Long propertyId) {
        return leaseRepository.findByPropertyId(propertyId);
    }

    //create a new lease
    public Lease createLease(Lease lease) {
        return leaseRepository.save(lease);
    }

    //update a lease
    public Lease updateLease(Long id, Lease lease) {
        lease.setId(id);
        return leaseRepository.save(lease);
    }

    //delete a lease
    public void deleteLease(Long id) {
        leaseRepository.deleteById(id);
    }
}
