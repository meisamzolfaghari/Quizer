package ir.maktab.quizer.services;

import ir.maktab.quizer.dto.LoginAccountDto;
import ir.maktab.quizer.outcome.LoginAccountOutcome;

public interface AuthenticationService {
    LoginAccountOutcome login(LoginAccountDto loginAccountDto);
}
