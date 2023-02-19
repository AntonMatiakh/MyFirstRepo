package com.academy.repository;

import com.academy.models.Lecture;
import com.academy.models.Model;
import com.academy.models.Student;

public class StudentRepository extends General <Student> {
    private Student[] students;

    public StudentRepository() {
        this.students = new Student[getSTANDARD_INITIAL_SIZE()];
    }

    @Override
    public int size() {
        return students.length;
    }

    @Override
    public void add(Student student) {
        for (int i = 0; i < students.length; i++) {

            if (students[i] == null) {
                students[i] = student;
                break;
            }
            if (i == students.length - 1) {
                increaseStorageSize();
            }
        }
    }

    @Override
    public void add(int index, Student student) {
        Student[] result = new Student[students.length + 1];
        System.arraycopy(students, 0, result, 0, index);
        System.arraycopy(students, index, result, index + 1, students.length - index);
        result[index] = student;
        students = result;
        getAll();
    }

    @Override
    public void increaseStorageSize() {

        int newSize = (students.length * 3) / 2 + 1;
        Student[] increasedSizeStorage = new Student[newSize];
        System.arraycopy(students, 0, increasedSizeStorage, 0, students.length);
        students = increasedSizeStorage;
    }

    @Override
    public Student get(int index) {

        Student detectedStudent = null;

        if (index < 0)
            System.out.println("WRONG ARGUMENT!!! Index can't be < 0 !!!");
        else if (index >= Student.getCounter())
            System.out.println("Sorry, student with index=" + index + " doesn't exist!");
        else {
            for (Student student : students) {

                if (student == null)
                    continue;

                detectedStudent = students[index];
                System.out.println("We have found next lecture:\n" + detectedStudent);
                break;
            }
        }
        return detectedStudent;
    }

    @Override
    public boolean isEmpty() {

        boolean result = true;

        for (Student student : students) {

            if (student != null) {
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
        else if (index >= Student.getCounter())
            System.out.println("Sorry, student with index=" + index + " doesn't exist!");
        else {

            Student[] result = new Student[students.length - 1];

            for (Student student : students) {

                if (student == null)
                    continue;
                if (student == students[index])
                    System.out.println("You have just deleted next lecture:\n" + student);
            }

            System.arraycopy(students, 0, result, 0, index);
            System.arraycopy(students, index + 1, result, index, students.length - index - 1);
            students = result;
            getAll();
        }
    }

    @Override
    public Student[] getAll() {

        System.out.println("Now we have next students:");

        for (Student student : students) {

            if (student == null)
                continue;
            System.out.println(student);
        }
        return students;
    }

    @Override
    public void getById(int inputId) {
        if (inputId <= 0)
            System.out.println("WRONG ARGUMENT!!! Student's id must be > 0 !!!");
        else if (inputId > Student.getCounter())
            System.out.println("Sorry, student with id=" + inputId + " doesn't exist!");
        else super.getById(inputId);
    }

    @Override
    public void deleteById(int inputId) {
        if (inputId <= 0)
            System.out.println("WRONG ARGUMENT!!! Student's id must be > 0 !!!");
        else if (inputId > Student.getCounter())
            System.out.println("Sorry, student with id=" + inputId + " doesn't exist!");
        else super.deleteById(inputId);
    }

}
