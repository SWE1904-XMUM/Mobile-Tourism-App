package com.example.xiamentourismapp.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class SharedPreferencesDb
{
    private static SQLiteDatabase db = ConnectionProvider.getDatabase(null);
    private static final String TABLE_NAME = "sharedPreferences";
    private static final String USERNAME = "username";
    private static final String SP_FILE = "spFile";

    public static String getSpByUsername(String username)
    {
        Cursor c = db.rawQuery("select spFile from " + TABLE_NAME + " where username=?", new String[]{username});
        return (c.moveToNext()) ? c.getString(0) : "";
    }

    public static boolean createNewSpFile(String username)
    {
        ContentValues cv = new ContentValues();
        cv.put(USERNAME, username);
        cv.put(SP_FILE, username);
        long result = db.insert(TABLE_NAME, null, cv);
        return result > 0;
    }
}
