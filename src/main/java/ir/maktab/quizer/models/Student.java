package ir.maktab.quizer.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Student")
public class Student extends Person {
    public Student() {
    }

    public Student(String firstName, String lastName, String fathersName, String nationalCode) {
        super(firstName, lastName, fathersName, nationalCode);
    }

    public Student(String firstName, String lastName, String fathersName, String nationalCode, Account account) {
        super(firstName, lastName, fathersName, nationalCode, account);
    }
}
