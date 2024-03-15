package jarg.com.usersharedpreferences.models;

import androidx.annotation.NonNull;

public class User {
  private String email;
  private String password;

  public User(String email, String password) {
    this.email = email;
    this.password = password;
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

  @NonNull
  @Override
  public String toString() {
    return "User{" +
        "email='" + email + '\'' +
        ", password='" + password + '\'' +
        '}';
  }
}
