public class Main {
    public static void main(String[] args) {

        PersonsList personsList = new PersonsList();
        Person person1 = new Person(1, "Juan Pérez", 30, "Desarrollador");
        Person person2 = new Person(2, "María Gómez", 25, "Diseñador");
        Person person3 = new Person(3, "Ana Martínez", 40, "Gerente");
        personsList.addPerson(person1);
        personsList.addPerson(person2);
        personsList.addPerson(person3);

        try {
            person1.setAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción atrapada: " + e.getMessage());
        }

        try {
            Person foundPerson = personsList.findByName("Juan Pérez");
            System.out.println("Persona encontrada: " + foundPerson);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción atrapada: " + e.getMessage());
        }
        try {
            Person foundPerson = personsList.findByName("Monzer Alzaim");
            System.out.println("Persona encontrada: " + foundPerson);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción atrapada: " + e.getMessage());
        }
        try {
            Person foundPerson = personsList.findByName("JuanPerez");
            System.out.println("Persona encontrada: " + foundPerson);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción atrapada: " + e.getMessage());
        }

        Person clonedPerson = personsList.clone(person1);
        System.out.println("Persona clonada: " + clonedPerson);




    }
}