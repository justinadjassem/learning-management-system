package com.golfe3.LMS.web;

import com.golfe3.LMS.entities.AppUser;
import com.golfe3.LMS.services.AccountServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    private AccountServices accountServices;

    public AccountController(AccountServices accountServices) {
        this.accountServices = accountServices;
    }
    @GetMapping(path = "/users")
    public List<AppUser> appUsers(){
        return accountServices.listOfUsers();
    }
}
