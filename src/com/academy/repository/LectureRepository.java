package com.academy.repository;

import com.academy.models.Lecture;
import com.academy.models.Model;

import java.util.Arrays;

public class LectureRepository extends Repository {
    private Lecture[] lectures;
    public Lecture[] getLectures() {
        return lectures;
    }
    public LectureRepository() {
        this.lectures = new Lecture[getSTANDARD_INITIAL_SIZE()];
    }

    public LectureRepository(int inputSize) {
        if (inputSize < 1) {
            System.out.println("WRONG ARGUMENT, CREATING STANDARD SIZED ARRAY");
            this.lectures = new Lecture[getSTANDARD_INITIAL_SIZE()];
        } else {
            this.lectures = new Lecture[inputSize];
        }
    }

    @Override
    public void add(Model model) {
        super.add(model);
    }

    @Override
    public Model[] getAll() {
        System.out.println("Now we have next lectures:");
        return super.getAll();
    }

    @Override
    public void getById(int inputId) {

        if (inputId <= 0)
            System.out.println("WRONG ARGUMENT!!! Lecture's id must be > 0 !!!");
        else if (inputId > Lecture.getCounter())
            System.out.println("Sorry, lecture with id=" + inputId + " doesn't exist!");
       else super.getById(inputId);

    }

    @Override
    public void deleteById(int inputId) {

        if (inputId <= 0)
            System.out.println("WRONG ARGUMENT!!! Lecture's id must be > 0 !!!");
        else if (inputId > Lecture.getCounter())
            System.out.println("Sorry, lecture with id=" + inputId + " doesn't exist!");
        else super.deleteById(inputId);

    }

    @Override
    public String toString() {
        return "LectureRepository{" +
                "lectures=" + Arrays.toString(modelsArray) +
                '}';
    }

}

