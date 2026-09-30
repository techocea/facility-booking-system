package com.webizera.facility_booking_system.model;
import com.webizera.facility_booking_system.model.enums.PaymentMethod;
import com.webizera.facility_booking_system.model.enums.PaymentStatus;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.math.BigDecimal;

@Entity
@Table(name = "payments")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus paymentStatus;

    private String transactionId;

    private LocalDateTime paidAt;

    @OneToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;
}
