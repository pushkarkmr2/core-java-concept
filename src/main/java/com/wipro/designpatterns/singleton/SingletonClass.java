package com.wipro.designpatterns.singleton;

public final class SingletonClass {

    private static volatile SingletonClass instance;

    public String value;

    private SingletonClass(String value) {
        this.value = value;
    }

    public static SingletonClass getInstance(String value) {
        SingletonClass result = instance;
        if (result != null) {
            return result;
        }
        synchronized(SingletonClass.class) {
            if (instance == null) {
                instance = new SingletonClass(value);
            }
            return instance;
        }
    }

}
