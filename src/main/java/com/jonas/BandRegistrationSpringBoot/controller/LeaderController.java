package com.jonas.BandRegistrationSpringBoot.controller;


import com.jonas.BandRegistrationSpringBoot.DTO.leaderRequests.LeaderPostRequest;
import com.jonas.BandRegistrationSpringBoot.DTO.leaderRequests.LeaderPutRequest;
import com.jonas.BandRegistrationSpringBoot.domain.Leader;
import com.jonas.BandRegistrationSpringBoot.services.LeaderServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "Leaders")
@Log4j2
public class LeaderController {

    private final LeaderServices leaderServices;


    @GetMapping
    public ResponseEntity<Page<Leader>> findAll(Pageable pageable) {
        return new ResponseEntity<>(leaderServices.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Leader> findByID(@PathVariable Integer id) {
        return new ResponseEntity<>(leaderServices.findById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<Leader>> findByName(@RequestParam String leaderName) {
        return new ResponseEntity<>(leaderServices.findByName(leaderName), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Leader> save(@RequestBody LeaderPostRequest leaderPostRequest) {
        return new ResponseEntity<>(leaderServices.save(leaderPostRequest), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Leader> update(@RequestBody LeaderPutRequest leaderPutRequest) {
        return new ResponseEntity<>(leaderServices.update(leaderPutRequest), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        leaderServices.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
