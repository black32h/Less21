package org.example;

import java.io.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int grade;
    private transient String password; // Поле не серіалізується

    public Student(String name, int grade, String password) {
        this.name = name;
        this.grade = grade;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', grade=" + grade + ", password='" + password + "'}";
    }
}