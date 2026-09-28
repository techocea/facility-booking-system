package com.webizera.facility_booking_system.controller;


import com.webizera.facility_booking_system.model.Payment;
import com.webizera.facility_booking_system.model.enums.PaymentMethod;
import com.webizera.facility_booking_system.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/process")
    public ResponseEntity<Payment> processPayment(
            @RequestParam Long bookingId,
            @RequestParam PaymentMethod method) {
        Payment payment = paymentService.processPayment(bookingId, method);
        return ResponseEntity.ok(payment);
    }
}
