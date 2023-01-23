package com.academy;

import com.academy.models.Course;
import com.academy.models.Lecture;
import com.academy.models.Person;
import com.academy.models.Role;
import com.academy.repository.LectureRepository;
import com.academy.repository.StudentRepository;
import com.academy.repository.TeacherRepository;

import java.util.Arrays;
import java.util.Scanner;

public class MainService {

    LectureRepository lectureRepository = new LectureRepository();
    TeacherRepository teacherRepository = new TeacherRepository();
    StudentRepository studentRepository = new StudentRepository();


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
            System.out.println("""
            We have the following categories:
            1. - Lectures
            2. - Teachers
            3. - Students
            4. - Courses
            Please, select necessary category and input appropriate number:""");

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
                System.out.println("You have selected 'Lectures' category!");
                initData();
                selectLecturesOption(chooseLecturesOption());
                break;
            case 2:
                System.out.println("You have selected 'Teachers' category!");
                selectTeachersOption(chooseTeachersOption());
                break;
            case 3:
                System.out.println("You have selected 'Students' category!");
                selectStudentsOption(chooseStudentsOption());
                break;
            case 4:
                System.out.println("You have selected 'Courses' category!");
                break;
            default:
                System.out.println(NOTHING_FOUND);
        }

    }

    public void initData() {

        lectureRepository.add(new Lecture("Intro", firstCourse.getId()));
        lectureRepository.add(new Lecture("Variables", firstCourse.getId()));
        lectureRepository.add(new Lecture("Git", firstCourse.getId()));

        System.out.println("We have already " + Lecture.getCounter() +
                " lectures and " + Course.getCounter() + " course(s)");

        System.out.println("Here we go:");
        System.out.println(firstCourse);
        System.out.println(Arrays.toString(lectureRepository.getAll()));
    }

    public void findLecture() {

        int inputId, choice;

        do {
            System.out.println("Enter lecture id you want to find:");
            inputId = USER_INPUT.nextInt();
            lectureRepository.getById(inputId);
            System.out.println("Would you like to find another lecture?");
            System.out.println(OPTION_CHOICE);
            choice = USER_INPUT.nextInt();

            if (choice == 0) {
                selectLecturesOption(chooseLecturesOption());
            } else if (choice != 1) {
                System.out.println(NOTHING_FOUND);
                selectLecturesOption(chooseLecturesOption());
            }

        } while (choice == 1);
    }

    public void findTeacher() {

        int inputId, choice;

        do {
            System.out.println("Enter teacher's id you want to find:");
            inputId = USER_INPUT.nextInt();
            teacherRepository.getById(inputId);
            System.out.println("Would you like to find another teacher?");
            System.out.println(OPTION_CHOICE);
            choice = USER_INPUT.nextInt();

            if (choice == 0) {
                selectTeachersOption(chooseTeachersOption());
            } else if (choice != 1) {
                System.out.println(NOTHING_FOUND);
                selectTeachersOption(chooseTeachersOption());
            }

        } while (choice == 1);
    }

    public void findStudent() {

        int inputId, choice;

        do {
            System.out.println("Enter student's id you want to find:");
            inputId = USER_INPUT.nextInt();
            studentRepository.getById(inputId);
            System.out.println("Would you like to find another student?");
            System.out.println(OPTION_CHOICE);
            choice = USER_INPUT.nextInt();

            if (choice == 0) {
                selectStudentsOption(chooseStudentsOption());
            } else if (choice != 1) {
                System.out.println(NOTHING_FOUND);
                selectStudentsOption(chooseStudentsOption());
            }

        } while (choice == 1);
    }

    public void deleteLecture() {

        int inputId, choice;

        do {
            System.out.println("Enter lecture id you want to delete:");
            inputId = USER_INPUT.nextInt();
            lectureRepository.deleteById(inputId);
            System.out.println("Would you like to delete another lecture?");
            System.out.println(OPTION_CHOICE);
            choice = USER_INPUT.nextInt();

            if (choice == 0) {
                selectLecturesOption(chooseLecturesOption());
            } else if (choice != 1) {
                System.out.println(NOTHING_FOUND);
                selectLecturesOption(chooseLecturesOption());
            }

        } while (choice == 1);
    }

    public void deleteTeacher() {

        int inputId, choice;

        do {
            System.out.println("Enter teacher's id you want to delete:");
            inputId = USER_INPUT.nextInt();
            teacherRepository.deleteById(inputId);
            System.out.println("Would you like to delete another teacher?");
            System.out.println(OPTION_CHOICE);
            choice = USER_INPUT.nextInt();

            if (choice == 0) {
                selectTeachersOption(chooseTeachersOption());
            } else if (choice != 1) {
                System.out.println(NOTHING_FOUND);
                selectTeachersOption(chooseTeachersOption());
            }

        } while (choice == 1);
    }

    public void deleteStudent() {

        int inputId, choice;

        do {
            System.out.println("Enter student's id you want to delete:");
            inputId = USER_INPUT.nextInt();
            studentRepository.deleteById(inputId);
            System.out.println("Would you like to delete another student?");
            System.out.println(OPTION_CHOICE);
            choice = USER_INPUT.nextInt();

            if (choice == 0) {
                selectStudentsOption(chooseStudentsOption());
            } else if (choice != 1) {
                System.out.println(NOTHING_FOUND);
                selectStudentsOption(chooseStudentsOption());
            }

        } while (choice == 1);
    }

    public int chooseLecturesOption() {

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



    public int chooseTeachersOption() {

        int chosenOption;

        do {
            System.out.println("""
                    We have next options to choose:
                    1. - create teacher
                    2. - find teacher
                    3. - delete teacher
                    4. - add teacher to lecture
                    0. - finish program
                    Please, input appropriate number:""");

            chosenOption = USER_INPUT.nextInt();

            if (chosenOption < 0 || chosenOption > 4) {
                System.out.println(NOTHING_FOUND);
            }

        } while (chosenOption < 0 || chosenOption > 4);

        return chosenOption;
    }

    public int chooseStudentsOption() {

        int chosenOption;

        do {
            System.out.println("""
                    We have next options to choose:
                    1. - create student
                    2. - find student
                    3. - delete student
                    0. - finish program
                    Please, input appropriate number:""");

            chosenOption = USER_INPUT.nextInt();

            if (chosenOption < 0 || chosenOption > 3) {
                System.out.println(NOTHING_FOUND);
            }

        } while (chosenOption < 0 || chosenOption > 3);

        return chosenOption;
    }

    public void selectLecturesOption(int chosenOption) {

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

    public void selectTeachersOption(int chosenOption) {

        switch (chosenOption) {
            case 1:
                System.out.println("You have selected 'create teacher' option!");
                createTeacher();
                break;
            case 2:
                System.out.println("You have selected 'find teacher' option!");
                findTeacher();
                break;
            case 3:
                System.out.println("You have selected 'delete teacher' option!");
                deleteTeacher();
                break;
            case 4:
                System.out.println("You have selected 'add teacher to lecture' option!");
                createTeacherAndAddToLecture();
                break;
            case 0:
                System.out.println("You have selected 'finish program' option!");
                finishProgram();
                break;
            default:
                System.out.println(NOTHING_FOUND);
        }
    }

    public void selectStudentsOption(int chosenOption) {

        switch (chosenOption) {
            case 1:
                System.out.println("You have selected 'create student' option!");
                createStudent();
                break;
            case 2:
                System.out.println("You have selected 'find student' option!");
                findStudent();
                break;
            case 3:
                System.out.println("You have selected 'delete student' option!");
                deleteStudent();
                break;
            case 0:
                System.out.println("You have selected 'finish program' option!");
                finishProgram();
                break;
            default:
                System.out.println(NOTHING_FOUND);
        }
    }

    public void createTeacher() {

        int choice;

        do {
            System.out.println("Enter teacher's name:");
            String teacherName = USER_INPUT.next();
            Person teacher = new Person(teacherName, firstCourse.getId(), Role.TEACHER);
            teacherRepository.add(teacher);
            System.out.println("Congratulations! You have just created new teacher!");
            System.out.println(teacher);
            System.out.println(Arrays.toString(teacherRepository.getAll()));
            System.out.println("Would you like to create another teacher?");
            System.out.println(OPTION_CHOICE);
            choice = USER_INPUT.nextInt();
        } while (choice == 1);

        if (choice == 0) {
            selectTeachersOption(chooseTeachersOption());
        } else {
            System.out.println(NOTHING_FOUND);
            selectTeachersOption(chooseTeachersOption());
        }
    }

    public void createTeacherAndAddToLecture() {

        int choice;

        do {
            System.out.println("Enter teacher's name:");
            String teacherName = USER_INPUT.next();
            Person teacher = new Person(teacherName, firstCourse.getId(), Role.TEACHER);
            teacherRepository.add(teacher);
            System.out.println("Congratulations! You have just created new teacher!");
            System.out.println(teacher);
            System.out.println("Enter lecture's name:");
            String lectureName = USER_INPUT.next();
            Lecture lecture = new Lecture(lectureName, firstCourse.getId(), teacher);
            lectureRepository.add(lecture);
            System.out.println("Congratulations! You have just added new teacher to a new lecture!");
            System.out.println(lecture);
            System.out.println("Would you like to repeat this action?");
            System.out.println(OPTION_CHOICE);
            choice = USER_INPUT.nextInt();
        } while (choice == 1);

        if (choice == 0) {
            selectTeachersOption(chooseTeachersOption());
        } else {
            System.out.println(NOTHING_FOUND);
            selectTeachersOption(chooseTeachersOption());
        }
    }

    public void createStudent() {

        int choice;

        do {
            System.out.println("Enter student's name:");
            String studentName = USER_INPUT.next();
            Person student = new Person(studentName, firstCourse.getId(), Role.STUDENT);
            studentRepository.add(student);
            System.out.println("Congratulations! You have just created new student!");
            System.out.println(student);
            System.out.println(Arrays.toString(studentRepository.getAll()));
            System.out.println("Would you like to create another student?");
            System.out.println(OPTION_CHOICE);
            choice = USER_INPUT.nextInt();
        } while (choice == 1);

        if (choice == 0) {
            selectStudentsOption(chooseStudentsOption());
        } else {
            System.out.println(NOTHING_FOUND);
            selectStudentsOption(chooseStudentsOption());
        }
    }

    public void createLecture() {

        int choice;

        do {
            System.out.println("Enter lecture name:");
            String lectureName = USER_INPUT.next();
            Lecture lecture = new Lecture(lectureName, firstCourse.getId());
            lectureRepository.add(lecture);
            System.out.println("Congratulations! You have just created new lecture!");
            System.out.println(lecture);
            System.out.println(Arrays.toString(lectureRepository.getAll()));
            System.out.println("Would you like to create another lecture?");
            System.out.println(OPTION_CHOICE);
            choice = USER_INPUT.nextInt();
        } while (choice == 1);

        if (choice == 0) {
            selectLecturesOption(chooseLecturesOption());
        } else {
            System.out.println(NOTHING_FOUND);
            selectLecturesOption(chooseLecturesOption());
        }
        USER_INPUT.close();
    }

}
