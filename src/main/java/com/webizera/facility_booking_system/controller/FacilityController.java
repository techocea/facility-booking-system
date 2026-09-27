package com.webizera.facility_booking_system.controller;

import com.webizera.facility_booking_system.model.Facility;
import com.webizera.facility_booking_system.model.FacilityCategory;
import com.webizera.facility_booking_system.repository.FacilityCategoryRepository;
import com.webizera.facility_booking_system.repository.FacilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/facilities")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class FacilityController {
    private final FacilityRepository facilityRepository;
    private final FacilityCategoryRepository categoryRepository;

    //get all categories
    @GetMapping("/categories")
    public ResponseEntity<List<FacilityCategory>> getAllCategories(){
        return ResponseEntity.ok(categoryRepository.findAll());
    }

    // Get all active facilities
    @GetMapping
    public ResponseEntity<List<Facility>> getAllFacilities() {
        return ResponseEntity.ok(facilityRepository.findByIsActiveTrue());
    }

    // Get active facilities by category ID
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Facility>> getFacilitiesByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(facilityRepository.findByCategoryIdAndIsActiveTrue(categoryId));
    }
}
