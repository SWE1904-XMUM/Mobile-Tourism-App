package com.example.xiamentourismapp.manager.session;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager
{
    // Initialize variable
    public static SharedPreferences sp;
    public static SharedPreferences.Editor edt;

    static String LOGIN = "LOGIN";
    static String USERNAME = "UNAME";

    // Constructor
    public SessionManager()
    {

    }

    public static void setSession(String uname,Context context)
    {
        sp = context.getSharedPreferences(uname,context.MODE_PRIVATE);
        edt = sp.edit();
        edt.apply();
    }

    public static void setLogin(boolean login)
    {
        edt.putBoolean(LOGIN,login);
        edt.commit();
    }

    public static boolean getLogin()
    {
        return sp.getBoolean(LOGIN,false);
    }

    public static void setUsername(String uname)
    {
        edt.putString(USERNAME,uname);
        edt.commit();
    }

    public static String getUsername()
    {
        return sp.getString(USERNAME,"");
    }
}
