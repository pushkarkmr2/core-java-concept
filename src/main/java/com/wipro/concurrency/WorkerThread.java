package com.wipro.concurrency;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Setter
@Getter
public class WorkerThread extends Thread{

    Logger log = LoggerFactory.getLogger(WorkerThread.class);

    private int threadId;
    private CopyOnWriteArrayList<Integer> clist;

    public WorkerThread(int threadId, CopyOnWriteArrayList<Integer> clist) {
        this.threadId = threadId;
        this.clist=clist;
    }

    @Override
    public void run(){
        log.info("Thread {} is executing.",threadId);
        CopyOnWriteArrayList<Integer> sublist = getSubList(clist,threadId,3);
        log.info("Thread {} is printing its sublist : {}", threadId , sublist);
        log.info("Thread {} finished execution.", threadId);
    }

    public CopyOnWriteArrayList<Integer> getSubList(List<Integer> list, int currentThreadNo, int totalThreads) {

        int j = list.size() / totalThreads;

        if (currentThreadNo == 1) {
            return new CopyOnWriteArrayList<>(list.subList(0, j));
        } else if (currentThreadNo == totalThreads) {
            return new CopyOnWriteArrayList<>(list.subList(((currentThreadNo - 1) * j), list.size()));
        } else {
            return new CopyOnWriteArrayList<>(list.subList(((currentThreadNo - 1) * j), currentThreadNo * j));
        }
    }

}

