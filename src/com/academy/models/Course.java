package com.academy.models;

public class Course {

    public static long counter;
    private String courseName;
    private long courseID;

    private Teacher teacher;
    private Student student;
    private Lecture lecture;

    public Course(String courseName, long courseID) {
        this.courseName = courseName;
        this.courseID = courseID;
    }

    public long getCourseID() {
        return courseID;
    }
}
