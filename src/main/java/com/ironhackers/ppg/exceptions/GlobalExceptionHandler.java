package com.ironhackers.ppg.exceptions;

import com.ironhackers.ppg.exceptions.custom.CantGenereteDiagnoseException;
import com.ironhackers.ppg.exceptions.custom.MissingIdException;
import com.ironhackers.ppg.exceptions.custom.EntityNotFoundException;
import com.ironhackers.ppg.exceptions.custom.SymptomAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    ResponseEntity<String> handlePatientNotFound(EntityNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(MissingIdException.class)
    ResponseEntity<String> handleMissingId(MissingIdException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(SymptomAlreadyExistsException.class)
    ResponseEntity<String> handleAlreadyExistingSymptom(SymptomAlreadyExistsException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(CantGenereteDiagnoseException.class)
    ResponseEntity<String> handleCantGenerateDiagnose(CantGenereteDiagnoseException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}
