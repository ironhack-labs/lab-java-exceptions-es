package org.example;
import org.junit.jupiter.api.*;
public class PersonTest {
    PersonList personList = new PersonList();
    Person person1 = new Person (3235,"Miguel Lopez", 22,"Java Developer");
    Person person2 = new Person (3463,"Miguel Lopez", 45,"Java Developer");
    Person person3 = new Person (4632,"Susana Garcia", 34,"IT Technician");

    @Test
    @DisplayName("Testing setAge con edades negativas")
    void setAge_NegativeNumbers_ThrowsIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> person1.setAge(-2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> person2.setAge(-76));
        //Assertions.assertThrows(IllegalArgumentException.class, () -> person2.setAge(14));

        System.out.println("SetAge funciona correctamente lanzando IllegalArgumentException cuando la edad es menor que 0");
    }

    @Test
    @DisplayName("Testing findByName()")
    void findByName_ReturnsPerson_Ok() {
        personList.addPerson(person1);
        personList.addPerson(person2);
        personList.addPerson(person3);

        Assertions.assertEquals(person1, personList.findByName("Miguel Lopez"));
        Assertions.assertEquals(person3, personList.findByName("Susana Garcia"));
        //Assertions.assertEquals(person3, personList.findByName("Pedro Suarez"));

        System.out.println("FindByName encuentra y devuelve correctamente el Person cuyo nombre coincide");
    }

    @Test
    @DisplayName("Testing findByName con nombre en formato incorrecto")
    void findByName_WrongFormat_ThrowsIllegalArgumentException() {
        personList.addPerson(person1);
        personList.addPerson(person2);
        personList.addPerson(person3);

        Assertions.assertThrows(IllegalArgumentException.class, () -> personList.findByName("MiguelLopez"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> personList.findByName("Vanesa Ruiz"));
        //Assertions.assertThrows(IllegalArgumentException.class, () -> personList.findByName("Miguel Lopez"));
        //Assertions.assertThrows(IllegalArgumentException.class, () -> personList.findByName(null));
        System.out.println("FindByName funciona correctamente lanzando IllegalArgumentException cuando el formato de Nombre Apellido es incorrecto");
    }

    @Test
    @DisplayName("Testing clonePerson()")
    void clonePerson_ReturnsPerson_Ok() {
        Person person4 = person3.clonePerson(person3);

        Assertions.assertFalse(person4.getId() == person3.getId());
        Assertions.assertTrue(person4.getNombreApellido().toLowerCase().equals
                (person3.getNombreApellido().toLowerCase()) && person4.getAge() == person3.getAge()
                && person4.getOccupation().toLowerCase().equals(person3.getOccupation().toLowerCase()));

        System.out.println("clonePerson tiene los mismos atributosque que el Person clonado");
    }
}
