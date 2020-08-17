package com.veloslyon.velib.controllers;

import com.veloslyon.velib.models.Stations;
import com.veloslyon.velib.services.StationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class StationController {

    @Autowired
    StationsService stationsService;

    @GetMapping("/stations/{number}")
    public Stations getStationByNumber(@PathVariable long number){
         Stations ourStation = stationsService.getStationByNumber(number);
         return ourStation;
    }

    @PostMapping("/stations")
    public ResponseEntity<Void> createStation(@RequestBody Stations station){

        stationsService.createStation(station);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{number}")
                .buildAndExpand(station.getNumber())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
