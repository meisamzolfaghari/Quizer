package ir.maktab.quizer.repositories;

import ir.maktab.quizer.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> , JpaSpecificationExecutor<Account> {
    Optional<Account> findAccountByUsername(String username);
    Account findByUsername(String username);
}
