package org.example.classes;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PersonListTest {
    Person p1;
    Person p2;
    Person p3;
    Person p4;
    PersonList pl;

    @BeforeEach
    void init() {
        pl = new PersonList();
        p1 = new Person("Ana Sánchez", 17, "Pintora");
        p2 = new Person("Laura Garcia", 42, "Escultora");
        p3 = new Person("Alberto Miranda", 23, "Trabajador de Amazon");
        p4 = new Person("Lisa Medina", 51, "Música");
        pl.addIndividual(p1);
        pl.addIndividual(p2);
        pl.addIndividual(p3);
        pl.addIndividual(p4);
    }

    @Test
    void findByName_sameNameOK() {
        assertEquals(p1, pl.searchByName("Ana Sánchez"));
    }

    @Test
    void findByName_wrongName() {
        assertThrows(UnsupportedOperationException.class, () -> pl.searchByName("Ana Sanchez"));
    }

    @Test
    void findByName_emptyList() {
        pl.clearAll();
        assertThrows(UnsupportedOperationException.class, () -> pl.searchByName("Ana Sánchez"));
    }

    @Test
    void findByName_nameMultipleTimes_returnsFirst() {
        p4.setFullName("Ana Sanchez");
        assertEquals(p1.getIdentifier(), pl.searchByName("Ana Sánchez").getIdentifier());
    }
}