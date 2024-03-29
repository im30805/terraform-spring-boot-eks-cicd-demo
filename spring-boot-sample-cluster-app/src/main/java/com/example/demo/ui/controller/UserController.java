package com.example.demo.ui.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.ui.model.response.UserRest;
import com.example.demo.userservice.UserService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.example.demo.exceptions.UserServiceException;
import com.example.demo.ui.model.request.UpdateUserDetailsRequestModel;
import com.example.demo.ui.model.request.UserDetailsRequestModel;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

  Map<String, UserRest> users;
  @Autowired
  UserService userService;

  @GetMapping
  public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
      @RequestParam(value = "limit", defaultValue = "50") int limit) {
    String returnStr =  "Get users was called with page = " + page + " and limit = " + limit + "\n";
    // if(!users.isEmpty()) {
    //   for (UserRest i : users.values()) {
    //     returnStr += i; 
    //     returnStr += "\n";
    //   }
    // }
    return returnStr;
    
  }

  @GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
  public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
    // if(!users.containsKey(userId)) {
    //   throw new UserServiceException("A user service exception is thrown");
    // }
    // else if(users.containsKey(userId)){
    //   return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
    // }
    // else {
    //   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }
    return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
  }

  @PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
      MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
  public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
    UserRest returnValue = userService.createUser(userDetails);
    return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
  }

  @PostMapping(path = "/{userId}", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
    MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
  @PutMapping
  public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequestModel userDetails) {
    UserRest storedUserDetails = users.get(userId);
    storedUserDetails.setFirstName(userDetails.getFirstName());
    storedUserDetails.setLastName(userDetails.getLastName());
    users.put(userId, storedUserDetails);

    return storedUserDetails;
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable String id) {
    users.remove(id);
    return ResponseEntity.noContent().build();
  }
}