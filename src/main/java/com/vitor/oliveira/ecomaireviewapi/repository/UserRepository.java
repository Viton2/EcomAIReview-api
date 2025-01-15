package com.vitor.oliveira.ecomaireviewapi.repository;

import com.vitor.oliveira.ecomaireviewapi.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}
