package com.academy.models;

public class Course {

    private static int courseCounter;
    private String courseName;
    private int courseID;

    private Teacher teacher;
    private Student student;
    private Lecture lecture;

    public Course(String courseName, int courseID) {
        this.courseName = courseName;
        this.courseID = courseID;
    }

    public int getCourseID() {
        return courseID;
    }
}
