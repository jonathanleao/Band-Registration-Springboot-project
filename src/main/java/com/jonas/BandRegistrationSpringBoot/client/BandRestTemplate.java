package com.jonas.BandRegistrationSpringBoot.client;

import com.jonas.BandRegistrationSpringBoot.domain.Band;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Log4j2
public class BandRestTemplate {
    public static void main(String[] args) {
        ResponseEntity<Band> restTemplate = new RestTemplate()
                .getForEntity("http://localhost:8080/Bands/{id}", Band.class, 1);
        log.info(restTemplate);

    }
}
