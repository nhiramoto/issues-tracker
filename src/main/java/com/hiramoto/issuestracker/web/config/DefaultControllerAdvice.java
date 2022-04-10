package com.hiramoto.issuestracker.web.config;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import com.hiramoto.issuestracker.model.dto.GenericDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DefaultControllerAdvice {

    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public GenericDTO constraintViolationHandler(ConstraintViolationException ex) {
        GenericDTO response = new GenericDTO();
        for (ConstraintViolation c : ex.getConstraintViolations()) {
            response.addError(c.getMessage());
        }
        return response;
    }

}