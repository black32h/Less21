package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Joe", 23);

        try (FileOutputStream fileOut = new FileOutputStream("student.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(student);
            System.out.println("Об'єкт Student було серіалізовано у файл student.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}