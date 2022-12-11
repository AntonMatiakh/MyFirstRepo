package com.academy.services;

import com.academy.models.Lecture;

public class LectureService {

    private static long lectureCounter;

    public Lecture createLecture(String lectureName, long courseID) {
        lectureCounter++;
        return new Lecture(lectureName, lectureCounter, courseID);
    }

    public long getLectureCounter(){
        return lectureCounter;
    }
}
