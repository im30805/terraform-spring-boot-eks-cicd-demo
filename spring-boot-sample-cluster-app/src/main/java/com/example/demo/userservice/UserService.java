package com.example.demo.userservice;

import com.example.demo.ui.model.request.UserDetailsRequestModel;
import com.example.demo.ui.model.response.UserRest;

public interface UserService {
    UserRest createUser(UserDetailsRequestModel userDetails);
}