package com.academy.repository;

import com.academy.models.Model;

import java.util.Arrays;

public class Repository {
    private static final int STANDARD_INITIAL_SIZE = 5;
    protected static int getSTANDARD_INITIAL_SIZE() { return STANDARD_INITIAL_SIZE; }
    protected Model[] modelsArray = new Model[getSTANDARD_INITIAL_SIZE()];
    public Model[] getModelsArray() {
        return modelsArray;
    }

    protected void add(Model model) {
        for (int i = 0; i < modelsArray.length; i++) {

            if (i == modelsArray.length - 1) {
                increaseArraySize();
            }
            if (modelsArray[i] == null) {
                modelsArray[i] = model;
                break;
            }
        }
    }

    protected void increaseArraySize() {
        int newSize = (modelsArray.length * 3) / 2 + 1;
        Model[] increasedSizeArray = new Model[newSize];
        System.arraycopy(modelsArray, 0, increasedSizeArray, 0, modelsArray.length);
        modelsArray = increasedSizeArray;
    }

    protected Model[] showAll() {
        for (Model m : modelsArray) {
            if (m == null) continue;
            System.out.println(m);
        }
        System.out.println("And our whole array:");
        return modelsArray;
    }

    protected void getById(int inputId) {

        for (Model model : modelsArray) {

            if (model == null)
                continue;
            if (model.getId() == inputId) {
                System.out.println("We have just found: " + model);
                break;
            }
        }
    }

    protected void deleteById(int inputId) {

        Model[] result = new Model[modelsArray.length - 1];
        int index = inputId - 1;

        for (Model model : modelsArray) {
            if (model == null)
                continue;
            if (model.getId() == inputId)
                System.out.println("You have just deleted:\n" + model);
        }

        System.arraycopy(modelsArray, 0, result, 0, index);
        System.arraycopy(modelsArray, index + 1, result, index, modelsArray.length - index - 1);
        modelsArray = result;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "modelArray=" + Arrays.toString(modelsArray) +
                '}';
    }

}
