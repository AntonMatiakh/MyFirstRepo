package com.academy.models;

public class Model {

    private String name;
    private int id;
    private int courseId;
//    private String firstname;
//    private String lastname;
//    private String phone;
//    private String email;
//    private Role role;


//    public Model(String firstname, String lastname, String phone, String email, int id, Role role) {
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.phone = phone;
//        this.email = email;
//        this.id = id;
//        this.role = role;
//    }

    protected Model(String name, int id, int courseId) {
        this.name = name;
        this.id = id;
        this.courseId = courseId;
    }

//    protected Model(String name, int id, int courseId, Person person) {
//        this.name = name;
//        this.id = id;
//        this.courseId = courseId;
//    }

    protected Model(String name, int id) {
        this.name = name;
        this.id = id;
    }

    protected Model() {
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

//    public String getFirstname() {
//        return firstname;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public Role getRole() {
//        return role;
//    }

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
