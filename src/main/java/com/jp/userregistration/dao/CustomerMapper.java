package com.jp.userregistration.dao;

import com.jp.model.user.Address;
import com.jp.model.user.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {
    public void createCustomer(final User user);
    public void createBilling(final Address billing);
    public void createShipping(final Address shipping);
    public User getUser(final User user);
}
