public class Person {


    private int id;
    private String name;
    private int age;
    private String occupation;

    // Constructor
    public Person(int id, String name, int age, String occupation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    // Método setAge
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("La edad no puede ser menor que 0");
        }
        this.age = age;
    }

    public boolean equals(Person p) {
        return this.name.equals(p.name) &&
                this.age == p.age &&
                this.occupation.equals(p.occupation);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    private String formatName(String name) {
        String[] parts = name.split(" ");
        if (parts.length != 2) {
            throw new IllegalArgumentException("El nombre debe tener formato 'nombre apellido'");
        }
        String firstName = parts[0];
        String lastName = parts[1];
        return firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase() +
                lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                '}';
    }
}
