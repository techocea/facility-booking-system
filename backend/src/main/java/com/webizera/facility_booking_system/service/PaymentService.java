package com.webizera.facility_booking_system.service;

import com.webizera.facility_booking_system.exception.ResourceNotFoundException;
import com.webizera.facility_booking_system.model.Booking;
import com.webizera.facility_booking_system.model.Payment;
import com.webizera.facility_booking_system.model.enums.BookingStatus;
import com.webizera.facility_booking_system.model.enums.PaymentMethod;
import com.webizera.facility_booking_system.model.enums.PaymentStatus;
import com.webizera.facility_booking_system.repository.BookingRepository;
import com.webizera.facility_booking_system.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final BookingRepository bookingRepository;
    private final PaymentRepository paymentRepository;

    @Transactional
    public Payment processPayment(Long bookingId, PaymentMethod method){
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(()-> new ResourceNotFoundException("Booking not found with id: " + bookingId));

        if(booking.getStatus().equals(BookingStatus.CANCELLED)){
            throw new IllegalArgumentException("Cannot for a cancelled booking");
        }

        Payment payment = Payment.builder()
                .booking(booking)
                .amount(booking.getTotalAmount())
                .paymentMethod(method)
                .paymentStatus(PaymentStatus.COMPLETED)
                .transactionId("TXN-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase())
                .paidAt(LocalDateTime.now())
                .build();

        booking.setStatus(BookingStatus.CONFIRMED);
        bookingRepository.save(booking);

        return paymentRepository.save(payment);
    }


}
