package com.junrylmaraviles.oauth2api.springbootapioauth2skeleton.controller;

import com.junrylmaraviles.oauth2api.springbootapioauth2skeleton.model.AuthRequest;
import com.junrylmaraviles.oauth2api.springbootapioauth2skeleton.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SampleController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    //public endpoint
    @GetMapping("/ping")
    public String ping() {
        return "Ping is successful!";
    }

    //protected endpoint
    @GetMapping("/isAuthorized")
    public String isAuthorized() {
        return "Congratulations, you are now authorized.";
    }

    @PostMapping("/token")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("Invalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }

}
