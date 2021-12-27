package com.example.xiamentourismapp.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class NotesDb
{
    private static SQLiteDatabase db = ConnectionProvider.getDatabase(null);
    private static final String TABLE_NAME = "notes";
    private static final String BOOKMARK_ID = "bookmarkId";
    private static final String USERNAME = "username";
    private static final String NOTE = "note";

    public static boolean insertNote(Integer bookmarkId,String uname,String note)
    {
        ContentValues cv = new ContentValues();
        cv.put(BOOKMARK_ID,bookmarkId);
        cv.put(USERNAME,uname);
        cv.put(NOTE,note);

        long insert = db.insert(TABLE_NAME,null,cv);
        return insert > 0;
    }

    public static boolean updateNotes(Integer noteId,String note)
    {
        ContentValues cv = new ContentValues();
        cv.put(NOTE, note);

        long update = db.update(TABLE_NAME, cv, "noteId=?", new String[]{noteId.toString()})  ;
        return update > 0;
    }

    public static boolean deleteNotes(Integer noteId)
    {
        long result = db.delete(TABLE_NAME, "noteId=?", new String[]{String.valueOf(noteId)});
        return result > 0;
    }

    public static String getNotesByNoteId(Integer noteId)
    {
        Cursor c = db.rawQuery("select note from notes where noteId=?", new String[]{noteId.toString()});

        if (c.moveToFirst())
        {
            do
            {
                return c.getString(0);
            }
            while(c.moveToNext());
        }
        return null;
    }
}
