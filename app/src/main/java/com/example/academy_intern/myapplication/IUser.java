package com.example.academy_intern.myapplication;

import java.util.ArrayList;

public interface IUser {

     boolean addUser(User user);
     ArrayList<User> getAllUsers();
     boolean isLoggedIn(String username, String password);
}
