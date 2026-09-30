package com.webizera.facility_booking_system.dto;

import com.webizera.facility_booking_system.model.enums.BookingStatus;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class BookingResponse {

    private Long id;
    private Long facilityId;
    private String facilityName;
    private Long userId;
    private String userName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private BigDecimal totalAmount;
    private BookingStatus status;
    private LocalDateTime createdAt;
}