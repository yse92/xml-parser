package solvd.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String phone;

    public Customer(int id, String firstName, String lastName, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public Customer() {

    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
