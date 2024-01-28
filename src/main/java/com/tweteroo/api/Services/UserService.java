package com.tweteroo.api.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tweteroo.api.Models.UserModel;
import com.tweteroo.api.Repositories.UserRepository;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository= userRepository;
    }
    
    public List<UserModel> findUsers(){
        return userRepository.findAll();
    }

}
