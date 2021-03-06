package ir.maktab.quizer.models;

import ir.maktab.quizer.enums.AccountStatus;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USERNAME", nullable = false, unique = true)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    private boolean enabled = false;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PERSON", referencedColumnName = "firstName")
    private Person person;


    @ManyToMany
    @JoinTable(
            name = "account_roles",
            joinColumns = @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();

    public Account() {
    }

    public Account(String username, String password, AccountStatus accountStatus) {
        this.username = username;
        this.password = password;
        this.accountStatus = accountStatus;
    }

    public Account(String username, String password, AccountStatus AccountStatus,Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.accountStatus = AccountStatus;
        this.roles = roles;
    }

    public Account(String username, String password, AccountStatus AccountStatus , boolean enabled, Set<Role> roles, Person person) {
        this.username = username;
        this.password = password;
        this.accountStatus = AccountStatus;
        this.roles = roles;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(username, account.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }


    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", accountStatus=" + accountStatus +
                ", roles=" + roles +
                '}';
    }
}
