package com.webizera.facility_booking_system.controller;

import com.webizera.facility_booking_system.dto.BookingRequest;
import com.webizera.facility_booking_system.dto.BookingResponse;
import com.webizera.facility_booking_system.service.BookingService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class BookingController {
    private final BookingService bookingService ;

    //create a booking
    @PostMapping
    public ResponseEntity<BookingResponse> createBooking(@Valid @RequestBody BookingRequest request){
        BookingResponse response = bookingService.createBooking(request);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    // get all bookings
    @GetMapping
    public ResponseEntity<List<BookingResponse>> getBookings(){
        return ResponseEntity.ok(bookingService.getBookings());
    }
    // get all bookings for a specific user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BookingResponse>> getUserBookings(@PathVariable Long userId){
        return ResponseEntity.ok(bookingService.getUserBookings(userId));
    }
}
