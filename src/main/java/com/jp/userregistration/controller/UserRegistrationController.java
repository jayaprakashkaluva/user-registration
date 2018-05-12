package com.jp.userregistration.controller;

import com.jp.userregistration.entity.User;
import com.jp.userregistration.manager.UserRegistrationManager;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserRegistrationController {

    @Autowired
    private  UserRegistrationManager userRegistrationManager;
    @PostMapping("/save")
    public User createUser(@RequestBody final User user) {
      return  userRegistrationManager.saveUser(user);
    }
}
