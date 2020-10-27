package com.gud.noderflow.persistance.repository;

import com.gud.noderflow.persistance.entity.UserPaymentDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserPaymentDataRepository extends JpaRepository<UserPaymentDataEntity, String> {

    @Query(value = " select " +
            " * " +
            " from USER_PAYMENT_DATA upd " +
            " where " +
            " upd.account_number in (?1) ", nativeQuery = true)
     List<UserPaymentDataEntity> getPaymentDataEntitiesWithAccount(String accountNumber);
}
