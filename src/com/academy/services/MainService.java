package com.academy.services;

import com.academy.models.Course;
import com.academy.models.Lecture;

import java.util.Scanner;

public class MainService {

    static Scanner scanner = new Scanner(System.in);

    public static int chooseCategory() {
        System.out.println("We have the following categories:");
        System.out.println("1.Course  2.Teacher  3.Student  4.Lecture");
        System.out.println("Please, choose necessary category and input appropriate number:");
        return scanner.nextInt();
    }

    public static void selectCategory(int chosenCategory) {
        switch (chosenCategory) {
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

        public static void realisationLecture(int answer){
            LectureService lectureService = new LectureService();
            Course firstCourse = new Course("Java", 2022L);
            if (answer == 1) {
                System.out.println("Enter lecture name:");
                String lectureName = scanner.next();
                System.out.println("Enter lecture id:");
                int lectureID = scanner.nextInt();
                System.out.println(lectureService.createLecture(lectureName, lectureID, firstCourse.getCourseID()));
                realisationLecture(optionLecture());
            } else if (answer == 2) {
                System.out.println("That's all, thank you for attention, see you next time :)");
                System.out.println("----------------------------END--------------------------");
            } else {
                System.out.println("Unfortunately, something went terribly wrong... :(");
                System.out.println("------------------------END-----------------------");

                scanner.close();
            }
        }
}
