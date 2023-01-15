package com.academy.models;

public class Homework extends Model {

    public static int counter;

    public Homework(String name, int id, int courseId) {
        super(name, id, courseId);
        counter++;
    }

    public Homework(String name, int courseId) {
        super(name, ++counter, courseId);
    }

    public Homework(String name) {
        super(name, ++counter);
    }

    public Homework() {
        super(++counter);
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return "Homework{" +
                "name='" + super.getName() + '\'' +
                ", id=" + super.getId() +
                ", courseId=" + super.getCourseId() +
                '}';
    }

}
