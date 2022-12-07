package com.academy.services;

import com.academy.models.Lecture;

public class LectureService {

    public Lecture createLecture(String lectureName, long lectureID, long courseID) {
        return new Lecture(lectureName, lectureID, courseID);
    }
}
