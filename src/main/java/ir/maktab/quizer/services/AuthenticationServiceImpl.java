package ir.maktab.quizer.services;

import ir.maktab.quizer.dto.LoginAccountDto;
import ir.maktab.quizer.dto.RegisterAccountDTO;
import ir.maktab.quizer.enums.AccountStatus;
import ir.maktab.quizer.enums.Roles;
import ir.maktab.quizer.exceptions.NotValidAccountException;
import ir.maktab.quizer.exceptions.UsernameNotAllowed;
import ir.maktab.quizer.models.*;
import ir.maktab.quizer.outcome.LoginAccountOutcome;
import ir.maktab.quizer.outcome.RegisterAccountOutcome;
import ir.maktab.quizer.repositories.AccountRepository;
import ir.maktab.quizer.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    final AccountRepository accountRepository;
    final RoleRepository roleRepository;
    final PasswordEncoder passwordEncoder;


    @Autowired
    public AuthenticationServiceImpl(AccountRepository accountRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public LoginAccountOutcome login(LoginAccountDto loginAccountDto) {
        Account account = accountRepository.findByUsername(loginAccountDto.getUsername());
        return new LoginAccountOutcome(account.getUsername()
                , account.getRoles().stream().map(Role::toString).collect(Collectors.toSet()));
    }

    @Override
    public RegisterAccountOutcome register(RegisterAccountDTO registerAccountDTO) throws UsernameNotAllowed, NotValidAccountException {

        if (accountRepository.findAccountByUsername(registerAccountDTO.getUsername()).isPresent()) {
            throw new UsernameNotAllowed("لطفا نام کاربری دیگری انتخاب کنید!");
        }

        Person person;

        if (registerAccountDTO.getRole().equals(Roles.ROLE_STUDENT.toString()))
            person = new Student();
        else if (registerAccountDTO.getRole().equals(Roles.ROLE_TEACHER.toString()))
            person = new Teacher();
        else {
            throw new NotValidAccountException("role not valid!");
        }
        Account account = accountRepository.save(
                new Account(
                        registerAccountDTO.getUsername(),
                        passwordEncoder.encode(registerAccountDTO.getPassword()),
                        AccountStatus.AWAITING_APPROVAL,
                        false,
                        Set.of(roleRepository.findRoleByTitle(Roles.valueOf(registerAccountDTO.getRole()))),
                        person));

        return new RegisterAccountOutcome(account.getUsername());
    }
}
