public class Main {
    public static void main(String[] args) {
        Person person1 = new Person(1, "Cheyenne Saiz ", 32, "Problem Solver");
        Person person2 = new Person(2, "Elsa Lorente ", 32, "Profesora");

        PersonsList personsList = new PersonsList();

        // Prueba de setAge
        try {
            person1.setAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Error en setAge: " + e.getMessage());
        }


        try {
            Person foundPerson = personsList.findByName("Cheyenne Saiz");
            System.out.println("Persona encontrada: " + foundPerson.getName());
        } catch (IllegalArgumentException e) {
            System.out.println("Error en findByName: " + e.getMessage());
        }


        try {
            personsList.findByName("Cheyenne");
        } catch (IllegalArgumentException e) {
            System.out.println("Error en findByName: " + e.getMessage());
        }


        Person clonedPerson = personsList.clone(person1);
        System.out.println("Clon de la persona: " + clonedPerson.getName() + ", Nuevo ID: " + clonedPerson.getId());
    }
}
