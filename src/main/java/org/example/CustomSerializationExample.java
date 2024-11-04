package org.example;

import java.io.*;

public class CustomSerializationExample {
    public static void main(String[] args) {
        // Створюємо об'єкт Student з Address
        Address address = new Address("123 Main St", "Springfield", "12345");
        Student student = new Student("Alice", 90, "pass123", address);

        // Серіалізуємо об'єкт Student у файл
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
            oos.writeObject(student);
            System.out.println("Об'єкт Student серіалізовано.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Десеріалізуємо об'єкт Student з файлу
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ser"))) {
            Student deserializedStudent = (Student) ois.readObject();
            System.out.println("Десеріалізований об'єкт Student: " + deserializedStudent);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}