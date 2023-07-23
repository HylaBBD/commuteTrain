package com.commutetrip.backend.controllers;

import com.commutetrip.backend.database.entities.CommuterBookingEntity;
import com.commutetrip.backend.models.CommuterBooking;
import com.commutetrip.backend.models.TruckRoute;
import com.commutetrip.backend.services.TruckRouteService;
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

@RequiredArgsConstructor
@Tag(name = "Truck-Routes")
@RestController
@RequestMapping("api/commute-train/truck-routes")
public class TruckRouteController {
    private final TruckRouteService truckRouteService;

    @Operation(summary = "Get all Truck Routes", description = "Get an array of Truck Routes or filter by routeId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
    })
    @GetMapping("")
    public ResponseEntity<List<TruckRoute>> getTruckRoutes(
            @RequestParam(value = "routeId", required = false)
            @Parameter( name = "routeId", description = "Id of Route", example = "1")
            Long routeId
    ) {
        return new ResponseEntity<>(truckRouteService.findTruckRoutes(routeId), HttpStatus.OK);
    }
    @Operation(summary = "Get a Truck Route", description = "Get a Truck Route by Truck Route Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
    })
    @GetMapping("/{truckRouteId}")
    public ResponseEntity<TruckRoute> getTruckRoute(
            @PathVariable("truckRouteId")
            @Parameter( name = "truckRouteId", description = "Id of Truck Route", example = "1")
            Long truckRouteId
    ) {
        return truckRouteService.getTruckRouteById(truckRouteId)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
