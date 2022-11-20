package com.academy.models;

public class Lecture {

    public static long counter;
    private String name;
    private long ID;
    public long courseID;

    private Homework homework;
    private ExtraMaterial extraMaterial;

    public Lecture(String name, long ID, long courseID) {
        this.name = name;
        this.ID = ID;
        this.courseID = courseID;
        counter++;
    }

    public Lecture() {
        ID = counter++;
    }
}
