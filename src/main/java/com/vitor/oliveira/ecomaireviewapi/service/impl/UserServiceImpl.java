package com.vitor.oliveira.ecomaireviewapi.service.impl;

import com.vitor.oliveira.ecomaireviewapi.DTO.UserDTO;
import com.vitor.oliveira.ecomaireviewapi.model.User;
import com.vitor.oliveira.ecomaireviewapi.model.UserEntity;
import com.vitor.oliveira.ecomaireviewapi.repository.UserRepository;
import com.vitor.oliveira.ecomaireviewapi.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }

    public UserDTO convertUserToDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setEmail(userEntity.getEmail());
        userDTO.setFirstName(userEntity.getFirstName());
        userDTO.setLastName(userEntity.getLastName());
        return userDTO;
    }
    public User convertUserEntityToUser(UserEntity userEntity) {
        User user = new User();
        user.setId(UUID.fromString(userEntity.getId()));
        user.setEmail(userEntity.getEmail());
        user.setName(userEntity.getFirstName()+" "+userEntity.getLastName());
        user.setUsername(userEntity.getUsername());
        return user;
    }
}
