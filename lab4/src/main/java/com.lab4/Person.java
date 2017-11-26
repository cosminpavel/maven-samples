package com.lab4;

/**
 * Created by Cosmin on 11/14/2017.
 */
public class Person{
    private String name1;
    private String name2;
    private String name3;
    private String cnp;
    private String email;

    public Person(String name1, String name2, String name3, String cnp, String email) {
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
        this.cnp = cnp;
        this.email = email;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (name1 != null ? !name1.equals(person.name1) : person.name1 != null) return false;
        if (name2 != null ? !name2.equals(person.name2) : person.name2 != null) return false;
        if (name3 != null ? !name3.equals(person.name3) : person.name3 != null) return false;
        if (cnp != null ? !cnp.equals(person.cnp) : person.cnp != null) return false;
        return email != null ? email.equals(person.email) : person.email == null;
    }

    @Override
    public int hashCode() {
        int result = name1 != null ? name1.hashCode() : 0;
        result = 31 * result + (name2 != null ? name2.hashCode() : 0);
        result = 31 * result + (name3 != null ? name3.hashCode() : 0);
        result = 31 * result + (cnp != null ? cnp.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name1 + " " +name2 +  " " + name3 + " " +cnp + " " +email;
    }
}
