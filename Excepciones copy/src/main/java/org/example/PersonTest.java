package org.example;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {
    private Person person;

    @Before
    public void setUp() {
        // Crear una persona para utilizar en las pruebas
        person = new Person(1, "JohnDoe", 30, "Engineer");
    }

    @Test
    public void testSetAgeValid() {
        // Prueba setAge con edad válida
        person.setAge(35);
        Assert.assertEquals(35, person.getAge());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetAgeInvalid() {
        // Prueba setAge con edad inválida (menor que 0)
        person.setAge(-5);  // Debería lanzar una excepción IllegalArgumentException
    }

    @Test
    public void testFindByNameValid() {
        PersonsList personsList = new PersonsList();
        personsList.addPerson(person);

        // Prueba findByName con nombre correctamente formateado
        Person foundPerson = personsList.findByName("John Doe");
        Assert.assertNotNull(foundPerson);
        Assert.assertEquals("JohnDoe", foundPerson.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByNameInvalidFormat() {
        PersonsList personsList = new PersonsList();
        personsList.addPerson(person);

        // Prueba findByName con nombre incorrectamente formateado
        personsList.findByName("JohnDoe");  // Debería lanzar una excepción IllegalArgumentException
    }

    @Test
    public void testClonePerson() {

        Person clonedPerson = new PersonsList().clonePerson(person);
        Assert.assertNotEquals(person.getId(), clonedPerson.getId());  // Deben tener ids diferentes
        Assert.assertEquals(person.getName(), clonedPerson.getName());
        Assert.assertEquals(person.getAge(), clonedPerson.getAge());
        Assert.assertEquals(person.getOccupation(), clonedPerson.getOccupation());
    }
}
