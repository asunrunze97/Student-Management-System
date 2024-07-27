package com.StuentManagerSys;

public class Student {
    // student id is set to -1 by default
    // while means does not exist
    private int id = -1;
    private String name = null;
    private String email = null;
    // TODO: Implement constructors, getters, and setters

    // two constructors (with id or without id) for easy initialization
    public Student(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // make all getters and setters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", email=" + email + "]";
    }
}
