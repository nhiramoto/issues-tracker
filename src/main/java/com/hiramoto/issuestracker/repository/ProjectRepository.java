package com.hiramoto.issuestracker.repository;

import org.springframework.stereotype.Repository;

import com.hiramoto.issuestracker.model.persistent.Project;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer> {
    
}
