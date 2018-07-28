package com.jp.userregistration.controller;

import com.jp.model.user.User;
import com.jp.userregistration.manager.UserRegistrationManager;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserRegistrationController {

    private  UserRegistrationManager userRegistrationManager;
    @PostMapping("/v2/save")
    public User createUser(@RequestBody final User user) {
      return  userRegistrationManager.saveUser(user);
    }

    @PostMapping("/v1/save")
    public User createUserInRdbms(@RequestBody final User user) {
        return  userRegistrationManager.saveUser(user);
    }
}
