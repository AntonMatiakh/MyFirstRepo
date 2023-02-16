package com.academy.models;

public class Course extends Model {

    private static int counter;

    private Teacher teacher;
    private Student student;
    private Lecture lecture;

    public Course(String name, int id) {
        super(name, id);
        counter++;
    }

//    public Course(String name) {
//        super(name, ++counter);
//    }

    public static int getCounter() {
        return counter;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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
