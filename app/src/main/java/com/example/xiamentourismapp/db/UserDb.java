package com.example.xiamentourismapp.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.xiamentourismapp.entity.User;

public class UserDb
{
    private static SQLiteDatabase db = ConnectionProvider.getDatabase(null);
    private static final String TABLE_NAME = "users";
    private static final String USERNAME = "username";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String PHONE_NO = "phoneNo";

    public static boolean insertUser(String username,String email,String phoneNo,String password)
    {
        ContentValues cv = new ContentValues();
        cv.put(USERNAME,username);
        cv.put(EMAIL,email);
        cv.put(PHONE_NO,phoneNo);
        cv.put(PASSWORD,password);

        long insert = db.insert(TABLE_NAME,null,cv);
        return insert > 0;
    }

    public static boolean updateUserProfile(String username, String email, String phoneNo, String newPassword)
    {
        ContentValues cv = new ContentValues();
        cv.put(EMAIL, email);
        cv.put(PHONE_NO, phoneNo);
        cv.put(PASSWORD, newPassword);

        long update = db.update(TABLE_NAME, cv, "username=?", new String[]{username})  ;
        return update > 0;
    }

    public static User getUserInfoByUsername(String uname)
    {
        Cursor c = db.rawQuery("select email, phoneNo, password from users where username=?", new String[]{uname});

        if (c.moveToFirst())
        {
            do
            {
                return new User(null,null,c.getString(0),c.getString(1),c.getString(2));
            }
            while(c.moveToNext());
        }

        return new User();
    }

    public static boolean verifyUser(String username, String password)
    {
        Cursor c = db.rawQuery("select password from users where username=?", new String[]{username});
        return (c.moveToNext() && password.equals(c.getString(0)));
    }

    public static boolean checkExistingUsername(String username)
    {
        Cursor c = db.rawQuery("select username from users where username = ?", new String[]{username});
        return (c.getCount() > 0);
    }

    public static boolean checkExistingEmail(String email)
    {
        Cursor c = db.rawQuery("select email from users where email = ?", new String[]{email});
        return (c.getCount() > 0);
    }
}
