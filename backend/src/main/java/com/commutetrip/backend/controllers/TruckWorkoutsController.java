package com.commutetrip.backend.controllers;

import com.commutetrip.backend.models.TruckWorkouts;
import com.commutetrip.backend.services.WorkoutService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Tag(name = "Workouts")
@RestController
@RequestMapping("api/commute-train/workouts")
@OpenAPIDefinition(servers = { @Server(url = "/", description = "Default Server URL") })
public class TruckWorkoutsController {
    private final WorkoutService workoutService;

    @Operation(summary = "Get a Truck Workouts", description = "Get a Truck Workouts by Booking Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
    })
    @GetMapping("/{bookingId}")
    public ResponseEntity<TruckWorkouts> getTruckWorkout(
            @PathVariable("bookingId") @Parameter(name = "bookingId", description = "Id of Booking", example = "1") Long bookingId) {
        return workoutService.getWorkout(bookingId)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
