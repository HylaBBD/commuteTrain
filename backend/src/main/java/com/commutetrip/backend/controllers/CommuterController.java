package com.commutetrip.backend.controllers;

import com.commutetrip.backend.database.entities.CommuterEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.commutetrip.backend.services.CommuterService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/commute-train/commuters")
public class CommuterController {
    private final CommuterService commuterService;

    @Operation(summary = "Get all Commuters", description = "Returns an Array of Commuters")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
    })
    @GetMapping("")
    public ResponseEntity<List<CommuterEntity>> getAllCommuters() {
        return new ResponseEntity<>(commuterService.findAllCommuters(), HttpStatus.OK);
    }

    @Operation(summary = "Get a Commuter", description = "Get a Commuter by either Name or Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
    })
    @GetMapping("/commuter")
    public ResponseEntity<CommuterEntity> getCommuter(
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

    @Operation(summary = "Create new Commuter", description = "Create a Commuter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully Created"),
    })
    @PostMapping("/commuter")
    public ResponseEntity<CommuterEntity> saveCommuter(
            @RequestBody CommuterEntity commuter
    ) {
        return new ResponseEntity<>(commuterService.saveCommuter(commuter), HttpStatus.CREATED);
    }
}
