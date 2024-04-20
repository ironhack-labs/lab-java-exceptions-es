import java.util.ArrayList;
import java.util.List;

class Person {
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

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("La edad no puede ser menor que 0.");
        }
        this.age = age;
    }

    public boolean equals(Person otherPerson) {
        return this.name.equals(otherPerson.name) &&
                this.age == otherPerson.age &&
                this.occupation.equals(otherPerson.occupation);
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

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Occupation: " + occupation;
    }
}

class PersonsList {
    private List<Person> persons;

    public PersonsList() {
        this.persons = new ArrayList<>();
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public Person findByName(String name) {
        String[] nameParts = name.split(" ");
        if (nameParts.length != 2) {
            throw new IllegalArgumentException("El nombre debe tener el formato 'nombre apellido'.");
        }
        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public Person clonePerson(Person originalPerson) {
        return new Person(
                generateNewId(),
                originalPerson.getName(),
                originalPerson.getAge(),
                originalPerson.getOccupation()
        );
    }

    public void writeToFile(Person person) {
        // Implementar la escritura en archivo aquí
    }

    private int generateNewId() {
        // Implementar la generación de nuevo ID aquí
        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        // Casos de prueba
        PersonsList personsList = new PersonsList();
        Person person1 = new Person(1, "Juan Perez", 30, "Ingeniero");
        Person person2 = new Person(2, "Maria Garcia", 25, "Doctora");
        personsList.addPerson(person1);
        personsList.addPerson(person2);

        // Prueba de setAge
        try {
            person1.setAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Prueba de findByName
        Person foundPerson = personsList.findByName("Juan Perez");
        if (foundPerson != null) {
            System.out.println("Persona encontrada: " + foundPerson);
        } else {
            System.out.println("Persona no encontrada.");
        }

        // Prueba de clone
        Person clonedPerson = personsList.clonePerson(person1);
        System.out.println("Persona clonada: " + clonedPerson);
    }
}
