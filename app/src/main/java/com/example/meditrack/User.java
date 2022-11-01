package com.example.meditrack;

public class User {

    public String fullName, email, password;

    public User(){

    }

    public User(String fullName, String email, String password){

        this.email = email;
        this.fullName = fullName;
        this.password = password;
    }
}
