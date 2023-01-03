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
        courseCounter++;
    }

    public int getCourseID() {
        return courseID;
    }

    /**
     * Changed access modifier to 'static' in order to get access to 'getCourseCounter' in 'Main' class
     */
    public static int getCourseCounter() {
        return courseCounter;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", courseID=" + courseID +
                '}';
    }

}
