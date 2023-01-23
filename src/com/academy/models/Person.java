package com.academy.models;

public class Person extends Model {

    private static int counter;
    private Role role;

    public Person(String name, int courseId, Role role) {
        super(name, ++counter, courseId);
        this.role = role;
    }

    public Person() {
        super();
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public int getCourseId() {
        return super.getCourseId();
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + super.getName() + '\'' +
                ", id=" + super.getId() +
                ", courseId=" + super.getCourseId() +
                ", role=" + role +
                '}';
    }
}
