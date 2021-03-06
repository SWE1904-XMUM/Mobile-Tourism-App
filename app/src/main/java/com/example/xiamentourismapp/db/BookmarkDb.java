package com.example.xiamentourismapp.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.xiamentourismapp.entity.Bookmark;

import java.util.ArrayList;
import java.util.List;

public class BookmarkDb
{
    private static SQLiteDatabase db = ConnectionProvider.getDatabase(null);
    private static final String TABLE_NAME = "bookmarks";
    private static final String USERNAME = "username";
    private static final String BOOKMARK_NAME = "bookmarkName";
    private static final String BOOKMARK_LINK = "bookmarkLink";
    private static final String BOOKMARK_PHONE = "bookmarkPhone";
    private static final String BOOKMARK_IMAGE = "bookmarkImage";

    public static boolean insertBookmark(String username, String bookmarkName, String bookmarkLink, String bookmarkPhone, Integer bookmarkImage)
    {
        ContentValues cv = new ContentValues();
        cv.put(USERNAME,username);
        cv.put(BOOKMARK_NAME,bookmarkName);
        cv.put(BOOKMARK_LINK,bookmarkLink);
        cv.put(BOOKMARK_PHONE,bookmarkPhone);
        cv.put(BOOKMARK_IMAGE,bookmarkImage);

        long insert = db.insert(TABLE_NAME,null,cv);
        return insert > 0;
    }

    public static List<Bookmark> getUserBookmarkByUsername(String uname)
    {
        List<Bookmark> bookmarkList = new ArrayList<>();

        Cursor c = db.rawQuery("select bookmarkId, bookmarkName, bookmarkLink, bookmarkPhone, bookmarkImage from bookmarks where username=?", new String[]{uname});

        if (c.moveToFirst())
        {
            do
            {
                bookmarkList.add(new Bookmark(c.getInt(0),uname,c.getString(1),c.getString(2),c.getString(3),c.getInt(4)));
            }
            while(c.moveToNext());
        }
        return bookmarkList;
    }

    public static List<Bookmark> getBookmarkByBookmarkId(String bookmarkId)
    {
        List<Bookmark> bookmarkList = new ArrayList<>();

        Cursor c = db.rawQuery("select bookmarkName, bookmarkLink, bookmarkPhone, bookmarkImage from bookmarks where bookmarkId=?", new String[]{bookmarkId});

        if (c.moveToFirst())
        {
            do
            {
                bookmarkList.add(new Bookmark(null,null,c.getString(0),c.getString(1),c.getString(2),c.getInt(3)));
            }
            while(c.moveToNext());
        }
        return bookmarkList;
    }

    public static boolean deleteBookmark(String bookmarkId)
    {
        long result = db.delete(TABLE_NAME, "bookmarkId=?", new String[]{String.valueOf(bookmarkId)});
        return result > 0;
    }
}
