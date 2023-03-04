package com.academy.repository;

import com.academy.models.Model;

public interface RepositoryInterface < E extends Model > {

    int size();

    boolean isEmpty();

    E get (int index);

    void add (E element);

    void add (int index, E element);

    void remove (int index);

}
