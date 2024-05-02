import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonsList {
    private List<Person> persons;
    public PersonsList() {
        this.persons = new ArrayList<>();
    }

    public void addPerson(Person person) {
        persons.add(person);
    }
    public Person findByName(String name) {
        String[] parts = name.split(" ");
        if (parts.length != 2) {
            throw new IllegalArgumentException("El nombre debe tener formato 'nombre apellido'");
        }
        String firstName = parts[0];
        String lastName = parts[1];

        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        throw new IllegalArgumentException("No se encontró ninguna persona con el nombre proporcionado.");
    }


    private int generateNewId() {

        return persons.size() + 1;
    }


    public Person clone(Person originalPerson) {
        int newId = generateNewId();
        return new Person(newId, originalPerson.getName(), originalPerson.getAge(), originalPerson.getOccupation());
    }

    public void writeToFile(Person person) {
        try {
            FileWriter writer = new FileWriter("person_info.txt");
            writer.write(person.toString());
            writer.close();
            System.out.println("Información de la persona escrita en el archivo person_info.txt");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }











}

