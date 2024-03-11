package com.wipro.designpatterns.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultiThreadSingletonImpl {
    public static void main(String[] args) {

        Thread threadFoo = new Thread(new ThreadFoo());
        Thread threadBar = new Thread(new ThreadBar());
        threadFoo.start();
        threadBar.start();
    }

    static class ThreadFoo implements Runnable {
        Logger log = LoggerFactory.getLogger(ThreadFoo.class);
        @Override
        public void run() {
            SingletonClass singleton = SingletonClass.getInstance("FOO");
            log.info(singleton.value);
        }
    }

    static class ThreadBar implements Runnable {
        Logger log = LoggerFactory.getLogger(ThreadBar.class);
        @Override
        public void run() {
            SingletonClass singleton = SingletonClass.getInstance("BAR");
            log.info(singleton.value);
        }
    }
}