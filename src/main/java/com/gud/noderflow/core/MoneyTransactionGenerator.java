package com.gud.noderflow.core;

import com.gud.noderflow.cache.NoderflowCache;
import com.gud.noderflow.correlationid.CorrelationIdConstants;
import com.gud.noderflow.correlationid.CorrelationIdGenerator;
import com.gud.noderflow.model.attributes.transactions.MoneyTransaction;
import com.gud.noderflow.model.attributes.users.UserEntityAttributes;
import com.gud.noderflow.publish.EventPublisher;
import com.gud.noderflow.publish.NoderflowEvent;
import com.gud.noderflow.publish.PublishSystem;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
@Slf4j
public class MoneyTransactionGenerator {

    @Value("${noderflow.transaction.amount.max:500}")
    private int transactionAmountMax;

    @Autowired
    @Qualifier("kafka-publisher")
    private EventPublisher publisher;

    @Value("${noderflow.publish.kafka.topic.name}")
    private String transactionTopic;

    @Autowired
    NoderflowCache<UserEntityAttributes> cache;

    public Runnable generateAndPublish() {
        return () -> {
            List<UserEntityAttributes> two = cache.getTwoRandom();
            BigDecimal transferAmount =  new BigDecimal(ThreadLocalRandom.current().nextInt(0, transactionAmountMax)).movePointLeft(2);
            if (two.size() < 2) {
                log.info("Not enough accounts in the cache to perform money transaction.");
                return;
            }

            if (!MoneyTransactionValidator.isBalanceGreaterThanWithdrawAmount(two.get(0).getPaymentData().getAccountBalance(), transferAmount)) {
                log.info("Balance of account {} :  {} is lower than transfer amount {} ", two.get(0).getPaymentData().getAccountNumber(), two.get(0).getPaymentData().getAccountBalance(), transferAmount);
            } else {
                MDC.put(CorrelationIdConstants.LOG_CORRELATION_ID_NAME , CorrelationIdGenerator.getNewOrExisting(CorrelationIdConstants.LOG_CORRELATION_ID_NAME));
                MoneyTransaction moneyTransaction =
                        new MoneyTransaction(
                                MDC.get(CorrelationIdConstants.LOG_CORRELATION_ID_NAME),
                                transferAmount,
                                two.get(0).getPaymentData().getAccountNumber(),
                                two.get(1).getPaymentData().getAccountNumber());

                publisher.publish(new NoderflowEvent<>(PublishSystem.KAFKA, transactionTopic, moneyTransaction));
                withdraw(two.get(0), transferAmount);
                topUp(two.get(1), transferAmount);
                log.info("Published money transaction {}", moneyTransaction);
                MDC.remove(CorrelationIdConstants.LOG_CORRELATION_ID_NAME);
            }
        };

    }

    private void withdraw(UserEntityAttributes user, BigDecimal withdrawAmount) {
        user.getPaymentData().setAccountBalance(user.getPaymentData().getAccountBalance().subtract(withdrawAmount));
    }

    private void topUp(UserEntityAttributes user, BigDecimal topUpAmount) {
        user.getPaymentData().setAccountBalance(user.getPaymentData().getAccountBalance().add(topUpAmount));
    }

}
