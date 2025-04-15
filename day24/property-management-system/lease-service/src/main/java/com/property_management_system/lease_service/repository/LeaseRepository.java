package com.property_management_system.lease_service.repository;

import com.property_management_system.lease_service.model.Lease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaseRepository extends JpaRepository<Lease, Long> {

    List<Lease> findByTenantId(Long tenantId); // Find leases by tenant ID <1>
    List<Lease> findByPropertyId(Long propertyId);
}
