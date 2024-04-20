package org.example;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;


public class App {
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);

        boolean continueInput = true;
        while (continueInput) {
            System.out.println("---Adding person details---");

            System.out.println("Enter details below");
            System.out.println("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Name: ");
            String name = scanner.nextLine();
            System.out.println("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Occupation: ");
            String occupation = scanner.nextLine();

            Person person = new Person(id, name, age, occupation);

            try (FileWriter fileWriter = new FileWriter("person_info.txt", true)) {
                fileWriter.write(person.toString());
                System.out.println("Person info has been written to 'person_info.txt'.");
            } catch (IOException exception) {
                System.out.println("The following error occurred: " + exception.getMessage());
            }
            System.out.println("Do you want to add another person? (Y/N): ");
            String input = scanner.nextLine();
            continueInput = input.equalsIgnoreCase("y");

        }



    scanner.close();
    }
}
