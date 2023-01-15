package com.academy.models;

public class Teacher extends Model {

    private static int counter;

    public Teacher(String name, int id, int courseId) {
        super(name, id, courseId);
        counter++;
    }

    public Teacher(String name, int courseId) {
        super(name, ++counter, courseId);
    }

    public Teacher(String name) {
        super(name, ++counter);
    }

    public Teacher() {
        super(++counter);
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + super.getName() + '\'' +
                ", id=" + super.getId() +
                ", courseId=" + super.getCourseId() +
                '}';
    }

}
