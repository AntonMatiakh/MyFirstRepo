package com.academy.models;

public class Lecture {
    private long ID;
    public static long counter;

    private Homework homework;
    private ExtraMaterial extraMaterial;

    public Lecture() {
        ID = counter++;
    }
}
