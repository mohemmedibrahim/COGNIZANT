package com.cognizant.account.controller;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AccountController {

    @GetMapping("/accounts/{number}")
    public Map<String, Object> getAccount(@PathVariable String number) {

        Map<String, Object> account = new HashMap<>();

        account.put("Account Number", number);
        account.put("Account Type", "Savings");
        account.put("Customer Name", "Balashanmugam");
        account.put("Balance", 50000);

        return account;
    }
}