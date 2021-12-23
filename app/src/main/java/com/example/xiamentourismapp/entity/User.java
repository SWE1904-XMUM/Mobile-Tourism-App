package com.example.xiamentourismapp.entity;

import androidx.annotation.Nullable;

public class User
{
    public Integer userId;
    public String username;
    public String email;
    public String phoneNo;
    public String password;

    public User()
    {

    }

    public User(@Nullable Integer userId,@Nullable String username, String email, String phoneNo, String password)
    {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.phoneNo = phoneNo;
        this.password = password;
    }
}
