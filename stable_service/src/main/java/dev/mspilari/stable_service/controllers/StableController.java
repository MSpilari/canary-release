package dev.mspilari.stable_service.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stable")
public class StableController {

    @GetMapping("/")
    public ResponseEntity<String> stableResponse() {
        return ResponseEntity.ok().body("Hello World from Stable Service.");
    }
}
