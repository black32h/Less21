package org.example;

import java.io.*;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L; // Незмінний ідентифікатор

    private String name;
    private int grade;
    private String email; // НОВЕ ПОЛЕ, додане після серіалізації об'єкта

    public Student(String name, int grade ) {
        this.name = name;
        this.grade = grade;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', grade=" + grade + ", email='" + email + "'}";
    }

    public static void main(String[] args) {
        // Десеріалізація об'єкта
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ser"))) {
            Student deserializedStudent = (Student) ois.readObject();
            System.out.println("Десеріалізований об'єкт: " + deserializedStudent);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
