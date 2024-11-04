package org.example;

import java.io.*;

public class Student implements Serializable, Comparable<Student> {
    private static final long serialVersionUID = 1L; // Унікальний ідентифікатор серіалізації

    private String name;
    private final int grade;

    public Student ( String name, int grade ) {
        this.name = name;
        this.grade = grade;
    }

    // Геттери для полів
    public String getName () {
        return name;
    }

    public int getGrade () {
        return grade;
    }

    // Метод порівняння за полем grade
    @Override
    public int compareTo ( Student other ) {
        return Integer.compare(this.grade, other.grade); // Порівнює за grade
    }

    @Override
    public String toString () {
        return "Student{name='" + name + "', grade=" + grade + "}";
    }
}

