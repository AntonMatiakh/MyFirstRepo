package com.academy.models;

public class Lecture {

    public static long counter;
    private long ID;
    public long courseID;
    private String name;

    private Homework homework;
    private ExtraMaterial extraMaterial;

    public Lecture(String name, long ID, long courseID) {
        this.name = name;
        this.ID = ID;
        this.courseID = courseID;
        counter++;
    }
}
