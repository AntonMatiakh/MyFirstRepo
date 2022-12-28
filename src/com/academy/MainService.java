package com.academy;

import com.academy.models.Course;
import com.academy.models.Lecture;
import com.academy.repository.LectureRepository;
import com.academy.services.LectureService;

import java.util.Scanner;

public class MainService {

    private static final Scanner USER_INPUT = new Scanner(System.in);

    private static final String NOTHING_FOUND =
            """
                    Sorry, nothing found...:(
                    Let's try again""";

    private static final String OPTION_CHOICE =
            """
                    If 'Yes' - input 1, if 'No' - input 0
                    Please, input appropriate number:""";

    public static void finishProgram() {
        System.out.println("That's all, thank you for attention, see you next time :)");
        System.out.println("----------------------PROGRAM FINISHED-------------------");
        System.exit(0);
    }

    public static void welcomeTo () {

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

    public static int chooseCategory() {

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


    public static void selectCategory(int category) {

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
     */
    public static int createNewLecture(LectureRepository lectureRepository) {
        System.out.println("We have already " + Lecture.getLectureCounter() + " lectures");
        //System.out.println("We have already " + lectureService.getCounterLecture() + " lectures");
        System.out.println("Would you like to create new lecture?");
        System.out.println(OPTION_CHOICE);
        return USER_INPUT.nextInt();
    }


    public static void produceLecture(int choice, LectureService lectureService,
                                      Course firstCourse, LectureRepository lectureRepository) {

        //int courseID = Course.getCourseID();

        while (choice == 1) {
            System.out.println("Enter lecture name:");
            String lectureName = USER_INPUT.next();
            LectureRepository.addToArray(lectureService.createLecture(lectureName, Course.getCourseID()));
            System.out.println("Congratulations! You have just created new lecture!");
            System.out.println("Now we have " + Lecture.getLectureCounter() + " lectures");
            System.out.println(LectureRepository.showCreatedLectures());


            if (Lecture.getLectureCounter() == 8) {
                System.out.println("Array is filled! You have reached maximum number of lectures!");
                finishProgram();
            }

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
