package ir.maktab.quizer.services;

import ir.maktab.quizer.dto.LoginAccountDto;
import ir.maktab.quizer.dto.RegisterAccountDTO;
import ir.maktab.quizer.exceptions.NotValidAccountException;
import ir.maktab.quizer.exceptions.UsernameNotAllowed;
import ir.maktab.quizer.outcome.LoginAccountOutcome;
import ir.maktab.quizer.outcome.RegisterAccountOutcome;

public interface AuthenticationService {
    LoginAccountOutcome login(LoginAccountDto loginAccountDto);

    RegisterAccountOutcome register(RegisterAccountDTO registerAccountDTO) throws UsernameNotAllowed, NotValidAccountException;
}
