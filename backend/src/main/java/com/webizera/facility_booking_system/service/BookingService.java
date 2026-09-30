package com.webizera.facility_booking_system.service;

import com.webizera.facility_booking_system.dto.BookingRequest;
import com.webizera.facility_booking_system.dto.BookingResponse;
import com.webizera.facility_booking_system.exception.BookingConflictException;
import com.webizera.facility_booking_system.exception.ResourceNotFoundException;
import com.webizera.facility_booking_system.model.*;
import com.webizera.facility_booking_system.model.enums.BookingStatus;
import com.webizera.facility_booking_system.repository.BookingRepository;
import com.webizera.facility_booking_system.repository.FacilityRepository;
import com.webizera.facility_booking_system.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingService  {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final FacilityRepository facilityRepository;

    @Transactional
    public BookingResponse createBooking(BookingRequest request){
        //validating chronological order of time bounds
        if(!request.getEndTime().isAfter(request.getStartTime())){
            throw new IllegalArgumentException("End time must be after start time");
        }

        //verify user and facility existence
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(()-> new ResourceNotFoundException("User not found with id: " + request.getUserId()));

        Facility facility = facilityRepository.findById(request.getFacilityId())
                .orElseThrow(()-> new ResourceNotFoundException("Facility not found with id: " + request.getFacilityId()));

        if (!facility.getIsActive()){
            throw new IllegalArgumentException("This facility is currently inactive for maintenance");
        }

        //check for slot collisions
        List<BookingStatus> activeStatuses = List.of(BookingStatus.PENDING, BookingStatus.CONFIRMED);
        boolean hasOverlap = bookingRepository.existsOverlappingBooking(
                facility.getId(),
                request.getStartTime(),
                request.getEndTime(),
                activeStatuses
        );

        if(hasOverlap){
            throw new BookingConflictException("This facility is already reserved for the selected time slot.");
        }

        //calculate duration and price calculation
        long hours = Duration.between(request.getStartTime(), request.getEndTime()).toHours();
        if(hours < 1){
            hours = 1; // minimum unit is 1h
        }

        BigDecimal totalAmount = facility.getHourlyRate().multiply(BigDecimal.valueOf(hours));

        //setting status according to approval necessity
        BookingStatus initialStatus = facility.getRequiresApproval() ? BookingStatus.PENDING : BookingStatus.CONFIRMED;

        //build domain model entity
        Booking booking = Booking.builder()
                .user(user)
                .facility(facility)
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .totalAmount(totalAmount)
                .status(initialStatus)
                .build();

        Booking savedBooking = bookingRepository.save(booking);
        return mapToResponse(savedBooking);
    }

    @Transactional(readOnly = true)
    public List<BookingResponse> getBookings(){
        return bookingRepository.findAll()
                .stream()
                .map(this::mapToResponse) //booking -> this.mapToResponse
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<BookingResponse> getUserBookings(Long userId){
        return bookingRepository.findByUserId(userId)
                .stream()
                .map(this::mapToResponse) //booking -> this.mapToResponse
                .collect(Collectors.toList());
    }

    // Helper mapper to convert Entity -> DTO
    private BookingResponse mapToResponse(Booking booking) {
        return BookingResponse.builder()
                .id(booking.getId())
                .facilityId(booking.getFacility().getId())
                .facilityName(booking.getFacility().getName())
                .userId(booking.getUser().getId())
                .userName(booking.getUser().getName())
                .startTime(booking.getStartTime())
                .endTime(booking.getEndTime())
                .totalAmount(booking.getTotalAmount())
                .status(booking.getStatus())
                .createdAt(booking.getCreatedAt())
                .build();
    }
}
