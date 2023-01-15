package com.academy;

import com.academy.models.Course;
import com.academy.models.Lecture;
import com.academy.repository.LectureRepository;

import java.util.Arrays;
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
                System.out.println("You have selected 'Course' category!");
                break;
            case 2:
                System.out.println("You have selected 'Teacher' category!");
                break;
            case 3:
                System.out.println("You have selected 'Student' category!");
                break;
            case 4:
                System.out.println("You have selected 'Lecture' category!");
                break;
            default:
                System.out.println(NOTHING_FOUND);
        }

    }

    public void initData() {

        lectureRepository.add(new Lecture("Intro", firstCourse.getId()));
        lectureRepository.add(new Lecture("Variables", firstCourse.getId()));
        lectureRepository.add(new Lecture("Git", firstCourse.getId()));

        System.out.println("Congratulations! We have just created " + Lecture.getCounter() +
                " lectures and " + Course.getCounter() + " course(s)");

        System.out.println("Here we go:");
        System.out.println(firstCourse);
        System.out.println(lectureRepository.showCreatedModels());
        System.out.println("And just for information our array looks like:");
        System.out.println(Arrays.toString(lectureRepository.getAll()));

    }

    public void findLecture() {

        int inputId, choice;

        do {
            System.out.println("Let's find lecture!");
            System.out.println("Enter lecture id you want to find:");
            inputId = USER_INPUT.nextInt();
            lectureRepository.getById(inputId);
            System.out.println("Would you like to find another lecture?");
            System.out.println(OPTION_CHOICE);
            choice = USER_INPUT.nextInt();

            if (choice == 0) {
                selectOption(chooseOption());
            } else if (choice != 1) {
                System.out.println(NOTHING_FOUND);
                selectOption(chooseOption());
            }

        } while (choice == 1);

    }

    public void deleteLecture() {

        int inputId, choice;

        do {
            System.out.println("Let's delete lecture!");
            System.out.println("Enter lecture id you want to delete:");
            inputId = USER_INPUT.nextInt();
            lectureRepository.deleteById(inputId);
            System.out.println("Would you like to delete another lecture?");
            System.out.println(OPTION_CHOICE);
            choice = USER_INPUT.nextInt();

            if (choice == 0) {
                selectOption(chooseOption());
            } else if (choice != 1) {
                System.out.println(NOTHING_FOUND);
                selectOption(chooseOption());
            }

        } while (choice == 1);

    }

    public int chooseOption() {

        int chosenOption;

        do {
            System.out.println("""
                    We have next options to choose:
                    1. - create lecture
                    2. - find lecture
                    3. - delete lecture
                    0. - finish program
                    Please, input appropriate number:""");

            chosenOption = USER_INPUT.nextInt();

            if (chosenOption < 0 || chosenOption > 3) {
                System.out.println(NOTHING_FOUND);
            }

        } while (chosenOption < 0 || chosenOption > 3);

        return chosenOption;
    }

    public void selectOption(int chosenOption) {

        switch (chosenOption) {
            case 1:
                System.out.println("You have selected 'create lecture' option!");
                createLecture();
                break;
            case 2:
                System.out.println("You have selected 'find lecture' option!");
                findLecture();
                break;
            case 3:
                System.out.println("You have selected 'delete lecture' option!");
                deleteLecture();
                break;
            case 0:
                System.out.println("You have selected 'finish program' option!");
                finishProgram();
                break;
            default:
                System.out.println(NOTHING_FOUND);
        }

    }

    public void createLecture() {

        int choice;

        do {
            System.out.println("Enter lecture name:");
            String lectureName = USER_INPUT.next();
            lectureRepository.add(new Lecture(lectureName, firstCourse.getId()));
            System.out.println("Congratulations! You have just created new lecture!");
            System.out.println(lectureRepository.showCreatedModels());
            System.out.println("Would you like to create another lecture?");
            System.out.println(OPTION_CHOICE);
            choice = USER_INPUT.nextInt();
        } while (choice == 1);

        if (choice == 0) {
            selectOption(chooseOption());
        } else {
            System.out.println(NOTHING_FOUND);
            selectOption(chooseOption());
        }
        USER_INPUT.close();
    }

}
