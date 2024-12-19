package com.haldovich.k8test.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.StringJoiner;

@RestController
@RequestMapping(value = "/v1/b2b")
public class CustomController {

    @Value("${app.configValue}")
    private String configValue;

    @Value("${app.secretValue}")
    private String secret;

    private String genre;

    @PostMapping(value = "/genre")
    public ResponseEntity<String> setGenre(@RequestBody String newGenre) {
        this.genre = newGenre;
        return ResponseEntity.ok("Genre updated to: " + newGenre);
    }

    @GetMapping(value = "/genre")
    public ResponseEntity<String> getGenre() {
        if (genre == null) {
            return ResponseEntity.ok("Genre is not set");
        }
        return ResponseEntity.ok("Current genre is: " + genre);
    }

    @GetMapping(value = "/hello")
    public ResponseEntity<String> getHello() {
        StringJoiner joiner = new StringJoiner("<br>");
        joiner.add("This value from configMap: " + configValue);
        joiner.add("This value from secrets: " + secret);
        return ResponseEntity.ok(joiner.toString());
    }
}
