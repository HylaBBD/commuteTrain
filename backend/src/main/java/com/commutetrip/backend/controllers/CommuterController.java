package com.commutetrip.backend.controllers;

import org.springframework.http.HttpHeaders;
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

import com.commutetrip.backend.services.CommuterService;
import com.commutetrip.backend.models.Commuter;

@RequiredArgsConstructor
@Tag(name = "Commuters")
@RestController
@RequestMapping("api/commute-train/commuters")
public class CommuterController {
    private final CommuterService commuterService;

    @Operation(summary = "Get all Commuters", description = "Returns an array of Commuters")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
    })
    @GetMapping("")
    public ResponseEntity<List<Commuter>> getAllCommuters() {
        return new ResponseEntity<>(commuterService.findAllCommuters(), HttpStatus.OK);
    }

    @Operation(summary = "Get a Commuter", description = "Get a Commuter by either Name or Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
    })
    @GetMapping("/commuter")
    public ResponseEntity<Commuter> getCommuter(
            @RequestParam(value = "name", required = false)
            @Parameter( name = "name", description = "Name of Commuter", example = "Jeff Surname")
            String name,
            @RequestParam(value = "id", required = false)
            @Parameter(name = "id", description = "Id of Commuter", example = "1")
            Long id
    ) {
        return commuterService.findCommuter(name, id)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Commuter Sign Up", description = "Sign Up and create a Commuter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully Created"),
    })
    @PostMapping("/sign-up")
    public ResponseEntity<Commuter> commuterSignUp(
            @RequestBody Commuter commuter
    ) {
        return new ResponseEntity<>(commuterService.commuterSignUp(commuter), HttpStatus.CREATED);
    }

    @Operation(summary = "Commuter Sign In", description = "Sign In for a Commuter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully SignIn"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
    })
    @PostMapping("/sign-ip")
    public ResponseEntity<Commuter> commuterSignIn(
            @RequestBody Commuter commuter
    ) {
        return commuterService.signIn(commuter)
                .map(value -> {
                    /*
                        We need to get the access token and send that back for the requests like making a booking.
                        We also need to get the token again on the other endpoints and validate that.
                            -> chat to team about the token validation.
                            -> would we need to call cognito on each request? to check the token:
                                note: I believe that we might need to, and check the refresh token as well.
                     */
                    HttpHeaders headers = new HttpHeaders();
                    headers.add("AccessToken", "blah-blah-blah");
                    return new ResponseEntity<>(value, headers, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}
