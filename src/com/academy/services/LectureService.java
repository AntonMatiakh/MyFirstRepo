package com.academy.services;

import com.academy.models.Lecture;

public class LectureService {

    private static int lectureCounter;

    public Lecture createLecture(String lectureName, int courseID) {
        lectureCounter++;
        return new Lecture (lectureName, lectureCounter, courseID);
    }

    public static int getCounterLecture() {
        return lectureCounter;
    }
}
