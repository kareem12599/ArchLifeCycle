package com.example.kareem.archlifecycle.Model;

/**
 * Created by USER on 11/10/2017.
 */

public class User {
    public String firstName;
    public String lastName;
    public String birthDay;
    public String gender;

    public User(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return firstName + '\'' ;
    }
}
