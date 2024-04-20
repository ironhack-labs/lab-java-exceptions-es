package org.example;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        PersonsList personsList = new PersonsList();

        try {
            Person person1 = new Person(1, "Juan Perez",45 , "Teacher");
            System.out.println("Error: El método setAge no lanza una excepción para una edad negativa.");
        } catch (IllegalArgumentException e) {
            System.out.println("Método setAge: OK (lanza una excepción para una edad negativa)");
        }

        Person person2 = new Person(2, "Adrian Pintor", 24, "Engineer");
        Person person3 = new Person(3, "Maria Ramos", 22, "Teacher");
        personsList.add(person2);
        personsList.add(person3);

        String name = "Adrian Pintor";
        try {
            Person foundPerson = personsList.findByName(name);
            if (foundPerson != null && foundPerson.getName().equals(name)) {
                System.out.println("Método findByName: OK (encontró correctamente la persona con el nombre " + name + ")");
            } else {
                System.out.println("Error: El método findByName no devolvió la persona esperada.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: El método findByName lanzó una excepción para un nombre correctamente formateado.");
        }

        String invalidName = "Pedro Rodriguez";
        try {
            personsList.findByName(invalidName);
            System.out.println("Error: El método findByName no lanzó una excepción para un nombre no correctamente formateado.");
        } catch (IllegalArgumentException e) {
            System.out.println("Método findByName: OK (lanzó una excepción para un nombre no correctamente formateado)");
        }

        // Prueba del método clone
        Person originalPerson = new Person(4, "Charlie Brown", 40, "Artist");
        Person clonedPerson = personsList.clone(originalPerson);
        if (clonedPerson != originalPerson && clonedPerson.equals(originalPerson)) {
            System.out.println("Método clone: OK (creó correctamente una nueva persona clonada)");
        } else {
            System.out.println("Error: El método clone no creó correctamente una nueva persona clonada.");
        }
        personsList.writeFile(clonedPerson);
    }
}