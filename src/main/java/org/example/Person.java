package org.example;

public class Person {
    public int id;
    public String name;
    public int age;
    public String occupation;

    public Person(int id, String name, int age, String occupation){
        this.id = id;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }

    public boolean equals(Person other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        return this.name.equals(other.name)
                && this.age == other.age
                && this.occupation.equals(other.occupation);
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Occupation: " + occupation;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }
}