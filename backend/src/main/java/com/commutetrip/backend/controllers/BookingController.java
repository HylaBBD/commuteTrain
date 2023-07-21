package com.commutetrip.backend.controllers;

import com.commutetrip.backend.database.entities.CommuterBookingEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.commutetrip.backend.services.CommuterBookingService;

@RequiredArgsConstructor
@Tag(name = "Bookings")
@RestController
@RequestMapping("api/commute-train/bookings")
public class BookingController {
    private final CommuterBookingService commuterBookingService;

    @Operation(summary = "Get all Commuter Bookings", description = "Get an array of Commuter Bookings by either commuter id or truck route id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
    })
    @GetMapping("")
    public ResponseEntity<List<CommuterBookingEntity>> getBookings(
            @RequestParam(value = "commuterId", required = false)
            @Parameter( name = "commuterId", description = "Id of Commuter", example = "1")
            Long commuterId,
            @RequestParam(value = "truckRouteId", required = false)
            @Parameter(name = "truckRouteId", description = "Id of Truck Route", example = "1")
            Long truckRouteId
    ) {
        return new ResponseEntity<>(commuterBookingService.findBookings(commuterId, truckRouteId), HttpStatus.OK);
    }

    @Operation(summary = "Get a Commuter Bookings", description = "Get a Commuter Bookings by Booking Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
    })
    @GetMapping("/{bookingId}")
    public ResponseEntity<CommuterBookingEntity> getBooking(
            @PathVariable("bookingId")
            @Parameter( name = "bookingId", description = "Id of Booking", example = "1")
            Long bookingId
    ) {
        return commuterBookingService.findByBookingId(bookingId)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Create new Booking", description = "Create a Commuter Booking")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully Created"),
    })
    @PostMapping("")
    public ResponseEntity<CommuterBookingEntity> saveBooking(
            @RequestBody CommuterBookingEntity booking
    ) {
        return new ResponseEntity<>(commuterBookingService.saveBooking(booking), HttpStatus.CREATED);
    }
}
