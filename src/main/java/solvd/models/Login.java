package solvd.models;

public class Login {
    private int id;
    private String name;
    private String password;

    public Login(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Login() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
