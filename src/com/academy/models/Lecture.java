package com.academy.models;

public class Lecture extends Model {
    private static int counter;

    private int personId;

    private Person person;
    private Homework homework;
    private ExtraMaterial extraMaterial;

    public Lecture(String name, int id, int courseID) {
        super(name, id, courseID);
        counter++;
    }

    public Lecture(String name, int courseId) {
        super(name, ++counter, courseId);
    }

    public Lecture(String name, int courseId, Person person) {
        super(name, ++counter, courseId);
        this.person = person;
    }

    public Lecture(String name) {
        super(name, ++counter);
    }

    public Lecture() {
        super(++counter);
    }

    public static int getCounter() {
        return counter;
    }

    public Homework getHomework() {
        return homework;
    }

    public void setHomework(Homework homework) {
        this.homework = homework;
    }

    public ExtraMaterial getExtraMaterial() {
        return extraMaterial;
    }

    public void setExtraMaterial(ExtraMaterial extraMaterial) {
        this.extraMaterial = extraMaterial;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "name='" + super.getName() + '\'' +
                ", id=" + super.getId() +
                ", courseID=" + super.getCourseId() +
                ", person=" + person +
                '}';
    }
}
