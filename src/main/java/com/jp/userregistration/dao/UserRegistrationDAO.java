package com.jp.userregistration.dao;

import com.jp.couch.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRegistrationDAO extends CrudRepository<User,String> {
}
