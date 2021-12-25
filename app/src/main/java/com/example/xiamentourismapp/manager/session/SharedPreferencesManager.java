package com.example.xiamentourismapp.manager.session;

import android.content.Context;
import com.example.xiamentourismapp.db.SharedPreferencesDb;
import com.example.xiamentourismapp.db.UserDb;
import java.util.List;

public class SharedPreferencesManager
{
    public static String spFile;

    public static boolean updateUser(String username)
    {
        spFile = SharedPreferencesDb.getSpByUsername(username);

        if(spFile == "")
        {
            boolean result = SharedPreferencesDb.createNewSpFile(username);

            if(result == false)
            {
                return false;
            }
            updateUser(username);
        }
        return true;
    }

    public static String getLoggedInUsername(Context context)
    {
        List<String> usernameList = UserDb.getAllUsername();

        if(usernameList == null)
        {
            return "";
        }

        for (String username : usernameList)
        {
            SessionManager.setSession(SharedPreferencesDb.getSpByUsername(username),context);

            if(SessionManager.getLogin() == true)
            {
                return SessionManager.getUsername();
            }
        }
        return "";
    }
}
