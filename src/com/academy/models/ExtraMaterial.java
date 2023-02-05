package com.academy.models;

public class ExtraMaterial extends Model {

    private static int counter;

    public ExtraMaterial(String name, int id, int courseId) {
        super(name, id, courseId);
        counter++;
    }

    public ExtraMaterial(String name, int courseId) {
        super(name, ++counter, courseId);
    }

    public ExtraMaterial(String name) {
        super(name, ++counter);
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return "ExtraMaterial{" +
                "name='" + super.getName() + '\'' +
                ", id=" + super.getId() +
                ", courseId=" + super.getCourseId() +
                '}';
    }

}
