package com.commutetrip.backend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.commutetrip.backend.database.entities.CommuterBookingEntity;
import com.commutetrip.backend.services.CommuterBookingService;
import com.commutetrip.backend.models.CommuterBooking;

@RequiredArgsConstructor
@Tag(name = "Bookings")
@RestController
@RequestMapping("api/commute-train/bookings")
@OpenAPIDefinition(servers = { @Server(url = "/", description = "Default Server URL") })
public class BookingController {
        private final CommuterBookingService commuterBookingService;

        @Operation(summary = "Get all Commuter Bookings", description = "Get an array of Commuter Bookings by the logged in Commuter and or the truck route id")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
        })
        @GetMapping("")
        public ResponseEntity<List<CommuterBooking>> getBookings(
                        @RequestParam(value = "truckRouteId", required = false) @Parameter(name = "truckRouteId", description = "Id of Truck Route", example = "1") Long truckRouteId) {
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                String sub = "";
                if (authentication.getPrincipal() instanceof OidcUser) {
                        OidcUser principal = ((OidcUser) authentication.getPrincipal());
                        sub =  principal.getClaim("sub").toString();
                }
                return new ResponseEntity<>(commuterBookingService.findBookings(sub, truckRouteId),
                                HttpStatus.OK);
        }

        @Operation(summary = "Get a Commuter Bookings", description = "Get a Commuter Bookings by Booking Id")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
                        @ApiResponse(responseCode = "404", description = "Not Found"),
        })
        @GetMapping("/{bookingId}")
        public ResponseEntity<CommuterBooking> getBooking(
                        @PathVariable("bookingId") @Parameter(name = "bookingId", description = "Id of Booking", example = "1") Long bookingId) {
                return commuterBookingService.getBooking(bookingId)
                                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }

        @Operation(summary = "Create new Booking", description = "Create a Commuter Booking")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "201", description = "Successfully Created"),
                        @ApiResponse(responseCode = "400", description = "Bad Request"),
        })
        @PostMapping("")
        public ResponseEntity<CommuterBooking> saveBooking(@RequestParam long truckRouteId) {
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                String sub = "";
                if (authentication.getPrincipal() instanceof OidcUser) {
                        OidcUser principal = ((OidcUser) authentication.getPrincipal());

                        sub = principal.getClaim("sub").toString();
                }
                CommuterBookingEntity commuterBooking = new CommuterBookingEntity();
                commuterBooking.setTruckRouteId(truckRouteId);
                return commuterBookingService.saveBooking(commuterBooking, sub)
                                .map(value -> new ResponseEntity<>(value, HttpStatus.CREATED))
                                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }
}
