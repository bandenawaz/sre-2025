package com.property_management_system.tenant_service.service;

import com.property_management_system.tenant_service.model.Tenant;
import com.property_management_system.tenant_service.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantService {
    //Reference to TenantRepository
    private final TenantRepository tenantRepository;

    //Inject the dependency via constructor injection
    @Autowired
    public TenantService(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    //Add a tenant
    public Tenant addTenant(Tenant tenant) {
        return tenantRepository.save(tenant);
    }
    //Get all tenants
    public List<Tenant> getAllTenants() {
        return tenantRepository.findAll();
    }

    //Get a tenant by id
    public Tenant getTenantById(Long id) {
        return tenantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tenant not found"));
    }

    //Update a tenant
    public Tenant updateTenant(Long id, Tenant tenant) {
        tenant.setId(id);
        return tenantRepository.save(tenant);
    }

    //Delete a tenant
    public void deleteTenant(Long id) {
        tenantRepository.deleteById(id);
    }
}
