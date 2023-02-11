package solvd.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Branch {
    private int id;
    private String adress;
    private String phone;

    public Branch() {
    }

    public Branch(int id, String adress, String phone) {
        this.id = id;
        this.adress = adress;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                ", adress='" + adress + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
