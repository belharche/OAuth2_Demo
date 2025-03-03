package com.auth.oauth2_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private OAuth2AuthorizedClientService clientService;

    @GetMapping("/home")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("Hello World From Protected Home");
    }

    @GetMapping("/")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("Hello World");
    }

    @GetMapping("/token")
    public String getAccessToken(Authentication authentication) {
        OAuth2AuthorizedClient authorizedClient = clientService
                .loadAuthorizedClient("google", authentication.getName());

        if (authorizedClient != null) {
            String accessToken = authorizedClient.getAccessToken().getTokenValue();
            return "Access Token: " + accessToken;
        }

        return "No token found!";
    }

    @GetMapping("/auth")
    public Authentication getAuthentication(Authentication authentication) {
        return authentication;
    }

}
