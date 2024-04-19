public class Person {
    private int id;
    private String name;
    private int age;
    private String occupation;

    public Person(int id, String name, int age, String occupation) {
        this.id = id;
        this.name = name;
        this.setAge(age);
        this.occupation = occupation;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("La edad no puede ser menor que 0");
        }
        this.age = age;
    }

    public boolean equals(Person otherPerson) {
        return this.name.equals(otherPerson.name) &&
                this.age == otherPerson.age &&
                this.occupation.equals(otherPerson.occupation);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }
}
