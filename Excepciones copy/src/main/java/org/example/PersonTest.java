package org.example;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {
    private Person person;

    @Before
    public void setUp() {
        person = new Person(1, "JohnDoe", 30, "Engineer");
    }

    @Test
    public void testSetAgeValid() {
        person.setAge(35);
        Assert.assertEquals(35, person.getAge());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetAgeInvalid() {
        person.setAge(-5);
    }

    @Test
    public void testFindByNameValid() {
        PersonsList personsList = new PersonsList();
        personsList.addPerson(person);

        Person foundPerson = personsList.findByName("John Doe");
        Assert.assertNotNull(foundPerson);
        Assert.assertEquals("JohnDoe", foundPerson.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByNameInvalidFormat() {
        PersonsList personsList = new PersonsList();
        personsList.addPerson(person);

        personsList.findByName("JohnDoe");
    }

    @Test
    public void testClonePerson() {

        Person clonedPerson = new PersonsList().clonePerson(person);
        Assert.assertNotEquals(person.getId(), clonedPerson.getId());
        Assert.assertEquals(person.getName(), clonedPerson.getName());
        Assert.assertEquals(person.getAge(), clonedPerson.getAge());
        Assert.assertEquals(person.getOccupation(), clonedPerson.getOccupation());
    }
}
