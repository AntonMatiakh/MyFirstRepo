package com.academy;

import com.academy.models.*;
import com.academy.repository.LectureRepository;
import com.academy.repository.PersonRepository;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainService {

    LectureRepository lectureRepository = new LectureRepository();
    PersonRepository personRepository = new PersonRepository();

    Course firstCourse = new Course("Java", 2022);

    private final Scanner USER_INPUT = new Scanner(System.in);

    private final String NOTHING_FOUND =
            """
                    Sorry, nothing found...
                    Let's try again!!!
                    """;

    private final String OPTION_CHOICE =
            """
                    If 'Yes' - input 1, if 'No' - input 0
                    Please, input appropriate number:""";

    private final String WRONG_FORMAT = "WRONG FORMAT !!! Please, try again !!!";

    public void finishProgram() {
        System.out.println("That's all, thank you for attention, see you next time !!!");
        System.out.println("---------------------PROGRAM FINISHED---------------------");
        System.exit(0);
    }

    public int repeatLectureAction() {

        System.out.println(OPTION_CHOICE);
        int choice = USER_INPUT.nextInt();

        if (choice == 0)
            selectLecturesOption(chooseLecturesOption());
        else if (choice != 1) {
            System.out.println(NOTHING_FOUND);
            selectLecturesOption(chooseLecturesOption());
        }
        return choice;
    }

    public int repeatStudentAction() {

        System.out.println(OPTION_CHOICE);
        int choice = USER_INPUT.nextInt();

        if (choice == 0)
            selectStudentsOption(chooseStudentsOption());
        else if (choice != 1) {
            System.out.println(NOTHING_FOUND);
            selectStudentsOption(chooseStudentsOption());
        }
        return choice;
    }

    public int repeatTeacherAction() {

        System.out.println(OPTION_CHOICE);
        int choice = USER_INPUT.nextInt();

        if (choice == 0) {
            selectTeachersOption(chooseTeachersOption());
        } else if (choice != 1) {
            System.out.println(NOTHING_FOUND);
            selectTeachersOption(chooseTeachersOption());
        }
        return choice;
    }

    public void welcomeTo() {

        int startOption;

        while (true) {

            System.out.println("Welcome to 'Online School' project!\n" +
                    "Would you like to continue?");
            System.out.println(OPTION_CHOICE);

            startOption = USER_INPUT.nextInt();

            if (startOption == 1)
                break;
            if (startOption == 0)
                finishProgram();
            else
                System.out.println(NOTHING_FOUND);
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
                lectureRepository.getAll();
                selectLecturesOption(chooseLecturesOption());
                break;
            case 2:
                System.out.println("You have selected 'Teachers' category!");
                personRepository.getAllTeachers();
                selectTeachersOption(chooseTeachersOption());
                break;
            case 3:
                System.out.println("You have selected 'Students' category!");
                personRepository.getAllStudents();
                selectStudentsOption(chooseStudentsOption());
                break;
            case 4:
                System.out.println("You have selected 'Courses' category!");
                break;
            default:
                System.out.println(NOTHING_FOUND);
        }

    }

    public void initLectureData() {

        Lecture firstLecture = new Lecture("Intro", firstCourse.getId(), "First");
        lectureRepository.add(firstLecture);
        Lecture secondLecture = new Lecture("Variables", firstCourse.getId(), "Second");
        lectureRepository.add(secondLecture);
        Lecture thirdLecture = new Lecture("Git", firstCourse.getId(), "Third");
        lectureRepository.add(thirdLecture);
        Lecture fourthLecture = new Lecture("Methods", firstCourse.getId(), "Fourth");
        lectureRepository.add(fourthLecture);
        Lecture fifthLecture = new Lecture("Arrays", firstCourse.getId(), "Fifth");
        lectureRepository.add(fifthLecture);

    }

    public void initTeacherData() {

        Person firstTeacher = new Person("Andriy", "Shevchenko",
                "+380667788999", "Shev@gmail.com", Role.TEACHER);
        personRepository.add(firstTeacher);

        Person secondTeacher = new Person("Lionel", "Messi",
                "+380997788999", "Mess@gmail.com", Role.TEACHER);
        personRepository.add(secondTeacher);

        Person thirdTeacher = new Person("Cristiano", "Ronaldo",
                "+380637788999", "CR7@gmail.com", Role.TEACHER);
        personRepository.add(thirdTeacher);

    }

    public void initStudentData() {

        Person firstStudent = new Person("Andriy", "Yarmolenko",
                "+380667788555", "Yar@gmail.com", Role.STUDENT);
        personRepository.add(firstStudent);

        Person secondStudent = new Person("Mykhaylo", "Mudryk",
                "+380997788555", "Mudr@gmail.com", Role.STUDENT);
        personRepository.add(secondStudent);
        Person thirdStudent = new Person("Viktor", "Tsygankov",
                "+380637788555", "V1tya@gmail.com", Role.STUDENT);
        personRepository.add(thirdStudent);

    }

    public void findLecture() {

        System.out.println("Enter lecture's index you want to find:");

        int inputIndex = USER_INPUT.nextInt();
        lectureRepository.get(inputIndex);

        System.out.println("Would you like to find another lecture?");

        if (repeatLectureAction() == 1)
            findLecture();
    }

    public void findTeacher() {

        System.out.println("Enter teacher's index you want to find:");

        int inputIndex = USER_INPUT.nextInt();
        personRepository.getTeacher(inputIndex);

        System.out.println("Would you like to find another teacher?");

        if (repeatTeacherAction() == 1)
            findTeacher();
    }

    public void findStudent() {

        System.out.println("Enter student's index you want to find:");

        int inputIndex = USER_INPUT.nextInt();
        personRepository.getStudent(inputIndex);

        System.out.println("Would you like to find another student?");

        if (repeatStudentAction() == 1)
            findStudent();
    }

    public void deleteLecture() {

        System.out.println("Enter lecture's index you want to delete:");

        int inputIndex = USER_INPUT.nextInt();
        lectureRepository.remove(inputIndex);

        System.out.println("Would you like to delete another lecture?");

        if (repeatLectureAction() == 1)
            deleteLecture();
    }

    public void deleteTeacher() {

        System.out.println("Enter teacher's index you want to delete:");

        int inputIndex = USER_INPUT.nextInt();
        personRepository.removeTeacher(inputIndex);

        System.out.println("Would you like to delete another teacher?");

        if (repeatTeacherAction() == 1)
            deleteTeacher();
    }

    public void deleteStudent() {

        System.out.println("Enter student's index you want to delete:");

        int inputIndex = USER_INPUT.nextInt();
        personRepository.removeStudent(inputIndex);

        System.out.println("Would you like to delete another student?");

        if (repeatStudentAction() == 1)
            deleteStudent();
    }

    public int chooseLecturesOption() {

        int chosenOption;

        do {
            System.out.println("""
                                        
                    We have next options to choose:
                                        
                    1. - create new lecture
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
                                        
                    1. - create new teacher
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
                                        
                    1. - create new student
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
                System.out.println("You have selected 'create new lecture' option!");
                createNewLecture();
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
                System.out.println("You have selected 'create new teacher' option!");
                createNewTeacher();
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
                addTeacherToLecture();
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
                createNewStudent();
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

    public void addTeacherToLecture() {

        int teacherIndex;
        int lectureIndex;
        Person requiredTeacher;
        Lecture requiredLecture;
        Lecture updatedLecture;

        personRepository.getAllTeachers();

        System.out.println("Enter teacher's index you want to add:");

        teacherIndex = USER_INPUT.nextInt();
        requiredTeacher = personRepository.getTeacher(teacherIndex);

        lectureRepository.getAll();

        System.out.println("Enter lecture's index you want to add teacher to:");

        lectureIndex = USER_INPUT.nextInt();
        requiredLecture = lectureRepository.get(lectureIndex);

        updatedLecture = requiredLecture.addPersonToLecture(requiredTeacher, requiredLecture);

        System.out.println("Congratulations, you have just added teacher to lecture! " +
                "Now we have:\n" + updatedLecture);

        System.out.println("Would you like to repeat this action?");

        if (repeatTeacherAction() == 1)
            addTeacherToLecture();
    }

    public String assignFirstName() {

        String firstName;

        do {
            System.out.println("Enter first name (format like 'Valerii'):");
            firstName = USER_INPUT.next();
            checkName(firstName);
            if (!checkName(firstName))
                System.out.println(WRONG_FORMAT);
        } while (!checkName(firstName));

        System.out.println("First name: " + firstName);
        return firstName;
    }

    public boolean checkName(String inputName) {
        Pattern pattern = Pattern.compile("^([А-Я][а-яё]{1,23}|[A-Z][a-z]{1,23})$");
        Matcher matcher = pattern.matcher(inputName);
        return matcher.matches();
    }

    public String assignLastName() {

        String lastName;

        do {
            System.out.println("Enter last name (format like 'Zaluzhnyi'):");
            lastName = USER_INPUT.next();
            checkName(lastName);
            if (!checkName(lastName))
                System.out.println(WRONG_FORMAT);
        } while (!checkName(lastName));

        System.out.println("Last name: " + lastName);
        return lastName;
    }

    public String assignPhone() {

        String phone;

        do {
            System.out.println("Enter phone number (format like '+380XXXXXXXXX'):");
            phone = USER_INPUT.next();
            checkPhone(phone);
            if (!checkPhone(phone))
                System.out.println(WRONG_FORMAT);
        } while (!checkPhone(phone));

        System.out.println("Phone number: " + phone);
        return phone;
    }

    public boolean checkPhone(String inputPhone) {
        Pattern pattern = Pattern.compile("\\+380\\d{3}\\d{2}\\d{2}\\d{2}");
        Matcher matcher = pattern.matcher(inputPhone);
        return matcher.matches();
    }

    public String assignEmail() {

        String email;

        do {
            System.out.println("Enter email address:");
            email = USER_INPUT.next();
            checkEmail(email);
            if (!checkEmail(email))
                System.out.println(WRONG_FORMAT);
        } while (!checkEmail(email));

        System.out.println("Email address: " + email);
        return email;
    }

    public boolean checkEmail(String inputEmail) {
        Pattern pattern = Pattern.compile("\\w{3,}@\\w+.\\w{2,3}");
        Matcher matcher = pattern.matcher(inputEmail);
        return matcher.matches();
    }

    public Person createNewTeacher() {

        Person teacher = new Person(assignFirstName(), assignLastName(), assignPhone(), assignEmail(), Role.TEACHER);
        personRepository.add(teacher);

        System.out.println("Congratulations! You have just created new teacher:\n" + teacher);

        personRepository.getAllTeachers();

        System.out.println("Would you like to create another teacher?");

        if (repeatTeacherAction() == 1)
            createNewTeacher();

        return teacher;
    }

    public Person createNewStudent() {

        Person student = new Person(assignFirstName(), assignLastName(), assignPhone(), assignEmail(), Role.STUDENT);
        personRepository.add(student);

        System.out.println("Congratulations! You have just created new student:\n" + student);

        personRepository.getAllStudents();

        System.out.println("Would you like to create another student?");

        if (repeatStudentAction() == 1)
            createNewStudent();

        return student;
    }

    public void createNewLecture() {

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

        System.out.println("Congratulations! You have just created new lecture:\n" + lecture);
        lectureRepository.getAll();

        System.out.println("Would you like to create another lecture?");

        if (repeatLectureAction() == 1)
            createNewLecture();

        USER_INPUT.close();
    }

}
