package com.academy;

import com.academy.models.*;
import com.academy.repository.LectureRepository;
import com.academy.repository.StudentRepository;
import com.academy.repository.TeacherRepository;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainService {
    LectureRepository lectureRepository = new LectureRepository();
    TeacherRepository teacherRepository = new TeacherRepository();
    StudentRepository studentRepository = new StudentRepository();


    Course firstCourse = new Course("Java", 2022);

    private static final Scanner USER_INPUT = new Scanner(System.in);

    public Scanner getUserInput() {
        return USER_INPUT;
    }

    private static final String NOTHING_FOUND =
            """
                    Sorry, nothing found...:(
                    Let's try again""";

    public String getNothingFound() {
        return NOTHING_FOUND;
    }

    private static final String OPTION_CHOICE =
            """
                    If 'Yes' - input 1, if 'No' - input 0
                    Please, input appropriate number:""";

    public String getOptionChoice() {
        return OPTION_CHOICE;
    }

    private static final String WRONG_FORMAT = "WRONG FORMAT!!! Please, try again!!!";


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
        lectureRepository.add(new Lecture("Methods", firstCourse.getId()));
        lectureRepository.add(new Lecture("Arrays", firstCourse.getId()));

        System.out.println("We have already " + Lecture.getCounter() +
                " lectures and " + Course.getCounter() + " course(s)");

        System.out.println("Here we go:");
        System.out.println(firstCourse);
        System.out.println(Arrays.toString(lectureRepository.getAll()));
    }

    public void findLecture() {

        int inputId;
        int choice;

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

        int inputId;
        int choice;

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

        int inputId;
        int choice;

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

        int inputId;
        int choice;

        do {
            System.out.println("Enter lecture id you want to delete:");
            inputId = USER_INPUT.nextInt();
            lectureRepository.deleteById(inputId);
            //lectureRepository.getAll();
            System.out.println(Arrays.toString(lectureRepository.getAll()));
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

        int inputId;
        int choice;

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

        int inputId;
        int choice;

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
                    4. - return to previous menu
                    0. - finish program
                    Please, input appropriate number:""");

            chosenOption = USER_INPUT.nextInt();

            if (chosenOption < 0 || chosenOption > 4) {
                System.out.println(NOTHING_FOUND);
            }

        } while (chosenOption < 0 || chosenOption > 4);

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
                    5. - return to previous menu
                    0. - finish program
                    Please, input appropriate number:""");

            chosenOption = USER_INPUT.nextInt();

            if (chosenOption < 0 || chosenOption > 5) {
                System.out.println(NOTHING_FOUND);
            }

        } while (chosenOption < 0 || chosenOption > 5);

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
                    4. - return to previous menu
                    0. - finish program
                    Please, input appropriate number:""");

            chosenOption = USER_INPUT.nextInt();

            if (chosenOption < 0 || chosenOption > 4) {
                System.out.println(NOTHING_FOUND);
            }

        } while (chosenOption < 0 || chosenOption > 4);

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
            case 4:
                System.out.println("You have selected 'return to previous menu' option!");
                selectCategory(chooseCategory());
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
            case 5:
                System.out.println("You have selected 'return to previous menu' option!");
                selectCategory(chooseCategory());
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
            case 4:
                System.out.println("You have selected 'return to previous menu' option!");
                selectCategory(chooseCategory());
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

        Person teacher = new Person();
        teacher.setRole(Role.TEACHER);

        do {

            String teacherFirstname;

            do {
                System.out.println("Enter teacher's first name (format like 'Valerii'):");
                teacherFirstname = USER_INPUT.next();
                checkName(teacherFirstname);
                if (!checkName(teacherFirstname))
                    System.out.println(WRONG_FORMAT);
            } while (!checkName(teacherFirstname));

            teacher.setFirstname(teacherFirstname);

            String teacherLastname;

            do {
                System.out.println("Enter teacher's lastname (format like 'Zaluzhnyi'):");
                teacherLastname = USER_INPUT.next();
                checkName(teacherLastname);
                if (!checkName(teacherLastname))
                    System.out.println(WRONG_FORMAT);
            } while (!checkName(teacherLastname));

            teacher.setLastname(teacherLastname);

            String teacherPhone;

            do {
                System.out.println("Enter teacher's phone (format like '+380XXXXXXXXX'):");
                teacherPhone = USER_INPUT.next();
                checkPhone(teacherPhone);
                if (!checkPhone(teacherPhone))
                    System.out.println(WRONG_FORMAT);
            } while (!checkPhone(teacherPhone));

            teacher.setPhone(teacherPhone);

            String teacherEmail;

            do {
            System.out.println("Enter teacher's email:");
            teacherEmail = USER_INPUT.next();
                checkEmail(teacherEmail);
                if (!checkEmail(teacherEmail))
                    System.out.println(WRONG_FORMAT);
            } while (!checkEmail(teacherEmail));

            teacher.setEmail(teacherEmail);

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

        Person teacher = new Person();
        teacher.setRole(Role.TEACHER);

        do {

            String teacherFirstname;

            do {
                System.out.println("Enter teacher's first name (format like 'Valerii'):");
                teacherFirstname = USER_INPUT.next();
                checkName(teacherFirstname);
                if (!checkName(teacherFirstname))
                    System.out.println(WRONG_FORMAT);
            } while (!checkName(teacherFirstname));

            teacher.setFirstname(teacherFirstname);

            String teacherLastname;

            do {
                System.out.println("Enter teacher's lastname (format like 'Zaluzhnyi'):");
                teacherLastname = USER_INPUT.next();
                checkName(teacherLastname);
                if (!checkName(teacherLastname))
                    System.out.println(WRONG_FORMAT);
            } while (!checkName(teacherLastname));

            teacher.setLastname(teacherLastname);

            String teacherPhone;

            do {
                System.out.println("Enter teacher's phone (format like '+380XXXXXXXXX'):");
                teacherPhone = USER_INPUT.next();
                checkPhone(teacherPhone);
                if (!checkPhone(teacherPhone))
                    System.out.println(WRONG_FORMAT);
            } while (!checkPhone(teacherPhone));

            teacher.setPhone(teacherPhone);

            String teacherEmail;

            do {
                System.out.println("Enter teacher's email:");
                teacherEmail = USER_INPUT.next();
                checkEmail(teacherEmail);
                if (!checkEmail(teacherEmail))
                    System.out.println(WRONG_FORMAT);
            } while (!checkEmail(teacherEmail));

            teacher.setEmail(teacherEmail);

            teacherRepository.add(teacher);

            System.out.println("Congratulations! You have just created new teacher!");
            System.out.println(teacher);

            String lectureName;

            do {
                System.out.println("Enter lecture name (format like 'Introduction'):");
                lectureName = USER_INPUT.next();
                checkName(lectureName);
                if (!checkName(lectureName))
                    System.out.println(WRONG_FORMAT);
            } while (!checkName(lectureName));

            System.out.println("Write down something into description:");
            String description = USER_INPUT.next();
            Lecture lecture = new Lecture(lectureName, firstCourse.getId(), description, teacher);
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

            String studentFirstname;

            do {
            System.out.println("Enter student's first name (format like 'Valerii'):");
            studentFirstname = USER_INPUT.next();
                checkName(studentFirstname);
                if (!checkName(studentFirstname))
                    System.out.println(WRONG_FORMAT);
            } while (!checkName(studentFirstname));

            String studentLastname;

            do {
            System.out.println("Enter student's last name (format like 'Zaluzhnyi'):");
            studentLastname = USER_INPUT.next();
                checkName(studentLastname);
                if (!checkName(studentLastname))
                    System.out.println(WRONG_FORMAT);
            } while (!checkName(studentLastname));

            String studentPhone;

            do {
            System.out.println("Enter student's phone (format like '+380XXXXXXXXX'):");
            studentPhone = USER_INPUT.next();
                checkPhone(studentPhone);
                if (!checkPhone(studentPhone))
                    System.out.println(WRONG_FORMAT);
            } while (!checkPhone(studentPhone));

            String studentEmail;

            do {
                System.out.println("Enter student's email (format like 'general@gmail.com'):");
                studentEmail = USER_INPUT.next();
                checkEmail(studentEmail);
                if (!checkEmail(studentEmail))
                    System.out.println(WRONG_FORMAT);
            } while (!checkEmail(studentEmail));

            Person student = new Person(studentFirstname, studentLastname, studentPhone,
                    studentEmail, Role.STUDENT);

            studentRepository.add(student);

            System.out.println("Congratulations! You have just created new student!");
            System.out.println(student);
            System.out.println(Arrays.toString(studentRepository.getAll()));

            System.out.println("Would you like to create another student?");
            System.out.println(OPTION_CHOICE);
            choice = USER_INPUT.nextInt();

        } while (choice == 1);

        if (choice == 0)
            selectStudentsOption(chooseStudentsOption());
         else {
            System.out.println(NOTHING_FOUND);
            selectStudentsOption(chooseStudentsOption());
        }

    }

    public void createLecture() {

        int choice;

        do {

            String lectureName;

            do {
            System.out.println("Enter lecture name (format like 'Introduction'):");
            lectureName = USER_INPUT.next();
                checkName(lectureName);
                if (!checkName(lectureName))
                    System.out.println(WRONG_FORMAT);
            } while (!checkName(lectureName));

            System.out.println("Write down something into description:");
            String description = USER_INPUT.next();
            Lecture lecture = new Lecture(lectureName, firstCourse.getId(), description);
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

    public boolean checkName(String inputName) {
        Pattern pattern = Pattern.compile("^([А-Я]{1}[а-яё]{1,23}|[A-Z]{1}[a-z]{1,23})$");
        Matcher matcher = pattern.matcher(inputName);
        return matcher.matches();
    }

    public boolean checkPhone(String inputPhone) {
        Pattern pattern = Pattern.compile("\\+380\\d{3}\\d{2}\\d{2}\\d{2}");
        Matcher matcher = pattern.matcher(inputPhone);
        return matcher.matches();
    }

    public boolean checkEmail(String inputEmail) {
        Pattern pattern = Pattern.compile("\\w{3,}@\\w+.\\w{2,3}");
        Matcher matcher = pattern.matcher(inputEmail);
        return matcher.matches();
    }

}
