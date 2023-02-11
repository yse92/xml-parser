package solvd.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    private int id;
    private double balance;
    private boolean isActive;

    public Account() {
    }

    public Account(int id, double balance, boolean isActive) {
        this.id = id;
        this.balance = balance;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", isActive=" + isActive +
                '}';
    }
}
