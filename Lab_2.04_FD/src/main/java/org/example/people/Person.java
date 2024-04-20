package org.example.people;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

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
            throw new IllegalArgumentException("Enter a valid age");
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
        return "ID: " + id +
                ", name: '" + name + '\'' +
                ", age: " + age +
                ", occupation: '" + occupation + '\'' +
                '.';
    }

    @Test
    public void testSetAgeValid(){
        Person person = new Person(1,"Blanca Gomez", 31, "Step up");
        person.setAge(32);
        assertEquals(32, person.getAge());
    }
    @Test
    public void testSetAgeInvalid(){
        Person person = new Person(1, "Blanca Gomez", 31, "Step up");
        assertThrows(IllegalArgumentException.class , () -> person.setAge(-5)); }

    @Test
    public void testEqualsSameProperties(){
        Person person = new Person(2,"Boris Riera", 33,"Programmer");
        Person person1 = new Person(3, "Boris Riera", 33, "Programmer");
        assertTrue(person.equals(person1));
    }
    @Test
    public void testEqualsDifferentProperties(){
        Person person = new Person(2,"Boris Riera", 33,"Programmer");
        Person person1 = new Person(4, "Luna Hidalgo", 28, "DJ");
        assertFalse(person.equals(person1));
    }
}
