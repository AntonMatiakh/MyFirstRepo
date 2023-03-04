package com.academy.repository;

import com.academy.models.Model;

public abstract class General <E extends Model> implements RepositoryInterface <Model>{

    private E[] storage;

    public abstract int size();

    public abstract boolean isEmpty();

    public abstract E get (int index);

    public abstract void add(Model element);

    public abstract void add(int index, Model element);

    public abstract void remove(int index);

    public abstract void getAll();

    public abstract void increaseStorageSize();

    public abstract void getById(int inputId);

    public abstract void deleteById(int inputId);

}


