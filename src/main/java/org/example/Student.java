package org.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int grade;
    private transient String password; // поле не серіалізується

    public Student(String name, int grade, String password) {
        this.name = name;
        this.grade = grade;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', grade=" + grade + ", password='" + password + "'}";
    }

    // Метод для кастомної серіалізації
    private void writeObject(ObjectOutputStream out) throws IOException {
        // Записуємо ім'я та оцінку
        out.defaultWriteObject();
        // Записуємо зашифрований пароль (можна використовувати просту логіку, наприклад, замінюючи символи)
        if (password != null) {
            out.writeObject(encryptPassword(password));
        } else {
            out.writeObject(null); // якщо пароль null
        }
    }

    // Метод для кастомної десеріалізації
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        // Читаємо ім'я та оцінку
        in.defaultReadObject();
        // Читаємо зашифрований пароль
        String encryptedPassword = (String) in.readObject();
        // Дешифруємо пароль
        if (encryptedPassword != null) {
            this.password = decryptPassword(encryptedPassword);
        } else {
            this.password = null; // якщо пароль null
        }
    }

    // Метод для "шифрування" пароля (просто приклад)
    private String encryptPassword(String password) {
        // Просте шифрування, наприклад, реверс рядка
        return new StringBuilder(password).reverse().toString();
    }

    // Метод для "дешифрування" пароля
    private String decryptPassword(String encryptedPassword) {
        // Відновлення пароля, реверс рядка назад
        return new StringBuilder(encryptedPassword).reverse().toString();
    }
}
