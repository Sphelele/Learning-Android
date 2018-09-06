package com.example.academy_intern.myapplication;

import android.text.TextUtils;
import android.util.Patterns;
import java.util.ArrayList;

public class DataSources implements IUser {

    public static ArrayList<User>  listUser = new ArrayList<>();
    public static User globalUser = new User();

    public boolean addUser(User user){

        boolean flag = false;
        flag = listUser.add(user);
        return  (flag);
    }

    public ArrayList<User> getAllUsers(){
        return (listUser);
    }

    public boolean isLoggedIn(String username, String password){

        for(User user : listUser) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                globalUser = user;
                return true;
            }
        }
        return false;
    }

    public User searchUser(String username){

        User resultUser = null;
        for(User user : listUser) {

            if (user.getUsername().equals(username)) {
                resultUser = user;
            }

        }
        return resultUser;
    }

    public static boolean isValidEmail(String target) {

        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());

    }
}
