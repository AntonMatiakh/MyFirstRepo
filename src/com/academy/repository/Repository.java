package com.academy.repository;

import com.academy.models.Lecture;
import com.academy.models.Model;

import java.util.Arrays;

public class Repository {

    private static final int STANDARD_INITIAL_SIZE = 5;

    protected Model[] modelArray = new Model[getSTANDARD_INITIAL_SIZE()];

    protected static int getSTANDARD_INITIAL_SIZE() {
        return STANDARD_INITIAL_SIZE;
    }

    protected Model[] getAll() {
        return modelArray;
    }

    protected String showCreatedModels() {

        int j = 0;
        int k = 0;
        for (int i = 0; i < modelArray.length; i++) {
            if (modelArray[i] == null) continue;
            j++;
        }
        String[] stringArray = new String[j];
        for (int i = 0; i < modelArray.length; i++) {
            if (modelArray[i] == null) continue;
            stringArray[k] = modelArray[i].toString();
            k++;
        }
        return "Created models: " + Arrays.toString(stringArray);

    }

    protected void add(Model model) {

        int blankSell = 0;
        for (int i = 0; i < modelArray.length; i++) {
            if (modelArray[i] == null) {
                modelArray[i] = model;
                blankSell++;
                break;
            }
        }
        if (blankSell == 0) {
            int addMark = modelArray.length;
            increaseArraySize();
            modelArray[addMark] = model;
        }

    }

    protected void increaseArraySize() {

        int newSize = (modelArray.length * 3) / 2 + 1;
        Model[] increasedSizeArray = new Model[newSize];
        System.arraycopy(modelArray, 0, increasedSizeArray, 0, modelArray.length);
        modelArray = increasedSizeArray;

    }

    protected void getById(int lectureId) {

        if (lectureId <= 0) {
            System.out.println("WRONG ARGUMENT!!! Lecture id must be > 0 !!!");
        } else if (lectureId > Lecture.getCounter()) {
            System.out.println("Sorry, lecture with id=" + lectureId + " doesn't exist!");
        } else {
            System.out.println("We have just found:");
            System.out.println(modelArray[lectureId - 1]);
        }

    }

    protected void deleteById(int lectureId) {

        if (lectureId <= 0) {
            System.out.println("WRONG ARGUMENT!!! Lecture id must be > 0 !!!");
        } else if (lectureId > Lecture.getCounter()) {
            System.out.println("Sorry, lecture with id=" + lectureId + " doesn't exist!");
        } else if (lectureId - 1 != modelArray.length) {
            modelArray[lectureId - 1] = null;
            System.out.println("Lecture with id=" + lectureId + " has just been deleted!");
            System.out.println("Now you can see remaining lectures:");
            System.out.println(showCreatedModels());
            System.out.println("And our modified array:");
            System.out.println(Arrays.toString(getAll()));
        }

    }

    @Override
    public String toString() {

        return "Repository{" +
                "modelArray=" + Arrays.toString(modelArray) +
                '}';

    }

}
