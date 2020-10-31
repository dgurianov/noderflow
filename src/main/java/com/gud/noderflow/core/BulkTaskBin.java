package com.gud.noderflow.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component("bulk-order-storage")
@Slf4j
public class BulkTaskBin {

    private BlockingQueue<BulkOrderTask> orderQueue = new LinkedBlockingQueue<>();

    public BulkOrderTask getNext(){
        try {
            return orderQueue.take();
        } catch (InterruptedException exc){
            log.error(exc.getMessage());
        }
        return null;
    }

    public void newTask(BulkOrderTask task){
        orderQueue.add(task);
    }

    public boolean isEmpty(){
        return orderQueue.isEmpty();
    }

}
