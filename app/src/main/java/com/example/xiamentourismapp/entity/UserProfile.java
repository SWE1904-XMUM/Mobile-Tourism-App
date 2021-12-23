package com.example.xiamentourismapp.entity;

import androidx.annotation.Nullable;

import java.util.Arrays;

public class UserProfile
{
    public Integer profileId;
    public String username;
    public byte[] profileImage;

    public UserProfile()
    {

    }

    public UserProfile(@Nullable Integer profileId, String username, byte[] profileImage)
    {
        this.profileId = profileId;
        this.username = username;
        this.profileImage = profileImage;
    }
}
