package com.gud.noderflow.persistance.repository;

import com.gud.noderflow.persistance.entity.UserPaymentDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPaymentDataRepository extends JpaRepository<UserPaymentDataEntity, String> {
}
