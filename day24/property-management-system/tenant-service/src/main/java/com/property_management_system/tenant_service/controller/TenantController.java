package com.property_management_system.tenant_service.controller;

import com.property_management_system.tenant_service.model.Tenant;
import com.property_management_system.tenant_service.service.TenantService;
import jakarta.ws.rs.PATCH;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tenants")
public class TenantController {

    //Reference to TenantService
    private final TenantService tenantService;

    //Constructor Injection
    @Autowired
    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    //Get all tenants
    @GetMapping
    public List<Tenant> getAllTenants() {
        return tenantService.getAllTenants();
    }

    //Get tenant by id
    @GetMapping("/{id}")
    public Tenant getTenantById(@PathVariable Long id) {
        return tenantService.getTenantById(id);
    }

    //Add a tenant
    @PostMapping
    public Tenant addTenant(@RequestBody Tenant tenant) {
        return tenantService.addTenant(tenant);
    }

    //Update a tenant
    @PutMapping("/{id}")
    public Tenant updateTenant(@PathVariable Long id,
                               @RequestBody Tenant tenant) {
        return tenantService.updateTenant(id, tenant);
    }

    //Delete a tenant
    @DeleteMapping("/{id}")
    public void deleteTenant(@PathVariable Long id) {
        tenantService.deleteTenant(id);
    }

}
