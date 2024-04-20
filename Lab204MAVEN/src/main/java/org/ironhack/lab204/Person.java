package org.ironhack.lab204;

public class Person {
    private int id;
    private String name;
    private int age;
    private String occupation;

    public Person(int id, String name, int age, String occupation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    public Person(int id, Person name, Object age, Object occupation) {

    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }

    public boolean equals(Person other) {
        return this.name.equals(other.name) && this.age == other.age && this.occupation.equals(other.occupation);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                '}';
    }

    public Person getName() {
        return null;
    }

    public Object getAge() {
        return null;
    }

    public Object getOccupation() {
        return null;
    }
}