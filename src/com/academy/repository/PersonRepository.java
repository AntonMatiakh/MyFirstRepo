package com.academy.repository;

import com.academy.models.Person;
import com.academy.models.Role;

public class PersonRepository extends General <Person> {

    private static Person[] persons = new Person[getSTANDARD_INITIAL_SIZE()];

    public PersonRepository() {
    }

    @Override
    public int size() {
        return persons.length;
    }

    @Override
    public void add(Person person) {

        for (int i = 0; i < persons.length; i++) {

            if (persons[i] == null) {
                persons[i] = person;
                break;
            }
            if (i == persons.length - 1) {
                increaseStorageSize();
            }
        }
    }

    @Override
    public void increaseStorageSize() {

        int newSize = (persons.length * 3) / 2 + 1;
        Person[] increasedSizeStorage = new Person[newSize];
        System.arraycopy(persons, 0, increasedSizeStorage, 0, persons.length);
        persons = increasedSizeStorage;
    }

    @Override
    public void add(int index, Person person) {

        Person[] result = new Person[persons.length + 1];
        System.arraycopy(persons, 0, result, 0, index);
        System.arraycopy(persons, index, result, index + 1, persons.length - index);
        result[index] = person;
        persons = result;
        getAll();
    }

    @Override
    public Person get(int index) {

        Person detectedPerson = null;

        if (index < 0 || index >= persons.length)

            System.out.println("Sorry, nothing found...");

        else {

            for (Person person : persons) {

                if (person == null)
                    continue;

                detectedPerson = persons[index];
                System.out.println("We have found next person:\n" + detectedPerson);
                break;
            }
        }
        return detectedPerson;
    }

    public Person getTeacher(int index) {

        Person detectedPerson = null;

        if (index < 0 || index >= persons.length || persons[index].getRole() != Role.TEACHER)

            System.out.println("Sorry, teacher is not found...");

        else {

            for (Person person : persons) {

                if (person == null)
                    continue;

                if (persons[index].getRole() == Role.TEACHER) {

                    detectedPerson = persons[index];
                    System.out.println("We have found next teacher:\n" + detectedPerson);
                    break;
                }
            }
        }
        return detectedPerson;
    }

    public Person getStudent(int index) {

        Person detectedPerson = null;

        if (index < 0 || index >= persons.length || persons[index].getRole() != Role.STUDENT)

            System.out.println("Sorry, student is not found...");

        else {

            for (Person person : persons) {

                if (person == null)
                    continue;

                if (persons[index].getRole() == Role.STUDENT) {

                    detectedPerson = persons[index];
                    System.out.println("We have found next student:\n" + detectedPerson);
                    break;
                }
            }
        }
        return detectedPerson;
    }

    @Override
    public boolean isEmpty() {

        boolean result = true;

        for (Person person : persons) {

            if (person != null) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public void remove(int index) {

        if (index < 0 || index >= persons.length)

            System.out.println("Sorry, nothing found...");

        else {

            Person[] result = new Person[persons.length - 1];

            for (Person person : persons) {

                if (person == null)
                    continue;
                if (person == persons[index])
                    System.out.println("You have just deleted next person:\n" + person);
            }

            System.arraycopy(persons, 0, result, 0, index);
            System.arraycopy(persons, index + 1, result, index, persons.length - index - 1);
            persons = result;
            getAll();
        }
    }

    public void removeTeacher(int index) {

        if (index < 0 || index >= persons.length || persons[index].getRole() != Role.TEACHER)

            System.out.println("Sorry, teacher is not found...");

        else {

            Person[] result = new Person[persons.length - 1];

            for (Person person : persons) {

                if (person == null)
                    continue;
                if (person == persons[index])
                    System.out.println("You have just deleted next teacher:\n" + person);
            }

            System.arraycopy(persons, 0, result, 0, index);
            System.arraycopy(persons, index + 1, result, index, persons.length - index - 1);
            persons = result;
            getAllTeachers();
        }
    }

    public void removeStudent(int index) {

        if (index < 0 || index >= persons.length || persons[index].getRole() != Role.STUDENT)

            System.out.println("Sorry, student is not found...");

        else {

            Person[] result = new Person[persons.length - 1];

            for (Person person : persons) {

                if (person == null)
                    continue;
                if (person == persons[index])
                    System.out.println("You have just deleted next student:\n" + person);
            }

            System.arraycopy(persons, 0, result, 0, index);
            System.arraycopy(persons, index + 1, result, index, persons.length - index - 1);
            persons = result;
            getAllStudents();
        }
    }

    @Override
    public Person[] getAll() {

        System.out.println("Now we have next persons:");
        System.out.println();
        for (Person person : persons) {

            if (person == null)
                continue;
            System.out.println(person);
        }
        return persons;
    }

    public void getAllTeachers() {

        System.out.println("Now we have next teachers:");
        System.out.println();
        for (Person person : persons) {

            if (person == null)
                continue;

            if (person.getRole() == Role.TEACHER)
                System.out.println(person);
        }
    }

    public void getAllStudents() {

        System.out.println("Now we have next students:");
        System.out.println();
        for (Person person : persons) {

            if (person == null)
                continue;

            if (person.getRole() == Role.STUDENT)
                System.out.println(person);
        }
    }

}
