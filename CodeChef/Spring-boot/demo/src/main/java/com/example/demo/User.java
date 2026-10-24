package com.example.demo;

public class User {

    private final String mName;
    private final String mEmail;

    User(String name, String email){
        mName = name;
        mEmail = email;
    }

    public String getName() {
        return mName;
    }

    public String getEmail() {
        return mEmail;
    }
}
