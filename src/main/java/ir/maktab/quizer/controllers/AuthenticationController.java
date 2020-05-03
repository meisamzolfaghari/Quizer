package ir.maktab.quizer.controllers;

import ir.maktab.quizer.dto.LoginAccountDto;
import ir.maktab.quizer.dto.RegisterAccountDTO;
import ir.maktab.quizer.exceptions.NotValidAccountException;
import ir.maktab.quizer.exceptions.UsernameNotAllowed;
import ir.maktab.quizer.outcome.LoginAccountOutcome;
import ir.maktab.quizer.outcome.RegisterAccountOutcome;
import ir.maktab.quizer.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RestController
@RequestMapping
public class AuthenticationController {
    final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    private LoginAccountOutcome login(@RequestBody LoginAccountDto loginAccountDto){
        return authenticationService.login(loginAccountDto);
    }

    @PostMapping("/register")
    private RegisterAccountOutcome register(@RequestBody RegisterAccountDTO registerAccountDTO) throws UsernameNotAllowed, NotValidAccountException {
        return authenticationService.register(registerAccountDTO);
    }

}
