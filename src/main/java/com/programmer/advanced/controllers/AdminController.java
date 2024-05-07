package com.programmer.advanced.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {

    
    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }

    @GetMapping("/hello-admin")
    public String helloAdmin() {
        return "Hello world Admin";
    }

}
