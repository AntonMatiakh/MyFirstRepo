package com.academy.repository;

import com.academy.models.Course;
import com.academy.models.Lecture;
import com.academy.services.LectureService;

import java.util.Arrays;

public class LectureRepository {

    private static final int STANDARD_INITIAL_SIZE = 5;

    private static Lecture[] lectures;

    public LectureRepository() {
        lectures = new Lecture[STANDARD_INITIAL_SIZE];
    }

    public LectureRepository(int inputSize) {
        if (inputSize < 1) {
            System.out.println("WRONG ARGUMENT, CREATING STANDARD SIZED ARRAY");
            lectures = new Lecture[STANDARD_INITIAL_SIZE];
        } else {
            lectures = new Lecture[inputSize];
        }
    }

    public static void addToArray (Lecture lecture) {
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

    public static void addToArray2 (Lecture lecture) {
        for (int i = 0; i < lectures.length; i++) {
            if (lectures[i] == null) {
                lectures[i] = lecture;
                break;
            } else if (lectures[i] != null && i == lectures.length - 1) {
                Lecture[] increasedSizeArray = new Lecture[(STANDARD_INITIAL_SIZE * 3) / 2 + 1];
                lectures = increasedSizeArray;
                System.arraycopy(lectures, 0, increasedSizeArray, 0, lectures.length);
//                int indexToAdd = lectures.length;
//                increaseArraySize();
//                lectures[indexToAdd] = lecture;
            }
        }
        Lecture[] newArr = lectures;
    }

//    public static void addLecture (Lecture lecture) {
//        boolean lastElementIsZero;
//        do {
//            if (lectures[STANDARD_INITIAL_SIZE - 1] == null) {
//                System.out.println("Array is filled");
//                lastElementIsZero = true;
//            } else {
//                lastElementIsZero = false;
//                System.out.println("Array is not filled");
//            }
//        } while (!lastElementIsZero);
//    }

    public static void increaseArraySize () {
        int newSize = (STANDARD_INITIAL_SIZE * 3) / 2 + 1;
        Lecture[] increasedSizeArray = new Lecture[newSize];
        System.arraycopy(lectures, 0, increasedSizeArray, 0, lectures.length);
        lectures = increasedSizeArray;
    }

    public static String showCreatedLectures(){
        int j=0;
        int k=0;
        for (int i = 0; i < lectures.length; i++){
            if (lectures[i] == null)continue;
            j++;
        }
        String[] stringArray = new String[j];
        for (int i = 0; i < lectures.length; i++){
            if (lectures[i] == null) continue;
            stringArray[k] = lectures[i].toString();
            k++;
        }
        return "Created lectures: " + Arrays.toString(stringArray);
    }


//    public void showArray() {
//        for (int i = 0; i < lectures.length; i++) {
//            System.out.println(lectures[i] + " " + Lecture.getLectureCounter());
//            System.out.println(Arrays.toString(lectures));
//        }
//    }


    public int getSTANDARD_INIT_AMOUNT() {
        return STANDARD_INITIAL_SIZE;
    }

    public Lecture[] getLectures() {
        return lectures;
    }

    @Override
    public String toString() {
        return "LectureRepository{" +
                "lectures=" + Arrays.toString(lectures) +
                '}';
    }
}
