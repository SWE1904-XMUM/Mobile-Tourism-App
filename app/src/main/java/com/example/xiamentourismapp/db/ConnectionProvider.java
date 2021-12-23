package com.example.xiamentourismapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ConnectionProvider extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "xmumTourism.db";
    private static ConnectionProvider connection_instance;
    private static SQLiteDatabase database;

    private ConnectionProvider(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    public static ConnectionProvider getConnection(Context context)
    {
        if (connection_instance == null)
        {
            connection_instance = new ConnectionProvider(context.getApplicationContext(), DATABASE_NAME, null, 1);
        }
        return connection_instance;
    }

    public static SQLiteDatabase getDatabase(Context context)
    {
        if (database == null || !database.isOpen())
        {
            database = getConnection(context).getWritableDatabase();
        }
        return database;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        // create users table
        db.execSQL("create table users (userId integer primary key autoincrement, username text unique, email text unique, phoneNo text, password text)");

        // create userProfile table
        db.execSQL("create table userProfile (profileId integer primary key autoincrement, username text not null, profileImage longblob not null)");

        // create bookmarks table
        db.execSQL("create table bookmarks (bookmarkId integer primary key autoincrement, username text not null, bookmarkName text not null, bookmarkLink text not null, bookmarkPhone text not null,bookmarkImage integer not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        List<String> databases_name = new ArrayList<>();
        databases_name.add("users");
        databases_name.add("userProfile");
        databases_name.add("bookmarks");

        for (int index = 0; index < databases_name.size(); index++)
        {
            db.execSQL("drop table if exists " + databases_name.get(index));
        }

        onCreate(db);
    }
}
