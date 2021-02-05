package com.beta.ms.auth.controller;

import com.beta.ms.auth.bridge.TokenBridge;
import com.beta.ms.auth.entity.UserEntity;
import com.beta.ms.auth.exception.*;
import com.beta.ms.auth.model.Token;
import com.beta.ms.auth.ro.LoginRO;
import com.beta.ms.auth.ro.TokenRO;
import com.beta.ms.auth.service.TokenService;
import com.beta.ms.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    @Autowired
    TokenBridge tokenBridge;

    @PostMapping("/token")
    public ResponseEntity<TokenRO> generateToken(@Validated @RequestBody LoginRO loginRO) throws Exception {
        UserEntity userEntity = userService.getUserEntityByUserName(loginRO.getUsername());
        if (userEntity != null) {
            if (userEntity.getPassword().equals(loginRO.getPassword())) {
                Token token = tokenService.createNewToken(userEntity);
                TokenRO tokenRO = tokenBridge.convertTokenToTokenRO(token);
                return new ResponseEntity<>(tokenRO, HttpStatus.OK);
            } else {
                throw new InvalidPasswordException();
            }
        } else {
            throw new InvalidUserNameException();
        }
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@Validated @RequestBody LoginRO loginRO) throws Exception {
        UserEntity userEntity = userService.getUserEntityByUserName(loginRO.getUsername());

        if (userEntity != null) {
           throw new UserExistException();
        } else {
            UserEntity savedEntity = userService.createuser(loginRO);
            if (savedEntity != null && savedEntity.getId() != null) {
                return new ResponseEntity("", HttpStatus.OK);
            } else {
                throw new UserRegisterException();
            }
        }
    }
}
