package com.jonas.BandRegistrationSpringBoot.DTO.leaderRequests;

import lombok.Data;

@Data
public class LeaderPutRequest {
    private Integer id;
    private String leaderName;
    private String surname;
}
