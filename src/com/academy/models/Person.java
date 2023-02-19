package com.academy.models;

public class Person extends Model {

    private static int counter;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Role role;

    public Person(String firstname, String lastname, String phone, String email, Role role) {

        super(++counter);
        this.firstName = firstname;
        this.lastName = lastname;
        this.phone = phone;
        this.email = email;
        this.role = role;

    }

    public Person() {
        super();
        counter++;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public static int getCounter() {
        return counter;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
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

    @Override
    public String toString() {
        return "Person{" +
                " first name = '" + firstName + '\'' +
                ", last name = '" + lastName +
                "', phone number = '" + phone +
                "', email address = '" + email +
                "', id = " + super.getId() +
                ", role = " + role +
                '}';
    }
}
