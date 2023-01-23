package com.academy.repository;

import com.academy.models.Model;

import java.util.Arrays;

public class Repository {
    private static final int STANDARD_INITIAL_SIZE = 5;
    protected static int getSTANDARD_INITIAL_SIZE() {
        return STANDARD_INITIAL_SIZE;
    }
    protected Model[] modelsArray = new Model[getSTANDARD_INITIAL_SIZE()];

    public void add(Model model) {
        for (int i = 0; i < modelsArray.length; i++) {
            if (modelsArray[i] == null) {
                modelsArray[i] = model;
                break;
            } else if (i == modelsArray.length - 1) {
                increaseArraySize();
            }
        }
    }

    protected Model[] getAll() {
        for (Model m : modelsArray) {
            if (m == null) continue;
            System.out.println(m);
        }
        System.out.println("Our array looks like:");
        return modelsArray;
    }

    protected void increaseArraySize() {
        int newSize = (modelsArray.length * 3) / 2 + 1;
        Model[] increasedSizeArray = new Model[newSize];
        System.arraycopy(modelsArray, 0, increasedSizeArray, 0, modelsArray.length);
        modelsArray = increasedSizeArray;
    }

    protected void getById(int Id) {
        Model model = modelsArray[Id];
        System.out.println(model);
    }

    protected void deleteById(int Id) {
        Model model = modelsArray[Id];
        System.out.println(model);
    }

    @Override
    public String toString() {
        return "Repository{" +
                "modelArray=" + Arrays.toString(modelsArray) +
                '}';
    }

}
