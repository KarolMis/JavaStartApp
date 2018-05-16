package data;

import java.io.Serializable;
import java.util.Objects;

public abstract class User implements Serializable {

    private String firstName;
    private String lastName;
    private String pesel;

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPesel() {
        return pesel;
    }

    public User setPesel(String pesel) {
        this.pesel = pesel;
        return this;
    }

    public User(String firstName, String lastName, String pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(pesel, user.pesel);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName, pesel);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pesel='" + pesel + '\'' +
                '}';
    }
}
