package com.academy.models;

public class Homework extends Model {

    private static int counter;

    private int lectureId;

    private String task;

    public Homework(String name, int id, int courseId) {
        super(name, id, courseId);
        counter++;
    }

    public Homework(String name, int id, int courseId, int lectureId, String task) {
        super(name, id, courseId);
        this.lectureId = lectureId;
        this.task = task;
        counter++;
    }

    public Homework(String name, int courseId) {
        super(name, ++counter, courseId);
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
                ", lectureId=" + lectureId +
                ", task=" + task +
                '}';
    }

}
