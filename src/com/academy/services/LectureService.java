package com.academy.services;

import com.academy.models.Lecture;

public class LectureService {

    private static int counterLecture;

    public Lecture createLecture(String lectureName, int courseID) {
        counterLecture++;
        return new Lecture(lectureName, counterLecture, courseID);
    }

    public int getCounterLecture() {
        return counterLecture;
    }
}
