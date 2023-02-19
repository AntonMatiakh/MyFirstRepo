package com.academy;

public class Main {

    public static void main(String[] args) {

        MainService mainService = new MainService();

        mainService.welcomeTo();

        mainService.initLectureData();
        mainService.initTeacherData();
        mainService.initStudentData();

        mainService.selectCategory(mainService.chooseCategory());

    }

}