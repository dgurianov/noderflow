package com.gud.noderflow.core;

import com.gud.noderflow.core.publish.NoderflowEvent;
import com.gud.noderflow.core.publish.kafka.KafkaEvent;
import com.gud.noderflow.core.publish.kafka.KafkaPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

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
            publisher.publish(KafkaEvent.builder().withPayload("test").build());
            log.info("Processed order {}",order);
        }

    }
}
