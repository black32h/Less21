package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main {
    public static void main(String[] args) {
        try (FileInputStream fileIn = new FileInputStream("student.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            // Десеріалізація об'єкта
            Student student = (Student) in.readObject();

            // Виведення об'єкта на екран
            System.out.println("Десеріалізований об'єкт: " + student);
            System.out.println("Ім'я студента: " + student.getName());
            System.out.println("Оцінка  студента: " + student.getGrade());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}