package com.academy.models;

public class Model {

    private String name;
    private int id;
    private int courseId;

    public Model(String name, int id, int courseId) {
        this.name = name;
        this.id = id;
        this.courseId = courseId;
    }

    public Model(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Model (int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getCourseId() {
        return courseId;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Model{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", courseId=" + courseId +
                '}';
    }

}
