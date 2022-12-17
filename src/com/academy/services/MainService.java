package com.academy.services;

import com.academy.models.Course;
import com.academy.models.Lecture;

import java.util.Scanner;

public class MainService {

    static Scanner scanner = new Scanner(System.in);

    public static void welcomeTo () {

        int startOption;

        while (true) {
            System.out.println("Welcome to 'Online School' project!");
            System.out.println("You have next options:");
            System.out.println("'Continue' - input 1, 'Finish' - input 0");
            System.out.println("Please, select necessary option and input appropriate number:");
            startOption = scanner.nextInt();

            if (startOption == 1) {
                break;
            } else if (startOption == 0) {
                System.out.println("That's all, thank you for attention, see you next time :)");
                System.out.println("----------------------PROGRAM FINISHED-------------------");
                System.exit(0);
            }
        }
    }

    public static int chooseCategory() {
        System.out.println("We have the following categories:");
        System.out.println("1.Course  2.Teacher  3.Student  4.Lecture");
        System.out.println("Please, choose necessary category and input appropriate number:");
        return scanner.nextInt();
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
                System.out.println("Sorry, nothing found... :(");
                System.out.println("------------END-----------");
                System.exit(0);
        }
    }

    public static int optionLecture() {
        System.out.println("We have already " + Lecture.counter + " lectures");
        System.out.println("Would you like to create new lecture?");
        System.out.println("If 'Yes' - input 1, if 'No' - input 2");
        System.out.println("Please, input appropriate number:");
        return scanner.nextInt();
    }

    public static void creationOfLecture (int choice) {

        LectureService lectureService = new LectureService();
        Course firstCourse = new Course("Java", 2022L);
        while (choice == 1) {
            System.out.println("Enter lecture name:");
            String lectureName = scanner.next();
            System.out.println(lectureService.createLecture(lectureName, firstCourse.getCourseID()));
            System.out.println("Now we have " + lectureService.getLectureCounter() + " lectures");

            if (lectureService.getLectureCounter() == 8) {
                System.out.println("That's all, thank you for attention, see you next time :)");
                System.out.println("----------------------PROGRAM FINISHED-------------------");
                System.exit(0);
            }

            System.out.println("Would you like to create another lecture?");
            System.out.println("If 'Yes' - input 1, if 'No' - input 2");
            System.out.println("Please, input appropriate number:");
            choice = scanner.nextInt();
        }
        if (choice == 2) {
            System.out.println("That's all, thank you for attention, see you next time :)");
            System.out.println("----------------------PROGRAM FINISHED-------------------");
        } else {
            System.out.println("Unfortunately, something went terribly wrong... :(");
            System.out.println("------------------PROGRAM FINISHED----------------");
        }
    }
//        public static void realisationLecture(int answer){
//            LectureService lectureService = new LectureService();
//            Course firstCourse = new Course("Java", 2022L);
//            if (answer == 1) {
//                System.out.println("Enter lecture name:");
//                String lectureName = scanner.next();
//                System.out.println("Enter lecture id:");
//                int lectureID = scanner.nextInt();
//                System.out.println(lectureService.createLecture(lectureName, lectureID));
//                realisationLecture(optionLecture());
//            } else if (answer == 2) {
//                System.out.println("That's all, thank you for attention, see you next time :)");
//                System.out.println("----------------------------END--------------------------");
//            } else {
//                System.out.println("Unfortunately, something went terribly wrong... :(");
//                System.out.println("------------------------END-----------------------");
//
//                scanner.close();
//            }
//        }
}
