package com.hiramoto.issuestracker.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.hiramoto.issuestracker.persistence.model.User;
import com.hiramoto.issuestracker.persistence.repository.UserRepository;
import com.hiramoto.issuestracker.web.exception.UserNotFoundException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController extends ApiController {

    @Resource
    private UserRepository repository;

    @GetMapping({ "", "/" })
    public List<User> getAll() {
        List<User> allUsers = new ArrayList<>();
        repository.findAll().forEach(allUsers::add);

        User user = new User();
        user.setLogin("user");
        user.setEmail("user@email.com");
        user.setPassword("123098");
        allUsers.add(user);

        return allUsers;
    }

    @PostMapping({ "", "/" })
    public User newUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    @GetMapping("/{id}")
    public User one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
    
}
