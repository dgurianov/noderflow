package com.gud.noderflow.persistance.repository;

import com.gud.noderflow.persistance.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, String> {
}
