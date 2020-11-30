package com.gud.noderflow.core;

import com.gud.noderflow.cache.NoderflowCache;
import com.gud.noderflow.model.attributes.transactions.MoneyTransaction;
import com.gud.noderflow.model.attributes.users.UserEntityAttributes;
import com.gud.noderflow.publish.NoderflowEvent;
import com.gud.noderflow.publish.PublishSystem;
import com.gud.noderflow.publish.kafka.KafkaPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
@Slf4j
public class BinWatcher implements ApplicationRunner {

    @Value("${bulk.order.queue.running.threads}")
    private String numberOfThreads;

    @Autowired
    @Qualifier("bulk-order-storage")
    private BulkTaskBin taskBin;

    private ExecutorService executor;

    @Autowired
    NoderflowCache<UserEntityAttributes> cache;

    @Autowired
    @Qualifier("kafka-publisher")
    private KafkaPublisher publisher;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(Objects.isNull(numberOfThreads)){
            numberOfThreads = String.valueOf(Runtime.getRuntime().availableProcessors());
        }

        log.info("Amount of threads for executor pool : {}",numberOfThreads);

        executor = Executors.newFixedThreadPool(Integer.parseInt(numberOfThreads));
        while(true){
            BulkOrderTask order = taskBin.getNext();
            executor.submit(order);
            List<UserEntityAttributes> two =  cache.getTwoRandom();
            if(two.size() < 2 ){
                log.info("Not enough accounts in the cache");
            }else {
                MoneyTransaction moneyTransaction = new MoneyTransaction(new BigDecimal(100.00), two.get(0).getPaymentData().getAccountNumber(),two.get(1).getPaymentData().getAccountNumber());
                NoderflowEvent<MoneyTransaction> mytop = new NoderflowEvent<>(PublishSystem.KAFKA, "mytop", moneyTransaction);
                publisher.publish(mytop);
            }
            log.info("Processed order {}",order);
        }

    }
}
