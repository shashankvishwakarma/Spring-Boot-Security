package com.example.springbootsecurity.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ldap")
public class HelloResource {

    @GetMapping(value = "/check")
    public String check() {
        return "LDAP Authentication successful !";
    }

}
