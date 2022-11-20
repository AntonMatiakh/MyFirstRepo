package com.academy.models;

public class Course {

    public static long counter;
    private String name;
    private long ID;

    private Teacher teacher;
    private Student student;
    private Lecture lecture;

    public Course(String name, long ID) {
        this.name = name;
        this.ID = ID;
    }

    public long getID() {
        return ID;
    }

    public Course() {
        ID = counter++;
    }
}
