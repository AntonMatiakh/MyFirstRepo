package com.academy;

import com.academy.models.Course;
import com.academy.models.Lecture;
import com.academy.repository.LectureRepository;
import com.academy.services.LectureService;

public class Main {

    public static Course firstCourse;
    public static void main(String[] args) {

        /**
         * Data in HOMEWORK_8
         */
        //LectureService lectureService = new LectureService();

        //Course firstCourse = new Course("Java", 2022);

//        System.out.println("Already " + Course.getCourseCounter() + " courses");
//
//        Lecture firstLecture = lectureService.createLecture("Introduction", firstCourse.getCourseID());
//        Lecture secondLecture = lectureService.createLecture("Variables", firstCourse.getCourseID());
//        Lecture thirdLecture = lectureService.createLecture("DataTypes", firstCourse.getCourseID());
//        Lecture fourthLecture = lectureService.createLecture("Git", firstCourse.getCourseID());
//        Lecture fifthLecture = lectureService.createLecture("GitHub", firstCourse.getCourseID());
//        Lecture sixthLecture = lectureService.createLecture("Methods", firstCourse.getCourseID());

        /**
         * Another variant of data for HOMEWORK_8 (need to continue...)
         */
//        Lecture Lecture1 = new Lecture("Introduction", 1, Course.getCourseCounter());
//        System.out.println(Lecture1);
//          .....

        System.out.println("Already " + Course.getCourseCounter() + " course");

        LectureRepository lectureRepository = new LectureRepository();
        System.out.println(lectureRepository.toString());

        initData();

        System.out.println("Already " + Course.getCourseCounter() + " course");

        MainService.welcomeTo();

        MainService.selectCategory(MainService.chooseCategory());

//        LectureRepository lectureRepository = new LectureRepository();
//        System.out.println(lectureRepository.toString());

        showCurrentData();

        System.out.println("Already " + Course.getCourseCounter() + " course");

        int choice = MainService.createNewLecture(lectureRepository);

        LectureService lectureService = new LectureService();

        MainService.produceLecture(choice, lectureService, firstCourse, lectureRepository);

//        System.out.println("***************************");
//        System.out.println(lectureRepository.toString());

//        LectureRepository.addToArray(new Lecture("Introduction", Lecture.getLectureCounter(), Course.getCourseID()));
//        LectureRepository.addToArray(new Lecture("Variables", Lecture.getLectureCounter(), Course.getCourseID()));
//        LectureRepository.addToArray(new Lecture("DataTypes", Lecture.getLectureCounter(), Course.getCourseID()));
//        LectureRepository.addToArray(new Lecture("Git", Lecture.getLectureCounter(), Course.getCourseID()));
//        LectureRepository.addToArray(new Lecture("GitHub", Lecture.getLectureCounter(), Course.getCourseID()));
//        LectureRepository.addToArray(new Lecture("Methods", Lecture.getLectureCounter(), Course.getCourseID()));

//        System.out.println(lectureRepository.toString());
//        System.out.println("************************************************************");

//        int choice = MainService.createNewLecture(lectureRepository);
//        System.out.println("************************************************************");

//        System.out.println(Lecture.getLectureCounter());
//        System.out.println("************************************************************");

//        System.out.println(lectureRepository.toString());
//        System.out.println("************************************************************");

//        System.out.println(lectureRepository.showCreatedLectures());
//        System.out.println("************************************************************");

//        lectureRepository.showArray();
//        System.out.println("************************************************************");

        //System.out.println("Already " + Course.getCourseCounter() + " course");

        /**
         * Creating Lecture array by default constructor and filling it with new Lectures
         */
//        LectureRepository lectureRepository1 = new LectureRepository();
//        System.out.println(lectureRepository1.toString());
//        LectureRepository.addToArray(new Lecture("Intro", Lecture.getLectureCounter(), firstCourse.getCourseID()));
//        LectureRepository.addToArray(new Lecture("Cycles", Lecture.getLectureCounter(), firstCourse.getCourseID()));
//        System.out.println(lectureRepository1.toString());
//        System.out.println(lectureRepository1.showCreatedLectures());

        /**
         * Creating Lecture array by constructor with variable size of array and filling it with new Lectures
         */
//        LectureRepository lectureRepository2 = new LectureRepository(2);
//        System.out.println(lectureRepository2.toString());
//        LectureRepository.addToArray(new Lecture("Cycles", Lecture.getLectureCounter(), firstCourse.getCourseID()));
//        LectureRepository.addToArray(new Lecture("Class", Lecture.getLectureCounter(), firstCourse.getCourseID()));
//        LectureRepository.addToArray(new Lecture("ENUM", Lecture.getLectureCounter(), firstCourse.getCourseID()));
//        System.out.println(lectureRepository2.toString());
//        System.out.println(lectureRepository2.showCreatedLectures());






//        LectureRepository.add(new Lecture("Cycles", 4, firstCourse.getCourseID()));
//        LectureRepository.add(new Lecture("Class", 5, firstCourse.getCourseID()));
//        LectureRepository.add(new Lecture("ENUM", 6, firstCourse.getCourseID()));
//        LectureRepository.add(new Lecture("String", 7, firstCourse.getCourseID()));
//        LectureRepository.add(new Lecture("Const", 8, firstCourse.getCourseID()));
//        lectureRepository.add(new Lecture("Encapsulation", 9, firstCourse.getCourseID()));


        //System.out.println(lectureRepository.toString())


    }

