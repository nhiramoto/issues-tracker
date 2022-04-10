package com.hiramoto.issuestracker.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.ConstraintViolationException;

import com.hiramoto.issuestracker.model.dto.Response;
import com.hiramoto.issuestracker.model.persistent.User;
import com.hiramoto.issuestracker.repository.UserRepository;
import com.hiramoto.issuestracker.web.exception.UserNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController extends ApiController {

    @Autowired
    private UserRepository repository;

    @GetMapping({ "", "/" })
    public Response<List<User>> getAll() {
        List<User> allUsers = new ArrayList<>();
        repository.findAll().forEach(allUsers::add);
        return new Response<List<User>>(allUsers);
    }

    @PostMapping({ "", "/" })
    public Response<User> newUser(@RequestBody User newUser) {
        newUser = repository.save(newUser);
        return new Response<>(newUser);
    }

    @GetMapping("/{id}")
    public Response<User> one(@PathVariable Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return new Response<>(user);
    }
    
}
