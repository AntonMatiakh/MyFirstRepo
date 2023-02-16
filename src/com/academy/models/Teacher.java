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

//    public Teacher(String name) {
//        super(name, ++counter);
//    }
//
//    public Teacher(String firstname, String lastname, String phone, String email, Role role) {
//        super(firstname, lastname, phone, email, ++counter, role);
//
//
//    }

//    public Teacher() {}

    public static int getCounter() {
        return counter;
    }

//    @Override
//    public String toString() {
//        return "Teacher{" +
//                "firstname='" + super.getFirstName() + '\'' +
//                ", lastname='" + super.getLastName() +
//                "', phone='" + super.getPhone() +
//                "', email='" + super.getEmail() +
//                "', id=" + super.getId() +
//                //", courseId=" + super.getCourseId() +
//                ", role=" + super.getRole() +
//                '}';
//    }



}
