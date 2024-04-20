package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        PersonsList personsList = new PersonsList();
        Person person1 = new Person(1, "Jose Perez", 30, "Zapatero");
        Person person2 = new Person(2, "Luis Fernandez", 55, "Conductor");
        Person person3 = new Person(3, "Ricardo Gonzalez", 41, "Chef");
        personsList.addPersons(person1);
        personsList.addPersons(person2);
        personsList.addPersons(person3);
        Person cloned1 = personsList.clone(person1);
        Person cloned3 = personsList.clone(person3);

        System.out.println(cloned1.getId());
        System.out.println(cloned3.getId());
    }
}
