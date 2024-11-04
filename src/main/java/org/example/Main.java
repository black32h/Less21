package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        // Створення об'єкта Student
        Student student = new Student("Inam", 10, "secretPassword");

        // Створення об'єкта Course
        Course course = new Course("Mathematics", student);

        // Серіалізація об'єкта Course
        try (FileOutputStream fileOut = new FileOutputStream("course.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            out.writeObject(course);
            System.out.println("Об'єкт Course серіалізовано у файл course.ser");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Десеріалізація об'єкта Course
        try (FileInputStream fileIn = new FileInputStream("course.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            Course deserializedCourse = (Course) in.readObject();
            System.out.println("Десеріалізований об'єкт Course: " + deserializedCourse);

            // Перевірка, що поле password студента не збережено
            System.out.println("Пароль студента після десеріалізації: " + deserializedCourse.getStudent().getPassword()); // має бути null

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
