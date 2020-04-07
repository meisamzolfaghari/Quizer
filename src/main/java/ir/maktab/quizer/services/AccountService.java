package ir.maktab.quizer.services;

import ir.maktab.quizer.dto.RegisterAccountDTO;
import ir.maktab.quizer.exceptions.NotValidAccountException;
import ir.maktab.quizer.exceptions.UsernameNotAllowed;
import ir.maktab.quizer.outcome.RegisterAccountOutcome;

public interface AccountService {

    RegisterAccountOutcome register(RegisterAccountDTO registerAccountDTO) throws UsernameNotAllowed, NotValidAccountException;

}
