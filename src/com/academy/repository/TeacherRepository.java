package com.academy.repository;

import com.academy.models.Model;
import com.academy.models.Person;
import com.academy.models.Student;
import com.academy.models.Teacher;

public class TeacherRepository extends General <Teacher> {
    private Teacher[] teachers;

    public TeacherRepository() {
        this.teachers = new Teacher[getSTANDARD_INITIAL_SIZE()];
    }

    @Override
    public int size() {
        return teachers.length;
    }

    @Override
    public void add(Teacher teacher) {

        for (int i = 0; i < teachers.length; i++) {

            if (teachers[i] == null) {
                teachers[i] = teacher;
                break;
            }
            if (i == teachers.length - 1) {
                increaseStorageSize();
            }
        }
    }

    @Override
    public void add(int index, Teacher teacher) {

        Teacher[] result = new Teacher[teachers.length + 1];
        System.arraycopy(teachers, 0, result, 0, index);
        System.arraycopy(teachers, index, result, index + 1, teachers.length - index);
        result[index] = teacher;
        teachers = result;
        getAll();
    }

    @Override
    public void increaseStorageSize() {
        int newSize = (teachers.length * 3) / 2 + 1;
        Teacher[] increasedSizeStorage = new Teacher[newSize];
        System.arraycopy(teachers, 0, increasedSizeStorage, 0, teachers.length);
        teachers = increasedSizeStorage;
    }

    @Override
    public Teacher get(int index) {

        Teacher detectedTeacher = null;

        if (index < 0)
            System.out.println("WRONG ARGUMENT!!! Index can't be < 0 !!!");
        else if (index >= Teacher.getCounter())
            System.out.println("Sorry, teacher with index=" + index + " doesn't exist!");
        else {
            for (Teacher teacher : teachers) {

                if (teacher == null)
                    continue;

                detectedTeacher = teachers[index];
                System.out.println("We have found next lecture:\n" + detectedTeacher);
                break;
            }
        }
        return detectedTeacher;
    }

    @Override
    public boolean isEmpty() {

        boolean result = true;

        for (Teacher teacher : teachers) {

            if (teacher != null) {
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
        else if (index >= Teacher.getCounter())
            System.out.println("Sorry, teacher with index=" + index + " doesn't exist!");
        else {

            Teacher[] result = new Teacher[teachers.length - 1];

            for (Teacher teacher : teachers) {

                if (teacher == null)
                    continue;
                if (teacher == teachers[index])
                    System.out.println("You have just deleted next lecture:\n" + teacher);
            }

            System.arraycopy(teachers, 0, result, 0, index);
            System.arraycopy(teachers, index + 1, result, index, teachers.length - index - 1);
            teachers = result;
            getAll();
        }
    }

    @Override
    public Teacher[] getAll() {

        System.out.println("Now we have next teachers:");

        for (Teacher teacher : teachers) {

            if (teacher == null)
                continue;
            System.out.println(teacher);
        }
        return teachers;
    }

//    @Override
//    public void add(Model model) {
//        super.add(model);
//    }

//    @Override
//    public void getById(int inputId) {
//        if (inputId <= 0)
//            System.out.println("WRONG ARGUMENT!!! Teacher's id must be > 0 !!!");
//        else if (inputId > Teacher.getCounter())
//            System.out.println("Sorry, teacher with id=" + inputId + " doesn't exist!");
//        else super.getById(inputId);
//    }

//    @Override
//    public void deleteById(int inputId) {
//        if (inputId <= 0)
//            System.out.println("WRONG ARGUMENT!!! Teacher's id must be > 0 !!!");
//        else if (inputId > Teacher.getCounter())
//            System.out.println("Sorry, teacher with id=" + inputId + " doesn't exist!");
//        else super.deleteById(inputId);
//    }

//    @Override
//    public Model[] showAll() {
//        System.out.println("Now we have next teachers:");
//        return super.showAll();
//    }
}
