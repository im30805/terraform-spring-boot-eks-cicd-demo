package com.example.demo.userservice.impl;

import com.example.demo.userservice.UserService;

import org.springframework.stereotype.Service;

import com.example.demo.ui.model.request.UserDetailsRequestModel;
import com.example.demo.ui.model.response.UserRest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import com.example.demo.shared.Utils;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements UserService {
    Map<String, UserRest> users;
    Utils utils;

    public UserServiceImpl () {
      
    }
    @Autowired
    public UserServiceImpl(Utils utils) {
      this.utils = utils;
    }
    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) { 
        UserRest returnValue = new UserRest();
        returnValue.setEmail(userDetails.getEmail());
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());

        String userId = utils.generateUserId();
        returnValue.setUserId(userId);

        if(users == null) {
          users = new HashMap<>();
        }
        users.put(userId, returnValue);
        return returnValue;
    }
}