package ir.maktab.quizer.models;

import ir.maktab.quizer.enums.Roles;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE", length = 30, nullable = false)
    @Enumerated(EnumType.STRING)
    private Roles title;

    @ManyToMany(mappedBy = "roles")
    private Set<Account> accounts = new HashSet<>();

    public Role() {
    }

    public Role(Roles title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public Roles getTitle() {
        return title;
    }

    public void setTitle(Roles title) {
        this.title = title;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return title == role.title;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", title=" + title +
                '}';
    }
}
