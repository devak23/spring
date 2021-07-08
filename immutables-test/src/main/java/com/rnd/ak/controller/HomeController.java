package com.rnd.ak.controller;

import com.rnd.ak.model.ImmutableUser;
import com.rnd.ak.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping ("/api/v1/home")
public class HomeController {

    public ResponseEntity<User> getUser() {
        ImmutableUser user = ImmutableUser.builder()
                .name("Abhay")
                .age(42.5f)
                .address("206, shiv srishti, Mumbai")
                .cell("8879354118")
                .build();
        return ResponseEntity.ok(user);
    }
}
