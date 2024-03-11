package com.wipro.streams;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FunctionalInterfaceImpl {
    public static void main(String[] args) {

        Logger log = LoggerFactory.getLogger(FunctionalInterface.class);


        IntegerOperation addition = (a, b) -> a+b;
        IntegerOperation subtraction = (a, b) -> a-b;
        IntegerOperation multiplication = (a, b) -> a*b;

        int result1 = addition.operate(5,3);
        int result2 = subtraction.operate(10,4);
        int result3 = multiplication.operate(6,7);

        log.info("Result of addition : " + result1);
        log.info("Result of subtraction : " + result2);
        log.info("Result of multiplication : " + result3);
    }
}
