package com.academy.repository;

import com.academy.models.Lecture;
import com.academy.models.Model;

import java.util.Arrays;

import static com.academy.repository.Repository.getSTANDARD_INITIAL_SIZE;

public class LectureRepository extends General <Lecture> {

    private Lecture[] lectures;

    public LectureRepository() {
        this.lectures = new Lecture[getSTANDARD_INITIAL_SIZE()];
    }

    @Override
    public int size() {
        return lectures.length;
    }

    @Override
    public boolean isEmpty() {

        boolean result = true;

        for (Lecture lecture : lectures) {

            if (lecture != null) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public Lecture get(int index) {

        Lecture detectedLecture = null;

        if (index < 0 || index >= lectures.length)

            System.out.println("Sorry, nothing found...");

        else {

            for (Lecture lecture : lectures) {

                if (lecture == null)
                    continue;

                detectedLecture = lectures[index];
                System.out.println("We have found next lecture:\n" + detectedLecture);
                break;
            }
        }
        return detectedLecture;
    }

    @Override
    public void remove(int index) {

        if (index < 0 || index >= lectures.length)

            System.out.println("Sorry, nothing found...");

        else {

            Lecture[] result = new Lecture[lectures.length - 1];

            for (Lecture lecture : lectures) {

                if (lecture == null)
                    continue;
                if (lecture == lectures[index])
                    System.out.println("You have just deleted next lecture:\n" + lecture);
            }

            System.arraycopy(lectures, 0, result, 0, index);
            System.arraycopy(lectures, index + 1, result, index, lectures.length - index - 1);
            lectures = result;
            getAll();
        }
    }

    @Override
    public void add(Model lecture) {

        for (int i = 0; i < lectures.length; i++) {

            if (lectures[i] == null) {
                lectures[i] = (Lecture) lecture;
                break;
            }
            if (i == lectures.length - 1) {
                increaseStorageSize();
            }
        }
    }

    @Override
    public void increaseStorageSize() {
        int newSize = (lectures.length * 3) / 2 + 1;
        Lecture[] increasedSizeStorage = new Lecture[newSize];
        System.arraycopy(lectures, 0, increasedSizeStorage, 0, lectures.length);
        lectures = increasedSizeStorage;
    }
    
    @Override
    public void add(int index, Model lecture) {

        Lecture[] result = new Lecture[lectures.length + 1];
        System.arraycopy(lectures, 0, result, 0, index);
        System.arraycopy(lectures, index, result, index + 1, lectures.length - index);
        result[index] = (Lecture) lecture;
        lectures = result;
        getAll();
    }

    @Override
    public void getAll() {

        System.out.println("Now we have next lectures:");

        for (Lecture lecture : lectures) {

            if (lecture == null)
                continue;
            System.out.println(lecture);
        }
    }

    @Override
    public void getById(int inputId) {

        if (inputId <= 0 || inputId > lectures.length)

            System.out.println("Sorry, nothing found...");

        else {

            for (Lecture lecture : lectures) {

                if (lecture == null)
                    continue;
                if (lecture.getId() == inputId) {
                    System.out.println("We have just found nex lecture: " + lecture);
                    break;
                }
            }
        }
    }

    @Override
    public void deleteById(int inputId) {

        if (inputId <= 0 || inputId > lectures.length)

            System.out.println("Sorry, nothing found...");

        else {

            Lecture[] result = new Lecture[lectures.length - 1];
            int index = inputId - 1;

            for (Lecture lecture : lectures) {
                if (lecture == null)
                    continue;
                if (lecture.getId() == inputId)
                    System.out.println("You have just deleted:\n" + lecture);
            }

            System.arraycopy(lectures, 0, result, 0, index);
            System.arraycopy(lectures, index + 1, result, index, lectures.length - index - 1);
            lectures = result;
        }
    }

    @Override
    public String toString() {
        return "LectureRepository{" +
                "lectures=" + Arrays.toString(lectures) +
                '}';
    }

}

