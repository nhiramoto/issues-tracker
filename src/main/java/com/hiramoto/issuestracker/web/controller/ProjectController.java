package com.hiramoto.issuestracker.web.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.hiramoto.issuestracker.model.dto.Response;
import com.hiramoto.issuestracker.model.persistent.Project;
import com.hiramoto.issuestracker.repository.ProjectRepository;
import com.hiramoto.issuestracker.web.exception.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/projects", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProjectController extends ApiController {

    @Autowired
    private ProjectRepository repository;

    @GetMapping({ "", "/" })
    public Response<Collection<Project>> all() {
        List<Project> projects = new ArrayList<>();
        repository.findAll().forEach(projects::add);
        return new Response<>(projects);
    }

    @PostMapping({ "", "/" })
    public Response<Project> newProject(@RequestBody Project newProject) {
        newProject = repository.save(newProject);
        return new Response<>(newProject);
    }

    @GetMapping("/{id}")
    public Response<Project> show(@PathVariable Integer id) {
        Project project = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
        return new Response<>(project);
    }
    
}
