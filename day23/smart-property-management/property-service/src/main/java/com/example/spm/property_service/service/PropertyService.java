package com.example.spm.property_service.service;

import com.example.spm.property_service.dto.PropertyDTO;
import com.example.spm.property_service.model.Property;
import com.example.spm.property_service.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class PropertyService {

    private final PropertyRepository repository;

    @Autowired
    public PropertyService(PropertyRepository repository) {
        this.repository = repository;
    }

    //write a method to list all properties
    public List<PropertyDTO> getAllProperties(){
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    //get property by iD
    public PropertyDTO getPropertyById(Long id){
        return repository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Property Not found"));
    }

    //crete a property
    public PropertyDTO createProperty(PropertyDTO dto){
        Property property = new Property();
        BeanUtils.copyProperties(dto, property);
        Property savedProperty= repository.save(property);
        return toDTO(savedProperty);
    }

    //lets update the property
    public PropertyDTO updateProperty(Long id, PropertyDTO dto){
        Property property = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property Not Found"));
        BeanUtils.copyProperties(dto,property, "id");
        return toDTO(repository.save(property));
    }

    //delete the property by id
    public void deleteProperty(Long id){
        repository.deleteById(id);
    }

    private PropertyDTO toDTO(Property property){
        return PropertyDTO.builder()
                .id(property.getId())
                .address(property.getAddress())
                .ownerName(property.getOwnerName())
                .price(property.getPrice())
                .size(property.getSize())
                .build();
    }
}
