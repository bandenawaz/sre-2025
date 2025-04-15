package com.example.spm.property_service.controller;

import com.example.spm.property_service.dto.PropertyDTO;
import com.example.spm.property_service.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/properties")

public class PropertyController {

    private final PropertyService service;

    @Autowired
    public PropertyController(PropertyService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PropertyDTO>> getAllProperties(){
        return ResponseEntity.ok(service.getAllProperties());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyDTO> getPropertById(@PathVariable Long id){
        return ResponseEntity.ok(service.getPropertyById(id));

    }

    @PostMapping
    public ResponseEntity<PropertyDTO> addProperty(@RequestBody PropertyDTO dto){
        return ResponseEntity.ok(service.createProperty(dto));
    }

    //write the methods of update and delete
    @PutMapping("/{id}")
    public ResponseEntity<PropertyDTO> updateProperty(@PathVariable Long id,
                                                      @RequestBody PropertyDTO dto){
        return ResponseEntity.ok(service.updateProperty(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long id){
        service.deleteProperty(id);
        return ResponseEntity.noContent().build();
    }

}
