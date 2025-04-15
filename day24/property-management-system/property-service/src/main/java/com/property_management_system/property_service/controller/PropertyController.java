package com.property_management_system.property_service.controller;

import com.property_management_system.property_service.model.Property;
import com.property_management_system.property_service.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/properties")
public class PropertyController {

    //Reference to PropertyService
    private final PropertyService propertyService;

    //Inject Constructor Dependency
    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    //method to get all the properties
    @GetMapping
    public List<Property> getAllProperties() {
        return propertyService.getAllProperties();
    }

    //method to get property by id
    @GetMapping("/{id}")
    public Property getProperty(@PathVariable Long id) {
        return propertyService.getProperty(id);
    }

    //method to add property
    @PostMapping
    public Property addProperty(@RequestBody Property property) {
        return propertyService.addProperty(property);
    }

    //method to update property
    @PutMapping("/{id}")
    public Property updateProperty(@PathVariable Long id,
                                   @RequestBody Property property) {
        return propertyService.updateProperty(id, property);
    }

    //method to delete property
    @DeleteMapping("/{id}")
    public void deleteProperty(@PathVariable Long id) {
        propertyService.deleteProperty(id);
    }


}
