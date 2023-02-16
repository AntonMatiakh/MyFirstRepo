package com.academy.repository;

import com.academy.models.Person;

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

        if (index < 0)
            System.out.println("WRONG ARGUMENT!!! Index can't be < 0 !!!");
        else if (index >= Person.getCounter())
            System.out.println("Sorry, person with index=" + index + " doesn't exist!");
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

        if (index < 0)
            System.out.println("WRONG ARGUMENT!!! Index can't be < 0 !!!");
        else if (index >= Person.getCounter())
            System.out.println("Sorry, person with index=" + index + " doesn't exist!");
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

    @Override
    public Person[] getAll() {

        System.out.println("Now we have next persons:");

        for (Person person : persons) {

            if (person == null)
                continue;
            System.out.println(person);
        }
        return persons;
    }

}
