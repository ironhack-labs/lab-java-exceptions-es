import Clases.Person;
import Clases.PersonsList;

public class Main {
    // Main method for testing
    public static void main(String[] args) {
        PersonsList personsList = new PersonsList();
        Person person1 = new Person(1, "John Doe", 30, "Software Developer");
        Person person2 = new Person(2, "Jane Doe", 25, "Data Scientist");

        personsList.addPerson(person1);
        personsList.addPerson(person2);

        // Test setAge method for negative age
        try {
            person1.setAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Test Passed: " + e.getMessage());
        }

        // Test findByName with correctly formatted name
        try {
            Person foundPerson = personsList.findByName("John Doe");
            if (foundPerson != null) {
                System.out.println("Test Passed: Found " + foundPerson);
            } else {
                System.out.println("Test Failed: Person not found");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Test Failed: " + e.getMessage());
        }

        // Test findByName with incorrectly formatted name
        try {
            personsList.findByName("JohnDoe");
            System.out.println("Test Failed: No exception thrown for incorrect format");
        } catch (IllegalArgumentException e) {
            System.out.println("Test Passed: " + e.getMessage());
        }

        // Test clone method
        System.out.println("\nTesting clone method:");
        Person clonedPerson = personsList.clone(person1);
        if (clonedPerson != null && clonedPerson.getId() != person1.getId() && clonedPerson.equals(person1)) {
            System.out.println("Test Passed: Cloned person " + clonedPerson);
        } else {
            System.out.println("Test Failed: Cloned person does not match original");
        }

        // Write person to file
        System.out.println("\nTesting writePersonToFile method:");
        personsList.writePersonToFile(person1, "person1.txt");
        System.out.println("Check the file 'person1.txt' to verify the output.");
    }
}