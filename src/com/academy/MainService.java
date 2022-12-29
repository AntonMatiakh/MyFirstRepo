package com.academy;

import com.academy.models.Course;
import com.academy.models.Lecture;
import com.academy.repository.LectureRepository;
import com.academy.services.LectureService;

import java.util.Scanner;

public class MainService {

    LectureRepository lectureRepository = new LectureRepository();

    Course firstCourse = new Course("Java", 2022);

    private static final Scanner USER_INPUT = new Scanner(System.in);

    private static final String NOTHING_FOUND =
            """
                    Sorry, nothing found...:(
                    Let's try again""";

    private static final String OPTION_CHOICE =
            """
                    If 'Yes' - input 1, if 'No' - input 0
                    Please, input appropriate number:""";

    public void finishProgram() {
        System.out.println("That's all, thank you for attention, see you next time :)");
        System.out.println("----------------------PROGRAM FINISHED-------------------");
        System.exit(0);
    }

    public void initData() {

        //Course firstCourse = new Course("Java", 2022);
        lectureRepository.addToArray(new Lecture("Intro", Lecture.getLectureCounter(), firstCourse.getCourseID()));
        lectureRepository.addToArray(new Lecture("Git", Lecture.getLectureCounter(), firstCourse.getCourseID()));
        lectureRepository.addToArray(new Lecture("GitHub", Lecture.getLectureCounter(), firstCourse.getCourseID()));

        System.out.println("Congratulations! We have just created " + Lecture.getLectureCounter() +
                " lectures and " + Course.getCourseCounter() + " course(s)");

        System.out.println("Here we go:");
        System.out.println(firstCourse);
        System.out.println(lectureRepository.showCreatedLectures());
    }

    public void welcomeTo() {

        int startOption;

        while (true) {
            System.out.println("Welcome to 'Online School' project!");
            System.out.println("Would you like to continue?");
            System.out.println(OPTION_CHOICE);

            startOption = USER_INPUT.nextInt();

            if (startOption == 1) {
                break;
            } else if (startOption == 0) {
                finishProgram();
            } else {
                System.out.println(NOTHING_FOUND);
            }
        }
    }

    public int chooseCategory() {

        int category;

        do {
            System.out.println("We have the following categories:");
            System.out.println("1.Course  2.Teacher  3.Student  4.Lecture");
            System.out.println("Please, select necessary category and input appropriate number:");
            category = USER_INPUT.nextInt();

            if (category < 1 || category > 4) {
                System.out.println(NOTHING_FOUND);
            }

        } while (category < 1 || category > 4);

        return category;
    }

    public void selectCategory(int category) {

        switch (category) {
            case 1:
                System.out.println("You have selected 'Course' category");
                break;
            case 2:
                System.out.println("You have selected 'Teacher' category");
                break;
            case 3:
                System.out.println("You have selected 'Student' category");
                break;
            case 4:
                System.out.println("You have selected 'Lecture' category");
                break;
            default:
                System.out.println(NOTHING_FOUND);
        }
    }

    /**
     * Changed parameter from 'Lecture lecture' to 'LectureRepository lectureRepository' in order to insert it into
     * variable 'choice' in 'Main' class. As a result 'int choice = MainService.createNewLecture(lectureRepository);'
     * But later made safe delete of parameter 'LectureRepository lectureRepository' without any damage to code.
     * As a result now in 'Main' class we have 'int choice = MainService.createNewLecture()' instead of
     * 'int choice = MainService.createNewLecture(lectureRepository)'
     */
    public int createNewLecture() {
        System.out.println("We have already " + Lecture.getLectureCounter() + " lectures");
        System.out.println("Would you like to create new lecture?");
        System.out.println(OPTION_CHOICE);
        return USER_INPUT.nextInt();
    }


    /**
     * Made a safe delete of parameters 'Course firstCourse' and 'LectureRepository lectureRepository' without any
     * damage to code. As a result now in 'Main' class we have 'MainService.produceLecture(choice, lectureService)'
     * instead of 'MainService.produceLecture(choice, lectureService, firstCourse, lectureRepository)'. More over,
     * line 'public static Course firstCourse' is no more necessary in the very beginning of 'Main' class.
     */
    public void produceLecture(int choice, LectureService lectureService) {

        while (choice == 1) {
            System.out.println("Enter lecture name:");
            String lectureName = USER_INPUT.next();
            lectureRepository.addToArray(lectureService.createLecture(lectureName, firstCourse.getCourseID()));
            System.out.println("Congratulations! You have just created new lecture!");
            System.out.println("Now we have " + Lecture.getLectureCounter() + " lectures");
            System.out.println(lectureRepository.showCreatedLectures());


            /**
             * This block of code possibly will be used in future.
             */
//            if (Lecture.getLectureCounter() == 8) {
//                System.out.println("Array is filled! You have reached maximum number of lectures!");
//                finishProgram();
//            }

            System.out.println("Would you like to create another lecture?");
            System.out.println(OPTION_CHOICE);
            choice = USER_INPUT.nextInt();
        }
        if (choice == 0) {
            finishProgram();
        } else {
            System.out.println("Unfortunately, something went terribly wrong... :(");
            System.out.println("------------------PROGRAM FINISHED----------------");
        }
        USER_INPUT.close();
    }
}
