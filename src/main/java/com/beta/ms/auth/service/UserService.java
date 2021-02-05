package com.beta.ms.auth.service;

import com.beta.ms.auth.dao.UserEntityDao;
import com.beta.ms.auth.entity.UserEntity;
import com.beta.ms.auth.ro.LoginRO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    @Autowired
    UserEntityDao userEntityDao;

    public boolean validateUsernameAndPassword(String username, String password) {

        try {

            UserEntity userEntity = userEntityDao.findByUsername(username);
            if (null != userEntity) {
                if (password.equals(userEntity.getPassword())) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw ex;
        }

    }

    public UserEntity getUserEntityByUserName(String username) {
        try {
            UserEntity userEntity = userEntityDao.findByUsername(username);
            return userEntity;
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw ex;
        }
    }

    public UserEntity createuser(LoginRO loginRO) {
        try {

            return  userEntityDao.save(UserEntity.builder()
                    .username(loginRO.getUsername())
                    .password(loginRO.getPassword())
                    .build());

        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw ex;
        }
    }
}
