package org.example.classes;

import org.example.utils.Validator;

import java.util.Objects;

public class Person  {
    private static int identifierCounter = 0;
    private int identifier;
    private String fullName;
    private int years;
    private String jobTitle;

    public Person (String fullName, int years, String jobTitle) {
        this.identifier = identifierCounter++;
        setFullName(fullName);
        setYears(years);
        this.jobTitle = jobTitle;
    }

    public Person () {
    }

    public Person (int identifier, String fullName, int years, String jobTitle) {
        this.identifier = identifier;
        this.fullName = fullName;
        this.years = years;
        this.jobTitle = jobTitle;
    }

    @Override
    public Person  clone() {
        return new Person (fullName, years, jobTitle);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person  that = (Person ) obj;
        return getYears() == that.getYears() && getFullName().equals(that.getFullName()) && getJobTitle().equals(that.getJobTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFullName(), getYears(), getJobTitle());
    }

    @Override
    public String toString() {
        return "Individual: " + fullName +
                "\nidentifier=" + identifier +
                "\nyears=" + years +
                "\njobTitle='" + jobTitle + '\n';
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        Validator.checkName(fullName);
        this.fullName = fullName;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        Validator.checkAge(years);
        this.years = years;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
