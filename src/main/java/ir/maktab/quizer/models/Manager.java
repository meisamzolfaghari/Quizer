package ir.maktab.quizer.models;

import javax.persistence.Entity;

@Entity
public class Manager extends Person {

    public Manager() {
    }

    public Manager(String firstName, String lastName, String fathersName, String nationalCode) {
        super(firstName, lastName, fathersName, nationalCode);
    }

    public Manager(String firstName, String lastName, String fathersName, String nationalCode, Account account) {
        super(firstName, lastName, fathersName, nationalCode, account);
    }
}
