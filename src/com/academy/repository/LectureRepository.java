package com.academy.repository;

import com.academy.models.Lecture;
import com.academy.models.Model;

import java.util.Arrays;

public class LectureRepository extends Repository {
    private static final int STANDARD_INITIAL_SIZE = 5;
    private Lecture[] lectures;

    public LectureRepository() {
        this.lectures = new Lecture[STANDARD_INITIAL_SIZE];
    }

    public LectureRepository(int inputSize) {
        if (inputSize < 1) {
            System.out.println("WRONG ARGUMENT, CREATING STANDARD SIZED ARRAY");
            this.lectures = new Lecture[STANDARD_INITIAL_SIZE];
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
        return super.getAll();
    }

    @Override
    public String showCreatedModels() {
        return super.showCreatedModels();
    }

    @Override
    public void getById(int lectureId) {
        super.getById(lectureId);
    }

    @Override
    public void deleteById(int lectureId) {
        super.deleteById(lectureId);
    }

    public Lecture[] getLectures() {
        return lectures;
    }

    @Override
    public String toString() {

        return "LectureRepository{" +
                "lectures=" + Arrays.toString(modelArray) +
                '}';

    }

}

