package com.programmer.answers.advanced.controllers;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Vous devez ajouter l'annotation @RestController
 */
//@RestController
@RequestMapping(value = "/api/v1/admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {

    /**
     * Vous devez ajouter l'annotation @PreAuthorize("hasAnyRole('USER')") Pour limiter l'accès à
     * L'api aux utilisateurs ayant le rôle USER
     */
    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }

    /**
     * Vous devez ajouter l'annotation @PreAuthorize("hasAnyRole('USER')") Pour limiter l'accès à
     * L'api aux utilisateurs ayant le rôle ADMIN
     */
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/hello-admin")
    public String helloAdmin() {
        return "Hello world Admin";
    }

}
