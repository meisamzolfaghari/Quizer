package ir.maktab.quizer.services;

import ir.maktab.quizer.dto.LoginAccountDTO;
import ir.maktab.quizer.dto.RegisterAccountDTO;
import ir.maktab.quizer.exceptions.UsernameNotAllowed;
import ir.maktab.quizer.outcome.LoginAccountOutcome;
import ir.maktab.quizer.outcome.RegisterAccountOutcome;
import ir.maktab.quizer.repositories.AccountRepository;
import ir.maktab.quizer.repositories.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    final AccountRepository accountRepository;
    final RoleRepository roleRepository;

    public AccountServiceImpl(AccountRepository accountRepository, RoleRepository roleRepository) {
        this.accountRepository = accountRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public RegisterAccountOutcome register(RegisterAccountDTO registerAccountDTO) throws UsernameNotAllowed {

        if (accountRepository.findAccountByUsername(registerAccountDTO.getUsername()).isPresent()) {
            throw new UsernameNotAllowed("نام کاربری دیگری انتخاب کنید!");
        }


        return null;
    }

    @Override
    public LoginAccountOutcome login(LoginAccountDTO loginAccountDTO) {
        return null;
    }
}
