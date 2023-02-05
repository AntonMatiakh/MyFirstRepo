package com.academy.repository;

import com.academy.models.Model;
import com.academy.models.Student;

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

    @Override
    public Model[] getAll() {
        System.out.println("Now we have next students:");
        return super.getAll();
    }

}
