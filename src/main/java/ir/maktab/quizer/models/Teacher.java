package ir.maktab.quizer.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Teacher")
public class Teacher extends Person{
    public Teacher() {
    }

    public Teacher(String firstName, String lastName, String fathersName, String nationalCode) {
        super(firstName, lastName, fathersName, nationalCode);
    }

    public Teacher(String firstName, String lastName, String fathersName, String nationalCode, Account account) {
        super(firstName, lastName, fathersName, nationalCode, account);
    }
}
