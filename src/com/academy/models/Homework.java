package com.academy.models;

public class Homework {
    private long ID;
    public static long counter;

    public Homework() {
        ID = counter++;
    }
}
