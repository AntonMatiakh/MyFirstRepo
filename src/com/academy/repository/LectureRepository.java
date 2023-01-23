package com.academy.repository;

import com.academy.models.Lecture;
import com.academy.models.Model;

import java.util.Arrays;

public class LectureRepository extends Repository {
    private Lecture[] lectures;

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
    public void getById(int lectureId) {
        if (lectureId <= 0) {
            System.out.println("WRONG ARGUMENT!!! Lecture's id must be > 0 !!!");
        } else if (lectureId > Lecture.getCounter() || modelsArray[lectureId - 1] == null) {
            System.out.println("Sorry, lecture with id=" + lectureId + " doesn't exist!");
        } else {
            System.out.println("We have just found:");
            super.getById(lectureId - 1);
        }
    }

    @Override
    public void deleteById(int lectureId) {
        if (lectureId <= 0) {
            System.out.println("WRONG ARGUMENT!!! Lecture id must be > 0 !!!");
        } else if (lectureId > Lecture.getCounter()) {
            System.out.println("Sorry, lecture with id=" + lectureId + " doesn't exist!");
        } else if (lectureId - 1 != modelsArray.length) {
            modelsArray[lectureId - 1] = null;
            System.out.println("Lecture with id=" + lectureId + " has just been deleted!");
            System.out.println(Arrays.toString(getAll()));
        }
    }

    public Lecture[] getLectures() {
        return lectures;
    }

    @Override
    public String toString() {
        return "LectureRepository{" +
                "lectures=" + Arrays.toString(modelsArray) +
                '}';
    }

}