    /**
     * Workable code
     */
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

    public static void showCurrentData() {
        System.out.println("Congratulations! We have just created " + Lecture.getLectureCounter() +
                " lectures and " + Course.getCourseCounter() + " course(s)");

        System.out.println("Here we go:");
        System.out.println(firstCourse = new Course("Java", 2022));
        System.out.println(LectureRepository.showCreatedLectures());
    }


//        LectureRepository.addToArray(new Lecture("Introduction", Lecture.getLectureCounter(), Course.getCourseID()));
//        LectureRepository.addToArray(new Lecture("Introduction", Lecture.getLectureCounter(), Course.getCourseID()));
//        LectureRepository.addToArray(new Lecture("Cycles", Lecture.getLectureCounter(), Course.getCourseID()));
//        LectureRepository.addToArray(new Lecture("Cycles", Lecture.getLectureCounter(), Course.getCourseID()));
//        LectureRepository.addToArray(new Lecture("Cycles", Lecture.getLectureCounter(), Course.getCourseID()));
//        LectureRepository.addToArray(new Lecture("Introduction", Lecture.getLectureCounter(), Course.getCourseID()));


//        LectureRepository.addToArray2(new Lecture("ENUM", Lecture.getLectureCounter(), Course.getCourseID()));
//        LectureRepository.addToArray2(new Lecture("ENUM", Lecture.getLectureCounter(), Course.getCourseID()));
//        LectureRepository.addToArray2(new Lecture("ENUM", Lecture.getLectureCounter(), Course.getCourseID()));
//        LectureRepository.addToArray2(new Lecture("ENUM", Lecture.getLectureCounter(), Course.getCourseID()));
//        LectureRepository.addToArray2(new Lecture("ENUM", Lecture.getLectureCounter(), Course.getCourseID()));
//        LectureRepository.addToArray2(new Lecture("ENUM", Lecture.getLectureCounter(), Course.getCourseID()));
//        LectureRepository.addToArray2(new Lecture("ENUM", Lecture.getLectureCounter(), Course.getCourseID()));
//        LectureRepository.addToArray2(new Lecture("ENUM", Lecture.getLectureCounter(), Course.getCourseID()));
//        LectureRepository.addToArray2(new Lecture("ENUM", Lecture.getLectureCounter(), Course.getCourseID()));
//        LectureRepository.addToArray2(new Lecture("ENUM", Lecture.getLectureCounter(), Course.getCourseID()));

    /**
     * Not workable code
     */
//    public static void initFirstData(){
//        Course firstCourse = new Course("Java", 2022);
//        LectureRepository.addLecture(new Lecture("Cycles", Lecture.getLectureCounter(), firstCourse.getCourseID()));
//        LectureRepository.addLecture(new Lecture("Class", Lecture.getLectureCounter(), firstCourse.getCourseID()));
//        LectureRepository.addLecture(new Lecture("ENUM", Lecture.getLectureCounter(), firstCourse.getCourseID()));
//        //LectureRepository.add(new Lecture("String", 7, firstCourse.getCourseID()));
//        //LectureRepository.add(new Lecture("Const", 8, firstCourse.getCourseID()));
//        //LectureRepository.add(new Lecture("Encapsulation", 9, firstCourse.getCourseID()));
//    }
}