package com.commutetrip.backend.controllers;

import com.commutetrip.backend.models.Commuter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.commutetrip.backend.services.CommuterService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/commute-train")
public class CommuterController {
    private final CommuterService commuterService;
    private final String produces = "application/json";
    @Autowired
    public CommuterController(CommuterService commuterService) {
        this.commuterService = commuterService;
    }

    @RequestMapping(path = "/commuters", method = RequestMethod.GET, produces = produces)
    public ResponseEntity<List<Commuter>> getAllCommuters() {
        return new ResponseEntity<>(commuterService.findAllCommuters(), HttpStatus.OK);
    }

    @RequestMapping(path = "/commuter", method = RequestMethod.GET, produces = produces)
    public ResponseEntity<Commuter> getCommuter(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "id", required = false) Long id
    ) {
        return commuterService.findCommuter(name, id)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(path = "/commuter", method = RequestMethod.PUT, produces = produces)
    public ResponseEntity<Commuter> saveCommuter(
            @RequestBody Commuter commuter
    ) {
        return new ResponseEntity<>(commuterService.saveCommuter(commuter), HttpStatus.CREATED);
    }
}
