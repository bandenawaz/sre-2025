package com.property_management_system.property_service.service;

import com.property_management_system.property_service.model.Property;
import com.property_management_system.property_service.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {
    //Create reference to PropertyRepository
    private final PropertyRepository propertyRepository;
    //Inject PropertyRepository
    @Autowired
    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    //lets write the method to add property of return type Property
    public Property addProperty(Property property) {
        return propertyRepository.save(property);
    }

    //method to get all the properties
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    //method to get property by id
    public Property getProperty(Long id) {
        return propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found"));
    }

    //method to update property
    public Property updateProperty(Long id, Property property) {
        property.setId(id);
        return propertyRepository.save(property);
    }

    //method to delete property
    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }

    //method to find property by price less than or equal
    public List<Property> findPropertiesByPriceLessThanEqual(Double price) {
        return propertyRepository.findByPriceLessThanEqual(price);
    }

    //method to find property by size greater than or equal
    public List<Property> findPropertiesBySizeGreaterThanEqual(Double size) {
        return propertyRepository.findBySizeGreaterThanEqual(size);
    }

    //method to find property by location by ignoring case
    public List<Property> findPropertiesByLocationContainingIgnoreCase(String location) {
        return propertyRepository.findByLocationContainingIgnoreCase(location);
    }

}
