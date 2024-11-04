package org.example;

import org.example.Student;

import java.io.*;
public class Main{

public static void main( String[] args) {
    // Створюємо об'єкти Student
    Student student1 = new Student("Alice", 90);
    Student student2 = new Student("Bob", 80);

    // Серіалізуємо об'єкт student1 у файл
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
        oos.writeObject(student1);
        System.out.println("Об'єкт Student серіалізовано: " + student1);
    } catch (IOException e) {
        e.printStackTrace();
    }

    // Десеріалізуємо об'єкт student1 з файлу
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ser"))) {
        Student deserializedStudent = (Student) ois.readObject();
        System.out.println("Десеріалізований об'єкт Student: " + deserializedStudent);
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }

    // Порівнюємо student1 і student2
    int comparisonResult = student1.compareTo(student2);
    if (comparisonResult > 0) {
        System.out.println(student1.getName() + " має кращий результат, ніж " + student2.getName());
    } else if (comparisonResult < 0) {
        System.out.println(student2.getName() + " має кращий результат, ніж " + student1.getName());
    } else {
        System.out.println(student1.getName() + " і " + student2.getName() + " мають однаковий результат");
    }
}
}