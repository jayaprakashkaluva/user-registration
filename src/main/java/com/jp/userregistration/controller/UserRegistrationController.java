package com.jp.userregistration.controller;

import com.jp.model.user.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserRegistrationController {

    @PostMapping("/save")
    public void createUser(@RequestBody final User user) {

    }
}
