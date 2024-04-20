package org.example;

public class Person {
    private int id;
    private String name;
    private int age;
    private String occupation;

    public Person(int id, String name, int age, String occupation) {
        this.id = id;
        setName(name); // formatting name to camel case
        this.age = age;
        this.occupation = occupation;
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
        this.name = formatName(name);
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age must be greater than 0.");
        }
    }


    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }


    // Method -> Camel case formatter
    public static String formatName(String name) {

        // Remove space, capitalize each part
        String[] nameParts = name.trim().split("\\s+");
        StringBuilder formattedNameBuilder = new StringBuilder();

        // go through each part of the name
        for (int i = 0; i < nameParts.length; i++) {
            String part = nameParts[i];
            // Ensure part is not empty before formatting
            if (!part.isEmpty()) {
                // Capitalize the first letter of the first part and lowercase the rest
                if (i == 0) {
                    formattedNameBuilder.append(Character.toLowerCase(part.charAt(0)))
                            .append(part.substring(1).toLowerCase());
                } else {
                    // Capitalize the first letter and append the rest of the string in lowercase
                    formattedNameBuilder.append(Character.toUpperCase(part.charAt(0)))
                            .append(part.substring(1).toLowerCase());
                }
            }
        }

        return formattedNameBuilder.toString();
    }


    // Method to compare if properties are the same
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Person otherPerson = (Person) o;

        return getName().equals(otherPerson.getName())
                && getAge() == otherPerson.getAge()
                && getOccupation().equals(otherPerson.getOccupation());
    }


    // Method to display the person's details
    @Override
    public String toString() {
        return "\n-------\nDETAILS"
                    + "\nID: " + id
                    + "\nNAME: " + name
                    + "\nAGE: " + age
                    + "\nOCCUPATION: " + occupation;
    }
}

