package com.tweteroo.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tweteroo.api.Models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long > {
    
}
