package org.example;

public class Person {
    private int id;
    private String name;
    private int age;
    private String occupation;

    public Person(int id, String name, int age, String occupation) {
        this.id = id;
        setName(name);
        this.age = age;
        this.occupation = occupation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException {
        String[] parts = name.split(" ");
        if (parts.length != 2)
            throw new IllegalArgumentException("El nombre debe estar formateado como 'nombreApellido'");
        this.name = parts[0].substring(0, 1).toUpperCase() + parts[0].substring(1) + parts[1].substring(0, 1).toUpperCase() + parts[1].substring(1);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Person) {
            Person otherPerson = (Person) o;
            return name.equals(otherPerson.name) && age == otherPerson.age && occupation.equals(otherPerson.occupation);
        }
        return false;
    }
}