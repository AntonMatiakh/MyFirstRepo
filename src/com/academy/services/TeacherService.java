package com.academy.services;

import com.academy.models.Person;
import com.academy.models.Role;

public class TeacherService {

    public Person createTeacher(String name, int courseId, Role role) {
        Person teacher = new Person(name, courseId, role);
        return teacher;
    }

}
