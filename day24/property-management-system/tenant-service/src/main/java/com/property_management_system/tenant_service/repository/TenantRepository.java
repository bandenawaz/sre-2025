package com.property_management_system.tenant_service.repository;

import com.property_management_system.tenant_service.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {
}
