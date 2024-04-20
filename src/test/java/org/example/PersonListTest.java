package org.example;

public class PersonListTest {

    PersonList personList = new PersonList();

    Person person1 = new Person (3235,"Miguel Lopez", 22,"Java Developer");
    Person person2 = new Person (3463,"Miguel Lopez", 45,"Java Developer");
    Person person3 = new Person (4632,"Susana Garcia", 34,"IT Technician");

    public PersonList getPersonList() {
        return personList;
    }

}
