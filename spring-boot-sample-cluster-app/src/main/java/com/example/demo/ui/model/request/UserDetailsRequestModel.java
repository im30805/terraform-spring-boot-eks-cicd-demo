package com.example.demo.ui.model.request;
import jakarta.validation.constraints.*;

public class UserDetailsRequestModel {
  @NotNull(message="First name cannot be null")
  @Size(min=2, message="First name must not be less than 2 characters")
  private String firstName;
  @NotNull(message="Last name cannot be null")
  @Size(min=2, message="Last name must not be less than 2 characters")
  private String lastName;
  @NotNull(message="Email name cannot be null")
  @Email
  private String email;
  @NotNull(message="Password name cannot be null")
  @Size(min=8, max=16, message="Password must be > 8 characters or < 16 characters")
  private String password;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}