package com.jonas.BandRegistrationSpringBoot.DTO.bandRequests;

import lombok.Data;

@Data
public class BandPostRequest {
    private Integer leaderId;
    private String bandName;
    private Integer numMembers;
}
