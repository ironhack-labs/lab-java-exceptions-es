package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;

public class PersonList {
    private List<Person> personList;

    public PersonList() {
        this.personList = new ArrayList<>();
    }

    public void addPerson(Person person) {
        personList.add(person);
    }

    public Person findByName(String name) throws IllegalArgumentException {
        for (Person person : personList) {

            if (!name.contains(" ")) {
                System.out.println("Datos incorrectos, el formato debe de ser Nombre Apellido");
                throw new IllegalArgumentException("Datos incorrectos, el formato debe de ser Nombre Apellido");
            }
            if (name.equals(person.getNombreApellido())) {
                System.out.println("El nombre " + name + " ha sido encontrado en nuestra base de datos");
                return person;
            }

        }
        System.out.println("No se ha encontrado ninguna persona con el nombre: " + name);
        throw new IllegalArgumentException("Person no encontrado");
    }

    public void showList() {
        for (Person persons : personList) {
            System.out.println("Id: " + persons.getId() + " || Nombre: " + persons.getNombreApellido() + " || Edad: " + persons.getAge() + " || Ocupacion: " + persons.getOccupation());
        }
    }
}






