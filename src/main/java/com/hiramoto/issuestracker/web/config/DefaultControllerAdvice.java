package com.hiramoto.issuestracker.web.config;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import com.hiramoto.issuestracker.model.dto.GenericDTO;
import com.hiramoto.issuestracker.model.dto.Response;
import com.hiramoto.issuestracker.model.persistent.User;
import com.hiramoto.issuestracker.model.dto.Response;
import com.hiramoto.issuestracker.web.exception.NotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DefaultControllerAdvice {

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public GenericDTO userNotFoundHandler(NotFoundException ex) {
        return new Response<>().withError(ex.getMessage());
    }

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