package ir.maktab.quizer.repositories;

import ir.maktab.quizer.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
