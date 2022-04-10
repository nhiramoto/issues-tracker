package com.hiramoto.issuestracker.web.config;

import com.hiramoto.issuestracker.model.dto.GenericDTO;
import com.hiramoto.issuestracker.model.dto.Response;
import com.hiramoto.issuestracker.model.persistent.User;
import com.hiramoto.issuestracker.web.exception.UserNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserControllerAdvice {

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Response<User> userNotFoundHandler(UserNotFoundException ex) {
        return new Response<User>().withError(ex.getMessage());
    }
    
}
