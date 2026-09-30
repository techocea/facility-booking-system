package com.webizera.facility_booking_system.repository;

import com.webizera.facility_booking_system.model.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Long> {
    List<Facility> findByIsActiveTrue();
    List<Facility> findByCategoryIdAndIsActiveTrue(Long categoryId);
}
