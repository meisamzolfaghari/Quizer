package ir.maktab.quizer.outcome;

public class RegisterAccountOutcome {
    String username;

    public RegisterAccountOutcome(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "RegisterAccountOutcome{" +
                "username='" + username + '\'' +
                '}';
    }
}
