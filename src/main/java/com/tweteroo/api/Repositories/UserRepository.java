package com.tweteroo.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.Models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long > {
    
}
