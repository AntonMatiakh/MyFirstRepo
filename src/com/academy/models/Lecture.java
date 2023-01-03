package com.academy.models;

public class Lecture {

    private static int lectureCounter;
    private String lectureName;
    private int lectureID;
    public int courseID;

    private Homework homework;
    private ExtraMaterial extraMaterial;

    /**
     * In this variant of constructor it is possible to make safe delete of 'int lectureID' without any
     * damage to code. Or make 'this.lectureID = lectureID;' to input lectureID by own as an argument.
     */
    public Lecture(String lectureName, int lectureID, int courseID) {
        lectureCounter++;
        this.lectureName = lectureName;
        this.lectureID = lectureCounter;
        this.courseID = courseID;
    }

    public static int getLectureCounter() {
        return lectureCounter;
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
