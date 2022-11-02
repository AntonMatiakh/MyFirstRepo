package com.academy.models;

public class Teacher {
    private long ID;
    public static long counter;

    public Teacher() {
        ID = counter++;
    }
}
