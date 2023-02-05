package com.academy.repository;

import com.academy.models.Model;
import com.academy.models.Teacher;

public class TeacherRepository extends Repository {
    private Teacher[] teachers;

    public TeacherRepository() {
        this.teachers = new Teacher[getSTANDARD_INITIAL_SIZE()];
    }

    @Override
    public void add(Model model) {
        super.add(model);
    }

    @Override
    public void getById(int inputId) {
        if (inputId <= 0)
            System.out.println("WRONG ARGUMENT!!! Teacher's id must be > 0 !!!");
        else if (inputId > Teacher.getCounter())
            System.out.println("Sorry, teacher with id=" + inputId + " doesn't exist!");
        else super.getById(inputId);
    }

    @Override
    public void deleteById(int inputId) {
        if (inputId <= 0)
            System.out.println("WRONG ARGUMENT!!! Teacher's id must be > 0 !!!");
        else if (inputId > Teacher.getCounter())
            System.out.println("Sorry, teacher with id=" + inputId + " doesn't exist!");
        else super.deleteById(inputId);
    }

    @Override
    public Model[] getAll() {
        System.out.println("Now we have next teachers:");
        return super.getAll();
    }
}
