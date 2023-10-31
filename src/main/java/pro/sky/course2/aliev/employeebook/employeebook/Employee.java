package pro.sky.course2.aliev.employeebook.employeebook;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;

    /**
     * Constructor
     * @param firstName - firstname
     * @param lastName  - lastname
     */
    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public int hashCode() {
        return 29 * firstName.hashCode() + 31 * lastName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        boolean result;
        if (this == obj) {
            result = true;
        } else if (obj == null || getClass() != obj.getClass()) {
            result = false;
        } else {
            result = Objects.equals(firstName, ((Employee) obj).firstName) && Objects.equals(lastName, ((Employee) obj).lastName);
        }
        return result;
    }
}
