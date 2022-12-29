package com.academy.repository;

import com.academy.models.Lecture;

import java.util.Arrays;

public class LectureRepository {

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

    public void addToArray(Lecture lecture) {
        int blankSell = 0;
        for (int i = 0; i < lectures.length; i++) {
            if (lectures[i] == null) {
                lectures[i] = lecture;
                blankSell++;
                break;
            }
        }
        if (blankSell == 0) {
            int addMark = lectures.length;
            increaseArraySize();
            lectures[addMark] = lecture;
        }
    }

    public void increaseArraySize() {
        int newSize = (lectures.length * 3) / 2 + 1;
        Lecture[] increasedSizeArray = new Lecture[newSize];
        System.arraycopy(lectures, 0, increasedSizeArray, 0, lectures.length);
        lectures = increasedSizeArray;
    }

    public String showCreatedLectures() {
        int j = 0;
        int k = 0;
        for (int i = 0; i < lectures.length; i++) {
            if (lectures[i] == null) continue;
            j++;
        }
        String[] stringArray = new String[j];
        for (int i = 0; i < lectures.length; i++) {
            if (lectures[i] == null) continue;
            stringArray[k] = lectures[i].toString();
            k++;
        }
        return "Created lectures: " + Arrays.toString(stringArray);
    }

    @Override
    public String toString() {
        return "LectureRepository{" +
                "lectures=" + Arrays.toString(lectures) +
                '}';
    }

}
