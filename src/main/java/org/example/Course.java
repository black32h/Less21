package org.example;

import org.example.Student;

import java.io.Serial;
import java.io.Serializable;

class Course implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final String courseName;
    private final Student student; // поле типу Student

    public Course(String courseName, Student student) {
        this.courseName = courseName;
        this.student = student;
    }

    public String getCourseName() {
        return courseName;
    }

    public Student getStudent() {
        return student;
    }

    @Override
    public String toString() {
        return "Course{courseName='" + courseName + "', student=" + student + "}";
    }
}
