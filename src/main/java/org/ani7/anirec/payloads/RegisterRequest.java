package org.ani7.anirec.payloads;

import org.ani7.anirec.models.User;

import java.time.LocalDate;

public class RegisterRequest {

    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private User.Gender gender;
    private LocalDate dateOfBirth;
    private User.Role userType;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User.Gender getGender() {
        return gender;
    }

    public void setGender(User.Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public User.Role getUserType() {
        return userType;
    }

    public void setUserType(User.Role userType) {
        this.userType = userType;
    }
}
