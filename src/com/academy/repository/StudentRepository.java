package com.academy.repository;

import com.academy.models.Model;
import com.academy.models.Person;
import com.academy.models.Student;

import java.util.Arrays;

public class StudentRepository extends Repository {
    private Student[] students;

    public StudentRepository() {
        this.students = new Student[getSTANDARD_INITIAL_SIZE()];
    }

    @Override
    public void add(Model model) {
        super.add(model);
    }

    @Override
    public void getById(int studentId) {
        if (studentId <= 0) {
            System.out.println("WRONG ARGUMENT!!! Student's id must be > 0 !!!");
        } else if (studentId > Person.getCounter() || modelsArray[studentId - 1] == null) {
            System.out.println("Sorry, student with id=" + studentId + " doesn't exist!");
        } else {
            System.out.println("We have just found:");
            super.getById(studentId - 1);
        }
    }

    @Override
    public void deleteById(int studentId) {
        if (studentId <= 0) {
            System.out.println("WRONG ARGUMENT!!! Student's id must be > 0 !!!");
        } else if (studentId > Person.getCounter()) {
            System.out.println("Sorry, student with id=" + studentId + " doesn't exist!");
        } else if (studentId - 1 != modelsArray.length) {
            modelsArray[studentId - 1] = null;
            System.out.println("Student with id=" + studentId + " has just been deleted!");
            System.out.println(Arrays.toString(getAll()));
        }
    }

    @Override
    public Model[] getAll() {
        System.out.println("Now we have next students:");
        return super.getAll();
    }

}
