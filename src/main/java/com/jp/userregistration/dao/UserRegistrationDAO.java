package com.jp.userregistration.dao;

import com.jp.userregistration.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRegistrationDAO extends CrudRepository<User,String> {
}
