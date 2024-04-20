package org.example;

public class Main {
    public static void main(String[] args) {
        PersonsList personsList = new PersonsList();

        Person person1 = new Person(1, "JohnDoe", 30, "Engineer");
        personsList.addPerson(person1);

        try {
            Person foundPerson = personsList.findByName("John Doe");
            System.out.println("Found Person: " + foundPerson);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        Person clonedPerson = personsList.clonePerson(person1);
        System.out.println("Cloned Person: " + clonedPerson);


        personsList.writeToFile(person1, "person_info.txt");
    }
}
