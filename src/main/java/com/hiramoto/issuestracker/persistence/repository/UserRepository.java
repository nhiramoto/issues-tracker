package com.hiramoto.issuestracker.persistence.repository;

import com.hiramoto.issuestracker.persistence.model.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
}
