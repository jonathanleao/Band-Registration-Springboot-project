package com.jonas.BandRegistrationSpringBoot.exceptions.exceptionsDetails;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ExceptionsDetails {
    private String title;
    private Integer status;
    private LocalDateTime timestamp;
    private String message;
}
