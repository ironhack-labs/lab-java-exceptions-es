package org.ironhack.lab204;

import org.junit.Assert;
import org.junit.Test;

public class PersonsListTest {

    @Test
    public void testFindByName() {
        PersonsList personsList = new PersonsList();
        Person person1 = new Person(1, "John Doe", 30, "Engineer");
        Person person2 = new Person(2, "Jane Smith", 25, "Analyst");

        personsList.addPerson(person1);
        personsList.addPerson(person2);

        Assert.assertEquals(person1, personsList.findByName("John Doe"));
        Assert.assertThrows(IllegalArgumentException.class, () -> personsList.findByName("John"));
    }
        @Test
        public void testClone() {
            Person person = new Person(1, "John Doe", 30, "Engineer");
            PersonsList personsList = new PersonsList();
            Person clonedPerson = personsList.clone(person);

            Assert.assertEquals(person.getName(), clonedPerson.getName());
            Assert.assertEquals(person.getAge(), clonedPerson.getAge());
            Assert.assertEquals(person.getOccupation(), clonedPerson.getOccupation());

    }
}
