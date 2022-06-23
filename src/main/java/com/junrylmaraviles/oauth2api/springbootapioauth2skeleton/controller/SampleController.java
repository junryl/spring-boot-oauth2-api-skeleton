package com.junrylmaraviles.oauth2api.springbootapioauth2skeleton.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SampleController {


    @GetMapping("/ping")
    public String ping() {
        return "Ping is successful!";
    }

}
