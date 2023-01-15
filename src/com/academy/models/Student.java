package com.academy.models;

public class Student extends Model {

    private static int counter;

    public Student(String name, int id, int courseId) {
        super(name, id, courseId);
        counter++;
    }

    public Student(String name, int courseId) {
        super(name, ++counter, courseId);
    }

    public Student(String name) {
        super(name, ++counter);
    }

    public Student() {
        super(++counter);
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + super.getName() + '\'' +
                ", id=" + super.getId() +
                ", courseId=" + super.getCourseId() +
                '}';
    }

}
