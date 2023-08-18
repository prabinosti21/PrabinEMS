package com.diyo.Event.Management.System.EMS.exception;

import com.diyo.Event.Management.System.EMS.model.ValidErrorResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<ValidErrorResponse>>handleInvalidDataException(ConstraintViolationException ex){
     List<ValidErrorResponse>validErrorResponseList = new ArrayList<>();
     ex.getConstraintViolations().forEach(fieldError->{
        validErrorResponseList.add(new ValidErrorResponse(fieldError.getPropertyPath().toString(), fieldError.getMessage()));
     });
     return ResponseEntity.badRequest().body(validErrorResponseList);
    }
}
