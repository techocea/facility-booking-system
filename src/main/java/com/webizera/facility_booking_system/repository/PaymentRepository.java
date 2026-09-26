package com.webizera.facility_booking_system.repository;

import com.webizera.facility_booking_system.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository {
    Optional<Payment> findByBookingId(Long bookingId);
}
