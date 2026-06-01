package com.jonas.BandRegistrationSpringBoot.DTO.bandRequests;

import lombok.Data;

@Data
public class BandPutRequest {

    private Integer id;
    private Integer leaderId;
    private String bandName;
    private Integer numMembers;
}
