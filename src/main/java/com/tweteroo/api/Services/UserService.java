package com.tweteroo.api.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tweteroo.api.DTOs.UserDTO;
import com.tweteroo.api.Models.UserModel;
import com.tweteroo.api.Repositories.UserRepository;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> findUsers() {
        return userRepository.findAll();
    }

    public Optional<UserModel> createUsers(UserDTO userDTO) {
        boolean userExist = userRepository.existsByUsername(userDTO.getUsername());

        if (userExist)
            return Optional.empty();

        UserModel user = new UserModel(userDTO);

        return Optional.of(userRepository.save(user));
    }
}
