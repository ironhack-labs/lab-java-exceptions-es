package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testSetAgeThrowsErrorIfNegativeAge() {
        Person person1 = new Person(1, "Juan Perez", 45, "Teacher");
        assertThrows(IllegalArgumentException.class, () -> person1.setAge(-1));
    }

    @Test
    public void testFindByNameReturnsCorrectPerson() {
        PersonsList personsList = new PersonsList();
        Person person2 = new Person(2, "Adrian Pintor", 24, "Engineer");
        Person person3 = new Person(3, "Maria Ramos", 22, "Doctor");
        personsList.add(person2);
        personsList.add(person3);

        assertEquals(person2, personsList.findByName("Adrian Pintor"));
        assertEquals(person3, personsList.findByName("Maria Ramos"));
    }

    @Test
    public void testFindByNameThrowsErrorIfNameNotFormattedCorrectly() {
        PersonsList personsList = new PersonsList();
        Person person1 = new Person(1, "Juan Perez", 45, "Teacher");
        personsList.add(person1);

        assertThrows(IllegalArgumentException.class, () -> personsList.findByName("JuanPerez"));
        assertThrows(IllegalArgumentException.class, () -> personsList.findByName("Juan"));
        assertThrows(IllegalArgumentException.class, () -> personsList.findByName("Juan Perez Garcia"));
    }

    @Test
    public void testCloneCreatesNewPersonWithSamePropertiesExceptId() {
        Person originalPerson = new Person(1, "Juan Perez", 45, "Teacher");
        PersonsList personsList = new PersonsList();
        personsList.add(originalPerson);

        Person clonedPerson = personsList.clone(originalPerson);
        assertEquals(originalPerson.getName(), clonedPerson.getName());
        assertEquals(originalPerson.getAge(), clonedPerson.getAge());
        assertEquals(originalPerson.getOccupation(), clonedPerson.getOccupation());
        assertNotEquals(originalPerson.getId(), clonedPerson.getId());

        assertTrue(originalPerson.equals(clonedPerson));
    }

}
