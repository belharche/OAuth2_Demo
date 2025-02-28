package com.auth.oauth2_demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("Hello World From Protected Home");
    }

    @GetMapping("/")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("Hello World");
    }

}
