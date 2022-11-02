package com.academy.models;

public class Course {
    private long ID;
    public static long counter;

    private Teacher teacher;
    private Student student;
    private Lecture lecture;

    public Course() {
        ID = counter++;
    }
}
