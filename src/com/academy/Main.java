package com.academy;

import com.academy.models.Course;
import com.academy.models.Lecture;
import com.academy.repository.LectureRepository;
import com.academy.services.LectureService;

public class Main {

    public static Course firstCourse;

    public static void main(String[] args) {

        MainService.welcomeTo();

        MainService.selectCategory(MainService.chooseCategory());

        LectureRepository lectureRepository = new LectureRepository();

        initData();

        int choice = MainService.createNewLecture(lectureRepository);

        LectureService lectureService = new LectureService();

        MainService.produceLecture(choice, lectureService, firstCourse, lectureRepository);
    }

    public static void initData() {

        Course firstCourse = new Course("Java", 2022);

        LectureRepository.addToArray(new Lecture("Intro", Lecture.getLectureCounter(), Course.getCourseID()));
        LectureRepository.addToArray(new Lecture("Git", Lecture.getLectureCounter(), Course.getCourseID()));
        LectureRepository.addToArray(new Lecture("GitHub", Lecture.getLectureCounter(), Course.getCourseID()));

        System.out.println("Congratulations! We have just created " + Lecture.getLectureCounter() +
                " lectures and " + Course.getCourseCounter() + " course(s)");

        System.out.println("Here we go:");
        System.out.println(firstCourse);
        System.out.println(LectureRepository.showCreatedLectures());
    }

}