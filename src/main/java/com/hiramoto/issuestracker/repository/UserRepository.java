package com.hiramoto.issuestracker.repository;

import com.hiramoto.issuestracker.model.persistent.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
}
