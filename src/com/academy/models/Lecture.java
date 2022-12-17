package com.academy.models;

public class Lecture {

    private static int lectureCounter;
    private String lectureName;
    private int lectureID;
    public int courseID;

    private Homework homework;
    private ExtraMaterial extraMaterial;

    public Lecture(String lectureName, int lectureID, int courseID) {
        this.lectureName = lectureName;
        this.lectureID = lectureID;
        this.courseID = courseID;
        lectureCounter++;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "lectureName='" + lectureName + '\'' +
                ", lectureID=" + lectureID +
                ", courseID=" + courseID +
                '}';
    }
}
