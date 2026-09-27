package com.webizera.facility_booking_system.repository;

import com.webizera.facility_booking_system.model.Booking;
import com.webizera.facility_booking_system.model.enums.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    //get all bookings for a specific user
    List<Booking> findByUserId(Long userId);

    //find all bookings for a specific facility
    List<Booking> findByFacilityId(Long facilityId);

    //overlapping logic check query
    @Query("""
            SELECT count(b) > 0 FROM Booking b
            WHERE b.facility.id = :facilityId
            AND b.status IN :activeStatuses
            AND :startTime < b.endTime
            AND :endTime > b.startTime
            """)
    boolean existsOverlappingBooking(
            @Param("facilityId") Long facilityId,
            @Param("startTime") LocalDateTime startTime,
            @Param("endTime") LocalDateTime endTime,
            @Param("activeStatuses") List<BookingStatus> activeStatuses
    );
}

