package org.example;
import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    public void testSetName() {
        Person person = new Person(1, "", 30, "");

        person.setName("John Doe");
        assertEquals("johnDoe", person.getName());

        person.setName("MaRCo vIllasMil");
        assertEquals("marcoVillasmil", person.getName());

        person.setName("  Bob   Smith  ");
        assertEquals("bobSmith", person.getName());

        person.setName("eva LOPEZ");
        assertEquals("evaLopez", person.getName());

        person.setName(""); // empty input
        assertEquals("", person.getName());

        person.setName("peter"); // single name
        assertEquals("peter", person.getName());
    }


    @Test
    public void testSetAge() {
        Person person = new Person(1, "", 30, "");
        person.setAge(40);
        assertEquals(40, person.getAge());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {person.setAge(0);});
        assertEquals("Age must be greater than 0.", exception.getMessage());

        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () -> {person.setAge(-5);});
        assertEquals("Age must be greater than 0.", exception1.getMessage());
    }



}
