package com.example.springbootsecurity.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloWorldController {

    @RequestMapping({"/home"})
    public String hello() {
        return "Hello World";
    }

    @RequestMapping({"/user"})
    public String user() {
        return "Hello user";
    }

    @RequestMapping({"/admin"})
    public String admin() {
        return "Hello Admin";
    }

}
