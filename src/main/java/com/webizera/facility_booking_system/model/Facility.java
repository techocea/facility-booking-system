package com.webizera.facility_booking_system.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "facilities")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required and cannot be empty")
    @Size(min = 3, max = 30, message = "Name should be between 3 and 30 characters")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Description is required and cannot be empty")
    @Size(max = 250, message = "Description cannot exceed 250 characters")
    @Column(nullable = false)
    private String description;

    private Integer capacity;

    @Column(nullable = false)
    private BigDecimal hourlyRate;

    @Builder.Default
    private Boolean isActive = true;

    @Builder.Default
    private Boolean requiresApproval = false;

    // many facilities belong to one category
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private FacilityCategory category;
}
