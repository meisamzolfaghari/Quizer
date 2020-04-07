package ir.maktab.quizer.dto;

import ir.maktab.quizer.enums.Roles;

public class RegisterAccountDTO {

    String username;

    String password;

    String role;

    public RegisterAccountDTO(String username, String password, String role) {
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

    public String getRole() {
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
