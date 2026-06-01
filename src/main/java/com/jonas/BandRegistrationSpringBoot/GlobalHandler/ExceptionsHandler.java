package com.jonas.BandRegistrationSpringBoot.GlobalHandler;

import com.jonas.BandRegistrationSpringBoot.exceptions.BadRequestException;
import com.jonas.BandRegistrationSpringBoot.exceptions.NotFoundException;
import com.jonas.BandRegistrationSpringBoot.exceptions.exceptionsDetails.ExceptionsDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionsDetails> handlerBadRequestException(BadRequestException bre) {
        return new ResponseEntity<>(
                ExceptionsDetails.builder()
                        .title("Bad Request Exception")
                        .message(bre.getMessage())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .timestamp(LocalDateTime.now())
                        .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionsDetails> handlerExceptionDetails(NotFoundException not) {
        return new ResponseEntity<>(ExceptionsDetails.builder()
                .title("Not Found Exception")
                .message(not.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .timestamp(LocalDateTime.now())
                .build(), HttpStatus.NOT_FOUND);
    }
}
