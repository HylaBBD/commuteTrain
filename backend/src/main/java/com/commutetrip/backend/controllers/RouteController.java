package com.commutetrip.backend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.commutetrip.backend.models.Route;
import com.commutetrip.backend.services.RouteService;

@RequiredArgsConstructor
@Tag(name = "Routes")
@RestController
@RequestMapping("api/commute-train/routes")
public class RouteController {
    private final RouteService routeService;

    @Operation(summary = "Get all Routes", description = "Returns an array of Routes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
    })
    @GetMapping("")
    public ResponseEntity<List<Route>> getAllRoutes(
            @RequestParam(value = "staringPoint", required = false)
            @Parameter(name = "staringPoint", description = "Id of start truck stop", example = "1")
            Long staringPoint,
            @RequestParam(value = "endPoint", required = false)
            @Parameter(name = "endPoint", description = "Id of end truck stop", example = "1")
            Long endPoint
    ) {
        return new ResponseEntity<>(routeService.findRoutes(staringPoint, endPoint), HttpStatus.OK);
    }

    @Operation(summary = "Get a Route", description = "Get a Route by routeId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not Found"),

    })
    @GetMapping("/{routeId}")
    public ResponseEntity<Route> getRoute(
            @PathVariable("routeId")
            @Parameter(name = "routeId", description = "Id of Route", example = "1")
            Long routeId
    ) {
        return routeService.getRouteById(routeId)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
