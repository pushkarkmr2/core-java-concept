package com.wipro.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronisedImpl {

    public static void main(String[] args) {

        Logger log = LoggerFactory.getLogger(SynchronisedImpl.class);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Counter counter = new Counter();

        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < 10; j++) {
                    counter.increment();
                    log.info("Executing increment by Thread {}  and its value is : {}"
                            ,Thread.currentThread().getName(), counter.getCount());
                }
            });
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        log.info("Final Count : " + counter.getCount());
    }

}
