import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear instancias de Person
        Person person1 = new Person(1, "Angel Fernandez", 30, "Ingeniero");
        Person person2 = new Person(2, "Lisa Medina", 25, "Doctor");

        // Crear una lista de Persons
        PersonsList personsList = new PersonsList();
        personsList.addPerson(person1);
        personsList.addPerson(person2);

        // Pruebas del método setAge
        try {
            person1.setAge(-5); // Esto debería lanzar una excepción
        } catch (IllegalArgumentException e) {
            System.out.println("Error en setAge: " + e.getMessage());
        }

        // Pruebas del método findByName
        try {
            Person foundPerson = personsList.findByName("John Doe"); // Esto debería lanzar una excepción
            System.out.println("Found Person: " + foundPerson);
        } catch (IllegalArgumentException e) {
            System.out.println("Error en findByName: " + e.getMessage());
        }

        // Pruebas del método clone
        Person clonedPerson = personsList.clonePerson(person1);
        System.out.println("Cloned Person: " + clonedPerson);

        // Pruebas del método writeToFile
        personsList.writeToFile(person1, "person1.txt");
    }
}

class Person {
    private static int nextId = 1;

    private int id;
    private String name;
    private int age;
    private String occupation;

    public Person(int id, String name, int age, String occupation) {
        this.id = id;
        this.name = name;
        if (age < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
        this.age = age;
        this.occupation = occupation;
    }

    public void setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age &&
                id == person.id &&
                name.equals(person.name) &&
                occupation.equals(person.occupation);
    }

    public String toString() {
        return "ID: " + id + ", Nombre: " + name + ", Edad: " + age + ", Ocupación: " + occupation;
    }

    // Métodos getters necesarios
    public static int getNextId() {
        return nextId++;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }
}

class PersonsList {
    private List<Person> persons;

    public PersonsList() {
        this.persons = new ArrayList<>();
    }

    public void addPerson(Person person) {
        this.persons.add(person);
    }

    public Person findByName(String name) throws IllegalArgumentException {
        validateNameFormat(name);
        String[] parts = name.split(" ");
        String firstName = parts[0];
        String lastName = parts[1];

        for (Person person : persons) {
            if (person.getName().equalsIgnoreCase(firstName + " " + lastName)) {
                return person;
            }
        }
        return null;
    }

    public Person clonePerson(Person originalPerson) {
        int newId = Person.getNextId();
        return new Person(newId, originalPerson.getName(), originalPerson.getAge(), originalPerson.getOccupation());
    }

    public void writeToFile(Person person, String filename) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(filename);
            writer.write(person.toString());
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir: " + e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("No se pudo cerrar el FileWriter correctamente: " + e.getMessage());
                }
            }
        }
    }

    private void validateNameFormat(String name) throws IllegalArgumentException {
        String[] parts = name.split(" ");
        if (parts.length != 2) {
            throw new IllegalArgumentException("El nombre debe estar en el formato 'nombre apellido'");
        }
    }
}




