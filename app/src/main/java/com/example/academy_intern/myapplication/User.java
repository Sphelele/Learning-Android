package com.example.academy_intern.myapplication;

public class User {

    private String username;
    private String password;
    private String name;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  User(){

    }


    public  User(String name, String password, String username){

        this.name = name;
        this.password = password;
        this.username = username;
    }


}
