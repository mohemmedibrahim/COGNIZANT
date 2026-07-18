package com.cognizant.loan.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class LoanController {

    @GetMapping("/loans/{id}")

    public Map<String,Object> loan(@PathVariable String id){

        Map<String,Object> loan=new HashMap<>();

        loan.put("Loan Number",id);

        loan.put("Type","Car Loan");

        loan.put("Amount",500000);

        return loan;

    }

}