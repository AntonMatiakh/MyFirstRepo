package com.academy;

import com.academy.models.Course;
import com.academy.models.Lecture;
import com.academy.services.LectureService;

public class Main {

    public static void main(String[] args) {

        LectureService lectureService = new LectureService();

        Course firstCourse = new Course("Java", 2022);

        Lecture firstLecture = lectureService.createLecture("Introduction", firstCourse.getCourseID());
        Lecture secondLecture = lectureService.createLecture("Variables", firstCourse.getCourseID());
        Lecture thirdLecture = lectureService.createLecture("DataTypes", firstCourse.getCourseID());
        Lecture fourthLecture = lectureService.createLecture("Git", firstCourse.getCourseID());
        Lecture fifthLecture = lectureService.createLecture("GitHub", firstCourse.getCourseID());
        Lecture sixthLecture = lectureService.createLecture("Methods", firstCourse.getCourseID());

        MainService.welcomeTo();

        MainService.selectCategory(MainService.chooseCategory());

        int choice = MainService.createNewLecture(lectureService);
        MainService.produceLecture(choice, lectureService, firstCourse);

    }
}