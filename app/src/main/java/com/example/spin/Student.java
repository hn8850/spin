package com.example.spin;

public class Student {
    private String name;
    private String surname;
    private String number;
    private String date;

    public Student(String name, String surname, String number, String date) {
        this.name = name;
        this.surname = surname;
        this.date = date;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDate() {
        return date;
    }

    public String getNumber() {
        return number;
    }


}
