package org.example.employee;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setAge(int age) {
        if (age < 0){
            throw new IllegalArgumentException("Ingrese una edad valida");
        }
        this.age = age;
    }
    public boolean equals(Person otherPerson){
        return this.name.equals(otherPerson.name) &&
                this.age == otherPerson.age &&
                this.occupation.equals(otherPerson.occupation);
    }

    @Override
    public String toString() {
        return "ID= " + id +
                ", name: '" + name + '\'' +
                ", age: " + age +
                ", occupation: '" + occupation + '\'' +
                '.';
    }
}
