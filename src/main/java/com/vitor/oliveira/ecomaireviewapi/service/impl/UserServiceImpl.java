package com.vitor.oliveira.ecomaireviewapi.service.impl;

import com.vitor.oliveira.ecomaireviewapi.model.UserEntity;
import com.vitor.oliveira.ecomaireviewapi.repository.UserRepository;
import com.vitor.oliveira.ecomaireviewapi.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> getUser() {
        return userRepository.findAll();
    }
}
