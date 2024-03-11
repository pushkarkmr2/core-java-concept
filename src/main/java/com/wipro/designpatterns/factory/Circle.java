package com.wipro.designpatterns.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Circle implements Shape{

    Logger log = LoggerFactory.getLogger(Circle.class);

    @Override
    public void draw() {
        log.info("Inside Circle:: draw() method.");
    }
}
