package com.gud.noderflow.persistance.repository;

import com.gud.noderflow.persistance.entity.UserContactsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserContactsRepository extends JpaRepository<UserContactsEntity, String> {

    @Query(value = " select " +
            " * " +
            " from USER_CONTACTS uc " +
            " where " +
            " uc.phone in (?1) ", nativeQuery = true)
    List<UserContactsEntity> findAlLWithPhoneNumber(String phoneNumber);
}
