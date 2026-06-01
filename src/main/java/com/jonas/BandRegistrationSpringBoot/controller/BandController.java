package com.jonas.BandRegistrationSpringBoot.controller;


import com.jonas.BandRegistrationSpringBoot.DTO.bandRequests.BandPostRequest;
import com.jonas.BandRegistrationSpringBoot.DTO.bandRequests.BandPutRequest;
import com.jonas.BandRegistrationSpringBoot.domain.Band;
import com.jonas.BandRegistrationSpringBoot.services.BandServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping (path = "Bands")
@Log4j2
public class BandController {

    private final BandServices bandServices;

    @GetMapping (path = "/{id}")
    public ResponseEntity<Band> findById(@PathVariable Integer id){
        return new ResponseEntity<>(bandServices.findById(id),HttpStatus.OK);
    }
    @GetMapping (path = "/find")
    public ResponseEntity<List<Band>> findByName(@RequestParam String bandName){
        return new ResponseEntity<>(bandServices.findByName(bandName),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Band> save(@RequestBody BandPostRequest bandPostRequest){
        return new ResponseEntity<>(bandServices.save(bandPostRequest), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Band> update (@RequestBody BandPutRequest bandPutRequest){
        return new ResponseEntity<>
                (bandServices.update(bandPutRequest), HttpStatus.OK);
    }
    @DeleteMapping (path = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Integer id){
        bandServices.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
