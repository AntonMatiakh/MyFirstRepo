package com.academy.models;

public class ExtraMaterial {
    private long ID;
    public static long counter;

    public ExtraMaterial() {
        ID = counter++;
    }
}
