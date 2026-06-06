package com.jonas.BandRegistrationSpringBoot.client;

import com.jonas.BandRegistrationSpringBoot.domain.Leader;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Log4j2
public class LeaderRestTemplate {
    public static void main(String[] args) {
        ResponseEntity<Leader> forEntity = new RestTemplate()
                .getForEntity("http://localhost:8080/Leaders/{id}", Leader.class, 2);
        log.info(forEntity);
    }
}
