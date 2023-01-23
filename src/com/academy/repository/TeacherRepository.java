package com.academy.repository;

import com.academy.models.Model;
import com.academy.models.Person;
import com.academy.models.Teacher;

import java.util.Arrays;

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
    public void getById(int teacherId) {
        if (teacherId <= 0) {
            System.out.println("WRONG ARGUMENT!!! Teacher's id must be > 0 !!!");
        } else if (teacherId > Person.getCounter() || modelsArray[teacherId - 1] == null) {
            System.out.println("Sorry, teacher with id=" + teacherId + " doesn't exist!");
        } else {
            System.out.println("We have just found:");
            super.getById(teacherId - 1);
        }
    }

    @Override
    public void deleteById(int teacherId) {
        if (teacherId <= 0) {
            System.out.println("WRONG ARGUMENT!!! Teacher's id must be > 0 !!!");
        } else if (teacherId > Person.getCounter()) {
            System.out.println("Sorry, teacher with id=" + teacherId + " doesn't exist!");
        } else if (teacherId - 1 != modelsArray.length) {
            modelsArray[teacherId - 1] = null;
            System.out.println("Teacher with id=" + teacherId + " has just been deleted!");
            System.out.println(Arrays.toString(getAll()));
        }
    }

    @Override
    public Model[] getAll() {
        System.out.println("Now we have next teachers:");
        return super.getAll();
    }
}
