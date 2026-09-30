package com.webizera.facility_booking_system.repository;

import com.webizera.facility_booking_system.model.FacilityCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityCategoryRepository extends JpaRepository<FacilityCategory, Long> {
}
