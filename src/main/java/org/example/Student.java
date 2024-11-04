package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    // Геттери для доступу до полів
    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    // Метод для зручного виведення об'єкта
    @Override
    public String toString() {
        return "Student{name='" + name + "', grade=" + grade + "}";
    }
}