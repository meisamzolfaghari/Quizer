package ir.maktab.quizer.dto;

import ir.maktab.quizer.enums.Roles;

public class RegisterAccountDTO {

    String username;

    String password;

    Roles role;

    public RegisterAccountDTO(String username, String password, Roles role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Roles getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "RegisterAccountDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
