import java.util.ArrayList;
import java.util.List;

public class PersonsList {
    private List<Person> persons;

    public PersonsList() {
        this.persons = new ArrayList<>();
    }

    public Person findByName(String name) {
        String[] parts = name.split(" ");
        if (parts.length != 2) {
            throw new IllegalArgumentException("El nombre debe tener el formato 'nombreApellido'");
        }
        String firstName = parts[0];
        String lastName = parts[1];

        for (Person person : persons) {
            String[] personNameParts = person.getName().split(" ");
            if (personNameParts[0].equals(firstName) && personNameParts[1].equals(lastName)) {
                return person;
            }
        }

        throw new IllegalArgumentException("No se encontró ninguna persona con el nombre proporcionado");
    }

    public Person clone(Person originalPerson) {
        return new Person(
                generateNewId(),
                originalPerson.getName(),
                originalPerson.getAge(),
                originalPerson.getOccupation()
        );
    }

    private int generateNewId() {
        return (int) (Math.random() * 1000);
    }

    public void writeToFile(Person person) {

    }
}
