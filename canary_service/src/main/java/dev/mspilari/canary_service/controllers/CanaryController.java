package dev.mspilari.canary_service.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("canary")
public class CanaryController {

    @GetMapping("/")
    public ResponseEntity<String> canaryResponse() {
        return ResponseEntity.ok().body("Hello World from Canary Service.");
    }
}
