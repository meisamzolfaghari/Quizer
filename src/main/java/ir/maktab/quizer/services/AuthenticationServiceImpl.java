package ir.maktab.quizer.services;

import ir.maktab.quizer.dto.LoginAccountDto;
import ir.maktab.quizer.models.Account;
import ir.maktab.quizer.models.Role;
import ir.maktab.quizer.outcome.LoginAccountOutcome;
import ir.maktab.quizer.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    final AccountRepository accountRepository;

    @Autowired
    public AuthenticationServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public LoginAccountOutcome login(LoginAccountDto loginAccountDto) {
        Account account = accountRepository.findByUsername(loginAccountDto.getUsername());
        return new LoginAccountOutcome(account.getUsername()
                , account.getRoles().stream().map(Role::toString).collect(Collectors.toSet()));
    }
}
