package com.example.xiamentourismapp.manager;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.example.xiamentourismapp.R;

public class FragmentManager extends Fragment
{
    public FragmentManager()
    {

    }

    public static void beginNewFragment(AppCompatActivity appCompatActivity, Fragment fragment)
    {
        androidx.fragment.app.FragmentManager fm = appCompatActivity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentContainer,fragment).commit();
    }
}