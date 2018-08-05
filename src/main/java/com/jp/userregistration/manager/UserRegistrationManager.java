package com.jp.userregistration.manager;

import com.jp.model.user.Address;
import com.jp.model.user.User;
import com.jp.userregistration.dao.CustomerMapper;
import com.jp.userregistration.util.UserRegistrationUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class UserRegistrationManager {

    private CustomerMapper customerMapper;

    public User createCustomerInRdbms(final User user) {
        String userId = UserRegistrationUtil.getUid();
        user.setUserId(userId);
        String salt = UserRegistrationUtil.getUserSalt();
        String password = user.getPassword();
        user.setSalt(salt);
        user.setStatus("active");
        user.setPassword(UserRegistrationUtil.getSecurePassword(password,salt));
        customerMapper.createCustomer(user);
        String billingAddressId = UserRegistrationUtil.getUid();
        Address billingAddress = user.getBillingAddress();
        billingAddress.setAddressId(billingAddressId);
        billingAddress.setCustId(userId);
        customerMapper.createBilling(billingAddress);
        Address shippingAddress;
        String shippingAddressId = UserRegistrationUtil.getUid();
        if(user.isShippingSameAsBilling()) {
            shippingAddress = billingAddress;
        } else {
            shippingAddress = user.getShippingAddress();
        }
        shippingAddress.setAddressId(shippingAddressId);
        shippingAddress.setCustId(userId);
        customerMapper.createShipping(shippingAddress);
        return user;
    }

    public User authenticateUser(final User user) {
        String reqPassword = user.getPassword();
        User userInDb = customerMapper.getUser(user);
        String hashRequestPassword = UserRegistrationUtil.getSecurePassword(reqPassword,userInDb.getSalt());
        log.info("hasheed password is  {}",hashRequestPassword);
        log.info("hash in db password is  {}",userInDb.getPassword());
        if(hashRequestPassword.equals(userInDb.getPassword())) {
            log.info("-----------------passwords are same====================");
            return userInDb;
        }
        return null;
    }
}
