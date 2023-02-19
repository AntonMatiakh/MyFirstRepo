package com.academy.repository;

import com.academy.models.Lecture;

import java.util.Arrays;

public class LectureRepository extends General <Lecture> {

    private Lecture[] lectures;

    public LectureRepository() {
        this.lectures = new Lecture[getSTANDARD_INITIAL_SIZE()];
    }

    public Lecture[] getLectures() {
        return lectures;
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
    public int size() {
        return lectures.length;
    }

    @Override
    public void add(Lecture lecture) {
        for (int i = 0; i < lectures.length; i++) {

            if (lectures[i] == null) {
                lectures[i] = lecture;
                break;
            }
            if (i == lectures.length - 1) {
                increaseStorageSize();
            }
        }
    }

    @Override
    public void add(int index, Lecture lecture) {

        Lecture[] result = new Lecture[lectures.length + 1];
        System.arraycopy(lectures, 0, result, 0, index);
        System.arraycopy(lectures, index, result, index + 1, lectures.length - index);
        result[index] = lecture;
        lectures = result;
        getAll();
    }

    @Override
    public void increaseStorageSize() {
        int newSize = (lectures.length * 3) / 2 + 1;
        Lecture[] increasedSizeStorage = new Lecture[newSize];
        System.arraycopy(lectures, 0, increasedSizeStorage, 0, lectures.length);
        lectures = increasedSizeStorage;
    }

    @Override
    public Lecture get(int index) {

        Lecture detectedLecture = null;

        if (index < 0)
            System.out.println("WRONG ARGUMENT!!! Index can't be < 0 !!!");
        else if (index >= Lecture.getCounter())
            System.out.println("Sorry, lecture with index=" + index + " doesn't exist!");
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
    public void remove(int index) {

        if (index < 0)
            System.out.println("WRONG ARGUMENT!!! Index can't be < 0 !!!");
        else if (index >= Lecture.getCounter())
            System.out.println("Sorry, lecture with index=" + index + " doesn't exist!");
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
    public Lecture[] getAll() {

        System.out.println("Now we have next lectures:");
        System.out.println();

        for (Lecture lecture : lectures) {

            if (lecture == null)
                continue;
            System.out.println(lecture);
        }
        return lectures;
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

