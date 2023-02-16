package com.academy.repository;

import java.util.Arrays;

public class General <E> extends Repository {

    private E[] storage;

    public General(){
        this.storage = (E[]) new Object[5];
    }

    public E[] getStorage() {
        return storage;
    }

    public int size() {
        return storage.length;
    }

    public E get (int index) {

        E elementToShow = null;

        for (E element : storage) {

            if (element == null)
                continue;

            elementToShow = storage[index];
            break;
        }
        return elementToShow;
    }


    public void add(E element) {
        for (int i = 0; i < storage.length; i++) {

            if (storage[i] == null) {
                storage[i] = element;
                break;
            }
            if (i == storage.length - 1) {
                increaseStorageSize();
            }
        }
    }

    protected void increaseStorageSize() {
        int newSize = (storage.length * 3) / 2 + 1;
        Object[] increasedSizeStorage = new Object[newSize];
        System.arraycopy(storage, 0, increasedSizeStorage, 0, storage.length);
        storage = (E[]) increasedSizeStorage;
    }

    protected boolean isEmpty() {

        boolean result = true;

        for (E element : storage) {

            if (element != null) {
                result = false;
                break;
            }
        }
        return result;
    }

    protected void remove(int index) {

        Object[] result = new Object[storage.length - 1];

        for (E element : storage) {
            if (element == null)
                continue;
            if (element == storage[index])
                System.out.println("You have just deleted:\n" + element);
        }

        System.arraycopy(storage, 0, result, 0, index);
        System.out.println("Result: " + Arrays.toString(result));
        System.arraycopy(storage, index + 1, result, index, storage.length - index - 1);
        storage = (E[]) result;
    }

    protected void add(int index, E elem) {

        Object[] result = new Object[storage.length + 1];

        System.arraycopy(storage, 0, result, 0, index);
        System.arraycopy(storage, index, result, index + 1, storage.length - index);
        result[index] = elem;
        storage = (E[]) result;
        getAll();
    }

    protected E[] getAll() {

        for (E element : storage) {

            if (element == null)
                continue;
            System.out.println(element);
        }
        return storage;
    }

    @Override
    public String toString() {
        return "General{" +
                "storage=" + Arrays.toString(storage) +
                '}';
    }

}


