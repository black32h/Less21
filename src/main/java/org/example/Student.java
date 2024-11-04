package org.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int grade;
    private transient String password; // Не серіалізується
    private transient Address address; // Не серіалізується автоматично, збережемо вручну

    public Student(String name, int grade, String password, Address address) {
        this.name = name;
        this.grade = grade;
        this.password = password;
        this.address = address;
    }

    // Кастомна серіалізація
    private void writeObject( ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject(); // Серіалізуємо стандартні поля
        oos.writeObject(password); // Зберігаємо пароль

        // Зберігаємо поля адреси окремо
        oos.writeObject(address.getStreet());
        oos.writeObject(address.getCity());
        oos.writeObject(address.getZipCode());
    }

    // Кастомна десеріалізація
    private void readObject( ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject(); // Десеріалізуємо стандартні поля
        password = (String) ois.readObject(); // Відновлюємо пароль

        // Відновлюємо поля адреси
        String street = (String) ois.readObject();
        String city = (String) ois.readObject();
        String zipCode = (String) ois.readObject();
        address = new Address(street, city, zipCode);
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', grade=" + grade + ", password='" + password + "', address=" + address + "}";
    }
}