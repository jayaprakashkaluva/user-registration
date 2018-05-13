package com.jp.userregistration.manager;

import com.jp.model.user.User;
import com.jp.userregistration.dao.UserRegistrationDAO;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserRegistrationManager {

    private UserRegistrationDAO userRegistrationDAO;

    public User saveUser(User user) {
        com.jp.couch.user.User userEntity = new com.jp.couch.user.User();
        BeanUtils.copyProperties(user,userEntity);
        userEntity.setId(UUID.randomUUID().toString());
    User newUser =  new User();
    BeanUtils.copyProperties(userRegistrationDAO.save(userEntity),newUser);
    return newUser;
    }
}
