package com.wipro.designpatterns.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rectangle implements Shape{

    Logger log = LoggerFactory.getLogger(Rectangle.class);

    @Override
    public void draw() {
        log.info("Inside Rectangle:: draw() method.");
    }
}
