package com.wipro.designpatterns.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Square implements Shape{

    Logger log = LoggerFactory.getLogger(Square.class);

    @Override
    public void draw() {
        log.info("Inside Square:: draw() method.");
    }
}
