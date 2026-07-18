public class LoanController {
    package com.cognizant.loan.controller;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

    @RestController
    public class LoanController {

        @GetMapping("/loans/{number}")
        public Map<String,Object> getLoan(@PathVariable String number){

            Map<String,Object> loan=new HashMap<>();

            loan.put("Loan Number",number);
            loan.put("Loan Type","Car Loan");
            loan.put("Loan Amount",400000);
            loan.put("EMI",9500);

            return loan;
        }

    }
}
