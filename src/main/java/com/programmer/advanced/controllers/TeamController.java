package com.programmer.advanced.controllers;

import java.io.IOException;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/team", produces = MediaType.APPLICATION_JSON_VALUE)
public class TeamController {

    @GetMapping("")
    public List<String> teams() throws IOException {
        throw new IOException("My IO Exception");
    }

}
