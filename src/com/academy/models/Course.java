package com.academy.models;

public class Course extends Model {

    private static int counter;
    private Lecture lecture;

    public Course(String name, int id) {
        super(name, id);
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + super.getName() + '\'' +
                ", id=" + super.getId() +
                '}';
    }

}
