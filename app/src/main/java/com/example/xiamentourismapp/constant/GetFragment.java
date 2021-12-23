package com.example.xiamentourismapp.constant;

import androidx.fragment.app.Fragment;

import com.example.xiamentourismapp.fragment.Bookmarks;
import com.example.xiamentourismapp.fragment.EditProfile;
import com.example.xiamentourismapp.fragment.Explore;
import com.example.xiamentourismapp.fragment.Home;
import com.example.xiamentourismapp.fragment.Profile;
import com.example.xiamentourismapp.fragment.UploadProfile;

public class GetFragment
{
    public static Fragment home = new Home();
    public static Fragment explore = new Explore();
    public static Fragment bookmarks = new Bookmarks();
    public static Fragment profile = new Profile();
    public static Fragment editProfile = new EditProfile();
    public static Fragment uploadProfile = new UploadProfile();

    public GetFragment()
    {

    }

    public static Fragment getHomeFragment()
    {
        return home;
    }

    public static Fragment getExploreFragment()
    {
        return explore;
    }

    public static Fragment getBookmarksFragment()
    {
        return bookmarks;
    }

    public static Fragment getProfileFragment()
    {
        return profile;
    }

    public static Fragment getEditProfileFragment()
    {
        return editProfile;
    }

    public static Fragment getUploadProfileFragment()
    {
        return uploadProfile;
    }
}
