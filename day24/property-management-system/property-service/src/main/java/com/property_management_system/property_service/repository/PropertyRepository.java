package com.property_management_system.property_service.repository;

import com.property_management_system.property_service.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

    //Custom queries
    //to find by location by ignoring case
    List<Property> findByLocationContainingIgnoreCase(String location);

    //to find by property by price less than or equal
    List<Property> findByPriceLessThanEqual(Double price);
    //to find by property by size greater than or equal
    List<Property> findBySizeGreaterThanEqual(Double size);
}
