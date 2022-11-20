package com.academy.services;

import com.academy.models.Lecture;

public class LectureService {

    public Lecture createLecture(String name, long ID, long courseID) {
        return new Lecture(name, ID, courseID);
    }
}
