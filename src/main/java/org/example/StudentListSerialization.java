package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentListSerialization {
    public static void main(String[] args) {
        // Створюємо список об'єктів Student
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 90, "pass123"));
        students.add(new Student("Bob", 85, "bobpass"));
        students.add(new Student("Charlie", 92, "charliepass"));

        // Серіалізуємо список у файл
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.ser"))) {
            oos.writeObject(students);
            System.out.println("Список студентів успішно серіалізовано у файл students.ser.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Десеріалізуємо список із файлу
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.ser"))) {
            List<Student> deserializedStudents = (List<Student>) ois.readObject();
            System.out.println("Десеріалізований список студентів:");
            deserializedStudents.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}