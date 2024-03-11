package com.wipro.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadImpl {
    public static void main(String[] args) {

        Logger log = LoggerFactory.getLogger(ThreadImpl.class);

        List<Integer> list = Arrays.asList(4,2,6,7,23,8,65,87,43,56,98,53,34);

        CopyOnWriteArrayList<Integer> clist = new CopyOnWriteArrayList<>(list);

        WorkerThread thread1 = new WorkerThread(1,clist);
        WorkerThread thread2 = new WorkerThread(2,clist);
        WorkerThread thread3 = new WorkerThread(3,clist);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        log.info("All threads have finished execution.");


    }
}
