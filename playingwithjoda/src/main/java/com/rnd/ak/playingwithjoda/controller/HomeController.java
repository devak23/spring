package com.rnd.ak.playingwithjoda.controller;

import com.rnd.ak.playingwithjoda.model.BillingRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping ("/v1/home")
public class HomeController {

    @GetMapping("/ping")
    public ResponseEntity<String> itWorks() {
        return ResponseEntity.ok().body("It works!");
    }

    @PostMapping("/ping2")
    public ResponseEntity<String> itWorks2() {
        return ResponseEntity.ok().body("It works in POST as well!");
    }

    @PostMapping("/initiate")
    public ResponseEntity<String> consumeRequest(@RequestBody BillingRequest request) {
        log.info("Request: {}", request);
        return ResponseEntity.ok("Request is consumed!");
    }
}
