package com.gud.noderflow.persistance.repository;

import com.gud.noderflow.persistance.entity.UserAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepository extends JpaRepository<UserAddressEntity, String> {
}
