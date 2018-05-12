package com.jp.userregistration.manager;

import com.jp.userregistration.dao.UserRegistrationDAO;
import com.jp.userregistration.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserRegistrationManager {

    private UserRegistrationDAO userRegistrationDAO;

    public User saveUser(User  user) {
        String id = UUID.randomUUID().toString();
        user.setId(id);
    return userRegistrationDAO.save(user);
    }
}
