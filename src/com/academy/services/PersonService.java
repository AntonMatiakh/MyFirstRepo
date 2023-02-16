package com.academy.services;

import com.academy.MainService;
import com.academy.models.Person;
import com.academy.models.Role;

public class PersonService extends MainService {

    public String assignFirstName() {

        String firstName;

        do {
            System.out.println("Enter first name (format like 'Valerii'):");
            firstName = getUserInput().next();
            checkName(firstName);
            if (!checkName(firstName))
                System.out.println(getWrongFormat());
        } while (!checkName(firstName));

        System.out.println("First name: " + firstName);
        return firstName;
    }

    public String assignLastName() {

        String lastName;

        do {
            System.out.println("Enter last name (format like 'Zaluzhnyi'):");
            lastName = getUserInput().next();
            checkName(lastName);
            if (!checkName(lastName))
                System.out.println(getWrongFormat());
        } while (!checkName(lastName));

        System.out.println("Last name: " + lastName);
        return lastName;
    }

    public String assignPhone() {

        String phone;

        do {
            System.out.println("Enter phone number (format like '+380XXXXXXXXX'):");
            phone = getUserInput().next();
            checkPhone(phone);
            if (!checkPhone(phone))
                System.out.println(getWrongFormat());
        } while (!checkPhone(phone));

        System.out.println("Phone number: " + phone);
        return phone;
    }

    public String assignEmail() {

        String email;

        do {
            System.out.println("Enter email address:");
            email = getUserInput().next();
            checkEmail(email);
            if (!checkEmail(email))
                System.out.println(getWrongFormat());
        } while (!checkEmail(email));

        System.out.println("Email address: " + email);
        return email;
    }

    public Person createNewTeacher() {

        int choice;
        Person teacher;

        do {

            teacher = new Person(assignFirstName(), assignLastName(), assignPhone(), assignEmail(), Role.TEACHER);
            System.out.println("Congratulations! You have just created new teacher:\n" + teacher);
            System.out.println("Would you like to create another teacher?");
            System.out.println(getOptionChoice());
            choice = getUserInput().nextInt();

        } while (choice == 1);

        if (choice == 0) {
            selectTeachersOption(chooseTeachersOption());
        } else {
            System.out.println(getNothingFound());
            selectTeachersOption(chooseTeachersOption());
        }
        return teacher;
    }

    public Person createNewStudent() {

        int choice;
        Person student;

        do {

        student = new Person();
        student.setFirstName(assignFirstName());
        student.setLastName(assignLastName());
        student.setPhone(assignPhone());
        student.setEmail(assignEmail());
        student.setRole(Role.STUDENT);
        System.out.println("Congratulations! You have just created new student:\n" + student);
        //personRepository.getAll();
        System.out.println("Would you like to create another student?");
        System.out.println(getOptionChoice());
        choice = getUserInput().nextInt();

        } while (choice == 1);

        if (choice == 0)
            selectStudentsOption(chooseStudentsOption());
        else {
            System.out.println(getNothingFound());
            selectStudentsOption(chooseStudentsOption());
        }
        return student;
    }

}
