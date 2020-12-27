package com.gud.noderflow.service;

import com.gud.noderflow.core.MoneyTransactionGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;

import java.util.concurrent.ScheduledFuture;

@Service
@Slf4j
public class FlowService {

    @Autowired
    private MoneyTransactionGenerator generator;

    @Autowired
    private TaskScheduler taskScheduler;

    private ScheduledFuture<?> scheduledFuture;

    @Value("${noderflow.transaction.publish.interval.millisec}")
    private String publishPeriod;


    public void startService(){
        scheduledFuture = taskScheduler.scheduleAtFixedRate(generator.generateAndPublish(), Integer.parseInt(publishPeriod));
    }

    public void stopService(){
        scheduledFuture.cancel(false);

    }

}
