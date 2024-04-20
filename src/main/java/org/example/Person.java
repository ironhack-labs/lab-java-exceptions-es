package org.example;

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.Objects;

public class Person {
    private int id;
    private String nombreApellido;
    private int age;
    private String occupation;

    public Person(int id, String nombreApellido, int age, String occupation) {
        this.id = id;
        this.nombreApellido = nombreApellido;
        this.age = age;
        this.occupation = occupation;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("La edad debe de ser mayor que 0");
        }
        this.age = age;
        System.out.println("La edad de "+ nombreApellido + " ha sido modificada a "+age+" años");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
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

    public String getNombreApellido() {
        return nombreApellido;
    }

    public boolean equals(Person person){
        if (this.nombreApellido == person.nombreApellido && this.age == person.age && this.occupation == person.occupation){
            System.out.println("La persona "+this.nombreApellido+" y la persona "+person.getNombreApellido()+" son iguales");
            return true;
        } else {
            System.out.println("La persona "+this.nombreApellido+" y la persona "+person.getNombreApellido()+" son distintas");
            return false;
        }

    }

    public Person clonePerson(Person person){
        Person newPerson = new Person(person.getId()+1, person.getNombreApellido(), person.getAge(), person.getOccupation());
        System.out.println("Se ha clonado exitosamente a la persona "+ newPerson.getNombreApellido());
        return newPerson;

    }

    public void writePersonToFile(Person person, String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(person.toString());
            writer.close();
        }

    }

    @Override
    public String toString() {
        return "Person{" +
                "Id= " + id +
                " || Name= " + nombreApellido +
                " || Age= " + age +
                " || Occupation= " + occupation +
                "}";

    }
}
