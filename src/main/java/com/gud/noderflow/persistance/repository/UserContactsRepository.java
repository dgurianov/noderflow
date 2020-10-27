package com.gud.noderflow.persistance.repository;

import com.gud.noderflow.persistance.entity.UserContactsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserContactsRepository extends JpaRepository<UserContactsEntity, String> {
}
