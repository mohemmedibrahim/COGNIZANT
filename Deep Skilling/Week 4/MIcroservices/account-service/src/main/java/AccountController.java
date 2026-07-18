package com.cognizant.account.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class AccountController {

    @GetMapping("/accounts/{id}")
    public Map<String,Object> getAccount(@PathVariable String id){

        Map<String,Object> map=new HashMap<>();

        map.put("Account Number",id);
        map.put("Type","Savings");
        map.put("Balance",45000);

        return map;

    }

}