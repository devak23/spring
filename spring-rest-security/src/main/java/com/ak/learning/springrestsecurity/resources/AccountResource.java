package com.ak.learning.springrestsecurity.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountResource {

    @RequestMapping(value = "/rest/v1/public/accounts/{accountNumber}", method = RequestMethod.GET)
    public String getPublicAccountDataLinkedTo(@PathVariable("accountNumber") final int accountNumber) {
        return "Public account linked: " + accountNumber;
    }

    @RequestMapping(value = "/rest/v1/private/accounts/{accountNumber}", method = RequestMethod.GET)
    public String getPrivateAccountDataLinkedTo(@PathVariable("accountNumber") final int accountNumber) {
        return "Private account linked: " + accountNumber;
    }
}
