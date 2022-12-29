package com.academy;

import com.academy.services.LectureService;

public class Main {

    public static void main(String[] args) {

        MainService mainService = new MainService();

        mainService.welcomeTo();

        mainService.selectCategory(mainService.chooseCategory());

        mainService.initData();

        int choice = mainService.createNewLecture();

        LectureService lectureService = new LectureService();

        mainService.produceLecture(choice, lectureService);
    }

}