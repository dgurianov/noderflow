package com.gud.noderflow.core;

import com.gud.noderflow.cache.NoderflowCache;
import com.gud.noderflow.model.attributes.transactions.MoneyTransaction;
import com.gud.noderflow.model.attributes.users.UserEntityAttributes;
import com.gud.noderflow.publish.EventPublisher;
import com.gud.noderflow.publish.NoderflowEvent;
import com.gud.noderflow.publish.PublishSystem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
@Slf4j
public class MoneyTransactionGenerator {

    @Autowired
    @Qualifier("kafka-publisher")
    private EventPublisher publisher;

    @Autowired
    NoderflowCache<UserEntityAttributes> cache;

    @Scheduled(fixedRate = 5000)
    private void generateAndPublish(){
            List<UserEntityAttributes> two =  cache.getTwoRandom();
            if(two.size() < 2 ){
                log.info("Not enough accounts in the cache");
            }else {
                MoneyTransaction moneyTransaction =
                        new MoneyTransaction(
                                new BigDecimal(ThreadLocalRandom.current().nextInt(0,500)),
                                two.get(0).getPaymentData().getAccountNumber(),
                                two.get(1).getPaymentData().getAccountNumber());

                NoderflowEvent<MoneyTransaction> mytop = new NoderflowEvent<>(PublishSystem.KAFKA, "mytop", moneyTransaction);
                publisher.publish(mytop);
                log.info("Published money transaction {}",moneyTransaction );
            }

    }
}
