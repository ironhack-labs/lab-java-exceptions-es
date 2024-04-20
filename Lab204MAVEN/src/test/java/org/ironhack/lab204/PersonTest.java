package org.ironhack.lab204;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {
    @Test
    public void testSetAge() {
        Person person = new Person(1, "John Doe", 30, "Engineer");
        Assert.assertThrows(IllegalArgumentException.class, () -> person.setAge(-1));
    }

    @Test
    public void testEquals() {
        Person person1 = new Person(1, "John Doe", 30, "Engineer");
        Person person2 = new Person(2, "Jane Smith", 25, "Analyst");
        Person person3 = new Person(1, "John Doe", 30, "Engineer");

        Assert.assertEquals(false, person1.equals(person2));
        Assert.assertEquals(true, person1.equals(person3));
    }

}
