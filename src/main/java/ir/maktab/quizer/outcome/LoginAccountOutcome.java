package ir.maktab.quizer.outcome;

import java.util.Set;

public class LoginAccountOutcome {
    String username;
    Set<String> roles;

    public LoginAccountOutcome(String username, Set<String> roles) {
        this.username = username;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "LoginAccountOutcome{" +
                "username='" + username + '\'' +
                ", roles=" + roles +
                '}';
    }
}
